package benchmarks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ListFaceOff { 
  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder().
	  include(ListFaceOff.class.getName()).
	  forks(2).
	  warmupIterations(2).
	  measurementIterations(5).
	  build();
		    
	new Runner(options).run();
  }
  
  @Param({
    "1", "2", "4", "8", "16", "32", "64", "128", "256", 
	"512", "1024", "2048", "4096", "8192", "16384", "32768", 
	"65536", "131072", "262144", "524288", "1048576"})
  public int size;
  
  private LinkedList<String> linkedList;
  private ArrayList<String> arrayList;
 
  @Setup
  public void setUp() {
	this.linkedList = new LinkedList<>();
	this.arrayList = new ArrayList<>(this.size);
	  
	ThreadLocalRandom random = ThreadLocalRandom.current();
	for ( int i = 0; i < this.size; ++i ) {
	  String str = String.valueOf(random.nextInt());
	  // just to make sure, hash is pre-computed
	  str.hashCode();
	  
	  this.linkedList.add(str);
	  this.arrayList.add(str);
	}
  }
  
  @Benchmark
  public int linkedList() {
	int hash = 0;
	for ( String str : this.linkedList ) {
	  hash |= str.hashCode();
	}
	return hash;
  }
  
  @Benchmark
  public int arrayList() {
	int hash = 0;
	for ( String str : this.arrayList ) {
	  hash |= str.hashCode();
	}
	return hash;
  }
}
