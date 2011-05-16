package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess;
import org.eclipse.xtext.generator.serializer.GeneratedFile;
import org.eclipse.xtext.generator.serializer.JavaFile;
import org.eclipse.xtext.generator.serializer.SyntacticSequencer;
import org.eclipse.xtext.generator.serializer.SyntacticSequencerUtil;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.analysis.NfaToGrammar.AbstractElementAlias;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class AbstractSyntacticSequencer extends GeneratedFile {
  
  @Inject
  private Grammar grammar;
  
  @Inject
  private GrammarAccess grammarAccess;
  
  @Inject
  private SyntacticSequencer sequencer;
  
  @Inject
  private SyntacticSequencerUtil util;
  
  public String getQualifiedName(final Grammar grammar) {
    String _name = this.getName(grammar, "Abstract", "SyntacticSequencer");
    return _name;
  }
  
  public String getFileContents() {
    String _xblockexpression = null;
    {
      String _packageName = this.getPackageName();
      JavaFile _javaFile = new JavaFile(_packageName);
      final JavaFile file = _javaFile;
      file.imported(org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer.class);
      file.imported(org.eclipse.xtext.RuleCall.class);
      file.imported(org.eclipse.xtext.nodemodel.INode.class);
      file.imported(org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition.class);
      file.imported(com.google.inject.Inject.class);
      file.imported(org.eclipse.xtext.AbstractElement.class);
      file.imported(org.eclipse.xtext.IGrammarAccess.class);
      file.imported(org.eclipse.emf.ecore.EObject.class);
      file.imported("org.eclipse.xtext.serializer.analysis.NfaToGrammar.AbstractElementAlias");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@SuppressWarnings(\"restriction\")");
      _builder.newLine();
      _builder.append("public class ");
      String _simpleName = this.getSimpleName();
      _builder.append(_simpleName, "");
      _builder.append(" extends AbstractSyntacticSequencer {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected ");
      String _gaFQName = this.grammarAccess.gaFQName(this.grammar);
      String _imported = file.imported(_gaFQName);
      _builder.append(_imported, "	");
      _builder.append(" grammarAccess;");
      _builder.newLineIfNotEmpty();
      {
        Map<AbstractElementAlias<ISynState>,List<ISynTransition>> _allAmbiguousTransitionsBySyntax = this.util.getAllAmbiguousTransitionsBySyntax();
        Set<Entry<AbstractElementAlias<ISynState>,List<ISynTransition>>> _entrySet = _allAmbiguousTransitionsBySyntax.entrySet();
        for(Entry<AbstractElementAlias<ISynState>,List<ISynTransition>> group : _entrySet) {
          _builder.append("\t");
          _builder.append("protected AbstractElementAlias<AbstractElement> match_");
          AbstractElementAlias<ISynState> _key = group.getKey();
          String _elementAliasToIdentifyer = this.util.elementAliasToIdentifyer(_key);
          _builder.append(_elementAliasToIdentifyer, "	");
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
      String _imported_1 = file.imported(_gaFQName_1);
      _builder.append(_imported_1, "		");
      _builder.append(") access;");
      _builder.newLineIfNotEmpty();
      {
        Map<AbstractElementAlias<ISynState>,List<ISynTransition>> _allAmbiguousTransitionsBySyntax_1 = this.util.getAllAmbiguousTransitionsBySyntax();
        Set<Entry<AbstractElementAlias<ISynState>,List<ISynTransition>>> _entrySet_1 = _allAmbiguousTransitionsBySyntax_1.entrySet();
        for(Entry<AbstractElementAlias<ISynState>,List<ISynTransition>> group_1 : _entrySet_1) {
          _builder.append("\t\t");
          _builder.append("match_");
          AbstractElementAlias<ISynState> _key_1 = group_1.getKey();
          String _elementAliasToIdentifyer_1 = this.util.elementAliasToIdentifyer(_key_1);
          _builder.append(_elementAliasToIdentifyer_1, "		");
          _builder.append(" = ");
          AbstractElementAlias<ISynState> _key_2 = group_1.getKey();
          String _elementAliasToConstructor = this.util.elementAliasToConstructor(_key_2, file);
          _builder.append(_elementAliasToConstructor, "		");
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
      StringConcatenation _genGetUnassignedRuleCallTokens = this.genGetUnassignedRuleCallTokens(file);
      _builder.append(_genGetUnassignedRuleCallTokens, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        Set<AbstractRule> _unassignedCalledTokenRules = this.unassignedCalledTokenRules();
        for(AbstractRule rule : _unassignedCalledTokenRules) {
          _builder.append("\t");
          StringConcatenation _genGetUnassignedRuleCallToken = this.genGetUnassignedRuleCallToken(file, rule);
          _builder.append(_genGetUnassignedRuleCallToken, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      StringConcatenation _genEmitUnassignedTokens = this.genEmitUnassignedTokens(file);
      _builder.append(_genEmitUnassignedTokens, "	");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        Map<AbstractElementAlias<ISynState>,List<ISynTransition>> _allAmbiguousTransitionsBySyntax_2 = this.util.getAllAmbiguousTransitionsBySyntax();
        Set<Entry<AbstractElementAlias<ISynState>,List<ISynTransition>>> _entrySet_2 = _allAmbiguousTransitionsBySyntax_2.entrySet();
        for(Entry<AbstractElementAlias<ISynState>,List<ISynTransition>> group_2 : _entrySet_2) {
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
          AbstractElementAlias<ISynState> _key_3 = group_2.getKey();
          _builder.append(_key_3, "	 ");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected void emit_");
          AbstractElementAlias<ISynState> _key_4 = group_2.getKey();
          String _elementAliasToIdentifyer_2 = this.util.elementAliasToIdentifyer(_key_4);
          _builder.append(_elementAliasToIdentifyer_2, "	");
          _builder.append("(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("acceptNodes(transition, fromNode, toNode);");
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
      file.setBody(_string);
      String _string_1 = file.toString();
      _xblockexpression = (_string_1);
    }
    return _xblockexpression;
  }
  
  public Set<AbstractRule> unassignedCalledTokenRules() {
    Set<AbstractRule> _xblockexpression = null;
    {
      List<AbstractRule> _allRules = GrammarUtil.allRules(this.grammar);
      final Function1<AbstractRule,Boolean> _function = new Function1<AbstractRule,Boolean>() {
          public Boolean apply(final AbstractRule e) {
            boolean _isEObjectRule = GrammarUtil.isEObjectRule(e);
            return ((Boolean)_isEObjectRule);
          }
        };
      Iterable<AbstractRule> _filter = IterableExtensions.<AbstractRule>filter(_allRules, _function);
      final Iterable<AbstractRule> rules = _filter;
      final Function1<AbstractRule,Iterable<RuleCall>> _function_1 = new Function1<AbstractRule,Iterable<RuleCall>>() {
          public Iterable<RuleCall> apply(final AbstractRule r) {
            List<RuleCall> _containedRuleCalls = GrammarUtil.containedRuleCalls(r);
            final Function1<RuleCall,Boolean> _function_2 = new Function1<RuleCall,Boolean>() {
                public Boolean apply(final RuleCall e_1) {
                  boolean _operator_and = false;
                  boolean _isAssigned = GrammarUtil.isAssigned(e_1);
                  boolean _operator_not = BooleanExtensions.operator_not(_isAssigned);
                  if (!_operator_not) {
                    _operator_and = false;
                  } else {
                    boolean _isEObjectRuleCall = GrammarUtil.isEObjectRuleCall(e_1);
                    boolean _operator_not_1 = BooleanExtensions.operator_not(_isEObjectRuleCall);
                    _operator_and = BooleanExtensions.operator_and(_operator_not, _operator_not_1);
                  }
                  return ((Boolean)_operator_and);
                }
              };
            Iterable<RuleCall> _filter_1 = IterableExtensions.<RuleCall>filter(_containedRuleCalls, _function_2);
            return _filter_1;
          }
        };
      Iterable<Iterable<RuleCall>> _map = IterableExtensions.<AbstractRule, Iterable<RuleCall>>map(rules, _function_1);
      Iterable<RuleCall> _flatten = IterableExtensions.<RuleCall>flatten(_map);
      final Iterable<RuleCall> calls = _flatten;
      final Function1<RuleCall,AbstractRule> _function_3 = new Function1<RuleCall,AbstractRule>() {
          public AbstractRule apply(final RuleCall e_2) {
            AbstractRule _rule = e_2.getRule();
            return _rule;
          }
        };
      Iterable<AbstractRule> _map_1 = IterableExtensions.<RuleCall, AbstractRule>map(calls, _function_3);
      Set<AbstractRule> _set = IterableExtensions.<AbstractRule>toSet(_map_1);
      _xblockexpression = (_set);
    }
    return _xblockexpression;
  }
  
  public StringConcatenation unassignedCalledTokenRuleName(final AbstractRule rule) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get");
    String _name = rule.getName();
    _builder.append(_name, "");
    _builder.append("Token");
    return _builder;
  }
  
  public Object defaultValue(final AbstractElement ele, final Set<AbstractElement> visited) {
    Object _switchResult = null;
    final AbstractElement ele_1 = ele;
    boolean matched = false;
    if (!matched) {
      boolean _add = visited.add(ele);
      boolean _operator_not = BooleanExtensions.operator_not(_add);
      if (_operator_not) {
        matched=true;
        _switchResult = "";
      }
    }
    if (!matched) {
      boolean _isOptionalCardinality = GrammarUtil.isOptionalCardinality(ele);
      if (_isOptionalCardinality) {
        matched=true;
        _switchResult = "";
      }
    }
    if (!matched) {
      if (ele_1 instanceof Alternatives) {
        final Alternatives ele_2 = (Alternatives) ele_1;
        matched=true;
        EList<AbstractElement> _elements = ele_2.getElements();
        AbstractElement _head = IterableExtensions.<AbstractElement>head(_elements);
        Object _defaultValue = this.defaultValue(_head, visited);
        _switchResult = _defaultValue;
      }
    }
    if (!matched) {
      if (ele_1 instanceof Group) {
        final Group ele_3 = (Group) ele_1;
        matched=true;
        EList<AbstractElement> _elements_1 = ele_3.getElements();
        final Function1<AbstractElement,Object> _function = new Function1<AbstractElement,Object>() {
            public Object apply(final AbstractElement e) {
              Object _defaultValue_1 = AbstractSyntacticSequencer.this.defaultValue(e, visited);
              return _defaultValue_1;
            }
          };
        List<Object> _map = ListExtensions.<AbstractElement, Object>map(_elements_1, _function);
        String _join = IterableExtensions.join(_map);
        _switchResult = _join;
      }
    }
    if (!matched) {
      if (ele_1 instanceof Keyword) {
        final Keyword ele_4 = (Keyword) ele_1;
        matched=true;
        String _value = ele_4.getValue();
        _switchResult = _value;
      }
    }
    if (!matched) {
      if (ele_1 instanceof RuleCall) {
        final RuleCall ele_5 = (RuleCall) ele_1;
        matched=true;
        AbstractRule _rule = ele_5.getRule();
        AbstractElement _alternatives = _rule.getAlternatives();
        Object _defaultValue_2 = this.defaultValue(_alternatives, visited);
        _switchResult = _defaultValue_2;
      }
    }
    if (!matched) {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  public StringConcatenation genGetUnassignedRuleCallTokens(final JavaFile file) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("protected String getUnassignedRuleCallToken(RuleCall ruleCall, INode node) {");
    _builder.newLine();
    _builder.append("\t");
    int i = 0;
    _builder.newLineIfNotEmpty();
    {
      Set<AbstractRule> _unassignedCalledTokenRules = this.unassignedCalledTokenRules();
      for(AbstractRule rule : _unassignedCalledTokenRules) {
        _builder.append("\t");
        {
          int _operator_plus = IntegerExtensions.operator_plus(((Integer)i), ((Integer)1));
          int _i = i = _operator_plus;
          boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_i), ((Integer)1));
          if (_operator_greaterThan) {
            _builder.append("else ");
          }
        }
        _builder.append("if(ruleCall.getRule() == grammarAccess.");
        String _gaAccessor = this.grammarAccess.gaAccessor(rule);
        _builder.append(_gaAccessor, "	");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        StringConcatenation _unassignedCalledTokenRuleName = this.unassignedCalledTokenRuleName(rule);
        _builder.append(_unassignedCalledTokenRuleName, "		");
        _builder.append("(ruleCall, node);");
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
  
  public StringConcatenation genGetUnassignedRuleCallToken(final JavaFile file, final AbstractRule rule) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected String ");
    StringConcatenation _unassignedCalledTokenRuleName = this.unassignedCalledTokenRuleName(rule);
    _builder.append(_unassignedCalledTokenRuleName, "");
    _builder.append("(RuleCall ruleCall, INode node) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return \"");
    AbstractElement _alternatives = rule.getAlternatives();
    HashSet<AbstractElement> _newHashSet = CollectionLiterals.<AbstractElement>newHashSet();
    Object _defaultValue = this.defaultValue(_alternatives, _newHashSet);
    _builder.append(_defaultValue, "	");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation genEmitUnassignedTokens(final JavaFile file) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (!transition.isSyntacticallyAmbiguous())");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t");
    int i = 0;
    _builder.newLineIfNotEmpty();
    {
      Map<AbstractElementAlias<ISynState>,List<ISynTransition>> _allAmbiguousTransitionsBySyntax = this.util.getAllAmbiguousTransitionsBySyntax();
      Set<Entry<AbstractElementAlias<ISynState>,List<ISynTransition>>> _entrySet = _allAmbiguousTransitionsBySyntax.entrySet();
      for(Entry<AbstractElementAlias<ISynState>,List<ISynTransition>> group : _entrySet) {
        _builder.append("\t");
        {
          int _operator_plus = IntegerExtensions.operator_plus(((Integer)i), ((Integer)1));
          int _i = i = _operator_plus;
          boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_i), ((Integer)1));
          if (_operator_greaterThan) {
            _builder.append("else ");
          }
        }
        _builder.append("if(match_");
        AbstractElementAlias<ISynState> _key = group.getKey();
        String _elementAliasToIdentifyer = this.util.elementAliasToIdentifyer(_key);
        _builder.append(_elementAliasToIdentifyer, "	");
        _builder.append(".equals(transition.getAmbiguousSyntax()))");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("emit_");
        AbstractElementAlias<ISynState> _key_1 = group.getKey();
        String _elementAliasToIdentifyer_1 = this.util.elementAliasToIdentifyer(_key_1);
        _builder.append(_elementAliasToIdentifyer_1, "		");
        _builder.append("(semanticObject, transition, fromNode, toNode);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    {
      boolean _operator_greaterThan_1 = ComparableExtensions.<Integer>operator_greaterThan(((Integer)i), ((Integer)0));
      if (_operator_greaterThan_1) {
        _builder.append("else ");
      }
    }
    _builder.append("acceptNodes(transition, fromNode, toNode);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}