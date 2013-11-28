/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.linking;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.override.BottomResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideTester;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.junit.Assert;
import org.junit.Test;

/**
 * Use a copy of org.junit.Assert as test data
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractOverloadedInstanceMethodTest extends AbstractXtendTestCase {
  @Inject
  private OverrideTester overrideTester;
  
  @Inject
  private CommonTypeComputationServices services;
  
  protected void linksTo(final String invocation, final String method) {
    try {
      String _inMethodBody = this.inMethodBody(invocation);
      final XtendFile file = this.file(_inMethodBody, false);
      EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      final XtendClass c = ((XtendClass) _head);
      EList<XtendMember> _members = c.getMembers();
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
      final XtendFunction m = ((XtendFunction) _head_1);
      XExpression _expression = m.getExpression();
      final XBlockExpression body = ((XBlockExpression) _expression);
      EList<XExpression> _expressions = body.getExpressions();
      XExpression _last = IterableExtensions.<XExpression>last(_expressions);
      final XAbstractFeatureCall featureCall = ((XAbstractFeatureCall) _last);
      JvmIdentifiableElement _feature = featureCall.getFeature();
      final JvmOperation operation = ((JvmOperation) _feature);
      StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, file);
      final StandardTypeReferenceOwner owner = _standardTypeReferenceOwner;
      JvmDeclaredType _declaringType = operation.getDeclaringType();
      ParameterizedTypeReference _parameterizedTypeReference = new ParameterizedTypeReference(owner, _declaringType);
      final ParameterizedTypeReference declaration = _parameterizedTypeReference;
      BottomResolvedOperation _bottomResolvedOperation = new BottomResolvedOperation(operation, declaration, this.overrideTester);
      final BottomResolvedOperation resolved = _bottomResolvedOperation;
      String _simpleSignature = resolved.getSimpleSignature();
      Assert.assertEquals(method, _simpleSignature);
      Resource _eResource = file.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = file.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
      XExpression _implicitReceiver = featureCall.getImplicitReceiver();
      Assert.assertNotNull(_implicitReceiver);
      XExpression _implicitFirstArgument = featureCall.getImplicitFirstArgument();
      Assert.assertNull(_implicitFirstArgument);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected abstract String inMethodBody(final String invocation);
  
  @Test
  public void putWithAllNulls() {
    this.linksTo("put(null, null, null)", "put(MapBasedPreferenceValues, PreferenceKey, Object)");
  }
  
  @Test
  public void assertFormattedWithNull() {
    this.linksTo("assertFormatted(null)", "assertFormatted(CharSequence)");
  }
  
  @Test
  public void assertFormattedWithTemplate() {
    this.linksTo("assertFormatted(\'\'\'\'\'\')", "assertFormatted(CharSequence)");
  }
  
  @Test
  public void assertFormattedWithString() {
    this.linksTo("assertFormatted(\'\')", "assertFormatted(CharSequence)");
  }
  
  @Test
  public void assertFormattedWithLambdaAndNull() {
    this.linksTo("assertFormatted([], null)", "assertFormatted(Procedure1<? super MapBasedPreferenceValues>, CharSequence)");
  }
  
  @Test
  public void assertFormattedWithLambdaAndString() {
    this.linksTo("assertFormatted([], \'\')", "assertFormatted(Procedure1<? super MapBasedPreferenceValues>, CharSequence)");
  }
  
  @Test
  public void assertFormattedWithLambdaAndTemplate() {
    this.linksTo("assertFormatted([], \'\'\'\'\'\')", "assertFormatted(Procedure1<? super MapBasedPreferenceValues>, CharSequence)");
  }
  
  @Test
  public void assertFormattedMemberWithLambdaAndNull() {
    this.linksTo("assertFormattedMember([], null)", 
      "assertFormattedMember(Procedure1<? super MapBasedPreferenceValues>, String)");
  }
  
  @Test
  public void assertFormattedMemberWithLambdaAndString() {
    this.linksTo("assertFormattedMember([], \'\')", 
      "assertFormattedMember(Procedure1<? super MapBasedPreferenceValues>, String)");
  }
  
  @Test
  public void assertFormattedMemberWithLambdaAndTemplate() {
    this.linksTo("assertFormattedMember([], \'\'\'\'\'\')", 
      "assertFormattedMember(Procedure1<? super MapBasedPreferenceValues>, String)");
  }
}
