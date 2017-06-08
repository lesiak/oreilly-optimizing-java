public class ChaSnippet {
  static abstract class Func {
    public abstract double apply(double x);
  }
  static class Square extends Func {
    public double apply(double x) {
      return x * x;
    }
  }

  public static void main(String[] args)
    throws InterruptedException
  {
    Square square = new Square();
    for ( int i = 0; i < 20_000; ++i ) {
      apply0(square, i);
      apply1(square, i);
    }
  }

  static double apply0(Func f, double i) {
    return f.apply(i);
  }
  static double apply1(Func f, double i) {
    return f.apply(i);
  }
}