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

        createCheckModuleGradle()
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

        container.group.forEach { group ->
            buildGroupClassSpec(group)
                .apply(androidDependencyClassBuilder::addType)
        }

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

    private fun buildGroupClassSpec(config: DependencyConfig): TypeSpec {

        val groupBuilder = TypeSpec.classBuilder(config.title)
            .addModifiers(KModifier.SEALED)

        val modules = config.modules ?: throw IllegalArgumentMissException(
            config,
            DependencyProperties.KEY_MODULES
        )

        val hasCustomVersion = modules.any { it.version != null }

        val hasCustomGroup = modules.any { it.group != null }


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
                config.group ?: throw IllegalArgumentMissException(
                    config,
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
                config.version ?: throw IllegalArgumentMissException(
                    config,
                    DependencyProperties.KEY_VERSION
                )
            )
        }

        config.modules.forEach { module ->
            val moduleBuilder = TypeSpec.objectBuilder(module.title)
            moduleBuilder.superclass(
                ClassName(
                    "",
                    config.title
                )
            )

            if (hasCustomGroup) {
                moduleBuilder.addSuperclassConstructorParameter(
                    "%S",
                    module.group ?: config.group ?: throw IllegalArgumentMissException(
                        config,
                        DependencyProperties.KEY_GROUP
                    )
                )
            }
            moduleBuilder.addSuperclassConstructorParameter(
                "%S",
                module.name ?: throw IllegalArgumentMissException(
                    config,
                    DependencyProperties.KEY_NAME
                )
            )
            if (hasCustomVersion) {
                moduleBuilder.addSuperclassConstructorParameter(
                    "%S",
                    module.version ?: config.version ?: throw IllegalArgumentMissException(
                        config,
                        DependencyProperties.KEY_VERSION
                    )
                )
            }

            getKDoc(module.remark, module.link)
                ?.apply(moduleBuilder::addKdoc)

            groupBuilder.addType(moduleBuilder.build())

        }

        getKDoc(config.remark, config.link)
            ?.apply(groupBuilder::addKdoc)

        return groupBuilder.build()
    }


    private fun createMd() {
        val list = mutableListOf<String>()

        list.add("# 三方依赖库版本管理[![](https://jitpack.io/v/qiushui95/AndroidDependencies.svg)](https://jitpack.io/#qiushui95/AndroidDependencies)  ")

        val container = getBeanFromJson() ?: throw IllegalArgumentException()

        list.createMdNextLine()
        list.createMdNextLine()

        list.createMdTitle()

        container.single.forEach {
            list.createMdSingle(null, it)
        }

        list.createMdNextLine()
        list.createMdNextLine()

        list.createMdTitle()
        container.view.forEach {
            list.createMdSingle(null, it)
        }

        list.createMdNextLine()
        list.createMdNextLine()

        list.createMdTitle()
        container.test.forEach {
            list.createMdSingle(null, it)
        }

        container.group.forEach { group ->
            list.createMdNextLine()
            list.createMdNextLine()

            list.createMdGroupTitle(group)

            group.modules?.forEach {
                list.createMdSingle(group, it)
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
            add("|${config.title}| | | ||$remark|  ")
        } else {
            add("|[${config.title}](${config.link})| | | |::|$remark|  ")
        }
        add("|:-:|:-:|:-:|:-:|:-:|:-:|  ")
        add("|title|group|name|version|remark|gradle dsl|  ")
    }

    private fun MutableList<String>.createMdSingle(
        groupConfig: DependencyConfig?,
        config: DependencyConfig
    ) {
        val title = config.title

        val group = config.group ?: groupConfig?.group ?: throw IllegalArgumentMissException(
            config,
            DependencyProperties.KEY_GROUP
        )

        val name = config.name ?: throw IllegalArgumentMissException(
            config,
            DependencyProperties.KEY_NAME
        )

        val version = config.version ?: groupConfig?.version ?: throw IllegalArgumentMissException(
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

    private fun createCheckModuleGradle() {
        val newestList = mutableListOf<String>()
        val defineList = mutableListOf<String>()

        val container = getBeanFromJson() ?: throw IllegalArgumentException()

        container.single
            .forEach {
                newestList.createGradle(null, it, true)
                defineList.createGradle(null, it, false)
            }

        container.view
            .forEach {
                newestList.createGradle(null, it, true)
                defineList.createGradle(null, it, false)
            }

        container.test
            .forEach {
                newestList.createGradle(null, it, true)
                defineList.createGradle(null, it, false)
            }

        container.group
            .forEach { group ->
                group.modules?.forEach { module ->
                    newestList.createGradle(group, module, true)
                    defineList.createGradle(group, module, false)
                }
                newestList.add("\n")
                defineList.add("\n")
            }

        val parentDir = File(File("").absolutePath).parentFile

        val newestDir = File(parentDir, "newest")

        newestList.writeTo(newestDir)

        val defineDir = File(parentDir, "define")

        defineList.writeTo(defineDir)
    }

    private fun MutableList<String>.createGradle(
        groupConfig: DependencyConfig?,
        config: DependencyConfig,
        isNewest: Boolean
    ) {
        val group = config.group ?: groupConfig?.group ?: throw IllegalArgumentMissException(
            config,
            DependencyProperties.KEY_GROUP
        )

        val name = config.name ?: throw IllegalArgumentMissException(
            config,
            DependencyProperties.KEY_NAME
        )

        val version = if (isNewest) {
            "+"
        } else {
            config.version ?: groupConfig?.version ?: throw IllegalArgumentMissException(
                config,
                DependencyProperties.KEY_VERSION
            )
        }

        val action = config.action ?: throw IllegalArgumentMissException(
            config,
            DependencyProperties.KEY_ACTION
        )

        add("""$action("$group:$name:$version")""")
    }

    private fun MutableList<String>.writeTo(dir: File) {
        val gradleHolderFile = File(dir, "build.gradle.kts.placeholder")
        val gradleFile = File(dir, "build.gradle.kts")

        if (!gradleFile.exists()) {
            gradleFile.createNewFile()
        }

        gradleFile.writeText(
            gradleHolderFile.readText().replace("\$PlaceHolder\$", joinToString("\n") {
                "\t$it"
            })
        )
    }
}