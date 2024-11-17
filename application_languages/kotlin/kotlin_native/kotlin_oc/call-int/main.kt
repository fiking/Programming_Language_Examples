import kotlin.time.measureTime
import kotlin.system.measureNanoTime
import call.*


@OptIn(kotlinx.cinterop.ExperimentalForeignApi::class)
fun caller() {
  var a: Int = 2;

  val timeMillis = measureTime {
     for (index in 1 until 10000000){
       var b: Int = callee(index);
     }
  }
  println("Execution time in milliseconds: $timeMillis ms")
}


fun main() {
  caller()
}
