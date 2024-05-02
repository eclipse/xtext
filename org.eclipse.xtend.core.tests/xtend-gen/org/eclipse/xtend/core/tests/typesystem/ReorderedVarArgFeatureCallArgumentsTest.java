/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArgumentSlot;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.arguments.ReorderedVarArgFeatureCallArguments;
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
    Assert.assertEquals(2, arguments.getArgumentCount());
    Assert.assertTrue(arguments.hasUnprocessedArguments());
    final IFeatureCallArgumentSlot firstSlot = arguments.getNextUnprocessedArgumentSlot();
    Assert.assertTrue(firstSlot.isVarArg());
    Assert.assertFalse(firstSlot.isSuperfluous());
    XExpression _argumentExpression = firstSlot.getArgumentExpression();
    Assert.assertTrue((_argumentExpression instanceof XNumberLiteral));
    Assert.assertEquals("int", firstSlot.getDeclaredType().getSimpleName());
    Assert.assertFalse(arguments.isProcessed(0));
    firstSlot.markProcessed();
    Assert.assertTrue(arguments.isProcessed(0));
    Assert.assertTrue(arguments.hasUnprocessedArguments());
    final IFeatureCallArgumentSlot secondSlot = arguments.getNextUnprocessedArgumentSlot();
    Assert.assertFalse(secondSlot.isVarArg());
    Assert.assertFalse(secondSlot.isSuperfluous());
    XExpression _argumentExpression_1 = secondSlot.getArgumentExpression();
    Assert.assertTrue((_argumentExpression_1 instanceof XClosure));
    Assert.assertEquals("String", secondSlot.getDeclaredType().getSimpleName());
    Assert.assertFalse(arguments.isProcessed(1));
    secondSlot.markProcessed();
    Assert.assertTrue(arguments.isProcessed(1));
    Assert.assertFalse(arguments.hasUnprocessedArguments());
  }

  @Test
  public void test_02() {
    final IFeatureCallArguments arguments = this.toArgumentsWithReceiver("String s, int i", "[], 1");
    Assert.assertEquals(3, arguments.getArgumentCount());
    Assert.assertTrue(arguments.hasUnprocessedArguments());
    final IFeatureCallArgumentSlot firstSlot = arguments.getNextUnprocessedArgumentSlot();
    Assert.assertTrue(firstSlot.isVarArg());
    Assert.assertFalse(firstSlot.isSuperfluous());
    XExpression _argumentExpression = firstSlot.getArgumentExpression();
    Assert.assertTrue((_argumentExpression instanceof XNumberLiteral));
    Assert.assertEquals("int", firstSlot.getDeclaredType().getSimpleName());
    Assert.assertTrue(arguments.isProcessed(0));
    Assert.assertFalse(arguments.isProcessed(1));
    firstSlot.markProcessed();
    Assert.assertTrue(arguments.isProcessed(1));
    Assert.assertTrue(arguments.hasUnprocessedArguments());
    final IFeatureCallArgumentSlot secondSlot = arguments.getNextUnprocessedArgumentSlot();
    Assert.assertFalse(secondSlot.isVarArg());
    Assert.assertFalse(secondSlot.isSuperfluous());
    XExpression _argumentExpression_1 = secondSlot.getArgumentExpression();
    Assert.assertTrue((_argumentExpression_1 instanceof XClosure));
    Assert.assertEquals("String", secondSlot.getDeclaredType().getSimpleName());
    Assert.assertFalse(arguments.isProcessed(2));
    secondSlot.markProcessed();
    Assert.assertTrue(arguments.isProcessed(2));
    Assert.assertFalse(arguments.hasUnprocessedArguments());
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
    Assert.assertEquals("boolean", secondType.getSimpleName());
    final XExpression third = arguments.getArgument(2);
    Assert.assertTrue((third instanceof XClosure));
    XExpression _expression = ((XClosure) third).getExpression();
    Assert.assertFalse(((XBlockExpression) _expression).getExpressions().isEmpty());
    final LightweightTypeReference thirdType = arguments.getDeclaredTypeForLambda(2);
    Assert.assertEquals("int", thirdType.getSimpleName());
    final XExpression fourth = arguments.getArgument(3);
    Assert.assertTrue((fourth instanceof XBooleanLiteral));
    final LightweightTypeReference fourthType = arguments.getDeclaredTypeForLambda(3);
    Assert.assertEquals("int", fourthType.getSimpleName());
    final XExpression fifth = arguments.getArgument(4);
    Assert.assertTrue((fifth instanceof XClosure));
    XExpression _expression_1 = ((XClosure) fifth).getExpression();
    Assert.assertTrue(((XBlockExpression) _expression_1).getExpressions().isEmpty());
    final LightweightTypeReference fifthType = arguments.getDeclaredTypeForLambda(4);
    Assert.assertEquals("String", fifthType.getSimpleName());
    try {
      arguments.getArgument(5);
      Assert.fail("Expected exception");
    } catch (final Throwable _t) {
      if (_t instanceof IndexOutOfBoundsException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    try {
      arguments.getDeclaredTypeForLambda(5);
      Assert.fail("Expected exception");
    } catch (final Throwable _t) {
      if (_t instanceof IndexOutOfBoundsException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
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
    Assert.assertEquals("boolean", secondType.getSimpleName());
    final XExpression third = arguments.getArgument(2);
    Assert.assertTrue((third instanceof XClosure));
    XExpression _expression = ((XClosure) third).getExpression();
    Assert.assertTrue(((XBlockExpression) _expression).getExpressions().isEmpty());
    final LightweightTypeReference thirdType = arguments.getDeclaredTypeForLambda(2);
    Assert.assertEquals("String", thirdType.getSimpleName());
    try {
      arguments.getArgument(3);
      Assert.fail("Expected exception");
    } catch (final Throwable _t) {
      if (_t instanceof IndexOutOfBoundsException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    try {
      arguments.getDeclaredTypeForLambda(3);
      Assert.fail("Expected exception");
    } catch (final Throwable _t) {
      if (_t instanceof IndexOutOfBoundsException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  protected void withIndizes(final IFeatureCallArguments arguments, final int... indexes) {
    final Consumer<Integer> _function = (Integer it) -> {
      Assert.assertTrue(arguments.hasUnprocessedArguments());
      final IFeatureCallArgumentSlot slot = arguments.getNextUnprocessedArgumentSlot();
      final XExpression expression = IterableExtensions.<XExpression>head(slot.getArgumentExpressions());
      EObject _eContainer = expression.eContainer();
      final XFeatureCall featureCall = ((XFeatureCall) _eContainer);
      Assert.assertEquals((it).intValue(), featureCall.getFeatureCallArguments().indexOf(expression));
      slot.markProcessed();
    };
    ((List<Integer>)Conversions.doWrapArray(indexes)).forEach(_function);
    Assert.assertFalse(arguments.hasUnprocessedArguments());
  }

  protected void withTypes(final IFeatureCallArguments arguments, final String... types) {
    final Consumer<String> _function = (String it) -> {
      Assert.assertTrue(arguments.hasUnprocessedArguments());
      final IFeatureCallArgumentSlot slot = arguments.getNextUnprocessedArgumentSlot();
      Assert.assertEquals(Boolean.valueOf((it == null)), Boolean.valueOf(slot.isSuperfluous()));
      if ((it != null)) {
        Assert.assertEquals(it, slot.getDeclaredType().getSimpleName());
      }
      slot.markProcessed();
    };
    ((List<String>)Conversions.doWrapArray(types)).forEach(_function);
    Assert.assertFalse(arguments.hasUnprocessedArguments());
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
      _builder.append(signature);
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
      XExpression _head = IterableExtensions.<XExpression>head(body.getExpressions());
      final XFeatureCall featureCall = ((XFeatureCall) _head);
      final EList<XExpression> arguments = featureCall.getFeatureCallArguments();
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      final IFeatureCallArguments result = this.factory.createVarArgArguments(arguments, operation.getParameters(), receiver, this.getOwner());
      Class<? extends IFeatureCallArguments> _class = result.getClass();
      boolean _equals = Objects.equals(_class, ReorderedVarArgFeatureCallArguments.class);
      Assert.assertTrue(_equals);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
