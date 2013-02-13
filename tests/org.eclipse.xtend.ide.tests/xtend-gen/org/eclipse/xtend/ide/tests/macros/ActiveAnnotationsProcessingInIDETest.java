package org.eclipse.xtend.ide.tests.macros;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.tests.macro.AbstractActiveAnnotationsTest;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.internal.StopwatchRule;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(XtendIDEInjectorProvider.class)
@SuppressWarnings("all")
public class ActiveAnnotationsProcessingInIDETest extends AbstractActiveAnnotationsTest {
  @Test
  public void testSimpleModification() {
    super.testSimpleModification();
  }
  
  @Inject
  private XtextResourceSetProvider resourceSetProvider;
  
  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;
  
  @Rule
  public static StopwatchRule stopwatch = new Function0<StopwatchRule>() {
    public StopwatchRule apply() {
      StopwatchRule _stopwatchRule = new StopwatchRule(true);
      return _stopwatchRule;
    }
  }.apply();
  
  @After
  public void tearDown() throws Exception {
    this.macroProject = null;
    this.userProject = null;
    this.sourceFile = null;
    IResourcesSetupUtil.cleanWorkspace();
  }
  
  private IJavaProject macroProject;
  
  private IJavaProject userProject;
  
  private IFile sourceFile;
  
  public void assertProcessing(final Pair<String,String> macroFile, final Pair<String,String> clientFile, final Procedure1<? super CompilationUnitImpl> expectations) {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("macroProject");
      IJavaProject _create = JavaCore.create(_createPluginProject);
      this.macroProject = _create;
      String _key = macroFile.getKey();
      String _value = macroFile.getValue();
      String _string = _value.toString();
      this.newSource(this.macroProject, _key, _string);
      String _key_1 = macroFile.getKey();
      final int lidx = _key_1.lastIndexOf("/");
      int _minus = (-1);
      boolean _notEquals = (lidx != _minus);
      if (_notEquals) {
        String _key_2 = macroFile.getKey();
        String _substring = _key_2.substring(0, lidx);
        final String packageName = _substring.replace("/", ".");
        this.addExportedPackage(this.macroProject, packageName);
      }
      IProject _createPluginProject_1 = WorkbenchTestHelper.createPluginProject("userProject", "com.google.inject", 
        "org.eclipse.xtend.lib", 
        "org.eclipse.xtext.xbase.lib", 
        "org.eclipse.xtend.ide.tests.data", 
        "org.junit4", "macroProject");
      IJavaProject _create_1 = JavaCore.create(_createPluginProject_1);
      this.userProject = _create_1;
      String _key_3 = clientFile.getKey();
      String _value_1 = clientFile.getValue();
      String _string_1 = _value_1.toString();
      IFile _newSource = this.newSource(this.userProject, _key_3, _string_1);
      this.sourceFile = _newSource;
      IResourcesSetupUtil.waitForAutoBuild();
      IProject _project = this.userProject.getProject();
      final ResourceSet resourceSet = this.resourceSetProvider.get(_project);
      IPath _fullPath = this.sourceFile.getFullPath();
      String _string_2 = _fullPath.toString();
      URI _createPlatformResourceURI = URI.createPlatformResourceURI(_string_2, true);
      final Resource resource = resourceSet.getResource(_createPlatformResourceURI, true);
      final CompilationUnitImpl unit = this.compilationUnitProvider.get();
      EList<EObject> _contents = resource.getContents();
      Iterable<XtendFile> _filter = Iterables.<XtendFile>filter(_contents, XtendFile.class);
      XtendFile _head = IterableExtensions.<XtendFile>head(_filter);
      unit.setXtendFile(_head);
      expectations.apply(unit);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
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
    } catch (Throwable _e) {
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
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
