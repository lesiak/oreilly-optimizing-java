public class RevisitingSimpleProgram {
  public static void main(String[] args)
  	throws InterruptedException
  {
    for ( int i = 0; ; ++i ) {
      long startTime = System.nanoTime();
      
      for ( int j = 0; j < 1_000; ++j ) {
        new Object();
      }
      
      long endTime = System.nanoTime();
      if ( i % 100_000 == 0 ) {
    	    System.out.printf("%d\t%d%n", i, endTime - startTime);
      }
    }
  }
}