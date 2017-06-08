import java.util.concurrent.ThreadLocalRandom;

public class LoopUnrolling {
  public static void main(String[] args) {
    int[] ints = randInts(1_000);

    for ( int i = 0; i < 20_000; ++i ) {
      hotSum(ints);
    }
  }

  private static int[] randInts(int size) {
    ThreadLocalRandom random = ThreadLocalRandom.current();

    int[] ints = new int[size];
    for ( int i = 0; i < size; ++i ) {
      ints[i] = random.nextInt();
    }
    return ints;
  }

  static int hotSum(int[] ints) {
    int sum = 0;
    for ( int x : ints ) {
      sum += x;
    }
    return sum;
  }
}