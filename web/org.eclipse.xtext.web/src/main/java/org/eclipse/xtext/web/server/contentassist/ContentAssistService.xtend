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
import java.util.Collection
import java.util.Collections
import java.util.HashSet
import java.util.List
import java.util.concurrent.ExecutorService
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.model.UpdateDocumentService
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess

import static org.eclipse.xtext.web.server.contentassist.ContentAssistResult.*

@Singleton
class ContentAssistService {
	
	@Inject Provider<ContentAssistContextFactory> contextFactoryProvider
	
	@Inject WebContentProposalProvider proposalProvider
	
	@Inject ExecutorService executorService
	
	@Inject extension UpdateDocumentService
	
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
			val IAcceptor<ContentAssistResult.Entry> acceptor = [proposals.add(it)]
			val longestPrefix = contexts.map[prefix].maxBy[length]
			for (context : contexts) {
				if (context.prefix == longestPrefix) {
					proposalProvider.createProposals(context, acceptor)
				}
			}
			result.entries.addAll(proposals.filter)
			result.entries.sort
		}
		return result
	}
	
	protected def filter(Collection<ContentAssistResult.Entry> proposals) {
		proposals.filter[
			if (proposal.nullOrEmpty || !proposal.startsWith(prefix))
				return false
			switch type {
				case KEYWORD:
					proposals.size == 1 || Character.isLetter(proposal.charAt(0))
				default: true
			}
		]
	}
	
	protected def sort(List<ContentAssistResult.Entry> proposals) {
		Collections.sort(proposals, [a, b |
			if (a.type == b.type)
				a.proposal.compareTo(b.proposal)
			else
				a.type.compareTo(b.type)
		])
	}
	
}