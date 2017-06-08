import java.util.concurrent.ThreadLocalRandom;

public class RevisitingDeadCode {
  public static void main(String[] args) {
    int[] values = randInts(1_000);

    for ( int i = 0; i < 20_000; ++i ) {
      hotSum(values);
    }
  }

  static void hotSum(int[] values) {
    int sum = 0;
    for ( int x: values ) {
      sum += x;
    }
  }

  static int[] randInts(int size) {
    ThreadLocalRandom random = ThreadLocalRandom.current();

    int[] ints = new int[size];
    for ( int i = 0; i < ints.length; ++i ) {
      ints[i] = random.nextInt();
    }
    return ints;
  }
}