package benchmarks;

import java.util.Random;
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

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class StrengthReduction {
  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder().
      include(StrengthReduction.class.getName()).
      forks(2).
      warmupIterations(2).
      measurementIterations(5).
      build();
                
    new Runner(options).run();
  }
  
  final int x = new Random(532).nextInt();
  
  @Benchmark
  public int div4() {
    return this.x / 4;
  }
  
  @Benchmark
  public int div5() {
    return this.x / 5;
  }
}
