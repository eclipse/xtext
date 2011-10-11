/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.example.arithmetics.arithmetics.DeclaredParameter;
import org.eclipse.xtext.example.arithmetics.ui.contentassist.AbstractArithmeticsProposalProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import com.google.common.base.Function;

/**
 * @author Sven Efftinge - initial contribution and API
 *
 */
public class ArithmeticsProposalProvider extends AbstractArithmeticsProposalProvider {
	
	
	/**
	 * sets the selection on the arguments for proposed functions.
	 */
	@Override
	public void completePrimaryExpression_Func(EObject model,
			Assignment assignment, ContentAssistContext context,
			final ICompletionProposalAcceptor acceptor) {
		super.completePrimaryExpression_Func(model, assignment, context, new ICompletionProposalAcceptor.Delegate(acceptor) {

			public void accept(ICompletionProposal proposal) {
				if (proposal instanceof ConfigurableCompletionProposal) {
					ConfigurableCompletionProposal ccp = (ConfigurableCompletionProposal) proposal;
					String string = ccp.getReplacementString();
					int indexOfOpenPar = string.indexOf('(');
					if (indexOfOpenPar!=-1) {
						int oldSelectionStart = ccp.getSelectionStart();
						ccp.setSelectionStart(oldSelectionStart-string.length()+indexOfOpenPar+1);
						ccp.setSelectionLength(oldSelectionStart-ccp.getSelectionStart()-1);
					}
				}
				super.accept(proposal);
			}

		});
	}
	
	@Override
	protected String getDisplayString(EObject element,
			String qualifiedNameAsString, String shortName) {
		if (element instanceof DeclaredParameter)
			return shortName;
		return super.getDisplayString(element, qualifiedNameAsString, shortName);
	}
	
	@Override
	protected Function<IEObjectDescription, ICompletionProposal> getProposalFactory(
			String ruleName, ContentAssistContext contentAssistContext) {
		// hackish: ignore concrete syntax constraints since we export functions with parenths
		return super.getProposalFactory(null, contentAssistContext);
	}
}
