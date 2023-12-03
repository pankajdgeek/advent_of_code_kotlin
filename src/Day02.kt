fun main() {
    val maxMap = mapOf("blue" to 14, "red" to 12, "green" to 13)
    val input = readInput("Day02")
    var result = 0
    for ((i, s) in input.withIndex()) {
        val gameMap = mutableMapOf<String, Int>()
        for (round in getRoundDetail(s.replace("Game ${i + 1}:", ""))) {
            for (slot in breakRound(round)) {
                val balls = gameBallCount(slot)
                gameMap[balls.second] = Math.max(gameMap.getOrDefault(balls.second, 0), balls.first)
            }
        }
//        println("game ${i + 1} ->$gameMap")
        var product = 1
        for ((key, value) in gameMap) {
            product *= value
        }
        result += product
    }
    println("final Result $result")
}

fun breakRound(input: String): List<String> {
    return input.split(",")
}

fun gameBallCount(input: String): Pair<Int, String> {
    val out = input.split(" ").filter { it.isNotEmpty() }
    return Pair(out[0].toInt(), out[1])
}

fun getRoundDetail(input: String): List<String> {
    return input.split(";")
}