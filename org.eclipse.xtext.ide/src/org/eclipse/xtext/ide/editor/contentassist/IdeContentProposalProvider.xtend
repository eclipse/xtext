/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist

import com.google.common.base.Predicate
import com.google.common.base.Predicates
import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.util.TextRegion
import org.eclipse.xtext.xtext.CurrentTypeFinder

/**
 * Generic content proposal provider for use in different IDE contexts. This provider is
 * <em>not</em> used by the Eclipse integration, which has its own abstraction for
 * content assist proposals.
 * @noreference
 */
class IdeContentProposalProvider {
	
	@Accessors(PROTECTED_GETTER)
	@Inject IScopeProvider scopeProvider
	
	@Accessors(PROTECTED_GETTER)
	@Inject IQualifiedNameConverter qualifiedNameConverter
	
	@Accessors(PROTECTED_GETTER)
	@Inject IdeCrossrefProposalProvider crossrefProposalProvider
	
	@Accessors(PROTECTED_GETTER)
	@Inject IdeContentProposalCreator proposalCreator
	
	@Accessors(PROTECTED_GETTER)
	@Inject IdeContentProposalPriorities proposalPriorities
	
	@Inject extension CurrentTypeFinder
	
	/**
	 * Create content assist proposals and pass them to the given acceptor.
	 */
	def void createProposals(Collection<ContentAssistContext> contexts, IIdeContentProposalAcceptor acceptor) {
		for (context : getFilteredContexts(contexts)) {
			for (element : context.firstSetGrammarElements) {
				if (!acceptor.canAcceptMoreProposals) {
					return
				}
				createProposals(element, context, acceptor)
			}
		}
	}
	
	protected def Iterable<ContentAssistContext> getFilteredContexts(Collection<ContentAssistContext> contexts) {
		return contexts
	}
	
	protected def dispatch void createProposals(AbstractElement element, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		// Unsupported element type
	}
	
	protected def dispatch void createProposals(Assignment assignment, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		val terminal = assignment.terminal
		if (terminal instanceof CrossReference) {
			createProposals(terminal, context, acceptor)
		} else if (terminal instanceof RuleCall) {
			val rule = terminal.rule
			if (rule instanceof TerminalRule && context.prefix.empty) {
				val proposal =
					if (rule.name == 'STRING')
						'"' + assignment.feature + '"'
					else
						assignment.feature
				val entry = proposalCreator.createProposal(proposal, context) [
					if (rule.name == 'STRING') {
						editPositions += new TextRegion(context.offset + 1, proposal.length - 2)
						kind = ContentAssistEntry.KIND_TEXT
					} else {
						editPositions += new TextRegion(context.offset, proposal.length)
						kind = ContentAssistEntry.KIND_VALUE
					}
					description = rule.name
				]
				acceptor.accept(entry, proposalPriorities.getDefaultPriority(entry))
			}
		}
	}
	
	protected def dispatch void createProposals(Keyword keyword, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		if (filterKeyword(keyword, context)) {
			val entry = proposalCreator.createProposal(keyword.value, context,ContentAssistEntry.KIND_KEYWORD, null)
			if (entry !== null) {
				acceptor.accept(entry, proposalPriorities.getKeywordPriority(keyword.value, entry))
			}
		}
	}
	
	protected def boolean filterKeyword(Keyword keyword, ContentAssistContext context) {
		return true
	}
	
	protected def dispatch void createProposals(RuleCall ruleCall, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		// No default proposals for rule calls
	}
	
	protected def dispatch void createProposals(CrossReference reference, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		val type = findCurrentTypeAfter(reference)
		if (type instanceof EClass) {
			val ereference = GrammarUtil.getReference(reference, type)
			val currentModel = context.currentModel
			if (ereference !== null && currentModel !== null) {
				val scope = scopeProvider.getScope(currentModel, ereference)
				crossrefProposalProvider.lookupCrossReference(scope, reference, context, acceptor,
					getCrossrefFilter(reference, context))
			}
		}
	}
	
	protected def Predicate<IEObjectDescription> getCrossrefFilter(CrossReference reference,
			ContentAssistContext context) {
		Predicates.alwaysTrue
	}
	
}
