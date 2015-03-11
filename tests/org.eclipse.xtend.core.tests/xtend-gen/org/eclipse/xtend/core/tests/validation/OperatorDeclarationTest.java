/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class OperatorDeclarationTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ParseHelper<XtendFile> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  private OperatorMapping operatorMapping;
  
  @Test
  public void testOperatorDeclaration_returnType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      {
        Set<QualifiedName> _operators = this.operatorMapping.getOperators();
        for(final QualifiedName op : _operators) {
          _builder.append("\t");
          _builder.append("def String ");
          _builder.append(op, "\t");
          _builder.append("() { return null }");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      Resource _eResource = file.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = file.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOperatorDeclaration_genericReturnType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      {
        Set<QualifiedName> _operators = this.operatorMapping.getOperators();
        for(final QualifiedName op : _operators) {
          _builder.append("\t");
          _builder.append("def Iterable<String> ");
          _builder.append(op, "\t");
          _builder.append("() { return null }");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      Resource _eResource = file.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = file.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOperatorDeclaration_genericReturnTypeWithFunctionType_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      {
        Set<QualifiedName> _operators = this.operatorMapping.getOperators();
        for(final QualifiedName op : _operators) {
          _builder.append("\t");
          _builder.append("def Iterable<(String)=>void> ");
          _builder.append(op, "\t");
          _builder.append("() { return null }");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      Resource _eResource = file.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = file.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOperatorDeclaration_genericReturnTypeWithFunctionType_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      {
        Set<QualifiedName> _operators = this.operatorMapping.getOperators();
        for(final QualifiedName op : _operators) {
          _builder.append("\t");
          _builder.append("def Iterable< =>void> ");
          _builder.append(op, "\t");
          _builder.append("() { return null }");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      Resource _eResource = file.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = file.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOperatorDeclaration_genericReturnTypeWithFunctionType_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      {
        Set<QualifiedName> _operators = this.operatorMapping.getOperators();
        for(final QualifiedName op : _operators) {
          _builder.append("\t");
          _builder.append("def Iterable<()=>void> ");
          _builder.append(op, "\t");
          _builder.append("() { return null }");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      Resource _eResource = file.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = file.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOperatorDeclaration_typeParam() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      {
        Set<QualifiedName> _operators = this.operatorMapping.getOperators();
        for(final QualifiedName op : _operators) {
          _builder.append("\t");
          _builder.append("def <T> ");
          _builder.append(op, "\t");
          _builder.append("() { return null }");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      Resource _eResource = file.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = file.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNotOperatorDeclaration_instance() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String !() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String !(Object o) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNotOperatorDeclaration_instance_error() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String !(String first, String second) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XtendPackage.Literals.XTEND_FUNCTION, 
        IssueCodes.INVALID_OPERATOR_SIGNATURE, 
        "The unary operator \'!\' allows at most one argument.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNotOperatorDeclaration_static() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static String !(Object o) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNotOperatorDeclaration_static_error_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static String !(String first, String second) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XtendPackage.Literals.XTEND_FUNCTION, 
        IssueCodes.INVALID_OPERATOR_SIGNATURE, 
        "The static unary operator \'!\' requires exactly one argument.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNotOperatorDeclaration_static_error_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static String !() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XtendPackage.Literals.XTEND_FUNCTION, 
        IssueCodes.INVALID_OPERATOR_SIGNATURE, 
        "The static unary operator \'!\' requires exactly one argument.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAndOperatorDeclaration_instance() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String &&(Object o) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String &&(Object o, Object p) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAndOperatorDeclaration_instance_error_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String &&() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XtendPackage.Literals.XTEND_FUNCTION, 
        IssueCodes.INVALID_OPERATOR_SIGNATURE, 
        "The binary operator \'&&\' requires at least one argument.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAndOperatorDeclaration_instance_error_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String &&(Object o, Object p, Object q) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XtendPackage.Literals.XTEND_FUNCTION, 
        IssueCodes.INVALID_OPERATOR_SIGNATURE, 
        "The binary operator \'&&\' allows at most two arguments.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAndOperatorDeclaration_static() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static String &&(Object o, Object p) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAndOperatorDeclaration_static_error_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static String &&(String s) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XtendPackage.Literals.XTEND_FUNCTION, 
        IssueCodes.INVALID_OPERATOR_SIGNATURE, 
        "The static binary operator \'&&\' requires exactly two arguments.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAndOperatorDeclaration_static_error_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static String &&(Object o, Object p, Object q) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XtendPackage.Literals.XTEND_FUNCTION, 
        IssueCodes.INVALID_OPERATOR_SIGNATURE, 
        "The static binary operator \'&&\' requires exactly two arguments.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPlusOperatorDeclaration_instance() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// unary");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String +() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// binary or extension unary");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String +(Object o) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// extension binary");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String +(Object o, Object p) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPlusOperatorDeclaration_instance_error() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String +(Object o, Object p, Object q) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XtendPackage.Literals.XTEND_FUNCTION, 
        IssueCodes.INVALID_OPERATOR_SIGNATURE, 
        "The operator \'+\' allows at most two arguments.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPlusOperatorDeclaration_static() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static String +(String s) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static String +(Object o, Object p) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPlusOperatorDeclaration_static_error_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static String +(Object o, Object p, Object q) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XtendPackage.Literals.XTEND_FUNCTION, 
        IssueCodes.INVALID_OPERATOR_SIGNATURE, 
        "The static operator \'+\' allows at most two arguments.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPlusPlusOperatorDeclaration_static() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static String ++(Object o) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPlusPlusOperatorDeclaration_instance() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String ++() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String ++(Object o) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPlusPlusOperatorDeclaration_static_error_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static String ++(Object o, Object p) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XtendPackage.Literals.XTEND_FUNCTION, 
        IssueCodes.INVALID_OPERATOR_SIGNATURE, 
        "The static unary operator \'++\' requires exactly one argument.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPlusPlusOperatorDeclaration_instance_error_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String ++(Object o, Object o2) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(file, 
        XtendPackage.Literals.XTEND_FUNCTION, 
        IssueCodes.INVALID_OPERATOR_SIGNATURE, 
        "The unary operator \'++\' allows at most one argument.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
