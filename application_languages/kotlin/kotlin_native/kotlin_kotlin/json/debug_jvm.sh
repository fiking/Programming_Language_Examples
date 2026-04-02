#!/bin/bash

JAVA_HOME=/Users/bytedance/.gradle/jdks/eclipse_adoptium-11-aarch64-os_x/jdk-11.0.30+7/Contents/Home
PATH=$JAVA_HOME/bin:$PATH


set -e
JAVA_OPTS="-Xdebug -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=localhost:5005" /Users/bytedance/code/ByteKMP/kotlin/kotlin-native/dist/bin/konanc "$@"

#JAVA_OPTS="-Xdebug -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=localhost:5005" /Users/bytedance/code/Keels/kotlin/kotlin-native/dist/bin/konanc "$@"
# ./debug_jvm.sh -Xbinary=gc=cms  -Xsave-llvm-ir-after=CStubs -Xsave-llvm-ir-directory=./llvm nullpointercheck_4.kt
