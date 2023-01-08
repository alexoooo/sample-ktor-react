//pluginManagement {
//    resolutionStrategy {
//        eachPlugin {
//            if (requested.id.id == "kotlinx-serialization") {
//                useModule("org.jetbrains.kotlin:kotlin-serialization:${requested.version}")
//            }
//        }
//    }
//
//    repositories {
//        mavenCentral()
//        gradlePluginPortal()
//    }
//}

rootProject.name = "sample-ktor-react"

include(
    "sample-ktor-react-common",
    "sample-ktor-react-js",
    "sample-ktor-react-jvm"
)