/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.binder.AnnotatedBindingBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.XtextGeneratorTemplates;
import org.eclipse.xtext.xtext.generator.model.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.model.XtextProjectConfig;

/**
 * The Xtext language infrastructure generator. Can be configured with {@link IGeneratorFragment}
 * instances as well as with some properties declared via setter or adder methods.
 * 
 * <p><b>NOTE: This is a reimplementation of org.eclipse.xtext.generator.Generator</b></p>
 */
@SuppressWarnings("all")
public class XtextGenerator extends AbstractWorkflowComponent2 {
  @Accessors
  private XtextProjectConfig projectConfig;
  
  @Accessors
  private CodeConfig codeConfig;
  
  private final List<Module> modules = CollectionLiterals.<Module>newArrayList();
  
  private final List<LanguageConfig2> languageConfigs = CollectionLiterals.<LanguageConfig2>newArrayList();
  
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
  
  /**
   * Add Guice modules to customize the behavior of the generator.
   */
  public void addModule(final Module module) {
    this.modules.add(module);
  }
  
  @Override
  protected void invokeInternal(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {
    IXtextProjectConfig project = this.projectConfig;
    IEncodingProvider encodingProvider = null;
    for (final LanguageConfig2 language : this.languageConfigs) {
      {
        final Injector injector = this.createInjector(language);
        language.generate();
        final XtextGeneratorTemplates templates = injector.<XtextGeneratorTemplates>getInstance(XtextGeneratorTemplates.class);
        this.generateRuntimeSetup(language, project, templates);
        this.generateModules(language, project, templates);
        if ((project == null)) {
          IXtextProjectConfig _instance = injector.<IXtextProjectConfig>getInstance(IXtextProjectConfig.class);
          project = _instance;
        }
        if ((encodingProvider == null)) {
          IEncodingProvider _instance_1 = injector.<IEncodingProvider>getInstance(IEncodingProvider.class);
          encodingProvider = _instance_1;
        }
      }
    }
    if ((project != null)) {
      this.generateManifests(project);
      this.generatePluginXmls(project, encodingProvider);
    }
  }
  
  protected void generateRuntimeSetup(final LanguageConfig2 language, final IXtextProjectConfig project, final XtextGeneratorTemplates templates) {
    JavaFileAccess _runtimeSetup = templates.getRuntimeSetup();
    IFileSystemAccess2 _runtimeSrc = project.getRuntimeSrc();
    _runtimeSetup.writeTo(_runtimeSrc);
    JavaFileAccess _runtimeSetup_1 = language.getRuntimeSetup();
    JavaFileAccess _finishRuntimeGenSetup = templates.finishRuntimeGenSetup(_runtimeSetup_1);
    IFileSystemAccess2 _runtimeSrcGen = project.getRuntimeSrcGen();
    _finishRuntimeGenSetup.writeTo(_runtimeSrcGen);
  }
  
  protected void generateModules(final LanguageConfig2 language, final IXtextProjectConfig project, final XtextGeneratorTemplates templates) {
    JavaFileAccess _runtimeModule = templates.getRuntimeModule();
    IFileSystemAccess2 _runtimeSrc = project.getRuntimeSrc();
    _runtimeModule.writeTo(_runtimeSrc);
    GuiceModuleAccess _runtimeModule_1 = language.getRuntimeModule();
    GuiceModuleAccess _finishGenModule = templates.finishGenModule(_runtimeModule_1);
    IFileSystemAccess2 _runtimeSrcGen = project.getRuntimeSrcGen();
    _finishGenModule.writeTo(_runtimeSrcGen);
    IFileSystemAccess2 _eclipsePluginSrc = project.getEclipsePluginSrc();
    boolean _tripleNotEquals = (_eclipsePluginSrc != null);
    if (_tripleNotEquals) {
      JavaFileAccess _eclipsePluginModule = templates.getEclipsePluginModule();
      IFileSystemAccess2 _eclipsePluginSrc_1 = project.getEclipsePluginSrc();
      _eclipsePluginModule.writeTo(_eclipsePluginSrc_1);
    }
    IFileSystemAccess2 _eclipsePluginSrcGen = project.getEclipsePluginSrcGen();
    boolean _tripleNotEquals_1 = (_eclipsePluginSrcGen != null);
    if (_tripleNotEquals_1) {
      GuiceModuleAccess _eclipsePluginModule_1 = language.getEclipsePluginModule();
      GuiceModuleAccess _finishGenModule_1 = templates.finishGenModule(_eclipsePluginModule_1);
      IFileSystemAccess2 _eclipsePluginSrcGen_1 = project.getEclipsePluginSrcGen();
      _finishGenModule_1.writeTo(_eclipsePluginSrcGen_1);
    }
  }
  
  protected void generateManifests(final IXtextProjectConfig project) {
    ManifestAccess _runtimeManifest = project.getRuntimeManifest();
    if (_runtimeManifest!=null) {
      _runtimeManifest.generate();
    }
    ManifestAccess _runtimeTestManifest = project.getRuntimeTestManifest();
    if (_runtimeTestManifest!=null) {
      _runtimeTestManifest.generate();
    }
    ManifestAccess _genericIdeManifest = project.getGenericIdeManifest();
    if (_genericIdeManifest!=null) {
      _genericIdeManifest.generate();
    }
    ManifestAccess _genericIdeTestManifest = project.getGenericIdeTestManifest();
    if (_genericIdeTestManifest!=null) {
      _genericIdeTestManifest.generate();
    }
    ManifestAccess _eclipsePluginManifest = project.getEclipsePluginManifest();
    if (_eclipsePluginManifest!=null) {
      _eclipsePluginManifest.generate();
    }
    ManifestAccess _eclipsePluginTestManifest = project.getEclipsePluginTestManifest();
    if (_eclipsePluginTestManifest!=null) {
      _eclipsePluginTestManifest.generate();
    }
    ManifestAccess _ideaPluginManifest = project.getIdeaPluginManifest();
    if (_ideaPluginManifest!=null) {
      _ideaPluginManifest.generate();
    }
    ManifestAccess _ideaPluginTestManifest = project.getIdeaPluginTestManifest();
    if (_ideaPluginTestManifest!=null) {
      _ideaPluginTestManifest.generate();
    }
    ManifestAccess _webManifest = project.getWebManifest();
    if (_webManifest!=null) {
      _webManifest.generate();
    }
    ManifestAccess _webTestManifest = project.getWebTestManifest();
    if (_webTestManifest!=null) {
      _webTestManifest.generate();
    }
  }
  
  protected void generatePluginXmls(final IXtextProjectConfig project, final IEncodingProvider encodingProvider) {
    TextFileAccess _runtimePluginXml = project.getRuntimePluginXml();
    this.generatePluginXml(_runtimePluginXml, encodingProvider);
    TextFileAccess _runtimeTestPluginXml = project.getRuntimeTestPluginXml();
    this.generatePluginXml(_runtimeTestPluginXml, encodingProvider);
    TextFileAccess _genericIdePluginXml = project.getGenericIdePluginXml();
    this.generatePluginXml(_genericIdePluginXml, encodingProvider);
    TextFileAccess _genericIdeTestPluginXml = project.getGenericIdeTestPluginXml();
    this.generatePluginXml(_genericIdeTestPluginXml, encodingProvider);
    TextFileAccess _eclipsePluginPluginXml = project.getEclipsePluginPluginXml();
    this.generatePluginXml(_eclipsePluginPluginXml, encodingProvider);
    TextFileAccess _eclipsePluginTestPluginXml = project.getEclipsePluginTestPluginXml();
    this.generatePluginXml(_eclipsePluginTestPluginXml, encodingProvider);
    TextFileAccess _ideaPluginPluginXml = project.getIdeaPluginPluginXml();
    this.generatePluginXml(_ideaPluginPluginXml, encodingProvider);
    TextFileAccess _ideaPluginTestPluginXml = project.getIdeaPluginTestPluginXml();
    this.generatePluginXml(_ideaPluginTestPluginXml, encodingProvider);
    TextFileAccess _webPluginXml = project.getWebPluginXml();
    this.generatePluginXml(_webPluginXml, encodingProvider);
    TextFileAccess _webTestPluginXml = project.getWebTestPluginXml();
    this.generatePluginXml(_webTestPluginXml, encodingProvider);
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
  
  protected Injector createInjector(final LanguageConfig2 languageConfig) {
    DefaultGeneratorModule _defaultGeneratorModule = new DefaultGeneratorModule();
    final ArrayList<Module> guiceConfig = CollectionLiterals.<Module>newArrayList(_defaultGeneratorModule);
    guiceConfig.addAll(this.modules);
    final Module _function = new Module() {
      @Override
      public void configure(final Binder it) {
        AnnotatedBindingBuilder<LanguageConfig2> _bind = it.<LanguageConfig2>bind(LanguageConfig2.class);
        _bind.toInstance(languageConfig);
      }
    };
    guiceConfig.add(_function);
    if ((this.projectConfig != null)) {
      final Module _function_1 = new Module() {
        @Override
        public void configure(final Binder it) {
          AnnotatedBindingBuilder<IXtextProjectConfig> _bind = it.<IXtextProjectConfig>bind(IXtextProjectConfig.class);
          _bind.toInstance(XtextGenerator.this.projectConfig);
        }
      };
      guiceConfig.add(_function_1);
    }
    if ((this.codeConfig != null)) {
      final Module _function_2 = new Module() {
        @Override
        public void configure(final Binder it) {
          AnnotatedBindingBuilder<CodeConfig> _bind = it.<CodeConfig>bind(CodeConfig.class);
          _bind.toInstance(XtextGenerator.this.codeConfig);
        }
      };
      guiceConfig.add(_function_2);
    }
    Module _mixin = Modules2.mixin(((Module[])Conversions.unwrapArray(guiceConfig, Module.class)));
    final Injector injector = Guice.createInjector(_mixin);
    injector.injectMembers(languageConfig);
    languageConfig.initialize();
    if ((this.projectConfig != null)) {
      injector.injectMembers(this.projectConfig);
      this.projectConfig.initialize();
    }
    if ((this.codeConfig != null)) {
      injector.injectMembers(this.codeConfig);
      this.codeConfig.initialize();
    }
    return injector;
  }
  
  @Pure
  public XtextProjectConfig getProjectConfig() {
    return this.projectConfig;
  }
  
  public void setProjectConfig(final XtextProjectConfig projectConfig) {
    this.projectConfig = projectConfig;
  }
  
  @Pure
  public CodeConfig getCodeConfig() {
    return this.codeConfig;
  }
  
  public void setCodeConfig(final CodeConfig codeConfig) {
    this.codeConfig = codeConfig;
  }
}
