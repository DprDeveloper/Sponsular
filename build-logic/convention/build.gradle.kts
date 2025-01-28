import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.sngular.sponsular.build_logic"


java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "sponsular.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "sponsular.android.library"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidHilt") {
            id = "sponsular.android.hilt"
            implementationClass = "HiltConventionPlugin"
        }
        register("androidCrashlytics") {
            id = "sponsular.android.crashlytics"
            implementationClass = "CrashlyticsConventionPlugin"
        }
        register("androidCompose") {
            id = "sponsular.android.compose"
            implementationClass = "ComposeConventionPlugin"
        }
        register("androidRetrofit") {
            id = "sponsular.android.retrofit"
            implementationClass = "RetrofitConventionPlugin"
        }
        register("androidSerialization") {
            id = "sponsular.android.serialization"
            implementationClass = "SerializationConventionPlugin"
        }
    }
}