/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist

import com.google.common.base.Predicates
import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.util.TextRegion
import org.eclipse.xtext.xtext.CurrentTypeFinder

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
	
	def void createProposals(List<ContentAssistContext> contexts, IIdeContentProposalAcceptor acceptor) {
		var ContentAssistContext selectedContext
		for (context : contexts) {
			if (selectedContext === null || context.acceptable
					&& (context.prefix.length > selectedContext.prefix.length || !selectedContext.acceptable)) {
				selectedContext = context
			}
		}
		for (context : contexts) {
			if (context === selectedContext || context.prefix == selectedContext.prefix && context.acceptable) {
				for (element : context.firstSetGrammarElements) {
					if (!acceptor.canAcceptMoreProposals) {
						return
					}
					createProposals(element, context, acceptor)
				}
			}
		}
	}
	
	protected def isAcceptable(ContentAssistContext context) {
		val prefix = context.prefix
		return prefix.empty || Character.isJavaIdentifierPart(prefix.charAt(prefix.length - 1))
	}
	
	protected def dispatch void createProposals(AbstractElement element, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		// not supported
	}
	
	protected def dispatch void createProposals(Assignment assignment, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		if (assignment.terminal instanceof CrossReference)
			createProposals(assignment.terminal, context, acceptor)
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
	
	protected def filterKeyword(Keyword keyword, ContentAssistContext context) {
		keyword.value.regionMatches(true, 0, context.prefix, 0, context.prefix.length)
			&& keyword.value.length > context.prefix.length
	}
	
	protected def dispatch void createProposals(RuleCall ruleCall, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		if (ruleCall.rule instanceof TerminalRule && context.prefix.empty) {
			val entry = new ContentAssistEntry => [
				prefix = context.prefix
				if (ruleCall.rule.name == 'STRING') {
					val container = ruleCall.eContainer
					if (container instanceof Assignment) {
						proposal = '"' + container.feature + '"'
						description = ruleCall.rule.name
					} else {
						proposal = '"' + ruleCall.rule.name + '"'
					}
					editPositions += new TextRegion(context.offset + 1, proposal.length - 2)
				} else {
					val container = ruleCall.eContainer
					if (container instanceof Assignment) {
						proposal = container.feature
						description = ruleCall.rule.name
					} else {
						proposal = ruleCall.rule.name
					}
					editPositions += new TextRegion(context.offset, proposal.length)
				}
			]
			acceptor.accept(entry, proposalPriorities.getDefaultPriority(entry))
		}
	}
	
	protected def dispatch void createProposals(CrossReference reference, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		val type = findCurrentTypeAfter(reference)
		if (type instanceof EClass) {
			val ereference = GrammarUtil.getReference(reference, type)
			if (ereference !== null) {
				val scope = scopeProvider.getScope(context.currentModel, ereference)
				crossrefProposalProvider.lookupCrossReference(scope, reference, context, acceptor, Predicates.alwaysTrue)
			}
		}
	}
	
}
		