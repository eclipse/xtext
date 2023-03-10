/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.example.statemachine.ide;

import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;
import org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class StatemachineWebContentProposalProvider extends IdeContentProposalProvider {
	@Inject
	private StatemachineGrammarAccess statemachineGrammarAccess;

	@Inject
	private StatemachineTemplateProposalProvider templateProvider;

	@Override
	protected void _createProposals(RuleCall ruleCall, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		if (ruleCall.getRule() == statemachineGrammarAccess.getBOOLEANRule()) {
			if ("true".startsWith(context.getPrefix())) {
				ContentAssistEntry trueEntry = getProposalCreator().createProposal("true", context);
				acceptor.accept(trueEntry, getProposalPriorities().getDefaultPriority(trueEntry));
			}
			if ("false".startsWith(context.getPrefix())) {
				ContentAssistEntry falseEntry = getProposalCreator().createProposal("false", context);
				acceptor.accept(falseEntry, getProposalPriorities().getDefaultPriority(falseEntry));
			}
		} else if (ruleCall.getRule() == statemachineGrammarAccess.getStateRule()) {
			templateProvider.createStateProposal(context, acceptor);
		} else {
			super._createProposals(ruleCall, context, acceptor);
		}
	}

	@Override
	protected void _createProposals(Assignment assignment, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		if (assignment == statemachineGrammarAccess.getEventAccess().getSignalAssignment_0()) {
			IScope scope = getScopeProvider().getScope(context.getCurrentModel(),
					StatemachinePackage.Literals.EVENT__SIGNAL);
			for (IEObjectDescription description : Iterables.filter(scope.getAllElements(),
					it -> StatemachinePackage.Literals.INPUT_SIGNAL.equals(it.getEClass()))) {
				ContentAssistEntry entry = getProposalCreator().createProposal(description.getName().toString(),
						context, new Procedure1<ContentAssistEntry>() {
							@Override
							public void apply(ContentAssistEntry it) {
								it.setSource(description);
								it.setDescription("input signal");
							}
						});
				acceptor.accept(entry, getProposalPriorities().getCrossRefPriority(description, entry));
			}
		} else if (assignment == statemachineGrammarAccess.getCommandAccess().getSignalAssignment_1()) {
			IScope scope = getScopeProvider().getScope(context.getCurrentModel(),
					StatemachinePackage.Literals.COMMAND__SIGNAL);
			for (IEObjectDescription description_1 : Iterables.filter(scope.getAllElements(),
					it -> StatemachinePackage.Literals.OUTPUT_SIGNAL.equals(it.getEClass()))) {
				ContentAssistEntry entry = getProposalCreator().createProposal(description_1.getName().toString(),
						context, new Procedure1<ContentAssistEntry>() {
							@Override
							public void apply(ContentAssistEntry it) {
								it.setSource(description_1);
								it.setDescription("output signal");
							}
						});
				acceptor.accept(entry, getProposalPriorities().getCrossRefPriority(description_1, entry));
			}
		} else if (assignment == statemachineGrammarAccess.getEventAccess().getValueAssignment_2()
				|| assignment == statemachineGrammarAccess.getCommandAccess().getNewValueAssignment_3()) {
			// Proposals are created by RuleCall dispatch method
		} else {
			super._createProposals(assignment, context, acceptor);
		}
	}

	@Override
	protected boolean filterKeyword(Keyword keyword, ContentAssistContext context) {
		if (keyword == statemachineGrammarAccess.getStateAccess().getStateKeyword_0()) {
			return false;
		}
		return super.filterKeyword(keyword, context);
	}

}
