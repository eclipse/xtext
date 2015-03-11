/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidationBug398302Test extends AbstractXtendTestCase {
  @Inject
  private ValidationTestHelper helper;
  
  @Inject
  private ParseHelper<XtendFile> parser;
  
  @Test
  public void test_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("String.CASE_INSENSITIVE_ORDER = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String s = _builder.toString();
      final XtendFile file = this.parser.parse(s);
      final String fieldName = "CASE_INSENSITIVE_ORDER";
      int _indexOf = s.indexOf(fieldName);
      int _length = fieldName.length();
      this.helper.assertError(file, XbasePackage.Literals.XASSIGNMENT, IssueCodes.ASSIGNMENT_TO_FINAL, _indexOf, _length);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("String::CASE_INSENSITIVE_ORDER = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String s = _builder.toString();
      final XtendFile file = this.parser.parse(s);
      final String fieldName = "CASE_INSENSITIVE_ORDER";
      int _indexOf = s.indexOf(fieldName);
      int _length = fieldName.length();
      this.helper.assertError(file, XbasePackage.Literals.XASSIGNMENT, IssueCodes.ASSIGNMENT_TO_FINAL, _indexOf, _length);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static java.lang.String.*");
      _builder.newLine();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("CASE_INSENSITIVE_ORDER = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String s = _builder.toString();
      final XtendFile file = this.parser.parse(s);
      final String fieldName = "CASE_INSENSITIVE_ORDER";
      int _indexOf = s.indexOf(fieldName);
      int _length = fieldName.length();
      this.helper.assertError(file, XbasePackage.Literals.XASSIGNMENT, IssueCodes.ASSIGNMENT_TO_FINAL, _indexOf, _length);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val string = \'\'");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("string = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String s = _builder.toString();
      final XtendFile file = this.parser.parse(s);
      final String assignment = "string = null";
      int _indexOf = s.indexOf(assignment);
      this.helper.assertError(file, XbasePackage.Literals.XASSIGNMENT, IssueCodes.ASSIGNMENT_TO_FINAL, _indexOf, 6);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val string = \'\'");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this.string = null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String s = _builder.toString();
      final XtendFile file = this.parser.parse(s);
      final String assignment = "string = null";
      int _indexOf = s.indexOf(assignment);
      this.helper.assertError(file, XbasePackage.Literals.XASSIGNMENT, IssueCodes.ASSIGNMENT_TO_FINAL, _indexOf, 6);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
