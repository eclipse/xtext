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
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess;
import org.eclipse.xtext.generator.serializer.GeneratedFile;
import org.eclipse.xtext.generator.serializer.JavaFile;
import org.eclipse.xtext.generator.serializer.SerializerGenFileNames;
import org.eclipse.xtext.generator.serializer.SyntacticSequencerUtil;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.serializer.analysis.GrammarAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

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
  
  public CharSequence getFileContents(final SerializerGenFileNames.GenFileName filename) {
    String _xblockexpression = null;
    {
      String _packageName = filename.getPackageName();
      final JavaFile file = new JavaFile(_packageName);
      file.imported(org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer.class);
      file.imported(RuleCall.class);
      file.imported(INode.class);
      file.imported(ISyntacticSequencerPDAProvider.ISynTransition.class);
      file.imported(Inject.class);
      file.imported(IGrammarAccess.class);
      file.imported(EObject.class);
      file.imported(List.class);
      file.imported(GrammarAlias.AbstractElementAlias.class);
      String _xifexpression = null;
      boolean _isAbstract = filename.isAbstract();
      if (_isAbstract) {
        _xifexpression = "abstract ";
      } else {
        _xifexpression = "";
      }
      final String _abstract = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@SuppressWarnings(\"all\")");
      _builder.newLine();
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
        List<Pair<String,GrammarAlias.AbstractElementAlias>> _allAmbiguousTransitionsBySyntax = this.util.getAllAmbiguousTransitionsBySyntax();
        for(final Pair<String, GrammarAlias.AbstractElementAlias> group : _allAmbiguousTransitionsBySyntax) {
          _builder.append("\t");
          _builder.append("protected ");
          String _imported_1 = file.imported("org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias");
          _builder.append(_imported_1, "\t");
          _builder.append(" match_");
          String _first = group.getFirst();
          _builder.append(_first, "\t");
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
        List<Pair<String,GrammarAlias.AbstractElementAlias>> _allAmbiguousTransitionsBySyntax_1 = this.util.getAllAmbiguousTransitionsBySyntax();
        for(final Pair<String, GrammarAlias.AbstractElementAlias> group_1 : _allAmbiguousTransitionsBySyntax_1) {
          _builder.append("\t\t");
          _builder.append("match_");
          String _first_1 = group_1.getFirst();
          _builder.append(_first_1, "\t\t");
          _builder.append(" = ");
          GrammarAlias.AbstractElementAlias _second = group_1.getSecond();
          String _elementAliasToConstructor = this.util.elementAliasToConstructor(_second, file);
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
          CharSequence _genGetUnassignedRuleCallToken = this.genGetUnassignedRuleCallToken(file, rule);
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
        List<Pair<String,GrammarAlias.AbstractElementAlias>> _allAmbiguousTransitionsBySyntax_2 = this.util.getAllAmbiguousTransitionsBySyntax();
        for(final Pair<String, GrammarAlias.AbstractElementAlias> group_2 : _allAmbiguousTransitionsBySyntax_2) {
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Syntax:");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*     ");
          GrammarAlias.AbstractElementAlias _second_1 = group_2.getSecond();
          _builder.append(_second_1, "\t ");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected void emit_");
          String _first_2 = group_2.getFirst();
          _builder.append(_first_2, "\t");
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
      String _string = _builder.toString();
      file.body = _string;
      _xblockexpression = (file.toString());
    }
    return _xblockexpression;
  }
  
  public List<AbstractRule> unassignedCalledTokenRules() {
    List<AbstractRule> _xblockexpression = null;
    {
      List<AbstractRule> _allRules = GrammarUtil.allRules(this.grammar);
      final Function1<AbstractRule,Boolean> _function = new Function1<AbstractRule,Boolean>() {
        public Boolean apply(final AbstractRule it) {
          return Boolean.valueOf(GrammarUtil.isEObjectRule(it));
        }
      };
      final Iterable<AbstractRule> rules = IterableExtensions.<AbstractRule>filter(_allRules, _function);
      final Function1<AbstractRule,Iterable<RuleCall>> _function_1 = new Function1<AbstractRule,Iterable<RuleCall>>() {
        public Iterable<RuleCall> apply(final AbstractRule r) {
          List<RuleCall> _containedRuleCalls = GrammarUtil.containedRuleCalls(r);
          final Function1<RuleCall,Boolean> _function = new Function1<RuleCall,Boolean>() {
            public Boolean apply(final RuleCall e) {
              return Boolean.valueOf(AbstractSyntacticSequencer.this.isUnassignedRuleCall(e));
            }
          };
          return IterableExtensions.<RuleCall>filter(_containedRuleCalls, _function);
        }
      };
      Iterable<Iterable<RuleCall>> _map = IterableExtensions.<AbstractRule, Iterable<RuleCall>>map(rules, _function_1);
      final Iterable<RuleCall> calls = Iterables.<RuleCall>concat(_map);
      final Function1<RuleCall,AbstractRule> _function_2 = new Function1<RuleCall,AbstractRule>() {
        public AbstractRule apply(final RuleCall it) {
          return it.getRule();
        }
      };
      Iterable<AbstractRule> _map_1 = IterableExtensions.<RuleCall, AbstractRule>map(calls, _function_2);
      Set<AbstractRule> _set = IterableExtensions.<AbstractRule>toSet(_map_1);
      final Function1<AbstractRule,String> _function_3 = new Function1<AbstractRule,String>() {
        public String apply(final AbstractRule it) {
          return it.getName();
        }
      };
      _xblockexpression = (IterableExtensions.<AbstractRule, String>sortBy(_set, _function_3));
    }
    return _xblockexpression;
  }
  
  public boolean isUnassignedRuleCall(final RuleCall c) {
    boolean _xblockexpression = false;
    {
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
        _or = (_equals || _isBooleanAssignment);
      }
      _xblockexpression = (_or);
    }
    return _xblockexpression;
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
        final Function1<AbstractElement,String> _function = new Function1<AbstractElement,String>() {
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
          int _i = i = (i + 1);
          boolean _greaterThan = (_i > 1);
          if (_greaterThan) {
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
          _or = (_not || _equals);
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
        final Function1<INode,String> _function = new Function1<INode,String>() {
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
  
  public CharSequence genGetUnassignedRuleCallToken(final JavaFile file, final AbstractRule rule) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    ICompositeNode _node = NodeModelUtils.getNode(rule);
    String _textWithoutComments = this.textWithoutComments(_node);
    String _trim = _textWithoutComments.trim();
    String _replace = _trim.replace("\n", "\n* ");
    _builder.append(_replace, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("protected String ");
    CharSequence _unassignedCalledTokenRuleName = this.unassignedCalledTokenRuleName(rule);
    _builder.append(_unassignedCalledTokenRuleName, "");
    _builder.append("(EObject semanticObject, RuleCall ruleCall, INode node) {");
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
    String _defaultValue = this.defaultValue(_alternatives, _newHashSet);
    String _convertToJavaString = Strings.convertToJavaString(_defaultValue);
    _builder.append(_convertToJavaString, "\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
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
      List<Pair<String,GrammarAlias.AbstractElementAlias>> _allAmbiguousTransitionsBySyntax = this.util.getAllAmbiguousTransitionsBySyntax();
      for(final Pair<String, GrammarAlias.AbstractElementAlias> group : _allAmbiguousTransitionsBySyntax) {
        _builder.append("\t\t");
        {
          int _i = i = (i + 1);
          boolean _greaterThan = (_i > 1);
          if (_greaterThan) {
            _builder.append("else ");
          }
        }
        _builder.append("if(match_");
        String _first = group.getFirst();
        _builder.append(_first, "\t\t");
        _builder.append(".equals(syntax))");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("emit_");
        String _first_1 = group.getFirst();
        _builder.append(_first_1, "\t\t\t");
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
}
