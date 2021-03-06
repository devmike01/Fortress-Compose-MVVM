
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven ( url ="https://jitpack.io")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.0")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinStdlib}")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven(url ="https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

