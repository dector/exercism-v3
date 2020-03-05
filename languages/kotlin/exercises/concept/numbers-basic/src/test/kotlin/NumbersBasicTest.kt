import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumbersBasicTest {

    @Test
    fun `integers`() {
        assertEquals(4, sum(2, 2))
    }

    @Test
    fun `decimals`() {
        assertEquals(4.0, sum(2.5, 1.5))
    }
}
