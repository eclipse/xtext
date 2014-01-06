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
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArgumentSlot;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.arguments.ReorderedFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ReorderedFeatureCallArgumentsTest extends AbstractTestingTypeReferenceOwner {
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
    Assert.assertFalse(_isVarArg);
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
    Assert.assertFalse(_isVarArg);
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
    this.withIndizes(arguments, 1, 3, 0, 2, 4, 5);
  }
  
  @Test
  public void test_06() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s, int i, int j", "[], 1, [], 1, [], 1");
    this.withIndizes(arguments, 1, 0, 2, 3, 4, 5);
  }
  
  @Test
  public void test_07() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s, int i, long j, boolean k, float l, double m", "[], 1, [], 1, []");
    this.withTypes(arguments, "int", "boolean", "String", "long", "float");
  }
  
  @Test
  public void test_08() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s, int i, long j, boolean k", "[], 1, [], 1, [], 1");
    this.withTypes(arguments, "int", "boolean", "String", "long", null, null);
  }
  
  @Test
  public void test_09() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s, int i, long j", "[], 1, [], 1, [], 1");
    this.withTypes(arguments, "int", "String", "long", null, null, null);
  }
  
  protected void withIndizes(final IFeatureCallArguments arguments, final int... indexes) {
    final Procedure1<Integer> _function = new Procedure1<Integer>() {
      public void apply(final Integer it) {
        boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
        Assert.assertTrue(_hasUnprocessedArguments);
        final IFeatureCallArgumentSlot slot = arguments.getNextUnprocessedArgumentSlot();
        final XExpression expression = slot.getArgumentExpression();
        EObject _eContainer = expression.eContainer();
        final XFeatureCall featureCall = ((XFeatureCall) _eContainer);
        EList<XExpression> _featureCallArguments = featureCall.getFeatureCallArguments();
        int _indexOf = _featureCallArguments.indexOf(expression);
        Assert.assertEquals((it).intValue(), _indexOf);
        slot.markProcessed();
      }
    };
    IterableExtensions.<Integer>forEach(((Iterable<Integer>)Conversions.doWrapArray(indexes)), _function);
    boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
    Assert.assertFalse(_hasUnprocessedArguments);
  }
  
  protected void withTypes(final IFeatureCallArguments arguments, final String... types) {
    final Procedure1<String> _function = new Procedure1<String>() {
      public void apply(final String it) {
        boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
        Assert.assertTrue(_hasUnprocessedArguments);
        final IFeatureCallArgumentSlot slot = arguments.getNextUnprocessedArgumentSlot();
        boolean _tripleEquals = (it == null);
        boolean _isSuperfluous = slot.isSuperfluous();
        Assert.assertEquals(Boolean.valueOf(_tripleEquals), Boolean.valueOf(_isSuperfluous));
        boolean _tripleNotEquals = (it != null);
        if (_tripleNotEquals) {
          LightweightTypeReference _declaredType = slot.getDeclaredType();
          String _simpleName = _declaredType.getSimpleName();
          Assert.assertEquals(it, _simpleName);
        }
        slot.markProcessed();
      }
    };
    IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(types)), _function);
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
      OwnedConverter _ownedConverter = new OwnedConverter(this);
      final IFeatureCallArguments result = this.factory.createStandardArguments(arguments, _parameters, receiver, _ownedConverter);
      Class<? extends IFeatureCallArguments> _class = result.getClass();
      boolean _equals = Objects.equal(_class, ReorderedFeatureCallArguments.class);
      Assert.assertTrue(_equals);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
