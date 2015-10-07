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
import java.util.LinkedList;
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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.LanguageModule;
import org.eclipse.xtext.xtext.generator.MweIssues;
import org.eclipse.xtext.xtext.generator.XtextDirectoryCleaner;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.XtextGeneratorStandaloneSetup;
import org.eclipse.xtext.xtext.generator.XtextGeneratorTemplates;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

/**
 * The Xtext language infrastructure generator. Can be configured with {@link IGeneratorFragment2}
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
  private final List<LanguageConfig2> languageConfigs = CollectionLiterals.<LanguageConfig2>newArrayList();
  
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
  public void addLanguage(final LanguageConfig2 language) {
    this.languageConfigs.add(language);
  }
  
  @Override
  protected void checkConfigurationInternal(final Issues issues) {
    this.initialize();
    final MweIssues generatorIssues = new MweIssues(this, issues);
    this.configuration.checkConfiguration(generatorIssues);
    final HashMap<String, Grammar> uris = new HashMap<String, Grammar>();
    for (final LanguageConfig2 language : this.languageConfigs) {
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
      for (final LanguageConfig2 language : this.languageConfigs) {
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
  
  protected Injector createLanguageInjector(final Injector parent, final LanguageConfig2 language) {
    LanguageModule _languageModule = new LanguageModule(language);
    return parent.createChildInjector(_languageModule);
  }
  
  @Override
  protected void invokeInternal(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {
    this.initialize();
    this.cleaner.clean();
    for (final LanguageConfig2 language : this.languageConfigs) {
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
  
  protected void generateSetups(final ILanguageConfig language) {
    JavaFileAccess _createRuntimeGenSetup = this.templates.createRuntimeGenSetup(language);
    IXtextGeneratorFileSystemAccess _runtimeSrcGen = this.projectConfig.getRuntimeSrcGen();
    _createRuntimeGenSetup.writeTo(_runtimeSrcGen);
    JavaFileAccess _createRuntimeSetup = this.templates.createRuntimeSetup(language);
    IXtextGeneratorFileSystemAccess _runtimeSrc = this.projectConfig.getRuntimeSrc();
    _createRuntimeSetup.writeTo(_runtimeSrc);
    JavaFileAccess _createWebSetup = this.templates.createWebSetup(language);
    IXtextGeneratorFileSystemAccess _webSrc = this.projectConfig.getWebSrc();
    _createWebSetup.writeTo(_webSrc);
  }
  
  protected void generateModules(final ILanguageConfig language) {
    JavaFileAccess _createRuntimeGenModule = this.templates.createRuntimeGenModule(language);
    IXtextGeneratorFileSystemAccess _runtimeSrcGen = this.projectConfig.getRuntimeSrcGen();
    _createRuntimeGenModule.writeTo(_runtimeSrcGen);
    JavaFileAccess _createRuntimeModule = this.templates.createRuntimeModule(language);
    IXtextGeneratorFileSystemAccess _runtimeSrc = this.projectConfig.getRuntimeSrc();
    _createRuntimeModule.writeTo(_runtimeSrc);
    JavaFileAccess _createEclipsePluginGenModule = this.templates.createEclipsePluginGenModule(language);
    IXtextGeneratorFileSystemAccess _eclipsePluginSrcGen = this.projectConfig.getEclipsePluginSrcGen();
    _createEclipsePluginGenModule.writeTo(_eclipsePluginSrcGen);
    JavaFileAccess _createEclipsePluginModule = this.templates.createEclipsePluginModule(language);
    IXtextGeneratorFileSystemAccess _eclipsePluginSrc = this.projectConfig.getEclipsePluginSrc();
    _createEclipsePluginModule.writeTo(_eclipsePluginSrc);
    JavaFileAccess _createIdeaGenModule = this.templates.createIdeaGenModule(language);
    IXtextGeneratorFileSystemAccess _ideaPluginSrcGen = this.projectConfig.getIdeaPluginSrcGen();
    _createIdeaGenModule.writeTo(_ideaPluginSrcGen);
    JavaFileAccess _createIdeaModule = this.templates.createIdeaModule(language);
    IXtextGeneratorFileSystemAccess _ideaPluginSrc = this.projectConfig.getIdeaPluginSrc();
    _createIdeaModule.writeTo(_ideaPluginSrc);
    JavaFileAccess _createWebGenModule = this.templates.createWebGenModule(language);
    IXtextGeneratorFileSystemAccess _webSrcGen = this.projectConfig.getWebSrcGen();
    _createWebGenModule.writeTo(_webSrcGen);
    JavaFileAccess _createWebModule = this.templates.createWebModule(language);
    IXtextGeneratorFileSystemAccess _webSrc = this.projectConfig.getWebSrc();
    _createWebModule.writeTo(_webSrc);
  }
  
  protected void generateExecutableExtensionFactory(final ILanguageConfig language) {
    IXtextGeneratorFileSystemAccess _eclipsePluginSrcGen = this.projectConfig.getEclipsePluginSrcGen();
    boolean _tripleNotEquals = (_eclipsePluginSrcGen != null);
    if (_tripleNotEquals) {
      LanguageConfig2 _head = IterableExtensions.<LanguageConfig2>head(this.languageConfigs);
      JavaFileAccess _createEclipsePluginExecutableExtensionFactory = this.templates.createEclipsePluginExecutableExtensionFactory(language, _head);
      IXtextGeneratorFileSystemAccess _eclipsePluginSrcGen_1 = this.projectConfig.getEclipsePluginSrcGen();
      _createEclipsePluginExecutableExtensionFactory.writeTo(_eclipsePluginSrcGen_1);
    }
  }
  
  protected void generateManifests() {
    try {
      ManifestAccess _runtimeManifest = this.projectConfig.getRuntimeManifest();
      IXtextGeneratorFileSystemAccess _runtimeMetaInf = this.projectConfig.getRuntimeMetaInf();
      String _runtimeProjectName = this.projectConfig.getRuntimeProjectName();
      Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String> _create = Tuples.<ManifestAccess, IXtextGeneratorFileSystemAccess, String>create(_runtimeManifest, _runtimeMetaInf, _runtimeProjectName);
      ManifestAccess _runtimeTestManifest = this.projectConfig.getRuntimeTestManifest();
      IXtextGeneratorFileSystemAccess _runtimeTestMetaInf = this.projectConfig.getRuntimeTestMetaInf();
      String _runtimeTestProjectName = this.projectConfig.getRuntimeTestProjectName();
      Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String> _create_1 = Tuples.<ManifestAccess, IXtextGeneratorFileSystemAccess, String>create(_runtimeTestManifest, _runtimeTestMetaInf, _runtimeTestProjectName);
      ManifestAccess _genericIdeManifest = this.projectConfig.getGenericIdeManifest();
      IXtextGeneratorFileSystemAccess _genericIdeMetaInf = this.projectConfig.getGenericIdeMetaInf();
      String _genericIdeProjectName = this.projectConfig.getGenericIdeProjectName();
      Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String> _create_2 = Tuples.<ManifestAccess, IXtextGeneratorFileSystemAccess, String>create(_genericIdeManifest, _genericIdeMetaInf, _genericIdeProjectName);
      ManifestAccess _genericIdeTestManifest = this.projectConfig.getGenericIdeTestManifest();
      IXtextGeneratorFileSystemAccess _genericIdeTestMetaInf = this.projectConfig.getGenericIdeTestMetaInf();
      String _genericIdeTestProjectName = this.projectConfig.getGenericIdeTestProjectName();
      Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String> _create_3 = Tuples.<ManifestAccess, IXtextGeneratorFileSystemAccess, String>create(_genericIdeTestManifest, _genericIdeTestMetaInf, _genericIdeTestProjectName);
      ManifestAccess _eclipsePluginManifest = this.projectConfig.getEclipsePluginManifest();
      IXtextGeneratorFileSystemAccess _eclipsePluginMetaInf = this.projectConfig.getEclipsePluginMetaInf();
      String _eclipsePluginProjectName = this.projectConfig.getEclipsePluginProjectName();
      Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String> _create_4 = Tuples.<ManifestAccess, IXtextGeneratorFileSystemAccess, String>create(_eclipsePluginManifest, _eclipsePluginMetaInf, _eclipsePluginProjectName);
      ManifestAccess _eclipsePluginTestManifest = this.projectConfig.getEclipsePluginTestManifest();
      IXtextGeneratorFileSystemAccess _eclipsePluginTestMetaInf = this.projectConfig.getEclipsePluginTestMetaInf();
      String _eclipsePluginTestProjectName = this.projectConfig.getEclipsePluginTestProjectName();
      Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String> _create_5 = Tuples.<ManifestAccess, IXtextGeneratorFileSystemAccess, String>create(_eclipsePluginTestManifest, _eclipsePluginTestMetaInf, _eclipsePluginTestProjectName);
      ManifestAccess _ideaPluginManifest = this.projectConfig.getIdeaPluginManifest();
      IXtextGeneratorFileSystemAccess _ideaPluginMetaInf = this.projectConfig.getIdeaPluginMetaInf();
      String _ideaPluginProjectName = this.projectConfig.getIdeaPluginProjectName();
      Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String> _create_6 = Tuples.<ManifestAccess, IXtextGeneratorFileSystemAccess, String>create(_ideaPluginManifest, _ideaPluginMetaInf, _ideaPluginProjectName);
      ManifestAccess _ideaPluginTestManifest = this.projectConfig.getIdeaPluginTestManifest();
      IXtextGeneratorFileSystemAccess _ideaPluginTestMetaInf = this.projectConfig.getIdeaPluginTestMetaInf();
      String _ideaPluginTestProjectName = this.projectConfig.getIdeaPluginTestProjectName();
      Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String> _create_7 = Tuples.<ManifestAccess, IXtextGeneratorFileSystemAccess, String>create(_ideaPluginTestManifest, _ideaPluginTestMetaInf, _ideaPluginTestProjectName);
      ManifestAccess _webManifest = this.projectConfig.getWebManifest();
      IXtextGeneratorFileSystemAccess _webMetaInf = this.projectConfig.getWebMetaInf();
      String _webProjectName = this.projectConfig.getWebProjectName();
      Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String> _create_8 = Tuples.<ManifestAccess, IXtextGeneratorFileSystemAccess, String>create(_webManifest, _webMetaInf, _webProjectName);
      ManifestAccess _webTestManifest = this.projectConfig.getWebTestManifest();
      IXtextGeneratorFileSystemAccess _webTestMetaInf = this.projectConfig.getWebTestMetaInf();
      String _webTestProjectName = this.projectConfig.getWebTestProjectName();
      Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String> _create_9 = Tuples.<ManifestAccess, IXtextGeneratorFileSystemAccess, String>create(_webTestManifest, _webTestMetaInf, _webTestProjectName);
      final LinkedList<Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String>> manifests = CollectionLiterals.<Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String>>newLinkedList(_create, _create_1, _create_2, _create_3, _create_4, _create_5, _create_6, _create_7, _create_8, _create_9);
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
          ManifestAccess _eclipsePluginManifest_1 = this.projectConfig.getEclipsePluginManifest();
          boolean _tripleEquals_1 = (manifest == _eclipsePluginManifest_1);
          if (_tripleEquals_1) {
            final LanguageConfig2 firstLanguage = IterableExtensions.<LanguageConfig2>head(this.languageConfigs);
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
    IXtextGeneratorFileSystemAccess _eclipsePluginSrcGen = this.projectConfig.getEclipsePluginSrcGen();
    boolean _tripleNotEquals = (_eclipsePluginSrcGen != null);
    if (!_tripleNotEquals) {
      _and = false;
    } else {
      boolean _isEmpty = this.languageConfigs.isEmpty();
      boolean _not = (!_isEmpty);
      _and = _not;
    }
    if (_and) {
      JavaFileAccess _createEclipsePluginActivator = this.templates.createEclipsePluginActivator(this.languageConfigs);
      IXtextGeneratorFileSystemAccess _eclipsePluginSrcGen_1 = this.projectConfig.getEclipsePluginSrcGen();
      _createEclipsePluginActivator.writeTo(_eclipsePluginSrcGen_1);
    }
  }
  
  protected void generatePluginXmls() {
    PluginXmlAccess _runtimePluginXml = this.projectConfig.getRuntimePluginXml();
    IXtextGeneratorFileSystemAccess _runtimeRoot = this.projectConfig.getRuntimeRoot();
    Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess> _mappedTo = Pair.<PluginXmlAccess, IXtextGeneratorFileSystemAccess>of(_runtimePluginXml, _runtimeRoot);
    PluginXmlAccess _runtimeTestPluginXml = this.projectConfig.getRuntimeTestPluginXml();
    IXtextGeneratorFileSystemAccess _runtimeTestRoot = this.projectConfig.getRuntimeTestRoot();
    Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess> _mappedTo_1 = Pair.<PluginXmlAccess, IXtextGeneratorFileSystemAccess>of(_runtimeTestPluginXml, _runtimeTestRoot);
    PluginXmlAccess _genericIdePluginXml = this.projectConfig.getGenericIdePluginXml();
    IXtextGeneratorFileSystemAccess _genericIdeRoot = this.projectConfig.getGenericIdeRoot();
    Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess> _mappedTo_2 = Pair.<PluginXmlAccess, IXtextGeneratorFileSystemAccess>of(_genericIdePluginXml, _genericIdeRoot);
    PluginXmlAccess _genericIdeTestPluginXml = this.projectConfig.getGenericIdeTestPluginXml();
    IXtextGeneratorFileSystemAccess _genericIdeTestRoot = this.projectConfig.getGenericIdeTestRoot();
    Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess> _mappedTo_3 = Pair.<PluginXmlAccess, IXtextGeneratorFileSystemAccess>of(_genericIdeTestPluginXml, _genericIdeTestRoot);
    PluginXmlAccess _eclipsePluginPluginXml = this.projectConfig.getEclipsePluginPluginXml();
    IXtextGeneratorFileSystemAccess _eclipsePluginRoot = this.projectConfig.getEclipsePluginRoot();
    Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess> _mappedTo_4 = Pair.<PluginXmlAccess, IXtextGeneratorFileSystemAccess>of(_eclipsePluginPluginXml, _eclipsePluginRoot);
    PluginXmlAccess _eclipsePluginTestPluginXml = this.projectConfig.getEclipsePluginTestPluginXml();
    IXtextGeneratorFileSystemAccess _eclipsePluginTestRoot = this.projectConfig.getEclipsePluginTestRoot();
    Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess> _mappedTo_5 = Pair.<PluginXmlAccess, IXtextGeneratorFileSystemAccess>of(_eclipsePluginTestPluginXml, _eclipsePluginTestRoot);
    final LinkedList<Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess>> pluginXmls = CollectionLiterals.<Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess>>newLinkedList(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5);
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
  public List<LanguageConfig2> getLanguageConfigs() {
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
