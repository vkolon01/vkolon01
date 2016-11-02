import java.math.*;

/**
 * Simple test class for the Fraction class.
 *
 * @author Carsten Fuhs
 */
public class FractionMain {

    /**
     * @param args Ignored.
     */
    public static void main(String[] args) {
        Fraction[] allFractions = {
            new Fraction(12,5),    // 0
            new Fraction(-1,2),    // 1
            new Fraction(BigInteger.ONE,new BigInteger("123456789012345678901234567890")),  // 2
            new Fraction(1),       // 3
            new Fraction(5,3),     // 4
            new Fraction(-10,-6),  // 5
            new Fraction(5,-10),   // 6
            new Fraction(-12,24),  // 7
            new Fraction(4,2),     // 8
            new Fraction(BigInteger.valueOf(-2)),   // 9
            new Fraction(BigInteger.valueOf(-2), BigInteger.ONE),  // 10
            new Fraction(0),       // 11
            new Fraction(0,3),     // 12
            new Fraction(4,0),     // 13
            new Fraction(0)        // 14
        };

        Fraction[] someFractionsNull = {
            new Fraction(5,7),  // 0
            null,               // 1
            new Fraction(2,8),  // 2
        };

        Fraction[] allFractionsNonNull = {
            new Fraction(5,-10),  // 0
            new Fraction(5,3),    // 1
            new Fraction(12,5),   // 2
        };

        System.out.println("(01) add:");
        System.out.println("ACTUAL:   " + allFractions[0].add(allFractions[1]));
        System.out.println("EXPECTED: " + "(19 / 10)");

        System.out.println("(02) add:");
        System.out.println("ACTUAL:   " + allFractions[0].add(allFractions[10]));
        System.out.println("EXPECTED: " + "(2 / 5)");

        System.out.println("(03) subtract:");
        System.out.println("ACTUAL:   " + allFractions[9].subtract(allFractions[4]));
        System.out.println("EXPECTED: " + "(-11 / 3)");

        System.out.println("(04) multiply:");
        System.out.println("ACTUAL:   " + allFractions[2].multiply(allFractions[6]));
        System.out.println("EXPECTED: " + "(-1 / 246913578024691357802469135780)");

        System.out.println("(05) divide:");
        System.out.println("ACTUAL:   " + allFractions[0].divide(allFractions[8]));
        System.out.println("EXPECTED: " + "(6 / 5)");

        System.out.println("(06) negate:");
        System.out.println("ACTUAL:   " + allFractions[6].negate());
        System.out.println("EXPECTED: " + "(1 / 2)");

        System.out.println("(07) negate:");
        System.out.println("ACTUAL:   " + allFractions[4].negate());
        System.out.println("EXPECTED: " + "(-5 / 3)");

        System.out.println("(08) invert:");
        System.out.println("ACTUAL:   " + allFractions[4].invert());
        System.out.println("EXPECTED: " + "(3 / 5)");

        System.out.println("(09) signum:");
        System.out.println("ACTUAL:   " + allFractions[2].signum());
        System.out.println("EXPECTED: " + "1");

        System.out.println("(10) signum:");
        System.out.println("ACTUAL:   " + allFractions[11].signum());
        System.out.println("EXPECTED: " + "0");

        System.out.println("(11) signum:");
        System.out.println("ACTUAL:   " + allFractions[7].signum());
        System.out.println("EXPECTED: " + "-1");

        System.out.println("(12) abs:");
        System.out.println("ACTUAL:   " + allFractions[2].abs());
        System.out.println("EXPECTED: " + "(1 / 123456789012345678901234567890)");

        System.out.println("(13) abs:");
        System.out.println("ACTUAL:   " + allFractions[7].abs());
        System.out.println("EXPECTED: " + "(1 / 2)");

        System.out.println("(14) max:");
        System.out.println("ACTUAL:   " + allFractions[2].max(allFractions[4]));
        System.out.println("EXPECTED: " + "(5 / 3)");

        System.out.println("(15) max:");
        System.out.println("ACTUAL:   " + allFractions[4].max(allFractions[2]));
        System.out.println("EXPECTED: " + "(5 / 3)");

        System.out.println("(16) min:");
        System.out.println("ACTUAL:   " + allFractions[2].min(allFractions[4]));
        System.out.println("EXPECTED: " + "(1 / 123456789012345678901234567890)");

        System.out.println("(17) min:");
        System.out.println("ACTUAL:   " + allFractions[4].min(allFractions[2]));
        System.out.println("EXPECTED: " + "(1 / 123456789012345678901234567890)");

        System.out.println("(18) pow:");
        System.out.println("ACTUAL:   " + allFractions[4].pow(2));
        System.out.println("EXPECTED: " + "(25 / 9)");

        System.out.println("(19) pow:");
        System.out.println("ACTUAL:   " + allFractions[4].pow(0));
        System.out.println("EXPECTED: " + "1");

        System.out.println("(20) pow:");
        System.out.println("ACTUAL:   " + allFractions[4].pow(-3));
        System.out.println("EXPECTED: " + "(27 / 125)");

        System.out.println("(21) compareTo:");
        System.out.println("ACTUAL:   " + allFractions[9].compareTo(allFractions[10]));
        System.out.println("EXPECTED: " + "0");

        System.out.println("(22) compareTo:");
        System.out.println("ACTUAL:   " + allFractions[9].compareTo(allFractions[9]));
        System.out.println("EXPECTED: " + "0");

        System.out.println("(23) compareTo:");
        System.out.println("ACTUAL:   " + allFractions[11].compareTo(allFractions[13]));
        System.out.println("EXPECTED: " + "0");

        System.out.println("(24) compareTo:");
        System.out.println("ACTUAL:   " + allFractions[4].compareTo(allFractions[0]));
        System.out.println("EXPECTED: " + "-1");

        System.out.println("(25) compareTo:");
        System.out.println("ACTUAL:   " + allFractions[0].compareTo(allFractions[4]));
        System.out.println("EXPECTED: " + "1");

        System.out.println("(26) isEqualTo:");
        System.out.println("ACTUAL:   " + allFractions[0].isEqualTo(allFractions[4]));
        System.out.println("EXPECTED: " + "false");

        System.out.println("(27) isEqualTo:");
        System.out.println("ACTUAL:   " + allFractions[12].isEqualTo(allFractions[13]));
        System.out.println("EXPECTED: " + "true");

        System.out.println("(28) isEqualTo:");
        System.out.println("ACTUAL:   " + allFractions[12].isEqualTo(null));
        System.out.println("EXPECTED: " + "false");

        System.out.println("(29) toString:");
        System.out.println("ACTUAL:   " + allFractions[12]);
        System.out.println("EXPECTED: " + "0");

        System.out.println("(30) toString:");
        System.out.println("ACTUAL:   " + allFractions[7]);
        System.out.println("EXPECTED: " + "(-1 / 2)");

        System.out.println("(31) toString:");
        System.out.println("ACTUAL:   " + allFractions[8]);
        System.out.println("EXPECTED: " + "2");

        System.out.println("(32) sumAll:");
        System.out.println("ACTUAL:   " + Fraction.sumAll(allFractionsNonNull));
        System.out.println("EXPECTED: " + "(107 / 30)");

        System.out.println("(33) sumAll:");
        System.out.println("ACTUAL:   " + Fraction.sumAll(someFractionsNull));
        System.out.println("EXPECTED: " + "null");
    }
}
