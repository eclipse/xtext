/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.xtend.lib.annotations.AccessorType;
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
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.grammarAccess.FragmentFakingEcoreResource;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation;
import org.eclipse.xtext.xtext.generator.model.annotations.SingletonClassAnnotation;

@Log
@SuppressWarnings("all")
public class GrammarAccessFragment2 extends AbstractXtextGeneratorFragment {
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  @Inject
  @Extension
  private GrammarAccessExtensions _grammarAccessExtensions;
  
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String xmlVersion;
  
  @Override
  public void generate() {
    final GuiceModuleAccess.BindingFactory bindingFactory = new GuiceModuleAccess.BindingFactory();
    String _name = this.getLanguage().getGrammar().getName();
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
    bindingFactory.addTypeToType(TypeReference.typeRef(IGrammarAccess.class), this._grammarAccessExtensions.getGrammarAccess(this.getLanguage().getGrammar())).contributeTo(this.getLanguage().getRuntimeGenModule());
    ManifestAccess _manifest = this.getProjectConfig().getRuntime().getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(this.getGrammar());
      String _runtimeBasePackage_1 = this._xtextGeneratorNaming.getRuntimeBasePackage(this.getGrammar());
      String _plus = (_runtimeBasePackage_1 + ".services");
      this.getProjectConfig().getRuntime().getManifest().getExportedPackages().addAll(
        Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_runtimeBasePackage, _plus)));
    }
    this.doGenerateGrammarAccess();
    this.writeGrammar();
  }
  
  protected String getQualifiedName(final AbstractRule rule) {
    String _name = GrammarUtil.getGrammar(rule).getName();
    String _plus = (_name + ".");
    String _name_1 = rule.getName();
    return (_plus + _name_1);
  }
  
  protected void writeGrammar() {
    final Wrapper<Boolean> isSaving = Wrapper.<Boolean>wrap(Boolean.valueOf(false));
    final ResourceSet cloneInto = new ResourceSetImpl();
    Map<String, Object> _extensionToFactoryMap = cloneInto.getResourceFactoryRegistry().getExtensionToFactoryMap();
    FragmentFakingEcoreResource.FactoryImpl _factoryImpl = new FragmentFakingEcoreResource.FactoryImpl(isSaving);
    _extensionToFactoryMap.put(
      FragmentFakingEcoreResource.FactoryImpl.ECORE_SUFFIX, _factoryImpl);
    final ResourceSet resourceSet = EcoreUtil2.<ResourceSet>clone(cloneInto, this.getLanguage().getGrammar().eResource().getResourceSet());
    EObject _head = IterableExtensions.<EObject>head(resourceSet.getResource(this.getLanguage().getGrammar().eResource().getURI(), true).getContents());
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
    final URI uri = this.getProjectConfig().getRuntime().getSrcGen().getURI(path);
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
        GrammarAccessFragment2.LOG.error(e.getMessage(), e);
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
    resource.getContents().add(grammar);
    EList<AbstractMetamodelDeclaration> _metamodelDeclarations = grammar.getMetamodelDeclarations();
    for (final AbstractMetamodelDeclaration metamodelDecl : _metamodelDeclarations) {
      {
        final EPackage pack = metamodelDecl.getEPackage();
        final Resource packResource = pack.eResource();
        String _string = packResource.getURI().toString();
        String _nsURI = pack.getNsURI();
        boolean _notEquals = (!Objects.equal(_string, _nsURI));
        if (_notEquals) {
          final ResourceSet packResourceSet = packResource.getResourceSet();
          if ((packResourceSet != null)) {
            EPackage topMost = pack;
            while (((topMost.getESuperPackage() != null) && (topMost.getESuperPackage().eResource() == topMost.eResource()))) {
              topMost = topMost.getESuperPackage();
            }
            if ((packResource.getContents().contains(topMost) && (packResource.getContents().size() == 1))) {
              boolean _isEmpty = topMost.getEClassifiers().isEmpty();
              boolean _not_1 = (!_isEmpty);
              if (_not_1) {
                packResource.setURI(URI.createURI(topMost.getNsURI()));
              } else {
                this.moveSubpackagesToNewResource(topMost, resource.getResourceSet());
              }
            }
            boolean _equals = topMost.eResource().getURI().toString().equals(topMost.getNsURI());
            boolean _not_2 = (!_equals);
            if (_not_2) {
              this.movePackageToNewResource(topMost, resource.getResourceSet());
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
        final EPackage sub = pack.getESubpackages().get(i);
        Resource _eResource = sub.eResource();
        Resource _eResource_1 = pack.eResource();
        boolean _tripleEquals = (_eResource == _eResource_1);
        if (_tripleEquals) {
          boolean _isEmpty = sub.getEClassifiers().isEmpty();
          if (_isEmpty) {
            this.moveSubpackagesToNewResource(sub, set);
          } else {
            this.movePackageToNewResource(sub, set);
            pack.getESubpackages().remove(i);
          }
        }
      }
    }
  }
  
  protected void movePackageToNewResource(final EPackage pack, final ResourceSet set) {
    final Resource resource = set.createResource(
      URI.createURI(("___temp___." + FragmentFakingEcoreResource.FactoryImpl.ECORE_SUFFIX)), 
      ContentHandler.UNSPECIFIED_CONTENT_TYPE);
    resource.setURI(URI.createURI(pack.getNsURI()));
    resource.getContents().add(pack);
  }
  
  protected void doGenerateGrammarAccess() {
    final GeneratedJavaFileAccess javaFile = this.fileAccessFactory.createGeneratedJavaFile(this._grammarAccessExtensions.getGrammarAccess(this.getGrammar()));
    javaFile.setImportNestedTypeThreshold(JavaFileAccess.DONT_IMPORT_NESTED_TYPES);
    List<IClassAnnotation> _annotations = javaFile.getAnnotations();
    SingletonClassAnnotation _singletonClassAnnotation = new SingletonClassAnnotation();
    _annotations.add(_singletonClassAnnotation);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        String _simpleName = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(GrammarAccessFragment2.this.getLanguage().getGrammar()).getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        _builder.append(AbstractElementFinder.AbstractGrammarElementFinder.class);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        {
          Iterable<ParserRule> _filter = Iterables.<ParserRule>filter(GrammarAccessFragment2.this.getLanguage().getGrammar().getRules(), ParserRule.class);
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
          Iterable<EnumRule> _filter_1 = Iterables.<EnumRule>filter(GrammarAccessFragment2.this.getLanguage().getGrammar().getRules(), EnumRule.class);
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
          EList<AbstractRule> _rules = GrammarAccessFragment2.this.getLanguage().getGrammar().getRules();
          for(final AbstractRule r_2 : _rules) {
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
          List<Grammar> _effectivelyUsedGrammars = GrammarAccessFragment2.this.getEffectivelyUsedGrammars(GrammarAccessFragment2.this.getLanguage().getGrammar());
          for(final Grammar g : _effectivelyUsedGrammars) {
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("private final ");
            TypeReference _grammarAccess = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(g);
            _builder.append(_grammarAccess, "\t");
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
        String _simpleName_1 = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(GrammarAccessFragment2.this.getLanguage().getGrammar()).getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(");
        _builder.append(GrammarProvider.class, "\t");
        _builder.append(" grammarProvider");
        {
          List<Grammar> _effectivelyUsedGrammars_1 = GrammarAccessFragment2.this.getEffectivelyUsedGrammars(GrammarAccessFragment2.this.getLanguage().getGrammar());
          for(final Grammar g_1 : _effectivelyUsedGrammars_1) {
            _builder.append(",");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            TypeReference _grammarAccess_1 = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(g_1);
            _builder.append(_grammarAccess_1, "\t\t\t");
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
          List<Grammar> _effectivelyUsedGrammars_2 = GrammarAccessFragment2.this.getEffectivelyUsedGrammars(GrammarAccessFragment2.this.getLanguage().getGrammar());
          for(final Grammar g_2 : _effectivelyUsedGrammars_2) {
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
          EList<AbstractRule> _rules_1 = GrammarAccessFragment2.this.getLanguage().getGrammar().getRules();
          for(final AbstractRule r_3 : _rules_1) {
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
        String _name = GrammarAccessFragment2.this.getLanguage().getGrammar().getName();
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
          List<Grammar> _effectivelyUsedGrammars_3 = GrammarAccessFragment2.this.getEffectivelyUsedGrammars(GrammarAccessFragment2.this.getLanguage().getGrammar());
          for(final Grammar g_3 : _effectivelyUsedGrammars_3) {
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public ");
            TypeReference _grammarAccess_2 = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(g_3);
            _builder.append(_grammarAccess_2, "\t");
            _builder.append(" get");
            String _simpleName_2 = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(g_3).getSimpleName();
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
          List<AbstractRule> _allRules = GrammarUtil.allRules(GrammarAccessFragment2.this.getLanguage().getGrammar());
          for(final AbstractRule r_4 : _allRules) {
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            StringConcatenationClient _ter = GrammarAccessFragment2.this.getter(r_4, GrammarAccessFragment2.this.getLanguage().getGrammar());
            _builder.append(_ter, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setContent(_client);
    javaFile.writeTo(this.getProjectConfig().getRuntime().getSrcGen());
  }
  
  protected StringConcatenationClient parserRuleClasses(final ParserRule it) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        String _gaRuleAccessorClassName = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessorClassName(it);
        _builder.append(_gaRuleAccessorClassName);
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
            TypeReference _typeRef = TypeReference.typeRef(e.eClass(), GrammarAccessFragment2.this.getLanguage());
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
            TypeReference _typeRef_1 = TypeReference.typeRef(e_1.eClass(), GrammarAccessFragment2.this.getLanguage());
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
        _builder.append(_gaRuleAccessorClassName);
        _builder.append(" extends ");
        _builder.append(AbstractElementFinder.AbstractEnumRuleElementFinder.class);
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
            TypeReference _typeRef = TypeReference.typeRef(e.eClass(), GrammarAccessFragment2.this.getLanguage());
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
            TypeReference _typeRef_1 = TypeReference.typeRef(e_1.eClass(), GrammarAccessFragment2.this.getLanguage());
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
        _builder.append(_gaRuleAccessorClassName);
        _builder.append(" ");
        String _gaRuleAccessorLocalVarName = GrammarAccessFragment2.this.gaRuleAccessorLocalVarName(it);
        _builder.append(_gaRuleAccessorLocalVarName);
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
        _builder.append(_gaRuleAccessorClassName);
        _builder.append(" ");
        String _gaRuleAccessorLocalVarName = GrammarAccessFragment2.this.gaRuleAccessorLocalVarName(it);
        _builder.append(_gaRuleAccessorLocalVarName);
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
        _builder.append(TerminalRule.class);
        _builder.append(" ");
        String _gaRuleAccessorLocalVarName = GrammarAccessFragment2.this.gaRuleAccessorLocalVarName(it);
        _builder.append(_gaRuleAccessorLocalVarName);
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
        _builder.append(_gaRuleAccessorLocalVarName);
        _builder.append(" = new ");
        String _gaRuleAccessorClassName = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessorClassName(it);
        _builder.append(_gaRuleAccessorClassName);
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
        _builder.append(_gaRuleAccessorLocalVarName);
        _builder.append(" = new ");
        String _gaRuleAccessorClassName = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessorClassName(it);
        _builder.append(_gaRuleAccessorClassName);
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
        _builder.append(_gaRuleAccessorLocalVarName);
        _builder.append(" = (");
        _builder.append(TerminalRule.class);
        _builder.append(") ");
        _builder.append(GrammarUtil.class);
        _builder.append(".findRuleForName(getGrammar(), \"");
        String _qualifiedName = GrammarAccessFragment2.this.getQualifiedName(it);
        _builder.append(_qualifiedName);
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
        _builder.append(_grammarFragmentToString);
        _builder.newLineIfNotEmpty();
        {
          Grammar _grammar = GrammarUtil.getGrammar(it);
          boolean _tripleEquals = (_grammar == original);
          if (_tripleEquals) {
            _builder.append("public ");
            String _gaRuleAccessorClassName = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessorClassName(it);
            _builder.append(_gaRuleAccessorClassName);
            _builder.append(" ");
            String _gaElementsAccessor = GrammarAccessFragment2.this._grammarAccessExtensions.gaElementsAccessor(it);
            _builder.append(_gaElementsAccessor);
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
            TypeReference _grammarAccess = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(GrammarUtil.getGrammar(it));
            _builder.append(_grammarAccess);
            _builder.append(".");
            String _gaBaseRuleAccessorClassName = GrammarAccessFragment2.this._grammarAccessExtensions.gaBaseRuleAccessorClassName(it);
            _builder.append(_gaBaseRuleAccessorClassName);
            _builder.append(" ");
            String _gaElementsAccessor_1 = GrammarAccessFragment2.this._grammarAccessExtensions.gaElementsAccessor(it);
            _builder.append(_gaElementsAccessor_1);
            _builder.append(" {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return ");
            String _gaGrammarAccessLocalVarName = GrammarAccessFragment2.this.gaGrammarAccessLocalVarName(GrammarUtil.getGrammar(it));
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
        _builder.append(_gaRuleAccessor);
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
        _builder.append(_grammarFragmentToString);
        _builder.newLineIfNotEmpty();
        {
          Grammar _grammar = GrammarUtil.getGrammar(it);
          boolean _tripleEquals = (_grammar == original);
          if (_tripleEquals) {
            _builder.append("public ");
            String _gaRuleAccessorClassName = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessorClassName(it);
            _builder.append(_gaRuleAccessorClassName);
            _builder.append(" ");
            String _gaElementsAccessor = GrammarAccessFragment2.this._grammarAccessExtensions.gaElementsAccessor(it);
            _builder.append(_gaElementsAccessor);
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
            TypeReference _grammarAccess = GrammarAccessFragment2.this._grammarAccessExtensions.getGrammarAccess(GrammarUtil.getGrammar(it));
            _builder.append(_grammarAccess);
            _builder.append(".");
            String _gaRuleAccessorClassName_1 = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessorClassName(it);
            _builder.append(_gaRuleAccessorClassName_1);
            _builder.append(" ");
            String _gaElementsAccessor_1 = GrammarAccessFragment2.this._grammarAccessExtensions.gaElementsAccessor(it);
            _builder.append(_gaElementsAccessor_1);
            _builder.append(" {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return ");
            String _gaGrammarAccessLocalVarName = GrammarAccessFragment2.this.gaGrammarAccessLocalVarName(GrammarUtil.getGrammar(it));
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
        _builder.append(EnumRule.class);
        _builder.append(" ");
        String _gaRuleAccessor = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessor(it);
        _builder.append(_gaRuleAccessor);
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
        _builder.append(_grammarFragmentToString);
        _builder.newLineIfNotEmpty();
        _builder.append("public ");
        _builder.append(TerminalRule.class);
        _builder.append(" ");
        String _gaRuleAccessor = GrammarAccessFragment2.this._grammarAccessExtensions.gaRuleAccessor(it);
        _builder.append(_gaRuleAccessor);
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
            String _gaGrammarAccessLocalVarName = GrammarAccessFragment2.this.gaGrammarAccessLocalVarName(GrammarUtil.getGrammar(it));
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
        TypeReference _typeRef = TypeReference.typeRef(ele.eClass(), GrammarAccessFragment2.this.getLanguage());
        _builder.append(_typeRef);
        _builder.append(")");
        String _loadElementParentStatement = GrammarAccessFragment2.this.loadElementParentStatement(ele);
        _builder.append(_loadElementParentStatement);
        _builder.append(".eContents().get(");
        int _indexOf = ele.eContainer().eContents().indexOf(ele);
        _builder.append(_indexOf);
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
  
  /**
   * Returns all grammars from the hierarchy that are used from rules of this grammar.
   */
  protected List<Grammar> getEffectivelyUsedGrammars(final Grammar grammar) {
    final Function1<AbstractRule, Grammar> _function = (AbstractRule it) -> {
      return GrammarUtil.getGrammar(it);
    };
    final Function1<Grammar, Boolean> _function_1 = (Grammar it) -> {
      return Boolean.valueOf((it != grammar));
    };
    return IterableExtensions.<Grammar>toList(IterableExtensions.<Grammar>toSet(IterableExtensions.<Grammar>filter(ListExtensions.<AbstractRule, Grammar>map(GrammarUtil.allRules(grammar), _function), _function_1)));
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
  
  private static final Logger LOG = Logger.getLogger(GrammarAccessFragment2.class);
  
  public void setXmlVersion(final String xmlVersion) {
    this.xmlVersion = xmlVersion;
  }
}
