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
import java.util.NoSuchElementException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.typesystem.AbstractTestingTypeReferenceOwner;
import org.eclipse.xtend.core.tests.typesystem.TestableExpressionArgumentFactory;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArgumentSlot;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.arguments.StandardFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class StandardFeatureCallArgumentsTest extends AbstractTestingTypeReferenceOwner {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private TestableExpressionArgumentFactory factory;
  
  @Test
  public void test_01() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("", "");
    boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
    Assert.assertFalse(_hasUnprocessedArguments);
    int _argumentCount = arguments.getArgumentCount();
    Assert.assertEquals(0, _argumentCount);
  }
  
  @Test(expected = NoSuchElementException.class)
  public void test_02() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("", "");
    arguments.getNextUnprocessedArgumentSlot();
  }
  
  @Test
  public void test_03() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s", "\"\"");
    boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
    Assert.assertTrue(_hasUnprocessedArguments);
    int _argumentCount = arguments.getArgumentCount();
    Assert.assertEquals(1, _argumentCount);
    final IFeatureCallArgumentSlot singleSlot = arguments.getNextUnprocessedArgumentSlot();
    boolean _isVarArg = singleSlot.isVarArg();
    Assert.assertFalse(_isVarArg);
    boolean _isSuperfluous = singleSlot.isSuperfluous();
    Assert.assertFalse(_isSuperfluous);
    XExpression _argumentExpression = singleSlot.getArgumentExpression();
    Assert.assertTrue((_argumentExpression instanceof XStringLiteral));
    LightweightTypeReference _declaredType = singleSlot.getDeclaredType();
    String _simpleName = _declaredType.getSimpleName();
    Assert.assertEquals("String", _simpleName);
    singleSlot.markProcessed();
    boolean _hasUnprocessedArguments_1 = arguments.hasUnprocessedArguments();
    Assert.assertFalse(_hasUnprocessedArguments_1);
  }
  
  @Test
  public void test_04() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s, int i", "\"\", 1");
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
    Assert.assertTrue((_argumentExpression instanceof XStringLiteral));
    LightweightTypeReference _declaredType = firstSlot.getDeclaredType();
    String _simpleName = _declaredType.getSimpleName();
    Assert.assertEquals("String", _simpleName);
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
    Assert.assertTrue((_argumentExpression_1 instanceof XNumberLiteral));
    LightweightTypeReference _declaredType_1 = secondSlot.getDeclaredType();
    String _simpleName_1 = _declaredType_1.getSimpleName();
    Assert.assertEquals("int", _simpleName_1);
    boolean _isProcessed_2 = arguments.isProcessed(1);
    Assert.assertFalse(_isProcessed_2);
    secondSlot.markProcessed();
    boolean _isProcessed_3 = arguments.isProcessed(1);
    Assert.assertTrue(_isProcessed_3);
    boolean _hasUnprocessedArguments_2 = arguments.hasUnprocessedArguments();
    Assert.assertFalse(_hasUnprocessedArguments_2);
  }
  
  @Test
  public void test_05() {
    final IFeatureCallArguments arguments = this.toArgumentsWithReceiver("", "");
    boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
    Assert.assertFalse(_hasUnprocessedArguments);
    int _argumentCount = arguments.getArgumentCount();
    Assert.assertEquals(1, _argumentCount);
  }
  
  @Test(expected = NoSuchElementException.class)
  public void test_06() {
    final IFeatureCallArguments arguments = this.toArgumentsWithReceiver("", "");
    arguments.getNextUnprocessedArgumentSlot();
  }
  
  @Test
  public void test_08() {
    final IFeatureCallArguments arguments = this.toArgumentsWithReceiver("String s, int i", "\"\", 1");
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
    Assert.assertTrue((_argumentExpression instanceof XStringLiteral));
    LightweightTypeReference _declaredType = firstSlot.getDeclaredType();
    String _simpleName = _declaredType.getSimpleName();
    Assert.assertEquals("String", _simpleName);
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
    Assert.assertTrue((_argumentExpression_1 instanceof XNumberLiteral));
    LightweightTypeReference _declaredType_1 = secondSlot.getDeclaredType();
    String _simpleName_1 = _declaredType_1.getSimpleName();
    Assert.assertEquals("int", _simpleName_1);
    boolean _isProcessed_3 = arguments.isProcessed(2);
    Assert.assertFalse(_isProcessed_3);
    secondSlot.markProcessed();
    boolean _isProcessed_4 = arguments.isProcessed(2);
    Assert.assertTrue(_isProcessed_4);
    boolean _hasUnprocessedArguments_2 = arguments.hasUnprocessedArguments();
    Assert.assertFalse(_hasUnprocessedArguments_2);
  }
  
  @Test
  public void test_09() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s", "\"\", 1");
    boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
    Assert.assertTrue(_hasUnprocessedArguments);
    int _argumentCount = arguments.getArgumentCount();
    Assert.assertEquals(2, _argumentCount);
    final IFeatureCallArgumentSlot valid = arguments.getNextUnprocessedArgumentSlot();
    boolean _isVarArg = valid.isVarArg();
    Assert.assertFalse(_isVarArg);
    boolean _isSuperfluous = valid.isSuperfluous();
    Assert.assertFalse(_isSuperfluous);
    XExpression _argumentExpression = valid.getArgumentExpression();
    Assert.assertTrue((_argumentExpression instanceof XStringLiteral));
    LightweightTypeReference _declaredType = valid.getDeclaredType();
    String _simpleName = _declaredType.getSimpleName();
    Assert.assertEquals("String", _simpleName);
    valid.markProcessed();
    boolean _hasUnprocessedArguments_1 = arguments.hasUnprocessedArguments();
    Assert.assertTrue(_hasUnprocessedArguments_1);
    final IFeatureCallArgumentSlot superfluous = arguments.getNextUnprocessedArgumentSlot();
    boolean _isVarArg_1 = superfluous.isVarArg();
    Assert.assertFalse(_isVarArg_1);
    boolean _isSuperfluous_1 = superfluous.isSuperfluous();
    Assert.assertTrue(_isSuperfluous_1);
    XExpression _argumentExpression_1 = superfluous.getArgumentExpression();
    Assert.assertTrue((_argumentExpression_1 instanceof XNumberLiteral));
    boolean _isProcessed = arguments.isProcessed(1);
    Assert.assertFalse(_isProcessed);
    superfluous.markProcessed();
    boolean _isProcessed_1 = arguments.isProcessed(1);
    Assert.assertTrue(_isProcessed_1);
    boolean _hasUnprocessedArguments_2 = arguments.hasUnprocessedArguments();
    Assert.assertFalse(_hasUnprocessedArguments_2);
  }
  
  @Test
  public void test_10() {
    final IFeatureCallArguments arguments = this.toArgumentsWithReceiver("String s", "\"\", 1");
    boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
    Assert.assertTrue(_hasUnprocessedArguments);
    int _argumentCount = arguments.getArgumentCount();
    Assert.assertEquals(3, _argumentCount);
    final IFeatureCallArgumentSlot valid = arguments.getNextUnprocessedArgumentSlot();
    boolean _isVarArg = valid.isVarArg();
    Assert.assertFalse(_isVarArg);
    boolean _isSuperfluous = valid.isSuperfluous();
    Assert.assertFalse(_isSuperfluous);
    XExpression _argumentExpression = valid.getArgumentExpression();
    Assert.assertTrue((_argumentExpression instanceof XStringLiteral));
    valid.markProcessed();
    boolean _hasUnprocessedArguments_1 = arguments.hasUnprocessedArguments();
    Assert.assertTrue(_hasUnprocessedArguments_1);
    boolean _isProcessed = arguments.isProcessed(1);
    Assert.assertTrue(_isProcessed);
    final IFeatureCallArgumentSlot superfluous = arguments.getNextUnprocessedArgumentSlot();
    boolean _isVarArg_1 = superfluous.isVarArg();
    Assert.assertFalse(_isVarArg_1);
    boolean _isSuperfluous_1 = superfluous.isSuperfluous();
    Assert.assertTrue(_isSuperfluous_1);
    XExpression _argumentExpression_1 = superfluous.getArgumentExpression();
    Assert.assertTrue((_argumentExpression_1 instanceof XNumberLiteral));
    boolean _isProcessed_1 = arguments.isProcessed(2);
    Assert.assertFalse(_isProcessed_1);
    superfluous.markProcessed();
    boolean _isProcessed_2 = arguments.isProcessed(2);
    Assert.assertTrue(_isProcessed_2);
    boolean _hasUnprocessedArguments_2 = arguments.hasUnprocessedArguments();
    Assert.assertFalse(_hasUnprocessedArguments_2);
  }
  
  @Test
  public void test_11() {
    final IFeatureCallArguments arguments = this.toArgumentsWithoutReceiver("String s", "");
    boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
    Assert.assertFalse(_hasUnprocessedArguments);
  }
  
  @Test
  public void test_12() {
    this.toArgumentsWithoutReceiver("String s, int i", "\"\", []");
    this.toArgumentsWithReceiver("String s, int i", "\"\", [], []");
  }
  
  @Test
  public void test_13() {
    this.toArgumentsWithoutReceiver("String s, int i", "[]");
    this.toArgumentsWithReceiver("String s, int i", "[], [], []");
  }
  
  @Test
  public void test_14() {
    this.toArgumentsWithoutReceiver("String s, int i", "[]");
    this.toArgumentsWithReceiver("String s, int i", "[], [], 1");
    this.toArgumentsWithReceiver("String s", "[], 1, 1");
  }
  
  protected IFeatureCallArguments toArgumentsWithoutReceiver(final String signature, final String invocation) {
    IFeatureCallArguments _arguments = this.toArguments(signature, invocation, false);
    return _arguments;
  }
  
  protected IFeatureCallArguments toArgumentsWithReceiver(final String signature, final String invocation) {
    IFeatureCallArguments _arguments = this.toArguments(signature, invocation, true);
    return _arguments;
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
      boolean _equals = Objects.equal(_class, StandardFeatureCallArguments.class);
      Assert.assertTrue(_equals);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
