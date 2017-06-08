public class NoLocalPropagation {
  public static int num() {
	final int x = 10;
	final int y = 5;
	return x + y;
  }
}
