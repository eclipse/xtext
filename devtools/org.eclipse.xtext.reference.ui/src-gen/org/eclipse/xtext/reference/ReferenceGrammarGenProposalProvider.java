/*
Generated with Xtext
*/
package org.eclipse.xtext.reference;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.AbstractProposalProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;

/**
 * Represents a generated, default implementation of interface {@link IProposalProvider}.
 * 
 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider
 */
public class ReferenceGrammarGenProposalProvider  extends AbstractProposalProvider {
	// constants
	private static final String UI_PLUGIN_ID  = "org.eclipse.xtext.reference.ui";

	
	
	
	
	
	
	
	public List<? extends ICompletionProposal> completeSpielplatzTypes(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielplatzTypes feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public List<? extends ICompletionProposal> completeFarbeWert(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeFarbeWert feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeCustomTypeParserRuleName(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeCustomTypeParserRuleName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment, "CustomTypeParserRuleName", contentAssistContext));
	}
    
    
    
    
    
    
    
    
    
	public List<? extends ICompletionProposal> completeReferenceModelCustomType(RuleCall ruleCall, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeReferenceModelCustomType '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
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
