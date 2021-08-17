/**
 * Copyright (c) 2020 Sebastian Zarnekow
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.java8.macro;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@InjectWith(Java8RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class DeclarationsTest extends org.eclipse.xtend.core.tests.macro.declaration.DeclarationsTest {
  @Test
  public void testXtendInterfaceWithDefaultMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package p");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface MyIntf {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String dflt() { \"\" }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String abstrct()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static String statc() { \"\" }");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      Assert.assertEquals("p", it.getPackageName());
      TypeDeclaration _head = IterableExtensions.head(it.getSourceTypeDeclarations());
      final InterfaceDeclaration intf = ((InterfaceDeclaration) _head);
      Assert.assertEquals("p.MyIntf", intf.getQualifiedName());
      Assert.assertTrue(IterableExtensions.isEmpty(intf.getExtendedInterfaces()));
      Assert.assertEquals(3, IterableExtensions.size(intf.getDeclaredMembers()));
      final MethodDeclaration dflt = IterableExtensions.head(intf.getDeclaredMethods());
      Assert.assertTrue(dflt.isDefault());
      Assert.assertFalse(dflt.isAbstract());
      final MethodDeclaration abstract_ = ((MethodDeclaration[])Conversions.unwrapArray(intf.getDeclaredMethods(), MethodDeclaration.class))[1];
      Assert.assertFalse(abstract_.isDefault());
      Assert.assertTrue(abstract_.isAbstract());
      final MethodDeclaration static_ = ((MethodDeclaration[])Conversions.unwrapArray(intf.getDeclaredMethods(), MethodDeclaration.class))[2];
      Assert.assertFalse(static_.isDefault());
      Assert.assertFalse(static_.isAbstract());
      Assert.assertTrue(static_.isStatic());
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }
}
