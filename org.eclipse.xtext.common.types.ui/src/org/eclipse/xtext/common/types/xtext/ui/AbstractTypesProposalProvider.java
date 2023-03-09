/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypesProposalProvider implements ITypesProposalProvider {

	@Override
	public void createTypeProposals(ICompletionProposalFactory proposalFactory, ContentAssistContext context, 
			EReference typeReference, ICompletionProposalAcceptor acceptor) {
		createTypeProposals(proposalFactory, context, typeReference, TypeMatchFilters.and(TypeMatchFilters.isNotInternal(), TypeMatchFilters.isAcceptableByPreference()), acceptor);
	}
	
	@Override
	public void createSubTypeProposals(JvmType superType, ICompletionProposalFactory proposalFactory,
			ContentAssistContext context, EReference typeReference, ICompletionProposalAcceptor acceptor) {
		createSubTypeProposals(superType, proposalFactory, context, typeReference, TypeMatchFilters.and(TypeMatchFilters.isNotInternal(), TypeMatchFilters.isAcceptableByPreference()), acceptor);
	}
	
	@Override
	public void createSubTypeProposals(JvmType superType, ICompletionProposalFactory proposalFactory,
			ContentAssistContext context, EReference typeReference, Filter filter, ICompletionProposalAcceptor acceptor) {
		createSubTypeProposals(superType, proposalFactory, context, typeReference, filter, null, acceptor);
	}
	
	@Override
	public void createTypeProposals(ICompletionProposalFactory proposalFactory, ContentAssistContext context,
			EReference typeReference, Filter filter, ICompletionProposalAcceptor acceptor) {
		createTypeProposals(proposalFactory, context, typeReference, filter, null, acceptor);
	}
	
}
