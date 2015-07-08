/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.highlighting

import com.google.inject.Inject
import com.google.inject.Singleton
import com.google.inject.name.Named
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.CodeInsightColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import java.util.Map
import org.eclipse.xtext.Constants
import static org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
class DefaultHighlightingConfiguration implements IHighlightingConfiguration {
	
	@Inject @Named(Constants.LANGUAGE_NAME) String languageId
	 
	Map<String, AttributesDescriptor> name2attributes

	private def initialize() {
		if(name2attributes == null) {
			name2attributes = newLinkedHashMap
			configure [ simpleStyleName, displayName, fallbackKey |
				val textAttributesKey = TextAttributesKey.createTextAttributesKey(languageId + '.' + simpleStyleName, fallbackKey)
				val attributeDescriptor = new AttributesDescriptor(displayName, textAttributesKey)
				name2attributes.put(simpleStyleName, attributeDescriptor)
				return textAttributesKey
			]
		}
	}
	
	override getTextAttributesKey(String xtextStyle) {
		initialize
		name2attributes.get(xtextStyle)?.key
	}
	
	override getAttributeDescriptors() {
		initialize
		name2attributes.values
	}

	/** 
	 * Override this to register your own styles.
	 * 
	 * Good fallback styles can be found in {@link DefaultLanguageHighlighterColors}, {@link CodeInsightColors},
	 * {@link com.intellij.openapi.editor.colors.EditorColors} or {@link com.intellij.ide.highlighter.JavaHighlightingColors}.
	 */
	protected def void configure(IHighlightingStyleAcceptor it) {
		addStyle(KEYWORD_ID, "Keyword", DefaultLanguageHighlighterColors.KEYWORD) 
		addStyle(PUNCTUATION_ID, "Punctuation", DefaultLanguageHighlighterColors.DOT)
		addStyle(COMMENT_ID, "Comment", DefaultLanguageHighlighterColors.LINE_COMMENT)
		addStyle(STRING_ID, "String", DefaultLanguageHighlighterColors.STRING)
		addStyle(NUMBER_ID, "Number", DefaultLanguageHighlighterColors.NUMBER)
		addStyle(DEFAULT_ID, "Default", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR)
		addStyle(INVALID_TOKEN_ID, "Error", CodeInsightColors.ERRORS_ATTRIBUTES)
		addStyle(TASK_ID, "Todo", CodeInsightColors.TODO_DEFAULT_ATTRIBUTES)
	}
	
	static interface IHighlightingStyleAcceptor {
		def TextAttributesKey addStyle(String xtextStyleId, String displayName, TextAttributesKey fallbackKey)
	}
	
}