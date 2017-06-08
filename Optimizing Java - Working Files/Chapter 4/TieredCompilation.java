// Run with -XX:+TieredCompilation -XX:+PrintCompilation
public class TieredCompilation {
  public static void main(String[] args)
  	throws InterruptedException
  {
    for ( int i = 0; i < 3_000; ++i ) {
    	  hotMethod();
    }
    
    System.out.println("Waiting for C1...");
    Thread.sleep(5_000);
    
    for ( int i = 0; i < 15_000; ++i ) {
    	  hotMethod();
    }
    
    System.out.println("Waiting for C2...");
    Thread.sleep(5_000);
  }
  
  static final void hotMethod() {
	System.out.print("");
  }
}
