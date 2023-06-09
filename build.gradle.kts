// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Dependency.Gradle.APPLICATION) version Versions.GRADLE apply false
    id(Dependency.Gradle.LIBRARY) version Versions.GRADLE apply false
    id(Dependency.Gradle.KOTLIN) version Versions.KOTLIN apply false
    id(Dependency.Gradle.HILT) version Versions.HILT apply false
}