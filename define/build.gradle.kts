plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
	implementation("androidx.activity:activity-ktx:1.3.0-rc01")
	implementation("com.aliyun.ams:alicloud-android-push:3.3.0")
	implementation("com.blankj:utilcodex:1.30.6")
	implementation("androidx.appcompat:appcompat:1.3.0")
	implementation("com.github.JavaNoober.BackgroundLibrary:libraryx:1.7.2")
	implementation("io.coil-kt:coil:1.2.2")
	implementation("me.jorgecastillo:androidcolorx:0.2.0")
	implementation("com.github.loperSeven:DateTimePicker:0.3.2")
	implementation("com.ypx.yimagepicker:androidx:3.1.4")
	implementation("joda-time:joda-time:2.10.10")
	implementation("com.squareup.leakcanary:leakcanary-android:2.7")
	implementation("com.tencent:mmkv-static:1.2.10")
	implementation("com.permissionx.guolindev:permissionx:1.4.0")
	implementation("com.king.zxing:zxing-lite:2.0.3")
	implementation("com.facebook.soloader:soloader:0.10.1")
	implementation("com.dropbox.mobile.store:store4:4.0.1")
	implementation("com.tencent.mm.opensdk:wechat-sdk-android-without-mta:6.7.4")
	implementation("com.iqiyi.xcrash:xcrash-android-lib:3.0.0")
	

	implementation("com.github.qiushui95.MyArchitecture:architecture-constant:1.0.15")
	implementation("com.github.qiushui95.MyArchitecture:architecture-domain:1.0.15")
	implementation("com.github.qiushui95.MyArchitecture:architecture-domain-impl:1.0.15")
	implementation("com.github.qiushui95.MyArchitecture:architecture-entity:1.0.15")
	implementation("com.github.qiushui95.MyArchitecture:architecture-error:1.0.15")
	implementation("com.github.qiushui95.MyArchitecture:architecture-ext:1.0.15")
	implementation("com.github.qiushui95.MyArchitecture:architecture-flow-work:1.0.15")
	implementation("com.github.qiushui95.MyArchitecture:architecture-getter:1.0.15")
	implementation("com.github.qiushui95.MyArchitecture:architecture-http:1.0.15")
	implementation("com.github.qiushui95.MyArchitecture:architecture-initializer:1.0.15")
	implementation("com.github.qiushui95.MyArchitecture:architecture-model:1.0.15")
	implementation("com.github.qiushui95.MyArchitecture:architecture-starter:1.0.15")
	

	implementation("io.github.razerdp:BasePopup:3.1.6-SNAPSHOT")
	implementation("io.github.razerdp:BasePopup:3.1.4")
	

	implementation("androidx.camera:camera-camera2:1.0.0")
	implementation("androidx.camera:camera-core:1.0.0")
	implementation("androidx.camera:camera-extensions:1.0.0-alpha26")
	implementation("androidx.camera:camera-lifecycle:1.0.0")
	implementation("androidx.camera:camera-view:1.0.0-alpha26")
	

	debugImplementation("com.github.chuckerteam.chucker:library:3.5.0")
	releaseImplementation("com.github.chuckerteam.chucker:library-no-op:3.5.0")
	

	implementation("androidx.core:core-animation:1.0.0-alpha02")
	implementation("androidx.core:core-animation-testing:1.0.0-alpha02")
	implementation("androidx.core:core-ktx:1.6.0-rc01")
	implementation("androidx.core:core-role:1.0.0")
	

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.0")
	

	implementation("com.github.kongzue.DialogX:DialogX:0.0.37")
	kapt("com.arialyy.aria:compiler:3.8.15")
	implementation("com.arialyy.aria:core:3.8.15")
	implementation("com.arialyy.aria:ftpComponent:3.8.15")
	implementation("com.arialyy.aria:m3u8Component:3.8.15")
	implementation("com.arialyy.aria:sftpComponent:3.8.15")
	

	kapt("com.airbnb.android:epoxy-processor:4.6.2")
	implementation("com.airbnb.android:epoxy:4.6.2")
	implementation("com.airbnb.android:epoxy-glide-preloading:4.6.2")
	

	implementation("io.github.reactivecircus.flowbinding:flowbinding-activity:1.2.0")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-appcompat:1.2.0")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-android:1.2.0")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-core:1.2.0")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-drawerlayout:1.2.0")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-lifecycle:1.2.0")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-material:1.2.0")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-navigation:1.2.0")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-preference:1.2.0")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-recyclerview:1.2.0")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-swiperefreshlayout:1.2.0")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-viewpager2:1.2.0")
	

	implementation("androidx.fragment:fragment-ktx:1.3.5")
	testImplementation("androidx.fragment:fragment-testing:1.3.5")
	

	implementation("com.github.weikaiyun.SFragmentation:fragmentation:1.8.3")
	implementation("com.github.weikaiyun.SFragmentation:fragmentation_swipeback:1.8.3")
	

	implementation("com.github.bumptech.glide:annotations:4.12.0")
	kapt("com.github.bumptech.glide:compiler:4.12.0")
	implementation("com.github.bumptech.glide:glide:4.12.0")
	implementation("jp.co.cyberagent.android:gpuimage:2.1.0")
	implementation("com.github.bumptech.glide:okhttp3-integration:4.12.0")
	implementation("jp.wasabeef:glide-transformations:4.3.0")
	

	kapt("com.github.qiushui95.KeysCreator:compiler:1.1.0")
	implementation("com.github.qiushui95.KeysCreator:annotations:1.1.0")
	

	implementation("io.insert-koin:koin-android:3.1.2")
	implementation("io.insert-koin:koin-core:3.1.2")
	testImplementation("io.insert-koin:koin-test-junit5:3.1.2")
	implementation("io.insert-koin:koin-androidx-workmanager:3.1.2")
	

	implementation("io.insert-koin:koin-androidx-ext:2.2.3")
	implementation("io.insert-koin:koin-core-ext:2.2.3")
	implementation("io.insert-koin:koin-androidx-scope:2.2.3")
	testImplementation("io.insert-koin:koin-test:2.2.3")
	implementation("io.insert-koin:koin-androidx-viewmodel:2.2.3")
	

	implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.20")
	implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.20")
	

	implementation("androidx.lifecycle:lifecycle-common:2.3.1")
	implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
	implementation("androidx.lifecycle:lifecycle-process:2.3.1")
	implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
	implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.3.1")
	implementation("androidx.lifecycle:lifecycle-service:2.3.1")
	implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
	

	kapt("com.squareup.moshi:moshi-kotlin-codegen:1.12.0")
	implementation("com.squareup.moshi:moshi:1.12.0")
	

	implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
	implementation("androidx.navigation:navigation-dynamic-features-fragment:2.3.5")
	testImplementation("androidx.navigation:navigation-testing:2.3.5")
	implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
	

	implementation("com.squareup.okhttp3:okhttp:4.9.1")
	implementation("com.localebro:okhttpprofiler:1.0.8")
	androidTestImplementation("com.squareup.okhttp3:mockwebserver:4.9.1")
	

	kapt("com.airbnb.android:paris-processor:1.7.3")
	implementation("com.airbnb.android:paris:1.7.3")
	

	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
	

	kapt("androidx.room:room-compiler:2.3.0")
	implementation("androidx.room:room-runtime:2.3.0")
	implementation("androidx.room:room-ktx:2.3.0")
	testImplementation("androidx.room:room-testing:2.3.0")
	

	implementation("androidx.work:work-runtime-ktx:2.5.0")
	testImplementation("androidx.work:work-testing:2.5.0")
	

	

	implementation("com.github.Justson.AgentWeb:agentweb-core:v4.1.9-androidx")
	implementation("com.github.xiaohaibin:XBanner:androidx_v1.1.3")
	implementation("com.eightbitlab:blurview:1.6.6")
	implementation("com.ashokvarma.android:bottom-navigation-bar:2.2.0")
	implementation("androidx.constraintlayout:constraintlayout:2.0.4")
	implementation("com.github.KuangGang:RoundCorners:1.1.0")
	implementation("com.google.android:flexbox:2.0.1")
	implementation("me.dkzwm.widget.fet:core:0.2.0")
	implementation("com.airbnb.android:lottie:3.7.0")
	implementation("com.sunfusheng:MarqueeView:1.4.1")
	implementation("com.google.android.material:material:1.4.0")
	implementation("io.github.chaosleung:pinview:1.4.4")
	implementation("androidx.recyclerview:recyclerview:1.2.1")
	implementation("com.github.lihangleo2:ShadowLayout:3.2.0")
	implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01")
	implementation("com.kyleduo.switchbutton:library:2.1.0")
	implementation("androidx.viewpager2:viewpager2:1.1.0-alpha01")
	

	implementation("com.google.accompanist:accompanist-appcompat-theme:0.13.0")
	implementation("com.google.accompanist:accompanist-coil:0.13.0")
	implementation("com.google.accompanist:accompanist-flowlayout:0.13.0")
	implementation("com.google.accompanist:accompanist-insets:0.13.0")
	implementation("com.google.accompanist:accompanist-pager:0.13.0")
	implementation("com.google.accompanist:accompanist-swiperefresh:0.13.0")
	implementation("com.google.accompanist:accompanist-systemuicontroller:0.13.0")
	

	implementation("androidx.activity:activity-compose:1.3.0-rc01")
	implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha08")
	implementation("androidx.navigation:navigation-compose:2.4.0-alpha04")
	implementation("com.github.fornewid:material-motion-compose:0.5.1")
	implementation("androidx.compose.animation:animation:1.0.0-rc01")
	implementation("androidx.compose.compiler:compiler:1.0.0-rc01")
	implementation("androidx.compose.foundation:foundation:1.0.0-rc01")
	implementation("androidx.compose.runtime:runtime-livedata:1.0.0-rc01")
	implementation("androidx.compose.material:material:1.0.0-rc01")
	implementation("androidx.compose.material:material-icons-core:1.0.0-rc01")
	implementation("androidx.compose.material:material-icons-extended:1.0.0-rc01")
	androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.0-rc01")
	implementation("androidx.compose.ui:ui:1.0.0-rc01")
	implementation("androidx.compose.ui:ui-tooling:1.0.0-rc01")
	

	implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
	

	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
	testImplementation("junit:junit:4.13.2")
	testImplementation("androidx.test.ext:junit-ktx:1.1.3")
	

}