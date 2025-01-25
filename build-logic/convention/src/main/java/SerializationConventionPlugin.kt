import com.sngular.sponsular.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class SerializationConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager){
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            dependencies {
                add("implementation",libs.findLibrary("serialization-json").get())
            }
        }
    }
}