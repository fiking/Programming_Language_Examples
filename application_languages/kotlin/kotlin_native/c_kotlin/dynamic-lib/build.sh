set -x
KONAN_HOME=/Users/bytedance/tools/kotlin-native-prebuilt-macos-aarch64-2.1.0
PATH=$KONAN_HOME/bin:$PATH

# 编译命令：生成名为libkotlinlib.a的静态库
konanc kotlin_lib.kt \
  -produce dynamic \
  -o native \
  -target macos_arm64
clang main.c libnative.dylib -o main
./main
