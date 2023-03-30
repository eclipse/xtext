/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.contentassist;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xtext.CurrentTypeFinder;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.inject.Inject;

/**
 * Generic content proposal provider for use in different IDE contexts. This provider is <em>not</em> used by the
 * Eclipse integration, which has its own abstraction for content assist proposals.
 * 
 * @noreference
 */
public class IdeContentProposalProvider {
	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private IdeCrossrefProposalProvider crossrefProposalProvider;

	@Inject
	private IdeContentProposalCreator proposalCreator;

	@Inject
	private IdeContentProposalPriorities proposalPriorities;

	@Inject
	private CurrentTypeFinder currentTypeFinder;

	/**
	 * Create content assist proposals and pass them to the given acceptor.
	 */
	public void createProposals(Collection<ContentAssistContext> contexts, IIdeContentProposalAcceptor acceptor) {
		for (ContentAssistContext context : getFilteredContexts(contexts)) {
			for (AbstractElement element : context.getFirstSetGrammarElements()) {
				if (!acceptor.canAcceptMoreProposals()) {
					return;
				}
				createProposals(element, context, acceptor);
			}
		}
	}

	protected Iterable<ContentAssistContext> getFilteredContexts(Collection<ContentAssistContext> contexts) {
		return contexts;
	}

	protected void _createProposals(AbstractElement element, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
	}

	protected void _createProposals(Assignment assignment, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		AbstractElement terminal = assignment.getTerminal();
		if (terminal instanceof CrossReference) {
			createProposals(terminal, context, acceptor);
		} else {
			if (terminal instanceof RuleCall) {
				AbstractRule rule = ((RuleCall) terminal).getRule();
				if (rule instanceof TerminalRule && context.getPrefix().isEmpty()) {
					final String proposal;
					if ("STRING".equals(rule.getName())) {
						proposal = "\"" + assignment.getFeature() + "\"";
					} else {
						proposal = assignment.getFeature();
					}
					ContentAssistEntry entry = getProposalCreator().createProposal(proposal, context,
							(ContentAssistEntry it) -> {
								if ("STRING".equals(rule.getName())) {
									it.getEditPositions()
											.add(new TextRegion(context.getOffset() + 1, proposal.length() - 2));
									it.setKind(ContentAssistEntry.KIND_TEXT);
								} else {
									it.getEditPositions().add(new TextRegion(context.getOffset(), proposal.length()));
									it.setKind(ContentAssistEntry.KIND_VALUE);
								}
								it.setDescription(rule.getName());
							});
					acceptor.accept(entry, getProposalPriorities().getDefaultPriority(entry));
				}
			}
		}
	}

	protected void _createProposals(Keyword keyword, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		if (filterKeyword(keyword, context)) {
			ContentAssistEntry entry = proposalCreator.createProposal(keyword.getValue(), context,
					ContentAssistEntry.KIND_KEYWORD, null);
			if (entry != null) {
				acceptor.accept(entry, getProposalPriorities().getKeywordPriority(keyword.getValue(), entry));
			}
		}
	}

	protected boolean filterKeyword(Keyword keyword, ContentAssistContext context) {
		return true;
	}

	protected void _createProposals(RuleCall ruleCall, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
	}

	protected void _createProposals(CrossReference reference, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		EClassifier type = currentTypeFinder.findCurrentTypeAfter(reference);
		if (type instanceof EClass) {
			EReference eReference = GrammarUtil.getReference(reference, ((EClass) type));
			EObject currentModel = context.getCurrentModel();
			if (eReference != null && currentModel != null) {
				IScope scope = getScopeProvider().getScope(currentModel, eReference);
				getCrossrefProposalProvider().lookupCrossReference(scope, reference, context, acceptor,
						getCrossrefFilter(reference, context));
			}
		}
	}

	protected Predicate<IEObjectDescription> getCrossrefFilter(CrossReference reference, ContentAssistContext context) {
		return Predicates.alwaysTrue();
	}

	protected void createProposals(AbstractElement assignment, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		if (assignment instanceof Assignment) {
			_createProposals((Assignment) assignment, context, acceptor);
			return;
		} else if (assignment instanceof CrossReference) {
			_createProposals((CrossReference) assignment, context, acceptor);
			return;
		} else if (assignment instanceof Keyword) {
			_createProposals((Keyword) assignment, context, acceptor);
			return;
		} else if (assignment instanceof RuleCall) {
			_createProposals((RuleCall) assignment, context, acceptor);
			return;
		} else if (assignment != null) {
			_createProposals(assignment, context, acceptor);
			return;
		} else {
			throw new IllegalArgumentException(
					"Unhandled parameter types: " + Arrays.asList(assignment, context, acceptor).toString());
		}
	}

	protected IScopeProvider getScopeProvider() {
		return scopeProvider;
	}

	protected IQualifiedNameConverter getQualifiedNameConverter() {
		return qualifiedNameConverter;
	}

	protected IdeCrossrefProposalProvider getCrossrefProposalProvider() {
		return crossrefProposalProvider;
	}

	protected IdeContentProposalCreator getProposalCreator() {
		return proposalCreator;
	}

	protected IdeContentProposalPriorities getProposalPriorities() {
		return proposalPriorities;
	}
}
