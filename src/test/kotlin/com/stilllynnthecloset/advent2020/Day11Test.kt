package com.stilllynnthecloset.advent2020

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day11Test {
    @Test
    fun exampleA() {
        assertEquals(0, day11a(readFile("2020/day11example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day11a(readFile("2020/day11input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day11b(readFile("2020/day11example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day11b(readFile("2020/day11input.txt")))
    }
}