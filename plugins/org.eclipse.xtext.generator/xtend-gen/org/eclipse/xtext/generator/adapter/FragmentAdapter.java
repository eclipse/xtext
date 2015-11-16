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
import java.io.File;
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
import org.eclipse.xtend2.lib.StringConcatenationClient;
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
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.MweIssues;
import org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.StandaloneSetupAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;

/**
 * @since 2.9
 */
@SuppressWarnings("all")
public class FragmentAdapter extends AbstractXtextGeneratorFragment {
  @Inject
  private CodeConfig codeConfig;
  
  @Inject
  private IEncodingProvider encodingProvider;
  
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Accessors
  private IGeneratorFragment fragment;
  
  @Accessors
  private Naming naming;
  
  private final List<PostProcessor> postProcessors = CollectionLiterals.<PostProcessor>newArrayList();
  
  public FragmentAdapter() {
  }
  
  public FragmentAdapter(final IGeneratorFragment fragment) {
    this.setFragment(fragment);
  }
  
  public void addPostProcessor(final PostProcessor postProcessor) {
    this.postProcessors.add(postProcessor);
  }
  
  @Override
  public void checkConfiguration(final Issues issues) {
    if ((this.naming == null)) {
      Naming _createNaming = this.createNaming();
      this.naming = _createNaming;
    }
    if ((this.fragment == null)) {
      issues.addError("The property \'fragment\' must be set.", this);
    } else {
      org.eclipse.emf.mwe.core.issues.Issues _delegate = ((MweIssues) issues).getDelegate();
      this.fragment.checkConfiguration(_delegate);
    }
  }
  
  @Override
  public void generate() {
    if ((this.naming == null)) {
      Naming _createNaming = this.createNaming();
      this.naming = _createNaming;
    }
    final XpandExecutionContext ctx = this.createExecutionContext();
    final LanguageConfig config1 = this.createLanguageConfig();
    if ((this.fragment instanceof IGeneratorFragmentExtension2)) {
      ((IGeneratorFragmentExtension2)this.fragment).generate(config1, ctx);
    } else {
      Grammar _grammar = config1.getGrammar();
      this.fragment.generate(_grammar, ctx);
    }
    this.generateStandaloneSetup(config1, ctx);
    this.generateGuiceModuleRt(config1, ctx);
    this.generateGuiceModuleUi(config1, ctx);
    this.generatePluginXmlRt(config1, ctx);
    this.generateManifestRt(config1, ctx);
    this.generatePluginXmlUi(config1, ctx);
    this.generateManifestUi(config1, ctx);
    this.generateManifestIde(config1, ctx);
    this.generateManifestTests(config1, ctx);
  }
  
  private void generateStandaloneSetup(final LanguageConfig config1, final XpandExecutionContext ctx) {
    Output _output = ctx.getOutput();
    _output.openFile(null, StringConcatOutputImpl.STRING_OUTLET);
    try {
      final IXtextGeneratorLanguage config2 = this.getLanguage();
      if ((this.fragment instanceof IGeneratorFragmentExtension2)) {
        ((IGeneratorFragmentExtension2)this.fragment).addToStandaloneSetup(config1, ctx);
      } else {
        Grammar _grammar = config1.getGrammar();
        this.fragment.addToStandaloneSetup(_grammar, ctx);
      }
      Output _output_1 = ctx.getOutput();
      final StringConcatenation result = ((StringConcatOutputImpl) _output_1).getStringOutlet();
      StandaloneSetupAccess _runtimeGenSetup = config2.getRuntimeGenSetup();
      List<StringConcatenationClient> _registrations = _runtimeGenSetup.getRegistrations();
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          String _string = result.toString();
          StringBuilder _decreaseIndentation = FragmentAdapter.this.decreaseIndentation(_string, 2);
          _builder.append(_decreaseIndentation, "");
        }
      };
      _registrations.add(_client);
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
  
  private void generateGuiceModuleRt(final LanguageConfig config1, final XpandExecutionContext ctx) {
    final IXtextGeneratorLanguage config2 = this.getLanguage();
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
  
  private void generateGuiceModuleUi(final LanguageConfig config1, final XpandExecutionContext ctx) {
    final IXtextGeneratorLanguage config2 = this.getLanguage();
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
        TypeReference _guessTypeRef = null;
        if (_type!=null) {
          _guessTypeRef=TypeReference.guessTypeRef(_type);
        }
        BindKey _key_1 = it.getKey();
        boolean _isSingleton = _key_1.isSingleton();
        BindKey _key_2 = it.getKey();
        boolean _isEagerSingleton = _key_2.isEagerSingleton();
        _xifexpression = new GuiceModuleAccess.BindKey(null, _guessTypeRef, _isSingleton, _isEagerSingleton);
      } else {
        BindKey _key_3 = it.getKey();
        String _type_1 = _key_3.getType();
        String _className = this.getClassName(_type_1);
        BindKey _key_4 = it.getKey();
        boolean _isSingleton_1 = _key_4.isSingleton();
        BindKey _key_5 = it.getKey();
        boolean _isEagerSingleton_1 = _key_5.isEagerSingleton();
        _xifexpression = new GuiceModuleAccess.BindKey(_className, null, _isSingleton_1, _isEagerSingleton_1);
      }
      final GuiceModuleAccess.BindKey newKey = _xifexpression;
      BindValue _value_2 = it.getValue();
      String _expression = _value_2.getExpression();
      BindValue _value_3 = it.getValue();
      String _typeName = _value_3.getTypeName();
      TypeReference _guessTypeRef_1 = null;
      if (_typeName!=null) {
        _guessTypeRef_1=TypeReference.guessTypeRef(_typeName);
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
      final GuiceModuleAccess.BindValue newValue = new GuiceModuleAccess.BindValue(_expression, _guessTypeRef_1, _isProvider, _map);
      boolean _isFinal = it.isFinal();
      String _contributedBy = it.getContributedBy();
      _xblockexpression = new GuiceModuleAccess.Binding(newKey, newValue, _isFinal, _contributedBy);
    }
    return _xblockexpression;
  }
  
  private String getClassName(final String qualifiedName) {
    int classStart = qualifiedName.length();
    for (int i = (qualifiedName.length() - 1); (i >= 0); i--) {
      char _charAt = qualifiedName.charAt(i);
      boolean _matches = this.matches(_charAt, '.');
      if (_matches) {
        char _charAt_1 = qualifiedName.charAt((i + 1));
        boolean _isLowerCase = Character.isLowerCase(_charAt_1);
        if (_isLowerCase) {
          return qualifiedName.substring(classStart);
        } else {
          classStart = (i + 1);
        }
      }
    }
    return qualifiedName;
  }
  
  private void generatePluginXmlRt(final LanguageConfig config1, final XpandExecutionContext ctx) {
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    PluginXmlAccess _pluginXml = _runtime.getPluginXml();
    boolean _tripleNotEquals = (_pluginXml != null);
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
        String _string = result.toString();
        final StringBuilder entry = this.decreaseIndentation(_string, 1);
        String _string_1 = entry.toString();
        String _trim = _string_1.trim();
        boolean _isEmpty = _trim.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
          IRuntimeProjectConfig _runtime_1 = _projectConfig_1.getRuntime();
          PluginXmlAccess _pluginXml_1 = _runtime_1.getPluginXml();
          List<CharSequence> _entries = _pluginXml_1.getEntries();
          _entries.add(entry);
        }
      } finally {
        Output _output_2 = ctx.getOutput();
        _output_2.closeFile();
      }
    }
  }
  
  private void generatePluginXmlUi(final LanguageConfig config1, final XpandExecutionContext ctx) {
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    PluginXmlAccess _pluginXml = _eclipsePlugin.getPluginXml();
    boolean _tripleNotEquals = (_pluginXml != null);
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
        String _string = result.toString();
        final StringBuilder entry = this.decreaseIndentation(_string, 1);
        String _string_1 = entry.toString();
        String _trim = _string_1.trim();
        boolean _isEmpty = _trim.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
          IBundleProjectConfig _eclipsePlugin_1 = _projectConfig_1.getEclipsePlugin();
          PluginXmlAccess _pluginXml_1 = _eclipsePlugin_1.getPluginXml();
          List<CharSequence> _entries = _pluginXml_1.getEntries();
          _entries.add(entry);
        }
      } finally {
        Output _output_2 = ctx.getOutput();
        _output_2.closeFile();
      }
    }
  }
  
  private void generateManifestRt(final LanguageConfig config1, final XpandExecutionContext ctx) {
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    ManifestAccess _manifest = _runtime.getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      Grammar _grammar = config1.getGrammar();
      final String[] exported = this.fragment.getExportedPackagesRt(_grammar);
      if ((exported != null)) {
        IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_1 = _projectConfig_1.getRuntime();
        ManifestAccess _manifest_1 = _runtime_1.getManifest();
        Set<String> _exportedPackages = _manifest_1.getExportedPackages();
        CollectionExtensions.<String>addAll(_exportedPackages, exported);
      }
      Grammar _grammar_1 = config1.getGrammar();
      final String[] required = this.fragment.getRequiredBundlesRt(_grammar_1);
      if ((required != null)) {
        IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_2 = _projectConfig_2.getRuntime();
        ManifestAccess _manifest_2 = _runtime_2.getManifest();
        Set<String> _requiredBundles = _manifest_2.getRequiredBundles();
        CollectionExtensions.<String>addAll(_requiredBundles, required);
      }
      Grammar _grammar_2 = config1.getGrammar();
      final String[] imported = this.fragment.getImportedPackagesRt(_grammar_2);
      if ((imported != null)) {
        IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_3 = _projectConfig_3.getRuntime();
        ManifestAccess _manifest_3 = _runtime_3.getManifest();
        Set<String> _importedPackages = _manifest_3.getImportedPackages();
        CollectionExtensions.<String>addAll(_importedPackages, imported);
      }
    }
  }
  
  private void generateManifestUi(final LanguageConfig config1, final XpandExecutionContext ctx) {
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig.getEclipsePlugin();
    ManifestAccess _manifest = _eclipsePlugin.getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      Grammar _grammar = config1.getGrammar();
      final String[] exported = this.fragment.getExportedPackagesUi(_grammar);
      if ((exported != null)) {
        IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
        IBundleProjectConfig _eclipsePlugin_1 = _projectConfig_1.getEclipsePlugin();
        ManifestAccess _manifest_1 = _eclipsePlugin_1.getManifest();
        Set<String> _exportedPackages = _manifest_1.getExportedPackages();
        CollectionExtensions.<String>addAll(_exportedPackages, exported);
      }
      Grammar _grammar_1 = config1.getGrammar();
      final String[] required = this.fragment.getRequiredBundlesUi(_grammar_1);
      if ((required != null)) {
        IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
        IBundleProjectConfig _eclipsePlugin_2 = _projectConfig_2.getEclipsePlugin();
        ManifestAccess _manifest_2 = _eclipsePlugin_2.getManifest();
        Set<String> _requiredBundles = _manifest_2.getRequiredBundles();
        CollectionExtensions.<String>addAll(_requiredBundles, required);
      }
      Grammar _grammar_2 = config1.getGrammar();
      final String[] imported = this.fragment.getImportedPackagesUi(_grammar_2);
      if ((imported != null)) {
        IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
        IBundleProjectConfig _eclipsePlugin_3 = _projectConfig_3.getEclipsePlugin();
        ManifestAccess _manifest_3 = _eclipsePlugin_3.getManifest();
        Set<String> _importedPackages = _manifest_3.getImportedPackages();
        CollectionExtensions.<String>addAll(_importedPackages, imported);
      }
    }
  }
  
  private void generateManifestIde(final LanguageConfig config1, final XpandExecutionContext ctx) {
    boolean _and = false;
    if (!(this.fragment instanceof IGeneratorFragmentExtension3)) {
      _and = false;
    } else {
      IXtextProjectConfig _projectConfig = this.getProjectConfig();
      IBundleProjectConfig _genericIde = _projectConfig.getGenericIde();
      ManifestAccess _manifest = _genericIde.getManifest();
      boolean _tripleNotEquals = (_manifest != null);
      _and = _tripleNotEquals;
    }
    if (_and) {
      final IGeneratorFragmentExtension3 fr = ((IGeneratorFragmentExtension3) this.fragment);
      Grammar _grammar = config1.getGrammar();
      final String[] exported = fr.getExportedPackagesIde(_grammar);
      if ((exported != null)) {
        IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
        IBundleProjectConfig _genericIde_1 = _projectConfig_1.getGenericIde();
        ManifestAccess _manifest_1 = _genericIde_1.getManifest();
        Set<String> _exportedPackages = _manifest_1.getExportedPackages();
        CollectionExtensions.<String>addAll(_exportedPackages, exported);
      }
      Grammar _grammar_1 = config1.getGrammar();
      final String[] required = fr.getRequiredBundlesIde(_grammar_1);
      if ((required != null)) {
        IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
        IBundleProjectConfig _genericIde_2 = _projectConfig_2.getGenericIde();
        ManifestAccess _manifest_2 = _genericIde_2.getManifest();
        Set<String> _requiredBundles = _manifest_2.getRequiredBundles();
        CollectionExtensions.<String>addAll(_requiredBundles, required);
      }
      Grammar _grammar_2 = config1.getGrammar();
      final String[] imported = fr.getImportedPackagesIde(_grammar_2);
      if ((imported != null)) {
        IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
        IBundleProjectConfig _genericIde_3 = _projectConfig_3.getGenericIde();
        ManifestAccess _manifest_3 = _genericIde_3.getManifest();
        Set<String> _importedPackages = _manifest_3.getImportedPackages();
        CollectionExtensions.<String>addAll(_importedPackages, imported);
      }
    }
  }
  
  private void generateManifestTests(final LanguageConfig config1, final XpandExecutionContext ctx) {
    boolean _and = false;
    if (!(this.fragment instanceof IGeneratorFragmentExtension)) {
      _and = false;
    } else {
      IXtextProjectConfig _projectConfig = this.getProjectConfig();
      IBundleProjectConfig _runtimeTest = _projectConfig.getRuntimeTest();
      ManifestAccess _manifest = _runtimeTest.getManifest();
      boolean _tripleNotEquals = (_manifest != null);
      _and = _tripleNotEquals;
    }
    if (_and) {
      final IGeneratorFragmentExtension fr = ((IGeneratorFragmentExtension) this.fragment);
      Grammar _grammar = config1.getGrammar();
      final String[] exported = fr.getExportedPackagesTests(_grammar);
      if ((exported != null)) {
        IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
        IBundleProjectConfig _runtimeTest_1 = _projectConfig_1.getRuntimeTest();
        ManifestAccess _manifest_1 = _runtimeTest_1.getManifest();
        Set<String> _exportedPackages = _manifest_1.getExportedPackages();
        CollectionExtensions.<String>addAll(_exportedPackages, exported);
      }
      Grammar _grammar_1 = config1.getGrammar();
      final String[] required = fr.getRequiredBundlesTests(_grammar_1);
      if ((required != null)) {
        IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
        IBundleProjectConfig _runtimeTest_2 = _projectConfig_2.getRuntimeTest();
        ManifestAccess _manifest_2 = _runtimeTest_2.getManifest();
        Set<String> _requiredBundles = _manifest_2.getRequiredBundles();
        CollectionExtensions.<String>addAll(_requiredBundles, required);
      }
      Grammar _grammar_2 = config1.getGrammar();
      final String[] imported = fr.getImportedPackagesTests(_grammar_2);
      if ((imported != null)) {
        IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
        IBundleProjectConfig _runtimeTest_3 = _projectConfig_3.getRuntimeTest();
        ManifestAccess _manifest_3 = _runtimeTest_3.getManifest();
        Set<String> _importedPackages = _manifest_3.getImportedPackages();
        CollectionExtensions.<String>addAll(_importedPackages, imported);
      }
    }
  }
  
  protected Naming createNaming() {
    final IXtextGeneratorLanguage config2 = this.getLanguage();
    Naming _naming = new Naming();
    final Procedure1<Naming> _function = new Procedure1<Naming>() {
      @Override
      public void apply(final Naming it) {
        IXtextProjectConfig _projectConfig = FragmentAdapter.this.getProjectConfig();
        IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
        IXtextGeneratorFileSystemAccess _root = _runtime.getRoot();
        String _path = null;
        if (_root!=null) {
          _path=_root.getPath();
        }
        String _lastSegment = FragmentAdapter.this.getLastSegment(_path);
        it.setProjectNameRt(_lastSegment);
        IXtextProjectConfig _projectConfig_1 = FragmentAdapter.this.getProjectConfig();
        IBundleProjectConfig _genericIde = _projectConfig_1.getGenericIde();
        IXtextGeneratorFileSystemAccess _root_1 = _genericIde.getRoot();
        String _path_1 = null;
        if (_root_1!=null) {
          _path_1=_root_1.getPath();
        }
        String _lastSegment_1 = FragmentAdapter.this.getLastSegment(_path_1);
        it.setProjectNameIde(_lastSegment_1);
        IXtextProjectConfig _projectConfig_2 = FragmentAdapter.this.getProjectConfig();
        IBundleProjectConfig _eclipsePlugin = _projectConfig_2.getEclipsePlugin();
        IXtextGeneratorFileSystemAccess _root_2 = _eclipsePlugin.getRoot();
        String _path_2 = null;
        if (_root_2!=null) {
          _path_2=_root_2.getPath();
        }
        String _lastSegment_2 = FragmentAdapter.this.getLastSegment(_path_2);
        it.setProjectNameUi(_lastSegment_2);
        Grammar _grammar = config2.getGrammar();
        String _genericIdeBasePackage = FragmentAdapter.this._xtextGeneratorNaming.getGenericIdeBasePackage(_grammar);
        it.setIdeBasePackage(_genericIdeBasePackage);
        Grammar _grammar_1 = config2.getGrammar();
        String _eclipsePluginBasePackage = FragmentAdapter.this._xtextGeneratorNaming.getEclipsePluginBasePackage(_grammar_1);
        it.setUiBasePackage(_eclipsePluginBasePackage);
        TypeReference _eclipsePluginActivator = FragmentAdapter.this._xtextGeneratorNaming.getEclipsePluginActivator();
        String _name = null;
        if (_eclipsePluginActivator!=null) {
          _name=_eclipsePluginActivator.getName();
        }
        it.setActivatorName(_name);
        IXtextProjectConfig _projectConfig_3 = FragmentAdapter.this.getProjectConfig();
        IBundleProjectConfig _runtimeTest = _projectConfig_3.getRuntimeTest();
        IXtextGeneratorFileSystemAccess _root_3 = _runtimeTest.getRoot();
        String _path_3 = null;
        if (_root_3!=null) {
          _path_3=_root_3.getPath();
        }
        it.setPathTestProject(_path_3);
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
        Grammar _grammar_2 = config2.getGrammar();
        String _name_1 = _grammar_2.getName();
        it.setGrammarId(_name_1);
      }
    };
    final Naming result = ObjectExtensions.<Naming>operator_doubleArrow(_naming, _function);
    if ((this.fragment instanceof NamingAware)) {
      ((NamingAware)this.fragment).registerNaming(result);
    }
    return result;
  }
  
  protected LanguageConfig createLanguageConfig() {
    IXtextGeneratorLanguage _language = this.getLanguage();
    final XtextGeneratorLanguage config2 = ((XtextGeneratorLanguage) _language);
    final LanguageConfig config = new LanguageConfig();
    ResourceSet _resourceSet = config2.getResourceSet();
    config.setForcedResourceSet(_resourceSet);
    List<String> _fileExtensions = config2.getFileExtensions();
    String _join = IterableExtensions.join(_fileExtensions, ",");
    config.setFileExtensions(_join);
    String _grammarUri = config2.getGrammarUri();
    config.setUri(_grammarUri);
    config.registerNaming(this.naming);
    return config;
  }
  
  protected XpandExecutionContext createExecutionContext() {
    final String encoding = this.encodingProvider.getEncoding(null);
    final StringConcatOutputImpl output = new StringConcatOutputImpl();
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _root = _runtime.getRoot();
    boolean _tripleNotEquals = (_root != null);
    if (_tripleNotEquals) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_1 = _projectConfig_1.getRuntime();
      IXtextGeneratorFileSystemAccess _root_1 = _runtime_1.getRoot();
      String _path = _root_1.getPath();
      Outlet _createOutlet = this.createOutlet(false, encoding, Generator.PLUGIN_RT, false, _path);
      output.addOutlet(_createOutlet);
    }
    IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
    IRuntimeProjectConfig _runtime_2 = _projectConfig_2.getRuntime();
    IXtextGeneratorFileSystemAccess _src = _runtime_2.getSrc();
    boolean _tripleNotEquals_1 = (_src != null);
    if (_tripleNotEquals_1) {
      IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_3 = _projectConfig_3.getRuntime();
      IXtextGeneratorFileSystemAccess _src_1 = _runtime_3.getSrc();
      String _path_1 = _src_1.getPath();
      Outlet _createOutlet_1 = this.createOutlet(false, encoding, Generator.SRC, false, _path_1);
      output.addOutlet(_createOutlet_1);
    }
    IXtextProjectConfig _projectConfig_4 = this.getProjectConfig();
    IRuntimeProjectConfig _runtime_4 = _projectConfig_4.getRuntime();
    IXtextGeneratorFileSystemAccess _srcGen = _runtime_4.getSrcGen();
    boolean _tripleNotEquals_2 = (_srcGen != null);
    if (_tripleNotEquals_2) {
      IXtextProjectConfig _projectConfig_5 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_5 = _projectConfig_5.getRuntime();
      IXtextGeneratorFileSystemAccess _srcGen_1 = _runtime_5.getSrcGen();
      String _path_2 = _srcGen_1.getPath();
      Outlet _createOutlet_2 = this.createOutlet(false, encoding, Generator.SRC_GEN, true, _path_2);
      output.addOutlet(_createOutlet_2);
    }
    IXtextProjectConfig _projectConfig_6 = this.getProjectConfig();
    IRuntimeProjectConfig _runtime_6 = _projectConfig_6.getRuntime();
    IXtextGeneratorFileSystemAccess _root_2 = _runtime_6.getRoot();
    boolean _tripleNotEquals_3 = (_root_2 != null);
    if (_tripleNotEquals_3) {
      IXtextProjectConfig _projectConfig_7 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_7 = _projectConfig_7.getRuntime();
      IXtextGeneratorFileSystemAccess _root_3 = _runtime_7.getRoot();
      String _path_3 = _root_3.getPath();
      String _plus = (_path_3 + "/model");
      Outlet _createOutlet_3 = this.createOutlet(false, encoding, Generator.MODEL, false, _plus);
      output.addOutlet(_createOutlet_3);
    }
    IXtextProjectConfig _projectConfig_8 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin = _projectConfig_8.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _root_4 = _eclipsePlugin.getRoot();
    boolean _tripleNotEquals_4 = (_root_4 != null);
    if (_tripleNotEquals_4) {
      IXtextProjectConfig _projectConfig_9 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_1 = _projectConfig_9.getEclipsePlugin();
      IXtextGeneratorFileSystemAccess _root_5 = _eclipsePlugin_1.getRoot();
      String _path_4 = _root_5.getPath();
      Outlet _createOutlet_4 = this.createOutlet(false, encoding, Generator.PLUGIN_UI, false, _path_4);
      output.addOutlet(_createOutlet_4);
    } else {
      IXtextProjectConfig _projectConfig_10 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_8 = _projectConfig_10.getRuntime();
      IXtextGeneratorFileSystemAccess _root_6 = _runtime_8.getRoot();
      boolean _tripleNotEquals_5 = (_root_6 != null);
      if (_tripleNotEquals_5) {
        IXtextProjectConfig _projectConfig_11 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_9 = _projectConfig_11.getRuntime();
        IXtextGeneratorFileSystemAccess _root_7 = _runtime_9.getRoot();
        String _path_5 = _root_7.getPath();
        Outlet _createOutlet_5 = this.createOutlet(false, encoding, Generator.PLUGIN_UI, false, _path_5);
        output.addOutlet(_createOutlet_5);
      }
    }
    IXtextProjectConfig _projectConfig_12 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin_2 = _projectConfig_12.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _src_2 = _eclipsePlugin_2.getSrc();
    boolean _tripleNotEquals_6 = (_src_2 != null);
    if (_tripleNotEquals_6) {
      IXtextProjectConfig _projectConfig_13 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_3 = _projectConfig_13.getEclipsePlugin();
      IXtextGeneratorFileSystemAccess _src_3 = _eclipsePlugin_3.getSrc();
      String _path_6 = _src_3.getPath();
      Outlet _createOutlet_6 = this.createOutlet(false, encoding, Generator.SRC_UI, false, _path_6);
      output.addOutlet(_createOutlet_6);
    } else {
      IXtextProjectConfig _projectConfig_14 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_10 = _projectConfig_14.getRuntime();
      IXtextGeneratorFileSystemAccess _src_4 = _runtime_10.getSrc();
      boolean _tripleNotEquals_7 = (_src_4 != null);
      if (_tripleNotEquals_7) {
        IXtextProjectConfig _projectConfig_15 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_11 = _projectConfig_15.getRuntime();
        IXtextGeneratorFileSystemAccess _src_5 = _runtime_11.getSrc();
        String _path_7 = _src_5.getPath();
        Outlet _createOutlet_7 = this.createOutlet(false, encoding, Generator.SRC_UI, false, _path_7);
        output.addOutlet(_createOutlet_7);
      }
    }
    IXtextProjectConfig _projectConfig_16 = this.getProjectConfig();
    IBundleProjectConfig _eclipsePlugin_4 = _projectConfig_16.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _srcGen_2 = _eclipsePlugin_4.getSrcGen();
    boolean _tripleNotEquals_8 = (_srcGen_2 != null);
    if (_tripleNotEquals_8) {
      IXtextProjectConfig _projectConfig_17 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_5 = _projectConfig_17.getEclipsePlugin();
      IXtextGeneratorFileSystemAccess _srcGen_3 = _eclipsePlugin_5.getSrcGen();
      String _path_8 = _srcGen_3.getPath();
      Outlet _createOutlet_8 = this.createOutlet(false, encoding, Generator.SRC_GEN_UI, true, _path_8);
      output.addOutlet(_createOutlet_8);
    } else {
      IXtextProjectConfig _projectConfig_18 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_12 = _projectConfig_18.getRuntime();
      IXtextGeneratorFileSystemAccess _srcGen_4 = _runtime_12.getSrcGen();
      boolean _tripleNotEquals_9 = (_srcGen_4 != null);
      if (_tripleNotEquals_9) {
        IXtextProjectConfig _projectConfig_19 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_13 = _projectConfig_19.getRuntime();
        IXtextGeneratorFileSystemAccess _srcGen_5 = _runtime_13.getSrcGen();
        String _path_9 = _srcGen_5.getPath();
        Outlet _createOutlet_9 = this.createOutlet(false, encoding, Generator.SRC_GEN_UI, true, _path_9);
        output.addOutlet(_createOutlet_9);
      }
    }
    IXtextProjectConfig _projectConfig_20 = this.getProjectConfig();
    IBundleProjectConfig _genericIde = _projectConfig_20.getGenericIde();
    IXtextGeneratorFileSystemAccess _root_8 = _genericIde.getRoot();
    boolean _tripleNotEquals_10 = (_root_8 != null);
    if (_tripleNotEquals_10) {
      IXtextProjectConfig _projectConfig_21 = this.getProjectConfig();
      IBundleProjectConfig _genericIde_1 = _projectConfig_21.getGenericIde();
      IXtextGeneratorFileSystemAccess _root_9 = _genericIde_1.getRoot();
      String _path_10 = _root_9.getPath();
      Outlet _createOutlet_10 = this.createOutlet(false, encoding, Generator.PLUGIN_IDE, false, _path_10);
      output.addOutlet(_createOutlet_10);
    } else {
      IXtextProjectConfig _projectConfig_22 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_6 = _projectConfig_22.getEclipsePlugin();
      IXtextGeneratorFileSystemAccess _root_10 = _eclipsePlugin_6.getRoot();
      boolean _tripleNotEquals_11 = (_root_10 != null);
      if (_tripleNotEquals_11) {
        IXtextProjectConfig _projectConfig_23 = this.getProjectConfig();
        IBundleProjectConfig _eclipsePlugin_7 = _projectConfig_23.getEclipsePlugin();
        IXtextGeneratorFileSystemAccess _root_11 = _eclipsePlugin_7.getRoot();
        String _path_11 = _root_11.getPath();
        Outlet _createOutlet_11 = this.createOutlet(false, encoding, Generator.PLUGIN_IDE, false, _path_11);
        output.addOutlet(_createOutlet_11);
      } else {
        IXtextProjectConfig _projectConfig_24 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_14 = _projectConfig_24.getRuntime();
        IXtextGeneratorFileSystemAccess _root_12 = _runtime_14.getRoot();
        boolean _tripleNotEquals_12 = (_root_12 != null);
        if (_tripleNotEquals_12) {
          IXtextProjectConfig _projectConfig_25 = this.getProjectConfig();
          IRuntimeProjectConfig _runtime_15 = _projectConfig_25.getRuntime();
          IXtextGeneratorFileSystemAccess _root_13 = _runtime_15.getRoot();
          String _path_12 = _root_13.getPath();
          Outlet _createOutlet_12 = this.createOutlet(false, encoding, Generator.PLUGIN_IDE, false, _path_12);
          output.addOutlet(_createOutlet_12);
        }
      }
    }
    IXtextProjectConfig _projectConfig_26 = this.getProjectConfig();
    IBundleProjectConfig _genericIde_2 = _projectConfig_26.getGenericIde();
    IXtextGeneratorFileSystemAccess _src_6 = _genericIde_2.getSrc();
    boolean _tripleNotEquals_13 = (_src_6 != null);
    if (_tripleNotEquals_13) {
      IXtextProjectConfig _projectConfig_27 = this.getProjectConfig();
      IBundleProjectConfig _genericIde_3 = _projectConfig_27.getGenericIde();
      IXtextGeneratorFileSystemAccess _src_7 = _genericIde_3.getSrc();
      String _path_13 = _src_7.getPath();
      Outlet _createOutlet_13 = this.createOutlet(false, encoding, Generator.SRC_IDE, false, _path_13);
      output.addOutlet(_createOutlet_13);
    } else {
      IXtextProjectConfig _projectConfig_28 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_8 = _projectConfig_28.getEclipsePlugin();
      IXtextGeneratorFileSystemAccess _src_8 = _eclipsePlugin_8.getSrc();
      boolean _tripleNotEquals_14 = (_src_8 != null);
      if (_tripleNotEquals_14) {
        IXtextProjectConfig _projectConfig_29 = this.getProjectConfig();
        IBundleProjectConfig _eclipsePlugin_9 = _projectConfig_29.getEclipsePlugin();
        IXtextGeneratorFileSystemAccess _src_9 = _eclipsePlugin_9.getSrc();
        String _path_14 = _src_9.getPath();
        Outlet _createOutlet_14 = this.createOutlet(false, encoding, Generator.SRC_IDE, false, _path_14);
        output.addOutlet(_createOutlet_14);
      } else {
        IXtextProjectConfig _projectConfig_30 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_16 = _projectConfig_30.getRuntime();
        IXtextGeneratorFileSystemAccess _src_10 = _runtime_16.getSrc();
        boolean _tripleNotEquals_15 = (_src_10 != null);
        if (_tripleNotEquals_15) {
          IXtextProjectConfig _projectConfig_31 = this.getProjectConfig();
          IRuntimeProjectConfig _runtime_17 = _projectConfig_31.getRuntime();
          IXtextGeneratorFileSystemAccess _src_11 = _runtime_17.getSrc();
          String _path_15 = _src_11.getPath();
          Outlet _createOutlet_15 = this.createOutlet(false, encoding, Generator.SRC_IDE, false, _path_15);
          output.addOutlet(_createOutlet_15);
        }
      }
    }
    IXtextProjectConfig _projectConfig_32 = this.getProjectConfig();
    IBundleProjectConfig _genericIde_4 = _projectConfig_32.getGenericIde();
    IXtextGeneratorFileSystemAccess _srcGen_6 = _genericIde_4.getSrcGen();
    boolean _tripleNotEquals_16 = (_srcGen_6 != null);
    if (_tripleNotEquals_16) {
      IXtextProjectConfig _projectConfig_33 = this.getProjectConfig();
      IBundleProjectConfig _genericIde_5 = _projectConfig_33.getGenericIde();
      IXtextGeneratorFileSystemAccess _srcGen_7 = _genericIde_5.getSrcGen();
      String _path_16 = _srcGen_7.getPath();
      Outlet _createOutlet_16 = this.createOutlet(false, encoding, Generator.SRC_GEN_IDE, true, _path_16);
      output.addOutlet(_createOutlet_16);
    } else {
      IXtextProjectConfig _projectConfig_34 = this.getProjectConfig();
      IBundleProjectConfig _eclipsePlugin_10 = _projectConfig_34.getEclipsePlugin();
      IXtextGeneratorFileSystemAccess _srcGen_8 = _eclipsePlugin_10.getSrcGen();
      boolean _tripleNotEquals_17 = (_srcGen_8 != null);
      if (_tripleNotEquals_17) {
        IXtextProjectConfig _projectConfig_35 = this.getProjectConfig();
        IBundleProjectConfig _eclipsePlugin_11 = _projectConfig_35.getEclipsePlugin();
        IXtextGeneratorFileSystemAccess _srcGen_9 = _eclipsePlugin_11.getSrcGen();
        String _path_17 = _srcGen_9.getPath();
        Outlet _createOutlet_17 = this.createOutlet(false, encoding, Generator.SRC_GEN_IDE, true, _path_17);
        output.addOutlet(_createOutlet_17);
      } else {
        IXtextProjectConfig _projectConfig_36 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_18 = _projectConfig_36.getRuntime();
        IXtextGeneratorFileSystemAccess _srcGen_10 = _runtime_18.getSrcGen();
        boolean _tripleNotEquals_18 = (_srcGen_10 != null);
        if (_tripleNotEquals_18) {
          IXtextProjectConfig _projectConfig_37 = this.getProjectConfig();
          IRuntimeProjectConfig _runtime_19 = _projectConfig_37.getRuntime();
          IXtextGeneratorFileSystemAccess _srcGen_11 = _runtime_19.getSrcGen();
          String _path_18 = _srcGen_11.getPath();
          Outlet _createOutlet_18 = this.createOutlet(false, encoding, Generator.SRC_GEN_IDE, true, _path_18);
          output.addOutlet(_createOutlet_18);
        }
      }
    }
    IXtextProjectConfig _projectConfig_38 = this.getProjectConfig();
    IBundleProjectConfig _runtimeTest = _projectConfig_38.getRuntimeTest();
    IXtextGeneratorFileSystemAccess _root_14 = _runtimeTest.getRoot();
    boolean _tripleNotEquals_19 = (_root_14 != null);
    if (_tripleNotEquals_19) {
      IXtextProjectConfig _projectConfig_39 = this.getProjectConfig();
      IBundleProjectConfig _runtimeTest_1 = _projectConfig_39.getRuntimeTest();
      IXtextGeneratorFileSystemAccess _root_15 = _runtimeTest_1.getRoot();
      String _path_19 = _root_15.getPath();
      Outlet _createOutlet_19 = this.createOutlet(false, encoding, Generator.PLUGIN_TEST, false, _path_19);
      output.addOutlet(_createOutlet_19);
    } else {
      IXtextProjectConfig _projectConfig_40 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_20 = _projectConfig_40.getRuntime();
      IXtextGeneratorFileSystemAccess _root_16 = _runtime_20.getRoot();
      boolean _tripleNotEquals_20 = (_root_16 != null);
      if (_tripleNotEquals_20) {
        IXtextProjectConfig _projectConfig_41 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_21 = _projectConfig_41.getRuntime();
        IXtextGeneratorFileSystemAccess _root_17 = _runtime_21.getRoot();
        String _path_20 = _root_17.getPath();
        Outlet _createOutlet_20 = this.createOutlet(false, encoding, Generator.PLUGIN_TEST, false, _path_20);
        output.addOutlet(_createOutlet_20);
      }
    }
    IXtextProjectConfig _projectConfig_42 = this.getProjectConfig();
    IBundleProjectConfig _runtimeTest_2 = _projectConfig_42.getRuntimeTest();
    IXtextGeneratorFileSystemAccess _src_12 = _runtimeTest_2.getSrc();
    boolean _tripleNotEquals_21 = (_src_12 != null);
    if (_tripleNotEquals_21) {
      IXtextProjectConfig _projectConfig_43 = this.getProjectConfig();
      IBundleProjectConfig _runtimeTest_3 = _projectConfig_43.getRuntimeTest();
      IXtextGeneratorFileSystemAccess _src_13 = _runtimeTest_3.getSrc();
      String _path_21 = _src_13.getPath();
      Outlet _createOutlet_21 = this.createOutlet(false, encoding, Generator.SRC_TEST, false, _path_21);
      output.addOutlet(_createOutlet_21);
    } else {
      IXtextProjectConfig _projectConfig_44 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_22 = _projectConfig_44.getRuntime();
      IXtextGeneratorFileSystemAccess _src_14 = _runtime_22.getSrc();
      boolean _tripleNotEquals_22 = (_src_14 != null);
      if (_tripleNotEquals_22) {
        IXtextProjectConfig _projectConfig_45 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_23 = _projectConfig_45.getRuntime();
        IXtextGeneratorFileSystemAccess _src_15 = _runtime_23.getSrc();
        String _path_22 = _src_15.getPath();
        Outlet _createOutlet_22 = this.createOutlet(false, encoding, Generator.SRC_TEST, false, _path_22);
        output.addOutlet(_createOutlet_22);
      }
    }
    IXtextProjectConfig _projectConfig_46 = this.getProjectConfig();
    IBundleProjectConfig _runtimeTest_4 = _projectConfig_46.getRuntimeTest();
    IXtextGeneratorFileSystemAccess _srcGen_12 = _runtimeTest_4.getSrcGen();
    boolean _tripleNotEquals_23 = (_srcGen_12 != null);
    if (_tripleNotEquals_23) {
      IXtextProjectConfig _projectConfig_47 = this.getProjectConfig();
      IBundleProjectConfig _runtimeTest_5 = _projectConfig_47.getRuntimeTest();
      IXtextGeneratorFileSystemAccess _srcGen_13 = _runtimeTest_5.getSrcGen();
      String _path_23 = _srcGen_13.getPath();
      Outlet _createOutlet_23 = this.createOutlet(false, encoding, Generator.SRC_GEN_TEST, true, _path_23);
      output.addOutlet(_createOutlet_23);
    } else {
      IXtextProjectConfig _projectConfig_48 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_24 = _projectConfig_48.getRuntime();
      IXtextGeneratorFileSystemAccess _srcGen_14 = _runtime_24.getSrcGen();
      boolean _tripleNotEquals_24 = (_srcGen_14 != null);
      if (_tripleNotEquals_24) {
        IXtextProjectConfig _projectConfig_49 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_25 = _projectConfig_49.getRuntime();
        IXtextGeneratorFileSystemAccess _srcGen_15 = _runtime_25.getSrcGen();
        String _path_24 = _srcGen_15.getPath();
        Outlet _createOutlet_24 = this.createOutlet(false, encoding, Generator.SRC_GEN_TEST, true, _path_24);
        output.addOutlet(_createOutlet_24);
      }
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
