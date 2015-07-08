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
import org.eclipse.xtext.util.TextRegion

/**
 * @author kosyakov - Initial contribution and API
 */
@Accessors
abstract class AbstractIndentableAutoEditBlock extends AbstractAutoEditBlock {

	val String indentationTerminal
	val boolean nested

	new(String openingTerminal, String closingTerminal) {
		this(openingTerminal, closingTerminal, false)
	}

	new(String openingTerminal, String closingTerminal, boolean nested) {
		this(openingTerminal, null, closingTerminal, nested)
	}

	new(String openingTerminal, String indentationTerminal, String closingTerminal) {
		this(openingTerminal, indentationTerminal, closingTerminal, false)
	}

	new(String openingTerminal, String indentationTerminal, String closingTerminal, boolean nested) {
		super(openingTerminal, closingTerminal)
		this.indentationTerminal = indentationTerminal
		this.nested = nested
	}

	protected def getIndentationTerminal() {
		if (indentationTerminal == null)
			// TODO: should be configurable
			return '\t'
		return indentationTerminal
	}

	abstract def AutoEditBlockRegion findRegion(extension AutoEditContext context)

	abstract def String indent(AutoEditBlockRegion region, String previousLineIndentation, extension AutoEditContext context)

}

@Accessors
@FinalFieldsConstructor
class AutoEditBlockRegion {
	val AbstractIndentableAutoEditBlock block
	val TextRegion openingTerminal
	val TextRegion closingTerminal
}