import functions.Func;
import functions.Sqrt;
import functions.Square;

public class ChaDevirtualization {
  public static void main(String[] args)
    throws InterruptedException
  {
    Square square = new Square();
    for ( int i = 0; i < 20_000; ++i ) {
      apply0(square, i);
      apply1(square, i);
      apply2(square, i);
      apply3(square, i);
      apply4(square, i);
      apply5(square, i);
      apply6(square, i);
      apply7(square, i);
    }
    
    Thread.sleep(5_000);
    
    System.out.printf("Loading Sqrt: %s%n", Sqrt.class);
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
