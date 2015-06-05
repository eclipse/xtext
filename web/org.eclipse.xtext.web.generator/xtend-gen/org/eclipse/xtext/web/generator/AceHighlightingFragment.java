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
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
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
  private String keywordsFilter = "\\w*";
  
  public boolean addEnablePattern(final String pattern) {
    boolean _xblockexpression = false;
    {
      boolean _contains = this.suppressedPatterns.contains(pattern);
      if (_contains) {
        throw new IllegalArgumentException("Cannot enable a suppressed pattern.");
      }
      _xblockexpression = this.enabledPatterns.add(pattern);
    }
    return _xblockexpression;
  }
  
  public boolean addSuppressPattern(final String pattern) {
    boolean _xblockexpression = false;
    {
      boolean _contains = this.enabledPatterns.contains(pattern);
      if (_contains) {
        throw new IllegalArgumentException("Cannot suppress an enabled pattern.");
      }
      _xblockexpression = this.suppressedPatterns.add(pattern);
    }
    return _xblockexpression;
  }
  
  @Override
  public void generate(final LanguageConfig config, final XpandExecutionContext ctx) {
    Grammar _grammar = config.getGrammar();
    List<String> _fileExtensions = config.getFileExtensions(_grammar);
    String _head = IterableExtensions.<String>head(_fileExtensions);
    this.langId = _head;
    Grammar _grammar_1 = config.getGrammar();
    this.grammar = _grammar_1;
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
      final Collection<String> patterns = this.createPatterns(keywords, filteredKeywords);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("define(\"xtext/mode-");
      _builder.append(this.langId, "");
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
      _builder.append("\t\t\t");
      _builder.append("\"start\": [");
      _builder.newLine();
      {
        boolean _isEmpty_1 = filteredKeywords.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          _builder.append("\t\t\t\t");
          _builder.append("{token: \"keyword\", regex: \"\\\\b(?:\" + keywords + \")\\\\b\"}");
          _builder.newLine();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("]");
      _builder.newLine();
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
  
  protected Collection<String> createPatterns(final Collection<String> keywords, final Collection<String> filteredKeywords) {
    final ArrayList<String> patterns = new ArrayList<String>();
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
  public String getKeywordsFilter() {
    return this.keywordsFilter;
  }
  
  public void setKeywordsFilter(final String keywordsFilter) {
    this.keywordsFilter = keywordsFilter;
  }
}
