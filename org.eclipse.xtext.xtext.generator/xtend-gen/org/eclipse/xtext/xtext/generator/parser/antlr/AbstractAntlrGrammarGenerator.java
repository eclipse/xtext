/**
 * Copyright (c) 2015, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xtext.FlattenedGrammarAccess;
import org.eclipse.xtext.xtext.RuleFilter;
import org.eclipse.xtext.xtext.RuleNames;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.util.SyntheticTerminalDetector;

@SuppressWarnings("all")
public abstract class AbstractAntlrGrammarGenerator {
  @Inject
  @Extension
  protected XtextGeneratorNaming _xtextGeneratorNaming;

  @Inject
  @Extension
  protected GrammarAccessExtensions _grammarAccessExtensions;

  @Inject
  @Extension
  protected SyntheticTerminalDetector _syntheticTerminalDetector;

  @Inject
  private CodeConfig codeConfig;

  protected KeywordHelper keywordHelper;

  private Grammar originalGrammar;

  public void generate(final Grammar it, final AntlrOptions options, final IXtextGeneratorFileSystemAccess fsa) {
    this.keywordHelper = KeywordHelper.getHelper(it);
    this.originalGrammar = it;
    final RuleFilter filter = new RuleFilter();
    filter.setDiscardUnreachableRules(options.isSkipUnusedRules());
    final RuleNames ruleNames = RuleNames.getRuleNames(it, true);
    final Grammar flattened = new FlattenedGrammarAccess(ruleNames, filter).getFlattenedGrammar();
    boolean _isCombinedGrammar = this.isCombinedGrammar();
    new CombinedGrammarMarker(_isCombinedGrammar).attachToEmfObject(flattened);
    fsa.generateFile(this.getGrammarNaming().getParserGrammar(it).getGrammarFileName(), this.compileParser(flattened, options));
    boolean _isCombinedGrammar_1 = this.isCombinedGrammar();
    boolean _not = (!_isCombinedGrammar_1);
    if (_not) {
      fsa.generateFile(this.getGrammarNaming().getLexerGrammar(it).getGrammarFileName(), this.compileLexer(flattened, options));
    }
  }

  protected boolean isCombinedGrammar() {
    return this.getGrammarNaming().isCombinedGrammar(this.originalGrammar);
  }

  protected abstract GrammarNaming getGrammarNaming();

  protected CharSequence compileParser(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    String _fileHeader = this.codeConfig.getFileHeader();
    _builder.append(_fileHeader);
    _builder.newLineIfNotEmpty();
    {
      boolean _isCombinedGrammar = this.isCombinedGrammar();
      boolean _not = (!_isCombinedGrammar);
      if (_not) {
        _builder.append("parser ");
      }
    }
    _builder.append("grammar ");
    String _simpleName = this.getGrammarNaming().getParserGrammar(it).getSimpleName();
    _builder.append(_simpleName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    CharSequence _compileParserOptions = this.compileParserOptions(it, options);
    _builder.append(_compileParserOptions);
    _builder.newLineIfNotEmpty();
    {
      boolean _isCombinedGrammar_1 = this.isCombinedGrammar();
      if (_isCombinedGrammar_1) {
        CharSequence _compileTokens = this.compileTokens(it, options);
        _builder.append(_compileTokens);
        _builder.newLineIfNotEmpty();
        CharSequence _compileLexerHeader = this.compileLexerHeader(it, options);
        _builder.append(_compileLexerHeader);
        _builder.newLineIfNotEmpty();
      }
    }
    CharSequence _compileParserHeader = this.compileParserHeader(it, options);
    _builder.append(_compileParserHeader);
    _builder.newLineIfNotEmpty();
    String _compileParserMembers = this.compileParserMembers(it, options);
    _builder.append(_compileParserMembers);
    _builder.newLineIfNotEmpty();
    String _compileRuleCatch = this.compileRuleCatch(it, options);
    _builder.append(_compileRuleCatch);
    _builder.newLineIfNotEmpty();
    CharSequence _compileRules = this.compileRules(it, options);
    _builder.append(_compileRules);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected CharSequence compileLexer(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    String _fileHeader = this.codeConfig.getFileHeader();
    _builder.append(_fileHeader);
    _builder.newLineIfNotEmpty();
    _builder.append("lexer grammar ");
    String _simpleName = this.getGrammarNaming().getLexerGrammar(it).getSimpleName();
    _builder.append(_simpleName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    CharSequence _compileLexerOptions = this.compileLexerOptions(it, options);
    _builder.append(_compileLexerOptions);
    _builder.newLineIfNotEmpty();
    CharSequence _compileTokens = this.compileTokens(it, options);
    _builder.append(_compileTokens);
    _builder.newLineIfNotEmpty();
    CharSequence _compileLexerHeader = this.compileLexerHeader(it, options);
    _builder.append(_compileLexerHeader);
    _builder.newLineIfNotEmpty();
    CharSequence _compileKeywordRules = this.compileKeywordRules(it, options);
    _builder.append(_compileKeywordRules);
    _builder.newLineIfNotEmpty();
    CharSequence _compileTerminalRules = this.compileTerminalRules(it, options);
    _builder.append(_compileTerminalRules);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected CharSequence compileParserOptions(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("options {");
    _builder.newLine();
    {
      boolean _isCombinedGrammar = this.isCombinedGrammar();
      boolean _not = (!_isCombinedGrammar);
      if (_not) {
        _builder.append("\t");
        _builder.append("tokenVocab=");
        String _simpleName = this.getGrammarNaming().getLexerGrammar(it).getSimpleName();
        _builder.append(_simpleName, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      TypeReference _internalParserSuperClass = this.getGrammarNaming().getInternalParserSuperClass(it);
      boolean _tripleNotEquals = (_internalParserSuperClass != null);
      if (_tripleNotEquals) {
        _builder.append("\t");
        _builder.append("superClass=");
        String _simpleName_1 = this.getGrammarNaming().getInternalParserSuperClass(it).getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if (((this.isParserBackTracking(it, options) || options.isMemoize()) || (options.getK() >= 0))) {
        {
          boolean _isParserBackTracking = this.isParserBackTracking(it, options);
          if (_isParserBackTracking) {
            _builder.append("\t");
            _builder.append("backtrack=true;");
            _builder.newLine();
          }
        }
        {
          boolean _isMemoize = options.isMemoize();
          if (_isMemoize) {
            _builder.append("\t");
            _builder.append("memoize=true;");
            _builder.newLine();
          }
        }
        {
          int _k = options.getK();
          boolean _greaterEqualsThan = (_k >= 0);
          if (_greaterEqualsThan) {
            _builder.append("\t");
            _builder.append("k=");
            int _k_1 = options.getK();
            _builder.append(_k_1, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  protected boolean isParserBackTracking(final Grammar it, final AntlrOptions options) {
    return options.isBacktrack();
  }

  protected CharSequence compileLexerOptions(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isBacktrackLexer = options.isBacktrackLexer();
      if (_isBacktrackLexer) {
        _builder.newLine();
        _builder.append("options {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("backtrack=true;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("memoize=true;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }

  protected CharSequence compileTokens(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isBacktrackLexer = options.isBacktrackLexer();
      if (_isBacktrackLexer) {
        _builder.append("tokens {");
        _builder.newLine();
        {
          Set<String> _allKeywords = this.keywordHelper.getAllKeywords();
          for(final String kw : _allKeywords) {
            _builder.append("\t");
            String _ruleName = this.keywordHelper.getRuleName(kw);
            _builder.append(_ruleName, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(it);
          for(final TerminalRule rule : _allTerminalRules) {
            _builder.append("\t");
            String _ruleName_1 = this._grammarAccessExtensions.ruleName(rule);
            _builder.append(_ruleName_1, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }

  protected CharSequence compileLexerHeader(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("@");
    {
      boolean _isCombinedGrammar = this.isCombinedGrammar();
      if (_isCombinedGrammar) {
        _builder.append("lexer::");
      }
    }
    _builder.append("header {");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _packageName = this.getGrammarNaming().getLexerGrammar(it).getPackageName();
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    CharSequence _compileLexerImports = this.compileLexerImports(it, options);
    _builder.append(_compileLexerImports);
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
    _builder.append("import ");
    TypeReference _lexerSuperClass = this.getGrammarNaming().getLexerSuperClass(it);
    _builder.append(_lexerSuperClass);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected CharSequence compileParserHeader(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("@");
    {
      boolean _isCombinedGrammar = this.isCombinedGrammar();
      if (_isCombinedGrammar) {
        _builder.append("parser::");
      }
    }
    _builder.append("header {");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _packageName = this.getGrammarNaming().getParserGrammar(it).getPackageName();
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    String _compileParserImports = this.compileParserImports(it, options);
    _builder.append(_compileParserImports);
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
      List<EnumRule> _allEnumRules = GrammarUtil.allEnumRules(it);
      final Function1<AbstractRule, Boolean> _function = (AbstractRule rule) -> {
        return Boolean.valueOf(this._grammarAccessExtensions.isCalled(rule, it));
      };
      Iterable<AbstractRule> _filter = IterableExtensions.<AbstractRule>filter(Iterables.<AbstractRule>concat(_allParserRules, _allEnumRules), _function);
      for(final AbstractRule rule : _filter) {
        _builder.newLine();
        CharSequence _compileRule = this.compileRule(rule, it, options);
        _builder.append(_compileRule);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _isCombinedGrammar = this.isCombinedGrammar();
      if (_isCombinedGrammar) {
        CharSequence _compileTerminalRules = this.compileTerminalRules(it, options);
        _builder.append(_compileTerminalRules);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  protected CharSequence compileKeywordRules(final Grammar it, final AntlrOptions options) {
    CharSequence _xblockexpression = null;
    {
      final Set<String> allKeywords = this.keywordHelper.getAllKeywords();
      final List<TerminalRule> allTerminalRules = GrammarUtil.allTerminalRules(it);
      final ArrayList<String> synthetic_kw_alternatives = CollectionLiterals.<String>newArrayList();
      final Function1<Pair<Integer, String>, String> _function = (Pair<Integer, String> it_1) -> {
        final String ruleName = this.keywordHelper.getRuleName(it_1.getValue());
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(FRAGMENT_");
        _builder.append(ruleName);
        _builder.append(")=> FRAGMENT_");
        _builder.append(ruleName);
        _builder.append(" {$type = ");
        _builder.append(ruleName);
        _builder.append("; }");
        return _builder.toString();
      };
      Iterables.<String>addAll(synthetic_kw_alternatives, 
        IterableExtensions.<Pair<Integer, String>, String>map(IterableExtensions.<String>indexed(allKeywords), _function));
      final Function1<Pair<Integer, TerminalRule>, String> _function_1 = (Pair<Integer, TerminalRule> it_1) -> {
        if (((!this._syntheticTerminalDetector.isSyntheticTerminalRule(it_1.getValue())) && (!it_1.getValue().isFragment()))) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("(FRAGMENT_");
          String _ruleName = this._grammarAccessExtensions.ruleName(it_1.getValue());
          _builder.append(_ruleName);
          _builder.append(")=> FRAGMENT_");
          String _ruleName_1 = this._grammarAccessExtensions.ruleName(it_1.getValue());
          _builder.append(_ruleName_1);
          _builder.append(" {$type = ");
          String _ruleName_2 = this._grammarAccessExtensions.ruleName(it_1.getValue());
          _builder.append(_ruleName_2);
          _builder.append("; }");
          return _builder.toString();
        }
        return null;
      };
      synthetic_kw_alternatives.addAll(
        IterableExtensions.<String>toList(IterableExtensions.<String>filterNull(IterableExtensions.<Pair<Integer, TerminalRule>, String>map(IterableExtensions.<TerminalRule>indexed(allTerminalRules), _function_1))));
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isBacktrackLexer = options.isBacktrackLexer();
        if (_isBacktrackLexer) {
          _builder.append("SYNTHETIC_ALL_KEYWORDS :");
          _builder.newLine();
          {
            boolean _hasElements = false;
            for(final String kw : synthetic_kw_alternatives) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(" |", "\t");
              }
              _builder.append("\t");
              _builder.append(kw, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append(";");
          _builder.newLine();
          _builder.newLine();
          {
            for(final String kw_1 : allKeywords) {
              _builder.append("fragment FRAGMENT_");
              String _ruleName = this.keywordHelper.getRuleName(kw_1);
              _builder.append(_ruleName);
              _builder.append(" : \'");
              String _antlrString = AntlrGrammarGenUtil.toAntlrString(kw_1);
              _builder.append(_antlrString);
              _builder.append("\';");
              _builder.newLineIfNotEmpty();
              _builder.newLine();
            }
          }
        } else {
          {
            for(final String rule : allKeywords) {
              _builder.newLine();
              CharSequence _compileRule = this.compileRule(rule, it, options);
              _builder.append(_compileRule);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }

  protected CharSequence compileTerminalRules(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isBacktrackLexer = options.isBacktrackLexer();
      if (_isBacktrackLexer) {
        _builder.newLine();
        _builder.append("// Rules duplicated to allow inter-rule references");
        _builder.newLine();
      }
    }
    {
      List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(it);
      for(final TerminalRule rule : _allTerminalRules) {
        _builder.newLine();
        CharSequence _compileRule = this.compileRule(rule, it, options);
        _builder.append(_compileRule);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  protected CharSequence _compileRule(final EnumRule it, final Grammar grammar, final AntlrOptions options) {
    return this.compileEBNF(it, options);
  }

  protected CharSequence _compileRule(final ParserRule it, final Grammar grammar, final AntlrOptions options) {
    return this.compileEBNF(it, options);
  }

  protected CharSequence _compileRule(final TerminalRule it, final Grammar grammar, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isBacktrackLexer = options.isBacktrackLexer();
      if (_isBacktrackLexer) {
        {
          boolean _isSyntheticTerminalRule = this._syntheticTerminalDetector.isSyntheticTerminalRule(it);
          boolean _not = (!_isSyntheticTerminalRule);
          if (_not) {
            {
              boolean _isFragment = it.isFragment();
              if (_isFragment) {
                _builder.append("fragment ");
                String _ruleName = this._grammarAccessExtensions.ruleName(it);
                _builder.append(_ruleName);
                _builder.append(" : ");
                String _lexerBody = TerminalRuleToLexerBody.toLexerBody(it);
                _builder.append(_lexerBody);
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("fragment ");
                String _ruleName_1 = this._grammarAccessExtensions.ruleName(it);
                _builder.append(_ruleName_1);
                _builder.append(" : FRAGMENT_");
                String _ruleName_2 = this._grammarAccessExtensions.ruleName(it);
                _builder.append(_ruleName_2);
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("fragment FRAGMENT_");
                String _ruleName_3 = this._grammarAccessExtensions.ruleName(it);
                _builder.append(_ruleName_3);
                _builder.append(" : ");
                String _lexerBody_1 = TerminalRuleToLexerBody.toLexerBody(it);
                _builder.append(_lexerBody_1);
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      } else {
        {
          boolean _isSyntheticTerminalRule_1 = this._syntheticTerminalDetector.isSyntheticTerminalRule(it);
          if (_isSyntheticTerminalRule_1) {
            _builder.append("fragment ");
            String _ruleName_4 = this._grammarAccessExtensions.ruleName(it);
            _builder.append(_ruleName_4);
            _builder.append(" : ;");
            _builder.newLineIfNotEmpty();
          } else {
            {
              boolean _isFragment_1 = it.isFragment();
              if (_isFragment_1) {
                _builder.append("fragment ");
              }
            }
            String _ruleName_5 = this._grammarAccessExtensions.ruleName(it);
            _builder.append(_ruleName_5);
            _builder.append(" : ");
            String _lexerBody_2 = TerminalRuleToLexerBody.toLexerBody(it);
            _builder.append(_lexerBody_2);
            {
              boolean _shouldBeSkipped = this.shouldBeSkipped(it, grammar);
              if (_shouldBeSkipped) {
                _builder.append(" {skip();}");
              }
            }
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }

  protected CharSequence _compileRule(final String keyword, final Grammar grammar, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    String _ruleName = this.keywordHelper.getRuleName(keyword);
    _builder.append(_ruleName);
    _builder.append(" : ");
    String _antlrKeywordRule = this.toAntlrKeywordRule(keyword, options);
    _builder.append(_antlrKeywordRule);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected String toAntlrKeywordRule(final String keyword, final AntlrOptions options) {
    boolean _isIgnoreCase = options.isIgnoreCase();
    if (_isIgnoreCase) {
      return AntlrGrammarGenUtil.toAntlrStringIgnoreCase(keyword);
    } else {
      String _antlrString = AntlrGrammarGenUtil.toAntlrString(keyword);
      String _plus = ("\'" + _antlrString);
      return (_plus + "\'");
    }
  }

  protected boolean shouldBeSkipped(final TerminalRule it, final Grammar grammar) {
    return (this._grammarAccessExtensions.initialHiddenTokens(grammar).contains(this._grammarAccessExtensions.ruleName(it)) && this.isCombinedGrammar());
  }

  protected String compileEBNF(final AbstractRule it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// Rule ");
    String _name = AntlrGrammarGenUtil.<AbstractRule>getOriginalElement(it).getName();
    _builder.append(_name);
    _builder.newLineIfNotEmpty();
    String _ruleName = this._grammarAccessExtensions.ruleName(it);
    _builder.append(_ruleName);
    String _compileInit = this.compileInit(it, options);
    _builder.append(_compileInit);
    _builder.append(":");
    _builder.newLineIfNotEmpty();
    {
      if (((it instanceof ParserRule) && GrammarUtil.isDatatypeRule(AntlrGrammarGenUtil.<AbstractRule>getOriginalElement(it)))) {
        _builder.append("\t");
        String _dataTypeEbnf = this.dataTypeEbnf(it.getAlternatives(), true);
        _builder.append(_dataTypeEbnf, "\t");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t");
        String _ebnf = this.ebnf(it.getAlternatives(), options, true);
        _builder.append(_ebnf, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(";");
    _builder.newLine();
    String _compileFinally = this.compileFinally(it, options);
    _builder.append(_compileFinally);
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
      boolean _mustBeParenthesized = this.mustBeParenthesized(it);
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
        _builder.append(_ebnf2_1);
      }
    }
    String _cardinality = it.getCardinality();
    _builder.append(_cardinality);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  protected String ebnfPredicate(final AbstractElement it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((this._grammarAccessExtensions.predicated(it) || it.isFirstSetPredicated())) {
        _builder.append("(");
        {
          boolean _predicated = this._grammarAccessExtensions.predicated(it);
          if (_predicated) {
            String _ebnf2 = this.ebnf2(this._grammarAccessExtensions.predicatedElement(it), options, false);
            _builder.append(_ebnf2);
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
                _builder.append(_ebnf2_1);
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
      boolean _mustBeParenthesized = this.mustBeParenthesized(it);
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
        _builder.append(_dataTypeEbnf2_1);
      }
    }
    String _cardinality = it.getCardinality();
    _builder.append(_cardinality);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  protected String dataTypeEbnfPredicate(final AbstractElement it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((this._grammarAccessExtensions.predicated(it) || it.isFirstSetPredicated())) {
        _builder.append("(");
        {
          boolean _predicated = this._grammarAccessExtensions.predicated(it);
          if (_predicated) {
            String _dataTypeEbnf2 = this.dataTypeEbnf2(this._grammarAccessExtensions.predicatedElement(it), false);
            _builder.append(_dataTypeEbnf2);
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
                _builder.append(_dataTypeEbnf2_1);
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
    String _name = it.eClass().getName();
    _builder.append(_name);
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
        _builder.append(_dataTypeEbnf);
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
        _builder.append(_dataTypeEbnf);
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
        _builder.append(_dataTypeEbnf2);
      }
    }
    _builder.append(")*");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  protected String _dataTypeEbnf2(final Keyword it, final boolean supportActions) {
    return this.ebnf(it);
  }

  protected String _dataTypeEbnf2(final RuleCall it, final boolean supportActions) {
    return this._grammarAccessExtensions.ruleName(it.getRule());
  }

  protected String _ebnf2(final AbstractElement it, final AntlrOptions options, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ERROR ");
    String _name = it.eClass().getName();
    _builder.append(_name);
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
        _builder.append(_ebnf);
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
        _builder.append(_ebnf);
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
        _builder.append(_ebnf);
      }
    }
    _builder.append(")*");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  protected String _ebnf2(final Assignment it, final AntlrOptions options, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    String _assignmentEbnf = this.assignmentEbnf(it.getTerminal(), it, options, supportActions);
    _builder.append(_assignmentEbnf);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  protected String _ebnf2(final Action it, final AntlrOptions options, final boolean supportActions) {
    return "";
  }

  protected String ebnf(final Keyword it) {
    String _xifexpression = null;
    boolean _isCombinedGrammar = this.isCombinedGrammar();
    if (_isCombinedGrammar) {
      String _antlrString = AntlrGrammarGenUtil.toAntlrString(it.getValue());
      String _plus = ("\'" + _antlrString);
      _xifexpression = (_plus + "\'");
    } else {
      _xifexpression = this.keywordHelper.getRuleName(it.getValue());
    }
    return _xifexpression;
  }

  protected String _ebnf2(final Keyword it, final AntlrOptions options, final boolean supportActions) {
    return this.ebnf(it);
  }

  protected String _ebnf2(final RuleCall it, final AntlrOptions options, final boolean supportActions) {
    return this._grammarAccessExtensions.ruleName(it.getRule());
  }

  protected String _ebnf2(final EnumLiteralDeclaration it, final AntlrOptions options, final boolean supportActions) {
    String _xifexpression = null;
    boolean _isCombinedGrammar = this.isCombinedGrammar();
    if (_isCombinedGrammar) {
      String _antlrString = AntlrGrammarGenUtil.toAntlrString(it.getLiteral().getValue());
      String _plus = ("\'" + _antlrString);
      _xifexpression = (_plus + "\'");
    } else {
      _xifexpression = this.keywordHelper.getRuleName(it.getLiteral().getValue());
    }
    return _xifexpression;
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
        _builder.append(_crossrefEbnf);
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
        boolean _isDatatypeRule = GrammarUtil.isDatatypeRule(((AbstractRule) _originalElement));
        boolean _not = (!_isDatatypeRule);
        if (_not) {
          throw new IllegalStateException("crossrefEbnf is not supported for ParserRule that is not a datatype rule");
        }
      }
      _xblockexpression = this.crossrefEbnf(rule, it, ref, supportActions);
    }
    return _xblockexpression;
  }

  protected String _crossrefEbnf(final Keyword it, final CrossReference ref, final boolean supportActions) {
    return this.ebnf(it);
  }

  protected String crossrefEbnf(final AbstractRule it, final RuleCall call, final CrossReference ref, final boolean supportActions) {
    String _switchResult = null;
    boolean _matched = false;
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
    {
      EList<AbstractElement> _elements = it.getElements();
      boolean _hasElements = false;
      for(final AbstractElement element : _elements) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n    |", "");
        }
        String _assignmentEbnf = this.assignmentEbnf(element, assignment, options, supportActions);
        _builder.append(_assignmentEbnf);
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  protected String _assignmentEbnf(final RuleCall it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    String _switchResult = null;
    AbstractRule _rule = it.getRule();
    final AbstractRule rule = _rule;
    boolean _matched = false;
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
    if (!_matched) {
      throw new IllegalStateException(("assignmentEbnf is not supported for " + rule));
    }
    return _switchResult;
  }

  protected String _assignmentEbnf(final CrossReference it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    return this.crossrefEbnf(it.getTerminal(), it, supportActions);
  }

  protected String _assignmentEbnf(final AbstractElement it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    return this.ebnf(it, options, supportActions);
  }

  protected boolean _mustBeParenthesized(final AbstractElement it) {
    return (this._grammarAccessExtensions.predicated(it) || it.isFirstSetPredicated());
  }

  protected boolean _mustBeParenthesized(final Group it) {
    return ((this._grammarAccessExtensions.predicated(it) || it.isFirstSetPredicated()) || (it.getCardinality() != null));
  }

  protected boolean _mustBeParenthesized(final Assignment it) {
    return ((this._grammarAccessExtensions.predicated(it) || it.isFirstSetPredicated()) || this.mustBeParenthesized(it.getTerminal()));
  }

  protected boolean _mustBeParenthesized(final Alternatives it) {
    return true;
  }

  protected CharSequence compileRule(final Object it, final Grammar grammar, final AntlrOptions options) {
    if (it instanceof EnumRule) {
      return _compileRule((EnumRule)it, grammar, options);
    } else if (it instanceof ParserRule) {
      return _compileRule((ParserRule)it, grammar, options);
    } else if (it instanceof TerminalRule) {
      return _compileRule((TerminalRule)it, grammar, options);
    } else if (it instanceof String) {
      return _compileRule((String)it, grammar, options);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, grammar, options).toString());
    }
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
    } else if (it instanceof Keyword) {
      return _crossrefEbnf((Keyword)it, ref, supportActions);
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

  public boolean mustBeParenthesized(final AbstractElement it) {
    if (it instanceof Alternatives) {
      return _mustBeParenthesized((Alternatives)it);
    } else if (it instanceof Group) {
      return _mustBeParenthesized((Group)it);
    } else if (it instanceof Assignment) {
      return _mustBeParenthesized((Assignment)it);
    } else if (it != null) {
      return _mustBeParenthesized(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
