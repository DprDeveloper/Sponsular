import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    const val kotlinToolGradle = "com.android.tools.build:gradle:${Versions.kotlinToolGradle}"

    const val androidxCorektx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val androidxLifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
    const val androidxActivityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"

    const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val composeMaterial = "androidx.compose.material3:material3"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeRuntime = "androidx.compose.runtime:runtime"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
    const val composeUiTestJunit4 = "androidx.compose.ui:ui-test-junit4"
    const val composeMaterial3 = "androidx.compose.material3:material3"

    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverterJson = "com.squareup.retrofit2:converter-kotlinx-serialization:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serializationJson}"

    const val junit = "junit:junit:${Versions.junit}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.junitVersion}"
    const val androidxEspressoCore = "androidx.test.espresso:espresso-core:${Versions.junitVersion}"
}

fun DependencyHandler.core() {
    implementation(Dependencies.androidxCorektx)
    implementation(Dependencies.androidxLifecycleRuntimeKtx)
    implementation(Dependencies.androidxActivityCompose)
}

fun DependencyHandler.compose() {
    implementationPlatform(Dependencies.composeBom)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiTestManifest)
    implementation(Dependencies.composeUiTestJunit4)
    implementation(Dependencies.composeMaterial3)
    debugImplementation(Dependencies.composeUiToolingPreview)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitConverterJson)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
}

fun DependencyHandler.firebase() {
    implementationPlatform(Dependencies.firebaseBom)
    implementation(Dependencies.firebaseCrashlytics)
}

fun DependencyHandler.test() {
    test(Dependencies.junit)
    androidTest(Dependencies.androidxJunit)
    androidTest(Dependencies.androidxEspressoCore)
}

fun DependencyHandler.serializer() {
    implementation(Dependencies.serializationJson)
}
