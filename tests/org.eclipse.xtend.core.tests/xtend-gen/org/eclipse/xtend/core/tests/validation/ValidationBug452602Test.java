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
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidationBug452602Test extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ValidationTestHelper helper;
  
  @Inject
  private ParseHelper<XtendFile> parser;
  
  @Test
  public void test_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Test {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("val String attrName");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("new(String s) {");
      _builder.newLine();
      _builder.append("    \t");
      _builder.append("attrName = s");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def boolean test(Object o) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("val x = o as Test");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("if (attrName != x.attrName) ");
      _builder.newLine();
      _builder.append("        \t");
      _builder.append("return false ");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("return true");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile c = this.parser.parse(_builder);
      this.helper.assertNoIssues(c);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Test {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("val String attrName");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("new(String s) {");
      _builder.newLine();
      _builder.append("    \t");
      _builder.append("attrName = s");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def boolean test(Object o) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("val x = o as Test");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("if ((o as Test).attrName != x.attrName) ");
      _builder.newLine();
      _builder.append("        \t");
      _builder.append("return false ");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("return true");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile c = this.parser.parse(_builder);
      this.helper.assertWarning(c, XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.CONSTANT_BOOLEAN_CONDITION, "Constant condition is always false");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Test {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("val String attrName");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("val String attrName2");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("new(String s1, String s2) {");
      _builder.newLine();
      _builder.append("    \t");
      _builder.append("attrName = s1");
      _builder.newLine();
      _builder.append("    \t");
      _builder.append("attrName2 = s2");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def boolean test() {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("if (attrName === attrName2) ");
      _builder.newLine();
      _builder.append("        \t");
      _builder.append("return false ");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("return true");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile c = this.parser.parse(_builder);
      this.helper.assertNoIssues(c);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
