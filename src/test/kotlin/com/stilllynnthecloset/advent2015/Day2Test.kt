package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day2Test {
    @Test
    fun examplesA() {
        assertEquals(58, day2a("2x3x4"))
        assertEquals(43, day2a("1x1x10"))
    }

    @Test
    fun testA() {
        assertEquals(1598415, day2a(readFile("2015/day2input.txt")))
    }

    @Test
    fun examplesB() {
        assertEquals(34, day2b("2x3x4"))
        assertEquals(14, day2b("1x1x10"))
    }

    @Test
    fun testB() {
        assertEquals(3812909, day2b(readFile("2015/day2input.txt")))
    }
}
