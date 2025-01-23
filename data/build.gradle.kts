import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.android.hilt)
    kotlin("kapt")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.sngular.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val localProperties: Properties =
            Properties().apply {
                load(FileInputStream(File(rootProject.rootDir, "local.properties")))
            }

        buildConfigField(
            "String",
            "API_BASE_URL",
            localProperties.getProperty("SPOTIFY_BASE_URL") ?: "",
        )
        buildConfigField(
            "String",
            "API_BASE_URL_TOKEN",
            localProperties.getProperty("SPOTIFY_BASE_URL_TOKEN") ?: "",
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {

    implementation(project(":domain"))

    implementation(libs.androidx.core.ktx)

    //Network
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.json)
    implementation(libs.okhttp3)
    implementation(libs.okhttp3.interceptor.logging)

    //Hilt
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    //Json serializer
    implementation(libs.serialization.json)

    //testing Pruebas
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
