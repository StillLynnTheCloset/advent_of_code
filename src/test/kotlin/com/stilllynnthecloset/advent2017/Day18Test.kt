package com.stilllynnthecloset.advent2017

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day18Test {
    @Test
    fun exampleA() {
        assertEquals(0, day18a(readFile("2017/day18example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day18a(readFile("2017/day18input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day18b(readFile("2017/day18example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day18b(readFile("2017/day18input.txt")))
    }
}
