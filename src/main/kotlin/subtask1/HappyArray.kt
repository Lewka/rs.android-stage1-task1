package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        val result = sadArray.toMutableList()

        var isSad: Boolean

        do {
            isSad = false

            for (x in 1 until result.size - 1) {
                if (result[x - 1] + result[x + 1] < result[x]) {
                    result.removeAt(x)
                    isSad = true
                    break
                }
            }

        } while (isSad)

        return result.toIntArray()
    }
}
