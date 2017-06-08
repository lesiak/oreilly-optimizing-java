public class DeadCodeElimination {
  public static final boolean ALWAYS = true;
  public static final boolean NEVER = false;
	
  public static void main(String[] args) {
	if ( ALWAYS ) {
	  System.out.println("Always!");
	}
	if ( NEVER ) {
	  System.out.println("Never!");
	}
  }
}
