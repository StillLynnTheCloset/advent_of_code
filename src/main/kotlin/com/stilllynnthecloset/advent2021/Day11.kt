package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.Position
import com.stilllynnthecloset.gridOnEach

fun day11a(input: String): Int = input
    .lines()
    .map { it.map { it.digitToInt() }.toMutableList() }
    .let { dumbos ->
        (0 until 100).sumOf {
            dumbos.runStep()
        }
    }

private fun List<MutableList<Int>>.runStep(flashes: MutableSet<Position> = mutableSetOf()): Int {
    gridOnEach { x, y, _ ->
        this[x][y] += 1
    }
    gridOnEach { x, y, value ->
        if (value > 9) {
            attemptFlash(Position(x, y), flashes)
        }
    }
    gridOnEach { x, y, value ->
        if (value > 9) {
            this[x][y] = 0
        }
    }
    return flashes.size
}

private fun List<MutableList<Int>>.attemptFlash(position: Position, flashes: MutableSet<Position>) {
    if (position !in flashes) {
        flashes.add(position)
        val neighbors = findValidSurroundingPositions(position.x, position.y)
        neighbors.forEach {
            this[it.x][it.y] += 1
            if (this[it.x][it.y] > 9 && it !in flashes) {
                attemptFlash(it, flashes)
            }
        }
    }
}

private fun List<List<Int>>.findValidSurroundingPositions(x: Int, y: Int): List<Position> {
    return mutableListOf<Position>().also {
        if (x != 0) it.add(Position(x - 1, y))
        if (y != 0) it.add(Position(x, y - 1))
        if (x != this[y].lastIndex) it.add(Position(x + 1, y))
        if (y != this.lastIndex) it.add(Position(x, y + 1))
        // diagonals
        if (x != 0 && y != 0) it.add(Position(x - 1, y - 1))
        if (y != 0 && x != this[y].lastIndex) it.add(Position(x + 1, y - 1))
        if (x != this[y].lastIndex && y != this.lastIndex) it.add(Position(x + 1, y + 1))
        if (y != this.lastIndex && x != 0) it.add(Position(x - 1, y + 1))
    }
}

fun day11b(input: String): Int = input
    .lines()
    .map { it.map { it.digitToInt() }.toMutableList() }
    .let { dumbos ->
        var step = 1
        while (dumbos.runStep() != 100) step++
        step
    }
