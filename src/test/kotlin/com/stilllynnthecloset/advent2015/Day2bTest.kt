package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day2bTest {
    @Test
    fun examples() {
        assertEquals(34, day2b("2x3x4"))
        assertEquals(14, day2b("1x1x10"))
    }

    @Test
    fun test() {
        assertEquals(3812909, day2b(readFile("2015/day2input.txt")))
    }
}
