package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day1aTest {
    @Test
    fun examples() {
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
    fun test() {
        assertEquals(138, day1a(readFile("2015/day1input.txt")))
    }
}
