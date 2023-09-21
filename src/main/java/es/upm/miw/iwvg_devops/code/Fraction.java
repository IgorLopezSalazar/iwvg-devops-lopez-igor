package es.upm.miw.iwvg_devops.code;

/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper() {
        return numerator < denominator;
    }
    public boolean isImproper() {
        return numerator > denominator;
    }
    public boolean isEquivalent(Fraction fraction) {
        int product1 = numerator * fraction.getDenominator();
        int product2 = fraction.getNumerator() * denominator;
        return product1 == product2;
    }
    public Fraction add(Fraction fraction){
        int newNumerator = numerator * fraction.getDenominator() + fraction.getNumerator() * denominator;
        int newDenominator = denominator * fraction.getDenominator();

        Fraction answer = new Fraction(newNumerator, newDenominator);
        answer.simplifyFraction();

        return answer;
    }
    public void simplifyFraction() {
        if (denominator != 0) {
            int temp;
            int a = numerator;
            int b = denominator;
            while (a != 0) {
                temp = b % a;
                b = a;
                a = temp;
            }
            numerator /= b;
            denominator /= b;
        }
    }
    public Fraction multiply(Fraction fraction){
        int newNumerator = numerator * fraction.getNumerator();
        int newDenominator = denominator * fraction.getDenominator();

        Fraction answer = new Fraction(newNumerator, newDenominator);
        answer.simplifyFraction();

        return answer;
    }
    public Fraction divide(Fraction fraction){
        fraction.swipeFraction();
        return this.multiply(fraction);
    }
    private void swipeFraction() {
        int tmp = numerator;
        numerator = denominator;
        denominator = tmp;
    }
    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Fraction other = (Fraction) obj;
        return numerator == other.getNumerator() &&
                denominator == other.getDenominator();
    }
    @Override
    public int hashCode() {
        int result = 5;
        result = 3 * result + numerator;
        result = 3 * result + denominator;
        return result;
    }
}
