/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import com.google.inject.ImplementedBy;

/**
 * <p>The {@link IProposalConflictHelper} is used to determine whether a 
 * possible content proposal is in conflict with the previous input.</p>
 * <p>Implementors should consider to extend the 
 * {@link org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper AntlrProposalConflictHelper}.
 * </p>
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(IProposalConflictHelper.NullHelper.class)
public interface IProposalConflictHelper {

	/**
	 * Returns <code>false</code> if the proposal would corrupt the previous
	 * input.
	 * @param proposal a possible proposal string. Is never <code>null</code>.
	 * @param context the current content assist context. Is never <code>null</code>.
	 * @return <code>false</code> if the proposal would corrupt the current input. 
	 */
	boolean existsConflict(String proposal, ContentAssistContext context);

	public static class NullHelper implements IProposalConflictHelper {

		public boolean existsConflict(String proposal, ContentAssistContext context) {
			return false;
		}
		
	}
}