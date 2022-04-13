/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro.declaration;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TypeLookupImplTest extends AbstractXtendTestCase {
  @Test
  public void testFindClass_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass {}");
    _builder.newLine();
    _builder.append("enum MyEnum {}");
    _builder.newLine();
    _builder.append("interface MyInterface {}");
    _builder.newLine();
    _builder.append("annotation MyAnnotation {}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      Assert.assertNotNull(it.getTypeLookup().findClass("foo.MyClass"));
      Assert.assertNull(it.getTypeLookup().findClass("foo.MyClass.Unknown"));
      Assert.assertNull(it.getTypeLookup().findClass("foo.MyInterface"));
      Assert.assertNotNull(it.getTypeLookup().findEnumerationType("foo.MyEnum"));
      Assert.assertNotNull(it.getTypeLookup().findAnnotationType("foo.MyAnnotation"));
      Assert.assertNotNull(it.getTypeLookup().findInterface("foo.MyInterface"));
      Assert.assertNull(it.getTypeLookup().findClass("java.lang.String"));
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testFindClass_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.core.tests.macro.declaration.AddNestedTypes");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@AddNestedTypes class MyClass {}");
    _builder.newLine();
    _builder.append("@AddNestedTypes enum MyEnum {}");
    _builder.newLine();
    _builder.append("@AddNestedTypes interface MyInterface {}");
    _builder.newLine();
    _builder.append("@AddNestedTypes annotation MyAnnotation {}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      Assert.assertNotNull(it.getTypeLookup().findClass("foo.MyClass.NestedClass"));
      Assert.assertNotNull(it.getTypeLookup().findInterface("foo.MyClass.NestedInterface"));
      Assert.assertNotNull(it.getTypeLookup().findEnumerationType("foo.MyClass.NestedEnumerationType"));
      Assert.assertNotNull(it.getTypeLookup().findAnnotationType("foo.MyClass.NestedAnnotationType"));
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testFindUpstreamType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass {}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      Assert.assertNull(it.getTypeLookup().findUpstreamType("foo.MyClass"));
      Assert.assertNotNull(it.getTypeLookup().findUpstreamType("java.lang.String"));
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testFindSourceType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.core.tests.macro.declaration.AddNestedTypes");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@AddNestedTypes class MyClass {}");
    _builder.newLine();
    _builder.append("@AddNestedTypes enum MyEnum {}");
    _builder.newLine();
    _builder.append("@AddNestedTypes interface MyInterface {}");
    _builder.newLine();
    _builder.append("@AddNestedTypes annotation MyAnnotation {}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      Assert.assertNotNull(it.getTypeLookup().findSourceClass("foo.MyClass"));
      Assert.assertNotNull(it.getTypeLookup().findSourceInterface("foo.MyInterface"));
      Assert.assertNotNull(it.getTypeLookup().findSourceEnumerationType("foo.MyEnum"));
      Assert.assertNotNull(it.getTypeLookup().findSourceAnnotationType("foo.MyAnnotation"));
      Assert.assertNull(it.getTypeLookup().findSourceClass("foo.MyClass.NestedClass"));
      Assert.assertNull(it.getTypeLookup().findSourceInterface("foo.MyClass.NestedInterface"));
      Assert.assertNull(it.getTypeLookup().findSourceEnumerationType("foo.MyClass.NestedEnumerationType"));
      Assert.assertNull(it.getTypeLookup().findSourceAnnotationType("foo.MyClass.NestedAnnotationType"));
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;

  public XtendFile validFile(final CharSequence code) {
    try {
      return this.file(code.toString(), true);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void asCompilationUnit(final XtendFile file, final Procedure1<? super CompilationUnitImpl> block) {
    final CompilationUnitImpl compilationUnit = this.compilationUnitProvider.get();
    compilationUnit.setXtendFile(file);
    block.apply(compilationUnit);
  }
}
