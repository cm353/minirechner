package com.example.minirechner;

public class CalculatorUtil {

    private CalculatorUtil(){};

    public static Double add(Double number1, Double number2) {
        return number1 + number2;
    }

    public static Double subtract(Double number1, Double number2) {
        return number1 - number2;
    }

    public static Double multiply(Double number1, Double number2) {
        return number1 * number2;
    }

    public static Double divide(Double number1, Double number2) throws ArithmeticException {
        if (number2 == 0.0)
            throw new ArithmeticException();
        return number1 / number2;
    }
}
