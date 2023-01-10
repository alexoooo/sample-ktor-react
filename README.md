# sample-ktor-react

To auto-reload backend:
1) Run `io.github.alexoooo.sample.ktorreact.dev.BackendDevelopment` from IDE
2) Run `./gradlew -t :sample-ktor-react-jvm:classes` from CLI

To auto-reload frontend:
1) Run `io.github.alexoooo.sample.ktorreact.dev.FrontendDevelopment` from IDE
2) Run `./gradlew -t :sample-ktor-react-js:build -x test -PjsWatch` from CLI


