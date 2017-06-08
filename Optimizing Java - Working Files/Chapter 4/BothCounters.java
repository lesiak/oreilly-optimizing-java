// Run with -XX:-TieredCompilation -XX:+PrintCompilation
public class BothCounters {
  public static void main(String[] args)
  	throws InterruptedException
  {
	for ( int i = 0; i < 2; ++i ) {
	  coldMethod();
	}
	
	System.out.println("Waiting for compiler...");
	Thread.sleep(5_000);
  }
  
  static void coldMethod() {
	for ( int i = 0; i < 10_000; ++i ) {
	  hotMethod();
	}
  }
  
  static void hotMethod() {}
}
