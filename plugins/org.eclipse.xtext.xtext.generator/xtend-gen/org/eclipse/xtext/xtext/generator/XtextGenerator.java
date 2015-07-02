/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.File;
import java.util.List;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.XtextGeneratorTemplates;
import org.eclipse.xtext.xtext.generator.model.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;

/**
 * The Xtext language infrastructure generator. Can be configured with {@link IGeneratorFragment}
 * instances as well as with some properties declared via setter or adder methods.
 * 
 * <p><b>NOTE: This is a reimplementation of org.eclipse.xtext.generator.Generator</b></p>
 */
@SuppressWarnings("all")
public class XtextGenerator extends AbstractWorkflowComponent2 implements IGuiceAwareGeneratorComponent {
  @Accessors
  private DefaultGeneratorModule configuration;
  
  @Accessors
  private String activator;
  
  private final List<LanguageConfig2> languageConfigs = CollectionLiterals.<LanguageConfig2>newArrayList();
  
  private Injector injector;
  
  @Inject
  private IXtextProjectConfig projectConfig;
  
  @Inject
  private XtextGeneratorTemplates templates;
  
  @Inject
  private IEncodingProvider encodingProvider;
  
  public XtextGenerator() {
    XtextStandaloneSetup _xtextStandaloneSetup = new XtextStandaloneSetup();
    _xtextStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
  
  /**
   * Add a language configuration to be included in the code generation process.
   */
  public void addLanguage(final LanguageConfig2 language) {
    this.languageConfigs.add(language);
  }
  
  protected Injector createInjector() {
    if ((this.injector == null)) {
      if ((this.configuration == null)) {
        DefaultGeneratorModule _defaultGeneratorModule = new DefaultGeneratorModule();
        this.configuration = _defaultGeneratorModule;
      }
      Injector _createInjector = Guice.createInjector(this.configuration);
      this.injector = _createInjector;
      this.initialize(this.injector);
    }
    return this.injector;
  }
  
  @Override
  public void initialize(final Injector injector) {
    injector.injectMembers(this);
    this.projectConfig.initialize(injector);
    CodeConfig _instance = injector.<CodeConfig>getInstance(CodeConfig.class);
    final Procedure1<CodeConfig> _function = new Procedure1<CodeConfig>() {
      @Override
      public void apply(final CodeConfig codeConfig) {
        codeConfig.initialize(injector);
      }
    };
    ObjectExtensions.<CodeConfig>operator_doubleArrow(_instance, _function);
    XtextGeneratorNaming _instance_1 = injector.<XtextGeneratorNaming>getInstance(XtextGeneratorNaming.class);
    final Procedure1<XtextGeneratorNaming> _function_1 = new Procedure1<XtextGeneratorNaming>() {
      @Override
      public void apply(final XtextGeneratorNaming naming) {
        naming.setEclipsePluginActivator(XtextGenerator.this.activator);
      }
    };
    ObjectExtensions.<XtextGeneratorNaming>operator_doubleArrow(_instance_1, _function_1);
  }
  
  @Override
  protected void invokeInternal(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {
    final Injector injector = this.createInjector();
    for (final LanguageConfig2 language : this.languageConfigs) {
      {
        language.initialize(injector);
        language.generate(language);
        this.generateRuntimeSetup(language);
        this.generateModules(language);
        this.generateExecutableExtensionFactory(language);
      }
    }
    this.generatePluginXmls();
    this.generateManifests();
  }
  
  protected void generateRuntimeSetup(final LanguageConfig2 language) {
    JavaFileAccess _runtimeSetup = this.templates.getRuntimeSetup(language);
    IFileSystemAccess2 _runtimeSrc = this.projectConfig.getRuntimeSrc();
    _runtimeSetup.writeTo(_runtimeSrc);
    JavaFileAccess _runtimeSetup_1 = language.getRuntimeSetup();
    JavaFileAccess _finishRuntimeGenSetup = this.templates.finishRuntimeGenSetup(_runtimeSetup_1);
    IFileSystemAccess2 _runtimeSrcGen = this.projectConfig.getRuntimeSrcGen();
    _finishRuntimeGenSetup.writeTo(_runtimeSrcGen);
  }
  
  protected void generateModules(final LanguageConfig2 language) {
    JavaFileAccess _runtimeModule = this.templates.getRuntimeModule(language);
    IFileSystemAccess2 _runtimeSrc = this.projectConfig.getRuntimeSrc();
    _runtimeModule.writeTo(_runtimeSrc);
    GuiceModuleAccess _runtimeModule_1 = language.getRuntimeModule();
    GuiceModuleAccess _finishGenModule = this.templates.finishGenModule(_runtimeModule_1);
    IFileSystemAccess2 _runtimeSrcGen = this.projectConfig.getRuntimeSrcGen();
    _finishGenModule.writeTo(_runtimeSrcGen);
    IFileSystemAccess2 _eclipsePluginSrc = this.projectConfig.getEclipsePluginSrc();
    boolean _tripleNotEquals = (_eclipsePluginSrc != null);
    if (_tripleNotEquals) {
      JavaFileAccess _eclipsePluginModule = this.templates.getEclipsePluginModule(language);
      IFileSystemAccess2 _eclipsePluginSrc_1 = this.projectConfig.getEclipsePluginSrc();
      _eclipsePluginModule.writeTo(_eclipsePluginSrc_1);
    }
    IFileSystemAccess2 _eclipsePluginSrcGen = this.projectConfig.getEclipsePluginSrcGen();
    boolean _tripleNotEquals_1 = (_eclipsePluginSrcGen != null);
    if (_tripleNotEquals_1) {
      GuiceModuleAccess _eclipsePluginModule_1 = language.getEclipsePluginModule();
      GuiceModuleAccess _finishGenModule_1 = this.templates.finishGenModule(_eclipsePluginModule_1);
      IFileSystemAccess2 _eclipsePluginSrcGen_1 = this.projectConfig.getEclipsePluginSrcGen();
      _finishGenModule_1.writeTo(_eclipsePluginSrcGen_1);
    }
  }
  
  protected void generateExecutableExtensionFactory(final LanguageConfig2 language) {
    IFileSystemAccess2 _eclipsePluginSrcGen = this.projectConfig.getEclipsePluginSrcGen();
    boolean _tripleNotEquals = (_eclipsePluginSrcGen != null);
    if (_tripleNotEquals) {
      JavaFileAccess _eclipsePluginExecutableExtensionFactory = this.templates.getEclipsePluginExecutableExtensionFactory(language);
      IFileSystemAccess2 _eclipsePluginSrcGen_1 = this.projectConfig.getEclipsePluginSrcGen();
      _eclipsePluginExecutableExtensionFactory.writeTo(_eclipsePluginSrcGen_1);
    }
  }
  
  protected void generateManifests() {
    ManifestAccess _runtimeManifest = this.projectConfig.getRuntimeManifest();
    if (_runtimeManifest!=null) {
      _runtimeManifest.generate();
    }
    ManifestAccess _runtimeTestManifest = this.projectConfig.getRuntimeTestManifest();
    if (_runtimeTestManifest!=null) {
      _runtimeTestManifest.generate();
    }
    ManifestAccess _genericIdeManifest = this.projectConfig.getGenericIdeManifest();
    if (_genericIdeManifest!=null) {
      _genericIdeManifest.generate();
    }
    ManifestAccess _genericIdeTestManifest = this.projectConfig.getGenericIdeTestManifest();
    if (_genericIdeTestManifest!=null) {
      _genericIdeTestManifest.generate();
    }
    ManifestAccess _eclipsePluginManifest = this.projectConfig.getEclipsePluginManifest();
    if (_eclipsePluginManifest!=null) {
      _eclipsePluginManifest.generate();
    }
    ManifestAccess _eclipsePluginTestManifest = this.projectConfig.getEclipsePluginTestManifest();
    if (_eclipsePluginTestManifest!=null) {
      _eclipsePluginTestManifest.generate();
    }
    ManifestAccess _ideaPluginManifest = this.projectConfig.getIdeaPluginManifest();
    if (_ideaPluginManifest!=null) {
      _ideaPluginManifest.generate();
    }
    ManifestAccess _ideaPluginTestManifest = this.projectConfig.getIdeaPluginTestManifest();
    if (_ideaPluginTestManifest!=null) {
      _ideaPluginTestManifest.generate();
    }
    ManifestAccess _webManifest = this.projectConfig.getWebManifest();
    if (_webManifest!=null) {
      _webManifest.generate();
    }
    ManifestAccess _webTestManifest = this.projectConfig.getWebTestManifest();
    if (_webTestManifest!=null) {
      _webTestManifest.generate();
    }
  }
  
  protected void generatePluginXmls() {
    TextFileAccess _runtimePluginXml = this.projectConfig.getRuntimePluginXml();
    this.generatePluginXml(_runtimePluginXml, this.encodingProvider);
    TextFileAccess _runtimeTestPluginXml = this.projectConfig.getRuntimeTestPluginXml();
    this.generatePluginXml(_runtimeTestPluginXml, this.encodingProvider);
    TextFileAccess _genericIdePluginXml = this.projectConfig.getGenericIdePluginXml();
    this.generatePluginXml(_genericIdePluginXml, this.encodingProvider);
    TextFileAccess _genericIdeTestPluginXml = this.projectConfig.getGenericIdeTestPluginXml();
    this.generatePluginXml(_genericIdeTestPluginXml, this.encodingProvider);
    TextFileAccess _eclipsePluginPluginXml = this.projectConfig.getEclipsePluginPluginXml();
    this.generatePluginXml(_eclipsePluginPluginXml, this.encodingProvider);
    TextFileAccess _eclipsePluginTestPluginXml = this.projectConfig.getEclipsePluginTestPluginXml();
    this.generatePluginXml(_eclipsePluginTestPluginXml, this.encodingProvider);
    TextFileAccess _ideaPluginPluginXml = this.projectConfig.getIdeaPluginPluginXml();
    this.generatePluginXml(_ideaPluginPluginXml, this.encodingProvider);
    TextFileAccess _ideaPluginTestPluginXml = this.projectConfig.getIdeaPluginTestPluginXml();
    this.generatePluginXml(_ideaPluginTestPluginXml, this.encodingProvider);
    TextFileAccess _webPluginXml = this.projectConfig.getWebPluginXml();
    this.generatePluginXml(_webPluginXml, this.encodingProvider);
    TextFileAccess _webTestPluginXml = this.projectConfig.getWebTestPluginXml();
    this.generatePluginXml(_webTestPluginXml, this.encodingProvider);
  }
  
  protected void generatePluginXml(final TextFileAccess pluginXml, final IEncodingProvider encodingProvider) {
    if ((pluginXml != null)) {
      pluginXml.setEncodingProvider(encodingProvider);
      String _path = pluginXml.getPath();
      File _file = new File(_path);
      boolean _exists = _file.exists();
      if (_exists) {
        String _path_1 = pluginXml.getPath();
        boolean _endsWith = _path_1.endsWith(".xml");
        if (_endsWith) {
          String _path_2 = pluginXml.getPath();
          String _plus = (_path_2 + "_gen");
          pluginXml.setPath(_plus);
          pluginXml.writeToFile();
        }
      } else {
        pluginXml.writeToFile();
      }
    }
  }
  
  @Pure
  public DefaultGeneratorModule getConfiguration() {
    return this.configuration;
  }
  
  public void setConfiguration(final DefaultGeneratorModule configuration) {
    this.configuration = configuration;
  }
  
  @Pure
  public String getActivator() {
    return this.activator;
  }
  
  public void setActivator(final String activator) {
    this.activator = activator;
  }
}
