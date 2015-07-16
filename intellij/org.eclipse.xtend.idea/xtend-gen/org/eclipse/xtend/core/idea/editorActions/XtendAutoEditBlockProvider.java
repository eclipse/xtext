/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.editorActions;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.psi.tree.TokenSet;
import java.util.Collections;
import org.eclipse.xtend.core.idea.editorActions.AutoEditMultiLineBlockInRichString;
import org.eclipse.xtend.core.idea.editorActions.XtendTokenSetProvider;
import org.eclipse.xtext.idea.editorActions.AbstractAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AbstractIndentableAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AutoEditMultiLineBlock;
import org.eclipse.xtext.idea.editorActions.AutoEditString;
import org.eclipse.xtext.idea.editorActions.DefaultAutoEditBlockProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class XtendAutoEditBlockProvider extends DefaultAutoEditBlockProvider {
  @Inject
  @Extension
  private XtendTokenSetProvider tokenSetProvider;
  
  @Override
  public Iterable<AbstractAutoEditBlock> getQuotes() {
    TokenSet _richStringLiteralTokens = this.tokenSetProvider.getRichStringLiteralTokens();
    AutoEditString _autoEditString = new AutoEditString("\'\'\'", _richStringLiteralTokens);
    TokenSet _stringLiteralTokens = this.tokenSetProvider.getStringLiteralTokens();
    AutoEditString _autoEditString_1 = new AutoEditString("\"", _stringLiteralTokens);
    TokenSet _stringLiteralTokens_1 = this.tokenSetProvider.getStringLiteralTokens();
    AutoEditString _autoEditString_2 = new AutoEditString("\'", _stringLiteralTokens_1);
    return Collections.<AbstractAutoEditBlock>unmodifiableList(CollectionLiterals.<AbstractAutoEditBlock>newArrayList(_autoEditString, _autoEditString_1, _autoEditString_2));
  }
  
  @Override
  public Iterable<AbstractIndentableAutoEditBlock> getBlocks(final TokenSet tokenSet) {
    TokenSet _richStringLiteralTokens = this.tokenSetProvider.getRichStringLiteralTokens();
    boolean _equals = Objects.equal(tokenSet, _richStringLiteralTokens);
    if (_equals) {
      AutoEditMultiLineBlockInRichString _autoEditMultiLineBlockInRichString = new AutoEditMultiLineBlockInRichString("{", "}");
      AutoEditMultiLineBlock _autoEditMultiLineBlock = new AutoEditMultiLineBlock("«", "»");
      final Procedure1<AutoEditMultiLineBlock> _function = new Procedure1<AutoEditMultiLineBlock>() {
        @Override
        public void apply(final AutoEditMultiLineBlock it) {
          it.setShouldDeleteClosing(true);
          it.setShouldInsertClosingTerminalBeforeDigit(true);
          it.setShouldInsertClosingTerminalBeforeSpecialCharacters(true);
        }
      };
      AutoEditMultiLineBlock _doubleArrow = ObjectExtensions.<AutoEditMultiLineBlock>operator_doubleArrow(_autoEditMultiLineBlock, _function);
      return Collections.<AbstractIndentableAutoEditBlock>unmodifiableList(CollectionLiterals.<AbstractIndentableAutoEditBlock>newArrayList(_autoEditMultiLineBlockInRichString, _doubleArrow));
    }
    return super.getBlocks(tokenSet);
  }
}
