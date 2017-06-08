package benchmarks;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class Devirtualization {
  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder().
      include(Devirtualization.class.getName()).
      forks(2).
      warmupIterations(5).
      measurementIterations(5).
      build();
    
    new Runner(options).run();
  }
  
  static abstract class Consumer<T> {
	public abstract void apply(T obj);
  }

  public static final class NopConsumer<T>
    extends Consumer<T>
  {
    public void apply(Object obj) {}
  }
  
  private final int size = 1_000;
  private final int[] values = randomInts(size);
  private final Consumer<Integer> nopConsumer = new NopConsumer<>();
  
  private static int[] randomInts(int size) {
    Random random = ThreadLocalRandom.current();
      
    int[] values = new int[size];
    for ( int i = 0; i < values.length; ++i ) {
      values[i] = random.nextInt();
    }
    return values;
  }
  
  @Benchmark
  public void cstyle() {
    for ( int i = 0; i < this.values.length; ++i ) {
      this.nopConsumer.apply(this.values[i]);
    }
  }
  
  @Benchmark
  public void hoisted() {
    for ( int i = 0, len = this.values.length; i < len; ++i ) {
      this.nopConsumer.apply(this.values[i]);
    }
  }
  
  @Benchmark
  public void enhanced() {
    for ( int x: this.values ) {
    	  this.nopConsumer.apply(x);
    }
  }
  
  @Benchmark
  public void almostFullyHoisted() {
	int[] values = this.values;
	
    for ( int i = 0; i < values.length; ++i ) {
    	  this.nopConsumer.apply(values[i]);
    }
  }
}
