import com.diffplug.spotless.LineEnding.PLATFORM_NATIVE

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.kotlinSerialization) version Versions.kotlinSerialization
    id(Plugins.spotless) version Versions.spotless
    id(Plugins.detekt) version Versions.detekt
    id(Plugins.hilt) version Versions.hilt apply false
    id(Plugins.firebaseCrashlytics) version Versions.firebaseCrashlytics apply false
    id(Plugins.gmsGoogleService)version Versions.gmsGoogleService apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependencies.hiltAgp)
    }
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
