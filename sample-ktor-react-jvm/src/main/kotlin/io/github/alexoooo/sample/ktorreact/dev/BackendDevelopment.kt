package io.github.alexoooo.sample.ktorreact.dev

import io.github.alexoooo.sample.ktorreact.ktorMain
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main() {
    System.setProperty("io.ktor.development", "true")

    embeddedServer(
        Netty,
        port = 8080,
        host = "127.0.0.1",
        watchPaths = listOf(
            "classes",
            "resources")
    ) {
        ktorMain()
    }.start(wait = true)
}