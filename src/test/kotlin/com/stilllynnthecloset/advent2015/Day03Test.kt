package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day03Test {
    @Test
    fun examplesA() {
        assertEquals(2, day03a(">"))
        assertEquals(4, day03a("^>v<"))
        assertEquals(2, day03a("^v^v^v^v^v"))
    }

    @Test
    fun testA() {
        assertEquals(2081, day03a(readFile("2015/day3input.txt")))
    }

    @Test
    fun examplesB() {
        assertEquals(2, day03b(">"))
        assertEquals(3, day03b("^v"))
        assertEquals(3, day03b("^>v<"))
        assertEquals(11, day03b("^v^v^v^v^v"))
    }

    @Test
    fun testB() {
        assertEquals(2341, day03b(readFile("2015/day3input.txt")))
    }
}
