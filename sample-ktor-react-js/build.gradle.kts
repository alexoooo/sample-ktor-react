import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig.Mode


plugins {
    id("org.jetbrains.kotlin.js")
}

//// https://gist.github.com/CameronProbert/85b7d60fa9572d93566f5c5ee62441e0
//
//val buildModeArg = (project.findProperty("buildMode") as String?)?.toUpperCase()
//val buildMode = when (buildModeArg) {
//    null, "DEBUG" -> DEVELOPMENT
//    "RELEASE" -> PRODUCTION
//    else -> throw Exception("Invalid buildMode: '$buildModeArg'. Expected 'DEBUG' or 'RELEASE'.")
//}
//
//val envTargetArg = (project.findProperty("envTarget") as String?)?.toUpperCase()
//val envTarget = when (envTargetArg) {
//    "DEV", "PROD" -> envTargetArg
//    null -> "DEV"
//    else -> throw Exception("Invalid envTarget: '$envTargetArg'. Expected 'DEV' or 'PROD'.")
//}
//
//logger.lifecycle("Building with buildMode = $buildMode and envTarget = $envTarget")

val devMode = properties.containsKey("jsWatch")

kotlin {
    js {
        useCommonJs()

        binaries.executable()

        browser {
            // https://discuss.kotlinlang.org/t/kotlin-js-gradle-webpack-arguments/21376
            // https://discuss.kotlinlang.org/t/kotlin-js-react-accessing-configuring-environment-variables/16906/9
            // https://github.com/webpack/webpack-cli/issues/1934

            val webpackMode =
                if (devMode) {
                    Mode.DEVELOPMENT
                }
                else {
                    Mode.PRODUCTION
                }

            commonWebpackConfig {
                mode = webpackMode
            }

//            webpackTask {
////                args += listOf("--mode", mode)
//                val additionalArgs = listOf("--mode", webpackMode.code)
////                args += additionalArgs
//                args.plusAssign(additionalArgs)
//                if (devMode) {
//                    println("!! js watch mode")
//                }
//            }
        }
    }
}


dependencies {
    implementation(project(":sample-ktor-react-common"))

    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:$kotlinReactVersion")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:$kotlinReactDomVersion")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion:$kotlinEmotionVersion")

    testImplementation(kotlin("test"))
}


run {
}
