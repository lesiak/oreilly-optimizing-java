import functions.AnotherSquare;
import functions.Func;
import functions.OneMoreSquare;
import functions.Sqrt;
import functions.Square;
import functions.YetAnotherSquare;

public class RevisitingClassDevirtualization {
  public static void main(String[] args)
    throws InterruptedException
  {
    Func func = new Square();
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
    
    System.out.println("Using AnotherSquare...");
    func = new AnotherSquare();
    for ( int i = 0; i < 20_000; ++i ) {
      apply0(func, i);
      apply1(func, i);
    }
    Thread.sleep(5_000);
    
    System.out.println("Using YetAnotherSquare...");
    func = new YetAnotherSquare();
    for ( int i = 0; i < 20_000; ++i ) {
      apply0(func, i);
      apply1(func, i);
    }
    Thread.sleep(5_000);
    
    System.out.println("Using OneMoreSquare...");
    func = new OneMoreSquare();
    for ( int i = 0; i < 20_000; ++i ) {
      apply0(func, i);
      apply1(func, i);
    }
    Thread.sleep(5_000);
  }
  
  static double apply0(Func f, double i) {
    return f.apply(i);
  }
  static double apply1(Func f, double i) {
    return f.apply(i);
  }
  static double apply2(Func f, double i) {
    return f.apply(i);
  }
  static double apply3(Func f, double i) {
    return f.apply(i);
  }
  static double apply4(Func f, double i) {
    return f.apply(i);
  }
  static double apply5(Func f, double i) {
    return f.apply(i);
  }
  static double apply6(Func f, double i) {
    return f.apply(i);
  }
  static double apply7(Func f, double i) {
    return f.apply(i);
  }
}
