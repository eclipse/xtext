/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.compiler;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=473833
 * 
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug473833Test extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper workbenchTestHelper;
  
  @Before
  @After
  public void cleanUp() {
    try {
      this.workbenchTestHelper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInheritedNestedTypes_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package somePackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Outer {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("static class Inner {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.workbenchTestHelper.createFile("somePackage/Outer.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package somePackage");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Outer2 extends Outer {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("somePackage/Outer2.xtend", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package myPackage");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import somePackage.Outer2.Inner");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class AnonymousClassTest extends Inner {");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("Inner inner");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final IFile file = this.workbenchTestHelper.createFile("myPackage/MyClass.xtend", _builder_2.toString());
      IResourcesSetupUtil.waitForBuild();
      this.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInheritedNestedTypes_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package somePackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Outer {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("static class Inner {");
      _builder.newLine();
      _builder.append("  \t");
      _builder.append("static class MoreInner {}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.workbenchTestHelper.createFile("somePackage/Outer.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package somePackage");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Outer2 extends Outer {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("somePackage/Outer2.xtend", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package myPackage");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import somePackage.Outer2.Inner.MoreInner");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class AnonymousClassTest extends MoreInner {");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("MoreInner moreInner");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final IFile file = this.workbenchTestHelper.createFile("myPackage/MyClass.xtend", _builder_2.toString());
      IResourcesSetupUtil.waitForBuild();
      this.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInheritedNestedTypes_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package somePackage");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Outer {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("static class Inner implements Foo{}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("interface Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static interface InnerFoo {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.workbenchTestHelper.createFile("somePackage/Outer.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package somePackage");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Outer2 extends Outer {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("somePackage/Outer2.xtend", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package myPackage");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import somePackage.Outer2.Inner.InnerFoo");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class AnonymousClassTest implements InnerFoo {");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("InnerFoo inner");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final IFile file = this.workbenchTestHelper.createFile("myPackage/MyClass.xtend", _builder_2.toString());
      IResourcesSetupUtil.waitForBuild();
      this.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInheritedNestedTypes_withJava() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package somePackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Outer {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("public static class Inner implements Foo {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.workbenchTestHelper.createFile("somePackage/Outer.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package somePackage;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("public interface Foo {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public static interface InnerFoo {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("somePackage/Foo.java", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package somePackage");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class Outer2 extends Outer {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.workbenchTestHelper.createFile("somePackage/Outer2.xtend", _builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package myPackage");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("import somePackage.Outer2.Inner.InnerFoo");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("class AnonymousClassTest implements InnerFoo {");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.append("InnerFoo inner");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      final IFile file = this.workbenchTestHelper.createFile("myPackage/MyClass.xtend", _builder_3.toString());
      IResourcesSetupUtil.waitForBuild();
      this.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertNoErrors(final IFile file) {
    try {
      final IMarker[] findMarkers = file.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      for (final IMarker iMarker : findMarkers) {
        String _message = MarkerUtilities.getMessage(iMarker);
        int _severity = MarkerUtilities.getSeverity(iMarker);
        boolean _equals = (_severity == IMarker.SEVERITY_ERROR);
        Assert.assertFalse(_message, _equals);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
