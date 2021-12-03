package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day1bTest {
    @Test
    fun examples() {
        assertEquals(1, day1b(")"))
        assertEquals(5, day1b("()())"))
    }

    @Test
    fun test() {
        assertEquals(1771, day1b(readFile("2015/day1input.txt")))
    }
}
