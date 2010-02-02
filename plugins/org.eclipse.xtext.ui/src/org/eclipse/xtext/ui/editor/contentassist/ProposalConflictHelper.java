/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.jface.text.Region;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class ProposalConflictHelper implements IProposalConflictHelper {
	
	public boolean existsConflict(String proposal, ContentAssistContext context) {
		// hidden node between lastCompleteNode and currentNode?
		AbstractNode lastCompleteNode = context.getLastCompleteNode();
		Region replaceRegion = context.getReplaceRegion();
		int nodeEnd = lastCompleteNode.getOffset() + lastCompleteNode.getLength();
		if (nodeEnd < replaceRegion.getOffset())
			return false;
		
		return existsConflict(lastCompleteNode, replaceRegion.getOffset(), proposal);
	}
	
	public abstract boolean existsConflict(String lastCompleteText, String proposal);

	public boolean existsConflict(AbstractNode lastCompleteNode, int offset, String proposal) {
		String lastCompleteText = lastCompleteNode.serialize();
		lastCompleteText = lastCompleteText.substring(0, offset - lastCompleteNode.getTotalOffset());
		if (Strings.isEmpty(lastCompleteText))
			return false;
		return existsConflict(lastCompleteText, proposal);
	}
	
}
