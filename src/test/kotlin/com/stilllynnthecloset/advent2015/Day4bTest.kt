package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day4bTest {
    @Test
    fun examples() {
//        assertEquals(609043, day4a("abcdef"))
//        assertEquals(1048970, day4a("pqrstuv"))
    }

    @Test
    fun test() {
        assertEquals(1038736, day4b(readFile("2015/day4input.txt")))
    }
}
