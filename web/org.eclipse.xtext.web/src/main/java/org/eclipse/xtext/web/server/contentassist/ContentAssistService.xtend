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
import java.util.HashSet
import java.util.List
import java.util.concurrent.ExecutorService
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.model.IXtextWebDocument
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess

/**
 * Service class for content assist proposals.
 */
@Singleton
class ContentAssistService {
	
	public static val DEFAULT_PROPOSALS_LIMIT = 1000
	
	@Inject Provider<ContentAssistContextFactory> contextFactoryProvider
	
	@Inject ExecutorService executorService
	
	@Accessors(PUBLIC_GETTER)
	@Inject IdeContentProposalProvider proposalProvider
	
	/**
	 * Create content assist proposals at the given caret offset. This document read operation
	 * is scheduled with higher priority, so currently running operations may be canceled.
	 * The document processing is rescheduled as background work afterwards.
	 */
	def ContentAssistResult createProposals(XtextWebDocumentAccess document, ITextRegion selection, int caretOffset,
			int proposalsLimit) throws InvalidRequestException {
		val stateIdWrapper = ArrayLiterals.newArrayOfSize(1)
		val contexts = document.priorityReadOnly[ it, cancelIndicator |
			stateIdWrapper.set(0, stateId)
			getContexts(selection, caretOffset)
		]
		return createProposals(contexts, stateIdWrapper.get(0), proposalsLimit)
	}
	
	/**
	 * Apply a text update and then create content assist proposals. This document read operation
	 * is scheduled with higher priority, so currently running operations may be canceled.
	 * The document processing is rescheduled as background work afterwards.
	 */
	def ContentAssistResult createProposalsWithUpdate(XtextWebDocumentAccess document, String deltaText, int deltaOffset,
			int deltaReplaceLength, ITextRegion selection, int caretOffset, int proposalsLimit)
			throws InvalidRequestException {
		val stateIdWrapper = ArrayLiterals.newArrayOfSize(1)
		val contexts = document.modify[ it, cancelIndicator |
			dirty = true
			createNewStateId()
			stateIdWrapper.set(0, stateId)
			updateText(deltaText, deltaOffset, deltaReplaceLength)
			getContexts(selection, caretOffset)
		]
		return createProposals(contexts, stateIdWrapper.get(0), proposalsLimit)
	}
	
	def ContentAssistContext[] getContexts(IXtextWebDocument document, ITextRegion selection, int caretOffset) {
		if (caretOffset > document.text.length)
			return #[]
		val contextFactory = contextFactoryProvider.get() => [it.pool = executorService]
		contextFactory.create(document.text, selection, caretOffset, document.resource)
	}
	
	/**
	 * Invoke the proposal provider and put the results into a {@link ContentAssistResult} object.
	 */
	protected def createProposals(List<ContentAssistContext> contexts, String stateId, int proposalsLimit) {
		val result = new ContentAssistResult(stateId)
		if (!contexts.empty) {
			val proposals = new HashSet<Pair<Integer, ContentAssistEntry>>
			val acceptor = new IIdeContentProposalAcceptor {
				override accept(ContentAssistEntry entry, int priority) {
					if (entry !== null) {
						if (entry.proposal === null)
							throw new IllegalArgumentException('proposal must not be null.')
						proposals.add(priority -> entry)
					}
				}
				override canAcceptMoreProposals() {
					proposals.size < proposalsLimit
				}
			}
			
			proposalProvider.createProposals(contexts, acceptor)
			
			result.entries.addAll(proposals.sortWith[p1, p2 |
				val prioResult = p2.key.compareTo(p1.key)
				if (prioResult != 0)
					return prioResult
				val s1 = p1.value.label ?: p1.value.proposal
				val s2 = p2.value.label ?: p2.value.proposal
				return s1.compareTo(s2)
			].map[value])
		}
		return result
	}
	
}