import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig.Mode


plugins {
    id("org.jetbrains.kotlin.js")
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
}


dependencies {
    implementation(project(":sample-ktor-react-common"))

    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:$kotlinReactVersion")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:$kotlinReactDomVersion")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion:$kotlinEmotionVersion")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-mui:$kotlinMuiVersion")

    testImplementation(kotlin("test"))
}


run {
}
