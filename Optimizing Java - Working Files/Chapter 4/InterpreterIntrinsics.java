import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class InterpreterIntrinsics {
  public static void main(String[] args) {
    int[] original = randomInts(100_000);
    
    int[] copy1 = new int[original.length];
    
    long startTime1 = System.nanoTime();
    for ( int i = 0; i < original.length; ++i ) {
    	  copy1[i] = original[i];
    }
    System.out.printf("copy loop: % 10d ms%n", System.nanoTime() - startTime1);
    
    int[] copy2 = new int[original.length];
    
    long startTime2 = System.nanoTime();
    System.arraycopy(original, 0, copy2, 0, original.length);
    System.out.printf("arraycopy: % 10d ms%n", System.nanoTime() - startTime2);
  }
  
  static int[] randomInts(int len) {
	Random random = ThreadLocalRandom.current();
	  
	int[] ints = new int[len];
	for ( int i = 0; i < len; ++i ) {
	  ints[i] = random.nextInt();
	}
	
	return ints;
  }
}
