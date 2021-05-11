package son.ysy.useful.dependencies


import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.squareup.kotlinpoet.*
import com.squareup.moshi.Moshi
import junit.framework.TestCase
import org.junit.Test
import son.ysy.useful.dependencies.model.DependencyConfig
import son.ysy.useful.dependencies.model.DependencyContainer
import java.io.File

class AndroidDependencyTest : TestCase() {

    private object DependencyValues {
        val packageList = listOf("son", "ysy", "useful", "dependencies")
    }

    private object DependencyProperties {
        const val KEY_ACTION = "action"
        const val KEY_GROUP = "group"
        const val KEY_NAME = "name"
        const val KEY_VERSION = "version"
        const val KEY_MODULES = "modules"
        const val KEY_FULL_GRADLE = "fullGradle"
    }

    private object DependencyFunctions {
        const val KEY_BUILD = "build"
        const val KEY_CUSTOM_VERSION = "customVersion"
    }

    private object DependencyClasses {
        const val KEY_CLASS_DEPENDENCY = "AndroidDependency"
        const val KEY_CLASS_SINGLE = "Single"
        const val KEY_CLASS_VIEW = "View"
        const val KEY_CLASS_GROUP = "Group"
        const val KEY_CLASS_TEST = "Test"
    }

    private val jsonAdapter = Moshi.Builder().build().adapter(DependencyContainer::class.java)

    /**
     * 从Resource文件夹读取json文件
     */
    private fun getJsonFromResource(): String {
        return Thread.currentThread()
            .contextClassLoader
            .getResourceAsStream("dependencies.json")
            ?.reader()
            ?.readText()
            ?: throw Error("读取json失败")
    }

    private fun getBeanFromJson(): DependencyContainer? {
        val json = getJsonFromResource()

        return jsonAdapter.fromJson(json)
    }

    /**
     * json文件排序
     */
    @Test
    fun testSortedJson() {
        val json = getBeanFromJson()?.sorted()
            .run(jsonAdapter::toJson)

        val formatJson = GsonBuilder().setPrettyPrinting().create().toJson(
            JsonParser.parseString(json)
        )

        File(File("src/test/resources/dependencies.json").absolutePath).writeText(formatJson)
    }

    @Test
    fun testCreateAll() {
        testSortedJson()

        createDependencyKt()

        createMd()
    }

    private fun createDependencyKt() {
        val container = getBeanFromJson() ?: return

        //声明AndroidDependency类
        val androidDependencyClassBuilder = TypeSpec
            .classBuilder(DependencyClasses.KEY_CLASS_DEPENDENCY)

        androidDependencyClassBuilder.addAnnotation(
            AnnotationSpec.builder(Suppress::class)
                .addMember("%S,%S", "MemberVisibilityCanBePrivate", "unused")
                .build()
        )

        //声明AndroidDependency为抽象类
        androidDependencyClassBuilder.addModifiers(KModifier.ABSTRACT)

        //声明AndroidDependency构造函数
        androidDependencyClassBuilder.primaryConstructor(
            FunSpec.constructorBuilder()
                .addParameter(DependencyProperties.KEY_GROUP, String::class)
                .addParameter(DependencyProperties.KEY_NAME, String::class)
                .addParameter(DependencyProperties.KEY_VERSION, String::class)
                .addModifiers(KModifier.PRIVATE)
                .build(),
        )

        //声明AndroidDependency group属性
        androidDependencyClassBuilder.addProperty(
            PropertySpec.builder(DependencyProperties.KEY_GROUP, String::class)
                .initializer(DependencyProperties.KEY_GROUP)
                .build()
        )
        //声明AndroidDependency module属性
        androidDependencyClassBuilder.addProperty(
            PropertySpec.builder(DependencyProperties.KEY_NAME, String::class)
                .initializer(DependencyProperties.KEY_NAME)
                .build()
        )
        //声明AndroidDependency version属性
        androidDependencyClassBuilder.addProperty(
            PropertySpec.builder(DependencyProperties.KEY_VERSION, String::class)
                .initializer(DependencyProperties.KEY_VERSION)
                .build()
        )
        //声明AndroidDependency build私有方法
        androidDependencyClassBuilder.addFunction(
            FunSpec.builder(DependencyFunctions.KEY_BUILD)
                .addParameter(DependencyProperties.KEY_VERSION, String::class)
                .addModifiers(KModifier.PRIVATE)
                .addStatement(
                    """return "$${DependencyProperties.KEY_GROUP}:$${DependencyProperties.KEY_NAME}:$${DependencyProperties.KEY_VERSION}""""
                )
                .build()
        )
        //声明AndroidDependency fullGradle计算属性
        androidDependencyClassBuilder.addProperty(
            PropertySpec.builder(DependencyProperties.KEY_FULL_GRADLE, String::class)
                .getter(
                    FunSpec.getterBuilder()
                        .addCode("return build(${DependencyProperties.KEY_VERSION})")
                        .build()
                )
                .build()
        )

        //声明AndroidDependency customVersion公共方法
        androidDependencyClassBuilder.addFunction(
            FunSpec.builder(DependencyFunctions.KEY_CUSTOM_VERSION)
                .addParameter(DependencyProperties.KEY_VERSION, String::class)
                .addCode(
                    "return ${DependencyFunctions.KEY_BUILD}(${DependencyProperties.KEY_VERSION})"
                ).returns(String::class)
                .build()
        )


        buildSingleClassSpec(DependencyClasses.KEY_CLASS_SINGLE, container.single)
            .apply(androidDependencyClassBuilder::addType)

        buildSingleClassSpec(DependencyClasses.KEY_CLASS_VIEW, container.view)
            .apply(androidDependencyClassBuilder::addType)

        buildGroupClassSpec(DependencyClasses.KEY_CLASS_GROUP, container.group)
            .apply(androidDependencyClassBuilder::addType)

        buildSingleClassSpec(DependencyClasses.KEY_CLASS_TEST, container.test)
            .apply(androidDependencyClassBuilder::addType)

        val fileSpec = FileSpec.builder(
            DependencyValues.packageList.joinToString("."),
            DependencyClasses.KEY_CLASS_DEPENDENCY
        ).addType(androidDependencyClassBuilder.build())
            .build()

        val rootPathList = listOf("src", "main", "kotlin")

        fileSpec.writeTo(File(rootPathList.joinToString(File.separator)))
    }

    private fun getKDoc(remark: String?, link: String?) = listOf(remark, link)
        .mapNotNull { it }
        .joinToString("\n")
        .ifBlank { null }

    private class IllegalArgumentMissException(
        config: DependencyConfig,
        name: String
    ) : IllegalArgumentException("${name}字段不能为缺失,$config")

    private fun buildSingleClassSpec(className: String, list: List<DependencyConfig>): TypeSpec {
        //声明类
        val singleClassBuilder = TypeSpec.objectBuilder(className)

        list.map { single ->

            val objectBuilder = TypeSpec.objectBuilder(single.title)
                .superclass(ClassName("", DependencyClasses.KEY_CLASS_DEPENDENCY))
                .addSuperclassConstructorParameter(
                    "%S",
                    single.group ?: throw IllegalArgumentMissException(
                        single,
                        DependencyProperties.KEY_GROUP
                    )
                )
                .addSuperclassConstructorParameter(
                    "%S",
                    single.name ?: throw IllegalArgumentMissException(
                        single,
                        DependencyProperties.KEY_NAME
                    )
                )
                .addSuperclassConstructorParameter(
                    "%S",
                    single.version ?: throw IllegalArgumentMissException(
                        single,
                        DependencyProperties.KEY_VERSION
                    )
                )

            getKDoc(single.remark, single.link)
                ?.apply(objectBuilder::addKdoc)
            objectBuilder.build()
        }.forEach {
            singleClassBuilder.addType(it)
        }
        return singleClassBuilder.build()
    }

    private fun buildGroupClassSpec(className: String, list: List<DependencyConfig>): TypeSpec {
        //声明类
        val groupClassBuilder = TypeSpec.objectBuilder(className)

        list.forEach { container ->

            val modules = container.modules ?: throw IllegalArgumentMissException(
                container,
                DependencyProperties.KEY_MODULES
            )

            val hasCustomVersion = modules.any { it.version != null }

            val hasCustomGroup = modules.any { it.group != null }

            val groupBuilder = TypeSpec.classBuilder(container.title)
                .addModifiers(KModifier.SEALED)

            val constructorBuilder = FunSpec.constructorBuilder()

            if (hasCustomGroup) {
                constructorBuilder.addParameter(DependencyProperties.KEY_GROUP, String::class)
            }

            constructorBuilder.addParameter(DependencyProperties.KEY_NAME, String::class)

            if (hasCustomVersion) {
                constructorBuilder.addParameter(DependencyProperties.KEY_VERSION, String::class)
            }

            groupBuilder.primaryConstructor(constructorBuilder.build())
                .superclass(ClassName("", DependencyClasses.KEY_CLASS_DEPENDENCY))

            if (hasCustomGroup) {
                groupBuilder.addSuperclassConstructorParameter(DependencyProperties.KEY_GROUP)
            } else {
                groupBuilder.addSuperclassConstructorParameter(
                    "%S",
                    container.group ?: throw IllegalArgumentMissException(
                        container,
                        DependencyProperties.KEY_GROUP
                    )
                )
            }

            groupBuilder.addSuperclassConstructorParameter(DependencyProperties.KEY_NAME)

            if (hasCustomVersion) {
                groupBuilder.addSuperclassConstructorParameter(DependencyProperties.KEY_VERSION)
            } else {
                groupBuilder.addSuperclassConstructorParameter(
                    "%S",
                    container.version ?: throw IllegalArgumentMissException(
                        container,
                        DependencyProperties.KEY_VERSION
                    )
                )
            }

            container.modules.forEach { module ->
                val moduleBuilder = TypeSpec.objectBuilder(module.title)
                moduleBuilder.superclass(
                    ClassName(
                        "",
                        container.title
                    )
                )

                if (hasCustomGroup) {
                    moduleBuilder.addSuperclassConstructorParameter(
                        "%S",
                        module.group ?: container.group ?: throw IllegalArgumentMissException(
                            container,
                            DependencyProperties.KEY_GROUP
                        )
                    )
                }
                moduleBuilder.addSuperclassConstructorParameter(
                    "%S",
                    module.name ?: throw IllegalArgumentMissException(
                        container,
                        DependencyProperties.KEY_NAME
                    )
                )
                if (hasCustomVersion) {
                    moduleBuilder.addSuperclassConstructorParameter(
                        "%S",
                        module.version ?: container.version ?: throw IllegalArgumentMissException(
                            container,
                            DependencyProperties.KEY_VERSION
                        )
                    )
                }


                getKDoc(module.remark, module.link)
                    ?.apply(moduleBuilder::addKdoc)

                groupBuilder.addType(moduleBuilder.build())
            }

            getKDoc(container.remark, container.link)
                ?.apply(groupBuilder::addKdoc)

            groupClassBuilder.addType(groupBuilder.build())


        }

        return groupClassBuilder.build()
    }


    private fun createMd() {
        val list = mutableListOf<String>()

        list.add("# 三方依赖库版本管理[![](https://jitpack.io/v/qiushui95/AndroidDependencies.svg)](https://jitpack.io/#qiushui95/AndroidDependencies)  ")

        val container = getBeanFromJson() ?: throw IllegalArgumentException()

        list.createMdNextLine()
        list.createMdNextLine()

        list.createMdTitle()

        container.single.forEach {
            list.createMdSingle(null,it)
        }

        list.createMdNextLine()
        list.createMdNextLine()

        list.createMdTitle()
        container.view.forEach {
            list.createMdSingle(null,it)
        }

        list.createMdNextLine()
        list.createMdNextLine()

        list.createMdTitle()
        container.test.forEach {
            list.createMdSingle(null,it)
        }

        container.group.forEach { group ->
            list.createMdNextLine()
            list.createMdNextLine()

            list.createMdGroupTitle(group)

            group.modules?.forEach {
                list.createMdSingle(group,it)
            }
        }


        File(File(".."), "ReadMe.md").writeText(list.joinToString("\n"))
    }

    private fun MutableList<String>.createMdNextLine() {
        add("  ")
    }

    private fun MutableList<String>.createMdTitle() {
        add("|title|group|name|version|remark|gradle dsl|  ")
        add("|:-:|:-:|:-:|:-:|:-:|:-:|  ")
    }

    private fun MutableList<String>.createMdGroupTitle(config: DependencyConfig) {
        val remark = config.remark ?: ""
        if (config.link == null) {
            add("|${config.title}| | | |$remark||  ")
        } else {
            add("|[${config.title}](${config.link})| | | |$remark||  ")
        }
        add("|:-:|:-:|:-:|:-:|:-:|:-:|  ")
        add("|title|group|name|version|remark|gradle dsl|  ")
    }

    private fun MutableList<String>.createMdSingle(groupConfig: DependencyConfig?,config: DependencyConfig) {
        val title = config.title

        val group = config.group?:groupConfig?.group ?: throw IllegalArgumentMissException(
            config,
            DependencyProperties.KEY_GROUP
        )

        val name = config.name ?: throw IllegalArgumentMissException(
            config,
            DependencyProperties.KEY_NAME
        )

        val version = config.version ?:groupConfig?.version?: throw IllegalArgumentMissException(
            config,
            DependencyProperties.KEY_VERSION
        )

        val remark = config.remark ?: ""

        val action = config.action ?: throw IllegalArgumentMissException(
            config,
            DependencyProperties.KEY_ACTION
        )

        val link = config.link

        val gradleDsl = """$action("$group:$name:$version")"""

        if (link == null) {
            add("|$title|$group|$name|$version|$remark|$gradleDsl|  ")
        } else {
            add("|[$title]($link)|$group|$name|$version|$remark|$gradleDsl|  ")
        }
    }
//
//        dependencyModel.group
//            .map { group ->
//                val hasCustomGroup = group.modules.any {
//                    it.group.isNullOrBlank()
//                }
//
//                val hasCustomVersion = group.modules.any {
//                    it.version?.isNotBlank() == true
//                }
//
//                val groupBuilder = TypeSpec.classBuilder(group.name)
//                    .addModifiers(KModifier.SEALED)
//                    .primaryConstructor(
//                        FunSpec.constructorBuilder()
//                            .addParameter(DependencyProperties.KEY_MODULE, String::class)
//                            .apply {
//                                if (hasCustomVersion) {
//                                    addParameter(DependencyProperties.KEY_VERSION, String::class)
//                                }
//                            }
//                            .build()
//                    ).superclass(ClassName("", DependencyClasses.KEY_CLASS_DEPENDENCY))
//                    .addSuperclassConstructorParameter("%S", group.group)
//                    .addSuperclassConstructorParameter(DependencyProperties.KEY_MODULE)
//                    .apply {
//                        if (hasCustomVersion) {
//                            addSuperclassConstructorParameter(DependencyProperties.KEY_VERSION)
//                        } else {
//                            addSuperclassConstructorParameter("%S", group.version)
//                        }
//                    }
//
//                getKDoc(group.remark, group.link)?.apply(groupBuilder::addKdoc)
//
//                group.modules
//                    .map { child ->
//                        val childBuilder = TypeSpec.objectBuilder(child.name)
//                        when {
//                            child.isCustomGroup -> {
//                                childBuilder.superclass(
//                                    ClassName(
//                                        "",
//                                        DependencyClasses.KEY_CLASS_DEPENDENCY
//                                    )
//                                ).addSuperclassConstructorParameter("%S", child.group!!)
//                                    .addSuperclassConstructorParameter("%S", child.module)
//                                    .addSuperclassConstructorParameter(
//                                        "%S",
//                                        child.version ?: group.version
//                                    )
//                            }
//                            hasCustomVersion -> {
//                                childBuilder.superclass(ClassName("", group.name))
//                                    .addSuperclassConstructorParameter("%S", child.module)
//                                    .addSuperclassConstructorParameter(
//                                        "%S",
//                                        child.version ?: group.version
//                                    )
//                            }
//                            else -> {
//                                childBuilder.superclass(ClassName("", group.name))
//                                    .addSuperclassConstructorParameter("%S", child.module)
//                            }
//                        }
//
//
//                        getKDoc(child.remark, child.link)?.apply(childBuilder::addKdoc)
//                        childBuilder.build()
//                    }.forEach {
//                        groupBuilder.addType(it)
//                    }
//                groupBuilder.build()
//            }.forEach {
//                androidDependencyClassBuilder.addType(it)
//            }
//

//
//        val fileSpec = FileSpec.builder(
//            DependencyValues.packageList.joinToString("."),
//            DependencyClasses.KEY_CLASS_DEPENDENCY
//        ).addType(androidDependencyClassBuilder.build())
//            .build()
//
//        val rootPathList = listOf("src", "main", "kotlin")
//
////        fileSpec.writeTo(System.out)
//        fileSpec.writeTo(File(rootPathList.joinToString(File.separator)))
//    }

//
//    private fun buildSingleClassSpec(className: String, list: List<SingleDependency>): TypeSpec {
//        //声明类
//        val singleClassBuilder = TypeSpec.objectBuilder(className)
//
//        list.map { single ->
//            val objectBuilder = TypeSpec.objectBuilder(single.name)
//                .superclass(ClassName("", DependencyClasses.KEY_CLASS_DEPENDENCY))
//                .addSuperclassConstructorParameter("%S", single.group)
//                .addSuperclassConstructorParameter("%S", single.module)
//                .addSuperclassConstructorParameter("%S", single.version)
//
//            getKDoc(single.remark, single.link)
//                ?.apply(objectBuilder::addKdoc)
//            objectBuilder.build()
//        }.forEach {
//            singleClassBuilder.addType(it)
//        }
//        return singleClassBuilder.build()
//    }
//
//    @Test
//    fun testCreateDependencyMd() {
//        val dependencyModel = getDependencyModel()
//
//        val sb = StringBuilder()
//
//        sb.appendMdLine("# 三方依赖库版本管理[![](https://jitpack.io/v/qiushui95/AndroidDependencies.svg)](https://jitpack.io/#qiushui95/AndroidDependencies)")
//
//        createSingleMd(dependencyModel.single, sb)
//        sb.append("\n")
//        createSingleMd(dependencyModel.view, sb)
//        dependencyModel.group.forEach { group ->
//            sb.append("\n")
//            val groupName = group.name.takeIf {
//                group.link.isNullOrBlank()
//            } ?: "[${group.name}](${group.link})"
//
//            sb.appendMdLine("|$groupName|${group.group}|${group.remark ?: ""}|")
//            sb.appendMdLine("|:-:|:-:|:-:|")
//
//            group.modules.forEach { child ->
//                val childName = child.name.takeIf { child.link.isNullOrBlank() }
//                    ?: "[${child.name}](${child.link})"
//
//                val childModule = when {
//                    child.isCustomGroup -> "${child.group}:${child.module}:${child.version}"
//                    else -> child.module
//                }
//                val childVersion = when {
//                    child.isCustomGroup -> child.remark
//                    child.isCustomVersion -> child.version
//                    else -> group.version
//                }
//                sb.appendMdLine("|$childName|$childModule|$childVersion|")
//            }
//        }
//        sb.append("\n")
//        createSingleMd(dependencyModel.test, sb)
//        File(File(".."), "ReadMe.md").writeText(sb.toString())
//    }
//
//    private fun StringBuilder.appendMdLine(line: String) {
//        append(line)
//        append("  \n")
//    }
//
//    private fun createSingleMd(list: List<SingleDependency>, sb: StringBuilder) {
//        sb.appendMdLine("|name|group|module|version|remark|")
//        sb.appendMdLine("|:-:|:-:|:-:|:-:|:-:|")
//        list.forEach { single ->
//            val name = single.name.takeIf {
//                single.link.isNullOrBlank()
//            } ?: "[${single.name}](${single.link})"
//            val singleLine =
//                listOf(
//                    name,
//                    single.group,
//                    single.module,
//                    single.version,
//                    single.remark ?: ""
//                ).joinToString(separator = "|", postfix = "|", prefix = "|")
//            sb.appendMdLine(
//                singleLine,
//            )
//        }
//    }
}