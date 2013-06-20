package overloading;

public class CopiedAssert {

	static public void assertTrue(String message, boolean condition) {
	}

	static public void assertTrue(boolean condition) {
	}

	static public void assertFalse(String message, boolean condition) {
	}

	static public void assertFalse(boolean condition) {
	}

	static public void fail(String message) {
	}

	static public void fail() {
	}

	static public void assertEquals(String message, Object expected, Object actual) {
	}

	static public void assertEquals(Object expected, Object actual) {
	}

	public static void assertArrayEquals(String message, Object[] expecteds, Object[] actuals) {
	}

	public static void assertArrayEquals(Object[] expecteds, Object[] actuals) {
	}

	public static void assertArrayEquals(String message, byte[] expecteds, byte[] actuals) {
	}

	public static void assertArrayEquals(byte[] expecteds, byte[] actuals) {
	}

	public static void assertArrayEquals(String message, char[] expecteds, char[] actuals) {
	}

	public static void assertArrayEquals(char[] expecteds, char[] actuals) {
	}

	public static void assertArrayEquals(String message, short[] expecteds, short[] actuals) {
	}

	public static void assertArrayEquals(short[] expecteds, short[] actuals) {
	}

	public static void assertArrayEquals(String message, int[] expecteds, int[] actuals) {
	}

	public static void assertArrayEquals(int[] expecteds, int[] actuals) {
	}

	public static void assertArrayEquals(String message, long[] expecteds, long[] actuals) {
	}

	public static void assertArrayEquals(long[] expecteds, long[] actuals) {
	}

	public static void assertArrayEquals(String message, double[] expecteds, double[] actuals, double delta) {
	}

	public static void assertArrayEquals(double[] expecteds, double[] actuals, double delta) {
	}

	public static void assertArrayEquals(String message, float[] expecteds, float[] actuals, float delta) {
	}

	public static void assertArrayEquals(float[] expecteds, float[] actuals, float delta) {
	}

	static public void assertEquals(String message, double expected, double actual, double delta) {
	}

	static public void assertEquals(long expected, long actual) {
	}

	static public void assertEquals(String message, long expected, long actual) {
	}

	@Deprecated
	static public void assertEquals(double expected, double actual) {
	}

	@Deprecated
	static public void assertEquals(String message, double expected, double actual) {
	}

	static public void assertEquals(double expected, double actual, double delta) {
	}

	static public void assertNotNull(String message, Object object) {
	}

	static public void assertNotNull(Object object) {
	}

	static public void assertNull(String message, Object object) {
	}

	static public void assertNull(Object object) {
	}

	static public void assertSame(String message, Object expected, Object actual) {
	}

	static public void assertSame(Object expected, Object actual) {
	}

	static public void assertNotSame(String message, Object unexpected, Object actual) {
	}

	static public void assertNotSame(Object unexpected, Object actual) {
	}

	@Deprecated
	public static void assertEquals(String message, Object[] expecteds, Object[] actuals) {
	}

	@Deprecated
	public static void assertEquals(Object[] expecteds, Object[] actuals) {
	}

	public static <T> void assertThat(T actual, CopiedMatcher<T> matcher) {
	}

	public static <T> void assertThat(String reason, T actual, CopiedMatcher<T> matcher) {
	}

	public interface CopiedMatcher<T> {
		/*
		 * Copied from the matcher interface:
		 * 
	     * This method matches against Object, instead of the generic type T. This is
	     * because the caller of the Matcher does not know at runtime what the type is
	     * (because of type erasure with Java generics). It is down to the implementations
	     * to check the correct type. 
	     */
		boolean matches(Object item);
	}
}
