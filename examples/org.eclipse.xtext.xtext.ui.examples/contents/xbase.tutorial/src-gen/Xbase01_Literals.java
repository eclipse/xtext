import java.math.BigDecimal;
import java.math.BigInteger;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class Xbase01_Literals {
  public static void main(final String[] args) {
    try {
        /* null */
        /* "Hello World" */
        /* 42 */
        /* 0.42e2 */
        /* true */
        /* false */
        /* String.class */
        /*CollectionLiterals.<Integer>newArrayList(Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7));*/
        /*CollectionLiterals.<String>newHashSet("foo", "bar", "baz");*/
        Pair<Integer,String> _mappedTo = Pair.<Integer, String>of(Integer.valueOf(1), "one");
        Pair<Integer,String> _mappedTo_1 = Pair.<Integer, String>of(Integer.valueOf(2), "two");
        Pair<Integer,String> _mappedTo_2 = Pair.<Integer, String>of(Integer.valueOf(3), "three");
        /*CollectionLiterals.<Integer, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2);*/
        /* new BigInteger("beefbeefbeefbeefbeef", 16) */
        /* new BigDecimal("0.123456789123456789123456789123456789e4242") */
    } catch (Throwable t) {}
  }
}
