package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day02Test {
    @Test
    fun examplesA() {
        assertEquals(58, day02a("2x3x4"))
        assertEquals(43, day02a("1x1x10"))
    }

    @Test
    fun testA() {
        assertEquals(1598415, day02a(readFile("2015/day2input.txt")))
    }

    @Test
    fun examplesB() {
        assertEquals(34, day02b("2x3x4"))
        assertEquals(14, day02b("1x1x10"))
    }

    @Test
    fun testB() {
        assertEquals(3812909, day02b(readFile("2015/day2input.txt")))
    }
}
