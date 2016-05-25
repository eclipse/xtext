/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.contentassist

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import java.util.TreeSet
import java.util.concurrent.ExecutorService
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.TextRegion

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class ContentAssistService {

	public static val DEFAULT_PROPOSALS_LIMIT = 1000

	@Inject Provider<ContentAssistContextFactory> contextFactoryProvider

	@Inject ExecutorService executorService

	@Inject IdeContentProposalProvider proposalProvider

	def Iterable<ContentAssistEntry> createProposals(
		String document,
		int caretOffset,
		XtextResource resource
	) {
		val selection = new TextRegion(caretOffset, 0)
		return createProposals(document, selection, caretOffset, resource)
	}

	def Iterable<ContentAssistEntry> createProposals(
		String document,
		TextRegion selection,
		int caretOffset,
		XtextResource resource
	) {
		return createProposals(document, selection, caretOffset, resource, DEFAULT_PROPOSALS_LIMIT)
	}

	def Iterable<ContentAssistEntry> createProposals(
		String document,
		TextRegion selection,
		int caretOffset,
		XtextResource resource,
		int proposalsLimit
	) {
		val entries = new TreeSet<Pair<Integer, ContentAssistEntry>> [ p1, p2 |
			val prioResult = p2.key.compareTo(p1.key)
			if (prioResult != 0)
				return prioResult
			val s1 = p1.value.label ?: p1.value.proposal
			val s2 = p2.value.label ?: p2.value.proposal
			return s1.compareTo(s2)
		]
		val acceptor = new IIdeContentProposalAcceptor {

			override accept(ContentAssistEntry entry, int priority) {
				if (entry !== null) {
					if (entry.proposal === null)
						throw new IllegalArgumentException('proposal must not be null.')
					entries.add(priority -> entry)
				}
			}

			override canAcceptMoreProposals() {
				entries.size < proposalsLimit
			}

		}
		createProposals(document, selection, caretOffset, resource, acceptor)
		return entries.map[value]
	}

	def void createProposals(
		String document,
		TextRegion selection,
		int caretOffset,
		XtextResource resource,
		IIdeContentProposalAcceptor acceptor
	) {
		if(caretOffset > document.length) return;

		val contextFactory = contextFactoryProvider.get
		contextFactory.pool = executorService
		val contexts = contextFactory.create(document, selection, caretOffset, resource)
		proposalProvider.createProposals(contexts, acceptor)
	}

}
