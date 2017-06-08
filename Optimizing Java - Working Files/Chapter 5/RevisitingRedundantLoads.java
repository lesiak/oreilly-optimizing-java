public class RevisitingRedundantLoads {
  public static class Point {
    public int x; // switch to final
    public int y; // switch to final

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) {
    for ( int i = 0; i < 20_000; ++i ) {
      hotDistance(new Point(i, i));
    }
  }

  static double hotDistance(Point p) {
    int x0 = p.x;
    cantOptimize();
    int x1 = p.x;
    cantOptimize();
    int y0 = p.y;
    cantOptimize();
    int y1 = p.y;
    return Math.sqrt(x0 * x1 + y0 * y1);
  }

  static void cantOptimize() { f0(); }
  static void f0() { f1(); }
  static void f1() { f2(); }
  static void f2() { f3(); }
  static void f3() { f4(); }
  static void f4() { f5(); }
  static void f5() { f6(); }
  static void f6() { f7(); }
  static void f7() { f8(); }
  static void f8() { f9(); }
  static void f9() {}
}