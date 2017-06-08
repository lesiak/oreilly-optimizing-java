public class LocalOptimizations {
  public static void main(String[] args) {
    for ( int i = 0; i < 20_000; ++i ) {
      hotMethod(i);
    }
  }
  
  public static int hotMethod(int x) {
   int y = x - 8;
   int z = x / 8 + 10;
   return y + z;
  }
}