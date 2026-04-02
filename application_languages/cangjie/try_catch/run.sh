mkdir llvm
cjc try_catch.cj -o try_catch --save-temps llvm -V
/Users/bytedance/tools/cangjie/third_party/llvm/bin/llvm-dis llvm/try_catch.bc -o try_catch.ll

mkdir llvm_opt
cjc try_catch.cj -O2 -o try_catch --save-temps llvm_opt -V
/Users/bytedance/tools/cangjie/third_party/llvm/bin/llvm-dis llvm_opt/try_catch.opt.bc -o try_catch_o2.ll
