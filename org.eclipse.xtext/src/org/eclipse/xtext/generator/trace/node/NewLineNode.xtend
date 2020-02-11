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
 * A new line node is a <em>leaf</em> in the code generator tree and produces line breaks.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors
class NewLineNode implements IGeneratorNode {
	
	String lineDelimiter
	
	/**
	 * When this is set to {@code true}, the preceding line is removed if it contains only whitespace.
	 */
	boolean ifNotEmpty
	
	new(String lineDelimiter) {
		this(lineDelimiter, false)
	}
	
	new(String lineDelimiter, boolean ifNotEmpty) {
		if (lineDelimiter === null)
			throw new NullPointerException
		this.lineDelimiter = lineDelimiter
		this.ifNotEmpty = ifNotEmpty
	}
	
	override toString() {
		'''«class.simpleName» "«Strings.convertToJavaString(lineDelimiter)»"«IF ifNotEmpty» if not empty«ENDIF»'''
	}
	
}