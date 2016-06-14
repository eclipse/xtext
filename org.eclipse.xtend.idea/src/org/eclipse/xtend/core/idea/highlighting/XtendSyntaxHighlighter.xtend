/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.highlighting

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles
import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper
import org.eclipse.xtext.idea.highlighting.IdeaHighlightingAttributesProvider
import org.eclipse.xtext.idea.parser.TokenTypeProvider

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtendSyntaxHighlighter extends SyntaxHighlighterBase {
	
	@Inject Provider<XtendHighlightingLexer> lexerProvider
	@Inject IdeaHighlightingAttributesProvider textAttributeProvider

	@Inject extension TokenTypeProvider 
	@Inject extension AbstractAntlrTokenToAttributeIdMapper 

	override getHighlightingLexer() {
		lexerProvider.get
	}

	override getTokenHighlights(IElementType tokenType) {
		val attribute = if(tokenType == XtendHighlightingLexer.GUILLEMET_ELEMENT_TYPE)
				XtendHighlightingStyles.RICH_TEXT_DELIMITER_ID
			else 
				tokenType.antlrType.id
		return pack(textAttributeProvider.getTextAttributesKey(attribute))
	}
}