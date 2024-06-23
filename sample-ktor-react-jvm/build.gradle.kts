@file:Suppress("UnstableApiUsage")
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm")
    id("io.ktor.plugin") version ktorVersion
}


kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(jvmToolchainVersion))
    }
    compilerOptions {
        jvmTarget.set(JvmTarget.fromTarget(jvmTargetVersion))
    }
}


tasks.compileJava {
    options.release.set(javaVersion)
}


application {
    mainClass.set("io.github.alexoooo.sample.ktorreact.ApplicationKt")
}


dependencies {
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    implementation(project(":sample-ktor-react-common"))


    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:$kotlinxHtmlVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-html-builder-jvm:$ktorVersion")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}


tasks.withType<ProcessResources> {
    val jsProject = project(":sample-ktor-react-js")

    val browserDistributionTask = jsProject.tasks.getByName("jsBrowserDistribution")
    dependsOn(browserDistributionTask)

    val task = jsProject.tasks.getByName("jsBrowserProductionWebpack") as KotlinWebpack
    dependsOn(task)

    from(task.outputDirectory) {
        // NB: referenced in webserver application resources
        into("static")
    }
}