// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.7.3" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
}
buildscript {
    repositories {
        google() // Ensure google() repository is included
        mavenCentral()
    }
    dependencies {
        classpath (libs.gradle.v861) // or your version
        classpath (libs.kotlin.gradle.plugin)
    }
}

