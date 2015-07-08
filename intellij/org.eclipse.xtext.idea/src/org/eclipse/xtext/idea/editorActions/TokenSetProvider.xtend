/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import com.google.inject.ImplementedBy
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

/**
 * @author kosyakov - Initial contribution and API
 */
@ImplementedBy(DefaultTokenSetProvider)
interface TokenSetProvider {

	def TokenSet getTokenSet(EditorEx editor, int offset)

	def TokenSet getTokenSet(IElementType tokenType)

	def boolean isStartOfLine(EditorEx editor, int offset)

	def boolean isStartOfLine(TokenSet tokenSet, EditorEx editor, int offset)

	def boolean isEndOfLine(EditorEx editor, int offset)

	def boolean isEndOfLine(TokenSet tokenSet, EditorEx editor, int offset)
	
	def TokenSet getCommentTokens()
	
	def TokenSet getSingleLineCommentTokens()
	
	def TokenSet getStringLiteralTokens()

}