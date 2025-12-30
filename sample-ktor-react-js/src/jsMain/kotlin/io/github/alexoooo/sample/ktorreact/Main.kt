package io.github.alexoooo.sample.ktorreact

import react.create
import react.dom.client.createRoot
import web.dom.ElementId
import web.dom.document


fun main() {
    val rootElement = document.getElementById(ElementId(rootHtmlElementId))
        ?: throw IllegalStateException("'$rootHtmlElementId' element not found")

    // https://stackoverflow.com/questions/3450593/how-do-i-clear-the-content-of-a-div-using-javascript
    while (rootElement.hasChildNodes()) {
        rootElement.removeChild(rootElement.firstChild!!)
    }

    val welcome = Welcome.create {
        name = "Ktor + React"
    }

    createRoot(rootElement).render(welcome)
}
