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
import java.util.concurrent.ExecutorService
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.TextRegion

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
class ContentAssistService {

	public static val DEFAULT_PROPOSALS_LIMIT = 1000

	@Inject Provider<ContentAssistContextFactory> contextFactoryProvider

	@Inject ExecutorService executorService

	@Inject IdeContentProposalProvider proposalProvider
	
	def void createProposals(
		String document,
		int caretOffset,
		XtextResource resource,
		IIdeContentProposalAcceptor acceptor,
		CancelIndicator cancelIndicator
	) {
		val selection = new TextRegion(caretOffset, 0)
		createProposals(document, selection, caretOffset, resource, acceptor, cancelIndicator)
	}

	def void createProposals(
		String document,
		TextRegion selection,
		int caretOffset,
		XtextResource resource,
		IIdeContentProposalAcceptor acceptor,
		CancelIndicator cancelIndicator
	) {
		createProposals(document, selection, caretOffset, resource, acceptor)
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
