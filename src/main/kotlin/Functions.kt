import java.io.File

//Функция принимает файл, проходиться по строкам и возвращает Map, где key - буква, а value - кол-во совпадений
fun counter(file: File): MutableMap<String, Int> {
    val resultMap = mutableMapOf<String, Int>()
    file.forEachLine {
        resultMap[it] = (resultMap[it] ?: 0) + 1
    }
    return resultMap
}

//Возвращает список типа File
fun getFiles(folderPath: String): List<File> {
    val folder = File(folderPath)
    val result = mutableListOf<File>()
    try {
        folder.listFiles()?.forEach {
            if (it.name.lowercase().endsWith(".txt")) result.add(it)
        }
    } catch (e: Exception) {
        throw Exception("Folder wasn't found")
    }
    return result
}