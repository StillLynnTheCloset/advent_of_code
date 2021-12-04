package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day1Test {
    @Test
    fun examplesA() {
        assertEquals(0, day1a("(())"))
        assertEquals(0, day1a("()()"))
        assertEquals(3, day1a("((("))
        assertEquals(3, day1a("(()(()("))
        assertEquals(3, day1a("))((((("))
        assertEquals(-1, day1a("())"))
        assertEquals(-1, day1a("))("))
        assertEquals(-3, day1a(")))"))
        assertEquals(-3, day1a(")())())"))
    }

    @Test
    fun testA() {
        assertEquals(138, day1a(readFile("2015/day1input.txt")))
    }

    @Test
    fun examplesB() {
        assertEquals(1, day1b(")"))
        assertEquals(5, day1b("()())"))
    }

    @Test
    fun testB() {
        assertEquals(1771, day1b(readFile("2015/day1input.txt")))
    }
}
