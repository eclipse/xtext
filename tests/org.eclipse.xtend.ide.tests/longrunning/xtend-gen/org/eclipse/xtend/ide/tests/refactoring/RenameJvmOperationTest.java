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
public class RenameJvmOperationTest extends AbstractXtendUITestCase {
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
  public void renameUnusedMethod() {
    this.renameUnusedMethod(false);
  }
  
  @Test
  public void renameUnusedMethod_2() {
    this.renameUnusedMethod(true);
  }
  
  public void renameUnusedMethod(final boolean extension) {
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
      _builder_1.append("import static ");
      {
        if (extension) {
          _builder_1.append("extension ");
        }
      }
      _builder_1.append("foo.Foo.foo");
      _builder_1.newLineIfNotEmpty();
      _builder_1.newLine();
      _builder_1.append("class Bar {}");
      _builder_1.newLine();
      final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
      IType _findJavaType = this.findJavaType("foo.Foo");
      IMethod _method = _findJavaType.getMethod("foo", new String[] {});
      this.renameJavaElement(_method, "newFoo");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package bar");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import static ");
      {
        if (extension) {
          _builder_2.append("extension ");
        }
      }
      _builder_2.append("foo.Foo.newFoo");
      _builder_2.newLineIfNotEmpty();
      _builder_2.newLine();
      _builder_2.append("class Bar {}");
      _builder_2.newLine();
      this._fileAsserts.assertFileContains(xtendFile, _builder_2.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameSingleMethod() {
    this.renameSingleMethod(false, false, false);
  }
  
  @Test
  public void renameSingleMethod_2() {
    this.renameSingleMethod(false, true, false);
  }
  
  @Test
  public void renameSingleMethod_3() {
    this.renameSingleMethod(false, true, true);
  }
  
  @Test
  public void renameSingleMethod_4() {
    this.renameSingleMethod(true, false, false);
  }
  
  @Test
  public void renameSingleMethod_5() {
    this.renameSingleMethod(true, true, false);
  }
  
  @Test
  public void renameSingleMethod_6() {
    this.renameSingleMethod(true, true, true);
  }
  
  public void renameSingleMethod(final boolean wildcard, final boolean extension, final boolean extensionAccess) {
    try {
      Assert.assertTrue("extension access is not possible without extension import", (extension || (!extensionAccess)));
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
      _builder_1.append("import static ");
      {
        if (extension) {
          _builder_1.append("extension ");
        }
      }
      _builder_1.append("foo.Foo.");
      {
        if (wildcard) {
          _builder_1.append("*");
        } else {
          _builder_1.append("foo");
        }
      }
      _builder_1.newLineIfNotEmpty();
      _builder_1.newLine();
      _builder_1.append("class Bar {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def bar() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      {
        if (extensionAccess) {
          _builder_1.append("1.foo");
        } else {
          _builder_1.append("foo(1)");
        }
      }
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
      IType _findJavaType = this.findJavaType("foo.Foo");
      IMethod _method = _findJavaType.getMethod("foo", new String[] { "I" });
      this.renameJavaElement(_method, "newFoo");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package bar");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import static ");
      {
        if (extension) {
          _builder_2.append("extension ");
        }
      }
      _builder_2.append("foo.Foo.");
      {
        if (wildcard) {
          _builder_2.append("*");
        } else {
          _builder_2.append("newFoo");
        }
      }
      _builder_2.newLineIfNotEmpty();
      _builder_2.newLine();
      _builder_2.append("class Bar {");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def bar() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      {
        if (extensionAccess) {
          _builder_2.append("1.newFoo");
        } else {
          _builder_2.append("newFoo(1)");
        }
      }
      _builder_2.newLineIfNotEmpty();
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
  public void renameOverloadedMethod() {
    this.renameOverloadedMethod(false, false, false);
  }
  
  @Test
  public void renameOverloadedMethod_2() {
    this.renameOverloadedMethod(false, true, false);
  }
  
  @Test
  public void renameOverloadedMethod_3() {
    this.renameOverloadedMethod(false, true, true);
  }
  
  @Test
  public void renameOverloadedMethod_4() {
    this.renameOverloadedMethod(true, false, false);
  }
  
  @Test
  public void renameOverloadedMethod_5() {
    this.renameOverloadedMethod(true, true, false);
  }
  
  @Test
  public void renameOverloadedMethod_6() {
    this.renameOverloadedMethod(true, true, true);
  }
  
  public void renameOverloadedMethod(final boolean wildcard, final boolean extension, final boolean extensionAccess) {
    try {
      Assert.assertTrue("extension access is not possible without extension import", (extension || (!extensionAccess)));
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
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void foo(String i) {}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("foo/Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package bar");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import static ");
      {
        if (extension) {
          _builder_1.append("extension ");
        }
      }
      _builder_1.append("foo.Foo.");
      {
        if (wildcard) {
          _builder_1.append("*");
        } else {
          _builder_1.append("foo");
        }
      }
      _builder_1.newLineIfNotEmpty();
      _builder_1.newLine();
      _builder_1.append("class Bar {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def withInteger() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      {
        if (extensionAccess) {
          _builder_1.append("1.foo");
        } else {
          _builder_1.append("foo(1)");
        }
      }
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def withString() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      {
        if (extensionAccess) {
          _builder_1.append("\"lalala\".foo");
        } else {
          _builder_1.append("foo(\"lalala\")");
        }
      }
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
      IType _findJavaType = this.findJavaType("foo.Foo");
      IMethod _method = _findJavaType.getMethod("foo", new String[] { "I" });
      this.renameJavaElement(_method, "newFoo");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package bar");
      _builder_2.newLine();
      _builder_2.newLine();
      {
        if (wildcard) {
          _builder_2.append("import static ");
          {
            if (extension) {
              _builder_2.append("extension ");
            }
          }
          _builder_2.append("foo.Foo.*");
          _builder_2.newLineIfNotEmpty();
        } else {
          _builder_2.append("import static ");
          {
            if (extension) {
              _builder_2.append("extension ");
            }
          }
          _builder_2.append("foo.Foo.foo");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("import static ");
          {
            if (extension) {
              _builder_2.append("extension ");
            }
          }
          _builder_2.append("foo.Foo.newFoo");
          _builder_2.newLineIfNotEmpty();
        }
      }
      _builder_2.newLine();
      _builder_2.append("class Bar {");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def withInteger() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      {
        if (extensionAccess) {
          _builder_2.append("1.newFoo");
        } else {
          _builder_2.append("newFoo(1)");
        }
      }
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def withString() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      {
        if (extensionAccess) {
          _builder_2.append("\"lalala\".foo");
        } else {
          _builder_2.append("foo(\"lalala\")");
        }
      }
      _builder_2.newLineIfNotEmpty();
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
  public void renameToOverloadedImport() {
    this.renameToOverloadedImport(false, false, false, false);
  }
  
  @Test
  public void renameToOverloadedImport_2() {
    this.renameToOverloadedImport(false, false, true, false);
  }
  
  @Test
  public void renameToOverloadedImport_3() {
    this.renameToOverloadedImport(false, false, true, true);
  }
  
  @Test
  public void renameToOverloadedImport_4() {
    this.renameToOverloadedImport(true, false, false, false);
  }
  
  @Test
  public void renameToOverloadedImport_5() {
    this.renameToOverloadedImport(true, false, true, false);
  }
  
  @Test
  public void renameToOverloadedImport_6() {
    this.renameToOverloadedImport(true, false, true, true);
  }
  
  @Test
  public void renameToOverloadedImport_7() {
    this.renameToOverloadedImport(true, true, false, false);
  }
  
  @Test
  public void renameToOverloadedImport_8() {
    this.renameToOverloadedImport(true, true, true, false);
  }
  
  @Test
  public void renameToOverloadedImport_9() {
    this.renameToOverloadedImport(true, true, true, true);
  }
  
  public void renameToOverloadedImport(final boolean extension, final boolean extensionAccess, final boolean extension2, final boolean extensionAccess2) {
    try {
      Assert.assertTrue("extension access is not possible without extension import", (extension || (!extensionAccess)));
      Assert.assertTrue("extension access is not possible without extension import", (extension2 || (!extensionAccess2)));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void newFoo(int i) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void foo(String i) {}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("foo/Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package bar");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import static ");
      {
        if (extension) {
          _builder_1.append("extension ");
        }
      }
      _builder_1.append("foo.Foo.foo");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("import static ");
      {
        if (extension2) {
          _builder_1.append("extension ");
        }
      }
      _builder_1.append("foo.Foo.newFoo");
      _builder_1.newLineIfNotEmpty();
      _builder_1.newLine();
      _builder_1.append("class Bar {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def withInteger() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      {
        if (extensionAccess2) {
          _builder_1.append("1.newFoo");
        } else {
          _builder_1.append("newFoo(1)");
        }
      }
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def withString() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      {
        if (extensionAccess) {
          _builder_1.append("\"lalala\".foo");
        } else {
          _builder_1.append("foo(\"lalala\")");
        }
      }
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_1.toString());
      IType _findJavaType = this.findJavaType("foo.Foo");
      IMethod _method = _findJavaType.getMethod("newFoo", new String[] { "I" });
      this.renameJavaElement(_method, "foo");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package bar");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import static ");
      {
        boolean _or = false;
        if (extension) {
          _or = true;
        } else {
          _or = extension2;
        }
        if (_or) {
          _builder_2.append("extension ");
        }
      }
      _builder_2.append("foo.Foo.foo");
      _builder_2.newLineIfNotEmpty();
      _builder_2.newLine();
      _builder_2.append("class Bar {");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def withInteger() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      {
        if (extensionAccess2) {
          _builder_2.append("1.foo");
        } else {
          _builder_2.append("foo(1)");
        }
      }
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def withString() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      {
        if (extensionAccess) {
          _builder_2.append("\"lalala\".foo");
        } else {
          _builder_2.append("foo(\"lalala\")");
        }
      }
      _builder_2.newLineIfNotEmpty();
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
  public void renameFeatureNameConflicts() {
    this.renameFeatureNameConflicts(false, false, false, false);
  }
  
  @Test
  public void renameFeatureNameConflicts_2() {
    this.renameFeatureNameConflicts(false, false, true, false);
  }
  
  @Test
  public void renameFeatureNameConflicts_3() {
    this.renameFeatureNameConflicts(false, false, true, true);
  }
  
  @Test
  public void renameFeatureNameConflicts_4() {
    this.renameFeatureNameConflicts(true, false, false, false);
  }
  
  @Test
  public void renameFeatureNameConflicts_5() {
    this.renameFeatureNameConflicts(true, false, true, false);
  }
  
  @Test
  public void renameFeatureNameConflicts_6() {
    this.renameFeatureNameConflicts(true, false, true, true);
  }
  
  @Test
  public void renameFeatureNameConflicts_7() {
    this.renameFeatureNameConflicts(true, true, false, false);
  }
  
  @Ignore("Invalid extension access")
  @Test
  public void renameFeatureNameConflicts_8() {
    this.renameFeatureNameConflicts(true, true, true, false);
  }
  
  @Ignore("Invalid extension access")
  @Test
  public void renameFeatureNameConflicts_9() {
    this.renameFeatureNameConflicts(true, true, true, true);
  }
  
  public void renameFeatureNameConflicts(final boolean extension, final boolean extensionAccess, final boolean extension2, final boolean extensionAccess2) {
    try {
      Assert.assertTrue("extension access is not possible without extension import", (extension || (!extensionAccess)));
      Assert.assertTrue("extension access is not possible without extension import", (extension2 || (!extensionAccess2)));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package a;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class A {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void a(int i) {}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("a/A.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package b;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("public class B {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public static void b(int i) {}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("b/B.java", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package bar");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import static ");
      {
        if (extension2) {
          _builder_2.append("extension ");
        }
      }
      _builder_2.append("a.A.a");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("import static ");
      {
        if (extension) {
          _builder_2.append("extension ");
        }
      }
      _builder_2.append("b.B.b");
      _builder_2.newLineIfNotEmpty();
      _builder_2.newLine();
      _builder_2.append("class Bar {");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def withA() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      {
        if (extensionAccess2) {
          _builder_2.append("1.a");
        } else {
          _builder_2.append("a(1)");
        }
      }
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def withB() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      {
        if (extensionAccess) {
          _builder_2.append("1.b");
        } else {
          _builder_2.append("b(1)");
        }
      }
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_2.toString());
      IType _findJavaType = this.findJavaType("b.B");
      IMethod _method = _findJavaType.getMethod("b", new String[] { "I" });
      this.renameJavaElement(_method, "a");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package bar");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("import static ");
      {
        if (extension2) {
          _builder_3.append("extension ");
        }
      }
      _builder_3.append("a.A.a");
      _builder_3.newLineIfNotEmpty();
      {
        if (((extension == extension2) || (extensionAccess == extensionAccess2))) {
          _builder_3.append("import b.B");
          _builder_3.newLine();
        } else {
          _builder_3.append("import static ");
          {
            if (extensionAccess) {
              _builder_3.append("extension ");
            }
          }
          _builder_3.append("b.B.a");
          _builder_3.newLineIfNotEmpty();
        }
      }
      _builder_3.newLine();
      _builder_3.append("class Bar {");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def withA() {");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      {
        if (extensionAccess2) {
          _builder_3.append("1.a");
        } else {
          _builder_3.append("a(1)");
        }
      }
      _builder_3.newLineIfNotEmpty();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def withB() {");
      _builder_3.newLine();
      {
        if (((extension == extension2) || (extensionAccess == extensionAccess2))) {
          _builder_3.append("\t\t");
          _builder_3.append("B.a(1)");
          _builder_3.newLine();
        } else {
          _builder_3.append("\t\t");
          {
            if (extensionAccess) {
              _builder_3.append("1.a");
            } else {
              _builder_3.append("a(1)");
            }
          }
          _builder_3.newLineIfNotEmpty();
        }
      }
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this._fileAsserts.assertFileContains(xtendFile, _builder_3.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameTypeNameConflict() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package a;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class A {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void a(int i) {}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("a/A.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package b;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("public class B {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public static void b(int i) {}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("b/B.java", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package b;");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("public class B {}");
      _builder_2.newLine();
      this.testHelper.createFile("c/B.java", _builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package bar");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("import static a.A.a");
      _builder_3.newLine();
      _builder_3.append("import static b.B.b");
      _builder_3.newLine();
      _builder_3.append("import c.B");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("class Bar {");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def withA() {");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("a(1)");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def withB() {");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("b(1)");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_3.toString());
      IType _findJavaType = this.findJavaType("b.B");
      IMethod _method = _findJavaType.getMethod("b", new String[] { "I" });
      this.renameJavaElement(_method, "a");
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("package bar");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("import static a.A.a");
      _builder_4.newLine();
      _builder_4.append("import c.B");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("class Bar {");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("def withA() {");
      _builder_4.newLine();
      _builder_4.append("\t\t");
      _builder_4.append("a(1)");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("}");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("def withB() {");
      _builder_4.newLine();
      _builder_4.append("\t\t");
      _builder_4.append("b.B.a(1)");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("}");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("}");
      _builder_4.newLine();
      this._fileAsserts.assertFileContains(xtendFile, _builder_4.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameTypeNameConflict_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package a;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class A {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void a(int i) {}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("a/A.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package b;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("public class B {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public static void b(int i) {}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("b/B.java", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package bar");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import static a.A.a");
      _builder_2.newLine();
      _builder_2.append("import static b.B.b");
      _builder_2.newLine();
      _builder_2.append("import b.B");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class Bar {");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def withA() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("a(1)");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def withB() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("b(1)");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_2.toString());
      IType _findJavaType = this.findJavaType("b.B");
      IMethod _method = _findJavaType.getMethod("b", new String[] { "I" });
      this.renameJavaElement(_method, "a");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package bar");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("import static a.A.a");
      _builder_3.newLine();
      _builder_3.append("import b.B");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("class Bar {");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def withA() {");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("a(1)");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def withB() {");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("B.a(1)");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this._fileAsserts.assertFileContains(xtendFile, _builder_3.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameTypeNameConflict_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package a;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class A {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void a(int i) {}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("a/A.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package b;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("public class B {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public static class D {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("public static void d(int i) {}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("b/B.java", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package d;");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("public class D {}");
      _builder_2.newLine();
      this.testHelper.createFile("d/D.java", _builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package bar");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("import static a.A.a");
      _builder_3.newLine();
      _builder_3.append("import static b.B.D.d");
      _builder_3.newLine();
      _builder_3.append("import d.D");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("class Bar {");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def withA() {");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("a(1)");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def withD() {");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("d(1)");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_3.toString());
      IType _findJavaType = this.findJavaType("b.B.D");
      IMethod _method = _findJavaType.getMethod("d", new String[] { "I" });
      this.renameJavaElement(_method, "a");
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("package bar");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("import static a.A.a");
      _builder_4.newLine();
      _builder_4.append("import d.D");
      _builder_4.newLine();
      _builder_4.append("import b.B");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("class Bar {");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("def withA() {");
      _builder_4.newLine();
      _builder_4.append("\t\t");
      _builder_4.append("a(1)");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("}");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("def withD() {");
      _builder_4.newLine();
      _builder_4.append("\t\t");
      _builder_4.append("B.D.a(1)");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("}");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("}");
      _builder_4.newLine();
      this._fileAsserts.assertFileContains(xtendFile, _builder_4.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameTypeNameConflict_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package a;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class A {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void a(int i) {}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("a/A.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package b;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("public class B {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public static class D {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("public static void d(int i) {}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("b/B.java", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package bar");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import static a.A.a");
      _builder_2.newLine();
      _builder_2.append("import static b.B.D.d");
      _builder_2.newLine();
      _builder_2.append("import b.B");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class Bar {");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def withA() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("a(1)");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def withD() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("d(1)");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_2.toString());
      IType _findJavaType = this.findJavaType("b.B.D");
      IMethod _method = _findJavaType.getMethod("d", new String[] { "I" });
      this.renameJavaElement(_method, "a");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package bar");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("import static a.A.a");
      _builder_3.newLine();
      _builder_3.append("import b.B");
      _builder_3.newLine();
      _builder_3.append("import b.B.D");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("class Bar {");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def withA() {");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("a(1)");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def withD() {");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("D.a(1)");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this._fileAsserts.assertFileContains(xtendFile, _builder_3.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void renameTypeNameConflict_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package a;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class A {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void a(int i) {}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("a/A.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package b;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("public class B {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public static class D {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("public static void d(int i) {}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("b/B.java", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package bar");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import static a.A.a");
      _builder_2.newLine();
      _builder_2.append("import static b.B.D.d");
      _builder_2.newLine();
      _builder_2.append("import b.B.D");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class Bar {");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def withA() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("a(1)");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def withD() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("d(1)");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final IFile xtendFile = this.testHelper.createFile("bar/Bar.xtend", _builder_2.toString());
      IType _findJavaType = this.findJavaType("b.B.D");
      IMethod _method = _findJavaType.getMethod("d", new String[] { "I" });
      this.renameJavaElement(_method, "a");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package bar");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("import static a.A.a");
      _builder_3.newLine();
      _builder_3.append("import b.B.D");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("class Bar {");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def withA() {");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("a(1)");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def withD() {");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("D.a(1)");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this._fileAsserts.assertFileContains(xtendFile, _builder_3.toString());
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
