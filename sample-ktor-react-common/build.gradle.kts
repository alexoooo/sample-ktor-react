plugins {
    kotlin("multiplatform")
//    id("kotlinx-serialization")
}


kotlin {
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
        @Suppress("UNUSED_VARIABLE")
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-css:$kotlinCssVersion")
//                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")
//                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
//
//                implementation("io.github.alexoooo.sample.lib:lib-common:$libVersion")
            }
        }

//        @Suppress("UNUSED_VARIABLE")
//        val commonTest by getting {
//            dependencies {
//                implementation(kotlin("test-common"))
//                implementation(kotlin("test-annotations-common"))
//            }
//        }


//        @Suppress("UNUSED_VARIABLE")
//        val jvmMain by getting {
//            dependencies {
//                implementation("ch.qos.logback:logback-classic:$logbackVersion")
////                implementation("org.jetbrains.kotlin-wrappers:kotlin-css-jvm:$kotlinxCssVersion")
////                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")
////                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")
//                implementation("io.github.alexoooo.sample.lib:lib-common-jvm:$libVersion")
//            }
//        }
//
//        @Suppress("UNUSED_VARIABLE")
//        val jvmTest by getting {
//            dependencies {
//                implementation(kotlin("test"))
//                implementation(kotlin("test-junit"))
//            }
//        }
//
//
//        @Suppress("UNUSED_VARIABLE")
//        val jsMain by getting {
//            dependencies {
//                // NB: seems to be required for IntelliJ IDEA 2020.2.2, but compiles from gradle without it
//                implementation(kotlin("stdlib-js"))
//
////                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:$serializationVersion")
//                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")
//                implementation("io.github.alexoooo.sample.lib:lib-common-js:$libVersion")
//                implementation(npm("immutable", immutaleJsVersion))
//            }
//        }
//
//        @Suppress("UNUSED_VARIABLE")
//        val jsTest by getting {
//            dependencies {
//                implementation(kotlin("test-js"))
//            }
//        }
    }
}