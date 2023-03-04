# sample-ktor-react

Example of Ktor on the backend with React on the frontend.
Supports auto-reload on JVM backend and browser frontend, as well as building a deployable jar.
Works with JavaScript IR (kotlin.js.compiler=ir).

To auto-reload backend:
1) Run `io.github.alexoooo.sample.ktorreact.dev.BackendDevelopment` from IDE
2) Run `./gradlew -t :sample-ktor-react-jvm:classes` from CLI

To auto-reload frontend:
1) Run `io.github.alexoooo.sample.ktorreact.dev.FrontendDevelopment` from IDE
2) Run `./gradlew -t :sample-ktor-react-js:build -x test -PjsWatch` from CLI

To build self-contained jar and executable it from CLI:
1) Run `./gradlew buildFatJar`
2) Run `java -jar sample-ktor-react-jvm/build/libs/sample-ktor-react-jvm-all.jar`
