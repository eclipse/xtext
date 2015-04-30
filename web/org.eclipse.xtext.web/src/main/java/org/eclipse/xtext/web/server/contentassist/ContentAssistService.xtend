/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.contentassist

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import java.util.Collections
import java.util.Comparator
import java.util.HashSet
import java.util.Set
import java.util.concurrent.ExecutorService
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.model.UpdateDocumentService
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess
import org.eclipse.xtext.xtext.CurrentTypeFinder

@Singleton
class ContentAssistService {
	
	protected static val KEYWORD = 'keyword'
	protected static val CROSSREF = 'crossref'
	
	@Inject Provider<ContentAssistContextFactory> contextFactoryProvider
	
	@Inject IScopeProvider scopeProvider
	
	@Inject ExecutorService executorService
	
	@Inject extension UpdateDocumentService
	
	@Inject extension CurrentTypeFinder
	
	def createProposals(XtextWebDocumentAccess document, ITextRegion selection, int offset)
			throws InvalidRequestException {
		val contextFactory = contextFactoryProvider.get() => [it.pool = executorService]
		val stateIdWrapper = ArrayLiterals.newArrayOfSize(1)
		val contexts = document.priorityReadOnly([ it, cancelIndicator |
			stateIdWrapper.set(0, stateId)
			contextFactory.create(text, selection, offset, resource)
		], [ it, cancelIndicator |
			processUpdatedDocument(cancelIndicator)
			return null
		])
		return createProposals(contexts, stateIdWrapper.get(0))
	}
	
	def createProposalsWithUpdate(XtextWebDocumentAccess document, String deltaText, int deltaOffset,
			int deltaReplaceLength, ITextRegion textSelection, int caretOffset) {
		val contextFactory = contextFactoryProvider.get() => [it.pool = executorService]
		val stateIdWrapper = ArrayLiterals.newArrayOfSize(1)
		val contexts = document.modify([ it, cancelIndicator |
			dirty = true
			processingCompleted = false
			createNewStateId()
			stateIdWrapper.set(0, stateId)
			updateText(deltaText, deltaOffset, deltaReplaceLength)
			contextFactory.create(text, textSelection, caretOffset, resource)
		], [ it, cancelIndicator |
			processUpdatedDocument(cancelIndicator)
			return null
		])
		return createProposals(contexts, stateIdWrapper.get(0))
	}
	
	protected def createProposals(ContentAssistContext[] contexts, String stateId) {
		val result = new ContentAssistResult
		result.stateId = stateId
		if (!contexts.empty) {
			val proposals = new HashSet<ContentAssistResult.Entry>
			val longestPrefix = contexts.map[prefix].maxBy[length]
			for (context : contexts) {
				if (context.prefix == longestPrefix) {
					for (element : context.firstSetGrammarElements) {
						createProposal(element, context, proposals)
					}
				}
			}
			result.entries.addAll(proposals)
			Collections.sort(result.entries, proposalComparator)
		}
		return result
	}
	
	protected def Comparator<? super ContentAssistResult.Entry> getProposalComparator() {
		[a, b |
			if (a.type == b.type)
				a.proposal.compareTo(b.proposal)
			else
				a.type.compareTo(b.type)
		]
	}

	protected def dispatch void createProposal(AbstractElement element, ContentAssistContext context,
			Set<ContentAssistResult.Entry> proposals) {
		// not supported
	}
	
	protected def dispatch void createProposal(Keyword keyword, ContentAssistContext context,
			Set<ContentAssistResult.Entry> proposals) {
		val value = keyword.value
		if (value.startsWith(context.prefix) && value.length > 1 && Character.isLetter(value.charAt(0))) {
			val entry = new ContentAssistResult.Entry(context.prefix, keyword.value, null, null, null)
			entry.type = KEYWORD
			proposals += entry
		}
	}
	
	protected def dispatch void createProposal(Assignment assignment, ContentAssistContext context,
			Set<ContentAssistResult.Entry> proposals) {
		createProposal(assignment.terminal, context, proposals)
	}
	
	protected def dispatch void createProposal(CrossReference reference, ContentAssistContext context,
			Set<ContentAssistResult.Entry> proposals) {
		val type = findCurrentTypeAfter(reference)
		if (type instanceof EClass) {
			val ereference = GrammarUtil.getReference(reference, type)
			if (ereference !== null) {
				val scope = scopeProvider.getScope(context.currentModel, ereference)
				try {
					for (description : scope.allElements) {
						var String name = description.name.toString
						if (!name.startsWith(context.prefix))
							name = description.qualifiedName.toString
						if (name.startsWith(context.prefix)) {
							val entry = new ContentAssistResult.Entry(context.prefix, name, null, description.EClass.name, null)
							entry.type = CROSSREF
							proposals += entry
						}
					}
				} catch (UnsupportedOperationException uoe) {
					uoe.printStackTrace
				}
			}
		}
	}
	
}