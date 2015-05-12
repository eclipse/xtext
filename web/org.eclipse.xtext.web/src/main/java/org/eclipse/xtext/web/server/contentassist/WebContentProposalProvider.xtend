/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.contentassist

import com.google.inject.Inject
import org.apache.log4j.Logger
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
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.xtext.CurrentTypeFinder

import static org.eclipse.xtext.web.server.contentassist.ContentAssistResult.*

class WebContentProposalProvider {
	
	static val LOG = Logger.getLogger(WebContentProposalProvider)
	
	@Accessors(PROTECTED_GETTER)
	@Inject IScopeProvider scopeProvider
	
	@Accessors(PROTECTED_GETTER)
	@Inject IQualifiedNameConverter qualifiedNameConverter
	
	@Inject extension CurrentTypeFinder
	
	def createProposals(ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		for (element : context.firstSetGrammarElements) {
			createProposals(element, context, acceptor)
		}
	}

	protected def dispatch void createProposals(AbstractElement element, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		// not supported
	}
	
	protected def dispatch void createProposals(Assignment assignment, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		if (assignment.terminal instanceof CrossReference)
			createProposals(assignment.terminal, context, acceptor)
	}
	
	protected def dispatch void createProposals(Keyword keyword, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		val value = keyword.value
		if (value.startsWith(context.prefix)) {
			acceptor.accept(new ContentAssistResult.Entry(KEYWORD, context.prefix) => [
				proposal = keyword.value
			])
		}
	}
	
	protected def dispatch void createProposals(RuleCall ruleCall, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		if (ruleCall.rule instanceof TerminalRule && context.prefix.empty) {
			acceptor.accept(new ContentAssistResult.Entry(TERMINAL, context.prefix) => [
				if (ruleCall.rule.name == 'STRING') {
					val container = ruleCall.eContainer
					if (container instanceof Assignment) {
						proposal = '"' + container.feature + '"'
						description = ruleCall.rule.name
					} else {
						proposal = '"' + ruleCall.rule.name + '"'
					}
					editPositions += new ContentAssistResult.EditPosition(context.offset + 1, proposal.length - 2)
				} else {
					val container = ruleCall.eContainer
					if (container instanceof Assignment) {
						proposal = container.feature
						description = ruleCall.rule.name
					} else {
						proposal = ruleCall.rule.name
					}
					editPositions += new ContentAssistResult.EditPosition(context.offset, proposal.length)
				}
			])
		}
	}
	
	protected def dispatch void createProposals(CrossReference reference, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		val type = findCurrentTypeAfter(reference)
		if (type instanceof EClass) {
			val ereference = GrammarUtil.getReference(reference, type)
			if (ereference !== null) {
				val scope = scopeProvider.getScope(context.currentModel, ereference)
				try {
					val proposalCreator = new CrossrefProposalCreator(context, qualifiedNameConverter)
					for (description : scope.allElements) {
						val String elementName = description.name.toString
						if (elementName.startsWith(context.prefix)) {
							acceptor.accept(proposalCreator.apply(description))
						}
					}
				} catch (UnsupportedOperationException uoe) {
					LOG.error('Failed to create content assist proposals for cross-reference.', uoe)
				}
			}
		}
	}
	
}