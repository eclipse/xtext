/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace.node;

import org.eclipse.xtext.util.Strings;

/**
 * A new line node is a <em>leaf</em> in the code generator tree and produces line breaks.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class NewLineNode implements IGeneratorNode {
	private String lineDelimiter;

	/**
	 * When this is set to {@code true}, the preceding line is removed if it contains only whitespace.
	 */
	private boolean ifNotEmpty;

	public NewLineNode(String lineDelimiter) {
		this(lineDelimiter, false);
	}

	public NewLineNode(String lineDelimiter, boolean ifNotEmpty) {
		if (lineDelimiter == null) {
			throw new NullPointerException();
		}
		this.lineDelimiter = lineDelimiter;
		this.ifNotEmpty = ifNotEmpty;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " \"" + Strings.convertToJavaString(lineDelimiter) + "\"";
		if (ifNotEmpty) {
			result = result + " if not empty";
		}
		return result;
	}

	public String getLineDelimiter() {
		return lineDelimiter;
	}

	public void setLineDelimiter(String lineDelimiter) {
		this.lineDelimiter = lineDelimiter;
	}

	public boolean isIfNotEmpty() {
		return ifNotEmpty;
	}

	public void setIfNotEmpty(boolean ifNotEmpty) {
		this.ifNotEmpty = ifNotEmpty;
	}
}
