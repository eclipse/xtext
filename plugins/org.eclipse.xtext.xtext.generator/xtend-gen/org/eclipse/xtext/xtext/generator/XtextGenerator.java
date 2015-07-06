/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.base.Objects;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;
import java.util.jar.Attributes;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.util.MergeableManifest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.XtextGeneratorTemplates;
import org.eclipse.xtext.xtext.generator.model.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

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
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  private IXtextProjectConfig projectConfig;
  
  @Inject
  private XtextGeneratorTemplates templates;
  
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
    this.generateActivator();
  }
  
  protected void generateRuntimeSetup(final LanguageConfig2 language) {
    JavaFileAccess _createRuntimeSetup = this.templates.createRuntimeSetup(language);
    IFileSystemAccess2 _runtimeSrc = this.projectConfig.getRuntimeSrc();
    _createRuntimeSetup.writeTo(_runtimeSrc);
    JavaFileAccess _createRuntimeGenSetup = this.templates.createRuntimeGenSetup(language);
    IFileSystemAccess2 _runtimeSrcGen = this.projectConfig.getRuntimeSrcGen();
    _createRuntimeGenSetup.writeTo(_runtimeSrcGen);
  }
  
  protected void generateModules(final LanguageConfig2 language) {
    JavaFileAccess _createRuntimeModule = this.templates.createRuntimeModule(language);
    IFileSystemAccess2 _runtimeSrc = this.projectConfig.getRuntimeSrc();
    _createRuntimeModule.writeTo(_runtimeSrc);
    JavaFileAccess _createRuntimeGenModule = this.templates.createRuntimeGenModule(language);
    IFileSystemAccess2 _runtimeSrcGen = this.projectConfig.getRuntimeSrcGen();
    _createRuntimeGenModule.writeTo(_runtimeSrcGen);
    IFileSystemAccess2 _eclipsePluginSrc = this.projectConfig.getEclipsePluginSrc();
    boolean _tripleNotEquals = (_eclipsePluginSrc != null);
    if (_tripleNotEquals) {
      JavaFileAccess _createEclipsePluginModule = this.templates.createEclipsePluginModule(language);
      IFileSystemAccess2 _eclipsePluginSrc_1 = this.projectConfig.getEclipsePluginSrc();
      _createEclipsePluginModule.writeTo(_eclipsePluginSrc_1);
    }
    IFileSystemAccess2 _eclipsePluginSrcGen = this.projectConfig.getEclipsePluginSrcGen();
    boolean _tripleNotEquals_1 = (_eclipsePluginSrcGen != null);
    if (_tripleNotEquals_1) {
      JavaFileAccess _createEclipsePluginGenModule = this.templates.createEclipsePluginGenModule(language);
      IFileSystemAccess2 _eclipsePluginSrcGen_1 = this.projectConfig.getEclipsePluginSrcGen();
      _createEclipsePluginGenModule.writeTo(_eclipsePluginSrcGen_1);
    }
  }
  
  protected void generateExecutableExtensionFactory(final LanguageConfig2 language) {
    IFileSystemAccess2 _eclipsePluginSrcGen = this.projectConfig.getEclipsePluginSrcGen();
    boolean _tripleNotEquals = (_eclipsePluginSrcGen != null);
    if (_tripleNotEquals) {
      JavaFileAccess _createEclipsePluginExecutableExtensionFactory = this.templates.createEclipsePluginExecutableExtensionFactory(language);
      IFileSystemAccess2 _eclipsePluginSrcGen_1 = this.projectConfig.getEclipsePluginSrcGen();
      _createEclipsePluginExecutableExtensionFactory.writeTo(_eclipsePluginSrcGen_1);
    }
  }
  
  protected void generateManifests() {
    LanguageConfig2 _head = IterableExtensions.<LanguageConfig2>head(this.languageConfigs);
    Grammar _grammar = null;
    if (_head!=null) {
      _grammar=_head.getGrammar();
    }
    final Grammar firstGrammar = _grammar;
    ManifestAccess _runtimeManifest = this.projectConfig.getRuntimeManifest();
    this.generateManifest(_runtimeManifest, null);
    ManifestAccess _runtimeTestManifest = this.projectConfig.getRuntimeTestManifest();
    this.generateManifest(_runtimeTestManifest, null);
    ManifestAccess _genericIdeManifest = this.projectConfig.getGenericIdeManifest();
    this.generateManifest(_genericIdeManifest, null);
    ManifestAccess _genericIdeTestManifest = this.projectConfig.getGenericIdeTestManifest();
    this.generateManifest(_genericIdeTestManifest, null);
    ManifestAccess _eclipsePluginManifest = this.projectConfig.getEclipsePluginManifest();
    TypeReference _eclipsePluginActivator = this._xtextGeneratorNaming.getEclipsePluginActivator(firstGrammar);
    this.generateManifest(_eclipsePluginManifest, _eclipsePluginActivator);
    ManifestAccess _eclipsePluginTestManifest = this.projectConfig.getEclipsePluginTestManifest();
    this.generateManifest(_eclipsePluginTestManifest, null);
    ManifestAccess _ideaPluginManifest = this.projectConfig.getIdeaPluginManifest();
    this.generateManifest(_ideaPluginManifest, null);
    ManifestAccess _ideaPluginTestManifest = this.projectConfig.getIdeaPluginTestManifest();
    this.generateManifest(_ideaPluginTestManifest, null);
    ManifestAccess _webManifest = this.projectConfig.getWebManifest();
    this.generateManifest(_webManifest, null);
    ManifestAccess _webTestManifest = this.projectConfig.getWebTestManifest();
    this.generateManifest(_webTestManifest, null);
  }
  
  protected void generateManifest(final ManifestAccess manifest, final TypeReference activator) {
    try {
      if ((manifest != null)) {
        String _bundleName = manifest.getBundleName();
        boolean _tripleEquals = (_bundleName == null);
        if (_tripleEquals) {
          String _path = manifest.getPath();
          final String[] segments = _path.split("/");
          boolean _and = false;
          int _length = segments.length;
          boolean _greaterEqualsThan = (_length >= 3);
          if (!_greaterEqualsThan) {
            _and = false;
          } else {
            int _length_1 = segments.length;
            int _minus = (_length_1 - 2);
            String _get = segments[_minus];
            boolean _equals = Objects.equal(_get, "META-INF");
            _and = _equals;
          }
          if (_and) {
            int _length_2 = segments.length;
            int _minus_1 = (_length_2 - 3);
            String _get_1 = segments[_minus_1];
            manifest.setBundleName(_get_1);
          }
        }
        String _path_1 = manifest.getPath();
        final File file = new File(_path_1);
        boolean _exists = file.exists();
        if (_exists) {
          boolean _isMerge = manifest.isMerge();
          if (_isMerge) {
            this.mergeManifest(manifest, file, activator);
          } else {
            String _path_2 = manifest.getPath();
            boolean _endsWith = _path_2.endsWith(".MF");
            if (_endsWith) {
              String _path_3 = manifest.getPath();
              String _plus = (_path_3 + "_gen");
              manifest.setPath(_plus);
              TextFileAccess _createManifest = this.templates.createManifest(manifest, activator);
              _createManifest.writeToFile();
            }
          }
        } else {
          TextFileAccess _createManifest_1 = this.templates.createManifest(manifest, activator);
          _createManifest_1.writeToFile();
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void generateActivator() {
    IFileSystemAccess2 _eclipsePluginSrcGen = this.projectConfig.getEclipsePluginSrcGen();
    boolean _tripleNotEquals = (_eclipsePluginSrcGen != null);
    if (_tripleNotEquals) {
      JavaFileAccess _createEclipsePluginActivator = this.templates.createEclipsePluginActivator(this.languageConfigs);
      IFileSystemAccess2 _eclipsePluginSrcGen_1 = this.projectConfig.getEclipsePluginSrcGen();
      _createEclipsePluginActivator.writeTo(_eclipsePluginSrcGen_1);
    }
  }
  
  protected void mergeManifest(final ManifestAccess manifest, final File file, final TypeReference activator) throws IOException {
    InputStream in = null;
    OutputStream out = null;
    try {
      FileInputStream _fileInputStream = new FileInputStream(file);
      in = _fileInputStream;
      String _bundleName = manifest.getBundleName();
      final MergeableManifest merge = new MergeableManifest(in, _bundleName);
      Set<String> _exportedPackages = manifest.getExportedPackages();
      merge.addExportedPackages(_exportedPackages);
      Set<String> _requiredBundles = manifest.getRequiredBundles();
      merge.addRequiredBundles(_requiredBundles);
      Set<String> _importedPackages = manifest.getImportedPackages();
      merge.addImportedPackages(_importedPackages);
      boolean _and = false;
      if (!(activator != null)) {
        _and = false;
      } else {
        Attributes _mainAttributes = merge.getMainAttributes();
        boolean _containsKey = _mainAttributes.containsKey(MergeableManifest.BUNDLE_ACTIVATOR);
        boolean _not = (!_containsKey);
        _and = _not;
      }
      if (_and) {
        Attributes _mainAttributes_1 = merge.getMainAttributes();
        String _name = activator.getName();
        _mainAttributes_1.put(MergeableManifest.BUNDLE_ACTIVATOR, _name);
      }
      boolean _isModified = merge.isModified();
      if (_isModified) {
        FileOutputStream _fileOutputStream = new FileOutputStream(file);
        out = _fileOutputStream;
        merge.write(out);
      }
    } finally {
      if ((in != null)) {
        in.close();
      }
      boolean _notEquals = (!Objects.equal(out, null));
      if (_notEquals) {
        out.close();
      }
    }
  }
  
  protected void generatePluginXmls() {
    PluginXmlAccess _runtimePluginXml = this.projectConfig.getRuntimePluginXml();
    this.generatePluginXml(_runtimePluginXml);
    PluginXmlAccess _runtimeTestPluginXml = this.projectConfig.getRuntimeTestPluginXml();
    this.generatePluginXml(_runtimeTestPluginXml);
    PluginXmlAccess _genericIdePluginXml = this.projectConfig.getGenericIdePluginXml();
    this.generatePluginXml(_genericIdePluginXml);
    PluginXmlAccess _genericIdeTestPluginXml = this.projectConfig.getGenericIdeTestPluginXml();
    this.generatePluginXml(_genericIdeTestPluginXml);
    PluginXmlAccess _eclipsePluginPluginXml = this.projectConfig.getEclipsePluginPluginXml();
    this.generatePluginXml(_eclipsePluginPluginXml);
    PluginXmlAccess _eclipsePluginTestPluginXml = this.projectConfig.getEclipsePluginTestPluginXml();
    this.generatePluginXml(_eclipsePluginTestPluginXml);
    PluginXmlAccess _ideaPluginPluginXml = this.projectConfig.getIdeaPluginPluginXml();
    this.generatePluginXml(_ideaPluginPluginXml);
    PluginXmlAccess _ideaPluginTestPluginXml = this.projectConfig.getIdeaPluginTestPluginXml();
    this.generatePluginXml(_ideaPluginTestPluginXml);
    PluginXmlAccess _webPluginXml = this.projectConfig.getWebPluginXml();
    this.generatePluginXml(_webPluginXml);
    PluginXmlAccess _webTestPluginXml = this.projectConfig.getWebTestPluginXml();
    this.generatePluginXml(_webTestPluginXml);
  }
  
  protected void generatePluginXml(final PluginXmlAccess pluginXml) {
    try {
      if ((pluginXml != null)) {
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
            TextFileAccess _createPluginXml = this.templates.createPluginXml(pluginXml);
            _createPluginXml.writeToFile();
          }
        } else {
          TextFileAccess _createPluginXml_1 = this.templates.createPluginXml(pluginXml);
          _createPluginXml_1.writeToFile();
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
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
