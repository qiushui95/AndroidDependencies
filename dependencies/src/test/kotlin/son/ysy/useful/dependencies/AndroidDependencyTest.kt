package son.ysy.useful.dependencies


import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.squareup.kotlinpoet.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import junit.framework.TestCase
import org.junit.Test
import son.ysy.useful.dependencies.model.DependencyConfig
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
        const val KEY_CLASS_COMPOSE = "Compose"
        const val KEY_CLASS_GROUP = "Group"
        const val KEY_CLASS_TEST = "Test"
    }

    private val jsonAdapter = Moshi.Builder().build().adapter<List<DependencyConfig>>(
        Types.newParameterizedType(
            List::class.java,
            DependencyConfig::class.java
        )
    )

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

    private fun getBeanFromJson(): List<DependencyConfig>? {
        val json = getJsonFromResource()

        return jsonAdapter.fromJson(json)
            ?.sort()
    }

    private fun List<DependencyConfig>.filterIgnore(): List<DependencyConfig> {
        return map { config ->
            config.copy(modules = config.modules?.filterIgnore())
        }.filterNot {
            it.realIgnore
        }
    }

    private fun List<DependencyConfig>.sort(): List<DependencyConfig> {
        return map { config ->
            config.copy(modules = config.modules?.sort())
        }.sorted()
    }

    /**
     * json文件排序
     */
    @Test
    fun testSortedJson() {
        val json = getBeanFromJson()
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
        val configs = getBeanFromJson()?.filterIgnore() ?: return

        //声明AndroidDependency类
        val androidDependencyClassBuilder = TypeSpec
            .classBuilder(DependencyClasses.KEY_CLASS_DEPENDENCY)

        androidDependencyClassBuilder.addAnnotation(
            AnnotationSpec.builder(Suppress::class)
                .addMember(
                    "%S,%S,%S",
                    "MemberVisibilityCanBePrivate",
                    "unused",
                    "RedundantVisibilityModifier"
                )
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
                .addModifiers(KModifier.PUBLIC)
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

        configs.forEach { config ->
            androidDependencyClassBuilder.buildGroupClassSpec(emptyList(), config)
        }

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

    private class MissPropertyException(
        config: DependencyConfig,
        name: String
    ) : IllegalArgumentException("字段${name}缺失,$config")

    private fun TypeSpec.Builder.buildGroupClassSpec(
        parent: List<DependencyConfig>,
        config: DependencyConfig
    ) {
        if (config.modules == null) {

            val groupId = findGroupId(parent, config)
            val name = findName(parent, config)
            val version = findVersion(parent, config)

            val classBuilder = TypeSpec.objectBuilder(config.title)
            classBuilder.superclass(ClassName("", DependencyClasses.KEY_CLASS_DEPENDENCY))
                .addSuperclassConstructorParameter("%S", groupId)
                .addSuperclassConstructorParameter("%S", name)
                .addSuperclassConstructorParameter("%S", version)
                .buildDoc(config)
            addType(classBuilder.build())
        } else {
            val list = parent + config

            val objectBuilder = TypeSpec.objectBuilder(config.title)
                .buildDoc(config)

            config.modules.forEach { child ->
                objectBuilder.buildGroupClassSpec(list, child)
            }

            addType(objectBuilder.build())
        }
    }

    private fun TypeSpec.Builder.buildDoc(config: DependencyConfig): TypeSpec.Builder {
        getKDoc(config.remark, config.link)?.apply(::addKdoc)
        return this
    }

    private fun findGroupId(parent: List<DependencyConfig>, config: DependencyConfig): String {
        val list = parent + config

        return list.mapNotNull { it.group }
            .lastOrNull() ?: throw MissPropertyException(config, "group")
    }

    private fun findName(parent: List<DependencyConfig>, config: DependencyConfig): String {
        val list = parent + config

        return list.mapNotNull { it.name }
            .lastOrNull() ?: throw MissPropertyException(config, "artifact")
    }

    private fun findVersion(parent: List<DependencyConfig>, config: DependencyConfig): String {
        val list = parent + config

        return list.mapNotNull { it.version }
            .lastOrNull() ?: throw MissPropertyException(config, "version")
    }

    private fun createMd() {
        val list = mutableListOf<String>()

        list.add("# 三方依赖库版本管理[![](https://jitpack.io/v/qiushui95/AndroidDependencies.svg)](https://jitpack.io/#qiushui95/AndroidDependencies)  ")

        val beans = getBeanFromJson() ?: emptyList()

        beans.filterIgnore()
            .forEach { parent ->
                list.addMdLine("<details>")
                list.addMdLine("<summary>${parent.title}</summary>")
                list.addMdLine("")
                parent.modules?.forEach { child ->
                    list.createMd(listOf(parent), child, 1)
                }
                list.addMdLine("</details>")
            }

        File(File(".."), "ReadMe.md").writeText(list.joinToString("\n"))
    }

    private fun MutableList<String>.createMd(
        parent: List<DependencyConfig>,
        config: DependencyConfig,
        prefixCount: Int
    ) {
        val sb = StringBuilder()

        sb.append(">".repeat(prefixCount))

        if (config.link != null) {
            sb.append("[${config.title}](${config.link})")
        } else {
            sb.append(config.title)
        }

        if (config.remark != null) {
            sb.append("(${config.remark})")
        }

        addMdLine(sb.toString())

        sb.clear()

        if (config.modules == null) {
            sb.append(">".repeat(prefixCount + 1))

            val groupId = findGroupId(parent, config)
            val name = findName(parent, config)
            val version = findVersion(parent, config)

            sb.append("${config.action}(${groupId}:${name}:${version})")

            addMdLine(sb.toString())
        } else {
            config.modules.forEach {
                createMd(parent + config, it, prefixCount + 1)
            }
        }

    }

    private fun MutableList<String>.addMdLine(line: String) {
        add("$line  \n")
    }

    private fun MutableList<String>.addGradleLine(line: String) {
        add("$line\n")
    }

    private fun createCheckModuleGradle() {
        val newestList = mutableListOf<String>()
        val defineList = mutableListOf<String>()

        val configs = getBeanFromJson()?.filterIgnore() ?: throw IllegalArgumentException()

        configs.forEach {
            newestList.createGradle(emptyList(), it,true)
            defineList.createGradle(emptyList(), it,false)
        }

        val parentDir = File(File("").absolutePath).parentFile

        val newestDir = File(parentDir, "newest")

        newestList.writeTo(newestDir)

        val defineDir = File(parentDir, "define")

        defineList.writeTo(defineDir)
    }

    private fun MutableList<String>.createGradle(
        parent: List<DependencyConfig>,
        config: DependencyConfig,
        isNewest: Boolean
    ) {
        if (config.modules == null) {
            val groupId = findGroupId(parent, config)

            val name = findName(parent, config)

            val version = if (isNewest) {
                "+"
            } else {
                findVersion(parent, config)
            }

            val action = config.action ?: throw IllegalArgumentMissException(
                config,
                DependencyProperties.KEY_ACTION
            )

            add("""$action("$groupId:$name:$version")""")
        } else {
            val list = config.modules + config

            config.modules.forEach {
                createGradle(list, it, isNewest)
            }

            if (config.modules.size > 1) {
                add("\n")
            }
        }
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