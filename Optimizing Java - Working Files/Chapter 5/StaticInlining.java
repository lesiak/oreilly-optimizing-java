import java.util.concurrent.ThreadLocalRandom;

public class StaticInlining {
  public static void main(String[] args) {
    int[] ints = randInts(1_000);

    for ( int i = 0; i < 20_000; ++i ) {
      sumSquares(ints);
    }
  }

  static int sumSquares(int[] ints) {
    int sum = 0;
    for ( int x: ints ) {
      sum += square(x);
    }
    return sum;
  }

  static int square(int x) {
    return x * x;
  }

  static int[] randInts(int size) {
    ThreadLocalRandom rand = ThreadLocalRandom.current();
    
    int[] ints = new int[size];
    for ( int i = 0; i < ints.length; ++i ) {
      ints[i] = rand.nextInt();
    }
    return ints;
  }
}