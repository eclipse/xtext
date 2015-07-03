/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public interface TokenSetProvider {
  public abstract TokenSet getTokenSet(final EditorEx editor, final int offset);
  
  public abstract TokenSet getTokenSet(final IElementType tokenType);
  
  public abstract TokenSet getStringLiteralTokens();
  
  public abstract boolean isStartOfLine(final EditorEx editor, final int offset);
  
  public abstract boolean isStartOfLine(final TokenSet tokenSet, final EditorEx editor, final int offset);
  
  public abstract boolean isEndOfLine(final EditorEx editor, final int offset);
  
  public abstract boolean isEndOfLine(final TokenSet tokenSet, final EditorEx editor, final int offset);
}
