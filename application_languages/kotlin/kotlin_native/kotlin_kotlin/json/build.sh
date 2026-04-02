JAVA_HOME=/Users/bytedance/.gradle/jdks/eclipse_adoptium-11-aarch64-os_x/jdk-11.0.30+7/Contents/Home
PATH=$JAVA_HOME/bin:$PATH
java --version

# rm -rf /Users/bytedance/.gradle/daemon/8.5
# rm -rf .gradle
./gradlew clean
# ./gradlew clean build --rerun-tasks
# ./gradlew build --no-build-cache --rerun-tasks
./gradlew :linkReleaseExecutableNative --debug -Dorg.gradle.jvmargs="-Xmx2048m -Xms1024m"
