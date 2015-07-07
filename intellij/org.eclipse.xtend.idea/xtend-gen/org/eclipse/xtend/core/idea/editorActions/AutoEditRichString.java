/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.editorActions;

import com.google.common.base.Objects;
import com.intellij.psi.tree.TokenSet;
import org.eclipse.xtext.idea.editorActions.AutoEditContext;
import org.eclipse.xtext.idea.editorActions.AutoEditString;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class AutoEditRichString extends AutoEditString {
  private final TokenSet richStringLiteralTokens;
  
  public AutoEditRichString(final TokenSet richStringLiteralTokens) {
    super("\'\'\'");
    this.richStringLiteralTokens = richStringLiteralTokens;
  }
  
  @Override
  protected boolean isStringLiteral(final TokenSet tokenSet, @Extension final AutoEditContext context) {
    return Objects.equal(tokenSet, this.richStringLiteralTokens);
  }
}
