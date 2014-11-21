package zillow;

/**
 * @author XIA LIN
 * 
 */

public class LongHelper {

  /**
   * Convert a given string to long type numeric
   * Restriction: Can not be used in multi-threaded environment of 32-bit CPU
   * architecture, because long is 64-bit.
   * 
   * @throws NullPointerException
   *           if s is null
   * @throws NumberFormatException
   *           if there's an error occurs
   * */
  public static long StringToLong(String s) {
	 if (s == null) {
		throw new NullPointerException();
	 }
	 int len = s.length();
	 s = s.trim();
	 if (len == 0) {
		throw new NumberFormatException();
	 }
	 boolean isNeg = false;
	 int index = 0;
	 char c = s.charAt(index);

	 if (c == '-') {
		isNeg = true;
		index++;
	 } else if (c == '+') {
		isNeg = false;
		index++;
	 }
	 if (index == len) { // s = "-"
		throw new NumberFormatException();
	 }
	 // skip '0', eg. "-00004"
	 while (index < len && s.charAt(index) == '0') {
		index++;
	 }

	 long val = 0;
	 for (int i = index; i < len; i++) {
		int dig = s.charAt(i) - '0';
		if (!isValid(dig)) {
		  throw new NumberFormatException();
		}
		val = val * 10 + dig;
		if (val < dig) { // handle overflow
		  System.out.println("overflow");
		  return isNeg ? Long.MIN_VALUE : Long.MAX_VALUE;
		  // throw new ArithmeticException("Overflow occurs");
		}
	 }
	 return isNeg ? -val : val;
  }

  private static boolean isValid(int a) {
	 if (a < 0 || a > 9) {
		return false;
	 }
	 return true;
  }

  public static void main(String[] args) {
	 String s1 = "-000004";
	 String s2 = "-90";
	 String s3 = String.valueOf(Long.MAX_VALUE) + "1";
	 long res = LongHelper.StringToLong(s1);
	 System.out.println(res);
	 res = LongHelper.StringToLong(s2);
	 System.out.println(res);
	 res = LongHelper.StringToLong(s3);
	 System.out.println(res);
  }
}