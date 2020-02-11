/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist

import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry

/**
 * @noreference
 */
interface IIdeContentProposalAcceptor {
	
	/**
	 * Handle the given content assist entry. The entry may be {@code null}.
	 */
	def void accept(ContentAssistEntry entry, int priority)
	
	def boolean canAcceptMoreProposals()
	
}
