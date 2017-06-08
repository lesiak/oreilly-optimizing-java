public class TypePropagation {
  static class Foo {}

  static int blackhole;

  public static void main(String[] args) {
    for ( int i = 0; i < 20_000; ++i ) {
      hotMethod();
    }
  }

  static void hotMethod() {
    blackhole = new Foo().hashCode();
  }
}