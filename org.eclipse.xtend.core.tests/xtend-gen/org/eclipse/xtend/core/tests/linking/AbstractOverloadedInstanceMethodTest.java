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
public abstract class AbstractOverloadedInstanceMethodTest extends AbstractXtendTestCase {
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
      Assert.assertNotNull(featureCall.getImplicitReceiver());
      Assert.assertNull(featureCall.getImplicitFirstArgument());
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
