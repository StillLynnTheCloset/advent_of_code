package com.stilllynnthecloset.advent2017

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day06Test {
    @Test
    fun exampleA() {
        assertEquals(0, day06a(readFile("2017/day06example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day06a(readFile("2017/day06input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day06b(readFile("2017/day06example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day06b(readFile("2017/day06input.txt")))
    }
}
