package io.github.alexoooo.sample.ktorreact

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import kotlinx.html.HTML


fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = "127.0.0.1",
//        watchPaths = listOf(
//            "classes",
//            "resources"
//        )
    ) {
        println("developmentMode: " + environment.developmentMode)

        routing {
            get("/") {
                call.respondHtml(HttpStatusCode.OK, HTML::indexPage)
            }
            static("/static") {
                resources("static")
            }
        }
    }.start(wait = true)
}