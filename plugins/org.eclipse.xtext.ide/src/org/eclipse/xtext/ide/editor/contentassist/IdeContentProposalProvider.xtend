/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
		var ContentAssistContext selectedContext
		for (context : contexts) {
			if (selectedContext === null || context.acceptable
					&& (context.prefix.length > selectedContext.prefix.length || !selectedContext.acceptable)) {
				selectedContext = context
			}
		}
		val finalSelectedContext = selectedContext
		return contexts.filter[ context |
			context === finalSelectedContext
			|| context.prefix == finalSelectedContext.prefix && context.acceptable
		]
	}
	
	protected def isAcceptable(ContentAssistContext context) {
		val prefix = context.prefix
		return prefix.empty || Character.isJavaIdentifierPart(prefix.charAt(prefix.length - 1))
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
				val entry = new ContentAssistEntry => [
					prefix = context.prefix
					if (rule.name == 'STRING') {
						proposal = '"' + assignment.feature + '"'
						editPositions += new TextRegion(context.offset + 1, proposal.length - 2)
					} else {
						proposal = assignment.feature
						editPositions += new TextRegion(context.offset, proposal.length)
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
			val entry = new ContentAssistEntry => [
				prefix = context.prefix
				proposal = keyword.value
			]
			acceptor.accept(entry, proposalPriorities.getKeywordPriority(keyword.value, entry))
		}
	}
	
	protected def boolean filterKeyword(Keyword keyword, ContentAssistContext context) {
		keyword.value.regionMatches(true, 0, context.prefix, 0, context.prefix.length)
			&& keyword.value.length > context.prefix.length
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
			if (ereference !== null) {
				val scope = scopeProvider.getScope(context.currentModel, ereference)
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
