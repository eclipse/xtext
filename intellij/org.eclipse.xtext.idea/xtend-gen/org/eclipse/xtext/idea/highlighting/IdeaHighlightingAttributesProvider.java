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
import com.intellij.codeInsight.daemon.impl.HighlightInfoType;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @noextend
 * @noreference
 */
@Singleton
@Log
@SuppressWarnings("all")
public class IdeaHighlightingAttributesProvider {
  @Inject
  @Named(Constants.LANGUAGE_NAME)
  private String languageId;
  
  @Inject
  private IHighlightingConfiguration highlightingConfiguration;
  
  private List<AttributesDescriptor> attributesDescriptors;
  
  private Map<String, HighlightInfoType> name2highlightInfoType;
  
  private void initialize() {
    boolean _equals = Objects.equal(this.attributesDescriptors, null);
    if (_equals) {
      ArrayList<AttributesDescriptor> _newArrayList = CollectionLiterals.<AttributesDescriptor>newArrayList();
      this.attributesDescriptors = _newArrayList;
      HashMap<String, HighlightInfoType> _newHashMap = CollectionLiterals.<String, HighlightInfoType>newHashMap();
      this.name2highlightInfoType = _newHashMap;
      final IHighlightingConfiguration.IHighlightingStyleAcceptor _function = new IHighlightingConfiguration.IHighlightingStyleAcceptor() {
        @Override
        public TextAttributesKey addStyle(final String simpleStyleName, final String displayName, final TextAttributesKey fallbackKey) {
          final TextAttributesKey textAttributesKey = TextAttributesKey.createTextAttributesKey(((IdeaHighlightingAttributesProvider.this.languageId + ".") + simpleStyleName), fallbackKey);
          final AttributesDescriptor attributeDescriptor = new AttributesDescriptor(displayName, textAttributesKey);
          IdeaHighlightingAttributesProvider.this.attributesDescriptors.add(attributeDescriptor);
          HighlightInfoType.HighlightInfoTypeImpl _highlightInfoTypeImpl = new HighlightInfoType.HighlightInfoTypeImpl(HighlightInfoType.SYMBOL_TYPE_SEVERITY, textAttributesKey);
          IdeaHighlightingAttributesProvider.this.name2highlightInfoType.put(simpleStyleName, _highlightInfoTypeImpl);
          return textAttributesKey;
        }
      };
      this.highlightingConfiguration.configure(_function);
    }
  }
  
  public HighlightInfoType getHighlightInfoType(final String xtextStyle) {
    HighlightInfoType _xblockexpression = null;
    {
      this.initialize();
      HighlightInfoType _elvis = null;
      HighlightInfoType _get = this.name2highlightInfoType.get(xtextStyle);
      if (_get != null) {
        _elvis = _get;
      } else {
        HighlightInfoType.HighlightInfoTypeImpl _xblockexpression_1 = null;
        {
          IdeaHighlightingAttributesProvider.LOG.error((("Highlighting style " + xtextStyle) + " has not been registered."));
          final HighlightInfoType.HighlightInfoTypeImpl newHighlightingInfoType = new HighlightInfoType.HighlightInfoTypeImpl(HighlightInfoType.SYMBOL_TYPE_SEVERITY, DefaultLanguageHighlighterColors.LINE_COMMENT);
          this.name2highlightInfoType.put(xtextStyle, newHighlightingInfoType);
          _xblockexpression_1 = newHighlightingInfoType;
        }
        _elvis = _xblockexpression_1;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  public TextAttributesKey getTextAttributesKey(final String xtextStyle) {
    HighlightInfoType _highlightInfoType = this.getHighlightInfoType(xtextStyle);
    TextAttributesKey _attributesKey = null;
    if (_highlightInfoType!=null) {
      _attributesKey=_highlightInfoType.getAttributesKey();
    }
    return _attributesKey;
  }
  
  public Iterable<AttributesDescriptor> getAttributesDescriptors() {
    List<AttributesDescriptor> _xblockexpression = null;
    {
      this.initialize();
      _xblockexpression = this.attributesDescriptors;
    }
    return _xblockexpression;
  }
  
  private final static Logger LOG = Logger.getLogger(IdeaHighlightingAttributesProvider.class);
}
