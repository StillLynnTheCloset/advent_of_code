package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.Position

fun day3a(input: String): Int = input
    .runningFold(Position(0, 0)) { acc, c ->
        when (c) {
            '<' -> Position(acc.x - 1, acc.y)
            '>' -> Position(acc.x + 1, acc.y)
            '^' -> Position(acc.x, acc.y - 1)
            'v' -> Position(acc.x, acc.y + 1)
            else -> acc
        }
    }
    .toSet()
    .size
