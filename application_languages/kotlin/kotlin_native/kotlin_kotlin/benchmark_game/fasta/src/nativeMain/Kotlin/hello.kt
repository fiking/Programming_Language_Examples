import kotlinx.cinterop.*
import platform.posix.*
import kotlin.native.concurrent.*

object Fasta {
    private const val LINE_LENGTH = 60
    private const val LINE_COUNT = 1024
    private val WORKERS = Array(maxOf(Platform.cpuCores - 1, 1)) { NucleotideSelector() }

    private val IN = AtomicInt(0)
    private val OUT = AtomicInt(0)
    private const val BUFFERS_IN_PLAY = 6

    @ThreadLocal
    companion object {
        val stdout = stdout
    }

    // ... (其他代码将在这里)
fun main(args: Array<String>) {
    var n = 1000

    if (args.isNotEmpty()) {
        n = args[0].toInt()
    }
    
    WORKERS.forEach { it.start() }

    memScoped {
        val bufferSize = LINE_COUNT * LINE_LENGTH

        repeat(BUFFERS_IN_PLAY) {
            lineFillALU(AluBuffer(LINE_LENGTH, bufferSize, it * bufferSize))
        }
        speciesFillALU(stdout, n * 2, ">ONE Homo sapiens alu\n")
        repeat(BUFFERS_IN_PLAY) {
            writeBuffer(stdout)
            lineFillRandom(IubBuffer(LINE_LENGTH, bufferSize))
        }
        speciesFillRandom(stdout, n * 3, ">TWO IUB ambiguity codes\n", true)
        repeat(BUFFERS_IN_PLAY) {
            writeBuffer(stdout)
            lineFillRandom(SapienBuffer(LINE_LENGTH, bufferSize))
        }
        speciesFillRandom(stdout, n * 5, ">THREE Homo sapiens frequency\n", false)
        repeat(BUFFERS_IN_PLAY) {
            writeBuffer(stdout)
        }
    }
}

private fun lineFillALU(buffer: AbstractBuffer) {
    WORKERS[OUT.incrementAndGet() % WORKERS.size].put(buffer)
}

private fun bufferFillALU(writer: CPointer<FILE>, buffers: Int) {
    repeat(buffers) {
        val buffer = WORKERS[IN.incrementAndGet() % WORKERS.size].take()
        fwrite(buffer.nucleotides, 1, buffer.nucleotides.size.convert(), writer)
        lineFillALU(buffer)
    }
}

private fun speciesFillALU(writer: CPointer<FILE>, nChars: Int, name: String) {
    val bufferCount = nChars / (LINE_COUNT * LINE_LENGTH)
    val charsLeftover = nChars % (LINE_COUNT * LINE_LENGTH)

    fwrite(name.cstr, 1, name.length.convert(), writer)
    bufferFillALU(writer, bufferCount - BUFFERS_IN_PLAY)
    if (charsLeftover > 0) {
        writeBuffer(writer)
        lineFillALU(AluBuffer(LINE_LENGTH, charsLeftover, nChars - charsLeftover))
    }
}

// ... (其他方法的转换)
private class NucleotideSelector : Worker {
    private val inQueue = Queue<AbstractBuffer>(BUFFERS_IN_PLAY)
    private val outQueue = Queue<AbstractBuffer>(BUFFERS_IN_PLAY)

    fun put(line: AbstractBuffer) {
        inQueue.add(line)
    }

    override fun run() {
        while (true) {
            val line = inQueue.remove()
            line.selectNucleotides()
            outQueue.add(line)
        }
    }

    fun take(): AbstractBuffer = outQueue.remove()
}
}

fun main(args: Array<String>) {
    Fasta.main(args)
}
