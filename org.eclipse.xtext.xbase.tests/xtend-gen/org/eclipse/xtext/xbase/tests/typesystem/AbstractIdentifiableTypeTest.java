/**
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
public abstract class AbstractIdentifiableTypeTest extends AbstractXbaseTestCase {
  public abstract void resolvesIdentifiablesTo(final String expression, final String... types);
  
  private static Set<String> seenExpressions;
  
  @BeforeClass
  public static void createSeenExpressionsSet() {
    AbstractIdentifiableTypeTest.seenExpressions = CollectionLiterals.<String>newHashSet();
  }
  
  @AfterClass
  public static void discardSeenExpressions() {
    AbstractIdentifiableTypeTest.seenExpressions = null;
  }
  
  protected List<JvmIdentifiableElement> findIdentifiables(final XExpression expression) {
    final Function1<EObject, List<? extends EObject>> _function = (EObject it) -> {
      List<? extends EObject> _switchResult = null;
      boolean _matched = false;
      if (it instanceof XClosure) {
        _matched=true;
        _switchResult = ((XClosure)it).getImplicitFormalParameters();
      }
      if (!_matched) {
        _switchResult = Collections.<EObject>unmodifiableList(CollectionLiterals.<EObject>newArrayList(it));
      }
      return _switchResult;
    };
    final Function1<EObject, Boolean> _function_1 = (EObject it) -> {
      boolean _and = false;
      if (!(it != null)) {
        _and = false;
      } else {
        boolean _switchResult = false;
        boolean _matched = false;
        if (it instanceof XVariableDeclaration) {
          _matched=true;
          _switchResult = true;
        }
        if (!_matched) {
          if (it instanceof JvmFormalParameter) {
            _matched=true;
            _switchResult = true;
          }
        }
        if (!_matched) {
          _switchResult = false;
        }
        _and = _switchResult;
      }
      return Boolean.valueOf(_and);
    };
    final List<JvmIdentifiableElement> identifiables = IterableExtensions.<JvmIdentifiableElement>toList(Iterables.<JvmIdentifiableElement>filter(IterableExtensions.<EObject>filter(IterableExtensions.<EObject>toSet(Iterables.<EObject>concat(IteratorExtensions.<List<? extends EObject>>toIterable(IteratorExtensions.<EObject, List<? extends EObject>>map(EcoreUtil2.eAll(expression), _function)))), _function_1), JvmIdentifiableElement.class));
    final Function1<JvmIdentifiableElement, Integer> _function_2 = (JvmIdentifiableElement it) -> {
      int _xblockexpression = (int) 0;
      {
        final ICompositeNode node = NodeModelUtils.findActualNodeFor(it);
        int _xifexpression = (int) 0;
        if ((node != null)) {
          _xifexpression = node.getOffset();
        } else {
          _xifexpression = NodeModelUtils.findActualNodeFor(it.eContainer()).getOffset();
        }
        _xblockexpression = _xifexpression;
      }
      return Integer.valueOf(_xblockexpression);
    };
    return IterableExtensions.<JvmIdentifiableElement, Integer>sortBy(identifiables, _function_2);
  }
  
  @Override
  protected XExpression expression(final CharSequence expression, final boolean resolve) throws Exception {
    XExpression _xblockexpression = null;
    {
      final String string = expression.toString();
      boolean _add = AbstractIdentifiableTypeTest.seenExpressions.add(string);
      boolean _not = (!_add);
      if (_not) {
        Assert.fail(("Duplicate expression under test: " + expression));
      }
      _xblockexpression = super.expression(expression, resolve);
    }
    return _xblockexpression;
  }
  
  @Test
  public void testIfExpression_01() throws Exception {
    this.resolvesIdentifiablesTo("{ val x = if (true) while(false) (\'foo\'+\'bar\').length }", "null");
  }
  
  @Test
  public void testIfExpression_02() throws Exception {
    this.resolvesIdentifiablesTo("{ val Object x = if (true) while(false) (\'foo\'+\'bar\').length }", "Object");
  }
  
  @Test
  public void testOverloadedMethods_01() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tvar java.util.List<CharSequence> list = null\n\t\t\tvar Object o = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)\n\t\t}", "List<CharSequence>", "Object");
  }
  
  @Test
  public void testOverloadedMethods_02() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tvar java.util.List<CharSequence> list = null\n\t\t\tvar String s = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)\n\t\t}", "List<CharSequence>", "String");
  }
  
  @Test
  public void testOverloadedMethods_03() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tvar java.util.List<? extends CharSequence> list = null\n\t\t\tvar Object o = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, o)\n\t\t}", "List<? extends CharSequence>", "Object");
  }
  
  @Test
  public void testOverloadedMethods_04() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tvar java.util.List<? extends CharSequence> list = null\n\t\t\tvar String s = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::overloaded(list, s)\n\t\t}", "List<? extends CharSequence>", "String");
  }
  
  @Test
  public void testOverloadedOperators_05() throws Exception {
    this.resolvesIdentifiablesTo("(0..Math::sqrt(1l).intValue).filter[ int it | 1l % it == 0 ].isEmpty", "int");
  }
  
  @Test
  public void testOverloadedOperators_06() throws Exception {
    this.resolvesIdentifiablesTo("(0..Math::sqrt(1l).intValue).filter[ 1l % it == 0 ].isEmpty", "Integer");
  }
  
  @Test
  public void testOverloadedOperators_07() throws Exception {
    this.resolvesIdentifiablesTo("(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].isEmpty", "Integer");
  }
  
  @Test
  public void testOverloadedOperators_08() throws Exception {
    this.resolvesIdentifiablesTo("(1..2).map[ toString ].reduce[ i1, i2| i1 + i2 ]", "Integer", "String", "String");
  }
  
  @Test
  public void testOverloadedOperators_09() throws Exception {
    this.resolvesIdentifiablesTo("(1..2).map[ toString.length ].reduce[ i1, i2| i1 + i2 ]", "Integer", "Integer", "Integer");
  }
  
  @Test
  public void testOverloadedOperators_10() throws Exception {
    this.resolvesIdentifiablesTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + i2 ]", "Integer", "BigInteger", "BigInteger");
  }
  
  @Ignore("i1 and i2 should become T -> Object thus + maps to String + Object")
  @Test
  public void testOverloadedOperators_11() throws Exception {
    this.resolvesIdentifiablesTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2 | i1.toString + i2 ]", "Integer", "Object", "Object");
  }
  
  @Test
  public void testOverloadedOperators_12() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval i = 1bi\n\t\t\tval s = \'\'\n\t\t\ts + i\n\t\t}", "BigInteger", "String");
  }
  
  @Ignore("i1 and i2 should become T -> Object thus + maps to Object + String")
  @Test
  public void testOverloadedOperators_13() throws Exception {
    this.resolvesIdentifiablesTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + String::valueOf(i2) ]", "Integer", "Object", "Object");
  }
  
  @Test
  public void testOverloadedOperators_15() throws Exception {
    this.resolvesIdentifiablesTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i.toString + i ]", "Integer", "BigInteger");
  }
  
  @Test
  public void testOverloadedOperators_16() throws Exception {
    this.resolvesIdentifiablesTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ it + String::valueOf(it) ]", "Integer", "BigInteger");
  }
  
  @Test
  public void testOverloadedOperators_17() throws Exception {
    this.resolvesIdentifiablesTo("(0..Math::sqrt(1l).intValue).filter[ i | 1l % i == 0 ].empty", "Integer");
  }
  
  @Test
  public void testTryCatchFinallyExpression_0() throws Exception {
    this.resolvesIdentifiablesTo("try \'foo\' catch (Exception e) \'bar\'", "Exception");
  }
  
  @Test
  public void testTryCatchFinallyExpression_1() throws Exception {
    this.resolvesIdentifiablesTo("try \'foo\' catch (Exception e) \'bar\' catch(RuntimeException e) \'baz\'", "Exception", "RuntimeException");
  }
  
  @Test
  public void testTryCatchFinallyExpression_2() throws Exception {
    this.resolvesIdentifiablesTo("try \'foo\' catch (Exception e) \'bar\' catch(RuntimeException e) \'baz\' finally true", "Exception", "RuntimeException");
  }
  
  @Test
  public void testArrayVariable_01() throws Exception {
    this.resolvesIdentifiablesTo("{ var a = \'a,b,c\'.split(\',\') }", "String[]");
  }
  
  @Test
  public void testForExpression_01() throws Exception {
    this.resolvesIdentifiablesTo("for(String x : new java.util.ArrayList<String>()) x.length", "String");
    this.resolvesIdentifiablesTo("for(String x : newArrayList(\'foo\')) x.length", "String");
    this.resolvesIdentifiablesTo("for(String x : <String>newArrayList()) x.length", "String");
  }
  
  @Test
  public void testForExpression_02() throws Exception {
    this.resolvesIdentifiablesTo("for(x : new java.util.ArrayList<String>()) x.length", "String");
    this.resolvesIdentifiablesTo("for(x : <String>newArrayList()) x.length", "String");
    this.resolvesIdentifiablesTo("for(x : newArrayList(\'foo\')) x.length", "String");
  }
  
  @Test
  public void testForExpression_03() throws Exception {
    this.resolvesIdentifiablesTo("for(String x : null as String[][]) x.length", "String");
  }
  
  @Test
  public void testForExpression_04() throws Exception {
    this.resolvesIdentifiablesTo("for(x : null as String[][]) x.size", "String[]");
  }
  
  @Test
  public void testForExpression_05() throws Exception {
    this.resolvesIdentifiablesTo("for(x : null as java.util.Set) x.toString", "Object");
  }
  
  @Test
  public void testForExpression_06() throws Exception {
    this.resolvesIdentifiablesTo("for(x : null as Iterable<String>?:emptyList) x.toString", "String");
  }
  
  @Test
  public void testMethodTypeParamInference_00() throws Exception {
    this.resolvesIdentifiablesTo("new java.util.ArrayList<String>().findFirst(e | true)", "String");
  }
  
  @Test
  public void testMethodTypeParamInference_01() throws Exception {
    this.resolvesIdentifiablesTo("new java.util.ArrayList<String>().findFirst(e|e == \'foo\')", "String");
  }
  
  @Test
  public void testMethodTypeParamInference_02() throws Exception {
    this.resolvesIdentifiablesTo("new java.util.ArrayList<String>().<String>findFirst(e|e == \'foo\')", "String");
  }
  
  @Test
  public void testMethodTypeParamInference_03() throws Exception {
    this.resolvesIdentifiablesTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e | true]", "String");
  }
  
  @Test
  public void testMethodTypeParamInference_04() throws Exception {
    this.resolvesIdentifiablesTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e|e == \'foo\']", "String");
  }
  
  @Test
  public void testMethodTypeParamInference_05() throws Exception {
    this.resolvesIdentifiablesTo("$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e|e == \'foo\']", "String");
  }
  
  @Test
  public void testClosure_01() throws Exception {
    this.resolvesIdentifiablesTo("{ var closure = [|\'literal\']\n\t\t  new testdata.ClosureClient().invoke0(closure)\t}", "()=>String");
  }
  
  @Test
  public void testClosure_02() throws Exception {
    this.resolvesIdentifiablesTo("[String x| true]", "String");
  }
  
  @Test
  public void testClosure_03() throws Exception {
    this.resolvesIdentifiablesTo(((("{\n" + 
      "  var java.util.List<? super String> list = null;\n") + 
      "  list.map(e|e)\n") + 
      "}"), "List<? super String>", "Object");
  }
  
  @Test
  public void testClosure_04() throws Exception {
    this.resolvesIdentifiablesTo(((("{\n" + 
      "  var java.util.List<? super String> list = null;\n") + 
      "  list.map(e|false)\n") + 
      "}"), "List<? super String>", "Object");
  }
  
  @Test
  public void testClosure_05() throws Exception {
    this.resolvesIdentifiablesTo("[x| true]", "Object");
  }
  
  @Test
  public void testClosure_07() throws Exception {
    this.resolvesIdentifiablesTo("[String x, String y| x + y ]", "String", "String");
  }
  
  @Test
  public void testClosure_08() throws Exception {
    this.resolvesIdentifiablesTo("[x| x]", "Object");
  }
  
  @Test
  public void testClosure_11() throws Exception {
    this.resolvesIdentifiablesTo("[Object x| x]", "Object");
  }
  
  @Test
  public void testClosure_13() throws Exception {
    this.resolvesIdentifiablesTo("{ \n\t\t\tval mapper = [ x | x ]\n\t\t\tnewArrayList(1).map(mapper)\n\t\t}", "(Integer)=>Integer", "Integer");
  }
  
  @Test
  public void testClosure_13b() throws Exception {
    this.resolvesIdentifiablesTo("{ \n\t\t\tval mapper = [ x | x ]\n\t\t\tnewArrayList(1).map(mapper).findFirst [ true ]\n\t\t}", "(Integer)=>Integer", "Integer", "Integer");
  }
  
  @Ignore("TODO deferred closure body typing")
  @Test
  public void testClosure_14() throws Exception {
    this.resolvesIdentifiablesTo("{ \n\t\t\tval mapper = [ x | x.charAt(0) ]\n\t\t\tnewArrayList(\'\').map(mapper)\n\t\t}", "(String)=>char", "String");
  }
  
  @Test
  public void testClosure_15() throws Exception {
    this.resolvesIdentifiablesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval String s = fun.apply(null)\n\t\t\tfun\n\t\t}", "(String)=>String", "String", "String");
  }
  
  @Test
  public void testClosure_16() throws Exception {
    this.resolvesIdentifiablesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.List<String> list = newArrayList(fun.apply(null))\n\t\t\tfun\n\t\t}", "(String[])=>String[]", "String[]", "List<String>");
  }
  
  @Test
  public void testClosure_17() throws Exception {
    this.resolvesIdentifiablesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.List<String> list = newArrayList.map(fun)\n\t\t\tfun\n\t\t}", "(String)=>String", "String", "List<String>");
  }
  
  @Test
  public void testClosure_21() throws Exception {
    this.resolvesIdentifiablesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval list = newArrayList.map(fun)\n\t\t\tval Iterable<String> iter = list\n\t\t\tfun\n\t\t}", "(String)=>String", "String", "List<String>", "Iterable<String>");
  }
  
  @Test
  public void testClosure_22() throws Exception {
    this.resolvesIdentifiablesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval java.util.List<String> list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tfun\n\t\t}", "(String)=>String", "String", "List<String>");
  }
  
  @Test
  public void testClosure_26() throws Exception {
    this.resolvesIdentifiablesTo("{ \n\t\t\tval fun = [ x | x ]\n\t\t\tval list = $$ListExtensions::map(newArrayList, fun)\n\t\t\tval Iterable<String> iter = list\n\t\t\tfun\n\t\t}", "(String)=>String", "String", "List<String>", "Iterable<String>");
  }
  
  @Test
  public void testClosure_27() throws Exception {
    this.resolvesIdentifiablesTo("{ \n\t\t\tval mapper = [ x | x ]\n\t\t\t$$ListExtensions::map(newArrayList(1), mapper)\n\t\t}", "(Integer)=>Integer", "Integer");
  }
  
  @Test
  public void testClosure_30() throws Exception {
    this.resolvesIdentifiablesTo("$$ListExtensions::map(null as java.util.List<? super String>) [e|e]", "Object");
  }
  
  @Test
  public void testClosure_31() throws Exception {
    this.resolvesIdentifiablesTo(((("{\n" + 
      "  var java.util.List<? super String> list = null;\n") + 
      "  $$ListExtensions::map(list) [e|e]\n") + 
      "}"), "List<? super String>", "Object");
  }
  
  @Test
  public void testSwitchExpression_3() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval Object c = null\n\t\t\tswitch c {\n\t            CharSequence: 1\n\t    \t}\n\t\t}", "Object");
  }
  
  @Test
  public void testSwitchExpression_4() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval Comparable<Object> c = null\n\t\t\tswitch c {\n\t            CharSequence: switch(c) {\n                    Appendable: {\n                        c.charAt(1)\n                    }\n                }\n        \t}\n\t\t}", "Comparable<Object>");
  }
  
  @Test
  public void testSwitchExpression_5() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval Comparable<Object> c = null\n\t\t\tswitch c {\n\t            CharSequence: switch(c) {\n                    Appendable: {\n                        c.append(null)\n                    }\n                }\n        \t}\n\t\t}", "Comparable<Object>");
  }
  
  @Test
  public void testSwitchExpression_6() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval Comparable<Object> c = null\n\t\t\tswitch c {\n\t            CharSequence: switch(c) {\n                    Appendable: {\n                        c.compareTo(null)\n                    }\n                }\n        \t}\n\t\t}", "Comparable<Object>");
  }
  
  @Test
  public void testTypeGuardedCase_0() throws Exception {
    this.resolvesIdentifiablesTo("switch s: new Object() { String: s StringBuffer: s}", "Object");
  }
  
  @Test
  public void testTypeGuardedCase_1() throws Exception {
    this.resolvesIdentifiablesTo("switch s: \'\' as CharSequence { Cloneable: s String: s }", "CharSequence");
  }
  
  @Test
  public void testBlockExpression_02() throws Exception {
    this.resolvesIdentifiablesTo("{val s = \'\' s}", "String");
  }
  
  @Test
  public void testBlockExpression_04() throws Exception {
    this.resolvesIdentifiablesTo("{val Object s = \'\' s}", "Object");
  }
  
  @Test
  public void testEMap_01() throws Exception {
    this.resolvesIdentifiablesTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ getKey ].head\n         }", "BasicEMap<Integer, String>", "Entry<Integer, String>");
  }
  
  @Test
  public void testEMap_05() throws Exception {
    this.resolvesIdentifiablesTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? extends Integer, String> eMap = null\n\t\t  eMap.map[ key ].head\n         }", "BasicEMap<? extends Integer, String>", "Entry<? extends Integer, String>");
  }
  
  @Test
  public void testEMap_09() throws Exception {
    this.resolvesIdentifiablesTo("{ \n          val org.eclipse.emf.common.util.BasicEMap<? super Integer, String> eMap = null\n\t\t  eMap.map[ key ].head\n         }", "BasicEMap<? super Integer, String>", "Entry<? super Integer, String>");
  }
  
  @Test
  public void testMemberFeatureCall_02() throws Exception {
    this.resolvesIdentifiablesTo("(1..20).map[ toString.length ].reduce[ i1,  i2 | i1 + i2 ]", "Integer", "Integer", "Integer");
  }
  
  @Test
  public void testFeatureCall_06() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map(s|s)", "String");
  }
  
  @Test
  public void testFeatureCall_06a() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map [it|it]", "String");
  }
  
  @Test
  public void testFeatureCall_06b() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map [it]", "String");
  }
  
  @Test
  public void testFeatureCall_06c() throws Exception {
    this.resolvesIdentifiablesTo("(null as Iterable<String>).map(s|s)", "String");
  }
  
  @Test
  public void testFeatureCall_06_00() throws Exception {
    this.resolvesIdentifiablesTo("$$ListExtensions::map(newArrayList(\'\')) [s|s]", "String");
  }
  
  @Test
  public void testFeatureCall_06_01() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map(s|s).head", "String");
  }
  
  @Test
  public void testFeatureCall_06_02() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map(s|s.toString).head", "String");
  }
  
  @Test
  public void testFeatureCall_06_03() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map(s|1)", "String");
  }
  
  @Test
  public void testFeatureCall_07() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map(s|s.length)", "String");
  }
  
  @Test
  public void testFeatureCall_07_01() throws Exception {
    this.resolvesIdentifiablesTo("<String>newArrayList.map[ length ]", "String");
  }
  
  @Test
  public void testFeatureCall_10() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map(s|1).map(i|i+1)", "String", "Integer");
  }
  
  @Test
  public void testFeatureCall_12() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map(s|1).toList().map(i|i)", "String", "Integer");
  }
  
  @Test
  public void testFeatureCall_13_2() throws Exception {
    this.resolvesIdentifiablesTo("{ var it = newArrayList(\'\').map(s|1).toList() it.map(i|i+1) }", "List<Integer>", "String", "Integer");
  }
  
  @Test
  public void testFeatureCall_13_3() throws Exception {
    this.resolvesIdentifiablesTo("{ var it = newArrayList(\'\').map(s|1).toList() map(i|i+1) }", "List<Integer>", "String", "Integer");
  }
  
  @Test
  public void testFeatureCall_13_5() throws Exception {
    this.resolvesIdentifiablesTo("{ var java.util.List<? extends Integer> it = null map(i|i+1) }", "List<? extends Integer>", "Integer");
  }
  
  @Test
  public void testFeatureCall_13_6() throws Exception {
    this.resolvesIdentifiablesTo("{ var java.util.List<? extends Integer> it = null map(i|i) }", "List<? extends Integer>", "Integer");
  }
  
  @Test
  public void testFeatureCall_14() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(newArrayList(\'\').map(s|1))", "String");
  }
  
  @Test
  public void testFeatureCall_15() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size())", "String", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_a() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size()).map(e|e)", "String", "List<Integer>", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_b() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e)", "String", "List<Integer>", "Integer", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_e() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e)).map(iterable|iterable.size())", "String", "Integer", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_e_2() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size())", "ArrayList<String>");
  }
  
  @Test
  public void testFeatureCall_15_f() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size())", "String", "Integer", "Integer", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_i_3() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e)).map(iterable|iterable.size()).map(e|e)", "String", "Integer", "List<Integer>", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_p() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size()).map(e|e)", "ArrayList<String>", "Integer");
  }
  
  @Test
  public void testFeatureCall_16_a() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map(s|1).map(i|1)", "String", "Integer");
  }
  
  @Test
  public void testFeatureCall_18_a() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b|b)", "String", "Boolean");
  }
  
  @Test
  public void testFeatureCall_20_a() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(boolean b|!b)", "String", "boolean");
  }
  
  @Test
  public void testFeatureCall_24_a() throws Exception {
    this.resolvesIdentifiablesTo(((("newArrayList(\'\').map(s|" + 
      "$$ObjectExtensions::operator_equals(") + 
      "\t$$IntegerExtensions::operator_plus(s.length,1), 5)") + 
      ").map(b| $$BooleanExtensions::operator_not(b) )"), "String", "Boolean");
  }
  
  @Test
  public void testFeatureCall_25_a() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map(s|s.length + 1 * 5).map(b| b / 5 )", "String", "Integer");
  }
  
  @Test
  public void testFeatureCall_25_c() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map[ length + 1 * 5 ].map [ it / 5 ].head", "String", "Integer");
  }
  
  @Test
  public void testFeatureCall_26() throws Exception {
    boolean _isJava12OrLater = AbstractXbaseTestCase.isJava12OrLater();
    if (_isJava12OrLater) {
      this.resolvesIdentifiablesTo("{ val list = newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\')).map(v|v.intValue)\n\t\t\t   val Object o = list.head \n\t\t\t   list\n\t\t\t}", "List<Integer>", "Number & Comparable<?> & Constable & ConstantDesc", "Object");
    } else {
      this.resolvesIdentifiablesTo("{ val list = newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\')).map(v|v.intValue)\n\t\t\t   val Object o = list.head \n\t\t\t   list\n\t\t\t}", "List<Integer>", "Number & Comparable<?>", "Object");
    }
  }
  
  @Test
  public void testFeatureCall_27() throws Exception {
    boolean _isJava12OrLater = AbstractXbaseTestCase.isJava12OrLater();
    if (_isJava12OrLater) {
      this.resolvesIdentifiablesTo("{ val list = $$ListExtensions::map(newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\'))) [ v|v.intValue ]\n\t\t\t   val Object o = list.head \n\t\t\t   list\n\t\t\t}", "List<Integer>", "Number & Comparable<?> & Constable & ConstantDesc", "Object");
    } else {
      this.resolvesIdentifiablesTo("{ val list = $$ListExtensions::map(newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\'))) [ v|v.intValue ]\n\t\t\t   val Object o = list.head \n\t\t\t   list\n\t\t\t}", "List<Integer>", "Number & Comparable<?>", "Object");
    }
  }
  
  @Test
  public void testFeatureCall_28() throws Exception {
    this.resolvesIdentifiablesTo("{ val list = $$ListExtensions::map(newArrayList(null as Integer)) [ v|v.intValue ] }", "List<Integer>", "Integer");
  }
  
  @Test
  public void testFeatureCall_30() throws Exception {
    this.resolvesIdentifiablesTo("{ val list = newArrayList(null as Integer).map [ v|v.intValue ]\n           val o = list.head \n           list\n        }", "List<Integer>", "Integer", "Integer");
  }
  
  @Test
  public void testFeatureCall_31() throws Exception {
    this.resolvesIdentifiablesTo("{ val list = newArrayList(null as Integer).map [ v|v.intValue ]\n           list.findFirst [ intValue == 0 ]\n        }", "List<Integer>", "Integer", "Integer");
  }
  
  @Test
  public void testFeatureCall_32() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.forEach[String s | s]\n\t\t\tlist\n\t\t}", "ArrayList<String>", "String");
  }
  
  @Test
  public void testFeatureCall_34() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList.map[String s | s.substring(1,1) ]", "String");
  }
  
  @Test
  public void testFeatureCall_35() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList.map[ s | s.toString ]", "Object");
  }
  
  @Test
  public void testFeatureCall_36() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.forEach[ s | s.toString ]\n\t\t\tlist\n\t\t}", "ArrayList<Object>", "Object");
  }
  
  @Test
  public void testFeatureCall_Bug342134_00() throws Exception {
    this.resolvesIdentifiablesTo("(null as java.util.List<String>).map(e|newArrayList(e)).flatten", "String");
  }
  
  @Test
  public void testFeatureCall_Bug342134_01() throws Exception {
    this.resolvesIdentifiablesTo("(null as java.util.List<String>).map(CharSequence e|newArrayList(e)).flatten", "CharSequence");
  }
  
  @Test
  public void testFeatureCall_Bug342134_02() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map(e|newArrayList(e)).flatten", "String");
  }
  
  @Test
  public void testFeatureCall_Bug342134_04() throws Exception {
    this.resolvesIdentifiablesTo("newArrayList(\'\').map(e|newArrayList(e))", "String");
  }
  
  @Test
  public void testFeatureCall_Bug342134_06() throws Exception {
    this.resolvesIdentifiablesTo("<String>newArrayList.map(e|newArrayList(e)).flatten", "String");
  }
  
  @Ignore("TODO this should work")
  @Test
  public void testBug_391758() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval iterable = newArrayList\n\t\t\titerable.fold(newArrayList) [ list , elem | null as java.util.List<String> ]\n\t\t}", "ArrayList<Object>", "List<String>", "Object");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_002() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval String s = list.get(0)\n\t\t\tlist\n\t\t}", "ArrayList<String>", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_012() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval secondList = newArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.addAll(secondList)\n\t\t\tsecondList\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_016() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval java.util.Iterator<String> sublist = list.subList(1, 1).iterator\n\t\t\tlist\n\t\t}", "ArrayList<String>", "Iterator<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_036() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = newArrayList(newArrayList)\n\t\t\tval Iterable<String> s = list.head\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<String>>", "Iterable<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_037() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = newArrayList(newArrayList)\n\t\t\tval Iterable<String> s = list.flatten\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<String>>", "Iterable<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_038() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = newArrayList(newHashSet)\n\t\t\tval String s = list.flatten.head\n\t\t\tlist.head\n\t\t}", "ArrayList<HashSet<String>>", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_040() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList(newArrayList)\n\t\t\tval String s = second.flatten.head\n\t\t\tlist.add(second.head)\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<String>>", "ArrayList<ArrayList<String>>", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_042() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval secondList = newArrayList\n\t\t\tlist.addAll(\'\')\n\t\t\tlist.addAll(secondList)\n\t\t\tsecondList\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_061() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval java.util.Set<String> sublist = println(println(list).subList(1, 1))\n\t\t\tlist\n\t\t}", "ArrayList<String>", "Set<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_062() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval java.util.Iterator<String> sublist = println(println(println(list).subList(1, 1)).iterator)\n\t\t\tlist\n\t\t}", "ArrayList<String>", "Iterator<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_102() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.HashSet)\n\t\t\tval Iterable<String> s = list.head\n\t\t\tlist.head\n\t\t}", "ArrayList<HashSet<String>>", "Iterable<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_106() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tsecond.add(new java.util.ArrayList)\n\t\t\tval String s = second.flatten.head\n\t\t\tlist.add(second.head)\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<String>>", "ArrayList<ArrayList<String>>", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_133() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval fun = [String s| s]\n\t\t\tlist.map(fun)\n\t\t\tlist\n\t\t}", "ArrayList<String>", "(String)=>String", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_134() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.map[String s| s]\n\t\t\tlist\n\t\t}", "ArrayList<String>", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_135() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.<String, Object>map[s| s]\n\t\t\tlist\n\t\t}", "ArrayList<String>", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_136() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.<String, Object>map[s| s.toString]\n\t\t\tlist\n\t\t}", "ArrayList<String>", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_137() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.<String, Object>map[s| s.charAt(1) ]\n\t\t\tlist\n\t\t}", "ArrayList<String>", "String");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_138() throws Exception {
    this.resolvesIdentifiablesTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.<String, CharSequence>map[s| s]\n\t\t\tlist\n\t\t}", "ArrayList<String>", "String");
  }
}
