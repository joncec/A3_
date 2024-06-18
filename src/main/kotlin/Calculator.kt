class Calculator {
    fun add(a: Double, b: Double): Double {
        return a + b
    }

    fun subtract(a: Double, b: Double): Double {
        return a - b
    }

    fun multiply(a: Double, b: Double): Double {
        return a * b
    }

    fun divide(a: Double, b: Double): Double {
        if (b == 0.0) {
            throw IllegalArgumentException("Cannot divide by zero")
        }
        return a / b
    }

    fun power(a: Double, b: Double): Double {
        return Math.pow(a, b)
    }

    fun sqrt(a: Double): Double {
        if (a < 0) {
            throw IllegalArgumentException("Cannot take square root of negative number")
        }
        return Math.sqrt(a)
    }

    fun modulus(a: Double, b: Double): Double {
        return a % b
    }
}