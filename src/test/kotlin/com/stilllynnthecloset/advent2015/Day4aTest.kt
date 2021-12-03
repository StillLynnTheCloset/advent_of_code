package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day4aTest {
    @Test
    fun examples() {
        assertEquals(609043, day4a("abcdef"))
        assertEquals(1048970, day4a("pqrstuv"))
    }

    @Test
    fun test() {
        assertEquals(254575, day4a(readFile("2015/day4input.txt")))
    }
}
