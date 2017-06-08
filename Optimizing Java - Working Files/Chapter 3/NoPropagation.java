public class NoPropagation {
  public static final int PROPAGATED = 32;
  public static final int NOT_PROPAGATED = identity(32);

  public static int identity(int val) {
    return val;
  }

  public static void main(String[] args) {
    System.out.println(PROPAGATED);
    System.out.println(NOT_PROPAGATED);
  }
}
