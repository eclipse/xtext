/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.highlighting

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.lexer.Lexer
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper
import org.eclipse.xtext.idea.parser.TokenTypeProvider

/**
 * @author kosyakov - Initial contribution and API
 */
class DefaultSyntaxHighlighter extends SyntaxHighlighterBase {

	@Inject Provider<Lexer> lexerProvider
	@Inject IdeaHighlightingAttributesProvider textAttributeProvider

	@Inject extension TokenTypeProvider tokenTypeProvider
	@Inject extension AbstractAntlrTokenToAttributeIdMapper tokenToAttributeIdMapper

	override getHighlightingLexer() {
		lexerProvider.get
	}

	override getTokenHighlights(IElementType tokenType) {
		val attribute = tokenType.antlrType.id
		return pack(textAttributeProvider.getTextAttributesKey(attribute))
	}
}