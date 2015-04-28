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
import java.util.concurrent.ExecutorService
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.model.UpdateDocumentService
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess

@Singleton
class ContentAssistService {
	
	@Inject Provider<ContentAssistContextFactory> contextFactoryProvider
	
	@Inject extension UpdateDocumentService updateDocumentService
	
	@Inject ExecutorService executorService
	
	def createProposals(XtextWebDocumentAccess document, ITextRegion selection, int offset)
			throws InvalidRequestException {
		val contextFactory = contextFactoryProvider.get() => [it.pool = executorService]
		val contexts = document.priorityReadOnly([ it, cancelIndicator |
			contextFactory.create(text, selection, offset, resource)
		], [ it, cancelIndicator |
			processUpdatedDocument(cancelIndicator)
			return null
		])
		return createProposals(contexts, null)
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
		val longestPrefix = contexts.map[prefix].maxBy[length]
		result.prefix = longestPrefix
		for (context : contexts) {
			if (context.prefix == longestPrefix) {
				for (element : context.firstSetGrammarElements) {
					createProposal(element, context, result)
				}
			}
		}
		Collections.sort(result.entries, [a, b | a.proposal.compareTo(b.proposal)])
		return result
	}

	protected def dispatch createProposal(AbstractElement element, ContentAssistContext context, ContentAssistResult result) {
		// not supported
	}
	
	protected def dispatch createProposal(Keyword keyword, ContentAssistContext context, ContentAssistResult result) {
		val value = keyword.value
		if (value.startsWith(context.prefix) && value.length > 1 && Character.isLetter(value.charAt(0))
				&& !result.entries.exists[proposal == value]) {
			result.entries += new ContentAssistResult.Entry(keyword.value, null, null, null)
		}
	}
	
}