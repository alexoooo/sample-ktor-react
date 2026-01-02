import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig.Mode
import org.jetbrains.kotlin.gradle.targets.js.yarn.yarn


plugins {
    kotlin("multiplatform")
}


val devMode = properties.containsKey("jsWatch")


kotlin {
    js {
        useCommonJs()

        binaries.executable()

        browser {
            // https://discuss.kotlinlang.org/t/kotlin-js-gradle-webpack-arguments/21376
            // https://discuss.kotlinlang.org/t/kotlin-js-react-accessing-configuring-environment-variables/16906/9
            // https://github.com/ktorio/ktor/issues/975
            // https://stackoverflow.com/questions/72256084/how-to-enable-development-mode-in-embedded-server-to-use-auto-reload-in-ktor

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
        }
    }

    sourceSets {
        jsMain.dependencies {
            implementation(kotlin("stdlib-js"))
            implementation(project(":sample-ktor-react-common"))

            implementation(kotlinWrappers.react)
            implementation(kotlinWrappers.reactLegacy)
            implementation(kotlinWrappers.reactDom)
            implementation(kotlinWrappers.emotion.styled)
            implementation(kotlinWrappers.mui.material)
        }

        jsTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}


run {}


// https://youtrack.jetbrains.com/issue/KT-52578/KJS-Gradle-KotlinNpmInstallTask-gradle-task-produces-unsolvable-warning-ignored-scripts-due-to-flag.
yarn.ignoreScripts = false