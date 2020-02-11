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
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalFactory;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(ITypesProposalProvider.Null.class)
public interface ITypesProposalProvider {

	void createTypeProposals(ICompletionProposalFactory proposalFactory, ContentAssistContext context,
			EReference typeReference, ICompletionProposalAcceptor acceptor);

	void createTypeProposals(ICompletionProposalFactory proposalFactory, ContentAssistContext context,
			EReference typeReference, Filter filter, ICompletionProposalAcceptor acceptor);
	
	void createTypeProposals(ICompletionProposalFactory proposalFactory, ContentAssistContext context,
			EReference typeReference, Filter filter, IValueConverter<String> valueConverter, ICompletionProposalAcceptor acceptor);

	void createSubTypeProposals(JvmType superType, ICompletionProposalFactory proposalFactory,
			ContentAssistContext context, EReference typeReference, ICompletionProposalAcceptor acceptor);

	void createSubTypeProposals(JvmType superType, ICompletionProposalFactory proposalFactory,
			ContentAssistContext context, EReference typeReference, Filter filter, ICompletionProposalAcceptor acceptor);
	
	void createSubTypeProposals(JvmType superType, ICompletionProposalFactory proposalFactory,
			ContentAssistContext context, EReference typeReference, Filter filter, IValueConverter<String> valueConverter, ICompletionProposalAcceptor acceptor);

	interface Filter {
		boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
						char[][] enclosingTypeNames, String path);
		
		/**
		 * @see org.eclipse.jdt.core.search.IJavaSearchConstants
		 * @since 2.0
		 */
		int getSearchFor();
	}
	
	public class Null implements ITypesProposalProvider {

		@Override
		public void createTypeProposals(ICompletionProposalFactory proposalFactory, ContentAssistContext context, 
				EReference typeReference, ICompletionProposalAcceptor acceptor) {
		}
		
		@Override
		public void createTypeProposals(ICompletionProposalFactory proposalFactory, ContentAssistContext context, 
				EReference typeReference, Filter filter, ICompletionProposalAcceptor acceptor) {
		}
		
		@Override
		public void createSubTypeProposals(JvmType superType, ICompletionProposalFactory proposalFactory,
				ContentAssistContext context, EReference typeReference, ICompletionProposalAcceptor acceptor) {
		}

		@Override
		public void createSubTypeProposals(JvmType superType, ICompletionProposalFactory proposalFactory,
				ContentAssistContext context, EReference typeReference, Filter filter, ICompletionProposalAcceptor acceptor) {
		}

		@Override
		public void createTypeProposals(ICompletionProposalFactory proposalFactory, ContentAssistContext context,
				EReference typeReference, Filter filter, IValueConverter<String> valueConverter,
				ICompletionProposalAcceptor acceptor) {
		}

		@Override
		public void createSubTypeProposals(JvmType superType, ICompletionProposalFactory proposalFactory,
				ContentAssistContext context, EReference typeReference, Filter filter,
				IValueConverter<String> valueConverter, ICompletionProposalAcceptor acceptor) {
		}
		
	}
	
}
