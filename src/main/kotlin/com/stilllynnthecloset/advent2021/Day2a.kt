package com.stilllynnthecloset.advent2021

fun day2a(input: String): Int = input
    .split("\n")
    .fold(Pair(0, 0)) { acc, i ->
        val (direction, distance) = i.split(" ").let { it.first() to it.last().toInt() }
        when (direction) {
            "forward" -> Pair(acc.first + distance, acc.second)
            "up" -> Pair(acc.first, acc.second - distance)
            "down" -> Pair(acc.first, acc.second + distance)
            else -> acc
        }
    }
    .let { it.first * it.second }

