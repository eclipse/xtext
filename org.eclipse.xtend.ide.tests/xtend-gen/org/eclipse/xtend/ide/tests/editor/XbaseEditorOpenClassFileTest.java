/**
 * Copyright (c) 2013, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.common.io.ByteStreams;
import com.google.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.text.IRewriteTarget;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@Log
@SuppressWarnings("all")
public class XbaseEditorOpenClassFileTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper helper;

  private IProject project;

  @Before
  @Override
  public void setUp() {
    try {
      super.setUp();
      this.project = WorkbenchTestHelper.createPluginProject("my.example.project");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @After
  @Override
  public void tearDown() {
    try {
      this.helper.tearDown();
      this.project.delete(true, null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOpenFileFromSmapJarWithIncludedSource() {
    try {
      final IJavaProject jp = JavaCore.create(this.project);
      final IPackageFragmentRoot root = this.addJarToClassPath(jp, "smap-all.jar", null);
      Assert.assertNotNull(root);
      final IType type = jp.findType("de.itemis.HelloXtend");
      Assert.assertNotNull(type);
      final String result = this.getEditorContents(type);
      this.assertContains("println(\'Hello Xtend!\')", result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOpenFileFromSmapJarWithAttachedSource() {
    try {
      final IProject project = WorkbenchTestHelper.createPluginProject("my.example.project");
      final IJavaProject jp = JavaCore.create(project);
      final IPackageFragmentRoot root = this.addJarToClassPath(jp, "smap-binary.jar", "smap-sources.jar");
      Assert.assertNotNull(root);
      final IType type = jp.findType("de.itemis.HelloXtend");
      Assert.assertNotNull(type);
      final String result = this.getEditorContents(type);
      this.assertContains("println(\'Hello Xtend!\')", result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOpenFileFromJarWithAttachedSource() {
    try {
      final IJavaProject jp = JavaCore.create(this.project);
      final IPackageFragmentRoot root = this.addJarToClassPath(jp, "primary-debug-binary.jar", "primary-debug-sources.jar");
      Assert.assertNotNull(root);
      final IType type = jp.findType("de.itemis.HelloXtend");
      Assert.assertNotNull(type);
      final String result = this.getEditorContents(type);
      this.assertContains("println(\'Hello Xtend!\')", result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOpenFileFromJarWithNameConflictingLocalFile() {
    try {
      final IJavaProject jp = JavaCore.create(this.project);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.append("class HelloXtend {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// wrong class");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.helper.createFile("foo/HelloXtend.xtend", _builder.toString());
      final IPackageFragmentRoot root = this.addJarToClassPath(jp, "primary-debug-binary.jar", "primary-debug-sources.jar");
      Assert.assertNotNull(root);
      final IType type = jp.findType("de.itemis.HelloXtend");
      Assert.assertNotNull(type);
      final String result = this.getEditorContents(type);
      this.assertContains("println(\'Hello Xtend!\')", result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOpenEditor_NameConflict() {
    try {
      final IJavaProject jp = JavaCore.create(this.project);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// Xtend");
      _builder.newLine();
      _builder.append("package myPackage");
      _builder.newLine();
      _builder.append("class Foo {}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("myPackage/Foo.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("// Java");
      _builder_1.newLine();
      _builder_1.append("package otherPackage;");
      _builder_1.newLine();
      _builder_1.append("public class Foo {}");
      _builder_1.newLine();
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("otherPackage/Foo.java", _builder_1.toString());
      this.addJarToProject(this.project, 
        this.createJar(_mappedTo, _mappedTo_1));
      IResourcesSetupUtil.waitForBuild();
      final IType type = jp.findType("otherPackage.Foo");
      Assert.assertNotNull(type);
      final String result = this.getEditorContents(type);
      this.assertContains("// Java", result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOpenEditor_NameConflict02() {
    try {
      final IJavaProject jp = JavaCore.create(this.project);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// Xtend");
      _builder.newLine();
      _builder.append("package myPackage");
      _builder.newLine();
      _builder.append("class Foo {}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("myPackage/Foo.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("// Java");
      _builder_1.newLine();
      _builder_1.append("package otherPackage;");
      _builder_1.newLine();
      _builder_1.append("public class Foo {}");
      _builder_1.newLine();
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("otherPackage/Foo.java", _builder_1.toString());
      this.addJarToProject(this.project, 
        this.createJar(_mappedTo, _mappedTo_1));
      IResourcesSetupUtil.waitForBuild();
      final IType type = jp.findType("myPackage.Foo");
      Assert.assertNotNull(type);
      final String result = this.getEditorContents(type);
      this.assertContains("package myPackage;", result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOpenEditor_NameConflict03() {
    try {
      final IJavaProject jp = JavaCore.create(this.project);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// Xtend");
      _builder.newLine();
      _builder.append("package myPackage");
      _builder.newLine();
      _builder.append("class Foo2 {}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("myPackage/Foo.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("// Java");
      _builder_1.newLine();
      _builder_1.append("package otherPackage;");
      _builder_1.newLine();
      _builder_1.append("public class Foo {}");
      _builder_1.newLine();
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("otherPackage/Foo.java", _builder_1.toString());
      this.addJarToProject(this.project, 
        this.createJar(_mappedTo, _mappedTo_1));
      IResourcesSetupUtil.waitForBuild();
      final IType type = jp.findType("myPackage.Foo2");
      Assert.assertNotNull(type);
      final String result = this.getEditorContents(type);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("// Xtend");
      _builder_2.newLine();
      _builder_2.append("package myPackage");
      _builder_2.newLine();
      _builder_2.append("class Foo2 {}");
      _builder_2.newLine();
      this.assertContains(_builder_2.toString(), result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOpenEditor4NestedType_NameConflict() {
    try {
      final IJavaProject jp = JavaCore.create(this.project);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// Xtend");
      _builder.newLine();
      _builder.append("package myPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static class MyInnerClass {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("myPackage/Foo.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("// Java");
      _builder_1.newLine();
      _builder_1.append("package otherPackage;");
      _builder_1.newLine();
      _builder_1.append("public class Foo {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("static class MyInnerClass {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("otherPackage/Foo.java", _builder_1.toString());
      this.addJarToProject(this.project, 
        this.createJar(_mappedTo, _mappedTo_1));
      IResourcesSetupUtil.waitForBuild();
      final IType type = jp.findType("myPackage.Foo.MyInnerClass");
      Assert.assertNotNull(type);
      final String result = this.getEditorContents(type);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package myPackage;");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@SuppressWarnings(\"all\")");
      _builder_2.newLine();
      _builder_2.append("public class Foo {");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("public static class MyInnerClass {");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      Assert.assertEquals(_builder_2.toString(), result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOpenEditor4NestedType_NoNameConflict() {
    try {
      final IJavaProject jp = JavaCore.create(this.project);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// Xtend");
      _builder.newLine();
      _builder.append("package myPackage");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static class MyInnerClass {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("myPackage/Foo.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("// Java");
      _builder_1.newLine();
      _builder_1.append("package otherPackage;");
      _builder_1.newLine();
      _builder_1.append("public class Bar {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("static class MyInnerClass2 {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("otherPackage/Bar.java", _builder_1.toString());
      this.addJarToProject(this.project, 
        this.createJar(_mappedTo, _mappedTo_1));
      IResourcesSetupUtil.waitForBuild();
      final IType type = jp.findType("myPackage.Foo.MyInnerClass");
      Assert.assertNotNull(type);
      final String result = this.getEditorContents(type);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("// Xtend");
      _builder_2.newLine();
      _builder_2.append("package myPackage");
      _builder_2.newLine();
      _builder_2.append("class Foo {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("static class MyInnerClass {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.assertContains(_builder_2.toString(), result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected IClasspathEntry addJarToProject(final IProject project, final byte[] jarData) {
    try {
      IClasspathEntry _xblockexpression = null;
      {
        final IFile jarFile = project.getFile("mydependency.jar");
        ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(jarData);
        jarFile.create(_byteArrayInputStream, true, null);
        _xblockexpression = JavaProjectSetupUtil.addJarToClasspath(JavaCore.create(project), jarFile);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public byte[] createJar(final Pair<? extends String, ? extends String>... sourceFiles) {
    try {
      final IProject project = WorkbenchTestHelper.createPluginProject("my.temporary.data.project", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.lib");
      final HashMap<String, InputStream> listOfContents = CollectionLiterals.<String, InputStream>newHashMap();
      try {
        final IFolder folder = JavaProjectSetupUtil.addSourceFolder(JavaCore.create(project), "src");
        JavaProjectSetupUtil.addSourceFolder(JavaCore.create(project), "xtend-gen");
        for (final Pair<? extends String, ? extends String> sourceFile : sourceFiles) {
          IResourcesSetupUtil.createFile(folder.getFullPath().append(sourceFile.getKey()), sourceFile.getValue());
        }
        IResourcesSetupUtil.waitForBuild();
        final IResourceVisitor _function = (IResource it) -> {
          if ((it instanceof IFile)) {
            final String path = ((IFile)it).getProjectRelativePath().removeFirstSegments(1).toString();
            boolean _containsKey = listOfContents.containsKey(path);
            boolean _not = (!_containsKey);
            if (_not) {
              listOfContents.put(path, ((IFile)it).getContents());
            }
          }
          return true;
        };
        final IResourceVisitor visitor = _function;
        project.getFolder("src").accept(visitor);
        project.getFolder("xtend-gen").accept(visitor);
        project.getFolder("bin").accept(visitor);
        final Function1<Map.Entry<String, InputStream>, Pair<String, InputStream>> _function_1 = (Map.Entry<String, InputStream> it) -> {
          String _key = it.getKey();
          InputStream _value = it.getValue();
          return Pair.<String, InputStream>of(_key, _value);
        };
        final InputStream jarin = JavaProjectSetupUtil.jarInputStream(((Pair<String, InputStream>[])Conversions.unwrapArray(IterableExtensions.<Pair<String, InputStream>>toList(IterableExtensions.<Map.Entry<String, InputStream>, Pair<String, InputStream>>map(listOfContents.entrySet(), _function_1)), Pair.class)));
        return ByteStreams.toByteArray(jarin);
      } finally {
        final Consumer<InputStream> _function_2 = (InputStream it) -> {
          try {
            it.close();
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        };
        listOfContents.values().forEach(_function_2);
        project.delete(true, true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void assertContains(final String substring, final String container) {
    boolean _contains = container.contains(substring);
    boolean _not = (!_contains);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Substring \'");
      _builder.append(substring);
      _builder.append("\' not found in");
      _builder.newLineIfNotEmpty();
      _builder.append("-----------");
      _builder.newLine();
      _builder.append(container);
      _builder.newLineIfNotEmpty();
      _builder.append("-----------");
      _builder.newLine();
      Assert.fail(_builder.toString());
    }
  }

  public IPackageFragmentRoot addJarToClassPath(final IJavaProject jp, final String fileName, final String fileNameOfSource) {
    try {
      IProject _project = jp.getProject();
      Path _path = new Path(fileName);
      final IFile jarFile = _project.getFile(_path);
      jarFile.create(this.getClass().getResourceAsStream(fileName), true, null);
      IFile _xifexpression = null;
      if ((fileNameOfSource != null)) {
        IFile _xblockexpression = null;
        {
          IProject _project_1 = jp.getProject();
          Path _path_1 = new Path(fileNameOfSource);
          final IFile source = _project_1.getFile(_path_1);
          source.create(this.getClass().getResourceAsStream(fileNameOfSource), true, null);
          _xblockexpression = source;
        }
        _xifexpression = _xblockexpression;
      }
      final IFile sourceFile = _xifexpression;
      IPath _fullPath = jarFile.getFullPath();
      IPath _fullPath_1 = null;
      if (sourceFile!=null) {
        _fullPath_1=sourceFile.getFullPath();
      }
      final IClasspathEntry cp = JavaCore.newLibraryEntry(_fullPath, _fullPath_1, null);
      JavaProjectSetupUtil.addToClasspath(jp, cp);
      return JavaCore.createJarPackageFragmentRootFrom(jarFile);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public String getEditorContents(final IJavaElement javaElement) {
    try {
      final IEditorPart editor = JavaUI.openInEditor(javaElement);
      final Object adapter = editor.<IRewriteTarget>getAdapter(IRewriteTarget.class);
      final String text = ((IRewriteTarget) adapter).getDocument().get();
      this.helper.closeEditor(editor, false);
      return text;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private static final Logger LOG = Logger.getLogger(XbaseEditorOpenClassFileTest.class);
}
