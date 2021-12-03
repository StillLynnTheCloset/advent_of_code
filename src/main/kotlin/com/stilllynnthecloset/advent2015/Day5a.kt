package com.stilllynnthecloset.advent2015

private val vowels = listOf('a', 'e', 'i', 'o', 'u')
private val banned = listOf("ab", "cd", "pq", "xy")
fun day5a(input: String): Int = input
    .split("\n")
    .filter { name -> name.count { it in vowels } >= 3}
    .filter { name -> name.windowed(2).any { it[0] == it[1] } }
    .filter { name -> banned.all { it !in name } }
    .size

