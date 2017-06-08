// Run with -XX:-TieredCompilation -XX:+PrintCompilation
public class TooManyArguments {
  public static void main(String[] args) throws InterruptedException {
	for ( int i = 0; i < 20_000; ++i ) {
	  hotMethod(
	    0L, 1L, 2L, 3L, 4L,
	    5L, 6L, 7L, 8L, 9L,
	    10L, 11L, 12L, 13L, 14L,
	    15L, 16L, 17L, 18L, 19L,
	    20L, 21L, 22L, 23L, 24L,
	    25L, 26L, 27L, 28L, 29L,
	    30L, 31L, 32L, 33L, 34L,
	    35L, 36L, 37L, 38L, 39L,
	    40L, 41L, 42L, 43L, 44L,
	    45L, 46L, 47L, 48L, 49L,
	    50L, 51L, 52L, 53L, 54L,
	    55L, 56L, 57L, 58L, 59L,
	    60L, 61L, 62L, 63L, 64L,
	    65L, 66L, 67L, 68L, 69L);
	}
	
	Thread.sleep(5_000);
  }
  
  static final int hotMethod(
	long p00, long p01, long p02, long p03, long p04,
	long p05, long p06, long p07, long p08, long p09,
	long p10, long p11, long p12, long p13, long p14,
	long p15, long p16, long p17, long p18, long p19,
	long p20, long p21, long p22, long p23, long p24,
	long p25, long p26, long p27, long p28, long p29,
	long p30, long p31, long p32, long p33, long p34,
	long p35, long p36, long p37, long p38, long p39,
	long p40, long p41, long p42, long p43, long p44,
	long p45, long p46, long p47, long p48, long p49,
	long p50, long p51, long p52, long p53, long p54,
	long p55, long p56, long p57, long p58, long p59,
	long p60, long p61, long p62, long p63, long p64,
	long p65, long p66, long p67, long p68, long p69)
  {
	return 0;  
  }
}
