import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class Xbase01_Literals {
  public Map<String,String> myMethod() throws Throwable {
    Map<String,String> _xblockexpression = null;
    {
      /* null */
      /* "Hello World" */
      /* true */
      /* false */
      /* 42 */
      /* 0.42e2 */
      /* new BigInteger("beefbeefbeefbeefbeef", 16) */
      /* new BigDecimal("0.123456789123456789123456789123456789e4242") */
      /* String.class */
      String.class.getField("CASE_INSENSITIVE_ORDER");
      /* Map.Entry.class */
      /* CollectionLiterals.<Integer>newArrayList(Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7)); */
      /* CollectionLiterals.<String>newHashSet("foo", "bar", "baz"); */
      Pair<Integer,String> _mappedTo = Pair.<Integer, String>of(Integer.valueOf(1), "one");
      Pair<Integer,String> _mappedTo_1 = Pair.<Integer, String>of(Integer.valueOf(2), "two");
      Pair<Integer,String> _mappedTo_2 = Pair.<Integer, String>of(Integer.valueOf(3), "three");
      /* CollectionLiterals.<Integer, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2); */
      String[] stringArray = { "a", "b", "c" };
      /* stringArray[1]; */
      List<String> listOfStrings = Collections.<String>unmodifiableList(Lists.<String>newArrayList("a", "b", "c"));
      /* listOfStrings; */
      Set<String> setOfStrings = Collections.<String>unmodifiableSet(Sets.<String>newHashSet("a", "b", "c"));
      /* setOfStrings; */
      Map<String,String> _xsetliteral = null;
      Map<String,String> _tempMap = Maps.<String, String>newHashMap();
      _tempMap.put("a", "A");
      _tempMap.put("b", "B");
      _tempMap.put("c", "C");
      _xsetliteral = Collections.<String, String>unmodifiableMap(_tempMap);
      Map<String,String> immutableMap = _xsetliteral;
      _xblockexpression = immutableMap;
    }
    return _xblockexpression;
  }
}
