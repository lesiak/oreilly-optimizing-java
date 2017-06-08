public class Unreached {
  static volatile Object obj;
  static volatile boolean output;
  
  public static void main(String[] args)
    throws InterruptedException
  {
    obj = null;
    for ( int i = 0; i < 20_000; ++i ) {
      hotMethod();
    }
    
    Thread.sleep(5_000);
    
    // phase change
    System.out.println("non-null");
    obj = new Object();    
    for ( int i = 0; i < 20_000; ++i ) {
      hotMethod();
    }
    
    Thread.sleep(5_000);
    
    // reverse - phase change
    System.out.println("back to null");
    obj = null;
    for ( int i = 0; i < 20_000; ++i ) {
      hotMethod();
    }
  }
  
  static void hotMethod() {
	output = (obj != null);
//    if ( obj == null ) {
//      output = false;
//    } else {
//      output = true;
//    }
  }
}
