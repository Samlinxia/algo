
public class GrayCodeDecision {

  public GrayCodeDecision() {
	 byte a = 1;
	 byte b = 5;
	 byte c = 2;
	 byte d = 3;
	 System.out.println(isGrayCode(a, b));
	 System.out.println(isGrayCode(c, d));
	 System.out.println(isGrayCode(a, d));
  }
  
  public static int isGrayCode (byte a, byte b) {
	 byte res = (byte) (a ^ b);
	 int count = 0;
	 for (int i = 0; i < 32; i++) {
		if (((res >> i) & 1) == 1) {
		  count++;
		}
	 }
	 return count == 1 ? 1 : 0;
  }

  public static void main(String[] args) {
	 long res = Math.abs((long)Integer.MIN_VALUE);
	 System.out.println(res);
//	GrayCodeDecision g = new GrayCodeDecision();
  }
}
