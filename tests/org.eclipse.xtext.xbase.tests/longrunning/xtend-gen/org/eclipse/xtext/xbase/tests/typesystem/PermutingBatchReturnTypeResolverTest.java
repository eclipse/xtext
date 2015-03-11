/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.typesystem.BatchReturnTypeResolverTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
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
      Resource _eResource = xExpression.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _string = _errors.toString();
      Resource _eResource_1 = xExpression.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_string, _isEmpty);
      Resource _eResource_2 = xExpression.eResource();
      EList<Resource.Diagnostic> _warnings = _eResource_2.getWarnings();
      String _string_1 = _warnings.toString();
      Resource _eResource_3 = xExpression.eResource();
      EList<Resource.Diagnostic> _warnings_1 = _eResource_3.getWarnings();
      boolean _isEmpty_1 = _warnings_1.isEmpty();
      Assert.assertTrue(_string_1, _isEmpty_1);
      boolean _hasReturnExpression = this.hasReturnExpression(xExpression);
      boolean _not = (!_hasReturnExpression);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("return (");
        _builder.append(replacedExpressionText, "");
        _builder.append(")");
        this.doResolvesTo(_builder.toString(), type);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("{ { return (");
        _builder_1.append(replacedExpressionText, "");
        _builder_1.append(") } }");
        this.doResolvesTo(_builder_1.toString(), type);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("return {");
        _builder_2.append(replacedExpressionText, "");
        _builder_2.append("}");
        this.doResolvesTo(_builder_2.toString(), type);
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("{ { return { ( if (true) ");
        _builder_3.append(replacedExpressionText, "");
        _builder_3.append(" ) {");
        _builder_3.append(replacedExpressionText, "");
        _builder_3.append("} }");
        this.doResolvesTo(_builder_3.toString(), type);
      } else {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("{ ");
        _builder_4.append(replacedExpressionText, "");
        _builder_4.append(" }");
        this.doResolvesTo(_builder_4.toString(), type);
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("{ ( if (true) ");
        _builder_5.append(replacedExpressionText, "");
        _builder_5.append(" ) {");
        _builder_5.append(replacedExpressionText, "");
        _builder_5.append("} }");
        this.doResolvesTo(_builder_5.toString(), type);
      }
      IBatchTypeResolver _typeResolver = this.getTypeResolver();
      final IResolvedTypes resolvedTypes = _typeResolver.resolveTypes(xExpression);
      final LightweightTypeReference resolvedType = resolvedTypes.getReturnType(xExpression);
      String _simpleName = resolvedType.getSimpleName();
      Assert.assertEquals(replacedExpressionText, type, _simpleName);
      Resource _eResource_4 = xExpression.eResource();
      Iterable<Resource.Diagnostic> _linkingAndSyntaxErrors = this.getLinkingAndSyntaxErrors(_eResource_4);
      String _string_2 = _linkingAndSyntaxErrors.toString();
      Resource _eResource_5 = xExpression.eResource();
      Iterable<Resource.Diagnostic> _linkingAndSyntaxErrors_1 = this.getLinkingAndSyntaxErrors(_eResource_5);
      boolean _isEmpty_2 = IterableExtensions.isEmpty(_linkingAndSyntaxErrors_1);
      Assert.assertTrue(_string_2, _isEmpty_2);
      Resource _eResource_6 = xExpression.eResource();
      EList<Resource.Diagnostic> _warnings_2 = _eResource_6.getWarnings();
      String _string_3 = _warnings_2.toString();
      Resource _eResource_7 = xExpression.eResource();
      EList<Resource.Diagnostic> _warnings_3 = _eResource_7.getWarnings();
      boolean _isEmpty_3 = _warnings_3.isEmpty();
      Assert.assertTrue(_string_3, _isEmpty_3);
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
