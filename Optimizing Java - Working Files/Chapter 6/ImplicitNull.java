public class ImplicitNull {
  public static void main(String[] args) throws InterruptedException {
    for ( int i = 0; i < 20_000; ++i ) {
      hotMethod("foo");
    }
    
    Thread.sleep(5_000);

    for ( int i = 0; i < 10; ++i ) {
      System.out.println("Tempting fate...");
      try {
        hotMethod(null);
      } catch ( NullPointerException e ) {
        // e.printStackTrace();
      }
    }
    
    for ( int i = 0; i < 20_000; ++i ) {
      hotMethod("foo");
    }
      
    Thread.sleep(5_000);
  }

  static int hotMethod(String foo) {
    return foo.hashCode();
  }
}