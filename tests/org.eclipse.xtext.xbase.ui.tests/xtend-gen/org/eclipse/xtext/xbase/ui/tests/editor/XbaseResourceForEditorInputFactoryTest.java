package org.eclipse.xtext.xbase.ui.tests.editor;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.ui.editor.XbaseResourceForEditorInputFactory;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class XbaseResourceForEditorInputFactoryTest extends AbstractXbaseUITestCase {
  @Inject
  private XbaseResourceForEditorInputFactory editorInputFactory;
  
  @Test
  public void testValidationIsDisabled_01() {
    try {
      IWorkspaceRoot _root = this.workspace.getRoot();
      final IProject project = _root.getProject("simpleProject");
      project.create(null);
      project.open(null);
      final IFile file = project.getFile("Hello.xtext");
      final InputStream _function = new InputStream() {
        @Override
        public int read() throws IOException {
          int _minus = (-1);
          return _minus;
        }
      };
      file.create(_function, true, null);
      boolean _isValidationDisabled = this.isValidationDisabled(file);
      Assert.assertTrue(_isValidationDisabled);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testValidationIsDisabled_02() {
    try {
      final IProject project = AbstractXbaseUITestCase.createPluginProject("my.plugin.project");
      final IFile file = project.getFile("Hello.xtext");
      final InputStream _function = new InputStream() {
        @Override
        public int read() throws IOException {
          int _minus = (-1);
          return _minus;
        }
      };
      file.create(_function, true, null);
      boolean _isValidationDisabled = this.isValidationDisabled(file);
      Assert.assertFalse(_isValidationDisabled);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testValidationIsDisabled_03() {
    try {
      final IProject project = AbstractXbaseUITestCase.createPluginProject("my.plugin.project");
      final IJavaProject jp = JavaCore.create(project);
      boolean wasTested = false;
      IPackageFragmentRoot[] _allPackageFragmentRoots = jp.getAllPackageFragmentRoots();
      for (final IPackageFragmentRoot pfr : _allPackageFragmentRoots) {
        boolean _isArchive = pfr.isArchive();
        if (_isArchive) {
          Object[] _nonJavaResources = pfr.getNonJavaResources();
          Iterable<IStorage> _filter = Iterables.<IStorage>filter(((Iterable<? extends Object>)Conversions.doWrapArray(_nonJavaResources)), IStorage.class);
          for (final IStorage r : _filter) {
            {
              boolean _isValidationDisabled = this.isValidationDisabled(r);
              Assert.assertTrue(_isValidationDisabled);
              wasTested = true;
            }
          }
        }
      }
      Assert.assertTrue(wasTested);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean isValidationDisabled(final IStorage storage) {
    try {
      Class<? extends XbaseResourceForEditorInputFactory> _class = this.editorInputFactory.getClass();
      final Method method = _class.getDeclaredMethod("isValidationDisabled", IStorage.class);
      method.setAccessible(true);
      try {
        Object _invoke = method.invoke(this.editorInputFactory, storage);
        return (((Boolean) _invoke)).booleanValue();
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    } catch (Throwable _e_1) {
      throw Exceptions.sneakyThrow(_e_1);
    }
  }
}
