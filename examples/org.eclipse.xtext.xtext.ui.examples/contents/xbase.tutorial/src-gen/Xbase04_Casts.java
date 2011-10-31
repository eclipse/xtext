@SuppressWarnings("all")
public class Xbase04_Casts {
  public static void main(final String[] args) {
    try {
    	final CharSequence s = "foo";
    	((String) s).length();
    } catch (Throwable t) {}
  }
}
