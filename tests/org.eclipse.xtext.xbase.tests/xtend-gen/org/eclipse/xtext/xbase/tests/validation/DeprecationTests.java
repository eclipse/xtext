/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * @author Stéphane Galland - Initial contribution and API
 */
@SuppressWarnings("all")
public class DeprecationTests extends AbstractXbaseTestCase {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testDeprecatedStaticField_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.deprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticField_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.nodeprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoError(_expression, IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedStaticFunction() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.deprecatedStaticFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticFunction() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.nodeprecatedStaticFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoError(_expression, IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedConstructor() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers(1)");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConstructor() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers(1f)");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoError(_expression, IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers(1f).deprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers(1f).nodeprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoError(_expression, IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedFunction() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers(1f).deprecatedFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFunction() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers(1f).nodeprecatedFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoError(_expression, IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedStaticField_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember1.deprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticField_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember1.nodeprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoError(_expression, IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedStaticFunction_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember1.deprecatedStaticFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticFunction_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember1.nodeprecatedStaticFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoError(_expression, IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedConstructor_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1(1)");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConstructor_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1(1f)");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoError(_expression, IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedField_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1(1f).deprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testField_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1(1f).nodeprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoError(_expression, IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedFunction_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1(1f).deprecatedFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFunction_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1(1f).nodeprecatedFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoError(_expression, IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedStaticField_1_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember1.InnerMember11.deprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticField_1_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember1.InnerMember11.nodeprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoError(_expression, IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedStaticFunction_1_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember1.InnerMember11.deprecatedStaticFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticFunction_1_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember1.InnerMember11.nodeprecatedStaticFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoError(_expression, IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedConstructor_1_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1)");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConstructor_1_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f)");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoError(_expression, IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedField_1_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).deprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testField_1_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).nodeprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoError(_expression, IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedFunction_1_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).deprecatedFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFunction_1_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).nodeprecatedFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertNoError(_expression, IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedStaticField_1_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember1.InnerMember12.deprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticField_1_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember1.InnerMember12.nodeprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedStaticFunction_1_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember1.InnerMember12.deprecatedStaticFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticFunction_1_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember1.InnerMember12.nodeprecatedStaticFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedConstructor_1_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1)");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConstructor_1_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f)");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedField_1_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).deprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testField_1_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).nodeprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedFunction_1_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).deprecatedFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFunction_1_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).nodeprecatedFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedStaticField_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember2.deprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticField_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember2.nodeprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedStaticFunction_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember2.deprecatedStaticFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticFunction_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember2.nodeprecatedStaticFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedConstructor_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2(1)");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConstructor_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2(1f)");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedField_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2(1f).deprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testField_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2(1f).nodeprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedFunction_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2(1f).deprecatedFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFunction_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2(1f).nodeprecatedFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedStaticField_2_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember2.InnerMember21.deprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticField_2_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember2.InnerMember21.nodeprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedStaticFunction_2_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember2.InnerMember21.deprecatedStaticFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticFunction_2_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember2.InnerMember21.nodeprecatedStaticFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedConstructor_2_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1)");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConstructor_2_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f)");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedField_2_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).deprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testField_2_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).nodeprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedFunction_2_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).deprecatedFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFunction_2_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).nodeprecatedFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedStaticField_2_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember2.InnerMember22.deprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticField_2_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember2.InnerMember22.nodeprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedStaticFunction_2_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember2.InnerMember22.deprecatedStaticFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticFunction_2_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("testdata.DeprecatedMembers.InnerMember2.InnerMember22.nodeprecatedStaticFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedConstructor_2_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1)");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConstructor_2_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f)");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XCONSTRUCTOR_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedField_2_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).deprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testField_2_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).nodeprecatedField");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeprecatedFunction_2_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).deprecatedFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFunction_2_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).nodeprecatedFunction");
      _builder.newLine();
      XExpression _expression = this.expression(_builder);
      this._validationTestHelper.assertWarning(_expression, 
        XbasePackage.Literals.XABSTRACT_FEATURE_CALL, 
        IssueCodes.DEPRECATED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
