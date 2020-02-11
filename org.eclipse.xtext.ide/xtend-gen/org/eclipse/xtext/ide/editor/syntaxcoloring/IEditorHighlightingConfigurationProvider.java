/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.syntaxcoloring;

import com.google.common.base.Objects;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@ImplementedBy(IEditorHighlightingConfigurationProvider.DefaultImpl.class)
@SuppressWarnings("all")
public interface IEditorHighlightingConfigurationProvider {
  class DefaultImpl implements IEditorHighlightingConfigurationProvider {
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
        _builder.append("match: \"\\\\b(?:");
        String _join = IterableExtensions.join(this.getKeywords(), "|");
        _builder.append(_join, "    ");
        _builder.append(")\\\\b\", ");
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
      _builder.append("{include: \"orion.lib#doc_block\"},");
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
      return _builder;
    }
    
    public Iterable<String> getKeywords() {
      final Function1<Keyword, Boolean> _function = (Keyword it) -> {
        return Boolean.valueOf(Character.isLetter(it.getValue().charAt(0)));
      };
      final Function1<Keyword, String> _function_1 = (Keyword it) -> {
        return it.getValue();
      };
      return IterableExtensions.<String>sort(IterableExtensions.<String>toSet(IterableExtensions.<Keyword, String>map(IterableExtensions.<Keyword>filter(GrammarUtil.containedKeywords(this.grammarAccess.getGrammar()), _function), _function_1)));
    }
  }
  
  /**
   * provides an editor specific highlighting configuration or null.
   */
  String getConfiguration(final String editorName);
}
