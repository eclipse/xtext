/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.serializer;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
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
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess;
import org.eclipse.xtext.generator.serializer.EqualAmbiguousTransitions;
import org.eclipse.xtext.generator.serializer.GeneratedFile;
import org.eclipse.xtext.generator.serializer.JavaFile;
import org.eclipse.xtext.generator.serializer.SerializerGenFileNames;
import org.eclipse.xtext.generator.serializer.SyntacticSequencerUtil;
import org.eclipse.xtext.generator.terminals.SyntheticTerminalDetector;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.serializer.analysis.GrammarAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class AbstractSyntacticSequencer extends GeneratedFile {
  @Inject
  private Grammar grammar;
  
  @Inject
  @Extension
  private GrammarAccess grammarAccess;
  
  @Inject
  @Extension
  private SyntacticSequencerUtil util;
  
  @Inject
  @Extension
  private Naming _naming;
  
  /**
   * @since 2.8
   */
  @Accessors
  private boolean detectSyntheticTerminals = true;
  
  /**
   * @since 2.8
   */
  @Accessors
  private SyntheticTerminalDetector syntheticTerminalDetector;
  
  @Override
  public CharSequence getFileContents(final SerializerGenFileNames.GenFileName filename) {
    String _xblockexpression = null;
    {
      String _packageName = filename.getPackageName();
      String _fileHeader = this._naming.fileHeader();
      final JavaFile file = new JavaFile(_packageName, _fileHeader);
      file.imported(org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer.class);
      file.imported(RuleCall.class);
      file.imported(INode.class);
      file.imported(ISyntacticSequencerPDAProvider.ISynTransition.class);
      file.imported(Inject.class);
      file.imported(IGrammarAccess.class);
      file.imported(EObject.class);
      file.imported(List.class);
      file.imported(GrammarAlias.AbstractElementAlias.class);
      String _annotationImports = this._naming.annotationImports();
      boolean _notEquals = (!Objects.equal(_annotationImports, null));
      if (_notEquals) {
        String _annotationImports_1 = this._naming.annotationImports();
        String[] _split = _annotationImports_1.split("(import)|;");
        final Function1<String, String> _function = new Function1<String, String>() {
          @Override
          public String apply(final String it) {
            return it.trim();
          }
        };
        List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_split)), _function);
        final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
          @Override
          public Boolean apply(final String it) {
            boolean _isEmpty = it.isEmpty();
            return Boolean.valueOf((!_isEmpty));
          }
        };
        Iterable<String> _filter = IterableExtensions.<String>filter(_map, _function_1);
        final Procedure1<String> _function_2 = new Procedure1<String>() {
          @Override
          public void apply(final String it) {
            file.imported(it);
          }
        };
        IterableExtensions.<String>forEach(_filter, _function_2);
      }
      String _xifexpression = null;
      boolean _isAbstract = filename.isAbstract();
      if (_isAbstract) {
        _xifexpression = "abstract ";
      } else {
        _xifexpression = "";
      }
      final String _abstract = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      String _classAnnotations = this._naming.classAnnotations();
      _builder.append(_classAnnotations, "");
      _builder.append("@SuppressWarnings(\"all\")");
      _builder.newLineIfNotEmpty();
      _builder.append("public ");
      _builder.append(_abstract, "");
      _builder.append("class ");
      String _simpleName = filename.getSimpleName();
      _builder.append(_simpleName, "");
      _builder.append(" extends AbstractSyntacticSequencer {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected ");
      String _gaFQName = this.grammarAccess.gaFQName(this.grammar);
      String _imported = file.imported(_gaFQName);
      _builder.append(_imported, "\t");
      _builder.append(" grammarAccess;");
      _builder.newLineIfNotEmpty();
      {
        List<EqualAmbiguousTransitions> _allAmbiguousTransitionsBySyntax = this.util.getAllAmbiguousTransitionsBySyntax();
        for(final EqualAmbiguousTransitions group : _allAmbiguousTransitionsBySyntax) {
          _builder.append("\t");
          _builder.append("protected ");
          String _imported_1 = file.imported("org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias");
          _builder.append(_imported_1, "\t");
          _builder.append(" match_");
          String _identifyer = group.getIdentifyer();
          _builder.append(_identifyer, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Inject");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected void init(IGrammarAccess access) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("grammarAccess = (");
      String _gaFQName_1 = this.grammarAccess.gaFQName(this.grammar);
      String _imported_2 = file.imported(_gaFQName_1);
      _builder.append(_imported_2, "\t\t");
      _builder.append(") access;");
      _builder.newLineIfNotEmpty();
      {
        List<EqualAmbiguousTransitions> _allAmbiguousTransitionsBySyntax_1 = this.util.getAllAmbiguousTransitionsBySyntax();
        for(final EqualAmbiguousTransitions group_1 : _allAmbiguousTransitionsBySyntax_1) {
          _builder.append("\t\t");
          _builder.append("match_");
          String _identifyer_1 = group_1.getIdentifyer();
          _builder.append(_identifyer_1, "\t\t");
          _builder.append(" = ");
          GrammarAlias.AbstractElementAlias _elementAlias = group_1.getElementAlias();
          String _elementAliasToConstructor = this.util.elementAliasToConstructor(_elementAlias, file);
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
      CharSequence _genGetUnassignedRuleCallTokens = this.genGetUnassignedRuleCallTokens(file);
      _builder.append(_genGetUnassignedRuleCallTokens, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        List<AbstractRule> _unassignedCalledTokenRules = this.unassignedCalledTokenRules();
        boolean _hasElements = false;
        for(final AbstractRule rule : _unassignedCalledTokenRules) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate("\n", "\t");
          }
          _builder.append("\t");
          boolean _isAbstract_1 = filename.isAbstract();
          String _genGetUnassignedRuleCallToken = this.genGetUnassignedRuleCallToken(file, rule, _isAbstract_1);
          _builder.append(_genGetUnassignedRuleCallToken, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _genEmitUnassignedTokens = this.genEmitUnassignedTokens(file);
      _builder.append(_genEmitUnassignedTokens, "\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        List<EqualAmbiguousTransitions> _allAmbiguousTransitionsBySyntax_2 = this.util.getAllAmbiguousTransitionsBySyntax();
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
            final Function1<ISyntacticSequencerPDAProvider.ISynTransition, String> _function_3 = new Function1<ISyntacticSequencerPDAProvider.ISynTransition, String>() {
              @Override
              public String apply(final ISyntacticSequencerPDAProvider.ISynTransition it) {
                String _ambiguityInsideTransition = group_2.ambiguityInsideTransition(it);
                return _ambiguityInsideTransition.trim();
              }
            };
            List<String> _map_1 = ListExtensions.<ISyntacticSequencerPDAProvider.ISynTransition, String>map(_transitions, _function_3);
            Set<String> _set = IterableExtensions.<String>toSet(_map_1);
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
          String _identifyer_2 = group_2.getIdentifyer();
          _builder.append(_identifyer_2, "\t");
          _builder.append("(EObject semanticObject, ");
          String _imported_3 = file.imported(ISyntacticSequencerPDAProvider.ISynNavigable.class);
          _builder.append(_imported_3, "\t");
          _builder.append(" transition, List<INode> nodes) {");
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
      String _string_2 = _builder.toString();
      file.body = _string_2;
      _xblockexpression = file.toString();
    }
    return _xblockexpression;
  }
  
  public List<AbstractRule> unassignedCalledTokenRules() {
    List<AbstractRule> _allRules = GrammarUtil.allRules(this.grammar);
    final Function1<AbstractRule, Boolean> _function = new Function1<AbstractRule, Boolean>() {
      @Override
      public Boolean apply(final AbstractRule it) {
        return Boolean.valueOf(GrammarUtil.isEObjectRule(it));
      }
    };
    final Iterable<AbstractRule> rules = IterableExtensions.<AbstractRule>filter(_allRules, _function);
    final Function1<AbstractRule, Iterable<RuleCall>> _function_1 = new Function1<AbstractRule, Iterable<RuleCall>>() {
      @Override
      public Iterable<RuleCall> apply(final AbstractRule r) {
        List<RuleCall> _containedRuleCalls = GrammarUtil.containedRuleCalls(r);
        final Function1<RuleCall, Boolean> _function = new Function1<RuleCall, Boolean>() {
          @Override
          public Boolean apply(final RuleCall e) {
            return Boolean.valueOf(AbstractSyntacticSequencer.this.isUnassignedRuleCall(e));
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
  
  public boolean isUnassignedRuleCall(final RuleCall c) {
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
  
  public CharSequence unassignedCalledTokenRuleName(final AbstractRule rule) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get");
    String _name = rule.getName();
    _builder.append(_name, "");
    _builder.append("Token");
    return _builder;
  }
  
  public String defaultValue(final AbstractElement ele, final Set<AbstractElement> visited) {
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
          public String apply(final AbstractElement e) {
            return AbstractSyntacticSequencer.this.defaultValue(e, visited);
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
  
  public CharSequence genGetUnassignedRuleCallTokens(final JavaFile file) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {");
    _builder.newLine();
    _builder.append("\t");
    int i = 0;
    _builder.newLineIfNotEmpty();
    {
      List<AbstractRule> _unassignedCalledTokenRules = this.unassignedCalledTokenRules();
      for(final AbstractRule rule : _unassignedCalledTokenRules) {
        _builder.append("\t");
        {
          if (((i = (i + 1)) > 1)) {
            _builder.append("else ");
          }
        }
        _builder.append("if(ruleCall.getRule() == grammarAccess.");
        String _gaAccessor = this.grammarAccess.gaAccessor(rule);
        _builder.append(_gaAccessor, "\t");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        CharSequence _unassignedCalledTokenRuleName = this.unassignedCalledTokenRuleName(rule);
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
    return _builder;
  }
  
  public String textWithoutComments(final INode node) {
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
            return AbstractSyntacticSequencer.this.textWithoutComments(it);
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
  
  public String genGetUnassignedRuleCallToken(final JavaFile file, final AbstractRule rule, final boolean isAbstract) {
    if ((rule instanceof TerminalRule)) {
      boolean _and = false;
      if (!this.detectSyntheticTerminals) {
        _and = false;
      } else {
        boolean _isSyntheticTerminalRule = this.syntheticTerminalDetector.isSyntheticTerminalRule(((TerminalRule)rule));
        _and = _isSyntheticTerminalRule;
      }
      if (_and) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Synthetic terminal rule. The concrete syntax is to be specified by clients.");
        _builder.newLine();
        {
          if ((!isAbstract)) {
            _builder.append(" * Defaults to the empty string.");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("protected ");
        {
          if (isAbstract) {
            _builder.append("abstract ");
          }
        }
        _builder.append("String ");
        CharSequence _unassignedCalledTokenRuleName = this.unassignedCalledTokenRuleName(rule);
        _builder.append(_unassignedCalledTokenRuleName, "");
        _builder.append("(EObject semanticObject, RuleCall ruleCall, INode node)");
        {
          if (isAbstract) {
            _builder.append(";");
          } else {
            _builder.append(" { return \"\"; }");
          }
        }
        _builder.newLineIfNotEmpty();
        return _builder.toString();
      }
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* ");
    ICompositeNode _node = NodeModelUtils.getNode(rule);
    String _textWithoutComments = this.textWithoutComments(_node);
    String _trim = _textWithoutComments.trim();
    String _replace = _trim.replace("\n", "\n* ");
    _builder_1.append(_replace, " ");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("protected String ");
    CharSequence _unassignedCalledTokenRuleName_1 = this.unassignedCalledTokenRuleName(rule);
    _builder_1.append(_unassignedCalledTokenRuleName_1, "");
    _builder_1.append("(EObject semanticObject, RuleCall ruleCall, INode node) {");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("if (node != null)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return getTokenText(node);");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return \"");
    AbstractElement _alternatives = rule.getAlternatives();
    HashSet<AbstractElement> _newHashSet = CollectionLiterals.<AbstractElement>newHashSet();
    String _defaultValue = this.defaultValue(_alternatives, _newHashSet);
    String _convertToJavaString = Strings.convertToJavaString(_defaultValue);
    _builder_1.append(_convertToJavaString, "\t");
    _builder_1.append("\";");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("}");
    _builder_1.newLine();
    return _builder_1.toString();
  }
  
  public CharSequence genEmitUnassignedTokens(final JavaFile file) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (transition.getAmbiguousSyntaxes().isEmpty()) return;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("List<INode> transitionNodes = collectNodes(fromNode, toNode);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);");
    _builder.newLine();
    _builder.append("\t\t");
    int i = 0;
    _builder.newLineIfNotEmpty();
    {
      List<EqualAmbiguousTransitions> _allAmbiguousTransitionsBySyntax = this.util.getAllAmbiguousTransitionsBySyntax();
      for(final EqualAmbiguousTransitions group : _allAmbiguousTransitionsBySyntax) {
        _builder.append("\t\t");
        {
          if (((i = (i + 1)) > 1)) {
            _builder.append("else ");
          }
        }
        _builder.append("if(match_");
        String _identifyer = group.getIdentifyer();
        _builder.append(_identifyer, "\t\t");
        _builder.append(".equals(syntax))");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("emit_");
        String _identifyer_1 = group.getIdentifyer();
        _builder.append(_identifyer_1, "\t\t\t");
        _builder.append("(semanticObject, getLastNavigableState(), syntaxNodes);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    {
      if ((i > 0)) {
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
    return _builder;
  }
  
  @Pure
  public boolean isDetectSyntheticTerminals() {
    return this.detectSyntheticTerminals;
  }
  
  public void setDetectSyntheticTerminals(final boolean detectSyntheticTerminals) {
    this.detectSyntheticTerminals = detectSyntheticTerminals;
  }
  
  @Pure
  public SyntheticTerminalDetector getSyntheticTerminalDetector() {
    return this.syntheticTerminalDetector;
  }
  
  public void setSyntheticTerminalDetector(final SyntheticTerminalDetector syntheticTerminalDetector) {
    this.syntheticTerminalDetector = syntheticTerminalDetector;
  }
}
