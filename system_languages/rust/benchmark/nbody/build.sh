rustc nbody.rs --target wasm32-wasip1 -O -o nbody.wasm
wasmtime nbody.wasm 5000000 -O
