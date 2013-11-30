/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.runner;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.xpect.XpectInvocation;
import org.xpect.text.Text;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectTestTitleProvider implements IXpectTestTitleProvider {

	public String getTitle(XpectInvocation invocation) {
		INode node = NodeModelUtils.findActualNodeFor(invocation);
		String document = node.getRootNode().getText();
		String title = findTitle(document, node.getOffset());
		if (title != null && title.startsWith("XPECT"))
			title = null;
		return title;
	}

	protected String findTitle(String documentString, int offset) {
		Text document = new Text(documentString);
		int lineStart = document.currentLineStart(offset);
		if (lineStart > 0) {
			String prefix = document.substring(lineStart, offset);
			String trimmedPrefix = prefix.trim();
			if (trimmedPrefix.length() > 0)
				for (int i = 0; i < trimmedPrefix.length(); i++) {
					char c = trimmedPrefix.charAt(i);
					if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
						return trimmedPrefix;
				}
			int prevLine = document.previousLineStart(offset);
			if (prevLine >= 0) {
				String prevPrefix = document.substring(prevLine, prevLine + prefix.length());
				if (prefix.equals(prevPrefix)) {
					String title = document.substring(prevLine + prefix.length(), lineStart).trim();
					if (title.length() > 0)
						return title;
				}
			}
		}
		return null;
	}

}
