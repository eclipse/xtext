/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.expectation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.xpect.XpectInvocation;
import org.xpect.util.IRegion;
import org.xpect.util.Region;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AbstractExpectationParser {
	private Pattern pattern = Pattern.compile("((---)|(-->)|(\n))");

	public IRegion claimRegion(XpectInvocation invocation, int paramIndex) {
		INode node = NodeModelUtils.getNode(invocation);
		String document = node.getRootNode().getText();
		Matcher matcher = pattern.matcher(document);
		if (matcher.find(node.getOffset() + node.getLength())) {
			int end = -1;
			int start = -1;
			if (matcher.group().equals("---")) {
				start = document.indexOf("\n", matcher.end()) + 1;
				end = document.indexOf("---", matcher.end());
				end = document.lastIndexOf("\n", end);
			} else if (matcher.group().equals("-->")) {
				start = matcher.end();
				if (Character.isWhitespace(document.charAt(start)))
					start++;
				end = document.indexOf("\n", matcher.end());
			}
			if (start >= 0) {
				if (end <= 0)
					end = document.length();
				return new Region(start, end - start);
			}
		}
		return null;
	}

}
