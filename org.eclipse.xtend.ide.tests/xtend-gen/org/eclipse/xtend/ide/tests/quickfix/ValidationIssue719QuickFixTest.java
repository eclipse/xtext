/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.quickfix;

import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Eva Poell - Initial contribution
 */
@RunWith(XtextRunner.class)
@InjectWith(XtendIDEInjectorProvider.class)
@SuppressWarnings("all")
public class ValidationIssue719QuickFixTest extends AbstractQuickfixTest {
  @Before
  public void setup() {
    try {
      JavaProjectSetupUtil.createJavaProject(this.getProjectName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void add_abstract_simple() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class AbstractSample {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("abstract class AbstractSample {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.applyFix(_builder, _builder_1);
  }

  @Test
  public void add_abstract_final_simple() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("final class AbstractSample {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("abstract class AbstractSample {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.applyFix(_builder, _builder_1);
  }

  @Test
  public void add_abstract_package() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package class AbstractSample {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package abstract class AbstractSample {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.applyFix(_builder, _builder_1);
  }

  @Test
  public void add_abstract_package_final() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package final class AbstractSample {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package abstract class AbstractSample {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.applyFix(_builder, _builder_1);
  }

  @Test
  public void add_abstract_static() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("static class AbstractSample {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("abstract static class AbstractSample {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.applyFix(_builder, _builder_1);
  }

  @Test
  public void add_abstract_nested_classes_outer() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class AbstractX{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("abstract static class AbstractY{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("abstract class AbstractX{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("abstract static class AbstractY{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.applyFix(_builder, _builder_1);
  }

  @Test
  public void add_abstract_nested_classes_inner() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("abstract class AbstractX{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("class AbstractY{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("abstract class AbstractX{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("abstract class AbstractY{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.applyFix(_builder, _builder_1);
  }

  @Test
  public void add_abstract_nested_classes_outer_static() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("static class AbstractX{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("class SampleInner{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("abstract static class AbstractX{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("class SampleInner{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.applyFix(_builder, _builder_1);
  }

  @Test
  public void add_abstract_annotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("class AbstractX{");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@Deprecated");
    _builder_1.newLine();
    _builder_1.append("abstract class AbstractX{");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.applyFix(_builder, _builder_1);
  }

  @Test
  public void add_abstract_javadoc() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This is a doc for this abstract class.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* It even has two lines.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class AbstractX{");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* This is a doc for this abstract class.");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* It even has two lines.");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("abstract class AbstractX{");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.applyFix(_builder, _builder_1);
  }

  private void applyFix(final CharSequence input, final CharSequence result) {
    final String issueCode = IssueCodes.MODIFIER_DOES_NOT_MATCH_TYPENAME;
    final String fixlabel = "Add missing abstract modifier.";
    final String fixdescription = "Add the abstract modifier to match naming conventions for the type name. Delete final modifier if necessary.";
    String _string = result.toString();
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix(fixlabel, fixdescription, _string);
    this.testQuickfixesOn(input, issueCode, _quickfix);
  }
}
