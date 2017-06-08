public class SpecialInlining {
  public static void main(String[] args) {
    for ( int i = 0; i < 20_000; ++i ) {
      factory();
    }
  }

  static Object factory() {
    return new Object();
  }
}