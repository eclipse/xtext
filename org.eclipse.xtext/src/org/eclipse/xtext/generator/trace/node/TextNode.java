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
 * A text node is a <em>leaf</em> in the code generator tree and produces arbitrary text.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class TextNode implements IGeneratorNode {
	private CharSequence text;

	public TextNode(CharSequence text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " \"" + Strings.convertToJavaString(text.toString()) + "\"";
	}

	public CharSequence getText() {
		return text;
	}

	public void setText(CharSequence text) {
		this.text = text;
	}
}
