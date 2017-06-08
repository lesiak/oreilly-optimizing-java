public class Diamond {
  public static void main(String[] args) {
    for ( int i = 0; i < 20_000; ++i ) {
      hotMethod(i % 10 == 0);
    }
  }

  static int hotMethod(boolean foo) {
    int x, y;
    if ( foo ) {
      x = 10;
      y = 5;
    } else {
      x = 20;
      y = 10;
    }
    return x + y;
  }
}