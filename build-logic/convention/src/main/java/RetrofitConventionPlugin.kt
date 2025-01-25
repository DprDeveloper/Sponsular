import com.sngular.sponsular.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class RetrofitConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                add("implementation",libs.findLibrary("retrofit").get())
                add("implementation",libs.findLibrary("retrofit-converter-json").get())
                add("implementation",libs.findLibrary("okhttp3").get())
                add("implementation",libs.findLibrary("okhttp3-interceptor-logging").get())
            }
        }
    }
}