buildscript {
    val kotlinVersion: String by project
    //val hiltAndroidGradlePluginVersion: String by project
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
//        classpath(kotlin("serialization", version = kotlinVersion))
/*
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltAndroidGradlePluginVersion")
*/
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
        classpath("com.android.tools.build:gradle:7.2.1")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}