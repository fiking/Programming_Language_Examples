// build.gradle.kts
plugins {
    kotlin("multiplatform") version "2.0.20"
    kotlin("plugin.serialization") version "2.0.20"
}

repositories {
    mavenCentral()
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
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1") }
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "8.5"
    distributionType = Wrapper.DistributionType.BIN
}


