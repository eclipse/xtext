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
	
	override protected configure(IHighlightingStyleAcceptor it) {
		super.configure(it)
		val templateText = addStyle(RICH_TEXT_ID, "Template text", EditorColors.INJECTED_LANGUAGE_FRAGMENT)
		addStyle(RICH_TEXT_DELIMITER_ID, "Template delimiter", DefaultLanguageHighlighterColors.PARENTHESES)
		val insignificantTemplateText = addStyle(INSIGNIFICANT_TEMPLATE_TEXT, "Insignificant Template text", DefaultLanguageHighlighterColors.MARKUP_TAG)
		addStyle(POTENTIAL_LINE_BREAK, "Potential Line Break (if line is not empty)", insignificantTemplateText)
		addStyle(TEMPLATE_LINE_BREAK, "Template Line Break", templateText)
		addStyle(ACTIVE_ANNOTATION, "Active Annotation", JavaHighlightingColors.VALID_STRING_ESCAPE)
	}
}