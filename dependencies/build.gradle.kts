plugins {
//    id("com.android.library")
    id("kotlin")
    id("kotlin-kapt")
    id("com.github.dcendents.android-maven")
}

val kotlinVersion = "1.5.0"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    testImplementation("junit:junit:4.13.2")

    testImplementation("com.squareup.moshi:moshi:1.12.0")
    kaptTest("com.squareup.moshi:moshi-kotlin-codegen:1.12.0")

    testImplementation("com.squareup:kotlinpoet:1.8.0")

    testImplementation("com.google.code.gson:gson:2.8.6")
}