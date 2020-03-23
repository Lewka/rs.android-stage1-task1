package subtask5

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        var result = digitString
        var count = k

        if (result != null) {

            if (wouldBePalindrome(result, count)) {

                for (i in 0 until n / 2) {

                    if (count == 0) {
                        break
                    }

                    when {
                        (result[i] != result[n - 1 - i]) -> {
                            when {
                                result[i] == '9' -> {
                                    result = replace(result, n - 1 - i, '9')
                                    count--
                                }
                                result[n - 1 - i] == '9' -> {
                                    result = replace(result, i, '9')
                                    count--
                                }
                                count >= 2 -> {
                                    result = replace(result, n - 1 - i, '9')
                                    result = replace(result, i, '9')
                                    count -= 2
                                }

                                count < 2 -> {
                                    result = if (result[i] > result[n - 1 - i]) {
                                        replace(result, n - 1 - i, result[i])
                                    } else {
                                        replace(result, i, result[n - 1 - i])
                                    }
                                }
                            }
                        }

                        (result[i] == result[n - 1 - i] && result[i] != '9') -> {
                            if (count >= 2) {
                                result = replace(result, n - 1 - i, '9')
                                result = replace(result, i, '9')
                                count -= 2
                            } else {
                                result = if (result[i] > result[n - 1 - i]) {
                                    replace(result, n - 1 - i, result[i])
                                } else {
                                    replace(result, i, result[n - 1 - i])
                                }
                            }
                        }
                    }
                }
            } else {
                result = "-1"
            }

        } else {
            throw NotImplementedError("Not implemented")
        }
        return result
    }

    private fun wouldBePalindrome(string: String, numberOfChanges: Int): Boolean {
        val size = string.length
        var count = 0

        for (i in 0 until size / 2) {
            if (string[i] != string[size - 1 - i]) {
                count += 2
            }
        }

        return when {
            count - numberOfChanges == 1 -> true
            else -> false
        }
    }

    private fun replace(string: String, indexOldChar: Int, newChar: Char): String {
        var charArr = string.toCharArray()
        charArr[indexOldChar] = newChar
        return String(charArr)
    }
}
