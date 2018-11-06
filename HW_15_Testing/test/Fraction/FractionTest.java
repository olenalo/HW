package Fraction;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {
    @Test
    public void multTest() {
        Fraction actual = new Fraction(3, 4).mult(0.1);
        Fraction expected = new Fraction(3, 40);
        assertEquals(expected, actual);
    }

    @Test
    public void divideTest() {

        Fraction actual = new Fraction(3, 4).divide(0.1);
        Fraction expected = new Fraction(30, 4);
        
        assertEquals(expected, actual);
    }

    @Test
    public void convertTest() {
        Fraction fraction = Fraction.convert(0.1);
        Fraction expected = new Fraction(1, 10);
        assertEquals(expected, fraction);
    }

    @Test
    public void sumTest() {
        Fraction actual = new Fraction(3, 4).sum(new Fraction(3, 4));
        Fraction expected = new Fraction(6, 4);
        assertEquals(expected, actual);
    }

}