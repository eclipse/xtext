/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;

/**
 * Small utility to extract the parsable content of a document when content assist is invoked at a given location.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.13
 */
public class CompletionPrefixProvider {

	/**
	 * Standard languages only need to parse the text up to the last hidden token sequence in the document. Thus the
	 * string from start to the normalized offset is sufficient.
	 */
	public String getInputToParse(String completeInput, int offset, int completionOffset) {
		return completeInput.substring(0, offset);
	}

	/**
	 * Returns the last node that appears to be part of the prefix. This will be used to determine the current model
	 * object that'll be the most special context instance in the proposal provider.
	 */
	public INode getLastCompleteNodeByOffset(INode node, int offsetPosition, int completionOffset) {
		return internalGetLastCompleteNodeByOffset(node.getRootNode(), offsetPosition);
	}

	private INode internalGetLastCompleteNodeByOffset(ICompositeNode node, int offsetPosition) {
		for (INode child : node.getChildren().reverse()) {
			if (child.getOffset() < offsetPosition) {
				if (child instanceof ICompositeNode) {
					return internalGetLastCompleteNodeByOffset((ICompositeNode) child, offsetPosition);
				} else if ((child instanceof ILeafNode)
						&& (child.getGrammarElement() == null || child.getGrammarElement() instanceof AbstractElement
								|| child.getGrammarElement() instanceof ParserRule)) {
					return child;
				}
			}
		}
		return node;
	}

}
