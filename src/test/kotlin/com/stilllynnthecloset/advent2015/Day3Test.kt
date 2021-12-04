package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day3Test {
    @Test
    fun examplesA() {
        assertEquals(2, day3a(">"))
        assertEquals(4, day3a("^>v<"))
        assertEquals(2, day3a("^v^v^v^v^v"))
    }

    @Test
    fun testA() {
        assertEquals(2081, day3a(readFile("2015/day3input.txt")))
    }

    @Test
    fun examplesB() {
        assertEquals(2, day3b(">"))
        assertEquals(3, day3b("^v"))
        assertEquals(3, day3b("^>v<"))
        assertEquals(11, day3b("^v^v^v^v^v"))
    }

    @Test
    fun testB() {
        assertEquals(2341, day3b(readFile("2015/day3input.txt")))
    }
}
