plugins {
    id("sponsular.android.library")
    id("sponsular.android.serialization")
    id("sponsular.android.compose")
}

android {
    namespace = "com.sngular.presentation"
}

dependencies {
    implementation(project(":data"))
}
