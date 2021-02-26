plugins {
//    id("com.android.library")
    id("kotlin")
    id("kotlin-kapt")
    id("com.github.dcendents.android-maven")
}

val kotlinVersion = "1.4.31"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.squareup.moshi:moshi:1.11.0")
    kapt("com.squareup.moshi:moshi:1.11.0")
    testImplementation("com.squareup:kotlinpoet:1.7.2")
}