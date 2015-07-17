/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.editorActions;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.psi.tree.TokenSet;
import org.eclipse.xtend.core.idea.editorActions.AutoEditMultiLineBlockInRichString;
import org.eclipse.xtend.core.idea.editorActions.XtendTokenSetProvider;
import org.eclipse.xtext.idea.editorActions.AbstractAutoEditBlockProvider;
import org.eclipse.xtext.idea.editorActions.AutoEditMultiLineBlock;
import org.eclipse.xtext.idea.editorActions.AutoEditString;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class XtendAutoEditBlockProvider extends AbstractAutoEditBlockProvider {
  @Inject
  public void setTokenSetProvider(@Extension final XtendTokenSetProvider tokenSetProvider) {
    TokenSet _richStringLiteralTokens = tokenSetProvider.getRichStringLiteralTokens();
    AutoEditString _autoEditString = new AutoEditString("\'\'\'", _richStringLiteralTokens);
    this.registerQuote(_autoEditString);
    TokenSet _stringLiteralTokens = tokenSetProvider.getStringLiteralTokens();
    AutoEditString _autoEditString_1 = new AutoEditString("\"", _stringLiteralTokens);
    this.registerQuote(_autoEditString_1);
    TokenSet _stringLiteralTokens_1 = tokenSetProvider.getStringLiteralTokens();
    AutoEditString _autoEditString_2 = new AutoEditString("\'", _stringLiteralTokens_1);
    this.registerQuote(_autoEditString_2);
    TokenSet _richStringLiteralTokens_1 = tokenSetProvider.getRichStringLiteralTokens();
    AutoEditMultiLineBlockInRichString _autoEditMultiLineBlockInRichString = new AutoEditMultiLineBlockInRichString("{", "}");
    this.registerBlock(_richStringLiteralTokens_1, _autoEditMultiLineBlockInRichString);
    TokenSet _richStringLiteralTokens_2 = tokenSetProvider.getRichStringLiteralTokens();
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
    this.registerBlock(_richStringLiteralTokens_2, _doubleArrow);
  }
}
