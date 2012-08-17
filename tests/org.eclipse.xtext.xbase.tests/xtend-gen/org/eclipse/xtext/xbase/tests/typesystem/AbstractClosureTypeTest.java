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
  public void testNumberLiteralInClosure() throws Exception {
    this.resolvesClosuresTo("newArrayList().map[42]", "(Object)=>int");
  }
  
  @Test
  public void testOverloadedOperators_01() throws Exception {
    this.resolvesClosuresTo("(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].isEmpty", "(Integer)=>boolean");
  }
  
  @Test
  public void testOverloadedOperators_02() throws Exception {
    this.resolvesClosuresTo("(1..2).map[ toString ].reduce[ i1, i2| i1 + i2 ]", "(Integer)=>String", "(String, String)=>String");
  }
  
  @Test
  public void testOverloadedOperators_03() throws Exception {
    this.resolvesClosuresTo("(1..2).map[ toString.length ].reduce[ i1, i2| i1 + i2 ]", "(Integer)=>int", "(Integer, Integer)=>int");
  }
  
  @Test
  public void testOverloadedOperators_04() throws Exception {
    this.resolvesClosuresTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + i2 ]", 
      "(Integer)=>BigInteger", "(BigInteger, BigInteger)=>BigInteger");
  }
  
  @Ignore(value = "i1 and i2 should become T -> Object thus + maps to String + Object")
  @Test
  public void testOverloadedOperators_05() throws Exception {
    this.resolvesClosuresTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2 | i1.toString + i2 ]", 
      "(Integer)=>BigInteger", "(Object, Object)=>String");
  }
  
  @Ignore(value = "i1 and i2 should become T -> Object thus + maps to Object + String")
  @Test
  public void testOverloadedOperators_06() throws Exception {
    this.resolvesClosuresTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + String::valueOf(i2) ]", 
      "(Integer)=>BigInteger", "(Object, Object)=>String");
  }
  
  @Test
  public void testOverloadedOperators_07() throws Exception {
    this.resolvesClosuresTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i.toString + i ]", 
      "(Integer)=>BigInteger", "(BigInteger)=>String");
  }
  
  @Test
  public void testOverloadedOperators_08() throws Exception {
    this.resolvesClosuresTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i + String::valueOf(i) ]", 
      "(Integer)=>BigInteger", "(BigInteger)=>String");
  }
  
  @Test
  public void testOverloadedOperators_09() throws Exception {
    this.resolvesClosuresTo("(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].empty", 
      "(Integer)=>boolean");
  }
  
  @Test
  public void testMethodTypeParamInference_00() throws Exception {
    this.resolvesClosuresTo("new java.util.ArrayList<String>().findFirst(e | true)", "(String)=>boolean");
  }
  
  @Test
  public void testMethodTypeParamInference_01() throws Exception {
    this.resolvesClosuresTo("new java.util.ArrayList<String>().findFirst(e|e == \'foo\')", "(String)=>boolean");
  }
  
  @Test
  public void testMethodTypeParamInference_02() throws Exception {
    this.resolvesClosuresTo("new java.util.ArrayList<String>().<String>findFirst(e|e == \'foo\')", "(String)=>boolean");
  }
  
  @Test
  public void testMethodTypeParamInference_03() throws Exception {
    this.resolvesClosuresTo("new java.util.ArrayList<String>().findFirst(Object e|e == \'foo\')", "(Object)=>boolean");
  }
  
  @Test
  public void testMethodTypeParamInference_04() throws Exception {
    this.resolvesClosuresTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e | true]", "(String)=>boolean");
  }
  
  @Test
  public void testMethodTypeParamInference_05() throws Exception {
    this.resolvesClosuresTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e|e == \'foo\']", "(String)=>boolean");
  }
  
  @Test
  public void testMethodTypeParamInference_06() throws Exception {
    this.resolvesClosuresTo("$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e|e == \'foo\']", "(String)=>boolean");
  }
  
  @Test
  public void testMethodTypeParamInference_07() throws Exception {
    this.resolvesClosuresTo("$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [Object e|e == \'foo\']", "(Object)=>boolean");
  }
  
  @Test
  public void testTypeForVoidClosure() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'foo\',\'bar\').forEach []", "(String)=>void");
  }
  
  @Test
  public void testClosure_00() throws Exception {
    this.resolvesClosuresTo("[|\'literal\'].apply()", "()=>String");
  }
  
  @Test
  public void testClosure_01() throws Exception {
    this.resolvesClosuresTo("{ var closure = [|\'literal\']\n\t\t  new testdata.ClosureClient().invoke0(closure)\t}", "()=>String");
  }
  
  @Test
  public void testClosure_02() throws Exception {
    String _plus = ("{\n" + 
      "  var java.util.List<? super String> list = null;\n");
    String _plus_1 = (_plus + 
      "  list.map(e|e)\n");
    String _plus_2 = (_plus_1 + 
      "}");
    this.resolvesClosuresTo(_plus_2, "(Object)=>Object");
  }
  
  @Test
  public void testClosure_03() throws Exception {
    String _plus = ("{\n" + 
      "  var java.util.List<? super String> list = null;\n");
    String _plus_1 = (_plus + 
      "  list.map(e|false)\n");
    String _plus_2 = (_plus_1 + 
      "}");
    this.resolvesClosuresTo(_plus_2, "(Object)=>boolean");
  }
  
  @Test
  public void testClosure_04() throws Exception {
    this.resolvesClosuresTo("{ \n\t\t\tval mapper = [ x | x ]\n\t\t\tnewArrayList(1).map(mapper)\n\t\t}", "(Integer)=>Integer");
  }
  
  @Test
  public void testClosure_05() throws Exception {
    this.resolvesClosuresTo("{ \n\t\t\tval mapper = [ x | x ]\n\t\t\tnewArrayList(1).map(mapper).head\n\t\t}", "(Integer)=>Integer");
  }
  
  @Test
  public void testClosure_06() throws Exception {
    this.resolvesClosuresTo("{ \n\t\t\tval mapper = [ x | x ]\n\t\t\tnewArrayList(1).map(mapper).findFirst [ true ]\n\t\t}", "(Integer)=>Integer", "(Integer)=>boolean");
  }
  
  @Ignore(value = "TODO deferred closure body typing")
  @Test
  public void testClosure_07() throws Exception {
    this.resolvesClosuresTo("{ \n\t\t\tval mapper = [ x | x.charAt(0) ]\n\t\t\tnewArrayList(\'\').map(mapper)\n\t\t}", "List<Character>");
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
    this.resolvesClosuresTo("{ \n\t\t\tval mapper = [ x | x ]\n\t\t\t$$ListExtensions::map(newArrayList(1), mapper)\n\t\t}", "(Integer)=>Integer");
  }
  
  @Test
  public void testClosure_21() throws Exception {
    this.resolvesClosuresTo("[|].apply()", "()=>Object");
  }
  
  @Test
  public void testClosure_22() throws Exception {
    this.resolvesClosuresTo("[].apply()", "(Object)=>Object");
  }
  
  @Test
  public void testClosure_23() throws Exception {
    this.resolvesClosuresTo("$$ListExtensions::map(null as java.util.List<? super String>) [e|e]", "(Object)=>Object");
  }
  
  @Test
  public void testClosure_24() throws Exception {
    String _plus = ("{\n" + 
      "  var java.util.List<? super String> list = null;\n");
    String _plus_1 = (_plus + 
      "  $$ListExtensions::map(list) [e|e]\n");
    String _plus_2 = (_plus_1 + 
      "}");
    this.resolvesClosuresTo(_plus_2, "(Object)=>Object");
  }
  
  @Test
  public void testClosure_25() throws Exception {
    this.resolvesClosuresTo("[|\'literal\']", "()=>String");
  }
  
  @Test
  public void testClosure_26() throws Exception {
    this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList(\'\')\n\t\t\tjava::util::Collections::sort(list) [ s1, s2 | s1.compareTo(s2) ]\n\t\t\tlist\n\t\t}", "(String, String)=>int");
  }
  
  @Test
  public void testEMap_01() throws Exception {
    this.resolvesClosuresTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ getKey ].head\n         }", "(Entry<Integer, String>)=>Integer");
  }
  
  @Test
  public void testEMap_02() throws Exception {
    this.resolvesClosuresTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ getValue ].head\n         }", "(Entry<Integer, String>)=>String");
  }
  
  @Test
  public void testEMap_03() throws Exception {
    this.resolvesClosuresTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ it ].head\n         }", "(Entry<Integer, String>)=>Entry<Integer, String>");
  }
  
  @Test
  public void testMemberFeatureCall_01() throws Exception {
    this.resolvesClosuresTo("(1..20).map[ toString.length ].reduce[ i1,  i2 | i1 + i2 ]", 
      "(Integer)=>int", "(Integer, Integer)=>int");
  }
  
  @Test
  public void testFeatureCall_01() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s)", "(String)=>String");
  }
  
  @Test
  public void testFeatureCall_02() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map [it|it]", "(String)=>String");
  }
  
  @Test
  public void testFeatureCall_03() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map [it]", "(String)=>String");
  }
  
  @Test
  public void testFeatureCall_04() throws Exception {
    this.resolvesClosuresTo("(null as Iterable<String>).map(s|s)", "(String)=>String");
  }
  
  @Test
  public void testFeatureCall_05() throws Exception {
    this.resolvesClosuresTo("$$ListExtensions::map(newArrayList(\'\')) [s|s]", "(String)=>String");
  }
  
  @Test
  public void testFeatureCall_06() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s).head", "(String)=>String");
  }
  
  @Test
  public void testFeatureCall_07() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.toString).head", "(String)=>String");
  }
  
  @Test
  public void testFeatureCall_08() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|1)", "(String)=>int");
  }
  
  @Test
  public void testFeatureCall_09() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|1).head", "(String)=>int");
  }
  
  @Test
  public void testFeatureCall_10() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length)", "(String)=>int");
  }
  
  @Test
  public void testFeatureCall_11() throws Exception {
    this.resolvesClosuresTo("<String>newArrayList.map(s|s.length)", "(String)=>int");
  }
  
  @Test
  public void testFeatureCall_12() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length).head", "(String)=>int");
  }
  
  @Test
  public void testFeatureCall_13() throws Exception {
    this.resolvesClosuresTo("<String>newArrayList.map(s|s.length).head", "(String)=>int");
  }
  
  @Test
  public void testFeatureCall_14() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s != null)", "(String)=>boolean");
  }
  
  @Test
  public void testFeatureCall_15() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length+1)", "(String)=>int");
  }
  
  @Test
  public void testFeatureCall_16() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|1).map(i|i+1)", "(String)=>int", "(Integer)=>int");
  }
  
  @Test
  public void testFeatureCall_17() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|1).toList()", "(String)=>int");
  }
  
  @Test
  public void testFeatureCall_18() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|1).toList().map(i|i)", "(String)=>int", "(Integer)=>Integer");
  }
  
  @Test
  public void testFeatureCall_19() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|1).toList().map(i|i+1)", "(String)=>int", "(Integer)=>int");
  }
  
  @Test
  public void testFeatureCall_20() throws Exception {
    this.resolvesClosuresTo("{ var it = newArrayList(\'\').map(s|1).toList() it.map(i|i+1) }", "(String)=>int", "(Integer)=>int");
  }
  
  @Test
  public void testFeatureCall_21() throws Exception {
    this.resolvesClosuresTo("{ var it = newArrayList(\'\').map(s|1).toList() map(i|i+1) }", "(String)=>int", "(Integer)=>int");
  }
  
  @Test
  public void testFeatureCall_22() throws Exception {
    this.resolvesClosuresTo("{ var it = newArrayList(\'\').map(s|1).toList() it }", "(String)=>int");
  }
  
  @Test
  public void testFeatureCall_23() throws Exception {
    this.resolvesClosuresTo("{ var java.util.List<? extends Integer> it = null map(i|i+1) }", "(Integer)=>int");
  }
  
  @Test
  public void testFeatureCall_24() throws Exception {
    this.resolvesClosuresTo("{ var java.util.List<? extends Integer> it = null map(i|i) }", "(Integer)=>Integer");
  }
  
  @Test
  public void testFeatureCall_25() throws Exception {
    this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s|1))", "(String)=>int");
  }
  
  @Test
  public void testFeatureCall_26() throws Exception {
    this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size())", 
      "(String)=>int", "(List<Integer>)=>int");
  }
  
  @Test
  public void testFeatureCall_27() throws Exception {
    this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size()).map(e|e)", 
      "(String)=>int", "(List<Integer>)=>int", "(Integer)=>Integer");
  }
  
  @Test
  public void testFeatureCall_28() throws Exception {
    this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e)).map(iterable|iterable.size())", 
      "(String)=>int", "(Integer)=>Integer", "(List<Integer>)=>int");
  }
  
  @Test
  public void testFeatureCall_29() throws Exception {
    this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e)).map(iterable|iterable.size()).head", 
      "(String)=>int", "(Integer)=>Integer", "(List<Integer>)=>int");
  }
  
  @Test
  public void testFeatureCall_30() throws Exception {
    this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size())", 
      "(ArrayList<String>)=>int");
  }
  
  @Test
  public void testFeatureCall_31() throws Exception {
    this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size()).head", 
      "(ArrayList<String>)=>int");
  }
  
  @Test
  public void testFeatureCall_32() throws Exception {
    this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size()).map(e|e)", 
      "(ArrayList<String>)=>int", "(Integer)=>Integer");
  }
  
  @Test
  public void testFeatureCall_33() throws Exception {
    this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size()).map(e|e).head", 
      "(ArrayList<String>)=>int", "(Integer)=>Integer");
  }
  
  @Test
  public void testFeatureCall_34() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|1).map(i|1)", "(String)=>int", "(Integer)=>int");
  }
  
  @Test
  public void testFeatureCall_35() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|1).map(i|1).head", "(String)=>int", "(Integer)=>int");
  }
  
  @Test
  public void testFeatureCall_36() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length).map(i|i)", "(String)=>int", "(Integer)=>Integer");
  }
  
  @Test
  public void testFeatureCall_37() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length).map(i|i).head", "(String)=>int", "(Integer)=>Integer");
  }
  
  @Test
  public void testFeatureCall_38() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b|b)", 
      "(String)=>boolean", "(Boolean)=>Boolean");
  }
  
  @Test
  public void testFeatureCall_39() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b|b).head", 
      "(String)=>boolean", "(Boolean)=>Boolean");
  }
  
  @Test
  public void testFeatureCall_40() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { \'length\'.length b })", 
      "(String)=>boolean", "(Boolean)=>Boolean");
  }
  
  @Test
  public void testFeatureCall_41() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { \'length\'.length b }).head", 
      "(String)=>boolean", "(Boolean)=>Boolean");
  }
  
  @Test
  public void testFeatureCall_42() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(Boolean b|!b)", 
      "(String)=>boolean", "(Boolean)=>boolean");
  }
  
  @Test
  public void testFeatureCall_43() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(Boolean b|!b).head", 
      "(String)=>boolean", "(Boolean)=>boolean");
  }
  
  @Ignore(value = "Unary operation")
  @Test
  public void testFeatureCall_44() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| !!b )", 
      "(String)=>boolean", "(Boolean)=>boolean");
  }
  
  @Ignore(value = "Unary operation")
  @Test
  public void testFeatureCall_45() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| !!b ).head", 
      "(String)=>boolean", "(Boolean)=>boolean");
  }
  
  @Test
  public void testFeatureCall_46() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { !b } )", 
      "(String)=>boolean", "(Boolean)=>boolean");
  }
  
  @Test
  public void testFeatureCall_47() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { !b } ).head", 
      "(String)=>boolean", "(Boolean)=>boolean");
  }
  
  @Test
  public void testFeatureCall_48() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { b.operator_not } )", 
      "(String)=>boolean", "(Boolean)=>boolean");
  }
  
  @Test
  public void testFeatureCall_49() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { b.operator_not } ).head", 
      "(String)=>boolean", "(Boolean)=>boolean");
  }
  
  @Test
  public void testFeatureCall_50() throws Exception {
    String _plus = ("newArrayList(\'\').map(s|" + 
      "$$ObjectExtensions::operator_equals(");
    String _plus_1 = (_plus + 
      "\t$$IntegerExtensions::operator_plus(s.length,1), 5)");
    String _plus_2 = (_plus_1 + 
      ").map(b| $$BooleanExtensions::operator_not(b) )");
    this.resolvesClosuresTo(_plus_2, 
      "(String)=>boolean", "(Boolean)=>boolean");
  }
  
  @Test
  public void testFeatureCall_51() throws Exception {
    String _plus = ("newArrayList(\'\').map(s|" + 
      "$$ObjectExtensions::operator_equals(");
    String _plus_1 = (_plus + 
      "\t$$IntegerExtensions::operator_plus(s.length,1), 5)");
    String _plus_2 = (_plus_1 + 
      ").map(b| $$BooleanExtensions::operator_not(b) ).head");
    this.resolvesClosuresTo(_plus_2, 
      "(String)=>boolean", "(Boolean)=>boolean");
  }
  
  @Test
  public void testFeatureCall_52() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 * 5).map(b| b / 5 )", 
      "(String)=>int", "(Integer)=>int");
  }
  
  @Test
  public void testFeatureCall_53() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 * 5).map(b| b / 5 ).head", 
      "(String)=>int", "(Integer)=>int");
  }
  
  @Test
  public void testFeatureCall_54() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map[ length + 1 * 5 ].map [ it / 5 ).head", 
      "(String)=>int", "(Integer)=>int");
  }
  
  @Ignore(value = "Too slow")
  @Test
  public void testFeatureCall_55() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map[ length + 1 * 5 - length + 1 * 5 ].map [ it / 5 + 1 / it ).head", 
      "(String)=>int", "(Integer)=>int");
  }
  
  @Test
  public void testFeatureCall_56() throws Exception {
    this.resolvesClosuresTo("{ val list = newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
  }
  
  @Test
  public void testFeatureCall_57() throws Exception {
    this.resolvesClosuresTo("{ val list = newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list.head\n        }", "(Number & Comparable<?>)=>int");
  }
  
  @Test
  public void testFeatureCall_58() throws Exception {
    this.resolvesClosuresTo("{ val list = $$ListExtensions::map(newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\'))) [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
  }
  
  @Test
  public void testFeatureCall_59() throws Exception {
    this.resolvesClosuresTo("{ val list = $$ListExtensions::map(newArrayList(null as Integer)) [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Integer)=>int");
  }
  
  @Test
  public void testFeatureCall_60() throws Exception {
    this.resolvesClosuresTo("{ val list = newArrayList(null as Integer).map [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Integer)=>int");
  }
  
  @Test
  public void testFeatureCall_61() throws Exception {
    this.resolvesClosuresTo("{ val list = newArrayList(null as Integer).map [ v|v.intValue ]\n           val Object o = list.head \n           list.findFirst [ intValue == 0 ]\n        }", "(Integer)=>int", "(Integer)=>boolean");
  }
  
  @Test
  public void testFeatureCall_62() throws Exception {
    this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.forEach[String s | s]\n\t\t\tlist\n\t\t}", "(String)=>void");
  }
  
  @Test
  public void testFeatureCall_63() throws Exception {
    this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.findFirst[String s | true]\n\t\t\tlist\n\t\t}", "(String)=>boolean");
  }
  
  @Test
  public void testFeatureCall_64() throws Exception {
    this.resolvesClosuresTo("newArrayList.map[String s | s.substring(1,1) ]", "(String)=>String");
  }
  
  @Test
  public void testFeatureCall_65() throws Exception {
    this.resolvesClosuresTo("newArrayList.map[ s | s.toString ]", "(Object)=>String");
  }
  
  @Test
  public void testFeatureCall_66() throws Exception {
    this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.forEach[ s | s.toString ]\n\t\t\tlist\n\t\t}", "(Object)=>void");
  }
  
  @Test
  public void testFeatureCall_67() throws Exception {
    this.resolvesClosuresTo("{ val list = newArrayList(new Double(\'-20\'), new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
  }
  
  @Test
  public void testFeatureCall_68() throws Exception {
    this.resolvesClosuresTo("{ val list = newArrayList(new Double(\'-20\'), new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list.head\n        }", "(Number & Comparable<?>)=>int");
  }
  
  @Test
  public void testFeatureCall_69() throws Exception {
    this.resolvesClosuresTo("{ val list = $$ListExtensions::map(newArrayList(new Double(\'-20\'), new Integer(\'20\'))) [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
  }
  
  @Test
  public void testFeatureCall_Bug342134_00() throws Exception {
    this.resolvesClosuresTo("(null as java.util.List<String>).map(e|newArrayList(e)).flatten", 
      "(String)=>ArrayList<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_01() throws Exception {
    this.resolvesClosuresTo("(null as java.util.List<String>).map(e|newArrayList(e)).flatten.head", 
      "(String)=>ArrayList<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_02() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(e|newArrayList(e)).flatten", 
      "(String)=>ArrayList<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_03() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(e|newArrayList(e)).flatten.head", 
      "(String)=>ArrayList<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_04() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(e|newArrayList(e))", "(String)=>ArrayList<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_05() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(e|newArrayList(e)).head", "(String)=>ArrayList<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_06() throws Exception {
    this.resolvesClosuresTo("<String>newArrayList.map(e|newArrayList(e)).flatten", "(String)=>ArrayList<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_07() throws Exception {
    this.resolvesClosuresTo("newArrayList(\'\').map(e|<String>newArrayList(e)).flatten", "(String)=>ArrayList<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_08() throws Exception {
    this.resolvesClosuresTo("newArrayList.map(String e|<String>newArrayList(e)).flatten", "(String)=>ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_01() throws Exception {
    this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tval fun = [String s| s]\n\t\t\tlist.map(fun)\n\t\t\tlist\n\t\t}", "(String)=>String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_02() throws Exception {
    this.resolvesClosuresTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.map[String s| s]\n\t\t\tlist\n\t\t}", "(String)=>String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_03() throws Exception {
    this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.map[String s| s]\n\t\t\tlist\n\t\t}", "(String)=>String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_04() throws Exception {
    this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\t$$IterableExtensions::map(list, [String s| s])\n\t\t\tlist\n\t\t}", "(String)=>String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_05() throws Exception {
    this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tval fun = [String s| s]\n\t\t\t$$IterableExtensions::map(list, fun)\n\t\t\tlist\n\t\t}", "(String)=>String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_06() throws Exception {
    this.resolvesClosuresTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.map(println([String s| println(s)]))\n\t\t\tlist\n\t\t}", "(String)=>String");
  }
}
