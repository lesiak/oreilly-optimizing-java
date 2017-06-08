public class SimpleProgram {
  public static void main(String[] args) {
    for ( int i = 0; i < 300; ++i ) {
      long startTime = System.nanoTime();
      
      for ( int j = 0; j < 1_000; ++j ) {
        new Object();
      }
      
      long endTime = System.nanoTime();
      System.out.printf("%d\t%d%n", i, endTime - startTime);
    }
  }
}
