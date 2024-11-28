# 需要安装wasi-sdk/wasmtime/wasm3

/Users/language-vm/code/wasi-sdk-24.0-arm64-macos/bin/clang -O3 fibonacci.c -o fib.wasm
time /Users/language-vm/.wasmtime/bin/wasmtime fib.wasm 40 -O
time /opt/homebrew/bin/wasm3 fib.wasm 40
