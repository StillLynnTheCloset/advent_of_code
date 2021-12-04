package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day5Test {
    @Test
    fun examplesA() {
        assertEquals(1, day5a("ugknbfddgicrmopn"))
        assertEquals(1, day5a("aaa"))
        assertEquals(0, day5a("jchzalrnumimnmhp"))
        assertEquals(0, day5a("haegwjzuvuyypxyu"))
        assertEquals(0, day5a("dvszwmarrgswjxmb"))
    }

    @Test
    fun testA() {
        assertEquals(236, day5a(readFile("2015/day5input.txt")))
    }

    @Test
    fun examplesB() {
        assertEquals(1, day5b("qjhvhtzxzqqjkmpb"))
        assertEquals(1, day5b("xxyxx"))
        assertEquals(0, day5b("uurcxstgmygtbstg"))
        assertEquals(0, day5b("ieodomkazucvgmuy"))
        assertEquals(0, day5b("aaa"))
        assertEquals(1, day5b("xyxy"))
        assertEquals(1, day5b("aaaa"))
    }

    @Test
    fun testB() {
        assertEquals(51, day5b(readFile("2015/day5input.txt")))
    }
}
