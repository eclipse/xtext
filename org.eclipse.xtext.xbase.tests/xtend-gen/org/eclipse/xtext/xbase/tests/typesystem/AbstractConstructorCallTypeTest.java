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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractConstructorCallTypeTest extends AbstractXbaseTestCase {
  public abstract void resolvesConstructorCallsTo(final String expression, final String... types);
  
  private static Set<String> seenExpressions;
  
  @BeforeClass
  public static void createSeenExpressionsSet() {
    HashSet<String> _newHashSet = CollectionLiterals.<String>newHashSet();
    AbstractConstructorCallTypeTest.seenExpressions = _newHashSet;
  }
  
  @AfterClass
  public static void discardSeenExpressions() {
    AbstractConstructorCallTypeTest.seenExpressions = null;
  }
  
  protected List<XConstructorCall> findConstructorCalls(final CharSequence expression) {
    try {
      final XExpression xExpression = this.expression(expression, false);
      Resource _eResource = xExpression.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TreeIterator<EObject> _eAll = EcoreUtil2.eAll(xExpression);
      Iterator<XConstructorCall> _filter = Iterators.<XConstructorCall>filter(_eAll, XConstructorCall.class);
      final List<XConstructorCall> closures = IteratorExtensions.<XConstructorCall>toList(_filter);
      final Function1<XConstructorCall, Integer> _function = (XConstructorCall it) -> {
        List<INode> _findNodesForFeature = NodeModelUtils.findNodesForFeature(it, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR);
        INode _head = IterableExtensions.<INode>head(_findNodesForFeature);
        return Integer.valueOf(_head.getOffset());
      };
      return IterableExtensions.<XConstructorCall, Integer>sortBy(closures, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected XExpression expression(final CharSequence expression, final boolean resolve) throws Exception {
    XExpression _xblockexpression = null;
    {
      final String string = expression.toString();
      boolean _add = AbstractConstructorCallTypeTest.seenExpressions.add(string);
      boolean _not = (!_add);
      if (_not) {
        Assert.fail(("Duplicate expression under test: " + expression));
      }
      _xblockexpression = super.expression(expression, resolve);
    }
    return _xblockexpression;
  }
  
  @Test
  public void testAssignment_01() throws Exception {
    this.resolvesConstructorCallsTo("new testdata.FieldAccess().stringField = null", "FieldAccess");
  }
  
  @Test
  public void testAssignment_02() throws Exception {
    this.resolvesConstructorCallsTo("new testdata.FieldAccess().stringField = new Object", "FieldAccess", "Object");
  }
  
  @Test
  public void testAssignment_03() throws Exception {
    this.resolvesConstructorCallsTo("new testdata.FieldAccess().stringField = \'\'", "FieldAccess");
  }
  
  @Test
  public void testOverloadedOperators_10() throws Exception {
    this.resolvesConstructorCallsTo("(1..2).map[ new java.math.BigInteger(toString) ].reduce[ i1, i2| i1 + i2 ]", "BigInteger");
  }
  
  @Test
  public void testOverloadedOperators_15() throws Exception {
    this.resolvesConstructorCallsTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i.toString + i ]", "BigInteger");
  }
  
  @Test
  public void testOverloadedOperators_16() throws Exception {
    this.resolvesConstructorCallsTo("(1..2).map[ new java.math.BigInteger(toString) ].map[ i | i + String::valueOf(i) ]", "BigInteger");
  }
  
  @Test
  public void testThrowExpression() throws Exception {
    this.resolvesConstructorCallsTo("throw new Exception()", "Exception");
  }
  
  @Test
  public void testMethodTypeParamInference_00() throws Exception {
    this.resolvesConstructorCallsTo("new java.util.ArrayList<String>().findFirst(e | true)", "ArrayList<String>");
  }
  
  @Test
  public void testMethodTypeParamInference_01() throws Exception {
    this.resolvesConstructorCallsTo("new java.util.ArrayList<String>().findFirst(e|e == \'foo\')", "ArrayList<String>");
  }
  
  @Test
  public void testMethodTypeParamInference_02() throws Exception {
    this.resolvesConstructorCallsTo("new java.util.ArrayList<String>().<String>findFirst(e|e == \'foo\')", "ArrayList<String>");
  }
  
  @Test
  public void testMethodTypeParamInference_03() throws Exception {
    this.resolvesConstructorCallsTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e | true]", "ArrayList<String>");
  }
  
  @Test
  public void testMethodTypeParamInference_04() throws Exception {
    this.resolvesConstructorCallsTo("$$IterableExtensions::findFirst(new java.util.ArrayList<String>) [e|e == \'foo\']", "ArrayList<String>");
  }
  
  @Test
  public void testMethodTypeParamInference_05() throws Exception {
    this.resolvesConstructorCallsTo("$$IterableExtensions::<String>findFirst(new java.util.ArrayList<String>) [e|e == \'foo\']", "ArrayList<String>");
  }
  
  @Test
  public void testClosure_01() throws Exception {
    this.resolvesConstructorCallsTo("{ var closure = [|\'literal\']\n\t\t  new testdata.ClosureClient().invoke0(closure)\t}", "ClosureClient");
  }
  
  @Test
  public void testTypeArgs() throws Exception {
    this.resolvesConstructorCallsTo("new java.util.ArrayList<String>() += \'foo\'", "ArrayList<String>");
  }
  
  @Test
  public void testIfExpression_02() throws Exception {
    this.resolvesConstructorCallsTo("if (true) new StringBuilder() else new StringBuffer()", "StringBuilder", "StringBuffer");
  }
  
  @Test
  public void testTypeGuardedCase_0() throws Exception {
    this.resolvesConstructorCallsTo("switch s: new Object() { String: s StringBuffer: s}", "Object");
  }
  
  @Test
  public void testEMap_01() throws Exception {
    this.resolvesConstructorCallsTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ getKey ].head\n         }", "BasicEMap<Integer, String>");
  }
  
  @Test
  public void testEMap_02() throws Exception {
    this.resolvesConstructorCallsTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ getValue ].head\n         }", "BasicEMap<Integer, String>");
  }
  
  @Test
  public void testEMap_03() throws Exception {
    this.resolvesConstructorCallsTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map[ it ].head\n         }", "BasicEMap<Integer, String>");
  }
  
  @Test
  public void testEMap_04() throws Exception {
    this.resolvesConstructorCallsTo("{ \n          val eMap = new org.eclipse.emf.common.util.BasicEMap<Integer, String>()\n\t\t  eMap.map\n         }", "BasicEMap<Integer, String>");
  }
  
  @Test
  public void testConstructorTypeParameters_01() throws Exception {
    this.resolvesConstructorCallsTo("new java.util.ArrayList<? extends String>()", "ArrayList<String>");
  }
  
  @Test
  public void testConstructorTypeParameters_02() throws Exception {
    this.resolvesConstructorCallsTo("new java.util.ArrayList<? super String>()", "ArrayList<String>");
  }
  
  @Test
  public void testConstructorTypeParameters_03() throws Exception {
    this.resolvesConstructorCallsTo("new java.util.ArrayList<? super Iterable<? super String>>()", "ArrayList<Iterable<? super String>>");
  }
  
  @Test
  public void testConstructorTypeParameters_04() throws Exception {
    this.resolvesConstructorCallsTo("new java.util.ArrayList<? extends Iterable<? extends String>>()", "ArrayList<Iterable<? extends String>>");
  }
  
  @Test
  public void testConstructorTypeParameters_05() throws Exception {
    this.resolvesConstructorCallsTo("new constructorTypeParameters.KeyValue(null, \'\')", "KeyValue");
  }
  
  @Test
  public void testConstructorTypeParameters_06() throws Exception {
    this.resolvesConstructorCallsTo("new constructorTypeParameters.KeyValue(new constructorTypeParameters.WritableValue, \'\')", "KeyValue", "WritableValue<String>");
  }
  
  @Test
  public void testConstructorTypeParameters_07() throws Exception {
    this.resolvesConstructorCallsTo("new constructorTypeParameters.KeyValue(new constructorTypeParameters.WritableDoubleValue, 1.0)", "KeyValue", "WritableDoubleValue");
  }
  
  @Test
  public void testConstructorTypeParameters_08() throws Exception {
    this.resolvesConstructorCallsTo("new constructorTypeParameters.KeyValue(new constructorTypeParameters.WritableValue, 1.0)", "KeyValue", "WritableValue<Double>");
  }
  
  @Test
  public void testConstructorTypeInference_01() throws Exception {
    this.resolvesConstructorCallsTo("{ var Iterable<? extends String> it = new java.util.ArrayList() }", "ArrayList<String>");
  }
  
  @Test
  public void testConstructorTypeInference_02() throws Exception {
    this.resolvesConstructorCallsTo("<java.util.List<String>>newArrayList().add(new java.util.ArrayList())", "ArrayList<String>");
  }
  
  @Test
  public void testConstructorTypeInference_03() throws Exception {
    this.resolvesConstructorCallsTo("<java.util.List<String>>newArrayList().add(0, new java.util.ArrayList())", "ArrayList<String>");
  }
  
  @Test
  public void testConstructorTypeInference_04() throws Exception {
    this.resolvesConstructorCallsTo("newArrayList.add(new java.util.ArrayList())", "ArrayList<Object>");
  }
  
  @Test
  public void testConstructorTypeInference_05() throws Exception {
    this.resolvesConstructorCallsTo("{ var Iterable<? super String> it = new java.util.ArrayList() }", "ArrayList<String>");
  }
  
  @Test
  public void testConstructorTypeInference_06() throws Exception {
    this.resolvesConstructorCallsTo("{ var Iterable<? extends String> it = { var x = new java.util.ArrayList() x } }", "ArrayList<String>");
  }
  
  @Test
  public void testConstructorTypeInference_07() throws Exception {
    this.resolvesConstructorCallsTo("{ var Iterable<? extends String> it = { var x = new java.util.ArrayList() var y = x y } }", "ArrayList<String>");
  }
  
  @Test
  public void testConstructorTypeInference_08() throws Exception {
    this.resolvesConstructorCallsTo("new testdata.GenericType2(new Integer(0), new Integer(0).doubleValue)", "GenericType2<Number & Comparable<?>>", "Integer", "Integer");
  }
  
  @Test
  public void testConstructorTypeInference_09() throws Exception {
    this.resolvesConstructorCallsTo("<Iterable<String>>newArrayList().add(new java.util.LinkedList)", "LinkedList<String>");
  }
  
  @Test
  public void testConstructorTypeInference_10() throws Exception {
    this.resolvesConstructorCallsTo("{ var Iterable<? extends Iterable<? super String>> it = new java.util.ArrayList() }", "ArrayList<Iterable<? super String>>");
  }
  
  @Test
  public void testConstructorTypeInference_11() throws Exception {
    this.resolvesConstructorCallsTo("{ var Iterable<? super Iterable<? super String>> it = new java.util.ArrayList() }", "ArrayList<Iterable<? super String>>");
  }
  
  @Test
  public void testConstructorTypeInference_12() throws Exception {
    this.resolvesConstructorCallsTo("{ var java.util.Map<? super String, ? super String> it = new java.util.HashMap }", "HashMap<String, String>");
  }
  
  @Test
  public void testVarArgs_01() throws Exception {
    this.resolvesConstructorCallsTo("newArrayList(new Double(\'-20\'), new Integer(\'20\'))", "Double", "Integer");
  }
  
  @Test
  public void testVarArgs_02() throws Exception {
    this.resolvesConstructorCallsTo("newArrayList(if (true) new Double(\'-20\') else new Integer(\'20\'))", "Double", "Integer");
  }
  
  @Test
  public void testVarArgs_03() throws Exception {
    this.resolvesConstructorCallsTo("newArrayList(if (true) new Double(\'-20\') else new Integer(\'20\'), new Integer(\'29\'))", "Double", "Integer", "Integer");
  }
  
  @Test
  public void testVarArgs_04() throws Exception {
    this.resolvesConstructorCallsTo("newArrayList(if (true) new Double(\'-20\') else new Integer(\'20\'), new Double(\'29\'))", "Double", "Integer", "Double");
  }
  
  @Test
  public void testVarArgs_05() throws Exception {
    this.resolvesConstructorCallsTo("newArrayList(if (true) new Double(\'-20\') else new Integer(\'20\'), new Integer(\'29\'), new Double(\'29\'))", "Double", "Integer", "Integer", "Double");
  }
  
  @Test
  public void testFeatureCall_03() throws Exception {
    this.resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toList()", "ClassWithVarArgs");
    this.resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toList(\'\')", "ClassWithVarArgs");
    this.resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toList(\'\', \'\')", "ClassWithVarArgs");
  }
  
  @Test
  public void testFeatureCall_03_a() throws Exception {
    this.resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toList(null as String[])", "ClassWithVarArgs");
  }
  
  @Test
  public void testFeatureCall_03_b() throws Exception {
    this.resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toList(null as int[])", "ClassWithVarArgs");
  }
  
  @Test
  public void testFeatureCall_04() throws Exception {
    this.resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toList(\'\', 1)", "ClassWithVarArgs");
  }
  
  @Test
  public void testFeatureCall_05() throws Exception {
    this.resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toNumberList()", "ClassWithVarArgs");
    this.resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toNumberList(0)", "ClassWithVarArgs");
    this.resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toNumberList(0, 1)", "ClassWithVarArgs");
    this.resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toNumberList(new Integer(0), new Integer(0).doubleValue)", "ClassWithVarArgs", "Integer", "Integer");
  }
  
  @Test
  public void testFeatureCall_05_b() throws Exception {
    this.resolvesConstructorCallsTo("new testdata.ClassWithVarArgs().toNumberList(null as Float[])", "ClassWithVarArgs");
  }
  
  @Test
  public void testFeatureCall_26() throws Exception {
    this.resolvesConstructorCallsTo("{ val list = newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list\n        }", "Double", "Integer");
  }
  
  @Test
  public void testFeatureCall_26a() throws Exception {
    this.resolvesConstructorCallsTo("{ val list = newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\')).map(v|v.intValue)\n           val Object o = list.head \n           list.head\n        }", "Double", "Integer");
  }
  
  @Test
  public void testFeatureCall_27() throws Exception {
    this.resolvesConstructorCallsTo("{ val list = $$ListExtensions::map(newArrayList(if (false) new Double(\'-20\') else new Integer(\'20\'))) [ v|v.intValue ]\n           val Object o = list.head \n           list\n        }", "Double", "Integer");
  }
  
  @Test
  public void testDependentTypeArgumentResolution_01() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tvar Iterable<CharSequence> from = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, new java.util.ArrayList)\n\t\t}", "ArrayList<CharSequence>");
  }
  
  @Test
  public void testDependentTypeArgumentResolution_02() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tvar Iterable<? extends CharSequence> from = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, new java.util.ArrayList)\n\t\t}", "ArrayList<CharSequence>");
  }
  
  @Test
  public void testDependentTypeArgumentResolution_03() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(null, new java.util.ArrayList)\n\t\t}", "ArrayList<Object>");
  }
  
  @Test
  public void testDependentTypeArgumentResolution_04() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::<String>copyIntoList(null, new java.util.ArrayList)\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDependentTypeArgumentResolution_05() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tvar Iterable<? super CharSequence> from = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::copyIntoList(from, new java.util.ArrayList)\n\t\t}", "ArrayList<Object>");
  }
  
  @Test
  public void testDependentTypeArgumentResolution_06() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tvar Iterable<StringBuilder> from = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, new java.util.ArrayList)\n\t\t}", "ArrayList<StringBuilder>");
  }
  
  @Test
  public void testDependentTypeArgumentResolution_07() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tvar Iterable<? extends StringBuilder> from = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, new java.util.ArrayList)\n\t\t}", "ArrayList<StringBuilder>");
  }
  
  @Test
  public void testDependentTypeArgumentResolution_08() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(null, new java.util.ArrayList)\n\t\t}", "ArrayList<Serializable>");
  }
  
  @Test
  public void testDependentTypeArgumentResolution_09() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::<String>constrainedCopyIntoList(null, new java.util.ArrayList)\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDependentTypeArgumentResolution_10() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tvar Iterable<? super StringBuilder> from = null\n\t\t\torg::eclipse::xtext::xbase::tests::typesystem::TypeResolutionTestData::constrainedCopyIntoList(from, new java.util.ArrayList)\n\t\t}", "ArrayList<Object>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_064() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.add(println(new Integer(0)))\n\t\t\tlist.add(println(new Integer(0).doubleValue))\n\t\t\tlist\n\t\t}", "Integer", "Integer");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_065() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.add(println(new Integer(0)))\n\t\t\tprintln(list.get(0)).toString\n\t\t\tlist.add(println(new Integer(0).doubleValue))\n\t\t\tlist\n\t\t}", "Integer", "Integer");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_068() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval String s = list.get(0)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_069() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval String s = list.head\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_070() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_071() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\t$$CollectionExtensions::addAll(list, null as java.util.ArrayList<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_072() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\t$$CollectionExtensions::addAll(list, \'\', \'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_073() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(null as java.util.ArrayList<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_074() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(new java.util.ArrayList<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_075() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(newHashSet(\'\'))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_076() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(null as java.util.Collection<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_077() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(\'\', \'\', \'\')\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_078() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval secondList = new java.util.ArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.addAll(secondList)\n\t\t\tsecondList\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_079() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval secondList = new java.util.ArrayList\n\t\t\tlist.addAll(secondList)\n\t\t\tlist.add(\'\')\n\t\t\tsecondList\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_080() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval Iterable<String> sublist = list.subList(1, 1)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_081() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval java.util.Set<String> sublist = list.subList(1, 1)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_082() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval java.util.Iterator<String> sublist = list.subList(1, 1).iterator\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_083() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tfor(String s: list.subList(1, 1)) {}\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_084() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new Integer(0))\n\t\t\tlist.add(new Integer(0).doubleValue)\n\t\t\tlist\n\t\t}", "ArrayList<Number & Comparable<?>>", "Integer", "Integer");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_085() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new Integer(0))\n\t\t\tlist.get(0).toString\n\t\t\tlist.add(new Integer(0).doubleValue)\n\t\t\tlist\n\t\t}", "ArrayList<Integer>", "Integer", "Integer");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_086() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_087() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tlist.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_088() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.head)\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_089() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.head)\n\t\t\tlist.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_090() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tlist\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_091() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_092() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tlist\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_093() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tsecond\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_094() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_095() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_096() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.head)\n\t\t\tsecond.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_097() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tlist.add(second.head)\n\t\t\tsecond.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_098() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tlist\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_099() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_100() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tlist\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_101() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tsecond\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_102() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.HashSet)\n\t\t\tval Iterable<String> s = list.head\n\t\t\tlist.head\n\t\t}", "ArrayList<HashSet<String>>", "HashSet<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_103() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval Iterable<String> s = list.flatten\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<String>>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_104() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(newHashSet)\n\t\t\tval String s = list.flatten.head\n\t\t\tlist.head\n\t\t}", "ArrayList<HashSet<String>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_105() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval String s = list.flatten.head\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<String>>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_106() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tsecond.add(new java.util.ArrayList)\n\t\t\tval String s = second.flatten.head\n\t\t\tlist.add(second.head)\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<String>>", "ArrayList<ArrayList<String>>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_107() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_108() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval secondList = new java.util.ArrayList\n\t\t\tlist.addAll(\'\')\n\t\t\tlist.addAll(secondList)\n\t\t\tsecondList\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_109() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval secondList = new java.util.ArrayList\n\t\t\tlist.addAll(secondList)\n\t\t\tlist.addAll(\'\')\n\t\t\tsecondList\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_110() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(\'\', \'\', \'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_111() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval secondList = new java.util.ArrayList\n\t\t\tlist.addAll(\'\', \'\', \'\')\n\t\t\tlist.addAll(secondList)\n\t\t\tsecondList\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_112() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval secondList = new java.util.ArrayList\n\t\t\tlist.addAll(secondList)\n\t\t\tlist.addAll(\'\', \'\', \'\')\n\t\t\tsecondList\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_113() throws Exception {
    this.resolvesConstructorCallsTo("println(new java.util.ArrayList)", "ArrayList<Object>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_114() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval String s = println(list.get(0))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_115() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval String s = println(println(list).head)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_116() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tprintln(list).add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_117() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\t$$CollectionExtensions::addAll(println(list), null as java.util.ArrayList<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_118() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\t$$CollectionExtensions::addAll(println(list), println(\'\'), println(\'\'))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_119() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tprintln(list).addAll(null as java.util.ArrayList<String>)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_120() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tprintln(list).addAll(println(new java.util.ArrayList<String>))\n\t\t\tprintln(list)\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_121() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = println(new java.util.ArrayList)\n\t\t\tprintln(list).addAll(println(newHashSet(\'\')))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_122() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = println(new java.util.ArrayList)\n\t\t\tprintln(list).addAll(null as java.util.Collection<String>)\n\t\t\tprintln(list)\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_123() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tprintln(list).addAll(\'\', \'\', \'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_124() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = println(new java.util.ArrayList)\n\t\t\tval secondList = println(new java.util.ArrayList)\n\t\t\tprintln(list).add(\'\')\n\t\t\tprintln(list).addAll(println(secondList))\n\t\t\tsecondList\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_125() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = println(new java.util.ArrayList)\n\t\t\tval secondList = println(new java.util.ArrayList)\n\t\t\tprintln(list).addAll(println(secondList))\n\t\t\tprintln(list).add(\'\')\n\t\t\tprintln(secondList)\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_126() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval Iterable<String> sublist = println(println(list).subList(1, 1))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_127() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval java.util.Set<String> sublist = println(println(list).subList(1, 1))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_128() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval java.util.Iterator<String> sublist = println(println(println(list).subList(1, 1)).iterator)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_129() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = println(new java.util.ArrayList)\n\t\t\tfor(String s: println(list.subList(1, 1))) {}\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_130() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(println(new Integer(0)))\n\t\t\tlist.add(println(new Integer(0).doubleValue))\n\t\t\tlist\n\t\t}", "ArrayList<Number & Comparable<?>>", "Integer", "Integer");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_131() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(println(new Integer(0)))\n\t\t\tprintln(list.get(0)).toString\n\t\t\tlist.add(println(new Integer(0).doubleValue))\n\t\t\tlist\n\t\t}", "ArrayList<Integer>", "Integer", "Integer");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_132() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tprintln(list).add(println(second.get(0)))\n\t\t\tprintln(list).add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_134() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.map[String s| s]\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_136() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval Iterable<String> s = list.head\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<String>>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_143() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval Iterable<String> s = $$IterableExtensions::head(list)\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<String>>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_144() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval Iterable<String> s = list.head.head\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<Iterable<String>>>", "ArrayList<Iterable<String>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_145() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval Iterable<String> s = list.head.flatten.head\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<Iterable<? extends Iterable<String>>>>", "ArrayList<Iterable<? extends Iterable<String>>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_146() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval String s = list.head.head\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<String>>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_147() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval String s = list.head.flatten.head\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<Iterable<? extends String>>>", "ArrayList<Iterable<? extends String>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_148() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval Iterable<String> s = $$IterableExtensions::flatten(list)\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<String>>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_149() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(newHashSet)\n\t\t\tval String s = $$IterableExtensions::flatten(list).head\n\t\t\tlist.head\n\t\t}", "ArrayList<HashSet<String>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_150() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(new java.util.ArrayList)\n\t\t\tval String s = $$IterableExtensions::flatten(list).head\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<String>>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_151() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tval second = new java.util.ArrayList\n\t\t\tsecond.add(new java.util.ArrayList)\n\t\t\tval String s = $$IterableExtensions::flatten(second).head\n\t\t\tlist.add(second.head)\n\t\t\tlist.head\n\t\t}", "ArrayList<ArrayList<String>>", "ArrayList<ArrayList<String>>", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_155() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.map(println([String s| println(s)]))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_05() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(list)\n\t\t\tlist\n\t\t}", "ArrayList<Object>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_06() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(list.head)\n\t\t\tlist\n\t\t}", "ArrayList<Object>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_07() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.addAll(list)\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_08() throws Exception {
    this.resolvesConstructorCallsTo("{\n\t\t\tval list = new java.util.ArrayList\n\t\t\tlist.add(list.head)\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testFeatureCallWithOperatorOverloading_2() throws Exception {
    this.resolvesConstructorCallsTo("new java.util.ArrayList<Byte>() += \'x\'.getBytes().iterator.next", "ArrayList<Byte>");
  }
  
  @Test
  public void testFeatureCallWithOperatorOverloading_3() throws Exception {
    this.resolvesConstructorCallsTo("new java.util.ArrayList<Byte>() += null", "ArrayList<Byte>");
  }
  
  @Test
  public void testFeatureCallWithOperatorOverloading_4() throws Exception {
    this.resolvesConstructorCallsTo("new java.util.ArrayList<Byte>() += newArrayList(\'x\'.getBytes().iterator.next)", "ArrayList<Byte>");
  }
  
  @Test
  public void testFeatureCallWithOperatorOverloading_5() throws Exception {
    this.resolvesConstructorCallsTo("new java.util.ArrayList<Byte>() += \'x\'.getBytes()", "ArrayList<Byte>");
  }
}
