/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.builder;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.debug.IBuildLogger;
import org.eclipse.xtext.builder.debug.XtextBuildConsole;
import org.eclipse.xtext.builder.impl.QueuedBuildData;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class BuildAffectionTest {
  @Inject
  private IBuildLogger logger;
  
  @Inject
  @Extension
  private WorkbenchTestHelper workbenchTestHelper;
  
  @Inject
  private QueuedBuildData queuedBuildData;
  
  private IProject clientProject;
  
  private static boolean wasAutoBuilding;
  
  @BeforeClass
  public static void setUpProject() throws Exception {
    IResourcesSetupUtil.cleanWorkspace();
    final IWorkspace workspace = ResourcesPlugin.getWorkspace();
    final IWorkspaceDescription description = workspace.getDescription();
    boolean _isAutoBuilding = description.isAutoBuilding();
    BuildAffectionTest.wasAutoBuilding = _isAutoBuilding;
    description.setAutoBuilding(false);
    workspace.setDescription(description);
    WorkbenchTestHelper.createPluginProject(WorkbenchTestHelper.TESTPROJECT_NAME);
  }
  
  @AfterClass
  public static void tearDownProject() throws Exception {
    IResourcesSetupUtil.cleanWorkspace();
    final IWorkspace workspace = ResourcesPlugin.getWorkspace();
    final IWorkspaceDescription description = workspace.getDescription();
    description.setAutoBuilding(BuildAffectionTest.wasAutoBuilding);
    workspace.setDescription(description);
  }
  
  @Before
  public void setUp() {
    XtendActivator _instance = XtendActivator.getInstance();
    final Injector injector = _instance.getInjector("org.eclipse.xtend.core.Xtend");
    injector.injectMembers(this);
    this.queuedBuildData.reset();
  }
  
  @After
  public void tearDown() {
    try {
      boolean _notEquals = (!Objects.equal(this.clientProject, null));
      if (_notEquals) {
        WorkbenchTestHelper.deleteProject(this.clientProject);
      }
      this.workbenchTestHelper.tearDown();
      this.autoBuild();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSingleFile() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {}");
      _builder.newLine();
      this.workbenchTestHelper.createFile("Foo", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Building test.project");
      _builder_1.newLine();
      _builder_1.append("indexing platform:/resource/test.project/src/Foo.xtend");
      _builder_1.newLine();
      _builder_1.append("Build test.project in \\d+ ms");
      _builder_1.newLine();
      _builder_1.append("Building test.project");
      _builder_1.newLine();
      _builder_1.append("Build test.project in \\d+ ms");
      _builder_1.newLine();
      this.assertBuildLogs(_builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnaffected_noReferences() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar {}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class NewFoo {}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Foo.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnaffected_noReferences_Java() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Foo {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar {}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("public class NewFoo {}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnaffected_commentAdded() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("// just a comment");
      _builder_2.newLine();
      _builder_2.append("class Foo {}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Foo.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnaffected_commentAdded_Java() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Foo {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("// just a comment");
      _builder_2.newLine();
      _builder_2.append("public class Foo {}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnaffected_methodBodyChanged() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() { new Object }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Foo {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def foo() { null }");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Foo.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnaffected_methodBodyChanged_Java() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Object foo() { return new Object(); }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("public class Foo {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("public Object foo() { return null; }");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAffected_nameAddedAndDeleted() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Baz {}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Foo.xtend");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Bar.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Bar.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAffected_nameAddedAndDeleted_Java() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Foo {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("public class Baz {}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Bar.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAffected_fieldAdded() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Foo {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("int foo");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Foo.xtend");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Bar.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAffected_fieldAdded_Java() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Foo {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("boolean foo");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("public class Foo {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("int foo;");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Bar.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAffected_fieldTypeChanged() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("boolean foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Foo {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("int foo");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Foo.xtend");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Bar.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAffected_fieldTypeChanges_Java() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("boolean foo;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("public class Foo {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("int foo;");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Bar.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAffected_exportedNameAdded() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Foo {}");
      _builder_2.newLine();
      _builder_2.append("class Baz {}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Foo.xtend");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Bar.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnaffected_exportedNameAdded_Java() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Foo {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("public class Foo {}");
      _builder_2.newLine();
      _builder_2.append("class Baz {}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAffected_typeChanged() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("enum Foo {}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Foo.xtend");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Bar.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAffected_typeChanged_Java() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Foo {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Bar extends Foo {}");
      _builder_1.newLine();
      this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("public enum Foo {}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Bar.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAffected_dependentProject() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Client extends Foo {}");
      _builder_1.newLine();
      this.createClientProjectFile("Client", _builder_1);
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Foo {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("int foo;");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Foo.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.client");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.client/src/Client.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.client in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.client");
      _builder_3.newLine();
      _builder_3.append("Build test.client in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAffected_dependentProject_Java() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Foo {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Client extends Foo {}");
      _builder_1.newLine();
      this.createClientProjectFile("Client", _builder_1);
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("public class Foo {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("protected int foo;");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.client");
      _builder_3.newLine();
      _builder_3.append("Build test.client in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.client");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.client/src/Client.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.client in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.client");
      _builder_3.newLine();
      _builder_3.append("Build test.client in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAffected_dependentProject_Java_WithExpression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Foo {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Client extends Foo {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void m(String s) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("s.length");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.createClientProjectFile("Client", _builder_1);
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("public class Foo {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("protected int foo;");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.client");
      _builder_3.newLine();
      _builder_3.append("Build test.client in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.client");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.client/src/Client.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.client in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.client");
      _builder_3.newLine();
      _builder_3.append("Build test.client in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAffected_annotationProcessorChanged_singleFile() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.macro.Active");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Active(Bar)");
      _builder.newLine();
      _builder.append("annotation Foo {}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar extends AbstractClassProcessor {}");
      _builder.newLine();
      final IFile foo = this.workbenchTestHelper.createFile("Foo", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@Foo ");
      _builder_1.newLine();
      _builder_1.append("class Client {}");
      _builder_1.newLine();
      this.createClientProjectFile("Client", _builder_1);
      this.autoBuild();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
      _builder_2.newLine();
      _builder_2.append("import org.eclipse.xtend.lib.macro.Active");
      _builder_2.newLine();
      _builder_2.append("import org.eclipse.xtend.lib.macro.TransformationContext");
      _builder_2.newLine();
      _builder_2.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@Active(Bar)");
      _builder_2.newLine();
      _builder_2.append("annotation Foo {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class Bar extends AbstractClassProcessor {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("override doTransform(MutableClassDeclaration it, extension TransformationContext context) {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("addField(\'foo\', [");
      _builder_2.newLine();
      _builder_2.append("\t\t\t");
      _builder_2.append("type = int.newTypeReference");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("])");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.changeContent(foo, _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.project/src/Foo.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.client");
      _builder_3.newLine();
      _builder_3.append("indexing platform:/resource/test.client/src/Client.xtend");
      _builder_3.newLine();
      _builder_3.append("Build test.client in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.project");
      _builder_3.newLine();
      _builder_3.append("Build test.project in \\d+ ms");
      _builder_3.newLine();
      _builder_3.append("Building test.client");
      _builder_3.newLine();
      _builder_3.append("Build test.client in \\d+ ms");
      _builder_3.newLine();
      this.assertBuildLogs(_builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAffected_annotationProcessorChanged_separateFiles() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.macro.Active");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Active(Bar)");
      _builder.newLine();
      _builder.append("annotation Foo {}");
      _builder.newLine();
      this.workbenchTestHelper.createFile("Foo", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Bar extends AbstractClassProcessor {}");
      _builder_1.newLine();
      final IFile bar = this.workbenchTestHelper.createFile("Bar", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("@Foo ");
      _builder_2.newLine();
      _builder_2.append("class Client {}");
      _builder_2.newLine();
      this.createClientProjectFile("Client", _builder_2);
      this.autoBuild();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
      _builder_3.newLine();
      _builder_3.append("import org.eclipse.xtend.lib.macro.TransformationContext");
      _builder_3.newLine();
      _builder_3.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("class Bar extends AbstractClassProcessor {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("override doTransform(MutableClassDeclaration it, extension TransformationContext context) {");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("addField(\'foo\', [");
      _builder_3.newLine();
      _builder_3.append("\t\t\t");
      _builder_3.append("type = int.newTypeReference");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("])");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this.changeContent(bar, _builder_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("Building test.project");
      _builder_4.newLine();
      _builder_4.append("indexing platform:/resource/test.project/src/Bar.xtend");
      _builder_4.newLine();
      _builder_4.append("indexing platform:/resource/test.project/src/Foo.xtend");
      _builder_4.newLine();
      _builder_4.append("Build test.project in \\d+ ms");
      _builder_4.newLine();
      _builder_4.append("Building test.client");
      _builder_4.newLine();
      _builder_4.append("indexing platform:/resource/test.client/src/Client.xtend");
      _builder_4.newLine();
      _builder_4.append("Build test.client in \\d+ ms");
      _builder_4.newLine();
      _builder_4.append("Building test.project");
      _builder_4.newLine();
      _builder_4.append("Build test.project in \\d+ ms");
      _builder_4.newLine();
      _builder_4.append("Building test.client");
      _builder_4.newLine();
      _builder_4.append("Build test.client in \\d+ ms");
      _builder_4.newLine();
      this.assertBuildLogs(_builder_4);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertBuildLogs(final CharSequence expected) {
    final StringBuilder logs = new StringBuilder();
    final IBuildLogger _function = new IBuildLogger() {
      @Override
      public void log(final Object it) {
        String _string = it.toString();
        String _trim = _string.trim();
        String _plus = (_trim + "\n");
        logs.append(_plus);
      }
    };
    ((XtextBuildConsole.Logger) this.logger).registerDelegate(_function);
    this.autoBuild();
    String _string = logs.toString();
    String _trim = _string.trim();
    String _string_1 = logs.toString();
    String _trim_1 = _string_1.trim();
    String _string_2 = expected.toString();
    String _trim_2 = _string_2.trim();
    boolean _matches = _trim_1.matches(_trim_2);
    Assert.assertTrue(_trim, _matches);
  }
  
  private void autoBuild() {
    IResourcesSetupUtil.waitForBuild();
  }
  
  private void changeContent(final IFile file, final CharSequence sequence) {
    try {
      String _string = sequence.toString();
      StringInputStream _stringInputStream = new StringInputStream(_string);
      file.setContents(_stringInputStream, IResource.FORCE, null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private IFile createClientProjectFile(final String name, final CharSequence content) {
    try {
      IFile _xblockexpression = null;
      {
        IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("test.client");
        this.clientProject = _createPluginProject;
        IJavaProject _create = JavaCore.create(this.clientProject);
        IProject _project = this.workbenchTestHelper.getProject();
        IJavaProject _create_1 = JavaCore.create(_project);
        JavaProjectSetupUtil.addProjectReference(_create, _create_1);
        Path _path = new Path((("test.client/src/" + name) + ".xtend"));
        String _string = content.toString();
        _xblockexpression = IResourcesSetupUtil.createFile(_path, _string);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
