package com.stilllynnthecloset.advent2016

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day22Test {
    @Test
    fun exampleA() {
        assertEquals(0, day22a(readFile("2016/day22example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day22a(readFile("2016/day22input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day22b(readFile("2016/day22example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day22b(readFile("2016/day22input.txt")))
    }
}
