import kotlin.test.Test
import kotlin.test.assertEquals

internal class SampleTest {
    private val testSample: Sample = Sample()

    @Test
    fun testSum() {
        val expected = 42
        val result = testSample.sum(40, 2);
        assertEquals(expected, result)
    }
}