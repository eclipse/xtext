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
@FinalFieldsConstructor
class AutoEditBlock {
	val String openingTerminal
	val String indentationTerminal
	val String closingTerminal
	val boolean nested

	new(String openingTerminal, String indentationTerminal, String closingTerminal) {
		this(openingTerminal, indentationTerminal, closingTerminal, false)
	}
}

@Accessors
@FinalFieldsConstructor
class AutoEditBlockRegion {
	val AutoEditBlock block
	val TextRegion openingTerminal
	val TextRegion closingTerminal
}