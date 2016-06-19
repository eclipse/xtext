/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
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
      String _string = expression.toString();
      String _replace = _string.replace("ClosureTypeResolutionTestData", "org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeResolutionTestData");
      final String expressionAsString = _replace.replace("$$", "org::eclipse::xtext::xbase::lib::");
      final XExpression xExpression = this.expression(expressionAsString, false);
      TreeIterator<EObject> _eAll = EcoreUtil2.eAll(xExpression);
      Iterator<XClosure> _filter = Iterators.<XClosure>filter(_eAll, XClosure.class);
      final List<XClosure> Closures = IteratorExtensions.<XClosure>toList(_filter);
      final Function1<XClosure, Integer> _function = (XClosure it) -> {
        ICompositeNode _findActualNodeFor = NodeModelUtils.findActualNodeFor(it);
        return Integer.valueOf(_findActualNodeFor.getOffset());
      };
      return IterableExtensions.<XClosure, Integer>sortBy(Closures, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected XExpression expression(final CharSequence expression, final boolean resolve) throws Exception {
    XExpression _xblockexpression = null;
    {
      final String string = expression.toString();
      boolean _add = AbstractClosureTypeTest.seenExpressions.add(string);
      boolean _not = (!_add);
      if (_not) {
        Assert.fail(("Duplicate expression under test: " + expression));
      }
      _xblockexpression = super.expression(expression, resolve);
    }
    return _xblockexpression;
  }
  
  @Test
  public void testVariableDeclaration_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var com.google.inject.Provider<CharSequence> p = [ new StringBuilder ] }", "()=>StringBuilder");
    this.withEquivalents(_resolvesClosuresTo, "Provider<CharSequence>");
  }
  
  @Test
  public void testVariableDeclaration_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var com.google.inject.Provider<? extends CharSequence> p = [ new StringBuilder ] }", "()=>StringBuilder");
    this.withEquivalents(_resolvesClosuresTo, "Provider<CharSequence>");
  }
  
  @Test
  public void testVariableDeclaration_03() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var com.google.inject.Provider<? super CharSequence> p = [ new StringBuilder ] }", "()=>StringBuilder");
    this.withEquivalents(_resolvesClosuresTo, "Provider<CharSequence>");
  }
  
  @Test
  public void testSpecializedSubInterface_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("closures::Client::invokeSubIntf [ length.toString ]", "(CharSequence)=>String");
    this.withEquivalents(_resolvesClosuresTo, "SubIntf");
  }
  
  @Test
  public void testSpecializedSubInterface_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("closures::Client::invokeIntf [ it ]", "(Object)=>Object");
    this.withEquivalents(_resolvesClosuresTo, "Intf<Object>");
  }
  
  @Test
  public void testSpecializedSubInterface_03() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("closures::Client::invokeIntf [ String it | it ]", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Intf<String>");
  }
  
  @Test
  public void testSpecializedSubInterface_04() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("closures::Client::<String>invokeIntf [ it ]", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Intf<String>");
  }
  
  @Test
  public void testSpecializedSubInterface_05() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("closures::Client::invokeConstrainedIntf [ it ]", "(CharSequence)=>CharSequence");
    this.withEquivalents(_resolvesClosuresTo, "Intf<CharSequence>");
  }
  
  @Test
  public void testSpecializedSubInterface_06() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("closures::Client::invokeParameterizedSubIntf [ it ]", "(CharSequence)=>CharSequence");
    this.withEquivalents(_resolvesClosuresTo, "ParameterizedSubIntf<CharSequence>");
  }
  
  @Test
  public void testSpecializedSubInterface_07() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("closures::Client::invokeConcreteParameterizedSubIntf [ it ]", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "ParameterizedSubIntf<String>");
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
  public void testIfExpression_13() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("if (true) [| return \'\'] else [| return \'\']", "()=>String", "()=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function0<String>", "Function0<String>");
  }
  
  @Test
  public void testIfExpression_14() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("if (true) [| return \'\'] else [| return null as CharSequence]", "()=>String", "()=>CharSequence");
    this.withEquivalents(_resolvesClosuresTo, "Function0<String>", "Function0<CharSequence>");
  }
  
  @Test
  public void testIfExpression_15() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("if (true) [| return null as Appendable] else [| return null as CharSequence]", "()=>Appendable", "()=>CharSequence");
    this.withEquivalents(_resolvesClosuresTo, "Function0<Appendable>", "Function0<CharSequence>");
  }
  
  @Test
  public void testIfExpression_16() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("if (true) [ CharSequence c | return \'\'] else [ String s | return \'\']", "(CharSequence)=>String", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<CharSequence, String>", "Function1<String, String>");
  }
  
  @Test
  public void testIfExpression_17() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("if (true) [return new StringBuilder()] else [return new StringBuffer()]", "(Object)=>StringBuilder", "(Object)=>StringBuffer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, StringBuilder>", "Function1<Object, StringBuffer>");
  }
  
  @Test
  public void testIfExpression_18() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(if (true) [return new StringBuilder()] else [return new StringBuffer()]).apply(\'\')", "(String)=>StringBuilder", "(String)=>StringBuffer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, StringBuilder>", "Function1<String, StringBuffer>");
  }
  
  @Test
  public void testIfExpression_19() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(if (true) [CharSequence c | return new StringBuilder()] else [return new StringBuffer()])", "(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>");
  }
  
  @Test
  public void testIfExpression_20() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(if (true) [CharSequence c | return new StringBuilder()] else [return new StringBuffer()]).apply(\'\')", "(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>");
  }
  
  @Test
  public void testIfExpression_21() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(if (true) [return new StringBuilder()] else [CharSequence c | return new StringBuffer()])", "(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>");
  }
  
  @Test
  public void testIfExpression_22() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(if (true) [return new StringBuilder()] else [CharSequence c | return new StringBuffer()]).apply(\'\')", "(CharSequence)=>StringBuilder", "(CharSequence)=>StringBuffer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<CharSequence, StringBuilder>", "Function1<CharSequence, StringBuffer>");
  }
  
  @Test
  public void testIfExpression_23() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(if (true) [Appendable a | return new StringBuilder()] else [CharSequence c | return new StringBuffer()])", "(Appendable)=>StringBuilder", "(CharSequence)=>StringBuffer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Appendable, StringBuilder>", "Function1<CharSequence, StringBuffer>");
  }
  
  @Test
  public void testIfExpression_24() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var java.io.FileFilter filter = (if (true) [return true] else [return false])", "(File)=>boolean", "(File)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "FileFilter", "FileFilter");
  }
  
  @Test
  public void testIfExpression_25() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval Iterable<Object> branch = \n\t\t\t  if (true) \n\t\t\t    [|<Object>newArrayList().iterator]\n\t\t\t  else\n\t\t\t    newArrayList(\'a\').toArray\n\t\t}", "()=>Iterator<Object>");
    this.withEquivalents(_resolvesClosuresTo, "Iterable<Object>");
  }
  
  @Test
  public void testSwitchExpression_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("switch null {\n            case null : [Object it | it]\n            case null : [Integer it | it]\n        }", "(Object)=>Object", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Object>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testNumberLiteralInClosure_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList().map[42]", "(Object)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Integer>");
  }
  
  @Test
  public void testNumberLiteralInClosure_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList().map[return 42]", "(Object)=>int");
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
  
  @Ignore("i1 and i2 should become T -> Object thus + maps to String + Object")
  @Test
  public void testOverloadedOperators_05() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2 | i1.toString + i2 ]", "(Integer)=>BigInteger", "(Object, Object)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, BigInteger>", "Function2<Object, Object, String>");
  }
  
  @Ignore("i1 and i2 should become T -> Object thus + maps to Object + String")
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
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(0..Math::sqrt(1l).intValue).filter[ i | if (true) return 1l % i == 0 ].isEmpty", "(Integer)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Boolean>");
  }
  
  @Test
  public void testOverloadedOperators_15() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ if (true) toString ].reduce[ i1, i2| if (true) return i1 + i2 ]", "(Integer)=>String", "(String, String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, String>", "Function2<String, String, String>");
  }
  
  @Test
  public void testOverloadedOperators_16() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ if (true) toString.length ].reduce[ i1, i2| if (true) return i1 + i2 ]", "(Integer)=>int", "(Integer, Integer)=>int");
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
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ if (true) toString.length ].reduce[ i1, i2| if (true) return i1 + i2 else return 1 ]", "(Integer)=>int", "(Integer, Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testOverloadedOperators_20() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ if (true) toString.length ].reduce[ i1, i2| if (true) return i1 + i2 else return null ]", "(Integer)=>int", "(Integer, Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testOverloadedOperators_21() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ return toString ].reduce[ i1, i2| return i1 + i2 ]", "(Integer)=>String", "(String, String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, String>", "Function2<String, String, String>");
  }
  
  @Test
  public void testOverloadedOperators_22() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ return toString.length ].reduce[ i1, i2| return i1 + i2 ]", "(Integer)=>int", "(Integer, Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testOverloadedOperators_23() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ return new java.math.BigInteger(toString) ].reduce[ i1, i2| return i1 + i2 ]", "(Integer)=>BigInteger", "(BigInteger, BigInteger)=>BigInteger");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, BigInteger>", "Function2<BigInteger, BigInteger, BigInteger>");
  }
  
  @Ignore("i1 and i2 should become T -> Object thus + maps to String + Object")
  @Test
  public void testOverloadedOperators_24() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ return new java.math.BigInteger(toString) ].reduce[ i1, i2 | return i1.toString + i2 ]", "(Integer)=>BigInteger", "(Object, Object)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, BigInteger>", "Function2<Object, Object, String>");
  }
  
  @Ignore("i1 and i2 should become T -> Object thus + maps to Object + String")
  @Test
  public void testOverloadedOperators_25() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ return new java.math.BigInteger(toString) ].reduce[ i1, i2| return i1 + String::valueOf(i2) ]", "(Integer)=>BigInteger", "(Object, Object)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, BigInteger>", "Function2<Object, Object, String>");
  }
  
  @Test
  public void testOverloadedOperators_26() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ return new java.math.BigInteger(toString) ].map[ i | return i.toString + i ]", "(Integer)=>BigInteger", "(BigInteger)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, BigInteger>", "Function1<BigInteger, String>");
  }
  
  @Test
  public void testOverloadedOperators_27() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ return new java.math.BigInteger(toString) ].map[ i | return i + String::valueOf(i) ]", "(Integer)=>BigInteger", "(BigInteger)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, BigInteger>", "Function1<BigInteger, String>");
  }
  
  @Test
  public void testOverloadedOperators_28() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(0..Math::sqrt(1l).intValue).filter[ i | return 1l % i == 0 ].empty", "(Integer)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Boolean>");
  }
  
  @Test
  public void testOverloadedOperators_29() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ return if (true) toString ].reduce[ i1, i2| if (true) return i1 + i2 ]", "(Integer)=>String", "(String, String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, String>", "Function2<String, String, String>");
  }
  
  @Test
  public void testOverloadedOperators_30() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ return if (true) toString.length ].reduce[ i1, i2| if (true) return i1 + i2 ]", "(Integer)=>int", "(Integer, Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testOverloadedOperators_31() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ return new java.math.BigInteger(toString) ].reduce[ i1, i2| if (true) return i1 + i2 ]", "(Integer)=>BigInteger", "(BigInteger, BigInteger)=>BigInteger");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, BigInteger>", "Function2<BigInteger, BigInteger, BigInteger>");
  }
  
  @Test
  public void testOverloadedOperators_32() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ return if (true) toString.length ].reduce[ i1, i2| if (true) return i1 + i2 else return 1 ]", "(Integer)=>int", "(Integer, Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testOverloadedOperators_33() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ return if (true) toString.length ].reduce[ i1, i2| if (true) return i1 + i2 else return null ]", "(Integer)=>int", "(Integer, Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testOverloadedOperators_34() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ if (true) return toString.length ].reduce[ i1, i2| if (true) return i1 + i2 else return 1 ]", "(Integer)=>int", "(Integer, Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testOverloadedOperators_35() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ if (true) return toString.length ].reduce[ i1, i2| if (true) return i1 + i2 else return null ]", "(Integer)=>int", "(Integer, Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testOverloadedOperators_36() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ if (true) return toString ].reduce[ i1, i2| if (true) return i1 + i2 ]", "(Integer)=>String", "(String, String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, String>", "Function2<String, String, String>");
  }
  
  @Test
  public void testOverloadedOperators_37() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..2).map[ if (true) return toString.length ].reduce[ i1, i2| if (true) return i1 + i2 ]", "(Integer)=>int", "(Integer, Integer)=>int");
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
  public void testMethodTypeParamInference_08() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("new java.util.ArrayList<String>().findFirst(e | return true)", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testMethodTypeParamInference_09() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("new java.util.ArrayList<String>().findFirst(e| return e == \'foo\')", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testMethodTypeParamInference_10() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("new java.util.ArrayList<String>().<String>findFirst(e| return e == \'foo\')", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testMethodTypeParamInference_11() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("new java.util.ArrayList<String>().findFirst(Object e| return e == \'foo\')", "(Object)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Boolean>");
  }
  
  @Test
  public void testMethodTypeParamInference_12() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e | return true]", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testMethodTypeParamInference_13() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e| return e == \'foo\']", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testMethodTypeParamInference_14() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e| return e == \'foo\']", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testMethodTypeParamInference_15() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [Object e| return e == \'foo\']", "(Object)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Boolean>");
  }
  
  @Test
  public void testTypeForVoidClosure_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'foo\',\'bar\').forEach []", "(String)=>void");
    this.withEquivalents(_resolvesClosuresTo, "Consumer<String>");
  }
  
  @Test
  public void testTypeForVoidClosure_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'foo\',\'bar\').forEach [ return ]", "(String)=>void");
    this.withEquivalents(_resolvesClosuresTo, "Consumer<String>");
  }
  
  @Test
  public void testClosure_00() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[|\'literal\'].apply()", "()=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function0<String>");
  }
  
  @Test
  public void testClosure_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var Closure = [|\'literal\']\n\t\t  new testdata.ClosureClient().invoke0(Closure)\t}", "()=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function0<String>");
  }
  
  @Test
  public void testClosure_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo(((("{\n" + 
      "  var java.util.List<? super String> list = null;\n") + 
      "  list.map(e|e)\n") + 
      "}"), "(Object)=>Object");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_03() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo(((("{\n" + 
      "  var java.util.List<? super String> list = null;\n") + 
      "  list.map(e|false)\n") + 
      "}"), "(Object)=>boolean");
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
  
  @Ignore("TODO deferred Closure body typing")
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
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.List<String> list = newArrayList(fun.apply(null))\n\t\t\tfun\n\t\t}", "(String[])=>String[]");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String[], String[]>");
  }
  
  @Test
  public void testClosure_09_2() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.List<String> list = newArrayList(fun.apply(null), fun.apply(null))\n\t\t\tfun\n\t\t}", "(String)=>String");
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
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo(((("{\n" + 
      "  var java.util.List<? super String> list = null;\n") + 
      "  $$ListExtensions::map(list) [e|e]\n") + 
      "}"), "(Object)=>Object");
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
  public void testClosure_27() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(null as Iterable<? super String>).map(e|e)", "(Object)=>Object");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_28() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[| return \'literal\'].apply()", "()=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function0<String>");
  }
  
  @Test
  public void testClosure_29() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var Closure = [| return \'literal\']\n\t\t  new testdata.ClosureClient().invoke0(Closure)\t}", "()=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function0<String>");
  }
  
  @Test
  public void testClosure_30() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo(((("{\n" + 
      "  var java.util.List<? super String> list = null;\n") + 
      "  list.map(e| return e)\n") + 
      "}"), "(Object)=>Object");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_31() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo(((("{\n" + 
      "  var java.util.List<? super String> list = null;\n") + 
      "  list.map(e| return false)\n") + 
      "}"), "(Object)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Boolean>");
  }
  
  @Test
  public void testClosure_32() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval mapper = [ x | return x ]\n\t\t\tnewArrayList(1).map(mapper)\n\t\t}", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testClosure_33() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval mapper = [ x | return x ]\n\t\t\tnewArrayList(1).map(mapper).head\n\t\t}", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testClosure_34() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval mapper = [ x | return x ]\n\t\t\tnewArrayList(1).map(mapper).findFirst [ true ]\n\t\t}", "(Integer)=>Integer", "(Integer)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function1<Integer, Boolean>");
  }
  
  @Ignore("TODO deferred Closure body typing")
  @Test
  public void testClosure_35() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval mapper = [ x | return x.charAt(0) ]\n\t\t\tnewArrayList(\'\').map(mapper)\n\t\t}", "Function1<String, Character>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Character>");
  }
  
  @Test
  public void testClosure_36() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | return x ]\n\t\t\tval String s = fun.apply(null)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_37() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | return x ]\n\t\t\tval java.util.List<String> list = newArrayList(fun.apply(null))\n\t\t\tfun\n\t\t}", "(String[])=>String[]");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String[], String[]>");
  }
  
  @Test
  public void testClosure_37_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | return x ]\n\t\t\tval java.util.List<String> list = newArrayList(fun.apply(null), fun.apply(null))\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_38() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | return x ]\n\t\t\tval java.util.List<String> list = newArrayList.map(fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_39() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | return x ]\n\t\t\tval java.util.Set<String> list = newArrayList.map(fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_40() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | return x ]\n\t\t\tval java.util.ArrayList<String> list = newArrayList.map(fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_41() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | return x ]\n\t\t\tval Iterable<String> list = newArrayList.map(fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_42() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | return x ]\n\t\t\tval list = newArrayList.map(fun)\n\t\t\tval Iterable<String> iter = list\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_43() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | return x ]\n\t\t\tval java.util.List<String> list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_44() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | return x ]\n\t\t\tval java.util.Set<String> list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_45() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | return x ]\n\t\t\tval java.util.ArrayList<String> list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_46() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | return x ]\n\t\t\tval Iterable<String> list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_47() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval fun = [ x | return x ]\n\t\t\tval list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tval Iterable<String> iter = list\n\t\t\tfun\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testClosure_48() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval mapper = [ x | return x ]\n\t\t\t$$ListExtensions::map(newArrayList(1), mapper)\n\t\t}", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testClosure_49() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[| return null].apply()", "()=>Object");
    this.withEquivalents(_resolvesClosuresTo, "Function0<Object>");
  }
  
  @Test
  public void testClosure_50() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[return null].apply()", "(Object)=>Object");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_51() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[| return ].apply()", "()=>void");
    this.withEquivalents(_resolvesClosuresTo, "Procedure0");
  }
  
  @Test
  public void testClosure_52() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[return].apply()", "(Object)=>void");
    this.withEquivalents(_resolvesClosuresTo, "Procedure1<Object>");
  }
  
  @Test
  public void testClosure_54() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("$$ListExtensions::map(null as java.util.List<? super String>) [e| return e]", "(Object)=>Object");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_55() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo(((("{\n" + 
      "  var java.util.List<? super String> list = null;\n") + 
      "  $$ListExtensions::map(list) [e| return e]\n") + 
      "}"), "(Object)=>Object");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_56() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[| return \'literal\']", "()=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function0<String>");
  }
  
  @Test
  public void testClosure_57() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList(\'\')\n\t\t\tjava::util::Collections::sort(list) [ s1, s2 | return s1.compareTo(s2) ]\n\t\t\tlist\n\t\t}", "(String, String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Comparator<String>");
  }
  
  @Test
  public void testClosure_58() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(null as Iterable<? super String>).map(e| return e)", "(Object)=>Object");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, Object>");
  }
  
  @Test
  public void testClosure_59() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval java.util.List<CharSequence> res = null\n\t\t\tval Iterable<? extends Object> obj = null\n\t\t\tres += obj.map[\"\"]\n\t\t}", "(Object)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, String>");
  }
  
  @Test
  public void testClosure_60() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval Iterable<? extends Object> obj = null\n\t\t\tval Iterable<CharSequence> res = obj.map[\"\"]\n\t\t}", "(Object)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, CharSequence>");
  }
  
  @Test
  public void testClosure_61() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tval java.util.List<? super CharSequence> res = null\n\t\t\tval Iterable<? extends Object> obj = null\n\t\t\tres += obj.map[\"\"]\n\t\t}", "(Object)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, String>");
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
  public void testEMap_10() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ return getKey ].head\n         }", "(Entry<Integer, String>)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<Integer, String>, Integer>");
  }
  
  @Test
  public void testEMap_11() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ return getValue ].head\n         }", "(Entry<Integer, String>)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<Integer, String>, String>");
  }
  
  @Test
  public void testEMap_12() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ return it ].head\n         }", "(Entry<Integer, String>)=>Entry<Integer, String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<Integer, String>, Entry<Integer, String>>");
  }
  
  @Test
  public void testEMap_13() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n\t\t  eMap.map[ return getKey ].head\n         }", "(Entry<? extends Integer, String>)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<? extends Integer, String>, Integer>");
  }
  
  @Test
  public void testEMap_14() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n\t\t  eMap.map[ return getValue ].head\n         }", "(Entry<? extends Integer, String>)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<? extends Integer, String>, String>");
  }
  
  @Test
  public void testEMap_15() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n\t\t  eMap.map[ return it ].head\n         }", "(Entry<? extends Integer, String>)=>Entry<? extends Integer, String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<? extends Integer, String>, Entry<? extends Integer, String>>");
  }
  
  @Test
  public void testEMap_16() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<Integer, ? extends String> eMap = null\n\t\t  eMap.map[ return getKey ].head\n         }", "(Entry<Integer, ? extends String>)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<Integer, ? extends String>, Integer>");
  }
  
  @Test
  public void testEMap_17() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<Integer, ? extends String> eMap = null\n\t\t  eMap.map[ return getValue ].head\n         }", "(Entry<Integer, ? extends String>)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<Integer, ? extends String>, String>");
  }
  
  @Test
  public void testEMap_18() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<Integer, ? extends String> eMap = null\n\t\t  eMap.map[ return it ].head\n         }", "(Entry<Integer, ? extends String>)=>Entry<Integer, ? extends String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Entry<Integer, ? extends String>, Entry<Integer, ? extends String>>");
  }
  
  @Test
  public void testIncompatibleExpression_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("new Thread [| return \'illegal\' ]", "()=>void");
    this.withEquivalents(_resolvesClosuresTo, "Runnable");
  }
  
  @Ignore("TODO implement this")
  @Test
  public void testIncompatibleExpression_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(null as Iterable<String>).filter [ it ]", "(String)=>Boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testMemberFeatureCall_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..20).map[ toString.length ].reduce[ i1,  i2 | i1 + i2 ]", "(Integer)=>int", "(Integer, Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testMemberFeatureCall_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(1..20).map[ return toString.length ].reduce[ i1,  i2 | return i1 + i2 ]", "(Integer)=>int", "(Integer, Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_001() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s)", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_002() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map [it|it]", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_003() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map [it]", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_004() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(null as Iterable<String>).map(s|s)", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_005() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("$$ListExtensions::map(newArrayList(\'\')) [s|s]", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_006() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s).head", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_007() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.toString).head", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_008() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1)", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_009() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1).head", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_010() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length)", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_011() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("<String>newArrayList.map(s|s.length)", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_012() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length).head", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_013() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("<String>newArrayList.map(s|s.length).head", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_014() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s != null)", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testFeatureCall_015() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length+1)", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_016() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1).map(i|i+1)", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_017() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1).toList()", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_018() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1).toList().map(i|i)", "(String)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_019() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1).toList().map(i|i+1)", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_020() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var it = newArrayList(\'\').map(s|1).toList() it.map(i|i+1) }", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_021() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var it = newArrayList(\'\').map(s|1).toList() map(i|i+1) }", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_022() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var it = newArrayList(\'\').map(s|1).toList() it }", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_023() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var java.util.List<? extends Integer> it = null map(i|i+1) }", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_024() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var java.util.List<? extends Integer> it = null map(i|i) }", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_025() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s|1))", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_026() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size())", "(String)=>int", "(List<Integer>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<List<Integer>, Integer>");
  }
  
  @Test
  public void testFeatureCall_027() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size()).map(e|e)", "(String)=>int", "(List<Integer>)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<List<Integer>, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_028() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e)).map(iterable|iterable.size())", "(String)=>int", "(Integer)=>Integer", "(List<Integer>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>", "Function1<List<Integer>, Integer>");
  }
  
  @Test
  public void testFeatureCall_029() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e)).map(iterable|iterable.size()).head", "(String)=>int", "(Integer)=>Integer", "(List<Integer>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>", "Function1<List<Integer>, Integer>");
  }
  
  @Test
  public void testFeatureCall_030() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size())", "(ArrayList<String>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<ArrayList<String>, Integer>");
  }
  
  @Test
  public void testFeatureCall_031() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size()).head", "(ArrayList<String>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<ArrayList<String>, Integer>");
  }
  
  @Test
  public void testFeatureCall_032() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size()).map(e|e)", "(ArrayList<String>)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<ArrayList<String>, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_033() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size()).map(e|e).head", "(ArrayList<String>)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<ArrayList<String>, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_034() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1).map(i|1)", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_035() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|1).map(i|1).head", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_036() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length).map(i|i)", "(String)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_037() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length).map(i|i).head", "(String)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_038() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b|b)", "(String)=>boolean", "(Boolean)=>Boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_039() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b|b).head", "(String)=>boolean", "(Boolean)=>Boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_040() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { \'length\'.length b })", "(String)=>boolean", "(Boolean)=>Boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_041() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { \'length\'.length b }).head", "(String)=>boolean", "(Boolean)=>Boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_042() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(Boolean b|!b)", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_043() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(Boolean b|!b).head", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_044() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| !!b )", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_045() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| !!b ).head", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_046() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { !b } )", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_047() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { !b } ).head", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_048() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { b.operator_not } )", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_049() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { b.operator_not } ).head", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_050() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo(((("newArrayList(\'\').map(s|" + 
      "$$ObjectExtensions::operator_equals(") + 
      "\t$$IntegerExtensions::operator_plus(s.length,1), 5)") + 
      ").map(b| $$BooleanExtensions::operator_not(b) )"), "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_051() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo(((("newArrayList(\'\').map(s|" + 
      "$$ObjectExtensions::operator_equals(") + 
      "\t$$IntegerExtensions::operator_plus(s.length,1), 5)") + 
      ").map(b| $$BooleanExtensions::operator_not(b) ).head"), "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_052() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 * 5).map(b| b / 5 )", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_053() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s|s.length + 1 * 5).map(b| b / 5 ).head", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_054() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map[ length + 1 * 5 ].map [ it / 5 ).head", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_055() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map[ length + 1 * 5 - length + 1 * 5 ].map [ it / 5 + 1 / it ).head", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_056() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_057() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list.head\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_058() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = $$ListExtensions::map(newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\'))) [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_059() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = $$ListExtensions::map(newArrayList(null as Integer)) [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_060() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(null as Integer).map [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_061() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(null as Integer).map [ v|v.intValue ]\n           val Object o = list.head \n           list.findFirst [ intValue == 0 ]\n        }", "(Integer)=>int", "(Integer)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function1<Integer, Boolean>");
  }
  
  @Test
  public void testFeatureCall_062() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.forEach[String s | s]\n\t\t\tlist\n\t\t}", "(String)=>void");
    this.withEquivalents(_resolvesClosuresTo, "Consumer<String>");
  }
  
  @Test
  public void testFeatureCall_063() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.findFirst[String s | true]\n\t\t\tlist\n\t\t}", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testFeatureCall_064() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList.map[String s | s.substring(1,1) ]", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_065() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList.map[ s | s.toString ]", "(Object)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, String>");
  }
  
  @Test
  public void testFeatureCall_066() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.forEach[ s | s.toString ]\n\t\t\tlist\n\t\t}", "(Object)=>void");
    this.withEquivalents(_resolvesClosuresTo, "Consumer<Object>");
  }
  
  @Test
  public void testFeatureCall_067() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(new Double(\'-20\'), new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_068() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(new Double(\'-20\'), new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list.head\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_069() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = $$ListExtensions::map(newArrayList(new Double(\'-20\'), new Integer(\'20\'))) [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_070() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = $$ListExtensions::map(newArrayList(new Double(\'-20\'), new Integer(\'20\'))) [ v| return v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_071() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s)", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_072() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map [it| return it]", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_073() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map [return it]", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_074() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(null as Iterable<String>).map(s| return s)", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_075() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("$$ListExtensions::map(newArrayList(\'\')) [s| return s]", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_076() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s).head", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_077() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.toString).head", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_078() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return 1)", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_079() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return 1).head", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_080() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length)", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_081() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("<String>newArrayList.map(s| return s.length)", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_082() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length).head", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_083() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("<String>newArrayList.map(s| return s.length).head", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_084() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s != null)", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testFeatureCall_085() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length+1)", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_086() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return 1).map(i| return i+1)", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_087() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return 1).toList()", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_088() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return 1).toList().map(i| return i)", "(String)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_089() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return 1).toList().map(i| return i+1)", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_090() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var it = newArrayList(\'\').map(s| return 1).toList() it.map(i| return i+1) }", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_091() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var it = newArrayList(\'\').map(s| return 1).toList() map(i| return i+1) }", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_092() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var it = newArrayList(\'\').map(s| return 1).toList() it }", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_093() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var java.util.List<? extends Integer> it = null map(i| return i+1) }", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_094() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var java.util.List<? extends Integer> it = null map(i| return i) }", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_095() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s| return 1))", "(String)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>");
  }
  
  @Test
  public void testFeatureCall_096() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s| return 1)).map(iterable| return iterable.size())", "(String)=>int", "(List<Integer>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<List<Integer>, Integer>");
  }
  
  @Test
  public void testFeatureCall_097() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s| return 1)).map(iterable| return iterable.size()).map(e| return e)", "(String)=>int", "(List<Integer>)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<List<Integer>, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_098() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s| return 1).map(e| return e)).map(iterable| return iterable.size())", "(String)=>int", "(Integer)=>Integer", "(List<Integer>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>", "Function1<List<Integer>, Integer>");
  }
  
  @Test
  public void testFeatureCall_099() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\').map(s| return 1).map(e| return e)).map(iterable| return iterable.size()).head", "(String)=>int", "(Integer)=>Integer", "(List<Integer>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>", "Function1<List<Integer>, Integer>");
  }
  
  @Test
  public void testFeatureCall_100() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable| return iterable.size())", "(ArrayList<String>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<ArrayList<String>, Integer>");
  }
  
  @Test
  public void testFeatureCall_101() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable| return iterable.size()).head", "(ArrayList<String>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<ArrayList<String>, Integer>");
  }
  
  @Test
  public void testFeatureCall_102() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable| return iterable.size()).map(e| return e)", "(ArrayList<String>)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<ArrayList<String>, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_103() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(newArrayList(\'\')).map(iterable| return iterable.size()).map(e| return e).head", "(ArrayList<String>)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<ArrayList<String>, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_104() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return 1).map(i| return 1)", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_105() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return 1).map(i| return 1).head", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_106() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length).map(i| return i)", "(String)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_107() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length).map(i| return i).head", "(String)=>int", "(Integer)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_108() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length + 1 == 5).map(b| return b)", "(String)=>boolean", "(Boolean)=>Boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_109() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length + 1 == 5).map(b| return b).head", "(String)=>boolean", "(Boolean)=>Boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_110() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length + 1 == 5).map(b| return { \'length\'.length b })", "(String)=>boolean", "(Boolean)=>Boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_111() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length + 1 == 5).map(b| return { \'length\'.length b }).head", "(String)=>boolean", "(Boolean)=>Boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_112() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length + 1 == 5).map(Boolean b| return !b)", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_113() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length + 1 == 5).map(Boolean b| return !b).head", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_114() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length + 1 == 5).map(b| return !!b )", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_115() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length + 1 == 5).map(b| return !!b ).head", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_116() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length + 1 == 5).map(b| return { !b } )", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_117() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length + 1 == 5).map(b| { return !b } ).head", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_118() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length + 1 == 5).map(b| return { b.operator_not } )", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_119() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length + 1 == 5).map(b| return { b.operator_not } ).head", "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_120() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo(((("newArrayList(\'\').map(s|" + 
      "return $$ObjectExtensions::operator_equals(") + 
      "\t$$IntegerExtensions::operator_plus(s.length,1), 5)") + 
      ").map(b| return $$BooleanExtensions::operator_not(b) )"), "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_121() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo(((("newArrayList(\'\').map(s|" + 
      "return $$ObjectExtensions::operator_equals(") + 
      "\t$$IntegerExtensions::operator_plus(s.length,1), 5)") + 
      ").map(b| return $$BooleanExtensions::operator_not(b) ).head"), "(String)=>boolean", "(Boolean)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>", "Function1<Boolean, Boolean>");
  }
  
  @Test
  public void testFeatureCall_122() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length + 1 * 5).map(b| return b / 5 )", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_123() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(s| return s.length + 1 * 5).map(b| return b / 5 ).head", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_124() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map[ return length + 1 * 5 ].map [ return it / 5 ).head", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_125() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map[ return length + 1 * 5 - length + 1 * 5 ].map [ return it / 5 + 1 / it ).head", "(String)=>int", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Integer>", "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_126() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\')).map(v| return v.intValue)\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_127() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\')).map(v| return v.intValue)\n           val Object o = list.head \n           list.head\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_128() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = $$ListExtensions::map(newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\'))) [ v| return v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_129() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = $$ListExtensions::map(newArrayList(null as Integer)) [ v| return v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_130() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(null as Integer).map [ v| return v.intValue ]\n           val Object o = list.head \n           list\n        }", "(Integer)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>");
  }
  
  @Test
  public void testFeatureCall_131() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(null as Integer).map [ v| return v.intValue ]\n           val Object o = list.head \n           list.findFirst [return intValue == 0 ]\n        }", "(Integer)=>int", "(Integer)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Integer, Integer>", "Function1<Integer, Boolean>");
  }
  
  @Test
  public void testFeatureCall_132() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.forEach[String s | return s]\n\t\t\tlist\n\t\t}", "(String)=>void");
    this.withEquivalents(_resolvesClosuresTo, "Procedure1<String>");
  }
  
  @Test
  public void testFeatureCall_133() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.findFirst[String s | return true]\n\t\t\tlist\n\t\t}", "(String)=>boolean");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Boolean>");
  }
  
  @Test
  public void testFeatureCall_134() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList.map[String s | return s.substring(1,1) ]", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, String>");
  }
  
  @Test
  public void testFeatureCall_135() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList.map[ s | return s.toString ]", "(Object)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Object, String>");
  }
  
  @Test
  public void testFeatureCall_136() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.forEach[ s | return s.toString ]\n\t\t\tlist\n\t\t}", "(Object)=>void");
    this.withEquivalents(_resolvesClosuresTo, "Procedure1<Object>");
  }
  
  @Test
  public void testFeatureCall_137() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(new Double(\'-20\'), new Integer(\'20\')).map(v| return v.intValue)\n           val Object o = list.head \n           list\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_138() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ val list = newArrayList(new Double(\'-20\'), new Integer(\'20\')).map(v| return v.intValue)\n           val Object o = list.head \n           list.head\n        }", "(Number & Comparable<?>)=>int");
    this.withEquivalents(_resolvesClosuresTo, "Function1<Number & Comparable<?>, Integer>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_00() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(null as java.util.List<String>).map(e| return newArrayList(e)).flatten", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("(null as java.util.List<String>).map(e|newArrayList(e)).flatten.head", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(e| return newArrayList(e)).flatten", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_03() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(e| return newArrayList(e)).flatten.head", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_04() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(e| return newArrayList(e))", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_05() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(e| return newArrayList(e)).head", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_06() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("<String>newArrayList.map(e| return newArrayList(e)).flatten", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_07() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList(\'\').map(e| return <String>newArrayList(e)).flatten", "(String)=>ArrayList<String>");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_08() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("newArrayList.map(String e| return <String>newArrayList(e)).flatten", "(String)=>ArrayList<String>");
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
  public void testDeferredTypeArgumentResolution_13() throws Exception {
    this.resolvesClosuresTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.<String, Object>map[s| s.toString]\n\t\t\tlist\n\t\t}", "(String)=>String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_14() throws Exception {
    this.resolvesClosuresTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.<String, Object>map[s| s.charAt(1) ]\n\t\t\tlist\n\t\t}", "(String)=>char");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_15() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.<String, CharSequence>map[s| s]\n\t\t\tlist\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, CharSequence>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_16() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.<String, Object>map[s| s]\n\t\t\tlist\n\t\t}", "(String)=>String");
    this.withEquivalents(_resolvesClosuresTo, "Function1<String, Object>");
  }
  
  @Test
  public void testClosureWithReturnExpression_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[ | if (true) return \'\' else return new StringBuilder ]", "()=>Serializable & CharSequence");
    this.withEquivalents(_resolvesClosuresTo, "Function0<Serializable & CharSequence>");
  }
  
  @Test
  public void testClosureWithReturnExpression_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[ | if (true) \'\' else return new StringBuilder ]", "()=>Serializable & CharSequence");
    this.withEquivalents(_resolvesClosuresTo, "Function0<Serializable & CharSequence>");
  }
  
  @Test
  public void testClosureWithReturnExpression_03() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[ | if (true) return \'\' else new StringBuilder ]", "()=>Serializable & CharSequence");
    this.withEquivalents(_resolvesClosuresTo, "Function0<Serializable & CharSequence>");
  }
  
  @Test
  public void testClosureWithReturnExpression_04() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[ | if (true) \'\' else new StringBuilder ]", "()=>Serializable & CharSequence");
    this.withEquivalents(_resolvesClosuresTo, "Function0<Serializable & CharSequence>");
  }
  
  @Test
  public void testClosureWithReturnExpression_05() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("[ int i1, int i2| if (true) return i1 else return null ].apply(1, 1)", "(int, int)=>Integer");
    this.withEquivalents(_resolvesClosuresTo, "Function2<Integer, Integer, Integer>");
  }
  
  @Test
  public void testAbstractIterator_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ var com.google.common.collect.AbstractIterator<String> iter = [| return self.endOfData ] }", "()=>String");
    this.withEquivalents(_resolvesClosuresTo, "AbstractIterator<String>");
  }
  
  @Test
  public void testAbstractIterator_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{ \n\t\t\tvar com.google.common.collect.AbstractIterator<java.util.Iterator<String>> iter = [|\n\t\t\t\tif (true) {\n\t\t\t\t\tval com.google.common.collect.AbstractIterator<String> result = [|\n\t\t\t\t\t\treturn self.endOfData\n\t\t\t\t\t]\n\t\t\t\t\treturn result\n\t\t\t\t}\n\t\t\t\treturn self.endOfData\n\t\t\t]\n\t\t}", "()=>Iterator<String>", "()=>String");
    this.withEquivalents(_resolvesClosuresTo, "AbstractIterator<Iterator<String>>", "AbstractIterator<String>");
  }
}
