/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.editorActions

import org.eclipse.xtext.idea.editorActions.AutoEditContext
import org.eclipse.xtext.idea.editorActions.AutoEditMultiLineBlock

/**
 * @author kosyakov - Initial contribution and API
 */
class AutoEditMultiLineBlockInRichString extends AutoEditMultiLineBlock {

	new(String openingTerminal, String closingTerminal) {
		super(openingTerminal, closingTerminal)
	}

	new(String openingTerminal, String closingTerminal, boolean nested) {
		super(openingTerminal, null, closingTerminal, nested)
	}

	new(String openingTerminal, String indentationTerminal, String closingTerminal) {
		super(openingTerminal, indentationTerminal, closingTerminal, false)
	}

	new(String openingTerminal, String indentationTerminal, String closingTerminal, boolean nested) {
		super(openingTerminal, indentationTerminal, closingTerminal, nested)
	}

	override protected findOpeningTerminal(int offset, extension AutoEditContext context) {
		val result = super.findOpeningTerminal(offset, context)
		if (result === null)
			return null
		val endOffset = result.offset + result.length
		val textBetween = getText(endOffset, offset)
		if (!textBetween.trim.empty)
			return null
		return result
	}

}