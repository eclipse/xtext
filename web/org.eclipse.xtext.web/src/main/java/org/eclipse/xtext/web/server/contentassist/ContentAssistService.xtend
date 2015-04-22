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
import java.util.concurrent.Executors
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.data.ContentAssistResult
import org.eclipse.xtext.web.server.model.XtextDocument

@Singleton
class ContentAssistService {
	
	@Inject Provider<ContentAssistContextFactory> contextFactoryProvider
	
	val pool = Executors.newFixedThreadPool(3)
	
	def createProposals(XtextDocument document, ITextRegion selection, int offset, String requiredStateId)
			throws InvalidRequestException {
		val contextFactory = contextFactoryProvider.get() => [it.pool = pool]
		val contexts = document.readOnly[ access |
			access.checkStateId(requiredStateId)
			contextFactory.create(access.text, selection, offset, access.resource)
		]
		val result = new ContentAssistResult
		for (context : contexts) {
			for (element : context.firstSetGrammarElements) {
				createProposal(element, context, result)
			}
		}
		result.entries.sort[a, b | a.proposal.compareTo(b.proposal)]
		return result
	}

	protected def dispatch createProposal(AbstractElement element, ContentAssistContext context, ContentAssistResult result) {
		// not supported
	}
	
	protected def dispatch createProposal(Keyword keyword, ContentAssistContext context, ContentAssistResult result) {
		val value = keyword.value
		if (value.length > 1 && Character.isLetter(value.charAt(0)) && !result.entries.exists[proposal == value]) {
			result.entries += new ContentAssistResult.Entry(keyword.value, null, null, null)
		}
	}
	
}