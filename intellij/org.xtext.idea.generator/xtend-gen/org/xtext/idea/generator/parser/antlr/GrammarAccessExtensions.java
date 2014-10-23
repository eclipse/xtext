package org.xtext.idea.generator.parser.antlr;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess;
import org.eclipse.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@Singleton
@SuppressWarnings("all")
public class GrammarAccessExtensions {
  @Inject
  @Extension
  private GrammarAccess _grammarAccess;
  
  protected String _grammarElementIdentifier(final EObject it) {
    String _string = it.toString();
    return ("Unsupported : grammarElementIdentifier for: " + _string);
  }
  
  protected String _grammarElementIdentifier(final AbstractRule it) {
    return this._grammarAccess.gaRuleIdentifyer(it);
  }
  
  protected String _grammarElementIdentifier(final AbstractElement it) {
    AbstractRule _containingRule = GrammarUtil.containingRule(it);
    String _grammarElementIdentifier = this.grammarElementIdentifier(_containingRule);
    String _plus = (_grammarElementIdentifier + "_");
    String _gaElementIdentifyer = this._grammarAccess.gaElementIdentifyer(it);
    return (_plus + _gaElementIdentifyer);
  }
  
  protected String _grammarElementAccess(final EObject it) {
    String _string = it.toString();
    return ("Unsupported : grammarElementAccess for: " + _string);
  }
  
  protected String _grammarElementAccess(final AbstractRule it) {
    return this._grammarAccess.gaRuleAccessor(it);
  }
  
  protected String _grammarElementAccess(final AbstractElement it) {
    return this._grammarAccess.gaRuleElementAccessor(it);
  }
  
  public List<String> initialHiddenTokens(final Grammar it) {
    List<String> _xblockexpression = null;
    {
      boolean _isDefinesHiddenTokens = it.isDefinesHiddenTokens();
      if (_isDefinesHiddenTokens) {
        EList<AbstractRule> _hiddenTokens = it.getHiddenTokens();
        final Function1<AbstractRule, String> _function = new Function1<AbstractRule, String>() {
          public String apply(final AbstractRule it) {
            return GrammarAccessExtensions.this.ruleName(it);
          }
        };
        List<String> _map = ListExtensions.<AbstractRule, String>map(_hiddenTokens, _function);
        return IterableExtensions.<String>toList(_map);
      }
      EList<Grammar> _usedGrammars = it.getUsedGrammars();
      int _size = _usedGrammars.size();
      boolean _equals = (_size == 1);
      if (_equals) {
        EList<Grammar> _usedGrammars_1 = it.getUsedGrammars();
        Grammar _head = IterableExtensions.<Grammar>head(_usedGrammars_1);
        return this.initialHiddenTokens(_head);
      }
      _xblockexpression = CollectionLiterals.<String>emptyList();
    }
    return _xblockexpression;
  }
  
  protected String _ruleName(final ParserRule it) {
    String _name = it.getName();
    return ("rule" + _name);
  }
  
  protected String _ruleName(final EnumRule it) {
    String _name = it.getName();
    return ("rule" + _name);
  }
  
  protected String _ruleName(final TerminalRule it) {
    String _name = it.getName();
    String _upperCase = _name.toUpperCase();
    return ("RULE_" + _upperCase);
  }
  
  protected String _ruleName(final AbstractRule it) {
    return "Unsupported";
  }
  
  public String entryRuleName(final ParserRule it) {
    String _name = it.getName();
    return ("entryRule" + _name);
  }
  
  public boolean isCalled(final AbstractRule rule, final Grammar grammar) {
    boolean _xblockexpression = false;
    {
      final List<AbstractRule> allRules = GrammarUtil.allRules(grammar);
      boolean _or = false;
      int _indexOf = allRules.indexOf(rule);
      boolean _equals = (_indexOf == 0);
      if (_equals) {
        _or = true;
      } else {
        final Function1<AbstractRule, List<EObject>> _function = new Function1<AbstractRule, List<EObject>>() {
          public List<EObject> apply(final AbstractRule it) {
            return EcoreUtil2.eAllContentsAsList(it);
          }
        };
        List<List<EObject>> _map = ListExtensions.<AbstractRule, List<EObject>>map(allRules, _function);
        Iterable<EObject> _flatten = Iterables.<EObject>concat(_map);
        Iterable<RuleCall> _filter = Iterables.<RuleCall>filter(_flatten, RuleCall.class);
        final Function1<RuleCall, Boolean> _function_1 = new Function1<RuleCall, Boolean>() {
          public Boolean apply(final RuleCall it) {
            return Boolean.valueOf((!Objects.equal(rule, null)));
          }
        };
        Iterable<RuleCall> _filter_1 = IterableExtensions.<RuleCall>filter(_filter, _function_1);
        final Function1<RuleCall, AbstractRule> _function_2 = new Function1<RuleCall, AbstractRule>() {
          public AbstractRule apply(final RuleCall it) {
            return rule;
          }
        };
        Iterable<AbstractRule> _map_1 = IterableExtensions.<RuleCall, AbstractRule>map(_filter_1, _function_2);
        List<AbstractRule> _list = IterableExtensions.<AbstractRule>toList(_map_1);
        boolean _contains = _list.contains(rule);
        _or = _contains;
      }
      _xblockexpression = _or;
    }
    return _xblockexpression;
  }
  
  public boolean definesUnorderedGroups(final ParserRule it, final AntlrOptions options) {
    boolean _and = false;
    boolean _isBacktrack = options.isBacktrack();
    if (!_isBacktrack) {
      _and = false;
    } else {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(it);
      List<UnorderedGroup> _typeSelect = EcoreUtil2.<UnorderedGroup>typeSelect(_eAllContentsAsList, UnorderedGroup.class);
      boolean _isEmpty = _typeSelect.isEmpty();
      boolean _not = (!_isEmpty);
      _and = _not;
    }
    return _and;
  }
  
  protected boolean _mustBeParenthesized(final AbstractElement it) {
    return true;
  }
  
  protected boolean _mustBeParenthesized(final Group it) {
    return true;
  }
  
  protected boolean _mustBeParenthesized(final UnorderedGroup it) {
    return true;
  }
  
  protected boolean _mustBeParenthesized(final Alternatives it) {
    return true;
  }
  
  protected boolean _mustBeParenthesized(final EnumLiteralDeclaration it) {
    return true;
  }
  
  protected boolean _mustBeParenthesized(final Keyword it) {
    boolean _or = false;
    boolean _or_1 = false;
    boolean _predicated = this.predicated(it);
    if (_predicated) {
      _or_1 = true;
    } else {
      boolean _isFirstSetPredicated = it.isFirstSetPredicated();
      _or_1 = _isFirstSetPredicated;
    }
    if (_or_1) {
      _or = true;
    } else {
      String _cardinality = it.getCardinality();
      boolean _notEquals = (!Objects.equal(_cardinality, null));
      _or = _notEquals;
    }
    return _or;
  }
  
  protected boolean _mustBeParenthesized(final RuleCall it) {
    boolean _or = false;
    boolean _or_1 = false;
    boolean _predicated = this.predicated(it);
    if (_predicated) {
      _or_1 = true;
    } else {
      boolean _isFirstSetPredicated = it.isFirstSetPredicated();
      _or_1 = _isFirstSetPredicated;
    }
    if (_or_1) {
      _or = true;
    } else {
      String _cardinality = it.getCardinality();
      boolean _notEquals = (!Objects.equal(_cardinality, null));
      _or = _notEquals;
    }
    return _or;
  }
  
  protected boolean _predicated(final AbstractElement it) {
    return it.isPredicated();
  }
  
  protected boolean _predicated(final Assignment it) {
    boolean _or = false;
    boolean _isPredicated = it.isPredicated();
    if (_isPredicated) {
      _or = true;
    } else {
      AbstractElement _terminal = it.getTerminal();
      boolean _predicated = this.predicated(_terminal);
      _or = _predicated;
    }
    return _or;
  }
  
  protected boolean _predicated(final RuleCall it) {
    boolean _or = false;
    boolean _isPredicated = it.isPredicated();
    if (_isPredicated) {
      _or = true;
    } else {
      boolean _xblockexpression = false;
      {
        AbstractRule _rule = it.getRule();
        final AbstractElement group = _rule.getAlternatives();
        boolean _xifexpression = false;
        if ((group instanceof Group)) {
          EList<AbstractElement> _elements = ((Group)group).getElements();
          AbstractElement _head = IterableExtensions.<AbstractElement>head(_elements);
          _xifexpression = this.predicated(_head);
        } else {
          _xifexpression = false;
        }
        _xblockexpression = _xifexpression;
      }
      _or = _xblockexpression;
    }
    return _or;
  }
  
  protected AbstractElement _predicatedElement(final AbstractElement it) {
    return it;
  }
  
  protected AbstractElement _predicatedElement(final Assignment it) {
    AbstractElement _xifexpression = null;
    boolean _isPredicated = it.isPredicated();
    if (_isPredicated) {
      _xifexpression = it;
    } else {
      AbstractElement _terminal = it.getTerminal();
      _xifexpression = this.predicatedElement(_terminal);
    }
    return _xifexpression;
  }
  
  protected AbstractElement _predicatedElement(final RuleCall it) {
    AbstractElement _xifexpression = null;
    boolean _isPredicated = it.isPredicated();
    if (_isPredicated) {
      _xifexpression = it;
    } else {
      AbstractRule _rule = it.getRule();
      AbstractElement _alternatives = _rule.getAlternatives();
      EList<AbstractElement> _elements = ((Group) _alternatives).getElements();
      AbstractElement _head = IterableExtensions.<AbstractElement>head(_elements);
      _xifexpression = this.predicatedElement(_head);
    }
    return _xifexpression;
  }
  
  public String localVar(final Assignment it, final AbstractElement terminal) {
    String _feature = it.getFeature();
    String _plus = ("lv_" + _feature);
    String _plus_1 = (_plus + "_");
    ParserRule _containingParserRule = GrammarUtil.containingParserRule(it);
    List<AbstractElement> _contentsAsList = this.contentsAsList(_containingParserRule);
    int _indexOf = _contentsAsList.indexOf(it);
    String _plus_2 = (_plus_1 + Integer.valueOf(_indexOf));
    String _plus_3 = (_plus_2 + "_");
    List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(it);
    int _indexOf_1 = _eAllContentsAsList.indexOf(terminal);
    return (_plus_3 + Integer.valueOf(_indexOf_1));
  }
  
  protected String _localVar(final RuleCall it) {
    AbstractRule _rule = it.getRule();
    String _name = _rule.getName();
    String _plus = ("this_" + _name);
    String _plus_1 = (_plus + "_");
    ParserRule _containingParserRule = GrammarUtil.containingParserRule(it);
    List<AbstractElement> _contentsAsList = this.contentsAsList(_containingParserRule);
    int _indexOf = _contentsAsList.indexOf(it);
    return (_plus_1 + Integer.valueOf(_indexOf));
  }
  
  protected String _localVar(final AbstractElement it) {
    String _xblockexpression = null;
    {
      ParserRule _containingParserRule = GrammarUtil.containingParserRule(it);
      List<AbstractElement> _contentsAsList = this.contentsAsList(_containingParserRule);
      final int index = _contentsAsList.indexOf(it);
      _xblockexpression = ("otherlv_" + Integer.valueOf(index));
    }
    return _xblockexpression;
  }
  
  protected String _localVar(final EnumLiteralDeclaration it) {
    EnumRule _containingEnumRule = GrammarUtil.containingEnumRule(it);
    AbstractElement _alternatives = _containingEnumRule.getAlternatives();
    List<AbstractElement> _contentsAsList = this.contentsAsList(_alternatives);
    int _indexOf = _contentsAsList.indexOf(it);
    return ("enumLiteral_" + Integer.valueOf(_indexOf));
  }
  
  protected List<AbstractElement> _contentsAsList(final ParserRule it) {
    AbstractElement _alternatives = it.getAlternatives();
    return this.contentsAsList(_alternatives);
  }
  
  protected List<AbstractElement> _contentsAsList(final AbstractElement it) {
    return CollectionLiterals.<AbstractElement>newArrayList(it);
  }
  
  protected List<AbstractElement> _contentsAsList(final CompoundElement it) {
    EList<AbstractElement> _elements = it.getElements();
    final Function1<AbstractElement, List<AbstractElement>> _function = new Function1<AbstractElement, List<AbstractElement>>() {
      public List<AbstractElement> apply(final AbstractElement it) {
        return GrammarAccessExtensions.this.contentsAsList(it);
      }
    };
    List<List<AbstractElement>> _map = ListExtensions.<AbstractElement, List<AbstractElement>>map(_elements, _function);
    Iterable<AbstractElement> _flatten = Iterables.<AbstractElement>concat(_map);
    return IterableExtensions.<AbstractElement>toList(_flatten);
  }
  
  protected List<AbstractElement> _contentsAsList(final UnorderedGroup it) {
    ArrayList<AbstractElement> _xblockexpression = null;
    {
      final ArrayList<AbstractElement> result = CollectionLiterals.<AbstractElement>newArrayList(it);
      EList<AbstractElement> _elements = it.getElements();
      final Function1<AbstractElement, List<AbstractElement>> _function = new Function1<AbstractElement, List<AbstractElement>>() {
        public List<AbstractElement> apply(final AbstractElement it) {
          return GrammarAccessExtensions.this.contentsAsList(it);
        }
      };
      List<List<AbstractElement>> _map = ListExtensions.<AbstractElement, List<AbstractElement>>map(_elements, _function);
      Iterable<AbstractElement> _flatten = Iterables.<AbstractElement>concat(_map);
      List<AbstractElement> _list = IterableExtensions.<AbstractElement>toList(_flatten);
      Iterables.<AbstractElement>addAll(result, _list);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public String setOrAdd(final Action it) {
    String _xifexpression = null;
    String _operator = it.getOperator();
    boolean _equals = Objects.equal(_operator, "+=");
    if (_equals) {
      _xifexpression = "add";
    } else {
      _xifexpression = "set";
    }
    return _xifexpression;
  }
  
  public String setOrAdd(final Assignment it) {
    String _xifexpression = null;
    String _operator = it.getOperator();
    boolean _equals = Objects.equal(_operator, "+=");
    if (_equals) {
      _xifexpression = "add";
    } else {
      _xifexpression = "set";
    }
    return _xifexpression;
  }
  
  public boolean isBoolean(final Assignment it) {
    String _operator = it.getOperator();
    return Objects.equal(_operator, "?=");
  }
  
  public CharSequence toStringLiteral(final AbstractElement it) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof RuleCall) {
        AbstractRule _rule = ((RuleCall)it).getRule();
        boolean _notEquals = (!Objects.equal(_rule, null));
        if (_notEquals) {
          _matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("\"");
          AbstractRule _rule_1 = ((RuleCall)it).getRule();
          String _name = _rule_1.getName();
          _builder.append(_name, "");
          _builder.append("\"");
          _switchResult = _builder;
        }
      }
    }
    if (!_matched) {
      if (it instanceof Keyword) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\"");
        String _value = ((Keyword)it).getValue();
        String _stringInAntlrAction = AntlrGrammarGenUtil.toStringInAntlrAction(_value);
        _builder.append(_stringInAntlrAction, "");
        _builder.append("\"");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      _switchResult = "null";
    }
    return _switchResult;
  }
  
  public String grammarElementIdentifier(final EObject it) {
    if (it instanceof AbstractElement) {
      return _grammarElementIdentifier((AbstractElement)it);
    } else if (it instanceof AbstractRule) {
      return _grammarElementIdentifier((AbstractRule)it);
    } else if (it != null) {
      return _grammarElementIdentifier(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public String grammarElementAccess(final EObject it) {
    if (it instanceof AbstractElement) {
      return _grammarElementAccess((AbstractElement)it);
    } else if (it instanceof AbstractRule) {
      return _grammarElementAccess((AbstractRule)it);
    } else if (it != null) {
      return _grammarElementAccess(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public String ruleName(final AbstractRule it) {
    if (it instanceof EnumRule) {
      return _ruleName((EnumRule)it);
    } else if (it instanceof ParserRule) {
      return _ruleName((ParserRule)it);
    } else if (it instanceof TerminalRule) {
      return _ruleName((TerminalRule)it);
    } else if (it != null) {
      return _ruleName(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public boolean mustBeParenthesized(final AbstractElement it) {
    if (it instanceof Alternatives) {
      return _mustBeParenthesized((Alternatives)it);
    } else if (it instanceof Group) {
      return _mustBeParenthesized((Group)it);
    } else if (it instanceof UnorderedGroup) {
      return _mustBeParenthesized((UnorderedGroup)it);
    } else if (it instanceof EnumLiteralDeclaration) {
      return _mustBeParenthesized((EnumLiteralDeclaration)it);
    } else if (it instanceof Keyword) {
      return _mustBeParenthesized((Keyword)it);
    } else if (it instanceof RuleCall) {
      return _mustBeParenthesized((RuleCall)it);
    } else if (it != null) {
      return _mustBeParenthesized(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public boolean predicated(final AbstractElement it) {
    if (it instanceof Assignment) {
      return _predicated((Assignment)it);
    } else if (it instanceof RuleCall) {
      return _predicated((RuleCall)it);
    } else if (it != null) {
      return _predicated(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public AbstractElement predicatedElement(final AbstractElement it) {
    if (it instanceof Assignment) {
      return _predicatedElement((Assignment)it);
    } else if (it instanceof RuleCall) {
      return _predicatedElement((RuleCall)it);
    } else if (it != null) {
      return _predicatedElement(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public String localVar(final AbstractElement it) {
    if (it instanceof EnumLiteralDeclaration) {
      return _localVar((EnumLiteralDeclaration)it);
    } else if (it instanceof RuleCall) {
      return _localVar((RuleCall)it);
    } else if (it != null) {
      return _localVar(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public List<AbstractElement> contentsAsList(final EObject it) {
    if (it instanceof UnorderedGroup) {
      return _contentsAsList((UnorderedGroup)it);
    } else if (it instanceof CompoundElement) {
      return _contentsAsList((CompoundElement)it);
    } else if (it instanceof ParserRule) {
      return _contentsAsList((ParserRule)it);
    } else if (it instanceof AbstractElement) {
      return _contentsAsList((AbstractElement)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
