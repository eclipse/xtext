/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.builder;

import com.google.common.io.ByteStreams;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtendIDEInjectorProvider.class)
@SuppressWarnings("all")
public class WorkspaceScenariosTest {
  @BeforeClass
  public static void setupTargetPlatform() {
    try {
      TargetPlatformUtil.setTargetPlatform(WorkspaceScenariosTest.class);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Inject
  @Named(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS)
  private Provider<IResourceDescriptions> persistedResourceDescriptions;

  @Test
  public void testJarWithEverything() {
    try {
      final Function1<String, Boolean> _function = (String it) -> {
        return Boolean.valueOf(false);
      };
      final IProject project = this.createProjectWithJarDependency(_function);
      try {
        IResourcesSetupUtil.assertNoErrorsInWorkspace();
        Assert.assertEquals(1, ((Object[])Conversions.unwrapArray(this.persistedResourceDescriptions.get().getAllResourceDescriptions(), Object.class)).length);
      } finally {
        project.delete(true, true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testJarWithoutJava() {
    try {
      final Function1<String, Boolean> _function = (String it) -> {
        return Boolean.valueOf((it.endsWith("java") || it.endsWith("class")));
      };
      final IProject project = this.createProjectWithJarDependency(_function);
      try {
        final ArrayList<IMarker> allXtendMarkers = CollectionLiterals.<IMarker>newArrayList();
        final IResourceVisitor _function_1 = (IResource it) -> {
          if ((it instanceof IFile)) {
            boolean _endsWith = ((IFile)it).getFullPath().lastSegment().endsWith(".xtend");
            if (_endsWith) {
              final IMarker[] markers = ((IFile)it).findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
              for (final IMarker m : markers) {
                allXtendMarkers.add(m);
              }
            }
          }
          return true;
        };
        project.accept(_function_1);
        Assert.assertEquals(IResourcesSetupUtil.printMarker(((IMarker[])Conversions.unwrapArray(allXtendMarkers, IMarker.class))), 2, allXtendMarkers.size());
        Assert.assertEquals(1, ((Object[])Conversions.unwrapArray(this.persistedResourceDescriptions.get().getAllResourceDescriptions(), Object.class)).length);
      } finally {
        project.delete(true, true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIncrementalChangeOnBidirectionalDep() {
    try {
      WorkbenchTestHelper.createPluginProject("my.project", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.lib");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypack");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class ClassA {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void myMethod(ClassB b) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("b.myMethod");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile fileA = IResourcesSetupUtil.createFile("my.project/src/mypack/ClassA.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypack");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class ClassB {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void anotherMethod(ClassA a) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("a.anotherMethod");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      IResourcesSetupUtil.createFile("my.project/src/mypack/ClassB.xtend", _builder_1.toString());
      IResourcesSetupUtil.waitForBuild();
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
      final IFile javaB = fileA.getProject().getFile("xtend-gen/mypack/ClassB.java");
      Assert.assertTrue(WorkbenchTestHelper.getContentsAsString(javaB).contains("anotherMethod(a);"));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package mypack");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class ClassA {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def void myMethod(ClassB b) {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("b.myMethod");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def void anotherMethod() {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      StringInputStream _stringInputStream = new StringInputStream(_builder_2.toString());
      fileA.setContents(_stringInputStream, true, true, null);
      IResourcesSetupUtil.waitForBuild();
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
      Assert.assertTrue(WorkbenchTestHelper.getContentsAsString(javaB).contains("a.anotherMethod();"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected IProject createProjectWithJarDependency(final Function1<? super String, ? extends Boolean> jarFilter) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypack");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Data class MyData {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String someProp");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int anotherProp");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("mypack/MyData.xtend", _builder.toString());
      final byte[] jarData = this.createJar(
        Collections.<Pair<? extends String, ? extends String>>unmodifiableList(CollectionLiterals.<Pair<? extends String, ? extends String>>newArrayList(_mappedTo)), jarFilter);
      final IProject project = WorkbenchTestHelper.createPluginProject("my.project", "org.eclipse.xtext.xbase.lib");
      this.addJarToProject(project, jarData);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package pack");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import mypack.MyData");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class MyClass {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def String myMethod() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("val myData = new MyData(\'foo\', 42)");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("return myData.getSomeProp() + myData.getAnotherProp()");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      IResourcesSetupUtil.createFile("my.project/src/pack/MyClass.xtend", _builder_1.toString());
      IResourcesSetupUtil.waitForBuild();
      return project;
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

  public byte[] createJar(final Iterable<? extends Pair<? extends String, ? extends String>> sourceFiles, final Function1<? super String, ? extends Boolean> filter) {
    try {
      final IProject project = WorkbenchTestHelper.createPluginProject("my.temporary.data.project", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.lib");
      final HashMap<String, InputStream> listOfContents = CollectionLiterals.<String, InputStream>newHashMap();
      try {
        JavaProjectSetupUtil.addSourceFolder(JavaCore.create(project), "src");
        JavaProjectSetupUtil.addSourceFolder(JavaCore.create(project), "xtend-gen");
        for (final Pair<? extends String, ? extends String> sourceFile : sourceFiles) {
          String _key = sourceFile.getKey();
          IResourcesSetupUtil.createFile(("my.temporary.data.project/src/" + _key), sourceFile.getValue());
        }
        IResourcesSetupUtil.waitForBuild();
        final IResourceVisitor _function = (IResource it) -> {
          if ((it instanceof IFile)) {
            final String path = ((IFile)it).getProjectRelativePath().removeFirstSegments(1).toString();
            if (((!(filter.apply(path)).booleanValue()) && (!listOfContents.containsKey(path)))) {
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
          String _key_1 = it.getKey();
          InputStream _value = it.getValue();
          return Pair.<String, InputStream>of(_key_1, _value);
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
}
