/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.jface.text.Region;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * <p>Abstract base implementation of the {@link IProposalConflictHelper} that
 * deals with the node model to extract the previous sibling of the input source.</p>
 * <p>Implementors have to provide the semantics of {@link #existsConflict(String, String, ContentAssistContext)}. 
 * They should consider to extend the 
 * {@link org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper AntlrProposalConflictHelper}.
 * </p>
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class ProposalConflictHelper implements IProposalConflictHelper {
	
	public boolean existsConflict(String proposal, ContentAssistContext context) {
		// hidden node between lastCompleteNode and currentNode?
		INode lastCompleteNode = context.getLastCompleteNode();
		Region replaceRegion = context.getReplaceRegion();
		int nodeEnd = lastCompleteNode.getEndOffset();
		if (nodeEnd < replaceRegion.getOffset())
			return false;
		
		return existsConflict(lastCompleteNode, replaceRegion.getOffset(), proposal, context);
	}
	
	/**
	 * Returns <code>false</code> if the proposal would corrupt the previous
	 * input.
	 * @param lastCompleteText the previous sibling in the input source. Is never <code>null</code> 
	 * but may be empty. However, the implementation of {@link #existsConflict(INode, int, String, ContentAssistContext)}
	 * will not pass empty strings by default but return <code>false</code> instead.
	 * @param proposal a possible proposal string. Is never <code>null</code>.
	 * @param context the current content assist context. Is never <code>null</code>.
	 * @return <code>false</code> if the proposal would corrupt the current input. 
	 */
	public abstract boolean existsConflict(String lastCompleteText, String proposal, ContentAssistContext context);

	public boolean existsConflict(INode lastCompleteNode, int offset, String proposal, ContentAssistContext context) {
		String lastCompleteText = lastCompleteNode.getText();
		lastCompleteText = lastCompleteText.substring(0, offset - lastCompleteNode.getTotalOffset());
		if (Strings.isEmpty(lastCompleteText))
			return false;
		return existsConflict(lastCompleteText, proposal, context);
	}
	
}
