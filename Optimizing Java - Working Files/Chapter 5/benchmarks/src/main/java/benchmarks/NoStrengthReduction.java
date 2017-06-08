package benchmarks;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class NoStrengthReduction {
  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder().
	  include(NoStrengthReduction.class.getName()).
	  forks(2).
	  warmupIterations(2).
	  measurementIterations(5).
	  build();
			    
	new Runner(options).run();
  }
  
  int x = new Random(532).nextInt();
  
  @Param({"4", "5"})
  public int divisor;
  
  @Benchmark
  public int div() {
	return this.x / this.divisor;
  }
}
