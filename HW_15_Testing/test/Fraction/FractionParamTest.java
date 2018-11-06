package Fraction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FractionParamTest {

    private final int firstNominator;
    private final int firstDenominator;
    private Fraction firstFraction;
    private final double firstDoubleNumber;
    private final String firstToStringResult;

    private final int secondNominator;
    private final int secondDenominator;
    private Fraction secondFraction;
    private final double secondDoubleNumber;

    private final Fraction multiplicationResult;
    private final Fraction divisionResult;
    private final Fraction summationResult;
    private final Boolean hashCodesAreEqual;
    private final Boolean equalsIsTrue;

    @Before
    public void initialize() {
        firstFraction = new Fraction(this.firstNominator, this.firstDenominator);
        secondFraction = new Fraction(this.secondNominator, this.secondDenominator);
    }

    @Parameterized.Parameters(name = "{index}: " +
            "Fraction.Fraction #1 (F1): {0}/{1}, " +
            "Fraction.Fraction #2 (F2): {2}/{3}; " +
            "F1 toSting(): {4}; " +
            "F1 double number: {5}; " +
            "F2 double number: {6}; " +
            "Multiplication result: {7}; " +
            "Division result: {8}; " +
            "Summation result: {9}. " +
            "Fractions are equal: {10}, " +
            "Hash codes are equal: {11}."
    )
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {1, 10, 3, 5, "1/10", 0.1, 0.6, new Fraction(6, 100), new Fraction(10, 60), new Fraction(35, 50), false, false}, // F1 is proper
            // {11, 10, 3, 5, "11/10", 1.10, 0.6, new Fraction.Fraction(66, 100), new Fraction.Fraction(110, 60), new Fraction.Fraction(85, 50)}, // F1 is improper FIXME fix the code (`convert()`)
            {1, 10, 10, 1, "1/10", 0.1, 10, new Fraction(100, 100), new Fraction(10, 1000), new Fraction(101, 10), false, false}, // F1 and F2 are reverse
            {0, 10, 3, 5, "0/10", 0.0, 0.6, new Fraction(0, 100), new Fraction(0, 60), new Fraction(30, 50), false, false}, // F1 nominator is zero
            {1, 10, 0, 5, "1/10", 0.1, 0.0, new Fraction(0, 100), new Fraction(10, 0), new Fraction(5, 50), false, false}, // F2 nominator is zero FIXME: should raise an exception (zero division)
            {1, 10, 1, 10, "1/10", 0.1, 0.1, new Fraction(1, 100), new Fraction(10, 10), new Fraction(2, 10), true, true}, // F1 and F2 are equal
        });
    }

    public FractionParamTest(int firstNominator,
                             int firstDenominator,
                             int secondNominator,
                             int secondDenominator,
                             String firstToStringResult,
                             double firstDoubleNumber,
                             double secondDoubleNumber,
                             Fraction multiplicationResult,
                             Fraction divisionResult,
                             Fraction summationResult,
                             Boolean hashCodesAreEqual,
                             Boolean equalsIsTrue
    ) {
        this.firstNominator = firstNominator;
        this.firstDenominator = firstDenominator;
        this.firstDoubleNumber = firstDoubleNumber;
        this.firstToStringResult = firstToStringResult;
        this.secondNominator = secondNominator;
        this.secondDenominator = secondDenominator;
        this.secondDoubleNumber = secondDoubleNumber;
        this.multiplicationResult = multiplicationResult;
        this.divisionResult = divisionResult;
        this.summationResult = summationResult;
        this.hashCodesAreEqual = hashCodesAreEqual;
        this.equalsIsTrue = equalsIsTrue;
    }


    @Test
    public void toStringTest() {
        assertEquals(firstToStringResult, firstFraction.toString());
    }

    @Test
    public void convertTest() {
        assertEquals(firstFraction, Fraction.convert(firstDoubleNumber));
    }

    @Test
    public void multTest() {
        assertEquals(multiplicationResult, firstFraction.mult(secondDoubleNumber));
    }

    @Test
    public void divideTest() {
        assertEquals(divisionResult, firstFraction.divide(secondDoubleNumber));
    }

    @Test
    public void sumTest() {
        assertEquals(summationResult, firstFraction.sum(secondFraction));
    }

    @Test
    public void equalsTest() {
        assertEquals(firstFraction.equals(secondFraction), equalsIsTrue);
    }

    @Test
    public void hashCodeTest() {
        assertEquals(firstFraction.hashCode()== secondFraction.hashCode(), hashCodesAreEqual);
    }

}
