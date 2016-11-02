import java.math.BigInteger;
import java.util.ArrayList;

/**
 * The class Fraction is a datatype for representing fractions. In a/b a being
 * the decimal and b being the fraction.
 * 
 * @author vkolon01
 *
 */
public class Fraction {
	
	private BigInteger numerator;
	private BigInteger denominator;

	// --------------------------------------------------
	// Constructors for the class Fraction

	/**
	 * @param numerator
	 * @param denominator
	 *            Takes parameters of type BigInteger and creates a Fraction
	 *            with a numerator and denominator of type BigInteger.
	 */
	public Fraction(BigInteger numerator, BigInteger denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		simplify(); // Every change to the object will force this method to
					// simplify the fraction.
	}

	/**
	 * @param val
	 *            Takes parameter of type BigIngeger and creates a Fraction with
	 *            a numerator of type BigInteger.
	 */
	public Fraction(BigInteger val) {
		this(val, BigInteger.ONE);
	}

	/**
	 * @param numerator
	 * @param denominator
	 *            Takes parameters of type long and creates a Fraction with a
	 *            numerator and denominator of type BigInteger.
	 */
	public Fraction(long numerator, long denominator) {
		this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
	}

	/**
	 * @param val
	 *            Takes parameter of type long and creates a Fraction with a
	 *            numerator of type BigInteger.
	 */
	public Fraction(long val) {
		this(BigInteger.valueOf(val), BigInteger.ONE);
	}

	// Methods of the class.
	// --------------------------------------------------
	/**
	 * @param val
	 * @return Fraction whose value is (this + val).
	 */
	public Fraction add(Fraction val) {
		return new Fraction(this.numerator.multiply(val.denominator).add(
				this.denominator.multiply(val.numerator)),
				this.denominator.multiply(val.denominator));
	}

	/**
	 * @param val
	 * @return Fraction whose value is (this - val).
	 */
	public Fraction subtract(Fraction val) {
		return add(val.negate());
	}

	/**
	 * @param val
	 * @return Fraction whose value is (this * val).
	 */
	public Fraction multiply(Fraction val) {
		return new Fraction(this.numerator.multiply(val.numerator),
				this.denominator.multiply(val.denominator));
	}

	/**
	 * @param val
	 * @return Fraction whose value is (this / val).
	 */
	public Fraction divide(Fraction val) {
		return new Fraction(this.numerator.multiply(val.denominator),
				this.denominator.multiply(val.numerator));
	}

	/**
	 * @return Returns abstract Fraction.
	 */
	public Fraction abs() {
		return new Fraction(this.numerator.abs(), this.denominator.abs());
	}

	/**
	 * @param exponent
	 * @return Returns a Fraction to the power of the exponent. (this^exponent).
	 */
	public Fraction pow(int exponent) {
		Fraction result = this;

		if (exponent == 0) {
			result = new Fraction(1); //If the exponent is 0 then the result will always be 1.
		} else if (exponent > 0) {
			for (int i = 0; i < exponent - 1; i++) {
				result = result.multiply(this); //Multiplication of the Fraction by the number of the exponent.
			}
			
		} else {
			for (int i = 0; i < Math.abs(exponent - 1); i++) {
				result = result.divide(this); //Division of the Fraction by the number of the exponent when the exponent is smaller than 0.
			}
		}
		return result;
	}

	/**
	 * @return Returns a Fraction whose value is (-this).
	 */
	public Fraction negate() {
		return new Fraction(this.numerator.negate(), this.denominator);
	}

	/**
	 * 
	 * @param val
	 * @return Returns −1, 0 or 1 as this Fraction is numerically less than,
	 *         equal to, or greater than given fraction, respectively.
	 */
	public int compareTo(Fraction val) {
		return this.numerator.divide(this.denominator).compareTo(
				val.numerator.divide(val.denominator));
	}

	/**
	 * 
	 * @param val
	 * @return Returns true if the two fractions have equal values and false
	 *         otherwise.
	 */
	public boolean isEqualTo(Fraction val) {
		if (val == null || this.compareTo(val) != 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * @return This method returns 1 if the fraction is positive, 0 if its 0 and
	 *         -1 when negative. The return value is integer.
	 */
	public int signum() {
		if (this.numerator.signum() == 0)
			return 0;
		if (this.numerator.signum() == -1 && this.denominator.signum() != -1)
			return -1;
		return 1;
	}

	/**
	 * This is a private method and only ran by the constructor. The method is
	 * ran every time the Fraction object is modified therefore does not need to
	 * be called separately.
	 */
	private void simplify() {
		BigInteger gcd = this.numerator.gcd(this.denominator);
		this.numerator = this.numerator.divide(gcd);
		this.denominator = this.denominator.divide(gcd);

		// Simplifying denominator to a positive sign
		if (this.denominator.signum() == -1) {
			this.denominator = this.denominator.abs();
			this.numerator = this.numerator.negate();
		}
		if (this.denominator.equals(BigInteger.ZERO)) {
			this.numerator = BigInteger.ZERO;
			this.denominator = BigInteger.ONE;
		}
	}

	/**
	 * This method defines the structure of the object output when called
	 * through System.out.print
	 */
	public String toString() {
		if (this.denominator.compareTo(BigInteger.ONE) == 0) {
			return "" + this.numerator;
		} else {
			if (this.numerator.compareTo(BigInteger.ZERO) == 0
					|| this.denominator.compareTo(BigInteger.ZERO) == 0) {
				return "0";
			} else {

				return "(" + this.numerator + " / " + this.denominator + ")";
			}
		}
	}

	/**
	 * @return Returns Fraction by swapping the numerator and denominator with
	 *         each other.
	 */
	public Fraction invert() {
		return new Fraction(this.denominator, this.numerator);
	}

	/**
	 * @param val
	 * @return Returns the largest Fraction of two.
	 */
	public Fraction max(Fraction val) {
		if (this.compareTo(val) == 1) {
			return this;
		} else {
			return val;
		}
	}

	/**
	 * @param val
	 * @return Returns the smallest Fraction of two.
	 */
	public Fraction min(Fraction val) {
		if (this.compareTo(val) == -1) {
			return this;
		} else {
			return val;
		}

	}

	/**
	 * 
	 * @param Fraction
	 *            [] fractions
	 * @return Fraction This method takes Fraction[] array and adds all the
	 *         elements together. Return is a Fraction that is the sum of all
	 *         elements in the array fractions.
	 */
	public static Fraction sumAll(Fraction[] fractions) {
		if (fractions.equals(null)) {
			return null;
		}

		Fraction val = new Fraction(0);
		for (Fraction x : fractions) {
			if (x == null)
				return null;
			val = val.add(x);
		}
		return val;
	}
}