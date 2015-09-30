/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.highlighting

import com.intellij.ide.highlighter.JavaHighlightingColors
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.EditorColors
import org.eclipse.xtext.xbase.idea.highlighting.XbaseHighlightingConfiguration

import static org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtendHighlightingConfiguration extends XbaseHighlightingConfiguration {
	
	override configure(IHighlightingStyleAcceptor it) {
		super.configure(it)
		addStyle(RICH_TEXT_ID, "Template Text", EditorColors.INJECTED_LANGUAGE_FRAGMENT)
		addStyle(RICH_TEXT_DELIMITER_ID, "Template Terminals", DefaultLanguageHighlighterColors.PARENTHESES)
		addStyle(INSIGNIFICANT_TEMPLATE_TEXT, "Insignificant Template Whitespace", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR)
		addRedirect(POTENTIAL_LINE_BREAK, INSIGNIFICANT_TEMPLATE_TEXT)
		addRedirect(SEMANTIC_LINE_BREAK, INSIGNIFICANT_TEMPLATE_TEXT)
		addStyle(ACTIVE_ANNOTATION, "Active Annotation", JavaHighlightingColors.VALID_STRING_ESCAPE)
	}
	
	
}