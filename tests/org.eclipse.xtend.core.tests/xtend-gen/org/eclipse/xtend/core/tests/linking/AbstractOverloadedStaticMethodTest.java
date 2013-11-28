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
public abstract class AbstractOverloadedStaticMethodTest extends AbstractXtendTestCase {
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
      Assert.assertNull(_implicitReceiver);
      XExpression _implicitFirstArgument = featureCall.getImplicitFirstArgument();
      Assert.assertNull(_implicitFirstArgument);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected abstract String inMethodBody(final String invocation);
  
  @Test
  public void failWithoutArguments() {
    this.linksTo("fail", "fail()");
  }
  
  @Test
  public void failWithExplicitArgument() {
    this.linksTo("fail(\"\")", "fail(String)");
  }
  
  @Test
  public void failWithImplicitOnScope() {
    this.linksTo("val String it = null fail", "fail()");
  }
  
  @Test
  public void assertEqualsNullAsObjectArray() {
    this.linksTo("assertEquals(null, null)", "assertEquals(Object[], Object[])");
  }
  
  @Test
  public void assertEqualsStringNumberArray() {
    this.linksTo("assertEquals(null as String[], null as Number[])", "assertEquals(Object[], Object[])");
  }
  
  @Test
  public void assertEqualsNullAsObjectArrayWithMessage() {
    this.linksTo("assertEquals(\"\", null, null)", "assertEquals(String, Object[], Object[])");
  }
  
  @Test
  public void assertEqualsNullAsObjectArrayWithNullMessage() {
    this.linksTo("assertEquals(null, null, null)", "assertEquals(String, Object[], Object[])");
  }
  
  @Test
  public void assertEqualsObjectNull() {
    this.linksTo("assertEquals(null as Object, null)", "assertEquals(Object, Object)");
  }
  
  @Test
  public void assertEqualsNullObject() {
    this.linksTo("assertEquals(null, null as Object)", "assertEquals(Object, Object)");
  }
  
  @Test
  public void assertEqualsWithIterables() {
    this.linksTo("assertEquals(null as Iterable<String>, null as Iterable<String>)", "assertEquals(Object, Object)");
  }
  
  @Test
  public void assertEqualsWithLists() {
    this.linksTo("assertEquals(null as java.util.List<String>, null as java.util.List<String>)", "assertEquals(Object, Object)");
  }
  
  @Test
  public void assertEqualsWithListAndObjectArray() {
    this.linksTo("assertEquals(null as java.util.List<String>, null as Object[])", "assertEquals(Object, Object)");
  }
  
  @Test
  public void assertEqualsWithBooleans() {
    this.linksTo("assertEquals(true, true)", "assertEquals(Object, Object)");
  }
  
  @Test
  public void assertEqualsWithBooleansAndMessage() {
    this.linksTo("assertEquals(\"\", true, true)", "assertEquals(String, Object, Object)");
  }
  
  @Test
  public void assertEqualsWithBooleansAndNullMessage() {
    this.linksTo("assertEquals(null, true, true)", "assertEquals(String, Object, Object)");
  }
}
