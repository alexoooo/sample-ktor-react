package io.github.alexoooo.sample.ktorreact

import csstype.NamedColor
import csstype.em
import csstype.px
import csstype.rgb
import emotion.react.css
import js.core.jso
import mui.material.Card
import mui.material.CardContent
import mui.material.Typography
import mui.material.styles.TypographyVariant
import react.*
import web.html.InputType
import react.dom.html.ReactHTML.br
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import web.html.HTMLElement


external interface WelcomeProps : Props {
    var name: String
}


val Welcome = FC<WelcomeProps> { props ->
    var name by useState(props.name)

    Card {
        style = jso {
            backgroundColor = NamedColor.blue
            margin = 1.em
        }

        CardContent {
            Typography {
                variant = TypographyVariant.h5
                +"Foo bar baz"
            }
        }
    }

    div {
        css {
            padding = 5.px
            backgroundColor = rgb(8, 97, 22)
            color = rgb(56, 246, 137)
        }
        +"Hello, $name!"
        br {}

        TestComponent::class.react {}
    }
    input {
        css {
            marginTop = 5.px
            marginBottom = 5.px
            fontSize = 14.px
        }
        type = InputType.text
        value = name
        onChange = { event ->
            name = event.target.value
        }
    }
}


class TestComponent : RPureComponent<Props, State>() {
    private var inputRef: RefObject<HTMLElement> = createRef()

    override fun ChildrenBuilder.render() {
        div {
            +"Hello, world!"

            input {
                ref = inputRef
            }
            button {
                onClick = {
                    inputRef.current?.focus()
                }
                +"Focus the input"
            }
        }
    }
}
