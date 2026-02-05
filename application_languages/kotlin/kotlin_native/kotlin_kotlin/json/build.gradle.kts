// build.gradle.kts
plugins {
    kotlin("multiplatform") version "2.0.20-ea-2034"
    kotlin("plugin.serialization") version "2.0.20-ea-2034"
}

kotlin {
//    androidNativeArm64("native") { // on android ndk
    // linuxX64("native") // on Linux
    // mingwX64("native") // on Windows
    macosArm64("native") { // on macOS
        binaries {
            executable {
                compilerOptions {
                    freeCompilerArgs.add("-g")
                    freeCompilerArgs.add("-Xbinary=packFields=false")
                }
            }
        }
    }

    sourceSets {
        val nativeMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1-ohos.11")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3-ohos.3") }
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "8.5"
    distributionType = Wrapper.DistributionType.BIN
}


