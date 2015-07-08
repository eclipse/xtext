/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.psi.tree.TokenSet;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtext.ide.editor.bracketmatching.BracePair;
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.idea.editorActions.AbstractAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AbstractIndentableAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AutoEditBlockProvider;
import org.eclipse.xtext.idea.editorActions.AutoEditMultiLineBlock;
import org.eclipse.xtext.idea.editorActions.AutoEditString;
import org.eclipse.xtext.idea.editorActions.TokenSetProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultAutoEditBlockProvider implements AutoEditBlockProvider {
  @Inject
  private IBracePairProvider bracePairProvider;
  
  @Inject
  @Extension
  private TokenSetProvider tokenSetProvider;
  
  @Override
  public Iterable<AbstractAutoEditBlock> getQuotes() {
    TokenSet _stringLiteralTokens = this.tokenSetProvider.getStringLiteralTokens();
    AutoEditString _autoEditString = new AutoEditString("\"", _stringLiteralTokens);
    TokenSet _stringLiteralTokens_1 = this.tokenSetProvider.getStringLiteralTokens();
    AutoEditString _autoEditString_1 = new AutoEditString("\'", _stringLiteralTokens_1);
    return Collections.<AbstractAutoEditBlock>unmodifiableList(CollectionLiterals.<AbstractAutoEditBlock>newArrayList(_autoEditString, _autoEditString_1));
  }
  
  @Override
  public Iterable<AbstractIndentableAutoEditBlock> getBlocks(final TokenSet tokenSet) {
    Iterable<AbstractIndentableAutoEditBlock> _xblockexpression = null;
    {
      final AutoEditMultiLineBlock multiLineCommentBlock = new AutoEditMultiLineBlock("/*", " * ", " */");
      Iterable<AbstractIndentableAutoEditBlock> _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        TokenSet _singleLineCommentTokens = this.tokenSetProvider.getSingleLineCommentTokens();
        if (Objects.equal(tokenSet, _singleLineCommentTokens)) {
          _matched=true;
          _switchResult = CollectionLiterals.<AbstractIndentableAutoEditBlock>emptyList();
        }
      }
      if (!_matched) {
        TokenSet _commentTokens = this.tokenSetProvider.getCommentTokens();
        if (Objects.equal(tokenSet, _commentTokens)) {
          _matched=true;
          _switchResult = Collections.<AbstractIndentableAutoEditBlock>unmodifiableList(CollectionLiterals.<AbstractIndentableAutoEditBlock>newArrayList(multiLineCommentBlock));
        }
      }
      if (!_matched) {
        Set<BracePair> _pairs = this.bracePairProvider.getPairs();
        final Function1<BracePair, AutoEditMultiLineBlock> _function = new Function1<BracePair, AutoEditMultiLineBlock>() {
          @Override
          public AutoEditMultiLineBlock apply(final BracePair it) {
            String _leftBrace = it.getLeftBrace();
            String _rightBrace = it.getRightBrace();
            boolean _isStructural = it.isStructural();
            return new AutoEditMultiLineBlock(_leftBrace, null, _rightBrace, _isStructural);
          }
        };
        Iterable<AutoEditMultiLineBlock> _map = IterableExtensions.<BracePair, AutoEditMultiLineBlock>map(_pairs, _function);
        _switchResult = Iterables.<AbstractIndentableAutoEditBlock>concat(_map, Collections.<AutoEditMultiLineBlock>unmodifiableList(CollectionLiterals.<AutoEditMultiLineBlock>newArrayList(multiLineCommentBlock)));
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
