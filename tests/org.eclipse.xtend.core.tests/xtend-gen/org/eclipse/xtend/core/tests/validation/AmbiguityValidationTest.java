/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.junit4.internal.LineDelimiters;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
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
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
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
    Resource _eResource = file.eResource();
    final EList<Resource.Diagnostic> errors = _eResource.getErrors();
    String _string = errors.toString();
    int _size = errors.size();
    Assert.assertEquals(_string, 1, _size);
    Resource.Diagnostic _head = IterableExtensions.<Resource.Diagnostic>head(errors);
    final AbstractDiagnostic singleError = ((AbstractDiagnostic) _head);
    String _message = singleError.getMessage();
    String _code = singleError.getCode();
    Assert.assertEquals(_message, IssueCodes.AMBIGUOUS_FEATURE_CALL, _code);
    final Function1<String, String> _function = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        return LineDelimiters.toUnix(it);
      }
    };
    List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(messageParts)), _function);
    for (final String it : _map) {
      {
        final String message = singleError.getMessage();
        boolean _contains = message.contains(it);
        boolean _not = (!_contains);
        if (_not) {
          Assert.assertEquals(it, message);
        }
      }
    }
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration firstType = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    EList<XtendMember> _members = firstType.getMembers();
    XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
    final XtendFunction firstMember = ((XtendFunction) _head_1);
    XExpression _expression = firstMember.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    EList<XExpression> _expressions = block.getExpressions();
    XExpression _last = IterableExtensions.<XExpression>last(_expressions);
    final XAbstractFeatureCall featureCall = ((XAbstractFeatureCall) _last);
    IResolvedTypes _resolveTypes = this._iBatchTypeResolver.resolveTypes(file);
    final IFeatureLinkingCandidate linkingCandidate = _resolveTypes.getLinkingCandidate(featureCall);
    Assert.assertTrue((linkingCandidate instanceof IAmbiguousLinkingCandidate));
  }
  
  protected void assertUnambiguous(final CharSequence contents) {
    final XtendFile file = this.getParsedXtendFile(contents);
    Resource _eResource = file.eResource();
    final EList<Resource.Diagnostic> errors = _eResource.getErrors();
    String _string = errors.toString();
    int _size = errors.size();
    Assert.assertEquals(_string, 0, _size);
    this._validationTestHelper.assertNoErrors(file);
  }
  
  protected XtendFile getParsedXtendFile(final CharSequence contents) {
    try {
      final XtendFile file = this._parseHelper.parse(contents);
      Resource _eResource = file.eResource();
      final EList<Resource.Diagnostic> errors = _eResource.getErrors();
      String _string = errors.toString();
      boolean _isEmpty = errors.isEmpty();
      Assert.assertTrue(_string, _isEmpty);
      EcoreUtil.resolveAll(file);
      return file;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
