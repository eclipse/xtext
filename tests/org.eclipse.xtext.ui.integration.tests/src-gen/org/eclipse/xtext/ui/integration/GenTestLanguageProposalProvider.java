/*
Generated with Xtext
*/
package org.eclipse.xtext.ui.integration;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.AbstractJavaProposalProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;

/**
 * Represents a generated, default implementation of interface {@link IProposalProvider}.
 * 
 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider
 */
public class GenTestLanguageProposalProvider extends AbstractJavaProposalProvider {
	// constants
	private static final String UI_PLUGIN_ID  = ".";
	
	
			
	public List<? extends ICompletionProposal> completeFileStuff(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeFileStuff feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
			
	public List<? extends ICompletionProposal> completeStuffName(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeStuffName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment, "StuffName", contentAssistContext));
	}
    
			
	public List<? extends ICompletionProposal> complete(RuleCall ruleCall, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("complete '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + contentAssistContext.getModel() + "' and prefix '" + contentAssistContext.getMatchString() + "'");
		}
		return Collections.emptyList();
	}
			
    
    @Override
	protected String getDefaultImageFilePath() {
		return "icons/editor.gif";
	}

	@Override
	protected String getPluginId() {
		return UI_PLUGIN_ID;
	}
}
