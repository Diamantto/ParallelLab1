import kotlin.system.measureTimeMillis

fun main() {
    val path = "src\\main\\resources\\"
    val listOfFiles = getFiles(path)
    val resultListOfMaps: List<MutableMap<String, Int>>

    val time = measureTimeMillis {
        resultListOfMaps = listOfFiles.map {
            counter(it)
        }
    }

    println("Time: ${time}ms")

    var i = 1
    resultListOfMaps.forEach {
        println("File ${i++}: $it")
    }
}



