
public class BiasedLocking {
  static final Object lock = new Object();
  static Object sink = null;
  static boolean done = false;
  
  public static void main(String[] args) throws InterruptedException {
    for ( int i = 0; i < 20; ++i ) {
    	  lock();
    }
    
    System.out.println("Reverting bias...");
    unbias();
    
    for ( int i = 0; i < 20; ++i ) {
    	  lock();
    }
  }
  
  static void lock() {
	Object newObject = new Object();
	
	synchronized ( lock ) {
	  sink = newObject;
	}
  }
  
  static void unbias() throws InterruptedException {
	Thread thread = new Thread(new Runnable() {
	  @Override
	  public void run() {
		synchronized ( lock ) {
		  try {
			Thread.sleep(5_000);
		  } catch ( InterruptedException e ) {
			// Don't do this!
		  }
		  
		  done = true;
		  lock.notify();
		}
	  }
	});
	thread.start();
	
	synchronized ( lock ) {
	  while ( !done ) {
		lock.wait();
	  }
	}
	
	thread.join();
  }
}
