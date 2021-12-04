package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.allIndexed

private data class BingoBoard constructor(val board: List<List<Pair<Int, Boolean>>>)

private fun BingoBoard.makeMove(move: Int): Pair<BingoBoard, Boolean> =
    BingoBoard(board.map { it.map { if (it.first == move) it.first to true else it } }).let { it to it.checkBoard() }

private fun BingoBoard.checkBoard(): Boolean = checkRows() || checkCols() || checkDiagonals()

private fun BingoBoard.checkRows(): Boolean = board.any { it.all { it.second } }

private fun BingoBoard.checkCols(): Boolean = (0 until 5).any { col -> board.all { it[col].second } }

private fun BingoBoard.checkDiagonals() =
    board.allIndexed { i, row -> row[i].second } || board.allIndexed { i, row -> row[i].second }

private fun BingoBoard.score(num: Int): Int = board.sumOf { it.sumOf { if (it.second) 0 else it.first } } * num

private fun List<String>.toBoards() =
    map { row ->
        row.split(" ")
            .filter { it.isNotBlank() }
            .map {
                Pair(it.toInt(), false)
            }
    }
        .windowed(5, 5)
        .map { BingoBoard(it) }

private fun winningScore(nums: List<Int>, boards: List<BingoBoard>): Int? {
    var results = boards.map { it to false }
    nums.forEach { num ->
        results = results.map { it.first.makeMove(num) }
        val winner = results.firstOrNull { it.second }?.first?.score(num)
        if (winner != null) {
            return winner
        }
    }
    return null
}

fun day04a(input: String): Int = input
    .split("\n")
    .run {
        val nums = first().split(",").map { it.toInt() }
        val boards = drop(1)
            .filter { it.isNotBlank() }
            .toBoards()

        winningScore(nums, boards) ?: 0
    }

fun day04b(input: String): Int = input
    .split("\n")
    .run {
        val nums = first().split(",").map { it.toInt() }
        val boards = drop(1)
            .filter { it.isNotBlank() }
            .toBoards()

        var results = boards.map { it to false }
        var loser: BingoBoard? = null
        nums.forEach { num ->
            results = results.map { it.first.makeMove(num) }
            val nonWinners = results.filterNot { it.second }
            if (nonWinners.size == 1) {
                loser = nonWinners.first().first
                return@forEach
            }
        }
        loser?.let { winningScore(nums, listOf(it)) } ?: 0
    }
