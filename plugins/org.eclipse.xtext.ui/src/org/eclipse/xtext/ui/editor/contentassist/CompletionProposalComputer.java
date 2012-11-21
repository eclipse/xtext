/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.TemplateProposal;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompletionProposalComputer implements IUnitOfWork<ICompletionProposal[], XtextResource>, ICompletionProposalAcceptor, ITemplateAcceptor {

	public interface State {
		ITemplateProposalProvider getTemplateProposalProvider();
		IContentProposalProvider getContentProposalProvider();
		ContentAssistContext.Factory getContextFactory();
		ICompletionProposalAcceptor decorateAcceptor(ICompletionProposalAcceptor delegate);
		ITemplateAcceptor decorateAcceptor(ITemplateAcceptor delegate);
	}
	
	private final int offset;
	private final ITextViewer viewer;
	private final State state;
	
	private final Collection<ICompletionProposal> proposals;
	
	public CompletionProposalComputer(State state, ITextViewer viewer, int offset) {
		super();
		this.proposals = new LinkedHashSet<ICompletionProposal>(30);
		this.state = state;
		this.viewer = viewer;
		this.offset = offset;
	}

	public ICompletionProposal[] exec(XtextResource resource) throws Exception {
		ICompletionProposalAcceptor proposalAcceptor = state.decorateAcceptor((ICompletionProposalAcceptor)this);
		ContentAssistContext[] contexts = state.getContextFactory().create(viewer, offset, resource);
		for (ContentAssistContext context: contexts) {
			if (proposalAcceptor.canAcceptMoreProposals())
				state.getContentProposalProvider().createProposals(context, proposalAcceptor);
		}
		ITemplateAcceptor templateAcceptor = state.decorateAcceptor((ITemplateAcceptor) this);
		for (ContentAssistContext context: contexts) {
			if (templateAcceptor.canAcceptMoreTemplates() && context.getReplaceRegion().getOffset() >= 0)
				state.getTemplateProposalProvider().createTemplates(context, templateAcceptor);
			
		}
		return proposals.toArray(new ICompletionProposal[proposals.size()]);
	}

	public void accept(ICompletionProposal proposal) {
		if (proposal == null)
			throw new NullPointerException("proposal may not be null");
		proposals.add(proposal);
	}

	public boolean canAcceptMoreProposals() {
		return true;
	}

	public void accept(TemplateProposal template) {
		if (template == null)
			throw new NullPointerException("template may not be null");
		proposals.add(template);
	}

	public boolean canAcceptMoreTemplates() {
		return true;
	}

}
