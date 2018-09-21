/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.contentassist

import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.example.arithmetics.arithmetics.DeclaredParameter
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor

/**
 * Implementation for custom code completion proposals.
 */
class ArithmeticsProposalProvider extends AbstractArithmeticsProposalProvider {

	/**
	 * sets the selection on the arguments for proposed functions.
	 */
	override void completePrimaryExpression_Func(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completePrimaryExpression_Func(model, assignment, context,
			new ICompletionProposalAcceptor.Delegate(acceptor) {
				override void accept(ICompletionProposal proposal) {
					if (proposal instanceof ConfigurableCompletionProposal) {
						var String string = proposal.getReplacementString()
						var int indexOfOpenPar = string.indexOf(Character.valueOf('(').charValue)
						if (indexOfOpenPar !== -1) {
							var oldSelectionStart = proposal.selectionStart
							proposal.selectionStart = oldSelectionStart - string.length + indexOfOpenPar + 1
							proposal.selectionLength = oldSelectionStart - proposal.selectionStart - 1
						}
					}
					super.accept(proposal)
				}
			})
	}

	override protected String getDisplayString(EObject element, String qualifiedNameAsString, String shortName) {
		if(element instanceof DeclaredParameter) 
			return shortName
		return super.getDisplayString(element, qualifiedNameAsString, shortName)
	}

}
