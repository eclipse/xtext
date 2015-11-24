/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
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
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammar;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.xtext.generator.parser.antlr.CombinedGrammarMarker;
import org.eclipse.xtext.xtext.generator.parser.antlr.GrammarNaming;
import org.eclipse.xtext.xtext.generator.parser.antlr.KeywordHelper;
import org.eclipse.xtext.xtext.generator.parser.antlr.TerminalRuleToLexerBody;
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
    KeywordHelper _helper = KeywordHelper.getHelper(it);
    this.keywordHelper = _helper;
    this.originalGrammar = it;
    final RuleFilter filter = new RuleFilter();
    boolean _isSkipUnusedRules = options.isSkipUnusedRules();
    filter.setDiscardUnreachableRules(_isSkipUnusedRules);
    final RuleNames ruleNames = RuleNames.getRuleNames(it, true);
    FlattenedGrammarAccess _flattenedGrammarAccess = new FlattenedGrammarAccess(ruleNames, filter);
    final Grammar flattened = _flattenedGrammarAccess.getFlattenedGrammar();
    boolean _isCombinedGrammar = this.isCombinedGrammar();
    CombinedGrammarMarker _combinedGrammarMarker = new CombinedGrammarMarker(_isCombinedGrammar);
    _combinedGrammarMarker.attachToEmfObject(flattened);
    GrammarNaming _grammarNaming = this.getGrammarNaming();
    AntlrGrammar _parserGrammar = _grammarNaming.getParserGrammar(it);
    String _grammarFileName = _parserGrammar.getGrammarFileName();
    CharSequence _compileParser = this.compileParser(flattened, options);
    fsa.generateFile(_grammarFileName, _compileParser);
    boolean _isCombinedGrammar_1 = this.isCombinedGrammar();
    boolean _not = (!_isCombinedGrammar_1);
    if (_not) {
      GrammarNaming _grammarNaming_1 = this.getGrammarNaming();
      AntlrGrammar _lexerGrammar = _grammarNaming_1.getLexerGrammar(it);
      String _grammarFileName_1 = _lexerGrammar.getGrammarFileName();
      CharSequence _compileLexer = this.compileLexer(flattened, options);
      fsa.generateFile(_grammarFileName_1, _compileLexer);
    }
  }
  
  protected boolean isCombinedGrammar() {
    GrammarNaming _grammarNaming = this.getGrammarNaming();
    return _grammarNaming.isCombinedGrammar(this.originalGrammar);
  }
  
  protected abstract GrammarNaming getGrammarNaming();
  
  protected CharSequence compileParser(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    String _fileHeader = this.codeConfig.getFileHeader();
    _builder.append(_fileHeader, "");
    _builder.newLineIfNotEmpty();
    {
      boolean _isCombinedGrammar = this.isCombinedGrammar();
      boolean _not = (!_isCombinedGrammar);
      if (_not) {
        _builder.append("parser ");
      }
    }
    _builder.append("grammar ");
    GrammarNaming _grammarNaming = this.getGrammarNaming();
    AntlrGrammar _parserGrammar = _grammarNaming.getParserGrammar(it);
    String _simpleName = _parserGrammar.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    CharSequence _compileParserOptions = this.compileParserOptions(it, options);
    _builder.append(_compileParserOptions, "");
    _builder.newLineIfNotEmpty();
    {
      boolean _isCombinedGrammar_1 = this.isCombinedGrammar();
      if (_isCombinedGrammar_1) {
        CharSequence _compileTokens = this.compileTokens(it, options);
        _builder.append(_compileTokens, "");
        _builder.newLineIfNotEmpty();
        CharSequence _compileLexerHeader = this.compileLexerHeader(it, options);
        _builder.append(_compileLexerHeader, "");
        _builder.newLineIfNotEmpty();
      }
    }
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
  
  protected CharSequence compileLexer(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    String _fileHeader = this.codeConfig.getFileHeader();
    _builder.append(_fileHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("lexer grammar ");
    GrammarNaming _grammarNaming = this.getGrammarNaming();
    AntlrGrammar _lexerGrammar = _grammarNaming.getLexerGrammar(it);
    String _simpleName = _lexerGrammar.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    CharSequence _compileLexerOptions = this.compileLexerOptions(it, options);
    _builder.append(_compileLexerOptions, "");
    _builder.newLineIfNotEmpty();
    CharSequence _compileTokens = this.compileTokens(it, options);
    _builder.append(_compileTokens, "");
    _builder.newLineIfNotEmpty();
    CharSequence _compileLexerHeader = this.compileLexerHeader(it, options);
    _builder.append(_compileLexerHeader, "");
    _builder.newLineIfNotEmpty();
    CharSequence _compileKeywordRules = this.compileKeywordRules(it, options);
    _builder.append(_compileKeywordRules, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// Rules duplicated to allow inter-rule references");
    _builder.newLine();
    CharSequence _compileTerminalRules = this.compileTerminalRules(it, options);
    _builder.append(_compileTerminalRules, "");
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
        GrammarNaming _grammarNaming = this.getGrammarNaming();
        AntlrGrammar _lexerGrammar = _grammarNaming.getLexerGrammar(it);
        String _simpleName = _lexerGrammar.getSimpleName();
        _builder.append(_simpleName, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      GrammarNaming _grammarNaming_1 = this.getGrammarNaming();
      TypeReference _internalParserSuperClass = _grammarNaming_1.getInternalParserSuperClass(it);
      boolean _notEquals = (!Objects.equal(_internalParserSuperClass, null));
      if (_notEquals) {
        _builder.append("\t");
        _builder.append("superClass=");
        GrammarNaming _grammarNaming_2 = this.getGrammarNaming();
        TypeReference _internalParserSuperClass_1 = _grammarNaming_2.getInternalParserSuperClass(it);
        String _simpleName_1 = _internalParserSuperClass_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _or = false;
      boolean _or_1 = false;
      boolean _isParserBackTracking = this.isParserBackTracking(it, options);
      if (_isParserBackTracking) {
        _or_1 = true;
      } else {
        boolean _isMemoize = options.isMemoize();
        _or_1 = _isMemoize;
      }
      if (_or_1) {
        _or = true;
      } else {
        int _k = options.getK();
        boolean _greaterEqualsThan = (_k >= 0);
        _or = _greaterEqualsThan;
      }
      if (_or) {
        {
          boolean _isParserBackTracking_1 = this.isParserBackTracking(it, options);
          if (_isParserBackTracking_1) {
            _builder.append("\t");
            _builder.append("backtrack=true;");
            _builder.newLine();
          }
        }
        {
          boolean _isMemoize_1 = options.isMemoize();
          if (_isMemoize_1) {
            _builder.append("\t");
            _builder.append("memoize=true;");
            _builder.newLine();
          }
        }
        {
          int _k_1 = options.getK();
          boolean _greaterEqualsThan_1 = (_k_1 >= 0);
          if (_greaterEqualsThan_1) {
            _builder.append("\t");
            _builder.append("memoize=");
            int _k_2 = options.getK();
            _builder.append(_k_2, "\t");
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
          Set<String> _allKeywords = GrammarUtil.getAllKeywords(it);
          List<String> _sort = IterableExtensions.<String>sort(_allKeywords);
          final Function1<String, Integer> _function = new Function1<String, Integer>() {
            @Override
            public Integer apply(final String it) {
              int _length = it.length();
              return Integer.valueOf((-_length));
            }
          };
          List<String> _sortBy = IterableExtensions.<String, Integer>sortBy(_sort, _function);
          for(final String kw : _sortBy) {
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
    GrammarNaming _grammarNaming = this.getGrammarNaming();
    AntlrGrammar _lexerGrammar = _grammarNaming.getLexerGrammar(it);
    String _packageName = _lexerGrammar.getPackageName();
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
    _builder.append("import ");
    GrammarNaming _grammarNaming = this.getGrammarNaming();
    TypeReference _lexerSuperClass = _grammarNaming.getLexerSuperClass(it);
    _builder.append(_lexerSuperClass, "");
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
    GrammarNaming _grammarNaming = this.getGrammarNaming();
    AntlrGrammar _parserGrammar = _grammarNaming.getParserGrammar(it);
    String _packageName = _parserGrammar.getPackageName();
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
      List<EnumRule> _allEnumRules = GrammarUtil.allEnumRules(it);
      Iterable<AbstractRule> _plus = Iterables.<AbstractRule>concat(_allParserRules, _allEnumRules);
      final Function1<AbstractRule, Boolean> _function = new Function1<AbstractRule, Boolean>() {
        @Override
        public Boolean apply(final AbstractRule rule) {
          return Boolean.valueOf(AbstractAntlrGrammarGenerator.this._grammarAccessExtensions.isCalled(rule, it));
        }
      };
      Iterable<AbstractRule> _filter = IterableExtensions.<AbstractRule>filter(_plus, _function);
      for(final AbstractRule rule : _filter) {
        _builder.newLine();
        CharSequence _compileRule = this.compileRule(rule, it, options);
        _builder.append(_compileRule, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _isCombinedGrammar = this.isCombinedGrammar();
      if (_isCombinedGrammar) {
        CharSequence _compileTerminalRules = this.compileTerminalRules(it, options);
        _builder.append(_compileTerminalRules, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence compileKeywordRules(final Grammar it, final AntlrOptions options) {
    CharSequence _xblockexpression = null;
    {
      Set<String> _allKeywords = GrammarUtil.getAllKeywords(it);
      List<String> _sort = IterableExtensions.<String>sort(_allKeywords);
      final Function1<String, Integer> _function = new Function1<String, Integer>() {
        @Override
        public Integer apply(final String it) {
          int _length = it.length();
          return Integer.valueOf((-_length));
        }
      };
      final List<String> allKeywords = IterableExtensions.<String, Integer>sortBy(_sort, _function);
      final List<TerminalRule> allTerminalRules = GrammarUtil.allTerminalRules(it);
      final ArrayList<String> synthetic_kw_alternatives = CollectionLiterals.<String>newArrayList();
      Iterable<Pair<Integer, String>> _indexed = IterableExtensions.<String>indexed(allKeywords);
      final Function1<Pair<Integer, String>, String> _function_1 = new Function1<Pair<Integer, String>, String>() {
        @Override
        public String apply(final Pair<Integer, String> it) {
          String _value = it.getValue();
          final String ruleName = AbstractAntlrGrammarGenerator.this.keywordHelper.getRuleName(_value);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("(FRAGMENT_");
          _builder.append(ruleName, "");
          _builder.append(")=> FRAGMENT_");
          _builder.append(ruleName, "");
          _builder.append(" {$type = ");
          _builder.append(ruleName, "");
          _builder.append("; }");
          return _builder.toString();
        }
      };
      Iterable<String> _map = IterableExtensions.<Pair<Integer, String>, String>map(_indexed, _function_1);
      Iterables.<String>addAll(synthetic_kw_alternatives, _map);
      Iterable<Pair<Integer, TerminalRule>> _indexed_1 = IterableExtensions.<TerminalRule>indexed(allTerminalRules);
      final Function1<Pair<Integer, TerminalRule>, String> _function_2 = new Function1<Pair<Integer, TerminalRule>, String>() {
        @Override
        public String apply(final Pair<Integer, TerminalRule> it) {
          boolean _and = false;
          TerminalRule _value = it.getValue();
          boolean _isSyntheticTerminalRule = AbstractAntlrGrammarGenerator.this._syntheticTerminalDetector.isSyntheticTerminalRule(_value);
          boolean _not = (!_isSyntheticTerminalRule);
          if (!_not) {
            _and = false;
          } else {
            TerminalRule _value_1 = it.getValue();
            boolean _isFragment = _value_1.isFragment();
            boolean _not_1 = (!_isFragment);
            _and = _not_1;
          }
          if (_and) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("(FRAGMENT_");
            TerminalRule _value_2 = it.getValue();
            String _ruleName = AbstractAntlrGrammarGenerator.this._grammarAccessExtensions.ruleName(_value_2);
            _builder.append(_ruleName, "");
            _builder.append(")=> FRAGMENT_");
            TerminalRule _value_3 = it.getValue();
            String _ruleName_1 = AbstractAntlrGrammarGenerator.this._grammarAccessExtensions.ruleName(_value_3);
            _builder.append(_ruleName_1, "");
            _builder.append(" {$type = ");
            TerminalRule _value_4 = it.getValue();
            String _ruleName_2 = AbstractAntlrGrammarGenerator.this._grammarAccessExtensions.ruleName(_value_4);
            _builder.append(_ruleName_2, "");
            _builder.append("; }");
            return _builder.toString();
          }
          return null;
        }
      };
      Iterable<String> _map_1 = IterableExtensions.<Pair<Integer, TerminalRule>, String>map(_indexed_1, _function_2);
      Iterable<String> _filterNull = IterableExtensions.<String>filterNull(_map_1);
      List<String> _list = IterableExtensions.<String>toList(_filterNull);
      synthetic_kw_alternatives.addAll(_list);
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
              _builder.append(_ruleName, "");
              _builder.append(" : \'");
              String _antlrString = AntlrGrammarGenUtil.toAntlrString(kw_1);
              _builder.append(_antlrString, "");
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
              _builder.append(_compileRule, "");
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
      List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(it);
      for(final TerminalRule rule : _allTerminalRules) {
        _builder.newLine();
        CharSequence _compileRule = this.compileRule(rule, it, options);
        _builder.append(_compileRule, "");
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
                _builder.append(_ruleName, "");
                _builder.append(" : ");
                String _lexerBody = TerminalRuleToLexerBody.toLexerBody(it);
                _builder.append(_lexerBody, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("fragment ");
                String _ruleName_1 = this._grammarAccessExtensions.ruleName(it);
                _builder.append(_ruleName_1, "");
                _builder.append(" : FRAGMENT_");
                String _ruleName_2 = this._grammarAccessExtensions.ruleName(it);
                _builder.append(_ruleName_2, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("fragment FRAGMENT_");
                String _ruleName_3 = this._grammarAccessExtensions.ruleName(it);
                _builder.append(_ruleName_3, "");
                _builder.append(" : ");
                String _lexerBody_1 = TerminalRuleToLexerBody.toLexerBody(it);
                _builder.append(_lexerBody_1, "");
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
            _builder.append(_ruleName_4, "");
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
            _builder.append(_ruleName_5, "");
            _builder.append(" : ");
            String _lexerBody_2 = TerminalRuleToLexerBody.toLexerBody(it);
            _builder.append(_lexerBody_2, "");
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
    _builder.append(_ruleName, "");
    _builder.append(" : ");
    String _antlrKeywordRule = this.toAntlrKeywordRule(keyword, options);
    _builder.append(_antlrKeywordRule, "");
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
    boolean _and = false;
    List<String> _initialHiddenTokens = this._grammarAccessExtensions.initialHiddenTokens(grammar);
    String _ruleName = this._grammarAccessExtensions.ruleName(it);
    boolean _contains = _initialHiddenTokens.contains(_ruleName);
    if (!_contains) {
      _and = false;
    } else {
      boolean _isCombinedGrammar = this.isCombinedGrammar();
      _and = _isCombinedGrammar;
    }
    return _and;
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
    String _xifexpression = null;
    boolean _isCombinedGrammar = this.isCombinedGrammar();
    if (_isCombinedGrammar) {
      String _value = it.getValue();
      String _antlrString = AntlrGrammarGenUtil.toAntlrString(_value);
      String _plus = ("\'" + _antlrString);
      _xifexpression = (_plus + "\'");
    } else {
      String _value_1 = it.getValue();
      _xifexpression = this.keywordHelper.getRuleName(_value_1);
    }
    return _xifexpression;
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
    AbstractElement _terminal = it.getTerminal();
    String _assignmentEbnf = this.assignmentEbnf(_terminal, it, options, supportActions);
    _builder.append(_assignmentEbnf, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _ebnf2(final Action it, final AntlrOptions options, final boolean supportActions) {
    return "";
  }
  
  protected String _ebnf2(final Keyword it, final AntlrOptions options, final boolean supportActions) {
    String _xifexpression = null;
    boolean _isCombinedGrammar = this.isCombinedGrammar();
    if (_isCombinedGrammar) {
      String _value = it.getValue();
      String _antlrString = AntlrGrammarGenUtil.toAntlrString(_value);
      String _plus = ("\'" + _antlrString);
      _xifexpression = (_plus + "\'");
    } else {
      String _value_1 = it.getValue();
      _xifexpression = this.keywordHelper.getRuleName(_value_1);
    }
    return _xifexpression;
  }
  
  protected String _ebnf2(final RuleCall it, final AntlrOptions options, final boolean supportActions) {
    AbstractRule _rule = it.getRule();
    return this._grammarAccessExtensions.ruleName(_rule);
  }
  
  protected String _ebnf2(final EnumLiteralDeclaration it, final AntlrOptions options, final boolean supportActions) {
    String _xifexpression = null;
    boolean _isCombinedGrammar = this.isCombinedGrammar();
    if (_isCombinedGrammar) {
      Keyword _literal = it.getLiteral();
      String _value = _literal.getValue();
      String _antlrString = AntlrGrammarGenUtil.toAntlrString(_value);
      String _plus = ("\'" + _antlrString);
      _xifexpression = (_plus + "\'");
    } else {
      Keyword _literal_1 = it.getLiteral();
      String _value_1 = _literal_1.getValue();
      _xifexpression = this.keywordHelper.getRuleName(_value_1);
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
        _builder.append(_assignmentEbnf, "");
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
  
  protected boolean _mustBeParenthesized(final AbstractElement it) {
    boolean _or = false;
    boolean _predicated = this._grammarAccessExtensions.predicated(it);
    if (_predicated) {
      _or = true;
    } else {
      boolean _isFirstSetPredicated = it.isFirstSetPredicated();
      _or = _isFirstSetPredicated;
    }
    return _or;
  }
  
  protected boolean _mustBeParenthesized(final Group it) {
    boolean _or = false;
    boolean _or_1 = false;
    boolean _predicated = this._grammarAccessExtensions.predicated(it);
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
    } else if (it != null) {
      return _mustBeParenthesized(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
