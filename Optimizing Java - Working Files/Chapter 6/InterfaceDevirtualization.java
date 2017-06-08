import functions.IFunc;
import functions.Sqrt;
import functions.Square;

public class InterfaceDevirtualization {
  public static void main(String[] args)
    throws InterruptedException
  {
    IFunc func = new Square();
    for ( int i = 0; i < 20_000; ++i ) {
      apply0(func, i);
      apply1(func, i);
      apply2(func, i);
      apply3(func, i);
      apply4(func, i);
      apply5(func, i);
      apply6(func, i);
      apply7(func, i);
    }
    
    Thread.sleep(5_000);
    
    System.out.printf("Loading Sqrt: %s%n", Sqrt.class);
    
    func = new Sqrt();
    
    System.out.println("Using sqrt...");
    for ( int i = 0; i < 20_000; ++i ) {
      apply0(func, i);
      apply1(func, i);
    }
    Thread.sleep(5_000);
    
    System.out.println("Using sqrt again...");
    for ( int i = 0; i < 20_000; ++i ) {
      apply2(func, i);
      apply3(func, i);
    }
    Thread.sleep(5_000);
  }
  
  static double apply0(IFunc f, double i) {
    return f.apply(i);
  }
  static double apply1(IFunc f, double i) {
    return f.apply(i);
  }
  static double apply2(IFunc f, double i) {
    return f.apply(i);
  }
  static double apply3(IFunc f, double i) {
    return f.apply(i);
  }
  static double apply4(IFunc f, double i) {
    return f.apply(i);
  }
  static double apply5(IFunc f, double i) {
    return f.apply(i);
  }
  static double apply6(IFunc f, double i) {
    return f.apply(i);
  }
  static double apply7(IFunc f, double i) {
    return f.apply(i);
  }
}
