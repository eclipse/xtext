/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.highlighting

import com.google.inject.Inject
import com.intellij.application.options.colors.InspectionColorSettingsPage
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.psi.codeStyle.DisplayPriority
import com.intellij.psi.codeStyle.DisplayPrioritySortable
import java.util.Map
import javax.swing.Icon
import org.eclipse.xtext.idea.Icons

/** 
 * @author dhubner - Initial contribution and API
 * @author Jan Koehnlein
 */
abstract class AbstractColorSettingsPage implements ColorSettingsPage, InspectionColorSettingsPage, DisplayPrioritySortable {

	@Inject SyntaxHighlighter highlighter

	@Inject IdeaHighlightingAttributesProvider textAttributeProvider
	 
	override getAttributeDescriptors() {
		textAttributeProvider.attributesDescriptors
	}
	
	override getHighlighter() {
		highlighter
	}

	override getDemoText() {
		'''
			// change this text in the ColorSettingsPage
			// of your language. See getDemoText() method
			
			abcdefghijklmnopqrstuvwxyz 0123456789 (){}[]
			ABCDEFGHIJKLMNOPQRSTUVWXYZ +-*/= .,;:!? #&$%@|^
			
			Styles:
			  result = "text, text, text";
			  i = 5
			  return i;
		'''
	}

	abstract override String getDisplayName()

	override ColorDescriptor[] getColorDescriptors() {
		return ColorDescriptor.EMPTY_ARRAY
	}

	override Icon getIcon() {
		// TODO use the icons provider, when implemented
		return Icons.DSL_FILE_TYPE
	}

	override Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
		return null
	}

	override DisplayPriority getPriority() {
		return DisplayPriority.LANGUAGE_SETTINGS
	}
}
