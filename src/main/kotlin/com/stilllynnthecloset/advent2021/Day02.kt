package com.stilllynnthecloset.advent2021

fun day02a(input: String): Int = input
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

data class State constructor(val x: Int, val y: Int, val aim: Int)

fun day02b(input: String): Int = input
    .split("\n")
    .fold(State(0, 0, 0)) { acc, i ->
        val (direction, distance) = i.split(" ").let { it.first() to it.last().toInt() }
        when (direction) {
            "forward" -> State(acc.x + (acc.aim * distance), acc.y + distance, acc.aim)
            "up" -> State(acc.x, acc.y, acc.aim - distance)
            "down" -> State(acc.x, acc.y, acc.aim + distance)
            else -> acc
        }
    }
    .let { it.y * it.x }
