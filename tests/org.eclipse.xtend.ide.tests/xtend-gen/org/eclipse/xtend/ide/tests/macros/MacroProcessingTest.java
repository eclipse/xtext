package org.eclipse.xtend.ide.tests.macros;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.internal.StopWatchRule;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

@SuppressWarnings("all")
public class MacroProcessingTest extends AbstractXtendUITestCase {
  public void setUp() throws Exception {
    super.setUp();
    final Procedure1<IProgressMonitor> _function = new Procedure1<IProgressMonitor>() {
        public void apply(final IProgressMonitor it) {
          try {
            IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("macroProject");
            IJavaProject _create = JavaCore.create(_createPluginProject);
            MacroProcessingTest.this.macroProject = _create;
            IProject _createPluginProject_1 = WorkbenchTestHelper.createPluginProject("userProject", "com.google.inject", 
              "org.eclipse.xtend.lib", 
              "org.eclipse.xtext.xbase.lib", 
              "org.eclipse.xtend.ide.tests.data", 
              "org.junit4", "macroProject");
            IJavaProject _create_1 = JavaCore.create(_createPluginProject_1);
            MacroProcessingTest.this.userProject = _create_1;
          } catch (Exception _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
    this.modifyWorkspace(new IWorkspaceRunnable() {
        public void run(IProgressMonitor monitor) {
          _function.apply(monitor);
        }
    });
  }
  
  private IJavaProject macroProject;
  
  private IJavaProject userProject;
  
  @Rule
  public static StopWatchRule stopWatch = new Function0<StopWatchRule>() {
    public StopWatchRule apply() {
      StopWatchRule _stopWatchRule = new StopWatchRule(true);
      return _stopWatchRule;
    }
  }.apply();
  
  public void tearDown() throws Exception {
    super.tearDown();
    final Procedure1<IProgressMonitor> _function = new Procedure1<IProgressMonitor>() {
        public void apply(final IProgressMonitor it) {
          try {
            IResourcesSetupUtil.cleanWorkspace();
          } catch (Exception _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
    this.modifyWorkspace(new IWorkspaceRunnable() {
        public void run(IProgressMonitor monitor) {
          _function.apply(monitor);
        }
    });
  }
  
  public IFile newSource(final IJavaProject it, final String fileName, final String contents) {
    try {
      IProject _project = it.getProject();
      String _plus = ("src/" + fileName);
      final IFile result = _project.getFile(_plus);
      IContainer parent = result.getParent();
      boolean _exists = parent.exists();
      boolean _not = (!_exists);
      boolean _while = _not;
      while (_while) {
        ((IFolder) parent).create(true, false, null);
        boolean _exists_1 = parent.exists();
        boolean _not_1 = (!_exists_1);
        _while = _not_1;
      }
      StringInputStream _stringInputStream = new StringInputStream(contents);
      result.create(_stringInputStream, true, null);
      return result;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void addExportedPackage(final IJavaProject pluginProject, final String... exportedPackages) {
    try {
      IProject _project = pluginProject.getProject();
      final IFile manifestFile = _project.getFile("META-INF/MANIFEST.MF");
      InputStream _contents = manifestFile.getContents();
      Manifest _manifest = new Manifest(_contents);
      final Manifest manifest = _manifest;
      final Attributes attrs = manifest.getMainAttributes();
      boolean _containsKey = attrs.containsKey("Export-Package");
      if (_containsKey) {
        Object _get = attrs.get("Export-Package");
        String _plus = (_get + ",");
        String _join = IterableExtensions.join(((Iterable<? extends Object>)Conversions.doWrapArray(exportedPackages)), ",");
        String _plus_1 = (_plus + _join);
        attrs.putValue("Export-Package", _plus_1);
      } else {
        String _join_1 = IterableExtensions.join(((Iterable<? extends Object>)Conversions.doWrapArray(exportedPackages)), ",");
        attrs.putValue("Export-Package", _join_1);
      }
      ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
      final ByteArrayOutputStream out = _byteArrayOutputStream;
      manifest.write(out);
      byte[] _byteArray = out.toByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
      final ByteArrayInputStream in = _byteArrayInputStream;
      BufferedInputStream _bufferedInputStream = new BufferedInputStream(in);
      manifestFile.setContents(_bufferedInputStream, true, true, null);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void modifyWorkspace(final IWorkspaceRunnable runnable) {
    try {
      IWorkspace _pluginWorkspace = IDEWorkbenchPlugin.getPluginWorkspace();
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot _root = _workspace.getRoot();
      _pluginWorkspace.run(runnable, _root, IWorkspace.AVOID_UPDATE, null);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAbstractAnnotation() {
    try {
      final Procedure1<IProgressMonitor> _function = new Procedure1<IProgressMonitor>() {
          public void apply(final IProgressMonitor it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("package myannotation");
            _builder.newLine();
            _builder.newLine();
            _builder.append("import java.util.List");
            _builder.newLine();
            _builder.append("import org.eclipse.xtend.lib.macro.Active");
            _builder.newLine();
            _builder.append("import org.eclipse.xtend.lib.macro.ModifyContext");
            _builder.newLine();
            _builder.append("import org.eclipse.xtend.lib.macro.ModifyProcessor");
            _builder.newLine();
            _builder.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
            _builder.newLine();
            _builder.newLine();
            _builder.append("@Active(typeof(AbstractProcessor))");
            _builder.newLine();
            _builder.append("annotation Abstract { }");
            _builder.newLine();
            _builder.append("class AbstractProcessor implements ModifyProcessor<MutableClassDeclaration> {");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("extension ModifyContext ctx");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("override modify(List<? extends MutableClassDeclaration> annotatedSourceClasses, ModifyContext context) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("ctx = context");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("annotatedSourceClasses.forEach [");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("^abstract = true");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("]");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
            MacroProcessingTest.this.newSource(MacroProcessingTest.this.macroProject, "myannotation/AbstractAnnotation.xtend", _builder.toString());
            MacroProcessingTest.this.addExportedPackage(MacroProcessingTest.this.macroProject, "myannotation");
          }
        };
      this.modifyWorkspace(new IWorkspaceRunnable() {
          public void run(IProgressMonitor monitor) {
            _function.apply(monitor);
          }
      });
      IResourcesSetupUtil.waitForAutoBuild();
      final Procedure1<IProgressMonitor> _function_1 = new Procedure1<IProgressMonitor>() {
          public void apply(final IProgressMonitor it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("package myusercode");
            _builder.newLine();
            _builder.newLine();
            _builder.append("@myannotation.Abstract");
            _builder.newLine();
            _builder.append("class MyClass {");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
            MacroProcessingTest.this.newSource(MacroProcessingTest.this.userProject, "myusercode/UserCode.xtend", _builder.toString());
          }
        };
      this.modifyWorkspace(new IWorkspaceRunnable() {
          public void run(IProgressMonitor monitor) {
            _function_1.apply(monitor);
          }
      });
      IResourcesSetupUtil.waitForAutoBuild();
      this.assertNoErrorsInWorkspace();
      final IType type = this.userProject.findType("myusercode.MyClass");
      int _flags = type.getFlags();
      boolean _isAbstract = Flags.isAbstract(_flags);
      Assert.assertTrue("The class should be abstract.", _isAbstract);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertNoErrorsInWorkspace() {
    try {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot _root = _workspace.getRoot();
      final IMarker[] findMarkers = _root.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      for (final IMarker iMarker : findMarkers) {
        String _message = MarkerUtilities.getMessage(iMarker);
        int _severity = MarkerUtilities.getSeverity(iMarker);
        boolean _equals = (_severity == IMarker.SEVERITY_ERROR);
        Assert.assertFalse(_message, _equals);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
