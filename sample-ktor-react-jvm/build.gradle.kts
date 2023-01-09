@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm")
}


kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(jvmToolchainVersion))
    }
}


tasks.compileJava {
    options.release.set(javaVersion)
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
//    println("^^^^ properties: " + properties.keys.toList().sorted())
    if (properties.containsKey("skipJsToJvm")) {
        println("! skip copy browserProductionWebpack to /static resources")
        return@withType
    }

    val jsProject = project(":sample-ktor-react-js")
    val task = jsProject.tasks.getByName("browserProductionWebpack") as org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack

    from(task.destinationDirectory) {
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
