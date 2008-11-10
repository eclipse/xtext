/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.common.editor.codecompletion.AbstractProposalProvider;
import org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider;

/**
 * Represents a generated, default implementation of interface {@link IProposalProvider}.
 * 
 * In addition to the declared methods, the framework tries to call grammar dependent methods for assignments using reflection.
 * The signature of such methods invoked reflectively follows the following pattern:
 * 
 * public List<ICompletionProposal> complete[Typename][featureName](Assignment ele, EObject model, String prefix)
 * 
 * <b>Example</b>
 *  Given the following grammar :
 *  <code>
 *  RuleA returns MyType :
 *  	"myType" name=ID;
 *  </code>
 *
 * One could provide the following method in an implementation of this interface:
 *  <code>
 * 	public List<ICompletionProposal> completeMyTypeName(Assignment ele, EObject model, String prefix, IDocument doc) {...}
 *  </code>
 *  Note that if you have generated Java classes for your domain model (meta model) you can alternatively declare the second parameter using 
 *  a specific type:
 *  <code>
 * 	public List<ICompletionProposal> completeMyTypeName(Assignment ele, MyType model, String prefix, IDocument doc) {...}
 *  </code>
 *   
 */
public class FowlerDslGenProposalProvider  extends AbstractProposalProvider {
	// constants
	private static final String UI_PLUGIN_ID  = "org.eclipse.xtext.example.fowlerdsl.ui";

	
	public List<? extends ICompletionProposal> completeStatemachineEvents(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeStatemachineEvents feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeStatemachineCommands(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeStatemachineCommands feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeStatemachineStates(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeStatemachineStates feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeEventResetting(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeEventResetting feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeEventName(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeEventName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"EventName", offset));
	}
	
	public List<? extends ICompletionProposal> completeEventCode(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeEventCode feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"EventCode", offset));
	}
	
	public List<? extends ICompletionProposal> completeCommandName(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeCommandName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"CommandName", offset));
	}
	
	public List<? extends ICompletionProposal> completeCommandCode(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeCommandCode feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"CommandCode", offset));
	}
	
	public List<? extends ICompletionProposal> completeStateName(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeStateName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"StateName", offset));
	}
	
	public List<? extends ICompletionProposal> completeStateActions(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeStateActions feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), model, prefix, offset);
	}
	
	public List<? extends ICompletionProposal> completeStateTransitions(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeStateTransitions feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeTransitionEvent(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeTransitionEvent feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), model, prefix, offset);
	}
	
	public List<? extends ICompletionProposal> completeTransitionState(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeTransitionState feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), model, prefix, offset);
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
