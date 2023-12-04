package Day01

import println
import readInput

fun main() {
    fun dissectIntoDigits(string: String): List<String> {
        var mutableList: MutableList<String> = mutableListOf()

        string.forEachIndexed { index, c ->
            val reg = "one|two"
//            mutableList.add()
        }

        return emptyList()

    }

    fun translateDigitString(digitString: String): String {
        return when(digitString){
            "one" -> "1"
            "two" -> "2"
            "three" -> "3"
            "four" -> "4"
            "five" -> "5"
            "six" -> "6"
            "seven" -> "7"
            "eight" -> "8"
            "nine" -> "9"
            else -> digitString
        }
    }

    fun getCodeForLine(line: String): Int {
        val digitStringsToMatch = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9")

        val firstDigitString = line.findAnyOf(digitStringsToMatch)?.second
        val lastDigitString = line.findLastAnyOf(digitStringsToMatch)?.second

        println("first: $firstDigitString, last: $lastDigitString")

        val code = (translateDigitString(firstDigitString!!) + "" + translateDigitString(lastDigitString!!)).toInt()

        return code
    }

    fun decode(input: List<String>) = input.map { getCodeForLine(it) }.reduce{ a, b -> a + b }

    val testInput = readInput("Day01\\Day01_test")
    val input = readInput("Day01\\Day01")
    testInput.println()
    input.println()

//    getTranslatedFirstAndLastDigit("")
    println("solution: " + decode(input))
}
