@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm")
    id("io.ktor.plugin") version ktorVersion
}


kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(jvmToolchainVersion))
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
    val task = jsProject.tasks.getByName("browserProductionWebpack") as org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack

    from(task.destinationDirectory) {
        // NB: referenced in webserver application resources
        into("static")
    }

    dependsOn(task)
}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = jvmTargetVersion
    }
}
