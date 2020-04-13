package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {

        val str = a.toUpperCase()
        var i = 0
        var j = 0
        var k = 0
        while (i < str.length) {
            if (b[j] == str[i]) {
                i++
                k++
                if (j < b.length) {
                    j++
                }
            } else {
                i++
            }
            if (k == b.length) {
                break
            }
        }
        return if (b.length == k) {
            "YES"
        } else {
            "NO"
        }
    }
}
