package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day4Test {
    @Test
    fun examplesA() {
        assertEquals(609043, day4a("abcdef"))
        assertEquals(1048970, day4a("pqrstuv"))
    }

    @Test
    fun testA() {
        assertEquals(254575, day4a(readFile("2015/day4input.txt")))
    }

    @Test
    fun examplesB() {
        // None given
    }

    @Test
    fun testB() {
        assertEquals(1038736, day4b(readFile("2015/day4input.txt")))
    }
}
