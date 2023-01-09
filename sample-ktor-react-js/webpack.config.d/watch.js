// https://stackoverflow.com/questions/61009367/how-to-make-ktor-reload-js-changes-at-runtime
// https://discuss.kotlinlang.org/t/webpack-watch-in-ktor-js-project/18428/5
//config.watch = false;
//config.watch = true;
//config.watch = (env.watch || false);

const productionMode = config.mode === "production";
config.watch = ! productionMode;
//config.watch = true;


