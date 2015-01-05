/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.bracketmatching;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.jface.text.source.ICharacterPairMatcherExtension;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtext.ide.editor.bracketmatching.BracePair;
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class BracePairMatcher implements ICharacterPairMatcher, ICharacterPairMatcherExtension {
  @Inject
  private IBracePairProvider bracePairProvider;
  
  @Delegate
  protected ICharacterPairMatcher getICharacterPairMatcher() {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList();
    final DefaultCharacterPairMatcher _result;
    synchronized (_createCache_getICharacterPairMatcher) {
      if (_createCache_getICharacterPairMatcher.containsKey(_cacheKey)) {
        return _createCache_getICharacterPairMatcher.get(_cacheKey);
      }
      DefaultCharacterPairMatcher _xblockexpression = null;
      {
        final ArrayList<Character> chars = CollectionLiterals.<Character>newArrayList();
        Collection<BracePair> _pairs = this.bracePairProvider.getPairs();
        for (final BracePair pair : _pairs) {
          boolean _and = false;
          String _leftBrace = pair.getLeftBrace();
          int _length = _leftBrace.length();
          boolean _equals = (_length == 1);
          if (!_equals) {
            _and = false;
          } else {
            String _rightBrace = pair.getRightBrace();
            int _length_1 = _rightBrace.length();
            boolean _equals_1 = (_length_1 == 1);
            _and = _equals_1;
          }
          if (_and) {
            String _leftBrace_1 = pair.getLeftBrace();
            char _charAt = _leftBrace_1.charAt(0);
            chars.add(Character.valueOf(_charAt));
            String _rightBrace_1 = pair.getRightBrace();
            char _charAt_1 = _rightBrace_1.charAt(0);
            chars.add(Character.valueOf(_charAt_1));
          }
        }
        _xblockexpression = new DefaultCharacterPairMatcher(((char[])Conversions.unwrapArray(chars, char.class)));
      }
      _result = _xblockexpression;
      _createCache_getICharacterPairMatcher.put(_cacheKey, _result);
    }
    _init_getICharacterPairMatcher(_result);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, ICharacterPairMatcher> _createCache_getICharacterPairMatcher = CollectionLiterals.newHashMap();
  
  private void _init_getICharacterPairMatcher(final DefaultCharacterPairMatcher it) {
  }
  
  @Delegate
  protected ICharacterPairMatcherExtension getICharacterPairMatcherExtension() {
    final ICharacterPairMatcher characterPairMatcher = this.getICharacterPairMatcher();
    if ((characterPairMatcher instanceof ICharacterPairMatcherExtension)) {
      return ((ICharacterPairMatcherExtension)characterPairMatcher);
    }
    return null;
  }
  
  public void clear() {
    this.getICharacterPairMatcher().clear();
  }
  
  public void dispose() {
    this.getICharacterPairMatcher().dispose();
  }
  
  public int getAnchor() {
    return this.getICharacterPairMatcher().getAnchor();
  }
  
  public IRegion match(final IDocument document, final int offset) {
    return this.getICharacterPairMatcher().match(document, offset);
  }
  
  public IRegion findEnclosingPeerCharacters(final IDocument document, final int offset, final int length) {
    return this.getICharacterPairMatcherExtension().findEnclosingPeerCharacters(document, offset, length);
  }
  
  public boolean isMatchedChar(final char ch) {
    return this.getICharacterPairMatcherExtension().isMatchedChar(ch);
  }
  
  public boolean isMatchedChar(final char ch, final IDocument document, final int offset) {
    return this.getICharacterPairMatcherExtension().isMatchedChar(ch, document, offset);
  }
  
  public boolean isRecomputationOfEnclosingPairRequired(final IDocument document, final IRegion currentSelection, final IRegion previousSelection) {
    return this.getICharacterPairMatcherExtension().isRecomputationOfEnclosingPairRequired(document, currentSelection, previousSelection);
  }
  
  public IRegion match(final IDocument document, final int offset, final int length) {
    return this.getICharacterPairMatcherExtension().match(document, offset, length);
  }
}
