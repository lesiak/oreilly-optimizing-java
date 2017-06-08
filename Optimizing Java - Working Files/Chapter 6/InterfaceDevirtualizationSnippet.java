public class InterfaceDevirtualizationSnippet {
  interface IFunc {
    double apply(double x);
  }
  static class Square implements IFunc {
    public double apply(double x) {
      return x * x;
    }
  }

  public static void main(String[] args)
    throws InterruptedException
  {
    IFunc func = new Square();
    for ( int i = 0; i < 20_000; ++i ) {
      apply0(func, i);
      apply1(func, i);
    }
  }
  
  static double apply0(IFunc f, double i) {
    return f.apply(i);
  }
  static double apply1(IFunc f, double i) {
    return f.apply(i);
  }
}