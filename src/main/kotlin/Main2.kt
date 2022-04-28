import kotlin.system.measureTimeMillis

fun main() {
    val path = "src\\main\\resources\\"
    val listOfFiles = getFiles(path)
    val resultMap: MutableMap<String, Int>

    val time = measureTimeMillis {
        val temp = listOfFiles.map {
            counter(it)
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