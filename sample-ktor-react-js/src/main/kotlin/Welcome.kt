import csstype.px
import csstype.rgb
import emotion.react.css
import js.core.Object.Companion.assign
import js.core.jso
import react.*
import react.dom.html.InputType
import react.dom.html.ReactHTML.br
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input

external interface WelcomeProps : Props {
    var name: String
}

val Welcome = FC<WelcomeProps> { props ->
    var name by useState(props.name)
    div {
        css {
            padding = 5.px
            backgroundColor = rgb(8, 97, 22)
            color = rgb(56, 246, 137)
        }
        +"Hello, $name! - qqqqq"
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


abstract class RComponent<P : Props, S : State> : Component<P, S> {
    constructor() : super() {
        state = jso { init() }
    }

    constructor(props: P) : super(props) {
        state = jso { init(props) }
    }

    open fun S.init() {}

    // if you use this method, don't forget to pass props to the constructor first
    open fun S.init(props: P) {}

    abstract fun ChildrenBuilder.render()

    override fun render(): ReactNode = Fragment.create { render() }
}

fun <S : State> Component<*, S>.setState(buildState: S.() -> Unit) {
    setState({ assign(it, buildState) })
}


abstract class RPureComponent<P : Props, S : State> : PureComponent<P, S> {
    constructor() : super() {
        state = jso { init() }
    }

    constructor(props: P) : super(props) {
        state = jso { init(props) }
    }

    open fun S.init() {}

    // if you use this method, don't forget to pass props to the constructor first
    open fun S.init(props: P) {}

    abstract fun ChildrenBuilder.render()

    override fun render(): ReactNode = Fragment.create { render() }
}


fun <S : State> PureComponent<*, S>.setState(buildState: S.() -> Unit) {
    setState({ assign(it, buildState) })
}


class TestComponent : RComponent<Props, State>() {
    override fun ChildrenBuilder.render() {
        div {
            +"Hello, world!"
        }
    }
}
