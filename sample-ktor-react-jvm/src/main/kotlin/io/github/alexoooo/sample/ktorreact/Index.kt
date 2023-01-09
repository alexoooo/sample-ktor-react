package io.github.alexoooo.sample.ktorreact

import kotlinx.html.*


fun HTML.indexPage() {
    head {
        title("Hello from Ktor!")
    }
    body {
        div {
            +"Hello from Ktor - bbbb"
        }
        div {
            id = "root"
        }
        script(src = "/static/sample-ktor-react-js.js") {}
    }
}
