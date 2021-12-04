package com.stilllynnthecloset.advent2015

private val vowels = listOf('a', 'e', 'i', 'o', 'u')
private val banned = listOf("ab", "cd", "pq", "xy")

fun day05a(input: String): Int = input
    .split("\n")
    .filter { name -> name.count { it in vowels } >= 3}
    .filter { name -> name.windowed(2).any { it[0] == it[1] } }
    .filter { name -> banned.all { it !in name } }
    .size

fun day05b(input: String): Int = input
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
