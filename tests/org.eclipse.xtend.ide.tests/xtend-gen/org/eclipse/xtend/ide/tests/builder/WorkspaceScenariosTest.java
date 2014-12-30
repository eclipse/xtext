/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.builder;

import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class WorkspaceScenariosTest {
  @Test
  public void testJarWithEverything() {
    try {
      final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
        public Boolean apply(final String it) {
          return Boolean.valueOf(false);
        }
      };
      final IProject project = this.createProjectWithJarDependency(_function);
      try {
        IResourcesSetupUtil.assertNoErrorsInWorkspace();
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
      final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
        public Boolean apply(final String it) {
          boolean _or = false;
          boolean _endsWith = it.endsWith("java");
          if (_endsWith) {
            _or = true;
          } else {
            boolean _endsWith_1 = it.endsWith("class");
            _or = _endsWith_1;
          }
          return Boolean.valueOf(_or);
        }
      };
      final IProject project = this.createProjectWithJarDependency(_function);
      try {
        final ArrayList<IMarker> allXtendMarkers = CollectionLiterals.<IMarker>newArrayList();
        final IResourceVisitor _function_1 = new IResourceVisitor() {
          public boolean visit(final IResource it) throws CoreException {
            if ((it instanceof IFile)) {
              IPath _fullPath = ((IFile)it).getFullPath();
              String _lastSegment = _fullPath.lastSegment();
              boolean _endsWith = _lastSegment.endsWith(".xtend");
              if (_endsWith) {
                final IMarker[] markers = ((IFile)it).findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
                for (final IMarker m : markers) {
                  allXtendMarkers.add(m);
                }
              }
            }
            return true;
          }
        };
        project.accept(_function_1);
        int _size = allXtendMarkers.size();
        Assert.assertEquals(3, _size);
        final Function1<IMarker, Boolean> _function_2 = new Function1<IMarker, Boolean>() {
          public Boolean apply(final IMarker it) {
            String _message = MarkerUtilities.getMessage(it);
            return Boolean.valueOf(_message.startsWith("Java problem:"));
          }
        };
        boolean _forall = IterableExtensions.<IMarker>forall(allXtendMarkers, _function_2);
        Assert.assertTrue(_forall);
      } finally {
        project.delete(true, true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJarWithoutXtend() {
    try {
      final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
        public Boolean apply(final String it) {
          boolean _or = false;
          boolean _endsWith = it.endsWith("java");
          if (_endsWith) {
            _or = true;
          } else {
            boolean _endsWith_1 = it.endsWith("class");
            _or = _endsWith_1;
          }
          return Boolean.valueOf((!_or));
        }
      };
      final IProject project = this.createProjectWithJarDependency(_function);
      try {
        IResourcesSetupUtil.assertNoErrorsInWorkspace();
      } finally {
        project.delete(true, true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJarWithoutStorage() {
    try {
      final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
        public Boolean apply(final String it) {
          return Boolean.valueOf(it.endsWith("bin"));
        }
      };
      final IProject project = this.createProjectWithJarDependency(_function);
      try {
        IResourcesSetupUtil.assertNoErrorsInWorkspace();
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
      IResourcesSetupUtil.waitForAutoBuild();
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
      IProject _project = fileA.getProject();
      final IFile javaB = _project.getFile("xtend-gen/mypack/ClassB.java");
      InputStream _contents = javaB.getContents();
      byte[] _byteArray = ByteStreams.toByteArray(_contents);
      String _string = new String(_byteArray);
      boolean _contains = _string.contains("anotherMethod(a);");
      Assert.assertTrue(_contains);
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
      IResourcesSetupUtil.waitForAutoBuild();
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
      InputStream _contents_1 = javaB.getContents();
      byte[] _byteArray_1 = ByteStreams.toByteArray(_contents_1);
      String _string_1 = new String(_byteArray_1);
      boolean _contains_1 = _string_1.contains("a.anotherMethod();");
      Assert.assertTrue(_contains_1);
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
      final IFile jarFile = project.getFile("mydependency.jar");
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(jarData);
      jarFile.create(_byteArrayInputStream, true, null);
      IJavaProject _create = JavaCore.create(project);
      JavaProjectSetupUtil.addJarToClasspath(_create, jarFile);
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
      IResourcesSetupUtil.waitForAutoBuild();
      return project;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public byte[] createJar(final Iterable<? extends Pair<? extends String, ? extends String>> sourceFiles, final Function1<? super String, ? extends Boolean> filter) {
    try {
      final IProject project = WorkbenchTestHelper.createPluginProject("my.temporary.data.project", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.lib");
      try {
        IJavaProject _create = JavaCore.create(project);
        JavaProjectSetupUtil.addSourceFolder(_create, "src");
        IJavaProject _create_1 = JavaCore.create(project);
        JavaProjectSetupUtil.addSourceFolder(_create_1, "xtend-gen");
        for (final Pair<? extends String, ? extends String> sourceFile : sourceFiles) {
          String _key = sourceFile.getKey();
          String _plus = ("my.temporary.data.project/src/" + _key);
          String _value = sourceFile.getValue();
          IResourcesSetupUtil.createFile(_plus, _value);
        }
        IResourcesSetupUtil.waitForAutoBuild();
        final HashMap<String, InputStream> listOfContents = CollectionLiterals.<String, InputStream>newHashMap();
        final IResourceVisitor _function = new IResourceVisitor() {
          public boolean visit(final IResource it) throws CoreException {
            if ((it instanceof IFile)) {
              IPath _projectRelativePath = ((IFile)it).getProjectRelativePath();
              IPath _removeFirstSegments = _projectRelativePath.removeFirstSegments(1);
              final String path = _removeFirstSegments.toString();
              Boolean _apply = filter.apply(path);
              boolean _not = (!(_apply).booleanValue());
              if (_not) {
                InputStream _contents = ((IFile)it).getContents();
                listOfContents.put(path, _contents);
              }
            }
            return true;
          }
        };
        final IResourceVisitor visitor = _function;
        IFolder _folder = project.getFolder("src");
        _folder.accept(visitor);
        IFolder _folder_1 = project.getFolder("xtend-gen");
        _folder_1.accept(visitor);
        IFolder _folder_2 = project.getFolder("bin");
        _folder_2.accept(visitor);
        Set<Map.Entry<String, InputStream>> _entrySet = listOfContents.entrySet();
        final Function1<Map.Entry<String, InputStream>, Pair<String, InputStream>> _function_1 = new Function1<Map.Entry<String, InputStream>, Pair<String, InputStream>>() {
          public Pair<String, InputStream> apply(final Map.Entry<String, InputStream> it) {
            String _key = it.getKey();
            InputStream _value = it.getValue();
            return Pair.<String, InputStream>of(_key, _value);
          }
        };
        Iterable<Pair<String, InputStream>> _map = IterableExtensions.<Map.Entry<String, InputStream>, Pair<String, InputStream>>map(_entrySet, _function_1);
        List<Pair<String, InputStream>> _list = IterableExtensions.<Pair<String, InputStream>>toList(_map);
        final InputStream jarin = JavaProjectSetupUtil.jarInputStream(((Pair<String, InputStream>[])Conversions.unwrapArray(_list, Pair.class)));
        return ByteStreams.toByteArray(jarin);
      } finally {
        project.delete(true, true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
