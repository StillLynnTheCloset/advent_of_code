package com.stilllynnthecloset.advent2016

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day12Test {
    @Test
    fun exampleA() {
        assertEquals(0, day12a(readFile("2016/day12example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day12a(readFile("2016/day12input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day12b(readFile("2016/day12example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day12b(readFile("2016/day12input.txt")))
    }
}