rustc binarytrees.rs --target wasm32-wasip1 -O -o binarytrees.wasm
wasmtime binarytrees.wasm 18 -O
