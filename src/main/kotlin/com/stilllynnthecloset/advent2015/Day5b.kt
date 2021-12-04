package com.stilllynnthecloset.advent2015

fun day5b(input: String): Int = input
    .split("\n")
    .filter { name -> name.windowed(3).any { it[0] == it[2] } }
    .filter { name ->
        name
            .windowed(2)
            .fold(Triple(false, listOf<String>(), "")) { (success, seenPairs, lastPair), s ->
                Triple(success || (s != lastPair && s in seenPairs) || seenPairs.count { it == s } >= 2, seenPairs + s, s)
            }
            .first
    }
    .size