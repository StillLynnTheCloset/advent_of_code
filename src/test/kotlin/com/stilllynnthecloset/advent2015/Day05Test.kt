package com.stilllynnthecloset.advent2015

import com.stilllynnthecloset.readFile
import org.junit.Test
import kotlin.test.assertEquals

class Day05Test {
    @Test
    fun examplesA() {
        assertEquals(1, day05a("ugknbfddgicrmopn"))
        assertEquals(1, day05a("aaa"))
        assertEquals(0, day05a("jchzalrnumimnmhp"))
        assertEquals(0, day05a("haegwjzuvuyypxyu"))
        assertEquals(0, day05a("dvszwmarrgswjxmb"))
    }

    @Test
    fun testA() {
        assertEquals(236, day05a(readFile("2015/day5input.txt")))
    }

    @Test
    fun examplesB() {
        assertEquals(1, day05b("qjhvhtzxzqqjkmpb"))
        assertEquals(1, day05b("xxyxx"))
        assertEquals(0, day05b("uurcxstgmygtbstg"))
        assertEquals(0, day05b("ieodomkazucvgmuy"))
        assertEquals(0, day05b("aaa"))
        assertEquals(1, day05b("xyxy"))
        assertEquals(1, day05b("aaaa"))
    }

    @Test
    fun testB() {
        assertEquals(51, day05b(readFile("2015/day5input.txt")))
    }
}
