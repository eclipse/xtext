/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.web;

import com.google.common.base.Objects;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.util.GrammarUtil2;

/**
 * JavaScript-based syntax highlighting for several editor frameworks.
 * Currently supported frameworks:
 * <ul>
 *   <li><a href="http://eclipse.org/orion/">Orion</a></li>
 *   <li><a href="http://ace.c9.io">Ace</a></li>
 *   <li><a href="http://codemirror.net">CodeMirror</a></li>
 * </ul>
 */
@SuppressWarnings("all")
public class JsHighlightingFragment extends AbstractGeneratorFragment2 {
  private enum Framework {
    ORION,
    
    ACE,
    
    CODEMIRROR;
  }
  
  private final static String TERMINALS = "org.eclipse.xtext.common.Terminals";
  
  private final static String XBASE = "org.eclipse.xtext.xbase.Xbase";
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  private String langId;
  
  private Grammar grammar;
  
  private final HashSet<String> enabledPatterns = new HashSet<String>();
  
  private final HashSet<String> suppressedPatterns = new HashSet<String>();
  
  private JsHighlightingFragment.Framework framework;
  
  private String moduleName;
  
  private String keywordsFilter = "\\w*";
  
  private String path;
  
  /**
   * Enable a default pattern for syntax highlighting. See the documentation of the chosen
   * framework for details.
   */
  public void addEnablePattern(final String pattern) {
    this.enabledPatterns.add(pattern);
  }
  
  /**
   * Suppress a default pattern for syntax highlighting. See the documentation of the chosen
   * framework for details.
   */
  public void addSuppressPattern(final String pattern) {
    this.suppressedPatterns.add(pattern);
  }
  
  /**
   * Choose one of the supported frameworks: {@code "Orion"}, {@code "Ace"}, or {@code "CodeMirror"}
   */
  @Mandatory
  public void setFramework(final String frameworkName) {
    String _upperCase = frameworkName.toUpperCase();
    JsHighlightingFragment.Framework _valueOf = JsHighlightingFragment.Framework.valueOf(_upperCase);
    this.framework = _valueOf;
  }
  
  /**
   * Name of the RequireJS module to be generated.
   */
  public void setModuleName(final String moduleName) {
    this.moduleName = moduleName;
  }
  
  /**
   * Regular expression for filtering those language keywords that should be highlighted. The default
   * is {@code \w*}, i.e. keywords consisting only of letters and digits.
   */
  public void setKeywordsFilter(final String keywordsFilter) {
    this.keywordsFilter = keywordsFilter;
  }
  
  /**
   * The path of the JavaScript file to be generated. The default is to derive the path from
   * the {@code moduleName} property.
   */
  public void setPath(final String path) {
    this.path = path;
  }
  
  @Override
  public void checkConfiguration(final Issues issues) {
    super.checkConfiguration(issues);
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IXtextGeneratorFileSystemAccess _webApp = _projectConfig.getWebApp();
    boolean _tripleEquals = (_webApp == null);
    if (_tripleEquals) {
      issues.addWarning("The webapp outlet is not defined in the project configuration; JS syntax highlighting is disabled.");
    }
    if ((this.framework == null)) {
      issues.addError("The property \'framework\' is required.");
    }
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        return Boolean.valueOf(JsHighlightingFragment.this.suppressedPatterns.contains(it));
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
      String _switchResult = null;
      final JsHighlightingFragment.Framework framework = this.framework;
      if (framework != null) {
        switch (framework) {
          case ORION:
            _switchResult = (("xtext-resources/generated/" + this.langId) + "-syntax");
            break;
          case ACE:
          case CODEMIRROR:
            _switchResult = ("xtext-resources/generated/mode-" + this.langId);
            break;
          default:
            break;
        }
      }
      this.moduleName = _switchResult;
    } else {
      boolean _endsWith = this.moduleName.endsWith(".js");
      if (_endsWith) {
        int _length = this.moduleName.length();
        int _minus = (_length - 3);
        String _substring = this.moduleName.substring(0, _minus);
        this.moduleName = _substring;
      }
    }
    boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(this.path);
    if (_isNullOrEmpty_1) {
      this.path = (this.moduleName + ".js");
    }
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IXtextGeneratorFileSystemAccess _webApp = _projectConfig.getWebApp();
    boolean _notEquals = (!Objects.equal(_webApp, null));
    if (_notEquals) {
      final Set<String> keywords = GrammarUtil.getAllKeywords(this.grammar);
      TextFileAccess _generateJavaScript = this.generateJavaScript(keywords);
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IXtextGeneratorFileSystemAccess _webApp_1 = _projectConfig_1.getWebApp();
      _generateJavaScript.writeTo(_webApp_1);
    }
  }
  
  protected TextFileAccess generateJavaScript(final Collection<String> keywords) {
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        return Boolean.valueOf(it.matches(JsHighlightingFragment.this.keywordsFilter));
      }
    };
    Iterable<String> _filter = IterableExtensions.<String>filter(keywords, _function);
    final Function1<String, String> _function_1 = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        return Strings.convertToJavaString(it);
      }
    };
    Iterable<String> _map = IterableExtensions.<String, String>map(_filter, _function_1);
    final List<String> filteredKeywords = IterableExtensions.<String>toList(_map);
    final TextFileAccess jsFile = this.fileAccessFactory.createTextFile();
    jsFile.setPath(this.path);
    final JsHighlightingFragment.Framework framework = this.framework;
    if (framework != null) {
      switch (framework) {
        case ORION:
          final Collection<String> patterns = this.createOrionPatterns(keywords, filteredKeywords);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("define(\"");
          _builder.append(this.moduleName, "");
          _builder.append("\", function() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("var keywords = \"");
          {
            List<String> _sort = IterableExtensions.<String>sort(filteredKeywords);
            boolean _hasElements = false;
            for(final String keyword : _sort) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate("|", "\t");
              }
              _builder.append(keyword, "\t");
            }
          }
          _builder.append("\";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("return {");
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
          _builder.append("};");
          _builder.newLine();
          _builder.append("});");
          _builder.newLine();
          jsFile.setContent(_builder);
          break;
        case ACE:
          final Multimap<String, String> patterns_1 = this.createCodeMirrorPatterns(keywords, filteredKeywords);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("define(\"");
          _builder_1.append(this.moduleName, "");
          _builder_1.append("\", [\"ace/lib/oop\", \"ace/mode/text\", \"ace/mode/text_highlight_rules\"], function(oop, mText, mTextHighlightRules) {");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t");
          _builder_1.append("var HighlightRules = function() {");
          _builder_1.newLine();
          {
            boolean _isEmpty = filteredKeywords.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              _builder_1.append("\t\t");
              _builder_1.append("var keywords = \"");
              {
                List<String> _sort_1 = IterableExtensions.<String>sort(filteredKeywords);
                boolean _hasElements_2 = false;
                for(final String keyword_1 : _sort_1) {
                  if (!_hasElements_2) {
                    _hasElements_2 = true;
                  } else {
                    _builder_1.appendImmediate("|", "\t\t");
                  }
                  _builder_1.append(keyword_1, "\t\t");
                }
              }
              _builder_1.append("\";");
              _builder_1.newLineIfNotEmpty();
            }
          }
          _builder_1.append("\t\t");
          _builder_1.append("this.$rules = {");
          _builder_1.newLine();
          {
            Set<String> _keySet = patterns_1.keySet();
            boolean _hasElements_3 = false;
            for(final String state : _keySet) {
              if (!_hasElements_3) {
                _hasElements_3 = true;
              } else {
                _builder_1.appendImmediate(",", "\t\t\t");
              }
              _builder_1.append("\t\t\t");
              _builder_1.append("\"");
              _builder_1.append(state, "\t\t\t");
              _builder_1.append("\": [");
              _builder_1.newLineIfNotEmpty();
              _builder_1.append("\t\t\t");
              _builder_1.append("\t");
              {
                Collection<String> _get = patterns_1.get(state);
                boolean _hasElements_4 = false;
                for(final String rule : _get) {
                  if (!_hasElements_4) {
                    _hasElements_4 = true;
                  } else {
                    _builder_1.appendImmediate(",\n", "\t\t\t\t");
                  }
                  _builder_1.append(rule, "\t\t\t\t");
                }
              }
              _builder_1.newLineIfNotEmpty();
              _builder_1.append("\t\t\t");
              _builder_1.append("]");
              _builder_1.newLine();
            }
          }
          _builder_1.append("\t\t");
          _builder_1.append("};");
          _builder_1.newLine();
          _builder_1.append("\t");
          _builder_1.append("};");
          _builder_1.newLine();
          _builder_1.append("\t");
          _builder_1.append("oop.inherits(HighlightRules, mTextHighlightRules.TextHighlightRules);");
          _builder_1.newLine();
          _builder_1.append("\t");
          _builder_1.newLine();
          _builder_1.append("\t");
          _builder_1.append("var Mode = function() {");
          _builder_1.newLine();
          _builder_1.append("\t\t");
          _builder_1.append("this.HighlightRules = HighlightRules;");
          _builder_1.newLine();
          _builder_1.append("\t");
          _builder_1.append("};");
          _builder_1.newLine();
          _builder_1.append("\t");
          _builder_1.append("oop.inherits(Mode, mText.Mode);");
          _builder_1.newLine();
          _builder_1.append("\t");
          _builder_1.append("Mode.prototype.$id = \"xtext/");
          _builder_1.append(this.langId, "\t");
          _builder_1.append("\";");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t");
          _builder_1.append("Mode.prototype.getCompletions = function(state, session, pos, prefix) {");
          _builder_1.newLine();
          _builder_1.append("\t\t");
          _builder_1.append("return [];");
          _builder_1.newLine();
          _builder_1.append("\t");
          _builder_1.append("}");
          _builder_1.newLine();
          _builder_1.append("\t");
          _builder_1.newLine();
          _builder_1.append("\t");
          _builder_1.append("return {");
          _builder_1.newLine();
          _builder_1.append("\t\t");
          _builder_1.append("Mode: Mode");
          _builder_1.newLine();
          _builder_1.append("\t");
          _builder_1.append("};");
          _builder_1.newLine();
          _builder_1.append("});");
          _builder_1.newLine();
          jsFile.setContent(_builder_1);
          break;
        case CODEMIRROR:
          final Multimap<String, String> patterns_2 = this.createCodeMirrorPatterns(keywords, filteredKeywords);
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("define(\"");
          _builder_2.append(this.moduleName, "");
          _builder_2.append("\", [\"codemirror\", \"codemirror/addon/mode/simple\"], function(CodeMirror, SimpleMode) {");
          _builder_2.newLineIfNotEmpty();
          {
            boolean _isEmpty_1 = filteredKeywords.isEmpty();
            boolean _not_1 = (!_isEmpty_1);
            if (_not_1) {
              _builder_2.append("\t");
              _builder_2.append("var keywords = \"");
              {
                List<String> _sort_2 = IterableExtensions.<String>sort(filteredKeywords);
                boolean _hasElements_5 = false;
                for(final String keyword_2 : _sort_2) {
                  if (!_hasElements_5) {
                    _hasElements_5 = true;
                  } else {
                    _builder_2.appendImmediate("|", "\t");
                  }
                  _builder_2.append(keyword_2, "\t");
                }
              }
              _builder_2.append("\";");
              _builder_2.newLineIfNotEmpty();
            }
          }
          _builder_2.append("\t");
          _builder_2.append("CodeMirror.defineSimpleMode(\"xtext/");
          _builder_2.append(this.langId, "\t");
          _builder_2.append("\", {");
          _builder_2.newLineIfNotEmpty();
          {
            Set<String> _keySet_1 = patterns_2.keySet();
            boolean _hasElements_6 = false;
            for(final String state_1 : _keySet_1) {
              if (!_hasElements_6) {
                _hasElements_6 = true;
              } else {
                _builder_2.appendImmediate(",", "\t\t");
              }
              _builder_2.append("\t\t");
              _builder_2.append(state_1, "\t\t");
              _builder_2.append(": ");
              {
                boolean _equals = Objects.equal(state_1, "meta");
                if (_equals) {
                  _builder_2.append("{");
                } else {
                  _builder_2.append("[");
                }
              }
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("\t\t");
              _builder_2.append("\t");
              {
                Collection<String> _get_1 = patterns_2.get(state_1);
                boolean _hasElements_7 = false;
                for(final String rule_1 : _get_1) {
                  if (!_hasElements_7) {
                    _hasElements_7 = true;
                  } else {
                    _builder_2.appendImmediate(",\n", "\t\t\t");
                  }
                  _builder_2.append(rule_1, "\t\t\t");
                }
              }
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("\t\t");
              {
                boolean _equals_1 = Objects.equal(state_1, "meta");
                if (_equals_1) {
                  _builder_2.append("}");
                } else {
                  _builder_2.append("]");
                }
              }
              _builder_2.newLineIfNotEmpty();
            }
          }
          _builder_2.append("\t");
          _builder_2.append("});");
          _builder_2.newLine();
          _builder_2.append("});");
          _builder_2.newLine();
          jsFile.setContent(_builder_2);
          break;
        default:
          break;
      }
    }
    return jsFile;
  }
  
  protected Collection<String> createOrionPatterns(final Collection<String> keywords, final Collection<String> filteredKeywords) {
    final boolean inheritsTerminals = GrammarUtil2.inherits(this.grammar, JsHighlightingFragment.TERMINALS);
    final boolean inheritsXbase = GrammarUtil2.inherits(this.grammar, JsHighlightingFragment.XBASE);
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
      _builder.append("{match: \"\\\\b(?:\" + keywords + \")\\\\b\", name: \"keyword.");
      _builder.append(this.langId, "");
      _builder.append("\"}");
      patterns.add(_builder.toString());
    }
    return patterns;
  }
  
  protected Multimap<String, String> createCodeMirrorPatterns(final Collection<String> keywords, final Collection<String> filteredKeywords) {
    final boolean inheritsTerminals = GrammarUtil2.inherits(this.grammar, JsHighlightingFragment.TERMINALS);
    final boolean inheritsXbase = GrammarUtil2.inherits(this.grammar, JsHighlightingFragment.XBASE);
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
    final boolean hasSingleLineComment = _or;
    if (hasSingleLineComment) {
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
    boolean _and_12 = false;
    boolean _equals = Objects.equal(this.framework, JsHighlightingFragment.Framework.CODEMIRROR);
    if (!_equals) {
      _and_12 = false;
    } else {
      boolean _containsKey = patterns.containsKey("comment");
      _and_12 = _containsKey;
    }
    if (_and_12) {
      StringConcatenation _builder_11 = new StringConcatenation();
      _builder_11.append("dontIndentStates: [\"comment\"]");
      patterns.put("meta", _builder_11.toString());
    }
    boolean _and_13 = false;
    boolean _equals_1 = Objects.equal(this.framework, JsHighlightingFragment.Framework.CODEMIRROR);
    if (!_equals_1) {
      _and_13 = false;
    } else {
      _and_13 = hasSingleLineComment;
    }
    if (_and_13) {
      StringConcatenation _builder_12 = new StringConcatenation();
      _builder_12.append("lineComment: \"//\"");
      patterns.put("meta", _builder_12.toString());
    }
    return patterns;
  }
}
