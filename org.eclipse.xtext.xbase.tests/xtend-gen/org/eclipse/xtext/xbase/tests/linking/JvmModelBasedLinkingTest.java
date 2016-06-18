/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.linking;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseWithLogicalContainerInjectorProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(XbaseWithLogicalContainerInjectorProvider.class)
@SuppressWarnings("all")
public class JvmModelBasedLinkingTest extends AbstractXbaseTestCase {
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private TypeReferences refs;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testLinkToParameter() {
    try {
      final XExpression expr = this.expression("x", false);
      final Resource resource = expr.eResource();
      resource.eSetDeliver(false);
      EList<EObject> _contents = resource.getContents();
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _stringType = this.stringType(expr);
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          JvmTypeReference _stringType_1 = this.stringType(expr);
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(expr, "x", _stringType_1);
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
          this._jvmTypesBuilder.setBody(it_1, expr);
        };
        JvmOperation _method = this._jvmTypesBuilder.toMethod(expr, "doStuff", _stringType, _function_1);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
      };
      JvmGenericType _class = this._jvmTypesBuilder.toClass(expr, "Foo", _function);
      this._jvmTypesBuilder.<JvmGenericType>operator_add(_contents, _class);
      this._validationTestHelper.assertNoErrors(expr);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLinkToParameter_1() {
    try {
      XExpression _expression = this.expression("x", false);
      final XFeatureCall expr = ((XFeatureCall) _expression);
      final Resource resource = expr.eResource();
      resource.eSetDeliver(false);
      EList<EObject> _contents = resource.getContents();
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _stringType = this.stringType(expr);
        JvmField _field = this._jvmTypesBuilder.toField(expr, "x", _stringType);
        this._jvmTypesBuilder.<JvmField>operator_add(_members, _field);
        EList<JvmMember> _members_1 = it.getMembers();
        JvmTypeReference _stringType_1 = this.stringType(expr);
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          JvmTypeReference _stringType_2 = this.stringType(expr);
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(expr, "x", _stringType_2);
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
          this._jvmTypesBuilder.setBody(it_1, expr);
        };
        JvmOperation _method = this._jvmTypesBuilder.toMethod(expr, "doStuff", _stringType_1, _function_1);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method);
      };
      JvmGenericType _class = this._jvmTypesBuilder.toClass(expr, "Foo", _function);
      this._jvmTypesBuilder.<JvmGenericType>operator_add(_contents, _class);
      this._validationTestHelper.assertNoErrors(expr);
      JvmIdentifiableElement _feature = expr.getFeature();
      Assert.assertTrue((_feature instanceof JvmFormalParameter));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLinkToField() {
    try {
      XExpression _expression = this.expression("x", false);
      final XFeatureCall expr = ((XFeatureCall) _expression);
      final Resource resource = expr.eResource();
      resource.eSetDeliver(false);
      EList<EObject> _contents = resource.getContents();
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _stringType = this.stringType(expr);
        JvmField _field = this._jvmTypesBuilder.toField(expr, "x", _stringType);
        this._jvmTypesBuilder.<JvmField>operator_add(_members, _field);
        EList<JvmMember> _members_1 = it.getMembers();
        JvmTypeReference _stringType_1 = this.stringType(expr);
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          JvmTypeReference _stringType_2 = this.stringType(expr);
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(expr, "y", _stringType_2);
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
          this._jvmTypesBuilder.setBody(it_1, expr);
        };
        JvmOperation _method = this._jvmTypesBuilder.toMethod(expr, "doStuff", _stringType_1, _function_1);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method);
      };
      JvmGenericType _class = this._jvmTypesBuilder.toClass(expr, "Foo", _function);
      this._jvmTypesBuilder.<JvmGenericType>operator_add(_contents, _class);
      this._validationTestHelper.assertNoErrors(expr);
      JvmIdentifiableElement _feature = expr.getFeature();
      Assert.assertTrue((_feature instanceof JvmField));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLinkToField_1() {
    try {
      XExpression _expression = this.expression("x", false);
      final XFeatureCall expr = ((XFeatureCall) _expression);
      final Resource resource = expr.eResource();
      resource.eSetDeliver(false);
      EList<EObject> _contents = resource.getContents();
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _stringType = this.stringType(expr);
        JvmField _field = this._jvmTypesBuilder.toField(expr, "x", _stringType);
        this._jvmTypesBuilder.<JvmField>operator_add(_members, _field);
        EList<JvmMember> _members_1 = it.getMembers();
        JvmTypeReference _stringType_1 = this.stringType(expr);
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          this._jvmTypesBuilder.setBody(it_1, expr);
        };
        JvmOperation _method = this._jvmTypesBuilder.toMethod(expr, "getX", _stringType_1, _function_1);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method);
      };
      JvmGenericType _class = this._jvmTypesBuilder.toClass(expr, "Foo", _function);
      this._jvmTypesBuilder.<JvmGenericType>operator_add(_contents, _class);
      this._validationTestHelper.assertNoErrors(expr);
      JvmIdentifiableElement _feature = expr.getFeature();
      Assert.assertTrue((_feature instanceof JvmField));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public JvmTypeReference stringType(final EObject ctx) {
    return this.refs.getTypeForName(String.class, ctx);
  }
}
