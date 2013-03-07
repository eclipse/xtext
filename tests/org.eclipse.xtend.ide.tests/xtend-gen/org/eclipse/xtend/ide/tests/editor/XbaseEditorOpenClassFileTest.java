package org.eclipse.xtend.ide.tests.editor;

import com.google.inject.Inject;
import java.io.InputStream;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
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
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class XbaseEditorOpenClassFileTest extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper helper;
  
  @After
  public void tearDown() {
    try {
      this.helper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOpenFileFromSmapJarWithIncludedSource() {
    try {
      IProject _project = this.helper.getProject();
      final IJavaProject jp = JavaCore.create(_project);
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
      IProject _project = this.helper.getProject();
      final IJavaProject jp = JavaCore.create(_project);
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
      IProject _project = this.helper.getProject();
      final IJavaProject jp = JavaCore.create(_project);
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
      boolean _notEquals = ObjectExtensions.operator_notEquals(fileNameOfSource, null);
      if (_notEquals) {
        IFile _xblockexpression = null;
        {
          IProject _project_1 = jp.getProject();
          Path _path_1 = new Path(fileNameOfSource);
          final IFile source = _project_1.getFile(_path_1);
          Class<? extends XbaseEditorOpenClassFileTest> _class_1 = this.getClass();
          InputStream _resourceAsStream_1 = _class_1.getResourceAsStream(fileNameOfSource);
          source.create(_resourceAsStream_1, true, null);
          _xblockexpression = (source);
        }
        _xifexpression = _xblockexpression;
      }
      final IFile sourceFile = _xifexpression;
      IPath _fullPath = jarFile.getFullPath();
      IPath _fullPath_1 = sourceFile==null?(IPath)null:sourceFile.getFullPath();
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
      Object _adapter = editor.getAdapter(IRewriteTarget.class);
      IDocument _document = ((IRewriteTarget) _adapter).getDocument();
      final String text = _document.get();
      this.helper.closeEditor(editor, false);
      return text;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
