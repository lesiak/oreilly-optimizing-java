public class InliningAndRedundantLoads {
  public static class Point {
    public final int x;
    public final int y;

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
    call();
    int x1 = p.x;
    call();
    int y0 = p.y;
    call();
    int y1 = p.y;
    return Math.sqrt(x0 * x1 + y0 * y1);
  }

  static void call() {}
}