import java.util.concurrent.ThreadLocalRandom;

public class IntrinsicInlining {
  public static void main(String[] args) {
    int[] ints = randInts(1_000);

    for ( int i = 0; i < 20_000; ++i ) {
      min(ints);
    }
  }

  static int min(int[] ints) {
    int min = Integer.MAX_VALUE;
    for ( int x: ints ) {
      min = Math.min(min, x);
    }
    return min;
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