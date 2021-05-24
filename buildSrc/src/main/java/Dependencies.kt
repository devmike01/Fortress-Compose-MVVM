
object Versions {
    val lifecycle = "2.3.1"
    val junit ="4.13.2"
    val kotlin_stdlib = "1.4.32"
    val compose ="1.0.0-beta07"
    val room_version = "2.3.0"

}

object Libs{
    val deps = arrayOf(
        "org.jetbrains.kotlin:kotlin-stdlib:1.4.32",
        "androidx.core:core-ktx:1.3.2",
        "androidx.appcompat:appcompat:1.2.0",
        "com.google.android.material:material:1.3.0",
        "androidx.compose.foundation:foundation:${Versions.compose}",
        "androidx.activity:activity-compose:1.3.0-alpha07",
        "androidx.compose.ui:ui-tooling:${Versions.compose}",
        "androidx.compose.runtime:runtime:${Versions.compose}",
        "androidx.compose.compiler:compiler:${Versions.compose}",
        "androidx.compose.material:material:${Versions.compose}",
        "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}",
        "androidx.room:room-ktx:${Versions.room_version}"
        //"androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    )

    val testDeps = arrayOf( "junit:junit:${Versions.junit}", "androidx.room:room-testing:${Versions.room_version}")

    val androidTestDeps = arrayOf("androidx.test.espresso:espresso-core:3.3.0",
        "androidx.test.ext:junit:1.1.2")

    val kaptDeps = arrayOf("androidx.room:room-compiler:${Versions.room_version}")

}