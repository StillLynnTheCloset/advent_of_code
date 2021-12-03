package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day3aTest {
    @Test
    fun examples() {
        assertEquals(2, day3a(">"))
        assertEquals(4, day3a("^>v<"))
        assertEquals(2, day3a("^v^v^v^v^v"))
    }

    @Test
    fun test() {
        assertEquals(2081, day3a(readFile("2015/day3input.txt")))
    }
}
