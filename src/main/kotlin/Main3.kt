import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    val path = "src\\main\\resources\\"
    val listOfFiles = getFiles(path)
    val resultMap: MutableMap<String, Int>

    val time = measureTimeMillis {
        val temp: List<MutableMap<String, Int>>
        runBlocking {
            val listOfDeferred = mutableListOf<Deferred<MutableMap<String, Int>>>()
            listOfFiles.forEach {
                val deferred = async(Dispatchers.Default) {
                    counter(it)
                }
                listOfDeferred.add(deferred)
            }
            temp = listOfDeferred.awaitAll()
        }
        resultMap = temp.reduce { accumulator, map ->
            map.forEach {
                accumulator[it.key] = (accumulator[it.key] ?: 0) + it.value
            }
            accumulator
        }
    }
    println("Time: ${time}ms")
    println(resultMap)
}