package subtask4

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val result: MutableList<String> = arrayListOf()

        for (i in inputString.indices) {
            when {
                inputString[i] == '<' -> result.add(
                    getSubstring(
                        inputString.substring(i),
                        '<',
                        '>'
                    )
                )
                inputString[i] == '(' -> result.add(
                    getSubstring(
                        inputString.substring(i),
                        '(',
                        ')'
                    )
                )
                inputString[i] == '[' -> result.add(
                    getSubstring(
                        inputString.substring(i),
                        '[',
                        ']'
                    )
                )
            }
        }

        return result.toTypedArray()
    }

    private fun getSubstring(string: String, charOpen: Char, charEnd: Char): String {
        var count = 0
        var result = ""

        for (i in 1 until string.length) {
            if (string[i] == charOpen) {
                count++
            } else if (string[i] == charEnd && count != 0) {
                count--
            } else if (string[i] == charEnd && count == 0) {
                result = string.substring(1, i)
                break
            }
        }
        return result
    }
}
