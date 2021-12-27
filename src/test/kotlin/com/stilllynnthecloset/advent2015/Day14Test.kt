package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day14Test {
    @Test
    fun exampleA() {
        assertEquals(0, day14a(readFile("2015/day14example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day14a(readFile("2015/day14input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day14b(readFile("2015/day14example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day14b(readFile("2015/day14input.txt")))
    }
}