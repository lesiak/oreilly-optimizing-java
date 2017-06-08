// Run with -XX:-TieredCompilation -XX:+PrintCompilation
public class InvocationCounter {
  public static void main(String[] args)
  	throws InterruptedException
  {
	for ( int i = 0; i < 20_000; ++i ) {
	  hotMethod();
	}
	
	System.out.println("Waiting for compiler...");
	Thread.sleep(5_000);
  }
  
  static void hotMethod() {}
}
