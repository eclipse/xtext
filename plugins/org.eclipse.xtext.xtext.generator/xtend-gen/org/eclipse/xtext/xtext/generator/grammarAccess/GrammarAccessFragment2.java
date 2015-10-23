/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.grammarAccess;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.grammarAccess.FragmentFakingEcoreResource;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation;
import org.eclipse.xtext.xtext.generator.model.annotations.SingletonClassAnnotation;
import org.eclipse.xtext.xtext.generator.model.project.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;

@Log
@SuppressWarnings("all")
public class GrammarAccessFragment2 extends AbstractXtextGeneratorFragment {
  @Accessors
  private String xmlVersion;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  @Inject
  @Extension
  private GrammarAccessExtensions _grammarAccessExtensions;
  
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Override
  public void generate() {
    final GuiceModuleAccess.BindingFactory bindingFactory = new GuiceModuleAccess.BindingFactory();
    IXtextGeneratorLanguage _language = this.getLanguage();
    Grammar _grammar = _language.getGrammar();
    String _name = _grammar.getName();
    boolean _notEquals = (!Objects.equal(_name, "org.eclipse.xtext.common.Terminals"));
    if (_notEquals) {
      TypeReference _typeRef = TypeReference.typeRef(ClassLoader.class);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("getClass().getClassLoader()");
        }
      };
      bindingFactory.addTypeToInstance(_typeRef, _client);
    }
    TypeReference _typeRef_1 = TypeReference.typeRef(IGrammarAccess.class);
    IXtextGeneratorLanguage _language_1 = this.getLanguage();
    Grammar _grammar_1 = _language_1.getGrammar();
    TypeReference _grammarAccess = this._grammarAccessExtensions.getGrammarAccess(_grammar_1);
    GuiceModuleAccess.BindingFactory _addTypeToType = bindingFactory.addTypeToType(_typeRef_1, _grammarAccess);
    IXtextGeneratorLanguage _language_2 = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule = _language_2.getRuntimeGenModule();
    _addTypeToType.contributeTo(_runtimeGenModule);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    ManifestAccess _manifest = _runtime.getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_1 = _projectConfig_1.getRuntime();
      ManifestAccess _manifest_1 = _runtime_1.getManifest();
      Set<String> _exportedPackages = _manifest_1.getExportedPackages();
      Grammar _grammar_2 = this.getGrammar();
      String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(_grammar_2);
      Grammar _grammar_3 = this.getGrammar();
      String _runtimeBasePackage_1 = this._xtextGeneratorNaming.getRuntimeBasePackage(_grammar_3);
      String _plus = (_runtimeBasePackage_1 + ".services");
      _exportedPackages.addAll(
        Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_runtimeBasePackage, _plus)));
    }
    this.doGenerateGrammarAccess();
    this.writeGrammar();
  }
  
  protected String getQualifiedName(final AbstractRule rule) {
    Grammar _grammar = GrammarUtil.getGrammar(rule);
    String _name = _grammar.getName();
    String _plus = (_name + ".");
    String _name_1 = rule.getName();
    return (_plus + _name_1);
  }
  
  protected void writeGrammar() {
    final Wrapper<Boolean> isSaving = Wrapper.<Boolean>wrap(Boolean.valueOf(false));
    final ResourceSet cloneInto = new ResourceSetImpl();
    Resource.Factory.Registry _resourceFactoryRegistry = cloneInto.getResourceFactoryRegistry();
    Map<String, Object> _extensionToFactoryMap = _resourceFactoryRegistry.getExtensionToFactoryMap();
    FragmentFakingEcoreResource.FactoryImpl _factoryImpl = new FragmentFakingEcoreResource.FactoryImpl(isSaving);
    _extensionToFactoryMap.put(
      FragmentFakingEcoreResource.FactoryImpl.ECORE_SUFFIX, _factoryImpl);
    IXtextGeneratorLanguage _language = this.getLanguage();
    Grammar _grammar = _language.getGrammar();
    Resource _eResource = _grammar.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    final ResourceSet resourceSet = EcoreUtil2.<ResourceSet>clone(cloneInto, _resourceSet);
    IXtextGeneratorLanguage _language_1 = this.getLanguage();
    Grammar _grammar_1 = _language_1.getGrammar();
    Resource _eResource_1 = _grammar_1.eResource();
    URI _uRI = _eResource_1.getURI();
    Resource _resource = resourceSet.getResource(_uRI, true);
    EList<EObject> _contents = _resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    final Grammar copy = ((Grammar) _head);
    String _xifexpression = null;
    if ((this.xmlVersion == null)) {
      _xifexpression = GrammarUtil.getClasspathRelativePathToBinGrammar(copy);
    } else {
      String _xblockexpression = null;
      {
        String _simpleName = GrammarAccessFragment2.class.getSimpleName();
        String _plus = ("The property \'xmlVersion\' has been specified for this " + _simpleName);
        String _plus_1 = (_plus + ". Therefore, the grammar is persisted as XMI and not as binary. This can be a performance drawback.");
        GrammarAccessFragment2.LOG.warn(_plus_1);
        _xblockexpression = GrammarUtil.getClasspathRelativePathToXmi(copy);
      }
      _xifexpression = _xblockexpression;
    }
    final String path = _xifexpression;
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _srcGen = _runtime.getSrcGen();
    final URI uri = _srcGen.getURI(path);
    final Resource resource = resourceSet.createResource(uri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
    HashSet<Grammar> _hashSet = new HashSet<Grammar>();
    this.addAllGrammarsToResource(resource, copy, _hashSet);
    isSaving.set(Boolean.valueOf(true));
    final Map<String, Object> saveOptions = CollectionLiterals.<String, Object>newHashMap();
    if ((resource instanceof XMLResource)) {
      String _elvis = null;
      if (this.xmlVersion != null) {
        _elvis = this.xmlVersion;
      } else {
        _elvis = "1.0";
      }
      ((XMLResource)resource).setXMLVersion(_elvis);
    } else {
      if ((resource instanceof BinaryResourceImpl)) {
        saveOptions.put(BinaryResourceImpl.OPTION_VERSION, BinaryResourceImpl.BinaryIO.Version.VERSION_1_1);
        saveOptions.put(BinaryResourceImpl.OPTION_STYLE_DATA_CONVERTER, Boolean.valueOf(true));
      }
    }
    try {
      resource.save(saveOptions);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        String _message = e.getMessage();
        GrammarAccessFragment2.LOG.error(_message, e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      isSaving.set(Boolean.valueOf(false));
    }
  }
  
  protected void addAllGrammarsToResource(final Resource resource, final Grammar grammar, final Set<Grammar> visitedGrammars) {
    boolean _add = visitedGrammars.add(grammar);
    boolean _not = (!_add);
    if (_not) {
      return;
    }
    EList<EObject> _contents = resource.getContents();
    _contents.add(grammar);
    EList<AbstractMetamodelDeclaration> _metamodelDeclarations = grammar.getMetamodelDeclarations();
    for (final AbstractMetamodelDeclaration metamodelDecl : _metamodelDeclarations) {
      {
        final EPackage pack = metamodelDecl.getEPackage();
        final Resource packResource = pack.eResource();
        URI _uRI = packResource.getURI();
        String _string = _uRI.toString();
        String _nsURI = pack.getNsURI();
        boolean _notEquals = (!Objects.equal(_string, _nsURI));
        if (_notEquals) {
          final ResourceSet packResourceSet = packResource.getResourceSet();
          if ((packResourceSet != null)) {
            EPackage topMost = pack;
            while (((topMost.getESuperPackage() != null) && (topMost.getESuperPackage().eResource() == topMost.eResource()))) {
              EPackage _eSuperPackage = topMost.getESuperPackage();
              topMost = _eSuperPackage;
            }
            boolean _and = false;
            EList<EObject> _contents_1 = packResource.getContents();
            boolean _contains = _contents_1.contains(topMost);
            if (!_contains) {
              _and = false;
            } else {
              EList<EObject> _contents_2 = packResource.getContents();
              int _size = _contents_2.size();
              boolean _equals = (_size == 1);
              _and = _equals;
            }
            if (_and) {
              EList<EClassifier> _eClassifiers = topMost.getEClassifiers();
              boolean _isEmpty = _eClassifiers.isEmpty();
              boolean _not_1 = (!_isEmpty);
              if (_not_1) {
                String _nsURI_1 = topMost.getNsURI();
                URI _createURI = URI.createURI(_nsURI_1);
                packResource.setURI(_createURI);
              } else {
                ResourceSet _resourceSet = resource.getResourceSet();
                this.moveSubpackagesToNewResource(topMost, _resourceSet);
              }
            }
            Resource _eResource = topMost.eResource();
            URI _uRI_1 = _eResource.getURI();
            String _string_1 = _uRI_1.toString();
            String _nsURI_2 = topMost.getNsURI();
            boolean _equals_1 = _string_1.equals(_nsURI_2);
            boolean _not_2 = (!_equals_1);
            if (_not_2) {
              ResourceSet _resourceSet_1 = resource.getResourceSet();
              this.movePackageToNewResource(topMost, _resourceSet_1);
            }
          }
        }
      }
    }
    EList<Grammar> _usedGrammars = grammar.getUsedGrammars();
    for (final Grammar usedGrammar : _usedGrammars) {
      this.addAllGrammarsToResource(resource, usedGrammar, visitedGrammars);
    }
  }
  
  protected void moveSubpackagesToNewResource(final EPackage pack, final ResourceSet set) {
    for (int i = (pack.getESubpackages().size() - 1); (i >= 0); i--) {
      {
        EList<EPackage> _eSubpackages = pack.getESubpackages();
        final EPackage sub = _eSubpackages.get(i);
        Resource _eResource = sub.eResource();
        Resource _eResource_1 = pack.eResource();
        boolean _tripleEquals = (_eResource == _eResource_1);
        if (_tripleEquals) {
          EList<EClassifier> _eClassifiers = sub.getEClassifiers();
          boolean _isEmpty = _eClassifiers.isEmpty();
          if (_isEmpty) {
            this.moveSubpackagesToNewResource(sub, set);
          } else {
            this.movePackageToNewResource(sub, set);
            EList<EPackage> _eSubpackages_1 = pack.getESubpackages();
            _eSubpackages_1.remove(i);
          }
        }
      }
    }
  }
  
  protected void movePackageToNewResource(final EPackage pack, final ResourceSet set) {
    URI _createURI = URI.createURI(("___temp___." + FragmentFakingEcoreResource.FactoryImpl.ECORE_SUFFIX));
    final Resource resource = set.createResource(_createURI, 
      ContentHandler.UNSPECIFIED_CONTENT_TYPE);
    String _nsURI = pack.getNsURI();
    URI _createURI_1 = URI.createURI(_nsURI);
    resource.setURI(_createURI_1);
    EList<EObject> _contents = resource.getContents();
    _contents.add(pack);
  }
  
  protected void doGenerateGrammarAccess() {
    Grammar _grammar = this.getGrammar();
    TypeReference _grammarAccess = this._grammarAccessExtensions.getGrammarAccess(_grammar);
    final GeneratedJavaFileAccess javaFile = this.fileAccessFactory.createGeneratedJavaFile(_grammarAccess);
    List<IClassAnnotation> _annotations = javaFile.getAnnotations();
    SingletonClassAnnotation _singletonClassAnnotation = new SingletonClassAnnotation();
    _annotations.add(_singletonClassAnnotation);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        IXtextGeneratorLanguage _language = GrammarAccessFragment2.this.getLanguage();
        Grammar _grammar = _language.getGrammar();
        TypeReference _grammarAccess = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(_grammar);
        String _simpleName = _grammarAccess.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append(AbstractElementFinder.AbstractGrammarElementFinder.class, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        {
          IXtextGeneratorLanguage _language_1 = GrammarAccessFragment2.this.getLanguage();
          Grammar _grammar_1 = _language_1.getGrammar();
          EList<AbstractRule> _rules = _grammar_1.getRules();
          Iterable<ParserRule> _filter = Iterables.<ParserRule>filter(_rules, ParserRule.class);
          for(final ParserRule r : _filter) {
            _builder.append("\t");
            StringConcatenationClient _parserRuleClasses = GrammarAccessFragment2.this.parserRuleClasses(r);
            _builder.append(_parserRuleClasses, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        {
          IXtextGeneratorLanguage _language_2 = GrammarAccessFragment2.this.getLanguage();
          Grammar _grammar_2 = _language_2.getGrammar();
          EList<AbstractRule> _rules_1 = _grammar_2.getRules();
          Iterable<EnumRule> _filter_1 = Iterables.<EnumRule>filter(_rules_1, EnumRule.class);
          for(final EnumRule r_1 : _filter_1) {
            _builder.append("\t");
            StringConcatenationClient _parserRuleClasses_1 = GrammarAccessFragment2.this.parserRuleClasses(r_1);
            _builder.append(_parserRuleClasses_1, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        {
          IXtextGeneratorLanguage _language_3 = GrammarAccessFragment2.this.getLanguage();
          Grammar _grammar_3 = _language_3.getGrammar();
          EList<AbstractRule> _rules_2 = _grammar_3.getRules();
          for(final AbstractRule r_2 : _rules_2) {
            _builder.append("\t");
            StringConcatenationClient _cache = GrammarAccessFragment2.this.cache(r_2);
            _builder.append(_cache, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private final ");
        _builder.append(Grammar.class, "\t");
        _builder.append(" grammar;");
        _builder.newLineIfNotEmpty();
        {
          IXtextGeneratorLanguage _language_4 = GrammarAccessFragment2.this.getLanguage();
          Grammar _grammar_4 = _language_4.getGrammar();
          EList<Grammar> _usedGrammars = _grammar_4.getUsedGrammars();
          for(final Grammar g : _usedGrammars) {
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("private final ");
            TypeReference _grammarAccess_1 = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(g);
            _builder.append(_grammarAccess_1, "\t");
            _builder.append(" ");
            String _gaGrammarAccessLocalVarName = GrammarAccessFragment2.this.gaGrammarAccessLocalVarName(g);
            _builder.append(_gaGrammarAccessLocalVarName, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        IXtextGeneratorLanguage _language_5 = GrammarAccessFragment2.this.getLanguage();
        Grammar _grammar_5 = _language_5.getGrammar();
        TypeReference _grammarAccess_2 = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(_grammar_5);
        String _simpleName_1 = _grammarAccess_2.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(");
        _builder.append(GrammarProvider.class, "\t");
        _builder.append(" grammarProvider");
        {
          IXtextGeneratorLanguage _language_6 = GrammarAccessFragment2.this.getLanguage();
          Grammar _grammar_6 = _language_6.getGrammar();
          EList<Grammar> _usedGrammars_1 = _grammar_6.getUsedGrammars();
          for(final Grammar g_1 : _usedGrammars_1) {
            _builder.append(",");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            TypeReference _grammarAccess_3 = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(g_1);
            _builder.append(_grammarAccess_3, "\t\t\t");
            _builder.append(" ");
            String _gaGrammarAccessLocalVarName_1 = GrammarAccessFragment2.this.gaGrammarAccessLocalVarName(g_1);
            _builder.append(_gaGrammarAccessLocalVarName_1, "\t\t\t");
          }
        }
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("this.grammar = internalFindGrammar(grammarProvider);");
        _builder.newLine();
        {
          IXtextGeneratorLanguage _language_7 = GrammarAccessFragment2.this.getLanguage();
          Grammar _grammar_7 = _language_7.getGrammar();
          EList<Grammar> _usedGrammars_2 = _grammar_7.getUsedGrammars();
          for(final Grammar g_2 : _usedGrammars_2) {
            _builder.append("\t\t");
            _builder.append("this.");
            String _gaGrammarAccessLocalVarName_2 = GrammarAccessFragment2.this.gaGrammarAccessLocalVarName(g_2);
            _builder.append(_gaGrammarAccessLocalVarName_2, "\t\t");
            _builder.append(" = ");
            String _gaGrammarAccessLocalVarName_3 = GrammarAccessFragment2.this.gaGrammarAccessLocalVarName(g_2);
            _builder.append(_gaGrammarAccessLocalVarName_3, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          IXtextGeneratorLanguage _language_8 = GrammarAccessFragment2.this.getLanguage();
          Grammar _grammar_8 = _language_8.getGrammar();
          EList<AbstractRule> _rules_3 = _grammar_8.getRules();
          for(final AbstractRule r_3 : _rules_3) {
            _builder.append("\t\t");
            StringConcatenationClient _initializer = GrammarAccessFragment2.this.initializer(r_3);
            _builder.append(_initializer, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append(Grammar.class, "\t");
        _builder.append(" internalFindGrammar(");
        _builder.append(GrammarProvider.class, "\t");
        _builder.append(" grammarProvider) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append(Grammar.class, "\t\t");
        _builder.append(" grammar = grammarProvider.getGrammar(this);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("while (grammar != null) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (\"");
        IXtextGeneratorLanguage _language_9 = GrammarAccessFragment2.this.getLanguage();
        Grammar _grammar_9 = _language_9.getGrammar();
        String _name = _grammar_9.getName();
        _builder.append(_name, "\t\t\t");
        _builder.append("\".equals(grammar.getName())) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("return grammar;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append(List.class, "\t\t\t");
        _builder.append("<");
        _builder.append(Grammar.class, "\t\t\t");
        _builder.append("> grammars = grammar.getUsedGrammars();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("if (!grammars.isEmpty()) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("grammar = grammars.iterator().next();");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("return null;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return grammar;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        _builder.append(Grammar.class, "\t");
        _builder.append(" getGrammar() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return grammar;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          IXtextGeneratorLanguage _language_10 = GrammarAccessFragment2.this.getLanguage();
          Grammar _grammar_10 = _language_10.getGrammar();
          EList<Grammar> _usedGrammars_3 = _grammar_10.getUsedGrammars();
          for(final Grammar g_3 : _usedGrammars_3) {
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public ");
            TypeReference _grammarAccess_4 = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(g_3);
            _builder.append(_grammarAccess_4, "\t");
            _builder.append(" get");
            TypeReference _grammarAccess_5 = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(g_3);
            String _simpleName_2 = _grammarAccess_5.getSimpleName();
            _builder.append(_simpleName_2, "\t");
            _builder.append("() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return ");
            String _gaGrammarAccessLocalVarName_4 = GrammarAccessFragment2.this.gaGrammarAccessLocalVarName(g_3);
            _builder.append(_gaGrammarAccessLocalVarName_4, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.newLine();
        {
          IXtextGeneratorLanguage _language_11 = GrammarAccessFragment2.this.getLanguage();
          Grammar _grammar_11 = _language_11.getGrammar();
          List<AbstractRule> _allRules = GrammarUtil.allRules(_grammar_11);
          for(final AbstractRule r_4 : _allRules) {
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            IXtextGeneratorLanguage _language_12 = GrammarAccessFragment2.this.getLanguage();
            Grammar _grammar_12 = _language_12.getGrammar();
            StringConcatenationClient _ter = GrammarAccessFragment2.this.getter(r_4, _grammar_12);
            _builder.append(_ter, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setContent(_client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _srcGen = _runtime.getSrcGen();
    javaFile.writeTo(_srcGen);
  }
  
  protected StringConcatenationClient parserRuleClasses(final ParserRule it) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        String _gaRuleAccessorClassName = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessorClassName(it);
        _builder.append(_gaRuleAccessorClassName, "");
        _builder.append(" extends AbstractParserRuleElementFinder {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private final ");
        _builder.append(ParserRule.class, "\t");
        _builder.append(" rule = (");
        _builder.append(ParserRule.class, "\t");
        _builder.append(") ");
        _builder.append(GrammarUtil.class, "\t");
        _builder.append(".findRuleForName(getGrammar(), \"");
        String _qualifiedName = GrammarAccessFragment2.this.getQualifiedName(it);
        _builder.append(_qualifiedName, "\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        {
          List<AbstractElement> _containedAbstractElements = GrammarUtil.containedAbstractElements(it);
          for(final AbstractElement e : _containedAbstractElements) {
            _builder.append("\t");
            _builder.append("private final ");
            EClass _eClass = e.eClass();
            IXtextGeneratorLanguage _language = GrammarAccessFragment2.this.getLanguage();
            TypeReference _typeRef = TypeReference.typeRef(_eClass, _language);
            _builder.append(_typeRef, "\t");
            _builder.append(" ");
            String _gaElementAccessorLocalVarName = GrammarAccessFragment2.this.gaElementAccessorLocalVarName(e);
            _builder.append(_gaElementAccessorLocalVarName, "\t");
            _builder.append(" = ");
            StringConcatenationClient _loadElementStatement = GrammarAccessFragment2.this.loadElementStatement(e);
            _builder.append(_loadElementStatement, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        String _grammarFragmentToString = GrammarAccessFragment2.this._grammarAccessExtensions.grammarFragmentToString(it, "//");
        _builder.append(_grammarFragmentToString, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("@Override public ");
        _builder.append(ParserRule.class, "\t");
        _builder.append(" getRule() { return rule; }");
        _builder.newLineIfNotEmpty();
        {
          List<AbstractElement> _containedAbstractElements_1 = GrammarUtil.containedAbstractElements(it);
          for(final AbstractElement e_1 : _containedAbstractElements_1) {
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            String _grammarFragmentToString_1 = GrammarAccessFragment2.this._grammarAccessExtensions.grammarFragmentToString(e_1, "//");
            _builder.append(_grammarFragmentToString_1, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("public ");
            EClass _eClass_1 = e_1.eClass();
            IXtextGeneratorLanguage _language_1 = GrammarAccessFragment2.this.getLanguage();
            TypeReference _typeRef_1 = TypeReference.typeRef(_eClass_1, _language_1);
            _builder.append(_typeRef_1, "\t");
            _builder.append(" ");
            String _gaElementAccessMethodName = GrammarAccessFragment2.this._grammarAccessExtensions.gaElementAccessMethodName(e_1);
            _builder.append(_gaElementAccessMethodName, "\t");
            _builder.append("() { return ");
            String _gaElementAccessorLocalVarName_1 = GrammarAccessFragment2.this.gaElementAccessorLocalVarName(e_1);
            _builder.append(_gaElementAccessorLocalVarName_1, "\t");
            _builder.append("; }");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client;
  }
  
  protected StringConcatenationClient parserRuleClasses(final EnumRule it) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        String _gaRuleAccessorClassName = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessorClassName(it);
        _builder.append(_gaRuleAccessorClassName, "");
        _builder.append(" extends ");
        _builder.append(AbstractElementFinder.AbstractEnumRuleElementFinder.class, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private final ");
        _builder.append(EnumRule.class, "\t");
        _builder.append(" rule = (");
        _builder.append(EnumRule.class, "\t");
        _builder.append(") ");
        _builder.append(GrammarUtil.class, "\t");
        _builder.append(".findRuleForName(getGrammar(), \"");
        String _qualifiedName = GrammarAccessFragment2.this.getQualifiedName(it);
        _builder.append(_qualifiedName, "\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        {
          List<AbstractElement> _containedAbstractElements = GrammarUtil.containedAbstractElements(it);
          for(final AbstractElement e : _containedAbstractElements) {
            _builder.append("\t");
            _builder.append("private final ");
            EClass _eClass = e.eClass();
            IXtextGeneratorLanguage _language = GrammarAccessFragment2.this.getLanguage();
            TypeReference _typeRef = TypeReference.typeRef(_eClass, _language);
            _builder.append(_typeRef, "\t");
            _builder.append(" ");
            String _gaElementAccessorLocalVarName = GrammarAccessFragment2.this.gaElementAccessorLocalVarName(e);
            _builder.append(_gaElementAccessorLocalVarName, "\t");
            _builder.append(" = ");
            StringConcatenationClient _loadElementStatement = GrammarAccessFragment2.this.loadElementStatement(e);
            _builder.append(_loadElementStatement, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        String _grammarFragmentToString = GrammarAccessFragment2.this._grammarAccessExtensions.grammarFragmentToString(it, "//");
        _builder.append(_grammarFragmentToString, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public EnumRule getRule() { return rule; }");
        _builder.newLine();
        {
          List<AbstractElement> _containedAbstractElements_1 = GrammarUtil.containedAbstractElements(it);
          for(final AbstractElement e_1 : _containedAbstractElements_1) {
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            String _grammarFragmentToString_1 = GrammarAccessFragment2.this._grammarAccessExtensions.grammarFragmentToString(e_1, "//");
            _builder.append(_grammarFragmentToString_1, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("public ");
            EClass _eClass_1 = e_1.eClass();
            IXtextGeneratorLanguage _language_1 = GrammarAccessFragment2.this.getLanguage();
            TypeReference _typeRef_1 = TypeReference.typeRef(_eClass_1, _language_1);
            _builder.append(_typeRef_1, "\t");
            _builder.append(" ");
            String _gaElementAccessMethodName = GrammarAccessFragment2.this._grammarAccessExtensions.gaElementAccessMethodName(e_1);
            _builder.append(_gaElementAccessMethodName, "\t");
            _builder.append("() { return ");
            String _gaElementAccessorLocalVarName_1 = GrammarAccessFragment2.this.gaElementAccessorLocalVarName(e_1);
            _builder.append(_gaElementAccessorLocalVarName_1, "\t");
            _builder.append("; }");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client;
  }
  
  protected StringConcatenationClient _cache(final ParserRule it) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("private final ");
        String _gaRuleAccessorClassName = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessorClassName(it);
        _builder.append(_gaRuleAccessorClassName, "");
        _builder.append(" ");
        String _gaRuleAccessorLocalVarName = GrammarAccessFragment2.this.gaRuleAccessorLocalVarName(it);
        _builder.append(_gaRuleAccessorLocalVarName, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    };
    return _client;
  }
  
  protected StringConcatenationClient _cache(final EnumRule it) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("private final ");
        String _gaRuleAccessorClassName = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessorClassName(it);
        _builder.append(_gaRuleAccessorClassName, "");
        _builder.append(" ");
        String _gaRuleAccessorLocalVarName = GrammarAccessFragment2.this.gaRuleAccessorLocalVarName(it);
        _builder.append(_gaRuleAccessorLocalVarName, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    };
    return _client;
  }
  
  protected StringConcatenationClient _cache(final TerminalRule it) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("private final ");
        _builder.append(TerminalRule.class, "");
        _builder.append(" ");
        String _gaRuleAccessorLocalVarName = GrammarAccessFragment2.this.gaRuleAccessorLocalVarName(it);
        _builder.append(_gaRuleAccessorLocalVarName, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    };
    return _client;
  }
  
  protected StringConcatenationClient _initializer(final ParserRule it) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("this.");
        String _gaRuleAccessorLocalVarName = GrammarAccessFragment2.this.gaRuleAccessorLocalVarName(it);
        _builder.append(_gaRuleAccessorLocalVarName, "");
        _builder.append(" = new ");
        String _gaRuleAccessorClassName = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessorClassName(it);
        _builder.append(_gaRuleAccessorClassName, "");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
      }
    };
    return _client;
  }
  
  protected StringConcatenationClient _initializer(final EnumRule it) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("this.");
        String _gaRuleAccessorLocalVarName = GrammarAccessFragment2.this.gaRuleAccessorLocalVarName(it);
        _builder.append(_gaRuleAccessorLocalVarName, "");
        _builder.append(" = new ");
        String _gaRuleAccessorClassName = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessorClassName(it);
        _builder.append(_gaRuleAccessorClassName, "");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
      }
    };
    return _client;
  }
  
  protected StringConcatenationClient _initializer(final TerminalRule it) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("this.");
        String _gaRuleAccessorLocalVarName = GrammarAccessFragment2.this.gaRuleAccessorLocalVarName(it);
        _builder.append(_gaRuleAccessorLocalVarName, "");
        _builder.append(" = (");
        _builder.append(TerminalRule.class, "");
        _builder.append(") ");
        _builder.append(GrammarUtil.class, "");
        _builder.append(".findRuleForName(getGrammar(), \"");
        String _qualifiedName = GrammarAccessFragment2.this.getQualifiedName(it);
        _builder.append(_qualifiedName, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    };
    return _client;
  }
  
  protected StringConcatenationClient _getter(final ParserRule it, final Grammar original) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        String _grammarFragmentToString = GrammarAccessFragment2.this._grammarAccessExtensions.grammarFragmentToString(it, "//");
        _builder.append(_grammarFragmentToString, "");
        _builder.newLineIfNotEmpty();
        {
          Grammar _grammar = GrammarUtil.getGrammar(it);
          boolean _tripleEquals = (_grammar == original);
          if (_tripleEquals) {
            _builder.append("public ");
            String _gaRuleAccessorClassName = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessorClassName(it);
            _builder.append(_gaRuleAccessorClassName, "");
            _builder.append(" ");
            String _gaElementsAccessor = GrammarAccessFragment2.this._grammarAccessExtensions.gaElementsAccessor(it);
            _builder.append(_gaElementsAccessor, "");
            _builder.append(" {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return ");
            String _gaRuleAccessorLocalVarName = GrammarAccessFragment2.this.gaRuleAccessorLocalVarName(it);
            _builder.append(_gaRuleAccessorLocalVarName, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("public ");
            Grammar _grammar_1 = GrammarUtil.getGrammar(it);
            TypeReference _grammarAccess = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(_grammar_1);
            _builder.append(_grammarAccess, "");
            _builder.append(".");
            String _gaBaseRuleAccessorClassName = GrammarAccessFragment2.this._grammarAccessExtensions.gaBaseRuleAccessorClassName(it);
            _builder.append(_gaBaseRuleAccessorClassName, "");
            _builder.append(" ");
            String _gaElementsAccessor_1 = GrammarAccessFragment2.this._grammarAccessExtensions.gaElementsAccessor(it);
            _builder.append(_gaElementsAccessor_1, "");
            _builder.append(" {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return ");
            Grammar _usedGrammar = GrammarAccessFragment2.this.usedGrammar(it, original);
            String _gaGrammarAccessLocalVarName = GrammarAccessFragment2.this.gaGrammarAccessLocalVarName(_usedGrammar);
            _builder.append(_gaGrammarAccessLocalVarName, "\t");
            _builder.append(".");
            String _gaBaseElementsAccessor = GrammarAccessFragment2.this._grammarAccessExtensions.gaBaseElementsAccessor(it);
            _builder.append(_gaBaseElementsAccessor, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.newLine();
        _builder.append("public ParserRule ");
        String _gaRuleAccessor = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessor(it);
        _builder.append(_gaRuleAccessor, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return ");
        String _gaElementsAccessor_2 = GrammarAccessFragment2.this._grammarAccessExtensions.gaElementsAccessor(it);
        _builder.append(_gaElementsAccessor_2, "\t");
        _builder.append(".getRule();");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client;
  }
  
  protected StringConcatenationClient _getter(final EnumRule it, final Grammar original) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        String _grammarFragmentToString = GrammarAccessFragment2.this._grammarAccessExtensions.grammarFragmentToString(it, "//");
        _builder.append(_grammarFragmentToString, "");
        _builder.newLineIfNotEmpty();
        {
          Grammar _grammar = GrammarUtil.getGrammar(it);
          boolean _tripleEquals = (_grammar == original);
          if (_tripleEquals) {
            _builder.append("public ");
            String _gaRuleAccessorClassName = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessorClassName(it);
            _builder.append(_gaRuleAccessorClassName, "");
            _builder.append(" ");
            String _gaElementsAccessor = GrammarAccessFragment2.this._grammarAccessExtensions.gaElementsAccessor(it);
            _builder.append(_gaElementsAccessor, "");
            _builder.append(" {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return ");
            String _gaRuleAccessorLocalVarName = GrammarAccessFragment2.this.gaRuleAccessorLocalVarName(it);
            _builder.append(_gaRuleAccessorLocalVarName, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("public ");
            Grammar _grammar_1 = GrammarUtil.getGrammar(it);
            TypeReference _grammarAccess = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(_grammar_1);
            _builder.append(_grammarAccess, "");
            _builder.append(".");
            String _gaRuleAccessorClassName_1 = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessorClassName(it);
            _builder.append(_gaRuleAccessorClassName_1, "");
            _builder.append(" ");
            String _gaElementsAccessor_1 = GrammarAccessFragment2.this._grammarAccessExtensions.gaElementsAccessor(it);
            _builder.append(_gaElementsAccessor_1, "");
            _builder.append(" {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return ");
            Grammar _usedGrammar = GrammarAccessFragment2.this.usedGrammar(it, original);
            String _gaGrammarAccessLocalVarName = GrammarAccessFragment2.this.gaGrammarAccessLocalVarName(_usedGrammar);
            _builder.append(_gaGrammarAccessLocalVarName, "\t");
            _builder.append(".");
            String _gaElementsAccessor_2 = GrammarAccessFragment2.this._grammarAccessExtensions.gaElementsAccessor(it);
            _builder.append(_gaElementsAccessor_2, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.newLine();
        _builder.append("public ");
        _builder.append(EnumRule.class, "");
        _builder.append(" ");
        String _gaRuleAccessor = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessor(it);
        _builder.append(_gaRuleAccessor, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return ");
        String _gaElementsAccessor_3 = GrammarAccessFragment2.this._grammarAccessExtensions.gaElementsAccessor(it);
        _builder.append(_gaElementsAccessor_3, "\t");
        _builder.append(".getRule();");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client;
  }
  
  protected StringConcatenationClient _getter(final TerminalRule it, final Grammar original) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        String _grammarFragmentToString = GrammarAccessFragment2.this._grammarAccessExtensions.grammarFragmentToString(it, "//");
        _builder.append(_grammarFragmentToString, "");
        _builder.newLineIfNotEmpty();
        _builder.append("public ");
        _builder.append(TerminalRule.class, "");
        _builder.append(" ");
        String _gaRuleAccessor = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessor(it);
        _builder.append(_gaRuleAccessor, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        {
          Grammar _grammar = GrammarUtil.getGrammar(it);
          boolean _tripleEquals = (_grammar == original);
          if (_tripleEquals) {
            _builder.append("\t");
            _builder.append("return ");
            String _gaRuleAccessorLocalVarName = GrammarAccessFragment2.this.gaRuleAccessorLocalVarName(it);
            _builder.append(_gaRuleAccessorLocalVarName, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            _builder.append("return ");
            Grammar _usedGrammar = GrammarAccessFragment2.this.usedGrammar(it, original);
            String _gaGrammarAccessLocalVarName = GrammarAccessFragment2.this.gaGrammarAccessLocalVarName(_usedGrammar);
            _builder.append(_gaGrammarAccessLocalVarName, "\t");
            _builder.append(".");
            String _gaBaseRuleAccessor = GrammarAccessFragment2.this._grammarAccessExtensions.gaBaseRuleAccessor(it);
            _builder.append(_gaBaseRuleAccessor, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client;
  }
  
  protected String gaGrammarAccessLocalVarName(final Grammar g) {
    String _simpleName = GrammarUtil.getSimpleName(g);
    return ("ga" + _simpleName);
  }
  
  protected String gaElementAccessorLocalVarName(final AbstractElement ele) {
    String _gaElementIdentifier = this._grammarAccessExtensions.gaElementIdentifier(ele);
    return ("c" + _gaElementIdentifier);
  }
  
  protected String _gaRuleAccessorLocalVarName(final ParserRule rule) {
    String _gaRuleIdentifier = this._grammarAccessExtensions.gaRuleIdentifier(rule);
    return ("p" + _gaRuleIdentifier);
  }
  
  protected String _gaRuleAccessorLocalVarName(final TerminalRule rule) {
    String _gaRuleIdentifier = this._grammarAccessExtensions.gaRuleIdentifier(rule);
    return ("t" + _gaRuleIdentifier);
  }
  
  protected String _gaRuleAccessorLocalVarName(final EnumRule rule) {
    String _gaRuleIdentifier = this._grammarAccessExtensions.gaRuleIdentifier(rule);
    return ("e" + _gaRuleIdentifier);
  }
  
  protected StringConcatenationClient loadElementStatement(final AbstractElement ele) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("(");
        EClass _eClass = ele.eClass();
        IXtextGeneratorLanguage _language = GrammarAccessFragment2.this.getLanguage();
        TypeReference _typeRef = TypeReference.typeRef(_eClass, _language);
        _builder.append(_typeRef, "");
        _builder.append(")");
        String _loadElementParentStatement = GrammarAccessFragment2.this.loadElementParentStatement(ele);
        _builder.append(_loadElementParentStatement, "");
        _builder.append(".eContents().get(");
        EObject _eContainer = ele.eContainer();
        EList<EObject> _eContents = _eContainer.eContents();
        int _indexOf = _eContents.indexOf(ele);
        _builder.append(_indexOf, "");
        _builder.append(")");
      }
    };
    return _client;
  }
  
  protected String loadElementParentStatement(final AbstractElement ele) {
    String _xifexpression = null;
    EObject _eContainer = ele.eContainer();
    if ((_eContainer instanceof AbstractElement)) {
      EObject _eContainer_1 = ele.eContainer();
      _xifexpression = this.gaElementAccessorLocalVarName(((AbstractElement) _eContainer_1));
    } else {
      _xifexpression = "rule";
    }
    return _xifexpression;
  }
  
  protected Grammar usedGrammar(final AbstractRule rule, final Grammar parent) {
    EList<Grammar> _usedGrammars = parent.getUsedGrammars();
    final Function1<Grammar, Boolean> _function = new Function1<Grammar, Boolean>() {
      @Override
      public Boolean apply(final Grammar it) {
        List<AbstractRule> _allRules = GrammarUtil.allRules(it);
        return Boolean.valueOf(_allRules.contains(rule));
      }
    };
    return IterableExtensions.<Grammar>findFirst(_usedGrammars, _function);
  }
  
  protected StringConcatenationClient cache(final AbstractRule it) {
    if (it instanceof EnumRule) {
      return _cache((EnumRule)it);
    } else if (it instanceof ParserRule) {
      return _cache((ParserRule)it);
    } else if (it instanceof TerminalRule) {
      return _cache((TerminalRule)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  protected StringConcatenationClient initializer(final AbstractRule it) {
    if (it instanceof EnumRule) {
      return _initializer((EnumRule)it);
    } else if (it instanceof ParserRule) {
      return _initializer((ParserRule)it);
    } else if (it instanceof TerminalRule) {
      return _initializer((TerminalRule)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  protected StringConcatenationClient getter(final AbstractRule it, final Grammar original) {
    if (it instanceof EnumRule) {
      return _getter((EnumRule)it, original);
    } else if (it instanceof ParserRule) {
      return _getter((ParserRule)it, original);
    } else if (it instanceof TerminalRule) {
      return _getter((TerminalRule)it, original);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, original).toString());
    }
  }
  
  protected String gaRuleAccessorLocalVarName(final AbstractRule rule) {
    if (rule instanceof EnumRule) {
      return _gaRuleAccessorLocalVarName((EnumRule)rule);
    } else if (rule instanceof ParserRule) {
      return _gaRuleAccessorLocalVarName((ParserRule)rule);
    } else if (rule instanceof TerminalRule) {
      return _gaRuleAccessorLocalVarName((TerminalRule)rule);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(rule).toString());
    }
  }
  
  private final static Logger LOG = Logger.getLogger(GrammarAccessFragment2.class);
  
  @Pure
  public String getXmlVersion() {
    return this.xmlVersion;
  }
  
  public void setXmlVersion(final String xmlVersion) {
    this.xmlVersion = xmlVersion;
  }
}
