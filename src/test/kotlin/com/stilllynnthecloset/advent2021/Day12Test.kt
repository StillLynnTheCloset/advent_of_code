package com.stilllynnthecloset.advent2021

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day12Test {
    @Test
    fun exampleA() {
        assertEquals(19, day12a(readFile("2021/day12example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(5457, day12a(readFile("2021/day12input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(103, day12b(readFile("2021/day12example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(128506, day12b(readFile("2021/day12input.txt")))
    }
}
