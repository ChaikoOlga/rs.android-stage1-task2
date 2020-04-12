package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        val hours = hour.toInt()
        val minutes = minute.toInt()

        val minutesArray = arrayOf(
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen",
            "twenty",
            "twenty one",
            "twenty two",
            "twenty three",
            "twenty four",
            "twenty five",
            "twenty six",
            "twenty seven",
            "twenty eight",
            "twenty nine"
        )
        return when (minutes) {
            0 -> "${minutesArray[hours]} o' clock"
            1 -> "one minute past ${minutesArray[hours]}"
            in 2..14 -> "${minutesArray[minutes]} minutes past ${minutesArray[hours]}"
            15 -> "quarter past ${minutesArray[hours]}"
            in 16..29 -> "${minutesArray[minutes]} minutes past ${minutesArray[hours]}"
            30 -> "half past ${minutesArray[hours]}"
            in 31..44 -> "${minutesArray[60 - minutes]} minutes to ${minutesArray[hours + 1]}"
            45 -> "quarter to ${minutesArray[hours + 1]}"
            in 46..59 -> "${minutesArray[60 - minutes]} minutes to ${minutesArray[hours + 1]}"
            else -> ""
        }
    }
}
