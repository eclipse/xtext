/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xpand2.output.PostProcessor;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ResourceManager;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.generator.IGeneratorFragmentExtension2;
import org.eclipse.xtext.generator.LanguageConfig;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.NewlineNormalizer;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.IGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.model.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.FileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;

@SuppressWarnings("all")
public class FragmentAdapter implements IGeneratorFragment2 {
  @Inject
  private IXtextProjectConfig projectConfig;
  
  @Inject
  private LanguageConfig2 languageConfig2;
  
  @Inject
  private CodeConfig codeConfig;
  
  @Inject
  private IEncodingProvider encodingProvider;
  
  @Inject
  private Provider<ResourceSet> resourceSetProvider;
  
  @Accessors
  private IGeneratorFragment fragment;
  
  private final List<PostProcessor> postProcessors = CollectionLiterals.<PostProcessor>newArrayList();
  
  public void addPostProcessor(final PostProcessor postProcessor) {
    this.postProcessors.add(postProcessor);
  }
  
  @Override
  public void generate() {
    final Naming naming = this.createNaming();
    final XpandExecutionContext ctx = this.createExecutionContext(naming);
    if ((this.fragment instanceof IGeneratorFragmentExtension2)) {
      final LanguageConfig config = this.createLanguageConfig(naming);
      ((IGeneratorFragmentExtension2)this.fragment).generate(config, ctx);
    } else {
      Grammar _grammar = this.languageConfig2.getGrammar();
      this.fragment.generate(_grammar, ctx);
    }
  }
  
  protected Naming createNaming() {
    Naming _naming = new Naming();
    final Procedure1<Naming> _function = new Procedure1<Naming>() {
      @Override
      public void apply(final Naming it) {
        ManifestAccess _runtimeManifest = FragmentAdapter.this.projectConfig.getRuntimeManifest();
        String _pluginPath = null;
        if (_runtimeManifest!=null) {
          _pluginPath=FragmentAdapter.this.getPluginPath(_runtimeManifest);
        }
        it.setProjectNameRt(_pluginPath);
        ManifestAccess _genericIdeManifest = FragmentAdapter.this.projectConfig.getGenericIdeManifest();
        String _pluginPath_1 = null;
        if (_genericIdeManifest!=null) {
          _pluginPath_1=FragmentAdapter.this.getPluginPath(_genericIdeManifest);
        }
        it.setProjectNameIde(_pluginPath_1);
        ManifestAccess _eclipsePluginManifest = FragmentAdapter.this.projectConfig.getEclipsePluginManifest();
        String _pluginPath_2 = null;
        if (_eclipsePluginManifest!=null) {
          _pluginPath_2=FragmentAdapter.this.getPluginPath(_eclipsePluginManifest);
        }
        it.setProjectNameUi(_pluginPath_2);
        boolean _and = false;
        String _projectNameIde = it.getProjectNameIde();
        boolean _tripleEquals = (_projectNameIde == null);
        if (!_tripleEquals) {
          _and = false;
        } else {
          String _projectNameUi = it.getProjectNameUi();
          boolean _tripleNotEquals = (_projectNameUi != null);
          _and = _tripleNotEquals;
        }
        if (_and) {
          String _projectNameUi_1 = it.getProjectNameUi();
          it.setIdeBasePackage(_projectNameUi_1);
        } else {
          String _projectNameIde_1 = it.getProjectNameIde();
          it.setIdeBasePackage(_projectNameIde_1);
        }
        String _projectNameUi_2 = it.getProjectNameUi();
        it.setUiBasePackage(_projectNameUi_2);
        String _activator = FragmentAdapter.this.getActivator(it);
        it.setActivatorName(_activator);
        ManifestAccess _runtimeTestManifest = FragmentAdapter.this.projectConfig.getRuntimeTestManifest();
        String _pluginPath_3 = FragmentAdapter.this.getPluginPath(_runtimeTestManifest);
        it.setPathTestProject(_pluginPath_3);
        String _fileHeader = FragmentAdapter.this.codeConfig.getFileHeader();
        it.setFileHeader(_fileHeader);
        String _classAnnotationsAsString = FragmentAdapter.this.codeConfig.getClassAnnotationsAsString();
        it.setClassAnnotations(_classAnnotationsAsString);
        String _annotationImportsAsString = FragmentAdapter.this.codeConfig.getAnnotationImportsAsString();
        it.setAnnotationImports(_annotationImportsAsString);
        String _projectNameUi_3 = it.getProjectNameUi();
        boolean _tripleNotEquals_1 = (_projectNameUi_3 != null);
        it.setHasUI(_tripleNotEquals_1);
        String _projectNameIde_2 = it.getProjectNameIde();
        boolean _tripleNotEquals_2 = (_projectNameIde_2 != null);
        it.setHasIde(_tripleNotEquals_2);
      }
    };
    return ObjectExtensions.<Naming>operator_doubleArrow(_naming, _function);
  }
  
  protected LanguageConfig createLanguageConfig(final Naming naming) {
    final LanguageConfig config = new LanguageConfig();
    List<String> _loadedResources = this.languageConfig2.getLoadedResources();
    for (final String resource : _loadedResources) {
      config.addLoadedResource(resource);
    }
    ResourceSet _get = this.resourceSetProvider.get();
    config.setForcedResourceSet(_get);
    List<String> _fileExtensions = this.languageConfig2.getFileExtensions();
    String _join = IterableExtensions.join(_fileExtensions, ",");
    config.setFileExtensions(_join);
    String _uri = this.languageConfig2.getUri();
    config.setUri(_uri);
    config.registerNaming(naming);
    return config;
  }
  
  protected XpandExecutionContext createExecutionContext(final Naming naming) {
    final String encoding = this.encodingProvider.getEncoding(null);
    final OutputImpl output = new OutputImpl();
    ManifestAccess _runtimeManifest = this.projectConfig.getRuntimeManifest();
    final String projectNameRt = this.getPluginPath(_runtimeManifest);
    Outlet _createOutlet = this.createOutlet(false, encoding, Generator.PLUGIN_RT, false, projectNameRt);
    output.addOutlet(_createOutlet);
    IFileSystemAccess2 _runtimeSrc = this.projectConfig.getRuntimeSrc();
    String _path = this.getPath(_runtimeSrc);
    Outlet _createOutlet_1 = this.createOutlet(false, encoding, Generator.SRC, false, _path);
    output.addOutlet(_createOutlet_1);
    IFileSystemAccess2 _runtimeSrcGen = this.projectConfig.getRuntimeSrcGen();
    String _path_1 = this.getPath(_runtimeSrcGen);
    Outlet _createOutlet_2 = this.createOutlet(false, encoding, Generator.SRC_GEN, true, _path_1);
    output.addOutlet(_createOutlet_2);
    ManifestAccess _runtimeManifest_1 = this.projectConfig.getRuntimeManifest();
    String _pluginPath = this.getPluginPath(_runtimeManifest_1);
    String _plus = (_pluginPath + "/model");
    Outlet _createOutlet_3 = this.createOutlet(false, encoding, Generator.MODEL, false, _plus);
    output.addOutlet(_createOutlet_3);
    ManifestAccess _eclipsePluginManifest = this.projectConfig.getEclipsePluginManifest();
    boolean _tripleNotEquals = (_eclipsePluginManifest != null);
    if (_tripleNotEquals) {
      ManifestAccess _eclipsePluginManifest_1 = this.projectConfig.getEclipsePluginManifest();
      String _pluginPath_1 = this.getPluginPath(_eclipsePluginManifest_1);
      Outlet _createOutlet_4 = this.createOutlet(false, encoding, Generator.PLUGIN_UI, false, _pluginPath_1);
      output.addOutlet(_createOutlet_4);
      IFileSystemAccess2 _eclipsePluginSrc = this.projectConfig.getEclipsePluginSrc();
      String _path_2 = this.getPath(_eclipsePluginSrc);
      Outlet _createOutlet_5 = this.createOutlet(false, encoding, Generator.SRC_UI, false, _path_2);
      output.addOutlet(_createOutlet_5);
      IFileSystemAccess2 _eclipsePluginSrcGen = this.projectConfig.getEclipsePluginSrcGen();
      String _path_3 = this.getPath(_eclipsePluginSrcGen);
      Outlet _createOutlet_6 = this.createOutlet(false, encoding, Generator.SRC_GEN_UI, true, _path_3);
      output.addOutlet(_createOutlet_6);
    }
    ManifestAccess _genericIdeManifest = this.projectConfig.getGenericIdeManifest();
    boolean _tripleNotEquals_1 = (_genericIdeManifest != null);
    if (_tripleNotEquals_1) {
      ManifestAccess _genericIdeManifest_1 = this.projectConfig.getGenericIdeManifest();
      String _pluginPath_2 = this.getPluginPath(_genericIdeManifest_1);
      Outlet _createOutlet_7 = this.createOutlet(false, encoding, Generator.PLUGIN_IDE, false, _pluginPath_2);
      output.addOutlet(_createOutlet_7);
      IFileSystemAccess2 _genericIdeSrc = this.projectConfig.getGenericIdeSrc();
      String _path_4 = this.getPath(_genericIdeSrc);
      Outlet _createOutlet_8 = this.createOutlet(false, encoding, Generator.SRC_IDE, false, _path_4);
      output.addOutlet(_createOutlet_8);
      IFileSystemAccess2 _genericIdeSrcGen = this.projectConfig.getGenericIdeSrcGen();
      String _path_5 = this.getPath(_genericIdeSrcGen);
      Outlet _createOutlet_9 = this.createOutlet(false, encoding, Generator.SRC_GEN_IDE, true, _path_5);
      output.addOutlet(_createOutlet_9);
    }
    ManifestAccess _runtimeTestManifest = this.projectConfig.getRuntimeTestManifest();
    boolean _tripleNotEquals_2 = (_runtimeTestManifest != null);
    if (_tripleNotEquals_2) {
      ManifestAccess _runtimeTestManifest_1 = this.projectConfig.getRuntimeTestManifest();
      String _pluginPath_3 = this.getPluginPath(_runtimeTestManifest_1);
      Outlet _createOutlet_10 = this.createOutlet(false, encoding, Generator.PLUGIN_TEST, false, _pluginPath_3);
      output.addOutlet(_createOutlet_10);
      IFileSystemAccess2 _runtimeTestSrc = this.projectConfig.getRuntimeTestSrc();
      String _path_6 = this.getPath(_runtimeTestSrc);
      Outlet _createOutlet_11 = this.createOutlet(false, encoding, Generator.SRC_TEST, false, _path_6);
      output.addOutlet(_createOutlet_11);
      IFileSystemAccess2 _runtimeTestSrcGen = this.projectConfig.getRuntimeTestSrcGen();
      String _path_7 = this.getPath(_runtimeTestSrcGen);
      Outlet _createOutlet_12 = this.createOutlet(false, encoding, Generator.SRC_GEN_TEST, true, _path_7);
      output.addOutlet(_createOutlet_12);
    }
    final Map<String, Variable> globalVars = Maps.<String, Variable>newHashMap();
    Variable _variable = new Variable(Naming.GLOBAL_VAR_NAME, naming);
    globalVars.put(Naming.GLOBAL_VAR_NAME, _variable);
    XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null, globalVars, null, null);
    ResourceManager _resourceManager = execCtx.getResourceManager();
    _resourceManager.setFileEncoding("ISO-8859-1");
    JavaBeansMetaModel _javaBeansMetaModel = new JavaBeansMetaModel();
    execCtx.registerMetaModel(_javaBeansMetaModel);
    Variable _variable_1 = new Variable("modelPluginID", projectNameRt);
    ExecutionContext _cloneWithVariable = execCtx.cloneWithVariable(_variable_1);
    execCtx = ((XpandExecutionContextImpl) _cloneWithVariable);
    return execCtx;
  }
  
  protected Outlet createOutlet(final boolean append, final String encoding, final String name, final boolean overwrite, final String path) {
    final Outlet outlet = new Outlet(append, encoding, name, overwrite, path);
    String _lineDelimiter = this.codeConfig.getLineDelimiter();
    NewlineNormalizer _newlineNormalizer = new NewlineNormalizer(_lineDelimiter);
    outlet.addPostprocessor(_newlineNormalizer);
    for (final PostProcessor pp : this.postProcessors) {
      outlet.addPostprocessor(pp);
    }
    return outlet;
  }
  
  protected String getActivator(final Naming naming) {
    final Grammar grammar = this.languageConfig2.getGrammar();
    String _basePackageUi = naming.basePackageUi(grammar);
    String _plus = (_basePackageUi + ".internal.");
    String _name = GrammarUtil.getName(grammar);
    String _plus_1 = (_plus + _name);
    return (_plus_1 + "Activator");
  }
  
  protected String getPath(final IFileSystemAccess2 fsa) {
    if ((fsa instanceof FileSystemAccess)) {
      return ((FileSystemAccess)fsa).getPath();
    } else {
      URI _uRI = fsa.getURI("");
      return _uRI.toPlatformString(true);
    }
  }
  
  protected String getPluginPath(final ManifestAccess manifest) {
    String _path = manifest.getPath();
    final int metaInfIndex = _path.indexOf("/META-INF");
    String _path_1 = manifest.getPath();
    return _path_1.substring(0, metaInfIndex);
  }
  
  @Pure
  public IGeneratorFragment getFragment() {
    return this.fragment;
  }
  
  public void setFragment(final IGeneratorFragment fragment) {
    this.fragment = fragment;
  }
}
