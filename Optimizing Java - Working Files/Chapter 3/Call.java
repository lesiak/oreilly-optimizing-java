public class Call {
  public static void main(String[] args) {
	max(10, 20);
  }
  
  static final int max(int x, int y) {
	return x >= y ? x : y;
  }
}
