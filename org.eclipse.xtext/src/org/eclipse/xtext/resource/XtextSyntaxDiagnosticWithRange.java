/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.7
 */
public class XtextSyntaxDiagnosticWithRange extends XtextSyntaxDiagnostic {

	private final int offset;
	private final int length;
	private final String[] userData;

	public XtextSyntaxDiagnosticWithRange(INode errorNode, int offset, int length, String[] userData) {
		super(errorNode);
		this.offset = offset;
		this.length = length;
		this.userData = userData;
	}
	
	@Override
	public int getLength() {
		return length;
	}
	
	@Override
	public int getOffset() {
		return offset + getNode().getTotalOffset();
	}
	
	@Override
	public int getLine() {
		int startLine = getNode().getTotalStartLine();
		String text = getNode().getText();
		int result = Strings.countLineBreaks(text, 0, offset) + startLine;
		return result;
	}
	
	@Override
	public String[] getData() {
		return userData;
	}
	
}
