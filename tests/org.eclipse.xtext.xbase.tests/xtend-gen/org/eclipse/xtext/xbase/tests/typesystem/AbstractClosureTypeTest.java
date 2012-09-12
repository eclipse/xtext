package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.collect.Iterators;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractClosureTypeTest extends AbstractXbaseTestCase {
  public abstract List<Object> resolvesClosuresTo(final String expression, final String... types);
  
  public abstract void withEquivalents(final List<Object> references, final String... type);
  
  private static Set<String> seenExpressions;
  
  @BeforeClass
  public static void createSeenExpressionsSet() {
    HashSet<String> _newHashSet = CollectionLiterals.<String>newHashSet();
    AbstractClosureTypeTest.seenExpressions = _newHashSet;
  }
  
  @AfterClass
  public static void discardSeenExpressions() {
    AbstractClosureTypeTest.seenExpressions = null;
  }
  
  protected List<XClosure> findClosures(final CharSequence expression) {
    try {
      final XExpression xExpression = this.expression(expression, false);
      TreeIterator<EObject> _eAll = EcoreUtil2.eAll(xExpression);
      Iterator<XClosure> _filter = Iterators.<XClosure>filter(_eAll, XClosure.class);
      final List<XClosure> closures = IteratorExtensions.<XClosure>toList(_filter);
      final Function1<XClosure,Integer> _function = new Function1<XClosure,Integer>() {
          public Integer apply(final XClosure it) {
            ICompositeNode _findActualNodeFor = NodeModelUtils.findActualNodeFor(it);
            int _offset = _findActualNodeFor.getOffset();
            return Integer.valueOf(_offset);
          }
        };
      return IterableExtensions.<XClosure, Integer>sortBy(closures, _function);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected XExpression expression(final CharSequence expression, final boolean resolve) throws Exception {
    XExpression _xblockexpression = null;
    {
      final String string = expression.toString();
      boolean _add = AbstractClosureTypeTest.seenExpressions.add(string);
      boolean _not = (!_add);
      if (_not) {
        String _plus = ("Duplicate expression under test: " + expression);
        Assert.fail(_plus);
      }
      XExpression _expression = super.expression(expression, resolve);
      _xblockexpression = (_expression);
    }
    return _xblockexpression;
  }
  
  @Test
  public void testIfExpression_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("if (true) [|\'\'] else [|\'\']", "()=>String", "()=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function0<String>", "Function0<String>");
  }
  
  @Test
  public void testIfExpression_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("if (true) [|\'\'] else [|null as CharSequence]", "()=>String", "()=>CharSequence");
    this.withEquivalents(_resolvesClosuresTo, "Function0<String>", "Function0<CharSequence>");
  }
  
  @Test
  public void testIfExpression_03() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("if (true) [|null as Appendable] else [|null as CharSequence]", "()=>Appendable", "()=>CharSequence");
    this.withEquivalents(_resolvesClosuresTo, "Function0<Appendable>", "Function0<CharSequence>");
  }
  
  @Test
  public void testIfExpression_04() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("if (true) [ CharSequence c |\'\'] else [ String s |\'\']", "(CharSequence)=>String", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<CharSequence, String>", "Function1<String, String>");
  }
  
  @Test
  public void testIfExpression_05() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("if (true) [new StringBuilder()] else [new StringBuffer()]", "(Object)=>StringBuilder", "(Object)=>StringBuffer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, StringBuilder>", "Function1<Object, StringBuffer>");
  }
  
  @Test
  public void testIfExpression_06() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(if (true) [new StringBuilder()] else [new StringBuffer()]).apply(\'\')", "(String)=>StringBuilder", "(String)=>StringBuffer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, StringBuilder>", "Function1<String, StringBuffer>");
  }
  
  @Test
  public void testIfExpression_07() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(if (true) [CharSequence c | new StringBuilder()] else [new StringBuffer()])", "(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>");
  }
  
  @Test
  public void testIfExpression_08() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(if (true) [CharSequence c | new StringBuilder()] else [new StringBuffer()]).apply(\'\')", "(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>");
  }
  
  @Test
  public void testIfExpression_09() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(if (true) [new StringBuilder()] else [CharSequence c | new StringBuffer()])", "(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>");
  }
  
  @Test
  public void testIfExpression_10() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(if (true) [new StringBuilder()] else [CharSequence c | new StringBuffer()]).apply(\'\')", "(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>");
  }
  
  @Test
  public void testIfExpression_11() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(if (true) [Appendable a |new StringBuilder()] else [CharSequence c | new StringBuffer()])", "(Appendable)=>StringBuilder", "(CharSequence)=>StringBuffer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Appendable, StringBuilder>", "Function1<CharSequence, StringBuffer>");
  }
  
  @Test
  public void testIfExpression_12() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var java.io.FileFilter filter = (if (true) [true] else [false])", "(File)=>boolean", "(File)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "FileFilter", "FileFilter");
  }
  
  @Test
  public void testNumberLiteralInClosure() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList().map[42]", "(Object)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Integer>");
  }
  
  @Test
  public void testOverloadedOperators_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].isEmpty", "(Integer)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Boolean>");
  }
  
  @Test
  public void testOverloadedOperators_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ toString ].reduce[ i1, i2| i1 + i2 ]", "(Integer)=>String", "(String, String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, String>", "Function2<String, String, String>");
  }
  
  @Test
  public void testOverloadedOperators_03() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ toString.length ].reduce[ i1, i2| i1 + i2 ]", "(Integer)=>int", "(Integer, Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testOverloadedOperators_04() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + i2 ]", "(Integer)=>BigInteger", "(BigInteger, BigInteger)=>BigInteger");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, BigInteger>", "Function2<BigInteger, BigInteger, BigInteger>");
  }
  
  @Ignore(value = "i1 and i2 should become T -> Object thus + maps to String + Object")
  @Test
  public void testOverloadedOperators_05() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2 | i1.toString + i2 ]", "(Integer)=>BigInteger", "(Object, Object)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, BigInteger>", "Function2<Object, Object, String>");
  }
  
  @Ignore(value = "i1 and i2 should become T -> Object thus + maps to Object + String")
  @Test
  public void testOverloadedOperators_06() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + String::valueOf(i2) ]", "(Integer)=>BigInteger", "(Object, Object)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, BigInteger>", "Function2<Object, Object, String>");
  }
  
  @Test
  public void testOverloadedOperators_07() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i.toString + i ]", "(Integer)=>BigInteger", "(BigInteger)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, BigInteger>", "Function1<BigInteger, String>");
  }
  
  @Test
  public void testOverloadedOperators_08() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i + String::valueOf(i) ]", "(Integer)=>BigInteger", "(BigInteger)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, BigInteger>", "Function1<BigInteger, String>");
  }
  
  @Test
  public void testOverloadedOperators_09() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].empty", "(Integer)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Boolean>");
  }
  
  @Test
  public void testOverloadedOperators_10() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(0..Math::sqrt(1l).intValue).filter[ i | return 1l % i == 0 ].isEmpty", "(Integer)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Boolean>");
  }
  
  @Test
  public void testOverloadedOperators_11() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ toString ].reduce[ i1, i2| return i1 + i2 ]", "(Integer)=>String", "(String, String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, String>", "Function2<String, String, String>");
  }
  
  @Test
  public void testOverloadedOperators_12() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ toString.length ].reduce[ i1, i2| return i1 + i2 ]", "(Integer)=>int", "(Integer, Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testOverloadedOperators_13() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| return i1 + i2 ]", "(Integer)=>BigInteger", "(BigInteger, BigInteger)=>BigInteger");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, BigInteger>", "Function2<BigInteger, BigInteger, BigInteger>");
  }
  
  @Test
  public void testOverloadedOperators_14() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(0..Math::sqrt(1l).intValue).filter[ i | if (true) return 1l % i == 0 ].isEmpty", "(Integer)=>Boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Boolean>");
  }
  
  @Test
  public void testOverloadedOperators_15() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ if (true) toString ].reduce[ i1, i2| if (true) return i1 + i2 ]", "(Integer)=>String", "(String, String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, String>", "Function2<String, String, String>");
  }
  
  @Test
  public void testOverloadedOperators_16() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ if (true) toString.length ].reduce[ i1, i2| if (true) return i1 + i2 ]", "(Integer)=>Integer", "(Integer, Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testOverloadedOperators_17() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| if (true) return i1 + i2 ]", "(Integer)=>BigInteger", "(BigInteger, BigInteger)=>BigInteger");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, BigInteger>", "Function2<BigInteger, BigInteger, BigInteger>");
  }
  
  @Test
  public void testOverloadedOperators_18() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(0..Math::sqrt(1l).intValue).filter[ i | if (true) return 1l % i == 0 else return null ].isEmpty", "(Integer)=>Boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Boolean>");
  }
  
  @Test
  public void testOverloadedOperators_19() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ if (true) toString.length ].reduce[ i1, i2| if (true) return i1 + i2 else return 1 ]", "(Integer)=>Integer", "(Integer, Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testOverloadedOperators_20() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ if (true) toString.length ].reduce[ i1, i2| if (true) return i1 + i2 else return null ]", "(Integer)=>Integer", "(Integer, Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testMethodTypeParamInference_00() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("new java.util.ArrayList<String>().findFirst(e | true)", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testMethodTypeParamInference_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("new java.util.ArrayList<String>().findFirst(e|e == \'foo\')", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testMethodTypeParamInference_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("new java.util.ArrayList<String>().<String>findFirst(e|e == \'foo\')", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testMethodTypeParamInference_03() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("new java.util.ArrayList<String>().findFirst(Object e|e == \'foo\')", "(Object)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Boolean>");
  }
  
  @Test
  public void testMethodTypeParamInference_04() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e | true]", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testMethodTypeParamInference_05() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e|e == \'foo\']", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testMethodTypeParamInference_06() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e|e == \'foo\']", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testMethodTypeParamInference_07() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [Object e|e == \'foo\']", "(Object)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Boolean>");
  }
  
  @Test
  public void testTypeForVoidClosure() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'foo\',\'bar\').forEach []", "(String)=>void");
    this.withEquivalents(_resolvesClosuresTo, "Procedure1<String>");
  }
  
  @Test
  public void testClosure_00() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[|\'literal\'].apply()", "()=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function0<String>");
  }
  
  @Test
  public void testClosure_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var closure = [|\'literal\']\n\t\t  new testdata.ClosureClient().invoke0(closure)\t}", "()=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function0<String>");
  }
  
  @Test
  public void testClosure_02() throws Exception {
    String _plus = ("{\n" + 
      "  var java.util.List<? super String> list = null;\n");
    String _plus_1 = (_plus + 
      "  list.map(e|e)\n");
    String _plus_2 = (_plus_1 + 
      "}");
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo(_plus_2, "(Object)=>Object");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_03() throws Exception {
    String _plus = ("{\n" + 
      "  var java.util.List<? super String> list = null;\n");
    String _plus_1 = (_plus + 
      "  list.map(e|false)\n");
    String _plus_2 = (_plus_1 + 
      "}");
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo(_plus_2, "(Object)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Boolean>");
  }
  
  @Test
  public void testClosure_04() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval mapper = [ x | x ]\n\t\t\tnewArrayList(1).map(mapper)\n\t\t}", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testClosure_05() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval mapper = [ x | x ]\n\t\t\tnewArrayList(1).map(mapper).head\n\t\t}", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testClosure_06() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval mapper = [ x | x ]\n\t\t\tnewArrayList(1).map(mapper).findFirst [ true ]\n\t\t}", "(Integer)=>Integer", "(Integer)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function1<Integer, Boolean>");
  }
  
  @Ignore(value = "TODO deferred closure body typing")
  @Test
  public void testClosure_07() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval mapper = [ x | x.charAt(0) ]\n\t\t\tnewArrayList(\'\').map(mapper)\n\t\t}", "Function1<String, Character>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Character>");
  }
  
  @Test
  public void testClosure_08() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval String s = fun.apply(null)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_09() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.List<String> list = newArrayList(fun.apply(null))\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_10() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.List<String> list = newArrayList.map(fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_11() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.Set<String> list = newArrayList.map(fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_12() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.ArrayList<String> list = newArrayList.map(fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_13() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval Iterable<String> list = newArrayList.map(fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_14() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval list = newArrayList.map(fun)\n\t\t\tval Iterable<String> iter = list\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_15() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.List<String> list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_16() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.Set<String> list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_17() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.ArrayList<String> list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_18() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval Iterable<String> list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_19() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tval Iterable<String> iter = list\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_20() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval mapper = [ x | x ]\n\t\t\t$$ListExtensions::map(newArrayList(1), mapper)\n\t\t}", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testClosure_21() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[|].apply()", "()=>Object");
    this.withEquivalents(_resolvesClosuresTo, "Function0<Object>");
  }
  
  @Test
  public void testClosure_22() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[].apply()", "(Object)=>Object");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_23() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("$$ListExtensions::map(null as java.util.List<? super String>) [e|e]", "(Object)=>Object");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_24() throws Exception {
    String _plus = ("{\n" + 
      "  var java.util.List<? super String> list = null;\n");
    String _plus_1 = (_plus + 
      "  $$ListExtensions::map(list) [e|e]\n");
    String _plus_2 = (_plus_1 + 
      "}");
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo(_plus_2, "(Object)=>Object");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_25() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[|\'literal\']", "()=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function0<String>");
  }
  
  @Test
  public void testClosure_26() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList(\'\')\n\t\t\tjava::util::Collections::sort(list) [ s1, s2 | s1.compareTo(s2) ]\n\t\t\tlist\n\t\t}", "(String, String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Comparator<String>");
  }
  
  @Test
  public void testEMap_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ getKey ].head\n         }", "(Entry<Integer, String>)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<Integer, String>, Integer>");
  }
  
  @Test
  public void testEMap_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ getValue ].head\n         }", "(Entry<Integer, String>)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<Integer, String>, String>");
  }
  
  @Test
  public void testEMap_03() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ it ].head\n         }", "(Entry<Integer, String>)=>Entry<Integer, String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<Integer, String>, Entry<Integer, String>>");
  }
  
  @Test
  public void testEMap_04() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n\t\t  eMap.map[ getKey ].head\n         }", "(Entry<? extends Integer, String>)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<? extends Integer, String>, Integer>");
  }
  
  @Test
  public void testEMap_05() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n\t\t  eMap.map[ getValue ].head\n         }", "(Entry<? extends Integer, String>)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<? extends Integer, String>, String>");
  }
  
  @Test
  public void testEMap_06() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n\t\t  eMap.map[ it ].head\n         }", "(Entry<? extends Integer, String>)=>Entry<? extends Integer, String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<? extends Integer, String>, Entry<? extends Integer, String>>");
  }
  
  @Test
  public void testEMap_07() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<Integer, ? extends String> eMap = null\n\t\t  eMap.map[ getKey ].head\n         }", "(Entry<Integer, ? extends String>)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<Integer, ? extends String>, Integer>");
  }
  
  @Test
  public void testEMap_08() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<Integer, ? extends String> eMap = null\n\t\t  eMap.map[ getValue ].head\n         }", "(Entry<Integer, ? extends String>)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<Integer, ? extends String>, String>");
  }
  
  @Test
  public void testEMap_09() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<Integer, ? extends String> eMap = null\n\t\t  eMap.map[ it ].head\n         }", "(Entry<Integer, ? extends String>)=>Entry<Integer, ? extends String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<Integer, ? extends String>, Entry<Integer, ? extends String>>");
  }
  
  @Test
  public void testMemberFeatureCall_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..20).map[ toString.length ].reduce[ i1,  i2 | i1 + i2 ]", "(Integer)=>int", "(Integer, Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s)", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map [it|it]", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_03() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map [it]", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_04() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(null as Iterable<String>).map(s|s)", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_05() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("$$ListExtensions::map(newArrayList(\'\')) [s|s]", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_06() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s).head", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_07() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.toString).head", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_08() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1)", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_09() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1).head", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_10() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length)", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_11() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("<String>newArrayList.map(s|s.length)", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_12() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length).head", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_13() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("<String>newArrayList.map(s|s.length).head", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_14() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s != null)", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testFeatureCall_15() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length+1)", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_16() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1).map(i|i+1)", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_17() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1).toList()", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_18() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1).toList().map(i|i)", "(String)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_19() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1).toList().map(i|i+1)", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_20() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var it = newArrayList(\'\').map(s|1).toList() it.map(i|i+1) }", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_21() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var it = newArrayList(\'\').map(s|1).toList() map(i|i+1) }", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_22() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var it = newArrayList(\'\').map(s|1).toList() it }", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_23() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var java.util.List<? extends Integer> it = null map(i|i+1) }", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_24() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var java.util.List<? extends Integer> it = null map(i|i) }", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_25() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s|1))", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_26() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size())", "(String)=>int", "(List<Integer>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<List<Integer>, Integer>");
  }
  
  @Test
  public void testFeatureCall_27() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size()).map(e|e)", "(String)=>int", "(List<Integer>)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<List<Integer>, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_28() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e)).map(iterable|iterable.size())", "(String)=>int", "(Integer)=>Integer", "(List<Integer>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>", "Function1<List<Integer>, Integer>");
  }
  
  @Test
  public void testFeatureCall_29() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e)).map(iterable|iterable.size()).head", "(String)=>int", "(Integer)=>Integer", "(List<Integer>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>", "Function1<List<Integer>, Integer>");
  }
  
  @Test
  public void testFeatureCall_30() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size())", "(ArrayList<String>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<ArrayList<String>, Integer>");
  }
  
  @Test
  public void testFeatureCall_31() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size()).head", "(ArrayList<String>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<ArrayList<String>, Integer>");
  }
  
  @Test
  public void testFeatureCall_32() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size()).map(e|e)", "(ArrayList<String>)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<ArrayList<String>, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_33() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size()).map(e|e).head", "(ArrayList<String>)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<ArrayList<String>, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_34() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1).map(i|1)", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_35() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1).map(i|1).head", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_36() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length).map(i|i)", "(String)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_37() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length).map(i|i).head", "(String)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_38() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b|b)", "(String)=>boolean", "(Boolean)=>Boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_39() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b|b).head", "(String)=>boolean", "(Boolean)=>Boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_40() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { \'length\'.length b })", "(String)=>boolean", "(Boolean)=>Boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_41() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { \'length\'.length b }).head", "(String)=>boolean", "(Boolean)=>Boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_42() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(Boolean b|!b)", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_43() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(Boolean b|!b).head", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_44() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| !!b )", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_45() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| !!b ).head", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_46() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { !b } )", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_47() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { !b } ).head", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_48() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { b.operator_not } )", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_49() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { b.operator_not } ).head", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_50() throws Exception {
    String _plus = ("newArrayList(\'\').map(s|" + 
      "$$ObjectExtensions::operator_equals(");
    String _plus_1 = (_plus + 
      "\t$$IntegerExtensions::operator_plus(s.length,1), 5)");
    String _plus_2 = (_plus_1 + 
      ").map(b| $$BooleanExtensions::operator_not(b) )");
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo(_plus_2, "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_51() throws Exception {
    String _plus = ("newArrayList(\'\').map(s|" + 
      "$$ObjectExtensions::operator_equals(");
    String _plus_1 = (_plus + 
      "\t$$IntegerExtensions::operator_plus(s.length,1), 5)");
    String _plus_2 = (_plus_1 + 
      ").map(b| $$BooleanExtensions::operator_not(b) ).head");
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo(_plus_2, "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_52() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 * 5).map(b| b / 5 )", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_53() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 * 5).map(b| b / 5 ).head", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_54() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map[ length + 1 * 5 ].map [ it / 5 ).head", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Ignore(value = "Too slow")
  @Test
  public void testFeatureCall_55() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map[ length + 1 * 5 - length + 1 * 5 ].map [ it / 5 + 1 / it ).head", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_56() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_57() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list.head\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_58() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = $$ListExtensions::map(newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\'))) [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_59() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = $$ListExtensions::map(newArrayList(null as Integer)) [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_60() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(null as Integer).map [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_61() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(null as Integer).map [ v|v.intValue ]\n           val Object o = list.head \n           list.findFirst [ intValue == 0 ]\n        }", "(Integer)=>int", "(Integer)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function1<Integer, Boolean>");
  }
  
  @Test
  public void testFeatureCall_62() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.forEach[String s | s]\n\t\t\tlist\n\t\t}", "(String)=>void");
    this.withEquivalents(_resolvesClosuresTo, "Procedure1<String>");
  }
  
  @Test
  public void testFeatureCall_63() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.findFirst[String s | true]\n\t\t\tlist\n\t\t}", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testFeatureCall_64() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList.map[String s | s.substring(1,1) ]", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_65() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList.map[ s | s.toString ]", "(Object)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, String>");
  }
  
  @Test
  public void testFeatureCall_66() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.forEach[ s | s.toString ]\n\t\t\tlist\n\t\t}", "(Object)=>void");
    this.withEquivalents(_resolvesClosuresTo, "Procedure1<Object>");
  }
  
  @Test
  public void testFeatureCall_67() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(new Double(\'-20\'), new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_68() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(new Double(\'-20\'), new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list.head\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_69() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = $$ListExtensions::map(newArrayList(new Double(\'-20\'), new Integer(\'20\'))) [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_00() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(null as java.util.List<String>).map(e|newArrayList(e)).flatten", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(null as java.util.List<String>).map(e|newArrayList(e)).flatten.head", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(e|newArrayList(e)).flatten", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_03() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(e|newArrayList(e)).flatten.head", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_04() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(e|newArrayList(e))", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_05() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(e|newArrayList(e)).head", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_06() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("<String>newArrayList.map(e|newArrayList(e)).flatten", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_07() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(e|<String>newArrayList(e)).flatten", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_08() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList.map(String e|<String>newArrayList(e)).flatten", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tval fun = [String s| s]\n\t\t\tlist.map(fun)\n\t\t\tlist\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.map[String s| s]\n\t\t\tlist\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_03() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.map[String s| s]\n\t\t\tlist\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_04() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\t$$IterableExtensions::map(list, [String s| s])\n\t\t\tlist\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_05() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tval fun = [String s| s]\n\t\t\t$$IterableExtensions::map(list, fun)\n\t\t\tlist\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_06() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.map(println([String s| println(s)]))\n\t\t\tlist\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_07() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tval fun = [String s| return s]\n\t\t\tlist.map(fun)\n\t\t\tlist\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_08() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.map[String s| return s]\n\t\t\tlist\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_09() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.map[String s| return s]\n\t\t\tlist\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_10() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\t$$IterableExtensions::map(list, [String s| return s])\n\t\t\tlist\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_11() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tval fun = [String s| return s]\n\t\t\t$$IterableExtensions::map(list, fun)\n\t\t\tlist\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_12() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.map(println([String s| return println(s)]))\n\t\t\tlist\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testCLosureWithReturnExpression_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[ | if (true) return \'\' else return new StringBuilder ]", "()=>Serializable & CharSequence");
    this.withEquivalents(_resolvesClosuresTo, "Function0<Serializable & CharSequence>");
  }
  
  @Test
  public void testCLosureWithReturnExpression_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[ | if (true) \'\' else return new StringBuilder ]", "()=>Serializable & CharSequence");
    this.withEquivalents(_resolvesClosuresTo, "Function0<Serializable & CharSequence>");
  }
  
  @Test
  public void testCLosureWithReturnExpression_03() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[ | if (true) return \'\' else new StringBuilder ]", "()=>Serializable & CharSequence");
    this.withEquivalents(_resolvesClosuresTo, "Function0<Serializable & CharSequence>");
  }
  
  @Test
  public void testCLosureWithReturnExpression_04() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[ | if (true) \'\' else new StringBuilder ]", "()=>Serializable & CharSequence");
    this.withEquivalents(_resolvesClosuresTo, "Function0<Serializable & CharSequence>");
  }
  
  @Test
  public void testCLosureWithReturnExpression_05() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[ int i1, int i2| if (true) return i1 else return null ].apply(1, 1)", "(int, int)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function2<Integer, Integer, Integer>");
  }
}
