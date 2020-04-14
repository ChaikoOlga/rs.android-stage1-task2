package subtask4

import java.util.regex.Matcher
import java.util.regex.Pattern

class Pangram {
    fun getResult(inputString: String): String {
        val isPangram = isPangram(inputString)
        println(isPangram)
        var str: String
        if (isPangram) {
            str = sortVowel(inputString)
            str = replaceVowel(str)
        } else {
            str = sortConsonant(inputString)
            str = replaceConsonant(str)
        }
        return str
    }

    fun isPangram(str: String): Boolean {
        val convert = str.toUpperCase()
        var letter = 'A' //65
        var i = 0
        while (letter.toInt() < 91) {
            while (letter == convert.get(i)) {
                letter = letter.plus(1)
                i = 0
            }
            if (convert.length - 1 == i) {
                return false
            } else {
                i++
            }
        }
        return true
    }

    fun sortVowel(str: String): String {
        var words = str.split(" ").toMutableList()
        words = words.filterNot { it == "" || it == "\n" || it == """+""" || it == """"""" } as MutableList<String>
        val pattern: Pattern = Pattern.compile("[eyuioa]", Pattern.CASE_INSENSITIVE)
        var matcher: Matcher
        var k = 0
        for (i in 0..words.size - 1) {
            matcher = pattern.matcher(words[i])
            while (matcher.find()) {
                k++
            }
            val number = "" + k + words[i]
            words[i] = number
            k = 0
        }
        words.sortBy { it.get(0) }
        var newVovel = ""
        for (i in 0..words.size - 1) {
            if (i != words.size - 1) {
                newVovel = newVovel + words[i] + " "
            } else {
                newVovel = newVovel + words[i]
            }
        }
        return newVovel
    }

    fun replaceVowel(words: String): String = words.replace(Regex("[eyuioa]")) {
        when (it.value) {
            "a" -> "A"
            "e" -> "E"
            "i" -> "I"
            "o" -> "O"
            "u" -> "U"
            "y" -> "Y"
            else -> it.value
        }
    }

    fun sortConsonant(str: String): String {
        var words = str.split(" ").toMutableList()
        words = words.filterNot { it == "" || it == "\n" || it == """+""" || it == """"""" } as MutableList<String>
        val pattern: Pattern = Pattern.compile("[pqrstvwghjklmnxzbcdf]", Pattern.CASE_INSENSITIVE)
        var matcher: Matcher
        var k = 0
        for (i in 0..words.size - 1) {
            matcher = pattern.matcher(words[i])
            while (matcher.find()) {
                k++
            }
            val number = "" + k + words[i]
            words[i] = number
            k = 0
        }
        words.sortBy { it.get(0) }
        var newConstant = ""
        for (i in 0..words.size - 1) {
            if (i != words.size - 1) {
                newConstant = newConstant + words[i] + " "
            } else {
                newConstant = newConstant + words[i]
            }
        }
        return newConstant
    }


    fun replaceConsonant(words: String): String = words.replace(Regex("[pqrstvwghjklmnxzbcdf]")) {
        when (it.value) {
            "b" -> "B"
            "c" -> "C"
            "d" -> "D"
            "f" -> "F"
            "g" -> "G"
            "h" -> "H"
            "j" -> "J"
            "k" -> "K"
            "l" -> "L"
            "m" -> "M"
            "n" -> "N"
            "p" -> "P"
            "q" -> "Q"
            "r" -> "R"
            "s" -> "S"
            "t" -> "T"
            "v" -> "V"
            "w" -> "W"
            "x" -> "X"
            "z" -> "Z"
            else -> it.value
        }
    }
}
