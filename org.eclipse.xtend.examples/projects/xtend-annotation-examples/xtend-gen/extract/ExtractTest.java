/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package extract;

import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ExtractTest {
  @Extension
  private XtendCompilerTester compilerTester = XtendCompilerTester.newXtendCompilerTester(this.getClass().getClassLoader());
  
  @Test
  public void testExtractAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@extract.Extract");
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override doStuff(String myParam) throws IllegalArgumentException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return myParam");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = (XtendCompilerTester.CompilationResult it) -> {
      @Extension
      final TransformationContext ctx = it.getTransformationContext();
      final MutableInterfaceDeclaration interf = ctx.findInterface("MyClassInterface");
      final MutableClassDeclaration clazz = ctx.findClass("MyClass");
      Assert.assertEquals(IterableExtensions.head(clazz.getImplementedInterfaces()).getType(), interf);
      MutableMethodDeclaration _head = IterableExtensions.head(interf.getDeclaredMethods());
      final Procedure1<MutableMethodDeclaration> _function_1 = (MutableMethodDeclaration it_1) -> {
        Assert.assertEquals("doStuff", it_1.getSimpleName());
        Assert.assertEquals(ctx.getString(), it_1.getReturnType());
        Assert.assertEquals(ctx.newTypeReference(IllegalArgumentException.class), IterableExtensions.head(it_1.getExceptions()));
      };
      ObjectExtensions.<MutableMethodDeclaration>operator_doubleArrow(_head, _function_1);
    };
    this.compilerTester.compile(_builder, _function);
  }
}
