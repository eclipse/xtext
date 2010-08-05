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
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalFactory;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(ITypesProposalProvider.Null.class)
public interface ITypesProposalProvider {

	interface IScopableTypesProposalProvider extends ITypesProposalProvider {
		
		/**
		 * Proposals will be narrowed according to the elements in the given scope. This
		 * allows to be aware of import statements.
		 * @throws UnsupportedOperationException if the implementation does not implement this method.
		 */
		ITypesProposalProvider getScopedProposalProvider(EObject context, IScope scope); 
		
	}
	
	void createTypeProposals(ICompletionProposalFactory proposalFactory, ContentAssistContext context, ICompletionProposalAcceptor acceptor);
	
	void createTypeProposals(ICompletionProposalFactory proposalFactory, ContentAssistContext context, Filter filter, ICompletionProposalAcceptor acceptor);
	
	void createSubTypeProposals(JvmType superType, ICompletionProposalFactory proposalFactory, ContentAssistContext context, ICompletionProposalAcceptor acceptor);
	
	void createSubTypeProposals(JvmType superType, ICompletionProposalFactory proposalFactory, ContentAssistContext context, Filter filter, ICompletionProposalAcceptor acceptor);
	
	interface Filter {
		boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
						char[][] enclosingTypeNames, String path);
	}
	
	public class Null implements ITypesProposalProvider {

		public void createTypeProposals(ICompletionProposalFactory proposalFactory, ContentAssistContext context, 
				ICompletionProposalAcceptor acceptor) {
		}
		
		public void createTypeProposals(ICompletionProposalFactory proposalFactory, ContentAssistContext context, 
				Filter filter, ICompletionProposalAcceptor acceptor) {
		}
		
		public void createSubTypeProposals(JvmType superType, ICompletionProposalFactory proposalFactory,
				ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		}

		public void createSubTypeProposals(JvmType superType, ICompletionProposalFactory proposalFactory,
				ContentAssistContext context, Filter filter, ICompletionProposalAcceptor acceptor) {
		}
		
	}
	
}
