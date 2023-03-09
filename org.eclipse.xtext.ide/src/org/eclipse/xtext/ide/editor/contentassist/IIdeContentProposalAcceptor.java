/*******************************************************************************
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist;

/**
 * @noreference
 */
public interface IIdeContentProposalAcceptor {
	
	/**
	 * Handle the given content assist entry. The entry may be {@code null}.
	 */
	void accept(ContentAssistEntry entry, int priority);
	
	boolean canAcceptMoreProposals();
	
	/**
	 * If the acceptor accepted all proposals.
	 * 
	 * @since 2.29
	 */
	default boolean didAcceptAllProposals() {
		// this default implementation will be accurate for all cases but the one
		// where the acceptor accepted all proposals so far but should reject another one
		return canAcceptMoreProposals();
	}
	
}
