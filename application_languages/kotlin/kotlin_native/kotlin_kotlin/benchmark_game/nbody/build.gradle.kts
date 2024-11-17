// build.gradle.kts
plugins {
    kotlin("multiplatform") version "2.0.0"
}

repositories {
    mavenCentral()
}

kotlin {
    androidNativeArm64("native") { // on android ndk
    // linuxX64("native") // on Linux
    // mingwX64("native") // on Windows
    // macosArm64("native") { // on macOS
        binaries {
            executable {
                compilerOptions {
                        freeCompilerArgs.add("-opt")
                }
            }
        }
    }

    sourceSets {
        val nativeMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-androidnativearm64:1.9.0-RC")
            }
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "8.5"
    distributionType = Wrapper.DistributionType.BIN
}
