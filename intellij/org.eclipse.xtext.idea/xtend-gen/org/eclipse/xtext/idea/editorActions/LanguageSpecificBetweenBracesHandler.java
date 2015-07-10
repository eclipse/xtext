/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.codeInsight.editorActions.enter.EnterBetweenBracesHandler;
import java.util.Set;
import org.eclipse.xtext.ide.editor.bracketmatching.BracePair;
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class LanguageSpecificBetweenBracesHandler extends EnterBetweenBracesHandler {
  @Inject
  private IBracePairProvider bracePairProvider;
  
  @Override
  protected boolean isBracePair(final char c1, final char c2) {
    Set<BracePair> _pairs = this.bracePairProvider.getPairs();
    final Function1<BracePair, Boolean> _function = new Function1<BracePair, Boolean>() {
      @Override
      public Boolean apply(final BracePair it) {
        boolean _and = false;
        String _leftBrace = it.getLeftBrace();
        int _length = _leftBrace.length();
        boolean _equals = (_length == 1);
        if (!_equals) {
          _and = false;
        } else {
          String _rightBrace = it.getRightBrace();
          int _length_1 = _rightBrace.length();
          boolean _equals_1 = (_length_1 == 1);
          _and = _equals_1;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<BracePair> _filter = IterableExtensions.<BracePair>filter(_pairs, _function);
    final Function1<BracePair, Boolean> _function_1 = new Function1<BracePair, Boolean>() {
      @Override
      public Boolean apply(final BracePair it) {
        boolean _and = false;
        String _leftBrace = it.getLeftBrace();
        char _charAt = _leftBrace.charAt(0);
        boolean _equals = (_charAt == c1);
        if (!_equals) {
          _and = false;
        } else {
          String _rightBrace = it.getRightBrace();
          char _charAt_1 = _rightBrace.charAt(0);
          boolean _equals_1 = (_charAt_1 == c2);
          _and = _equals_1;
        }
        return Boolean.valueOf(_and);
      }
    };
    return IterableExtensions.<BracePair>exists(_filter, _function_1);
  }
}
