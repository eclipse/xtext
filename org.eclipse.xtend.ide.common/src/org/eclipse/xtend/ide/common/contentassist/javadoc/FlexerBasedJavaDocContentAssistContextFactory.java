/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.common.contentassist.javadoc;

import org.eclipse.xtend.ide.common.contentassist.antlr.FlexerBasedContentAssistContextFactory;
import org.eclipse.xtext.nodemodel.INode;

public class FlexerBasedJavaDocContentAssistContextFactory extends FlexerBasedContentAssistContextFactory {

	@Override
	public String getPrefix(INode node) {
		if(node != null) {
			int offsetInNode = getCompletionOffset() - node.getOffset();
			String textInFront = node.getText().substring(0, offsetInNode);
			for (int i = offsetInNode - 1; i > 0; i--) {
				char c = textInFront.charAt(i);
				if (Character.isWhitespace(c)) {
					return textInFront.substring(i + 1);
				}
			}
		}
		return "";
	}
}