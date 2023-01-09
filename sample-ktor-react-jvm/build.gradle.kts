//import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
//import org.springframework.boot.gradle.tasks.bundling.BootJar


plugins {
//    id("org.springframework.boot") version springBootVersion
//    id("io.spring.dependency-management") version dependencyManagementVersion
    kotlin("jvm")
//    kotlin("plugin.spring") version kotlinVersion
}


kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(jvmToolchainVersion))
    }
}


dependencies {
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
//    implementation("org.jetbrains.kotlin-wrappers:kotlin-css-jvm:1.0.0-$wrapperKotlinVersion")
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")

    implementation(project(":sample-ktor-react-common"))

//    implementation("org.springframework.boot:spring-boot-starter-webflux")

    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:$kotlinxHtmlVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-html-builder-jvm:$ktorVersion")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

//    implementation("io.github.alexoooo.sample.lib:lib-common-jvm:$libVersion")
//    implementation("io.github.alexoooo.sample.lib:lib-jvm:$libVersion")
//
//    implementation("com.github.andrewoma.dexx:collection:$dexxVersion")
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

tasks.compileJava {
    options.release.set(javaVersion)
}


//tasks.register<ProcessResources>("copyBrowserProductionWebpack") {
//    val jsProject = project(":sample-ktor-react-js")
//    val task = jsProject.tasks.getByName("browserProductionWebpack") as org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack
//
//    from(task.destinationDirectory) {
//        into("static")
//    }
//
//    dependsOn(task)
//}

