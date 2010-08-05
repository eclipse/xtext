/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider.IScopableTypesProposalProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypesProposalProvider implements IScopableTypesProposalProvider {

	public void createTypeProposals(ICompletionProposalFactory proposalFactory, ContentAssistContext context, 
			ICompletionProposalAcceptor acceptor) {
		createTypeProposals(proposalFactory, context, TypeMatchFilters.all(), acceptor);
	}
	
	public void createSubTypeProposals(JvmType superType, ICompletionProposalFactory proposalFactory,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		createSubTypeProposals(superType, proposalFactory, context, TypeMatchFilters.all(), acceptor);
	}
	
	public ITypesProposalProvider getScopedProposalProvider(EObject context, IScope scope) {
		throw new UnsupportedOperationException("IScopableTypesProposalProvider.getScopedProposalProvider");
	}

}
