/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class AccessorsAnnotationTest extends AbstractActiveAnnotationTest {
  @Test
  public void testProperty() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.core.tests.macro.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Accessors String field");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Accessors val String finalField = \'foo\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = (XtendCompilerTester.CompilationResult it) -> {
      final TransformationContext ctx = it.getTransformationContext();
      final MutableClassDeclaration classA = ctx.findClass("A");
      Assert.assertEquals(Visibility.PUBLIC, classA.findDeclaredMethod("getField").getVisibility());
      Assert.assertEquals(Visibility.PUBLIC, classA.findDeclaredMethod("setField", ctx.getString()).getVisibility());
      Assert.assertEquals(Visibility.PUBLIC, classA.findDeclaredMethod("getFinalField").getVisibility());
      Assert.assertNull(classA.findDeclaredMethod("setFinalField", ctx.getString()));
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }

  @Test
  public void testProperty2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.core.tests.macro.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Accessors String field");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private def String getField() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = (XtendCompilerTester.CompilationResult it) -> {
      final TransformationContext ctx = it.getTransformationContext();
      final MutableClassDeclaration classA = ctx.findClass("A");
      Assert.assertEquals(Visibility.PRIVATE, classA.findDeclaredMethod("getField").getVisibility());
      Assert.assertEquals(Visibility.PUBLIC, classA.findDeclaredMethod("setField", ctx.getString()).getVisibility());
      Assert.assertEquals(2, IterableExtensions.size(classA.getDeclaredMethods()));
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
}
