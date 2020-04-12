package subtask1


import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        try {
            val outputDate = "d MMMM, EEEE"
            val currentDate = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
            val formatter = DateTimeFormatter.ofPattern(outputDate, Locale("RU"))
            return formatter.format(currentDate)
        } catch (e: DateTimeException) {
            return "Такого дня не существует"
        }
    }
}



