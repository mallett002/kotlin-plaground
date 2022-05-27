package algorithms

import Algorithms
import org.junit.jupiter.api.Test
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
        val expectedFour = algorithms.countConstruct(
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

        assertEquals(1, actualOne)
        assertEquals(2, actualTwo)
        assertEquals(0, actualThree)
        assertEquals(0, expectedFour)
    }

    @Test
    fun testRomanNumerals() {
        val resultOne: String = algorithms.createRomans(0);
        val resultTwo: String = algorithms.createRomans(3);
        val resultThree: String = algorithms.createRomans(4);
        val resultFour: String = algorithms.createRomans(6);

        assertEquals("", resultOne);
        assertEquals("III", resultTwo);
        assertEquals("IV", resultThree);
        assertEquals("VI", resultFour);
    }
}


