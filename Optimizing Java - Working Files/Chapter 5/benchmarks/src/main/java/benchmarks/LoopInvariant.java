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
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class LoopInvariant {
  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder().
      include(LoopInvariant.class.getName()).
      forks(2).
      warmupIterations(2).
      measurementIterations(5).
      build();
    
    new Runner(options).run();
  }
  
  private final int size = 1_000;
  private final int[] values = randomInts(size);
  
  private static int[] randomInts(int size) {
    Random random = ThreadLocalRandom.current();
      
    int[] values = new int[size];
    for ( int i = 0; i < values.length; ++i ) {
      values[i] = random.nextInt();
    }
    return values;
  }
  
  @Benchmark
  public void cstyle(Blackhole blackhole) {
    int sum = 0;
    for ( int i = 0; i < this.values.length; ++i ) {
      sum += this.values[i];
    }
    blackhole.consume(sum);
  }
  
  @Benchmark
  public void hoisted(Blackhole blackhole) {
    int sum = 0;
    for ( int i = 0, len = this.values.length; i < len; ++i ) {
      sum += this.values[i];
    }
    blackhole.consume(sum);
  }
  
  @Benchmark
  public void enhanced(Blackhole blackhole) {
    int sum = 0;
    for ( int x: this.values ) {
      sum += x;
    }
    blackhole.consume(sum);
  }
}
