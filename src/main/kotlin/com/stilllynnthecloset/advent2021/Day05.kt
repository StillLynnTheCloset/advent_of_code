package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.Position
import com.stilllynnthecloset.rangeTo

fun day05a(input: String): Int = input
    .lines()
    .map(::parseLine)
    .filter { it.first.x == it.second.x || it.first.y == it.second.y }
    .flatMap { lineBetweenPoints(it.first, it.second) }
    .groupBy { it }
    .count { it.value.size > 1 }

fun day05b(input: String): Int = input
    .lines()
    .map(::parseLine)
    .flatMap { lineBetweenPoints(it.first, it.second) }
    .groupBy { it }
    .count { it.value.size > 1 }

private fun lineBetweenPoints(a: Position, b: Position): List<Position> =
    if (a.x == b.x) {
        (a.y rangeTo b.y).map { Position(a.x, it) }
    } else if (a.y == b.y) {
        (a.x rangeTo b.x).map { Position(it, a.y) }
    } else {
        (a.x rangeTo b.x).zip((a.y rangeTo b.y)) { x, y -> Position(x, y) }
    }

private fun parseLine(line: String) = line
    .split(Regex.fromLiteral(" -> "))
    .map {
        it
            .split(",")
            .let {
                Position(it[0].toInt(), it[1].toInt())
            }
    }
    .let { it[0] to it[1] }
