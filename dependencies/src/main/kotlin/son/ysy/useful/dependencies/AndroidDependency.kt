package son.ysy.useful.dependencies

import kotlin.String
import kotlin.Suppress

@Suppress("MemberVisibilityCanBePrivate", "unused")
abstract class AndroidDependency private constructor(
    val group: String,
    val name: String,
    val version: String
) {
    val fullGradle: String
        get() = build(version)

    private fun build(version: String) = "$group:$name:$version"

    fun customVersion(version: String): String = build(version)

    object Single {
        /**
         * https://developer.android.com/jetpack/androidx/releases/activity
         */
        object Activity : AndroidDependency("androidx.activity", "activity-ktx", "1.2.3")

        /**
         * 阿里推送
         * https://help.aliyun.com/document_detail/190009.html?spm=a2c4g.11174283.3.2.52eb6d163QVxjG
         */
        object AliPush : AndroidDependency("com.aliyun.ams", "alicloud-android-push", "3.3.0")

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
         * https://developer.android.com/jetpack/androidx/releases/appcompat
         */
        object Appcompat : AndroidDependency("androidx.appcompat", "appcompat", "1.3.0-rc01")

        /**
         * 背景生成工具库
         * https://github.com/JavaNoober/BackgroundLibrary
         */
        object Background : AndroidDependency("com.noober.background", "core", "1.6.5")

        /**
         * 图片加载
         * https://github.com/coil-kt/coil
         */
        object Coil : AndroidDependency("io.coil-kt", "coil", "1.2.1")

        /**
         * 颜色帮助库
         * https://github.com/JorgeCastilloPrz/AndroidColorX
         */
        object ColorKtx : AndroidDependency("me.jorgecastillo", "androidcolorx", "0.2.0")

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
        object Mmkv : AndroidDependency("com.tencent", "mmkv-static", "1.2.8")

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
         * so加载库
         * https://github.com/facebook/soloader
         */
        object SoLoader : AndroidDependency("com.facebook.soloader", "soloader", "0.10.1")

        /**
         * 多数据源
         * https://github.com/dropbox/Store
         */
        object Store : AndroidDependency("com.dropbox.mobile.store", "store4", "4.0.1")

        /**
         * 微信开发Sdk
         * https://developers.weixin.qq.com/doc/oplatform/Mobile_App/Resource_Center_Homepage.html
         */
        object WeChat : AndroidDependency(
            "com.tencent.mm.opensdk",
            "wechat-sdk-android-without-mta", "6.7.0"
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
            "1.4.0-beta01"
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

    object Group {
        /**
         * 弹窗
         * https://github.com/razerdp/BasePopup
         */
        sealed class BasePopup(
            name: String,
            version: String
        ) : AndroidDependency("io.github.razerdp", name, version) {
            object Candy : BasePopup("BasePopup_Candy", "2.2.30.0324")

            object Stable : BasePopup("BasePopup", "2.3.0")
        }

        /**
         * 网络请求监控
         * https://github.com/ChuckerTeam/chucker
         */
        sealed class Chucker(
            name: String
        ) : AndroidDependency("com.github.chuckerteam.chucker", name, "3.4.0") {
            object Debug : Chucker("library")

            object Release : Chucker("library-no-op")
        }

        /**
         * 组件化实现方案
         * https://github.com/xiaojinzi123/Component
         */
        sealed class Component(
            name: String
        ) : AndroidDependency("com.github.xiaojinzi123.Component", name, "v1.8.8-androidx-java8") {
            object Compiler : Component("component-compiler")

            object Core : Component("component-impl")

            object Plugin : Component("component-plugin")
        }

        /**
         * core
         * https://developer.android.com/jetpack/androidx/releases/core
         */
        sealed class Core(
            name: String,
            version: String
        ) : AndroidDependency("androidx.core", name, version) {
            object Animation : Core("core-animation", "1.0.0-alpha02")

            object AnimationTest : Core("core-animation-testing", "1.0.0-alpha02")

            object Ktx : Core("core-ktx", "1.5.0-rc02")

            object Role : Core("core-role", "1.0.0")
        }

        /**
         * 协程
         * https://github.com/Kotlin/kotlinx.coroutines
         */
        sealed class Coroutines(
            name: String
        ) : AndroidDependency("org.jetbrains.kotlinx", name, "1.5.0-RC") {
            object Core : Coroutines("kotlinx-coroutines-android")

            object Test : Coroutines("kotlinx-coroutines-test")
        }

        /**
         * 常用弹窗
         * https://github.com/kongzue/DialogX
         */
        sealed class DialogX(
            group: String,
            name: String
        ) : AndroidDependency(group, name, "0.0.37") {
            object Core : DialogX("com.github.kongzue.DialogX", "DialogX")

            object IosStyle : DialogX("com.kongzue.dialogx.style.ios", "DialogXIOSStyle")

            object KongzueStyle : DialogX(
                "com.kongzue.dialogx.style.kongzue",
                "DialogXKongzueStyle"
            )

            object MiuiStyle : DialogX("com.kongzue.dialogx.style.miui", "DialogXMIUIStyle")
        }

        /**
         * 文件下载与上传
         * https://github.com/AriaLyy/Aria
         */
        sealed class DownloadAndUpload(
            name: String
        ) : AndroidDependency("com.arialyy.aria", name, "3.8.15") {
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
            name: String
        ) : AndroidDependency("com.airbnb.android", name, "4.5.0") {
            object Compiler : Epoxy("epoxy-processor")

            object Core : Epoxy("epoxy")

            object Glide : Epoxy("epoxy-glide-preloading")
        }

        /**
         * https://github.com/ReactiveCircus/FlowBinding
         */
        sealed class FlowBinding(
            name: String
        ) : AndroidDependency("io.github.reactivecircus.flowbinding", name, "1.0.0") {
            object Activity : FlowBinding("flowbinding-activity")

            object Appcompat : FlowBinding("flowbinding-appcompat")

            object Basic : FlowBinding("flowbinding-android")

            object Core : FlowBinding("flowbinding-core")

            object DrawerLayout : FlowBinding("flowbinding-drawerlayout")

            object Lifecycle : FlowBinding("flowbinding-lifecycle")

            object Material : FlowBinding("flowbinding-material")

            object Navigation : FlowBinding("flowbinding-navigation")

            object Preference : FlowBinding("flowbinding-preference")

            object RecyclerView : FlowBinding("flowbinding-recyclerview")

            object SwipeRefreshLayout : FlowBinding("flowbinding-swiperefreshlayout")

            object ViewPager2 : FlowBinding("flowbinding-viewpager2")
        }

        /**
         * https://developer.android.com/jetpack/androidx/releases/fragment
         */
        sealed class Fragment(
            name: String
        ) : AndroidDependency("androidx.fragment", name, "1.3.3") {
            object Core : Fragment("fragment")

            object Test : Fragment("fragment-testing")
        }

        /**
         * 图片加载
         * https://github.com/bumptech/glide
         */
        sealed class Glide(
            group: String,
            name: String,
            version: String
        ) : AndroidDependency(group, name, version) {
            object Annotation : Glide("com.github.bumptech.glide", "annotations", "4.12.0")

            object Compiler : Glide("com.github.bumptech.glide", "compiler", "4.12.0")

            object Core : Glide("com.github.bumptech.glide", "glide", "4.12.0")

            /**
             * Gpu处理图片效果
             * https://github.com/cats-oss/android-gpuimage
             */
            object GpuImage : Glide("jp.co.cyberagent.android", "gpuimage", "2.1.0")

            object OkHttp : Glide("com.github.bumptech.glide", "okhttp3-integration", "4.12.0")

            /**
             * 图片变换库
             * https://github.com/wasabeef/glide-transformations
             */
            object Transformations : Glide("jp.wasabeef", "glide-transformations", "4.3.0")
        }

        /**
         * key生成器
         * https://github.com/qiushui95/KeysCreator
         */
        sealed class KeyCreator(
            name: String
        ) : AndroidDependency("com.github.qiushui95.KeysCreator", name, "1.1.0") {
            object Compiler : KeyCreator("compiler")

            object Core : KeyCreator("annotations")
        }

        /**
         * 依赖注入库
         * https://github.com/InsertKoinIO/koin
         */
        sealed class Koin(
            name: String
        ) : AndroidDependency("org.koin", name, "2.2.2") {
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
            name: String
        ) : AndroidDependency("org.jetbrains.kotlin", name, "1.5.0") {
            object Reflect : Kotlin("kotlin-reflect")

            object Stdlib : Kotlin("kotlin-stdlib")
        }

        /**
         * https://developer.android.com/jetpack/androidx/releases/lifecycle
         */
        sealed class Lifecycle(
            name: String
        ) : AndroidDependency("androidx.lifecycle", name, "2.3.1") {
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
            name: String
        ) : AndroidDependency("com.facebook.litho", name, "0.40.0") {
            object AnnotationsSelection : Litho("litho-sections-annotations")

            object CompilerSelection : Litho("litho-sections-processor")

            object Core : Litho("litho-core-kotlin")

            object CoreSelection : Litho("litho-sections-core")

            object Fresco : Litho("litho-fresco-kotlin")

            object Test : Litho("litho:litho-testing")

            object Widget : Litho("litho-widget-kotlin")

            object WidgetSelection : Litho("litho-sections-widget")
        }

        /**
         * json解析库
         * https://github.com/square/moshi
         */
        sealed class MoShi(
            name: String
        ) : AndroidDependency("com.squareup.moshi", name, "1.12.0") {
            object Compiler : MoShi("moshi-kotlin-codegen")

            object Core : MoShi("moshi")
        }

        /**
         * Fragment导航库
         * https://developer.android.com/jetpack/androidx/releases/navigation
         */
        sealed class Navigation(
            name: String
        ) : AndroidDependency("androidx.navigation", name, "2.3.5") {
            object Core : Navigation("navigation-fragment-ktx")

            object Features : Navigation("navigation-dynamic-features-fragment")

            object Test : Navigation("navigation-testing")

            object Ui : Navigation("navigation-ui-ktx")
        }

        /**
         * https://github.com/square/okhttp
         */
        sealed class OkHttp(
            name: String
        ) : AndroidDependency("com.squareup.okhttp3", name, "4.9.1") {
            object Core : OkHttp("okhttp")

            object Interceptor : OkHttp("logging-interceptor")

            object Mock : OkHttp("mockwebserver")
        }

        /**
         * https://github.com/airbnb/paris
         */
        sealed class Paris(
            name: String
        ) : AndroidDependency("com.airbnb.android", name, "1.7.3") {
            object Compiler : Paris("paris-processor")

            object Core : Paris("paris")
        }

        /**
         * 网络请求
         * https://github.com/square/retrofit
         */
        sealed class Retrofit(
            name: String
        ) : AndroidDependency("com.squareup.retrofit2", name, "2.9.0") {
            object Core : Retrofit("retrofit")

            object MoShi : Retrofit("converter-moshi")
        }

        /**
         * Sqlite数据库
         * https://developer.android.com/jetpack/androidx/releases/room
         */
        sealed class Room(
            name: String
        ) : AndroidDependency("androidx.room", name, "2.3.0") {
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
            name: String
        ) : AndroidDependency("androidx.work", name, "2.5.0") {
            object Core : WorkManager("work-runtime-ktx")

            object Test : WorkManager("work-testing")
        }
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
