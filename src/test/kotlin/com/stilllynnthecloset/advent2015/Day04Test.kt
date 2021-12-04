package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day04Test {
    @Test
    fun examplesA() {
        assertEquals(609043, day04a("abcdef"))
        assertEquals(1048970, day04a("pqrstuv"))
    }

    @Test
    fun testA() {
        assertEquals(254575, day04a(readFile("2015/day04input.txt")))
    }

    @Test
    fun examplesB() {
        // None given
    }

    @Test
    fun testB() {
        assertEquals(1038736, day04b(readFile("2015/day04input.txt")))
    }
}
