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
	implementation("androidx.activity:activity-ktx:+")
	implementation("com.aliyun.ams:alicloud-android-push:+")
	implementation("com.blankj:utilcodex:+")
	implementation("androidx.appcompat:appcompat:+")
	implementation("com.github.JavaNoober.BackgroundLibrary:libraryx:+")
	implementation("io.coil-kt:coil:+")
	implementation("me.jorgecastillo:androidcolorx:+")
	implementation("com.github.loperSeven:DateTimePicker:+")
	implementation("com.ypx.yimagepicker:androidx:+")
	implementation("joda-time:joda-time:+")
	implementation("com.squareup.leakcanary:leakcanary-android:+")
	implementation("com.tencent:mmkv-static:+")
	implementation("com.permissionx.guolindev:permissionx:+")
	implementation("com.king.zxing:zxing-lite:+")
	implementation("com.facebook.soloader:soloader:+")
	implementation("com.dropbox.mobile.store:store4:+")
	implementation("com.tencent.mm.opensdk:wechat-sdk-android-without-mta:+")
	implementation("com.iqiyi.xcrash:xcrash-android-lib:+")
	

	implementation("com.github.qiushui95.MyArchitecture:architecture-constant:+")
	implementation("com.github.qiushui95.MyArchitecture:architecture-domain:+")
	implementation("com.github.qiushui95.MyArchitecture:architecture-domain-impl:+")
	implementation("com.github.qiushui95.MyArchitecture:architecture-entity:+")
	implementation("com.github.qiushui95.MyArchitecture:architecture-error:+")
	implementation("com.github.qiushui95.MyArchitecture:architecture-ext:+")
	implementation("com.github.qiushui95.MyArchitecture:architecture-flow-work:+")
	implementation("com.github.qiushui95.MyArchitecture:architecture-getter:+")
	implementation("com.github.qiushui95.MyArchitecture:architecture-http:+")
	implementation("com.github.qiushui95.MyArchitecture:architecture-initializer:+")
	implementation("com.github.qiushui95.MyArchitecture:architecture-model:+")
	implementation("com.github.qiushui95.MyArchitecture:architecture-starter:+")
	

	implementation("io.github.razerdp:BasePopup:+")
	implementation("io.github.razerdp:BasePopup:+")
	

	implementation("androidx.camera:camera-camera2:+")
	implementation("androidx.camera:camera-core:+")
	implementation("androidx.camera:camera-extensions:+")
	implementation("androidx.camera:camera-lifecycle:+")
	implementation("androidx.camera:camera-view:+")
	

	debugImplementation("com.github.chuckerteam.chucker:library:+")
	releaseImplementation("com.github.chuckerteam.chucker:library-no-op:+")
	

	implementation("androidx.core:core-animation:+")
	implementation("androidx.core:core-animation-testing:+")
	implementation("androidx.core:core-ktx:+")
	implementation("androidx.core:core-role:+")
	

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:+")
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:+")
	

	implementation("com.github.kongzue.DialogX:DialogX:+")
	kapt("com.arialyy.aria:compiler:+")
	implementation("com.arialyy.aria:core:+")
	implementation("com.arialyy.aria:ftpComponent:+")
	implementation("com.arialyy.aria:m3u8Component:+")
	implementation("com.arialyy.aria:sftpComponent:+")
	

	kapt("com.airbnb.android:epoxy-processor:+")
	implementation("com.airbnb.android:epoxy:+")
	implementation("com.airbnb.android:epoxy-glide-preloading:+")
	

	implementation("io.github.reactivecircus.flowbinding:flowbinding-activity:+")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-appcompat:+")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-android:+")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-core:+")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-drawerlayout:+")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-lifecycle:+")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-material:+")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-navigation:+")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-preference:+")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-recyclerview:+")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-swiperefreshlayout:+")
	implementation("io.github.reactivecircus.flowbinding:flowbinding-viewpager2:+")
	

	implementation("androidx.fragment:fragment-ktx:+")
	testImplementation("androidx.fragment:fragment-testing:+")
	

	implementation("com.github.weikaiyun.SFragmentation:fragmentation:+")
	implementation("com.github.weikaiyun.SFragmentation:fragmentation_swipeback:+")
	

	implementation("com.github.bumptech.glide:annotations:+")
	kapt("com.github.bumptech.glide:compiler:+")
	implementation("com.github.bumptech.glide:glide:+")
	implementation("jp.co.cyberagent.android:gpuimage:+")
	implementation("com.github.bumptech.glide:okhttp3-integration:+")
	implementation("jp.wasabeef:glide-transformations:+")
	

	kapt("com.github.qiushui95.KeysCreator:compiler:+")
	implementation("com.github.qiushui95.KeysCreator:annotations:+")
	

	implementation("io.insert-koin:koin-android:+")
	implementation("io.insert-koin:koin-core:+")
	testImplementation("io.insert-koin:koin-test-junit5:+")
	implementation("io.insert-koin:koin-androidx-workmanager:+")
	

	implementation("io.insert-koin:koin-androidx-ext:+")
	implementation("io.insert-koin:koin-core-ext:+")
	implementation("io.insert-koin:koin-androidx-scope:+")
	testImplementation("io.insert-koin:koin-test:+")
	implementation("io.insert-koin:koin-androidx-viewmodel:+")
	

	implementation("org.jetbrains.kotlin:kotlin-reflect:+")
	implementation("org.jetbrains.kotlin:kotlin-stdlib:+")
	

	implementation("androidx.lifecycle:lifecycle-common:+")
	implementation("androidx.lifecycle:lifecycle-livedata-ktx:+")
	implementation("androidx.lifecycle:lifecycle-process:+")
	implementation("androidx.lifecycle:lifecycle-runtime-ktx:+")
	implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:+")
	implementation("androidx.lifecycle:lifecycle-service:+")
	implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:+")
	

	kapt("com.squareup.moshi:moshi-kotlin-codegen:+")
	implementation("com.squareup.moshi:moshi:+")
	

	implementation("androidx.navigation:navigation-fragment-ktx:+")
	implementation("androidx.navigation:navigation-dynamic-features-fragment:+")
	testImplementation("androidx.navigation:navigation-testing:+")
	implementation("androidx.navigation:navigation-ui-ktx:+")
	

	implementation("com.squareup.okhttp3:okhttp:+")
	implementation("com.localebro:okhttpprofiler:+")
	androidTestImplementation("com.squareup.okhttp3:mockwebserver:+")
	

	kapt("com.airbnb.android:paris-processor:+")
	implementation("com.airbnb.android:paris:+")
	

	implementation("com.squareup.retrofit2:retrofit:+")
	implementation("com.squareup.retrofit2:converter-moshi:+")
	

	kapt("androidx.room:room-compiler:+")
	implementation("androidx.room:room-runtime:+")
	implementation("androidx.room:room-ktx:+")
	testImplementation("androidx.room:room-testing:+")
	

	implementation("androidx.work:work-runtime-ktx:+")
	testImplementation("androidx.work:work-testing:+")
	

	

	implementation("com.github.Justson.AgentWeb:agentweb-core:+")
	implementation("com.github.xiaohaibin:XBanner:+")
	implementation("com.eightbitlab:blurview:+")
	implementation("com.ashokvarma.android:bottom-navigation-bar:+")
	implementation("androidx.constraintlayout:constraintlayout:+")
	implementation("com.github.KuangGang:RoundCorners:+")
	implementation("com.google.android:flexbox:+")
	implementation("me.dkzwm.widget.fet:core:+")
	implementation("com.airbnb.android:lottie:+")
	implementation("com.sunfusheng:MarqueeView:+")
	implementation("com.google.android.material:material:+")
	implementation("io.github.chaosleung:pinview:+")
	implementation("androidx.recyclerview:recyclerview:+")
	implementation("com.github.lihangleo2:ShadowLayout:+")
	implementation("androidx.swiperefreshlayout:swiperefreshlayout:+")
	implementation("com.kyleduo.switchbutton:library:+")
	implementation("androidx.viewpager2:viewpager2:+")
	

	implementation("com.google.accompanist:accompanist-appcompat-theme:+")
	implementation("com.google.accompanist:accompanist-coil:+")
	implementation("com.google.accompanist:accompanist-flowlayout:+")
	implementation("com.google.accompanist:accompanist-insets:+")
	implementation("com.google.accompanist:accompanist-pager:+")
	implementation("com.google.accompanist:accompanist-swiperefresh:+")
	implementation("com.google.accompanist:accompanist-systemuicontroller:+")
	

	implementation("androidx.activity:activity-compose:+")
	implementation("androidx.constraintlayout:constraintlayout-compose:+")
	implementation("androidx.navigation:navigation-compose:+")
	implementation("com.github.fornewid:material-motion-compose:+")
	implementation("androidx.compose.animation:animation:+")
	implementation("androidx.compose.compiler:compiler:+")
	implementation("androidx.compose.foundation:foundation:+")
	implementation("androidx.compose.runtime:runtime-livedata:+")
	implementation("androidx.compose.material:material:+")
	implementation("androidx.compose.material:material-icons-core:+")
	implementation("androidx.compose.material:material-icons-extended:+")
	androidTestImplementation("androidx.compose.ui:ui-test-junit4:+")
	implementation("androidx.compose.ui:ui:+")
	implementation("androidx.compose.ui:ui-tooling:+")
	

	implementation("androidx.lifecycle:lifecycle-viewmodel-compose:+")
	

	androidTestImplementation("androidx.test.espresso:espresso-core:+")
	testImplementation("junit:junit:+")
	testImplementation("androidx.test.ext:junit-ktx:+")
	

}