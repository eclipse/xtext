/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.highlighting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class DefaultHighlightingConfiguration implements IHighlightingConfiguration {
  public interface IHighlightingStyleAcceptor {
    public abstract TextAttributesKey addStyle(final String xtextStyleId, final String displayName, final TextAttributesKey fallbackKey);
  }
  
  @Inject
  @Named(Constants.LANGUAGE_NAME)
  private String languageId;
  
  private Map<String, AttributesDescriptor> name2attributes;
  
  private void initialize() {
    boolean _equals = Objects.equal(this.name2attributes, null);
    if (_equals) {
      LinkedHashMap<String, AttributesDescriptor> _newLinkedHashMap = CollectionLiterals.<String, AttributesDescriptor>newLinkedHashMap();
      this.name2attributes = _newLinkedHashMap;
      final DefaultHighlightingConfiguration.IHighlightingStyleAcceptor _function = new DefaultHighlightingConfiguration.IHighlightingStyleAcceptor() {
        @Override
        public TextAttributesKey addStyle(final String simpleStyleName, final String displayName, final TextAttributesKey fallbackKey) {
          final TextAttributesKey textAttributesKey = TextAttributesKey.createTextAttributesKey(((DefaultHighlightingConfiguration.this.languageId + ".") + simpleStyleName), fallbackKey);
          final AttributesDescriptor attributeDescriptor = new AttributesDescriptor(displayName, textAttributesKey);
          DefaultHighlightingConfiguration.this.name2attributes.put(simpleStyleName, attributeDescriptor);
          return textAttributesKey;
        }
      };
      this.configure(_function);
    }
  }
  
  @Override
  public TextAttributesKey getTextAttributesKey(final String xtextStyle) {
    TextAttributesKey _xblockexpression = null;
    {
      this.initialize();
      AttributesDescriptor _get = this.name2attributes.get(xtextStyle);
      TextAttributesKey _key = null;
      if (_get!=null) {
        _key=_get.getKey();
      }
      _xblockexpression = _key;
    }
    return _xblockexpression;
  }
  
  @Override
  public Iterable<AttributesDescriptor> getAttributeDescriptors() {
    Collection<AttributesDescriptor> _xblockexpression = null;
    {
      this.initialize();
      _xblockexpression = this.name2attributes.values();
    }
    return _xblockexpression;
  }
  
  /**
   * Override this to register your own styles.
   * 
   * Good fallback styles can be found in {@link DefaultLanguageHighlighterColors}, {@link CodeInsightColors},
   * {@link com.intellij.openapi.editor.colors.EditorColors} or {@link com.intellij.ide.highlighter.JavaHighlightingColors}.
   */
  protected void configure(final DefaultHighlightingConfiguration.IHighlightingStyleAcceptor it) {
    it.addStyle(HighlightingStyles.KEYWORD_ID, "Keyword", DefaultLanguageHighlighterColors.KEYWORD);
    it.addStyle(HighlightingStyles.PUNCTUATION_ID, "Punctuation", DefaultLanguageHighlighterColors.DOT);
    it.addStyle(HighlightingStyles.COMMENT_ID, "Comment", DefaultLanguageHighlighterColors.LINE_COMMENT);
    it.addStyle(HighlightingStyles.STRING_ID, "String", DefaultLanguageHighlighterColors.STRING);
    it.addStyle(HighlightingStyles.NUMBER_ID, "Number", DefaultLanguageHighlighterColors.NUMBER);
    it.addStyle(HighlightingStyles.DEFAULT_ID, "Default", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR);
    it.addStyle(HighlightingStyles.INVALID_TOKEN_ID, "Error", CodeInsightColors.ERRORS_ATTRIBUTES);
    it.addStyle(HighlightingStyles.TASK_ID, "Todo", CodeInsightColors.TODO_DEFAULT_ATTRIBUTES);
  }
}
