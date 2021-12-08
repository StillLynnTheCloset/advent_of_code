package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day08Test {
    @Test
    fun exampleA() {
        assertEquals(26, day08a(readFile("2021/day08example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(284, day08a(readFile("2021/day08input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(61229, day08b(readFile("2021/day08example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(973499, day08b(readFile("2021/day08input.txt")))
    }
}
