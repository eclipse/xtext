/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.serializer;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.antlr.AbstractSplittingTokenSource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.analysis.GrammarAlias;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation;
import org.eclipse.xtext.xtext.generator.model.annotations.SuppressWarningsAnnotation;
import org.eclipse.xtext.xtext.generator.serializer.DebugGraphGenerator;
import org.eclipse.xtext.xtext.generator.serializer.EqualAmbiguousTransitions;
import org.eclipse.xtext.xtext.generator.serializer.SemanticSequencerExtensions;
import org.eclipse.xtext.xtext.generator.serializer.SyntacticSequencerExtensions;
import org.eclipse.xtext.xtext.generator.util.GenModelUtil2;
import org.eclipse.xtext.xtext.generator.util.SyntheticTerminalDetector;

@SuppressWarnings("all")
public class SerializerFragment2 extends AbstractGeneratorFragment2 {
  private static <K extends Object, V extends Object> Map<K, V> toMap(final Iterable<Pair<K, V>> items) {
    LinkedHashMap<K, V> _xblockexpression = null;
    {
      final LinkedHashMap<K, V> result = CollectionLiterals.<K, V>newLinkedHashMap();
      for (final Pair<K, V> i : items) {
        K _key = i.getKey();
        V _value = i.getValue();
        result.put(_key, _value);
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  @Extension
  private SyntheticTerminalDetector _syntheticTerminalDetector;
  
  @Inject
  @Extension
  private SemanticSequencerExtensions _semanticSequencerExtensions;
  
  @Inject
  @Extension
  private SyntacticSequencerExtensions _syntacticSequencerExtensions;
  
  @Inject
  @Extension
  private GrammarAccessExtensions _grammarAccessExtensions;
  
  @Inject
  @Extension
  private Context2NameFunction _context2NameFunction;
  
  @Inject
  private DebugGraphGenerator debugGraphGenerator;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  @Inject
  private CodeConfig codeConfig;
  
  @Accessors
  private boolean generateDebugData = false;
  
  @Accessors
  private boolean generateStub = true;
  
  private boolean detectSyntheticTerminals = true;
  
  /**
   * Set to false if synthetic terminal should be ignored. Synthetic terminals
   * have the form {@code terminal ABC: 'synthetic:ABC';} in the grammar
   * and require a customized {@link AbstractSplittingTokenSource token source}.
   */
  public void setDetectSyntheticTerminals(final boolean detectSyntheticTerminals) {
    this.detectSyntheticTerminals = detectSyntheticTerminals;
  }
  
  protected String getSerializerBasePackage(final Grammar grammar) {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(grammar);
    return (_runtimeBasePackage + ".serializer");
  }
  
  protected TypeReference getSemanticSequencerClass(final Grammar grammar) {
    String _serializerBasePackage = this.getSerializerBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = (_simpleName + "SemanticSequencer");
    return new TypeReference(_serializerBasePackage, _plus);
  }
  
  protected TypeReference getSyntacticSequencerClass(final Grammar grammar) {
    String _serializerBasePackage = this.getSerializerBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = (_simpleName + "SyntacticSequencer");
    return new TypeReference(_serializerBasePackage, _plus);
  }
  
  protected TypeReference getAbstractSemanticSequencerClass(final Grammar grammar) {
    String _serializerBasePackage = this.getSerializerBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = ("Abstract" + _simpleName);
    String _plus_1 = (_plus + "SemanticSequencer");
    return new TypeReference(_serializerBasePackage, _plus_1);
  }
  
  protected TypeReference getAbstractSyntacticSequencerClass(final Grammar grammar) {
    String _serializerBasePackage = this.getSerializerBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = ("Abstract" + _simpleName);
    String _plus_1 = (_plus + "SyntacticSequencer");
    return new TypeReference(_serializerBasePackage, _plus_1);
  }
  
  protected String getGrammarConstraintsPath(final Grammar grammar) {
    String _serializerBasePackage = this.getSerializerBasePackage(grammar);
    String _replace = _serializerBasePackage.replace(".", "/");
    String _plus = (_replace + "/");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "GrammarConstraints.xtext");
  }
  
  @Override
  public void generate() {
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef = TypeReference.typeRef(ISemanticSequencer.class);
    Grammar _grammar = this.getGrammar();
    TypeReference _semanticSequencerClass = this.getSemanticSequencerClass(_grammar);
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeRef, _semanticSequencerClass);
    TypeReference _typeRef_1 = TypeReference.typeRef(ISyntacticSequencer.class);
    Grammar _grammar_1 = this.getGrammar();
    TypeReference _syntacticSequencerClass = this.getSyntacticSequencerClass(_grammar_1);
    GuiceModuleAccess.BindingFactory _addTypeToType_1 = _addTypeToType.addTypeToType(_typeRef_1, _syntacticSequencerClass);
    TypeReference _typeRef_2 = TypeReference.typeRef(ISerializer.class);
    TypeReference _typeRef_3 = TypeReference.typeRef(Serializer.class);
    GuiceModuleAccess.BindingFactory _addTypeToType_2 = _addTypeToType_1.addTypeToType(_typeRef_2, _typeRef_3);
    ILanguageConfig _language = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule = _language.getRuntimeGenModule();
    _addTypeToType_2.contributeTo(_runtimeGenModule);
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
      String _serializerBasePackage = this.getSerializerBasePackage(_grammar_2);
      _exportedPackages.add(_serializerBasePackage);
      IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_2 = _projectConfig_2.getRuntime();
      ManifestAccess _manifest_2 = _runtime_2.getManifest();
      Set<String> _requiredBundles = _manifest_2.getRequiredBundles();
      _requiredBundles.add("org.eclipse.xtext.xbase.lib");
    }
    this.generateAbstractSemanticSequencer();
    this.generateAbstractSyntacticSequencer();
    if (this.generateStub) {
      this.generateSemanticSequencer();
      this.generateSyntacticSequencer();
    }
    if (this.generateDebugData) {
      this.generateGrammarConstraints();
      Iterable<Pair<String, String>> _generateDebugGraphs = this.debugGraphGenerator.generateDebugGraphs();
      for (final Pair<String, String> fileToContent : _generateDebugGraphs) {
        IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
        IRuntimeProjectConfig _runtime_3 = _projectConfig_3.getRuntime();
        IXtextGeneratorFileSystemAccess _srcGen = _runtime_3.getSrcGen();
        String _key = fileToContent.getKey();
        String _value = fileToContent.getValue();
        _srcGen.generateFile(_key, _value);
      }
    }
  }
  
  protected void generateSemanticSequencer() {
    boolean _isPreferXtendStubs = this.codeConfig.isPreferXtendStubs();
    if (_isPreferXtendStubs) {
      Grammar _grammar = this.getGrammar();
      TypeReference _semanticSequencerClass = this.getSemanticSequencerClass(_grammar);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("class ");
          Grammar _grammar = SerializerFragment2.this.getGrammar();
          TypeReference _semanticSequencerClass = SerializerFragment2.this.getSemanticSequencerClass(_grammar);
          String _simpleName = _semanticSequencerClass.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append(" extends ");
          Grammar _grammar_1 = SerializerFragment2.this.getGrammar();
          TypeReference _abstractSemanticSequencerClass = SerializerFragment2.this.getAbstractSemanticSequencerClass(_grammar_1);
          _builder.append(_abstractSemanticSequencerClass, "");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        }
      };
      XtendFileAccess _createXtendFile = this.fileAccessFactory.createXtendFile(_semanticSequencerClass, _client);
      IXtextProjectConfig _projectConfig = this.getProjectConfig();
      IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
      IXtextGeneratorFileSystemAccess _src = _runtime.getSrc();
      _createXtendFile.writeTo(_src);
    } else {
      Grammar _grammar_1 = this.getGrammar();
      TypeReference _semanticSequencerClass_1 = this.getSemanticSequencerClass(_grammar_1);
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          Grammar _grammar = SerializerFragment2.this.getGrammar();
          TypeReference _semanticSequencerClass = SerializerFragment2.this.getSemanticSequencerClass(_grammar);
          String _simpleName = _semanticSequencerClass.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append(" extends ");
          Grammar _grammar_1 = SerializerFragment2.this.getGrammar();
          TypeReference _abstractSemanticSequencerClass = SerializerFragment2.this.getAbstractSemanticSequencerClass(_grammar_1);
          _builder.append(_abstractSemanticSequencerClass, "");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        }
      };
      JavaFileAccess _createJavaFile = this.fileAccessFactory.createJavaFile(_semanticSequencerClass_1, _client_1);
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_1 = _projectConfig_1.getRuntime();
      IXtextGeneratorFileSystemAccess _src_1 = _runtime_1.getSrc();
      _createJavaFile.writeTo(_src_1);
    }
  }
  
  private CharSequence unassignedCalledTokenRuleName(final AbstractRule rule) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get");
    String _name = rule.getName();
    _builder.append(_name, "");
    _builder.append("Token");
    return _builder;
  }
  
  protected void generateSyntacticSequencer() {
    boolean _isPreferXtendStubs = this.codeConfig.isPreferXtendStubs();
    if (_isPreferXtendStubs) {
      Grammar _grammar = this.getGrammar();
      TypeReference _syntacticSequencerClass = this.getSyntacticSequencerClass(_grammar);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("class ");
          Grammar _grammar = SerializerFragment2.this.getGrammar();
          TypeReference _syntacticSequencerClass = SerializerFragment2.this.getSyntacticSequencerClass(_grammar);
          String _simpleName = _syntacticSequencerClass.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append(" extends ");
          Grammar _grammar_1 = SerializerFragment2.this.getGrammar();
          TypeReference _abstractSyntacticSequencerClass = SerializerFragment2.this.getAbstractSyntacticSequencerClass(_grammar_1);
          _builder.append(_abstractSyntacticSequencerClass, "");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          {
            if (SerializerFragment2.this.detectSyntheticTerminals) {
              {
                Grammar _grammar_2 = SerializerFragment2.this.getGrammar();
                List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(_grammar_2);
                final Function1<TerminalRule, Boolean> _function = new Function1<TerminalRule, Boolean>() {
                  @Override
                  public Boolean apply(final TerminalRule it) {
                    return Boolean.valueOf(SerializerFragment2.this._syntheticTerminalDetector.isSyntheticTerminalRule(it));
                  }
                };
                Iterable<TerminalRule> _filter = IterableExtensions.<TerminalRule>filter(_allTerminalRules, _function);
                for(final TerminalRule rule : _filter) {
                  _builder.append("\t");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("/**");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append(" ");
                  _builder.append("* Stub implementation for a synthetic terminal rule. Defaults to the empty string.");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append(" ");
                  _builder.append("*/");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("// TODO review the concrete syntax for the terminal");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("override ");
                  CharSequence _unassignedCalledTokenRuleName = SerializerFragment2.this.unassignedCalledTokenRuleName(rule);
                  _builder.append(_unassignedCalledTokenRuleName, "\t");
                  _builder.append("(");
                  _builder.append(EObject.class, "\t");
                  _builder.append(" semanticObject, ");
                  _builder.append(RuleCall.class, "\t");
                  _builder.append(" ruleCall, ");
                  _builder.append(INode.class, "\t");
                  _builder.append(" node) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("return \'\'");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          }
          _builder.append("}");
          _builder.newLine();
        }
      };
      XtendFileAccess _createXtendFile = this.fileAccessFactory.createXtendFile(_syntacticSequencerClass, _client);
      IXtextProjectConfig _projectConfig = this.getProjectConfig();
      IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
      IXtextGeneratorFileSystemAccess _src = _runtime.getSrc();
      _createXtendFile.writeTo(_src);
    } else {
      Grammar _grammar_1 = this.getGrammar();
      TypeReference _syntacticSequencerClass_1 = this.getSyntacticSequencerClass(_grammar_1);
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          Grammar _grammar = SerializerFragment2.this.getGrammar();
          TypeReference _syntacticSequencerClass = SerializerFragment2.this.getSyntacticSequencerClass(_grammar);
          String _simpleName = _syntacticSequencerClass.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append(" extends ");
          Grammar _grammar_1 = SerializerFragment2.this.getGrammar();
          TypeReference _abstractSyntacticSequencerClass = SerializerFragment2.this.getAbstractSyntacticSequencerClass(_grammar_1);
          _builder.append(_abstractSyntacticSequencerClass, "");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          {
            if (SerializerFragment2.this.detectSyntheticTerminals) {
              {
                Grammar _grammar_2 = SerializerFragment2.this.getGrammar();
                List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(_grammar_2);
                final Function1<TerminalRule, Boolean> _function = new Function1<TerminalRule, Boolean>() {
                  @Override
                  public Boolean apply(final TerminalRule it) {
                    return Boolean.valueOf(SerializerFragment2.this._syntheticTerminalDetector.isSyntheticTerminalRule(it));
                  }
                };
                Iterable<TerminalRule> _filter = IterableExtensions.<TerminalRule>filter(_allTerminalRules, _function);
                for(final TerminalRule rule : _filter) {
                  _builder.append("\t");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("/**");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append(" ");
                  _builder.append("* Stub implementation for a synthetic terminal rule. Defaults to the empty string.");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append(" ");
                  _builder.append("*/");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("// TODO review the concrete syntax for the terminal");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("@Override");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("public String ");
                  CharSequence _unassignedCalledTokenRuleName = SerializerFragment2.this.unassignedCalledTokenRuleName(rule);
                  _builder.append(_unassignedCalledTokenRuleName, "\t");
                  _builder.append("(");
                  _builder.append(EObject.class, "\t");
                  _builder.append(" semanticObject, ");
                  _builder.append(RuleCall.class, "\t");
                  _builder.append(" ruleCall, ");
                  _builder.append(INode.class, "\t");
                  _builder.append(" node) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("return \"\";");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          }
          _builder.append("}");
          _builder.newLine();
        }
      };
      JavaFileAccess _createJavaFile = this.fileAccessFactory.createJavaFile(_syntacticSequencerClass_1, _client_1);
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_1 = _projectConfig_1.getRuntime();
      IXtextGeneratorFileSystemAccess _src_1 = _runtime_1.getSrc();
      _createJavaFile.writeTo(_src_1);
    }
  }
  
  protected void generateAbstractSemanticSequencer() {
    Grammar _grammar = this.getGrammar();
    final Collection<IGrammarConstraintProvider.IConstraint> localConstraints = this._semanticSequencerExtensions.getGrammarConstraints(_grammar);
    Grammar _grammar_1 = this.getGrammar();
    Grammar _superGrammar = this._semanticSequencerExtensions.getSuperGrammar(_grammar_1);
    final Collection<IGrammarConstraintProvider.IConstraint> superConstraints = this._semanticSequencerExtensions.getGrammarConstraints(_superGrammar);
    final Function1<IGrammarConstraintProvider.IConstraint, Boolean> _function = new Function1<IGrammarConstraintProvider.IConstraint, Boolean>() {
      @Override
      public Boolean apply(final IGrammarConstraintProvider.IConstraint it) {
        boolean _and = false;
        EClass _type = it.getType();
        boolean _tripleNotEquals = (_type != null);
        if (!_tripleNotEquals) {
          _and = false;
        } else {
          boolean _contains = superConstraints.contains(it);
          boolean _not = (!_contains);
          _and = _not;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<IGrammarConstraintProvider.IConstraint> _filter = IterableExtensions.<IGrammarConstraintProvider.IConstraint>filter(localConstraints, _function);
    final List<IGrammarConstraintProvider.IConstraint> newLocalConstraints = IterableExtensions.<IGrammarConstraintProvider.IConstraint>toList(_filter);
    TypeReference _xifexpression = null;
    if (this.generateStub) {
      Grammar _grammar_2 = this.getGrammar();
      _xifexpression = this.getAbstractSemanticSequencerClass(_grammar_2);
    } else {
      Grammar _grammar_3 = this.getGrammar();
      _xifexpression = this.getSemanticSequencerClass(_grammar_3);
    }
    final TypeReference clazz = _xifexpression;
    TypeReference _xifexpression_1 = null;
    final Function1<IGrammarConstraintProvider.IConstraint, Boolean> _function_1 = new Function1<IGrammarConstraintProvider.IConstraint, Boolean>() {
      @Override
      public Boolean apply(final IGrammarConstraintProvider.IConstraint it) {
        return Boolean.valueOf(superConstraints.contains(it));
      }
    };
    boolean _exists = IterableExtensions.<IGrammarConstraintProvider.IConstraint>exists(localConstraints, _function_1);
    if (_exists) {
      Grammar _grammar_4 = this.getGrammar();
      EList<Grammar> _usedGrammars = _grammar_4.getUsedGrammars();
      Grammar _head = IterableExtensions.<Grammar>head(_usedGrammars);
      _xifexpression_1 = this.getSemanticSequencerClass(_head);
    } else {
      _xifexpression_1 = TypeReference.typeRef(AbstractDelegatingSemanticSequencer.class);
    }
    final TypeReference superClazz = _xifexpression_1;
    final GeneratedJavaFileAccess javaFile = this.fileAccessFactory.createGeneratedJavaFile(clazz);
    ILanguageConfig _language = this.getLanguage();
    ResourceSet _resourceSet = _language.getResourceSet();
    javaFile.setResourceSet(_resourceSet);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public ");
        {
          if (SerializerFragment2.this.generateStub) {
            _builder.append("abstract ");
          }
        }
        _builder.append("class ");
        String _simpleName = clazz.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append(superClazz, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private ");
        Grammar _grammar = SerializerFragment2.this.getGrammar();
        TypeReference _grammarAccess = SerializerFragment2.this._grammarAccessExtensions.getGrammarAccess(_grammar);
        _builder.append(_grammarAccess, "\t");
        _builder.append(" grammarAccess;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        StringConcatenationClient _genMethodCreateSequence = SerializerFragment2.this.genMethodCreateSequence();
        _builder.append(_genMethodCreateSequence, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        {
          List<IGrammarConstraintProvider.IConstraint> _sort = IterableExtensions.<IGrammarConstraintProvider.IConstraint>sort(newLocalConstraints);
          for(final IGrammarConstraintProvider.IConstraint c : _sort) {
            _builder.append("\t");
            StringConcatenationClient _genMethodSequence = SerializerFragment2.this.genMethodSequence(c);
            _builder.append(_genMethodSequence, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setContent(_client);
    List<IClassAnnotation> _annotations = javaFile.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _srcGen = _runtime.getSrcGen();
    javaFile.writeTo(_srcGen);
  }
  
  private Iterable<EPackage> getAccessedPackages() {
    Grammar _grammar = this.getGrammar();
    Collection<IGrammarConstraintProvider.IConstraint> _grammarConstraints = this._semanticSequencerExtensions.getGrammarConstraints(_grammar);
    final Function1<IGrammarConstraintProvider.IConstraint, Boolean> _function = new Function1<IGrammarConstraintProvider.IConstraint, Boolean>() {
      @Override
      public Boolean apply(final IGrammarConstraintProvider.IConstraint it) {
        EClass _type = it.getType();
        return Boolean.valueOf((_type != null));
      }
    };
    Iterable<IGrammarConstraintProvider.IConstraint> _filter = IterableExtensions.<IGrammarConstraintProvider.IConstraint>filter(_grammarConstraints, _function);
    final Function1<IGrammarConstraintProvider.IConstraint, EPackage> _function_1 = new Function1<IGrammarConstraintProvider.IConstraint, EPackage>() {
      @Override
      public EPackage apply(final IGrammarConstraintProvider.IConstraint it) {
        EClass _type = it.getType();
        return _type.getEPackage();
      }
    };
    Iterable<EPackage> _map = IterableExtensions.<IGrammarConstraintProvider.IConstraint, EPackage>map(_filter, _function_1);
    Set<EPackage> _set = IterableExtensions.<EPackage>toSet(_map);
    final Function1<EPackage, String> _function_2 = new Function1<EPackage, String>() {
      @Override
      public String apply(final EPackage it) {
        return it.getName();
      }
    };
    return IterableExtensions.<EPackage, String>sortBy(_set, _function_2);
  }
  
  private Iterable<EClass> getAccessedClasses(final EPackage pkg) {
    Grammar _grammar = this.getGrammar();
    Collection<IGrammarConstraintProvider.IConstraint> _grammarConstraints = this._semanticSequencerExtensions.getGrammarConstraints(_grammar);
    final Function1<IGrammarConstraintProvider.IConstraint, EClass> _function = new Function1<IGrammarConstraintProvider.IConstraint, EClass>() {
      @Override
      public EClass apply(final IGrammarConstraintProvider.IConstraint it) {
        return it.getType();
      }
    };
    Iterable<EClass> _map = IterableExtensions.<IGrammarConstraintProvider.IConstraint, EClass>map(_grammarConstraints, _function);
    final Function1<EClass, Boolean> _function_1 = new Function1<EClass, Boolean>() {
      @Override
      public Boolean apply(final EClass it) {
        boolean _and = false;
        if (!(it != null)) {
          _and = false;
        } else {
          EPackage _ePackage = it.getEPackage();
          boolean _equals = Objects.equal(_ePackage, pkg);
          _and = _equals;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<EClass> _filter = IterableExtensions.<EClass>filter(_map, _function_1);
    Set<EClass> _set = IterableExtensions.<EClass>toSet(_filter);
    final Function1<EClass, String> _function_2 = new Function1<EClass, String>() {
      @Override
      public String apply(final EClass it) {
        return it.getName();
      }
    };
    return IterableExtensions.<EClass, String>sortBy(_set, _function_2);
  }
  
  private StringConcatenationClient genMethodCreateSequence() {
    StringConcatenationClient _xblockexpression = null;
    {
      Grammar _grammar = this.getGrammar();
      Grammar _superGrammar = this._semanticSequencerExtensions.getSuperGrammar(_grammar);
      Collection<IGrammarConstraintProvider.IConstraint> _grammarConstraints = this._semanticSequencerExtensions.getGrammarConstraints(_superGrammar);
      final Function1<IGrammarConstraintProvider.IConstraint, Pair<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint>> _function = new Function1<IGrammarConstraintProvider.IConstraint, Pair<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint>>() {
        @Override
        public Pair<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint> apply(final IGrammarConstraintProvider.IConstraint it) {
          return Pair.<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint>of(it, it);
        }
      };
      Iterable<Pair<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint>> _map = IterableExtensions.<IGrammarConstraintProvider.IConstraint, Pair<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint>>map(_grammarConstraints, _function);
      final Map<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint> superConstraints = SerializerFragment2.<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint>toMap(_map);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("public void createSequence(");
          _builder.append(EObject.class, "");
          _builder.append(" context, ");
          _builder.append(EObject.class, "");
          _builder.append(" semanticObject) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(EPackage.class, "\t");
          _builder.append(" epackage = semanticObject.eClass().getEPackage();");
          _builder.newLineIfNotEmpty();
          {
            Iterable<EPackage> _accessedPackages = SerializerFragment2.this.getAccessedPackages();
            Iterable<Pair<Integer, EPackage>> _indexed = IterableExtensions.<EPackage>indexed(_accessedPackages);
            for(final Pair<Integer, EPackage> pkg : _indexed) {
              _builder.append("\t");
              {
                Integer _key = pkg.getKey();
                boolean _greaterThan = ((_key).intValue() > 0);
                if (_greaterThan) {
                  _builder.append("else ");
                }
              }
              _builder.append("if (epackage == ");
              EPackage _value = pkg.getValue();
              _builder.append(_value, "\t");
              _builder.append(".");
              String _packageLiteral = GenModelUtil2.getPackageLiteral();
              _builder.append(_packageLiteral, "\t");
              _builder.append(")");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("switch (semanticObject.eClass().getClassifierID()) {");
              _builder.newLine();
              {
                EPackage _value_1 = pkg.getValue();
                Iterable<EClass> _accessedClasses = SerializerFragment2.this.getAccessedClasses(_value_1);
                for(final EClass type : _accessedClasses) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("case ");
                  EPackage _value_2 = pkg.getValue();
                  _builder.append(_value_2, "\t\t");
                  _builder.append(".");
                  ILanguageConfig _language = SerializerFragment2.this.getLanguage();
                  ResourceSet _resourceSet = _language.getResourceSet();
                  String _intLiteral = GenModelUtil2.getIntLiteral(type, _resourceSet);
                  _builder.append(_intLiteral, "\t\t");
                  _builder.append(":");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  StringConcatenationClient _genMethodCreateSequenceCaseBody = SerializerFragment2.this.genMethodCreateSequenceCaseBody(superConstraints, type);
                  _builder.append(_genMethodCreateSequenceCaseBody, "\t\t\t");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("if (errorAcceptor != null)");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      _xblockexpression = _client;
    }
    return _xblockexpression;
  }
  
  private StringConcatenationClient genMethodCreateSequenceCaseBody(final Map<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint> superConstraints, final EClass type) {
    StringConcatenationClient _xblockexpression = null;
    {
      Grammar _grammar = this.getGrammar();
      Map<IGrammarConstraintProvider.IConstraint, List<EObject>> _grammarConstraints = this._semanticSequencerExtensions.getGrammarConstraints(_grammar, type);
      Set<Map.Entry<IGrammarConstraintProvider.IConstraint, List<EObject>>> _entrySet = _grammarConstraints.entrySet();
      final Function1<Map.Entry<IGrammarConstraintProvider.IConstraint, List<EObject>>, String> _function = new Function1<Map.Entry<IGrammarConstraintProvider.IConstraint, List<EObject>>, String>() {
        @Override
        public String apply(final Map.Entry<IGrammarConstraintProvider.IConstraint, List<EObject>> it) {
          IGrammarConstraintProvider.IConstraint _key = it.getKey();
          return _key.getName();
        }
      };
      final List<Map.Entry<IGrammarConstraintProvider.IConstraint, List<EObject>>> contexts = IterableExtensions.<Map.Entry<IGrammarConstraintProvider.IConstraint, List<EObject>>, String>sortBy(_entrySet, _function);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          {
            int _size = contexts.size();
            boolean _greaterThan = (_size > 1);
            if (_greaterThan) {
              {
                Iterable<Pair<Integer, Map.Entry<IGrammarConstraintProvider.IConstraint, List<EObject>>>> _indexed = IterableExtensions.<Map.Entry<IGrammarConstraintProvider.IConstraint, List<EObject>>>indexed(contexts);
                for(final Pair<Integer, Map.Entry<IGrammarConstraintProvider.IConstraint, List<EObject>>> ctx : _indexed) {
                  {
                    Integer _key = ctx.getKey();
                    boolean _greaterThan_1 = ((_key).intValue() > 0);
                    if (_greaterThan_1) {
                      _builder.append("else ");
                    }
                  }
                  _builder.append("if (");
                  {
                    Map.Entry<IGrammarConstraintProvider.IConstraint, List<EObject>> _value = ctx.getValue();
                    List<EObject> _value_1 = _value.getValue();
                    final Function1<EObject, String> _function = new Function1<EObject, String>() {
                      @Override
                      public String apply(final EObject e) {
                        Grammar _grammar = SerializerFragment2.this.getGrammar();
                        return SerializerFragment2.this._context2NameFunction.getContextName(_grammar, e);
                      }
                    };
                    List<EObject> _sortBy = IterableExtensions.<EObject, String>sortBy(_value_1, _function);
                    boolean _hasElements = false;
                    for(final EObject c : _sortBy) {
                      if (!_hasElements) {
                        _hasElements = true;
                      } else {
                        _builder.appendImmediate("\n\t\t|| ", "");
                      }
                      _builder.append("context == grammarAccess.");
                      String _gaAccessor = SerializerFragment2.this._grammarAccessExtensions.gaAccessor(c);
                      _builder.append(_gaAccessor, "");
                    }
                  }
                  _builder.append(") {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  Map.Entry<IGrammarConstraintProvider.IConstraint, List<EObject>> _value_2 = ctx.getValue();
                  IGrammarConstraintProvider.IConstraint _key_1 = _value_2.getKey();
                  StringConcatenationClient _genMethodCreateSequenceCall = SerializerFragment2.this.genMethodCreateSequenceCall(superConstraints, type, _key_1);
                  _builder.append(_genMethodCreateSequenceCall, "\t");
                  _builder.newLineIfNotEmpty();
                  _builder.append("}");
                  _builder.newLine();
                }
              }
              _builder.append("else break;");
              _builder.newLine();
            } else {
              int _size_1 = contexts.size();
              boolean _equals = (_size_1 == 1);
              if (_equals) {
                Map.Entry<IGrammarConstraintProvider.IConstraint, List<EObject>> _head = IterableExtensions.<Map.Entry<IGrammarConstraintProvider.IConstraint, List<EObject>>>head(contexts);
                IGrammarConstraintProvider.IConstraint _key_2 = _head.getKey();
                StringConcatenationClient _genMethodCreateSequenceCall_1 = SerializerFragment2.this.genMethodCreateSequenceCall(superConstraints, type, _key_2);
                _builder.append(_genMethodCreateSequenceCall_1, "");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("// error, no contexts. ");
                _builder.newLine();
              }
            }
          }
        }
      };
      _xblockexpression = _client;
    }
    return _xblockexpression;
  }
  
  private StringConcatenationClient genMethodCreateSequenceCall(final Map<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint> superConstraints, final EClass type, final IGrammarConstraintProvider.IConstraint key) {
    StringConcatenationClient _xblockexpression = null;
    {
      final IGrammarConstraintProvider.IConstraint superConstraint = superConstraints.get(key);
      IGrammarConstraintProvider.IConstraint _elvis = null;
      if (superConstraint != null) {
        _elvis = superConstraint;
      } else {
        _elvis = key;
      }
      final IGrammarConstraintProvider.IConstraint constraint = _elvis;
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("sequence_");
          String _simpleName = constraint.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append("(context, (");
          _builder.append(type, "");
          _builder.append(") semanticObject); ");
          _builder.newLineIfNotEmpty();
          _builder.append("return; ");
          _builder.newLine();
        }
      };
      _xblockexpression = _client;
    }
    return _xblockexpression;
  }
  
  private StringConcatenationClient genMethodSequence(final IGrammarConstraintProvider.IConstraint c) {
    StringConcatenationClient _xblockexpression = null;
    {
      ILanguageConfig _language = this.getLanguage();
      final ResourceSet rs = _language.getResourceSet();
      StringConcatenationClient _xifexpression = null;
      EClass _type = c.getType();
      GenClass _genClass = GenModelUtil2.getGenClass(_type, rs);
      boolean _isEObjectExtension = _genClass.isEObjectExtension();
      if (_isEObjectExtension) {
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          }
        };
        _xifexpression = _client;
      } else {
        StringConcatenationClient _client_1 = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("(");
            _builder.append(EObject.class, "");
            _builder.append(") ");
          }
        };
        _xifexpression = _client_1;
      }
      final StringConcatenationClient cast = _xifexpression;
      final List<ISemanticSequencerNfaProvider.ISemState> states = this._semanticSequencerExtensions.getLinearListOfMandatoryAssignments(c);
      StringConcatenationClient _client_2 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Constraint:");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*     ");
          {
            IGrammarConstraintProvider.IConstraintElement _body = c.getBody();
            boolean _tripleEquals = (_body == null);
            if (_tripleEquals) {
              _builder.append("{");
              EClass _type = c.getType();
              String _name = _type.getName();
              _builder.append(_name, " ");
              _builder.append("}");
            } else {
              IGrammarConstraintProvider.IConstraintElement _body_1 = c.getBody();
              String _string = _body_1.toString();
              String _replaceAll = _string.replaceAll("\\n", "\n*     ");
              _builder.append(_replaceAll, " ");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("protected void sequence_");
          String _simpleName = c.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append("(");
          _builder.append(EObject.class, "");
          _builder.append(" context, ");
          EClass _type_1 = c.getType();
          _builder.append(_type_1, "");
          _builder.append(" semanticObject) {");
          _builder.newLineIfNotEmpty();
          {
            if ((states != null)) {
              _builder.append("\t");
              _builder.append("if (errorAcceptor != null) {");
              _builder.newLine();
              {
                for(final ISemanticSequencerNfaProvider.ISemState s : states) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("if (transientValues.isValueTransient(");
                  _builder.append(cast, "\t\t");
                  _builder.append("semanticObject, ");
                  EStructuralFeature _feature = s.getFeature();
                  EClass _eContainingClass = _feature.getEContainingClass();
                  EPackage _ePackage = _eContainingClass.getEPackage();
                  _builder.append(_ePackage, "\t\t");
                  _builder.append(".");
                  EStructuralFeature _feature_1 = s.getFeature();
                  String _featureLiteral = GenModelUtil2.getFeatureLiteral(_feature_1, rs);
                  _builder.append(_featureLiteral, "\t\t");
                  _builder.append(") == ");
                  _builder.append(ITransientValueService.ValueTransient.class, "\t\t");
                  _builder.append(".YES)");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(");
                  _builder.append(cast, "\t\t\t");
                  _builder.append("semanticObject, ");
                  EStructuralFeature _feature_2 = s.getFeature();
                  EClass _eContainingClass_1 = _feature_2.getEContainingClass();
                  EPackage _ePackage_1 = _eContainingClass_1.getEPackage();
                  _builder.append(_ePackage_1, "\t\t\t");
                  _builder.append(".");
                  EStructuralFeature _feature_3 = s.getFeature();
                  String _featureLiteral_1 = GenModelUtil2.getFeatureLiteral(_feature_3, rs);
                  _builder.append(_featureLiteral_1, "\t\t\t");
                  _builder.append("));");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.append(ISemanticNodeProvider.INodesForEObjectProvider.class, "\t");
              _builder.append(" nodes = createNodeProvider(");
              _builder.append(cast, "\t");
              _builder.append("semanticObject);");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append(SequenceFeeder.class, "\t");
              _builder.append(" feeder = createSequencerFeeder(");
              _builder.append(cast, "\t");
              _builder.append("semanticObject, nodes);");
              _builder.newLineIfNotEmpty();
              {
                for(final ISemanticSequencerNfaProvider.ISemState f : states) {
                  _builder.append("\t");
                  _builder.append("feeder.accept(grammarAccess.");
                  AbstractElement _assignedGrammarElement = f.getAssignedGrammarElement();
                  String _gaAccessor = SerializerFragment2.this._grammarAccessExtensions.gaAccessor(_assignedGrammarElement);
                  _builder.append(_gaAccessor, "\t");
                  _builder.append(", semanticObject.");
                  EStructuralFeature _feature_4 = f.getFeature();
                  String _getAccessor = GenModelUtil2.getGetAccessor(_feature_4, rs);
                  _builder.append(_getAccessor, "\t");
                  _builder.append("());");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("feeder.finish();");
              _builder.newLine();
            } else {
              _builder.append("\t");
              _builder.append("genericSequencer.createSequence(context, ");
              _builder.append(cast, "\t");
              _builder.append("semanticObject);");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("}");
          _builder.newLine();
        }
      };
      _xblockexpression = _client_2;
    }
    return _xblockexpression;
  }
  
  protected void generateAbstractSyntacticSequencer() {
    TypeReference _xifexpression = null;
    if (this.generateStub) {
      Grammar _grammar = this.getGrammar();
      _xifexpression = this.getAbstractSyntacticSequencerClass(_grammar);
    } else {
      Grammar _grammar_1 = this.getGrammar();
      _xifexpression = this.getSyntacticSequencerClass(_grammar_1);
    }
    final TypeReference clazz = _xifexpression;
    final GeneratedJavaFileAccess javaFile = this.fileAccessFactory.createGeneratedJavaFile(clazz);
    ILanguageConfig _language = this.getLanguage();
    ResourceSet _resourceSet = _language.getResourceSet();
    javaFile.setResourceSet(_resourceSet);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public ");
        {
          if (SerializerFragment2.this.generateStub) {
            _builder.append("abstract ");
          }
        }
        _builder.append("class ");
        String _simpleName = clazz.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append(AbstractSyntacticSequencer.class, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        Grammar _grammar = SerializerFragment2.this.getGrammar();
        TypeReference _grammarAccess = SerializerFragment2.this._grammarAccessExtensions.getGrammarAccess(_grammar);
        _builder.append(_grammarAccess, "\t");
        _builder.append(" grammarAccess;");
        _builder.newLineIfNotEmpty();
        {
          List<EqualAmbiguousTransitions> _allAmbiguousTransitionsBySyntax = SerializerFragment2.this._syntacticSequencerExtensions.getAllAmbiguousTransitionsBySyntax();
          for(final EqualAmbiguousTransitions group : _allAmbiguousTransitionsBySyntax) {
            _builder.append("\t");
            _builder.append("protected ");
            TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias");
            _builder.append(_typeRef, "\t");
            _builder.append(" match_");
            String _identifier = group.getIdentifier();
            _builder.append(_identifier, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("protected void init(");
        _builder.append(IGrammarAccess.class, "\t");
        _builder.append(" access) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("grammarAccess = (");
        Grammar _grammar_1 = SerializerFragment2.this.getGrammar();
        TypeReference _grammarAccess_1 = SerializerFragment2.this._grammarAccessExtensions.getGrammarAccess(_grammar_1);
        _builder.append(_grammarAccess_1, "\t\t");
        _builder.append(") access;");
        _builder.newLineIfNotEmpty();
        {
          List<EqualAmbiguousTransitions> _allAmbiguousTransitionsBySyntax_1 = SerializerFragment2.this._syntacticSequencerExtensions.getAllAmbiguousTransitionsBySyntax();
          for(final EqualAmbiguousTransitions group_1 : _allAmbiguousTransitionsBySyntax_1) {
            _builder.append("\t\t");
            _builder.append("match_");
            String _identifier_1 = group_1.getIdentifier();
            _builder.append(_identifier_1, "\t\t");
            _builder.append(" = ");
            GrammarAlias.AbstractElementAlias _elementAlias = group_1.getElementAlias();
            StringConcatenationClient _elementAliasToConstructor = SerializerFragment2.this._syntacticSequencerExtensions.elementAliasToConstructor(_elementAlias);
            _builder.append(_elementAliasToConstructor, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        StringConcatenationClient _genGetUnassignedRuleCallTokens = SerializerFragment2.this.genGetUnassignedRuleCallTokens();
        _builder.append(_genGetUnassignedRuleCallTokens, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        {
          List<AbstractRule> _unassignedCalledTokenRules = SerializerFragment2.this.unassignedCalledTokenRules();
          boolean _hasElements = false;
          for(final AbstractRule rule : _unassignedCalledTokenRules) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate("\n", "\t");
            }
            _builder.append("\t");
            StringConcatenationClient _genGetUnassignedRuleCallToken = SerializerFragment2.this.genGetUnassignedRuleCallToken(rule);
            _builder.append(_genGetUnassignedRuleCallToken, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        StringConcatenationClient _genEmitUnassignedTokens = SerializerFragment2.this.genEmitUnassignedTokens();
        _builder.append(_genEmitUnassignedTokens, "\t");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        {
          List<EqualAmbiguousTransitions> _allAmbiguousTransitionsBySyntax_2 = SerializerFragment2.this._syntacticSequencerExtensions.getAllAmbiguousTransitionsBySyntax();
          for(final EqualAmbiguousTransitions group_2 : _allAmbiguousTransitionsBySyntax_2) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* Ambiguous syntax:");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*     ");
            GrammarAlias.AbstractElementAlias _elementAlias_1 = group_2.getElementAlias();
            String _string = _elementAlias_1.toString();
            String _replace = _string.replace("\n", "\n *     ");
            _builder.append(_replace, "\t ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* This ambiguous syntax occurs at:");
            _builder.newLine();
            {
              List<ISyntacticSequencerPDAProvider.ISynTransition> _transitions = group_2.getTransitions();
              final Function1<ISyntacticSequencerPDAProvider.ISynTransition, String> _function = new Function1<ISyntacticSequencerPDAProvider.ISynTransition, String>() {
                @Override
                public String apply(final ISyntacticSequencerPDAProvider.ISynTransition it) {
                  String _ambiguityInsideTransition = group_2.ambiguityInsideTransition(it);
                  return _ambiguityInsideTransition.trim();
                }
              };
              List<String> _map = ListExtensions.<ISyntacticSequencerPDAProvider.ISynTransition, String>map(_transitions, _function);
              Set<String> _set = IterableExtensions.<String>toSet(_map);
              List<String> _sort = IterableExtensions.<String>sort(_set);
              for(final String trans : _sort) {
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*     ");
                String _string_1 = trans.toString();
                String _replace_1 = _string_1.replace("\n", "\n*     ");
                _builder.append(_replace_1, "\t ");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("protected void emit_");
            String _identifier_2 = group_2.getIdentifier();
            _builder.append(_identifier_2, "\t");
            _builder.append("(");
            _builder.append(EObject.class, "\t");
            _builder.append(" semanticObject, ");
            _builder.append(ISyntacticSequencerPDAProvider.ISynNavigable.class, "\t");
            _builder.append(" transition, ");
            _builder.append(List.class, "\t");
            _builder.append("<");
            _builder.append(INode.class, "\t");
            _builder.append("> nodes) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("acceptNodes(transition, nodes);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    javaFile.setContent(_client);
    List<IClassAnnotation> _annotations = javaFile.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _srcGen = _runtime.getSrcGen();
    javaFile.writeTo(_srcGen);
  }
  
  private List<AbstractRule> unassignedCalledTokenRules() {
    Grammar _grammar = this.getGrammar();
    List<AbstractRule> _allRules = GrammarUtil.allRules(_grammar);
    final Function1<AbstractRule, Boolean> _function = new Function1<AbstractRule, Boolean>() {
      @Override
      public Boolean apply(final AbstractRule it) {
        return Boolean.valueOf(GrammarUtil.isEObjectRule(it));
      }
    };
    final Iterable<AbstractRule> rules = IterableExtensions.<AbstractRule>filter(_allRules, _function);
    final Function1<AbstractRule, Iterable<RuleCall>> _function_1 = new Function1<AbstractRule, Iterable<RuleCall>>() {
      @Override
      public Iterable<RuleCall> apply(final AbstractRule it) {
        List<RuleCall> _containedRuleCalls = GrammarUtil.containedRuleCalls(it);
        final Function1<RuleCall, Boolean> _function = new Function1<RuleCall, Boolean>() {
          @Override
          public Boolean apply(final RuleCall it) {
            return Boolean.valueOf(SerializerFragment2.this.isUnassignedRuleCall(it));
          }
        };
        return IterableExtensions.<RuleCall>filter(_containedRuleCalls, _function);
      }
    };
    Iterable<Iterable<RuleCall>> _map = IterableExtensions.<AbstractRule, Iterable<RuleCall>>map(rules, _function_1);
    final Iterable<RuleCall> calls = Iterables.<RuleCall>concat(_map);
    final Function1<RuleCall, AbstractRule> _function_2 = new Function1<RuleCall, AbstractRule>() {
      @Override
      public AbstractRule apply(final RuleCall it) {
        return it.getRule();
      }
    };
    Iterable<AbstractRule> _map_1 = IterableExtensions.<RuleCall, AbstractRule>map(calls, _function_2);
    Set<AbstractRule> _set = IterableExtensions.<AbstractRule>toSet(_map_1);
    final Function1<AbstractRule, String> _function_3 = new Function1<AbstractRule, String>() {
      @Override
      public String apply(final AbstractRule it) {
        return it.getName();
      }
    };
    return IterableExtensions.<AbstractRule, String>sortBy(_set, _function_3);
  }
  
  private boolean isUnassignedRuleCall(final RuleCall c) {
    boolean _isEObjectRuleCall = GrammarUtil.isEObjectRuleCall(c);
    if (_isEObjectRuleCall) {
      return false;
    }
    final Assignment ass = GrammarUtil.containingAssignment(c);
    boolean _or = false;
    boolean _equals = Objects.equal(ass, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _isBooleanAssignment = GrammarUtil.isBooleanAssignment(ass);
      _or = _isBooleanAssignment;
    }
    return _or;
  }
  
  private String defaultValue(final AbstractElement ele, final Set<AbstractElement> visited) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      boolean _add = visited.add(ele);
      boolean _not = (!_add);
      if (_not) {
        _matched=true;
        _switchResult = "";
      }
    }
    if (!_matched) {
      boolean _isOptionalCardinality = GrammarUtil.isOptionalCardinality(ele);
      if (_isOptionalCardinality) {
        _matched=true;
        _switchResult = "";
      }
    }
    if (!_matched) {
      if (ele instanceof Alternatives) {
        _matched=true;
        EList<AbstractElement> _elements = ((Alternatives)ele).getElements();
        AbstractElement _head = IterableExtensions.<AbstractElement>head(_elements);
        _switchResult = this.defaultValue(_head, visited);
      }
    }
    if (!_matched) {
      if (ele instanceof Group) {
        _matched=true;
        EList<AbstractElement> _elements = ((Group)ele).getElements();
        final Function1<AbstractElement, String> _function = new Function1<AbstractElement, String>() {
          @Override
          public String apply(final AbstractElement it) {
            return SerializerFragment2.this.defaultValue(it, visited);
          }
        };
        List<String> _map = ListExtensions.<AbstractElement, String>map(_elements, _function);
        _switchResult = IterableExtensions.join(_map);
      }
    }
    if (!_matched) {
      if (ele instanceof Keyword) {
        _matched=true;
        _switchResult = ((Keyword)ele).getValue();
      }
    }
    if (!_matched) {
      if (ele instanceof RuleCall) {
        _matched=true;
        AbstractRule _rule = ((RuleCall)ele).getRule();
        AbstractElement _alternatives = _rule.getAlternatives();
        _switchResult = this.defaultValue(_alternatives, visited);
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  private StringConcatenationClient genGetUnassignedRuleCallTokens() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("protected String getUnassignedRuleCallToken(");
        _builder.append(EObject.class, "");
        _builder.append(" semanticObject, ");
        _builder.append(RuleCall.class, "");
        _builder.append(" ruleCall, ");
        _builder.append(INode.class, "");
        _builder.append(" node) {");
        _builder.newLineIfNotEmpty();
        {
          List<AbstractRule> _unassignedCalledTokenRules = SerializerFragment2.this.unassignedCalledTokenRules();
          Iterable<Pair<Integer, AbstractRule>> _indexed = IterableExtensions.<AbstractRule>indexed(_unassignedCalledTokenRules);
          for(final Pair<Integer, AbstractRule> rule : _indexed) {
            _builder.append("\t");
            {
              Integer _key = rule.getKey();
              boolean _greaterThan = ((_key).intValue() > 0);
              if (_greaterThan) {
                _builder.append("else ");
              }
            }
            _builder.append("if (ruleCall.getRule() == grammarAccess.");
            AbstractRule _value = rule.getValue();
            String _gaAccessor = SerializerFragment2.this._grammarAccessExtensions.gaAccessor(_value);
            _builder.append(_gaAccessor, "\t");
            _builder.append(")");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return ");
            AbstractRule _value_1 = rule.getValue();
            CharSequence _unassignedCalledTokenRuleName = SerializerFragment2.this.unassignedCalledTokenRuleName(_value_1);
            _builder.append(_unassignedCalledTokenRuleName, "\t\t");
            _builder.append("(semanticObject, ruleCall, node);");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("return \"\";");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client;
  }
  
  private String textWithoutComments(final INode node) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (node instanceof ILeafNode) {
        boolean _or = false;
        boolean _isHidden = ((ILeafNode)node).isHidden();
        boolean _not = (!_isHidden);
        if (_not) {
          _or = true;
        } else {
          String _text = ((ILeafNode)node).getText();
          String _trim = _text.trim();
          int _length = _trim.length();
          boolean _equals = (_length == 0);
          _or = _equals;
        }
        if (_or) {
          _matched=true;
          _switchResult = ((ILeafNode)node).getText();
        }
      }
    }
    if (!_matched) {
      if (node instanceof ICompositeNode) {
        _matched=true;
        BidiIterable<INode> _children = ((ICompositeNode)node).getChildren();
        final Function1<INode, String> _function = new Function1<INode, String>() {
          @Override
          public String apply(final INode it) {
            return SerializerFragment2.this.textWithoutComments(it);
          }
        };
        Iterable<String> _map = IterableExtensions.<INode, String>map(_children, _function);
        _switchResult = IterableExtensions.join(_map);
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  private StringConcatenationClient genGetUnassignedRuleCallToken(final AbstractRule rule) {
    if ((rule instanceof TerminalRule)) {
      boolean _and = false;
      if (!this.detectSyntheticTerminals) {
        _and = false;
      } else {
        boolean _isSyntheticTerminalRule = this._syntheticTerminalDetector.isSyntheticTerminalRule(((TerminalRule)rule));
        _and = _isSyntheticTerminalRule;
      }
      if (_and) {
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("/**");
            _builder.newLine();
            _builder.append(" ");
            _builder.append("* Synthetic terminal rule. The concrete syntax is to be specified by clients.");
            _builder.newLine();
            {
              if ((!SerializerFragment2.this.generateStub)) {
                _builder.append(" * Defaults to the empty string.");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("protected ");
            {
              if (SerializerFragment2.this.generateStub) {
                _builder.append("abstract ");
              }
            }
            _builder.append("String ");
            CharSequence _unassignedCalledTokenRuleName = SerializerFragment2.this.unassignedCalledTokenRuleName(rule);
            _builder.append(_unassignedCalledTokenRuleName, "");
            _builder.append("(");
            _builder.append(EObject.class, "");
            _builder.append(" semanticObject, ");
            _builder.append(RuleCall.class, "");
            _builder.append(" ruleCall, ");
            _builder.append(INode.class, "");
            _builder.append(" node)");
            {
              if (SerializerFragment2.this.generateStub) {
                _builder.append(";");
              } else {
                _builder.append(" { return \"\"; }");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        };
        return _client;
      }
    }
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        ICompositeNode _node = NodeModelUtils.getNode(rule);
        String _textWithoutComments = SerializerFragment2.this.textWithoutComments(_node);
        String _trim = _textWithoutComments.trim();
        String _replace = _trim.replace("\n", "\n* ");
        _builder.append(_replace, " ");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("protected String ");
        CharSequence _unassignedCalledTokenRuleName = SerializerFragment2.this.unassignedCalledTokenRuleName(rule);
        _builder.append(_unassignedCalledTokenRuleName, "");
        _builder.append("(");
        _builder.append(EObject.class, "");
        _builder.append(" semanticObject, ");
        _builder.append(RuleCall.class, "");
        _builder.append(" ruleCall, ");
        _builder.append(INode.class, "");
        _builder.append(" node) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if (node != null)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return getTokenText(node);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return \"");
        AbstractElement _alternatives = rule.getAlternatives();
        HashSet<AbstractElement> _newHashSet = CollectionLiterals.<AbstractElement>newHashSet();
        String _defaultValue = SerializerFragment2.this.defaultValue(_alternatives, _newHashSet);
        String _convertToJavaString = Strings.convertToJavaString(_defaultValue);
        _builder.append(_convertToJavaString, "\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client_1;
  }
  
  private StringConcatenationClient genEmitUnassignedTokens() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("protected void emitUnassignedTokens(");
        _builder.append(EObject.class, "");
        _builder.append(" semanticObject, ");
        _builder.append(ISyntacticSequencerPDAProvider.ISynTransition.class, "");
        _builder.append(" transition, ");
        _builder.append(INode.class, "");
        _builder.append(" fromNode, ");
        _builder.append(INode.class, "");
        _builder.append(" toNode) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if (transition.getAmbiguousSyntaxes().isEmpty()) return;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(List.class, "\t");
        _builder.append("<");
        _builder.append(INode.class, "\t");
        _builder.append("> transitionNodes = collectNodes(fromNode, toNode);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("for (");
        _builder.append(GrammarAlias.AbstractElementAlias.class, "\t");
        _builder.append(" syntax : transition.getAmbiguousSyntaxes()) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append(List.class, "\t\t");
        _builder.append("<");
        _builder.append(INode.class, "\t\t");
        _builder.append("> syntaxNodes = getNodesFor(transitionNodes, syntax);");
        _builder.newLineIfNotEmpty();
        {
          List<EqualAmbiguousTransitions> _allAmbiguousTransitionsBySyntax = SerializerFragment2.this._syntacticSequencerExtensions.getAllAmbiguousTransitionsBySyntax();
          Iterable<Pair<Integer, EqualAmbiguousTransitions>> _indexed = IterableExtensions.<EqualAmbiguousTransitions>indexed(_allAmbiguousTransitionsBySyntax);
          for(final Pair<Integer, EqualAmbiguousTransitions> group : _indexed) {
            _builder.append("\t\t");
            {
              Integer _key = group.getKey();
              boolean _greaterThan = ((_key).intValue() > 0);
              if (_greaterThan) {
                _builder.append("else ");
              }
            }
            _builder.append("if (match_");
            EqualAmbiguousTransitions _value = group.getValue();
            String _identifier = _value.getIdentifier();
            _builder.append(_identifier, "\t\t");
            _builder.append(".equals(syntax))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("emit_");
            EqualAmbiguousTransitions _value_1 = group.getValue();
            String _identifier_1 = _value_1.getIdentifier();
            _builder.append(_identifier_1, "\t\t\t");
            _builder.append("(semanticObject, getLastNavigableState(), syntaxNodes);");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        {
          List<EqualAmbiguousTransitions> _allAmbiguousTransitionsBySyntax_1 = SerializerFragment2.this._syntacticSequencerExtensions.getAllAmbiguousTransitionsBySyntax();
          boolean _isEmpty = _allAmbiguousTransitionsBySyntax_1.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append("else ");
          }
        }
        _builder.append("acceptNodes(getLastNavigableState(), syntaxNodes);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client;
  }
  
  protected void generateGrammarConstraints() {
    Grammar _grammar = this.getGrammar();
    String _grammarConstraintsPath = this.getGrammarConstraintsPath(_grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("grammar ");
        Grammar _grammar = SerializerFragment2.this.getGrammar();
        String _name = _grammar.getName();
        _builder.append(_name, "");
        {
          Grammar _grammar_1 = SerializerFragment2.this.getGrammar();
          EList<Grammar> _usedGrammars = _grammar_1.getUsedGrammars();
          boolean _hasElements = false;
          for(final Grammar ug : _usedGrammars) {
            if (!_hasElements) {
              _hasElements = true;
              _builder.append(" with ", "");
            } else {
              _builder.appendImmediate(", ", "");
            }
            String _name_1 = ug.getName();
            _builder.append(_name_1, "");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("generate model \"http://");
        Grammar _grammar_2 = SerializerFragment2.this.getGrammar();
        String _name_2 = _grammar_2.getName();
        _builder.append(_name_2, "");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.newLine();
        _builder.append("// ******** constraint contexts ********");
        _builder.newLine();
        {
          Grammar _grammar_3 = SerializerFragment2.this.getGrammar();
          List<IGrammarConstraintProvider.IConstraintContext> _grammarConstraintContexts = SerializerFragment2.this._semanticSequencerExtensions.getGrammarConstraintContexts(_grammar_3);
          boolean _hasElements_1 = false;
          for(final IGrammarConstraintProvider.IConstraintContext gcc : _grammarConstraintContexts) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate("\n", "");
            }
            String _name_3 = gcc.getName();
            _builder.append(_name_3, "");
            {
              String _safeType = SerializerFragment2.this.getSafeType(gcc);
              boolean _tripleNotEquals = (_safeType != null);
              if (_tripleNotEquals) {
                _builder.append(" returns ");
                String _safeType_1 = SerializerFragment2.this.getSafeType(gcc);
                _builder.append(_safeType_1, "");
              }
            }
            _builder.append(":");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            {
              List<IGrammarConstraintProvider.IConstraint> _constraints = gcc.getConstraints();
              boolean _hasElements_2 = false;
              for(final IGrammarConstraintProvider.IConstraint constraint : _constraints) {
                if (!_hasElements_2) {
                  _hasElements_2 = true;
                } else {
                  _builder.appendImmediate(" | ", "\t");
                }
                String _name_4 = constraint.getName();
                _builder.append(_name_4, "\t");
              }
            }
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        _builder.newLine();
        _builder.newLine();
        _builder.append("// ******** constraints ********");
        _builder.newLine();
        {
          Grammar _grammar_4 = SerializerFragment2.this.getGrammar();
          Collection<IGrammarConstraintProvider.IConstraint> _grammarConstraints = SerializerFragment2.this._semanticSequencerExtensions.getGrammarConstraints(_grammar_4);
          boolean _hasElements_3 = false;
          for(final IGrammarConstraintProvider.IConstraint constraint_1 : _grammarConstraints) {
            if (!_hasElements_3) {
              _hasElements_3 = true;
            } else {
              _builder.appendImmediate("\n", "");
            }
            String _name_5 = constraint_1.getName();
            _builder.append(_name_5, "");
            {
              EClass _type = constraint_1.getType();
              boolean _tripleNotEquals_1 = (_type != null);
              if (_tripleNotEquals_1) {
                _builder.append(" returns ");
                EClass _type_1 = constraint_1.getType();
                String _name_6 = _type_1.getName();
                _builder.append(_name_6, "");
              }
            }
            _builder.append(":");
            _builder.newLineIfNotEmpty();
            {
              IGrammarConstraintProvider.IConstraintElement _body = constraint_1.getBody();
              boolean _equals = Objects.equal(_body, null);
              if (_equals) {
                _builder.append("\t");
                _builder.append("{");
                EClass _type_2 = constraint_1.getType();
                String _name_7 = null;
                if (_type_2!=null) {
                  _name_7=_type_2.getName();
                }
                _builder.append(_name_7, "\t");
                _builder.append("};");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                IGrammarConstraintProvider.IConstraintElement _body_1 = constraint_1.getBody();
                _builder.append(_body_1, "\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    };
    TextFileAccess _createTextFile = this.fileAccessFactory.createTextFile(_grammarConstraintsPath, _client);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    IXtextGeneratorFileSystemAccess _srcGen = _runtime.getSrcGen();
    _createTextFile.writeTo(_srcGen);
  }
  
  private String getSafeType(final IGrammarConstraintProvider.IConstraintContext context) {
    String _xtrycatchfinallyexpression = null;
    try {
      EClass _commonType = context.getCommonType();
      String _name = null;
      if (_commonType!=null) {
        _name=_commonType.getName();
      }
      _xtrycatchfinallyexpression = _name;
    } catch (final Throwable _t) {
      if (_t instanceof UnsupportedOperationException) {
        final UnsupportedOperationException e = (UnsupportedOperationException)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Pure
  public boolean isGenerateDebugData() {
    return this.generateDebugData;
  }
  
  public void setGenerateDebugData(final boolean generateDebugData) {
    this.generateDebugData = generateDebugData;
  }
  
  @Pure
  public boolean isGenerateStub() {
    return this.generateStub;
  }
  
  public void setGenerateStub(final boolean generateStub) {
    this.generateStub = generateStub;
  }
}