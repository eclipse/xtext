package org.eclipse.xtext.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TerminalsProposalProvider extends org.eclipse.xtext.common.AbstractTerminalsProposalProvider {

	@Override
	public void complete_ID(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (doCreateIdProposals()) {
			String feature = getAssignedFeature(ruleCall);
			ICompletionProposal proposal = createCompletionProposal(feature, context);
			if (proposal instanceof ConfigurableCompletionProposal) {
				ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
				configurable.setSelectionStart(configurable.getReplacementOffset());
				configurable.setSelectionLength(feature.length());
				configurable.setAutoInsertable(false);
				configurable.setSimpleLinkedMode(context.getViewer(), '\t', ' ');
			}
			acceptor.accept(proposal);
		}
	}
	
	private String getAssignedFeature(RuleCall call) {
		Assignment ass = GrammarUtil.containingAssignment(call);
		if (ass != null) {
			String result = ass.getFeature();
			if (result.equals(result.toLowerCase()))
				result = Strings.toFirstUpper(result);
			return result;
		}
		return Strings.toFirstUpper(call.getRule().getName().toLowerCase());
	}
	
	@Override
	public void complete_STRING(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (doCreateStringProposals()) {
			String feature = getAssignedFeature(ruleCall);
			createStringProposal(context, acceptor, feature, '"');
			createStringProposal(context, acceptor, feature, '\'');
		}
	}

	private void createStringProposal(ContentAssistContext context, ICompletionProposalAcceptor acceptor,
			String feature, char delim) {
		ICompletionProposal proposal = createCompletionProposal(delim + feature + delim, context);
		if (proposal instanceof ConfigurableCompletionProposal) {
			ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
			configurable.setSelectionStart(configurable.getReplacementOffset() + 1);
			configurable.setSelectionLength(feature.length());
			configurable.setAutoInsertable(false);
			configurable.setSimpleLinkedMode(context.getViewer(), delim, '\t');
		}
		acceptor.accept(proposal);
	}
	
	@Override
	public void complete_INT(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		String feature = getAssignedFeature(ruleCall);
		if (doCreateIntProposals()) {
//			createIntProposal(context, acceptor, feature, "0");
			createIntProposal(context, acceptor, feature, "1");
//			createIntProposal(context, acceptor, feature, "2");
//			createIntProposal(context, acceptor, feature, "5");
//			createIntProposal(context, acceptor, feature, "10");
//			createIntProposal(context, acceptor, feature, "50");
//			createIntProposal(context, acceptor, feature, "100");
//			createIntProposal(context, acceptor, feature, "1000");
		}
	}
	
	protected boolean doCreateIntProposals() {
		return true;
	}

	protected boolean doCreateStringProposals() {
		return true;
	}
	
	protected boolean doCreateIdProposals() {
		return true;
	}
	
	private void createIntProposal(ContentAssistContext context, ICompletionProposalAcceptor acceptor, String feature,
			String i) {
		ICompletionProposal proposal = createCompletionProposal(i, i + " - " + feature, null, context);
		if (proposal instanceof ConfigurableCompletionProposal) {
			ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
			configurable.setSelectionStart(configurable.getReplacementOffset());
			configurable.setSelectionLength(i.length());
			configurable.setAutoInsertable(false);
			configurable.setSimpleLinkedMode(context.getViewer(), '\t', ' ');
		}
		acceptor.accept(proposal);
	}
}
