package com.stilllynnthecloset.advent2020

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day04Test {
    @Test
    fun exampleA() {
        assertEquals(0, day04a(readFile("2020/day04example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day04a(readFile("2020/day04input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day04b(readFile("2020/day04example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day04b(readFile("2020/day04input.txt")))
    }
}
