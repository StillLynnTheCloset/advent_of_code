package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day01Test {
    @Test
    fun examplesA() {
        assertEquals(0, day01a("(())"))
        assertEquals(0, day01a("()()"))
        assertEquals(3, day01a("((("))
        assertEquals(3, day01a("(()(()("))
        assertEquals(3, day01a("))((((("))
        assertEquals(-1, day01a("())"))
        assertEquals(-1, day01a("))("))
        assertEquals(-3, day01a(")))"))
        assertEquals(-3, day01a(")())())"))
    }

    @Test
    fun testA() {
        assertEquals(138, day01a(readFile("2015/day01input.txt")))
    }

    @Test
    fun examplesB() {
        assertEquals(1, day01b(")"))
        assertEquals(5, day01b("()())"))
    }

    @Test
    fun testB() {
        assertEquals(1771, day01b(readFile("2015/day01input.txt")))
    }
}
