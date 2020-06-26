/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.RuleNames;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.CompositeGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.ImplicitFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorResourceSetInitializer;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.StandaloneSetupAccess;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;

/**
 * Configuration for an Xtext language. Use this class if you need to specify exactly which generator
 * fragments you want to include, or alternatively {@link StandardLanguage} to work with the standard
 * fragments.
 * 
 * <p>The most important property is {@code name}, which should be set to the language name exactly
 * as specified in the grammar file. If the default grammar resolution based on the name does not
 * work in your particular scenario, set the {@code grammarUri} property instead. Furthermore,
 * use {@code fileExtensions} to specify the file extensions for your language.</p>
 * 
 * <p>Generator fragments can be added with the {@code fragment} property. See {@link StandardLanguage}
 * for a list of useful fragments.</p>
 * 
 * @noextend This class should not be extended by clients.
 */
@SuppressWarnings("all")
public class XtextGeneratorLanguage extends CompositeGeneratorFragment2 implements IXtextGeneratorLanguage {
  private static final Logger LOG = Logger.getLogger(XtextGeneratorLanguage.class);
  
  private String grammarUri;
  
  private String name;
  
  private Boolean generateXtendStubs;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private Grammar grammar;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private RuleNames ruleNames;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private List<String> fileExtensions;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private List<String> referencedResources = CollectionLiterals.<String>newArrayList();
  
  @Accessors
  private ResourceSet resourceSet;
  
  @Accessors
  private com.google.inject.Module guiceModule = ((com.google.inject.Module) (Binder it) -> {
  });
  
  @Accessors
  private final StandaloneSetupAccess runtimeGenSetup = new StandaloneSetupAccess();
  
  @Accessors
  private final GuiceModuleAccess runtimeGenModule = new GuiceModuleAccess();
  
  @Accessors
  private final GuiceModuleAccess ideGenModule = new GuiceModuleAccess();
  
  @Accessors
  private final GuiceModuleAccess eclipsePluginGenModule = new GuiceModuleAccess();
  
  @Accessors
  private final GuiceModuleAccess webGenModule = new GuiceModuleAccess();
  
  @Inject
  private Provider<ResourceSet> resourceSetProvider;
  
  @Inject
  private IXtextProjectConfig projectConfig;
  
  @Inject
  private CodeConfig codeConfig;
  
  @Inject
  private XtextGeneratorResourceSetInitializer resourceSetInitializer;
  
  /**
   * The URI of the grammar file. Use this property if the automatic grammar resolution based on {@link #setName(String)}
   * does not work in your particular scenario.
   */
  public void setGrammarUri(final String uri) {
    this.grammarUri = uri;
  }
  
  public String getGrammarUri() {
    String _elvis = null;
    if (this.grammarUri != null) {
      _elvis = this.grammarUri;
    } else {
      String _path = this.projectConfig.getRuntime().getSrc().getPath();
      String _replace = this.name.replace(".", "/");
      String _plus = (_replace + ".xtext");
      String _string = new File(_path, _plus).toURI().toString();
      _elvis = _string;
    }
    return _elvis;
  }
  
  /**
   * The language name exactly as specified in the grammar.
   */
  public void setName(final String name) {
    this.name = name;
  }
  
  /**
   * Either a single file extension or a comma-separated list of extensions for which the language
   * shall be registered.
   */
  public void setFileExtensions(final String fileExtensions) {
    this.fileExtensions = IterableExtensions.<String>toList(((Iterable<String>)Conversions.doWrapArray(fileExtensions.trim().split("\\s*,\\s*"))));
  }
  
  /**
   * Add a resource to be included in the resource set that will be used to load the grammar file.
   * This is often necessary if additional Ecore models are referenced by the grammar.
   */
  public void addReferencedResource(final String referencedResource) {
    this.referencedResources.add(referencedResource);
  }
  
  @Override
  public List<String> getFileExtensions() {
    if (((this.fileExtensions == null) || this.fileExtensions.isEmpty())) {
      this.setFileExtensions(GrammarUtil.getSimpleName(this.grammar).toLowerCase());
      XtextGeneratorLanguage.LOG.info((("No explicit fileExtensions configured. Using \'*." + this.fileExtensions) + "\'."));
    }
    return this.fileExtensions;
  }
  
  /**
   * @deprecated Use {@link CodeConfig#setPreferXtendStubs(boolean)} instead
   */
  @Deprecated
  public void setGenerateXtendStubs(final Boolean generateXtendStubs) {
    this.generateXtendStubs = generateXtendStubs;
  }
  
  /**
   * @deprecated Use {@link CodeConfig#isPreferXtendStubs()} instead
   */
  @Deprecated
  @Override
  public boolean isGenerateXtendStubs() {
    boolean _xifexpression = false;
    if ((this.generateXtendStubs != null)) {
      _xifexpression = this.generateXtendStubs.booleanValue();
    } else {
      _xifexpression = this.codeConfig.isPreferXtendStubs();
    }
    return _xifexpression;
  }
  
  @Override
  public void initialize(final Injector injector) {
    this.getFragments().addAll(0, this.getImplicitFragments());
    injector.injectMembers(this);
    if ((this.resourceSet == null)) {
      this.resourceSet = this.resourceSetProvider.get();
    }
    this.resourceSetInitializer.initialize(this.resourceSet, this.referencedResources);
    boolean _isEmpty = this.resourceSet.getResources().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.installIndex();
      {
        int i = 0;
        int size = this.resourceSet.getResources().size();
        boolean _while = (i < size);
        while (_while) {
          {
            final Resource res = this.resourceSet.getResources().get(i);
            boolean _isEmpty_1 = res.getContents().isEmpty();
            if (_isEmpty_1) {
              URI _uRI = res.getURI();
              String _plus = ("Error loading \'" + _uRI);
              String _plus_1 = (_plus + "\'");
              XtextGeneratorLanguage.LOG.error(_plus_1);
            } else {
              boolean _isEmpty_2 = res.getErrors().isEmpty();
              boolean _not_1 = (!_isEmpty_2);
              if (_not_1) {
                URI _uRI_1 = res.getURI();
                String _plus_2 = ("Error loading \'" + _uRI_1);
                String _plus_3 = (_plus_2 + "\':\n");
                String _join = Joiner.on("\n").join(res.getErrors());
                String _plus_4 = (_plus_3 + _join);
                XtextGeneratorLanguage.LOG.error(_plus_4);
              }
            }
          }
          i++;
          _while = (i < size);
        }
      }
      EcoreUtil.resolveAll(this.resourceSet);
    }
    String _grammarUri = this.getGrammarUri();
    boolean _tripleEquals = (_grammarUri == null);
    if (_tripleEquals) {
      throw new IllegalStateException("No grammarUri or language name given");
    }
    Resource _resource = this.resourceSet.getResource(URI.createURI(this.getGrammarUri()), true);
    final XtextResource resource = ((XtextResource) _resource);
    boolean _isEmpty_1 = resource.getContents().isEmpty();
    if (_isEmpty_1) {
      String _grammarUri_1 = this.getGrammarUri();
      String _plus = ("Couldn\'t load grammar for \'" + _grammarUri_1);
      String _plus_1 = (_plus + "\'.");
      throw new IllegalArgumentException(_plus_1);
    }
    boolean _isEmpty_2 = resource.getErrors().isEmpty();
    boolean _not_1 = (!_isEmpty_2);
    if (_not_1) {
      XtextGeneratorLanguage.LOG.error(resource.getErrors());
      String _grammarUri_2 = this.getGrammarUri();
      String _plus_2 = ("Problem parsing \'" + _grammarUri_2);
      String _plus_3 = (_plus_2 + "\':\n");
      String _join = Joiner.on("\n").join(resource.getErrors());
      String _plus_4 = (_plus_3 + _join);
      throw new IllegalStateException(_plus_4);
    }
    EObject _get = resource.getContents().get(0);
    final Grammar grammar = ((Grammar) _get);
    this.validateGrammar(grammar);
    this.initialize(grammar);
    super.initialize(injector);
  }
  
  protected List<? extends IXtextGeneratorFragment> getImplicitFragments() {
    final ArrayList<ImplicitFragment> fragments = CollectionLiterals.<ImplicitFragment>newArrayList();
    ImplicitFragment _implicitFragment = new ImplicitFragment();
    fragments.add(_implicitFragment);
    return fragments;
  }
  
  public void initialize(final Grammar grammar) {
    this.grammar = grammar;
    this.ruleNames = RuleNames.getRuleNames(grammar, true);
  }
  
  private void installIndex() {
    List<IResourceDescription> _emptyList = Collections.<IResourceDescription>emptyList();
    final ResourceDescriptionsData index = new ResourceDescriptionsData(_emptyList);
    final ArrayList<Resource> resources = Lists.<Resource>newArrayList(this.resourceSet.getResources());
    for (final Resource resource : resources) {
      this.index(resource, resource.getURI(), index);
    }
    ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(this.resourceSet, index);
  }
  
  private void index(final Resource resource, final URI uri, final ResourceDescriptionsData index) {
    final IResourceServiceProvider serviceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri);
    if ((serviceProvider != null)) {
      final IResourceDescription resourceDescription = serviceProvider.getResourceDescriptionManager().getResourceDescription(resource);
      if ((resourceDescription != null)) {
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
            String _name = grammar.getName();
            String _plus = ("Validation Error in " + _name);
            final String grammarName = (_plus + ": ");
            Throwable _exception = diagnostic.getException();
            boolean _tripleEquals = (_exception == null);
            if (_tripleEquals) {
              String _message = diagnostic.getMessage();
              String _plus_1 = (grammarName + _message);
              throw new IllegalStateException(_plus_1);
            } else {
              String _message_1 = diagnostic.getMessage();
              String _plus_2 = (grammarName + _message_1);
              Throwable _exception_1 = diagnostic.getException();
              throw new IllegalStateException(_plus_2, _exception_1);
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
    if (((ref.getEPackage() != null) && (!ref.getEPackage().eIsProxy()))) {
      return;
    }
    final EReference eref = XtextPackage.Literals.ABSTRACT_METAMODEL_DECLARATION__EPACKAGE;
    final List<INode> nodes = NodeModelUtils.findNodesForFeature(ref, eref);
    String _xifexpression = null;
    boolean _isEmpty = nodes.isEmpty();
    if (_isEmpty) {
      _xifexpression = "(unknown)";
    } else {
      _xifexpression = NodeModelUtils.getTokenText(nodes.get(0));
    }
    final String refName = _xifexpression;
    final String grammarName = GrammarUtil.getGrammar(ref).getName();
    final String msg = ((((("The EPackage " + refName) + " in grammar ") + grammarName) + " could not be found. ") + "You might want to register that EPackage in your workflow file.");
    throw new IllegalStateException(msg);
  }
  
  @Pure
  @Override
  public Grammar getGrammar() {
    return this.grammar;
  }
  
  @Pure
  public RuleNames getRuleNames() {
    return this.ruleNames;
  }
  
  @Pure
  public List<String> getReferencedResources() {
    return this.referencedResources;
  }
  
  @Pure
  @Override
  public ResourceSet getResourceSet() {
    return this.resourceSet;
  }
  
  public void setResourceSet(final ResourceSet resourceSet) {
    this.resourceSet = resourceSet;
  }
  
  @Pure
  public com.google.inject.Module getGuiceModule() {
    return this.guiceModule;
  }
  
  public void setGuiceModule(final com.google.inject.Module guiceModule) {
    this.guiceModule = guiceModule;
  }
  
  @Pure
  @Override
  public StandaloneSetupAccess getRuntimeGenSetup() {
    return this.runtimeGenSetup;
  }
  
  @Pure
  @Override
  public GuiceModuleAccess getRuntimeGenModule() {
    return this.runtimeGenModule;
  }
  
  @Pure
  @Override
  public GuiceModuleAccess getIdeGenModule() {
    return this.ideGenModule;
  }
  
  @Pure
  @Override
  public GuiceModuleAccess getEclipsePluginGenModule() {
    return this.eclipsePluginGenModule;
  }
  
  @Pure
  @Override
  public GuiceModuleAccess getWebGenModule() {
    return this.webGenModule;
  }
}
