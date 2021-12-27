package com.stilllynnthecloset.advent2016

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day08Test {
    @Test
    fun exampleA() {
        assertEquals(0, day08a(readFile("2016/day08example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day08a(readFile("2016/day08input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day08b(readFile("2016/day08example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day08b(readFile("2016/day08input.txt")))
    }
}
