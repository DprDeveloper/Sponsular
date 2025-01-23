import com.sngular.sponsular.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class CrashlyticsConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager){
                apply("com.google.firebase.crashlytics")
                apply("com.google.gms.google-services")
            }

            dependencies {
                add("implementation",platform(libs.findLibrary("firebase-bom").get()))
                add("implementation",libs.findLibrary("firebase-crashlytics").get())
            }
        }
    }
}