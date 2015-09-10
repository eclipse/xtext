/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.generator.parser.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.RuleNames;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess;
import org.eclipse.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.generator.parser.antlr.TerminalRuleToLexerBody;
import org.eclipse.xtext.idea.generator.parser.antlr.GrammarAccessExtensions;
import org.eclipse.xtext.idea.generator.parser.antlr.NamingExtensions;
import org.eclipse.xtext.idea.generator.parser.antlr.XtextIDEAGeneratorExtensions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.normalization.FlattenedGrammarAccess;
import org.eclipse.xtext.xtext.generator.normalization.RuleFilter;

@Singleton
@SuppressWarnings("all")
public class DefaultAntlrGrammarGenerator {
  @Inject
  @Extension
  protected Naming _naming;
  
  @Inject
  @Extension
  protected GrammarAccess _grammarAccess;
  
  @Inject
  @Extension
  protected NamingExtensions _namingExtensions;
  
  @Inject
  @Extension
  protected GrammarAccessExtensions _grammarAccessExtensions;
  
  @Inject
  @Extension
  protected XtextIDEAGeneratorExtensions _xtextIDEAGeneratorExtensions;
  
  public void generate(final Grammar it, final AntlrOptions options, final Xtend2ExecutionContext ctx) {
    final RuleFilter filter = new RuleFilter();
    Grammar _grammar = GrammarUtil.getGrammar(it);
    final RuleNames ruleNames = RuleNames.getRuleNames(_grammar, true);
    FlattenedGrammarAccess _flattenedGrammarAccess = new FlattenedGrammarAccess(ruleNames, filter);
    final Grammar flattened = _flattenedGrammarAccess.getFlattenedGrammar();
    Outlet _srcGenOutlet = this._xtextIDEAGeneratorExtensions.getSrcGenOutlet(ctx);
    String _name = _srcGenOutlet.getName();
    String _grammarFileName = this.getGrammarFileName(it);
    String _asPath = this._naming.asPath(_grammarFileName);
    String _plus = (_asPath + ".g");
    CharSequence _compile = this.compile(flattened, options);
    ctx.writeFile(_name, _plus, _compile);
  }
  
  protected String getGrammarFileName(final Grammar it) {
    return this._namingExtensions.getGrammarFileName(it, "Debug");
  }
  
  protected CharSequence compile(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    String _fileHeader = this._naming.fileHeader();
    _builder.append(_fileHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("grammar ");
    String _grammarFileName = this.getGrammarFileName(it);
    String _simpleName = this._naming.toSimpleName(_grammarFileName);
    _builder.append(_simpleName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    String _compileOptions = this.compileOptions(it, options);
    _builder.append(_compileOptions, "");
    _builder.newLineIfNotEmpty();
    String _compileTokens = this.compileTokens(it, options);
    _builder.append(_compileTokens, "");
    _builder.newLineIfNotEmpty();
    CharSequence _compileLexerHeader = this.compileLexerHeader(it, options);
    _builder.append(_compileLexerHeader, "");
    _builder.newLineIfNotEmpty();
    CharSequence _compileParserHeader = this.compileParserHeader(it, options);
    _builder.append(_compileParserHeader, "");
    _builder.newLineIfNotEmpty();
    String _compileParserMembers = this.compileParserMembers(it, options);
    _builder.append(_compileParserMembers, "");
    _builder.newLineIfNotEmpty();
    String _compileRuleCatch = this.compileRuleCatch(it, options);
    _builder.append(_compileRuleCatch, "");
    _builder.newLineIfNotEmpty();
    CharSequence _compileRules = this.compileRules(it, options);
    _builder.append(_compileRules, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected String compileOptions(final Grammar it, final AntlrOptions options) {
    return "";
  }
  
  protected String compileTokens(final Grammar it, final AntlrOptions options) {
    return "";
  }
  
  protected CharSequence compileLexerHeader(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("@lexer::header {");
    _builder.newLine();
    _builder.append("package ");
    String _grammarFileName = this.getGrammarFileName(it);
    String _packageName = this._naming.toPackageName(_grammarFileName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    CharSequence _compileLexerImports = this.compileLexerImports(it, options);
    _builder.append(_compileLexerImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence compileLexerImports(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("// Hack: Use our own Lexer superclass by means of import. ");
    _builder.newLine();
    _builder.append("// Currently there is no other way to specify the superclass for the lexer.");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.parser.antlr.Lexer;");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence compileParserHeader(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("@parser::header {");
    _builder.newLine();
    _builder.append("package ");
    String _grammarFileName = this.getGrammarFileName(it);
    String _packageName = this._naming.toPackageName(_grammarFileName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    String _compileParserImports = this.compileParserImports(it, options);
    _builder.append(_compileParserImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected String compileParserImports(final Grammar it, final AntlrOptions options) {
    return "";
  }
  
  protected String compileParserMembers(final Grammar it, final AntlrOptions options) {
    return "";
  }
  
  protected String compileRuleCatch(final Grammar it, final AntlrOptions options) {
    return "";
  }
  
  protected CharSequence compileRules(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<ParserRule> _allParserRules = GrammarUtil.allParserRules(it);
      final Function1<ParserRule, Boolean> _function = new Function1<ParserRule, Boolean>() {
        @Override
        public Boolean apply(final ParserRule rule) {
          return Boolean.valueOf(DefaultAntlrGrammarGenerator.this._grammarAccessExtensions.isCalled(rule, it));
        }
      };
      Iterable<ParserRule> _filter = IterableExtensions.<ParserRule>filter(_allParserRules, _function);
      for(final ParserRule rule : _filter) {
        _builder.newLine();
        String _compileRule = this.compileRule(rule, it, options);
        _builder.append(_compileRule, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      List<EnumRule> _allEnumRules = GrammarUtil.allEnumRules(it);
      final Function1<EnumRule, Boolean> _function_1 = new Function1<EnumRule, Boolean>() {
        @Override
        public Boolean apply(final EnumRule rule) {
          return Boolean.valueOf(DefaultAntlrGrammarGenerator.this._grammarAccessExtensions.isCalled(rule, it));
        }
      };
      Iterable<EnumRule> _filter_1 = IterableExtensions.<EnumRule>filter(_allEnumRules, _function_1);
      for(final EnumRule rule_1 : _filter_1) {
        _builder.newLine();
        String _compileRule_1 = this.compileRule(rule_1, it, options);
        _builder.append(_compileRule_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(it);
      for(final TerminalRule rule_2 : _allTerminalRules) {
        _builder.newLine();
        CharSequence _compileRule_2 = this.compileRule(rule_2, it, options);
        _builder.append(_compileRule_2, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected String compileRule(final EnumRule it, final Grammar grammar, final AntlrOptions options) {
    return this.compileEBNF(it, options);
  }
  
  protected String compileRule(final ParserRule it, final Grammar grammar, final AntlrOptions options) {
    return this.compileEBNF(it, options);
  }
  
  protected CharSequence compileRule(final TerminalRule it, final Grammar grammar, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isFragment = it.isFragment();
      if (_isFragment) {
        _builder.append("fragment ");
      }
    }
    String _ruleName = this._grammarAccessExtensions.ruleName(it);
    _builder.append(_ruleName, "");
    _builder.append(" : ");
    String _lexerBody = TerminalRuleToLexerBody.toLexerBody(it);
    _builder.append(_lexerBody, "");
    {
      boolean _shouldBeSkipped = this.shouldBeSkipped(it, grammar);
      if (_shouldBeSkipped) {
        _builder.append(" {skip();}");
      }
    }
    _builder.append(";");
    return _builder;
  }
  
  protected boolean shouldBeSkipped(final TerminalRule it, final Grammar grammar) {
    List<String> _initialHiddenTokens = this._grammarAccessExtensions.initialHiddenTokens(grammar);
    String _ruleName = this._grammarAccessExtensions.ruleName(it);
    return _initialHiddenTokens.contains(_ruleName);
  }
  
  protected String compileEBNF(final AbstractRule it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// Rule ");
    AbstractRule _originalElement = AntlrGrammarGenUtil.<AbstractRule>getOriginalElement(it);
    String _name = _originalElement.getName();
    _builder.append(_name, "");
    _builder.newLineIfNotEmpty();
    String _ruleName = this._grammarAccessExtensions.ruleName(it);
    _builder.append(_ruleName, "");
    String _compileInit = this.compileInit(it, options);
    _builder.append(_compileInit, "");
    _builder.append(":");
    _builder.newLineIfNotEmpty();
    {
      boolean _and = false;
      if (!(it instanceof ParserRule)) {
        _and = false;
      } else {
        AbstractRule _originalElement_1 = AntlrGrammarGenUtil.<AbstractRule>getOriginalElement(it);
        boolean _isDatatypeRule = GrammarUtil.isDatatypeRule(_originalElement_1);
        _and = _isDatatypeRule;
      }
      if (_and) {
        _builder.append("\t");
        AbstractElement _alternatives = it.getAlternatives();
        String _dataTypeEbnf = this.dataTypeEbnf(_alternatives, true);
        _builder.append(_dataTypeEbnf, "\t");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t");
        AbstractElement _alternatives_1 = it.getAlternatives();
        String _ebnf = this.ebnf(_alternatives_1, options, true);
        _builder.append(_ebnf, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(";");
    _builder.newLine();
    String _compileFinally = this.compileFinally(it, options);
    _builder.append(_compileFinally, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String compileInit(final AbstractRule it, final AntlrOptions options) {
    return "";
  }
  
  protected String compileFinally(final AbstractRule it, final AntlrOptions options) {
    return "";
  }
  
  protected String ebnf(final AbstractElement it, final AntlrOptions options, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _mustBeParenthesized = this._grammarAccessExtensions.mustBeParenthesized(it);
      if (_mustBeParenthesized) {
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _ebnfPredicate = this.ebnfPredicate(it, options);
        _builder.append(_ebnfPredicate, "\t");
        String _ebnf2 = this.ebnf2(it, options, supportActions);
        _builder.append(_ebnf2, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append(")");
      } else {
        String _ebnf2_1 = this.ebnf2(it, options, supportActions);
        _builder.append(_ebnf2_1, "");
      }
    }
    String _cardinality = it.getCardinality();
    _builder.append(_cardinality, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String ebnfPredicate(final AbstractElement it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _or = false;
      boolean _predicated = this._grammarAccessExtensions.predicated(it);
      if (_predicated) {
        _or = true;
      } else {
        boolean _isFirstSetPredicated = it.isFirstSetPredicated();
        _or = _isFirstSetPredicated;
      }
      if (_or) {
        _builder.append("(");
        {
          boolean _predicated_1 = this._grammarAccessExtensions.predicated(it);
          if (_predicated_1) {
            AbstractElement _predicatedElement = this._grammarAccessExtensions.predicatedElement(it);
            String _ebnf2 = this.ebnf2(_predicatedElement, options, false);
            _builder.append(_ebnf2, "");
          } else {
            {
              List<AbstractElement> _firstSet = AntlrGrammarGenUtil.getFirstSet(it);
              boolean _hasElements = false;
              for(final AbstractElement e : _firstSet) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(" | ", "");
                }
                String _ebnf2_1 = this.ebnf2(e, options, false);
                _builder.append(_ebnf2_1, "");
              }
            }
          }
        }
        _builder.append(")=>");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String dataTypeEbnf(final AbstractElement it, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _mustBeParenthesized = this._grammarAccessExtensions.mustBeParenthesized(it);
      if (_mustBeParenthesized) {
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _dataTypeEbnfPredicate = this.dataTypeEbnfPredicate(it);
        _builder.append(_dataTypeEbnfPredicate, "\t");
        String _dataTypeEbnf2 = this.dataTypeEbnf2(it, supportActions);
        _builder.append(_dataTypeEbnf2, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append(")");
      } else {
        String _dataTypeEbnf2_1 = this.dataTypeEbnf2(it, supportActions);
        _builder.append(_dataTypeEbnf2_1, "");
      }
    }
    String _cardinality = it.getCardinality();
    _builder.append(_cardinality, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String dataTypeEbnfPredicate(final AbstractElement it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _or = false;
      boolean _predicated = this._grammarAccessExtensions.predicated(it);
      if (_predicated) {
        _or = true;
      } else {
        boolean _isFirstSetPredicated = it.isFirstSetPredicated();
        _or = _isFirstSetPredicated;
      }
      if (_or) {
        _builder.append("(");
        {
          boolean _predicated_1 = this._grammarAccessExtensions.predicated(it);
          if (_predicated_1) {
            AbstractElement _predicatedElement = this._grammarAccessExtensions.predicatedElement(it);
            String _dataTypeEbnf2 = this.dataTypeEbnf2(_predicatedElement, false);
            _builder.append(_dataTypeEbnf2, "");
          } else {
            {
              List<AbstractElement> _firstSet = AntlrGrammarGenUtil.getFirstSet(it);
              boolean _hasElements = false;
              for(final AbstractElement e : _firstSet) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(" | ", "");
                }
                String _dataTypeEbnf2_1 = this.dataTypeEbnf2(e, false);
                _builder.append(_dataTypeEbnf2_1, "");
              }
            }
          }
        }
        _builder.append(")=>");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _dataTypeEbnf2(final AbstractElement it, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ERROR ");
    EClass _eClass = it.eClass();
    String _name = _eClass.getName();
    _builder.append(_name, "");
    _builder.append(" not matched");
    return _builder.toString();
  }
  
  protected String _dataTypeEbnf2(final Alternatives it, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<AbstractElement> _elements = it.getElements();
      boolean _hasElements = false;
      for(final AbstractElement e : _elements) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n    |", "");
        }
        String _dataTypeEbnf = this.dataTypeEbnf(e, supportActions);
        _builder.append(_dataTypeEbnf, "");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _dataTypeEbnf2(final Group it, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<AbstractElement> _elements = it.getElements();
      for(final AbstractElement e : _elements) {
        String _dataTypeEbnf = this.dataTypeEbnf(e, supportActions);
        _builder.append(_dataTypeEbnf, "");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _dataTypeEbnf2(final UnorderedGroup it, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    {
      EList<AbstractElement> _elements = it.getElements();
      boolean _hasElements = false;
      for(final AbstractElement e : _elements) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n    |", "");
        }
        String _dataTypeEbnf2 = this.dataTypeEbnf2(e, supportActions);
        _builder.append(_dataTypeEbnf2, "");
      }
    }
    _builder.append(")*");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _dataTypeEbnf2(final Keyword it, final boolean supportActions) {
    String _value = it.getValue();
    String _antlrString = AntlrGrammarGenUtil.toAntlrString(_value);
    String _plus = ("\'" + _antlrString);
    return (_plus + "\'");
  }
  
  protected String _dataTypeEbnf2(final RuleCall it, final boolean supportActions) {
    AbstractRule _rule = it.getRule();
    return this._grammarAccessExtensions.ruleName(_rule);
  }
  
  protected String _ebnf2(final AbstractElement it, final AntlrOptions options, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ERROR ");
    EClass _eClass = it.eClass();
    String _name = _eClass.getName();
    _builder.append(_name, "");
    _builder.append(" not matched");
    return _builder.toString();
  }
  
  protected String _ebnf2(final Alternatives it, final AntlrOptions options, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<AbstractElement> _elements = it.getElements();
      boolean _hasElements = false;
      for(final AbstractElement element : _elements) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n    |", "");
        }
        String _ebnf = this.ebnf(element, options, supportActions);
        _builder.append(_ebnf, "");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _ebnf2(final Group it, final AntlrOptions options, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<AbstractElement> _elements = it.getElements();
      for(final AbstractElement element : _elements) {
        String _ebnf = this.ebnf(element, options, supportActions);
        _builder.append(_ebnf, "");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _ebnf2(final UnorderedGroup it, final AntlrOptions options, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    {
      EList<AbstractElement> _elements = it.getElements();
      boolean _hasElements = false;
      for(final AbstractElement element : _elements) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n    |", "");
        }
        String _ebnf = this.ebnf(element, options, supportActions);
        _builder.append(_ebnf, "");
      }
    }
    _builder.append(")*");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _ebnf2(final Assignment it, final AntlrOptions options, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    _builder.newLine();
    _builder.append("\t");
    AbstractElement _terminal = it.getTerminal();
    String _assignmentEbnf = this.assignmentEbnf(_terminal, it, options, supportActions);
    _builder.append(_assignmentEbnf, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _ebnf2(final Action it, final AntlrOptions options, final boolean supportActions) {
    return "";
  }
  
  protected String _ebnf2(final Keyword it, final AntlrOptions options, final boolean supportActions) {
    String _value = it.getValue();
    String _antlrString = AntlrGrammarGenUtil.toAntlrString(_value);
    String _plus = ("\'" + _antlrString);
    return (_plus + "\'");
  }
  
  protected String _ebnf2(final RuleCall it, final AntlrOptions options, final boolean supportActions) {
    AbstractRule _rule = it.getRule();
    return this._grammarAccessExtensions.ruleName(_rule);
  }
  
  protected String _ebnf2(final EnumLiteralDeclaration it, final AntlrOptions options, final boolean supportActions) {
    Keyword _literal = it.getLiteral();
    String _value = _literal.getValue();
    String _antlrString = AntlrGrammarGenUtil.toAntlrString(_value);
    String _plus = ("\'" + _antlrString);
    return (_plus + "\'");
  }
  
  protected String _crossrefEbnf(final AbstractElement it, final CrossReference ref, final boolean supportActions) {
    throw new IllegalStateException(("crossrefEbnf is not supported for " + it));
  }
  
  protected String _crossrefEbnf(final Alternatives it, final CrossReference ref, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<AbstractElement> _elements = it.getElements();
      boolean _hasElements = false;
      for(final AbstractElement element : _elements) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n    |", "");
        }
        String _crossrefEbnf = this.crossrefEbnf(element, ref, supportActions);
        _builder.append(_crossrefEbnf, "");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _crossrefEbnf(final RuleCall it, final CrossReference ref, final boolean supportActions) {
    String _xblockexpression = null;
    {
      final AbstractRule rule = it.getRule();
      if ((rule instanceof ParserRule)) {
        ParserRule _originalElement = AntlrGrammarGenUtil.<ParserRule>getOriginalElement(((ParserRule)rule));
        boolean _isDatatypeRule = GrammarUtil.isDatatypeRule(_originalElement);
        boolean _not = (!_isDatatypeRule);
        if (_not) {
          throw new IllegalStateException("crossrefEbnf is not supported for ParserRule that is not a datatype rule");
        }
      }
      _xblockexpression = this.crossrefEbnf(rule, it, ref, supportActions);
    }
    return _xblockexpression;
  }
  
  protected String crossrefEbnf(final AbstractRule it, final RuleCall call, final CrossReference ref, final boolean supportActions) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof EnumRule) {
        _matched=true;
      }
      if (!_matched) {
        if (it instanceof ParserRule) {
          _matched=true;
        }
      }
      if (!_matched) {
        if (it instanceof TerminalRule) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = this._grammarAccessExtensions.ruleName(it);
      }
    }
    if (!_matched) {
      throw new IllegalStateException(("crossrefEbnf is not supported for " + it));
    }
    return _switchResult;
  }
  
  protected String _assignmentEbnf(final Group it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    throw new IllegalStateException(("assignmentEbnf is not supported for " + it));
  }
  
  protected String _assignmentEbnf(final Assignment it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    throw new IllegalStateException(("assignmentEbnf is not supported for " + it));
  }
  
  protected String _assignmentEbnf(final Action it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    throw new IllegalStateException(("assignmentEbnf is not supported for " + it));
  }
  
  protected String _assignmentEbnf(final Alternatives it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    _builder.newLine();
    _builder.append("\t");
    {
      EList<AbstractElement> _elements = it.getElements();
      boolean _hasElements = false;
      for(final AbstractElement element : _elements) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n    |", "\t");
        }
        String _assignmentEbnf = this.assignmentEbnf(element, assignment, options, supportActions);
        _builder.append(_assignmentEbnf, "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _assignmentEbnf(final RuleCall it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    String _switchResult = null;
    AbstractRule _rule = it.getRule();
    final AbstractRule rule = _rule;
    boolean _matched = false;
    if (!_matched) {
      if (rule instanceof EnumRule) {
        _matched=true;
      }
      if (!_matched) {
        if (rule instanceof ParserRule) {
          _matched=true;
        }
      }
      if (!_matched) {
        if (rule instanceof TerminalRule) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = this._grammarAccessExtensions.ruleName(rule);
      }
    }
    if (!_matched) {
      throw new IllegalStateException(("assignmentEbnf is not supported for " + rule));
    }
    return _switchResult;
  }
  
  protected String _assignmentEbnf(final CrossReference it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    AbstractElement _terminal = it.getTerminal();
    return this.crossrefEbnf(_terminal, it, supportActions);
  }
  
  protected String _assignmentEbnf(final AbstractElement it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    return this.ebnf(it, options, supportActions);
  }
  
  protected String dataTypeEbnf2(final AbstractElement it, final boolean supportActions) {
    if (it instanceof Alternatives) {
      return _dataTypeEbnf2((Alternatives)it, supportActions);
    } else if (it instanceof Group) {
      return _dataTypeEbnf2((Group)it, supportActions);
    } else if (it instanceof UnorderedGroup) {
      return _dataTypeEbnf2((UnorderedGroup)it, supportActions);
    } else if (it instanceof Keyword) {
      return _dataTypeEbnf2((Keyword)it, supportActions);
    } else if (it instanceof RuleCall) {
      return _dataTypeEbnf2((RuleCall)it, supportActions);
    } else if (it != null) {
      return _dataTypeEbnf2(it, supportActions);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, supportActions).toString());
    }
  }
  
  protected String ebnf2(final AbstractElement it, final AntlrOptions options, final boolean supportActions) {
    if (it instanceof Alternatives) {
      return _ebnf2((Alternatives)it, options, supportActions);
    } else if (it instanceof Group) {
      return _ebnf2((Group)it, options, supportActions);
    } else if (it instanceof UnorderedGroup) {
      return _ebnf2((UnorderedGroup)it, options, supportActions);
    } else if (it instanceof Action) {
      return _ebnf2((Action)it, options, supportActions);
    } else if (it instanceof Assignment) {
      return _ebnf2((Assignment)it, options, supportActions);
    } else if (it instanceof EnumLiteralDeclaration) {
      return _ebnf2((EnumLiteralDeclaration)it, options, supportActions);
    } else if (it instanceof Keyword) {
      return _ebnf2((Keyword)it, options, supportActions);
    } else if (it instanceof RuleCall) {
      return _ebnf2((RuleCall)it, options, supportActions);
    } else if (it != null) {
      return _ebnf2(it, options, supportActions);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, options, supportActions).toString());
    }
  }
  
  protected String crossrefEbnf(final AbstractElement it, final CrossReference ref, final boolean supportActions) {
    if (it instanceof Alternatives) {
      return _crossrefEbnf((Alternatives)it, ref, supportActions);
    } else if (it instanceof RuleCall) {
      return _crossrefEbnf((RuleCall)it, ref, supportActions);
    } else if (it != null) {
      return _crossrefEbnf(it, ref, supportActions);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, ref, supportActions).toString());
    }
  }
  
  protected String assignmentEbnf(final AbstractElement it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    if (it instanceof Alternatives) {
      return _assignmentEbnf((Alternatives)it, assignment, options, supportActions);
    } else if (it instanceof Group) {
      return _assignmentEbnf((Group)it, assignment, options, supportActions);
    } else if (it instanceof Action) {
      return _assignmentEbnf((Action)it, assignment, options, supportActions);
    } else if (it instanceof Assignment) {
      return _assignmentEbnf((Assignment)it, assignment, options, supportActions);
    } else if (it instanceof CrossReference) {
      return _assignmentEbnf((CrossReference)it, assignment, options, supportActions);
    } else if (it instanceof RuleCall) {
      return _assignmentEbnf((RuleCall)it, assignment, options, supportActions);
    } else if (it != null) {
      return _assignmentEbnf(it, assignment, options, supportActions);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, assignment, options, supportActions).toString());
    }
  }
}
