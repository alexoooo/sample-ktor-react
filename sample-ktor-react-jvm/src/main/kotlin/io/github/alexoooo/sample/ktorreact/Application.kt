@file:Suppress("ConstPropertyName")

package io.github.alexoooo.sample.ktorreact

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.HTML


const val staticResourceName = "static"
const val staticResourcePath = "/$staticResourceName"
const val jsFileName = "sample-ktor-react-js.js"
const val jsResourcePath = "$staticResourcePath/$jsFileName"

private const val indexFileName = "index.html"
private const val indexFilePath = "/$indexFileName"


fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = "127.0.0.1"
    ) {
        ktorMain()
    }.start(wait = true)
}


fun Application.ktorMain() {
//    println("developmentMode: " + environment.developmentMode)

    routing {
        get("/") {
            call.respondRedirect(indexFileName)
        }
        get(indexFilePath) {
            call.respondHtml(HttpStatusCode.OK, HTML::indexPage)
        }
        static(staticResourcePath) {
            resources(staticResourceName)
        }
    }
}