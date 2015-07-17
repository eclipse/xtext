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
import com.intellij.psi.tree.TokenSet;
import org.eclipse.xtext.idea.editorActions.AbstractAutoEditBlockProvider;
import org.eclipse.xtext.idea.editorActions.AutoEditString;
import org.eclipse.xtext.idea.editorActions.TokenSetProvider;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class DefaultAutoEditBlockProvider extends AbstractAutoEditBlockProvider {
  @Inject
  public void setTokenSetProvider(@Extension final TokenSetProvider tokenSetProvider) {
    TokenSet _stringLiteralTokens = tokenSetProvider.getStringLiteralTokens();
    AutoEditString _autoEditString = new AutoEditString("\"", _stringLiteralTokens);
    this.registerQuote(_autoEditString);
    TokenSet _stringLiteralTokens_1 = tokenSetProvider.getStringLiteralTokens();
    AutoEditString _autoEditString_1 = new AutoEditString("\'", _stringLiteralTokens_1);
    this.registerQuote(_autoEditString_1);
  }
}
