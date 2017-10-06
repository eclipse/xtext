/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;

/**
 * Small utility to extract the parsable content of a document when 
 * content assist is invoked at a given location.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.13
 */
public class CompletionPrefixProvider {

	/**
	 * Standard languages only need to parse the text up to the last hidden token sequence
	 * in the document. Thus the string from start to the normalized offset is sufficient.
	 */
	public String getInputToParse(String completeInput, int offset, int completionOffset) {
		return completeInput.substring(0, offset);
	}
	
	/**
	 * Returns the last node that appears to be part of the prefix. This will be used to determine
	 * the current model object that'll be the most special context instance in the proposal provider.
	 */
	public INode getLastCompleteNodeByOffset(INode node, int offset, int completionOffset) {
		BidiTreeIterator<INode> iterator = node.getRootNode().getAsTreeIterable().iterator();
		INode result = node;
		while (iterator.hasNext()) {
			INode candidate = iterator.next();
			if (candidate.getOffset() >= offset) {
				break;
			} else if ((candidate instanceof ILeafNode) && (candidate.getGrammarElement() == null
					|| candidate.getGrammarElement() instanceof AbstractElement
					|| candidate.getGrammarElement() instanceof ParserRule)) {
				result = candidate;
			}
		}
		return result;
	}
	
}
