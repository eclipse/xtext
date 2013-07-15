package org.eclipse.xtend.core.tests.macro;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.File;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.macro.AbstractReusableActiveAnnotationTests;
import org.eclipse.xtend.core.tests.macro.DelegatingClassloader;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper.Result;
import org.eclipse.xtext.xbase.file.ProjectConfig;
import org.eclipse.xtext.xbase.file.RuntimeWorkspaceConfigProvider;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class ActiveAnnotationsRuntimeTest extends AbstractReusableActiveAnnotationTests {
  @Inject
  private CompilationTestHelper compiler;
  
  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;
  
  @Inject
  private ProcessorInstanceForJvmTypeProvider processorProvider;
  
  @Inject
  private ValidationTestHelper validationTestHelper;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private RuntimeWorkspaceConfigProvider configProvider;
  
  @Inject
  @Extension
  private MutableFileSystemSupport fileSystemSupport;
  
  private final String macroProject = "macroProject";
  
  private final String clientProject = "userProject";
  
  @Before
  public void setUp() {
    this.compiler.setJavaCompilerClassPath(MutableTypeDeclaration.class, IterableExtensions.class, Lists.class);
    this.configureFreshWorkspace();
  }
  
  @After
  public void tearDown() {
    try {
      WorkspaceConfig _workspaceConfig = this.configProvider.getWorkspaceConfig();
      String _absoluteFileSystemPath = _workspaceConfig.getAbsoluteFileSystemPath();
      File _file = new File(_absoluteFileSystemPath);
      Files.sweepFolder(_file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void configureFreshWorkspace() {
    final File tempDir = this.createFreshTempDir();
    String _absolutePath = tempDir.getAbsolutePath();
    WorkspaceConfig _workspaceConfig = new WorkspaceConfig(_absolutePath);
    final Procedure1<WorkspaceConfig> _function = new Procedure1<WorkspaceConfig>() {
      public void apply(final WorkspaceConfig it) {
        ProjectConfig _projectConfig = new ProjectConfig(ActiveAnnotationsRuntimeTest.this.macroProject);
        final Procedure1<ProjectConfig> _function = new Procedure1<ProjectConfig>() {
          public void apply(final ProjectConfig it) {
            Map<Path,Path> _sourceFolderMappings = it.getSourceFolderMappings();
            String _plus = ("/" + ActiveAnnotationsRuntimeTest.this.macroProject);
            String _plus_1 = (_plus + "/src");
            Path _path = new Path(_plus_1);
            String _plus_2 = ("/" + ActiveAnnotationsRuntimeTest.this.macroProject);
            String _plus_3 = (_plus_2 + "/xtend-gen");
            Path _path_1 = new Path(_plus_3);
            _sourceFolderMappings.put(_path, _path_1);
          }
        };
        ProjectConfig _doubleArrow = ObjectExtensions.<ProjectConfig>operator_doubleArrow(_projectConfig, _function);
        it.addProjectConfig(_doubleArrow);
        ProjectConfig _projectConfig_1 = new ProjectConfig(ActiveAnnotationsRuntimeTest.this.clientProject);
        final Procedure1<ProjectConfig> _function_1 = new Procedure1<ProjectConfig>() {
          public void apply(final ProjectConfig it) {
            Map<Path,Path> _sourceFolderMappings = it.getSourceFolderMappings();
            String _plus = ("/" + ActiveAnnotationsRuntimeTest.this.clientProject);
            String _plus_1 = (_plus + "/src");
            Path _path = new Path(_plus_1);
            String _plus_2 = ("/" + ActiveAnnotationsRuntimeTest.this.clientProject);
            String _plus_3 = (_plus_2 + "/xtend-gen");
            Path _path_1 = new Path(_plus_3);
            _sourceFolderMappings.put(_path, _path_1);
          }
        };
        ProjectConfig _doubleArrow_1 = ObjectExtensions.<ProjectConfig>operator_doubleArrow(_projectConfig_1, _function_1);
        it.addProjectConfig(_doubleArrow_1);
      }
    };
    WorkspaceConfig _doubleArrow = ObjectExtensions.<WorkspaceConfig>operator_doubleArrow(_workspaceConfig, _function);
    this.configProvider.setWorkspaceConfig(_doubleArrow);
  }
  
  protected File createFreshTempDir() {
    try {
      long _nanoTime = System.nanoTime();
      String _string = Long.toString(_nanoTime);
      final File tempDir = File.createTempFile("temp", _string);
      boolean _delete = tempDir.delete();
      boolean _not = (!_delete);
      if (_not) {
        IllegalStateException _illegalStateException = new IllegalStateException("couldn\'t delete temp file.");
        throw _illegalStateException;
      }
      boolean _mkdir = tempDir.mkdir();
      boolean _not_1 = (!_mkdir);
      if (_not_1) {
        IllegalStateException _illegalStateException_1 = new IllegalStateException("couldn\'t create temp dir.");
        throw _illegalStateException_1;
      }
      return tempDir;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected URI copyToDisk(final String projectName, final Pair<String,String> fileRepresentation) {
    String _plus = ("/" + projectName);
    String _plus_1 = (_plus + "/src/");
    String _key = fileRepresentation.getKey();
    String _plus_2 = (_plus_1 + _key);
    Path _path = new Path(_plus_2);
    final Path path = _path;
    String _value = fileRepresentation.getValue();
    this.fileSystemSupport.setContents(path, _value);
    WorkspaceConfig _workspaceConfig = this.configProvider.getWorkspaceConfig();
    String _absoluteFileSystemPath = _workspaceConfig.getAbsoluteFileSystemPath();
    String _string = path.toString();
    String _plus_3 = (_absoluteFileSystemPath + _string);
    return URI.createFileURI(_plus_3);
  }
  
  public void assertProcessing(final Pair<String,String> macroFile, final Pair<String,String> clientFile, final Procedure1<? super CompilationUnitImpl> expectations) {
    final URI macroURI = this.copyToDisk(this.macroProject, macroFile);
    final URI clientURI = this.copyToDisk(this.clientProject, clientFile);
    final XtextResourceSet macroResourceSet = this.resourceSetProvider.get();
    Class<? extends ActiveAnnotationsRuntimeTest> _class = this.getClass();
    ClassLoader _classLoader = _class.getClassLoader();
    macroResourceSet.setClasspathURIContext(_classLoader);
    macroResourceSet.createResource(macroURI);
    final XtextResourceSet resourceSet = this.resourceSetProvider.get();
    resourceSet.createResource(clientURI);
    final IAcceptor<Result> _function = new IAcceptor<Result>() {
      public void accept(final Result result) {
        Class<? extends ActiveAnnotationsRuntimeTest> _class = ActiveAnnotationsRuntimeTest.this.getClass();
        ClassLoader _classLoader = _class.getClassLoader();
        final Function1<String,Class<? extends Object>> _function = new Function1<String,Class<? extends Object>>() {
          public Class<? extends Object> apply(final String it) {
            Class<? extends Object> _compiledClass = result.getCompiledClass(it);
            return _compiledClass;
          }
        };
        DelegatingClassloader _delegatingClassloader = new DelegatingClassloader(_classLoader, _function);
        final DelegatingClassloader classLoader = _delegatingClassloader;
        resourceSet.setClasspathURIContext(classLoader);
        ActiveAnnotationsRuntimeTest.this.processorProvider.setClassLoader(classLoader);
      }
    };
    this.compiler.compile(macroResourceSet, _function);
    EList<Resource> _resources = resourceSet.getResources();
    final Resource singleResource = IterableExtensions.<Resource>head(_resources);
    final IAcceptor<Result> _function_1 = new IAcceptor<Result>() {
      public void accept(final Result it) {
        final CompilationUnitImpl unit = ActiveAnnotationsRuntimeTest.this.compilationUnitProvider.get();
        EList<EObject> _contents = singleResource.getContents();
        Iterable<XtendFile> _filter = Iterables.<XtendFile>filter(_contents, XtendFile.class);
        final XtendFile xtendFile = IterableExtensions.<XtendFile>head(_filter);
        ActiveAnnotationsRuntimeTest.this.validationTestHelper.assertNoErrors(xtendFile);
        unit.setXtendFile(xtendFile);
        expectations.apply(unit);
        EList<Diagnostic> _errors = singleResource.getErrors();
        boolean _isEmpty = _errors.isEmpty();
        Assert.assertTrue(_isEmpty);
      }
    };
    this.compiler.compile(resourceSet, _function_1);
  }
  
  @Test
  public void testSimpleModification() {
    super.testSimpleModification();
  }
}
