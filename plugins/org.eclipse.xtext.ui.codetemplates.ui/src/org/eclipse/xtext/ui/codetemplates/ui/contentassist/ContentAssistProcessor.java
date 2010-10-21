/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.contentassist;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistantExtension2;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.keys.IBindingService;
import org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistProcessor extends XtextContentAssistProcessor implements ICompletionListener {

	@Inject
	private IWorkbench workbench;
	
	private int mode;
	private IContentAssistantExtension2 currentAssistant;
	
	@Override
	public CodetemplatesProposalProvider getContentProposalProvider() {
		return (CodetemplatesProposalProvider) super.getContentProposalProvider();
	}
	
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		try {
			mode++;
			currentAssistant.setStatusMessage(getStatusMessage());
			getContentProposalProvider().setMode(mode);
			return super.computeCompletionProposals(viewer, offset);
		} finally {
			mode = mode % 3;
		}
	}
	
	protected String getStatusMessage() {
		IBindingService bindingService = (IBindingService) workbench.getAdapter(IBindingService.class);
		String binding = bindingService.getBestActiveBindingFormattedFor(IWorkbenchCommandConstants.EDIT_CONTENT_ASSIST);
		String category = "all proposals";
		if (mode == 3)
			category = "template infrastructure proposals";
		if (mode == 1)
			category = "target language proposals";
		return binding + " to show " + category;
	}

	public void assistSessionStarted(ContentAssistEvent event) {
		mode = 2;
		this.currentAssistant = (IContentAssistantExtension2) event.assistant;
	}

	public void assistSessionEnded(ContentAssistEvent event) {
		mode = 2;
		this.currentAssistant = null;
	}

	public void selectionChanged(ICompletionProposal proposal, boolean smartToggle) {
	}

}
