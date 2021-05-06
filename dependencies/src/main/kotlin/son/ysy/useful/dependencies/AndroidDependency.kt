package son.ysy.useful.dependencies

import kotlin.String
import kotlin.Suppress

@Suppress("MemberVisibilityCanBePrivate", "unused")
abstract class AndroidDependency private constructor(
    val group: String,
    val module: String,
    val version: String
) {
    val fullGradle: String
        get() = build(version)

    private fun build(version: String) = """$group:$module:$version"""

    fun customVersion(version: String): String = build(version)

    object Single {
        /**
         * https://developer.android.com/jetpack/androidx/releases/activity
         */
        object Activity : AndroidDependency("androidx.activity", "activity-ktx", "1.2.3")

        /**
         * Alerter弹窗
         * https://github.com/Tapadoo/Alerter
         */
        object Alerter : AndroidDependency("com.tapadoo.android", "alerter", "7.0.1")

        /**
         * app启动初始化管理
         * https://github.com/YummyLau/Anchors/blob/master/README-zh.md
         */
        object Anchors : AndroidDependency("com.github.YummyLau", "Anchors", "1.1.4")

        /**
         * 多功能工具包
         * https://github.com/Blankj/AndroidUtilCode
         */
        object AndroidUtil : AndroidDependency("com.blankj", "utilcodex", "1.30.6")

        /**
         * 阿里推送
         * https://help.aliyun.com/document_detail/190009.html?spm=a2c4g.11174283.3.2.52eb6d163QVxjG
         */
        object AliPush : AndroidDependency("com.aliyun.ams", "alicloud-android-push", "3.3.0")

        /**
         * https://developer.android.com/jetpack/androidx/releases/appcompat
         */
        object Appcompat : AndroidDependency("androidx.appcompat", "appcompat", "1.3.0-rc01")

        /**
         * 背景生成工具库
         * https://github.com/JavaNoober/BackgroundLibrary
         */
        object Background : AndroidDependency("com.noober.background", "core", "1.6.5")

        /**
         * 颜色帮助库
         * https://github.com/JorgeCastilloPrz/AndroidColorX
         */
        object ColorKtx : AndroidDependency("me.jorgecastillo", "androidcolorx", "0.2.0")

        /**
         * 图片加载
         * https://github.com/coil-kt/coil
         */
        object Coil : AndroidDependency("io.coil-kt", "coil", "1.2.0")

        /**
         * 时间选择器
         * https://github.com/loperSeven/DateTimePicker
         */
        object DateTimePicker : AndroidDependency(
            "com.github.loperSeven", "DateTimePicker",
            "0.3.1"
        )

        /**
         * 多媒体选择库
         * https://github.com/yangpeixing/YImagePicker
         */
        object ImagePicker : AndroidDependency("com.ypx.yimagepicker", "androidx", "3.1.4")

        /**
         * 时间处理库
         * https://github.com/JodaOrg/joda-time
         */
        object JodaTime : AndroidDependency("joda-time", "joda-time", "2.10.10")

        /**
         * 内存泄露监控
         * https://square.github.io/leakcanary/getting_started/
         */
        object LeakCanary : AndroidDependency(
            "com.squareup.leakcanary", "leakcanary-android",
            "2.7"
        )

        /**
         * 持久KV数据存储
         * https://github.com/Tencent/MMKV/blob/master/README_CN.md
         */
        object Mmkv : AndroidDependency("com.tencent", "mmkv-static", "1.2.7")

        /**
         * 权限请求
         * https://github.com/guolindev/PermissionX
         */
        object PermissionX : AndroidDependency(
            "com.permissionx.guolindev", "permissionx",
            "1.4.0"
        )

        /**
         * 二维码扫描
         * https://github.com/jenly1314/ZXingLite
         */
        object QrScanner : AndroidDependency("com.king.zxing", "zxing-lite", "2.0.3")

        /**
         * 多数据源
         * https://github.com/dropbox/Store
         */
        object Store : AndroidDependency("com.dropbox.mobile.store", "store4", "4.0.0")

        /**
         * so加载库
         * https://github.com/facebook/soloader
         */
        object SoLoader : AndroidDependency("com.facebook.soloader", "soloader", "0.10.1")

        /**
         * 自动消失LiveData
         * https://github.com/KunMinX/UnPeek-LiveData
         */
        object UnPeekLiveData : AndroidDependency(
            "com.kunminx.archi", "unpeek-livedata",
            "4.5.0-beta1"
        )

        /**
         * 微信开发Sdk
         * https://developers.weixin.qq.com/doc/oplatform/Mobile_App/Resource_Center_Homepage.html
         */
        object WeChat : AndroidDependency(
            "com.tencent.mm.opensdk",
            "wechat-sdk-android-without-mta", "6.6.23"
        )

        /**
         * 奔溃日志收集
         * https://github.com/iqiyi/xCrash/blob/master/README.zh-CN.md
         */
        object XCrash : AndroidDependency("com.iqiyi.xcrash", "xcrash-android-lib", "3.0.0")
    }

    object View {
        /**
         * 浏览器
         * https://github.com/Justson/AgentWeb
         */
        object AgentWeb : AndroidDependency(
            "com.github.Justson.AgentWeb", "agentweb-core",
            "v4.1.9-androidx"
        )

        /**
         * 轮播控件
         * https://github.com/xiaohaibin/XBanner/tree/androidX
         */
        object BannerView : AndroidDependency(
            "com.github.xiaohaibin", "XBanner",
            "androidx_v1.1.3"
        )

        /**
         * 高斯模糊
         * https://github.com/Dimezis/BlurView
         */
        object BlurView : AndroidDependency("com.eightbitlab", "blurview", "1.6.6")

        /**
         * 底部导航
         * https://github.com/Ashok-Varma/BottomNavigation
         */
        object BottomNavigation : AndroidDependency(
            "com.ashokvarma.android",
            "bottom-navigation-bar", "2.2.0"
        )

        /**
         * 约束布局
         * https://developer.android.com/jetpack/androidx/releases/constraintlayout
         */
        object ConstraintLayout : AndroidDependency(
            "androidx.constraintlayout",
            "constraintlayout", "2.0.4"
        )

        /**
         * 圆角控件
         * https://github.com/KuangGang/RoundCorners
         */
        object CornerView : AndroidDependency("com.github.KuangGang", "RoundCorners", "1.1.0")

        /**
         * 流式布局
         * https://github.com/google/flexbox-layout
         */
        object FlexBox : AndroidDependency("com.google.android", "flexbox", "2.0.1")

        /**
         * 输入格式化控件
         * https://github.com/dkzwm/FormatEditText
         */
        object FormatterEdit : AndroidDependency("me.dkzwm.widget.fet", "core", "0.2.0")

        /**
         * 动画框架
         * https://github.com/airbnb/lottie-android
         */
        object LottieView : AndroidDependency("com.airbnb.android", "lottie", "3.7.0")

        /**
         * 跑马灯控件
         * https://github.com/sunfusheng/MarqueeView
         */
        object MarqueeView : AndroidDependency("com.sunfusheng", "MarqueeView", "1.4.1")

        /**
         * https://github.com/material-components/material-components-android
         */
        object Material : AndroidDependency(
            "com.google.android.material", "material",
            "1.4.0-alpha02"
        )

        /**
         * 密码输入框
         * https://github.com/ChaosLeung/PinView
         */
        object PinView : AndroidDependency("io.github.chaosleung", "pinview", "1.4.4")

        /**
         * https://developer.android.com/jetpack/androidx/releases/recyclerview
         */
        object RecyclerView : AndroidDependency("androidx.recyclerview", "recyclerview", "1.2.0")

        /**
         * 阴影控件
         * https://github.com/lihangleo2/ShadowLayout
         */
        object ShadowLayout : AndroidDependency("com.github.lihangleo2", "ShadowLayout", "3.2.0")

        /**
         * 下拉刷新控件
         * https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout
         */
        object SwipeRefreshLayout : AndroidDependency(
            "androidx.swiperefreshlayout",
            "swiperefreshlayout", "1.2.0-alpha01"
        )

        /**
         * 开关按钮
         * https://github.com/kyleduo/SwitchButton
         */
        object SwitchButton : AndroidDependency("com.kyleduo.switchbutton", "library", "2.0.3")

        /**
         * https://developer.android.com/jetpack/androidx/releases/viewpager2
         */
        object ViewPager2 : AndroidDependency(
            "androidx.viewpager2", "viewpager2",
            "1.1.0-alpha01"
        )
    }

    /**
     * 弹窗
     * https://github.com/razerdp/BasePopup
     */
    sealed class BasePopup(
        module: String,
        version: String
    ) : AndroidDependency("io.github.razerdp", module, version) {
        object Stable : BasePopup("BasePopup", "2.3.0")

        object Candy : BasePopup("BasePopup_Candy", "2.2.30.0324")
    }

    /**
     * 网络请求监控
     * https://github.com/ChuckerTeam/chucker
     */
    sealed class Chucker(
        module: String
    ) : AndroidDependency("com.github.chuckerteam.chucker", module, "3.4.0") {
        object Debug : Chucker("library")

        object Release : Chucker("library-no-op")
    }

    /**
     * 组件化实现方案
     * https://github.com/xiaojinzi123/Component
     */
    sealed class Component(
        module: String
    ) : AndroidDependency("com.github.xiaojinzi123.Component", module, "v1.8.8-androidx-java8") {
        object Compiler : Component("component-compiler")

        object Core : Component("component-impl")

        object Plugin : Component("component-plugin")
    }

    /**
     * core
     * https://developer.android.com/jetpack/androidx/releases/core
     */
    sealed class Core(
        module: String,
        version: String
    ) : AndroidDependency("androidx.core", module, version) {
        object Ktx : Core("core-ktx", "1.5.0-rc02")

        object Role : Core("core-role", "1.0.0")

        object Animation : Core("core-animation", "1.0.0-alpha02")

        object AnimationTest : Core("core-animation-testing", "1.0.0-alpha02")
    }

    /**
     * 协程
     * https://github.com/Kotlin/kotlinx.coroutines
     */
    sealed class Coroutines(
        module: String
    ) : AndroidDependency("org.jetbrains.kotlinx", module, "1.5.0-RC") {
        object Core : Coroutines("kotlinx-coroutines-android")

        object Test : Coroutines("kotlinx-coroutines-test")
    }

    /**
     * 常用弹窗
     * https://github.com/kongzue/DialogX
     */
    sealed class DialogX(
        module: String
    ) : AndroidDependency("com.kongzue.dialogx", module, "0.0.36") {
        object Core : DialogX("DialogX")

        object IosStyle : AndroidDependency(
            "com.kongzue.dialogx.style.ios", "DialogXIOSStyle",
            "0.0.36"
        )

        object KongzueStyle : AndroidDependency(
            "com.kongzue.dialogx.style.kongzue",
            "DialogXKongzueStyle", "0.0.36"
        )

        object MiuiStyle : AndroidDependency(
            "com.kongzue.dialogx.style.miui",
            "DialogXMIUIStyle", "0.0.36"
        )
    }

    /**
     * 文件下载与上传
     * https://github.com/AriaLyy/Aria
     */
    sealed class DownloadAndUpload(
        module: String
    ) : AndroidDependency("com.arialyy.aria", module, "3.8.15") {
        object Compiler : DownloadAndUpload("compiler")

        object Core : DownloadAndUpload("core")

        object Ftp : DownloadAndUpload("ftpComponent")

        object M3u8 : DownloadAndUpload("m3u8Component")

        object Sftp : DownloadAndUpload("sftpComponent")
    }

    /**
     * RecyclerView适配库
     * https://github.com/airbnb/epoxy
     */
    sealed class Epoxy(
        module: String
    ) : AndroidDependency("com.airbnb.android", module, "4.5.0") {
        object Compiler : Epoxy("epoxy-processor")

        object Core : Epoxy("epoxy")

        object Glide : Epoxy("epoxy-glide-preloading")
    }

    /**
     * https://developer.android.com/jetpack/androidx/releases/fragment
     */
    sealed class Fragment(
        module: String
    ) : AndroidDependency("androidx.fragment", module, "1.3.3") {
        object Core : Fragment("fragment")

        object Test : Fragment("fragment-testing")
    }

    /**
     * https://github.com/ReactiveCircus/FlowBinding
     */
    sealed class FlowBinding(
        module: String
    ) : AndroidDependency("io.github.reactivecircus.flowbinding", module, "1.0.0") {
        object Basic : FlowBinding("flowbinding-android")

        object Activity : FlowBinding("flowbinding-activity")

        object Appcompat : FlowBinding("flowbinding-appcompat")

        object Core : FlowBinding("flowbinding-core")

        object DrawerLayout : FlowBinding("flowbinding-drawerlayout")

        object Lifecycle : FlowBinding("flowbinding-lifecycle")

        object Navigation : FlowBinding("flowbinding-navigation")

        object Preference : FlowBinding("flowbinding-preference")

        object RecyclerView : FlowBinding("flowbinding-recyclerview")

        object SwipeRefreshLayout : FlowBinding("flowbinding-swiperefreshlayout")

        object ViewPager2 : FlowBinding("flowbinding-viewpager2")

        object Material : FlowBinding("flowbinding-material")
    }

    /**
     * 图片加载
     * https://github.com/bumptech/glide
     */
    sealed class Glide(
        module: String,
        version: String
    ) : AndroidDependency("com.github.bumptech.glide", module, version) {
        object Annotation : Glide("annotations", "4.12.0")

        object Compiler : Glide("compiler", "4.12.0")

        object Core : Glide("glide", "4.12.0")

        object OkHttp : Glide("okhttp3-integration", "4.12.0")

        /**
         * 图片变换库
         * https://github.com/wasabeef/glide-transformations
         */
        object Transformations : AndroidDependency(
            "jp.wasabeef", "glide-transformations",
            "4.3.0"
        )

        /**
         * Gpu处理图片效果
         * https://github.com/cats-oss/android-gpuimage
         */
        object GpuImage : AndroidDependency("jp.co.cyberagent.android", "gpuimage", "2.1.0")
    }

    /**
     * key生成器
     * https://github.com/qiushui95/KeysCreator
     */
    sealed class KeyCreator(
        module: String
    ) : AndroidDependency("com.github.qiushui95.KeysCreator", module, "1.1.0") {
        object Core : KeyCreator("annotations")

        object Compiler : KeyCreator("compiler")
    }

    /**
     * 依赖注入库
     * https://github.com/InsertKoinIO/koin
     */
    sealed class Koin(
        module: String
    ) : AndroidDependency("org.koin", module, "2.2.2") {
        object Core : Koin("koin-core")

        object Ext : Koin("koin-androidx-ext")

        object Scope : Koin("koin-androidx-scope")

        object Test : Koin("koin-test")

        object ViewModel : Koin("koin-androidx-viewmodel")
    }

    /**
     * https://github.com/JetBrains/kotlin
     */
    sealed class Kotlin(
        module: String
    ) : AndroidDependency("org.jetbrains.kotlin", module, "1.5.0") {
        object Reflect : Kotlin("kotlin-reflect")

        object Stdlib : Kotlin("kotlin-stdlib")
    }

    /**
     * https://developer.android.com/jetpack/androidx/releases/lifecycle
     */
    sealed class Lifecycle(
        module: String
    ) : AndroidDependency("androidx.lifecycle", module, "2.3.1") {
        object Common : Lifecycle("lifecycle-common")

        object LiveData : Lifecycle("lifecycle-livedata-ktx")

        object Process : Lifecycle("lifecycle-process")

        object Runtime : Lifecycle("lifecycle-runtime-ktx")

        object SavedState : Lifecycle("lifecycle-viewmodel-savedstate")

        object Service : Lifecycle("lifecycle-service")

        object ViewModel : Lifecycle("lifecycle-viewmodel-ktx")
    }

    /**
     * https://fblitho.com/docs/getting-started/
     */
    sealed class Litho(
        module: String
    ) : AndroidDependency("com.facebook.litho", module, "0.40.0") {
        object Core : Litho("litho-core-kotlin")

        object Widget : Litho("litho-widget-kotlin")

        object Fresco : Litho("litho-fresco-kotlin")

        object Test : Litho("litho:litho-testing")

        object CoreSelection : Litho("litho-sections-core")

        object WidgetSelection : Litho("litho-sections-widget")

        object AnnotationsSelection : Litho("litho-sections-annotations")

        object CompilerSelection : Litho("litho-sections-processor")
    }

    /**
     * json解析库
     * https://github.com/square/moshi
     */
    sealed class MoShi(
        module: String
    ) : AndroidDependency("com.squareup.moshi", module, "1.12.0") {
        object Compiler : MoShi("moshi-kotlin-codegen")

        object Core : MoShi("moshi")
    }

    /**
     * Fragment导航库
     * https://developer.android.com/jetpack/androidx/releases/navigation
     */
    sealed class Navigation(
        module: String
    ) : AndroidDependency("androidx.navigation", module, "2.3.5") {
        object Features : Navigation("navigation-dynamic-features-fragment")

        object Ui : Navigation("navigation-ui-ktx")

        object Core : Navigation("navigation-fragment-ktx")

        object Test : Navigation("navigation-testing")
    }

    /**
     * https://github.com/square/okhttp
     */
    sealed class OkHttp(
        module: String
    ) : AndroidDependency("com.squareup.okhttp3", module, "4.9.1") {
        object Core : OkHttp("okhttp")

        object Interceptor : OkHttp("logging-interceptor")

        object Mock : OkHttp("mockwebserver")
    }

    /**
     * https://github.com/airbnb/paris
     */
    sealed class Paris(
        module: String
    ) : AndroidDependency("com.airbnb.android", module, "1.7.3") {
        object Compiler : Paris("paris-processor")

        object Core : Paris("paris")
    }

    /**
     * 网络请求
     * https://github.com/square/retrofit
     */
    sealed class Retrofit(
        module: String
    ) : AndroidDependency("com.squareup.retrofit2", module, "2.9.0") {
        object Core : Retrofit("retrofit")

        object MoShi : Retrofit("converter-moshi")
    }

    /**
     * Sqlite数据库
     * https://developer.android.com/jetpack/androidx/releases/room
     */
    sealed class Room(
        module: String
    ) : AndroidDependency("androidx.room", module, "2.3.0") {
        object Compiler : Room("room-compiler")

        object Core : Room("room-runtime")

        object Ktx : Room("room-ktx")

        object Test : Room("room-testing")
    }

    /**
     * 任务管理器
     * https://developer.android.com/jetpack/androidx/releases/work
     */
    sealed class WorkManager(
        module: String
    ) : AndroidDependency("androidx.work", module, "2.5.0") {
        object Core : WorkManager("work-runtime-ktx")

        object Test : WorkManager("work-testing")
    }

    object Test {
        /**
         * UI自动化测试
         * https://mvnrepository.com/artifact/androidx.test.espresso/espresso-core
         */
        object Espresso : AndroidDependency("androidx.test.espresso", "espresso-core", "3.3.0")

        /**
         * 单元测试
         * https://mvnrepository.com/artifact/junit/junit
         */
        object Junit : AndroidDependency("junit", "junit", "4.13.2")

        /**
         * 单元测试扩展
         * https://mvnrepository.com/artifact/androidx.test.ext/junit-ktx
         */
        object JunitExt : AndroidDependency("androidx.test.ext", "junit-ktx", "1.1.2")
    }
}
