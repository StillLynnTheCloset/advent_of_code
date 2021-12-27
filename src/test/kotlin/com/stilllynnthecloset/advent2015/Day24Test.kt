package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day24Test {
    @Test
    fun exampleA() {
        assertEquals(0, day24a(readFile("2015/day24example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day24a(readFile("2015/day24input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day24b(readFile("2015/day24example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day24b(readFile("2015/day24input.txt")))
    }
}
