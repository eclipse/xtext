/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionListenerExtension;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistantExtension2;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.keys.IBindingService;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RepeatedContentAssistProcessor extends XtextContentAssistProcessor implements ICompletionListener, ICompletionListenerExtension {

	public interface ModeAware {
		
		/**
		 * Reset the proposal provider's repetition state. The intial
		 * proposals should be displayed after a subsequent
		 * call to {@link #nextMode()}.
		 */
		void reset();
		
		/**
		 * Announce that proposals will be computed.
		 */
		void nextMode();
		
		/**
		 * @return <code>true</code> if a subsequent call to {@link #nextMode()} will
		 * show the proposals for the first mode.
		 */
		boolean isLastMode();
		
		/**
		 * @return a description of the proposal category that will be
		 *   retrieved after a subsequent invocation of {@link #nextMode()}.
		 */
		String getNextCategory();
		
	}
	
	@Inject(optional = true)
	/* @Nullable */
	private IWorkbench workbench;
	
	private IContentAssistantExtension2 currentAssistant;
	
	public ModeAware getModeAwareProposalProvider() {
		return (ModeAware) super.getContentProposalProvider();
	}
	
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		ModeAware proposalProvider = getModeAwareProposalProvider();
		if (proposalProvider == null)
			return new ICompletionProposal[0];
		int i = 0;
		while(i++ < 1000) { // just to prevent endless loop in case #isLastMode has an error
			proposalProvider.nextMode();
			if (currentAssistant != null)
				currentAssistant.setStatusMessage(getStatusMessage());
			ICompletionProposal[] result = super.computeCompletionProposals(viewer, offset);
			if (result != null && result.length > 0)
				return result;
			if (proposalProvider.isLastMode()) {
				return new ICompletionProposal[0];	
			}
		}
		throw new IllegalStateException("#isLastMode did not return true for 1000 times");
	}
	
	protected String getStatusMessage() {
		String binding = "<binding>";
		if (workbench != null) {
			IBindingService bindingService = (IBindingService) workbench.getAdapter(IBindingService.class);
			binding = bindingService.getBestActiveBindingFormattedFor(IWorkbenchCommandConstants.EDIT_CONTENT_ASSIST);
		}
		String category = getModeAwareProposalProvider().getNextCategory();
		return binding + " to show " + category;
	}

	public void assistSessionStarted(ContentAssistEvent event) {
		ModeAware proposalProvider = getModeAwareProposalProvider();
		if (proposalProvider != null)
			proposalProvider.reset();
		this.currentAssistant = (IContentAssistantExtension2) event.assistant;
	}

	public void assistSessionEnded(ContentAssistEvent event) {
		ModeAware proposalProvider = getModeAwareProposalProvider();
		if (proposalProvider != null)
			proposalProvider.reset();
		this.currentAssistant = null;
	}
	
	public void assistSessionRestarted(ContentAssistEvent event) {
		ModeAware proposalProvider = getModeAwareProposalProvider();
		if (proposalProvider != null)
			proposalProvider.reset();
	}

	public void selectionChanged(ICompletionProposal proposal, boolean smartToggle) {
	}

}
