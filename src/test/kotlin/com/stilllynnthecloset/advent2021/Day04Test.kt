package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day04Test {
    @Test
    fun exampleA() {
        assertEquals(4512, day04a(readFile("2021/day04example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(72770, day04a(readFile("2021/day04input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(1924, day04b(readFile("2021/day04example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(13912, day04b(readFile("2021/day04input.txt")))
    }
}
