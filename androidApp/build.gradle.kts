plugins {
    id("com.android.application")
    kotlin("android")
/*
    kotlin("plugin.serialization")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
*/
}
val androidAppCompatVersion: String by project
val androidWorkRuntimeVersion: String by project
val kotlinxCoroutinesVersion: String by project
val kotlinxSerializationVersion: String by project
val navigationComposeVersion: String by project

val hiltAndroidGradlePluginVersion: String by project
val hiltNavigationComposeVersion: String by project
val composeVersion: String by project
val activityComposeVersion: String by project
val accompanistVersion: String by project
val composeMaterial3: String by project
val ktorVersion: String by project

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "fr.agbikossi.gotoesig.android"
        minSdk = 26
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
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
    implementation(project(":shared"))
   // implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    //Android
    implementation("androidx.appcompat:appcompat:$androidAppCompatVersion")

    //Navigation
    implementation("androidx.navigation:navigation-compose:$navigationComposeVersion")

    //Kotlin
   // implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
   // implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinxCoroutinesVersion")

    //Compose
     //Icons
    implementation ("androidx.compose.material:material-icons-extended:$composeVersion")

    implementation ("androidx.compose.ui:ui:$composeVersion")
    implementation ("androidx.compose.material:material:$composeVersion")
    implementation ("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.activity:activity-compose:$activityComposeVersion")
    implementation ("androidx.compose.material3:material3-window-size-class:$composeMaterial3")

/*
    implementation ("androidx.compose.runtime:runtime:$composeVersion")
    implementation ("androidx.compose.foundation:foundation-layout:$composeVersion")
    implementation ("androidx.compose.foundation:foundation:$composeVersion")
    implementation ("androidx.compose.animation:animation:$composeVersion")
    implementation ("androidx.compose.runtime:runtime-livedata:$composeVersion")
*/


    debugImplementation ("androidx.compose.ui:ui-tooling:$composeVersion")

    //Ktor
/*
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
    implementation("io.ktor:ktor-client-auth:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
*/

    //Hilt
/*
    implementation("com.google.dagger:hilt-android:$hiltAndroidGradlePluginVersion")
    implementation("androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltAndroidGradlePluginVersion")
*/

    //Accompanist
    implementation ("com.google.accompanist:accompanist-swiperefresh:$accompanistVersion")
    implementation ("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")

}