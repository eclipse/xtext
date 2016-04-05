/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.typesystem.AbstractTestingTypeReferenceOwner;
import org.eclipse.xtend.core.tests.typesystem.TestableExpressionArgumentFactory;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArgumentSlot;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.arguments.ReorderedVarArgFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ReorderedVarArgFeatureCallArgumentsTest extends AbstractTestingTypeReferenceOwner {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private TestableExpressionArgumentFactory factory;
  
  @Test
  public void test_01() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s, int i", "[], 1");
    int _argumentCount = arguments.getArgumentCount();
    Assert.assertEquals(2, _argumentCount);
    boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
    Assert.assertTrue(_hasUnprocessedArguments);
    final IFeatureCallArgumentSlot firstSlot = arguments.getNextUnprocessedArgumentSlot();
    boolean _isVarArg = firstSlot.isVarArg();
    Assert.assertTrue(_isVarArg);
    boolean _isSuperfluous = firstSlot.isSuperfluous();
    Assert.assertFalse(_isSuperfluous);
    XExpression _argumentExpression = firstSlot.getArgumentExpression();
    Assert.assertTrue((_argumentExpression instanceof XNumberLiteral));
    LightweightTypeReference _declaredType = firstSlot.getDeclaredType();
    String _simpleName = _declaredType.getSimpleName();
    Assert.assertEquals("int", _simpleName);
    boolean _isProcessed = arguments.isProcessed(0);
    Assert.assertFalse(_isProcessed);
    firstSlot.markProcessed();
    boolean _isProcessed_1 = arguments.isProcessed(0);
    Assert.assertTrue(_isProcessed_1);
    boolean _hasUnprocessedArguments_1 = arguments.hasUnprocessedArguments();
    Assert.assertTrue(_hasUnprocessedArguments_1);
    final IFeatureCallArgumentSlot secondSlot = arguments.getNextUnprocessedArgumentSlot();
    boolean _isVarArg_1 = secondSlot.isVarArg();
    Assert.assertFalse(_isVarArg_1);
    boolean _isSuperfluous_1 = secondSlot.isSuperfluous();
    Assert.assertFalse(_isSuperfluous_1);
    XExpression _argumentExpression_1 = secondSlot.getArgumentExpression();
    Assert.assertTrue((_argumentExpression_1 instanceof XClosure));
    LightweightTypeReference _declaredType_1 = secondSlot.getDeclaredType();
    String _simpleName_1 = _declaredType_1.getSimpleName();
    Assert.assertEquals("String", _simpleName_1);
    boolean _isProcessed_2 = arguments.isProcessed(1);
    Assert.assertFalse(_isProcessed_2);
    secondSlot.markProcessed();
    boolean _isProcessed_3 = arguments.isProcessed(1);
    Assert.assertTrue(_isProcessed_3);
    boolean _hasUnprocessedArguments_2 = arguments.hasUnprocessedArguments();
    Assert.assertFalse(_hasUnprocessedArguments_2);
  }
  
  @Test
  public void test_02() {
    final IFeatureCallArguments arguments = this.toArgumentsWithReceiver("String s, int i", "[], 1");
    int _argumentCount = arguments.getArgumentCount();
    Assert.assertEquals(3, _argumentCount);
    boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
    Assert.assertTrue(_hasUnprocessedArguments);
    final IFeatureCallArgumentSlot firstSlot = arguments.getNextUnprocessedArgumentSlot();
    boolean _isVarArg = firstSlot.isVarArg();
    Assert.assertTrue(_isVarArg);
    boolean _isSuperfluous = firstSlot.isSuperfluous();
    Assert.assertFalse(_isSuperfluous);
    XExpression _argumentExpression = firstSlot.getArgumentExpression();
    Assert.assertTrue((_argumentExpression instanceof XNumberLiteral));
    LightweightTypeReference _declaredType = firstSlot.getDeclaredType();
    String _simpleName = _declaredType.getSimpleName();
    Assert.assertEquals("int", _simpleName);
    boolean _isProcessed = arguments.isProcessed(0);
    Assert.assertTrue(_isProcessed);
    boolean _isProcessed_1 = arguments.isProcessed(1);
    Assert.assertFalse(_isProcessed_1);
    firstSlot.markProcessed();
    boolean _isProcessed_2 = arguments.isProcessed(1);
    Assert.assertTrue(_isProcessed_2);
    boolean _hasUnprocessedArguments_1 = arguments.hasUnprocessedArguments();
    Assert.assertTrue(_hasUnprocessedArguments_1);
    final IFeatureCallArgumentSlot secondSlot = arguments.getNextUnprocessedArgumentSlot();
    boolean _isVarArg_1 = secondSlot.isVarArg();
    Assert.assertFalse(_isVarArg_1);
    boolean _isSuperfluous_1 = secondSlot.isSuperfluous();
    Assert.assertFalse(_isSuperfluous_1);
    XExpression _argumentExpression_1 = secondSlot.getArgumentExpression();
    Assert.assertTrue((_argumentExpression_1 instanceof XClosure));
    LightweightTypeReference _declaredType_1 = secondSlot.getDeclaredType();
    String _simpleName_1 = _declaredType_1.getSimpleName();
    Assert.assertEquals("String", _simpleName_1);
    boolean _isProcessed_3 = arguments.isProcessed(2);
    Assert.assertFalse(_isProcessed_3);
    secondSlot.markProcessed();
    boolean _isProcessed_4 = arguments.isProcessed(2);
    Assert.assertTrue(_isProcessed_4);
    boolean _hasUnprocessedArguments_2 = arguments.hasUnprocessedArguments();
    Assert.assertFalse(_hasUnprocessedArguments_2);
  }
  
  @Test
  public void test_03() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s, int i", "[], 1");
    this.withIndizes(arguments, 1, 0);
  }
  
  @Test
  public void test_04() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s, int i, int j, int k, int l, int m", "[], 1, [], 1, []");
    this.withIndizes(arguments, 1, 3, 0, 2, 4);
  }
  
  @Test
  public void test_05() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s, int i, int j, int k", "[], 1, [], 1, [], 1");
    this.withIndizes(arguments, 1, 3, 0, 2);
  }
  
  @Test
  public void test_06() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s, int i, int j", "[], 1, [], 1, [], 1");
    this.withIndizes(arguments, 1, 2, 0);
  }
  
  @Test
  public void test_07() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s, int i, long j, boolean k, float l, double m", "[], 1, [], 1, []");
    this.withTypes(arguments, "int", "boolean", "String", "long", "float");
  }
  
  @Test
  public void test_08() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s, int i, long j, boolean k", "[], 1, [], 1, [], 1");
    this.withTypes(arguments, "int", "boolean", "String", "long");
  }
  
  @Test
  public void test_09() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s, int i, long j", "[], 1, [], 1, [], 1");
    this.withTypes(arguments, "int", "long", "String");
  }
  
  @Test
  public void test_10() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s, int i, int j, int k, int l, int m, int n", "[], 1, [], 1, []");
    this.withIndizes(arguments, 1, 3, 0, 2, 4);
  }
  
  @Test
  public void testBug457779_01() {
    final IFeatureCallArguments arguments = this.toArgumentsWithReceiver("String s, boolean b, int[] i", "[], 1, [1], true");
    final XExpression first = arguments.getArgument(0);
    Assert.assertNull(first);
    final LightweightTypeReference firstType = arguments.getDeclaredTypeForLambda(0);
    Assert.assertNull(firstType);
    final XExpression second = arguments.getArgument(1);
    Assert.assertTrue((second instanceof XNumberLiteral));
    final LightweightTypeReference secondType = arguments.getDeclaredTypeForLambda(1);
    String _simpleName = secondType.getSimpleName();
    Assert.assertEquals("boolean", _simpleName);
    final XExpression third = arguments.getArgument(2);
    Assert.assertTrue((third instanceof XClosure));
    XExpression _expression = ((XClosure) third).getExpression();
    EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
    boolean _isEmpty = _expressions.isEmpty();
    Assert.assertFalse(_isEmpty);
    final LightweightTypeReference thirdType = arguments.getDeclaredTypeForLambda(2);
    String _simpleName_1 = thirdType.getSimpleName();
    Assert.assertEquals("int", _simpleName_1);
    final XExpression fourth = arguments.getArgument(3);
    Assert.assertTrue((fourth instanceof XBooleanLiteral));
    final LightweightTypeReference fourthType = arguments.getDeclaredTypeForLambda(3);
    String _simpleName_2 = fourthType.getSimpleName();
    Assert.assertEquals("int", _simpleName_2);
    final XExpression fifth = arguments.getArgument(4);
    Assert.assertTrue((fifth instanceof XClosure));
    XExpression _expression_1 = ((XClosure) fifth).getExpression();
    EList<XExpression> _expressions_1 = ((XBlockExpression) _expression_1).getExpressions();
    boolean _isEmpty_1 = _expressions_1.isEmpty();
    Assert.assertTrue(_isEmpty_1);
    final LightweightTypeReference fifthType = arguments.getDeclaredTypeForLambda(4);
    String _simpleName_3 = fifthType.getSimpleName();
    Assert.assertEquals("String", _simpleName_3);
    try {
      arguments.getArgument(5);
      Assert.fail("Expected exception");
    } catch (final Throwable _t) {
      if (_t instanceof IndexOutOfBoundsException) {
        final IndexOutOfBoundsException expected = (IndexOutOfBoundsException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    try {
      arguments.getDeclaredTypeForLambda(5);
      Assert.fail("Expected exception");
    } catch (final Throwable _t_1) {
      if (_t_1 instanceof IndexOutOfBoundsException) {
        final IndexOutOfBoundsException expected_1 = (IndexOutOfBoundsException)_t_1;
      } else {
        throw Exceptions.sneakyThrow(_t_1);
      }
    }
  }
  
  @Test
  public void testBug457779_02() {
    final IFeatureCallArguments arguments = this.toArgumentsWithReceiver("String s, boolean b, int[] i", "[], 1");
    final XExpression first = arguments.getArgument(0);
    Assert.assertNull(first);
    final LightweightTypeReference firstType = arguments.getDeclaredTypeForLambda(0);
    Assert.assertNull(firstType);
    final XExpression second = arguments.getArgument(1);
    Assert.assertTrue((second instanceof XNumberLiteral));
    final LightweightTypeReference secondType = arguments.getDeclaredTypeForLambda(1);
    String _simpleName = secondType.getSimpleName();
    Assert.assertEquals("boolean", _simpleName);
    final XExpression third = arguments.getArgument(2);
    Assert.assertTrue((third instanceof XClosure));
    XExpression _expression = ((XClosure) third).getExpression();
    EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
    boolean _isEmpty = _expressions.isEmpty();
    Assert.assertTrue(_isEmpty);
    final LightweightTypeReference thirdType = arguments.getDeclaredTypeForLambda(2);
    String _simpleName_1 = thirdType.getSimpleName();
    Assert.assertEquals("String", _simpleName_1);
    try {
      arguments.getArgument(3);
      Assert.fail("Expected exception");
    } catch (final Throwable _t) {
      if (_t instanceof IndexOutOfBoundsException) {
        final IndexOutOfBoundsException expected = (IndexOutOfBoundsException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    try {
      arguments.getDeclaredTypeForLambda(3);
      Assert.fail("Expected exception");
    } catch (final Throwable _t_1) {
      if (_t_1 instanceof IndexOutOfBoundsException) {
        final IndexOutOfBoundsException expected_1 = (IndexOutOfBoundsException)_t_1;
      } else {
        throw Exceptions.sneakyThrow(_t_1);
      }
    }
  }
  
  protected void withIndizes(final IFeatureCallArguments arguments, final int... indexes) {
    for (final int it : indexes) {
      {
        boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
        Assert.assertTrue(_hasUnprocessedArguments);
        final IFeatureCallArgumentSlot slot = arguments.getNextUnprocessedArgumentSlot();
        List<XExpression> _argumentExpressions = slot.getArgumentExpressions();
        final XExpression expression = IterableExtensions.<XExpression>head(_argumentExpressions);
        EObject _eContainer = expression.eContainer();
        final XFeatureCall featureCall = ((XFeatureCall) _eContainer);
        EList<XExpression> _featureCallArguments = featureCall.getFeatureCallArguments();
        int _indexOf = _featureCallArguments.indexOf(expression);
        Assert.assertEquals(it, _indexOf);
        slot.markProcessed();
      }
    }
    boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
    Assert.assertFalse(_hasUnprocessedArguments);
  }
  
  protected void withTypes(final IFeatureCallArguments arguments, final String... types) {
    for (final String it : types) {
      {
        boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
        Assert.assertTrue(_hasUnprocessedArguments);
        final IFeatureCallArgumentSlot slot = arguments.getNextUnprocessedArgumentSlot();
        boolean _isSuperfluous = slot.isSuperfluous();
        Assert.assertEquals(Boolean.valueOf((it == null)), Boolean.valueOf(_isSuperfluous));
        if ((it != null)) {
          LightweightTypeReference _declaredType = slot.getDeclaredType();
          String _simpleName = _declaredType.getSimpleName();
          Assert.assertEquals(it, _simpleName);
        }
        slot.markProcessed();
      }
    }
    boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
    Assert.assertFalse(_hasUnprocessedArguments);
  }
  
  protected IFeatureCallArguments toArgumentsWithoutReceiver(final String signature, final String invocation) {
    return this.toArguments(signature, invocation, false);
  }
  
  protected IFeatureCallArguments toArgumentsWithReceiver(final String signature, final String invocation) {
    return this.toArguments(signature, invocation, true);
  }
  
  protected IFeatureCallArguments toArguments(final String signature, final String invocation, final boolean receiver) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def void m(");
      _builder.append(signature, "");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("m(");
      _builder.append(invocation, "\t");
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      final String functionString = _builder.toString();
      final XtendFunction function = this.function(functionString);
      XExpression _expression = function.getExpression();
      final XBlockExpression body = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = body.getExpressions();
      XExpression _head = IterableExtensions.<XExpression>head(_expressions);
      final XFeatureCall featureCall = ((XFeatureCall) _head);
      final EList<XExpression> arguments = featureCall.getFeatureCallArguments();
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      EList<JvmFormalParameter> _parameters = operation.getParameters();
      ITypeReferenceOwner _owner = this.getOwner();
      final IFeatureCallArguments result = this.factory.createVarArgArguments(arguments, _parameters, receiver, _owner);
      Class<? extends IFeatureCallArguments> _class = result.getClass();
      boolean _equals = Objects.equal(_class, ReorderedVarArgFeatureCallArguments.class);
      Assert.assertTrue(_equals);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
