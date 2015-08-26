/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.web;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.util.GrammarUtil2;

@SuppressWarnings("all")
public class OrionHighlightingFragment extends AbstractGeneratorFragment2 {
  private final static String TERMINALS = "org.eclipse.xtext.common.Terminals";
  
  private final static String XBASE = "org.eclipse.xtext.xbase.Xbase";
  
  private final HashSet<String> enabledPatterns = new HashSet<String>();
  
  private final HashSet<String> suppressedPatterns = new HashSet<String>();
  
  private String langId;
  
  private Grammar grammar;
  
  @Accessors
  private String moduleName;
  
  @Accessors
  private String keywordsFilter = "\\w*";
  
  /**
   * The default container for JS files is the webapp outlet.
   */
  @Accessors
  private String javaScriptPath = "";
  
  public boolean addEnablePattern(final String pattern) {
    return this.enabledPatterns.add(pattern);
  }
  
  public boolean addSuppressPattern(final String pattern) {
    return this.suppressedPatterns.add(pattern);
  }
  
  @Override
  public void checkConfiguration(final Issues issues) {
    super.checkConfiguration(issues);
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        return Boolean.valueOf(OrionHighlightingFragment.this.suppressedPatterns.contains(it));
      }
    };
    Iterable<String> _filter = IterableExtensions.<String>filter(this.enabledPatterns, _function);
    for (final String pattern : _filter) {
      issues.addError((("The pattern \'" + pattern) + "\' cannot be enabled and suppressed."));
    }
  }
  
  @Override
  public void generate() {
    ILanguageConfig _language = this.getLanguage();
    List<String> _fileExtensions = _language.getFileExtensions();
    String _head = IterableExtensions.<String>head(_fileExtensions);
    this.langId = _head;
    ILanguageConfig _language_1 = this.getLanguage();
    Grammar _grammar = _language_1.getGrammar();
    this.grammar = _grammar;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.moduleName);
    if (_isNullOrEmpty) {
      this.moduleName = (("xtext/generated/" + this.langId) + "-syntax");
    }
    final Set<String> keywords = GrammarUtil.getAllKeywords(this.grammar);
    CharSequence _generateJavaScript = this.generateJavaScript(keywords);
    this.writeToFile(_generateJavaScript, (((this.javaScriptPath + "/") + this.moduleName) + ".js"));
  }
  
  protected void writeToFile(final CharSequence content, final String fileName) {
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IXtextGeneratorFileSystemAccess _webApp = _projectConfig.getWebApp();
    boolean _notEquals = (!Objects.equal(_webApp, null));
    if (_notEquals) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IXtextGeneratorFileSystemAccess _webApp_1 = _projectConfig_1.getWebApp();
      _webApp_1.generateFile(fileName, content);
    }
  }
  
  protected CharSequence generateJavaScript(final Collection<String> keywords) {
    CharSequence _xblockexpression = null;
    {
      final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
        @Override
        public Boolean apply(final String it) {
          return Boolean.valueOf(it.matches(OrionHighlightingFragment.this.keywordsFilter));
        }
      };
      Iterable<String> _filter = IterableExtensions.<String>filter(keywords, _function);
      final List<String> filteredKeywords = IterableExtensions.<String>toList(_filter);
      final Collection<String> patterns = this.createPatterns(keywords, filteredKeywords);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("define(\"");
      _builder.append(this.moduleName, "");
      _builder.append("\", [\"orion/editor/stylers/lib/syntax\"], function(mLib) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("var keywords = [");
      {
        List<String> _sort = IterableExtensions.<String>sort(filteredKeywords);
        boolean _hasElements = false;
        for(final String keyword : _sort) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(", ", "\t");
          }
          _builder.append("\"");
          _builder.append(keyword, "\t");
          _builder.append("\"");
        }
      }
      _builder.append("];");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var grammars = [];");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("grammars.push.apply(grammars, mLib.grammars);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("grammars.push({");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("id: \"xtext.");
      _builder.append(this.langId, "\t\t");
      _builder.append("\",");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("contentTypes: [\"xtext/");
      _builder.append(this.langId, "\t\t");
      _builder.append("\"],");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("patterns: [");
      _builder.newLine();
      _builder.append("\t\t\t");
      {
        boolean _hasElements_1 = false;
        for(final String pattern : patterns) {
          if (!_hasElements_1) {
            _hasElements_1 = true;
          } else {
            _builder.appendImmediate(",\n", "\t\t\t");
          }
          _builder.append(pattern, "\t\t\t");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("});");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("id: \"xtext.");
      _builder.append(this.langId, "\t\t");
      _builder.append("\",");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("grammars: grammars,");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("keywords: keywords");
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
  
  protected Collection<String> createPatterns(final Collection<String> keywords, final Collection<String> filteredKeywords) {
    final boolean inheritsTerminals = GrammarUtil2.inherits(this.grammar, OrionHighlightingFragment.TERMINALS);
    final boolean inheritsXbase = GrammarUtil2.inherits(this.grammar, OrionHighlightingFragment.XBASE);
    final ArrayList<String> patterns = new ArrayList<String>();
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
      patterns.add("{include: \"orion.c-like#comment_singleLine\"}");
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
      patterns.add("{include: \"orion.c-like#comment_block\"}");
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
      patterns.add("{include: \"orion.lib#string_doubleQuote\"}");
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
      patterns.add("{include: \"orion.lib#string_singleQuote\"}");
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
      patterns.add("{include: \"orion.lib#number_decimal\"}");
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
      patterns.add("{include: \"orion.lib#number_hex\"}");
    }
    boolean _or_6 = false;
    boolean _contains_12 = this.enabledPatterns.contains("brace_open");
    if (_contains_12) {
      _or_6 = true;
    } else {
      boolean _and_6 = false;
      boolean _contains_13 = keywords.contains("{");
      if (!_contains_13) {
        _and_6 = false;
      } else {
        boolean _contains_14 = this.suppressedPatterns.contains("brace_open");
        boolean _not_6 = (!_contains_14);
        _and_6 = _not_6;
      }
      _or_6 = _and_6;
    }
    if (_or_6) {
      patterns.add("{include: \"orion.lib#brace_open\"}");
    }
    boolean _or_7 = false;
    boolean _contains_15 = this.enabledPatterns.contains("brace_close");
    if (_contains_15) {
      _or_7 = true;
    } else {
      boolean _and_7 = false;
      boolean _contains_16 = keywords.contains("}");
      if (!_contains_16) {
        _and_7 = false;
      } else {
        boolean _contains_17 = this.suppressedPatterns.contains("brace_close");
        boolean _not_7 = (!_contains_17);
        _and_7 = _not_7;
      }
      _or_7 = _and_7;
    }
    if (_or_7) {
      patterns.add("{include: \"orion.lib#brace_close\"}");
    }
    boolean _or_8 = false;
    boolean _contains_18 = this.enabledPatterns.contains("bracket_open");
    if (_contains_18) {
      _or_8 = true;
    } else {
      boolean _and_8 = false;
      boolean _contains_19 = keywords.contains("[");
      if (!_contains_19) {
        _and_8 = false;
      } else {
        boolean _contains_20 = this.suppressedPatterns.contains("bracket_open");
        boolean _not_8 = (!_contains_20);
        _and_8 = _not_8;
      }
      _or_8 = _and_8;
    }
    if (_or_8) {
      patterns.add("{include: \"orion.lib#bracket_open\"}");
    }
    boolean _or_9 = false;
    boolean _contains_21 = this.enabledPatterns.contains("bracket_close");
    if (_contains_21) {
      _or_9 = true;
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
      _or_9 = _and_9;
    }
    if (_or_9) {
      patterns.add("{include: \"orion.lib#bracket_close\"}");
    }
    boolean _or_10 = false;
    boolean _contains_24 = this.enabledPatterns.contains("parenthesis_open");
    if (_contains_24) {
      _or_10 = true;
    } else {
      boolean _and_10 = false;
      boolean _contains_25 = keywords.contains("(");
      if (!_contains_25) {
        _and_10 = false;
      } else {
        boolean _contains_26 = this.suppressedPatterns.contains("parenthesis_open");
        boolean _not_10 = (!_contains_26);
        _and_10 = _not_10;
      }
      _or_10 = _and_10;
    }
    if (_or_10) {
      patterns.add("{include: \"orion.lib#parenthesis_open\"}");
    }
    boolean _or_11 = false;
    boolean _contains_27 = this.enabledPatterns.contains("parenthesis_close");
    if (_contains_27) {
      _or_11 = true;
    } else {
      boolean _and_11 = false;
      boolean _contains_28 = keywords.contains(")");
      if (!_contains_28) {
        _and_11 = false;
      } else {
        boolean _contains_29 = this.suppressedPatterns.contains("parenthesis_close");
        boolean _not_11 = (!_contains_29);
        _and_11 = _not_11;
      }
      _or_11 = _and_11;
    }
    if (_or_11) {
      patterns.add("{include: \"orion.lib#parenthesis_close\"}");
    }
    boolean _contains_30 = this.enabledPatterns.contains("doc_block");
    if (_contains_30) {
      patterns.add("{include: \"orion.lib#doc_block\"}");
    }
    boolean _isEmpty = filteredKeywords.isEmpty();
    boolean _not_12 = (!_isEmpty);
    if (_not_12) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{match: \"\\\\b(?:\" + keywords.join(\"|\") + \")\\\\b\", name: \"keyword.operator.");
      _builder.append(this.langId, "");
      _builder.append("\"}");
      patterns.add(_builder.toString());
    }
    return patterns;
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
  
  @Pure
  public String getJavaScriptPath() {
    return this.javaScriptPath;
  }
  
  public void setJavaScriptPath(final String javaScriptPath) {
    this.javaScriptPath = javaScriptPath;
  }
}
