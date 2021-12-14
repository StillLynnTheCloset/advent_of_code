package com.stilllynnthecloset.advent2021

fun day14a(input: String): Int = input
    .lines()
    .size // TODO: Broke this while working on part B, fix later
//    .let {
//        val start = it.first()
//
//        val instructions = it.filter { " -> " in it }.map { it.split(" -> ").let { it.first() to it.last() } }.toMap()
//        (0 until 10).fold(start) { acc, _ ->
//            ""
//        }
//            .groupBy { it }
//            .mapValues { it.value.size }
//    }
//    .let {
//        val max = it.maxByOrNull { it.value }
//        val min = it.minByOrNull { it.value }
//        println(max)
//        println(min)
//        max!!.value - min!!.value
//    }

fun day14b(input: String): Long = input
    .lines()
    .let {
        val start = it.first()
        val accumulator = start
            .windowed(2)
            .groupBy { it }
            .mapValues { it.value.size.toLong() }

        val instructions = it
            .filter { " -> " in it }
            .associate { it.split(" -> ").let { it.first() to it.last() } }
        (0 until 40).fold(accumulator) { acc, _ ->
            val new = mutableMapOf<String, Long>()
            acc.forEach {
                val out = instructions.get(it.key)
                if (out != null) {
                    val key1 = "${it.key.first()}$out"
                    val key2 = "$out${it.key.last()}"
                    new[key1] = it.value + new.getOrDefault(key1, 0)
                    new[key2] = it.value + new.getOrDefault(key2, 0)
                } else {
                    new[it.key] = it.value + new.getOrDefault(it.key, 0)
                }
            }
            new
        }
    }
    .toList()
    .map { it.first.first() to it.second }
    .groupBy { it.first }
    .mapValues { it.value.sumOf { it.second }  + if (it.key == 'B') 1 else 0}
    .let {
        val max = it.maxByOrNull { it.value }
        val min = it.minByOrNull { it.value }
        max!!.value - min!!.value
    }
