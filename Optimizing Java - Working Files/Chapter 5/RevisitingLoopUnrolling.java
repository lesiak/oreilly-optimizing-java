import java.util.concurrent.ThreadLocalRandom;

public class RevisitingLoopUnrolling {
  int[] ints = randInts(1_000);

  public static void main(String[] args) {
    RevisitingLoopUnrolling instance = 
      new RevisitingLoopUnrolling(); 

    for ( int i = 0; i < 20_000; ++i ) {
      instance.hotSum();
    }
  }

  int hotSum() {
    int sum = 0;
    for ( int i = 0; i < this.ints.length; ++i ) {
      sum += this.ints[i];
    }
    return sum;
  }

  private static int[] randInts(int size) {
    ThreadLocalRandom random = ThreadLocalRandom.current();

    int[] ints = new int[size];
    for ( int i = 0; i < size; ++i ) {
      ints[i] = random.nextInt();
    }
    return ints;
  }
}