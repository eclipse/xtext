package org.eclipse.xtext.builder.standalone;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.standalone.IIssueHandler;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler;
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler.CompilationResult;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.descriptions.IStubGenerator;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.mwe.NameBasedFilter;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData.ResourceSetAdapter;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class StandaloneBuilder {
  private final static Logger LOG = new Function0<Logger>() {
    public Logger apply() {
      Logger _logger = Logger.getLogger(StandaloneBuilder.class);
      return _logger;
    }
  }.apply();
  
  private Map<String,LanguageAccess> _languages;
  
  public Map<String,LanguageAccess> getLanguages() {
    return this._languages;
  }
  
  public void setLanguages(final Map<String,LanguageAccess> languages) {
    this._languages = languages;
  }
  
  private Iterable<String> _sourceDirs;
  
  public Iterable<String> getSourceDirs() {
    return this._sourceDirs;
  }
  
  public void setSourceDirs(final Iterable<String> sourceDirs) {
    this._sourceDirs = sourceDirs;
  }
  
  private Iterable<String> _classPathEntries;
  
  public Iterable<String> getClassPathEntries() {
    return this._classPathEntries;
  }
  
  public void setClassPathEntries(final Iterable<String> classPathEntries) {
    this._classPathEntries = classPathEntries;
  }
  
  private File _tempDir = new Function0<File>() {
    public File apply() {
      File _createTempDir = Files.createTempDir();
      return _createTempDir;
    }
  }.apply();
  
  public File getTempDir() {
    return this._tempDir;
  }
  
  public void setTempDir(final File tempDir) {
    this._tempDir = tempDir;
  }
  
  private String _encoding;
  
  public String getEncoding() {
    return this._encoding;
  }
  
  public void setEncoding(final String encoding) {
    this._encoding = encoding;
  }
  
  private boolean _failOnValidationError = true;
  
  public boolean isFailOnValidationError() {
    return this._failOnValidationError;
  }
  
  public void setFailOnValidationError(final boolean failOnValidationError) {
    this._failOnValidationError = failOnValidationError;
  }
  
  @Inject
  private IndexedJvmTypeAccess jvmTypeAccess;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private AbstractFileSystemAccess commonFileAccess;
  
  @Inject
  private IIssueHandler issueHandler;
  
  @Inject
  private org.eclipse.xtext.parser.IEncodingProvider.Runtime encodingProvider;
  
  @Inject
  private IJavaCompiler compiler;
  
  public void setTempDir(final String pathAsString) {
    boolean _notEquals = (!Objects.equal(pathAsString, null));
    if (_notEquals) {
      File _file = new File(pathAsString);
      this._tempDir = _file;
    }
  }
  
  public boolean launch() {
    Map<String,LanguageAccess> _languages = this.getLanguages();
    Collection<LanguageAccess> _values = _languages.values();
    final Function1<LanguageAccess,Boolean> _function = new Function1<LanguageAccess,Boolean>() {
      public Boolean apply(final LanguageAccess it) {
        boolean _isLinksAgainstJava = it.isLinksAgainstJava();
        return Boolean.valueOf(_isLinksAgainstJava);
      }
    };
    final boolean needsJava = IterableExtensions.<LanguageAccess>exists(_values, _function);
    if (needsJava) {
      StandaloneBuilder.LOG.info("Using common types.");
    }
    final XtextResourceSet resourceSet = this.resourceSetProvider.get();
    Iterable<String> _sourceDirs = this.getSourceDirs();
    Iterable<String> _classPathEntries = this.getClassPathEntries();
    final Iterable<String> allClassPathEntries = Iterables.<String>concat(_sourceDirs, _classPathEntries);
    this.collectResources(allClassPathEntries, resourceSet);
    if (needsJava) {
      this.installTypeProvider(allClassPathEntries, resourceSet, null);
    }
    final ResourceDescriptionsData index = this.fillIndex(resourceSet);
    Iterable<String> _sourceDirs_1 = this.getSourceDirs();
    final List<Resource> sourceResources = this.collectResources(_sourceDirs_1, resourceSet);
    if (needsJava) {
      File _generateStubs = this.generateStubs(index, sourceResources);
      final String stubsClasses = this.compileStubs(_generateStubs);
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(stubsClasses);
      Iterable<String> _plus = Iterables.<String>concat(allClassPathEntries, _newArrayList);
      this.installTypeProvider(_plus, resourceSet, this.jvmTypeAccess);
    }
    final Procedure1<Resource> _function_1 = new Procedure1<Resource>() {
      public void apply(final Resource it) {
        it.getContents();
      }
    };
    IterableExtensions.<Resource>forEach(sourceResources, _function_1);
    final Procedure1<Resource> _function_2 = new Procedure1<Resource>() {
      public void apply(final Resource it) {
        EcoreUtil2.resolveLazyCrossReferences(it, CancelIndicator.NullImpl);
      }
    };
    IterableExtensions.<Resource>forEach(sourceResources, _function_2);
    final boolean isErrorFree = this.validate(sourceResources);
    boolean _and = false;
    boolean _isFailOnValidationError = this.isFailOnValidationError();
    if (!_isFailOnValidationError) {
      _and = false;
    } else {
      _and = (_isFailOnValidationError && (!isErrorFree));
    }
    if (_and) {
      return isErrorFree;
    }
    this.generate(sourceResources);
    return isErrorFree;
  }
  
  protected ResourceDescriptionsData fillIndex(final XtextResourceSet set) {
    EList<Resource> _resources = set.getResources();
    ArrayList<Resource> _arrayList = new ArrayList<Resource>(_resources);
    final Function1<Resource,IResourceDescription> _function = new Function1<Resource,IResourceDescription>() {
      public IResourceDescription apply(final Resource it) {
        LanguageAccess _languageAccess = StandaloneBuilder.this.languageAccess(it);
        Manager _resourceDescriptionManager = _languageAccess.getResourceDescriptionManager();
        IResourceDescription _resourceDescription = _resourceDescriptionManager.getResourceDescription(it);
        return _resourceDescription;
      }
    };
    final List<IResourceDescription> descriptions = ListExtensions.<Resource, IResourceDescription>map(_arrayList, _function);
    ResourceDescriptionsData _resourceDescriptionsData = new ResourceDescriptionsData(descriptions);
    final ResourceDescriptionsData index = _resourceDescriptionsData;
    ResourceSetAdapter.installResourceDescriptionsData(set, index);
    return index;
  }
  
  protected String compileStubs(final File stubsDir) {
    final File stubsClasses = this.createTempDir("classes");
    Iterable<String> _classPathEntries = this.getClassPathEntries();
    this.compiler.setClassPath(_classPathEntries);
    String _absolutePath = stubsDir.getAbsolutePath();
    String _plus = ("Compiling stubs located in " + _absolutePath);
    StandaloneBuilder.LOG.info(_plus);
    Iterable<String> _sourceDirs = this.getSourceDirs();
    String _absolutePath_1 = stubsDir.getAbsolutePath();
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(_absolutePath_1);
    Iterable<String> _plus_1 = Iterables.<String>concat(_sourceDirs, _newArrayList);
    final CompilationResult result = this.compiler.compile(_plus_1, stubsClasses);
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(result,CompilationResult.SKIPPED)) {
        _matched=true;
        StandaloneBuilder.LOG.info("Nothing to compile. Stubs compilation was skipped.");
      }
    }
    if (!_matched) {
      if (Objects.equal(result,CompilationResult.FAILED)) {
        _matched=true;
        StandaloneBuilder.LOG.warn("Stubs compilation finished with errors.");
      }
    }
    return stubsClasses.getAbsolutePath();
  }
  
  protected File generateStubs(final ResourceDescriptionsData data, final List<? extends Resource> resources) {
    final File stubsDir = this.createTempDir("stubs");
    String _absolutePath = stubsDir.getAbsolutePath();
    String _plus = ("Generating stubs into " + _absolutePath);
    StandaloneBuilder.LOG.info(_plus);
    String _encoding = this.getEncoding();
    boolean _notEquals = (!Objects.equal(_encoding, null));
    if (_notEquals) {
      String _encoding_1 = this.getEncoding();
      this.encodingProvider.setDefaultEncoding(_encoding_1);
    }
    String _absolutePath_1 = stubsDir.getAbsolutePath();
    this.commonFileAccess.setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT, _absolutePath_1);
    final Function1<Resource,Boolean> _function = new Function1<Resource,Boolean>() {
      public Boolean apply(final Resource it) {
        LanguageAccess _languageAccess = StandaloneBuilder.this.languageAccess(it);
        boolean _isLinksAgainstJava = _languageAccess.isLinksAgainstJava();
        return Boolean.valueOf(_isLinksAgainstJava);
      }
    };
    final Iterable<? extends Resource> generateStubs = IterableExtensions.filter(resources, _function);
    final Procedure1<Resource> _function_1 = new Procedure1<Resource>() {
      public void apply(final Resource it) {
        LanguageAccess _languageAccess = StandaloneBuilder.this.languageAccess(it);
        IStubGenerator _stubGenerator = _languageAccess.getStubGenerator();
        URI _uRI = it.getURI();
        IResourceDescription _resourceDescription = data.getResourceDescription(_uRI);
        _stubGenerator.doGenerateStubs(StandaloneBuilder.this.commonFileAccess, _resourceDescription);
      }
    };
    IterableExtensions.forEach(generateStubs, _function_1);
    return stubsDir;
  }
  
  protected boolean validate(final List<Resource> sourceResources) {
    final ArrayList<Issue> allIssues = CollectionLiterals.<Issue>newArrayList();
    for (final Resource resource : sourceResources) {
      {
        LanguageAccess _languageAccess = this.languageAccess(resource);
        final IResourceValidator resourceValidator = _languageAccess.getResourceValidator();
        final List<Issue> validationResult = resourceValidator.validate(resource, CheckMode.ALL, null);
        allIssues.addAll(validationResult);
      }
    }
    return this.issueHandler.handleIssue(allIssues);
  }
  
  protected void generate(final List<Resource> sourceResources) {
    for (final Resource it : sourceResources) {
      {
        URI _uRI = it.getURI();
        String _lastSegment = _uRI.lastSegment();
        String _plus = ("Starting generator for input: \'" + _lastSegment);
        String _plus_1 = (_plus + "\'");
        StandaloneBuilder.LOG.info(_plus_1);
        String _encoding = this.getEncoding();
        boolean _notEquals = (!Objects.equal(_encoding, null));
        if (_notEquals) {
          LanguageAccess _languageAccess = this.languageAccess(it);
          IEncodingProvider _encodingProvider = _languageAccess.getEncodingProvider();
          final IEncodingProvider provider = _encodingProvider;
          boolean _matched = false;
          if (!_matched) {
            if (provider instanceof org.eclipse.xtext.parser.IEncodingProvider.Runtime) {
              _matched=true;
              String _encoding_1 = this.getEncoding();
              ((org.eclipse.xtext.parser.IEncodingProvider.Runtime)provider).setDefaultEncoding(_encoding_1);
            }
          }
          if (!_matched) {
            String _encoding_1 = this.getEncoding();
            String _plus_2 = ("Couldn\'t set encoding \'" + _encoding_1);
            String _plus_3 = (_plus_2 + "\' for file \'");
            URI _uRI_1 = it.getURI();
            String _plus_4 = (_plus_3 + _uRI_1);
            String _plus_5 = (_plus_4 + 
              "\'. Only subclasses of IEncodingProvider.Runtime are supported.");
            StandaloneBuilder.LOG.debug(_plus_5);
          }
        }
        LanguageAccess _languageAccess_1 = this.languageAccess(it);
        IGenerator _generator = _languageAccess_1.getGenerator();
        LanguageAccess _languageAccess_2 = this.languageAccess(it);
        JavaIoFileSystemAccess _fileSystemAccess = _languageAccess_2.getFileSystemAccess();
        _generator.doGenerate(it, _fileSystemAccess);
      }
    }
  }
  
  private LanguageAccess languageAccess(final Resource resource) {
    Map<String,LanguageAccess> _languages = this.getLanguages();
    URI _uRI = resource.getURI();
    String _fileExtension = _uRI.fileExtension();
    LanguageAccess _get = _languages.get(_fileExtension);
    return _get;
  }
  
  protected File createTempDir(final String subDir) {
    try {
      File _tempDir = this.getTempDir();
      File _file = new File(_tempDir, subDir);
      final File file = _file;
      boolean _and = false;
      boolean _mkdirs = file.mkdirs();
      boolean _not = (!_mkdirs);
      if (!_not) {
        _and = false;
      } else {
        boolean _exists = file.exists();
        boolean _not_1 = (!_exists);
        _and = (_not && _not_1);
      }
      if (_and) {
        String _absolutePath = file.getAbsolutePath();
        String _plus = ("Failed to create directory \'" + _absolutePath);
        String _plus_1 = (_plus + "\'");
        IOException _iOException = new IOException(_plus_1);
        throw _iOException;
      }
      return file;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void installTypeProvider(final Iterable<String> classPathRoots, final XtextResourceSet resSet, final IndexedJvmTypeAccess typeAccess) {
    final URLClassLoader classLoader = this.createURLClassLoader(classPathRoots);
    new ClasspathTypeProvider(classLoader, resSet, typeAccess);
    resSet.setClasspathURIContext(classLoader);
  }
  
  private URLClassLoader createURLClassLoader(final Iterable<String> classPathEntries) {
    final Function1<String,URL> _function = new Function1<String,URL>() {
      public URL apply(final String str) {
        try {
          File _file = new File(str);
          java.net.URI _uRI = _file.toURI();
          URL _uRL = _uRI.toURL();
          return _uRL;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    final Iterable<URL> classPathUrls = IterableExtensions.<String, URL>map(classPathEntries, _function);
    URLClassLoader _uRLClassLoader = new URLClassLoader(((URL[])Conversions.unwrapArray(classPathUrls, URL.class)));
    return _uRLClassLoader;
  }
  
  protected List<Resource> collectResources(final Iterable<String> roots, final ResourceSet resourceSet) {
    Map<String,LanguageAccess> _languages = this.getLanguages();
    Set<String> _keySet = _languages.keySet();
    final String extensions = IterableExtensions.join(_keySet, "|");
    NameBasedFilter _nameBasedFilter = new NameBasedFilter();
    final NameBasedFilter nameBasedFilter = _nameBasedFilter;
    nameBasedFilter.setRegularExpression(((".*\\.(?:(" + extensions) + "))$"));
    PathTraverser _pathTraverser = new PathTraverser();
    final PathTraverser pathTraverser = _pathTraverser;
    final List<Resource> resources = CollectionLiterals.<Resource>newArrayList();
    List<String> _list = IterableExtensions.<String>toList(roots);
    final Predicate<URI> _function = new Predicate<URI>() {
      public boolean apply(final URI input) {
        final boolean matches = nameBasedFilter.matches(input);
        if (matches) {
          boolean _isDebugEnabled = StandaloneBuilder.LOG.isDebugEnabled();
          if (_isDebugEnabled) {
            StandaloneBuilder.LOG.debug((("Adding file \'" + input) + "\'"));
          }
          Resource _resource = resourceSet.getResource(input, true);
          resources.add(_resource);
        }
        return matches;
      }
    };
    pathTraverser.resolvePathes(_list, _function);
    return resources;
  }
  
  public IJavaCompiler getCompiler() {
    return this.compiler;
  }
}
