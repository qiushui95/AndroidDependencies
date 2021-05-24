import org.gradle.jvm.tasks.Jar

plugins {
//    id("com.android.library")
    id("kotlin")
    id("kotlin-kapt")
    id("maven")
}

group = "com.github.qiushui95"
setProperty("archivesBaseName", "AndroidDependencies")
version = "1.4.24"

tasks.register("sourcesJar", Jar::class) {
    dependsOn("classes")
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}


artifacts.archives(tasks.getByName("sourcesJar"))

dependencies {

    testImplementation("junit:junit:4.13.2")

    testImplementation("com.squareup.moshi:moshi:1.12.0")
    kaptTest("com.squareup.moshi:moshi-kotlin-codegen:1.12.0")

    testImplementation("com.squareup:kotlinpoet:1.8.0")

    testImplementation("com.google.code.gson:gson:2.8.6")
}