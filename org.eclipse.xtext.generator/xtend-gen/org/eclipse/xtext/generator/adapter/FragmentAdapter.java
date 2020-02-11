/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.adapter;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xpand2.output.PostProcessor;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
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
import org.eclipse.xtext.xtext.generator.model.TypeReference;

/**
 * @since 2.9
 * 
 * @deprecated please rewrite your fragment with the new generator infrastructure.
 */
@Deprecated
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
      this.naming = this.createNaming();
    }
    if ((this.fragment == null)) {
      issues.addError("The property \'fragment\' must be set.", this);
    } else {
      this.fragment.checkConfiguration(((MweIssues) issues).getDelegate());
    }
  }
  
  @Override
  public void generate() {
    if ((this.naming == null)) {
      this.naming = this.createNaming();
    }
    final XpandExecutionContext ctx = this.createExecutionContext();
    final LanguageConfig config1 = this.createLanguageConfig();
    if ((this.fragment instanceof IGeneratorFragmentExtension2)) {
      ((IGeneratorFragmentExtension2)this.fragment).generate(config1, ctx);
    } else {
      this.fragment.generate(config1.getGrammar(), ctx);
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
    ctx.getOutput().openFile(null, StringConcatOutputImpl.STRING_OUTLET);
    try {
      final IXtextGeneratorLanguage config2 = this.getLanguage();
      if ((this.fragment instanceof IGeneratorFragmentExtension2)) {
        ((IGeneratorFragmentExtension2)this.fragment).addToStandaloneSetup(config1, ctx);
      } else {
        this.fragment.addToStandaloneSetup(config1.getGrammar(), ctx);
      }
      Output _output = ctx.getOutput();
      final StringConcatenation result = ((StringConcatOutputImpl) _output).getStringOutlet();
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          StringBuilder _decreaseIndentation = FragmentAdapter.this.decreaseIndentation(result.toString(), 2);
          _builder.append(_decreaseIndentation);
        }
      };
      config2.getRuntimeGenSetup().getRegistrations().add(_client);
      Set<TypeReference> _imports = config2.getRuntimeGenSetup().getImports();
      TypeReference _typeReference = new TypeReference("org.eclipse.emf.ecore.EPackage");
      _imports.add(_typeReference);
      Set<TypeReference> _imports_1 = config2.getRuntimeGenSetup().getImports();
      TypeReference _typeReference_1 = new TypeReference("org.eclipse.emf.ecore.resource.Resource");
      _imports_1.add(_typeReference_1);
    } finally {
      ctx.getOutput().closeFile();
    }
  }
  
  private void generateGuiceModuleRt(final LanguageConfig config1, final XpandExecutionContext ctx) {
    final IXtextGeneratorLanguage config2 = this.getLanguage();
    final Set<Binding> bindings = this.fragment.getGuiceBindingsRt(config1.getGrammar());
    if ((bindings != null)) {
      final Function1<Binding, GuiceModuleAccess.Binding> _function = (Binding it) -> {
        return this.translateBinding(it);
      };
      config2.getRuntimeGenModule().addAll(IterableExtensions.<Binding, GuiceModuleAccess.Binding>map(bindings, _function));
    }
    if ((this.fragment instanceof IGeneratorFragmentExtension4)) {
      final String superClass = ((IGeneratorFragmentExtension4)this.fragment).getDefaultRuntimeModuleClassName(config1.getGrammar());
      if ((superClass != null)) {
        GuiceModuleAccess _runtimeGenModule = config2.getRuntimeGenModule();
        TypeReference _typeReference = new TypeReference(superClass);
        _runtimeGenModule.setSuperClass(_typeReference);
      }
    }
  }
  
  private void generateGuiceModuleUi(final LanguageConfig config1, final XpandExecutionContext ctx) {
    final IXtextGeneratorLanguage config2 = this.getLanguage();
    final Set<Binding> bindings = this.fragment.getGuiceBindingsUi(config1.getGrammar());
    if ((bindings != null)) {
      final Function1<Binding, GuiceModuleAccess.Binding> _function = (Binding it) -> {
        return this.translateBinding(it);
      };
      config2.getEclipsePluginGenModule().addAll(IterableExtensions.<Binding, GuiceModuleAccess.Binding>map(bindings, _function));
    }
    if ((this.fragment instanceof IGeneratorFragmentExtension4)) {
      final String superClass = ((IGeneratorFragmentExtension4)this.fragment).getDefaultUiModuleClassName(config1.getGrammar());
      if ((superClass != null)) {
        GuiceModuleAccess _eclipsePluginGenModule = config2.getEclipsePluginGenModule();
        TypeReference _typeReference = new TypeReference(superClass);
        _eclipsePluginGenModule.setSuperClass(_typeReference);
      }
    }
  }
  
  private GuiceModuleAccess.Binding translateBinding(final Binding it) {
    GuiceModuleAccess.Binding _xblockexpression = null;
    {
      GuiceModuleAccess.BindKey _xifexpression = null;
      if (((it.getValue().getStatements() == null) || ((List<String>)Conversions.doWrapArray(it.getValue().getStatements())).isEmpty())) {
        String _type = it.getKey().getType();
        TypeReference _guessTypeRef = null;
        if (_type!=null) {
          _guessTypeRef=TypeReference.guessTypeRef(_type);
        }
        boolean _isSingleton = it.getKey().isSingleton();
        boolean _isEagerSingleton = it.getKey().isEagerSingleton();
        _xifexpression = new GuiceModuleAccess.BindKey(null, _guessTypeRef, _isSingleton, _isEagerSingleton);
      } else {
        String _className = this.getClassName(it.getKey().getType());
        boolean _isSingleton_1 = it.getKey().isSingleton();
        boolean _isEagerSingleton_1 = it.getKey().isEagerSingleton();
        _xifexpression = new GuiceModuleAccess.BindKey(_className, null, _isSingleton_1, _isEagerSingleton_1);
      }
      final GuiceModuleAccess.BindKey newKey = _xifexpression;
      String _expression = it.getValue().getExpression();
      String _typeName = it.getValue().getTypeName();
      TypeReference _guessTypeRef_1 = null;
      if (_typeName!=null) {
        _guessTypeRef_1=TypeReference.guessTypeRef(_typeName);
      }
      boolean _isProvider = it.getValue().isProvider();
      final Function1<String, Object> _function = (String s) -> {
        String _xifexpression_1 = null;
        boolean _endsWith = s.endsWith(";");
        if (_endsWith) {
          _xifexpression_1 = s;
        } else {
          _xifexpression_1 = (s + ";");
        }
        return _xifexpression_1;
      };
      List<Object> _map = ListExtensions.<String, Object>map(((List<String>)Conversions.doWrapArray(it.getValue().getStatements())), _function);
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
      boolean _matches = this.matches(qualifiedName.charAt(i), '.');
      if (_matches) {
        boolean _isLowerCase = Character.isLowerCase(qualifiedName.charAt((i + 1)));
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
    PluginXmlAccess _pluginXml = this.getProjectConfig().getRuntime().getPluginXml();
    boolean _tripleNotEquals = (_pluginXml != null);
    if (_tripleNotEquals) {
      ctx.getOutput().openFile(null, StringConcatOutputImpl.STRING_OUTLET);
      try {
        if ((this.fragment instanceof IGeneratorFragmentExtension2)) {
          ((IGeneratorFragmentExtension2)this.fragment).addToPluginXmlRt(config1, ctx);
        } else {
          this.fragment.addToPluginXmlRt(config1.getGrammar(), ctx);
        }
        Output _output = ctx.getOutput();
        final StringConcatenation result = ((StringConcatOutputImpl) _output).getStringOutlet();
        final StringBuilder entry = this.decreaseIndentation(result.toString(), 1);
        boolean _isEmpty = entry.toString().trim().isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          List<CharSequence> _entries = this.getProjectConfig().getRuntime().getPluginXml().getEntries();
          _entries.add(entry);
        }
      } finally {
        ctx.getOutput().closeFile();
      }
    }
  }
  
  private void generatePluginXmlUi(final LanguageConfig config1, final XpandExecutionContext ctx) {
    PluginXmlAccess _pluginXml = this.getProjectConfig().getEclipsePlugin().getPluginXml();
    boolean _tripleNotEquals = (_pluginXml != null);
    if (_tripleNotEquals) {
      ctx.getOutput().openFile(null, StringConcatOutputImpl.STRING_OUTLET);
      try {
        if ((this.fragment instanceof IGeneratorFragmentExtension2)) {
          ((IGeneratorFragmentExtension2)this.fragment).addToPluginXmlUi(config1, ctx);
        } else {
          this.fragment.addToPluginXmlUi(config1.getGrammar(), ctx);
        }
        Output _output = ctx.getOutput();
        final StringConcatenation result = ((StringConcatOutputImpl) _output).getStringOutlet();
        final StringBuilder entry = this.decreaseIndentation(result.toString(), 1);
        boolean _isEmpty = entry.toString().trim().isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          List<CharSequence> _entries = this.getProjectConfig().getEclipsePlugin().getPluginXml().getEntries();
          _entries.add(entry);
        }
      } finally {
        ctx.getOutput().closeFile();
      }
    }
  }
  
  private void generateManifestRt(final LanguageConfig config1, final XpandExecutionContext ctx) {
    ManifestAccess _manifest = this.getProjectConfig().getRuntime().getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      final String[] exported = this.fragment.getExportedPackagesRt(config1.getGrammar());
      if ((exported != null)) {
        CollectionExtensions.<String>addAll(this.getProjectConfig().getRuntime().getManifest().getExportedPackages(), exported);
      }
      final String[] required = this.fragment.getRequiredBundlesRt(config1.getGrammar());
      if ((required != null)) {
        CollectionExtensions.<String>addAll(this.getProjectConfig().getRuntime().getManifest().getRequiredBundles(), required);
      }
      final String[] imported = this.fragment.getImportedPackagesRt(config1.getGrammar());
      if ((imported != null)) {
        CollectionExtensions.<String>addAll(this.getProjectConfig().getRuntime().getManifest().getImportedPackages(), imported);
      }
    }
  }
  
  private void generateManifestUi(final LanguageConfig config1, final XpandExecutionContext ctx) {
    ManifestAccess _manifest = this.getProjectConfig().getEclipsePlugin().getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      final String[] exported = this.fragment.getExportedPackagesUi(config1.getGrammar());
      if ((exported != null)) {
        CollectionExtensions.<String>addAll(this.getProjectConfig().getEclipsePlugin().getManifest().getExportedPackages(), exported);
      }
      final String[] required = this.fragment.getRequiredBundlesUi(config1.getGrammar());
      if ((required != null)) {
        CollectionExtensions.<String>addAll(this.getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles(), required);
      }
      final String[] imported = this.fragment.getImportedPackagesUi(config1.getGrammar());
      if ((imported != null)) {
        CollectionExtensions.<String>addAll(this.getProjectConfig().getEclipsePlugin().getManifest().getImportedPackages(), imported);
      }
    }
  }
  
  private void generateManifestIde(final LanguageConfig config1, final XpandExecutionContext ctx) {
    if (((this.fragment instanceof IGeneratorFragmentExtension3) && (this.getProjectConfig().getGenericIde().getManifest() != null))) {
      final IGeneratorFragmentExtension3 fr = ((IGeneratorFragmentExtension3) this.fragment);
      final String[] exported = fr.getExportedPackagesIde(config1.getGrammar());
      if ((exported != null)) {
        CollectionExtensions.<String>addAll(this.getProjectConfig().getGenericIde().getManifest().getExportedPackages(), exported);
      }
      final String[] required = fr.getRequiredBundlesIde(config1.getGrammar());
      if ((required != null)) {
        CollectionExtensions.<String>addAll(this.getProjectConfig().getGenericIde().getManifest().getRequiredBundles(), required);
      }
      final String[] imported = fr.getImportedPackagesIde(config1.getGrammar());
      if ((imported != null)) {
        CollectionExtensions.<String>addAll(this.getProjectConfig().getGenericIde().getManifest().getImportedPackages(), imported);
      }
    }
  }
  
  private void generateManifestTests(final LanguageConfig config1, final XpandExecutionContext ctx) {
    if (((this.fragment instanceof IGeneratorFragmentExtension) && (this.getProjectConfig().getRuntimeTest().getManifest() != null))) {
      final IGeneratorFragmentExtension fr = ((IGeneratorFragmentExtension) this.fragment);
      final String[] exported = fr.getExportedPackagesTests(config1.getGrammar());
      if ((exported != null)) {
        CollectionExtensions.<String>addAll(this.getProjectConfig().getRuntimeTest().getManifest().getExportedPackages(), exported);
      }
      final String[] required = fr.getRequiredBundlesTests(config1.getGrammar());
      if ((required != null)) {
        CollectionExtensions.<String>addAll(this.getProjectConfig().getRuntimeTest().getManifest().getRequiredBundles(), required);
      }
      final String[] imported = fr.getImportedPackagesTests(config1.getGrammar());
      if ((imported != null)) {
        CollectionExtensions.<String>addAll(this.getProjectConfig().getRuntimeTest().getManifest().getImportedPackages(), imported);
      }
    }
  }
  
  protected Naming createNaming() {
    final IXtextGeneratorLanguage config2 = this.getLanguage();
    Naming _naming = new Naming();
    final Procedure1<Naming> _function = (Naming it) -> {
      IXtextGeneratorFileSystemAccess _root = this.getProjectConfig().getRuntime().getRoot();
      String _path = null;
      if (_root!=null) {
        _path=_root.getPath();
      }
      it.setProjectNameRt(this.getLastSegment(_path));
      IXtextGeneratorFileSystemAccess _root_1 = this.getProjectConfig().getGenericIde().getRoot();
      String _path_1 = null;
      if (_root_1!=null) {
        _path_1=_root_1.getPath();
      }
      it.setProjectNameIde(this.getLastSegment(_path_1));
      IXtextGeneratorFileSystemAccess _root_2 = this.getProjectConfig().getEclipsePlugin().getRoot();
      String _path_2 = null;
      if (_root_2!=null) {
        _path_2=_root_2.getPath();
      }
      it.setProjectNameUi(this.getLastSegment(_path_2));
      it.setIdeBasePackage(this._xtextGeneratorNaming.getGenericIdeBasePackage(config2.getGrammar()));
      it.setUiBasePackage(this._xtextGeneratorNaming.getEclipsePluginBasePackage(config2.getGrammar()));
      TypeReference _eclipsePluginActivator = this._xtextGeneratorNaming.getEclipsePluginActivator();
      String _name = null;
      if (_eclipsePluginActivator!=null) {
        _name=_eclipsePluginActivator.getName();
      }
      it.setActivatorName(_name);
      IXtextGeneratorFileSystemAccess _root_3 = this.getProjectConfig().getRuntimeTest().getRoot();
      String _path_3 = null;
      if (_root_3!=null) {
        _path_3=_root_3.getPath();
      }
      it.setPathTestProject(_path_3);
      it.setLineDelimiter(this.codeConfig.getLineDelimiter());
      it.setFileHeader(this.codeConfig.getFileHeader());
      it.setClassAnnotations(this.codeConfig.getClassAnnotationsAsString());
      it.setAnnotationImports(this.codeConfig.getAnnotationImportsAsString());
      String _projectNameUi = it.getProjectNameUi();
      boolean _tripleNotEquals = (_projectNameUi != null);
      it.setHasUI(_tripleNotEquals);
      String _projectNameIde = it.getProjectNameIde();
      boolean _tripleNotEquals_1 = (_projectNameIde != null);
      it.setHasIde(_tripleNotEquals_1);
      it.setGrammarId(config2.getGrammar().getName());
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
    config.setForcedResourceSet(config2.getResourceSet());
    config.setFileExtensions(IterableExtensions.join(config2.getFileExtensions(), ","));
    config.setUri(config2.getGrammarUri());
    config.registerNaming(this.naming);
    return config;
  }
  
  protected XpandExecutionContext createExecutionContext() {
    final String encoding = this.encodingProvider.getEncoding(null);
    final StringConcatOutputImpl output = new StringConcatOutputImpl();
    IXtextGeneratorFileSystemAccess _root = this.getProjectConfig().getRuntime().getRoot();
    boolean _tripleNotEquals = (_root != null);
    if (_tripleNotEquals) {
      output.addOutlet(this.createOutlet(false, encoding, Generator.PLUGIN_RT, false, this.getProjectConfig().getRuntime().getRoot().getPath()));
    }
    IXtextGeneratorFileSystemAccess _src = this.getProjectConfig().getRuntime().getSrc();
    boolean _tripleNotEquals_1 = (_src != null);
    if (_tripleNotEquals_1) {
      output.addOutlet(this.createOutlet(false, encoding, Generator.SRC, false, this.getProjectConfig().getRuntime().getSrc().getPath()));
    }
    IXtextGeneratorFileSystemAccess _srcGen = this.getProjectConfig().getRuntime().getSrcGen();
    boolean _tripleNotEquals_2 = (_srcGen != null);
    if (_tripleNotEquals_2) {
      output.addOutlet(this.createOutlet(false, encoding, Generator.SRC_GEN, true, this.getProjectConfig().getRuntime().getSrcGen().getPath()));
    }
    IXtextGeneratorFileSystemAccess _root_1 = this.getProjectConfig().getRuntime().getRoot();
    boolean _tripleNotEquals_3 = (_root_1 != null);
    if (_tripleNotEquals_3) {
      String _path = this.getProjectConfig().getRuntime().getRoot().getPath();
      String _plus = (_path + "/model");
      output.addOutlet(this.createOutlet(false, encoding, Generator.MODEL, false, _plus));
    }
    IXtextGeneratorFileSystemAccess _root_2 = this.getProjectConfig().getEclipsePlugin().getRoot();
    boolean _tripleNotEquals_4 = (_root_2 != null);
    if (_tripleNotEquals_4) {
      output.addOutlet(this.createOutlet(false, encoding, Generator.PLUGIN_UI, false, this.getProjectConfig().getEclipsePlugin().getRoot().getPath()));
    } else {
      IXtextGeneratorFileSystemAccess _root_3 = this.getProjectConfig().getRuntime().getRoot();
      boolean _tripleNotEquals_5 = (_root_3 != null);
      if (_tripleNotEquals_5) {
        output.addOutlet(this.createOutlet(false, encoding, Generator.PLUGIN_UI, false, this.getProjectConfig().getRuntime().getRoot().getPath()));
      }
    }
    IXtextGeneratorFileSystemAccess _src_1 = this.getProjectConfig().getEclipsePlugin().getSrc();
    boolean _tripleNotEquals_6 = (_src_1 != null);
    if (_tripleNotEquals_6) {
      output.addOutlet(this.createOutlet(false, encoding, Generator.SRC_UI, false, this.getProjectConfig().getEclipsePlugin().getSrc().getPath()));
    } else {
      IXtextGeneratorFileSystemAccess _src_2 = this.getProjectConfig().getRuntime().getSrc();
      boolean _tripleNotEquals_7 = (_src_2 != null);
      if (_tripleNotEquals_7) {
        output.addOutlet(this.createOutlet(false, encoding, Generator.SRC_UI, false, this.getProjectConfig().getRuntime().getSrc().getPath()));
      }
    }
    IXtextGeneratorFileSystemAccess _srcGen_1 = this.getProjectConfig().getEclipsePlugin().getSrcGen();
    boolean _tripleNotEquals_8 = (_srcGen_1 != null);
    if (_tripleNotEquals_8) {
      output.addOutlet(this.createOutlet(false, encoding, Generator.SRC_GEN_UI, true, this.getProjectConfig().getEclipsePlugin().getSrcGen().getPath()));
    } else {
      IXtextGeneratorFileSystemAccess _srcGen_2 = this.getProjectConfig().getRuntime().getSrcGen();
      boolean _tripleNotEquals_9 = (_srcGen_2 != null);
      if (_tripleNotEquals_9) {
        output.addOutlet(this.createOutlet(false, encoding, Generator.SRC_GEN_UI, true, this.getProjectConfig().getRuntime().getSrcGen().getPath()));
      }
    }
    IXtextGeneratorFileSystemAccess _root_4 = this.getProjectConfig().getGenericIde().getRoot();
    boolean _tripleNotEquals_10 = (_root_4 != null);
    if (_tripleNotEquals_10) {
      output.addOutlet(this.createOutlet(false, encoding, Generator.PLUGIN_IDE, false, this.getProjectConfig().getGenericIde().getRoot().getPath()));
    } else {
      IXtextGeneratorFileSystemAccess _root_5 = this.getProjectConfig().getEclipsePlugin().getRoot();
      boolean _tripleNotEquals_11 = (_root_5 != null);
      if (_tripleNotEquals_11) {
        output.addOutlet(this.createOutlet(false, encoding, Generator.PLUGIN_IDE, false, this.getProjectConfig().getEclipsePlugin().getRoot().getPath()));
      } else {
        IXtextGeneratorFileSystemAccess _root_6 = this.getProjectConfig().getRuntime().getRoot();
        boolean _tripleNotEquals_12 = (_root_6 != null);
        if (_tripleNotEquals_12) {
          output.addOutlet(this.createOutlet(false, encoding, Generator.PLUGIN_IDE, false, this.getProjectConfig().getRuntime().getRoot().getPath()));
        }
      }
    }
    IXtextGeneratorFileSystemAccess _src_3 = this.getProjectConfig().getGenericIde().getSrc();
    boolean _tripleNotEquals_13 = (_src_3 != null);
    if (_tripleNotEquals_13) {
      output.addOutlet(this.createOutlet(false, encoding, Generator.SRC_IDE, false, this.getProjectConfig().getGenericIde().getSrc().getPath()));
    } else {
      IXtextGeneratorFileSystemAccess _src_4 = this.getProjectConfig().getEclipsePlugin().getSrc();
      boolean _tripleNotEquals_14 = (_src_4 != null);
      if (_tripleNotEquals_14) {
        output.addOutlet(this.createOutlet(false, encoding, Generator.SRC_IDE, false, this.getProjectConfig().getEclipsePlugin().getSrc().getPath()));
      } else {
        IXtextGeneratorFileSystemAccess _src_5 = this.getProjectConfig().getRuntime().getSrc();
        boolean _tripleNotEquals_15 = (_src_5 != null);
        if (_tripleNotEquals_15) {
          output.addOutlet(this.createOutlet(false, encoding, Generator.SRC_IDE, false, this.getProjectConfig().getRuntime().getSrc().getPath()));
        }
      }
    }
    IXtextGeneratorFileSystemAccess _srcGen_3 = this.getProjectConfig().getGenericIde().getSrcGen();
    boolean _tripleNotEquals_16 = (_srcGen_3 != null);
    if (_tripleNotEquals_16) {
      output.addOutlet(this.createOutlet(false, encoding, Generator.SRC_GEN_IDE, true, this.getProjectConfig().getGenericIde().getSrcGen().getPath()));
    } else {
      IXtextGeneratorFileSystemAccess _srcGen_4 = this.getProjectConfig().getEclipsePlugin().getSrcGen();
      boolean _tripleNotEquals_17 = (_srcGen_4 != null);
      if (_tripleNotEquals_17) {
        output.addOutlet(this.createOutlet(false, encoding, Generator.SRC_GEN_IDE, true, this.getProjectConfig().getEclipsePlugin().getSrcGen().getPath()));
      } else {
        IXtextGeneratorFileSystemAccess _srcGen_5 = this.getProjectConfig().getRuntime().getSrcGen();
        boolean _tripleNotEquals_18 = (_srcGen_5 != null);
        if (_tripleNotEquals_18) {
          output.addOutlet(this.createOutlet(false, encoding, Generator.SRC_GEN_IDE, true, this.getProjectConfig().getRuntime().getSrcGen().getPath()));
        }
      }
    }
    IXtextGeneratorFileSystemAccess _root_7 = this.getProjectConfig().getRuntimeTest().getRoot();
    boolean _tripleNotEquals_19 = (_root_7 != null);
    if (_tripleNotEquals_19) {
      output.addOutlet(this.createOutlet(false, encoding, Generator.PLUGIN_TEST, false, this.getProjectConfig().getRuntimeTest().getRoot().getPath()));
    } else {
      IXtextGeneratorFileSystemAccess _root_8 = this.getProjectConfig().getRuntime().getRoot();
      boolean _tripleNotEquals_20 = (_root_8 != null);
      if (_tripleNotEquals_20) {
        output.addOutlet(this.createOutlet(false, encoding, Generator.PLUGIN_TEST, false, this.getProjectConfig().getRuntime().getRoot().getPath()));
      }
    }
    IXtextGeneratorFileSystemAccess _src_6 = this.getProjectConfig().getRuntimeTest().getSrc();
    boolean _tripleNotEquals_21 = (_src_6 != null);
    if (_tripleNotEquals_21) {
      output.addOutlet(this.createOutlet(false, encoding, Generator.SRC_TEST, false, this.getProjectConfig().getRuntimeTest().getSrc().getPath()));
    } else {
      IXtextGeneratorFileSystemAccess _src_7 = this.getProjectConfig().getRuntime().getSrc();
      boolean _tripleNotEquals_22 = (_src_7 != null);
      if (_tripleNotEquals_22) {
        output.addOutlet(this.createOutlet(false, encoding, Generator.SRC_TEST, false, this.getProjectConfig().getRuntime().getSrc().getPath()));
      }
    }
    IXtextGeneratorFileSystemAccess _srcGen_6 = this.getProjectConfig().getRuntimeTest().getSrcGen();
    boolean _tripleNotEquals_23 = (_srcGen_6 != null);
    if (_tripleNotEquals_23) {
      output.addOutlet(this.createOutlet(false, encoding, Generator.SRC_GEN_TEST, true, this.getProjectConfig().getRuntimeTest().getSrcGen().getPath()));
    } else {
      IXtextGeneratorFileSystemAccess _srcGen_7 = this.getProjectConfig().getRuntime().getSrcGen();
      boolean _tripleNotEquals_24 = (_srcGen_7 != null);
      if (_tripleNotEquals_24) {
        output.addOutlet(this.createOutlet(false, encoding, Generator.SRC_GEN_TEST, true, this.getProjectConfig().getRuntime().getSrcGen().getPath()));
      }
    }
    final Map<String, Variable> globalVars = Maps.<String, Variable>newHashMap();
    Variable _variable = new Variable(Naming.GLOBAL_VAR_NAME, this.naming);
    globalVars.put(Naming.GLOBAL_VAR_NAME, _variable);
    XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null, globalVars, null, null);
    execCtx.getResourceManager().setFileEncoding("ISO-8859-1");
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
    final String path = fsa.getURI("").toFileString();
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
