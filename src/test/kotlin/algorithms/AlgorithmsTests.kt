package algorithms

import Algorithms
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.assertEquals

internal class AlgorithmsTests {
    private val algorithms: Algorithms = Algorithms()

    @Test
    fun testCanConstruct() {
        val expectedTrue = algorithms.canConstruct("hello", listOf("hi", "hel", "ll", "lo"))
        val expectedTrueTwo = algorithms.canConstruct("", listOf("", "hel", "ll", "lo"))
        val expectedFalse = algorithms.canConstruct("blah", listOf("bla", "hel", "ll", "lah"))
        val expectedFalseTwo = algorithms.canConstruct(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
            listOf(
                "e",
                "eee",
                "eeee",
                "eeeeeeee",
                "eeeeeeeee",
                "eeeeeeeeee",
                "eeeeeeeeeeeeeeeeeeeee",
            ))

        assertTrue { expectedTrue }
        assertTrue { expectedTrueTwo }
        assertFalse { expectedFalse }
        assertFalse { expectedFalseTwo }
    }

    @Test
    fun testCountConstruct() {
        val actualOne = algorithms.countConstruct("abcdef", listOf("ab", "abc", "cd", "def", "abcd"))
        val actualTwo = algorithms.countConstruct("purple", listOf("purp", "p", "ur", "le", "purpl"))
        val actualThree = algorithms.countConstruct("skateboard", listOf("bo", "rd", "ate", "ska", "stk", "boar"))
        var expectedFour: Int
        val timeInMillis = measureTimeMillis {
            expectedFour = algorithms.countConstruct(
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                listOf(
                    "e",
                    "eee",
                    "eeee",
                    "eeeeeeee",
                    "eeeeeeeee",
                    "eeeeeeeeee",
                    "eeeeeeeeeeeeeeeeeeeee",
                ))
        }

        println("runtime: $timeInMillis")

        assertEquals(1, actualOne)
        assertEquals(2, actualTwo)
        assertEquals(0, actualThree)
        assertEquals(0, expectedFour)
    }

    @Test
    fun testRomanNumerals() {
        val resultOne: String = algorithms.createRomans(0)
        val resultTwo: String = algorithms.createRomans(1)
        val resultThree: String = algorithms.createRomans(3)
        val resultFour: String = algorithms.createRomans(4)
        val resultFive: String = algorithms.createRomans(6)
        val resultSix: String = algorithms.createRomans(49)
        var resultSeven: String

        val timeInMillis = measureTimeMillis {
            resultSeven = algorithms.createRomans(999)
        }

        println("runtime: $timeInMillis")

        assertEquals("", resultOne)
        assertEquals("I", resultTwo)
        assertEquals("III", resultThree)
        assertEquals("IV", resultFour)
        assertEquals("VI", resultFive)
        assertEquals("XLIX", resultSix)
        assertEquals("CMXCIX", resultSeven)
    }

    @Test
    fun testAllConstruct() {
        val resultOne = algorithms.allConstruct("", listOf())
        val resultTwo = algorithms.allConstruct("", listOf("cat", "dog", "mouse"))
        val resultThree = algorithms.allConstruct("hello", listOf("cat", "dog", "mouse"))
//        val resultFour = algorithms.allConstruct("purple", listOf("purp", "p", "ur", "le", "purpl"))

        assertEquals(listOf(), resultOne)
//        assertEquals(listOf(listOf()), resultTwo) // "", ["cat", "dog", "mouse"] => [[]] (if we get to an empty string, we'll have an inner list)
//        assertEquals(listOf(), resultThree) // "hello", ["cat", "dog", "mouse"] => [] (can't make any)
//        assertEquals(listOf(
//            listOf("purp", "le"),
//            listOf("p", "ur", "p", "le"),
//            ),
//            resultFour
//        )
    }
}


