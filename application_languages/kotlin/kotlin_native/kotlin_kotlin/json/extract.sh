/Users/bytedance/code/Keels/kotlin/kotlin-native/tools/llvm_builder/llvm-distribution/bin/llvm-extract --func="kfun:#main(){}" $1  -o main.bc
/Users/bytedance/code/Keels/kotlin/kotlin-native/tools/llvm_builder/llvm-distribution/bin/llvm-dis main.bc -o main.ll
/Users/bytedance/code/Keels/kotlin/kotlin-native/tools/llvm_builder/llvm-distribution/bin/clang++ -cc1 -emit-obj -x ir -triple arm64-apple-macos11.0 -O3 -mllvm -print-after-all main.bc -S -o main.s > irlog 2>&1

# /Users/bytedance/code/Keels/kotlin/kotlin-native/tools/llvm_builder/llvm-distribution/bin/llvm-dis /var/folders/yx/162xf1s125b9xrmzl1fstfsm0000gn/T/konan_temp7444670425961733349/out.bc -o out.ll
