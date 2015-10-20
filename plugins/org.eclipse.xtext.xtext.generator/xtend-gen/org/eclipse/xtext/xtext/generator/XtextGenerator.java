/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.jar.Attributes;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.util.MergeableManifest;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.LanguageModule;
import org.eclipse.xtext.xtext.generator.MweIssues;
import org.eclipse.xtext.xtext.generator.XtextDirectoryCleaner;
import org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.XtextGeneratorStandaloneSetup;
import org.eclipse.xtext.xtext.generator.XtextGeneratorTemplates;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.project.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.ISubProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IWebProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;

/**
 * The Xtext language infrastructure generator. Can be configured with {@link IXtextGeneratorFragment}
 * instances as well as with some properties declared via setter or adder methods.
 * 
 * <p><b>NOTE: This is a reimplementation of org.eclipse.xtext.generator.Generator</b></p>
 */
@Log
@SuppressWarnings("all")
public class XtextGenerator extends AbstractWorkflowComponent2 {
  @Accessors
  private DefaultGeneratorModule configuration = new DefaultGeneratorModule();
  
  @Accessors
  private final List<XtextGeneratorLanguage> languageConfigs = CollectionLiterals.<XtextGeneratorLanguage>newArrayList();
  
  @Accessors
  private XtextDirectoryCleaner cleaner = new XtextDirectoryCleaner();
  
  @Accessors
  private XtextGeneratorStandaloneSetup standaloneSetup = new XtextGeneratorStandaloneSetup();
  
  private Injector injector;
  
  @Inject
  private IXtextProjectConfig projectConfig;
  
  @Inject
  private XtextGeneratorTemplates templates;
  
  @Inject
  private XtextGeneratorNaming naming;
  
  public XtextGenerator() {
    XtextStandaloneSetup _xtextStandaloneSetup = new XtextStandaloneSetup();
    _xtextStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
  
  /**
   * Add a language configuration to be included in the code generation process.
   */
  public void addLanguage(final XtextGeneratorLanguage language) {
    this.languageConfigs.add(language);
  }
  
  @Override
  protected void checkConfigurationInternal(final Issues issues) {
    this.initialize();
    final MweIssues generatorIssues = new MweIssues(this, issues);
    this.configuration.checkConfiguration(generatorIssues);
    final HashMap<String, Grammar> uris = new HashMap<String, Grammar>();
    for (final XtextGeneratorLanguage language : this.languageConfigs) {
      {
        language.checkConfiguration(generatorIssues);
        Grammar _grammar = language.getGrammar();
        EList<AbstractMetamodelDeclaration> _metamodelDeclarations = _grammar.getMetamodelDeclarations();
        Iterable<GeneratedMetamodel> _filter = Iterables.<GeneratedMetamodel>filter(_metamodelDeclarations, GeneratedMetamodel.class);
        for (final GeneratedMetamodel generatedMetamodel : _filter) {
          {
            EPackage _ePackage = generatedMetamodel.getEPackage();
            final String nsURI = _ePackage.getNsURI();
            boolean _containsKey = uris.containsKey(nsURI);
            if (_containsKey) {
              Grammar _get = uris.get(nsURI);
              String _name = _get.getName();
              String _plus = ((("Duplicate generated grammar with nsURI \'" + nsURI) + "\' in ") + _name);
              String _plus_1 = (_plus + " and ");
              Grammar _grammar_1 = language.getGrammar();
              String _name_1 = _grammar_1.getName();
              String _plus_2 = (_plus_1 + _name_1);
              generatorIssues.addError(_plus_2);
            } else {
              Grammar _grammar_2 = language.getGrammar();
              uris.put(nsURI, _grammar_2);
            }
          }
        }
      }
    }
  }
  
  public void initialize() {
    if ((this.injector == null)) {
      XtextGenerator.LOG.info("Initializing Xtext generator");
      StandaloneSetup _standaloneSetup = new StandaloneSetup();
      _standaloneSetup.addRegisterGeneratedEPackage("org.eclipse.xtext.common.types.TypesPackage");
      Injector _createInjector = this.createInjector();
      this.injector = _createInjector;
      this.injector.injectMembers(this);
      CodeConfig _instance = this.injector.<CodeConfig>getInstance(CodeConfig.class);
      final Procedure1<CodeConfig> _function = new Procedure1<CodeConfig>() {
        @Override
        public void apply(final CodeConfig it) {
          it.initialize(XtextGenerator.this.injector);
        }
      };
      ObjectExtensions.<CodeConfig>operator_doubleArrow(_instance, _function);
      this.projectConfig.initialize(this.injector);
      this.cleaner.initialize(this.injector);
      this.standaloneSetup.initialize(this.injector);
      for (final XtextGeneratorLanguage language : this.languageConfigs) {
        {
          final Injector languageInjector = this.createLanguageInjector(this.injector, language);
          language.initialize(languageInjector);
        }
      }
    }
  }
  
  protected Injector createInjector() {
    return Guice.createInjector(this.configuration);
  }
  
  protected Injector createLanguageInjector(final Injector parent, final XtextGeneratorLanguage language) {
    LanguageModule _languageModule = new LanguageModule(language);
    return parent.createChildInjector(_languageModule);
  }
  
  @Override
  protected void invokeInternal(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {
    this.initialize();
    this.cleaner.clean();
    for (final XtextGeneratorLanguage language : this.languageConfigs) {
      {
        Grammar _grammar = language.getGrammar();
        String _name = _grammar.getName();
        String _plus = ("Generating " + _name);
        XtextGenerator.LOG.info(_plus);
        language.generate();
        this.generateSetups(language);
        this.generateModules(language);
        this.generateExecutableExtensionFactory(language);
      }
    }
    XtextGenerator.LOG.info("Generating common infrastructure");
    this.generatePluginXmls();
    this.generateManifests();
    this.generateActivator();
  }
  
  protected void generateSetups(final IXtextGeneratorLanguage language) {
    JavaFileAccess _createRuntimeGenSetup = this.templates.createRuntimeGenSetup(language);
    IRuntimeProjectConfig _runtime = this.projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _srcGen = _runtime.getSrcGen();
    _createRuntimeGenSetup.writeTo(_srcGen);
    JavaFileAccess _createRuntimeSetup = this.templates.createRuntimeSetup(language);
    IRuntimeProjectConfig _runtime_1 = this.projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _src = _runtime_1.getSrc();
    _createRuntimeSetup.writeTo(_src);
    JavaFileAccess _createWebSetup = this.templates.createWebSetup(language);
    IWebProjectConfig _web = this.projectConfig.getWeb();
    IXtextGeneratorFileSystemAccess _src_1 = _web.getSrc();
    _createWebSetup.writeTo(_src_1);
  }
  
  protected void generateModules(final IXtextGeneratorLanguage language) {
    JavaFileAccess _createRuntimeGenModule = this.templates.createRuntimeGenModule(language);
    IRuntimeProjectConfig _runtime = this.projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _srcGen = _runtime.getSrcGen();
    _createRuntimeGenModule.writeTo(_srcGen);
    JavaFileAccess _createRuntimeModule = this.templates.createRuntimeModule(language);
    IRuntimeProjectConfig _runtime_1 = this.projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _src = _runtime_1.getSrc();
    _createRuntimeModule.writeTo(_src);
    JavaFileAccess _createEclipsePluginGenModule = this.templates.createEclipsePluginGenModule(language);
    IBundleProjectConfig _eclipsePlugin = this.projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _srcGen_1 = _eclipsePlugin.getSrcGen();
    _createEclipsePluginGenModule.writeTo(_srcGen_1);
    JavaFileAccess _createEclipsePluginModule = this.templates.createEclipsePluginModule(language);
    IBundleProjectConfig _eclipsePlugin_1 = this.projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _src_1 = _eclipsePlugin_1.getSrc();
    _createEclipsePluginModule.writeTo(_src_1);
    JavaFileAccess _createIdeaGenModule = this.templates.createIdeaGenModule(language);
    ISubProjectConfig _ideaPlugin = this.projectConfig.getIdeaPlugin();
    IXtextGeneratorFileSystemAccess _srcGen_2 = _ideaPlugin.getSrcGen();
    _createIdeaGenModule.writeTo(_srcGen_2);
    JavaFileAccess _createIdeaModule = this.templates.createIdeaModule(language);
    ISubProjectConfig _ideaPlugin_1 = this.projectConfig.getIdeaPlugin();
    IXtextGeneratorFileSystemAccess _src_2 = _ideaPlugin_1.getSrc();
    _createIdeaModule.writeTo(_src_2);
    JavaFileAccess _createWebGenModule = this.templates.createWebGenModule(language);
    IWebProjectConfig _web = this.projectConfig.getWeb();
    IXtextGeneratorFileSystemAccess _srcGen_3 = _web.getSrcGen();
    _createWebGenModule.writeTo(_srcGen_3);
    JavaFileAccess _createWebModule = this.templates.createWebModule(language);
    IWebProjectConfig _web_1 = this.projectConfig.getWeb();
    IXtextGeneratorFileSystemAccess _src_3 = _web_1.getSrc();
    _createWebModule.writeTo(_src_3);
  }
  
  protected void generateExecutableExtensionFactory(final IXtextGeneratorLanguage language) {
    IBundleProjectConfig _eclipsePlugin = this.projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _srcGen = _eclipsePlugin.getSrcGen();
    boolean _tripleNotEquals = (_srcGen != null);
    if (_tripleNotEquals) {
      XtextGeneratorLanguage _head = IterableExtensions.<XtextGeneratorLanguage>head(this.languageConfigs);
      JavaFileAccess _createEclipsePluginExecutableExtensionFactory = this.templates.createEclipsePluginExecutableExtensionFactory(language, _head);
      IBundleProjectConfig _eclipsePlugin_1 = this.projectConfig.getEclipsePlugin();
      IXtextGeneratorFileSystemAccess _srcGen_1 = _eclipsePlugin_1.getSrcGen();
      _createEclipsePluginExecutableExtensionFactory.writeTo(_srcGen_1);
    }
  }
  
  protected void generateManifests() {
    try {
      List<? extends ISubProjectConfig> _enabledProjects = this.projectConfig.getEnabledProjects();
      Iterable<BundleProjectConfig> _filter = Iterables.<BundleProjectConfig>filter(_enabledProjects, BundleProjectConfig.class);
      final Function1<BundleProjectConfig, Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String>> _function = new Function1<BundleProjectConfig, Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String>>() {
        @Override
        public Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String> apply(final BundleProjectConfig it) {
          ManifestAccess _manifest = it.getManifest();
          IXtextGeneratorFileSystemAccess _metaInf = it.getMetaInf();
          String _name = it.getName();
          return Tuples.<ManifestAccess, IXtextGeneratorFileSystemAccess, String>create(_manifest, _metaInf, _name);
        }
      };
      Iterable<Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String>> _map = IterableExtensions.<BundleProjectConfig, Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String>>map(_filter, _function);
      final List<Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String>> manifests = IterableExtensions.<Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String>>toList(_map);
      int _size = manifests.size();
      final HashMap<URI, ManifestAccess> uri2Manifest = Maps.<URI, ManifestAccess>newHashMapWithExpectedSize(_size);
      final ListIterator<Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String>> manifestIter = manifests.listIterator();
      while (manifestIter.hasNext()) {
        {
          final Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String> entry = manifestIter.next();
          final ManifestAccess manifest = entry.getFirst();
          final IXtextGeneratorFileSystemAccess metaInf = entry.getSecond();
          if (((manifest == null) || (metaInf == null))) {
            manifestIter.remove();
          } else {
            String _path = manifest.getPath();
            final URI uri = metaInf.getURI(_path);
            boolean _containsKey = uri2Manifest.containsKey(uri);
            if (_containsKey) {
              ManifestAccess _get = uri2Manifest.get(uri);
              _get.merge(manifest);
              manifestIter.remove();
            } else {
              uri2Manifest.put(uri, manifest);
            }
          }
        }
      }
      for (final Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String> entry : manifests) {
        {
          final ManifestAccess manifest = entry.getFirst();
          final IXtextGeneratorFileSystemAccess metaInf = entry.getSecond();
          String _bundleName = manifest.getBundleName();
          boolean _tripleEquals = (_bundleName == null);
          if (_tripleEquals) {
            String _third = entry.getThird();
            manifest.setBundleName(_third);
          }
          IBundleProjectConfig _eclipsePlugin = this.projectConfig.getEclipsePlugin();
          ManifestAccess _manifest = _eclipsePlugin.getManifest();
          boolean _tripleEquals_1 = (manifest == _manifest);
          if (_tripleEquals_1) {
            final XtextGeneratorLanguage firstLanguage = IterableExtensions.<XtextGeneratorLanguage>head(this.languageConfigs);
            TypeReference _eclipsePluginActivator = null;
            if (this.naming!=null) {
              Grammar _grammar = firstLanguage.getGrammar();
              _eclipsePluginActivator=this.naming.getEclipsePluginActivator(_grammar);
            }
            manifest.setActivator(_eclipsePluginActivator);
          }
          String _path = manifest.getPath();
          boolean _isFile = metaInf.isFile(_path);
          if (_isFile) {
            boolean _isMerge = manifest.isMerge();
            if (_isMerge) {
              this.mergeManifest(manifest, metaInf);
            } else {
              String _path_1 = manifest.getPath();
              boolean _endsWith = _path_1.endsWith(".MF");
              if (_endsWith) {
                String _path_2 = manifest.getPath();
                String _plus = (_path_2 + "_gen");
                manifest.setPath(_plus);
                manifest.writeTo(metaInf);
              }
            }
          } else {
            manifest.writeTo(metaInf);
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void mergeManifest(final ManifestAccess manifest, final IXtextGeneratorFileSystemAccess metaInf) throws IOException {
    InputStream in = null;
    try {
      String _path = manifest.getPath();
      InputStream _readBinaryFile = metaInf.readBinaryFile(_path);
      in = _readBinaryFile;
      String _bundleName = manifest.getBundleName();
      final MergeableManifest merge = new MergeableManifest(in, _bundleName);
      Set<String> _exportedPackages = manifest.getExportedPackages();
      merge.addExportedPackages(_exportedPackages);
      Set<String> _requiredBundles = manifest.getRequiredBundles();
      merge.addRequiredBundles(_requiredBundles);
      Set<String> _importedPackages = manifest.getImportedPackages();
      merge.addImportedPackages(_importedPackages);
      boolean _and = false;
      TypeReference _activator = manifest.getActivator();
      boolean _tripleNotEquals = (_activator != null);
      if (!_tripleNotEquals) {
        _and = false;
      } else {
        Attributes _mainAttributes = merge.getMainAttributes();
        boolean _containsKey = _mainAttributes.containsKey(MergeableManifest.BUNDLE_ACTIVATOR);
        boolean _not = (!_containsKey);
        _and = _not;
      }
      if (_and) {
        Attributes _mainAttributes_1 = merge.getMainAttributes();
        TypeReference _activator_1 = manifest.getActivator();
        String _name = _activator_1.getName();
        _mainAttributes_1.put(MergeableManifest.BUNDLE_ACTIVATOR, _name);
      }
      boolean _isModified = merge.isModified();
      if (_isModified) {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        merge.write(out);
        String _path_1 = manifest.getPath();
        byte[] _byteArray = out.toByteArray();
        ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
        metaInf.generateFile(_path_1, _byteArrayInputStream);
      }
    } finally {
      if ((in != null)) {
        in.close();
      }
    }
  }
  
  protected void generateActivator() {
    boolean _and = false;
    IBundleProjectConfig _eclipsePlugin = this.projectConfig.getEclipsePlugin();
    IXtextGeneratorFileSystemAccess _srcGen = _eclipsePlugin.getSrcGen();
    boolean _tripleNotEquals = (_srcGen != null);
    if (!_tripleNotEquals) {
      _and = false;
    } else {
      boolean _isEmpty = this.languageConfigs.isEmpty();
      boolean _not = (!_isEmpty);
      _and = _not;
    }
    if (_and) {
      JavaFileAccess _createEclipsePluginActivator = this.templates.createEclipsePluginActivator(this.languageConfigs);
      IBundleProjectConfig _eclipsePlugin_1 = this.projectConfig.getEclipsePlugin();
      IXtextGeneratorFileSystemAccess _srcGen_1 = _eclipsePlugin_1.getSrcGen();
      _createEclipsePluginActivator.writeTo(_srcGen_1);
    }
  }
  
  protected void generatePluginXmls() {
    List<? extends ISubProjectConfig> _enabledProjects = this.projectConfig.getEnabledProjects();
    Iterable<BundleProjectConfig> _filter = Iterables.<BundleProjectConfig>filter(_enabledProjects, BundleProjectConfig.class);
    final Function1<BundleProjectConfig, Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess>> _function = new Function1<BundleProjectConfig, Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess>>() {
      @Override
      public Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess> apply(final BundleProjectConfig it) {
        PluginXmlAccess _pluginXml = it.getPluginXml();
        IXtextGeneratorFileSystemAccess _root = it.getRoot();
        return Pair.<PluginXmlAccess, IXtextGeneratorFileSystemAccess>of(_pluginXml, _root);
      }
    };
    Iterable<Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess>> _map = IterableExtensions.<BundleProjectConfig, Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess>>map(_filter, _function);
    final List<Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess>> pluginXmls = IterableExtensions.<Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess>>toList(_map);
    int _size = pluginXmls.size();
    final HashMap<URI, PluginXmlAccess> uri2PluginXml = Maps.<URI, PluginXmlAccess>newHashMapWithExpectedSize(_size);
    final ListIterator<Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess>> pluginXmlIter = pluginXmls.listIterator();
    while (pluginXmlIter.hasNext()) {
      {
        final Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess> entry = pluginXmlIter.next();
        final PluginXmlAccess pluginXml = entry.getKey();
        final IXtextGeneratorFileSystemAccess root = entry.getValue();
        if (((pluginXml == null) || (root == null))) {
          pluginXmlIter.remove();
        } else {
          String _path = pluginXml.getPath();
          final URI uri = root.getURI(_path);
          boolean _containsKey = uri2PluginXml.containsKey(uri);
          if (_containsKey) {
            PluginXmlAccess _get = uri2PluginXml.get(uri);
            _get.merge(pluginXml);
            pluginXmlIter.remove();
          } else {
            uri2PluginXml.put(uri, pluginXml);
          }
        }
      }
    }
    for (final Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess> entry : pluginXmls) {
      {
        final PluginXmlAccess pluginXml = entry.getKey();
        final IXtextGeneratorFileSystemAccess root = entry.getValue();
        String _path = pluginXml.getPath();
        boolean _isFile = root.isFile(_path);
        if (_isFile) {
          boolean _and = false;
          boolean _and_1 = false;
          List<CharSequence> _entries = pluginXml.getEntries();
          boolean _isEmpty = _entries.isEmpty();
          boolean _not = (!_isEmpty);
          if (!_not) {
            _and_1 = false;
          } else {
            String _path_1 = pluginXml.getPath();
            CharSequence _readTextFile = root.readTextFile(_path_1);
            CharSequence _content = pluginXml.getContent();
            boolean _notEquals = (!Objects.equal(_readTextFile, _content));
            _and_1 = _notEquals;
          }
          if (!_and_1) {
            _and = false;
          } else {
            String _path_2 = pluginXml.getPath();
            boolean _endsWith = _path_2.endsWith(".xml");
            _and = _endsWith;
          }
          if (_and) {
            String _path_3 = pluginXml.getPath();
            String _plus = (_path_3 + "_gen");
            pluginXml.setPath(_plus);
            pluginXml.writeTo(root);
          }
        } else {
          pluginXml.writeTo(root);
        }
      }
    }
  }
  
  private final static Logger LOG = Logger.getLogger(XtextGenerator.class);
  
  @Pure
  public DefaultGeneratorModule getConfiguration() {
    return this.configuration;
  }
  
  public void setConfiguration(final DefaultGeneratorModule configuration) {
    this.configuration = configuration;
  }
  
  @Pure
  public List<XtextGeneratorLanguage> getLanguageConfigs() {
    return this.languageConfigs;
  }
  
  @Pure
  public XtextDirectoryCleaner getCleaner() {
    return this.cleaner;
  }
  
  public void setCleaner(final XtextDirectoryCleaner cleaner) {
    this.cleaner = cleaner;
  }
  
  @Pure
  public XtextGeneratorStandaloneSetup getStandaloneSetup() {
    return this.standaloneSetup;
  }
  
  public void setStandaloneSetup(final XtextGeneratorStandaloneSetup standaloneSetup) {
    this.standaloneSetup = standaloneSetup;
  }
}
