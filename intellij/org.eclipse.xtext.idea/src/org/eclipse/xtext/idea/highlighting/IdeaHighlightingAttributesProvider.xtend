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
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import java.util.List
import java.util.Map
import org.eclipse.xtext.Constants
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration.IHighlightingStyleAcceptor

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
	Map<String, String> xtextStyle2xtextStyleRedirectMap
	
	protected def void initialize() {
		if (attributesDescriptors == null) {
			attributesDescriptors = newArrayList
			name2highlightInfoType = newHashMap
			xtextStyle2xtextStyleRedirectMap = newHashMap
			highlightingConfiguration.configure(new IHighlightingStyleAcceptor() {
				
				override addStyle(String xtextStyleId, String displayName, TextAttributesKey fallbackKey) {
					addHighlightingConfiguration(xtextStyleId, displayName, fallbackKey).attributesKey
				}
				
				override addRedirect(String fromXtextStyleId, String toXtextStyleId) {
					if (name2highlightInfoType.containsKey(fromXtextStyleId)) {
						IdeaHighlightingAttributesProvider.LOG.error('Redirected highlighting style ' + fromXtextStyleId + ' already registered.')
					}
					if (xtextStyle2xtextStyleRedirectMap.put(fromXtextStyleId, toXtextStyleId) !==null) {
						IdeaHighlightingAttributesProvider.LOG.error('Duplicate redirected highlighting style ' + fromXtextStyleId + '.')
					}
				}
				
			})
		}
	}
	
	protected def HighlightInfoType addHighlightingConfiguration(String simpleStyleName, String displayName, TextAttributesKey fallbackKey) {
		val textAttributesKey = TextAttributesKey.createTextAttributesKey(languageId + '.' + simpleStyleName, fallbackKey)
		val attributeDescriptor = new AttributesDescriptor(displayName, textAttributesKey)
		attributesDescriptors.add(attributeDescriptor)
		val highlightInfoType = new HighlightInfoTypeImpl(HighlightInfoType.SYMBOL_TYPE_SEVERITY, textAttributesKey)
		name2highlightInfoType.put(simpleStyleName, highlightInfoType)
		return highlightInfoType
	}
	
	def HighlightInfoType getHighlightInfoType(String xtextStyle) {
		initialize
		val realId = xtextStyle2xtextStyleRedirectMap.get(xtextStyle) ?: xtextStyle
		return name2highlightInfoType.get(realId) ?: {
			IdeaHighlightingAttributesProvider.LOG.error('Highlighting style ' + realId + ' has not been registered.')
			addHighlightingConfiguration(realId, realId + ' (unregistered) ', DefaultLanguageHighlighterColors.LINE_COMMENT)
		}
	}
	
	def TextAttributesKey getTextAttributesKey(String xtextStyle) {
		xtextStyle.highlightInfoType?.attributesKey
	}
	
	def Map<String, TextAttributesKey> getXtextStyle2TextAttributes() {
		newHashMap(name2highlightInfoType.entrySet.map[key -> value.attributesKey])
	}
	
	def Iterable<AttributesDescriptor> getAttributesDescriptors() {
		initialize
		attributesDescriptors
	}
}