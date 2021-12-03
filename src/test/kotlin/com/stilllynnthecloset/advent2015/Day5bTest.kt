package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day5bTest {
    @Test
    fun examples() {
        assertEquals(1, day5b("qjhvhtzxzqqjkmpb"))
        assertEquals(1, day5b("xxyxx"))
        assertEquals(0, day5b("uurcxstgmygtbstg"))
        assertEquals(0, day5b("ieodomkazucvgmuy"))
        assertEquals(0, day5b("aaa"))
        assertEquals(1, day5b("xyxy"))
        assertEquals(1, day5b("aaaa"))
    }

    @Test
    fun test() {
        assertEquals(51, day5b(readFile("2015/day5input.txt")))
    }
}
