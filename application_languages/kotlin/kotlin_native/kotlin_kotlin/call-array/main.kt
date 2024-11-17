import kotlin.time.measureTime
import kotlin.system.measureNanoTime

fun callee(a: List<Int>) : List<Int> {
  return a;
}

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::class)
fun caller() {
  val list = listOf(1, 2, 3)  
  val timeMillis = measureTime {
     for (index in 1 until 10000000){
       var b = callee(list);
     }
  }
  println("Execution time in milliseconds: $timeMillis ms")
}


fun main() {
  caller()
}
