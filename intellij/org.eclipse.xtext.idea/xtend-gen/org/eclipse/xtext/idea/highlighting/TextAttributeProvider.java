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
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @noextend
 * @noreference
 */
@Singleton
@SuppressWarnings("all")
public class TextAttributeProvider {
  @Inject
  @Named(Constants.LANGUAGE_NAME)
  private String languageId;
  
  @Inject
  private IHighlightingConfiguration highlightingConfiguration;
  
  private Map<String, AttributesDescriptor> name2attributes;
  
  private void initialize() {
    boolean _equals = Objects.equal(this.name2attributes, null);
    if (_equals) {
      LinkedHashMap<String, AttributesDescriptor> _newLinkedHashMap = CollectionLiterals.<String, AttributesDescriptor>newLinkedHashMap();
      this.name2attributes = _newLinkedHashMap;
      final IHighlightingConfiguration.IHighlightingStyleAcceptor _function = new IHighlightingConfiguration.IHighlightingStyleAcceptor() {
        @Override
        public TextAttributesKey addStyle(final String simpleStyleName, final String displayName, final TextAttributesKey fallbackKey) {
          final TextAttributesKey textAttributesKey = TextAttributesKey.createTextAttributesKey(((TextAttributeProvider.this.languageId + ".") + simpleStyleName), fallbackKey);
          final AttributesDescriptor attributeDescriptor = new AttributesDescriptor(displayName, textAttributesKey);
          TextAttributeProvider.this.name2attributes.put(simpleStyleName, attributeDescriptor);
          return textAttributesKey;
        }
      };
      this.highlightingConfiguration.configure(_function);
    }
  }
  
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
  
  public Collection<AttributesDescriptor> getAttributesDescriptors() {
    Collection<AttributesDescriptor> _xblockexpression = null;
    {
      this.initialize();
      _xblockexpression = this.name2attributes.values();
    }
    return _xblockexpression;
  }
}
