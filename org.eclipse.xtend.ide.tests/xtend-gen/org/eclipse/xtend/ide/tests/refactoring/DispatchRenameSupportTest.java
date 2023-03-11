/**
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.refactoring;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.refactoring.DispatchRenameSupport;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class DispatchRenameSupportTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper testHelper;

  @Inject
  private DispatchRenameSupport dispatchRenameSupport;

  @Override
  public void tearDown() throws Exception {
    this.testHelper.tearDown();
    super.tearDown();
  }

  @Test
  public void testSimple() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(String x) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Integer x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile fooFile = this.testHelper.createFile("Foo", _builder.toString());
      this.checkDispatchOperations(fooFile, 
        "Foo._foo(String)", "Foo._foo(Integer)", "Foo.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSubClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Object x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(String x) {}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile subFile = this.testHelper.createFile("Sub", _builder_1.toString());
      this.checkDispatchOperations(subFile, 
        "Super.foo(Object)", "Super._foo(Double)", "Super._foo(Object)", 
        "Sub._foo(String)", "Sub._foo(Integer)", "Sub.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSuperClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Object x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile superFile = this.testHelper.createFile("Super", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(String x) {}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub", _builder_1.toString());
      this.checkDispatchOperations(superFile, 
        "Super.foo(Object)", "Super._foo(Double)", "Super._foo(Object)", 
        "Sub._foo(String)", "Sub._foo(Integer)", "Sub.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDisconnectedJavaSubClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile superFile = this.testHelper.createFile("Super", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void _foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub", _builder_1.toString());
      this.checkDispatchOperations(superFile, 
        "Super._foo(Double)", "Super.foo(Double)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJavaSuperClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void _foo(Double x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile subFile = this.testHelper.createFile("Sub", _builder_1.toString());
      this.checkDispatchOperations(subFile, 
        "Super._foo(Double)", 
        "Sub._foo(Integer)", 
        "Sub.foo(Number)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSubClassOverride() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(String x) {}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override dispatch foo(Double x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile subFile = this.testHelper.createFile("Sub", _builder_1.toString());
      this.checkDispatchOperations(subFile, 
        "Super.foo(Double)", "Super._foo(Double)", 
        "Sub._foo(String)", "Sub._foo(Double)", "Sub.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSuperClassOverride() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile superFile = this.testHelper.createFile("Super", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(String x) {}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override dispatch foo(Double x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub", _builder_1.toString());
      this.checkDispatchOperations(superFile, 
        "Super.foo(Double)", "Super._foo(Double)", 
        "Sub._foo(String)", "Sub._foo(Double)", "Sub.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSubSubClass_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Object x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class SubSub extends Sub {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final IFile subSubFile = this.testHelper.createFile("SubSub", _builder_2.toString());
      this.checkDispatchOperations(subSubFile, 
        "Super.foo(Object)", "Super._foo(Double)", "Super._foo(Object)", 
        "Sub._foo(Integer)", "Sub.foo(Object)", 
        "SubSub._foo(String)", "SubSub.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSubSubClass_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Object x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile subFile = this.testHelper.createFile("Sub", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class SubSub extends Sub {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.testHelper.createFile("SubSub", _builder_2.toString());
      this.checkDispatchOperations(subFile, 
        "Super.foo(Object)", "Super._foo(Double)", "Super._foo(Object)", 
        "Sub._foo(Integer)", "Sub.foo(Object)", 
        "SubSub._foo(String)", "SubSub.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSubSubClass_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Object x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile superFile = this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class SubSub extends Sub {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.testHelper.createFile("SubSub", _builder_2.toString());
      this.checkDispatchOperations(superFile, 
        "Super.foo(Object)", "Super._foo(Double)", "Super._foo(Object)", 
        "Sub._foo(Integer)", "Sub.foo(Object)", 
        "SubSub._foo(String)", "SubSub.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJavaInTheMiddle_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Object x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile superFile = this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void _foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub.java", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class SubSub extends Sub {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.testHelper.createFile("SubSub", _builder_2.toString());
      this.checkDispatchOperations(superFile, 
        "Super.foo(Object)", "Super._foo(Double)", "Super._foo(Object)", 
        "Sub._foo(Integer)", 
        "SubSub._foo(String)", "SubSub.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJavaInTheMiddle_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Object x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void _foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub.java", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class SubSub extends Sub {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final IFile subsubFile = this.testHelper.createFile("SubSub", _builder_2.toString());
      this.checkDispatchOperations(subsubFile, 
        "Super.foo(Object)", "Super._foo(Double)", "Super._foo(Object)", 
        "Sub._foo(Integer)", 
        "SubSub._foo(String)", "SubSub.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testConnectedSubclasses_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Object x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile superFile = this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub0 extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub0", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Sub1 extends Super {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.testHelper.createFile("Sub1", _builder_2.toString());
      this.checkDispatchOperations(superFile, 
        "Super.foo(Object)", "Super._foo(Double)", "Super._foo(Object)", 
        "Sub0._foo(Integer)", "Sub0.foo(Object)", 
        "Sub1._foo(String)", "Sub1.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testConnectedSubclasses_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Object x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub0 extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile sub0File = this.testHelper.createFile("Sub0", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Sub1 extends Super {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.testHelper.createFile("Sub1", _builder_2.toString());
      this.checkDispatchOperations(sub0File, 
        "Super.foo(Object)", "Super._foo(Double)", "Super._foo(Object)", 
        "Sub0._foo(Integer)", "Sub0.foo(Object)", 
        "Sub1._foo(String)", "Sub1.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJavaConnectedSubclasses() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void _foo(Double x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub0 extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile sub0File = this.testHelper.createFile("Sub0", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Sub1 extends Super {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.testHelper.createFile("Sub1", _builder_2.toString());
      this.checkDispatchOperations(sub0File, 
        "Super._foo(Double)", 
        "Sub0._foo(Integer)", "Sub0.foo(Number)", 
        "Sub1._foo(String)", "Sub1.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testUnconnectedSubclasses_0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub0 extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile sub0File = this.testHelper.createFile("Sub0", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Sub1 extends Super {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.testHelper.createFile("Sub1", _builder_2.toString());
      this.checkDispatchOperations(sub0File, 
        "Sub0._foo(Integer)", "Sub0.foo(Integer)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testUnconnectedSubclasses_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub0 extends Super {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def dispatch foo(Integer x) {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub0", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Sub1 extends Super {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final IFile sub1File = this.testHelper.createFile("Sub1", _builder_2.toString());
      this.checkDispatchOperations(sub1File, 
        "Sub1._foo(String)", "Sub1.foo(String)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testTreeConnected() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Object x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class SubSub0 extends Sub {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.testHelper.createFile("SubSub0", _builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("class SubSub1 extends Sub {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def dispatch foo(String x) {}");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      final IFile subsub1File = this.testHelper.createFile("SubSub1", _builder_3.toString());
      this.checkDispatchOperations(subsub1File, 
        "Super.foo(Object)", "Super._foo(Double)", "Super._foo(Object)", 
        "SubSub1._foo(String)", "SubSub1.foo(Object)", 
        "SubSub0._foo(String)", "SubSub0.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testTreeConnected_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Double x) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch foo(Object x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub.java", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class SubSub0 extends Sub {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.testHelper.createFile("SubSub0", _builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("class SubSub1 extends Sub {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def dispatch foo(String x) {}");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      final IFile subsub1File = this.testHelper.createFile("SubSub1", _builder_3.toString());
      this.checkDispatchOperations(subsub1File, 
        "Super.foo(Object)", "Super._foo(Double)", "Super._foo(Object)", 
        "SubSub1._foo(String)", "SubSub1.foo(Object)", 
        "SubSub0._foo(String)", "SubSub0.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testTreeConnected_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Super {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void _foo(Double x) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("Super.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Sub extends Super {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("Sub", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class SubSub0 extends Sub {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def dispatch foo(String x) {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.testHelper.createFile("SubSub0", _builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("class SubSub1 extends Sub {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def dispatch foo(String x) {}");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      final IFile subsub1File = this.testHelper.createFile("SubSub1", _builder_3.toString());
      this.checkDispatchOperations(subsub1File, 
        "Super._foo(Double)", 
        "SubSub1._foo(String)", "SubSub1.foo(Object)", 
        "SubSub0._foo(String)", "SubSub0.foo(Object)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public XtendFunction firstMethod(final IFile targetFile) {
    XtendFunction _xblockexpression = null;
    {
      final Resource resource = this.testHelper.getResourceSet().getResource(this.testHelper.uri(targetFile), true);
      final EObject createFile = resource.getContents().get(0);
      Assert.assertTrue((createFile instanceof XtendFile));
      XtendTypeDeclaration _get = ((XtendFile) createFile).getXtendTypes().get(0);
      final XtendClass xtendClass = ((XtendClass) _get);
      _xblockexpression = Iterables.<XtendFunction>get(Iterables.<XtendFunction>filter(xtendClass.getMembers(), XtendFunction.class), 0);
    }
    return _xblockexpression;
  }

  public void checkDispatchOperations(final IFile targetFile, final String... signatures) {
    IResourcesSetupUtil.waitForBuild();
    final Function1<JvmOperation, String> _function = (JvmOperation it) -> {
      return this.signature(it);
    };
    final Iterable<String> dispatchOperations = IterableExtensions.<JvmOperation, String>map(this.dispatchRenameSupport.getAllDispatchOperations(this.firstMethod(targetFile)), _function);
    for (final String signature : signatures) {
      String _join = IterableExtensions.join(dispatchOperations, "\n");
      String _plus = ((signature + " not found. Only got ") + _join);
      Assert.assertTrue(_plus, Iterables.contains(dispatchOperations, signature));
    }
    String _join_1 = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(signatures)), "\n");
    String _plus_1 = ("Expected " + _join_1);
    String _plus_2 = (_plus_1 + "but got ");
    String _join_2 = IterableExtensions.join(dispatchOperations, "\n");
    String _plus_3 = (_plus_2 + _join_2);
    Assert.assertEquals(_plus_3, 
      ((List<String>)Conversions.doWrapArray(signatures)).size(), Iterables.size(dispatchOperations));
  }

  public String signature(final JvmOperation it) {
    StringConcatenation _builder = new StringConcatenation();
    String _qualifiedName = it.getQualifiedName();
    _builder.append(_qualifiedName);
    _builder.append("(");
    {
      EList<JvmFormalParameter> _parameters = it.getParameters();
      boolean _hasElements = false;
      for(final JvmFormalParameter p : _parameters) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        String _simpleName = p.getParameterType().getType().getSimpleName();
        _builder.append(_simpleName);
      }
    }
    _builder.append(")");
    return _builder.toString();
  }
}
