/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.Strings

/**
 * A text node is a <em>leaf</em> in the code generator tree and produces arbitrary text.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors
class TextNode implements IGeneratorNode {
	
	CharSequence text
	
	new(CharSequence text) {
		this.text = text
	}
	
	override toString() {
		'''«class.simpleName» "«Strings.convertToJavaString(text.toString)»"'''
	}
	
}