/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.MergeableManifest2;
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
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.CompositeGeneratorException;
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
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.project.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;

/**
 * The Xtext language infrastructure generator. Use the {@code configuration} block to add general
 * configuration for your Xtext project and the generated code, e.g.
 * <pre>
 * configuration = {
 *     project = model.project.StandardProjectConfig {
 *         baseName = "org.example.language"
 *         rootPath = ".."
 *     }
 *     code = {
 *         encoding = 'ISO-8859-1'
 *     }
 * }
 * </pre>
 * You can generate code for one or more Xtext languages within the same project. For each language,
 * add a {@code language} block, e.g.
 * <pre>
 * language = StandardLanguage {
 *     name = "org.example.language.MyExampleLanguage"
 * }
 * </pre>
 * 
 * @noextend This class should not be extended by clients.
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
  
  @Accessors
  private String grammarEncoding;
  
  private Injector injector;
  
  @Inject
  private IXtextProjectConfig projectConfig;
  
  @Inject
  private XtextGeneratorTemplates templates;
  
  @Inject
  private XtextGeneratorNaming naming;
  
  @Inject
  private CodeConfig codeConfig;
  
  public XtextGenerator() {
    new XtextStandaloneSetup().createInjectorAndDoEMFRegistration();
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
        Iterable<GeneratedMetamodel> _filter = Iterables.<GeneratedMetamodel>filter(language.getGrammar().getMetamodelDeclarations(), GeneratedMetamodel.class);
        for (final GeneratedMetamodel generatedMetamodel : _filter) {
          {
            final String nsURI = generatedMetamodel.getEPackage().getNsURI();
            boolean _containsKey = uris.containsKey(nsURI);
            if (_containsKey) {
              String _name = uris.get(nsURI).getName();
              String _plus = ((("Duplicate generated grammar with nsURI \'" + nsURI) + "\' in ") + _name);
              String _plus_1 = (_plus + " and ");
              String _name_1 = language.getGrammar().getName();
              String _plus_2 = (_plus_1 + _name_1);
              generatorIssues.addError(_plus_2);
            } else {
              uris.put(nsURI, language.getGrammar());
            }
          }
        }
      }
    }
  }
  
  public void initialize() {
    if ((this.injector == null)) {
      XtextGenerator.LOG.info("Initializing Xtext generator");
      new StandaloneSetup().addRegisterGeneratedEPackage("org.eclipse.xtext.common.types.TypesPackage");
      this.initializeEncoding();
      this.injector = this.createInjector();
      this.injector.injectMembers(this);
      CodeConfig _instance = this.injector.<CodeConfig>getInstance(CodeConfig.class);
      final Procedure1<CodeConfig> _function = (CodeConfig it) -> {
        it.initialize(this.injector);
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
  
  protected void initializeEncoding() {
    final IResourceServiceProvider.Registry serviceProviderRegistry = IResourceServiceProvider.Registry.INSTANCE;
    Object _get = serviceProviderRegistry.getExtensionToFactoryMap().get("xtext");
    final IResourceServiceProvider serviceProvider = ((IResourceServiceProvider) _get);
    String _elvis = null;
    if (this.grammarEncoding != null) {
      _elvis = this.grammarEncoding;
    } else {
      String _encoding = this.configuration.getCode().getEncoding();
      _elvis = _encoding;
    }
    final String encoding = _elvis;
    if (((serviceProvider != null) && (encoding != null))) {
      final IEncodingProvider encodingProvider = serviceProvider.<IEncodingProvider>get(IEncodingProvider.class);
      if ((encodingProvider instanceof IEncodingProvider.Runtime)) {
        ((IEncodingProvider.Runtime)encodingProvider).setDefaultEncoding(encoding);
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
    try {
      this.cleaner.clean();
      for (final XtextGeneratorLanguage language : this.languageConfigs) {
        try {
          String _name = language.getGrammar().getName();
          String _plus = ("Generating " + _name);
          XtextGenerator.LOG.info(_plus);
          language.generate();
          this.generateSetups(language);
          this.generateModules(language);
          this.generateExecutableExtensionFactory(language);
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception e = (Exception)_t;
            this.handleException(e, issues);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      XtextGenerator.LOG.info("Generating common infrastructure");
      this.generatePluginXmls();
      this.generateManifests();
      this.generateActivator();
      this.generateServices();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        this.handleException(e, issues);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private void handleException(final Exception ex, final Issues issues) {
    if ((ex instanceof CompositeGeneratorException)) {
      final Consumer<Exception> _function = (Exception it) -> {
        this.handleException(it, issues);
      };
      ((CompositeGeneratorException)ex).getExceptions().forEach(_function);
    } else {
      issues.addError(this, "GeneratorException: ", null, ex, null);
    }
  }
  
  protected void generateSetups(final IXtextGeneratorLanguage language) {
    this.templates.createRuntimeGenSetup(language).writeTo(this.projectConfig.getRuntime().getSrcGen());
    this.templates.createRuntimeSetup(language).writeTo(this.projectConfig.getRuntime().getSrc());
    this.templates.createIdeSetup(language).writeTo(this.projectConfig.getGenericIde().getSrc());
    this.templates.createWebSetup(language).writeTo(this.projectConfig.getWeb().getSrc());
  }
  
  protected void generateModules(final IXtextGeneratorLanguage language) {
    this.templates.createRuntimeGenModule(language).writeTo(this.projectConfig.getRuntime().getSrcGen());
    this.templates.createRuntimeModule(language).writeTo(this.projectConfig.getRuntime().getSrc());
    this.templates.createIdeModule(language).writeTo(this.projectConfig.getGenericIde().getSrc());
    this.templates.createIdeGenModule(language).writeTo(this.projectConfig.getGenericIde().getSrcGen());
    this.templates.createEclipsePluginGenModule(language).writeTo(this.projectConfig.getEclipsePlugin().getSrcGen());
    this.templates.createEclipsePluginModule(language).writeTo(this.projectConfig.getEclipsePlugin().getSrc());
    this.templates.createIdeaGenModule(language).writeTo(this.projectConfig.getIdeaPlugin().getSrcGen());
    this.templates.createIdeaModule(language).writeTo(this.projectConfig.getIdeaPlugin().getSrc());
    this.templates.createWebGenModule(language).writeTo(this.projectConfig.getWeb().getSrcGen());
    this.templates.createWebModule(language).writeTo(this.projectConfig.getWeb().getSrc());
  }
  
  protected void generateExecutableExtensionFactory(final IXtextGeneratorLanguage language) {
    IXtextGeneratorFileSystemAccess _srcGen = this.projectConfig.getEclipsePlugin().getSrcGen();
    boolean _tripleNotEquals = (_srcGen != null);
    if (_tripleNotEquals) {
      this.templates.createEclipsePluginExecutableExtensionFactory(language, IterableExtensions.<XtextGeneratorLanguage>head(this.languageConfigs)).writeTo(this.projectConfig.getEclipsePlugin().getSrcGen());
    }
  }
  
  protected void generateManifests() {
    try {
      final Function1<BundleProjectConfig, Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String>> _function = (BundleProjectConfig it) -> {
        return Tuples.<ManifestAccess, IXtextGeneratorFileSystemAccess, String>create(it.getManifest(), it.getMetaInf(), it.getName());
      };
      final List<Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String>> manifests = IterableExtensions.<Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String>>toList(IterableExtensions.<BundleProjectConfig, Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String>>map(Iterables.<BundleProjectConfig>filter(this.projectConfig.getEnabledProjects(), BundleProjectConfig.class), _function));
      final HashMap<URI, ManifestAccess> uri2Manifest = Maps.<URI, ManifestAccess>newHashMapWithExpectedSize(manifests.size());
      final ListIterator<Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String>> manifestIter = manifests.listIterator();
      while (manifestIter.hasNext()) {
        {
          final Triple<ManifestAccess, IXtextGeneratorFileSystemAccess, String> entry = manifestIter.next();
          final ManifestAccess manifest = entry.getFirst();
          final IXtextGeneratorFileSystemAccess metaInf = entry.getSecond();
          if (((manifest == null) || (metaInf == null))) {
            manifestIter.remove();
          } else {
            if (((manifest.getActivator() == null) && (manifest == this.projectConfig.getEclipsePlugin().getManifest()))) {
              manifest.setActivator(this.naming.getEclipsePluginActivator());
            }
            final URI uri = metaInf.getURI(manifest.getPath());
            boolean _containsKey = uri2Manifest.containsKey(uri);
            if (_containsKey) {
              uri2Manifest.get(uri).merge(manifest);
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
            manifest.setBundleName(entry.getThird());
          }
          boolean _isFile = metaInf.isFile(manifest.getPath());
          if (_isFile) {
            boolean _isMerge = manifest.isMerge();
            if (_isMerge) {
              this.mergeManifest(manifest, metaInf);
            } else {
              boolean _endsWith = manifest.getPath().endsWith(".MF");
              if (_endsWith) {
                String _path = manifest.getPath();
                String _plus = (_path + "_gen");
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
      in = metaInf.readBinaryFile(manifest.getPath());
      String _bundleName = manifest.getBundleName();
      final MergeableManifest2 merge = new MergeableManifest2(in, _bundleName);
      merge.setLineDelimiter(this.codeConfig.getLineDelimiter());
      merge.addExportedPackages(manifest.getExportedPackages());
      merge.addRequiredBundles(manifest.getRequiredBundles());
      merge.addImportedPackages(manifest.getImportedPackages());
      if (((manifest.getActivator() != null) && StringExtensions.isNullOrEmpty(merge.getBundleActivator()))) {
        merge.setBundleActivator(manifest.getActivator().getName());
      }
      boolean _isModified = merge.isModified();
      if (_isModified) {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        merge.write(out);
        byte[] _byteArray = out.toByteArray();
        ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
        metaInf.generateFile(manifest.getPath(), _byteArrayInputStream);
      }
    } finally {
      if ((in != null)) {
        in.close();
      }
    }
  }
  
  protected void generateServices() {
    if (((this.projectConfig.getGenericIde().getSrcGen() == null) || this.languageConfigs.isEmpty())) {
      return;
    }
    final TextFileAccess file = new TextFileAccess();
    file.setPath("META-INF/services/org.eclipse.xtext.ISetup");
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          for(final XtextGeneratorLanguage lang : XtextGenerator.this.languageConfigs) {
            TypeReference _genericIdeSetup = XtextGenerator.this.naming.getGenericIdeSetup(lang.getGrammar());
            _builder.append(_genericIdeSetup);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    };
    file.setContent(_client);
    file.writeTo(this.projectConfig.getGenericIde().getSrcGen());
  }
  
  protected void generateActivator() {
    if (((this.projectConfig.getEclipsePlugin().getSrcGen() != null) && (!this.languageConfigs.isEmpty()))) {
      this.templates.createEclipsePluginActivator(this.projectConfig, this.languageConfigs).writeTo(this.projectConfig.getEclipsePlugin().getSrcGen());
    }
  }
  
  protected void generatePluginXmls() {
    final Function1<BundleProjectConfig, Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess>> _function = (BundleProjectConfig it) -> {
      PluginXmlAccess _pluginXml = it.getPluginXml();
      IXtextGeneratorFileSystemAccess _root = it.getRoot();
      return Pair.<PluginXmlAccess, IXtextGeneratorFileSystemAccess>of(_pluginXml, _root);
    };
    final List<Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess>> pluginXmls = IterableExtensions.<Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess>>toList(IterableExtensions.<BundleProjectConfig, Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess>>map(Iterables.<BundleProjectConfig>filter(this.projectConfig.getEnabledProjects(), BundleProjectConfig.class), _function));
    final HashMap<URI, PluginXmlAccess> uri2PluginXml = Maps.<URI, PluginXmlAccess>newHashMapWithExpectedSize(pluginXmls.size());
    final ListIterator<Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess>> pluginXmlIter = pluginXmls.listIterator();
    while (pluginXmlIter.hasNext()) {
      {
        final Pair<PluginXmlAccess, IXtextGeneratorFileSystemAccess> entry = pluginXmlIter.next();
        final PluginXmlAccess pluginXml = entry.getKey();
        final IXtextGeneratorFileSystemAccess root = entry.getValue();
        if (((pluginXml == null) || (root == null))) {
          pluginXmlIter.remove();
        } else {
          final URI uri = root.getURI(pluginXml.getPath());
          boolean _containsKey = uri2PluginXml.containsKey(uri);
          if (_containsKey) {
            uri2PluginXml.get(uri).merge(pluginXml);
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
        boolean _isFile = root.isFile(pluginXml.getPath());
        if (_isFile) {
          boolean _and = false;
          boolean _and_1 = false;
          boolean _isEmpty = pluginXml.getEntries().isEmpty();
          boolean _not = (!_isEmpty);
          if (!_not) {
            _and_1 = false;
          } else {
            CharSequence _readTextFile = root.readTextFile(pluginXml.getPath());
            String _string = null;
            if (_readTextFile!=null) {
              _string=_readTextFile.toString();
            }
            String _contentString = pluginXml.getContentString();
            boolean _notEquals = (!Objects.equal(_string, _contentString));
            _and_1 = _notEquals;
          }
          if (!_and_1) {
            _and = false;
          } else {
            boolean _endsWith = pluginXml.getPath().endsWith(".xml");
            _and = _endsWith;
          }
          if (_and) {
            String _path = pluginXml.getPath();
            String _plus = (_path + "_gen");
            pluginXml.setPath(_plus);
            pluginXml.writeTo(root);
          }
        } else {
          pluginXml.writeTo(root);
        }
      }
    }
  }
  
  private static final Logger LOG = Logger.getLogger(XtextGenerator.class);
  
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
  
  @Pure
  public String getGrammarEncoding() {
    return this.grammarEncoding;
  }
  
  public void setGrammarEncoding(final String grammarEncoding) {
    this.grammarEncoding = grammarEncoding;
  }
}
