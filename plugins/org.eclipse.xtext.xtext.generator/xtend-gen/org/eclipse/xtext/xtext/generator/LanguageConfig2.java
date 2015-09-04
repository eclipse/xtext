/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.RuleNames;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.ecore.EcoreSupportStandaloneSetup;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.CompositeGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.IGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.StandaloneSetupAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector;

@Log
@SuppressWarnings("all")
public class LanguageConfig2 extends CompositeGeneratorFragment2 implements ILanguageConfig {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String uri;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private Grammar grammar;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private RuleNames ruleNames;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private List<String> fileExtensions;
  
  @Accessors
  private ResourceSet resourceSet;
  
  @Accessors
  private Module guiceModule = new Module() {
    @Override
    public void configure(final Binder it) {
    }
  };
  
  @Accessors
  @Extension
  private XtextGeneratorNaming naming = new XtextGeneratorNaming();
  
  @Accessors
  private final List<String> loadedResources = CollectionLiterals.<String>newArrayList();
  
  @Accessors
  private final StandaloneSetupAccess runtimeGenSetup = new StandaloneSetupAccess();
  
  @Accessors
  private final GuiceModuleAccess runtimeGenModule = new GuiceModuleAccess();
  
  @Accessors
  private final GuiceModuleAccess eclipsePluginGenModule = new GuiceModuleAccess();
  
  @Accessors
  private final GuiceModuleAccess ideaGenModule = new GuiceModuleAccess();
  
  @Accessors
  private final GuiceModuleAccess webGenModule = new GuiceModuleAccess();
  
  @Inject
  private Provider<ResourceSet> resourceSetProvider;
  
  @Inject
  private IXtextProjectConfig projectConfig;
  
  @Inject
  @Extension
  private XbaseUsageDetector _xbaseUsageDetector;
  
  @Mandatory
  public void setUri(final String uri) {
    this.uri = uri;
  }
  
  public void setFileExtensions(final String fileExtensions) {
    String _trim = fileExtensions.trim();
    String[] _split = _trim.split("\\s*,\\s*");
    List<String> _list = IterableExtensions.<String>toList(((Iterable<String>)Conversions.doWrapArray(_split)));
    this.fileExtensions = _list;
  }
  
  @Override
  public List<String> getFileExtensions() {
    boolean _or = false;
    if ((this.fileExtensions == null)) {
      _or = true;
    } else {
      boolean _isEmpty = this.fileExtensions.isEmpty();
      _or = _isEmpty;
    }
    if (_or) {
      String _simpleName = GrammarUtil.getSimpleName(this.grammar);
      final String lowerCase = _simpleName.toLowerCase();
      LanguageConfig2.LOG.info((("No explicit fileExtensions configured. Using \'*." + lowerCase) + "\'."));
      return Collections.<String>singletonList(lowerCase);
    }
    return this.fileExtensions;
  }
  
  public void addLoadedResource(final String uri) {
    this.loadedResources.add(uri);
  }
  
  @Override
  public void initialize(final Injector injector) {
    injector.injectMembers(this);
    if ((this.resourceSet == null)) {
      ResourceSet _get = this.resourceSetProvider.get();
      this.resourceSet = _get;
    }
    for (final String loadedResource : this.loadedResources) {
      {
        final URI loadedResourceUri = URI.createURI(loadedResource);
        String _fileExtension = loadedResourceUri.fileExtension();
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(_fileExtension, "genmodel")) {
            _matched=true;
            final IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResourceUri);
            if ((resourceServiceProvider == null)) {
              try {
                final Class<?> genModelSupport = Class.forName("org.eclipse.emf.codegen.ecore.xtext.GenModelSupport");
                final Object instance = genModelSupport.newInstance();
                Method _declaredMethod = genModelSupport.getDeclaredMethod("createInjectorAndDoEMFRegistration");
                _declaredMethod.invoke(instance);
              } catch (final Throwable _t) {
                if (_t instanceof ClassNotFoundException) {
                  final ClassNotFoundException e = (ClassNotFoundException)_t;
                  LanguageConfig2.LOG.error("Couldn\'t initialize GenModel support. Is it on the classpath?");
                  String _message = e.getMessage();
                  LanguageConfig2.LOG.debug(_message, e);
                } else if (_t instanceof Exception) {
                  final Exception e_1 = (Exception)_t;
                  LanguageConfig2.LOG.error("Couldn\'t initialize GenModel support.", e_1);
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
            }
          }
        }
        if (!_matched) {
          if (Objects.equal(_fileExtension, "ecore")) {
            _matched=true;
            final IResourceServiceProvider resourceServiceProvider_1 = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResourceUri);
            if ((resourceServiceProvider_1 == null)) {
              EcoreSupportStandaloneSetup.setup();
            }
          }
        }
        if (!_matched) {
          if (Objects.equal(_fileExtension, "xcore")) {
            _matched=true;
            final IResourceServiceProvider resourceServiceProvider_2 = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(loadedResourceUri);
            if ((resourceServiceProvider_2 == null)) {
              try {
                final Class<?> xcore = Class.forName("org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup");
                Method _declaredMethod_1 = xcore.getDeclaredMethod("doSetup", new Class[] {});
                _declaredMethod_1.invoke(null);
              } catch (final Throwable _t_1) {
                if (_t_1 instanceof ClassNotFoundException) {
                  final ClassNotFoundException e_2 = (ClassNotFoundException)_t_1;
                  LanguageConfig2.LOG.error("Couldn\'t initialize Xcore support. Is it on the classpath?");
                  String _message_1 = e_2.getMessage();
                  LanguageConfig2.LOG.debug(_message_1, e_2);
                } else if (_t_1 instanceof Exception) {
                  final Exception e_3 = (Exception)_t_1;
                  LanguageConfig2.LOG.error("Couldn\'t initialize Xcore support.", e_3);
                } else {
                  throw Exceptions.sneakyThrow(_t_1);
                }
              }
            }
            final URI xcoreLangURI = URI.createPlatformResourceURI("/org.eclipse.emf.ecore.xcore.lib/model/XcoreLang.xcore", true);
            try {
              this.resourceSet.getResource(xcoreLangURI, true);
            } catch (final Throwable _t_2) {
              if (_t_2 instanceof WrappedException) {
                final WrappedException e_4 = (WrappedException)_t_2;
                LanguageConfig2.LOG.error("Could not load XcoreLang.xcore.", e_4);
                final Resource brokenResource = this.resourceSet.getResource(xcoreLangURI, false);
                EList<Resource> _resources = this.resourceSet.getResources();
                _resources.remove(brokenResource);
              } else {
                throw Exceptions.sneakyThrow(_t_2);
              }
            }
          }
        }
        this.resourceSet.getResource(loadedResourceUri, true);
      }
    }
    EList<Resource> _resources = this.resourceSet.getResources();
    boolean _isEmpty = _resources.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.installIndex();
      {
        int i = 0;
        EList<Resource> _resources_1 = this.resourceSet.getResources();
        int size = _resources_1.size();
        boolean _while = (i < size);
        while (_while) {
          {
            EList<Resource> _resources_2 = this.resourceSet.getResources();
            final Resource res = _resources_2.get(i);
            EList<EObject> _contents = res.getContents();
            boolean _isEmpty_1 = _contents.isEmpty();
            if (_isEmpty_1) {
              URI _uRI = res.getURI();
              String _plus = ("Error loading \'" + _uRI);
              String _plus_1 = (_plus + "\'");
              LanguageConfig2.LOG.error(_plus_1);
            } else {
              EList<Resource.Diagnostic> _errors = res.getErrors();
              boolean _isEmpty_2 = _errors.isEmpty();
              boolean _not_1 = (!_isEmpty_2);
              if (_not_1) {
                URI _uRI_1 = res.getURI();
                String _plus_2 = ("Error loading \'" + _uRI_1);
                String _plus_3 = (_plus_2 + "\':\n");
                Joiner _on = Joiner.on("\n");
                EList<Resource.Diagnostic> _errors_1 = res.getErrors();
                String _join = _on.join(_errors_1);
                String _plus_4 = (_plus_3 + _join);
                LanguageConfig2.LOG.error(_plus_4);
              }
            }
          }
          i++;
          _while = (i < size);
        }
      }
      EcoreUtil.resolveAll(this.resourceSet);
    }
    URI _createURI = URI.createURI(this.uri);
    Resource _resource = this.resourceSet.getResource(_createURI, true);
    final XtextResource resource = ((XtextResource) _resource);
    EList<EObject> _contents = resource.getContents();
    boolean _isEmpty_1 = _contents.isEmpty();
    if (_isEmpty_1) {
      throw new IllegalArgumentException((("Couldn\'t load grammar for \'" + this.uri) + "\'."));
    }
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    boolean _isEmpty_2 = _errors.isEmpty();
    boolean _not_1 = (!_isEmpty_2);
    if (_not_1) {
      EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
      LanguageConfig2.LOG.error(_errors_1);
      Joiner _on = Joiner.on("\n");
      EList<Resource.Diagnostic> _errors_2 = resource.getErrors();
      String _join = _on.join(_errors_2);
      String _plus = ((("Problem parsing \'" + this.uri) + "\':\n") + _join);
      throw new IllegalStateException(_plus);
    }
    EList<EObject> _contents_1 = resource.getContents();
    EObject _get_1 = _contents_1.get(0);
    final Grammar grammar = ((Grammar) _get_1);
    this.validateGrammar(grammar);
    this.grammar = grammar;
    RuleNames _ruleNames = RuleNames.getRuleNames(grammar, true);
    this.ruleNames = _ruleNames;
    this.naming.setGrammar(grammar);
    List<IGeneratorFragment2> _fragments = this.getFragments();
    for (final IGeneratorFragment2 fragment : _fragments) {
      fragment.initialize(injector);
    }
  }
  
  private void installIndex() {
    List<IResourceDescription> _emptyList = Collections.<IResourceDescription>emptyList();
    final ResourceDescriptionsData index = new ResourceDescriptionsData(_emptyList);
    EList<Resource> _resources = this.resourceSet.getResources();
    final ArrayList<Resource> resources = Lists.<Resource>newArrayList(_resources);
    for (final Resource resource : resources) {
      URI _uRI = resource.getURI();
      this.index(resource, _uRI, index);
    }
    ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(this.resourceSet, index);
  }
  
  private void index(final Resource resource, final URI uri, final ResourceDescriptionsData index) {
    final IResourceServiceProvider serviceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri);
    boolean _notEquals = (!Objects.equal(serviceProvider, null));
    if (_notEquals) {
      IResourceDescription.Manager _resourceDescriptionManager = serviceProvider.getResourceDescriptionManager();
      final IResourceDescription resourceDescription = _resourceDescriptionManager.getResourceDescription(resource);
      boolean _notEquals_1 = (!Objects.equal(resourceDescription, null));
      if (_notEquals_1) {
        index.addDescription(uri, resourceDescription);
      }
    }
  }
  
  protected void validateGrammar(final Grammar grammar) {
    this.validateAllImports(grammar);
    final EValidator validator = EValidator.Registry.INSTANCE.getEValidator(XtextPackage.eINSTANCE);
    if ((validator != null)) {
      final DiagnosticChain chain = new DiagnosticChain() {
        @Override
        public void add(final Diagnostic diagnostic) {
          int _severity = diagnostic.getSeverity();
          boolean _equals = (_severity == Diagnostic.ERROR);
          if (_equals) {
            Throwable _exception = diagnostic.getException();
            boolean _equals_1 = Objects.equal(_exception, null);
            if (_equals_1) {
              String _message = diagnostic.getMessage();
              throw new IllegalStateException(_message);
            } else {
              String _message_1 = diagnostic.getMessage();
              Throwable _exception_1 = diagnostic.getException();
              throw new IllegalStateException(_message_1, _exception_1);
            }
          }
        }
        
        @Override
        public void addAll(final Diagnostic diagnostic) {
          this.add(diagnostic);
        }
        
        @Override
        public void merge(final Diagnostic diagnostic) {
          throw new UnsupportedOperationException();
        }
      };
      validator.validate(grammar, chain, null);
      final TreeIterator<EObject> iterator = grammar.eAllContents();
      while (iterator.hasNext()) {
        EObject _next = iterator.next();
        HashMap<Object, Object> _hashMap = new HashMap<Object, Object>();
        validator.validate(_next, chain, _hashMap);
      }
    }
  }
  
  protected void validateAllImports(final Grammar grammar) {
    List<AbstractMetamodelDeclaration> _allMetamodelDeclarations = GrammarUtil.allMetamodelDeclarations(grammar);
    for (final AbstractMetamodelDeclaration amd : _allMetamodelDeclarations) {
      if ((amd instanceof ReferencedMetamodel)) {
        this.validateReferencedMetamodel(((ReferencedMetamodel)amd));
      }
    }
  }
  
  protected void validateReferencedMetamodel(final ReferencedMetamodel ref) {
    boolean _and = false;
    EPackage _ePackage = ref.getEPackage();
    boolean _notEquals = (!Objects.equal(_ePackage, null));
    if (!_notEquals) {
      _and = false;
    } else {
      EPackage _ePackage_1 = ref.getEPackage();
      boolean _eIsProxy = _ePackage_1.eIsProxy();
      boolean _not = (!_eIsProxy);
      _and = _not;
    }
    if (_and) {
      return;
    }
    final EReference eref = XtextPackage.Literals.ABSTRACT_METAMODEL_DECLARATION__EPACKAGE;
    final List<INode> nodes = NodeModelUtils.findNodesForFeature(ref, eref);
    String _xifexpression = null;
    boolean _isEmpty = nodes.isEmpty();
    if (_isEmpty) {
      _xifexpression = "(unknown)";
    } else {
      INode _get = nodes.get(0);
      _xifexpression = NodeModelUtils.getTokenText(_get);
    }
    final String refName = _xifexpression;
    Grammar _grammar = GrammarUtil.getGrammar(ref);
    final String grammarName = _grammar.getName();
    final String msg = ((((("The EPackage " + refName) + " in grammar ") + grammarName) + " could not be found. ") + "You might want to register that EPackage in your workflow file.");
    throw new IllegalStateException(msg);
  }
  
  @Override
  public void generate() {
    this.addImplicitContributions();
    super.generate();
  }
  
  protected void addImplicitContributions() {
    ManifestAccess _runtimeManifest = this.projectConfig.getRuntimeManifest();
    boolean _tripleNotEquals = (_runtimeManifest != null);
    if (_tripleNotEquals) {
      ManifestAccess _runtimeManifest_1 = this.projectConfig.getRuntimeManifest();
      Set<String> _requiredBundles = _runtimeManifest_1.getRequiredBundles();
      _requiredBundles.addAll(
        Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.xtext", "org.eclipse.xtext.util")));
      ManifestAccess _runtimeManifest_2 = this.projectConfig.getRuntimeManifest();
      Set<String> _importedPackages = _runtimeManifest_2.getImportedPackages();
      _importedPackages.add("org.apache.log4j");
    }
    ManifestAccess _eclipsePluginManifest = this.projectConfig.getEclipsePluginManifest();
    boolean _tripleNotEquals_1 = (_eclipsePluginManifest != null);
    if (_tripleNotEquals_1) {
      ManifestAccess _eclipsePluginManifest_1 = this.projectConfig.getEclipsePluginManifest();
      Set<String> _requiredBundles_1 = _eclipsePluginManifest_1.getRequiredBundles();
      _requiredBundles_1.addAll(
        Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.xtext.ui", "org.eclipse.xtext.ui.shared", "org.eclipse.ui.editors", "org.eclipse.ui")));
    }
    PluginXmlAccess _eclipsePluginPluginXml = this.projectConfig.getEclipsePluginPluginXml();
    boolean _tripleNotEquals_2 = (_eclipsePluginPluginXml != null);
    if (_tripleNotEquals_2) {
      PluginXmlAccess _eclipsePluginPluginXml_1 = this.projectConfig.getEclipsePluginPluginXml();
      List<CharSequence> _entries = _eclipsePluginPluginXml_1.getEntries();
      CharSequence _implicitPluginXmlEnties = this.getImplicitPluginXmlEnties(this.grammar);
      _entries.add(_implicitPluginXmlEnties);
    }
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.shared.Access");
        _builder.append(_typeRef, "");
        _builder.append(".getJavaProjectsState()");
      }
    };
    final StringConcatenationClient expression = _client;
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef = TypeReference.typeRef(IAllContainersState.class);
    final GuiceModuleAccess.BindingFactory bindingFactory = _bindingFactory.addTypeToProviderInstance(_typeRef, expression);
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(this.grammar);
    if (_inheritsXbase) {
      TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.XtextEditor");
      TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.xtext.xbase.ui.editor.XbaseEditor");
      GuiceModuleAccess.BindingFactory _addTypeToType = bindingFactory.addTypeToType(_typeRef_1, _typeRef_2);
      TypeReference _typeRef_3 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.model.XtextDocumentProvider");
      TypeReference _typeRef_4 = TypeReference.typeRef("org.eclipse.xtext.xbase.ui.editor.XbaseDocumentProvider");
      GuiceModuleAccess.BindingFactory _addTypeToType_1 = _addTypeToType.addTypeToType(_typeRef_3, _typeRef_4);
      TypeReference _typeRef_5 = TypeReference.typeRef("org.eclipse.xtext.ui.generator.trace.OpenGeneratedFileHandler");
      TypeReference _typeRef_6 = TypeReference.typeRef("org.eclipse.xtext.xbase.ui.generator.trace.XbaseOpenGeneratedFileHandler");
      _addTypeToType_1.addTypeToType(_typeRef_5, _typeRef_6);
    }
    bindingFactory.contributeTo(this.eclipsePluginGenModule);
  }
  
  public CharSequence getImplicitPluginXmlEnties(final Grammar it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("point=\"org.eclipse.ui.editors\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<editor");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("class=\"");
    TypeReference _eclipsePluginExecutableExtensionFactory = this.naming.getEclipsePluginExecutableExtensionFactory(it);
    _builder.append(_eclipsePluginExecutableExtensionFactory, "\t\t");
    _builder.append(":org.eclipse.xtext.ui.editor.XtextEditor\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("contributorClass=\"org.eclipse.ui.editors.text.TextEditorActionContributor\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("default=\"true\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("extensions=\"");
    String _join = IterableExtensions.join(this.fileExtensions, ",");
    _builder.append(_join, "\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("id=\"");
    String _name = it.getName();
    _builder.append(_name, "\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    {
      boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(this.grammar);
      if (_inheritsXbase) {
        _builder.append("\t\t");
        _builder.append("matchingStrategy=\"");
        TypeReference _eclipsePluginExecutableExtensionFactory_1 = this.naming.getEclipsePluginExecutableExtensionFactory(it);
        _builder.append(_eclipsePluginExecutableExtensionFactory_1, "\t\t");
        _builder.append(":org.eclipse.xtext.xbase.ui.editor.JavaEditorInputMatcher\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("name=\"");
    _builder.append(" Editor\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</editor>");
    _builder.newLine();
    _builder.append("</extension>");
    _builder.newLine();
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("point=\"org.eclipse.ui.handlers\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<handler");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("class=\"");
    TypeReference _eclipsePluginExecutableExtensionFactory_2 = this.naming.getEclipsePluginExecutableExtensionFactory(it);
    _builder.append(_eclipsePluginExecutableExtensionFactory_2, "\t\t");
    _builder.append(":org.eclipse.xtext.ui.editor.hyperlinking.OpenDeclarationHandler\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("commandId=\"org.eclipse.xtext.ui.editor.hyperlinking.OpenDeclaration\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<activeWhen>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<reference");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("definitionId=\"");
    String _name_1 = it.getName();
    _builder.append(_name_1, "\t\t\t\t");
    _builder.append(".Editor.opened\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("</reference>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</activeWhen>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</handler>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<handler");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("class=\"");
    TypeReference _eclipsePluginExecutableExtensionFactory_3 = this.naming.getEclipsePluginExecutableExtensionFactory(it);
    _builder.append(_eclipsePluginExecutableExtensionFactory_3, "\t\t");
    _builder.append(":org.eclipse.xtext.ui.editor.handler.ValidateActionHandler\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("commandId=\"");
    String _name_2 = it.getName();
    _builder.append(_name_2, "\t\t");
    _builder.append(".validate\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<activeWhen>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<reference");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("definitionId=\"");
    String _name_3 = it.getName();
    _builder.append(_name_3, "\t\t\t\t");
    _builder.append(".Editor.opened\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("</reference>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</activeWhen>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</handler>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<!-- copy qualified name -->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<handler");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("class=\"");
    TypeReference _eclipsePluginExecutableExtensionFactory_4 = this.naming.getEclipsePluginExecutableExtensionFactory(it);
    _builder.append(_eclipsePluginExecutableExtensionFactory_4, "\t\t");
    _builder.append(":org.eclipse.xtext.ui.editor.copyqualifiedname.EditorCopyQualifiedNameHandler\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("commandId=\"org.eclipse.xtext.ui.editor.copyqualifiedname.EditorCopyQualifiedName\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<activeWhen>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<reference definitionId=\"");
    String _name_4 = it.getName();
    _builder.append(_name_4, "\t\t\t");
    _builder.append(".Editor.opened\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("</activeWhen>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</handler>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<handler");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("class=\"");
    TypeReference _eclipsePluginExecutableExtensionFactory_5 = this.naming.getEclipsePluginExecutableExtensionFactory(it);
    _builder.append(_eclipsePluginExecutableExtensionFactory_5, "\t\t");
    _builder.append(":org.eclipse.xtext.ui.editor.copyqualifiedname.OutlineCopyQualifiedNameHandler\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("commandId=\"org.eclipse.xtext.ui.editor.copyqualifiedname.OutlineCopyQualifiedName\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<activeWhen>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<and>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<reference definitionId=\"");
    String _name_5 = it.getName();
    _builder.append(_name_5, "\t\t\t\t");
    _builder.append(".XtextEditor.opened\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("<iterate>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<adapt type=\"org.eclipse.xtext.ui.editor.outline.IOutlineNode\" />");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</iterate>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</and>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</activeWhen>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</handler>");
    _builder.newLine();
    _builder.append("</extension>");
    _builder.newLine();
    _builder.append("<extension point=\"org.eclipse.core.expressions.definitions\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<definition id=\"");
    String _name_6 = it.getName();
    _builder.append(_name_6, "\t");
    _builder.append(".Editor.opened\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<and>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<reference definitionId=\"isActiveEditorAnInstanceOfXtextEditor\"/>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<with variable=\"activeEditor\">");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<test property=\"org.eclipse.xtext.ui.editor.XtextEditor.languageName\" ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("value=\"");
    String _name_7 = it.getName();
    _builder.append(_name_7, "\t\t\t\t\t");
    _builder.append("\" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("forcePluginActivation=\"true\"/>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</with>\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</and>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</definition>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<definition id=\"");
    String _name_8 = it.getName();
    _builder.append(_name_8, "\t");
    _builder.append(".XtextEditor.opened\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<and>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<reference definitionId=\"isXtextEditorActive\"/>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<with variable=\"activeEditor\">");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<test property=\"org.eclipse.xtext.ui.editor.XtextEditor.languageName\" ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("value=\"");
    String _name_9 = it.getName();
    _builder.append(_name_9, "\t\t\t\t\t");
    _builder.append("\" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("forcePluginActivation=\"true\"/>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</with>\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</and>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</definition>");
    _builder.newLine();
    _builder.append("</extension>");
    _builder.newLine();
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("point=\"org.eclipse.ui.preferencePages\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<page");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("class=\"");
    TypeReference _eclipsePluginExecutableExtensionFactory_6 = this.naming.getEclipsePluginExecutableExtensionFactory(it);
    _builder.append(_eclipsePluginExecutableExtensionFactory_6, "\t\t");
    _builder.append(":org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("id=\"");
    String _name_10 = it.getName();
    _builder.append(_name_10, "\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("name=\"");
    String _simpleName = GrammarUtil.getSimpleName(it);
    _builder.append(_simpleName, "\t\t");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<keywordReference id=\"");
    String _namespace = GrammarUtil.getNamespace(it);
    String _plus = (_namespace + ".ui.keyword_");
    String _simpleName_1 = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_plus + _simpleName_1);
    _builder.append(_plus_1, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</page>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<page");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("category=\"");
    String _name_11 = it.getName();
    _builder.append(_name_11, "\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("class=\"");
    TypeReference _eclipsePluginExecutableExtensionFactory_7 = this.naming.getEclipsePluginExecutableExtensionFactory(it);
    _builder.append(_eclipsePluginExecutableExtensionFactory_7, "\t\t");
    _builder.append(":org.eclipse.xtext.ui.editor.syntaxcoloring.SyntaxColoringPreferencePage\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("id=\"");
    String _name_12 = it.getName();
    _builder.append(_name_12, "\t\t");
    _builder.append(".coloring\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("name=\"Syntax Coloring\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<keywordReference id=\"");
    String _namespace_1 = GrammarUtil.getNamespace(it);
    String _plus_2 = (_namespace_1 + ".ui.keyword_");
    String _simpleName_2 = GrammarUtil.getSimpleName(it);
    String _plus_3 = (_plus_2 + _simpleName_2);
    _builder.append(_plus_3, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</page>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<page");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("category=\"");
    String _name_13 = it.getName();
    _builder.append(_name_13, "\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("class=\"");
    TypeReference _eclipsePluginExecutableExtensionFactory_8 = this.naming.getEclipsePluginExecutableExtensionFactory(it);
    _builder.append(_eclipsePluginExecutableExtensionFactory_8, "\t\t");
    _builder.append(":org.eclipse.xtext.ui.editor.templates.XtextTemplatePreferencePage\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("id=\"");
    String _name_14 = it.getName();
    _builder.append(_name_14, "\t\t");
    _builder.append(".templates\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("name=\"Templates\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<keywordReference id=\"");
    String _namespace_2 = GrammarUtil.getNamespace(it);
    String _plus_4 = (_namespace_2 + ".ui.keyword_");
    String _simpleName_3 = GrammarUtil.getSimpleName(it);
    String _plus_5 = (_plus_4 + _simpleName_3);
    _builder.append(_plus_5, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</page>");
    _builder.newLine();
    _builder.append("</extension>");
    _builder.newLine();
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("point=\"org.eclipse.ui.propertyPages\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<page");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("class=\"");
    TypeReference _eclipsePluginExecutableExtensionFactory_9 = this.naming.getEclipsePluginExecutableExtensionFactory(it);
    _builder.append(_eclipsePluginExecutableExtensionFactory_9, "\t\t");
    _builder.append(":org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("id=\"");
    String _name_15 = it.getName();
    _builder.append(_name_15, "\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("name=\"");
    String _simpleName_4 = GrammarUtil.getSimpleName(it);
    _builder.append(_simpleName_4, "\t\t");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<keywordReference id=\"");
    String _namespace_3 = GrammarUtil.getNamespace(it);
    String _plus_6 = (_namespace_3 + ".ui.keyword_");
    String _simpleName_5 = GrammarUtil.getSimpleName(it);
    String _plus_7 = (_plus_6 + _simpleName_5);
    _builder.append(_plus_7, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<enabledWhen>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<adapt type=\"org.eclipse.core.resources.IProject\"/>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</enabledWhen>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<filter name=\"projectNature\" value=\"org.eclipse.xtext.ui.shared.xtextNature\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</page>");
    _builder.newLine();
    _builder.append("</extension>");
    _builder.newLine();
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("point=\"org.eclipse.ui.keywords\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<keyword");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("id=\"");
    String _namespace_4 = GrammarUtil.getNamespace(it);
    String _plus_8 = (_namespace_4 + ".ui.keyword_");
    String _simpleName_6 = GrammarUtil.getSimpleName(it);
    String _plus_9 = (_plus_8 + _simpleName_6);
    _builder.append(_plus_9, "\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("label=\"");
    String _simpleName_7 = GrammarUtil.getSimpleName(it);
    _builder.append(_simpleName_7, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("</extension>");
    _builder.newLine();
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("point=\"org.eclipse.ui.commands\">");
    _builder.newLine();
    _builder.append("<command");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("description=\"Trigger expensive validation\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("id=\"");
    String _name_16 = it.getName();
    _builder.append(_name_16, "\t\t");
    _builder.append(".validate\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("name=\"Validate\">");
    _builder.newLine();
    _builder.append("</command>");
    _builder.newLine();
    _builder.append("<!-- copy qualified name -->");
    _builder.newLine();
    _builder.append("<command");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("id=\"org.eclipse.xtext.ui.editor.copyqualifiedname.EditorCopyQualifiedName\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("categoryId=\"org.eclipse.ui.category.edit\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("description=\"Copy the qualified name for the selected element\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("name=\"Copy Qualified Name\">");
    _builder.newLine();
    _builder.append("</command>");
    _builder.newLine();
    _builder.append("<command");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("id=\"org.eclipse.xtext.ui.editor.copyqualifiedname.OutlineCopyQualifiedName\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("categoryId=\"org.eclipse.ui.category.edit\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("description=\"Copy the qualified name for the selected element\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("name=\"Copy Qualified Name\">");
    _builder.newLine();
    _builder.append("</command>");
    _builder.newLine();
    _builder.append("</extension>");
    _builder.newLine();
    _builder.append("<extension point=\"org.eclipse.ui.menus\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<menuContribution");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("locationURI=\"popup:#TextEditorContext?after=group.edit\">");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("<command");
    _builder.newLine();
    _builder.append("\t\t\t ");
    _builder.append("commandId=\"");
    String _name_17 = it.getName();
    _builder.append(_name_17, "\t\t\t ");
    _builder.append(".validate\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t ");
    _builder.append("style=\"push\"");
    _builder.newLine();
    _builder.append("\t\t\t ");
    _builder.append("tooltip=\"Trigger expensive validation\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<visibleWhen checkEnabled=\"false\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<reference");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("definitionId=\"");
    String _name_18 = it.getName();
    _builder.append(_name_18, "\t\t\t\t");
    _builder.append(".Editor.opened\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("</reference>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</visibleWhen>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</command>  ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</menuContribution>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("!-- copy qualified name -->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<menuContribution locationURI=\"popup:#TextEditorContext?after=copy\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<command commandId=\"org.eclipse.xtext.ui.editor.copyqualifiedname.EditorCopyQualifiedName\" ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("style=\"push\" tooltip=\"Copy Qualified Name\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<visibleWhen checkEnabled=\"false\">");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<reference definitionId=\"");
    String _name_19 = it.getName();
    _builder.append(_name_19, "\t\t\t\t");
    _builder.append(".Editor.opened\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("</visibleWhen>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</command>  ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</menuContribution>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<menuContribution locationURI=\"menu:edit?after=copy\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<command commandId=\"org.eclipse.xtext.ui.editor.copyqualifiedname.EditorCopyQualifiedName\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("style=\"push\" tooltip=\"Copy Qualified Name\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<visibleWhen checkEnabled=\"false\">");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<reference definitionId=\"");
    String _name_20 = it.getName();
    _builder.append(_name_20, "\t\t\t\t");
    _builder.append(".Editor.opened\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("</visibleWhen>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</command>  ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</menuContribution>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<menuContribution locationURI=\"popup:org.eclipse.xtext.ui.outline?after=additions\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<command commandId=\"org.eclipse.xtext.ui.editor.copyqualifiedname.OutlineCopyQualifiedName\" ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("style=\"push\" tooltip=\"Copy Qualified Name\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<visibleWhen checkEnabled=\"false\">");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<and>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<reference definitionId=\"");
    String _name_21 = it.getName();
    _builder.append(_name_21, "\t\t\t\t\t");
    _builder.append(".XtextEditor.opened\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("<iterate>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<adapt type=\"org.eclipse.xtext.ui.editor.outline.IOutlineNode\" />");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</iterate>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</and>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</visibleWhen>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</command>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</menuContribution>");
    _builder.newLine();
    _builder.append("</extension>");
    _builder.newLine();
    _builder.append("<extension point=\"org.eclipse.ui.menus\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<menuContribution locationURI=\"popup:#TextEditorContext?endof=group.find\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<command commandId=\"org.eclipse.xtext.ui.editor.FindReferences\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<visibleWhen checkEnabled=\"false\">");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<reference definitionId=\"");
    String _name_22 = it.getName();
    _builder.append(_name_22, "\t\t\t\t");
    _builder.append(".Editor.opened\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("</reference>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</visibleWhen>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</command>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</menuContribution>");
    _builder.newLine();
    _builder.append("</extension>");
    _builder.newLine();
    _builder.append("<extension point=\"org.eclipse.ui.handlers\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<handler");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("class=\"");
    TypeReference _eclipsePluginExecutableExtensionFactory_10 = this.naming.getEclipsePluginExecutableExtensionFactory(it);
    _builder.append(_eclipsePluginExecutableExtensionFactory_10, "\t\t");
    _builder.append(":org.eclipse.xtext.ui.editor.findrefs.FindReferencesHandler\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("commandId=\"org.eclipse.xtext.ui.editor.FindReferences\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<activeWhen>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<reference");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("definitionId=\"");
    String _name_23 = it.getName();
    _builder.append(_name_23, "\t\t\t\t");
    _builder.append(".Editor.opened\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("</reference>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</activeWhen>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</handler>");
    _builder.newLine();
    _builder.append("</extension>");
    _builder.newLine();
    return _builder;
  }
  
  private final static Logger LOG = Logger.getLogger(LanguageConfig2.class);
  
  @Pure
  public String getUri() {
    return this.uri;
  }
  
  @Pure
  public Grammar getGrammar() {
    return this.grammar;
  }
  
  @Pure
  public RuleNames getRuleNames() {
    return this.ruleNames;
  }
  
  @Pure
  public ResourceSet getResourceSet() {
    return this.resourceSet;
  }
  
  public void setResourceSet(final ResourceSet resourceSet) {
    this.resourceSet = resourceSet;
  }
  
  @Pure
  public Module getGuiceModule() {
    return this.guiceModule;
  }
  
  public void setGuiceModule(final Module guiceModule) {
    this.guiceModule = guiceModule;
  }
  
  @Pure
  public XtextGeneratorNaming getNaming() {
    return this.naming;
  }
  
  public void setNaming(final XtextGeneratorNaming naming) {
    this.naming = naming;
  }
  
  @Pure
  public List<String> getLoadedResources() {
    return this.loadedResources;
  }
  
  @Pure
  public StandaloneSetupAccess getRuntimeGenSetup() {
    return this.runtimeGenSetup;
  }
  
  @Pure
  public GuiceModuleAccess getRuntimeGenModule() {
    return this.runtimeGenModule;
  }
  
  @Pure
  public GuiceModuleAccess getEclipsePluginGenModule() {
    return this.eclipsePluginGenModule;
  }
  
  @Pure
  public GuiceModuleAccess getIdeaGenModule() {
    return this.ideaGenModule;
  }
  
  @Pure
  public GuiceModuleAccess getWebGenModule() {
    return this.webGenModule;
  }
}
