package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.Position

fun day3b(input: String): Int = input
    .runningFoldIndexed(Position(0, 0) to Position(0, 0)) { i, acc, c ->
        val oldPos = if (i.mod(2) == 1) acc.first else acc.second
        val newPos = when (c) {
            '<' -> Position(oldPos.x - 1, oldPos.y)
            '>' -> Position(oldPos.x + 1, oldPos.y)
            '^' -> Position(oldPos.x, oldPos.y - 1)
            'v' -> Position(oldPos.x, oldPos.y + 1)
            else -> oldPos
        }
        if (i.mod(2) == 0) acc.first to newPos else newPos to acc.second
    }
    .unzip()
    .let { it.first + it.second }
    .toSet()
    .size
