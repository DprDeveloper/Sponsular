import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dependency: String){
    add("implementation", dependency)
}

fun DependencyHandler.implementationPlatform(dependency: String){
    add("implementation", platform(dependency))
}

fun DependencyHandler.test(dependency: String){
    add("testImplementation", dependency)
}

fun DependencyHandler.androidTest(dependency: String){
    add("androidTestImplementation", dependency)
}

fun DependencyHandler.debugImplementation(dependency: String){
    add("debugImplementation", dependency)
}

fun DependencyHandler.kapt(dependency: String){
    add("kapt", dependency)
}
