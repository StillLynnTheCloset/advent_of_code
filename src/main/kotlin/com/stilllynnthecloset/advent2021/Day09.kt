package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.Position
import com.stilllynnthecloset.gridOnEach
import com.stilllynnthecloset.product

fun day09a(input: String): Int = input
    .parse()
    .findLocalMinima()
    .sumOf { it + 1 }

fun day09b(input: String): Int = input
    .parse()
    .findBasins()
    .map { it.size }
    .sorted()
    .takeLast(3)
    .product()

private fun String.parse(): List<List<Int>> =
    lines()
        .map { it.map { it.digitToInt() } }

private fun List<List<Int>>.findLocalMinima(): List<Int> =
    flatMapIndexed { y: Int, list: List<Int> ->
        list.filterIndexed { x, i -> isLocalMinimum(x, y) }
    }

private fun List<List<Int>>.isLocalMinimum(x: Int, y: Int): Boolean =
    findValidSurroundingPositions(x, y).all { this[it.y][it.x] > this[y][x] }

private fun List<List<Int>>.findValidSurroundingPositions(x: Int, y: Int): List<Position> {
    return mutableListOf<Position>().also {
        if (x != 0) it.add(Position(x - 1, y))
        if (y != 0) it.add(Position(x, y - 1))
        if (x != this[y].lastIndex) it.add(Position(x + 1, y))
        if (y != this.lastIndex) it.add(Position(x, y + 1))
    }
}

private fun List<List<Int>>.findBasins(): List<Set<Position>> {
    val basins = mutableListOf<Set<Position>>()
    gridOnEach { x, y, value ->
        val pos = Position(x, y)
        // Heights of 9 can't be in a basin
        // If this position is already in a basin, skip it
        if (value != 9 && basins.none { pos in it }) {
            basins.add(findBasin(pos))
        }
    }
    return basins
}

private fun List<List<Int>>.findBasin(position: Position): Set<Position> {
    val basin = mutableSetOf<Position>()
    val queue = mutableListOf(position)
    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        basin.add(current)
        queue.addAll(
            findValidSurroundingPositions(current.x, current.y)
                .filter { it !in basin && this[it.y][it.x] != 9 }
        )
    }
    return basin
}
