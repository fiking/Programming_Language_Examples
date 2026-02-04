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

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement

@Serializable
class ReadSoSymbol1(val symbol_name: String? = null, val so_path: String? = null, val symbol_offset: Long? = null)

fun testfun() {
    val content ="{\"so_path\":\"/data/storage/el1/bundle/libs/arm64/libshared.so\",\"symbol_name\":\"Konan_DebugBufferSize\",\"symbol_offset\":49025500}"
    println("ohos_dlsym decodeFromJsonElement $content")
    val testJson = Json {
        ignoreUnknownKeys = true
    }

    val jsonElement = testJson.parseToJsonElement(content)
    println("ohos_dlsym jsonElement $jsonElement")
    val res = testJson.decodeFromJsonElement<ReadSoSymbol1>(jsonElement)
    println("ohos_dlsym res $res")
    println("ohos_dlsym res $res ${res.symbol_name}")
    println("ohos_dlsym res $res ${res.symbol_offset}")
    println("ohos_dlsym res $res ${res.so_path}")

    println("ohos_dlsym findAndInitDebugSymbols1 testcase end")
}

fun main() {
    testfun()
}

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