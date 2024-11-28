rustc hello.rs --target wasm32-wasip1 -O -o hello.wasm
wasmtime hello.wasm
