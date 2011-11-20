package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
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
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

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
  
  public CharSequence getFileContents() {
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
      file.imported(org.eclipse.xtext.IGrammarAccess.class);
      file.imported(org.eclipse.emf.ecore.EObject.class);
      file.imported(java.util.List.class);
      file.imported(org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias.class);
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
        List<Pair<String,AbstractElementAlias>> _allAmbiguousTransitionsBySyntax = this.util.getAllAmbiguousTransitionsBySyntax();
        for(final Pair<String,AbstractElementAlias> group : _allAmbiguousTransitionsBySyntax) {
          _builder.append("\t");
          _builder.append("protected ");
          String _imported_1 = file.imported("org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias");
          _builder.append(_imported_1, "	");
          _builder.append(" match_");
          String _first = group.getFirst();
          _builder.append(_first, "	");
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
      _builder.append(_imported_2, "		");
      _builder.append(") access;");
      _builder.newLineIfNotEmpty();
      {
        List<Pair<String,AbstractElementAlias>> _allAmbiguousTransitionsBySyntax_1 = this.util.getAllAmbiguousTransitionsBySyntax();
        for(final Pair<String,AbstractElementAlias> group_1 : _allAmbiguousTransitionsBySyntax_1) {
          _builder.append("\t\t");
          _builder.append("match_");
          String _first_1 = group_1.getFirst();
          _builder.append(_first_1, "		");
          _builder.append(" = ");
          AbstractElementAlias _second = group_1.getSecond();
          String _elementAliasToConstructor = this.util.elementAliasToConstructor(_second, file);
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
      CharSequence _genGetUnassignedRuleCallTokens = this.genGetUnassignedRuleCallTokens(file);
      _builder.append(_genGetUnassignedRuleCallTokens, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        List<AbstractRule> _unassignedCalledTokenRules = this.unassignedCalledTokenRules();
        for(final AbstractRule rule : _unassignedCalledTokenRules) {
          _builder.append("\t");
          CharSequence _genGetUnassignedRuleCallToken = this.genGetUnassignedRuleCallToken(file, rule);
          _builder.append(_genGetUnassignedRuleCallToken, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _genEmitUnassignedTokens = this.genEmitUnassignedTokens(file);
      _builder.append(_genEmitUnassignedTokens, "	");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        List<Pair<String,AbstractElementAlias>> _allAmbiguousTransitionsBySyntax_2 = this.util.getAllAmbiguousTransitionsBySyntax();
        for(final Pair<String,AbstractElementAlias> group_2 : _allAmbiguousTransitionsBySyntax_2) {
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
          AbstractElementAlias _second_1 = group_2.getSecond();
          _builder.append(_second_1, "	 ");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected void emit_");
          String _first_2 = group_2.getFirst();
          _builder.append(_first_2, "	");
          _builder.append("(EObject semanticObject, ");
          String _imported_3 = file.imported(org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable.class);
          _builder.append(_imported_3, "	");
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
      file.setBody(_string);
      String _string_1 = file.toString();
      _xblockexpression = (_string_1);
    }
    return _xblockexpression;
  }
  
  public List<AbstractRule> unassignedCalledTokenRules() {
    List<AbstractRule> _xblockexpression = null;
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
            final Function1<RuleCall,Boolean> _function = new Function1<RuleCall,Boolean>() {
                public Boolean apply(final RuleCall e) {
                  boolean _operator_and = false;
                  boolean _isAssigned = GrammarUtil.isAssigned(e);
                  boolean _operator_not = BooleanExtensions.operator_not(_isAssigned);
                  if (!_operator_not) {
                    _operator_and = false;
                  } else {
                    boolean _isEObjectRuleCall = GrammarUtil.isEObjectRuleCall(e);
                    boolean _operator_not_1 = BooleanExtensions.operator_not(_isEObjectRuleCall);
                    _operator_and = BooleanExtensions.operator_and(_operator_not, _operator_not_1);
                  }
                  return ((Boolean)_operator_and);
                }
              };
            Iterable<RuleCall> _filter_1 = IterableExtensions.<RuleCall>filter(_containedRuleCalls, _function);
            return _filter_1;
          }
        };
      Iterable<Iterable<RuleCall>> _map = IterableExtensions.<AbstractRule, Iterable<RuleCall>>map(rules, _function_1);
      Iterable<RuleCall> _flatten = IterableExtensions.<RuleCall>flatten(_map);
      final Iterable<RuleCall> calls = _flatten;
      final Function1<RuleCall,AbstractRule> _function_2 = new Function1<RuleCall,AbstractRule>() {
          public AbstractRule apply(final RuleCall e) {
            AbstractRule _rule = e.getRule();
            return _rule;
          }
        };
      Iterable<AbstractRule> _map_1 = IterableExtensions.<RuleCall, AbstractRule>map(calls, _function_2);
      Set<AbstractRule> _set = IterableExtensions.<AbstractRule>toSet(_map_1);
      final Function2<AbstractRule,AbstractRule,Integer> _function_3 = new Function2<AbstractRule,AbstractRule,Integer>() {
          public Integer apply(final AbstractRule r1, final AbstractRule r2) {
            String _name = r1.getName();
            String _name_1 = r2.getName();
            int _compareTo = _name.compareTo(_name_1);
            return _compareTo;
          }
        };
      List<AbstractRule> _sort = IterableExtensions.<AbstractRule>sort(_set, new Comparator<AbstractRule>() {
          public int compare(AbstractRule o1,AbstractRule o2) {
            return _function_3.apply(o1,o2);
          }
      });
      _xblockexpression = (_sort);
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
        String _defaultValue = this.defaultValue(_head, visited);
        _switchResult = _defaultValue;
      }
    }
    if (!matched) {
      if (ele_1 instanceof Group) {
        final Group ele_3 = (Group) ele_1;
        matched=true;
        EList<AbstractElement> _elements_1 = ele_3.getElements();
        final Function1<AbstractElement,String> _function = new Function1<AbstractElement,String>() {
            public String apply(final AbstractElement e) {
              String _defaultValue_1 = AbstractSyntacticSequencer.this.defaultValue(e, visited);
              return _defaultValue_1;
            }
          };
        List<String> _map = ListExtensions.<AbstractElement, String>map(_elements_1, _function);
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
        String _defaultValue_1 = this.defaultValue(_alternatives, visited);
        _switchResult = _defaultValue_1;
      }
    }
    if (!matched) {
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
        CharSequence _unassignedCalledTokenRuleName = this.unassignedCalledTokenRuleName(rule);
        _builder.append(_unassignedCalledTokenRuleName, "		");
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
  
  public CharSequence genGetUnassignedRuleCallToken(final JavaFile file, final AbstractRule rule) {
    StringConcatenation _builder = new StringConcatenation();
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
    _builder.append(_convertToJavaString, "	");
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
      List<Pair<String,AbstractElementAlias>> _allAmbiguousTransitionsBySyntax = this.util.getAllAmbiguousTransitionsBySyntax();
      for(final Pair<String,AbstractElementAlias> group : _allAmbiguousTransitionsBySyntax) {
        _builder.append("\t\t");
        {
          int _operator_plus = IntegerExtensions.operator_plus(((Integer)i), ((Integer)1));
          int _i = i = _operator_plus;
          boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_i), ((Integer)1));
          if (_operator_greaterThan) {
            _builder.append("else ");
          }
        }
        _builder.append("if(match_");
        String _first = group.getFirst();
        _builder.append(_first, "		");
        _builder.append(".equals(syntax))");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("emit_");
        String _first_1 = group.getFirst();
        _builder.append(_first_1, "			");
        _builder.append("(semanticObject, getLastNavigableState(), syntaxNodes);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    {
      boolean _operator_greaterThan_1 = ComparableExtensions.<Integer>operator_greaterThan(((Integer)i), ((Integer)0));
      if (_operator_greaterThan_1) {
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
