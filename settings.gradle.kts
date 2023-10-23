@file:Suppress("UnstableApiUsage")


plugins {
    id("org.gradle.toolchains.foojay-resolver") version "0.7.0"
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