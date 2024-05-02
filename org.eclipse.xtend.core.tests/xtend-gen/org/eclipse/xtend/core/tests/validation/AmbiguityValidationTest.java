/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IAmbiguousLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Assert;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AmbiguityValidationTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  protected ParseHelper<XtendFile> _parseHelper;

  @Inject
  @Extension
  protected IBatchTypeResolver _iBatchTypeResolver;

  @Inject
  @Extension
  protected ValidationTestHelper _validationTestHelper;

  protected void assertAmbiguous(final CharSequence contents, final String... messageParts) {
    final XtendFile file = this.getParsedXtendFile(contents);
    final EList<Resource.Diagnostic> errors = file.eResource().getErrors();
    Assert.assertEquals(errors.toString(), 1, errors.size());
    Resource.Diagnostic _head = IterableExtensions.<Resource.Diagnostic>head(errors);
    final AbstractDiagnostic singleError = ((AbstractDiagnostic) _head);
    Assert.assertEquals(singleError.getMessage(), IssueCodes.AMBIGUOUS_FEATURE_CALL, singleError.getCode());
    final Function1<String, String> _function = (String it) -> {
      return Strings.toUnixLineSeparator(it);
    };
    final Consumer<String> _function_1 = (String it) -> {
      final String message = singleError.getMessage();
      boolean _contains = message.contains(it);
      boolean _not = (!_contains);
      if (_not) {
        Assert.assertEquals(it, message);
      }
    };
    ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(messageParts)), _function).forEach(_function_1);
    final XtendTypeDeclaration firstType = IterableExtensions.<XtendTypeDeclaration>head(file.getXtendTypes());
    XtendMember _head_1 = IterableExtensions.<XtendMember>head(firstType.getMembers());
    final XtendFunction firstMember = ((XtendFunction) _head_1);
    XExpression _expression = firstMember.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    final IResolvedTypes resolvedTypes = this._iBatchTypeResolver.resolveTypes(file);
    ILinkingCandidate _switchResult = null;
    XExpression _lastOrNull = IterableExtensions.<XExpression>lastOrNull(block.getExpressions());
    final XExpression featureOrConstructorCall = _lastOrNull;
    boolean _matched = false;
    if (featureOrConstructorCall instanceof XAbstractFeatureCall) {
      _matched=true;
      _switchResult = resolvedTypes.getLinkingCandidate(((XAbstractFeatureCall)featureOrConstructorCall));
    }
    if (!_matched) {
      if (featureOrConstructorCall instanceof XConstructorCall) {
        _matched=true;
        _switchResult = resolvedTypes.getLinkingCandidate(((XConstructorCall)featureOrConstructorCall));
      }
    }
    if (!_matched) {
      String _valueOf = String.valueOf(featureOrConstructorCall.eClass().getName());
      throw new IllegalArgumentException(_valueOf);
    }
    final ILinkingCandidate linkingCandidate = _switchResult;
    Assert.assertTrue((linkingCandidate instanceof IAmbiguousLinkingCandidate));
  }

  protected void assertUnambiguous(final CharSequence contents) {
    final XtendFile file = this.getParsedXtendFile(contents);
    final EList<Resource.Diagnostic> errors = file.eResource().getErrors();
    Assert.assertEquals(errors.toString(), 0, errors.size());
    this._validationTestHelper.assertNoErrors(file);
  }

  protected XtendFile getParsedXtendFile(final CharSequence contents) {
    try {
      final XtendFile file = this._parseHelper.parse(contents);
      final EList<Resource.Diagnostic> errors = file.eResource().getErrors();
      Assert.assertTrue(errors.toString(), errors.isEmpty());
      EcoreUtil.resolveAll(file);
      return file;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
