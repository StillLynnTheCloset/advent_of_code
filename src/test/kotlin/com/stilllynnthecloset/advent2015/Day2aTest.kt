package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day2aTest {
    @Test
    fun examples() {
        assertEquals(58, day2a("2x3x4"))
        assertEquals(43, day2a("1x1x10"))
    }

    @Test
    fun test() {
        assertEquals(1598415, day2a(readFile("2015/day2input.txt")))
    }
}
