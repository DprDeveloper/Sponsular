import com.diffplug.spotless.LineEnding.PLATFORM_NATIVE

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.android.spotless)
    alias(libs.plugins.android.detekt)
    alias(libs.plugins.android.hilt) apply false
    alias(libs.plugins.firebase.crashlytics) apply false
    alias(libs.plugins.google.gms.google.services) apply false
}

spotless {
    lineEndings = PLATFORM_NATIVE

    format("misc") {
        target("**/*.md", "**/.gitignore", "**/*.pro")
        targetExclude("**/build/**", ".idea/**", "/docs/public/**")

        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }

    format("xml") {
        target("**/*.xml")
        targetExclude("**/build/**", ".idea/**", "**/detekt-baseline.xml")

        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }

    format("yml") {
        target("**/*.yml", "**/*.yaml")

        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }

    format("toml") {
        target("**/*.toml")
        targetExclude("**/build/**", ".idea/**")

        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }

    kotlinGradle {
        target("**/*.gradle.kts")
        targetExclude("**/build/**")

        ktlint()
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }

    kotlin {
        target("**/*.kt", "**/*.kts")
        targetExclude("**/build/**", "**/*.gradle.kts")

        ktlint()
            .setEditorConfigPath(".editorconfig")
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }
}
