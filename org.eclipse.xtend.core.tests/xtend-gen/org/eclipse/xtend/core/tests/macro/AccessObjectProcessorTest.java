/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import java.io.Serializable;
import java.util.Objects;
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class AccessObjectProcessorTest extends AbstractActiveAnnotationTest {
  @Test
  public void testWithoutPackage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.core.tests.macro.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@org.eclipse.xtend.core.tests.macro.AccessObjectAnn");
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String field");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = (XtendCompilerTester.CompilationResult it) -> {
      final TransformationContext ctx = it.getTransformationContext();
      final MutableClassDeclaration classA = ctx.findClass("A");
      Assert.assertNotNull(classA.findDeclaredMethod("getField"));
      final MutableClassDeclaration classPA = ctx.findClass("PA");
      final Function1<TypeReference, Boolean> _function_1 = (TypeReference it_1) -> {
        Type _type = it_1.getType();
        Type _type_1 = ctx.newTypeReference(Serializable.class).getType();
        return Boolean.valueOf(Objects.equals(_type, _type_1));
      };
      Assert.assertNotNull(IterableExtensions.findFirst(classPA.getImplementedInterfaces(), _function_1));
      final MutableClassDeclaration classGA = ctx.findClass("GA");
      final Function1<TypeReference, Boolean> _function_2 = (TypeReference it_1) -> {
        Type _type = it_1.getType();
        Type _type_1 = ctx.newTypeReference(Serializable.class).getType();
        return Boolean.valueOf(Objects.equals(_type, _type_1));
      };
      Assert.assertNotNull(IterableExtensions.findFirst(classGA.getImplementedInterfaces(), _function_2));
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }

  @Test
  public void testWithPackage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package my.pack");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.core.tests.macro.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@org.eclipse.xtend.core.tests.macro.AccessObjectAnn");
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String field");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = (XtendCompilerTester.CompilationResult it) -> {
      final TransformationContext ctx = it.getTransformationContext();
      final MutableClassDeclaration classA = ctx.findClass("my.pack.A");
      Assert.assertNotNull(classA.findDeclaredMethod("getField"));
      final MutableClassDeclaration classPA = ctx.findClass("my.pack.PA");
      final Function1<TypeReference, Boolean> _function_1 = (TypeReference it_1) -> {
        Type _type = it_1.getType();
        Type _type_1 = ctx.newTypeReference(Serializable.class).getType();
        return Boolean.valueOf(Objects.equals(_type, _type_1));
      };
      Assert.assertNotNull(IterableExtensions.findFirst(classPA.getImplementedInterfaces(), _function_1));
      final MutableClassDeclaration classGA = ctx.findClass("my.pack.GA");
      final Function1<TypeReference, Boolean> _function_2 = (TypeReference it_1) -> {
        Type _type = it_1.getType();
        Type _type_1 = ctx.newTypeReference(Serializable.class).getType();
        return Boolean.valueOf(Objects.equals(_type, _type_1));
      };
      Assert.assertNotNull(IterableExtensions.findFirst(classGA.getImplementedInterfaces(), _function_2));
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
}
