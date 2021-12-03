package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day3bTest {
    @Test
    fun examples() {
        assertEquals(2, day3b(">"))
        assertEquals(3, day3b("^v"))
        assertEquals(3, day3b("^>v<"))
        assertEquals(11, day3b("^v^v^v^v^v"))
    }

    @Test
    fun test() {
        assertEquals(2341, day3b(readFile("2015/day3input.txt")))
    }
}
