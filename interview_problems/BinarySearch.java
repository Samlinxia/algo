
public class BinarySearch {

  public BinarySearch() {
	 // TODO Auto-generated constructor stub
  }
  public static int sqrt(int x) {
    if (x < 0) {
        throw new IllegalArgumentException();
    }
    
    int l = 0; 
    int r = x / 2 + 1;
    
    while (l + 1 < r) {
        int m = l + (r - l) / 2;
        int product = m * m;
        if (product < x) {
            l = m;
        } else if (product > x) {
            r = m;
        } else {
            return m;
        }
    }
    if (l * l == x) {
        return l;
    } else {
        return r;
    }
}
  
  public static void main(String[] arg) {
	 int res = sqrt(2);
	 System.out.println(res);
  }
}
