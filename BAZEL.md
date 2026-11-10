# Bazel parser target

`bazel build //:eug_parser` compiles the EUG save-file parser and its shared
model with Bazel 8.7.0 and a pinned remote JDK 21 runtime. The Java source
level is 17, matching Gradle. `bazel test //...` runs a save-file parsing
test. The parser's `eug.shared` and `eug.parser` packages reference each
other, so they form one Bazel library.

The JavaFX application and its Gradle commands remain in `build.gradle`.
Their JavaFX, Gson, and bundled Super CSV dependencies are outside this
parser-only target. The test target uses Bazel's Java launcher and executes
an assertion-bearing `main` method rather than JUnit, so it needs no
additional test dependency.
