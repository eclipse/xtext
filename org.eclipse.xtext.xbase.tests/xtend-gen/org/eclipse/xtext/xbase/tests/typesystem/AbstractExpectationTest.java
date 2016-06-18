/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.ExpectationTestingTypeComputer;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractExpectationTest extends AbstractXbaseTestCase {
  private List<String> expectations;
  
  private List<ITypeExpectation> finalExpectations;
  
  private List<XExpression> expressions;
  
  private IResolvedTypes resolvedTypes;
  
  private XExpression rootExpression;
  
  private boolean pendingAssert = false;
  
  public abstract ExpectationTestingTypeComputer getTypeComputer();
  
  public abstract PublicReentrantTypeResolver getResolver();
  
  public AbstractExpectationTest expects(final String input) {
    try {
      XExpression _expression = this.expression(input, false);
      this.rootExpression = _expression;
      PublicReentrantTypeResolver _resolver = this.getResolver();
      _resolver.initializeFrom(this.rootExpression);
      PublicReentrantTypeResolver _resolver_1 = this.getResolver();
      IResolvedTypes _reentrantResolve = _resolver_1.reentrantResolve(CancelIndicator.NullImpl);
      this.resolvedTypes = _reentrantResolve;
      this.pendingAssert = true;
      return this;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void clearData() {
    this.resolvedTypes = null;
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    this.expectations = _newArrayList;
    ArrayList<ITypeExpectation> _newArrayList_1 = CollectionLiterals.<ITypeExpectation>newArrayList();
    this.finalExpectations = _newArrayList_1;
    ArrayList<XExpression> _newArrayList_2 = CollectionLiterals.<XExpression>newArrayList();
    this.expressions = _newArrayList_2;
  }
  
  public AbstractExpectationTest types(final String... names) {
    Assert.assertTrue(this.pendingAssert);
    this.pendingAssert = false;
    String _string = this.expectations.toString();
    int _size = ((List<String>)Conversions.doWrapArray(names)).size();
    int _size_1 = this.expectations.size();
    Assert.assertEquals(_string, _size, _size_1);
    Set<String> _set = IterableExtensions.<String>toSet(((Iterable<String>)Conversions.doWrapArray(names)));
    Set<String> _set_1 = IterableExtensions.<String>toSet(this.expectations);
    Assert.assertEquals(_set, _set_1);
    return this;
  }
  
  public AbstractExpectationTest finalizedAs(final String... names) {
    Assert.assertFalse(this.pendingAssert);
    final Function1<ITypeExpectation, String> _function = (ITypeExpectation it) -> {
      LightweightTypeReference _expectedType = it.getExpectedType();
      String _simpleName = null;
      if (_expectedType!=null) {
        _simpleName=_expectedType.getSimpleName();
      }
      return _simpleName;
    };
    List<String> _map = ListExtensions.<ITypeExpectation, String>map(this.finalExpectations, _function);
    String _string = _map.toString();
    int _size = ((List<String>)Conversions.doWrapArray(names)).size();
    int _size_1 = this.expectations.size();
    Assert.assertEquals(_string, _size, _size_1);
    Set<String> _set = IterableExtensions.<String>toSet(((Iterable<String>)Conversions.doWrapArray(names)));
    final Function1<ITypeExpectation, String> _function_1 = (ITypeExpectation it) -> {
      LightweightTypeReference _expectedType = it.getExpectedType();
      String _simpleName = null;
      if (_expectedType!=null) {
        _simpleName=_expectedType.getSimpleName();
      }
      return _simpleName;
    };
    List<String> _map_1 = ListExtensions.<ITypeExpectation, String>map(this.finalExpectations, _function_1);
    Set<String> _set_1 = IterableExtensions.<String>toSet(_map_1);
    Assert.assertEquals(_set, _set_1);
    return this;
  }
  
  public AbstractExpectationTest queriedAs(final String... names) {
    this.pendingAssert = false;
    final Function1<XExpression, LightweightTypeReference> _function = (XExpression it) -> {
      return this.resolvedTypes.getExpectedType(it);
    };
    final List<LightweightTypeReference> expectedTypes = ListExtensions.<XExpression, LightweightTypeReference>map(this.expressions, _function);
    final Function1<LightweightTypeReference, String> _function_1 = (LightweightTypeReference it) -> {
      return it.getSimpleName();
    };
    List<String> _map = ListExtensions.<LightweightTypeReference, String>map(expectedTypes, _function_1);
    String _string = _map.toString();
    int _size = ((List<String>)Conversions.doWrapArray(names)).size();
    int _size_1 = expectedTypes.size();
    Assert.assertEquals(_string, _size, _size_1);
    Set<String> _set = IterableExtensions.<String>toSet(((Iterable<String>)Conversions.doWrapArray(names)));
    final Function1<LightweightTypeReference, String> _function_2 = (LightweightTypeReference it) -> {
      return it.getSimpleName();
    };
    List<String> _map_1 = ListExtensions.<LightweightTypeReference, String>map(expectedTypes, _function_2);
    Set<String> _set_1 = IterableExtensions.<String>toSet(_map_1);
    Assert.assertEquals(_set, _set_1);
    return this;
  }
  
  public AbstractExpectationTest nothing() {
    Assert.assertTrue(this.pendingAssert);
    this.pendingAssert = false;
    int _size = this.finalExpectations.size();
    Assert.assertEquals(1, _size);
    final ITypeExpectation expectation = IterableExtensions.<ITypeExpectation>head(this.finalExpectations);
    boolean _isNoTypeExpectation = expectation.isNoTypeExpectation();
    Assert.assertTrue(_isNoTypeExpectation);
    boolean _isVoidTypeAllowed = expectation.isVoidTypeAllowed();
    Assert.assertTrue(_isVoidTypeAllowed);
    LightweightTypeReference _expectedType = expectation.getExpectedType();
    Assert.assertNull(_expectedType);
    return this;
  }
  
  public AbstractExpectationTest notVoid() {
    Assert.assertTrue(this.pendingAssert);
    this.pendingAssert = false;
    int _size = this.finalExpectations.size();
    Assert.assertEquals(1, _size);
    final ITypeExpectation expectation = IterableExtensions.<ITypeExpectation>head(this.finalExpectations);
    boolean _isNoTypeExpectation = expectation.isNoTypeExpectation();
    Assert.assertFalse(_isNoTypeExpectation);
    boolean _isVoidTypeAllowed = expectation.isVoidTypeAllowed();
    Assert.assertFalse(_isVoidTypeAllowed);
    LightweightTypeReference _expectedType = expectation.getExpectedType();
    Assert.assertNull(_expectedType);
    return this;
  }
  
  @Before
  public void setUp() throws Exception {
    ExpectationTestingTypeComputer _typeComputer = this.getTypeComputer();
    _typeComputer.setTest(this);
    this.pendingAssert = false;
    PublicReentrantTypeResolver _resolver = this.getResolver();
    ExpectationTestingTypeComputer _typeComputer_1 = this.getTypeComputer();
    _resolver.setTypeComputer(_typeComputer_1);
    this.clearData();
  }
  
  @After
  public void tearDown() throws Exception {
    Assert.assertFalse(this.pendingAssert);
    this.pendingAssert = false;
    this.expectations = null;
    this.finalExpectations = null;
    this.expressions = null;
    this.resolvedTypes = null;
    this.rootExpression = null;
    ExpectationTestingTypeComputer _typeComputer = this.getTypeComputer();
    _typeComputer.setTest(null);
    PublicReentrantTypeResolver _resolver = this.getResolver();
    _resolver.setTypeComputer(null);
  }
  
  public void recordExpectation(final XExpression expression, final ITypeComputationState state) {
    List<? extends ITypeExpectation> _expectations = state.getExpectations();
    Iterables.<ITypeExpectation>addAll(this.finalExpectations, _expectations);
    List<? extends ITypeExpectation> _expectations_1 = state.getExpectations();
    final Function1<ITypeExpectation, String> _function = (ITypeExpectation it) -> {
      LightweightTypeReference _expectedType = it.getExpectedType();
      String _simpleName = null;
      if (_expectedType!=null) {
        _simpleName=_expectedType.getSimpleName();
      }
      return _simpleName;
    };
    List<String> _map = ListExtensions.map(_expectations_1, _function);
    Iterables.<String>addAll(this.expectations, _map);
    this.expressions.add(expression);
  }
  
  @Test
  public void testIfCondition() {
    AbstractExpectationTest _expects = this.expects("if (null) true");
    _expects.types("boolean");
  }
  
  @Test
  public void testNotLastExpressionInBlock() {
    AbstractExpectationTest _expects = this.expects("{ null true }");
    _expects.nothing();
  }
  
  @Test
  public void testSwitchValue() {
    AbstractExpectationTest _expects = this.expects("switch null case true: true");
    _expects.notVoid();
  }
  
  @Test
  public void testAssignment_01() {
    AbstractExpectationTest _expects = this.expects("{ val String s = null }");
    _expects.types("String");
  }
  
  @Test
  public void testAssignment_02() {
    AbstractExpectationTest _expects = this.expects("{ val String s; s = null }");
    _expects.types("String");
  }
  
  @Test
  public void testTransitiveAssignment() {
    AbstractExpectationTest _expects = this.expects("{ val StringBuilder s = if (true) null }");
    _expects.types("StringBuilder");
  }
  
  @Test
  public void testFeatureCallArgument_01() {
    AbstractExpectationTest _expects = this.expects("\'\'.substring(null)");
    _expects.types("int");
  }
  
  @Test
  public void testFeatureCallArgument_02() {
    AbstractExpectationTest _expects = this.expects("newArrayList.<String>findFirst(null)");
    AbstractExpectationTest _types = _expects.types("Function1<? super String, Boolean>");
    _types.finalizedAs("Function1<? super String, Boolean>");
  }
  
  @Test
  public void testFeatureCallArgument_03() {
    AbstractExpectationTest _expects = this.expects("newArrayList.findFirst(null)");
    AbstractExpectationTest _types = _expects.types("Function1<? super Unbound[T], Boolean>");
    _types.finalizedAs("Function1<? super Object, Boolean>");
  }
  
  @Test
  public void testFeatureCallArgument_04() {
    AbstractExpectationTest _expects = this.expects("<String>newArrayList.findFirst(null)");
    AbstractExpectationTest _types = _expects.types("Function1<? super Unbound[T], Boolean>");
    _types.finalizedAs("Function1<? super String, Boolean>");
  }
  
  @Test
  public void testFeatureCallArgument_05() {
    AbstractExpectationTest _expects = this.expects("newArrayList(\'\').findFirst(null)");
    AbstractExpectationTest _types = _expects.types("Function1<? super Unbound[T], Boolean>");
    _types.finalizedAs("Function1<? super String, Boolean>");
  }
  
  @Test
  public void testFeatureCallArgument_06() {
    AbstractExpectationTest _expects = this.expects("{\n\t\t\tval (Iterable<CharSequence>)=>void f\n\t\t\tf.apply(null)\n\t\t}");
    AbstractExpectationTest _types = _expects.types("Iterable<CharSequence>");
    _types.finalizedAs("Iterable<CharSequence>");
  }
  
  @Test
  @Ignore("TODO null type is bound differently")
  public void testExtensionReceiver_01() {
    AbstractExpectationTest _expects = this.expects("null.isNullOrEmpty()");
    _expects.types("String", "Iterable<Unbound[T]>");
  }
  
  @Test
  public void testFeatureCallVarArgument_01() {
    AbstractExpectationTest _expects = this.expects("newArrayList(null)");
    AbstractExpectationTest _types = _expects.types("Unbound[T]", "Unbound[T][]");
    _types.finalizedAs("Object", "Object[]");
  }
  
  @Test
  public void testFeatureCallVarArgument_02() {
    AbstractExpectationTest _expects = this.expects("newArrayList(null, \'\')");
    AbstractExpectationTest _types = _expects.types("Unbound[T]");
    _types.finalizedAs("String");
  }
  
  @Test
  public void testFeatureCallVarArgument_03() {
    AbstractExpectationTest _expects = this.expects("{ val Iterable<String> iterable = newArrayList(null) }");
    AbstractExpectationTest _types = _expects.types("Unbound[T][]", "Unbound[T]");
    _types.finalizedAs("String[]", "String");
  }
  
  @Test
  public void testFeatureCallVarArgument_04() {
    ExpectationTestingTypeComputer _typeComputer = this.getTypeComputer();
    final Function1<XExpression, Boolean> _function = (XExpression it) -> {
      return Boolean.valueOf((it instanceof XReturnExpression));
    };
    _typeComputer.setPredicate(_function);
    AbstractExpectationTest _expects = this.expects("new foo.ClassWithGenericMethod().genericMethod(return null)");
    AbstractExpectationTest _types = _expects.types("Unbound[T]");
    _types.finalizedAs("Object");
  }
  
  @Test
  public void testForLoop_01() {
    AbstractExpectationTest _expects = this.expects("for(int x: null) {}");
    AbstractExpectationTest _types = _expects.types("int[] | Iterable<? extends Integer> | Integer[]");
    _types.finalizedAs("int[] | Iterable<? extends Integer> | Integer[]");
  }
  
  @Test
  public void testForLoop_02() {
    AbstractExpectationTest _expects = this.expects("for(String x: null) {}");
    AbstractExpectationTest _types = _expects.types("Iterable<? extends String> | String[]");
    _types.finalizedAs("Iterable<? extends String> | String[]");
  }
  
  @Test
  public void testForLoop_03() {
    AbstractExpectationTest _expects = this.expects("for(Integer x: null) {}");
    AbstractExpectationTest _types = _expects.types("Iterable<? extends Integer> | int[] | Integer[]");
    _types.finalizedAs("Iterable<? extends Integer> | int[] | Integer[]");
  }
  
  @Test
  public void testUpperBound_01() {
    AbstractExpectationTest _expects = this.expects("(1 as Comparable<?>).compareTo(null)");
    AbstractExpectationTest _types = _expects.types("null");
    _types.finalizedAs("null");
  }
  
  @Test
  public void testLowerBound_01() {
    AbstractExpectationTest _expects = this.expects("(1 as Comparable<? super CharSequence>).compareTo(null)");
    AbstractExpectationTest _types = _expects.types("CharSequence");
    _types.finalizedAs("CharSequence");
  }
  
  @Test
  public void testReturn_01() {
    AbstractExpectationTest _expects = this.expects("return null");
    _expects.notVoid();
  }
  
  @Test
  public void testReturn_02() {
    AbstractExpectationTest _expects = this.expects("return { { null } }");
    _expects.notVoid();
  }
  
  @Test
  public void testReturn_03() {
    AbstractExpectationTest _expects = this.expects("return if (true) { { null } }");
    _expects.notVoid();
  }
  
  @Test
  public void testReturn_04() {
    AbstractExpectationTest _expects = this.expects("return if (true) { null \'\' }");
    _expects.nothing();
  }
  
  @Test
  public void testRawType_01() {
    AbstractExpectationTest _expects = this.expects("(\'\' as Comparable).compareTo(null)");
    _expects.types("Object");
  }
  
  @Test
  public void testInvocationOnPrimitive() {
    ExpectationTestingTypeComputer _typeComputer = this.getTypeComputer();
    final Function1<XExpression, Boolean> _function = (XExpression it) -> {
      return Boolean.valueOf((it instanceof XNumberLiteral));
    };
    _typeComputer.setPredicate(_function);
    AbstractExpectationTest _expects = this.expects("1L.intValue");
    AbstractExpectationTest _types = _expects.types(((String) null));
    AbstractExpectationTest _finalizedAs = _types.finalizedAs(((String) null));
    _finalizedAs.queriedAs("Long");
  }
  
  @Test
  public void testImplicitReceiver() {
    ExpectationTestingTypeComputer _typeComputer = this.getTypeComputer();
    final Function1<XExpression, Boolean> _function = (XExpression it) -> {
      return Boolean.valueOf(false);
    };
    _typeComputer.setPredicate(_function);
    this.expects("{val it = 1L intValue}");
    TreeIterator<EObject> _eAllContents = this.rootExpression.eAllContents();
    Iterator<XFeatureCall> _filter = Iterators.<XFeatureCall>filter(_eAllContents, XFeatureCall.class);
    final XFeatureCall intValue = IteratorExtensions.<XFeatureCall>head(_filter);
    XExpression _implicitReceiver = intValue.getImplicitReceiver();
    this.expressions.add(_implicitReceiver);
    this.queriedAs("Long");
  }
  
  @Test
  public void testExtension() {
    ExpectationTestingTypeComputer _typeComputer = this.getTypeComputer();
    final Function1<XExpression, Boolean> _function = (XExpression it) -> {
      return Boolean.valueOf((it instanceof XCastedExpression));
    };
    _typeComputer.setPredicate(_function);
    AbstractExpectationTest _expects = this.expects("(null as String[]).size");
    AbstractExpectationTest _types = _expects.types(((String) null));
    AbstractExpectationTest _finalizedAs = _types.finalizedAs(((String) null));
    _finalizedAs.queriedAs("List<String>");
  }
  
  @Test
  public void testImplicitFirstArgument() {
    ExpectationTestingTypeComputer _typeComputer = this.getTypeComputer();
    final Function1<XExpression, Boolean> _function = (XExpression it) -> {
      return Boolean.valueOf(false);
    };
    _typeComputer.setPredicate(_function);
    this.expects("{val it = null as String[] head}");
    TreeIterator<EObject> _eAllContents = this.rootExpression.eAllContents();
    Iterator<XFeatureCall> _filter = Iterators.<XFeatureCall>filter(_eAllContents, XFeatureCall.class);
    final XFeatureCall size = IteratorExtensions.<XFeatureCall>head(_filter);
    XExpression _implicitFirstArgument = size.getImplicitFirstArgument();
    this.expressions.add(_implicitFirstArgument);
    this.queriedAs("Iterable<String>");
  }
  
  @Test
  public void testBug379531_01() {
    ExpectationTestingTypeComputer _typeComputer = this.getTypeComputer();
    final Function1<XExpression, Boolean> _function = (XExpression it) -> {
      return Boolean.valueOf((it instanceof XCastedExpression));
    };
    _typeComputer.setPredicate(_function);
    AbstractExpectationTest _expects = this.expects("newArrayList(\'\', \'\', null as String)");
    AbstractExpectationTest _types = _expects.types("Unbound[T]");
    _types.finalizedAs("String");
  }
  
  @Test
  public void testBug379531_02() {
    ExpectationTestingTypeComputer _typeComputer = this.getTypeComputer();
    final Function1<XExpression, Boolean> _function = (XExpression it) -> {
      return Boolean.valueOf((it instanceof XCastedExpression));
    };
    _typeComputer.setPredicate(_function);
    AbstractExpectationTest _expects = this.expects("newArrayList(\'\', \'\', null as CharSequence)");
    AbstractExpectationTest _types = _expects.types("Unbound[T]");
    _types.finalizedAs("CharSequence");
  }
  
  @Test
  public void testBug379531_03() {
    AbstractExpectationTest _expects = this.expects("newArrayList(\'\', \'\', null)");
    AbstractExpectationTest _types = _expects.types("Unbound[T]");
    _types.finalizedAs("String");
  }
  
  @Test
  public void testExpectationFromTypeParameter_01() {
    AbstractExpectationTest _expects = this.expects("{ val Iterable<Number> iterable = newArrayList(null) }");
    AbstractExpectationTest _types = _expects.types("Unbound[T]", "Unbound[T][]");
    _types.finalizedAs("Number", "Number[]");
  }
  
  @Test
  public void testExpectationFromTypeParameter_02() {
    AbstractExpectationTest _expects = this.expects("{ val Iterable<Iterable<Number>> iterable = newArrayList(newArrayList(null)) }");
    AbstractExpectationTest _types = _expects.types(
      "Unbound[T]", "Unbound[T][]", "Unbound[T]", "Unbound[T][]");
    _types.finalizedAs("Number", "Number[]", "Iterable<Number>", "Iterable<Number>[]");
  }
}
