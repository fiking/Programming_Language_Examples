/Users/bytedance/tools/kotlin-native-prebuilt-macos-aarch64-2.1.0/bin/konanc \
  -Xsave-llvm-ir-after=CStubs,Codegen,LinkBitcodeDependencies \
  -Xsave-llvm-ir-directory=./llvm \
  -Xbinary=gc=cms \
  -Xruntime-logs=gc=debug \
  try_catch.kt -o try_catch
