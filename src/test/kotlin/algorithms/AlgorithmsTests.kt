package algorithms

import Algorithms
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

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
}


