/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.annotations;

import com.google.inject.Inject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class AnnotationTest extends AbstractXtendTestCase {
  @Test
  public void testAnnotationValue_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Click(2)");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation Click {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertContains(this.compileToJavaCode(_builder), "@Click(2)");
  }

  @Test
  public void testAnnotationValue_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Click(#[2])");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation Click {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertContains(this.compileToJavaCode(_builder), "@Click({ 2 })");
  }

  @Test
  public void testAnnotationValue_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Click(#[2,3])");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation Click {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertContains(this.compileToJavaCode(_builder), "@Click({ 2, 3 })");
  }

  @Test
  public void testAnnotationValue_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Click(value = 2)");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation Click {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertContains(this.compileToJavaCode(_builder), "@Click(value = 2)");
  }

  @Test
  public void testAnnotationValue_4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Click(value = #[2])");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation Click {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertContains(this.compileToJavaCode(_builder), "@Click(value = { 2 })");
  }

  @Test
  public void testAnnotationValue_5() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Click(value = #[2,3])");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation Click {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertContains(this.compileToJavaCode(_builder), "@Click(value = { 2, 3 })");
  }

  protected void assertContains(final CharSequence code, final String text) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Substring \'");
    _builder.append(text);
    _builder.append("\' not found in \'");
    _builder.append(code);
    _builder.append("\' ");
    Assert.assertTrue(_builder.toString(), code.toString().contains(text));
  }

  @Inject
  private ParseHelper<XtendFile> parseHelper;

  @Inject
  private ValidationTestHelper validationHelper;

  @Inject
  private IXtendJvmAssociations associations;

  @Inject
  private JvmModelGenerator generator;

  @Inject
  private IGeneratorConfigProvider generatorConfigProvider;

  protected CharSequence compileToJavaCode(final CharSequence xtendCode) {
    try {
      CharSequence _xblockexpression = null;
      {
        final XtendFile file = this.parseHelper.parse(xtendCode);
        this.validationHelper.assertNoErrors(file);
        final JvmDeclaredType inferredType = this.associations.getInferredType(file.getXtendTypes().get(0));
        _xblockexpression = this.generator.generateType(inferredType, this.generatorConfigProvider.get(inferredType));
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
