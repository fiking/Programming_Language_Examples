import kotlin.time.measureTime
import kotlin.system.measureNanoTime

fun callee(str:String) : String {
  return str;
}

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::class)
fun caller() {
  var str:String = "this is a Kotlin String";
  
  val timeMillis = measureTime {
     for (index in 1 until 10000000){
       var b = callee(str);
     }
  }
  println("Execution time in milliseconds: $timeMillis ms")
}


fun main() {
  caller()
}
