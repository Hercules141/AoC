package Day02

import println
import readInput

fun main() {

    fun parseInput(lines: List<String>): List<Game>{
        return lines.map { line ->

            val gameId = line.replace("Game ".toRegex(), "").replace(":.*".toRegex(), "").toInt()

            val setsStrings = line.replace("Game.*: ".toRegex(), "").split("; ")

            val drawSets = setsStrings.map { setString ->
                val ballAndCountStrings  = setString.split(", ")

                val rBallCount = ballAndCountStrings.find { it.contains("red") }?.replace(" red", "")?.toInt() ?: 0
                val gBallCount = ballAndCountStrings.find { it.contains("green") }?.replace(" green", "")?.toInt() ?: 0
                val bBallCount = ballAndCountStrings.find { it.contains("blue") }?.replace(" blue", "")?.toInt() ?: 0

                DrawSet(
                    numRed = rBallCount,
                    numGreen = gBallCount,
                    numBlue = bBallCount
                )
            }

            Game(
                gameId = gameId,
                sets = drawSets
            )
        }
    }

    val testInput = readInput("Day02\\Day02_test")
    val input = readInput("Day02\\Day02")

    val games = parseInput(input)

    val validGames = filterValidGames(games)

    println("Solution: " + solveDay02(validGames))
}

fun filterValidGames(games: List<Game>): List<Game> {
    // not be over sis no
    val maxR = 12
    val maxG = 13
    val maxB = 14

    return games.filter { game ->
        game.sets.none { set ->
            set.numRed > maxR ||
            set.numGreen > maxG ||
            set.numBlue > maxB
        }
    }
}

fun solveDay02(validGames: List<Game>): Int {
    return validGames.sumOf { game ->
        game.gameId
    }
}

data class Game(
    val gameId: Int,
    val sets: List<DrawSet>
)

data class DrawSet(
    val numRed: Int,
    val numGreen: Int,
    val numBlue: Int
)