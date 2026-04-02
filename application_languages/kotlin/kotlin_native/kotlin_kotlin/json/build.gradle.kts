import org.jetbrains.kotlin.daemon.md5Digest
import kotlin.collections.plusAssign

// build.gradle.kts
plugins {
    kotlin("multiplatform") version "2.0.20-ea-2036"
    kotlin("plugin.serialization") version "2.0.20-ea-2036"
}

kotlin {
//    androidNativeArm64("native") { // on android ndk
    // linuxX64("native") // on Linux
    // mingwX64("native") // on Windows
//    macosArm64("native") { // on macOS
    ohosArm64("native") { // on macOS
        binaries {
            executable {
                compilerOptions {
                    freeCompilerArgs.add("-Xparallel-build-library-cache=false")
                    freeCompilerArgs.add("-opt")
                    freeCompilerArgs.add("-Xbinary=stripDebugInfoFromNativeLibs=false")
                    freeCompilerArgs.add("-Xadd-light-debug=enable")
                    freeCompilerArgs.add("-Xbinary=packFields=false")
//		            freeCompilerArgs.add("-Xsave-llvm-ir-after=Codegen,CStubs,RemoveRedundantSafepoints,MandatoryBitcodeLLVMPostprocessingPhase,LTOBitcodeOptimization,ModuleBitcodeOptimization,OptimizeTLSDataLoads,LinkBitcodeDependencies")
//		            freeCompilerArgs.add("-Xsave-llvm-ir-directory=/Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/llvm")
                }
            }
        }
    }


    sourceSets {
        val nativeMain by getting {
            dependencies {
//                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1-ohos.11")
//                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3-ohos.3")
//                implementation("org.jetbrains.compose.ui:ui:1.6.10-ohos-nd.151")
//                implementation("org.jetbrains.compose.runtime:runtime:1.6.10")
//                implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.20-ea-2036")
            }
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "8.5"
    distributionType = Wrapper.DistributionType.BIN
}

// Kotlin DSL 自定义Task：打印linkDebugExecutableNative的Class path详情
tasks.register("printNativeLinkClassPath") {
    group = "Help"
    description = "打印linkDebugExecutableNative Task的Class path和相关配置"

    doLast {
        // 获取Native链接Task（多模块需指定模块名，如":app:linkDebugExecutableNative"）
        val nativeLinkTask = project.tasks.findByName("linkDebugExecutableNative")
        if (nativeLinkTask != null) {
            println("=== linkDebugExecutableNative Class Path 详情 ===")

            // 1. 打印Task的Classpath（核心：触发up-to-date的关键）
            if (nativeLinkTask.hasProperty("classpath")) {
                val classpath = nativeLinkTask.property("classpath") as? FileCollection
                println("1. Classpath 集合：")
                classpath?.forEach { file ->
                    println("   - ${file.absolutePath}")
                    println("     MD5哈希：${file.md5Digest()}")
                    // 可选：打印文件最后修改时间，排查是否被修改
//                    println("     最后修改时间：${java.util.Date(file.lastModified())}")
                } ?: println("   未找到classpath属性")
            }

//            // 2. 打印Native Task特有配置（NDK/CMake路径）
//            println("\n2. Native构建核心配置：")
//            // 获取Android NDK配置（需确保引入Android插件）
//            val androidExtension = project.extensions.findByName("android") as? com.android.build.gradle.BaseExtension
//            androidExtension?.apply {
//                println("   NDK版本：${ndkVersion ?: "未指定"}")
//                println("   NDK目录：${ndkDirectory.absolutePath}")
//                println("   CMake版本：${externalNativeBuild.cmake.version ?: "未指定"}")
//            }

            // 3. 打印Task的所有输入文件（触发up-to-date的关键）
            println("\n3. Task输入文件（修改会触发Class path变化）：")
            nativeLinkTask.inputs.files.forEach { file ->
                println("   - ${file.absolutePath}")
            }

            // 4. 打印Task的哈希值（对比前后变化）
            println("\n4. Task输入属性哈希（简化版）：")
            val inputProperties = nativeLinkTask.inputs.properties
            inputProperties.forEach { (key, value) ->
                if (key.contains("classpath") || key.contains("hash")) {
                    println("   $key: $value")
                }
            }
        } else {
            println("❌ 未找到Task: linkDebugExecutableNative，请检查Task名称或模块名")
        }
    }
}

