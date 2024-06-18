class CalculatorService(private val calculator: Calculator) {

    fun performAddition(a: Double, b: Double): Double {
        return calculator.add(a, b)
    }

    fun performSubtraction(a: Double, b: Double): Double {
        return calculator.subtract(a, b)
    }

    fun performMultiplication(a: Double, b: Double): Double {
        return calculator.multiply(a, b)
    }

    fun performDivision(a: Double, b: Double): Double {
        return calculator.divide(a, b)
    }

    fun performPower(a: Double, b: Double): Double {
        return calculator.power(a, b)
    }

    fun performSqrt(a: Double): Double {
        return calculator.sqrt(a)
    }

    fun performModulus(a: Double, b: Double): Double {
        return calculator.modulus(a, b)
    }
}