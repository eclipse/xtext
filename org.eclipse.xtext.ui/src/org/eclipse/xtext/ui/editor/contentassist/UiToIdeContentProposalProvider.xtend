/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.jface.viewers.StyledString
import org.eclipse.swt.graphics.Image
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext.Builder
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalAcceptor
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import org.eclipse.xtext.util.TextRegion

/**
 * @author Titouan Vervack - Initial contribution and API
 * 
 * @since 2.12
 */
abstract class UiToIdeContentProposalProvider extends AbstractContentProposalProvider {

	@Inject IdeContentProposalProvider ideProvider
	@Inject Provider<Builder> builderProvider
	@Inject Provider<IdeContentProposalAcceptor> acceptorProvider

	override createProposals(ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val ideAcceptor = acceptorProvider.get()
		ideProvider.createProposals(#[context.getIdeContext], ideAcceptor)
		val uiAcceptor = new NullSafeCompletionProposalAcceptor(acceptor)

		val entries = ideAcceptor.entries
		entries.forEach [ entry, idx |
			val priority = computePriority(entries, idx)
			// createCompletionProposal calls isValidProposal
			val proposal = createCompletionProposal(entry.proposal, new StyledString(entry.label ?: entry.proposal),
				getImage(entry), priority, entry.prefix, context)
			uiAcceptor.accept(proposal)
		]
	}

	protected def int computePriority(Iterable<ContentAssistEntry> entries, int index) {
		entries.size - index
	}

	private def org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext getIdeContext(ContentAssistContext c) {
		val builder = builderProvider.get()
		val replaceRegion = c.replaceRegion
		builder
			.setPrefix(c.prefix)
			.setSelectedText(c.selectedText)
			.setRootModel(c.rootModel)
			.setRootNode(c.rootNode)
			.setCurrentModel(c.currentModel)
			.setPreviousModel(c.previousModel)
			.setCurrentNode(c.currentNode)
			.setLastCompleteNode(c.lastCompleteNode)
			.setOffset(c.offset)
			.setReplaceRegion(new TextRegion(replaceRegion.offset, replaceRegion.length))
			.setResource(c.resource)
		for (grammarElement : c.firstSetGrammarElements) {
			builder.accept(grammarElement)
		}
		return builder.toContext()
	}

	abstract protected def Image getImage(ContentAssistEntry entry)
}
