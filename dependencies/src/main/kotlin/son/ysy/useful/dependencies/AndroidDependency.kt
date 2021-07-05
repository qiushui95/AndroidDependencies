package son.ysy.useful.dependencies

import kotlin.String
import kotlin.Suppress

@Suppress("MemberVisibilityCanBePrivate","unused","RedundantVisibilityModifier")
public abstract class AndroidDependency private constructor(
  public val group: String,
  public val name: String,
  public val version: String
) {
  public val fullGradle: String
    get() = build(version)

  public fun build(version: String) = "$group:$name:$version"

  public fun customVersion(version: String): String = build(version)

  public object Single {
    /**
     * https://developer.android.com/jetpack/androidx/releases/activity
     */
    public object Activity : AndroidDependency("androidx.activity", "activity-ktx", "1.3.0-rc01")

    /**
     * 阿里推送
     * https://help.aliyun.com/document_detail/190009.html?spm=a2c4g.11174283.3.2.52eb6d163QVxjG
     */
    public object AliPush : AndroidDependency("com.aliyun.ams", "alicloud-android-push", "3.3.0")

    /**
     * 多功能工具包
     * https://github.com/Blankj/AndroidUtilCode
     */
    public object AndroidUtil : AndroidDependency("com.blankj", "utilcodex", "1.30.6")

    /**
     * https://developer.android.com/jetpack/androidx/releases/appcompat
     */
    public object Appcompat : AndroidDependency("androidx.appcompat", "appcompat", "1.3.0")

    /**
     * 背景生成工具库
     * https://github.com/JavaNoober/BackgroundLibrary
     */
    public object Background : AndroidDependency("com.github.JavaNoober.BackgroundLibrary",
        "libraryx", "1.7.2")

    /**
     * 图片加载
     * https://github.com/coil-kt/coil
     */
    public object Coil : AndroidDependency("io.coil-kt", "coil", "1.2.2")

    /**
     * 颜色帮助库
     * https://github.com/JorgeCastilloPrz/AndroidColorX
     */
    public object ColorKtx : AndroidDependency("me.jorgecastillo", "androidcolorx", "0.2.0")

    /**
     * 时间选择器
     * https://github.com/loperSeven/DateTimePicker
     */
    public object DateTimePicker : AndroidDependency("com.github.loperSeven", "DateTimePicker",
        "0.3.2")

    /**
     * 多媒体选择库
     * https://github.com/yangpeixing/YImagePicker
     */
    public object ImagePicker : AndroidDependency("com.ypx.yimagepicker", "androidx", "3.1.4")

    /**
     * 时间处理库
     * https://github.com/JodaOrg/joda-time
     */
    public object JodaTime : AndroidDependency("joda-time", "joda-time", "2.10.10")

    /**
     * 内存泄露监控
     * https://square.github.io/leakcanary/getting_started/
     */
    public object LeakCanary : AndroidDependency("com.squareup.leakcanary", "leakcanary-android",
        "2.7")

    /**
     * 持久KV数据存储
     * https://github.com/Tencent/MMKV/blob/master/README_CN.md
     */
    public object Mmkv : AndroidDependency("com.tencent", "mmkv-static", "1.2.10")

    /**
     * 权限请求
     * https://github.com/guolindev/PermissionX
     */
    public object PermissionX : AndroidDependency("com.permissionx.guolindev", "permissionx",
        "1.4.0")

    /**
     * 二维码扫描
     * https://github.com/jenly1314/ZXingLite
     */
    public object QrScanner : AndroidDependency("com.king.zxing", "zxing-lite", "2.0.3")

    /**
     * so加载库
     * https://github.com/facebook/soloader
     */
    public object SoLoader : AndroidDependency("com.facebook.soloader", "soloader", "0.10.1")

    /**
     * 多数据源
     * https://github.com/dropbox/Store
     */
    public object Store : AndroidDependency("com.dropbox.mobile.store", "store4", "4.0.1")

    /**
     * 微信开发Sdk
     * https://developers.weixin.qq.com/doc/oplatform/Mobile_App/Resource_Center_Homepage.html
     */
    public object WeChat : AndroidDependency("com.tencent.mm.opensdk",
        "wechat-sdk-android-without-mta", "6.7.4")

    /**
     * 奔溃日志收集
     * https://github.com/iqiyi/xCrash/blob/master/README.zh-CN.md
     */
    public object XCrash : AndroidDependency("com.iqiyi.xcrash", "xcrash-android-lib", "3.0.0")
  }

  public object Group {
    /**
     * 我的架构组件
     * https://github.com/qiushui95/MyArchitecture
     */
    public object Architecture {
      public object Constant : AndroidDependency("com.github.qiushui95.MyArchitecture",
          "architecture-constant", "1.0.15")

      public object Domain : AndroidDependency("com.github.qiushui95.MyArchitecture",
          "architecture-domain", "1.0.15")

      public object DomainImpl : AndroidDependency("com.github.qiushui95.MyArchitecture",
          "architecture-domain-impl", "1.0.15")

      public object Entity : AndroidDependency("com.github.qiushui95.MyArchitecture",
          "architecture-entity", "1.0.15")

      public object Error : AndroidDependency("com.github.qiushui95.MyArchitecture",
          "architecture-error", "1.0.15")

      public object Ext : AndroidDependency("com.github.qiushui95.MyArchitecture",
          "architecture-ext", "1.0.15")

      public object FlowWork : AndroidDependency("com.github.qiushui95.MyArchitecture",
          "architecture-flow-work", "1.0.15")

      public object Getter : AndroidDependency("com.github.qiushui95.MyArchitecture",
          "architecture-getter", "1.0.15")

      public object Http : AndroidDependency("com.github.qiushui95.MyArchitecture",
          "architecture-http", "1.0.15")

      public object Initializer : AndroidDependency("com.github.qiushui95.MyArchitecture",
          "architecture-initializer", "1.0.15")

      public object Model : AndroidDependency("com.github.qiushui95.MyArchitecture",
          "architecture-model", "1.0.15")

      public object Starter : AndroidDependency("com.github.qiushui95.MyArchitecture",
          "architecture-starter", "1.0.15")
    }

    /**
     * 弹窗
     * https://github.com/razerdp/BasePopup
     */
    public object BasePopup {
      public object Candy : AndroidDependency("io.github.razerdp", "BasePopup", "3.1.6-SNAPSHOT")

      public object Stable : AndroidDependency("io.github.razerdp", "BasePopup", "3.1.4")
    }

    /**
     * 相机相关
     * https://developer.android.com/jetpack/androidx/releases/camera
     */
    public object CameraX {
      public object Camera2 : AndroidDependency("androidx.camera", "camera-camera2", "1.0.0")

      public object Core : AndroidDependency("androidx.camera", "camera-core", "1.0.0")

      public object Extensions : AndroidDependency("androidx.camera", "camera-extensions",
          "1.0.0-alpha26")

      public object Lifecycle : AndroidDependency("androidx.camera", "camera-lifecycle", "1.0.0")

      public object View : AndroidDependency("androidx.camera", "camera-view", "1.0.0-alpha26")
    }

    /**
     * 网络请求监控
     * https://github.com/ChuckerTeam/chucker
     */
    public object Chucker {
      public object Debug : AndroidDependency("com.github.chuckerteam.chucker", "library", "3.5.0")

      public object Release : AndroidDependency("com.github.chuckerteam.chucker", "library-no-op",
          "3.5.0")
    }

    /**
     * core
     * https://developer.android.com/jetpack/androidx/releases/core
     */
    public object Core {
      public object Animation : AndroidDependency("androidx.core", "core-animation",
          "1.0.0-alpha02")

      public object AnimationTest : AndroidDependency("androidx.core", "core-animation-testing",
          "1.0.0-alpha02")

      public object Ktx : AndroidDependency("androidx.core", "core-ktx", "1.6.0-rc01")

      public object Role : AndroidDependency("androidx.core", "core-role", "1.0.0")
    }

    /**
     * 协程
     * https://github.com/Kotlin/kotlinx.coroutines
     */
    public object Coroutines {
      public object Core : AndroidDependency("org.jetbrains.kotlinx", "kotlinx-coroutines-android",
          "1.5.0")

      public object Test : AndroidDependency("org.jetbrains.kotlinx", "kotlinx-coroutines-test",
          "1.5.0")
    }

    /**
     * 常用弹窗
     * https://github.com/kongzue/DialogX
     */
    public object DialogX {
      public object Core : AndroidDependency("com.github.kongzue.DialogX", "DialogX", "0.0.37")
    }

    /**
     * 文件下载与上传
     * https://github.com/AriaLyy/Aria
     */
    public object DownloadAndUpload {
      public object Compiler : AndroidDependency("com.arialyy.aria", "compiler", "3.8.15")

      public object Core : AndroidDependency("com.arialyy.aria", "core", "3.8.15")

      public object Ftp : AndroidDependency("com.arialyy.aria", "ftpComponent", "3.8.15")

      public object M3u8 : AndroidDependency("com.arialyy.aria", "m3u8Component", "3.8.15")

      public object Sftp : AndroidDependency("com.arialyy.aria", "sftpComponent", "3.8.15")
    }

    /**
     * RecyclerView适配库
     * https://github.com/airbnb/epoxy
     */
    public object Epoxy {
      public object Compiler : AndroidDependency("com.airbnb.android", "epoxy-processor", "4.6.2")

      public object Core : AndroidDependency("com.airbnb.android", "epoxy", "4.6.2")

      public object Glide : AndroidDependency("com.airbnb.android", "epoxy-glide-preloading",
          "4.6.2")
    }

    /**
     * https://github.com/ReactiveCircus/FlowBinding
     */
    public object FlowBinding {
      public object Activity : AndroidDependency("io.github.reactivecircus.flowbinding",
          "flowbinding-activity", "1.2.0")

      public object Appcompat : AndroidDependency("io.github.reactivecircus.flowbinding",
          "flowbinding-appcompat", "1.2.0")

      public object Basic : AndroidDependency("io.github.reactivecircus.flowbinding",
          "flowbinding-android", "1.2.0")

      public object Core : AndroidDependency("io.github.reactivecircus.flowbinding",
          "flowbinding-core", "1.2.0")

      public object DrawerLayout : AndroidDependency("io.github.reactivecircus.flowbinding",
          "flowbinding-drawerlayout", "1.2.0")

      public object Lifecycle : AndroidDependency("io.github.reactivecircus.flowbinding",
          "flowbinding-lifecycle", "1.2.0")

      public object Material : AndroidDependency("io.github.reactivecircus.flowbinding",
          "flowbinding-material", "1.2.0")

      public object Navigation : AndroidDependency("io.github.reactivecircus.flowbinding",
          "flowbinding-navigation", "1.2.0")

      public object Preference : AndroidDependency("io.github.reactivecircus.flowbinding",
          "flowbinding-preference", "1.2.0")

      public object RecyclerView : AndroidDependency("io.github.reactivecircus.flowbinding",
          "flowbinding-recyclerview", "1.2.0")

      public object SwipeRefreshLayout : AndroidDependency("io.github.reactivecircus.flowbinding",
          "flowbinding-swiperefreshlayout", "1.2.0")

      public object ViewPager2 : AndroidDependency("io.github.reactivecircus.flowbinding",
          "flowbinding-viewpager2", "1.2.0")
    }

    /**
     * https://developer.android.com/jetpack/androidx/releases/fragment
     */
    public object Fragment {
      public object Core : AndroidDependency("androidx.fragment", "fragment-ktx", "1.3.5")

      public object Test : AndroidDependency("androidx.fragment", "fragment-testing", "1.3.5")
    }

    /**
     * Fragment管理
     * https://developer.android.com/jetpack/androidx/releases/fragment
     */
    public object FragmentManager {
      public object Core : AndroidDependency("com.github.weikaiyun.SFragmentation", "fragmentation",
          "1.8.3")

      public object SwipeBack : AndroidDependency("com.github.weikaiyun.SFragmentation",
          "fragmentation_swipeback", "1.8.3")
    }

    /**
     * 图片加载
     * https://github.com/bumptech/glide
     */
    public object Glide {
      public object Annotation : AndroidDependency("com.github.bumptech.glide", "annotations",
          "4.12.0")

      public object Compiler : AndroidDependency("com.github.bumptech.glide", "compiler", "4.12.0")

      public object Core : AndroidDependency("com.github.bumptech.glide", "glide", "4.12.0")

      /**
       * Gpu处理图片效果
       * https://github.com/cats-oss/android-gpuimage
       */
      public object GpuImage : AndroidDependency("jp.co.cyberagent.android", "gpuimage", "2.1.0")

      public object OkHttp : AndroidDependency("com.github.bumptech.glide", "okhttp3-integration",
          "4.12.0")

      /**
       * 图片变换库
       * https://github.com/wasabeef/glide-transformations
       */
      public object Transformations : AndroidDependency("jp.wasabeef", "glide-transformations",
          "4.3.0")
    }

    /**
     * key生成器
     * https://github.com/qiushui95/KeysCreator
     */
    public object KeyCreator {
      public object Compiler : AndroidDependency("com.github.qiushui95.KeysCreator", "compiler",
          "1.1.0")

      public object Core : AndroidDependency("com.github.qiushui95.KeysCreator", "annotations",
          "1.1.0")
    }

    /**
     * 依赖注入库
     * https://github.com/InsertKoinIO/koin
     */
    public object Koin {
      public object Android : AndroidDependency("io.insert-koin", "koin-android", "3.1.2")

      public object Core : AndroidDependency("io.insert-koin", "koin-core", "3.1.2")

      public object Test : AndroidDependency("io.insert-koin", "koin-test-junit5", "3.1.2")

      public object WorkManager : AndroidDependency("io.insert-koin", "koin-androidx-workmanager",
          "3.1.2")
    }

    /**
     * 依赖注入库
     * https://github.com/InsertKoinIO/koin
     */
    public object KoinOld {
      public object Android : AndroidDependency("io.insert-koin", "koin-androidx-ext", "2.2.3")

      public object Core : AndroidDependency("io.insert-koin", "koin-core-ext", "2.2.3")

      public object Scope : AndroidDependency("io.insert-koin", "koin-androidx-scope", "2.2.3")

      public object Test : AndroidDependency("io.insert-koin", "koin-test", "2.2.3")

      public object ViewModel : AndroidDependency("io.insert-koin", "koin-androidx-viewmodel",
          "2.2.3")
    }

    /**
     * https://github.com/JetBrains/kotlin
     */
    public object Kotlin {
      public object Reflect : AndroidDependency("org.jetbrains.kotlin", "kotlin-reflect", "1.5.20")

      public object Stdlib : AndroidDependency("org.jetbrains.kotlin", "kotlin-stdlib", "1.5.20")
    }

    /**
     * https://developer.android.com/jetpack/androidx/releases/lifecycle
     */
    public object Lifecycle {
      public object Common : AndroidDependency("androidx.lifecycle", "lifecycle-common", "2.3.1")

      public object LiveData : AndroidDependency("androidx.lifecycle", "lifecycle-livedata-ktx",
          "2.3.1")

      public object Process : AndroidDependency("androidx.lifecycle", "lifecycle-process", "2.3.1")

      public object Runtime : AndroidDependency("androidx.lifecycle", "lifecycle-runtime-ktx",
          "2.3.1")

      public object SavedState : AndroidDependency("androidx.lifecycle",
          "lifecycle-viewmodel-savedstate", "2.3.1")

      public object Service : AndroidDependency("androidx.lifecycle", "lifecycle-service", "2.3.1")

      public object ViewModel : AndroidDependency("androidx.lifecycle", "lifecycle-viewmodel-ktx",
          "2.3.1")
    }

    /**
     * json解析库
     * https://github.com/square/moshi
     */
    public object MoShi {
      public object Compiler : AndroidDependency("com.squareup.moshi", "moshi-kotlin-codegen",
          "1.12.0")

      public object Core : AndroidDependency("com.squareup.moshi", "moshi", "1.12.0")
    }

    /**
     * Fragment导航库
     * https://developer.android.com/jetpack/androidx/releases/navigation
     */
    public object Navigation {
      public object Core : AndroidDependency("androidx.navigation", "navigation-fragment-ktx",
          "2.3.5")

      public object Features : AndroidDependency("androidx.navigation",
          "navigation-dynamic-features-fragment", "2.3.5")

      public object Test : AndroidDependency("androidx.navigation", "navigation-testing", "2.3.5")

      public object Ui : AndroidDependency("androidx.navigation", "navigation-ui-ktx", "2.3.5")
    }

    /**
     * https://github.com/square/okhttp
     */
    public object OkHttp {
      public object Core : AndroidDependency("com.squareup.okhttp3", "okhttp", "4.9.1")

      public object Interceptor : AndroidDependency("com.localebro", "okhttpprofiler", "1.0.8")

      public object Mock : AndroidDependency("com.squareup.okhttp3", "mockwebserver", "4.9.1")
    }

    /**
     * https://github.com/airbnb/paris
     */
    public object Paris {
      public object Compiler : AndroidDependency("com.airbnb.android", "paris-processor", "1.7.3")

      public object Core : AndroidDependency("com.airbnb.android", "paris", "1.7.3")
    }

    /**
     * 网络请求
     * https://github.com/square/retrofit
     */
    public object Retrofit {
      public object Core : AndroidDependency("com.squareup.retrofit2", "retrofit", "2.9.0")

      public object MoShi : AndroidDependency("com.squareup.retrofit2", "converter-moshi", "2.9.0")
    }

    /**
     * Sqlite数据库
     * https://developer.android.com/jetpack/androidx/releases/room
     */
    public object Room {
      public object Compiler : AndroidDependency("androidx.room", "room-compiler", "2.3.0")

      public object Core : AndroidDependency("androidx.room", "room-runtime", "2.3.0")

      public object Ktx : AndroidDependency("androidx.room", "room-ktx", "2.3.0")

      public object Test : AndroidDependency("androidx.room", "room-testing", "2.3.0")
    }

    /**
     * 任务管理器
     * https://developer.android.com/jetpack/androidx/releases/work
     */
    public object WorkManager {
      public object Core : AndroidDependency("androidx.work", "work-runtime-ktx", "2.5.0")

      public object Test : AndroidDependency("androidx.work", "work-testing", "2.5.0")
    }
  }

  public object View {
    /**
     * 浏览器
     * https://github.com/Justson/AgentWeb
     */
    public object AgentWeb : AndroidDependency("com.github.Justson.AgentWeb", "agentweb-core",
        "v4.1.9-androidx")

    /**
     * 轮播控件
     * https://github.com/xiaohaibin/XBanner/tree/androidX
     */
    public object BannerView : AndroidDependency("com.github.xiaohaibin", "XBanner",
        "androidx_v1.1.3")

    /**
     * 高斯模糊
     * https://github.com/Dimezis/BlurView
     */
    public object BlurView : AndroidDependency("com.eightbitlab", "blurview", "1.6.6")

    /**
     * 底部导航
     * https://github.com/Ashok-Varma/BottomNavigation
     */
    public object BottomNavigation : AndroidDependency("com.ashokvarma.android",
        "bottom-navigation-bar", "2.2.0")

    /**
     * 约束布局
     * https://developer.android.com/jetpack/androidx/releases/constraintlayout
     */
    public object ConstraintLayout : AndroidDependency("androidx.constraintlayout",
        "constraintlayout", "2.0.4")

    /**
     * 圆角控件
     * https://github.com/KuangGang/RoundCorners
     */
    public object CornerView : AndroidDependency("com.github.KuangGang", "RoundCorners", "1.1.0")

    /**
     * 流式布局
     * https://github.com/google/flexbox-layout
     */
    public object FlexBox : AndroidDependency("com.google.android", "flexbox", "2.0.1")

    /**
     * 输入格式化控件
     * https://github.com/dkzwm/FormatEditText
     */
    public object FormatterEdit : AndroidDependency("me.dkzwm.widget.fet", "core", "0.2.0")

    /**
     * 动画框架
     * https://github.com/airbnb/lottie-android
     */
    public object LottieView : AndroidDependency("com.airbnb.android", "lottie", "3.7.0")

    /**
     * 跑马灯控件
     * https://github.com/sunfusheng/MarqueeView
     */
    public object MarqueeView : AndroidDependency("com.sunfusheng", "MarqueeView", "1.4.1")

    /**
     * https://github.com/material-components/material-components-android
     */
    public object Material : AndroidDependency("com.google.android.material", "material", "1.4.0")

    /**
     * 密码输入框
     * https://github.com/ChaosLeung/PinView
     */
    public object PinView : AndroidDependency("io.github.chaosleung", "pinview", "1.4.4")

    /**
     * https://developer.android.com/jetpack/androidx/releases/recyclerview
     */
    public object RecyclerView : AndroidDependency("androidx.recyclerview", "recyclerview", "1.2.1")

    /**
     * 阴影控件
     * https://github.com/lihangleo2/ShadowLayout
     */
    public object ShadowLayout : AndroidDependency("com.github.lihangleo2", "ShadowLayout", "3.2.0")

    /**
     * 下拉刷新控件
     * https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout
     */
    public object SwipeRefreshLayout : AndroidDependency("androidx.swiperefreshlayout",
        "swiperefreshlayout", "1.2.0-alpha01")

    /**
     * 开关按钮
     * https://github.com/kyleduo/SwitchButton
     */
    public object SwitchButton : AndroidDependency("com.kyleduo.switchbutton", "library", "2.1.0")

    /**
     * https://developer.android.com/jetpack/androidx/releases/viewpager2
     */
    public object ViewPager2 : AndroidDependency("androidx.viewpager2", "viewpager2",
        "1.1.0-alpha01")
  }

  public object Compose {
    /**
     * https://github.com/google/accompanist
     */
    public object Accompanist {
      public object AppcompatTheme : AndroidDependency("com.google.accompanist",
          "accompanist-appcompat-theme", "0.13.0")

      public object Coil : AndroidDependency("com.google.accompanist", "accompanist-coil", "0.13.0")

      public object FlowLayout : AndroidDependency("com.google.accompanist",
          "accompanist-flowlayout", "0.13.0")

      public object Insets : AndroidDependency("com.google.accompanist", "accompanist-insets",
          "0.13.0")

      public object Pager : AndroidDependency("com.google.accompanist", "accompanist-pager",
          "0.13.0")

      public object SwipeRefresh : AndroidDependency("com.google.accompanist",
          "accompanist-swiperefresh", "0.13.0")

      public object SystemUiController : AndroidDependency("com.google.accompanist",
          "accompanist-systemuicontroller", "0.13.0")
    }

    /**
     * https://developer.android.com/jetpack/androidx/releases/activity
     */
    public object Activity : AndroidDependency("androidx.activity", "activity-compose",
        "1.3.0-rc01")

    /**
     * https://developer.android.com/jetpack/androidx/releases/constraintlayout
     */
    public object ConstraintLayout : AndroidDependency("androidx.constraintlayout",
        "constraintlayout-compose", "1.0.0-alpha08")

    /**
     * https://developer.android.com/jetpack/androidx/releases/navigation
     */
    public object Navigation : AndroidDependency("androidx.navigation", "navigation-compose",
        "2.4.0-alpha04")

    /**
     * Compose导航动画
     * https://github.com/fornewid/material-motion-compose
     */
    public object NavigationAnimation : AndroidDependency("com.github.fornewid",
        "material-motion-compose", "0.5.1")

    /**
     * https://developer.android.com/jetpack/androidx/releases/compose
     */
    public object Official {
      public object Animation : AndroidDependency("androidx.compose.animation", "animation",
          "1.0.0-rc01")

      public object Compiler : AndroidDependency("androidx.compose.compiler", "compiler",
          "1.0.0-rc01")

      public object Foundation : AndroidDependency("androidx.compose.foundation", "foundation",
          "1.0.0-rc01")

      public object LiveData : AndroidDependency("androidx.compose.runtime", "runtime-livedata",
          "1.0.0-rc01")

      public object Material : AndroidDependency("androidx.compose.material", "material",
          "1.0.0-rc01")

      public object MaterialIcon : AndroidDependency("androidx.compose.material",
          "material-icons-core", "1.0.0-rc01")

      public object MaterialIconExtended : AndroidDependency("androidx.compose.material",
          "material-icons-extended", "1.0.0-rc01")

      public object Test : AndroidDependency("androidx.compose.ui", "ui-test-junit4", "1.0.0-rc01")

      public object Ui : AndroidDependency("androidx.compose.ui", "ui", "1.0.0-rc01")

      public object UiTooling : AndroidDependency("androidx.compose.ui", "ui-tooling", "1.0.0-rc01")
    }

    /**
     * https://developer.android.com/jetpack/androidx/releases/lifecycle#lifecycle_viewmodel_compose_2
     */
    public object ViewModel : AndroidDependency("androidx.lifecycle", "lifecycle-viewmodel-compose",
        "1.0.0-alpha07")
  }

  public object Test {
    /**
     * UI自动化测试
     * https://mvnrepository.com/artifact/androidx.test.espresso/espresso-core
     */
    public object Espresso : AndroidDependency("androidx.test.espresso", "espresso-core", "3.4.0")

    /**
     * 单元测试
     * https://mvnrepository.com/artifact/junit/junit
     */
    public object Junit : AndroidDependency("junit", "junit", "4.13.2")

    /**
     * 单元测试扩展
     * https://mvnrepository.com/artifact/androidx.test.ext/junit-ktx
     */
    public object JunitExt : AndroidDependency("androidx.test.ext", "junit-ktx", "1.1.3")
  }
}
