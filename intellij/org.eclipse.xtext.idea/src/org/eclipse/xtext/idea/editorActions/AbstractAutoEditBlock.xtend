/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * @author kosyakov - Initial contribution and API
 */
@Accessors
@FinalFieldsConstructor
abstract class AbstractAutoEditBlock {

	val String openingTerminal
	val String closingTerminal

	def void open(char c, extension AutoEditContext context)

	def boolean close(char c, extension AutoEditContext context)

	boolean shouldDeleteClosing = false

	def boolean delete(char c, extension AutoEditContext context) {
		if (!shouldDeleteClosing)
			return false

		if (c != openingTerminal.charAt(0))
			return false

		val beginOffset = caretOffset
		if (beginOffset < 0)
			return false

		val endOffset = beginOffset + closingTerminal.length
		if (endOffset > document.textLength)
			return false

		val s = getText(beginOffset, endOffset)
		if (s != closingTerminal)
			return false

		editor.document.deleteString(beginOffset, endOffset)
		return true
	}

}