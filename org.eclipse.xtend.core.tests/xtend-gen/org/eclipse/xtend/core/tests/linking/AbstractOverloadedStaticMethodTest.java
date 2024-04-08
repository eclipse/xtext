/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.linking;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.override.BottomResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideTester;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
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
      final XtendFile file = this.file(this.inMethodBody(invocation), false);
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(file.getXtendTypes());
      final XtendClass c = ((XtendClass) _head);
      XtendMember _head_1 = IterableExtensions.<XtendMember>head(c.getMembers());
      final XtendFunction m = ((XtendFunction) _head_1);
      XExpression _expression = m.getExpression();
      final XBlockExpression body = ((XBlockExpression) _expression);
      XExpression _lastOrNull = IterableExtensions.<XExpression>lastOrNull(body.getExpressions());
      final XAbstractFeatureCall featureCall = ((XAbstractFeatureCall) _lastOrNull);
      JvmIdentifiableElement _feature = featureCall.getFeature();
      final JvmOperation operation = ((JvmOperation) _feature);
      final StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(this.services, file);
      final ParameterizedTypeReference declaration = owner.newParameterizedTypeReference(operation.getDeclaringType());
      final BottomResolvedOperation resolved = new BottomResolvedOperation(operation, declaration, this.overrideTester);
      Assert.assertEquals(method, resolved.getSimpleSignature());
      Assert.assertTrue(IterableExtensions.join(file.eResource().getErrors(), "\n"), file.eResource().getErrors().isEmpty());
      Assert.assertNull(featureCall.getImplicitReceiver());
      Assert.assertNull(featureCall.getImplicitFirstArgument());
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
