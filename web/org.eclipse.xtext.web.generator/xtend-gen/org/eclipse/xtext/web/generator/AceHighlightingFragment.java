/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import java.io.File;
import java.io.FileWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.generator.LanguageConfig;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * This implementation is outdated and will be removed before the Xtext 2.9.0 release.
 * 
 * @deprecated Use org.eclipse.xtext.xtext.generator.web.WebIntegrationFragment
 */
@Deprecated
@SuppressWarnings("all")
public class AceHighlightingFragment extends Xtend2GeneratorFragment {
  private final static String TERMINALS = "org.eclipse.xtext.common.Terminals";
  
  private final static String XBASE = "org.eclipse.xtext.xbase.Xbase";
  
  private final HashSet<String> enabledPatterns = new HashSet<String>();
  
  private final HashSet<String> suppressedPatterns = new HashSet<String>();
  
  private String langId;
  
  private Grammar grammar;
  
  @Accessors
  private String javaScriptPath;
  
  @Accessors
  private String moduleName;
  
  @Accessors
  private String keywordsFilter = "\\w*";
  
  public boolean addEnablePattern(final String pattern) {
    return this.enabledPatterns.add(pattern);
  }
  
  public boolean addSuppressPattern(final String pattern) {
    return this.suppressedPatterns.add(pattern);
  }
  
  @Override
  public void checkConfiguration(final Issues issues) {
    super.checkConfiguration(issues);
    if ((this.javaScriptPath == null)) {
      issues.addError("The property \'javaScriptPath\' must be set.");
    }
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        return Boolean.valueOf(AceHighlightingFragment.this.suppressedPatterns.contains(it));
      }
    };
    Iterable<String> _filter = IterableExtensions.<String>filter(this.enabledPatterns, _function);
    for (final String pattern : _filter) {
      issues.addError((("The pattern \'" + pattern) + "\' cannot be enabled and suppressed."));
    }
  }
  
  @Override
  public void generate(final LanguageConfig config, final XpandExecutionContext ctx) {
    Grammar _grammar = config.getGrammar();
    List<String> _fileExtensions = config.getFileExtensions(_grammar);
    String _head = IterableExtensions.<String>head(_fileExtensions);
    this.langId = _head;
    Grammar _grammar_1 = config.getGrammar();
    this.grammar = _grammar_1;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.moduleName);
    if (_isNullOrEmpty) {
      this.moduleName = ("xtext/mode-" + this.langId);
    }
    super.generate(config, ctx);
  }
  
  @Override
  public void generate(final Xtend2ExecutionContext ctx) {
    final Set<String> keywords = this.getKeywords(this.grammar);
    CharSequence _generateJavaScript = this.generateJavaScript(keywords);
    this.writeToFile(_generateJavaScript, (("mode-" + this.langId) + ".js"));
  }
  
  private Set<String> getKeywords(final Grammar grammar) {
    final HashSet<String> result = CollectionLiterals.<String>newHashSet();
    EList<Grammar> _usedGrammars = grammar.getUsedGrammars();
    for (final Grammar usedGrammar : _usedGrammars) {
      Set<String> _keywords = this.getKeywords(usedGrammar);
      Iterables.<String>addAll(result, _keywords);
    }
    final TreeIterator<EObject> iterator = grammar.eAllContents();
    while (iterator.hasNext()) {
      {
        final EObject elem = iterator.next();
        if ((elem instanceof Keyword)) {
          String _value = ((Keyword)elem).getValue();
          result.add(_value);
        } else {
          if ((elem instanceof TerminalRule)) {
            iterator.prune();
          }
        }
      }
    }
    return result;
  }
  
  private boolean inherits(final Grammar grammar, final String name) {
    Grammar g = grammar;
    do {
      {
        String _name = g.getName();
        boolean _equals = Objects.equal(_name, name);
        if (_equals) {
          return true;
        }
        EList<Grammar> _usedGrammars = g.getUsedGrammars();
        Grammar _head = IterableExtensions.<Grammar>head(_usedGrammars);
        g = _head;
      }
    } while((!Objects.equal(g, null)));
    return false;
  }
  
  protected void writeToFile(final CharSequence content, final String fileName) {
    try {
      File _file = new File(this.javaScriptPath);
      _file.mkdirs();
      File _file_1 = new File(this.javaScriptPath, fileName);
      final FileWriter writer = new FileWriter(_file_1);
      String _string = content.toString();
      writer.write(_string);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected CharSequence generateJavaScript(final Collection<String> keywords) {
    CharSequence _xblockexpression = null;
    {
      final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
        @Override
        public Boolean apply(final String it) {
          return Boolean.valueOf(it.matches(AceHighlightingFragment.this.keywordsFilter));
        }
      };
      Iterable<String> _filter = IterableExtensions.<String>filter(keywords, _function);
      final List<String> filteredKeywords = IterableExtensions.<String>toList(_filter);
      final Multimap<String, String> patterns = this.createPatterns(keywords, filteredKeywords);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("define(\"");
      _builder.append(this.moduleName, "");
      _builder.append("\", [\"ace/lib/oop\", \"ace/mode/text\", \"ace/mode/text_highlight_rules\"], function(oop, mText, mTextHighlightRules) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("var HighlightRules = function() {");
      _builder.newLine();
      {
        boolean _isEmpty = filteredKeywords.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder.append("\t\t");
          _builder.append("var keywords = \"");
          {
            List<String> _sort = IterableExtensions.<String>sort(filteredKeywords);
            boolean _hasElements = false;
            for(final String keyword : _sort) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate("|", "\t\t");
              }
              _builder.append(keyword, "\t\t");
            }
          }
          _builder.append("\";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.append("this.$rules = {");
      _builder.newLine();
      {
        Set<String> _keySet = patterns.keySet();
        boolean _hasElements_1 = false;
        for(final String state : _keySet) {
          if (!_hasElements_1) {
            _hasElements_1 = true;
          } else {
            _builder.appendImmediate(",", "\t\t\t");
          }
          _builder.append("\t\t\t");
          _builder.append("\"");
          _builder.append(state, "\t\t\t");
          _builder.append("\": [");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("\t");
          {
            Collection<String> _get = patterns.get(state);
            boolean _hasElements_2 = false;
            for(final String rule : _get) {
              if (!_hasElements_2) {
                _hasElements_2 = true;
              } else {
                _builder.appendImmediate(",\n", "\t\t\t\t");
              }
              _builder.append(rule, "\t\t\t\t");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("]");
          _builder.newLine();
        }
      }
      _builder.append("\t\t");
      _builder.append("};");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("};");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("oop.inherits(HighlightRules, mTextHighlightRules.TextHighlightRules);");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var Mode = function() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this.HighlightRules = HighlightRules;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("};");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("oop.inherits(Mode, mText.Mode);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Mode.prototype.$id = \"xtext/mode/");
      _builder.append(this.langId, "\t");
      _builder.append("\";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("Mode.prototype.getCompletions = function(state, session, pos, prefix) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return [];");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Mode: Mode");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("};");
      _builder.newLine();
      _builder.append("});");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected Multimap<String, String> createPatterns(final Collection<String> keywords, final Collection<String> filteredKeywords) {
    final boolean inheritsTerminals = this.inherits(this.grammar, AceHighlightingFragment.TERMINALS);
    final boolean inheritsXbase = this.inherits(this.grammar, AceHighlightingFragment.XBASE);
    final LinkedHashMultimap<String, String> patterns = LinkedHashMultimap.<String, String>create();
    boolean _or = false;
    boolean _contains = this.enabledPatterns.contains("comment_singleLine");
    if (_contains) {
      _or = true;
    } else {
      boolean _and = false;
      if (!(inheritsTerminals || inheritsXbase)) {
        _and = false;
      } else {
        boolean _contains_1 = this.suppressedPatterns.contains("comment_singleLine");
        boolean _not = (!_contains_1);
        _and = _not;
      }
      _or = _and;
    }
    if (_or) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{token: \"comment\", regex: \"\\\\/\\\\/.*$\"}");
      patterns.put("start", _builder.toString());
    }
    boolean _or_1 = false;
    boolean _contains_2 = this.enabledPatterns.contains("comment_block");
    if (_contains_2) {
      _or_1 = true;
    } else {
      boolean _and_1 = false;
      if (!(inheritsTerminals || inheritsXbase)) {
        _and_1 = false;
      } else {
        boolean _contains_3 = this.suppressedPatterns.contains("comment_block");
        boolean _not_1 = (!_contains_3);
        _and_1 = _not_1;
      }
      _or_1 = _and_1;
    }
    if (_or_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("{token: \"comment\", regex: \"\\\\/\\\\*\", next : \"comment\"}");
      patterns.put("start", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("{token: \"comment\", regex: \".*?\\\\*\\\\/\", next : \"start\"}");
      patterns.put("comment", _builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("{token: \"comment\", regex: \".+\"}");
      patterns.put("comment", _builder_3.toString());
    }
    boolean _or_2 = false;
    boolean _contains_4 = this.enabledPatterns.contains("string_doubleQuote");
    if (_contains_4) {
      _or_2 = true;
    } else {
      boolean _and_2 = false;
      if (!(inheritsTerminals || inheritsXbase)) {
        _and_2 = false;
      } else {
        boolean _contains_5 = this.suppressedPatterns.contains("string_doubleQuote");
        boolean _not_2 = (!_contains_5);
        _and_2 = _not_2;
      }
      _or_2 = _and_2;
    }
    if (_or_2) {
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("{token: \"string\", regex: \'[\"](?:(?:\\\\\\\\.)|(?:[^\"\\\\\\\\]))*?[\"]\'}");
      patterns.put("start", _builder_4.toString());
    }
    boolean _or_3 = false;
    boolean _contains_6 = this.enabledPatterns.contains("string_singleQuote");
    if (_contains_6) {
      _or_3 = true;
    } else {
      boolean _and_3 = false;
      if (!(inheritsTerminals || inheritsXbase)) {
        _and_3 = false;
      } else {
        boolean _contains_7 = this.suppressedPatterns.contains("string_singleQuote");
        boolean _not_3 = (!_contains_7);
        _and_3 = _not_3;
      }
      _or_3 = _and_3;
    }
    if (_or_3) {
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("{token: \"string\", regex: \"[\'](?:(?:\\\\\\\\.)|(?:[^\'\\\\\\\\]))*?[\']\"}");
      patterns.put("start", _builder_5.toString());
    }
    boolean _or_4 = false;
    boolean _contains_8 = this.enabledPatterns.contains("number_decimal");
    if (_contains_8) {
      _or_4 = true;
    } else {
      boolean _and_4 = false;
      if (!(inheritsTerminals || inheritsXbase)) {
        _and_4 = false;
      } else {
        boolean _contains_9 = this.suppressedPatterns.contains("number_decimal");
        boolean _not_4 = (!_contains_9);
        _and_4 = _not_4;
      }
      _or_4 = _and_4;
    }
    if (_or_4) {
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("{token: \"constant.numeric\", regex: \"[+-]?\\\\d+(?:(?:\\\\.\\\\d*)?(?:[eE][+-]?\\\\d+)?)?\\\\b\"}");
      patterns.put("start", _builder_6.toString());
    }
    boolean _or_5 = false;
    boolean _contains_10 = this.enabledPatterns.contains("number_hex");
    if (_contains_10) {
      _or_5 = true;
    } else {
      boolean _and_5 = false;
      if (!inheritsXbase) {
        _and_5 = false;
      } else {
        boolean _contains_11 = this.suppressedPatterns.contains("number_hex");
        boolean _not_5 = (!_contains_11);
        _and_5 = _not_5;
      }
      _or_5 = _and_5;
    }
    if (_or_5) {
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("{token: \"constant.numeric\", regex: \"0[xX][0-9a-fA-F]+\\\\b\"}");
      patterns.put("start", _builder_7.toString());
    }
    boolean _or_6 = false;
    boolean _contains_12 = this.enabledPatterns.contains("bracket_open");
    if (_contains_12) {
      _or_6 = true;
    } else {
      boolean _and_6 = false;
      boolean _contains_13 = keywords.contains("[");
      if (!_contains_13) {
        _and_6 = false;
      } else {
        boolean _contains_14 = this.suppressedPatterns.contains("bracket_open");
        boolean _not_6 = (!_contains_14);
        _and_6 = _not_6;
      }
      _or_6 = _and_6;
    }
    final boolean bracketOpen = _or_6;
    boolean _or_7 = false;
    boolean _contains_15 = this.enabledPatterns.contains("parenthesis_open");
    if (_contains_15) {
      _or_7 = true;
    } else {
      boolean _and_7 = false;
      boolean _contains_16 = keywords.contains("(");
      if (!_contains_16) {
        _and_7 = false;
      } else {
        boolean _contains_17 = this.suppressedPatterns.contains("parenthesis_open");
        boolean _not_7 = (!_contains_17);
        _and_7 = _not_7;
      }
      _or_7 = _and_7;
    }
    final boolean parenOpen = _or_7;
    boolean _or_8 = false;
    boolean _contains_18 = this.enabledPatterns.contains("brace_open");
    if (_contains_18) {
      _or_8 = true;
    } else {
      boolean _and_8 = false;
      boolean _contains_19 = keywords.contains("{");
      if (!_contains_19) {
        _and_8 = false;
      } else {
        boolean _contains_20 = this.suppressedPatterns.contains("brace_open");
        boolean _not_8 = (!_contains_20);
        _and_8 = _not_8;
      }
      _or_8 = _and_8;
    }
    final boolean braceOpen = _or_8;
    boolean _or_9 = false;
    if ((bracketOpen || parenOpen)) {
      _or_9 = true;
    } else {
      _or_9 = braceOpen;
    }
    if (_or_9) {
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("{token: \"lparen\", regex: \"[");
      {
        if (bracketOpen) {
          _builder_8.append("\\\\[");
        }
      }
      {
        if (parenOpen) {
          _builder_8.append("(");
        }
      }
      {
        if (braceOpen) {
          _builder_8.append("{");
        }
      }
      _builder_8.append("]\"}");
      patterns.put("start", _builder_8.toString());
    }
    boolean _or_10 = false;
    boolean _contains_21 = this.enabledPatterns.contains("bracket_close");
    if (_contains_21) {
      _or_10 = true;
    } else {
      boolean _and_9 = false;
      boolean _contains_22 = keywords.contains("]");
      if (!_contains_22) {
        _and_9 = false;
      } else {
        boolean _contains_23 = this.suppressedPatterns.contains("bracket_close");
        boolean _not_9 = (!_contains_23);
        _and_9 = _not_9;
      }
      _or_10 = _and_9;
    }
    final boolean bracketClose = _or_10;
    boolean _or_11 = false;
    boolean _contains_24 = this.enabledPatterns.contains("parenthesis_close");
    if (_contains_24) {
      _or_11 = true;
    } else {
      boolean _and_10 = false;
      boolean _contains_25 = keywords.contains(")");
      if (!_contains_25) {
        _and_10 = false;
      } else {
        boolean _contains_26 = this.suppressedPatterns.contains("parenthesis_close");
        boolean _not_10 = (!_contains_26);
        _and_10 = _not_10;
      }
      _or_11 = _and_10;
    }
    final boolean parenClose = _or_11;
    boolean _or_12 = false;
    boolean _contains_27 = this.enabledPatterns.contains("brace_close");
    if (_contains_27) {
      _or_12 = true;
    } else {
      boolean _and_11 = false;
      boolean _contains_28 = keywords.contains("}");
      if (!_contains_28) {
        _and_11 = false;
      } else {
        boolean _contains_29 = this.suppressedPatterns.contains("brace_close");
        boolean _not_11 = (!_contains_29);
        _and_11 = _not_11;
      }
      _or_12 = _and_11;
    }
    final boolean braceClose = _or_12;
    boolean _or_13 = false;
    if ((bracketClose || parenClose)) {
      _or_13 = true;
    } else {
      _or_13 = braceClose;
    }
    if (_or_13) {
      StringConcatenation _builder_9 = new StringConcatenation();
      _builder_9.append("{token: \"rparen\", regex: \"[");
      {
        if (bracketClose) {
          _builder_9.append("\\\\]");
        }
      }
      {
        if (parenClose) {
          _builder_9.append(")");
        }
      }
      {
        if (braceClose) {
          _builder_9.append("}");
        }
      }
      _builder_9.append("]\"}");
      patterns.put("start", _builder_9.toString());
    }
    boolean _isEmpty = filteredKeywords.isEmpty();
    boolean _not_12 = (!_isEmpty);
    if (_not_12) {
      StringConcatenation _builder_10 = new StringConcatenation();
      _builder_10.append("{token: \"keyword\", regex: \"\\\\b(?:\" + keywords + \")\\\\b\"}");
      patterns.put("start", _builder_10.toString());
    }
    return patterns;
  }
  
  @Pure
  public String getJavaScriptPath() {
    return this.javaScriptPath;
  }
  
  public void setJavaScriptPath(final String javaScriptPath) {
    this.javaScriptPath = javaScriptPath;
  }
  
  @Pure
  public String getModuleName() {
    return this.moduleName;
  }
  
  public void setModuleName(final String moduleName) {
    this.moduleName = moduleName;
  }
  
  @Pure
  public String getKeywordsFilter() {
    return this.keywordsFilter;
  }
  
  public void setKeywordsFilter(final String keywordsFilter) {
    this.keywordsFilter = keywordsFilter;
  }
}
