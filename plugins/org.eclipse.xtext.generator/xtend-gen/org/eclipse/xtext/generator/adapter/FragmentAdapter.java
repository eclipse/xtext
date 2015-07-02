/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.adapter;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xpand2.output.PostProcessor;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ResourceManager;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.BindKey;
import org.eclipse.xtext.generator.BindValue;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.generator.IGeneratorFragmentExtension2;
import org.eclipse.xtext.generator.LanguageConfig;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.NewlineNormalizer;
import org.eclipse.xtext.generator.adapter.StringConcatOutputImpl;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.IGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.model.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.FileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;

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
  
  @Accessors
  private Naming naming;
  
  private final List<PostProcessor> postProcessors = CollectionLiterals.<PostProcessor>newArrayList();
  
  public void addPostProcessor(final PostProcessor postProcessor) {
    this.postProcessors.add(postProcessor);
  }
  
  @Override
  public void generate() {
    if ((this.naming == null)) {
      Naming _createNaming = this.createNaming();
      this.naming = _createNaming;
    }
    final XpandExecutionContext ctx = this.createExecutionContext();
    final LanguageConfig config = this.createLanguageConfig();
    if ((this.fragment instanceof IGeneratorFragmentExtension2)) {
      ((IGeneratorFragmentExtension2)this.fragment).generate(config, ctx);
    } else {
      Grammar _grammar = config.getGrammar();
      this.fragment.generate(_grammar, ctx);
    }
    this.generateStandaloneSetup(config, ctx);
    this.generateGuiceModuleRt(config, ctx);
    this.generateGuiceModuleUi(config, ctx);
    this.generatePluginXmlRt(config, ctx);
  }
  
  private void generateStandaloneSetup(final LanguageConfig config, final XpandExecutionContext ctx) {
    Output _output = ctx.getOutput();
    _output.openFile(null, StringConcatOutputImpl.STRING_OUTLET);
    try {
      if ((this.fragment instanceof IGeneratorFragmentExtension2)) {
        ((IGeneratorFragmentExtension2)this.fragment).addToStandaloneSetup(config, ctx);
      } else {
        Grammar _grammar = config.getGrammar();
        this.fragment.addToStandaloneSetup(_grammar, ctx);
      }
      Output _output_1 = ctx.getOutput();
      final StringConcatenation result = ((StringConcatOutputImpl) _output_1).getStringOutlet();
      JavaFileAccess _runtimeSetup = this.languageConfig2.getRuntimeSetup();
      List<CharSequence> _codeFragments = _runtimeSetup.getCodeFragments();
      _codeFragments.add(result);
    } finally {
      Output _output_2 = ctx.getOutput();
      _output_2.closeFile();
    }
  }
  
  private boolean generateGuiceModuleRt(final LanguageConfig config, final XpandExecutionContext ctx) {
    GuiceModuleAccess _runtimeModule = this.languageConfig2.getRuntimeModule();
    List<GuiceModuleAccess.Binding> _bindings = _runtimeModule.getBindings();
    Grammar _grammar = config.getGrammar();
    Set<Binding> _guiceBindingsRt = this.fragment.getGuiceBindingsRt(_grammar);
    final Function1<Binding, GuiceModuleAccess.Binding> _function = new Function1<Binding, GuiceModuleAccess.Binding>() {
      @Override
      public GuiceModuleAccess.Binding apply(final Binding it) {
        return FragmentAdapter.this.translateBinding(it);
      }
    };
    Iterable<GuiceModuleAccess.Binding> _map = IterableExtensions.<Binding, GuiceModuleAccess.Binding>map(_guiceBindingsRt, _function);
    return Iterables.<GuiceModuleAccess.Binding>addAll(_bindings, _map);
  }
  
  private boolean generateGuiceModuleUi(final LanguageConfig config, final XpandExecutionContext ctx) {
    GuiceModuleAccess _eclipsePluginModule = this.languageConfig2.getEclipsePluginModule();
    List<GuiceModuleAccess.Binding> _bindings = _eclipsePluginModule.getBindings();
    Grammar _grammar = config.getGrammar();
    Set<Binding> _guiceBindingsUi = this.fragment.getGuiceBindingsUi(_grammar);
    final Function1<Binding, GuiceModuleAccess.Binding> _function = new Function1<Binding, GuiceModuleAccess.Binding>() {
      @Override
      public GuiceModuleAccess.Binding apply(final Binding it) {
        return FragmentAdapter.this.translateBinding(it);
      }
    };
    Iterable<GuiceModuleAccess.Binding> _map = IterableExtensions.<Binding, GuiceModuleAccess.Binding>map(_guiceBindingsUi, _function);
    return Iterables.<GuiceModuleAccess.Binding>addAll(_bindings, _map);
  }
  
  private GuiceModuleAccess.Binding translateBinding(final Binding it) {
    GuiceModuleAccess.Binding _xblockexpression = null;
    {
      BindKey _key = it.getKey();
      String _type = _key.getType();
      BindKey _key_1 = it.getKey();
      boolean _isSingleton = _key_1.isSingleton();
      BindKey _key_2 = it.getKey();
      boolean _isEagerSingleton = _key_2.isEagerSingleton();
      final GuiceModuleAccess.BindKey newKey = new GuiceModuleAccess.BindKey(_type, _isSingleton, _isEagerSingleton);
      BindValue _value = it.getValue();
      String _expression = _value.getExpression();
      BindValue _value_1 = it.getValue();
      String _typeName = _value_1.getTypeName();
      BindValue _value_2 = it.getValue();
      boolean _isProvider = _value_2.isProvider();
      BindValue _value_3 = it.getValue();
      String[] _statements = _value_3.getStatements();
      final GuiceModuleAccess.BindValue newValue = new GuiceModuleAccess.BindValue(_expression, _typeName, _isProvider, (List<CharSequence>)Conversions.doWrapArray(_statements));
      String _contributedBy = it.getContributedBy();
      boolean _isFinal = it.isFinal();
      _xblockexpression = new GuiceModuleAccess.Binding(newKey, newValue, _contributedBy, _isFinal);
    }
    return _xblockexpression;
  }
  
  private void generatePluginXmlRt(final LanguageConfig config, final XpandExecutionContext ctx) {
    Output _output = ctx.getOutput();
    _output.openFile(null, StringConcatOutputImpl.STRING_OUTLET);
    try {
      if ((this.fragment instanceof IGeneratorFragmentExtension2)) {
        ((IGeneratorFragmentExtension2)this.fragment).addToPluginXmlRt(config, ctx);
      } else {
        Grammar _grammar = config.getGrammar();
        this.fragment.addToPluginXmlRt(_grammar, ctx);
      }
      Output _output_1 = ctx.getOutput();
      final StringConcatenation result = ((StringConcatOutputImpl) _output_1).getStringOutlet();
      TextFileAccess _runtimePluginXml = this.projectConfig.getRuntimePluginXml();
      List<CharSequence> _codeFragments = _runtimePluginXml.getCodeFragments();
      _codeFragments.add(result);
    } finally {
      Output _output_2 = ctx.getOutput();
      _output_2.closeFile();
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
        String _activator = FragmentAdapter.this.getActivator();
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
  
  protected LanguageConfig createLanguageConfig() {
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
    config.registerNaming(this.naming);
    return config;
  }
  
  protected XpandExecutionContext createExecutionContext() {
    final String encoding = this.encodingProvider.getEncoding(null);
    final StringConcatOutputImpl output = new StringConcatOutputImpl();
    String _projectNameRt = this.naming.getProjectNameRt();
    Outlet _createOutlet = this.createOutlet(false, encoding, Generator.PLUGIN_RT, false, _projectNameRt);
    output.addOutlet(_createOutlet);
    IFileSystemAccess2 _runtimeSrc = this.projectConfig.getRuntimeSrc();
    boolean _tripleNotEquals = (_runtimeSrc != null);
    if (_tripleNotEquals) {
      IFileSystemAccess2 _runtimeSrc_1 = this.projectConfig.getRuntimeSrc();
      String _path = this.getPath(_runtimeSrc_1);
      Outlet _createOutlet_1 = this.createOutlet(false, encoding, Generator.SRC, false, _path);
      output.addOutlet(_createOutlet_1);
    }
    IFileSystemAccess2 _runtimeSrcGen = this.projectConfig.getRuntimeSrcGen();
    boolean _tripleNotEquals_1 = (_runtimeSrcGen != null);
    if (_tripleNotEquals_1) {
      IFileSystemAccess2 _runtimeSrcGen_1 = this.projectConfig.getRuntimeSrcGen();
      String _path_1 = this.getPath(_runtimeSrcGen_1);
      Outlet _createOutlet_2 = this.createOutlet(false, encoding, Generator.SRC_GEN, true, _path_1);
      output.addOutlet(_createOutlet_2);
    }
    String _projectNameRt_1 = this.naming.getProjectNameRt();
    String _plus = (_projectNameRt_1 + "/model");
    Outlet _createOutlet_3 = this.createOutlet(false, encoding, Generator.MODEL, false, _plus);
    output.addOutlet(_createOutlet_3);
    String _projectNameUi = this.naming.getProjectNameUi();
    boolean _tripleNotEquals_2 = (_projectNameUi != null);
    if (_tripleNotEquals_2) {
      String _projectNameUi_1 = this.naming.getProjectNameUi();
      Outlet _createOutlet_4 = this.createOutlet(false, encoding, Generator.PLUGIN_UI, false, _projectNameUi_1);
      output.addOutlet(_createOutlet_4);
    }
    IFileSystemAccess2 _eclipsePluginSrc = this.projectConfig.getEclipsePluginSrc();
    boolean _tripleNotEquals_3 = (_eclipsePluginSrc != null);
    if (_tripleNotEquals_3) {
      IFileSystemAccess2 _eclipsePluginSrc_1 = this.projectConfig.getEclipsePluginSrc();
      String _path_2 = this.getPath(_eclipsePluginSrc_1);
      Outlet _createOutlet_5 = this.createOutlet(false, encoding, Generator.SRC_UI, false, _path_2);
      output.addOutlet(_createOutlet_5);
    }
    IFileSystemAccess2 _eclipsePluginSrcGen = this.projectConfig.getEclipsePluginSrcGen();
    boolean _tripleNotEquals_4 = (_eclipsePluginSrcGen != null);
    if (_tripleNotEquals_4) {
      IFileSystemAccess2 _eclipsePluginSrcGen_1 = this.projectConfig.getEclipsePluginSrcGen();
      String _path_3 = this.getPath(_eclipsePluginSrcGen_1);
      Outlet _createOutlet_6 = this.createOutlet(false, encoding, Generator.SRC_GEN_UI, true, _path_3);
      output.addOutlet(_createOutlet_6);
    }
    String _projectNameIde = this.naming.getProjectNameIde();
    boolean _tripleNotEquals_5 = (_projectNameIde != null);
    if (_tripleNotEquals_5) {
      String _projectNameIde_1 = this.naming.getProjectNameIde();
      Outlet _createOutlet_7 = this.createOutlet(false, encoding, Generator.PLUGIN_IDE, false, _projectNameIde_1);
      output.addOutlet(_createOutlet_7);
    }
    IFileSystemAccess2 _genericIdeSrc = this.projectConfig.getGenericIdeSrc();
    boolean _tripleNotEquals_6 = (_genericIdeSrc != null);
    if (_tripleNotEquals_6) {
      IFileSystemAccess2 _genericIdeSrc_1 = this.projectConfig.getGenericIdeSrc();
      String _path_4 = this.getPath(_genericIdeSrc_1);
      Outlet _createOutlet_8 = this.createOutlet(false, encoding, Generator.SRC_IDE, false, _path_4);
      output.addOutlet(_createOutlet_8);
    }
    IFileSystemAccess2 _genericIdeSrcGen = this.projectConfig.getGenericIdeSrcGen();
    boolean _tripleNotEquals_7 = (_genericIdeSrcGen != null);
    if (_tripleNotEquals_7) {
      IFileSystemAccess2 _genericIdeSrcGen_1 = this.projectConfig.getGenericIdeSrcGen();
      String _path_5 = this.getPath(_genericIdeSrcGen_1);
      Outlet _createOutlet_9 = this.createOutlet(false, encoding, Generator.SRC_GEN_IDE, true, _path_5);
      output.addOutlet(_createOutlet_9);
    }
    String _pathTestProject = this.naming.getPathTestProject();
    boolean _tripleNotEquals_8 = (_pathTestProject != null);
    if (_tripleNotEquals_8) {
      String _pathTestProject_1 = this.naming.getPathTestProject();
      Outlet _createOutlet_10 = this.createOutlet(false, encoding, Generator.PLUGIN_TEST, false, _pathTestProject_1);
      output.addOutlet(_createOutlet_10);
    }
    IFileSystemAccess2 _runtimeTestSrc = this.projectConfig.getRuntimeTestSrc();
    boolean _tripleNotEquals_9 = (_runtimeTestSrc != null);
    if (_tripleNotEquals_9) {
      IFileSystemAccess2 _runtimeTestSrc_1 = this.projectConfig.getRuntimeTestSrc();
      String _path_6 = this.getPath(_runtimeTestSrc_1);
      Outlet _createOutlet_11 = this.createOutlet(false, encoding, Generator.SRC_TEST, false, _path_6);
      output.addOutlet(_createOutlet_11);
    }
    IFileSystemAccess2 _runtimeTestSrcGen = this.projectConfig.getRuntimeTestSrcGen();
    boolean _tripleNotEquals_10 = (_runtimeTestSrcGen != null);
    if (_tripleNotEquals_10) {
      IFileSystemAccess2 _runtimeTestSrcGen_1 = this.projectConfig.getRuntimeTestSrcGen();
      String _path_7 = this.getPath(_runtimeTestSrcGen_1);
      Outlet _createOutlet_12 = this.createOutlet(false, encoding, Generator.SRC_GEN_TEST, true, _path_7);
      output.addOutlet(_createOutlet_12);
    }
    final Map<String, Variable> globalVars = Maps.<String, Variable>newHashMap();
    Variable _variable = new Variable(Naming.GLOBAL_VAR_NAME, this.naming);
    globalVars.put(Naming.GLOBAL_VAR_NAME, _variable);
    XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null, globalVars, null, null);
    ResourceManager _resourceManager = execCtx.getResourceManager();
    _resourceManager.setFileEncoding("ISO-8859-1");
    JavaBeansMetaModel _javaBeansMetaModel = new JavaBeansMetaModel();
    execCtx.registerMetaModel(_javaBeansMetaModel);
    String _projectNameRt_2 = this.naming.getProjectNameRt();
    Variable _variable_1 = new Variable("modelPluginID", _projectNameRt_2);
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
  
  protected String getActivator() {
    final Grammar grammar = this.languageConfig2.getGrammar();
    String _basePackageUi = this.naming.basePackageUi(grammar);
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
  
  @Pure
  public Naming getNaming() {
    return this.naming;
  }
  
  public void setNaming(final Naming naming) {
    this.naming = naming;
  }
}
