package com.stilllynnthecloset.advent2020

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day20Test {
    @Test
    fun exampleA() {
        assertEquals(0, day20a(readFile("2020/day20example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day20a(readFile("2020/day20input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day20b(readFile("2020/day20example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day20b(readFile("2020/day20input.txt")))
    }
}
