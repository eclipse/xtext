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
public class ClientHighlightingFragment extends Xtend2GeneratorFragment {
  private final static String TERMINALS = "org.eclipse.xtext.common.Terminals";
  
  private final static String XBASE = "org.eclipse.xtext.xbase.Xbase";
  
  private String langId;
  
  private Grammar grammar;
  
  @Accessors
  private String javaScriptPath;
  
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
    this.writeToFile(_generateJavaScript, (this.langId + "-syntax.js"));
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
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("define(\"xtext/");
    _builder.append(this.langId, "");
    _builder.append("-syntax\", [\"orion/editor/stylers/lib/syntax\"], function(mLib) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("var keywords = [");
    _builder.newLine();
    _builder.append("\t\t");
    {
      final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
        @Override
        public Boolean apply(final String it) {
          return Boolean.valueOf(it.matches("\\w*"));
        }
      };
      Iterable<String> _filter = IterableExtensions.<String>filter(keywords, _function);
      List<String> _sort = IterableExtensions.<String>sort(_filter);
      boolean _hasElements = false;
      for(final String kw : _sort) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "\t\t");
        }
        _builder.append("\"");
        _builder.append(kw, "\t\t");
        _builder.append("\"");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("];");
    _builder.newLine();
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
    {
      boolean _or = false;
      boolean _inherits = this.inherits(this.grammar, ClientHighlightingFragment.TERMINALS);
      if (_inherits) {
        _or = true;
      } else {
        boolean _inherits_1 = this.inherits(this.grammar, ClientHighlightingFragment.XBASE);
        _or = _inherits_1;
      }
      if (_or) {
        _builder.append("\t\t\t");
        _builder.append("{include: \"orion.lib#string_doubleQuote\"},");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("{include: \"orion.lib#string_singleQuote\"},");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("{include: \"orion.c-like#comment_singleLine\"},");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("{include: \"orion.c-like#comment_block\"},");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("{include: \"orion.lib#number_decimal\"},");
        _builder.newLine();
      }
    }
    {
      boolean _inherits_2 = this.inherits(this.grammar, ClientHighlightingFragment.XBASE);
      if (_inherits_2) {
        _builder.append("\t\t\t");
        _builder.append("{include: \"orion.lib#number_hex\"},");
        _builder.newLine();
      }
    }
    {
      boolean _and = false;
      boolean _contains = keywords.contains("{");
      if (!_contains) {
        _and = false;
      } else {
        boolean _contains_1 = keywords.contains("}");
        _and = _contains_1;
      }
      if (_and) {
        _builder.append("\t\t\t");
        _builder.append("{include: \"orion.lib#brace_open\"},");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("{include: \"orion.lib#brace_close\"},");
        _builder.newLine();
      }
    }
    {
      boolean _and_1 = false;
      boolean _contains_2 = keywords.contains("[");
      if (!_contains_2) {
        _and_1 = false;
      } else {
        boolean _contains_3 = keywords.contains("]");
        _and_1 = _contains_3;
      }
      if (_and_1) {
        _builder.append("\t\t\t");
        _builder.append("{include: \"orion.lib#bracket_open\"},");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("{include: \"orion.lib#bracket_close\"},");
        _builder.newLine();
      }
    }
    {
      boolean _and_2 = false;
      boolean _contains_4 = keywords.contains("(");
      if (!_contains_4) {
        _and_2 = false;
      } else {
        boolean _contains_5 = keywords.contains(")");
        _and_2 = _contains_5;
      }
      if (_and_2) {
        _builder.append("\t\t\t");
        _builder.append("{include: \"orion.lib#parenthesis_open\"},");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("{include: \"orion.lib#parenthesis_close\"},");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("match: \"\\\\b(?:\" + keywords.join(\"|\") + \")\\\\b\",");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("name: \"keyword.operator.");
    _builder.append(this.langId, "\t\t\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
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
    return _builder;
  }
  
  @Pure
  public String getJavaScriptPath() {
    return this.javaScriptPath;
  }
  
  public void setJavaScriptPath(final String javaScriptPath) {
    this.javaScriptPath = javaScriptPath;
  }
}
