/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.ExpectationTestingTypeComputer;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseNewTypeSystemInjectorProvider.class)
@SuppressWarnings("all")
public class ExpectationTest extends AbstractXbaseTestCase {
  @Inject
  private PublicReentrantTypeResolver resolver;
  
  @Inject
  private ExpectationTestingTypeComputer typeComputer;
  
  private List<String> expectations;
  
  private List<ITypeExpectation> finalExpectations;
  
  private boolean pendingAssert = false;
  
  public ExpectationTest expects(final String input) {
    try {
      final XExpression expression = this.expression(input, false);
      this.resolver.initializeFrom(expression);
      this.resolver.reentrantResolve();
      this.pendingAssert = true;
      return this;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ExpectationTest types(final String... names) {
    Assert.assertTrue(this.pendingAssert);
    this.pendingAssert = false;
    String _string = this.expectations.toString();
    int _size = ((List<String>)Conversions.doWrapArray(names)).size();
    int _size_1 = this.expectations.size();
    Assert.assertEquals(_string, _size, _size_1);
    Set<String> _set = IterableExtensions.<String>toSet(((Iterable<? extends String>)Conversions.doWrapArray(names)));
    Set<String> _set_1 = IterableExtensions.<String>toSet(this.expectations);
    Assert.assertEquals(((Object) _set), _set_1);
    return this;
  }
  
  public ExpectationTest finalizedAs(final String... names) {
    Assert.assertFalse(this.pendingAssert);
    final Function1<ITypeExpectation,String> _function = new Function1<ITypeExpectation,String>() {
        public String apply(final ITypeExpectation it) {
          LightweightTypeReference _expectedType = it.getExpectedType();
          String _simpleName = _expectedType==null?(String)null:_expectedType.getSimpleName();
          return _simpleName;
        }
      };
    List<String> _map = ListExtensions.<ITypeExpectation, String>map(this.finalExpectations, _function);
    String _string = _map.toString();
    int _size = ((List<String>)Conversions.doWrapArray(names)).size();
    int _size_1 = this.expectations.size();
    Assert.assertEquals(_string, _size, _size_1);
    Set<String> _set = IterableExtensions.<String>toSet(((Iterable<? extends String>)Conversions.doWrapArray(names)));
    final Function1<ITypeExpectation,String> _function_1 = new Function1<ITypeExpectation,String>() {
        public String apply(final ITypeExpectation it) {
          LightweightTypeReference _expectedType = it.getExpectedType();
          String _simpleName = _expectedType==null?(String)null:_expectedType.getSimpleName();
          return _simpleName;
        }
      };
    List<String> _map_1 = ListExtensions.<ITypeExpectation, String>map(this.finalExpectations, _function_1);
    Set<String> _set_1 = IterableExtensions.<String>toSet(_map_1);
    Assert.assertEquals(((Object) _set), _set_1);
    return this;
  }
  
  public ExpectationTest nothing() {
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
  
  public ExpectationTest notVoid() {
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
    this.typeComputer.setTest(this);
    this.pendingAssert = false;
    this.resolver.setTypeComputer(this.typeComputer);
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    this.expectations = _newArrayList;
    ArrayList<ITypeExpectation> _newArrayList_1 = CollectionLiterals.<ITypeExpectation>newArrayList();
    this.finalExpectations = _newArrayList_1;
  }
  
  @After
  public void tearDown() throws Exception {
    Assert.assertFalse(this.pendingAssert);
    this.pendingAssert = false;
    this.expectations = null;
    this.finalExpectations = null;
    this.typeComputer.setTest(null);
    this.resolver.setTypeComputer(null);
  }
  
  public void recordExpectation(final ITypeComputationState state) {
    List<? extends ITypeExpectation> _expectations = state.getExpectations();
    Iterables.<ITypeExpectation>addAll(this.finalExpectations, _expectations);
    List<? extends ITypeExpectation> _expectations_1 = state.getExpectations();
    final Function1<ITypeExpectation,String> _function = new Function1<ITypeExpectation,String>() {
        public String apply(final ITypeExpectation it) {
          LightweightTypeReference _expectedType = it.getExpectedType();
          String _simpleName = _expectedType==null?(String)null:_expectedType.getSimpleName();
          return _simpleName;
        }
      };
    List<String> _map = ListExtensions.map(_expectations_1, _function);
    Iterables.<String>addAll(this.expectations, _map);
  }
  
  @Test
  public void testIfCondition() {
    ExpectationTest _expects = this.expects("if (null) true");
    _expects.types("boolean");
  }
  
  @Test
  public void testNotLastExpressionInBlock() {
    ExpectationTest _expects = this.expects("{ null true }");
    _expects.nothing();
  }
  
  @Test
  public void testSwitchValue() {
    ExpectationTest _expects = this.expects("switch null case true: true");
    _expects.notVoid();
  }
  
  @Test
  public void testAssignment_01() {
    ExpectationTest _expects = this.expects("{ val String s = null }");
    _expects.types("String");
  }
  
  @Test
  public void testAssignment_02() {
    ExpectationTest _expects = this.expects("{ val String s; s = null }");
    _expects.types("String");
  }
  
  @Test
  public void testTransitiveAssignment() {
    ExpectationTest _expects = this.expects("{ val StringBuilder s = if (true) null }");
    _expects.types("StringBuilder");
  }
  
  @Test
  public void testFeatureCallArgument_01() {
    ExpectationTest _expects = this.expects("\'\'.substring(null)");
    _expects.types("int");
  }
  
  @Test
  public void testFeatureCallArgument_02() {
    ExpectationTest _expects = this.expects("newArrayList.<String>findFirst(null)");
    ExpectationTest _types = _expects.types("Function1<? super String, Boolean>");
    _types.finalizedAs("Function1<? super String, Boolean>");
  }
  
  @Test
  public void testFeatureCallArgument_03() {
    ExpectationTest _expects = this.expects("newArrayList.findFirst(null)");
    ExpectationTest _types = _expects.types("Function1<? super Unbound[T], Boolean>");
    _types.finalizedAs("Function1<? super Object, Boolean>");
  }
  
  @Test
  public void testFeatureCallArgument_04() {
    ExpectationTest _expects = this.expects("<String>newArrayList.findFirst(null)");
    ExpectationTest _types = _expects.types("Function1<? super Unbound[T], Boolean>");
    _types.finalizedAs("Function1<? super String, Boolean>");
  }
  
  @Test
  public void testFeatureCallArgument_05() {
    ExpectationTest _expects = this.expects("newArrayList(\'\').findFirst(null)");
    ExpectationTest _types = _expects.types("Function1<? super Unbound[T], Boolean>");
    _types.finalizedAs("Function1<? super String, Boolean>");
  }
  
  @Test
  public void testFeatureCallArgument_06() {
    ExpectationTest _expects = this.expects("{\n\t\t\tval (Iterable<CharSequence>)=>void f\n\t\t\tf.apply(null)\n\t\t}");
    ExpectationTest _types = _expects.types("Iterable<CharSequence>");
    _types.finalizedAs("Iterable<CharSequence>");
  }
  
  @Test
  @Ignore(value = "TODO null type is bound differently")
  public void testExtensionReceiver_01() {
    ExpectationTest _expects = this.expects("null.isNullOrEmpty()");
    _expects.types("String", "Iterable<Unbound[T]>");
  }
  
  @Test
  public void testFeatureCallVarArgument_01() {
    ExpectationTest _expects = this.expects("newArrayList(null)");
    ExpectationTest _types = _expects.types("Unbound[T]", "Unbound[T][]");
    _types.finalizedAs("Object", "Object[]");
  }
  
  @Test
  public void testFeatureCallVarArgument_02() {
    ExpectationTest _expects = this.expects("newArrayList(null, \'\')");
    ExpectationTest _types = _expects.types("Unbound[T]");
    _types.finalizedAs("String");
  }
  
  @Test
  public void testFeatureCallVarArgument_03() {
    ExpectationTest _expects = this.expects("{ val Iterable<String> iterable = newArrayList(null) }");
    ExpectationTest _types = _expects.types("Unbound[T][]", "Unbound[T]");
    _types.finalizedAs("String[]", "String");
  }
  
  @Test
  public void testForLoop_01() {
    ExpectationTest _expects = this.expects("for(int x: null) {}");
    ExpectationTest _types = _expects.types("int[]");
    _types.finalizedAs("int[]");
  }
  
  @Test
  public void testUpperBound_01() {
    ExpectationTest _expects = this.expects("(1 as Comparable<?>).compareTo(null)");
    ExpectationTest _types = _expects.types("null");
    _types.finalizedAs("null");
  }
  
  @Test
  public void testLowerBound_01() {
    ExpectationTest _expects = this.expects("(1 as Comparable<? super CharSequence>).compareTo(null)");
    ExpectationTest _types = _expects.types("CharSequence");
    _types.finalizedAs("CharSequence");
  }
}
