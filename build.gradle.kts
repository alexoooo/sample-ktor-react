plugins {
    kotlin("multiplatform") version kotlinVersion apply false
}

allprojects {
    group = "io.github.alexoooo.sample.ktorreact"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenLocal()
        mavenCentral()
    }
}
