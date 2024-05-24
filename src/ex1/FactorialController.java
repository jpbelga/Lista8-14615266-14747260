package ex1;

import java.math.BigInteger;

public class FactorialController {
    public BigInteger calculateFactorial(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Número deve ser não negativo.");
        }
        return factorial(number);
    }

    private BigInteger factorial(int number) {
        BigInteger num = BigInteger.ONE;
        for (int i = 2; i <= number; i++)
            num = num.multiply(BigInteger.valueOf(i));
        return num;
    }
}