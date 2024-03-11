package io.github.alexoooo.sample.ktorreact

import emotion.react.css
import js.objects.jso
import mui.material.*
import mui.material.styles.TypographyVariant
import mui.system.sx
import react.*
import web.html.InputType
import react.dom.html.ReactHTML.br
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.dom.onChange
import web.cssom.NamedColor
import web.cssom.em
import web.cssom.px
import web.cssom.rgb
import web.html.HTMLElement
import web.html.HTMLInputElement
import web.html.HTMLTextAreaElement


external interface WelcomeProps : Props {
    var name: String
}

external interface WelcomeState : State {
    var name: String
}

val Welcome = FC<WelcomeProps> { props ->
    var name by useState(props.name)

    Card {
        style = jso {
            backgroundColor = NamedColor.yellow
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

    val multilineOverride = true
    TextField  {
        fullWidth = true
        multiline = multilineOverride
        size = Size.small

        label = ReactNode("Foo")
        value = name

        sx {
            marginTop = 1.em
        }

        onChange = {
            val value =
                if (multilineOverride) {
                    (it.target as HTMLTextAreaElement).value
                }
                else {
                    (it.target as HTMLInputElement).value
                }
            name = value
        }
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


class TestComponent : RPureComponent<Props, WelcomeState>() {
    private var inputRef: RefObject<HTMLElement> = createRef()


    override fun WelcomeState.init() {
        name = "bar"
    }

    override fun ChildrenBuilder.render() {
        div {
            +"Hello, world!"

            input {
                ref = inputRef
                value = state.name
                onChange = {
                    setState {
                        name = it.target.value
                    }
                }
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
