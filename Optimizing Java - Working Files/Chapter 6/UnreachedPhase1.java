public class UnreachedPhase1 {
  static volatile Object obj;
  static volatile boolean isNull;
  static volatile boolean notNull;
  
  public static void main(String[] args)
    throws InterruptedException
  {
    obj = null;
    for ( int i = 0; i < 20_000; ++i ) {
      hotMethod();
    }
  }
  
  static void hotMethod() {
    if ( obj == null ) {
      isNull = true;
    } else {
      notNull = true;
    }
  }
}