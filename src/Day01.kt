import java.lang.StringBuilder

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01")
    println(testInput)
    var result = 0
    for (input in testInput) {
        val nub = getNumber(input)
        println("$input -> $nub")
        result += nub
    }
    println(result)
//    check(result == 142)

//    val input = readInput("Day01")
//    part1(input).println()
//    part2(input).println()
}

val countSet = mapOf(
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9
)

fun getNumber(input: String): Int {
    var left = 0
    var right = input.length - 1
    var first = -1
    var second = -1
    var leftStr = StringBuilder()
    var rightStr = StringBuilder()
    while ((first == -1 || second == -1) && left <= right) {
        if (first == -1 && input[left].isDigit()) {
            first = (input[left].code - '0'.code) * 10
        } else if (first == -1) {
            leftStr.append(input[left])
            val num = getNumberFromString(leftStr.toString())
            if (num != -1)
                first = num * 10
            left++
        }
        if (second == -1 && input[right].isDigit()) {
            second = input[right].code - '0'.code
        } else if (second == -1) {
            rightStr.append(input[right])
            val num = getNumberFromString(rightStr.toString().reversed())
            if (num != -1)
                second = num
            right--
        }
    }
    if (first == -1 && second == -1)
        return 0
    if (first == -1)
        first = second * 10
    if (second == -1)
        second = first / 10

    return first + second
}

fun getNumberFromString(input: String): Int {
    for ((key, num) in countSet) {
        if (input.contains(key))
            return num
    }
    return -1
}
