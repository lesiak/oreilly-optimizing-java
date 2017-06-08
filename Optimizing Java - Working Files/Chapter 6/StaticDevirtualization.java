public class StaticDevirtualization {
  static abstract class Consumer<T> {
    public abstract void apply(T obj);
  }

  public static final class NopConsumer<T>
    extends Consumer<T>
  {
    public void apply(Object obj) {}
  }

  public static void main(String[] args) {
    Consumer<Integer> nopConsumer = new NopConsumer<>();

    for ( int i = 0; i < 20_000; ++i ) {
      consume(nopConsumer, i);
    }
  }

  static <T> void consume(Consumer<T> consumer, T value) {
    consumer.apply(value);
  }
}