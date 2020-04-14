package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        return when (blockB) {
            String::class -> sumString(blockA)
            Int::class -> sumInt(blockA)
            LocalDate::class -> sumLocalDate(blockA)
            else -> {
                ""
            }
        }
    }

    fun sumString(blockA: Array<Any>): String {
        var str = ""
        for (i in 0..blockA.size - 1) {
            if (blockA[i] is String) {
                str = str + blockA[i]
            }
        }
        return str
    }

    fun sumLocalDate(blockA: Array<Any>): Any {
        val date = mutableListOf<Long>()
        for (e in blockA) {
            if (e is LocalDate) {
                date.add(e.toEpochDay())
            }
        }
        date.sort()
        val formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY")
        return LocalDate.ofEpochDay(date.last() - 365).format(formatter)
    }

    fun sumInt(blockA: Array<Any>): Int {
        var sum = 0
        for (j in 0..blockA.size - 1) {
            if (blockA[j] is Int) {
                val a = blockA[j] as Int
                sum = sum + a
            }
        }
        return sum
    }
}
