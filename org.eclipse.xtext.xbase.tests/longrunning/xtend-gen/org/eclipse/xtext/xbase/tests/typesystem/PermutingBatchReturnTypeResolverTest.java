/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.typesystem.BatchReturnTypeResolverTest;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class PermutingBatchReturnTypeResolverTest extends BatchReturnTypeResolverTest {
  @Override
  public LightweightTypeReference resolvesTo(final String expression, final String type) {
    try {
      final String replacedExpressionText = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
      final XExpression xExpression = this.expression(replacedExpressionText, false);
      Assert.assertTrue(xExpression.eResource().getErrors().toString(), xExpression.eResource().getErrors().isEmpty());
      Assert.assertTrue(xExpression.eResource().getWarnings().toString(), xExpression.eResource().getWarnings().isEmpty());
      boolean _hasReturnExpression = this.hasReturnExpression(xExpression);
      boolean _not = (!_hasReturnExpression);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("return (");
        _builder.append(replacedExpressionText);
        _builder.append(")");
        this.doResolvesTo(_builder.toString(), type);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("{ { return (");
        _builder_1.append(replacedExpressionText);
        _builder_1.append(") } }");
        this.doResolvesTo(_builder_1.toString(), type);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("return {");
        _builder_2.append(replacedExpressionText);
        _builder_2.append("}");
        this.doResolvesTo(_builder_2.toString(), type);
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("{ { return { ( if (true) ");
        _builder_3.append(replacedExpressionText);
        _builder_3.append(" ) {");
        _builder_3.append(replacedExpressionText);
        _builder_3.append("} }");
        this.doResolvesTo(_builder_3.toString(), type);
      } else {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("{ ");
        _builder_4.append(replacedExpressionText);
        _builder_4.append(" }");
        this.doResolvesTo(_builder_4.toString(), type);
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("{ ( if (true) ");
        _builder_5.append(replacedExpressionText);
        _builder_5.append(" ) {");
        _builder_5.append(replacedExpressionText);
        _builder_5.append("} }");
        this.doResolvesTo(_builder_5.toString(), type);
      }
      final IResolvedTypes resolvedTypes = this.getTypeResolver().resolveTypes(xExpression);
      final LightweightTypeReference resolvedType = resolvedTypes.getReturnType(xExpression);
      Assert.assertEquals(replacedExpressionText, type, resolvedType.getSimpleName());
      Assert.assertTrue(this.getLinkingAndSyntaxErrors(xExpression.eResource()).toString(), IterableExtensions.isEmpty(this.getLinkingAndSyntaxErrors(xExpression.eResource())));
      Assert.assertTrue(xExpression.eResource().getWarnings().toString(), xExpression.eResource().getWarnings().isEmpty());
      return resolvedType;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testIfExpression_27() throws Exception {
    this.resolvesTo("return if (true) while(false) (\'a\'+\'b\').length", "null");
  }
  
  @Test
  @Override
  public void testSwitchExpression_11() throws Exception {
    this.resolvesTo("return switch null {\n\t\t  Object : return \n\t\t}", "void");
  }
}
