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
	implementation("com.github.YummyLau:Anchors:+")
	implementation("com.blankj:utilcodex:+")
	implementation("androidx.appcompat:appcompat:+")
	implementation("com.noober.background:core:+")
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
	androidTestImplementation("androidx.test.espresso:espresso-core:+")
	testImplementation("junit:junit:+")
	testImplementation("androidx.test.ext:junit-ktx:+")
	implementation("io.github.razerdp:BasePopup_Candy:+")
	implementation("io.github.razerdp:BasePopup:+")
	

	debugImplementation("com.github.chuckerteam.chucker:library:+")
	releaseImplementation("com.github.chuckerteam.chucker:library-no-op:+")
	

	kapt("com.github.xiaojinzi123.Component:component-compiler:+")
	implementation("com.github.xiaojinzi123.Component:component-impl:+")
	implementation("com.github.xiaojinzi123.Component:component-plugin:+")
	

	implementation("androidx.core:core-animation:+")
	implementation("androidx.core:core-animation-testing:+")
	implementation("androidx.core:core-ktx:+")
	implementation("androidx.core:core-role:+")
	

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:+")
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:+")
	

	implementation("com.github.kongzue.DialogX:DialogX:+")
	implementation("com.kongzue.dialogx.style.ios:DialogXIOSStyle:+")
	implementation("com.kongzue.dialogx.style.kongzue:DialogXKongzueStyle:+")
	implementation("com.kongzue.dialogx.style.miui:DialogXMIUIStyle:+")
	

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
	implementation("com.github.terrakok:cicerone:+")
	testImplementation("androidx.fragment:fragment-testing:+")
	

	implementation("com.github.bumptech.glide:annotations:+")
	kapt("com.github.bumptech.glide:compiler:+")
	implementation("com.github.bumptech.glide:glide:+")
	implementation("jp.co.cyberagent.android:gpuimage:+")
	implementation("com.github.bumptech.glide:okhttp3-integration:+")
	implementation("jp.wasabeef:glide-transformations:+")
	

	kapt("com.github.qiushui95.KeysCreator:compiler:+")
	implementation("com.github.qiushui95.KeysCreator:annotations:+")
	

	implementation("org.koin:koin-core:+")
	implementation("org.koin:koin-androidx-ext:+")
	implementation("org.koin:koin-androidx-scope:+")
	testImplementation("org.koin:koin-test:+")
	implementation("org.koin:koin-androidx-viewmodel:+")
	

	implementation("org.jetbrains.kotlin:kotlin-reflect:+")
	implementation("org.jetbrains.kotlin:kotlin-stdlib:+")
	

	implementation("androidx.lifecycle:lifecycle-common:+")
	implementation("androidx.lifecycle:lifecycle-livedata-ktx:+")
	implementation("androidx.lifecycle:lifecycle-process:+")
	implementation("androidx.lifecycle:lifecycle-runtime-ktx:+")
	implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:+")
	implementation("androidx.lifecycle:lifecycle-service:+")
	implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:+")
	

	implementation("com.facebook.litho:litho-sections-annotations:+")
	kapt("com.facebook.litho:litho-sections-processor:+")
	implementation("com.facebook.litho:litho-core-kotlin:+")
	implementation("com.facebook.litho:litho-sections-core:+")
	implementation("com.facebook.litho:litho-fresco-kotlin:+")
	implementation("com.facebook.litho:litho:litho-testing:+")
	implementation("com.facebook.litho:litho-widget-kotlin:+")
	implementation("com.facebook.litho:litho-sections-widget:+")
	

	kapt("com.squareup.moshi:moshi-kotlin-codegen:+")
	implementation("com.squareup.moshi:moshi:+")
	

	implementation("androidx.navigation:navigation-fragment-ktx:+")
	implementation("androidx.navigation:navigation-dynamic-features-fragment:+")
	testImplementation("androidx.navigation:navigation-testing:+")
	implementation("androidx.navigation:navigation-ui-ktx:+")
	

	implementation("com.squareup.okhttp3:okhttp:+")
	implementation("com.squareup.okhttp3:logging-interceptor:+")
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
	

}