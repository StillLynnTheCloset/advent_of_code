package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day21Test {
    @Test
    fun exampleA() {
        assertEquals(0, day21a(readFile("2015/day21example.txt")))
    }

    @Test
    fun testA() {
        assertEquals(0, day21a(readFile("2015/day21input.txt")))
    }

    @Test
    fun exampleB() {
        assertEquals(0, day21b(readFile("2015/day21example.txt")))
    }

    @Test
    fun testB() {
        assertEquals(0, day21b(readFile("2015/day21input.txt")))
    }
}
