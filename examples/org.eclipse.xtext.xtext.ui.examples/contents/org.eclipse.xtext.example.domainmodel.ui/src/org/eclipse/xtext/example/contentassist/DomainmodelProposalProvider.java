package org.eclipse.xtext.example.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalAcceptor;

public class DomainmodelProposalProvider extends org.eclipse.xtext.example.contentassist.AbstractDomainmodelProposalProvider {
	@Override
	public void completeEntity_Name(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeEntity_Name(model, assignment, context, acceptor);
	}
}
