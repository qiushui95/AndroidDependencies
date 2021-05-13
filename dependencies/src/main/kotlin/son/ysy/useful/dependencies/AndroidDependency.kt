package son.ysy.useful.dependencies

import kotlin.String
import kotlin.Suppress

@Suppress("MemberVisibilityCanBePrivate","unused")
public abstract class AndroidDependency private constructor(
  public val group: String,
  public val name: String,
  public val version: String
) {
  public val fullGradle: String
    get() = build(version)

  private fun build(version: String) = "$group:$name:$version"

  public fun customVersion(version: String): String = build(version)

  public object Single {
    /**
     * https://developer.android.com/jetpack/androidx/releases/activity
     */
    public object Activity : AndroidDependency("androidx.activity", "activity-ktx", "1.2.3")

    /**
     * 阿里推送
     * https://help.aliyun.com/document_detail/190009.html?spm=a2c4g.11174283.3.2.52eb6d163QVxjG
     */
    public object AliPush : AndroidDependency("com.aliyun.ams", "alicloud-android-push", "3.3.0")

    /**
     * app启动初始化管理
     * https://github.com/YummyLau/Anchors/blob/master/README-zh.md
     */
    public object Anchors : AndroidDependency("com.github.YummyLau", "Anchors", "1.1.4")

    /**
     * 多功能工具包
     * https://github.com/Blankj/AndroidUtilCode
     */
    public object AndroidUtil : AndroidDependency("com.blankj", "utilcodex", "1.30.6")

    /**
     * https://developer.android.com/jetpack/androidx/releases/appcompat
     */
    public object Appcompat : AndroidDependency("androidx.appcompat", "appcompat", "1.3.0-rc01")

    /**
     * 背景生成工具库
     * https://github.com/JavaNoober/BackgroundLibrary
     */
    public object Background : AndroidDependency("com.noober.background", "core", "1.6.5")

    /**
     * 图片加载
     * https://github.com/coil-kt/coil
     */
    public object Coil : AndroidDependency("io.coil-kt", "coil", "1.2.1")

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
        "0.3.1")

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
    public object Mmkv : AndroidDependency("com.tencent", "mmkv-static", "1.2.8")

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
        "wechat-sdk-android-without-mta", "6.7.0")

    /**
     * 奔溃日志收集
     * https://github.com/iqiyi/xCrash/blob/master/README.zh-CN.md
     */
    public object XCrash : AndroidDependency("com.iqiyi.xcrash", "xcrash-android-lib", "3.0.0")
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
    public object Material : AndroidDependency("com.google.android.material", "material",
        "1.4.0-beta01")

    /**
     * 密码输入框
     * https://github.com/ChaosLeung/PinView
     */
    public object PinView : AndroidDependency("io.github.chaosleung", "pinview", "1.4.4")

    /**
     * https://developer.android.com/jetpack/androidx/releases/recyclerview
     */
    public object RecyclerView : AndroidDependency("androidx.recyclerview", "recyclerview", "1.2.0")

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
    public object SwitchButton : AndroidDependency("com.kyleduo.switchbutton", "library", "2.0.3")

    /**
     * https://developer.android.com/jetpack/androidx/releases/viewpager2
     */
    public object ViewPager2 : AndroidDependency("androidx.viewpager2", "viewpager2",
        "1.1.0-alpha01")
  }

  /**
   * 我的架构组件
   * https://github.com/qiushui95/MyArchitecture
   */
  public sealed class Architecture(
    name: String
  ) : AndroidDependency("com.github.qiushui95.MyArchitecture", name, "1.0.4") {
    public object Constant : Architecture("constant")

    public object Domain : Architecture("domain")

    public object DomainImpl : Architecture("domain-impl")

    public object Entity : Architecture("entity")

    public object Error : Architecture("error")

    public object Ext : Architecture("ext")

    public object Http : Architecture("http")

    public object Model : Architecture("model")

    public object Starter : Architecture("starter")
  }

  /**
   * 弹窗
   * https://github.com/razerdp/BasePopup
   */
  public sealed class BasePopup(
    name: String,
    version: String
  ) : AndroidDependency("io.github.razerdp", name, version) {
    public object Candy : BasePopup("BasePopup_Candy", "2.2.30.0324")

    public object Stable : BasePopup("BasePopup", "2.3.0")
  }

  /**
   * 网络请求监控
   * https://github.com/ChuckerTeam/chucker
   */
  public sealed class Chucker(
    name: String
  ) : AndroidDependency("com.github.chuckerteam.chucker", name, "3.4.0") {
    public object Debug : Chucker("library")

    public object Release : Chucker("library-no-op")
  }

  /**
   * 组件化实现方案
   * https://github.com/xiaojinzi123/Component
   */
  public sealed class Component(
    name: String
  ) : AndroidDependency("com.github.xiaojinzi123.Component", name, "v1.8.8-androidx-java8") {
    public object Compiler : Component("component-compiler")

    public object Core : Component("component-impl")

    public object Plugin : Component("component-plugin")
  }

  /**
   * core
   * https://developer.android.com/jetpack/androidx/releases/core
   */
  public sealed class Core(
    name: String,
    version: String
  ) : AndroidDependency("androidx.core", name, version) {
    public object Animation : Core("core-animation", "1.0.0-alpha02")

    public object AnimationTest : Core("core-animation-testing", "1.0.0-alpha02")

    public object Ktx : Core("core-ktx", "1.5.0-rc02")

    public object Role : Core("core-role", "1.0.0")
  }

  /**
   * 协程
   * https://github.com/Kotlin/kotlinx.coroutines
   */
  public sealed class Coroutines(
    name: String
  ) : AndroidDependency("org.jetbrains.kotlinx", name, "1.5.0-RC") {
    public object Core : Coroutines("kotlinx-coroutines-android")

    public object Test : Coroutines("kotlinx-coroutines-test")
  }

  /**
   * 常用弹窗
   * https://github.com/kongzue/DialogX
   */
  public sealed class DialogX(
    group: String,
    name: String
  ) : AndroidDependency(group, name, "0.0.37") {
    public object Core : DialogX("com.github.kongzue.DialogX", "DialogX")

    public object IosStyle : DialogX("com.kongzue.dialogx.style.ios", "DialogXIOSStyle")

    public object KongzueStyle : DialogX("com.kongzue.dialogx.style.kongzue", "DialogXKongzueStyle")

    public object MiuiStyle : DialogX("com.kongzue.dialogx.style.miui", "DialogXMIUIStyle")
  }

  /**
   * 文件下载与上传
   * https://github.com/AriaLyy/Aria
   */
  public sealed class DownloadAndUpload(
    name: String
  ) : AndroidDependency("com.arialyy.aria", name, "3.8.15") {
    public object Compiler : DownloadAndUpload("compiler")

    public object Core : DownloadAndUpload("core")

    public object Ftp : DownloadAndUpload("ftpComponent")

    public object M3u8 : DownloadAndUpload("m3u8Component")

    public object Sftp : DownloadAndUpload("sftpComponent")
  }

  /**
   * RecyclerView适配库
   * https://github.com/airbnb/epoxy
   */
  public sealed class Epoxy(
    name: String
  ) : AndroidDependency("com.airbnb.android", name, "4.5.0") {
    public object Compiler : Epoxy("epoxy-processor")

    public object Core : Epoxy("epoxy")

    public object Glide : Epoxy("epoxy-glide-preloading")
  }

  /**
   * https://github.com/ReactiveCircus/FlowBinding
   */
  public sealed class FlowBinding(
    name: String
  ) : AndroidDependency("io.github.reactivecircus.flowbinding", name, "1.0.0") {
    public object Activity : FlowBinding("flowbinding-activity")

    public object Appcompat : FlowBinding("flowbinding-appcompat")

    public object Basic : FlowBinding("flowbinding-android")

    public object Core : FlowBinding("flowbinding-core")

    public object DrawerLayout : FlowBinding("flowbinding-drawerlayout")

    public object Lifecycle : FlowBinding("flowbinding-lifecycle")

    public object Material : FlowBinding("flowbinding-material")

    public object Navigation : FlowBinding("flowbinding-navigation")

    public object Preference : FlowBinding("flowbinding-preference")

    public object RecyclerView : FlowBinding("flowbinding-recyclerview")

    public object SwipeRefreshLayout : FlowBinding("flowbinding-swiperefreshlayout")

    public object ViewPager2 : FlowBinding("flowbinding-viewpager2")
  }

  /**
   * https://developer.android.com/jetpack/androidx/releases/fragment
   */
  public sealed class Fragment(
    group: String,
    name: String,
    version: String
  ) : AndroidDependency(group, name, version) {
    public object Core : Fragment("androidx.fragment", "fragment-ktx", "1.3.3")

    /**
     * https://github.com/terrakok/Cicerone
     */
    public object Manager : Fragment("com.github.terrakok", "cicerone", "7.0")

    public object Test : Fragment("androidx.fragment", "fragment-testing", "1.3.3")
  }

  /**
   * 图片加载
   * https://github.com/bumptech/glide
   */
  public sealed class Glide(
    group: String,
    name: String,
    version: String
  ) : AndroidDependency(group, name, version) {
    public object Annotation : Glide("com.github.bumptech.glide", "annotations", "4.12.0")

    public object Compiler : Glide("com.github.bumptech.glide", "compiler", "4.12.0")

    public object Core : Glide("com.github.bumptech.glide", "glide", "4.12.0")

    /**
     * Gpu处理图片效果
     * https://github.com/cats-oss/android-gpuimage
     */
    public object GpuImage : Glide("jp.co.cyberagent.android", "gpuimage", "2.1.0")

    public object OkHttp : Glide("com.github.bumptech.glide", "okhttp3-integration", "4.12.0")

    /**
     * 图片变换库
     * https://github.com/wasabeef/glide-transformations
     */
    public object Transformations : Glide("jp.wasabeef", "glide-transformations", "4.3.0")
  }

  /**
   * key生成器
   * https://github.com/qiushui95/KeysCreator
   */
  public sealed class KeyCreator(
    name: String
  ) : AndroidDependency("com.github.qiushui95.KeysCreator", name, "1.1.0") {
    public object Compiler : KeyCreator("compiler")

    public object Core : KeyCreator("annotations")
  }

  /**
   * 依赖注入库
   * https://github.com/InsertKoinIO/koin
   */
  public sealed class Koin(
    name: String
  ) : AndroidDependency("io.insert-koin", name, "3.0.1") {
    public object Android : Koin("koin-android")

    public object AndroidExt : Koin("koin-android-ext")

    public object Core : Koin("koin-core")

    public object CoreExt : Koin("koin-core-ext")

    public object Test : Koin("koin-test")

    public object WorkManager : Koin("koin-androidx-workmanager")
  }

  /**
   * 依赖注入库
   * https://github.com/InsertKoinIO/koin
   */
  public sealed class KoinOld(
    name: String
  ) : AndroidDependency("org.koin", name, "2.2.2") {
    public object Core : KoinOld("koin-core")

    public object Ext : KoinOld("koin-androidx-ext")

    public object Scope : KoinOld("koin-androidx-scope")

    public object Test : KoinOld("koin-test")

    public object ViewModel : KoinOld("koin-androidx-viewmodel")
  }

  /**
   * https://github.com/JetBrains/kotlin
   */
  public sealed class Kotlin(
    name: String
  ) : AndroidDependency("org.jetbrains.kotlin", name, "1.5.0") {
    public object Reflect : Kotlin("kotlin-reflect")

    public object Stdlib : Kotlin("kotlin-stdlib")
  }

  /**
   * https://developer.android.com/jetpack/androidx/releases/lifecycle
   */
  public sealed class Lifecycle(
    name: String
  ) : AndroidDependency("androidx.lifecycle", name, "2.3.1") {
    public object Common : Lifecycle("lifecycle-common")

    public object LiveData : Lifecycle("lifecycle-livedata-ktx")

    public object Process : Lifecycle("lifecycle-process")

    public object Runtime : Lifecycle("lifecycle-runtime-ktx")

    public object SavedState : Lifecycle("lifecycle-viewmodel-savedstate")

    public object Service : Lifecycle("lifecycle-service")

    public object ViewModel : Lifecycle("lifecycle-viewmodel-ktx")
  }

  /**
   * https://fblitho.com/docs/getting-started/
   */
  public sealed class Litho(
    name: String
  ) : AndroidDependency("com.facebook.litho", name, "0.40.0") {
    public object AnnotationsSelection : Litho("litho-sections-annotations")

    public object CompilerSelection : Litho("litho-sections-processor")

    public object Core : Litho("litho-core-kotlin")

    public object CoreSelection : Litho("litho-sections-core")

    public object Fresco : Litho("litho-fresco-kotlin")

    public object Test : Litho("litho:litho-testing")

    public object Widget : Litho("litho-widget-kotlin")

    public object WidgetSelection : Litho("litho-sections-widget")
  }

  /**
   * json解析库
   * https://github.com/square/moshi
   */
  public sealed class MoShi(
    name: String
  ) : AndroidDependency("com.squareup.moshi", name, "1.12.0") {
    public object Compiler : MoShi("moshi-kotlin-codegen")

    public object Core : MoShi("moshi")
  }

  /**
   * Fragment导航库
   * https://developer.android.com/jetpack/androidx/releases/navigation
   */
  public sealed class Navigation(
    name: String
  ) : AndroidDependency("androidx.navigation", name, "2.3.5") {
    public object Core : Navigation("navigation-fragment-ktx")

    public object Features : Navigation("navigation-dynamic-features-fragment")

    public object Test : Navigation("navigation-testing")

    public object Ui : Navigation("navigation-ui-ktx")
  }

  /**
   * https://github.com/square/okhttp
   */
  public sealed class OkHttp(
    name: String
  ) : AndroidDependency("com.squareup.okhttp3", name, "4.9.1") {
    public object Core : OkHttp("okhttp")

    public object Interceptor : OkHttp("logging-interceptor")

    public object Mock : OkHttp("mockwebserver")
  }

  /**
   * https://github.com/airbnb/paris
   */
  public sealed class Paris(
    name: String
  ) : AndroidDependency("com.airbnb.android", name, "1.7.3") {
    public object Compiler : Paris("paris-processor")

    public object Core : Paris("paris")
  }

  /**
   * 网络请求
   * https://github.com/square/retrofit
   */
  public sealed class Retrofit(
    name: String
  ) : AndroidDependency("com.squareup.retrofit2", name, "2.9.0") {
    public object Core : Retrofit("retrofit")

    public object MoShi : Retrofit("converter-moshi")
  }

  /**
   * Sqlite数据库
   * https://developer.android.com/jetpack/androidx/releases/room
   */
  public sealed class Room(
    name: String
  ) : AndroidDependency("androidx.room", name, "2.3.0") {
    public object Compiler : Room("room-compiler")

    public object Core : Room("room-runtime")

    public object Ktx : Room("room-ktx")

    public object Test : Room("room-testing")
  }

  /**
   * 任务管理器
   * https://developer.android.com/jetpack/androidx/releases/work
   */
  public sealed class WorkManager(
    name: String
  ) : AndroidDependency("androidx.work", name, "2.5.0") {
    public object Core : WorkManager("work-runtime-ktx")

    public object Test : WorkManager("work-testing")
  }

  public object Test {
    /**
     * UI自动化测试
     * https://mvnrepository.com/artifact/androidx.test.espresso/espresso-core
     */
    public object Espresso : AndroidDependency("androidx.test.espresso", "espresso-core", "3.3.0")

    /**
     * 单元测试
     * https://mvnrepository.com/artifact/junit/junit
     */
    public object Junit : AndroidDependency("junit", "junit", "4.13.2")

    /**
     * 单元测试扩展
     * https://mvnrepository.com/artifact/androidx.test.ext/junit-ktx
     */
    public object JunitExt : AndroidDependency("androidx.test.ext", "junit-ktx", "1.1.2")
  }
}
