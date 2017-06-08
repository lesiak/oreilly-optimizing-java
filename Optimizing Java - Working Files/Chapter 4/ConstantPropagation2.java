public class ConstantPropagation2 {
  public static void main(String[] args) {
	for ( int i = 0; i < 20_000; ++i ) {
	  hotMethod();
	}
  }
  
  static int hotMethod() {
	int x = 10;
	int y = 5;
	return x + y;
  }
}
