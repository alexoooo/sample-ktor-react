package io.github.alexoooo.sample.ktorreact.dev

import io.github.alexoooo.sample.ktorreact.jsFileName
import io.github.alexoooo.sample.ktorreact.jsResourcePath
import io.github.alexoooo.sample.ktorreact.ktorMain
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.nio.file.Path


fun main() {
    System.setProperty("io.ktor.development", "true")

    val projectBaseDir = Path.of(".").toAbsolutePath().normalize()
    val jsDistDir = projectBaseDir.resolve("sample-ktor-react-js/build/distributions")
    val jsFile = jsDistDir.resolve(jsFileName).toFile()
    println("Auto-reload js file (exists = ${jsFile.exists()}): $jsFile")

    embeddedServer(
        Netty,
        port = 8080,
        host = "127.0.0.1"
    ) {
        routing {
            get(jsResourcePath) {
                call.respondFile(jsFile)
            }
        }

        ktorMain()
    }.start(wait = true)
}