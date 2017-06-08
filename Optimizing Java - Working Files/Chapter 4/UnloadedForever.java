// Run with -XX:-TieredCompilation -XX:+PrintCompilation
public class UnloadedForever {
  public static class Missing {}
  
  public static void main(String[] args) throws InterruptedException {
	for ( int i = 0; i < 20_000; ++i ) {
	  try {
		new Missing();
	  } catch ( Throwable t ) {
		// nop
	  }
	}
	
	Thread.sleep(5_000);
  }
}
