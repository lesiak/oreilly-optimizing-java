package benchmarks;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
public class JmhDemo {
  public static void main(String[] args) throws RunnerException {
	Options options = new OptionsBuilder().
	  include(JmhDemo.class.getName()).
	  forks(2).
	  warmupIterations(2).
	  measurementIterations(5).
	  build();
	    
	new Runner(options).run();
  }
	 
  @Param({"10", "1000", "1000000"})
  public int size;

  private int[] values;
  
  @Setup
  public final void setUp() {
	this.values = randomInts(size);
  }
  
  private static int[] randomInts(int size) {
	Random random = ThreadLocalRandom.current();
	  
	int[] values = new int[size];
	for ( int i = 0; i < values.length; ++i ) {
      values[i] = random.nextInt();
	}
	return values;
  }
  
  // Change from returns void to int
  // Then add Blackhole param and do blackhole.consume(sum)
  @Benchmark
  public void sum() {
	int sum = 0;
	for ( int x: values ) {
	  sum += x;
	}
  }
}
