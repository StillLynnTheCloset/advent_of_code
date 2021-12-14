package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.Grid
import com.stilllynnthecloset.Position

fun day13a(input: String): Int = input
    .lines()
    .let {
        val positions = it.takeWhile { it.contains(",") }.mapTo(mutableSetOf()) { it.split(",").let { Position(it.first().toInt(), it.last().toInt()) } }
        val folds = it.takeLastWhile { it.contains("=") }.map { it.replace("fold along ", "").split("=").let { it.first() to it.last().toInt() } }

        val fold = folds.first()
        when (fold.first) {
            "x" -> positions.foldX(fold.second)
            "y" -> positions.foldY(fold.second)
            else -> throw IllegalStateException("Unknown fold dimension: ${fold.first}")
        }
    }
    .size

private fun Set<Position>.foldX(crease: Int): MutableSet<Position> = mapNotNullTo(mutableSetOf()) { (x, y) ->
        if (x == crease) {
            throw IllegalStateException("$x, $y is on x crease $crease")
        } else if (x > crease) {
            Position(crease - (x - crease), y)
        } else {
            Position(x, y)
        }
    }

private fun Set<Position>.foldY(crease: Int): MutableSet<Position> = mapNotNullTo(mutableSetOf()) { (x, y) ->
    if (y == crease) {
        throw IllegalStateException("$x, $y is on y crease $crease")
    } else if (y > crease) {
        Position(x, crease - (y - crease))
    } else {
        Position(x, y)
    }
}

fun day13b(input: String): Int = input
    .lines()
    .let {
        val positions = it.takeWhile { it.contains(",") }.mapTo(mutableSetOf()) { it.split(",").let { Position(it.first().toInt(), it.last().toInt()) } }
        val folds = it.takeLastWhile { it.contains("=") }.map { it.replace("fold along ", "").split("=").let { it.first() to it.last().toInt() } }

        val result = folds.fold(positions) { acc, (dimen, crease) ->
            when (dimen) {
                "x" -> acc.foldX(crease)
                "y" -> acc.foldY(crease)
                else -> throw IllegalStateException("Unknown fold dimension: $dimen")
            }
        }
        println(Grid<Boolean>(result.maxOf { it.x }, result.maxOf { it.y }) {x, y -> Position(x, y) in result}.flipCoords().print { if (it) "#" else "." })
        result
    }
    .size
// HZKHFEJZ
