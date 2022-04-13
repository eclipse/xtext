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
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
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
    Assert.assertTrue(arguments.hasUnprocessedArguments());
    final IFeatureCallArgumentSlot singleSlot = arguments.getNextUnprocessedArgumentSlot();
    Assert.assertNull(singleSlot.getDeclaredType());
    Assert.assertFalse(singleSlot.isVarArg());
    Assert.assertFalse(singleSlot.isSuperfluous());
    XExpression _argumentExpression = singleSlot.getArgumentExpression();
    Assert.assertTrue((_argumentExpression instanceof XNullLiteral));
    singleSlot.markProcessed();
    Assert.assertFalse(arguments.hasUnprocessedArguments());
  }

  @Test
  public void test_02() {
    final AssignmentFeatureCallArguments arguments = this.toArguments("String s", "\"\"");
    Assert.assertTrue(arguments.hasUnprocessedArguments());
    Assert.assertEquals(1, arguments.getArgumentCount());
    final IFeatureCallArgumentSlot singleSlot = arguments.getNextUnprocessedArgumentSlot();
    Assert.assertEquals("String", singleSlot.getDeclaredType().getSimpleName());
    Assert.assertFalse(singleSlot.isVarArg());
    Assert.assertFalse(singleSlot.isSuperfluous());
    XExpression _argumentExpression = singleSlot.getArgumentExpression();
    Assert.assertTrue((_argumentExpression instanceof XStringLiteral));
    singleSlot.markProcessed();
    Assert.assertFalse(arguments.hasUnprocessedArguments());
  }

  protected AssignmentFeatureCallArguments toArguments(final String type, final String expression) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def void m(");
      _builder.append(type);
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
      final XExpression value = IterableExtensions.<XExpression>head(body.getExpressions());
      JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(this._iXtendJvmAssociations.getDirectlyInferredOperation(function).getParameters());
      JvmTypeReference _parameterType = null;
      if (_head!=null) {
        _parameterType=_head.getParameterType();
      }
      final JvmTypeReference declaredType = _parameterType;
      if ((declaredType != null)) {
        LightweightTypeReference _lightweightTypeReference = this.toLightweightTypeReference(declaredType);
        return new AssignmentFeatureCallArguments(value, _lightweightTypeReference);
      } else {
        return new AssignmentFeatureCallArguments(value, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
