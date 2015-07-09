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
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightInfoType.HighlightInfoTypeImpl
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import java.util.Map
import org.eclipse.xtext.Constants
import java.util.List
import org.eclipse.xtext.util.internal.Log
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @noextend
 * @noreference
 */
@Singleton
@Log
class IdeaHighlightingAttributesProvider {
	
	@Inject @Named(Constants.LANGUAGE_NAME) String languageId
	 
	@Inject IHighlightingConfiguration highlightingConfiguration

	List<AttributesDescriptor> attributesDescriptors
	
	Map<String, HighlightInfoType> name2highlightInfoType
	
	private def void initialize() {
		if(attributesDescriptors == null) {
			attributesDescriptors = newArrayList
			name2highlightInfoType = newHashMap
			highlightingConfiguration.configure [ simpleStyleName, displayName, fallbackKey |
				val textAttributesKey = TextAttributesKey.createTextAttributesKey(languageId + '.' + simpleStyleName, fallbackKey)
				val attributeDescriptor = new AttributesDescriptor(displayName, textAttributesKey)
				attributesDescriptors.add(attributeDescriptor)
				name2highlightInfoType.put(simpleStyleName, new HighlightInfoTypeImpl(HighlightInfoType.SYMBOL_TYPE_SEVERITY, textAttributesKey))
				return textAttributesKey
			]
		}
	}
	
	def HighlightInfoType getHighlightInfoType(String xtextStyle) {
		initialize
		name2highlightInfoType.get(xtextStyle) ?: {
			org.eclipse.xtext.idea.highlighting.IdeaHighlightingAttributesProvider.LOG.error('Highlighting style ' + xtextStyle + ' has not been registered.')
			val newHighlightingInfoType = new HighlightInfoTypeImpl(HighlightInfoType.SYMBOL_TYPE_SEVERITY, DefaultLanguageHighlighterColors.LINE_COMMENT)
			name2highlightInfoType.put(xtextStyle, newHighlightingInfoType)
			newHighlightingInfoType
		}
		
	}
	
	def TextAttributesKey getTextAttributesKey(String xtextStyle) {
		xtextStyle.highlightInfoType?.attributesKey
	}
	
	def Iterable<AttributesDescriptor> getAttributesDescriptors() {
		initialize
		attributesDescriptors
	}
}