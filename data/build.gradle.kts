import java.io.FileInputStream
import java.util.Properties

plugins {
    id("sponsular.android.library")
    id("sponsular.android.hilt")
    id("sponsular.android.retrofit")
    id("sponsular.android.serialization")
}

android {
    namespace = "com.sngular.data"

    defaultConfig {
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
}

dependencies {
    implementation(project(":domain"))
}
