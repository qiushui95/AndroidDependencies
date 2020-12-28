package son.ysy.useful.dependencies

import kotlin.String
import kotlin.Suppress

@Suppress("MemberVisibilityCanBePrivate", "unused")
abstract class AndroidDependency private constructor(
    val group: String,
    val module: String,
    var version: String
) {
    val fullGradle: String
        get() = build(version)

    private fun build(version: String) = """$group:$module:$version"""

    fun customVersion(version: String): String {
        this.version = version
        return build(version)
    }

    object Single {
        /**
         * https://developer.android.com/jetpack/androidx/releases/activity
         */
        object Activity : AndroidDependency("androidx.activity", "activity-ktx", "1.2.0-rc01")

        /**
         * Alerter弹窗
         * https://github.com/Tapadoo/Alerter
         */
        object Alerter : AndroidDependency("com.tapadoo.android", "alerter", "6.2.1")

        /**
         * app启动初始化管理
         * https://github.com/YummyLau/Anchors/blob/master/README-zh.md
         */
        object Anchors : AndroidDependency("com.effective.android", "anchors", "1.1.3")

        /**
         * 多功能工具包
         * https://github.com/Blankj/AndroidUtilCode
         */
        object AndroidUtil : AndroidDependency("com.blankj", "utilcodex", "1.30.5")

        /**
         * https://developer.android.com/jetpack/androidx/releases/appcompat
         */
        object Appcompat : AndroidDependency("androidx.appcompat", "appcompat", "1.3.0-alpha02")

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
         * https://developer.android.com/jetpack/androidx/releases/core
         */
        object CoreKtx : AndroidDependency("androidx.core", "core-ktx", "1.5.0-alpha05")

        /**
         * 多媒体选择库
         * https://github.com/yangpeixing/YImagePicker
         */
        object ImagePicker : AndroidDependency("com.ypx.yimagepicker", "androidx", "3.1.4")

        /**
         * 时间处理库
         * https://github.com/JodaOrg/joda-time
         */
        object JodaTime : AndroidDependency("joda-time", "joda-time", "2.10.8")

        /**
         * 内存泄露监控
         * https://square.github.io/leakcanary/getting_started/
         */
        object LeakCanary : AndroidDependency(
            "com.squareup.leakcanary", "leakcanary-android",
            "2.6"
        )

        /**
         * 持久KV数据存储
         * https://github.com/Tencent/MMKV/blob/master/README_CN.md
         */
        object Mmkv : AndroidDependency("com.tencent", "mmkv-static", "1.2.7")

        /**
         * 二维码扫描
         * https://github.com/jenly1314/ZXingLite
         */
        object QrScanner : AndroidDependency("com.king.zxing", "zxing-lite", "2.0.0")

        /**
         * 多数据源
         * https://github.com/dropbox/Store
         */
        object Store : AndroidDependency("com.dropbox.mobile.store", "store4", "4.0.0")

        /**
         * 自动消失LiveData
         * https://github.com/KunMinX/UnPeek-LiveData
         */
        object UnPeekLiveData : AndroidDependency(
            "com.kunminx.archi", "unpeek-livedata",
            "4.4.1-beta1"
        )

        /**
         * 微信开发Sdk
         * https://developers.weixin.qq.com/doc/oplatform/Mobile_App/Resource_Center_Homepage.html
         */
        object WeChat : AndroidDependency(
            "com.tencent.mm.opensdk",
            "wechat-sdk-android-without-mta", "6.6.5"
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
        object AgentWeb : AndroidDependency("com.just.agentweb", "agentweb", "4.1.4")

        /**
         * 轮播控件
         * https://github.com/xiaohaibin/XBanner/tree/androidX
         */
        object BannerView : AndroidDependency(
            "com.github.xiaohaibin", "XBanner",
            "androidx_v1.1.2"
        )

        /**
         * 高斯模糊
         * https://github.com/Dimezis/BlurView
         */
        object BlurView : AndroidDependency("com.eightbitlab", "blurview", "1.6.5")

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
         * 流式布局
         * https://github.com/google/flexbox-layout
         */
        object FlexBox : AndroidDependency("com.google.android", "flexbox", "2.0.1")

        /**
         * 动画框架
         * https://github.com/airbnb/lottie-android
         */
        object LottieView : AndroidDependency("com.airbnb.android", "lottie", "3.5.0")

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
            "1.3.0-beta01"
        )

        /**
         * https://developer.android.com/jetpack/androidx/releases/recyclerview
         */
        object RecyclerView : AndroidDependency(
            "androidx.recyclerview", "recyclerview",
            "1.2.0-beta01"
        )

        /**
         * 阴影控件
         * https://github.com/lihangleo2/ShadowLayout
         */
        object ShadowLayout : AndroidDependency("com.github.lihangleo2", "ShadowLayout", "3.1.6")

        /**
         * 下拉刷新控件
         * https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout
         */
        object SwipeRefreshLayout : AndroidDependency(
            "androidx.swiperefreshlayout",
            "swiperefreshlayout", "1.2.0-alpha01"
        )

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
    ) : AndroidDependency("com.github.razerdp", module, version) {
        object Stable : BasePopup("BasePopup", "2.2.11")

        object Candy : BasePopup("BasePopup_Candy", "2.2.12.1222")
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
    ) : AndroidDependency("com.github.xiaojinzi123.Component", module, "v1.8.6-androidx-java8") {
        object Compiler : Component("component-compiler")

        object Core : Component("component-impl")

        object Plugin : Component("component-plugin")
    }

    /**
     * 协程
     * https://github.com/Kotlin/kotlinx.coroutines
     */
    sealed class Coroutines(
        module: String
    ) : AndroidDependency("org.jetbrains.kotlinx", module, "1.4.2") {
        object Core : Coroutines("kotlinx-coroutines-android")

        object Test : Coroutines("kotlinx-coroutines-test")
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
    ) : AndroidDependency("com.airbnb.android", module, "4.3.1") {
        object Compiler : Epoxy("epoxy-processor")

        object Core : Epoxy("epoxy")

        object Glide : Epoxy("epoxy-glide-preloading")
    }

    /**
     * https://developer.android.com/jetpack/androidx/releases/fragment
     */
    sealed class Fragment(
        module: String
    ) : AndroidDependency("androidx.fragment", module, "1.3.0-rc01") {
        object Core : Fragment("fragment")

        object Test : Fragment("fragment-testing")
    }

    /**
     * 图片加载
     * https://github.com/bumptech/glide
     */
    sealed class Glide(
        module: String
    ) : AndroidDependency("com.github.bumptech.glide", module, "4.11.0") {
        object Annotation : Glide("annotations")

        object Compiler : Glide("compiler")

        object Core : Glide("glide")

        object OkHttp : Glide("okhttp3-integration")

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
         * https://github.com/wasabeef/glide-transformations
         */
        object GpuImage : AndroidDependency("jp.co.cyberagent.android", "gpuimage", "2.1.0")
    }

    /**
     * 依赖注入库
     * https://github.com/InsertKoinIO/koin
     */
    sealed class Koin(
        module: String
    ) : AndroidDependency("org.koin", module, "2.2.0") {
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
    ) : AndroidDependency("org.jetbrains.kotlin", module, "1.4.21") {
        object Reflect : Kotlin("kotlin-reflect")

        object Stdlib : Kotlin("kotlin-stdlib")
    }

    /**
     * https://developer.android.com/jetpack/androidx/releases/lifecycle
     */
    sealed class Lifecycle(
        module: String
    ) : AndroidDependency("androidx.lifecycle", module, "2.3.0-rc01") {
        object Common : Lifecycle("lifecycle-common")

        object LiveData : Lifecycle("lifecycle-livedata-ktx")

        object Process : Lifecycle("lifecycle-process")

        object Runtime : Lifecycle("lifecycle-runtime-ktx")

        object SavedState : Lifecycle("lifecycle-viewmodel-savedstate")

        object Service : Lifecycle("lifecycle-service")

        object ViewModel : Lifecycle("lifecycle-viewmodel-ktx")
    }

    /**
     * json解析库
     * https://github.com/square/moshi
     */
    sealed class MoShi(
        module: String
    ) : AndroidDependency("com.squareup.moshi", module, "1.11.0") {
        object Compiler : MoShi("moshi-kotlin-codegen")

        object Core : MoShi("moshi")
    }

    /**
     * Fragment导航库
     * https://developer.android.com/jetpack/androidx/releases/navigation
     */
    sealed class Navigation(
        module: String
    ) : AndroidDependency("androidx.navigation", module, "2.3.2") {
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
    ) : AndroidDependency("com.squareup.okhttp3", module, "4.9.0") {
        object Core : OkHttp("okhttp")

        object Interceptor : OkHttp("logging-interceptor")

        object Mock : OkHttp("mockwebserver")
    }

    /**
     * https://github.com/airbnb/paris
     */
    sealed class Paris(
        module: String
    ) : AndroidDependency("com.airbnb.android", module, "1.7.2") {
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
    ) : AndroidDependency("androidx.room", module, "2.2.6") {
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
    ) : AndroidDependency("androidx.work", module, "2.5.0-beta02") {
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
        object Junit : AndroidDependency("junit", "junit", "4.13.1")

        /**
         * 单元测试扩展
         * https://mvnrepository.com/artifact/androidx.test.ext/junit-ktx
         */
        object JunitExt : AndroidDependency("androidx.test.ext", "junit-ktx", "1.1.2")
    }
}
