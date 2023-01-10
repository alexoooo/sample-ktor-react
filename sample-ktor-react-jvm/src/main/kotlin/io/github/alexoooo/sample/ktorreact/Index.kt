package io.github.alexoooo.sample.ktorreact

import kotlinx.html.*


fun HTML.indexPage() {
    head {
        title("Sample : Ktor + React")
        meta {
            charset = "UTF-8"
        }
        script(src = jsResourcePath) {
            defer = true
        }
    }
    body {
        div {
            id = rootHtmlElementId
            +"Loading..."
        }
    }
}
