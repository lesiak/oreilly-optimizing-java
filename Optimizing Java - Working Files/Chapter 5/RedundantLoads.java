public class RedundantLoads {
  static class Point {
    public volatile int x; // change to volatile
    public volatile int y; // change to volatile

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
    return Math.sqrt(p.x * p.x + p.y * p.y);
  }
}