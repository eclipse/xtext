package testdata;

public class OuterClass {
	public static class InnerClass {
		public static final String SINGLETON = "SINGLETON";
		
		public String toUpperCase(String x) {
			return x.toUpperCase();
		}
	}
}
