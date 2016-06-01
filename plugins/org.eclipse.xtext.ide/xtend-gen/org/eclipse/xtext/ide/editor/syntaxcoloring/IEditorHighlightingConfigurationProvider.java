/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.syntaxcoloring;

import com.google.common.base.Objects;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(IEditorHighlightingConfigurationProvider.DefaultImpl.class)
@SuppressWarnings("all")
public interface IEditorHighlightingConfigurationProvider {
  public static class DefaultImpl implements IEditorHighlightingConfigurationProvider {
    @Inject
    private IGrammarAccess grammarAccess;
    
    @Inject
    private LanguageInfo languageInfo;
    
    @Override
    public String getConfiguration(final String editorName) {
      if ((Objects.equal(editorName, "EclipseChe") || Objects.equal(editorName, "EclipseOrion"))) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("[");
        _builder.newLine();
        _builder.append("  ");
        CharSequence _getStandardPatterns = this.getGetStandardPatterns();
        _builder.append(_getStandardPatterns, "  ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("{");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("match: \"\\\\\\\\b(?:");
        Iterable<String> _keywords = this.getKeywords();
        String _join = IterableExtensions.join(_keywords, "|");
        _builder.append(_join, "    ");
        _builder.append(")\\\\\\\\b\", ");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("name: \"keyword.");
        String _shortName = this.languageInfo.getShortName();
        _builder.append(_shortName, "    ");
        _builder.append("\" ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("]");
        _builder.newLine();
        return _builder.toString();
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        return _builder_1.toString();
      }
    }
    
    public CharSequence getGetStandardPatterns() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{include: \"orion.c-like#comment_singleLine\"},");
      _builder.newLine();
      _builder.append("{include: \"orion.c-like#comment_block\"},");
      _builder.newLine();
      _builder.append("{include: \"orion.lib#string_doubleQuote\"},");
      _builder.newLine();
      _builder.append("{include: \"orion.lib#string_singleQuote\"},");
      _builder.newLine();
      _builder.append("{include: \"orion.lib#number_decimal\"},");
      _builder.newLine();
      _builder.append("{include: \"orion.lib#number_hex\"},");
      _builder.newLine();
      _builder.append("{include: \"orion.lib#brace_open\"},");
      _builder.newLine();
      _builder.append("{include: \"orion.lib#brace_close\"},");
      _builder.newLine();
      _builder.append("{include: \"orion.lib#bracket_open\"},");
      _builder.newLine();
      _builder.append("{include: \"orion.lib#bracket_close\"},");
      _builder.newLine();
      _builder.append("{include: \"orion.lib#parenthesis_open\"},");
      _builder.newLine();
      _builder.append("{include: \"orion.lib#parenthesis_close\"},");
      _builder.newLine();
      _builder.append("{include: \"orion.lib#operator\"},");
      _builder.newLine();
      _builder.append("{include: \"orion.lib#doc_block\"},");
      _builder.newLine();
      return _builder;
    }
    
    public Iterable<String> getKeywords() {
      Grammar _grammar = this.grammarAccess.getGrammar();
      List<Keyword> _containedKeywords = GrammarUtil.containedKeywords(_grammar);
      final Function1<Keyword, Boolean> _function = new Function1<Keyword, Boolean>() {
        @Override
        public Boolean apply(final Keyword it) {
          String _value = it.getValue();
          char _charAt = _value.charAt(0);
          return Boolean.valueOf(Character.isJavaIdentifierStart(_charAt));
        }
      };
      Iterable<Keyword> _filter = IterableExtensions.<Keyword>filter(_containedKeywords, _function);
      final Function1<Keyword, String> _function_1 = new Function1<Keyword, String>() {
        @Override
        public String apply(final Keyword it) {
          return it.getValue();
        }
      };
      Iterable<String> _map = IterableExtensions.<Keyword, String>map(_filter, _function_1);
      Set<String> _set = IterableExtensions.<String>toSet(_map);
      return IterableExtensions.<String>sort(_set);
    }
  }
  
  /**
   * provides an editor specific highlighting configuration or null.
   */
  public abstract String getConfiguration(final String editorName);
}
