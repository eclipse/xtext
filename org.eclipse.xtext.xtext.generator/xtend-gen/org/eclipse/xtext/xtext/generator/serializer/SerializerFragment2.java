/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.serializer;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
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
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.antlr.AbstractSplittingTokenSource;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.analysis.GrammarAlias;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.analysis.SerializationContext;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation;
import org.eclipse.xtext.xtext.generator.model.annotations.SuppressWarningsAnnotation;
import org.eclipse.xtext.xtext.generator.serializer.DebugGraphGenerator;
import org.eclipse.xtext.xtext.generator.serializer.EqualAmbiguousTransitions;
import org.eclipse.xtext.xtext.generator.serializer.SemanticSequencerExtensions;
import org.eclipse.xtext.xtext.generator.serializer.SyntacticSequencerExtensions;
import org.eclipse.xtext.xtext.generator.util.GenModelUtil2;
import org.eclipse.xtext.xtext.generator.util.SyntheticTerminalDetector;

@Log
@SuppressWarnings("all")
public class SerializerFragment2 extends AbstractStubGeneratingFragment {
  private static <K extends Object, V extends Object> Map<K, V> toMap(final Iterable<Pair<K, V>> items) {
    LinkedHashMap<K, V> _xblockexpression = null;
    {
      final LinkedHashMap<K, V> result = CollectionLiterals.<K, V>newLinkedHashMap();
      for (final Pair<K, V> i : items) {
        result.put(i.getKey(), i.getValue());
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
  private SemanticSequencerExtensions _semanticSequencerExtensions;
  
  @Inject
  @Extension
  private SyntacticSequencerExtensions _syntacticSequencerExtensions;
  
  @Inject
  @Extension
  private GrammarAccessExtensions _grammarAccessExtensions;
  
  @Inject
  @Extension
  private SyntheticTerminalDetector syntheticTerminalDetector;
  
  @Inject
  @Extension
  private IGrammarConstraintProvider _iGrammarConstraintProvider;
  
  @Inject
  private DebugGraphGenerator debugGraphGenerator;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  @Accessors
  private boolean generateDebugData = false;
  
  @Accessors
  private boolean generateSupportForDeprecatedContextEObject = false;
  
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
    String _replace = this.getSerializerBasePackage(grammar).replace(".", "/");
    String _plus = (_replace + "/");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "GrammarConstraints.txt");
  }
  
  @Override
  public void generate() {
    new GuiceModuleAccess.BindingFactory().addTypeToType(TypeReference.typeRef(ISemanticSequencer.class), this.getSemanticSequencerClass(this.getGrammar())).addTypeToType(TypeReference.typeRef(ISyntacticSequencer.class), this.getSyntacticSequencerClass(this.getGrammar())).addTypeToType(TypeReference.typeRef(ISerializer.class), TypeReference.typeRef(Serializer.class)).contributeTo(this.getLanguage().getRuntimeGenModule());
    ManifestAccess _manifest = this.getProjectConfig().getRuntime().getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      Set<String> _exportedPackages = this.getProjectConfig().getRuntime().getManifest().getExportedPackages();
      String _serializerBasePackage = this.getSerializerBasePackage(this.getGrammar());
      _exportedPackages.add(_serializerBasePackage);
      Set<String> _requiredBundles = this.getProjectConfig().getRuntime().getManifest().getRequiredBundles();
      String _xbaseLibVersionLowerBound = this.getProjectConfig().getRuntime().getXbaseLibVersionLowerBound();
      String _plus = ("org.eclipse.xtext.xbase.lib;bundle-version=\"" + _xbaseLibVersionLowerBound);
      String _plus_1 = (_plus + "\"");
      _requiredBundles.add(_plus_1);
    }
    this.generateAbstractSemanticSequencer();
    this.generateAbstractSyntacticSequencer();
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      this.generateSemanticSequencer();
      this.generateSyntacticSequencer();
    }
    if (this.generateDebugData) {
      this.generateGrammarConstraints();
      Iterable<Pair<String, String>> _generateDebugGraphs = this.debugGraphGenerator.generateDebugGraphs();
      for (final Pair<String, String> fileToContent : _generateDebugGraphs) {
        this.getProjectConfig().getRuntime().getSrcGen().generateFile(fileToContent.getKey(), fileToContent.getValue());
      }
    }
  }
  
  protected void generateSemanticSequencer() {
    boolean _isGenerateXtendStub = this.isGenerateXtendStub();
    if (_isGenerateXtendStub) {
      TypeReference _semanticSequencerClass = this.getSemanticSequencerClass(this.getGrammar());
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("class ");
          String _simpleName = SerializerFragment2.this.getSemanticSequencerClass(SerializerFragment2.this.getGrammar()).getSimpleName();
          _builder.append(_simpleName);
          _builder.append(" extends ");
          TypeReference _abstractSemanticSequencerClass = SerializerFragment2.this.getAbstractSemanticSequencerClass(SerializerFragment2.this.getGrammar());
          _builder.append(_abstractSemanticSequencerClass);
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        }
      };
      this.fileAccessFactory.createXtendFile(_semanticSequencerClass, _client).writeTo(this.getProjectConfig().getRuntime().getSrc());
    } else {
      TypeReference _semanticSequencerClass_1 = this.getSemanticSequencerClass(this.getGrammar());
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          String _simpleName = SerializerFragment2.this.getSemanticSequencerClass(SerializerFragment2.this.getGrammar()).getSimpleName();
          _builder.append(_simpleName);
          _builder.append(" extends ");
          TypeReference _abstractSemanticSequencerClass = SerializerFragment2.this.getAbstractSemanticSequencerClass(SerializerFragment2.this.getGrammar());
          _builder.append(_abstractSemanticSequencerClass);
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        }
      };
      this.fileAccessFactory.createJavaFile(_semanticSequencerClass_1, _client_1).writeTo(this.getProjectConfig().getRuntime().getSrc());
    }
  }
  
  private CharSequence unassignedCalledTokenRuleName(final AbstractRule rule) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get");
    String _name = rule.getName();
    _builder.append(_name);
    _builder.append("Token");
    return _builder;
  }
  
  protected void generateSyntacticSequencer() {
    boolean _isGenerateXtendStub = this.isGenerateXtendStub();
    if (_isGenerateXtendStub) {
      TypeReference _syntacticSequencerClass = this.getSyntacticSequencerClass(this.getGrammar());
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("class ");
          String _simpleName = SerializerFragment2.this.getSyntacticSequencerClass(SerializerFragment2.this.getGrammar()).getSimpleName();
          _builder.append(_simpleName);
          _builder.append(" extends ");
          TypeReference _abstractSyntacticSequencerClass = SerializerFragment2.this.getAbstractSyntacticSequencerClass(SerializerFragment2.this.getGrammar());
          _builder.append(_abstractSyntacticSequencerClass);
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          {
            if (SerializerFragment2.this.detectSyntheticTerminals) {
              {
                final Function1<TerminalRule, Boolean> _function = (TerminalRule it) -> {
                  return Boolean.valueOf(SerializerFragment2.this.syntheticTerminalDetector.isSyntheticTerminalRule(it));
                };
                Iterable<TerminalRule> _filter = IterableExtensions.<TerminalRule>filter(GrammarUtil.allTerminalRules(SerializerFragment2.this.getGrammar()), _function);
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
      this.fileAccessFactory.createXtendFile(_syntacticSequencerClass, _client).writeTo(this.getProjectConfig().getRuntime().getSrc());
    } else {
      TypeReference _syntacticSequencerClass_1 = this.getSyntacticSequencerClass(this.getGrammar());
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          String _simpleName = SerializerFragment2.this.getSyntacticSequencerClass(SerializerFragment2.this.getGrammar()).getSimpleName();
          _builder.append(_simpleName);
          _builder.append(" extends ");
          TypeReference _abstractSyntacticSequencerClass = SerializerFragment2.this.getAbstractSyntacticSequencerClass(SerializerFragment2.this.getGrammar());
          _builder.append(_abstractSyntacticSequencerClass);
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          {
            if (SerializerFragment2.this.detectSyntheticTerminals) {
              {
                final Function1<TerminalRule, Boolean> _function = (TerminalRule it) -> {
                  return Boolean.valueOf(SerializerFragment2.this.syntheticTerminalDetector.isSyntheticTerminalRule(it));
                };
                Iterable<TerminalRule> _filter = IterableExtensions.<TerminalRule>filter(GrammarUtil.allTerminalRules(SerializerFragment2.this.getGrammar()), _function);
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
      this.fileAccessFactory.createJavaFile(_syntacticSequencerClass_1, _client_1).writeTo(this.getProjectConfig().getRuntime().getSrc());
    }
  }
  
  protected void generateAbstractSemanticSequencer() {
    final Collection<IGrammarConstraintProvider.IConstraint> localConstraints = this._semanticSequencerExtensions.getGrammarConstraints(this.getGrammar());
    final Collection<IGrammarConstraintProvider.IConstraint> superConstraints = this._semanticSequencerExtensions.getGrammarConstraints(this._semanticSequencerExtensions.getSuperGrammar(this.getGrammar()));
    final Function1<IGrammarConstraintProvider.IConstraint, Boolean> _function = (IGrammarConstraintProvider.IConstraint it) -> {
      return Boolean.valueOf(((it.getType() != null) && (!superConstraints.contains(it))));
    };
    final Set<IGrammarConstraintProvider.IConstraint> newLocalConstraints = IterableExtensions.<IGrammarConstraintProvider.IConstraint>toSet(IterableExtensions.<IGrammarConstraintProvider.IConstraint>filter(localConstraints, _function));
    TypeReference _xifexpression = null;
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      _xifexpression = this.getAbstractSemanticSequencerClass(this.getGrammar());
    } else {
      _xifexpression = this.getSemanticSequencerClass(this.getGrammar());
    }
    final TypeReference clazz = _xifexpression;
    TypeReference _xifexpression_1 = null;
    final Function1<IGrammarConstraintProvider.IConstraint, Boolean> _function_1 = (IGrammarConstraintProvider.IConstraint it) -> {
      return Boolean.valueOf(superConstraints.contains(it));
    };
    boolean _exists = IterableExtensions.<IGrammarConstraintProvider.IConstraint>exists(localConstraints, _function_1);
    if (_exists) {
      _xifexpression_1 = this.getSemanticSequencerClass(IterableExtensions.<Grammar>head(this.getGrammar().getUsedGrammars()));
    } else {
      _xifexpression_1 = TypeReference.typeRef(AbstractDelegatingSemanticSequencer.class);
    }
    final TypeReference superClazz = _xifexpression_1;
    final GeneratedJavaFileAccess javaFile = this.fileAccessFactory.createGeneratedJavaFile(clazz);
    javaFile.setResourceSet(this.getLanguage().getResourceSet());
    final HashSet<Pair<String, EClass>> methodSignatures = CollectionLiterals.<Pair<String, EClass>>newHashSet();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public ");
        {
          boolean _isGenerateStub = SerializerFragment2.this.isGenerateStub();
          if (_isGenerateStub) {
            _builder.append("abstract ");
          }
        }
        _builder.append("class ");
        String _simpleName = clazz.getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        _builder.append(superClazz);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private ");
        TypeReference _grammarAccess = SerializerFragment2.this._grammarAccessExtensions.getGrammarAccess(SerializerFragment2.this.getGrammar());
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
            {
              String _simpleName_1 = c.getSimpleName();
              EClass _type = c.getType();
              Pair<String, EClass> _mappedTo = Pair.<String, EClass>of(_simpleName_1, _type);
              boolean _add = methodSignatures.add(_mappedTo);
              if (_add) {
                _builder.append("\t");
                StringConcatenationClient _genMethodSequence = SerializerFragment2.this.genMethodSequence(c);
                _builder.append(_genMethodSequence, "\t");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                String _simpleName_2 = clazz.getSimpleName();
                String _plus = ("Skipped generating duplicate method in " + _simpleName_2);
                SerializerFragment2.LOG.warn(_plus);
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                StringConcatenationClient _genMethodSequenceComment = SerializerFragment2.this.genMethodSequenceComment(c);
                _builder.append(_genMethodSequenceComment, "\t");
                _builder.newLineIfNotEmpty();
              }
            }
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
    javaFile.writeTo(this.getProjectConfig().getRuntime().getSrcGen());
  }
  
  private Iterable<EPackage> getAccessedPackages() {
    final Function1<IGrammarConstraintProvider.IConstraint, Boolean> _function = (IGrammarConstraintProvider.IConstraint it) -> {
      EClass _type = it.getType();
      return Boolean.valueOf((_type != null));
    };
    final Function1<IGrammarConstraintProvider.IConstraint, EPackage> _function_1 = (IGrammarConstraintProvider.IConstraint it) -> {
      return it.getType().getEPackage();
    };
    final Function1<EPackage, String> _function_2 = (EPackage it) -> {
      return it.getName();
    };
    return IterableExtensions.<EPackage, String>sortBy(IterableExtensions.<EPackage>toSet(IterableExtensions.<IGrammarConstraintProvider.IConstraint, EPackage>map(IterableExtensions.<IGrammarConstraintProvider.IConstraint>filter(this._semanticSequencerExtensions.getGrammarConstraints(this.getGrammar()), _function), _function_1)), _function_2);
  }
  
  private Iterable<EClass> getAccessedClasses(final EPackage pkg) {
    final Function1<IGrammarConstraintProvider.IConstraint, EClass> _function = (IGrammarConstraintProvider.IConstraint it) -> {
      return it.getType();
    };
    final Function1<EClass, Boolean> _function_1 = (EClass it) -> {
      return Boolean.valueOf(((it != null) && Objects.equal(it.getEPackage(), pkg)));
    };
    final Function1<EClass, String> _function_2 = (EClass it) -> {
      return it.getName();
    };
    return IterableExtensions.<EClass, String>sortBy(IterableExtensions.<EClass>toSet(IterableExtensions.<EClass>filter(IterableExtensions.<IGrammarConstraintProvider.IConstraint, EClass>map(this._semanticSequencerExtensions.getGrammarConstraints(this.getGrammar()), _function), _function_1)), _function_2);
  }
  
  private StringConcatenationClient genMethodCreateSequence() {
    StringConcatenationClient _xblockexpression = null;
    {
      final Function1<IGrammarConstraintProvider.IConstraint, Pair<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint>> _function = (IGrammarConstraintProvider.IConstraint it) -> {
        return Pair.<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint>of(it, it);
      };
      final Map<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint> superConstraints = SerializerFragment2.<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint>toMap(IterableExtensions.<IGrammarConstraintProvider.IConstraint, Pair<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint>>map(this._semanticSequencerExtensions.getGrammarConstraints(this._semanticSequencerExtensions.getSuperGrammar(this.getGrammar())), _function));
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("public void sequence(");
          _builder.append(ISerializationContext.class);
          _builder.append(" context, ");
          _builder.append(EObject.class);
          _builder.append(" semanticObject) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(EPackage.class, "\t");
          _builder.append(" epackage = semanticObject.eClass().getEPackage();");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(ParserRule.class, "\t");
          _builder.append(" rule = context.getParserRule();");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(Action.class, "\t");
          _builder.append(" action = context.getAssignedAction();");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(Set.class, "\t");
          _builder.append("<");
          _builder.append(Parameter.class, "\t");
          _builder.append("> parameters = context.getEnabledBooleanParameters();");
          _builder.newLineIfNotEmpty();
          {
            Iterable<Pair<Integer, EPackage>> _indexed = IterableExtensions.<EPackage>indexed(SerializerFragment2.this.getAccessedPackages());
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
                Iterable<EClass> _accessedClasses = SerializerFragment2.this.getAccessedClasses(pkg.getValue());
                for(final EClass type : _accessedClasses) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("case ");
                  EPackage _value_1 = pkg.getValue();
                  _builder.append(_value_1, "\t\t");
                  _builder.append(".");
                  String _intLiteral = GenModelUtil2.getIntLiteral(type, SerializerFragment2.this.getLanguage().getResourceSet());
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
  
  private StringConcatenationClient genParameterCondition(final ISerializationContext context, final IGrammarConstraintProvider.IConstraint constraint) {
    StringConcatenationClient _xblockexpression = null;
    {
      final Set<Parameter> values = context.getEnabledBooleanParameters();
      StringConcatenationClient _xifexpression = null;
      boolean _isEmpty = values.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append(ImmutableSet.class);
            _builder.append(".of(");
            final Function1<Parameter, String> _function = (Parameter it) -> {
              String _gaAccessor = SerializerFragment2.this._grammarAccessExtensions.gaAccessor(it);
              return ("grammarAccess." + _gaAccessor);
            };
            String _join = IterableExtensions.join(IterableExtensions.<Parameter, String>map(values, _function), ", ");
            _builder.append(_join);
            _builder.append(").equals(parameters)");
          }
        };
        _xifexpression = _client;
      } else {
        StringConcatenationClient _xifexpression_1 = null;
        final Function1<ISerializationContext, Boolean> _function = (ISerializationContext it) -> {
          boolean _isEmpty_1 = ((SerializationContext) it).getDeclaredParameters().isEmpty();
          return Boolean.valueOf((!_isEmpty_1));
        };
        boolean _exists = IterableExtensions.<ISerializationContext>exists(constraint.getContexts(), _function);
        if (_exists) {
          StringConcatenationClient _client_1 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("parameters.isEmpty()");
            }
          };
          _xifexpression_1 = _client_1;
        } else {
          StringConcatenationClient _client_2 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            }
          };
          _xifexpression_1 = _client_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private StringConcatenationClient genMethodCreateSequenceCaseBody(final Map<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint> superConstraints, final EClass type) {
    StringConcatenationClient _xblockexpression = null;
    {
      final Function1<Map.Entry<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>>, String> _function = (Map.Entry<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>> it) -> {
        return it.getKey().getName();
      };
      final List<Map.Entry<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>>> contexts = IterableExtensions.<Map.Entry<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>>, String>sortBy(this._semanticSequencerExtensions.getGrammarConstraints(this.getGrammar(), type).entrySet(), _function);
      final LinkedHashMultimap<EObject, IGrammarConstraintProvider.IConstraint> context2constraint = LinkedHashMultimap.<EObject, IGrammarConstraintProvider.IConstraint>create();
      for (final Map.Entry<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>> e : contexts) {
        List<ISerializationContext> _value = e.getValue();
        for (final ISerializationContext ctx : _value) {
          context2constraint.put(((SerializationContext) ctx).getActionOrRule(), e.getKey());
        }
      }
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          {
            int _size = contexts.size();
            boolean _greaterThan = (_size > 1);
            if (_greaterThan) {
              {
                Iterable<Pair<Integer, Map.Entry<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>>>> _indexed = IterableExtensions.<Map.Entry<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>>>indexed(contexts);
                for(final Pair<Integer, Map.Entry<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>>> ctx : _indexed) {
                  {
                    Integer _key = ctx.getKey();
                    boolean _greaterThan_1 = ((_key).intValue() > 0);
                    if (_greaterThan_1) {
                      _builder.append("else ");
                    }
                  }
                  _builder.append("if (");
                  StringConcatenationClient _genCondition = SerializerFragment2.this.genCondition(ctx.getValue().getValue(), ctx.getValue().getKey(), context2constraint);
                  _builder.append(_genCondition);
                  _builder.append(") {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  StringConcatenationClient _genMethodCreateSequenceCall = SerializerFragment2.this.genMethodCreateSequenceCall(superConstraints, type, ctx.getValue().getKey());
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
                StringConcatenationClient _genMethodCreateSequenceCall_1 = SerializerFragment2.this.genMethodCreateSequenceCall(superConstraints, type, IterableExtensions.<Map.Entry<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>>>head(contexts).getKey());
                _builder.append(_genMethodCreateSequenceCall_1);
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
  
  private StringConcatenationClient genCondition(final List<ISerializationContext> contexts, final IGrammarConstraintProvider.IConstraint constraint, final Multimap<EObject, IGrammarConstraintProvider.IConstraint> ctx2ctr) {
    StringConcatenationClient _xblockexpression = null;
    {
      final List<ISerializationContext> sorted = IterableExtensions.<ISerializationContext>sort(contexts);
      final LinkedHashMultimap<EObject, ISerializationContext> index = LinkedHashMultimap.<EObject, ISerializationContext>create();
      final Consumer<ISerializationContext> _function = (ISerializationContext it) -> {
        index.put(this.getContextObject(it), it);
      };
      sorted.forEach(_function);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          {
            Set<EObject> _keySet = index.keySet();
            boolean _hasElements = false;
            for(final EObject obj : _keySet) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate("\n\t\t|| ", "");
              }
              StringConcatenationClient _genObjectSelector = SerializerFragment2.this.genObjectSelector(obj);
              _builder.append(_genObjectSelector);
              {
                int _size = ctx2ctr.get(obj).size();
                boolean _greaterThan = (_size > 1);
                if (_greaterThan) {
                  StringConcatenationClient _genParameterSelector = SerializerFragment2.this.genParameterSelector(obj, index.get(obj), constraint);
                  _builder.append(_genParameterSelector);
                }
              }
            }
          }
        }
      };
      _xblockexpression = _client;
    }
    return _xblockexpression;
  }
  
  private StringConcatenationClient genObjectSelector(final EObject obj) {
    StringConcatenationClient _switchResult = null;
    boolean _matched = false;
    if (obj instanceof Action) {
      _matched=true;
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("action == grammarAccess.");
          String _gaAccessor = SerializerFragment2.this._grammarAccessExtensions.gaAccessor(obj);
          _builder.append(_gaAccessor);
        }
      };
      _switchResult = _client;
    }
    if (!_matched) {
      if (obj instanceof ParserRule) {
        _matched=true;
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("rule == grammarAccess.");
            String _gaAccessor = SerializerFragment2.this._grammarAccessExtensions.gaAccessor(obj);
            _builder.append(_gaAccessor);
          }
        };
        _switchResult = _client;
      }
    }
    return _switchResult;
  }
  
  private StringConcatenationClient genParameterSelector(final EObject obj, final Set<ISerializationContext> contexts, final IGrammarConstraintProvider.IConstraint constraint) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(" ");
        _builder.append("&& (");
        {
          boolean _hasElements = false;
          for(final ISerializationContext context : contexts) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate("\n\t\t\t|| ", " ");
            }
            StringConcatenationClient _genParameterCondition = SerializerFragment2.this.genParameterCondition(context, constraint);
            _builder.append(_genParameterCondition, " ");
          }
        }
        _builder.append(")");
      }
    };
    return _client;
  }
  
  private EObject getContextObject(final ISerializationContext context) {
    EObject _elvis = null;
    Action _assignedAction = context.getAssignedAction();
    if (_assignedAction != null) {
      _elvis = _assignedAction;
    } else {
      ParserRule _parserRule = context.getParserRule();
      _elvis = _parserRule;
    }
    return _elvis;
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
          _builder.append(_simpleName);
          _builder.append("(context, (");
          _builder.append(type);
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
  
  private StringConcatenationClient genMethodSequenceComment(final IGrammarConstraintProvider.IConstraint c) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("// This method is commented out because it has the same signature as another method in this class.");
        _builder.newLine();
        _builder.append("// This is probably a bug in Xtext\'s serializer, please report it here: ");
        _builder.newLine();
        _builder.append("// https://bugs.eclipse.org/bugs/enter_bug.cgi?product=TMF");
        _builder.newLine();
        _builder.append("//");
        _builder.newLine();
        _builder.append("// Contexts:");
        _builder.newLine();
        _builder.append("//     ");
        String _replaceAll = IterableExtensions.join(IterableExtensions.<ISerializationContext>sort(c.getContexts()), "\n").replaceAll("\\n", "\n//     ");
        _builder.append(_replaceAll);
        _builder.newLineIfNotEmpty();
        _builder.append("//");
        _builder.newLine();
        _builder.append("// Constraint:");
        _builder.newLine();
        _builder.append("//     ");
        {
          IGrammarConstraintProvider.IConstraintElement _body = c.getBody();
          boolean _tripleEquals = (_body == null);
          if (_tripleEquals) {
            _builder.append("{");
            String _name = c.getType().getName();
            _builder.append(_name);
            _builder.append("}");
          } else {
            String _replaceAll_1 = c.getBody().toString().replaceAll("\\n", "\n//     ");
            _builder.append(_replaceAll_1);
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("//");
        _builder.newLine();
        _builder.append("// protected void sequence_");
        String _simpleName = c.getSimpleName();
        _builder.append(_simpleName);
        _builder.append("(");
        _builder.append(ISerializationContext.class);
        _builder.append(" context, ");
        EClass _type = c.getType();
        _builder.append(_type);
        _builder.append(" semanticObject) { }");
        _builder.newLineIfNotEmpty();
      }
    };
    return _client;
  }
  
  private StringConcatenationClient genMethodSequence(final IGrammarConstraintProvider.IConstraint c) {
    StringConcatenationClient _xblockexpression = null;
    {
      final ResourceSet rs = this.getLanguage().getResourceSet();
      StringConcatenationClient _xifexpression = null;
      boolean _isEObjectExtension = GenModelUtil2.getGenClass(c.getType(), rs).isEObjectExtension();
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
            _builder.append(EObject.class);
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
          _builder.append("* Contexts:");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*     ");
          String _replaceAll = IterableExtensions.join(IterableExtensions.<ISerializationContext>sort(c.getContexts()), "\n").replaceAll("\\n", "\n*     ");
          _builder.append(_replaceAll, " ");
          _builder.newLineIfNotEmpty();
          _builder.append(" ");
          _builder.append("*");
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
              String _name = c.getType().getName();
              _builder.append(_name, " ");
              _builder.append("}");
            } else {
              String _replaceAll_1 = c.getBody().toString().replaceAll("\\n", "\n*     ");
              _builder.append(_replaceAll_1, " ");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("protected void sequence_");
          String _simpleName = c.getSimpleName();
          _builder.append(_simpleName);
          _builder.append("(");
          _builder.append(ISerializationContext.class);
          _builder.append(" context, ");
          EClass _type = c.getType();
          _builder.append(_type);
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
                  EPackage _ePackage = s.getFeature().getEContainingClass().getEPackage();
                  _builder.append(_ePackage, "\t\t");
                  _builder.append(".");
                  String _featureLiteral = GenModelUtil2.getFeatureLiteral(s.getFeature(), rs);
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
                  EPackage _ePackage_1 = s.getFeature().getEContainingClass().getEPackage();
                  _builder.append(_ePackage_1, "\t\t\t");
                  _builder.append(".");
                  String _featureLiteral_1 = GenModelUtil2.getFeatureLiteral(s.getFeature(), rs);
                  _builder.append(_featureLiteral_1, "\t\t\t");
                  _builder.append("));");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.append(SequenceFeeder.class, "\t");
              _builder.append(" feeder = createSequencerFeeder(context, ");
              _builder.append(cast, "\t");
              _builder.append("semanticObject);");
              _builder.newLineIfNotEmpty();
              {
                for(final ISemanticSequencerNfaProvider.ISemState f : states) {
                  _builder.append("\t");
                  _builder.append("feeder.accept(grammarAccess.");
                  String _gaAccessor = SerializerFragment2.this._grammarAccessExtensions.gaAccessor(f.getAssignedGrammarElement());
                  _builder.append(_gaAccessor, "\t");
                  _builder.append(", semanticObject.");
                  StringConcatenationClient _unresolvingGetAccessor = SerializerFragment2.this.getUnresolvingGetAccessor(f.getFeature(), rs);
                  _builder.append(_unresolvingGetAccessor, "\t");
                  _builder.append(");");
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
          _builder.newLine();
          {
            if (SerializerFragment2.this.generateSupportForDeprecatedContextEObject) {
              _builder.append("@Deprecated");
              _builder.newLine();
              _builder.append("protected void sequence_");
              String _simpleName_1 = c.getSimpleName();
              _builder.append(_simpleName_1);
              _builder.append("(");
              _builder.append(EObject.class);
              _builder.append(" context, ");
              EClass _type_1 = c.getType();
              _builder.append(_type_1);
              _builder.append(" semanticObject) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("sequence_");
              String _simpleName_2 = c.getSimpleName();
              _builder.append(_simpleName_2, "\t");
              _builder.append("(createContext(context, semanticObject), semanticObject);");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      };
      _xblockexpression = _client_2;
    }
    return _xblockexpression;
  }
  
  private StringConcatenationClient getUnresolvingGetAccessor(final EStructuralFeature feature, final ResourceSet resourceSet) {
    final GenFeature genFeature = GenModelUtil2.getGenFeature(feature, resourceSet);
    boolean _isResolveProxies = genFeature.isResolveProxies();
    if (_isResolveProxies) {
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("eGet(");
          EPackage _ecorePackage = genFeature.getGenPackage().getEcorePackage();
          _builder.append(_ecorePackage);
          _builder.append(".");
          String _featureLiteral = GenModelUtil2.getFeatureLiteral(genFeature, resourceSet);
          _builder.append(_featureLiteral);
          _builder.append(", false)");
        }
      };
      return _client;
    } else {
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          String _getAccessor = GenModelUtil2.getGetAccessor(genFeature, resourceSet);
          _builder.append(_getAccessor);
          _builder.append("()");
        }
      };
      return _client_1;
    }
  }
  
  protected void generateAbstractSyntacticSequencer() {
    TypeReference _xifexpression = null;
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      _xifexpression = this.getAbstractSyntacticSequencerClass(this.getGrammar());
    } else {
      _xifexpression = this.getSyntacticSequencerClass(this.getGrammar());
    }
    final TypeReference clazz = _xifexpression;
    final GeneratedJavaFileAccess javaFile = this.fileAccessFactory.createGeneratedJavaFile(clazz);
    javaFile.setResourceSet(this.getLanguage().getResourceSet());
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public ");
        {
          boolean _isGenerateStub = SerializerFragment2.this.isGenerateStub();
          if (_isGenerateStub) {
            _builder.append("abstract ");
          }
        }
        _builder.append("class ");
        String _simpleName = clazz.getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" extends ");
        _builder.append(AbstractSyntacticSequencer.class);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        TypeReference _grammarAccess = SerializerFragment2.this._grammarAccessExtensions.getGrammarAccess(SerializerFragment2.this.getGrammar());
        _builder.append(_grammarAccess, "\t");
        _builder.append(" grammarAccess;");
        _builder.newLineIfNotEmpty();
        {
          List<EqualAmbiguousTransitions> _allAmbiguousTransitionsBySyntax = SerializerFragment2.this._syntacticSequencerExtensions.getAllAmbiguousTransitionsBySyntax();
          for(final EqualAmbiguousTransitions group : _allAmbiguousTransitionsBySyntax) {
            _builder.append("\t");
            _builder.append("protected ");
            TypeReference _typeReference = new TypeReference("org.eclipse.xtext.serializer.analysis", "GrammarAlias.AbstractElementAlias");
            _builder.append(_typeReference, "\t");
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
        TypeReference _grammarAccess_1 = SerializerFragment2.this._grammarAccessExtensions.getGrammarAccess(SerializerFragment2.this.getGrammar());
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
            StringConcatenationClient _elementAliasToConstructor = SerializerFragment2.this._syntacticSequencerExtensions.elementAliasToConstructor(group_1.getElementAlias());
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
            String _replace = group_2.getElementAlias().toString().replace("\n", "\n *     ");
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
              final Function1<ISyntacticSequencerPDAProvider.ISynTransition, String> _function = (ISyntacticSequencerPDAProvider.ISynTransition it) -> {
                return group_2.ambiguityInsideTransition(it).trim();
              };
              List<String> _sort = IterableExtensions.<String>sort(IterableExtensions.<String>toSet(ListExtensions.<ISyntacticSequencerPDAProvider.ISynTransition, String>map(group_2.getTransitions(), _function)));
              for(final String trans : _sort) {
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*     ");
                String _replace_1 = trans.toString().replace("\n", "\n*     ");
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
    javaFile.writeTo(this.getProjectConfig().getRuntime().getSrcGen());
  }
  
  private List<AbstractRule> unassignedCalledTokenRules() {
    final Function1<AbstractRule, Boolean> _function = (AbstractRule it) -> {
      return Boolean.valueOf(GrammarUtil.isEObjectRule(it));
    };
    final Iterable<AbstractRule> rules = IterableExtensions.<AbstractRule>filter(GrammarUtil.allRules(this.getGrammar()), _function);
    final Function1<AbstractRule, Iterable<RuleCall>> _function_1 = (AbstractRule it) -> {
      final Function1<RuleCall, Boolean> _function_2 = (RuleCall it_1) -> {
        return Boolean.valueOf(this.isUnassignedRuleCall(it_1));
      };
      return IterableExtensions.<RuleCall>filter(GrammarUtil.containedRuleCalls(it), _function_2);
    };
    final Iterable<RuleCall> calls = Iterables.<RuleCall>concat(IterableExtensions.<AbstractRule, Iterable<RuleCall>>map(rules, _function_1));
    final Function1<RuleCall, AbstractRule> _function_2 = (RuleCall it) -> {
      return it.getRule();
    };
    final Function1<AbstractRule, String> _function_3 = (AbstractRule it) -> {
      return it.getName();
    };
    return IterableExtensions.<AbstractRule, String>sortBy(IterableExtensions.<AbstractRule>toSet(IterableExtensions.<RuleCall, AbstractRule>map(calls, _function_2)), _function_3);
  }
  
  private boolean isUnassignedRuleCall(final RuleCall c) {
    boolean _isEObjectRuleCall = GrammarUtil.isEObjectRuleCall(c);
    if (_isEObjectRuleCall) {
      return false;
    }
    final Assignment ass = GrammarUtil.containingAssignment(c);
    return ((ass == null) || GrammarUtil.isBooleanAssignment(ass));
  }
  
  private String defaultValue(final AbstractElement ele, final AbstractRule rule, final Set<AbstractElement> visited) {
    String _switchResult = null;
    boolean _matched = false;
    boolean _add = visited.add(ele);
    boolean _not = (!_add);
    if (_not) {
      _matched=true;
      _switchResult = "";
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
        _switchResult = this.defaultValue(IterableExtensions.<AbstractElement>head(((Alternatives)ele).getElements()), rule, visited);
      }
    }
    if (!_matched) {
      if (ele instanceof Group) {
        _matched=true;
        String _xifexpression = null;
        if ((rule instanceof TerminalRule)) {
          final Function1<AbstractElement, String> _function = (AbstractElement it) -> {
            return this.defaultValue(it, rule, visited);
          };
          final Function1<String, Boolean> _function_1 = (String it) -> {
            boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
            return Boolean.valueOf((!_isNullOrEmpty));
          };
          _xifexpression = IterableExtensions.join(IterableExtensions.<String>filter(ListExtensions.<AbstractElement, String>map(((Group)ele).getElements(), _function), _function_1));
        } else {
          final Function1<AbstractElement, String> _function_2 = (AbstractElement it) -> {
            return this.defaultValue(it, rule, visited);
          };
          final Function1<String, Boolean> _function_3 = (String it) -> {
            boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
            return Boolean.valueOf((!_isNullOrEmpty));
          };
          _xifexpression = IterableExtensions.join(IterableExtensions.<String>filter(ListExtensions.<AbstractElement, String>map(((Group)ele).getElements(), _function_2), _function_3), " ");
        }
        _switchResult = _xifexpression;
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
        _switchResult = this.defaultValue(((RuleCall)ele).getRule().getAlternatives(), ((RuleCall)ele).getRule(), visited);
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
        _builder.append(EObject.class);
        _builder.append(" semanticObject, ");
        _builder.append(RuleCall.class);
        _builder.append(" ruleCall, ");
        _builder.append(INode.class);
        _builder.append(" node) {");
        _builder.newLineIfNotEmpty();
        {
          Iterable<Pair<Integer, AbstractRule>> _indexed = IterableExtensions.<AbstractRule>indexed(SerializerFragment2.this.unassignedCalledTokenRules());
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
            String _gaAccessor = SerializerFragment2.this._grammarAccessExtensions.gaAccessor(rule.getValue());
            _builder.append(_gaAccessor, "\t");
            _builder.append(")");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return ");
            CharSequence _unassignedCalledTokenRuleName = SerializerFragment2.this.unassignedCalledTokenRuleName(rule.getValue());
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
    if (node instanceof ILeafNode) {
      if (((!((ILeafNode)node).isHidden()) || (((ILeafNode)node).getText().trim().length() == 0))) {
        _matched=true;
        _switchResult = ((ILeafNode)node).getText();
      }
    }
    if (!_matched) {
      if (node instanceof ICompositeNode) {
        _matched=true;
        final Function1<INode, String> _function = (INode it) -> {
          return this.textWithoutComments(it);
        };
        _switchResult = IterableExtensions.join(IterableExtensions.<INode, String>map(((ICompositeNode)node).getChildren(), _function));
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  private StringConcatenationClient genGetUnassignedRuleCallToken(final AbstractRule rule) {
    if ((rule instanceof TerminalRule)) {
      if ((this.detectSyntheticTerminals && this.syntheticTerminalDetector.isSyntheticTerminalRule(((TerminalRule)rule)))) {
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("/**");
            _builder.newLine();
            _builder.append(" ");
            _builder.append("* Synthetic terminal rule. The concrete syntax is to be specified by clients.");
            _builder.newLine();
            {
              boolean _isGenerateStub = SerializerFragment2.this.isGenerateStub();
              boolean _not = (!_isGenerateStub);
              if (_not) {
                _builder.append(" * Defaults to the empty string.");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("protected ");
            {
              boolean _isGenerateStub_1 = SerializerFragment2.this.isGenerateStub();
              if (_isGenerateStub_1) {
                _builder.append("abstract ");
              }
            }
            _builder.append("String ");
            CharSequence _unassignedCalledTokenRuleName = SerializerFragment2.this.unassignedCalledTokenRuleName(rule);
            _builder.append(_unassignedCalledTokenRuleName);
            _builder.append("(");
            _builder.append(EObject.class);
            _builder.append(" semanticObject, ");
            _builder.append(RuleCall.class);
            _builder.append(" ruleCall, ");
            _builder.append(INode.class);
            _builder.append(" node)");
            {
              boolean _isGenerateStub_2 = SerializerFragment2.this.isGenerateStub();
              if (_isGenerateStub_2) {
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
        String _replace = SerializerFragment2.this.textWithoutComments(NodeModelUtils.getNode(rule)).trim().replace("\n", "\n* ").replace("*/", "*&#47;");
        _builder.append(_replace, " ");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("protected String ");
        CharSequence _unassignedCalledTokenRuleName = SerializerFragment2.this.unassignedCalledTokenRuleName(rule);
        _builder.append(_unassignedCalledTokenRuleName);
        _builder.append("(");
        _builder.append(EObject.class);
        _builder.append(" semanticObject, ");
        _builder.append(RuleCall.class);
        _builder.append(" ruleCall, ");
        _builder.append(INode.class);
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
        String _convertToJavaString = Strings.convertToJavaString(SerializerFragment2.this.defaultValue(rule.getAlternatives(), rule, CollectionLiterals.<AbstractElement>newHashSet()));
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
        _builder.append(EObject.class);
        _builder.append(" semanticObject, ");
        _builder.append(ISyntacticSequencerPDAProvider.ISynTransition.class);
        _builder.append(" transition, ");
        _builder.append(INode.class);
        _builder.append(" fromNode, ");
        _builder.append(INode.class);
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
          Iterable<Pair<Integer, EqualAmbiguousTransitions>> _indexed = IterableExtensions.<EqualAmbiguousTransitions>indexed(SerializerFragment2.this._syntacticSequencerExtensions.getAllAmbiguousTransitionsBySyntax());
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
            String _identifier = group.getValue().getIdentifier();
            _builder.append(_identifier, "\t\t");
            _builder.append(".equals(syntax))");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("emit_");
            String _identifier_1 = group.getValue().getIdentifier();
            _builder.append(_identifier_1, "\t\t\t");
            _builder.append("(semanticObject, getLastNavigableState(), syntaxNodes);");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        {
          boolean _isEmpty = SerializerFragment2.this._syntacticSequencerExtensions.getAllAmbiguousTransitionsBySyntax().isEmpty();
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
    String _grammarConstraintsPath = this.getGrammarConstraintsPath(this.getGrammar());
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          List<SerializationContextMap.Entry<IGrammarConstraintProvider.IConstraint>> _values = SerializerFragment2.this._iGrammarConstraintProvider.getConstraints(SerializerFragment2.this.getGrammar()).sortedCopy().values();
          boolean _hasElements = false;
          for(final SerializationContextMap.Entry<IGrammarConstraintProvider.IConstraint> e : _values) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate("\n", "");
            }
            String _join = IterableExtensions.join(e.getContexts(), ", ");
            _builder.append(_join);
            _builder.append(":");
            _builder.newLineIfNotEmpty();
            {
              IGrammarConstraintProvider.IConstraintElement _body = e.getValue().getBody();
              boolean _tripleEquals = (_body == null);
              if (_tripleEquals) {
                _builder.append("\t");
                _builder.append("{");
                EClass _type = e.getValue().getType();
                String _name = null;
                if (_type!=null) {
                  _name=_type.getName();
                }
                _builder.append(_name, "\t");
                _builder.append("};");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                IGrammarConstraintProvider.IConstraintElement _body_1 = e.getValue().getBody();
                _builder.append(_body_1, "\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    };
    this.fileAccessFactory.createTextFile(_grammarConstraintsPath, _client).writeTo(this.getProjectConfig().getRuntime().getSrcGen());
  }
  
  private static final Logger LOG = Logger.getLogger(SerializerFragment2.class);
  
  @Pure
  public boolean isGenerateDebugData() {
    return this.generateDebugData;
  }
  
  public void setGenerateDebugData(final boolean generateDebugData) {
    this.generateDebugData = generateDebugData;
  }
  
  @Pure
  public boolean isGenerateSupportForDeprecatedContextEObject() {
    return this.generateSupportForDeprecatedContextEObject;
  }
  
  public void setGenerateSupportForDeprecatedContextEObject(final boolean generateSupportForDeprecatedContextEObject) {
    this.generateSupportForDeprecatedContextEObject = generateSupportForDeprecatedContextEObject;
  }
}
