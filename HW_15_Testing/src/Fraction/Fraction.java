package Fraction;

public class Fraction {
    int x;
    int y;

    public Fraction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "/" + y;
    }

    public Fraction mult(double fr) {
        Fraction second = convert(fr);
        // TODO: simplify (reduce) the fraction, here and in other cases
        return new Fraction(this.x * second.x, this.y * second.y);
    }

    public Fraction divide(double fr) {
        Fraction second = convert(fr);
        return new Fraction(this.x * second.y, this.y * second.x);
    }

    public static Fraction convert(double fraction) {
        int x = (int) fraction;
        double xRest = fraction - x;
        String xStr = Double.toString(xRest);
        int zeroes = xStr.length() - 2;
        int ten = (int) Math.pow(10.0, zeroes);
        return new Fraction((int) (fraction * ten), ten);
    }

    public Fraction sum(Fraction a) {
        return (y == a.y) ? new Fraction(this.x + a.x, y) : new Fraction((this.x * a.y) + (a.x * this.y), this.y * a.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (x != fraction.x) return false;
        return y == fraction.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
