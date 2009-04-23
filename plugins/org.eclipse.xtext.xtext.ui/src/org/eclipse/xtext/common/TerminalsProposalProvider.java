package org.eclipse.xtext.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TerminalsProposalProvider extends org.eclipse.xtext.common.AbstractTerminalsProposalProvider {

	@Inject
	private IValueConverterService valueConverter;
	
	@Override
	public void complete_ID(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (doCreateIdProposals()) {
			String feature = getAssignedFeature(ruleCall);
			String proposalText = feature != null ? feature : Strings.toFirstUpper(ruleCall.getRule().getName().toLowerCase());
			String displayText = proposalText;
			if (feature != null)
				displayText = proposalText + " - " + ruleCall.getRule().getName();
			proposalText = valueConverter.toString(proposalText, ruleCall.getRule().getName());
			ICompletionProposal proposal = createCompletionProposal(proposalText, displayText, null, context);
			if (proposal instanceof ConfigurableCompletionProposal) {
				ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
				configurable.setSelectionStart(configurable.getReplacementOffset());
				configurable.setSelectionLength(proposalText.length());
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
		return null;
	}
	
	@Override
	public void complete_STRING(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (doCreateStringProposals()) {
			String feature = getAssignedFeature(ruleCall);
			createStringProposal(context, acceptor, feature, ruleCall);
		}
	}

	private void createStringProposal(ContentAssistContext context, ICompletionProposalAcceptor acceptor,
			String feature, RuleCall ruleCall) {
		String proposalText = feature != null ? feature : Strings.toFirstUpper(ruleCall.getRule().getName().toLowerCase());
		proposalText = valueConverter.toString(proposalText, ruleCall.getRule().getName());
		String displayText = proposalText;
		if (feature != null)
			displayText = displayText + " - " + ruleCall.getRule().getName();
		ICompletionProposal proposal = createCompletionProposal(proposalText, displayText, null, context);
		if (proposal instanceof ConfigurableCompletionProposal) {
			ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
			configurable.setSelectionStart(configurable.getReplacementOffset() + 1);
			configurable.setSelectionLength(proposalText.length() - 2);
			configurable.setAutoInsertable(false);
			configurable.setSimpleLinkedMode(context.getViewer(), proposalText.charAt(0), '\t');
			
		}
		acceptor.accept(proposal);
	}
	
	@Override
	public void complete_INT(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		String feature = getAssignedFeature(ruleCall);
		if (doCreateIntProposals()) {
//			createIntProposal(context, acceptor, feature, "0");
			createIntProposal(context, acceptor, ruleCall, feature, 1);
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
	
	private void createIntProposal(ContentAssistContext context, ICompletionProposalAcceptor acceptor,
			RuleCall ruleCall, String feature,	int i) {
		String proposalText = valueConverter.toString(i, ruleCall.getRule().getName());
		String displayText = proposalText + " - " + ruleCall.getRule().getName();
		if (feature != null)
			displayText = proposalText + " - " + feature;
		ICompletionProposal proposal = createCompletionProposal(proposalText, displayText, null, context);
		if (proposal instanceof ConfigurableCompletionProposal) {
			ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
			configurable.setSelectionStart(configurable.getReplacementOffset());
			configurable.setSelectionLength(proposalText.length());
			configurable.setAutoInsertable(false);
			configurable.setSimpleLinkedMode(context.getViewer(), '\t', ' ');
		}
		acceptor.accept(proposal);
	}

	public void setValueConverter(IValueConverterService valueConverter) {
		this.valueConverter = valueConverter;
	}

	public IValueConverterService getValueConverter() {
		return valueConverter;
	}
}
