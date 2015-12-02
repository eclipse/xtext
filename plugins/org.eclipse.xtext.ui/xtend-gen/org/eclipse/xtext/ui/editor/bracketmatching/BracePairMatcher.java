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
import java.util.Set;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtext.ide.editor.bracketmatching.BracePair;
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;

/**
 * @author kosyakov - Initial contribution and API
 * 
 * @since 2.8
 */
@SuppressWarnings("all")
public class BracePairMatcher implements ICharacterPairMatcher {
  @Delegate
  private DefaultCharacterPairMatcher characterPairMatcher;
  
  @Inject
  public void setBracePairProvider(final IBracePairProvider bracePairProvider) {
    final ArrayList<Character> chars = this.getChars(bracePairProvider);
    DefaultCharacterPairMatcher _defaultCharacterPairMatcher = new DefaultCharacterPairMatcher(((char[])Conversions.unwrapArray(chars, char.class)));
    this.characterPairMatcher = _defaultCharacterPairMatcher;
  }
  
  protected ArrayList<Character> getChars(final IBracePairProvider bracePairProvider) {
    ArrayList<Character> _xblockexpression = null;
    {
      final ArrayList<Character> chars = CollectionLiterals.<Character>newArrayList();
      Set<BracePair> _pairs = bracePairProvider.getPairs();
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
        } else {
          throw new IllegalStateException((("Brace pair is invalid: " + pair) + "; left and right braces should have length of one character."));
        }
      }
      _xblockexpression = chars;
    }
    return _xblockexpression;
  }
  
  public void clear() {
    this.characterPairMatcher.clear();
  }
  
  public void dispose() {
    this.characterPairMatcher.dispose();
  }
  
  public int getAnchor() {
    return this.characterPairMatcher.getAnchor();
  }
  
  public IRegion match(final IDocument iDocument, final int i) {
    return this.characterPairMatcher.match(iDocument, i);
  }
}
