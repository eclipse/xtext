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
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

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
  
  private Map<String, String> xtextStyle2xtextStyleRedirectMap;
  
  protected void initialize() {
    boolean _equals = Objects.equal(this.attributesDescriptors, null);
    if (_equals) {
      ArrayList<AttributesDescriptor> _newArrayList = CollectionLiterals.<AttributesDescriptor>newArrayList();
      this.attributesDescriptors = _newArrayList;
      HashMap<String, HighlightInfoType> _newHashMap = CollectionLiterals.<String, HighlightInfoType>newHashMap();
      this.name2highlightInfoType = _newHashMap;
      HashMap<String, String> _newHashMap_1 = CollectionLiterals.<String, String>newHashMap();
      this.xtextStyle2xtextStyleRedirectMap = _newHashMap_1;
      this.highlightingConfiguration.configure(new IHighlightingConfiguration.IHighlightingStyleAcceptor() {
        @Override
        public TextAttributesKey addStyle(final String xtextStyleId, final String displayName, final TextAttributesKey fallbackKey) {
          HighlightInfoType _addHighlightingConfiguration = IdeaHighlightingAttributesProvider.this.addHighlightingConfiguration(xtextStyleId, displayName, fallbackKey);
          return _addHighlightingConfiguration.getAttributesKey();
        }
        
        @Override
        public void addRedirect(final String fromXtextStyleId, final String toXtextStyleId) {
          boolean _containsKey = IdeaHighlightingAttributesProvider.this.name2highlightInfoType.containsKey(fromXtextStyleId);
          if (_containsKey) {
            IdeaHighlightingAttributesProvider.LOG.error((("Redirected highlighting style " + fromXtextStyleId) + " already registered."));
          }
          String _put = IdeaHighlightingAttributesProvider.this.xtextStyle2xtextStyleRedirectMap.put(fromXtextStyleId, toXtextStyleId);
          boolean _tripleNotEquals = (_put != null);
          if (_tripleNotEquals) {
            IdeaHighlightingAttributesProvider.LOG.error((("Duplicate redirected highlighting style " + fromXtextStyleId) + "."));
          }
        }
      });
    }
  }
  
  protected HighlightInfoType addHighlightingConfiguration(final String simpleStyleName, final String displayName, final TextAttributesKey fallbackKey) {
    final TextAttributesKey textAttributesKey = TextAttributesKey.createTextAttributesKey(((this.languageId + ".") + simpleStyleName), fallbackKey);
    final AttributesDescriptor attributeDescriptor = new AttributesDescriptor(displayName, textAttributesKey);
    this.attributesDescriptors.add(attributeDescriptor);
    final HighlightInfoType.HighlightInfoTypeImpl highlightInfoType = new HighlightInfoType.HighlightInfoTypeImpl(HighlightInfoType.SYMBOL_TYPE_SEVERITY, textAttributesKey);
    this.name2highlightInfoType.put(simpleStyleName, highlightInfoType);
    return highlightInfoType;
  }
  
  public HighlightInfoType getHighlightInfoType(final String xtextStyle) {
    this.initialize();
    String _elvis = null;
    String _get = this.xtextStyle2xtextStyleRedirectMap.get(xtextStyle);
    if (_get != null) {
      _elvis = _get;
    } else {
      _elvis = xtextStyle;
    }
    final String realId = _elvis;
    HighlightInfoType _elvis_1 = null;
    HighlightInfoType _get_1 = this.name2highlightInfoType.get(realId);
    if (_get_1 != null) {
      _elvis_1 = _get_1;
    } else {
      HighlightInfoType _xblockexpression = null;
      {
        IdeaHighlightingAttributesProvider.LOG.error((("Highlighting style " + realId) + " has not been registered."));
        _xblockexpression = this.addHighlightingConfiguration(realId, (realId + " (unregistered) "), DefaultLanguageHighlighterColors.LINE_COMMENT);
      }
      _elvis_1 = _xblockexpression;
    }
    return _elvis_1;
  }
  
  public TextAttributesKey getTextAttributesKey(final String xtextStyle) {
    HighlightInfoType _highlightInfoType = this.getHighlightInfoType(xtextStyle);
    TextAttributesKey _attributesKey = null;
    if (_highlightInfoType!=null) {
      _attributesKey=_highlightInfoType.getAttributesKey();
    }
    return _attributesKey;
  }
  
  public Map<String, TextAttributesKey> getXtextStyle2TextAttributes() {
    Set<Map.Entry<String, HighlightInfoType>> _entrySet = this.name2highlightInfoType.entrySet();
    final Function1<Map.Entry<String, HighlightInfoType>, Pair<String, TextAttributesKey>> _function = new Function1<Map.Entry<String, HighlightInfoType>, Pair<String, TextAttributesKey>>() {
      @Override
      public Pair<String, TextAttributesKey> apply(final Map.Entry<String, HighlightInfoType> it) {
        String _key = it.getKey();
        HighlightInfoType _value = it.getValue();
        TextAttributesKey _attributesKey = _value.getAttributesKey();
        return Pair.<String, TextAttributesKey>of(_key, _attributesKey);
      }
    };
    Iterable<Pair<String, TextAttributesKey>> _map = IterableExtensions.<Map.Entry<String, HighlightInfoType>, Pair<String, TextAttributesKey>>map(_entrySet, _function);
    return CollectionLiterals.<String, TextAttributesKey>newHashMap(((Pair<? extends String, ? extends TextAttributesKey>[])Conversions.unwrapArray(_map, Pair.class)));
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
