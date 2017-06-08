public class NullTracking {
  public static class User {
    public final String first;
    public final String last;

    public User(String first, String last) {
      this.first = first;
      this.last = last;
    }
  }

  static final User JON = new User("Jon", "Doe");

  public static void main(String[] args) {
    for ( int i = 0; i < 20_000; ++i ) {
      hotFullName(JON);
    }
  }

  static String hotFullName(User user) {
    return user.first + user.last;
  }
}