/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.adapter;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.issues.Issues;
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
import org.eclipse.xtext.generator.BindKey;
import org.eclipse.xtext.generator.BindValue;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.generator.IGeneratorFragmentExtension;
import org.eclipse.xtext.generator.IGeneratorFragmentExtension2;
import org.eclipse.xtext.generator.IGeneratorFragmentExtension3;
import org.eclipse.xtext.generator.IGeneratorFragmentExtension4;
import org.eclipse.xtext.generator.LanguageConfig;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.NamingAware;
import org.eclipse.xtext.generator.NewlineNormalizer;
import org.eclipse.xtext.generator.adapter.StringConcatOutputImpl;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.IGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.XtextGenerator;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.StandaloneSetupAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

/**
 * @since 2.9
 */
@SuppressWarnings("all")
public class FragmentAdapter implements IGeneratorFragment2 {
  @Inject
  private IXtextProjectConfig projectConfig;
  
  @Inject
  private CodeConfig codeConfig;
  
  @Inject
  private IEncodingProvider encodingProvider;
  
  @Accessors
  private IGeneratorFragment fragment;
  
  @Accessors
  private Naming naming;
  
  private final List<PostProcessor> postProcessors = CollectionLiterals.<PostProcessor>newArrayList();
  
  public void addPostProcessor(final PostProcessor postProcessor) {
    this.postProcessors.add(postProcessor);
  }
  
  @Override
  public void checkConfiguration(final XtextGenerator generator, final Issues issues) {
    if ((this.naming == null)) {
      List<LanguageConfig2> _languageConfigs = generator.getLanguageConfigs();
      LanguageConfig2 _head = IterableExtensions.<LanguageConfig2>head(_languageConfigs);
      Naming _createNaming = this.createNaming(_head);
      this.naming = _createNaming;
    }
    if ((this.fragment == null)) {
      issues.addError(generator, "The property \'fragment\' must be set.", this);
    } else {
      this.fragment.checkConfiguration(issues);
    }
  }
  
  @Override
  public void initialize(final Injector injector) {
    injector.injectMembers(this);
  }
  
  @Override
  public void generate(final LanguageConfig2 config2) {
    if ((this.naming == null)) {
      Naming _createNaming = this.createNaming(config2);
      this.naming = _createNaming;
    }
    final XpandExecutionContext ctx = this.createExecutionContext();
    final LanguageConfig config1 = this.createLanguageConfig(config2);
    if ((this.fragment instanceof IGeneratorFragmentExtension2)) {
      ((IGeneratorFragmentExtension2)this.fragment).generate(config1, ctx);
    } else {
      Grammar _grammar = config1.getGrammar();
      this.fragment.generate(_grammar, ctx);
    }
    this.generateStandaloneSetup(config1, config2, ctx);
    this.generateGuiceModuleRt(config1, config2, ctx);
    this.generateGuiceModuleUi(config1, config2, ctx);
    this.generatePluginXmlRt(config1, ctx);
    this.generateManifestRt(config1, ctx);
    this.generatePluginXmlUi(config1, ctx);
    this.generateManifestUi(config1, ctx);
    this.generateManifestIde(config1, ctx);
    this.generateManifestTests(config1, ctx);
  }
  
  private void generateStandaloneSetup(final LanguageConfig config1, final LanguageConfig2 config2, final XpandExecutionContext ctx) {
    Output _output = ctx.getOutput();
    _output.openFile(null, StringConcatOutputImpl.STRING_OUTLET);
    try {
      if ((this.fragment instanceof IGeneratorFragmentExtension2)) {
        ((IGeneratorFragmentExtension2)this.fragment).addToStandaloneSetup(config1, ctx);
      } else {
        Grammar _grammar = config1.getGrammar();
        this.fragment.addToStandaloneSetup(_grammar, ctx);
      }
      Output _output_1 = ctx.getOutput();
      final StringConcatenation result = ((StringConcatOutputImpl) _output_1).getStringOutlet();
      StandaloneSetupAccess _runtimeGenSetup = config2.getRuntimeGenSetup();
      List<CharSequence> _registrations = _runtimeGenSetup.getRegistrations();
      String _string = result.toString();
      StringBuilder _decreaseIndentation = this.decreaseIndentation(_string, 2);
      _registrations.add(_decreaseIndentation);
      StandaloneSetupAccess _runtimeGenSetup_1 = config2.getRuntimeGenSetup();
      Set<TypeReference> _imports = _runtimeGenSetup_1.getImports();
      TypeReference _typeReference = new TypeReference("org.eclipse.emf.ecore.EPackage");
      _imports.add(_typeReference);
      StandaloneSetupAccess _runtimeGenSetup_2 = config2.getRuntimeGenSetup();
      Set<TypeReference> _imports_1 = _runtimeGenSetup_2.getImports();
      TypeReference _typeReference_1 = new TypeReference("org.eclipse.emf.ecore.resource.Resource");
      _imports_1.add(_typeReference_1);
    } finally {
      Output _output_2 = ctx.getOutput();
      _output_2.closeFile();
    }
  }
  
  private void generateGuiceModuleRt(final LanguageConfig config1, final LanguageConfig2 config2, final XpandExecutionContext ctx) {
    Grammar _grammar = config1.getGrammar();
    final Set<Binding> bindings = this.fragment.getGuiceBindingsRt(_grammar);
    if ((bindings != null)) {
      GuiceModuleAccess _runtimeGenModule = config2.getRuntimeGenModule();
      final Function1<Binding, GuiceModuleAccess.Binding> _function = new Function1<Binding, GuiceModuleAccess.Binding>() {
        @Override
        public GuiceModuleAccess.Binding apply(final Binding it) {
          return FragmentAdapter.this.translateBinding(it);
        }
      };
      Iterable<GuiceModuleAccess.Binding> _map = IterableExtensions.<Binding, GuiceModuleAccess.Binding>map(bindings, _function);
      _runtimeGenModule.addAll(_map);
    }
    if ((this.fragment instanceof IGeneratorFragmentExtension4)) {
      Grammar _grammar_1 = config1.getGrammar();
      final String superClass = ((IGeneratorFragmentExtension4)this.fragment).getDefaultRuntimeModuleClassName(_grammar_1);
      if ((superClass != null)) {
        GuiceModuleAccess _runtimeGenModule_1 = config2.getRuntimeGenModule();
        TypeReference _typeReference = new TypeReference(superClass);
        _runtimeGenModule_1.setSuperClass(_typeReference);
      }
    }
  }
  
  private void generateGuiceModuleUi(final LanguageConfig config1, final LanguageConfig2 config2, final XpandExecutionContext ctx) {
    Grammar _grammar = config1.getGrammar();
    final Set<Binding> bindings = this.fragment.getGuiceBindingsUi(_grammar);
    if ((bindings != null)) {
      GuiceModuleAccess _eclipsePluginGenModule = config2.getEclipsePluginGenModule();
      final Function1<Binding, GuiceModuleAccess.Binding> _function = new Function1<Binding, GuiceModuleAccess.Binding>() {
        @Override
        public GuiceModuleAccess.Binding apply(final Binding it) {
          return FragmentAdapter.this.translateBinding(it);
        }
      };
      Iterable<GuiceModuleAccess.Binding> _map = IterableExtensions.<Binding, GuiceModuleAccess.Binding>map(bindings, _function);
      _eclipsePluginGenModule.addAll(_map);
    }
    if ((this.fragment instanceof IGeneratorFragmentExtension4)) {
      Grammar _grammar_1 = config1.getGrammar();
      final String superClass = ((IGeneratorFragmentExtension4)this.fragment).getDefaultUiModuleClassName(_grammar_1);
      if ((superClass != null)) {
        GuiceModuleAccess _eclipsePluginGenModule_1 = config2.getEclipsePluginGenModule();
        TypeReference _typeReference = new TypeReference(superClass);
        _eclipsePluginGenModule_1.setSuperClass(_typeReference);
      }
    }
  }
  
  private GuiceModuleAccess.Binding translateBinding(final Binding it) {
    GuiceModuleAccess.Binding _xblockexpression = null;
    {
      GuiceModuleAccess.BindKey _xifexpression = null;
      boolean _or = false;
      BindValue _value = it.getValue();
      String[] _statements = _value.getStatements();
      boolean _tripleEquals = (_statements == null);
      if (_tripleEquals) {
        _or = true;
      } else {
        BindValue _value_1 = it.getValue();
        String[] _statements_1 = _value_1.getStatements();
        boolean _isEmpty = ((List<String>)Conversions.doWrapArray(_statements_1)).isEmpty();
        _or = _isEmpty;
      }
      if (_or) {
        BindKey _key = it.getKey();
        String _type = _key.getType();
        TypeReference _typeRef = null;
        if (_type!=null) {
          _typeRef=TypeReference.typeRef(_type);
        }
        BindKey _key_1 = it.getKey();
        boolean _isSingleton = _key_1.isSingleton();
        BindKey _key_2 = it.getKey();
        boolean _isEagerSingleton = _key_2.isEagerSingleton();
        _xifexpression = new GuiceModuleAccess.BindKey(null, _typeRef, _isSingleton, _isEagerSingleton);
      } else {
        GuiceModuleAccess.BindKey _xblockexpression_1 = null;
        {
          BindKey _key_3 = it.getKey();
          String _type_1 = _key_3.getType();
          final int nameIndex = _type_1.lastIndexOf(".");
          BindKey _key_4 = it.getKey();
          String _type_2 = _key_4.getType();
          String _substring = _type_2.substring((nameIndex + 1));
          BindKey _key_5 = it.getKey();
          boolean _isSingleton_1 = _key_5.isSingleton();
          BindKey _key_6 = it.getKey();
          boolean _isEagerSingleton_1 = _key_6.isEagerSingleton();
          _xblockexpression_1 = new GuiceModuleAccess.BindKey(_substring, null, _isSingleton_1, _isEagerSingleton_1);
        }
        _xifexpression = _xblockexpression_1;
      }
      final GuiceModuleAccess.BindKey newKey = _xifexpression;
      BindValue _value_2 = it.getValue();
      String _expression = _value_2.getExpression();
      BindValue _value_3 = it.getValue();
      String _typeName = _value_3.getTypeName();
      TypeReference _typeRef_1 = null;
      if (_typeName!=null) {
        _typeRef_1=TypeReference.typeRef(_typeName);
      }
      BindValue _value_4 = it.getValue();
      boolean _isProvider = _value_4.isProvider();
      BindValue _value_5 = it.getValue();
      String[] _statements_2 = _value_5.getStatements();
      final Function1<String, Object> _function = new Function1<String, Object>() {
        @Override
        public Object apply(final String s) {
          String _xifexpression = null;
          boolean _endsWith = s.endsWith(";");
          if (_endsWith) {
            _xifexpression = s;
          } else {
            _xifexpression = (s + ";");
          }
          return _xifexpression;
        }
      };
      List<Object> _map = ListExtensions.<String, Object>map(((List<String>)Conversions.doWrapArray(_statements_2)), _function);
      final GuiceModuleAccess.BindValue newValue = new GuiceModuleAccess.BindValue(_expression, _typeRef_1, _isProvider, _map);
      boolean _isFinal = it.isFinal();
      String _contributedBy = it.getContributedBy();
      _xblockexpression = new GuiceModuleAccess.Binding(newKey, newValue, _isFinal, _contributedBy);
    }
    return _xblockexpression;
  }
  
  private void generatePluginXmlRt(final LanguageConfig config1, final XpandExecutionContext ctx) {
    PluginXmlAccess _runtimePluginXml = this.projectConfig.getRuntimePluginXml();
    boolean _tripleNotEquals = (_runtimePluginXml != null);
    if (_tripleNotEquals) {
      Output _output = ctx.getOutput();
      _output.openFile(null, StringConcatOutputImpl.STRING_OUTLET);
      try {
        if ((this.fragment instanceof IGeneratorFragmentExtension2)) {
          ((IGeneratorFragmentExtension2)this.fragment).addToPluginXmlRt(config1, ctx);
        } else {
          Grammar _grammar = config1.getGrammar();
          this.fragment.addToPluginXmlRt(_grammar, ctx);
        }
        Output _output_1 = ctx.getOutput();
        final StringConcatenation result = ((StringConcatOutputImpl) _output_1).getStringOutlet();
        PluginXmlAccess _runtimePluginXml_1 = this.projectConfig.getRuntimePluginXml();
        List<CharSequence> _entries = _runtimePluginXml_1.getEntries();
        String _string = result.toString();
        StringBuilder _decreaseIndentation = this.decreaseIndentation(_string, 1);
        _entries.add(_decreaseIndentation);
      } finally {
        Output _output_2 = ctx.getOutput();
        _output_2.closeFile();
      }
    }
  }
  
  private void generatePluginXmlUi(final LanguageConfig config1, final XpandExecutionContext ctx) {
    PluginXmlAccess _eclipsePluginPluginXml = this.projectConfig.getEclipsePluginPluginXml();
    boolean _tripleNotEquals = (_eclipsePluginPluginXml != null);
    if (_tripleNotEquals) {
      Output _output = ctx.getOutput();
      _output.openFile(null, StringConcatOutputImpl.STRING_OUTLET);
      try {
        if ((this.fragment instanceof IGeneratorFragmentExtension2)) {
          ((IGeneratorFragmentExtension2)this.fragment).addToPluginXmlUi(config1, ctx);
        } else {
          Grammar _grammar = config1.getGrammar();
          this.fragment.addToPluginXmlUi(_grammar, ctx);
        }
        Output _output_1 = ctx.getOutput();
        final StringConcatenation result = ((StringConcatOutputImpl) _output_1).getStringOutlet();
        PluginXmlAccess _eclipsePluginPluginXml_1 = this.projectConfig.getEclipsePluginPluginXml();
        List<CharSequence> _entries = _eclipsePluginPluginXml_1.getEntries();
        String _string = result.toString();
        StringBuilder _decreaseIndentation = this.decreaseIndentation(_string, 1);
        _entries.add(_decreaseIndentation);
      } finally {
        Output _output_2 = ctx.getOutput();
        _output_2.closeFile();
      }
    }
  }
  
  private void generateManifestRt(final LanguageConfig config1, final XpandExecutionContext ctx) {
    ManifestAccess _runtimeManifest = this.projectConfig.getRuntimeManifest();
    boolean _tripleNotEquals = (_runtimeManifest != null);
    if (_tripleNotEquals) {
      Grammar _grammar = config1.getGrammar();
      final String[] exported = this.fragment.getExportedPackagesRt(_grammar);
      if ((exported != null)) {
        ManifestAccess _runtimeManifest_1 = this.projectConfig.getRuntimeManifest();
        Set<String> _exportedPackages = _runtimeManifest_1.getExportedPackages();
        CollectionExtensions.<String>addAll(_exportedPackages, exported);
      }
      Grammar _grammar_1 = config1.getGrammar();
      final String[] required = this.fragment.getRequiredBundlesRt(_grammar_1);
      if ((required != null)) {
        ManifestAccess _runtimeManifest_2 = this.projectConfig.getRuntimeManifest();
        Set<String> _requiredBundles = _runtimeManifest_2.getRequiredBundles();
        CollectionExtensions.<String>addAll(_requiredBundles, required);
      }
      Grammar _grammar_2 = config1.getGrammar();
      final String[] imported = this.fragment.getImportedPackagesRt(_grammar_2);
      if ((imported != null)) {
        ManifestAccess _runtimeManifest_3 = this.projectConfig.getRuntimeManifest();
        Set<String> _importedPackages = _runtimeManifest_3.getImportedPackages();
        CollectionExtensions.<String>addAll(_importedPackages, imported);
      }
    }
  }
  
  private void generateManifestUi(final LanguageConfig config1, final XpandExecutionContext ctx) {
    ManifestAccess _eclipsePluginManifest = this.projectConfig.getEclipsePluginManifest();
    boolean _tripleNotEquals = (_eclipsePluginManifest != null);
    if (_tripleNotEquals) {
      Grammar _grammar = config1.getGrammar();
      final String[] exported = this.fragment.getExportedPackagesUi(_grammar);
      if ((exported != null)) {
        ManifestAccess _eclipsePluginManifest_1 = this.projectConfig.getEclipsePluginManifest();
        Set<String> _exportedPackages = _eclipsePluginManifest_1.getExportedPackages();
        CollectionExtensions.<String>addAll(_exportedPackages, exported);
      }
      Grammar _grammar_1 = config1.getGrammar();
      final String[] required = this.fragment.getRequiredBundlesUi(_grammar_1);
      if ((required != null)) {
        ManifestAccess _eclipsePluginManifest_2 = this.projectConfig.getEclipsePluginManifest();
        Set<String> _requiredBundles = _eclipsePluginManifest_2.getRequiredBundles();
        CollectionExtensions.<String>addAll(_requiredBundles, required);
      }
      Grammar _grammar_2 = config1.getGrammar();
      final String[] imported = this.fragment.getImportedPackagesUi(_grammar_2);
      if ((imported != null)) {
        ManifestAccess _eclipsePluginManifest_3 = this.projectConfig.getEclipsePluginManifest();
        Set<String> _importedPackages = _eclipsePluginManifest_3.getImportedPackages();
        CollectionExtensions.<String>addAll(_importedPackages, imported);
      }
    }
  }
  
  private void generateManifestIde(final LanguageConfig config1, final XpandExecutionContext ctx) {
    boolean _and = false;
    if (!(this.fragment instanceof IGeneratorFragmentExtension3)) {
      _and = false;
    } else {
      ManifestAccess _genericIdeManifest = this.projectConfig.getGenericIdeManifest();
      boolean _tripleNotEquals = (_genericIdeManifest != null);
      _and = _tripleNotEquals;
    }
    if (_and) {
      final IGeneratorFragmentExtension3 fr = ((IGeneratorFragmentExtension3) this.fragment);
      Grammar _grammar = config1.getGrammar();
      final String[] exported = fr.getExportedPackagesIde(_grammar);
      if ((exported != null)) {
        ManifestAccess _genericIdeManifest_1 = this.projectConfig.getGenericIdeManifest();
        Set<String> _exportedPackages = _genericIdeManifest_1.getExportedPackages();
        CollectionExtensions.<String>addAll(_exportedPackages, exported);
      }
      Grammar _grammar_1 = config1.getGrammar();
      final String[] required = fr.getRequiredBundlesIde(_grammar_1);
      if ((required != null)) {
        ManifestAccess _genericIdeManifest_2 = this.projectConfig.getGenericIdeManifest();
        Set<String> _requiredBundles = _genericIdeManifest_2.getRequiredBundles();
        CollectionExtensions.<String>addAll(_requiredBundles, required);
      }
      Grammar _grammar_2 = config1.getGrammar();
      final String[] imported = fr.getImportedPackagesIde(_grammar_2);
      if ((imported != null)) {
        ManifestAccess _genericIdeManifest_3 = this.projectConfig.getGenericIdeManifest();
        Set<String> _importedPackages = _genericIdeManifest_3.getImportedPackages();
        CollectionExtensions.<String>addAll(_importedPackages, imported);
      }
    }
  }
  
  private void generateManifestTests(final LanguageConfig config1, final XpandExecutionContext ctx) {
    boolean _and = false;
    if (!(this.fragment instanceof IGeneratorFragmentExtension)) {
      _and = false;
    } else {
      ManifestAccess _runtimeTestManifest = this.projectConfig.getRuntimeTestManifest();
      boolean _tripleNotEquals = (_runtimeTestManifest != null);
      _and = _tripleNotEquals;
    }
    if (_and) {
      final IGeneratorFragmentExtension fr = ((IGeneratorFragmentExtension) this.fragment);
      Grammar _grammar = config1.getGrammar();
      final String[] exported = fr.getExportedPackagesTests(_grammar);
      if ((exported != null)) {
        ManifestAccess _runtimeTestManifest_1 = this.projectConfig.getRuntimeTestManifest();
        Set<String> _exportedPackages = _runtimeTestManifest_1.getExportedPackages();
        CollectionExtensions.<String>addAll(_exportedPackages, exported);
      }
      Grammar _grammar_1 = config1.getGrammar();
      final String[] required = fr.getRequiredBundlesTests(_grammar_1);
      if ((required != null)) {
        ManifestAccess _runtimeTestManifest_2 = this.projectConfig.getRuntimeTestManifest();
        Set<String> _requiredBundles = _runtimeTestManifest_2.getRequiredBundles();
        CollectionExtensions.<String>addAll(_requiredBundles, required);
      }
      Grammar _grammar_2 = config1.getGrammar();
      final String[] imported = fr.getImportedPackagesTests(_grammar_2);
      if ((imported != null)) {
        ManifestAccess _runtimeTestManifest_3 = this.projectConfig.getRuntimeTestManifest();
        Set<String> _importedPackages = _runtimeTestManifest_3.getImportedPackages();
        CollectionExtensions.<String>addAll(_importedPackages, imported);
      }
    }
  }
  
  protected Naming createNaming(final LanguageConfig2 config2) {
    Naming _naming = new Naming();
    final Procedure1<Naming> _function = new Procedure1<Naming>() {
      @Override
      public void apply(final Naming it) {
        ManifestAccess _runtimeManifest = FragmentAdapter.this.projectConfig.getRuntimeManifest();
        String _pluginPath = null;
        if (_runtimeManifest!=null) {
          _pluginPath=FragmentAdapter.this.getPluginPath(_runtimeManifest);
        }
        String _lastSegment = FragmentAdapter.this.getLastSegment(_pluginPath);
        it.setProjectNameRt(_lastSegment);
        ManifestAccess _genericIdeManifest = FragmentAdapter.this.projectConfig.getGenericIdeManifest();
        String _pluginPath_1 = null;
        if (_genericIdeManifest!=null) {
          _pluginPath_1=FragmentAdapter.this.getPluginPath(_genericIdeManifest);
        }
        String _lastSegment_1 = FragmentAdapter.this.getLastSegment(_pluginPath_1);
        it.setProjectNameIde(_lastSegment_1);
        ManifestAccess _eclipsePluginManifest = FragmentAdapter.this.projectConfig.getEclipsePluginManifest();
        String _pluginPath_2 = null;
        if (_eclipsePluginManifest!=null) {
          _pluginPath_2=FragmentAdapter.this.getPluginPath(_eclipsePluginManifest);
        }
        String _lastSegment_2 = FragmentAdapter.this.getLastSegment(_pluginPath_2);
        it.setProjectNameUi(_lastSegment_2);
        XtextGeneratorNaming _naming = config2.getNaming();
        String _genericIdeBasePackage = _naming.getGenericIdeBasePackage();
        it.setIdeBasePackage(_genericIdeBasePackage);
        XtextGeneratorNaming _naming_1 = config2.getNaming();
        String _eclipsePluginBasePackage = _naming_1.getEclipsePluginBasePackage();
        it.setUiBasePackage(_eclipsePluginBasePackage);
        XtextGeneratorNaming _naming_2 = config2.getNaming();
        TypeReference _eclipsePluginActivator = _naming_2.getEclipsePluginActivator();
        String _name = _eclipsePluginActivator.getName();
        it.setActivatorName(_name);
        ManifestAccess _runtimeTestManifest = FragmentAdapter.this.projectConfig.getRuntimeTestManifest();
        String _pluginPath_3 = null;
        if (_runtimeTestManifest!=null) {
          _pluginPath_3=FragmentAdapter.this.getPluginPath(_runtimeTestManifest);
        }
        it.setPathTestProject(_pluginPath_3);
        String _lineDelimiter = FragmentAdapter.this.codeConfig.getLineDelimiter();
        it.setLineDelimiter(_lineDelimiter);
        String _fileHeader = FragmentAdapter.this.codeConfig.getFileHeader();
        it.setFileHeader(_fileHeader);
        String _classAnnotationsAsString = FragmentAdapter.this.codeConfig.getClassAnnotationsAsString();
        it.setClassAnnotations(_classAnnotationsAsString);
        String _annotationImportsAsString = FragmentAdapter.this.codeConfig.getAnnotationImportsAsString();
        it.setAnnotationImports(_annotationImportsAsString);
        String _projectNameUi = it.getProjectNameUi();
        boolean _tripleNotEquals = (_projectNameUi != null);
        it.setHasUI(_tripleNotEquals);
        String _projectNameIde = it.getProjectNameIde();
        boolean _tripleNotEquals_1 = (_projectNameIde != null);
        it.setHasIde(_tripleNotEquals_1);
        Grammar _grammar = config2.getGrammar();
        String _name_1 = _grammar.getName();
        it.setGrammarId(_name_1);
      }
    };
    final Naming result = ObjectExtensions.<Naming>operator_doubleArrow(_naming, _function);
    if ((this.fragment instanceof NamingAware)) {
      ((NamingAware)this.fragment).registerNaming(result);
    }
    return result;
  }
  
  protected LanguageConfig createLanguageConfig(final LanguageConfig2 config2) {
    final LanguageConfig config = new LanguageConfig();
    List<String> _loadedResources = config2.getLoadedResources();
    for (final String resource : _loadedResources) {
      config.addLoadedResource(resource);
    }
    ResourceSet _resourceSet = config2.getResourceSet();
    config.setForcedResourceSet(_resourceSet);
    List<String> _fileExtensions = config2.getFileExtensions();
    String _join = IterableExtensions.join(_fileExtensions, ",");
    config.setFileExtensions(_join);
    String _uri = config2.getUri();
    config.setUri(_uri);
    config.registerNaming(this.naming);
    return config;
  }
  
  protected XpandExecutionContext createExecutionContext() {
    final String encoding = this.encodingProvider.getEncoding(null);
    final StringConcatOutputImpl output = new StringConcatOutputImpl();
    ManifestAccess _runtimeManifest = this.projectConfig.getRuntimeManifest();
    boolean _tripleNotEquals = (_runtimeManifest != null);
    if (_tripleNotEquals) {
      ManifestAccess _runtimeManifest_1 = this.projectConfig.getRuntimeManifest();
      String _pluginPath = this.getPluginPath(_runtimeManifest_1);
      Outlet _createOutlet = this.createOutlet(false, encoding, Generator.PLUGIN_RT, false, _pluginPath);
      output.addOutlet(_createOutlet);
    }
    IFileSystemAccess2 _runtimeSrc = this.projectConfig.getRuntimeSrc();
    boolean _tripleNotEquals_1 = (_runtimeSrc != null);
    if (_tripleNotEquals_1) {
      IFileSystemAccess2 _runtimeSrc_1 = this.projectConfig.getRuntimeSrc();
      String _path = this.getPath(_runtimeSrc_1);
      Outlet _createOutlet_1 = this.createOutlet(false, encoding, Generator.SRC, false, _path);
      output.addOutlet(_createOutlet_1);
    }
    IFileSystemAccess2 _runtimeSrcGen = this.projectConfig.getRuntimeSrcGen();
    boolean _tripleNotEquals_2 = (_runtimeSrcGen != null);
    if (_tripleNotEquals_2) {
      IFileSystemAccess2 _runtimeSrcGen_1 = this.projectConfig.getRuntimeSrcGen();
      String _path_1 = this.getPath(_runtimeSrcGen_1);
      Outlet _createOutlet_2 = this.createOutlet(false, encoding, Generator.SRC_GEN, true, _path_1);
      output.addOutlet(_createOutlet_2);
    }
    ManifestAccess _runtimeManifest_2 = this.projectConfig.getRuntimeManifest();
    boolean _tripleNotEquals_3 = (_runtimeManifest_2 != null);
    if (_tripleNotEquals_3) {
      ManifestAccess _runtimeManifest_3 = this.projectConfig.getRuntimeManifest();
      String _pluginPath_1 = this.getPluginPath(_runtimeManifest_3);
      String _plus = (_pluginPath_1 + "/model");
      Outlet _createOutlet_3 = this.createOutlet(false, encoding, Generator.MODEL, false, _plus);
      output.addOutlet(_createOutlet_3);
    }
    ManifestAccess _eclipsePluginManifest = this.projectConfig.getEclipsePluginManifest();
    boolean _tripleNotEquals_4 = (_eclipsePluginManifest != null);
    if (_tripleNotEquals_4) {
      ManifestAccess _eclipsePluginManifest_1 = this.projectConfig.getEclipsePluginManifest();
      String _pluginPath_2 = this.getPluginPath(_eclipsePluginManifest_1);
      Outlet _createOutlet_4 = this.createOutlet(false, encoding, Generator.PLUGIN_UI, false, _pluginPath_2);
      output.addOutlet(_createOutlet_4);
    }
    IFileSystemAccess2 _eclipsePluginSrc = this.projectConfig.getEclipsePluginSrc();
    boolean _tripleNotEquals_5 = (_eclipsePluginSrc != null);
    if (_tripleNotEquals_5) {
      IFileSystemAccess2 _eclipsePluginSrc_1 = this.projectConfig.getEclipsePluginSrc();
      String _path_2 = this.getPath(_eclipsePluginSrc_1);
      Outlet _createOutlet_5 = this.createOutlet(false, encoding, Generator.SRC_UI, false, _path_2);
      output.addOutlet(_createOutlet_5);
    }
    IFileSystemAccess2 _eclipsePluginSrcGen = this.projectConfig.getEclipsePluginSrcGen();
    boolean _tripleNotEquals_6 = (_eclipsePluginSrcGen != null);
    if (_tripleNotEquals_6) {
      IFileSystemAccess2 _eclipsePluginSrcGen_1 = this.projectConfig.getEclipsePluginSrcGen();
      String _path_3 = this.getPath(_eclipsePluginSrcGen_1);
      Outlet _createOutlet_6 = this.createOutlet(false, encoding, Generator.SRC_GEN_UI, true, _path_3);
      output.addOutlet(_createOutlet_6);
    }
    ManifestAccess _genericIdeManifest = this.projectConfig.getGenericIdeManifest();
    boolean _tripleNotEquals_7 = (_genericIdeManifest != null);
    if (_tripleNotEquals_7) {
      ManifestAccess _genericIdeManifest_1 = this.projectConfig.getGenericIdeManifest();
      String _pluginPath_3 = this.getPluginPath(_genericIdeManifest_1);
      Outlet _createOutlet_7 = this.createOutlet(false, encoding, Generator.PLUGIN_IDE, false, _pluginPath_3);
      output.addOutlet(_createOutlet_7);
    }
    IFileSystemAccess2 _genericIdeSrc = this.projectConfig.getGenericIdeSrc();
    boolean _tripleNotEquals_8 = (_genericIdeSrc != null);
    if (_tripleNotEquals_8) {
      IFileSystemAccess2 _genericIdeSrc_1 = this.projectConfig.getGenericIdeSrc();
      String _path_4 = this.getPath(_genericIdeSrc_1);
      Outlet _createOutlet_8 = this.createOutlet(false, encoding, Generator.SRC_IDE, false, _path_4);
      output.addOutlet(_createOutlet_8);
    }
    IFileSystemAccess2 _genericIdeSrcGen = this.projectConfig.getGenericIdeSrcGen();
    boolean _tripleNotEquals_9 = (_genericIdeSrcGen != null);
    if (_tripleNotEquals_9) {
      IFileSystemAccess2 _genericIdeSrcGen_1 = this.projectConfig.getGenericIdeSrcGen();
      String _path_5 = this.getPath(_genericIdeSrcGen_1);
      Outlet _createOutlet_9 = this.createOutlet(false, encoding, Generator.SRC_GEN_IDE, true, _path_5);
      output.addOutlet(_createOutlet_9);
    }
    ManifestAccess _runtimeTestManifest = this.projectConfig.getRuntimeTestManifest();
    boolean _tripleNotEquals_10 = (_runtimeTestManifest != null);
    if (_tripleNotEquals_10) {
      ManifestAccess _runtimeTestManifest_1 = this.projectConfig.getRuntimeTestManifest();
      String _pluginPath_4 = this.getPluginPath(_runtimeTestManifest_1);
      Outlet _createOutlet_10 = this.createOutlet(false, encoding, Generator.PLUGIN_TEST, false, _pluginPath_4);
      output.addOutlet(_createOutlet_10);
    }
    IFileSystemAccess2 _runtimeTestSrc = this.projectConfig.getRuntimeTestSrc();
    boolean _tripleNotEquals_11 = (_runtimeTestSrc != null);
    if (_tripleNotEquals_11) {
      IFileSystemAccess2 _runtimeTestSrc_1 = this.projectConfig.getRuntimeTestSrc();
      String _path_6 = this.getPath(_runtimeTestSrc_1);
      Outlet _createOutlet_11 = this.createOutlet(false, encoding, Generator.SRC_TEST, false, _path_6);
      output.addOutlet(_createOutlet_11);
    }
    IFileSystemAccess2 _runtimeTestSrcGen = this.projectConfig.getRuntimeTestSrcGen();
    boolean _tripleNotEquals_12 = (_runtimeTestSrcGen != null);
    if (_tripleNotEquals_12) {
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
    String _projectNameRt = this.naming.getProjectNameRt();
    Variable _variable_1 = new Variable("modelPluginID", _projectNameRt);
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
  
  protected String getPath(final IFileSystemAccess2 fsa) {
    URI _uRI = fsa.getURI("");
    final String path = _uRI.toFileString();
    boolean _endsWith = path.endsWith(File.separator);
    if (_endsWith) {
      int _length = path.length();
      int _minus = (_length - 1);
      return path.substring(0, _minus);
    } else {
      return path;
    }
  }
  
  protected String getPluginPath(final ManifestAccess manifest) {
    String _path = manifest.getPath();
    final int metaInfIndex = _path.indexOf("/META-INF");
    String _path_1 = manifest.getPath();
    return _path_1.substring(0, metaInfIndex);
  }
  
  private String getLastSegment(final String path) {
    String _substring = null;
    if (path!=null) {
      int _lastIndexOf = path.lastIndexOf("/");
      int _plus = (_lastIndexOf + 1);
      _substring=path.substring(_plus);
    }
    return _substring;
  }
  
  private StringBuilder decreaseIndentation(final String text, final int level) {
    int _length = text.length();
    final StringBuilder result = new StringBuilder(_length);
    boolean newLine = true;
    int skippedSpaces = 0;
    int skippedTabs = 0;
    for (int i = 0; (i < text.length()); i++) {
      {
        final char c = text.charAt(i);
        boolean append = false;
        boolean _matches = this.matches(c, '\n', '\r');
        if (_matches) {
          newLine = true;
          append = true;
          skippedTabs = 0;
          skippedSpaces = 0;
        } else {
          if (newLine) {
            boolean _matches_1 = this.matches(c, ' ');
            if (_matches_1) {
              skippedSpaces++;
              if ((skippedSpaces >= 4)) {
                skippedSpaces = 0;
                skippedTabs++;
              }
            } else {
              boolean _matches_2 = this.matches(c, '\t');
              if (_matches_2) {
                skippedSpaces = 0;
                skippedTabs++;
              } else {
                newLine = false;
                append = true;
              }
            }
            if ((skippedTabs >= level)) {
              newLine = false;
            }
          } else {
            append = true;
          }
        }
        if (append) {
          result.append(c);
        }
      }
    }
    return result;
  }
  
  private boolean matches(final char c, final char... m) {
    for (int i = 0; (i < m.length); i++) {
      char _get = m[i];
      boolean _equals = (c == _get);
      if (_equals) {
        return true;
      }
    }
    return false;
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
