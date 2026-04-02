//import kotlin.coroutines.*
//
//open class EmptyContinuation(override val context: CoroutineContext = EmptyCoroutineContext) : Continuation<Any?> {
//    companion object : EmptyContinuation()
//    override fun resumeWith(result: Result<Any?>) { result.getOrThrow() }
//}
//
//tailrec suspend fun <T, A> Iterator<T>.foldl(acc : A, foldFunction : (e : T, acc : A) -> A) : A =
//        if (!hasNext()) acc
//        else foldl(foldFunction(next(), acc), foldFunction)
//
//fun builder(c: suspend () -> Unit) {
//    c.startCoroutine(EmptyContinuation)
//}
//
//fun box() : String {
//    var sum = 0L
//    builder {
//        sum = (1..1000000).iterator().foldl(0) { e : Int, acc : Long ->
//            acc + e
//        }
//    }
//
//    return if (sum == 500000500000) "OK" else "FAIL: $sum"
//}
//
//fun main() {
//  println(box())
//}

//import kotlinx.serialization.Serializable
//import kotlinx.serialization.json.Json
//import kotlinx.serialization.json.decodeFromJsonElement
//
//@Serializable
//class ReadSoSymbol1(val symbol_name: String? = null, val so_path: String? = null, val symbol_offset: Long? = null)
//
//fun testfun() {
//    val content ="{\"so_path\":\"/data/storage/el1/bundle/libs/arm64/libshared.so\",\"symbol_name\":\"Konan_DebugBufferSize\",\"symbol_offset\":49025500}"
//    println("ohos_dlsym decodeFromJsonElement $content")
//    val testJson = Json {
//        ignoreUnknownKeys = true
//    }
//
//    val jsonElement = testJson.parseToJsonElement(content)
//    println("ohos_dlsym jsonElement $jsonElement")
//    val res = testJson.decodeFromJsonElement<ReadSoSymbol1>(jsonElement)
//    println("ohos_dlsym res $res")
//    println("ohos_dlsym res $res ${res.symbol_name}")
//    println("ohos_dlsym res $res ${res.symbol_offset}")
//    println("ohos_dlsym res $res ${res.so_path}")
//
//    println("ohos_dlsym findAndInitDebugSymbols1 testcase end")
//}
//
//fun main() {
//    testfun()
//}

//import kotlinx.serialization.Serializable
//import kotlinx.serialization.json.Json
//import kotlinx.serialization.encodeToString
//import platform.posix.printf
//
//@Serializable
//data class Data(val a: Int, val b: String)
//
//fun main() {
//    val json = Json.encodeToString(Data(42, "str"))
//
//    val obj = Json.decodeFromString<Data>("""{"a":"42", "b": "str"}""")
//    println("${obj.a}")
//    println("${obj.b}")
//}


//interface IECJsEventSubscriber {
//    fun onReceiveJsEvent(params: String)
//}
//
//inline fun<T1,T2, R> lets2(
//    t1: T1?,
//    t2: T2?,
//    block: (T1, T2) -> R
//): R? {
//    return when {
//        (t1 != null && t2 != null) ->
//            block(t1, t2)
//        else ->
//            null
//    }
//}
//
//fun main() {
//    val carChangeSkuSubscriber = object : IECJsEventSubscriber {
//        override fun onReceiveJsEvent(paramsStr: String) {
//            val t1 : String = "aaaa"
//            val t2 : String = "bbbb"
//            lets2(
//                t1,
//                t2
//            ) {renderNodeKey, skuId->
//                return
//            }
//        }
//    }
//    carChangeSkuSubscriber.onReceiveJsEvent("ccccc")
//}

//fun main() {
//    // 准备测试数据：一个字符串列表
//    val fruits = listOf("Apple", "Banana", "Cherry", "Date", "Elderberry")
//
//    // 场景1：基础遍历 - 用 withIndex() 获取 IndexedValue 序列
//    println("=== 场景1：基础遍历 IndexedValue ===")
//    for ((index, measurable) in fruits.withIndex()) {
//        // indexedValue 是 IndexedValue<String> 类型，包含 index 和 value
//        println("索引 ${index} -> 元素 ${measurable}")
//    }
//}

//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.layout.Layout
//import androidx.compose.ui.layout.Placeable
//import kotlin.math.max
//import kotlin.math.min
//
///**
// * @author: ZhangZiang
// * @date: 2025/8/17
// * 自定义Row布局, 按顺序排列子元素,
// * 如果子元素空间不够放入父布局, 那么这个子元素和后续的元素都不会展示
// */
//@Composable
//fun TruncatingRow(
//    modifier: Modifier = Modifier,
//    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
//    onVisibleChildrenChanged: (List<Int>) -> Unit,
//    content: @Composable () -> Unit
//) {
//    Layout(
//        content = content,
//        modifier = modifier
//    ) { measurables, constraints ->
//        // 允许子项 wrapContent 宽度，避免被 minWidth 顶到最大
//        val childConstraints = constraints.copy(minWidth = 0)
//
//        var usedWidth = 0
//        val visiblePlaceables = mutableListOf<Placeable>()
//        val visibleIndices = mutableListOf<Int>()
//
//        for ((index, measurable) in measurables.withIndex()) {
//            val placeable = measurable.measure(childConstraints)
//            if (usedWidth + placeable.width <= constraints.maxWidth) {
//                usedWidth += placeable.width
//                visiblePlaceables += placeable
//                visibleIndices += index
//            } else {
//                break
//            }
//        }
//
//        onVisibleChildrenChanged(visibleIndices)
//
//        val contentHeight = max(
//            visiblePlaceables.maxOfOrNull { it.height } ?: 0,
//            constraints.minHeight
//        )
//        val layoutWidth = max(min(usedWidth, constraints.maxWidth), constraints.minWidth)
//
//        layout(width = layoutWidth, height = contentHeight) {
//            var x = 0
//            visiblePlaceables.forEach { p ->
//                val y = when (verticalAlignment) {
//                    Alignment.Top -> 0
//                    Alignment.CenterVertically -> (contentHeight - p.height) / 2
//                    Alignment.Bottom -> contentHeight - p.height
//                    else -> 0 // 其他自定义实现可在此扩展
//                }
//                p.placeRelative(x = x, y = y)
//                x += p.width
//            }
//        }
//    }
//}
//
//
fun main() {
    println("ok")
    val visiblePlaceables = mutableListOf<String>()
    return
}

//class A {
//    val ss = "xxx"
//    val ss2 = "xxx"
//}
//
//val arr = arrayOf(A(),A())
//fun main() {
//    var a = A()
//    println("hello " + a.ss);
//
////   a.ss = "uuu"
//    println("hello " + a.ss);
//
//    println("${arr[1]}")
//}

//import kotlin.native.concurrent.*
//
//@kotlin.native.runtime.NativeRuntimeApi
//fun main() {
//    val results = arrayOfNulls<Unit>(1)
//
//    val workers = Worker.start()
//    val futures = mutableListOf<Future<Unit>>()
//
//    val future = workers.execute(TransferMode.UNSAFE, {}) {
//        kotlin.native.runtime.GC.collect()
//        println("worker")
//    }
//    futures.add(future)
//    println(results)
//    workers.requestTermination().result
//}


///Users/bytedance/code/ByteKMP/kotlin/kotlin-native/dist/bin/konanc \
//-g \
//-enable-assertions \
//-library \
///Users/bytedance/code/ByteKMP/kotlin/kotlin-native/dist/klib/common/stdlib \
//-module-name \
//json \
//-no-endorsed-libs \
//-nostdlib \
//-output
///Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/build/classes/kotlin/native/main/klib/json.klib
//-produce
//library
//-Xshort-module-name=json
//-target
//macos_arm64
//-Xfragment-refines=nativeMain:commonMain
//-Xfragment-sources=nativeMain:/Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/src/nativeMain/kotlin/hello.kt
//-Xfragments=nativeMain,commonMain
//-Xmulti-platform
//-Xplugin=/Users/bytedance/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-serialization-compiler-plugin-embeddable/2.0.20-ea-2036/95e79b270c3fb2e6a73947cf0200b098938d2663/kotlin-serialization-compiler-plugin-embeddable-2.0.20-ea-2036.jar
//-verbose
//-opt
//-Xadd-light-debug=enable
//-Xbinary=packFields=false
//-Xsave-llvm-ir-after=Codegen,OptimizeTLSDataLoads,LinkBitcodeDependencies
//-Xsave-llvm-ir-directory=/Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/llvm
//-opt
//-Xadd-light-debug=enable
//-Xbinary=packFields=false
//-Xsave-llvm-ir-after=Codegen,OptimizeTLSDataLoads,LinkBitcodeDependencies
//-Xsave-llvm-ir-directory=/Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/llvm
///Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/src/nativeMain/kotlin/hello.kt


///Users/bytedance/code/ByteKMP/kotlin/kotlin-native/dist/bin/konanc \
//-Xinclude=/Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/build/classes/kotlin/native/main/klib/json.klib \
//-library \
///Users/bytedance/code/ByteKMP/kotlin/kotlin-native/dist/klib/common/stdlib \
//-no-endorsed-libs \
//-nostdlib \
//-opt \
//-output \
///Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/build/bin/native/releaseExecutable/json.kexe \
//-produce \
//program \
//-target \
//macos_arm64 \
//-Xmulti-platform \
//-opt \
//-Xadd-light-debug=enable \
//-Xbinary=packFields=false \
//-Xsave-llvm-ir-after=Codegen,OptimizeTLSDataLoads,LinkBitcodeDependencies \
//-Xsave-llvm-ir-directory=/Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/llvm \
//-Xexternal-dependencies=/var/folders/yx/162xf1s125b9xrmzl1fstfsm0000gn/T/kotlin-native-external-dependencies15261359665464995781.deps


///Users/bytedance/code/ByteKMP/kotlin/kotlin-native/dist/bin/konanc \
//-Xinclude=/Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/build/classes/kotlin/native/main/klib/json.klib \
//-library \
///Users/bytedance/code/ByteKMP/kotlin/kotlin-native/dist/klib/common/stdlib \
//-no-endorsed-libs \
//-nostdlib \
//-opt \
//-output \
///Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/build/bin/native/releaseExecutable/json.kexe \
//-produce \
//program \
//-target \
//macos_arm64 \
//-Xmulti-platform \
//-opt \
//-Xadd-light-debug=enable \
//-Xbinary=packFields=false \
//-Xsave-llvm-ir-after=Codegen,OptimizeTLSDataLoads,LinkBitcodeDependencies \
//-Xsave-llvm-ir-directory=/Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/llvm

//konanc
//-g
//-enable-assertions
//-library
///Users/bytedance/code/ByteKMP/kotlin/kotlin-native/dist/klib/common/stdlib
//-module-name
//json
//-no-endorsed-libs
//-nostdlib
//-output
///Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/build/classes/kotlin/native/main/klib/json.klib
//-produce
//library
//-Xshort-module-name=json
//-target
//macos_arm64
//-Xfragment-refines=nativeMain:commonMain
//-Xfragment-sources=nativeMain:/Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/src/nativeMain/kotlin/hello.kt
//-Xfragments=nativeMain,commonMain
//-Xmulti-platform
//-Xplugin=/Users/bytedance/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-serialization-compiler-plugin-embeddable/2.0.20-ea-2036/95e79b270c3fb2e6a73947cf0200b098938d2663/kotlin-serialization-compiler-plugin-embeddable-2.0.20-ea-2036.jar
//-verbose
//-opt
//-Xadd-light-debug=enable
//-Xbinary=packFields=false
//-Xsave-llvm-ir-after=Codegen,OptimizeTLSDataLoads,LinkBitcodeDependencies
//-Xsave-llvm-ir-directory=/Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/llvm
//-opt
//-Xadd-light-debug=enable
//-Xbinary=packFields=false
//-Xsave-llvm-ir-after=Codegen,OptimizeTLSDataLoads,LinkBitcodeDependencies
//-Xsave-llvm-ir-directory=/Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/llvm
///Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/src/nativeMain/kotlin/hello.kt


// /Users/bytedance/code/ByteKMP/kotlin/kotlin-native/dist/bin/konanc -output /Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/build/classes/kotlin/native/main/klib/json.klib -produce library -target macos_arm64 -opt /Users/bytedance/code/Programming_Language_Examples/application_languages/kotlin/kotlin_native/kotlin_kotlin/json/src/nativeMain/kotlin/hello.kt


///Users/bytedance/code/ByteKMP/kotlin/kotlin-native/dist/bin/konanc -output json.klib -produce library -target macos_arm64 -opt hello.kt
///Users/bytedance/code/ByteKMP/kotlin/kotlin-native/dist/bin/konanc -Xsave-llvm-ir-after=Codegen,OptimizeTLSDataLoads,LinkBitcodeDependencies -Xsave-llvm-ir-directory=./llvm -Xinclude=json.klib -opt -output json.kexe