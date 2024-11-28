## 背景
目前这个目录下的用例主要是测试wasmtime和wasm3的性能，因此需要提前安装wasmtime和wasm3工具链。此外由C生成wasm使用的是wasi-sdk，故而也需要提前安装wasi-sdk。
## 环境搭建
1. 安装wasm3
2. 安装wasmtime
3. wasi-sdk
## 测试命令
以fibonacci为例，编译和执行的命令如下：
```
/Users/language-vm/code/wasi-sdk-24.0-arm64-macos/bin/clang -O3 fibonacci.c -o fib.wasm
time /Users/language-vm/.wasmtime/bin/wasmtime fib.wasm 40 -O
time /opt/homebrew/bin/wasm3 fib.wasm 40
```
