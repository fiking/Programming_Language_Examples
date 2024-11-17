import kotlin.time.measureTime
import kotlin.system.measureNanoTime
import call.*
import kotlinx.cinterop.cstr

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::class)
fun caller() {
  var str:String = "kotlin caller asdasdfadfasdfafdasdfasfdasdfasdfasfasfasfasdfascasdvagjsnfsfgsfdgsdkfgsjkdfgksjfksdkfjsdkfjlsdjflgsjfgljsdlfjgsldjflskdjfglksjdlfkjgsldfjglsjjkllslvnsjnvnsjfnsjngljnsfljgnlslsflsjflsdlfgjsldfjgsdfnvsdjlfnvslgoweroihofhaljfoajfoijonlhohiglhihl,gqihkuhlnhlhiljhigkihofhqwohefowhfoihlfdhaofwhqowfhjsdfiuhqworfhqowehfoqwhfohsfjhwfiuhq3bfiouhfoajofhowqhfo"

  var cst = str.cstr
  val timeMillis = measureTime {
     for (index in 1 until 10000000){
       var b = callee(cst);
     }
  }
  println("Execution time in milliseconds: $timeMillis ms")
}


fun main() {
  caller()
}
