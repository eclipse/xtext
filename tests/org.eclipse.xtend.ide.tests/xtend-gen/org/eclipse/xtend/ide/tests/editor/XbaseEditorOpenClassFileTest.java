package org.eclipse.xtend.ide.tests.editor;

import com.google.common.base.Objects;
import com.google.common.io.ByteStreams;
import com.google.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRewriteTarget;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("my.example.project");
      this.project = _createPluginProject;
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
      boolean _supportsEditorOverride = this.supportsEditorOverride();
      boolean _not = (!_supportsEditorOverride);
      if (_not) {
        return;
      }
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
      boolean _supportsEditorOverride = this.supportsEditorOverride();
      boolean _not = (!_supportsEditorOverride);
      if (_not) {
        return;
      }
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
      boolean _supportsEditorOverride = this.supportsEditorOverride();
      boolean _not = (!_supportsEditorOverride);
      if (_not) {
        return;
      }
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
      boolean _supportsEditorOverride = this.supportsEditorOverride();
      boolean _not = (!_supportsEditorOverride);
      if (_not) {
        return;
      }
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
      byte[] _createJar = this.createJar(_mappedTo, _mappedTo_1);
      this.addJarToProject(this.project, _createJar);
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
      boolean _supportsEditorOverride = this.supportsEditorOverride();
      boolean _not = (!_supportsEditorOverride);
      if (_not) {
        return;
      }
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
      byte[] _createJar = this.createJar(_mappedTo, _mappedTo_1);
      this.addJarToProject(this.project, _createJar);
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
      boolean _supportsEditorOverride = this.supportsEditorOverride();
      boolean _not = (!_supportsEditorOverride);
      if (_not) {
        return;
      }
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
      byte[] _createJar = this.createJar(_mappedTo, _mappedTo_1);
      this.addJarToProject(this.project, _createJar);
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
      String _string = _builder_2.toString();
      this.assertContains(_string, result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOpenEditor4NestedType_NameConflict() {
    try {
      boolean _supportsEditorOverride = this.supportsEditorOverride();
      boolean _not = (!_supportsEditorOverride);
      if (_not) {
        return;
      }
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
      byte[] _createJar = this.createJar(_mappedTo, _mappedTo_1);
      this.addJarToProject(this.project, _createJar);
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
      String _string = _builder_2.toString();
      Assert.assertEquals(_string, result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOpenEditor4NestedType_NoNameConflict() {
    try {
      boolean _supportsEditorOverride = this.supportsEditorOverride();
      boolean _not = (!_supportsEditorOverride);
      if (_not) {
        return;
      }
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
      byte[] _createJar = this.createJar(_mappedTo, _mappedTo_1);
      this.addJarToProject(this.project, _createJar);
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
        IJavaProject _create = JavaCore.create(project);
        _xblockexpression = JavaProjectSetupUtil.addJarToClasspath(_create, jarFile);
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
        IJavaProject _create = JavaCore.create(project);
        final IFolder folder = JavaProjectSetupUtil.addSourceFolder(_create, "src");
        IJavaProject _create_1 = JavaCore.create(project);
        JavaProjectSetupUtil.addSourceFolder(_create_1, "xtend-gen");
        for (final Pair<? extends String, ? extends String> sourceFile : sourceFiles) {
          IPath _fullPath = folder.getFullPath();
          String _key = sourceFile.getKey();
          IPath _append = _fullPath.append(_key);
          String _value = sourceFile.getValue();
          IResourcesSetupUtil.createFile(_append, _value);
        }
        IResourcesSetupUtil.waitForBuild();
        final IResourceVisitor _function = new IResourceVisitor() {
          @Override
          public boolean visit(final IResource it) throws CoreException {
            if ((it instanceof IFile)) {
              IPath _projectRelativePath = ((IFile)it).getProjectRelativePath();
              IPath _removeFirstSegments = _projectRelativePath.removeFirstSegments(1);
              final String path = _removeFirstSegments.toString();
              InputStream _contents = ((IFile)it).getContents();
              listOfContents.put(path, _contents);
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
          @Override
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
        Collection<InputStream> _values = listOfContents.values();
        final Procedure1<InputStream> _function_2 = new Procedure1<InputStream>() {
          @Override
          public void apply(final InputStream it) {
            try {
              it.close();
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
        IterableExtensions.<InputStream>forEach(_values, _function_2);
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
      _builder.append(substring, "");
      _builder.append("\' not found in");
      _builder.newLineIfNotEmpty();
      _builder.append("-----------");
      _builder.newLine();
      _builder.append(container, "");
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
      Class<? extends XbaseEditorOpenClassFileTest> _class = this.getClass();
      InputStream _resourceAsStream = _class.getResourceAsStream(fileName);
      jarFile.create(_resourceAsStream, true, null);
      IFile _xifexpression = null;
      boolean _notEquals = (!Objects.equal(fileNameOfSource, null));
      if (_notEquals) {
        IFile _xblockexpression = null;
        {
          IProject _project_1 = jp.getProject();
          Path _path_1 = new Path(fileNameOfSource);
          final IFile source = _project_1.getFile(_path_1);
          Class<? extends XbaseEditorOpenClassFileTest> _class_1 = this.getClass();
          InputStream _resourceAsStream_1 = _class_1.getResourceAsStream(fileNameOfSource);
          source.create(_resourceAsStream_1, true, null);
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
      IRewriteTarget _adapter = (IRewriteTarget) editor.getAdapter(IRewriteTarget.class);
      IDocument _document = _adapter.getDocument();
      final String text = _document.get();
      this.helper.closeEditor(editor, false);
      return text;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean supportsEditorOverride() {
    try {
      Class<?> _forName = Class.forName("org.eclipse.ui.ide.IEditorAssociationOverride");
      boolean _notEquals = (!Objects.equal(_forName, null));
      if (_notEquals) {
        return true;
      }
    } catch (final Throwable _t) {
      if (_t instanceof ClassNotFoundException) {
        final ClassNotFoundException e = (ClassNotFoundException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    Thread _currentThread = Thread.currentThread();
    StackTraceElement[] _stackTrace = _currentThread.getStackTrace();
    StackTraceElement _get = _stackTrace[1];
    String _methodName = _get.getMethodName();
    String _plus = ("Ignoring " + _methodName);
    String _plus_1 = (_plus + " , since editor everride is not supported.");
    XbaseEditorOpenClassFileTest.LOG.warn(_plus_1);
    return false;
  }
  
  private final static Logger LOG = Logger.getLogger(XbaseEditorOpenClassFileTest.class);
}
