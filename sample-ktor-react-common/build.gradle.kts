plugins {
    kotlin("multiplatform")
//    id("kotlinx-serialization")
}


kotlin {
//    jvmToolchain {
//        languageVersion.set(JavaLanguageVersion.of(jvmToolchainVersion))
//    }


    jvm {}

    js {
        browser {
//            testTask {
//                testLogging {
//                    showExceptions = true
//                    exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
//                    showCauses = true
//                    showStackTraces = true
//                }
//            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(kotlin("test"))
        }

        jsMain.dependencies {
            // NB: stdlib should be included automatically, not sure why it's necessary to do it explicitly here (Kotlin 2.0.0 / Gradle 8.8)
            implementation(kotlin("stdlib-js"))
        }
    }
}