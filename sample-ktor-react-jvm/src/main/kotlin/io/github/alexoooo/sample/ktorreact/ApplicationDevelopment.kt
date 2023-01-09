package io.github.alexoooo.sample.ktorreact

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
    val jsFileName = "sample-ktor-react-js.js"
    val jsFile = jsDistDir.resolve(jsFileName).toFile()
    println("jsFile: $jsFile ${jsFile.exists()}")

    embeddedServer(
        Netty,
        port = 8080,
        host = "127.0.0.1",
        watchPaths = listOf(
            "classes",
            "resources"
        )
    ) {
        routing {
            get("/static/$jsFileName") {
                call.respondFile(jsFile)
            }
        }

        ktorMain()
    }.start(wait = true)
}