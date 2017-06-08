package benchmarks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;

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

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class FalseSharing {
  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder().
	  include(FalseSharing.class.getName()).
	  forks(5).
	  warmupIterations(5).
	  measurementIterations(10).
	  threads(2).
	  build();
		    
	new Runner(options).run();
  }
  
  private final AtomicLongArray array = new AtomicLongArray(16);
  
  @Param({"1", "8"})
  private int otherIndex;

  @State(Scope.Thread)
  public static class ThreadData {
	private static AtomicInteger threadCounter = new AtomicInteger();
	
	private final int threadId;
	
	public ThreadData() {
	  this.threadId = threadCounter.getAndIncrement();
	}
  }
  
  @Benchmark
  public void benchmark(final ThreadData threadData) {
	if ( threadData.threadId == 0 ) {
	  this.array.incrementAndGet(0);
	} else {
	  this.array.incrementAndGet(this.otherIndex);
	}
  }
}
