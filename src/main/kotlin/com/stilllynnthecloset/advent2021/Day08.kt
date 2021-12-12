package com.stilllynnthecloset.advent2021

fun day08a(input: String): Int = input
    .parse()
    .sumOf { it.second.count { it.length in listOf(2, 3, 4, 7) } }

fun day08b(input: String): Int = input
    .parse()
    .testPossibilities()
    .sum()

private fun String.parse(): List<Pair<List<String>, List<String>>> =
    lines()
        .map {
            it.split(" | ").let {
                it[0].split(" ") to it[1].split(" ")
            }
        }

private fun List<Pair<List<String>, List<String>>>.testPossibilities(): List<Int> =
    map {
        val digits = it.first.toMutableList()

        val digit1 = digits.first { it.length == 2 }.also { digits.remove(it) }.toSet()
        val digit7 = digits.first { it.length == 3 }.also { digits.remove(it) }.toSet()
        val digit4 = digits.first { it.length == 4 }.also { digits.remove(it) }.toSet()
        val digit8 = digits.first { it.length == 7 }.also { digits.remove(it) }.toSet()
        val digit3 =
            digits.first { it.length == 5 && it.toList().containsAll(digit1.toList()) }.also { digits.remove(it) }
                .toSet()
        val digit9 =
            digits.first { it.length == 6 && it.toList().containsAll(digit3.toList()) }.also { digits.remove(it) }
                .toSet()
        val digit0 =
            digits.first { it.length == 6 && it.toList().containsAll(digit1.toList()) }.also { digits.remove(it) }
                .toSet()
        val digit6 = digits.first { it.length == 6 }.also { digits.remove(it) }.toSet()
        val digit5 = digits.first { digit ->
            val nineDigits = digit9.toList()
            val unique = nineDigits.filterNot { it in digit3.toList() }
            digit.toList().containsAll(unique)
        }.also { digits.remove(it) }.toSet()
        val digit2 = digits.first().toSet()

        it.second.map {
            when (it.toSet()) {
                digit0 -> 0
                digit1 -> 1
                digit2 -> 2
                digit3 -> 3
                digit4 -> 4
                digit5 -> 5
                digit6 -> 6
                digit7 -> 7
                digit8 -> 8
                digit9 -> 9
                else -> throw IllegalStateException("Did not find matching digit for $it")
            }
        }.joinToString(separator = "").toInt()
    }
