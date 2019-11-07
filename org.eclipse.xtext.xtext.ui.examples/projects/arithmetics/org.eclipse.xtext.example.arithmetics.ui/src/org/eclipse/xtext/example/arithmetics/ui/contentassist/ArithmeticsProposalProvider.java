/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * See
 * https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
public class ArithmeticsProposalProvider extends AbstractArithmeticsProposalProvider {
	/**
	 * sets the selection on the arguments for proposed functions.
	 */
	@Override
	public void completePrimaryExpression_Func(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.completePrimaryExpression_Func(model, assignment, context,
				new ICompletionProposalAcceptor.Delegate(acceptor) {
					@Override
					public void accept(ICompletionProposal proposal) {
						if (proposal instanceof ConfigurableCompletionProposal) {
							ConfigurableCompletionProposal configurableCompletionProposal = (ConfigurableCompletionProposal) proposal;
							String string = configurableCompletionProposal.getReplacementString();
							int indexOfOpenPar = string.indexOf(Character.valueOf('(').charValue());
							if (indexOfOpenPar != -1) {
								int oldSelectionStart = configurableCompletionProposal.getSelectionStart();
								int selectionStart = oldSelectionStart - string.length() + indexOfOpenPar + 1;
								int selectionLenth = oldSelectionStart - selectionStart - 1;
								configurableCompletionProposal.setSelectionStart(selectionStart);
								configurableCompletionProposal.setSelectionLength(selectionLenth);
							}
						}
						super.accept(proposal);
					}
				});
	}

	@Override
	protected String getDisplayString(EObject element, String qualifiedNameAsString,
			String shortName) {
		if (element instanceof DeclaredParameter) {
			return shortName;
		}
		return super.getDisplayString(element, qualifiedNameAsString, shortName);
	}
}
