/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import com.google.inject.Inject;
import com.intellij.psi.tree.TokenSet;
import java.util.Collections;
import org.eclipse.xtext.idea.editorActions.AbstractAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AbstractIndentableAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AutoEditBlockProvider;
import org.eclipse.xtext.idea.editorActions.AutoEditString;
import org.eclipse.xtext.idea.editorActions.TokenSetProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultAutoEditBlockProvider implements AutoEditBlockProvider {
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
    return CollectionLiterals.<AbstractIndentableAutoEditBlock>emptyList();
  }
}
