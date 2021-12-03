package com.stilllynnthecloset.advent2015

fun day2a(input: String): Int = input
    .split("\n")
    .sumOf { line ->
        val sides = line.split('x').map { it.toInt() }
        val areas = listOf(sides[0] * sides[1], sides[1] * sides[2], sides[2] * sides[0])
        areas.sum() * 2 + areas.minOf { it }
    }
