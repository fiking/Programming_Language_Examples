cargo build --target wasm32-wasip1 -r
time wasmtime target/wasm32-wasip1/release/core_prime_sieve.wasm 4000
