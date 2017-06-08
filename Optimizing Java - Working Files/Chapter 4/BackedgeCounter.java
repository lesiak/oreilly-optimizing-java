// Run with -XX:-TieredCompilation -XX:+PrintCompilation
public class BackedgeCounter {
  public static void main(String[] args)
  	throws InterruptedException
  {
	for ( int i = 0; i < 20_000; ++i ) {
	  hotMethod();
	}
	System.out.println("Waiting for compiler...");
	Thread.sleep(5_000);
	
	for ( int i = 0; i < 20_000; ++i ) {
	  hotMethod();
	}
	System.out.println("Waiting for compiler...");
	Thread.sleep(5_000);
  }
  
  static void hotMethod() {}
}
