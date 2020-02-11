/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import java.util.Arrays;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionListenerExtension;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistantExtension2;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.keys.IBindingService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;

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
	private IWorkbench workbench;
	
	/**
	 * @since 2.19
	 */
	@Inject
	private XtextDocumentUtil xtextDocumentUtil;
	
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
		CompletionProposalComputer proposalComputer = createCompletionProposalComputer(viewer, offset);
		while(i++ < 1000) { // just to prevent endless loop in case #isLastMode has an error
			proposalProvider.nextMode();
			if (currentAssistant != null)
				currentAssistant.setStatusMessage(getStatusMessage());
			ICompletionProposal[] result = computeCompletionProposals(xtextDocumentUtil.getXtextDocument(viewer), proposalComputer);
			if (result != null && result.length > 0)
				return result;
			if (proposalProvider.isLastMode()) {
				return new ICompletionProposal[0];	
			}
		}
		throw new IllegalStateException("#isLastMode did not return true for 1000 times");
	}
	
	@Override
	protected CompletionProposalComputer createCompletionProposalComputer(ITextViewer viewer, int offset) {
		return new CompletionProposalComputer(this, viewer, offset) {
			ContentAssistContext[] previouslyComputed;
			@Override
			protected ContentAssistContext[] createContentAssistContexts(XtextResource resource) {
				if (previouslyComputed != null) {
					return previouslyComputed;
				}
				return previouslyComputed = super.createContentAssistContexts(resource);
			}
		};
	}
	
	/**
	 * @since 2.7
	 */
	protected ICompletionProposal[] computeCompletionProposals(IXtextDocument document, CompletionProposalComputer proposalComputer) {
		if (getContentProposalProvider() == null)
			return null;
		
		ICompletionProposal[] result = document.priorityReadOnly(proposalComputer);
		Arrays.sort(result, getCompletionProposalComparator());
		result = getCompletionProposalPostProcessor().postProcess(result);
		return result;
	}
	
	protected String getStatusMessage() {
		String binding = "<binding>";
		if (workbench != null) {
			IBindingService bindingService = workbench.getAdapter(IBindingService.class);
			binding = bindingService.getBestActiveBindingFormattedFor(IWorkbenchCommandConstants.EDIT_CONTENT_ASSIST);
		}
		String category = getModeAwareProposalProvider().getNextCategory();
		return binding + " to show " + category;
	}

	@Override
	public void assistSessionStarted(ContentAssistEvent event) {
		ModeAware proposalProvider = getModeAwareProposalProvider();
		if (proposalProvider != null)
			proposalProvider.reset();
		this.currentAssistant = (IContentAssistantExtension2) event.assistant;
	}

	@Override
	public void assistSessionEnded(ContentAssistEvent event) {
		ModeAware proposalProvider = getModeAwareProposalProvider();
		if (proposalProvider != null)
			proposalProvider.reset();
		this.currentAssistant = null;
	}
	
	@Override
	public void assistSessionRestarted(ContentAssistEvent event) {
		ModeAware proposalProvider = getModeAwareProposalProvider();
		if (proposalProvider != null)
			proposalProvider.reset();
	}

	@Override
	public void selectionChanged(ICompletionProposal proposal, boolean smartToggle) {
	}

}
