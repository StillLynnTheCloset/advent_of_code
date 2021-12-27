package com.stilllynnthecloset.advent2017

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day03Test {
    @Test
    fun exampleA() {
        assertEquals(0, day03a(readFile("2017/day03example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day03a(readFile("2017/day03input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day03b(readFile("2017/day03example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day03b(readFile("2017/day03input.txt")))
    }
}
