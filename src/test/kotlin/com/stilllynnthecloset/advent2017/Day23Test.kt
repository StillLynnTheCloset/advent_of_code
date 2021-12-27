package com.stilllynnthecloset.advent2017

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day23Test {
    @Test
    fun exampleA() {
        assertEquals(0, day23a(readFile("2017/day23example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day23a(readFile("2017/day23input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day23b(readFile("2017/day23example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day23b(readFile("2017/day23input.txt")))
    }
}