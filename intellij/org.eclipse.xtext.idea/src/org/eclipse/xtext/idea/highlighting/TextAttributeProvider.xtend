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
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import java.util.Map
import org.eclipse.xtext.Constants

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @noextend
 * @noreference
 */
@Singleton
class TextAttributeProvider {
	
	@Inject @Named(Constants.LANGUAGE_NAME) String languageId
	 
	@Inject IHighlightingConfiguration highlightingConfiguration

	Map<String, AttributesDescriptor> name2attributes
	
	private def initialize() {
		if(name2attributes == null) {
			name2attributes = newLinkedHashMap
			highlightingConfiguration.configure [ simpleStyleName, displayName, fallbackKey |
				val textAttributesKey = TextAttributesKey.createTextAttributesKey(languageId + '.' + simpleStyleName, fallbackKey)
				val attributeDescriptor = new AttributesDescriptor(displayName, textAttributesKey)
				name2attributes.put(simpleStyleName, attributeDescriptor)
				return textAttributesKey
			]
		}
	}
	
	def getTextAttributesKey(String xtextStyle) {
		initialize
		name2attributes.get(xtextStyle)?.key
	}
	
	def getAttributesDescriptors() {
		initialize
		name2attributes.values
	}
}