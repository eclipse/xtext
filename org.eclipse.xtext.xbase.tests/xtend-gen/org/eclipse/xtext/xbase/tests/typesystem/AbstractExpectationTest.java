/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.List;
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
      this.rootExpression = this.expression(input, false);
      this.getResolver().initializeFrom(this.rootExpression);
      this.resolvedTypes = this.getResolver().reentrantResolve(CancelIndicator.NullImpl);
      this.pendingAssert = true;
      return this;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void clearData() {
    this.resolvedTypes = null;
    this.expectations = CollectionLiterals.<String>newArrayList();
    this.finalExpectations = CollectionLiterals.<ITypeExpectation>newArrayList();
    this.expressions = CollectionLiterals.<XExpression>newArrayList();
  }
  
  public AbstractExpectationTest types(final String... names) {
    Assert.assertTrue(this.pendingAssert);
    this.pendingAssert = false;
    Assert.assertEquals(this.expectations.toString(), ((List<String>)Conversions.doWrapArray(names)).size(), this.expectations.size());
    Assert.assertEquals(IterableExtensions.<String>toSet(((Iterable<String>)Conversions.doWrapArray(names))), IterableExtensions.<String>toSet(this.expectations));
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
    Assert.assertEquals(ListExtensions.<ITypeExpectation, String>map(this.finalExpectations, _function).toString(), ((List<String>)Conversions.doWrapArray(names)).size(), this.expectations.size());
    final Function1<ITypeExpectation, String> _function_1 = (ITypeExpectation it) -> {
      LightweightTypeReference _expectedType = it.getExpectedType();
      String _simpleName = null;
      if (_expectedType!=null) {
        _simpleName=_expectedType.getSimpleName();
      }
      return _simpleName;
    };
    Assert.assertEquals(IterableExtensions.<String>toSet(((Iterable<String>)Conversions.doWrapArray(names))), IterableExtensions.<String>toSet(ListExtensions.<ITypeExpectation, String>map(this.finalExpectations, _function_1)));
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
    Assert.assertEquals(ListExtensions.<LightweightTypeReference, String>map(expectedTypes, _function_1).toString(), ((List<String>)Conversions.doWrapArray(names)).size(), expectedTypes.size());
    final Function1<LightweightTypeReference, String> _function_2 = (LightweightTypeReference it) -> {
      return it.getSimpleName();
    };
    Assert.assertEquals(IterableExtensions.<String>toSet(((Iterable<String>)Conversions.doWrapArray(names))), IterableExtensions.<String>toSet(ListExtensions.<LightweightTypeReference, String>map(expectedTypes, _function_2)));
    return this;
  }
  
  public AbstractExpectationTest nothing() {
    Assert.assertTrue(this.pendingAssert);
    this.pendingAssert = false;
    Assert.assertEquals(1, this.finalExpectations.size());
    final ITypeExpectation expectation = IterableExtensions.<ITypeExpectation>head(this.finalExpectations);
    Assert.assertTrue(expectation.isNoTypeExpectation());
    Assert.assertTrue(expectation.isVoidTypeAllowed());
    Assert.assertNull(expectation.getExpectedType());
    return this;
  }
  
  public AbstractExpectationTest notVoid() {
    Assert.assertTrue(this.pendingAssert);
    this.pendingAssert = false;
    Assert.assertEquals(1, this.finalExpectations.size());
    final ITypeExpectation expectation = IterableExtensions.<ITypeExpectation>head(this.finalExpectations);
    Assert.assertFalse(expectation.isNoTypeExpectation());
    Assert.assertFalse(expectation.isVoidTypeAllowed());
    Assert.assertNull(expectation.getExpectedType());
    return this;
  }
  
  @Before
  public void setUp() throws Exception {
    ExpectationTestingTypeComputer _typeComputer = this.getTypeComputer();
    _typeComputer.setTest(this);
    this.pendingAssert = false;
    PublicReentrantTypeResolver _resolver = this.getResolver();
    _resolver.setTypeComputer(this.getTypeComputer());
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
    final Function1<ITypeExpectation, String> _function = (ITypeExpectation it) -> {
      LightweightTypeReference _expectedType = it.getExpectedType();
      String _simpleName = null;
      if (_expectedType!=null) {
        _simpleName=_expectedType.getSimpleName();
      }
      return _simpleName;
    };
    List<String> _map = ListExtensions.map(state.getExpectations(), _function);
    Iterables.<String>addAll(this.expectations, _map);
    this.expressions.add(expression);
  }
  
  @Test
  public void testIfCondition() {
    this.expects("if (null) true").types("boolean");
  }
  
  @Test
  public void testNotLastExpressionInBlock() {
    this.expects("{ null true }").nothing();
  }
  
  @Test
  public void testSwitchValue() {
    this.expects("switch null case true: true").notVoid();
  }
  
  @Test
  public void testAssignment_01() {
    this.expects("{ val String s = null }").types("String");
  }
  
  @Test
  public void testAssignment_02() {
    this.expects("{ val String s; s = null }").types("String");
  }
  
  @Test
  public void testTransitiveAssignment() {
    this.expects("{ val StringBuilder s = if (true) null }").types("StringBuilder");
  }
  
  @Test
  public void testFeatureCallArgument_01() {
    this.expects("\'\'.substring(null)").types("int");
  }
  
  @Test
  public void testFeatureCallArgument_02() {
    this.expects("newArrayList.<String>findFirst(null)").types("Function1<? super String, Boolean>").finalizedAs("Function1<? super String, Boolean>");
  }
  
  @Test
  public void testFeatureCallArgument_03() {
    this.expects("newArrayList.findFirst(null)").types("Function1<? super Unbound[T], Boolean>").finalizedAs("Function1<? super Object, Boolean>");
  }
  
  @Test
  public void testFeatureCallArgument_04() {
    this.expects("<String>newArrayList.findFirst(null)").types("Function1<? super Unbound[T], Boolean>").finalizedAs("Function1<? super String, Boolean>");
  }
  
  @Test
  public void testFeatureCallArgument_05() {
    this.expects("newArrayList(\'\').findFirst(null)").types("Function1<? super Unbound[T], Boolean>").finalizedAs("Function1<? super String, Boolean>");
  }
  
  @Test
  public void testFeatureCallArgument_06() {
    this.expects("{\n\t\t\tval (Iterable<CharSequence>)=>void f\n\t\t\tf.apply(null)\n\t\t}").types("Iterable<CharSequence>").finalizedAs("Iterable<CharSequence>");
  }
  
  @Test
  @Ignore("TODO null type is bound differently")
  public void testExtensionReceiver_01() {
    this.expects("null.isNullOrEmpty()").types("String", "Iterable<Unbound[T]>");
  }
  
  @Test
  public void testFeatureCallVarArgument_01() {
    this.expects("newArrayList(null)").types("Unbound[T]", "Unbound[T][]").finalizedAs("Object", "Object[]");
  }
  
  @Test
  public void testFeatureCallVarArgument_02() {
    this.expects("newArrayList(null, \'\')").types("Unbound[T]").finalizedAs("String");
  }
  
  @Test
  public void testFeatureCallVarArgument_03() {
    this.expects("{ val Iterable<String> iterable = newArrayList(null) }").types("Unbound[T][]", "Unbound[T]").finalizedAs("String[]", "String");
  }
  
  @Test
  public void testFeatureCallVarArgument_04() {
    ExpectationTestingTypeComputer _typeComputer = this.getTypeComputer();
    final Function1<XExpression, Boolean> _function = (XExpression it) -> {
      return Boolean.valueOf((it instanceof XReturnExpression));
    };
    _typeComputer.setPredicate(_function);
    this.expects("new foo.ClassWithGenericMethod().genericMethod(return null)").types("Unbound[T]").finalizedAs("Object");
  }
  
  @Test
  public void testForLoop_01() {
    this.expects("for(int x: null) {}").types("int[] | Iterable<? extends Integer> | Integer[]").finalizedAs("int[] | Iterable<? extends Integer> | Integer[]");
  }
  
  @Test
  public void testForLoop_02() {
    this.expects("for(String x: null) {}").types("Iterable<? extends String> | String[]").finalizedAs("Iterable<? extends String> | String[]");
  }
  
  @Test
  public void testForLoop_03() {
    this.expects("for(Integer x: null) {}").types("Iterable<? extends Integer> | int[] | Integer[]").finalizedAs("Iterable<? extends Integer> | int[] | Integer[]");
  }
  
  @Test
  public void testUpperBound_01() {
    this.expects("(1 as Comparable<?>).compareTo(null)").types("null").finalizedAs("null");
  }
  
  @Test
  public void testLowerBound_01() {
    this.expects("(1 as Comparable<? super CharSequence>).compareTo(null)").types("CharSequence").finalizedAs("CharSequence");
  }
  
  @Test
  public void testReturn_01() {
    this.expects("return null").notVoid();
  }
  
  @Test
  public void testReturn_02() {
    this.expects("return { { null } }").notVoid();
  }
  
  @Test
  public void testReturn_03() {
    this.expects("return if (true) { { null } }").notVoid();
  }
  
  @Test
  public void testReturn_04() {
    this.expects("return if (true) { null \'\' }").nothing();
  }
  
  @Test
  public void testRawType_01() {
    this.expects("(\'\' as Comparable).compareTo(null)").types("Object");
  }
  
  @Test
  public void testInvocationOnPrimitive() {
    ExpectationTestingTypeComputer _typeComputer = this.getTypeComputer();
    final Function1<XExpression, Boolean> _function = (XExpression it) -> {
      return Boolean.valueOf((it instanceof XNumberLiteral));
    };
    _typeComputer.setPredicate(_function);
    this.expects("1L.intValue").types(((String) null)).finalizedAs(((String) null)).queriedAs("Long");
  }
  
  @Test
  public void testImplicitReceiver() {
    ExpectationTestingTypeComputer _typeComputer = this.getTypeComputer();
    final Function1<XExpression, Boolean> _function = (XExpression it) -> {
      return Boolean.valueOf(false);
    };
    _typeComputer.setPredicate(_function);
    this.expects("{val it = 1L intValue}");
    final XFeatureCall intValue = IteratorExtensions.<XFeatureCall>head(Iterators.<XFeatureCall>filter(this.rootExpression.eAllContents(), XFeatureCall.class));
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
    this.expects("(null as String[]).size").types(((String) null)).finalizedAs(((String) null)).queriedAs("List<String>");
  }
  
  @Test
  public void testImplicitFirstArgument() {
    ExpectationTestingTypeComputer _typeComputer = this.getTypeComputer();
    final Function1<XExpression, Boolean> _function = (XExpression it) -> {
      return Boolean.valueOf(false);
    };
    _typeComputer.setPredicate(_function);
    this.expects("{val it = null as String[] head}");
    final XFeatureCall size = IteratorExtensions.<XFeatureCall>head(Iterators.<XFeatureCall>filter(this.rootExpression.eAllContents(), XFeatureCall.class));
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
    this.expects("newArrayList(\'\', \'\', null as String)").types("Unbound[T]").finalizedAs("String");
  }
  
  @Test
  public void testBug379531_02() {
    ExpectationTestingTypeComputer _typeComputer = this.getTypeComputer();
    final Function1<XExpression, Boolean> _function = (XExpression it) -> {
      return Boolean.valueOf((it instanceof XCastedExpression));
    };
    _typeComputer.setPredicate(_function);
    this.expects("newArrayList(\'\', \'\', null as CharSequence)").types("Unbound[T]").finalizedAs("CharSequence");
  }
  
  @Test
  public void testBug379531_03() {
    this.expects("newArrayList(\'\', \'\', null)").types("Unbound[T]").finalizedAs("String");
  }
  
  @Test
  public void testExpectationFromTypeParameter_01() {
    this.expects("{ val Iterable<Number> iterable = newArrayList(null) }").types("Unbound[T]", "Unbound[T][]").finalizedAs("Number", "Number[]");
  }
  
  @Test
  public void testExpectationFromTypeParameter_02() {
    this.expects("{ val Iterable<Iterable<Number>> iterable = newArrayList(newArrayList(null)) }").types(
      "Unbound[T]", "Unbound[T][]", "Unbound[T]", "Unbound[T][]").finalizedAs("Number", "Number[]", "Iterable<Number>", "Iterable<Number>[]");
  }
}
