import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.times

class CalculatorServiceTest {

    private val calculator = mock<Calculator>()
    private val calculatorService = CalculatorService(calculator)

    @Test
    fun `power of 2 to the 3 using service returns 8`() {
        doReturn(8.0).`when`(calculator).power(2.0, 3.0)

        val result = calculatorService.performPower(2.0, 3.0)

        assertEquals(8.0, result)
        verify(calculator, times(1)).power(2.0, 3.0)
    }

    @Test
    fun `square root of 4 using service returns 2`() {
        doReturn(2.0).`when`(calculator).sqrt(4.0)

        val result = calculatorService.performSqrt(4.0)

        assertEquals(2.0, result)
        verify(calculator, times(1)).sqrt(4.0)
    }

    @Test
    fun `modulus of 10 by 3 using service returns 1`() {
        doReturn(1.0).`when`(calculator).modulus(10.0, 3.0)

        val result = calculatorService.performModulus(10.0, 3.0)

        assertEquals(1.0, result)
        verify(calculator, times(1)).modulus(10.0, 3.0)
    }
}

class IntegrationTest {

    @Test
    fun `test calculator service with real calculator`() {
        val calculator = Calculator()
        val calculatorService = CalculatorService(calculator)

        val result = calculatorService.performAddition(2.0, 3.0)

        assertEquals(5.0, result)
    }

    @Test
    fun `test calculator service with mocked calculator`() {
        val calculator = mock<Calculator>()
        doReturn(5.0).`when`(calculator).add(2.0, 3.0)
        val calculatorService = CalculatorService(calculator)

        val result = calculatorService.performAddition(2.0, 3.0)

        assertEquals(5.0, result)
    }
}

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `addition of 2 and 3 returns 5`() {
        val result = calculator.add(2.0, 3.0)
        assertEquals(5.0, result)
    }

    @Test
    fun `subtraction of 2 from 3 returns -1`() {
        val result = calculator.subtract(2.0, 3.0)
        assertEquals(-1.0, result)
    }

    @Test
    fun `multiplication of 2 and 3 returns 6`() {
        val result = calculator.multiply(2.0, 3.0)
        assertEquals(6.0, result)
    }

    @Test
    fun `division of 6 by 3 returns 2`() {
        val result = calculator.divide(6.0, 3.0)
        assertEquals(2.0, result)
    }

    @Test
    fun `power of 2 to the 3 returns 8`() {
        val result = calculator.power(2.0, 3.0)
        assertEquals(8.0, result)
    }

    @Test
    fun `square root of 4 returns 2`() {
        val result = calculator.sqrt(4.0)
        assertEquals(2.0, result)
    }

    @Test
    fun `modulus of 10 by 3 returns 1`() {
        val result = calculator.modulus(10.0, 3.0)
        assertEquals(1.0, result)
    }

    @Test
    fun `division of 10 by zero throws IllegalArgumentException`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.divide(10.0, 0.0)
        }
        assertEquals("Cannot divide by zero", exception.message)
    }

    @Test
    fun `square root of negative 1 throws IllegalArgumentException`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.sqrt(-1.0)
        }
        assertEquals("Cannot take square root of negative number", exception.message)
    }
}