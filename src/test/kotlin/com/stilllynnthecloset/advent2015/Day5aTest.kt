package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day5aTest {
    @Test
    fun examples() {
        assertEquals(1, day5a("ugknbfddgicrmopn"))
        assertEquals(1, day5a("aaa"))
        assertEquals(0, day5a("jchzalrnumimnmhp"))
        assertEquals(0, day5a("haegwjzuvuyypxyu"))
        assertEquals(0, day5a("dvszwmarrgswjxmb"))
    }

    @Test
    fun test() {
        assertEquals(236, day5a(readFile("2015/day5input.txt")))
    }
}
