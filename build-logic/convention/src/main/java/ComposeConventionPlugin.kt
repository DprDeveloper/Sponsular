import com.android.build.api.dsl.LibraryExtension
import com.sngular.sponsular.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class ComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager){
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            dependencies {

                add("implementation",platform(libs.findLibrary("androidx-compose-bom").get()))
                add("implementation",libs.findLibrary("androidx-activity-compose").get())
                add("implementation",libs.findLibrary("androidx-ui").get())
                add("implementation",libs.findLibrary("androidx-ui-graphics").get())
                add("implementation",libs.findLibrary("androidx-ui-tooling-preview").get())
                add("implementation", libs.findLibrary("androidx.material3").get())
                add("implementation", libs.findLibrary("androidx-navigation-compose").get())

                add("androidTestImplementation",platform(libs.findLibrary("androidx-compose-bom").get()))
                add("androidTestImplementation",libs.findLibrary("androidx-ui-test-junit4").get())

                add("debugImplementation",libs.findLibrary("androidx-ui-tooling").get())
                add("debugImplementation",libs.findLibrary("androidx-ui-test-manifest").get())
            }
        }
    }
}