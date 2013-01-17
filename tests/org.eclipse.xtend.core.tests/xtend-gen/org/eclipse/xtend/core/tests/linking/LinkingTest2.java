/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.linking;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.linking.AbstractLinkingTest;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = NewTypeSystemRuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class LinkingTest2 extends AbstractLinkingTest {
  @Test
  public void testImplicitFirstArgument_07() throws Exception {
    final XtendClass clazz = this.clazz(
      "import static extension test.ImplicitFirstArgumentStatics.*\n                class MyXtendClass {\n                  def testExtensionMethods(CharSequence it) { \n                    withCharSequence \n                  }\n                }");
    EList<XtendMember> _members = clazz.getMembers();
    XtendMember _get = _members.get(0);
    final XtendFunction func = ((XtendFunction) _get);
    XExpression _expression = func.getExpression();
    EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
    XExpression _get_1 = _expressions.get(0);
    final XFeatureCall seventh = ((XFeatureCall) _get_1);
    JvmIdentifiableElement _feature = seventh.getFeature();
    final JvmOperation seventhFeature = ((JvmOperation) _feature);
    String _identifier = seventhFeature.getIdentifier();
    Assert.assertEquals("test.ImplicitFirstArgumentStatics.withCharSequence(java.lang.CharSequence)", _identifier);
    XExpression _implicitReceiver = seventh.getImplicitReceiver();
    Assert.assertNull(_implicitReceiver);
    XExpression _implicitFirstArgument = seventh.getImplicitFirstArgument();
    Assert.assertNotNull(_implicitFirstArgument);
    String _invalidFeatureIssueCode = seventh.getInvalidFeatureIssueCode();
    String _invalidFeatureIssueCode_1 = seventh.getInvalidFeatureIssueCode();
    Assert.assertNull(_invalidFeatureIssueCode, _invalidFeatureIssueCode_1);
    XExpression _implicitFirstArgument_1 = seventh.getImplicitFirstArgument();
    JvmIdentifiableElement _feature_1 = ((XAbstractFeatureCall) _implicitFirstArgument_1).getFeature();
    String _simpleName = _feature_1.getSimpleName();
    Assert.assertEquals("it", _simpleName);
  }
  
  @Test
  public void testBug345827_03() throws Exception {
    final XtendFunction function = this.function(
      "def String name(String param) { \n\t\t\t\t   var name = \'\'\n\t\t\t\t   name() \n\t\t\t\t}");
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    EList<XExpression> _expressions = block.getExpressions();
    XExpression _last = IterableExtensions.<XExpression>last(_expressions);
    final XFeatureCall featureCall = ((XFeatureCall) _last);
    JvmOperation _directlyInferredOperation = this.associator.getDirectlyInferredOperation(function);
    JvmIdentifiableElement _feature = featureCall.getFeature();
    Assert.assertSame(_directlyInferredOperation, _feature);
  }
  
  @Test
  public void testBug345827_05() throws Exception {
    final XtendFunction function = this.function(
      "def String name(String name) { \n\t\t\t\t   name() \n\t\t\t\t}");
    XExpression _expression = function.getExpression();
    final XBlockExpression block = ((XBlockExpression) _expression);
    EList<XExpression> _expressions = block.getExpressions();
    XExpression _head = IterableExtensions.<XExpression>head(_expressions);
    final XFeatureCall featureCall = ((XFeatureCall) _head);
    JvmOperation _directlyInferredOperation = this.associator.getDirectlyInferredOperation(function);
    JvmIdentifiableElement _feature = featureCall.getFeature();
    Assert.assertSame(_directlyInferredOperation, _feature);
  }
}
