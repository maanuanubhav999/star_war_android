import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.asraven.start_wars.build_logic"

// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
//        register("androidApplicationCompose") {
//            id = "nowinandroid.android.application.compose"
//            implementationClass = "AndroidApplicationComposeConventionPlugin"
//        }
//        register("androidApplication") {
//            id = "nowinandroid.android.application"
//            implementationClass = "AndroidApplicationConventionPlugin"
//        }
//
//        register("androidLibraryCompose") {
//            id = "nowinandroid.android.library.compose"
//            implementationClass = "AndroidLibraryComposeConventionPlugin"
//        }
//        register("androidLibrary") {
//            id = "nowinandroid.android.library"
//            implementationClass = "AndroidLibraryConventionPlugin"
//        }
//        register("androidFeature") {
//            id = "nowinandroid.android.feature"
//            implementationClass = "AndroidFeatureConventionPlugin"
//        }
//
//        }
        register("androidHilt") {
            id = "asraven.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidRoom") {
            id = "asraven.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }

    }
}
