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
public class CommonSubexpression {
  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder().
      include(CommonSubexpression.class.getName()).
      forks(1).
      warmupIterations(2).
      measurementIterations(5).
      build();
                        
    new Runner(options).run();
  }
      
  static final Random RANDOM_532 = new Random(532);
  
  static int randInt() {
    return RANDOM_532.nextInt();
  }
  
  int a = randInt();
  int b = randInt();
  int c = randInt();
  int d = randInt();
  int e = b;
    
  @Benchmark
  public int elimination() {
    int x = a * b + c;
    int y = a * b * d;
    return x + y;
  }
  
  @Benchmark
  public int manualElimination() {
    int tmp = a * b;
    int x = tmp + c;
    int y = tmp * d;
    return x + y;
  }
  
  @Benchmark
  public int noElimination() {
    int x = a * b + c;
    int y = a * e * d;
    return x + y;
  }
}
