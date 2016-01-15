package org.eclipse.xpect.tests.text;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xpect.text.StringEndsSimilarityFunction;
import org.eclipse.xpect.util.IDifferencer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class StringSimilarityFunctionTest {
  @Test
  public void testEqual() {
    float _similarity = this.similarity("abc", "abc");
    boolean _equals = (IDifferencer.ISimilarityFunction.EQUAL == _similarity);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void testUnequal() {
    float _similarity = this.similarity("", "");
    boolean _equals = (IDifferencer.ISimilarityFunction.UPPER_SIMILARITY_BOUND == _similarity);
    Assert.assertTrue(_equals);
    float _similarity_1 = this.similarity(null, null);
    boolean _equals_1 = (IDifferencer.ISimilarityFunction.UPPER_SIMILARITY_BOUND == _similarity_1);
    Assert.assertTrue(_equals_1);
  }
  
  @Test
  public void testSimilarBeginning() {
    final ArrayList<Pair<String, String>> data = CollectionLiterals.<Pair<String, String>>newArrayList();
    Pair<String, String> _mappedTo = Pair.<String, String>of("aaaaaaaaaa", "aaaaaaaaaa");
    data.add(_mappedTo);
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("aaaaaaaaaa", "aaaaaaaaa-");
    data.add(_mappedTo_1);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("aaaaaaaaaa", "aaaaaaaa--");
    data.add(_mappedTo_2);
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("aaaaaaaaaa", "aaaaaaa---");
    data.add(_mappedTo_3);
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("aaaaaaaaaa", "aaaaaa----");
    data.add(_mappedTo_4);
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("aaaaaaaaaa", "aaaaa-----");
    data.add(_mappedTo_5);
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("aaaaaaaaaa", "aaaa------");
    data.add(_mappedTo_6);
    Pair<String, String> _mappedTo_7 = Pair.<String, String>of("aaaaaaaaaa", "aaa-------");
    data.add(_mappedTo_7);
    Pair<String, String> _mappedTo_8 = Pair.<String, String>of("aaaaaaaaaa", "aa--------");
    data.add(_mappedTo_8);
    Pair<String, String> _mappedTo_9 = Pair.<String, String>of("aaaaaaaaaa", "a---------");
    data.add(_mappedTo_9);
    Pair<String, String> _mappedTo_10 = Pair.<String, String>of("aaaaaaaaaa", "----------");
    data.add(_mappedTo_10);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aaaaaaaaaa <> aaaaaaaaaa --> 0.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> aaaaaaaaa- --> 0.25");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> aaaaaaaa-- --> 0.50");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> aaaaaaa--- --> 0.75");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> aaaaaa---- --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> aaaaa----- --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> aaaa------ --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> aaa------- --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> aa-------- --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> a--------- --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> ---------- --> 1.00");
    _builder.newLine();
    final String expected = _builder.toString();
    String _trim = expected.trim();
    String _similarityStr = this.similarityStr(((Pair<String, String>[])Conversions.unwrapArray(data, Pair.class)));
    Assert.assertEquals(_trim, _similarityStr);
  }
  
  @Test
  public void testSimilarEnd() {
    final ArrayList<Pair<String, String>> data = CollectionLiterals.<Pair<String, String>>newArrayList();
    Pair<String, String> _mappedTo = Pair.<String, String>of("aaaaaaaaaa", "aaaaaaaaaa");
    data.add(_mappedTo);
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("aaaaaaaaaa", "-aaaaaaaaa");
    data.add(_mappedTo_1);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("aaaaaaaaaa", "--aaaaaaaa");
    data.add(_mappedTo_2);
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("aaaaaaaaaa", "---aaaaaaa");
    data.add(_mappedTo_3);
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("aaaaaaaaaa", "----aaaaaa");
    data.add(_mappedTo_4);
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("aaaaaaaaaa", "-----aaaaa");
    data.add(_mappedTo_5);
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("aaaaaaaaaa", "------aaaa");
    data.add(_mappedTo_6);
    Pair<String, String> _mappedTo_7 = Pair.<String, String>of("aaaaaaaaaa", "-------aaa");
    data.add(_mappedTo_7);
    Pair<String, String> _mappedTo_8 = Pair.<String, String>of("aaaaaaaaaa", "--------aa");
    data.add(_mappedTo_8);
    Pair<String, String> _mappedTo_9 = Pair.<String, String>of("aaaaaaaaaa", "---------a");
    data.add(_mappedTo_9);
    Pair<String, String> _mappedTo_10 = Pair.<String, String>of("aaaaaaaaaa", "----------");
    data.add(_mappedTo_10);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aaaaaaaaaa <> aaaaaaaaaa --> 0.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> -aaaaaaaaa --> 0.25");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> --aaaaaaaa --> 0.50");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> ---aaaaaaa --> 0.75");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> ----aaaaaa --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> -----aaaaa --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> ------aaaa --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> -------aaa --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> --------aa --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> ---------a --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> ---------- --> 1.00");
    _builder.newLine();
    final String expected = _builder.toString();
    String _trim = expected.trim();
    String _similarityStr = this.similarityStr(((Pair<String, String>[])Conversions.unwrapArray(data, Pair.class)));
    Assert.assertEquals(_trim, _similarityStr);
  }
  
  @Test
  public void testBeginningAndEnd() {
    final ArrayList<Pair<String, String>> data = CollectionLiterals.<Pair<String, String>>newArrayList();
    Pair<String, String> _mappedTo = Pair.<String, String>of("aaaaaaaaaa", "aaaaaaaaaa");
    data.add(_mappedTo);
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("aaaaaaaaaa", "aaaaa-aaaa");
    data.add(_mappedTo_1);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("aaaaaaaaaa", "aaaa--aaaa");
    data.add(_mappedTo_2);
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("aaaaaaaaaa", "aaaa---aaa");
    data.add(_mappedTo_3);
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("aaaaaaaaaa", "aaa----aaa");
    data.add(_mappedTo_4);
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("aaaaaaaaaa", "aaa-----aa");
    data.add(_mappedTo_5);
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("aaaaaaaaaa", "aa------aa");
    data.add(_mappedTo_6);
    Pair<String, String> _mappedTo_7 = Pair.<String, String>of("aaaaaaaaaa", "aa-------a");
    data.add(_mappedTo_7);
    Pair<String, String> _mappedTo_8 = Pair.<String, String>of("aaaaaaaaaa", "a--------a");
    data.add(_mappedTo_8);
    Pair<String, String> _mappedTo_9 = Pair.<String, String>of("aaaaaaaaaa", "a---------");
    data.add(_mappedTo_9);
    Pair<String, String> _mappedTo_10 = Pair.<String, String>of("aaaaaaaaaa", "----------");
    data.add(_mappedTo_10);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aaaaaaaaaa <> aaaaaaaaaa --> 0.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> aaaaa-aaaa --> 0.25");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> aaaa--aaaa --> 0.50");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> aaaa---aaa --> 0.75");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> aaa----aaa --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> aaa-----aa --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> aa------aa --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> aa-------a --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> a--------a --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> a--------- --> 1.00");
    _builder.newLine();
    _builder.append("aaaaaaaaaa <> ---------- --> 1.00");
    _builder.newLine();
    final String expected = _builder.toString();
    String _trim = expected.trim();
    String _similarityStr = this.similarityStr(((Pair<String, String>[])Conversions.unwrapArray(data, Pair.class)));
    Assert.assertEquals(_trim, _similarityStr);
  }
  
  public String similarityStr(final Pair<String, String>... pairs) {
    final Function1<Pair<String, String>, String> _function = new Function1<Pair<String, String>, String>() {
      @Override
      public String apply(final Pair<String, String> it) {
        StringConcatenation _builder = new StringConcatenation();
        String _key = it.getKey();
        _builder.append(_key, "");
        _builder.append(" <> ");
        String _value = it.getValue();
        _builder.append(_value, "");
        _builder.append(" --> ");
        String _key_1 = it.getKey();
        String _value_1 = it.getValue();
        float _similarity = StringSimilarityFunctionTest.this.similarity(_key_1, _value_1);
        String _format = String.format("%.2f", Float.valueOf(_similarity));
        _builder.append(_format, "");
        return _builder.toString();
      }
    };
    List<String> _map = ListExtensions.<Pair<String, String>, String>map(((List<Pair<String, String>>)Conversions.doWrapArray(pairs)), _function);
    return IterableExtensions.join(_map, "\n");
  }
  
  public float similarity(final String s1, final String s2) {
    StringEndsSimilarityFunction _stringEndsSimilarityFunction = new StringEndsSimilarityFunction();
    return _stringEndsSimilarityFunction.similarity(s1, s2);
  }
}
