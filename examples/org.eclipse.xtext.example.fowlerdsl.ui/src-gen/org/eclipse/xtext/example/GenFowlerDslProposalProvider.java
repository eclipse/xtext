/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

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
public class GenFowlerDslProposalProvider extends AbstractJavaProposalProvider {
	// constants
	private static final String UI_PLUGIN_ID  = "org.eclipse.xtext.example.fowlerdsl.ui";
	
	
			
	public List<? extends ICompletionProposal> completeStatemachine_Events(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeStatemachine_Events feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
			
	public List<? extends ICompletionProposal> completeStatemachine_Commands(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeStatemachine_Commands feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
			
	public List<? extends ICompletionProposal> completeStatemachine_States(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeStatemachine_States feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
			
	public List<? extends ICompletionProposal> completeEvent_Resetting(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeEvent_Resetting feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
			
	public List<? extends ICompletionProposal> completeEvent_Name(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeEvent_Name feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment, "Event_Name", contentAssistContext));
	}
			
	public List<? extends ICompletionProposal> completeEvent_Code(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeEvent_Code feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment, "Event_Code", contentAssistContext));
	}
			
	public List<? extends ICompletionProposal> completeCommand_Name(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeCommand_Name feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment, "Command_Name", contentAssistContext));
	}
			
	public List<? extends ICompletionProposal> completeCommand_Code(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeCommand_Code feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment, "Command_Code", contentAssistContext));
	}
			
	public List<? extends ICompletionProposal> completeState_Name(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeState_Name feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment, "State_Name", contentAssistContext));
	}
			
	public List<? extends ICompletionProposal> completeState_Actions(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeState_Actions feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), contentAssistContext);
	}
			
	public List<? extends ICompletionProposal> completeState_Transitions(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeState_Transitions feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
			
	public List<? extends ICompletionProposal> completeTransition_Event(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeTransition_Event feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), contentAssistContext);
	}
			
	public List<? extends ICompletionProposal> completeTransition_State(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeTransition_State feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), contentAssistContext);
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
