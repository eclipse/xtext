/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
public class ValidationBug419050Test extends AbstractXtendTestCase {
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
      _builder.append("def m(boolean b) { ");
      _builder.newLine();
      _builder.append("\t   ");
      _builder.append("var boolean y = if (b) return true else return false");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XVARIABLE_DECLARATION, IssueCodes.UNREACHABLE_CODE);
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
      _builder.append("def m(boolean b) { ");
      _builder.newLine();
      _builder.append("\t   ");
      _builder.append("var boolean y = false");
      _builder.newLine();
      _builder.append("\t   ");
      _builder.append("y = if (b) return true else return false");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XASSIGNMENT, IssueCodes.UNREACHABLE_CODE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m(boolean b) { ");
      _builder.newLine();
      _builder.append("\t   ");
      _builder.append("var boolean y = false");
      _builder.newLine();
      _builder.append("\t   ");
      _builder.append("y = return false");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XASSIGNMENT, IssueCodes.UNREACHABLE_CODE);
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
      _builder.append("def m(boolean b) { ");
      _builder.newLine();
      _builder.append("\t   ");
      _builder.append("var boolean y = if (b) return true");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertWarning(file, XbasePackage.Literals.XIF_EXPRESSION, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
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
      _builder.append("def m(boolean b) { ");
      _builder.newLine();
      _builder.append("\t   ");
      _builder.append("var boolean y = false");
      _builder.newLine();
      _builder.append("\t   ");
      _builder.append("y = if (b) return true");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertWarning(file, XbasePackage.Literals.XIF_EXPRESSION, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug417371_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m(Iterable<String> iter) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("iter.filter [");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (length < 2) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return true");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("} else if (length > 2) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return false");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("] ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertWarning(file, XbasePackage.Literals.XIF_EXPRESSION, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
