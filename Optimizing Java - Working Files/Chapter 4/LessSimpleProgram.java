public class LessSimpleProgram {
  public static void main(String[] args) {
	Object trap = null;
	
    for ( int i = 0; i < 500; ++i ) {
      long startTime = System.nanoTime();
      
      for ( int j = 0; j < 1_000; ++j ) {
    	    if ( trap != null ) {
    	    	  System.out.println("trap!");
    	    	  trap = null;
    	    }
        new Object();
      }
      
      if ( i == 300 ) {
    	    trap = new Object();
      }
      
      long endTime = System.nanoTime();
      System.out.printf("%d\t%d%n", i, endTime - startTime);
    }
  }
}
