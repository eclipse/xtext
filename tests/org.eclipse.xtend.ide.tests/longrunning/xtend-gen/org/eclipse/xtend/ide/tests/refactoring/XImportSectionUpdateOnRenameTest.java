/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.refactoring;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.refactoring.RenameSupport;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend.ide.tests.refactoring.FileAsserts;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.ui.refactoring.participant.CompositeRefactoringProcessor;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XImportSectionUpdateOnRenameTest extends AbstractXtendUITestCase {
  @Inject
  private SyncUtil syncUtil;
  
  @Inject
  private IWorkbench workbench;
  
  @Inject
  @Extension
  private FileAsserts _fileAsserts;
  
  @Inject
  @Extension
  private WorkbenchTestHelper testHelper;
  
  @Inject
  private CompositeRefactoringProcessor.Access compositeRefactoringProcessorAccess;
  
  public void tearDown() throws Exception {
    this.testHelper.tearDown();
    super.tearDown();
  }
  
  @Test
  public void renameUnusedType() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package foo;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class Foo {}");
        _builder.newLine();
        this.testHelper.createFile("foo/Foo.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package bar");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import foo.Foo");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar {}");
        _builder_1.newLine();
        final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
        IType _findJavaType = this.findJavaType("foo.Foo");
        this.renameJavaElement(_findJavaType, "NewFoo");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package bar");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import foo.NewFoo");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Bar {}");
        _builder_2.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/foo/NewFoo.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Ignore
  @Test
  public void renameUnusedType_2() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package foo;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class Foo {}");
        _builder.newLine();
        this.testHelper.createFile("foo/Foo.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package bar");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import foo.Foo.*");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar {}");
        _builder_1.newLine();
        final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
        IType _findJavaType = this.findJavaType("foo.Foo");
        this.renameJavaElement(_findJavaType, "NewFoo");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package bar");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import foo.NewFoo.*");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Bar {}");
        _builder_2.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/foo/NewFoo.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameUnusedType_3() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package foo;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class Foo {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static void foo() {}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        this.testHelper.createFile("foo/Foo.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package bar");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import static foo.Foo.foo");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar {}");
        _builder_1.newLine();
        final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
        IType _findJavaType = this.findJavaType("foo.Foo");
        this.renameJavaElement(_findJavaType, "NewFoo");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package bar");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import static foo.NewFoo.foo");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Bar {}");
        _builder_2.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/foo/NewFoo.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameUnusedType_4() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package foo;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class Foo {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static void foo() {}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        this.testHelper.createFile("foo/Foo.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package bar");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import static extension foo.Foo.foo");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar {}");
        _builder_1.newLine();
        final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
        IType _findJavaType = this.findJavaType("foo.Foo");
        this.renameJavaElement(_findJavaType, "NewFoo");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package bar");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import static extension foo.NewFoo.foo");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Bar {}");
        _builder_2.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/foo/NewFoo.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameUnusedType_5() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package foo;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class Foo {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static void foo() {}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        this.testHelper.createFile("foo/Foo.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package bar");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import static foo.Foo.*");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar {}");
        _builder_1.newLine();
        final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
        IType _findJavaType = this.findJavaType("foo.Foo");
        this.renameJavaElement(_findJavaType, "NewFoo");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package bar");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import static foo.NewFoo.*");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Bar {}");
        _builder_2.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/foo/NewFoo.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameUnusedType_6() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package foo;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class Foo {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static void foo() {}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        this.testHelper.createFile("foo/Foo.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package bar");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import static extension foo.Foo.*");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar {}");
        _builder_1.newLine();
        final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
        IType _findJavaType = this.findJavaType("foo.Foo");
        this.renameJavaElement(_findJavaType, "NewFoo");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package bar");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import static extension foo.NewFoo.*");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Bar {}");
        _builder_2.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/foo/NewFoo.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameUnusedField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static String foo;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("foo/Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package bar");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import static foo.Foo.foo");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Bar {}");
      _builder_1.newLine();
      final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
      IType _findJavaType = this.findJavaType("foo.Foo");
      IField _field = _findJavaType.getField("foo");
      this.renameJavaElement(_field, "newFoo");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package bar");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import static foo.Foo.newFoo");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class Bar {}");
      _builder_2.newLine();
      this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameUnusedField_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static String foo;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("foo/Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package bar");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import static extension foo.Foo.foo");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Bar {}");
      _builder_1.newLine();
      final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
      IType _findJavaType = this.findJavaType("foo.Foo");
      IField _field = _findJavaType.getField("foo");
      this.renameJavaElement(_field, "newFoo");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package bar");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import static extension foo.Foo.newFoo");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class Bar {}");
      _builder_2.newLine();
      this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameUsedType() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package foo;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class Foo {}");
        _builder.newLine();
        this.testHelper.createFile("foo/Foo.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package bar");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import foo.Foo");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar extends Foo {}");
        _builder_1.newLine();
        final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
        IType _findJavaType = this.findJavaType("foo.Foo");
        this.renameJavaElement(_findJavaType, "NewFoo");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package bar");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import foo.NewFoo");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Bar extends NewFoo {}");
        _builder_2.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/foo/NewFoo.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Ignore
  @Test
  public void renameUsedType_2() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package foo;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class Foo {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static class Inner {}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        this.testHelper.createFile("foo/Foo.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package bar");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import foo.Foo.*");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar extends Inner {}");
        _builder_1.newLine();
        final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
        IType _findJavaType = this.findJavaType("foo.Foo");
        this.renameJavaElement(_findJavaType, "NewFoo");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package bar");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import foo.NewFoo.*");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Bar extends Inner {}");
        _builder_2.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/foo/NewFoo.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameUsedType_3() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package foo;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class Foo {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static void foo(int i) {}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        this.testHelper.createFile("foo/Foo.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package bar");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import static foo.Foo.foo");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar {");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("def bar() {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("foo(1)");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
        IType _findJavaType = this.findJavaType("foo.Foo");
        this.renameJavaElement(_findJavaType, "NewFoo");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package bar");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import static foo.NewFoo.foo");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Bar {");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("def bar() {");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("foo(1)");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("}");
        _builder_2.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/foo/NewFoo.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameUsedType_4() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package foo;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class Foo {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static void foo(int i) {}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        this.testHelper.createFile("foo/Foo.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package bar");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import static extension foo.Foo.foo");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar {");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("def bar() {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("1.foo");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
        IType _findJavaType = this.findJavaType("foo.Foo");
        this.renameJavaElement(_findJavaType, "NewFoo");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package bar");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import static extension foo.NewFoo.foo");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Bar {");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("def bar() {");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("1.foo");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("}");
        _builder_2.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/foo/NewFoo.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameUsedType_5() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package foo;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class Foo {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static void foo(int i) {}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        this.testHelper.createFile("foo/Foo.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package bar");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import static foo.Foo.*");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar {");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("def bar() {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("foo(1)");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
        IType _findJavaType = this.findJavaType("foo.Foo");
        this.renameJavaElement(_findJavaType, "NewFoo");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package bar");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import static foo.NewFoo.*");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Bar {");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("def bar() {");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("foo(1)");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("}");
        _builder_2.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/foo/NewFoo.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameUsedType_6() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package foo;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class Foo {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static void foo(int i) {}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        this.testHelper.createFile("foo/Foo.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package bar");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("import static extension foo.Foo.*");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Bar {");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("def bar() {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("1.foo");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
        IType _findJavaType = this.findJavaType("foo.Foo");
        this.renameJavaElement(_findJavaType, "NewFoo");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package bar");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import static extension foo.NewFoo.*");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Bar {");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("def bar() {");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("1.foo");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("}");
        _builder_2.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/foo/NewFoo.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Ignore
  @Test
  public void renameUsedType_7() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package a;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class A {}");
        _builder.newLine();
        this.testHelper.createFile("a/A.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package b;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("public class B {}");
        _builder_1.newLine();
        this.testHelper.createFile("b/B.java", _builder_1.toString());
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package foo");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import a.A");
        _builder_2.newLine();
        _builder_2.append("import b.B");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Foo extends A {");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("def foo() {");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("return new B");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("}");
        _builder_2.newLine();
        final IFile xtendFile = this.testHelper.createFile("foo/Foo.xtend", _builder_2.toString());
        IType _findJavaType = this.findJavaType("a.A");
        this.renameJavaElement(_findJavaType, "B");
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("package foo");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("import b.B");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("class Foo extends a.B {");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("\t");
        _builder_3.append("def foo() {");
        _builder_3.newLine();
        _builder_3.append("\t\t");
        _builder_3.append("return new B");
        _builder_3.newLine();
        _builder_3.append("\t");
        _builder_3.append("}");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("}");
        _builder_3.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_3.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/a/B.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Ignore
  @Test
  public void renameUsedType_8() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package a;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class A {}");
        _builder.newLine();
        this.testHelper.createFile("a/A.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package b;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("public class B {}");
        _builder_1.newLine();
        this.testHelper.createFile("b/B.java", _builder_1.toString());
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package foo");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import b.B");
        _builder_2.newLine();
        _builder_2.append("import a.A");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Foo extends A {");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("def foo() {");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("return new B");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("}");
        _builder_2.newLine();
        final IFile xtendFile = this.testHelper.createFile("foo/Foo.xtend", _builder_2.toString());
        IType _findJavaType = this.findJavaType("a.A");
        this.renameJavaElement(_findJavaType, "B");
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("package foo");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("import b.B");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("class Foo extends a.B {");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("\t");
        _builder_3.append("def foo() {");
        _builder_3.newLine();
        _builder_3.append("\t\t");
        _builder_3.append("return new B");
        _builder_3.newLine();
        _builder_3.append("\t");
        _builder_3.append("}");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("}");
        _builder_3.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_3.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/a/B.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Ignore
  @Test
  public void renameUsedType_9() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package a;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class A {}");
        _builder.newLine();
        this.testHelper.createFile("a/A.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package b;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("public class B {}");
        _builder_1.newLine();
        this.testHelper.createFile("b/B.java", _builder_1.toString());
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package foo");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import a.A");
        _builder_2.newLine();
        _builder_2.append("import b.B");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Foo extends B {");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("def foo() {");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("A");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("}");
        _builder_2.newLine();
        final IFile xtendFile = this.testHelper.createFile("foo/Foo.xtend", _builder_2.toString());
        IType _findJavaType = this.findJavaType("a.A");
        this.renameJavaElement(_findJavaType, "B");
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("package foo");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("import b.B");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("class Foo extends B {");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("\t");
        _builder_3.append("def foo() {");
        _builder_3.newLine();
        _builder_3.append("\t\t");
        _builder_3.append("a.B");
        _builder_3.newLine();
        _builder_3.append("\t");
        _builder_3.append("}");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("}");
        _builder_3.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_3.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/a/B.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Ignore
  @Test
  public void renameUsedType_10() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package a;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public class A {}");
        _builder.newLine();
        this.testHelper.createFile("a/A.java", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package b;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("public class B {}");
        _builder_1.newLine();
        this.testHelper.createFile("b/B.java", _builder_1.toString());
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("package foo");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("import a.A");
        _builder_2.newLine();
        _builder_2.append("import b.B");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("class Foo extends B {");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("def foo() {");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("new A");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append("}");
        _builder_2.newLine();
        final IFile xtendFile = this.testHelper.createFile("foo/Foo.xtend", _builder_2.toString());
        IType _findJavaType = this.findJavaType("a.A");
        this.renameJavaElement(_findJavaType, "B");
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("package foo");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("import b.B");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("class Foo extends B {");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("\t");
        _builder_3.append("def foo() {");
        _builder_3.newLine();
        _builder_3.append("\t\t");
        _builder_3.append("new a.B");
        _builder_3.newLine();
        _builder_3.append("\t");
        _builder_3.append("}");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("}");
        _builder_3.newLine();
        this._fileAsserts.assertFileContains(xtendFile, _builder_3.toString());
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/a/B.java");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameUsedField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static String foo;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("foo/Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package bar");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import static foo.Foo.foo");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Bar {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def bar() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("foo");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
      IType _findJavaType = this.findJavaType("foo.Foo");
      IField _field = _findJavaType.getField("foo");
      this.renameJavaElement(_field, "newFoo");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package bar");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import static foo.Foo.newFoo");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class Bar {");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def bar() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("newFoo");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameUsedField_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static String foo;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("foo/Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package bar");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import static extension foo.Foo.foo");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Bar {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def bar() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("foo");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
      IType _findJavaType = this.findJavaType("foo.Foo");
      IField _field = _findJavaType.getField("foo");
      this.renameJavaElement(_field, "newFoo");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package bar");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import static extension foo.Foo.newFoo");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class Bar {");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def bar() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("newFoo");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IType findJavaType(final String typeName) throws Exception {
    IType _xblockexpression = null;
    {
      this.syncUtil.totalSync(false);
      IProject _project = this.testHelper.getProject();
      IJavaProject _create = JavaCore.create(_project);
      _xblockexpression = _create.findType(typeName);
    }
    return _xblockexpression;
  }
  
  public void renameJavaElement(final IType javaElement, final String newName) throws Exception {
    this.syncUtil.totalSync(false);
    final RenameSupport renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES);
    IWorkbenchWindow _activeWorkbenchWindow = this.workbench.getActiveWorkbenchWindow();
    Shell _shell = _activeWorkbenchWindow.getShell();
    IWorkbenchWindow _activeWorkbenchWindow_1 = this.workbench.getActiveWorkbenchWindow();
    renameSupport.perform(_shell, _activeWorkbenchWindow_1);
    this.syncUtil.totalSync(false);
    boolean _isDisposed = this.compositeRefactoringProcessorAccess.isDisposed();
    Assert.assertTrue(_isDisposed);
  }
  
  public void renameJavaElement(final IMethod javaElement, final String newName) throws Exception {
    this.syncUtil.totalSync(false);
    final RenameSupport renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES);
    IWorkbenchWindow _activeWorkbenchWindow = this.workbench.getActiveWorkbenchWindow();
    Shell _shell = _activeWorkbenchWindow.getShell();
    IWorkbenchWindow _activeWorkbenchWindow_1 = this.workbench.getActiveWorkbenchWindow();
    renameSupport.perform(_shell, _activeWorkbenchWindow_1);
    this.syncUtil.totalSync(false);
    boolean _isDisposed = this.compositeRefactoringProcessorAccess.isDisposed();
    Assert.assertTrue(_isDisposed);
  }
  
  public void renameJavaElement(final IField javaElement, final String newName) throws Exception {
    this.syncUtil.totalSync(false);
    final RenameSupport renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES);
    IWorkbenchWindow _activeWorkbenchWindow = this.workbench.getActiveWorkbenchWindow();
    Shell _shell = _activeWorkbenchWindow.getShell();
    IWorkbenchWindow _activeWorkbenchWindow_1 = this.workbench.getActiveWorkbenchWindow();
    renameSupport.perform(_shell, _activeWorkbenchWindow_1);
    this.syncUtil.totalSync(false);
    boolean _isDisposed = this.compositeRefactoringProcessorAccess.isDisposed();
    Assert.assertTrue(_isDisposed);
  }
}
