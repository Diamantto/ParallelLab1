import java.io.File
import kotlin.random.Random

//Creates new file with 10000 random symbols ('a' - 'z')
fun main() {
    val path = "src\\main\\resources\\"
    val f = File(path, "file5.txt")
    f.createNewFile()
    repeat(100000) {
        val c = "${Random.nextInt(97,122).toChar()}\n"
        f.appendText(c)
    }
}