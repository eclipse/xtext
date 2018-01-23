/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.generator.parser.antlr;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess;
import org.eclipse.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xtext.RuleNames;

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
    String _grammarElementIdentifier = this.grammarElementIdentifier(GrammarUtil.containingRule(it));
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
        final Function1<AbstractRule, String> _function = (AbstractRule it_1) -> {
          return this.ruleName(it_1);
        };
        return IterableExtensions.<String>toList(ListExtensions.<AbstractRule, String>map(it.getHiddenTokens(), _function));
      }
      int _size = it.getUsedGrammars().size();
      boolean _equals = (_size == 1);
      if (_equals) {
        return this.initialHiddenTokens(IterableExtensions.<Grammar>head(it.getUsedGrammars()));
      }
      _xblockexpression = CollectionLiterals.<String>emptyList();
    }
    return _xblockexpression;
  }
  
  public String ruleName(final AbstractRule rule) {
    final RuleNames ruleNames = RuleNames.tryGetRuleNames(rule);
    String _elvis = null;
    String _antlrRuleName = null;
    if (ruleNames!=null) {
      _antlrRuleName=ruleNames.getAntlrRuleName(rule);
    }
    if (_antlrRuleName != null) {
      _elvis = _antlrRuleName;
    } else {
      String _ruleName = AntlrGrammarGenUtil.getRuleName(rule);
      _elvis = _ruleName;
    }
    return _elvis;
  }
  
  public String entryRuleName(final ParserRule rule) {
    return AntlrGrammarGenUtil.getEntryRuleName(rule);
  }
  
  public boolean isCalled(final AbstractRule rule, final Grammar grammar) {
    boolean _xblockexpression = false;
    {
      final List<AbstractRule> allRules = GrammarUtil.allRules(grammar);
      _xblockexpression = ((allRules.indexOf(rule) == 0) || IterableExtensions.<RuleCall>exists(Iterables.<RuleCall>concat(ListExtensions.<AbstractRule, List<RuleCall>>map(allRules, ((Function1<AbstractRule, List<RuleCall>>) (AbstractRule it) -> {
        return GrammarUtil.containedRuleCalls(it);
      }))), ((Function1<RuleCall, Boolean>) (RuleCall ruleCall) -> {
        AbstractRule _rule = ruleCall.getRule();
        return Boolean.valueOf(Objects.equal(_rule, rule));
      })));
    }
    return _xblockexpression;
  }
  
  public boolean definesUnorderedGroups(final ParserRule it, final AntlrOptions options) {
    return (options.isBacktrack() && (!EcoreUtil2.<UnorderedGroup>typeSelect(EcoreUtil2.eAllContentsAsList(it), UnorderedGroup.class).isEmpty()));
  }
  
  protected boolean _mustBeParenthesized(final AbstractElement it) {
    return true;
  }
  
  protected boolean _mustBeParenthesized(final Keyword it) {
    return ((this.predicated(it) || it.isFirstSetPredicated()) || (it.getCardinality() != null));
  }
  
  protected boolean _mustBeParenthesized(final RuleCall it) {
    return ((this.predicated(it) || it.isFirstSetPredicated()) || (it.getCardinality() != null));
  }
  
  protected boolean _predicated(final AbstractElement it) {
    return it.isPredicated();
  }
  
  protected boolean _predicated(final Assignment it) {
    return (it.isPredicated() || this.predicated(it.getTerminal()));
  }
  
  protected boolean _predicated(final RuleCall it) {
    boolean _or = false;
    boolean _isPredicated = it.isPredicated();
    if (_isPredicated) {
      _or = true;
    } else {
      boolean _xblockexpression = false;
      {
        final AbstractElement group = it.getRule().getAlternatives();
        boolean _xifexpression = false;
        if ((group instanceof Group)) {
          _xifexpression = this.predicated(IterableExtensions.<AbstractElement>head(((Group)group).getElements()));
        } else {
          _xifexpression = false;
        }
        _xblockexpression = _xifexpression;
      }
      _or = _xblockexpression;
    }
    return _or;
  }
  
  public AbstractElement predicatedElement(final AbstractElement it) {
    return AntlrGrammarGenUtil.getPredicatedElement(it);
  }
  
  public String localVar(final Assignment it, final AbstractElement terminal) {
    String _feature = it.getFeature();
    String _plus = ("lv_" + _feature);
    String _plus_1 = (_plus + "_");
    int _indexOf = this.contentsAsList(GrammarUtil.containingParserRule(it)).indexOf(it);
    String _plus_2 = (_plus_1 + Integer.valueOf(_indexOf));
    String _plus_3 = (_plus_2 + "_");
    int _indexOf_1 = EcoreUtil2.eAllContentsAsList(it).indexOf(terminal);
    return (_plus_3 + Integer.valueOf(_indexOf_1));
  }
  
  protected String _localVar(final RuleCall it) {
    String _name = AntlrGrammarGenUtil.<AbstractRule>getOriginalElement(it.getRule()).getName();
    String _plus = ("this_" + _name);
    String _plus_1 = (_plus + "_");
    int _indexOf = this.contentsAsList(GrammarUtil.containingParserRule(it)).indexOf(it);
    return (_plus_1 + Integer.valueOf(_indexOf));
  }
  
  protected String _localVar(final AbstractElement it) {
    String _xblockexpression = null;
    {
      final ParserRule rule = GrammarUtil.containingParserRule(it);
      final int index = this.contentsAsList(rule).indexOf(it);
      _xblockexpression = ("otherlv_" + Integer.valueOf(index));
    }
    return _xblockexpression;
  }
  
  protected String _localVar(final EnumLiteralDeclaration it) {
    int _indexOf = this.contentsAsList(GrammarUtil.containingEnumRule(it).getAlternatives()).indexOf(it);
    return ("enumLiteral_" + Integer.valueOf(_indexOf));
  }
  
  protected List<AbstractElement> _contentsAsList(final ParserRule it) {
    return this.contentsAsList(it.getAlternatives());
  }
  
  protected List<AbstractElement> _contentsAsList(final AbstractElement it) {
    return CollectionLiterals.<AbstractElement>newArrayList(it);
  }
  
  protected List<AbstractElement> _contentsAsList(final CompoundElement it) {
    final Function1<AbstractElement, List<AbstractElement>> _function = (AbstractElement it_1) -> {
      return this.contentsAsList(it_1);
    };
    return IterableExtensions.<AbstractElement>toList(Iterables.<AbstractElement>concat(ListExtensions.<AbstractElement, List<AbstractElement>>map(it.getElements(), _function)));
  }
  
  protected List<AbstractElement> _contentsAsList(final UnorderedGroup it) {
    ArrayList<AbstractElement> _xblockexpression = null;
    {
      final ArrayList<AbstractElement> result = CollectionLiterals.<AbstractElement>newArrayList(it);
      final Function1<AbstractElement, List<AbstractElement>> _function = (AbstractElement it_1) -> {
        return this.contentsAsList(it_1);
      };
      List<AbstractElement> _list = IterableExtensions.<AbstractElement>toList(Iterables.<AbstractElement>concat(ListExtensions.<AbstractElement, List<AbstractElement>>map(it.getElements(), _function)));
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
  
  public CharSequence toStringLiteral(final AbstractElement it) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (it instanceof RuleCall) {
      AbstractRule _rule = ((RuleCall)it).getRule();
      boolean _tripleNotEquals = (_rule != null);
      if (_tripleNotEquals) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\"");
        String _name = ((RuleCall)it).getRule().getName();
        _builder.append(_name);
        _builder.append("\"");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (it instanceof Keyword) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\"");
        String _stringInAntlrAction = AntlrGrammarGenUtil.toStringInAntlrAction(((Keyword)it).getValue());
        _builder.append(_stringInAntlrAction);
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
  
  public boolean mustBeParenthesized(final AbstractElement it) {
    if (it instanceof Keyword) {
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
