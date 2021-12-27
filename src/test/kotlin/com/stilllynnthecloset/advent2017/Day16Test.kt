package com.stilllynnthecloset.advent2017

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day16Test {
    @Test
    fun exampleA() {
        assertEquals(0, day16a(readFile("2017/day16example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day16a(readFile("2017/day16input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day16b(readFile("2017/day16example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day16b(readFile("2017/day16input.txt")))
    }
}