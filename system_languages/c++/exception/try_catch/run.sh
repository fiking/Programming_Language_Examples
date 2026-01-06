clang++ -O0 try_catch.cpp -S -emit-llvm -o try_catch.ll
clang++ -O0 try_catch.cpp -S -o try_catch.s

clang++ -O0 try_catch.cpp -g -o try_catch

