import java.io.FileInputStream
import java.util.Properties

plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.hilt)
    kotlin("kapt")
    id(Plugins.kotlinSerialization)
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":domain"))

    core()
    retrofit()
    hilt()
    serializer()
    test()
}
