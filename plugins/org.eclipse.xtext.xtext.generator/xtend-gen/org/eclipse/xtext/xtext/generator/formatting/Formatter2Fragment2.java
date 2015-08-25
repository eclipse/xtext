/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.formatting;

import com.google.common.base.Objects;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.FormatterPreferenceValuesProvider;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.eclipse.xtext.xtext.generator.util.GenModelUtil2;
import org.eclipse.xtext.xtext.generator.util.GrammarUtil2;

@SuppressWarnings("all")
public class Formatter2Fragment2 extends AbstractGeneratorFragment2 {
  @Inject
  private IXtextProjectConfig projectConfig;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  @Extension
  private GrammarAccessExtensions _grammarAccessExtensions;
  
  protected TypeReference getFormatter2Stub(final Grammar grammar) {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(grammar);
    String _plus = (_runtimeBasePackage + ".formatting2.");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "Formatter");
    return new TypeReference(_plus_2);
  }
  
  @Override
  public void generate() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        _builder.append(IPreferenceValuesProvider.class, "");
        _builder.append(".class).annotatedWith(");
        _builder.append(FormatterPreferences.class, "");
        _builder.append(".class).to(");
        _builder.append(FormatterPreferenceValuesProvider.class, "");
        _builder.append(".class);");
      }
    };
    final StringConcatenationClient statement = _client;
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef = TypeReference.typeRef(IFormatter2.class);
    LanguageConfig2 _language = this.getLanguage();
    Grammar _grammar = _language.getGrammar();
    TypeReference _formatter2Stub = this.getFormatter2Stub(_grammar);
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeRef, _formatter2Stub);
    String _simpleName = FormatterPreferences.class.getSimpleName();
    GuiceModuleAccess.BindingFactory _addConfiguredBinding = _addTypeToType.addConfiguredBinding(_simpleName, statement);
    LanguageConfig2 _language_1 = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule = _language_1.getRuntimeGenModule();
    _addConfiguredBinding.contributeTo(_runtimeGenModule);
    GuiceModuleAccess.BindingFactory _bindingFactory_1 = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory");
    TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.formatting2.ContentFormatterFactory");
    GuiceModuleAccess.BindingFactory _addTypeToType_1 = _bindingFactory_1.addTypeToType(_typeRef_1, _typeRef_2);
    LanguageConfig2 _language_2 = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule = _language_2.getEclipsePluginGenModule();
    _addTypeToType_1.contributeTo(_eclipsePluginGenModule);
    this.doGenerateStubFile();
  }
  
  protected void doGenerateStubFile() {
    LanguageConfig2 _language = this.getLanguage();
    Grammar _grammar = this.getGrammar();
    TypeReference _formatter2Stub = this.getFormatter2Stub(_grammar);
    final XtendFileAccess xtendFile = this.fileAccessFactory.createXtendFile(_language, _formatter2Stub);
    final LinkedHashMultimap<EClass, EReference> type2ref = LinkedHashMultimap.<EClass, EReference>create();
    LanguageConfig2 _language_1 = this.getLanguage();
    Grammar _grammar_1 = _language_1.getGrammar();
    this.getLocallyAssignedContainmentReferences(_grammar_1, type2ref);
    final LinkedHashMultimap<EClass, EReference> inheritedTypes = LinkedHashMultimap.<EClass, EReference>create();
    LanguageConfig2 _language_2 = this.getLanguage();
    Grammar _grammar_2 = _language_2.getGrammar();
    HashSet<Grammar> _newHashSet = CollectionLiterals.<Grammar>newHashSet();
    this.getInheritedContainmentReferences(_grammar_2, inheritedTypes, _newHashSet);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("class ");
        Grammar _grammar = Formatter2Fragment2.this.getGrammar();
        TypeReference _formatter2Stub = Formatter2Fragment2.this.getFormatter2Stub(_grammar);
        String _simpleName = _formatter2Stub.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _stubSuperClass = Formatter2Fragment2.this.getStubSuperClass();
        _builder.append(_stubSuperClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.append(" extension ");
        Grammar _grammar_1 = Formatter2Fragment2.this.getGrammar();
        TypeReference _grammarAccess = Formatter2Fragment2.this._grammarAccessExtensions.getGrammarAccess(_grammar_1);
        _builder.append(_grammarAccess, "\t");
        _builder.newLineIfNotEmpty();
        {
          Set<EClass> _keySet = type2ref.keySet();
          for(final EClass type : _keySet) {
            _builder.newLine();
            _builder.append("\t");
            Set<EReference> _get = type2ref.get(type);
            boolean _containsKey = inheritedTypes.containsKey(type);
            StringConcatenationClient _generateFormatMethod = Formatter2Fragment2.this.generateFormatMethod(type, _get, _containsKey);
            _builder.append(_generateFormatMethod, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    xtendFile.setJavaContent(_client);
    IXtextGeneratorFileSystemAccess _runtimeSrc = this.projectConfig.getRuntimeSrc();
    xtendFile.writeTo(_runtimeSrc);
  }
  
  protected StringConcatenationClient generateFormatMethod(final EClass clazz, final Collection<EReference> containmentRefs, final boolean isOverriding) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          if (isOverriding) {
            _builder.append("override");
          } else {
            _builder.append("def");
          }
        }
        _builder.append(" dispatch void format(");
        _builder.append(clazz, "");
        _builder.append(" ");
        String _name = Formatter2Fragment2.this.toName(clazz);
        _builder.append(_name, "");
        _builder.append(", extension ");
        _builder.append(IFormattableDocument.class, "");
        _builder.append(" document) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("// TODO: format HiddenRegions around keywords, attributes, cross references, etc. ");
        _builder.newLine();
        {
          for(final EReference ref : containmentRefs) {
            {
              boolean _isMany = ref.isMany();
              if (_isMany) {
                _builder.append("\t");
                _builder.append("for (");
                EClass _eReferenceType = ref.getEReferenceType();
                _builder.append(_eReferenceType, "\t");
                _builder.append(" ");
                String _name_1 = ref.getName();
                _builder.append(_name_1, "\t");
                _builder.append(" : ");
                String _name_2 = Formatter2Fragment2.this.toName(clazz);
                _builder.append(_name_2, "\t");
                _builder.append(".");
                String _getAccessor = Formatter2Fragment2.this.getGetAccessor(ref);
                _builder.append(_getAccessor, "\t");
                _builder.append("()) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("format(");
                String _name_3 = ref.getName();
                _builder.append(_name_3, "\t\t");
                _builder.append(", document);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              } else {
                _builder.append("\t");
                _builder.append("format(");
                String _name_4 = Formatter2Fragment2.this.toName(clazz);
                _builder.append(_name_4, "\t");
                _builder.append(".");
                String _getAccessor_1 = Formatter2Fragment2.this.getGetAccessor(ref);
                _builder.append(_getAccessor_1, "\t");
                _builder.append("(), document);");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client;
  }
  
  protected void getLocallyAssignedContainmentReferences(final Grammar grammar, final Multimap<EClass, EReference> type2ref) {
    List<Assignment> _containedAssignments = GrammarUtil.containedAssignments(grammar);
    for (final Assignment assignment : _containedAssignments) {
      {
        final EClassifier type = GrammarUtil.findCurrentType(assignment);
        if ((type instanceof EClass)) {
          String _feature = assignment.getFeature();
          final EStructuralFeature feature = ((EClass)type).getEStructuralFeature(_feature);
          boolean _and = false;
          if (!(feature instanceof EReference)) {
            _and = false;
          } else {
            boolean _isContainment = ((EReference) feature).isContainment();
            _and = _isContainment;
          }
          if (_and) {
            type2ref.put(((EClass)type), ((EReference) feature));
          }
        }
      }
    }
    List<Action> _containedActions = GrammarUtil.containedActions(grammar);
    for (final Action action : _containedActions) {
      {
        final String featureName = action.getFeature();
        boolean _notEquals = (!Objects.equal(featureName, null));
        if (_notEquals) {
          TypeRef _type = action.getType();
          final EClassifier type = _type.getClassifier();
          if ((type instanceof EClass)) {
            final EStructuralFeature feature = ((EClass)type).getEStructuralFeature(featureName);
            boolean _and = false;
            if (!(feature instanceof EReference)) {
              _and = false;
            } else {
              boolean _isContainment = ((EReference) feature).isContainment();
              _and = _isContainment;
            }
            if (_and) {
              type2ref.put(((EClass)type), ((EReference) feature));
            }
          }
        }
      }
    }
  }
  
  protected void getInheritedContainmentReferences(final Grammar grammar, final Multimap<EClass, EReference> type2ref, final Set<Grammar> visitedGrammars) {
    visitedGrammars.add(grammar);
    EList<Grammar> _usedGrammars = grammar.getUsedGrammars();
    for (final Grammar usedGrammar : _usedGrammars) {
      boolean _contains = visitedGrammars.contains(usedGrammar);
      boolean _not = (!_contains);
      if (_not) {
        this.getLocallyAssignedContainmentReferences(usedGrammar, type2ref);
        this.getInheritedContainmentReferences(usedGrammar, type2ref, visitedGrammars);
      }
    }
  }
  
  protected TypeReference getStubSuperClass() {
    LanguageConfig2 _language = this.getLanguage();
    Grammar _grammar = _language.getGrammar();
    final Grammar superGrammar = GrammarUtil2.getNonTerminalsSuperGrammar(_grammar);
    boolean _notEquals = (!Objects.equal(superGrammar, null));
    if (_notEquals) {
      return this.getFormatter2Stub(superGrammar);
    } else {
      return TypeReference.typeRef(AbstractFormatter2.class);
    }
  }
  
  protected String toName(final EClass clazz) {
    String _name = clazz.getName();
    return _name.toLowerCase();
  }
  
  protected String getGetAccessor(final EStructuralFeature feature) {
    LanguageConfig2 _language = this.getLanguage();
    ResourceSet _resourceSet = _language.getResourceSet();
    GenFeature _genFeature = GenModelUtil2.getGenFeature(feature, _resourceSet);
    return _genFeature.getGetAccessor();
  }
}
