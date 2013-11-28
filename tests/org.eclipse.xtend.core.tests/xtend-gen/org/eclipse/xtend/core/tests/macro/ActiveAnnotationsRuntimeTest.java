package org.eclipse.xtend.core.tests.macro;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.AnnotationProcessor;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.macro.AbstractReusableActiveAnnotationTests;
import org.eclipse.xtend.core.tests.macro.DelegatingClassloader;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
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
            Path _path = new Path((("/" + ActiveAnnotationsRuntimeTest.this.macroProject) + "/src"));
            Path _path_1 = new Path((("/" + ActiveAnnotationsRuntimeTest.this.macroProject) + "/xtend-gen"));
            _sourceFolderMappings.put(_path, _path_1);
          }
        };
        ProjectConfig _doubleArrow = ObjectExtensions.<ProjectConfig>operator_doubleArrow(_projectConfig, _function);
        it.addProjectConfig(_doubleArrow);
        ProjectConfig _projectConfig_1 = new ProjectConfig(ActiveAnnotationsRuntimeTest.this.clientProject);
        final Procedure1<ProjectConfig> _function_1 = new Procedure1<ProjectConfig>() {
          public void apply(final ProjectConfig it) {
            Map<Path,Path> _sourceFolderMappings = it.getSourceFolderMappings();
            Path _path = new Path((("/" + ActiveAnnotationsRuntimeTest.this.clientProject) + "/src"));
            Path _path_1 = new Path((("/" + ActiveAnnotationsRuntimeTest.this.clientProject) + "/xtend-gen"));
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
    String _key = fileRepresentation.getKey();
    String _plus = ((("/" + projectName) + "/src/") + _key);
    Path _path = new Path(_plus);
    final Path path = _path;
    String _value = fileRepresentation.getValue();
    this.fileSystemSupport.setContents(path, _value);
    WorkspaceConfig _workspaceConfig = this.configProvider.getWorkspaceConfig();
    String _absoluteFileSystemPath = _workspaceConfig.getAbsoluteFileSystemPath();
    String _string = path.toString();
    String _plus_1 = (_absoluteFileSystemPath + _string);
    return URI.createFileURI(_plus_1);
  }
  
  public void assertProcessing(final Pair<String,String> macroFile, final Pair<String,String> clientFile, final Procedure1<? super CompilationUnitImpl> expectations) {
    final XtextResourceSet resourceSet = this.compileMacroResourceSet(macroFile, clientFile);
    EList<Resource> _resources = resourceSet.getResources();
    final Resource singleResource = IterableExtensions.<Resource>head(_resources);
    final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
      public void accept(final CompilationTestHelper.Result it) {
        final CompilationUnitImpl unit = ActiveAnnotationsRuntimeTest.this.compilationUnitProvider.get();
        EList<EObject> _contents = singleResource.getContents();
        Iterable<XtendFile> _filter = Iterables.<XtendFile>filter(_contents, XtendFile.class);
        final XtendFile xtendFile = IterableExtensions.<XtendFile>head(_filter);
        ActiveAnnotationsRuntimeTest.this.validationTestHelper.assertNoErrors(xtendFile);
        unit.setXtendFile(xtendFile);
        expectations.apply(unit);
        EList<Resource.Diagnostic> _errors = singleResource.getErrors();
        boolean _isEmpty = _errors.isEmpty();
        Assert.assertTrue(_isEmpty);
      }
    };
    this.compiler.compile(resourceSet, _function);
  }
  
  public void assertIssues(final Pair<String,String> macroFile, final Pair<String,String> clientFile, final Procedure1<? super List<Issue>> expectations) {
    try {
      final XtextResourceSet resourceSet = this.compileMacroResourceSet(macroFile, clientFile);
      EList<Resource> _resources = resourceSet.getResources();
      Resource _head = IterableExtensions.<Resource>head(_resources);
      final XtextResource singleResource = ((XtextResource) _head);
      boolean _isLoaded = singleResource.isLoaded();
      boolean _not = (!_isLoaded);
      if (_not) {
        Map<Object,Object> _loadOptions = resourceSet.getLoadOptions();
        singleResource.load(_loadOptions);
      }
      IResourceServiceProvider _resourceServiceProvider = singleResource.getResourceServiceProvider();
      final IResourceValidator validator = _resourceServiceProvider.getResourceValidator();
      List<Issue> _validate = validator.validate(singleResource, CheckMode.ALL, CancelIndicator.NullImpl);
      expectations.apply(_validate);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public XtextResourceSet compileMacroResourceSet(final Pair<String,String> macroFile, final Pair<String,String> clientFile) {
    XtextResourceSet _xblockexpression = null;
    {
      final URI macroURI = this.copyToDisk(this.macroProject, macroFile);
      final URI clientURI = this.copyToDisk(this.clientProject, clientFile);
      final XtextResourceSet macroResourceSet = this.resourceSetProvider.get();
      Class<? extends ActiveAnnotationsRuntimeTest> _class = this.getClass();
      ClassLoader _classLoader = _class.getClassLoader();
      macroResourceSet.setClasspathURIContext(_classLoader);
      macroResourceSet.createResource(macroURI);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      resourceSet.createResource(clientURI);
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result result) {
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
      _xblockexpression = (resourceSet);
    }
    return _xblockexpression;
  }
  
  @Test
  public void testSimpleModification() {
    super.testSimpleModification();
  }
  
  @Test
  public void testBug403563() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package myannotation");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.Active");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.TransformationContext");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.AbstractClassProcessor");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Active(ThrowExceptionAnnotationProcessor)");
    _builder.newLine();
    _builder.append("annotation ThrowExceptionAnnotation{ }");
    _builder.newLine();
    _builder.append("class ThrowExceptionAnnotationProcessor extends AbstractClassProcessor {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new IllegalStateException");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String,String> _mappedTo = Pair.<String, String>of("myannotation/ThrowExceptionAnnotationProcessor.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package myusercode");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@myannotation.ThrowExceptionAnnotation class MyClass {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("myusercode/UserCode.xtend", _builder_1.toString());
    final Procedure1<List<Issue>> _function = new Procedure1<List<Issue>>() {
      public void apply(final List<Issue> it) {
        int _size = it.size();
        Assert.assertEquals(1, _size);
        final Issue error = IterableExtensions.<Issue>head(it);
        Assert.assertNotNull(error);
        String _code = error.getCode();
        Assert.assertEquals(IssueCodes.PROCESSING_ERROR, _code);
        String _message = error.getMessage();
        String _name = IllegalStateException.class.getName();
        boolean _contains = _message.contains(_name);
        Assert.assertTrue(_contains);
        String _message_1 = error.getMessage();
        String _name_1 = AnnotationProcessor.class.getName();
        boolean _contains_1 = _message_1.contains(_name_1);
        Assert.assertFalse(_contains_1);
      }
    };
    this.assertIssues(_mappedTo, _mappedTo_1, _function);
  }
}
