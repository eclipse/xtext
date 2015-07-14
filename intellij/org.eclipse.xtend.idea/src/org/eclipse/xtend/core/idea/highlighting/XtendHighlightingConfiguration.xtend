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
		addStyle(RICH_TEXT_ID, "Template text", EditorColors.INJECTED_LANGUAGE_FRAGMENT)
		addStyle(RICH_TEXT_DELIMITER_ID, "Template guillemets", DefaultLanguageHighlighterColors.PARENTHESES)
		addStyle(INSIGNIFICANT_TEMPLATE_TEXT, "Insignificant template text", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR)
		addStyle(POTENTIAL_LINE_BREAK, "Potential Line Break (if line is not empty)", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR)
		addStyle(TEMPLATE_LINE_BREAK, "Template Line Break", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR)
		addStyle(ACTIVE_ANNOTATION, "Active Annotation", JavaHighlightingColors.VALID_STRING_ESCAPE)
	}
}