@file:Suppress("UnstableApiUsage")


plugins {
    id("org.gradle.toolchains.foojay-resolver") version "1.0.0"
}


rootProject.name = "sample-ktor-react"

include(
    "sample-ktor-react-common",
    "sample-ktor-react-js",
    "sample-ktor-react-jvm"
)


toolchainManagement {
    jvm {
        javaRepositories {
            repository("foojay") {
                resolverClass.set(org.gradle.toolchains.foojay.FoojayToolchainResolver::class.java)
            }
        }
    }
}


dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }

    versionCatalogs {
        create("kotlinWrappers") {
            val wrappersVersion = "2025.12.11"
            from("org.jetbrains.kotlin-wrappers:kotlin-wrappers-catalog:$wrappersVersion")
        }
    }
}