/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.typesystem.AbstractTestingTypeReferenceOwner;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.arguments.AssignmentFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArgumentSlot;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class AssignmentFeatureCallArgumentsTest extends AbstractTestingTypeReferenceOwner {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Test
  public void test_01() {
    final AssignmentFeatureCallArguments arguments = this.toArguments("", "null");
    boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
    Assert.assertTrue(_hasUnprocessedArguments);
    final IFeatureCallArgumentSlot singleSlot = arguments.getNextUnprocessedArgumentSlot();
    LightweightTypeReference _declaredType = singleSlot.getDeclaredType();
    Assert.assertNull(_declaredType);
    boolean _isVarArg = singleSlot.isVarArg();
    Assert.assertFalse(_isVarArg);
    boolean _isSuperfluous = singleSlot.isSuperfluous();
    Assert.assertFalse(_isSuperfluous);
    XExpression _argumentExpression = singleSlot.getArgumentExpression();
    Assert.assertTrue((_argumentExpression instanceof XNullLiteral));
    singleSlot.markProcessed();
    boolean _hasUnprocessedArguments_1 = arguments.hasUnprocessedArguments();
    Assert.assertFalse(_hasUnprocessedArguments_1);
  }
  
  @Test
  public void test_02() {
    final AssignmentFeatureCallArguments arguments = this.toArguments("String s", "\"\"");
    boolean _hasUnprocessedArguments = arguments.hasUnprocessedArguments();
    Assert.assertTrue(_hasUnprocessedArguments);
    int _argumentCount = arguments.getArgumentCount();
    Assert.assertEquals(1, _argumentCount);
    final IFeatureCallArgumentSlot singleSlot = arguments.getNextUnprocessedArgumentSlot();
    LightweightTypeReference _declaredType = singleSlot.getDeclaredType();
    String _simpleName = _declaredType.getSimpleName();
    Assert.assertEquals("String", _simpleName);
    boolean _isVarArg = singleSlot.isVarArg();
    Assert.assertFalse(_isVarArg);
    boolean _isSuperfluous = singleSlot.isSuperfluous();
    Assert.assertFalse(_isSuperfluous);
    XExpression _argumentExpression = singleSlot.getArgumentExpression();
    Assert.assertTrue((_argumentExpression instanceof XStringLiteral));
    singleSlot.markProcessed();
    boolean _hasUnprocessedArguments_1 = arguments.hasUnprocessedArguments();
    Assert.assertFalse(_hasUnprocessedArguments_1);
  }
  
  protected AssignmentFeatureCallArguments toArguments(final String type, final String expression) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def void m(");
      _builder.append(type, "");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(expression, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      final String functionString = _builder.toString();
      final XtendFunction function = this.function(functionString);
      XExpression _expression = function.getExpression();
      final XBlockExpression body = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = body.getExpressions();
      final XExpression value = IterableExtensions.<XExpression>head(_expressions);
      JvmOperation _directlyInferredOperation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      EList<JvmFormalParameter> _parameters = _directlyInferredOperation.getParameters();
      JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(_parameters);
      JvmTypeReference _parameterType = null;
      if (_head!=null) {
        _parameterType=_head.getParameterType();
      }
      final JvmTypeReference declaredType = _parameterType;
      boolean _tripleNotEquals = (declaredType != null);
      if (_tripleNotEquals) {
        OwnedConverter _ownedConverter = new OwnedConverter(this);
        final OwnedConverter converter = _ownedConverter;
        LightweightTypeReference _lightweightReference = converter.toLightweightReference(declaredType);
        AssignmentFeatureCallArguments _assignmentFeatureCallArguments = new AssignmentFeatureCallArguments(value, _lightweightReference);
        return _assignmentFeatureCallArguments;
      } else {
        AssignmentFeatureCallArguments _assignmentFeatureCallArguments_1 = new AssignmentFeatureCallArguments(value, null);
        return _assignmentFeatureCallArguments_1;
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
