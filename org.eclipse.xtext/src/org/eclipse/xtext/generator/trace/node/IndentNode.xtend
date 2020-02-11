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

/**
 * An indent node prepends the indentation string to each line that is generated through its children.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors
class IndentNode extends CompositeGeneratorNode {
	
	String indentationString
	
	/**
	 * When this is set to {@code true}, the indentation is always inserted in the first line, otherwise it is
	 * inserted only if the first line has no text preceding this node.
	 */
	boolean indentImmediately
	
	/**
	 * When this is set to {@code true}, all lines are indented, otherwise only lines with text content are indented.
	 */
	boolean indentEmptyLines
	
	new(String indentationString) {
		this(indentationString, true, false)
	}
	
	new(String indentationString, boolean indentImmediately, boolean indentEmptyLines) {
		if (indentationString === null)
			throw new NullPointerException
		this.indentationString = indentationString
		this.indentImmediately = indentImmediately
		this.indentEmptyLines = indentEmptyLines
	}
	
}