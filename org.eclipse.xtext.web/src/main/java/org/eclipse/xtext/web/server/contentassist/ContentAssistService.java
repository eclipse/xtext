/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.contentassist;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Service class for content assist proposals.
 */
@Singleton
public class ContentAssistService {
	public static final int DEFAULT_PROPOSALS_LIMIT = 1000;

	@Inject
	private Provider<ContentAssistContextFactory> contextFactoryProvider;

	@Inject
	private ExecutorService executorService;

	@Inject
	private IdeContentProposalProvider proposalProvider;

	/**
	 * Create content assist proposals at the given caret offset. This document read
	 * operation is scheduled with higher priority, so currently running operations
	 * may be canceled. The document processing is rescheduled as background work
	 * afterwards.
	 */
	public ContentAssistResult createProposals(XtextWebDocumentAccess document, ITextRegion selection, int caretOffset,
			int proposalsLimit) throws InvalidRequestException {
		String[] stateIdWrapper = new String[1];
		ContentAssistContext[] contexts = document
				.priorityReadOnly(new CancelableUnitOfWork<ContentAssistContext[], IXtextWebDocument>() {
					@Override
					public ContentAssistContext[] exec(IXtextWebDocument it, CancelIndicator cancelIndicator)
							throws Exception {
						stateIdWrapper[0] = it.getStateId();
						return getContexts(it, selection, caretOffset);
					}
				});
		List<ContentAssistContext> contextsList = Arrays.asList(contexts);
		return createProposals(contextsList, stateIdWrapper[0], proposalsLimit);
	}

	/**
	 * Apply a text update and then create content assist proposals. This document
	 * read operation is scheduled with higher priority, so currently running
	 * operations may be canceled. The document processing is rescheduled as
	 * background work afterwards.
	 */
	public ContentAssistResult createProposalsWithUpdate(XtextWebDocumentAccess document, String deltaText,
			int deltaOffset, int deltaReplaceLength, ITextRegion selection, int caretOffset, int proposalsLimit)
			throws InvalidRequestException {
		String[] stateIdWrapper = new String[1];
		ContentAssistContext[] contexts = document
				.modify(new CancelableUnitOfWork<ContentAssistContext[], IXtextWebDocument>() {
					@Override
					public ContentAssistContext[] exec(IXtextWebDocument it, CancelIndicator cancelIndicator)
							throws Exception {
						it.setDirty(true);
						it.createNewStateId();
						stateIdWrapper[0] = it.getStateId();
						it.updateText(deltaText, deltaOffset, deltaReplaceLength);
						return getContexts(it, selection, caretOffset);
					}
				});
		List<ContentAssistContext> contextsList = Arrays.asList(contexts);
		return createProposals(contextsList, stateIdWrapper[0], proposalsLimit);
	}

	public ContentAssistContext[] getContexts(IXtextWebDocument document, ITextRegion selection, int caretOffset) {
		if (caretOffset > document.getText().length()) {
			return new ContentAssistContext[] {};
		}
		ContentAssistContextFactory contextFactory = contextFactoryProvider.get();
		contextFactory.setPool(executorService);
		return contextFactory.create(document.getText(), selection, caretOffset, document.getResource());
	}

	/**
	 * Invoke the proposal provider and put the results into a
	 * {@link ContentAssistResult} object.
	 */
	protected ContentAssistResult createProposals(List<ContentAssistContext> contexts, String stateId,
			int proposalsLimit) {
		ContentAssistResult result = new ContentAssistResult(stateId);
		if (!contexts.isEmpty()) {
			Set<Pair<Integer, ContentAssistEntry>> proposals = new HashSet<Pair<Integer, ContentAssistEntry>>();
			IIdeContentProposalAcceptor acceptor = new IIdeContentProposalAcceptor() {
				@Override
				public void accept(ContentAssistEntry entry, int priority) {
					if (entry != null) {
						if (entry.getProposal() == null) {
							throw new IllegalArgumentException("proposal must not be null.");
						}
						proposals.add(Pair.of(priority, entry));
					}
				}

				@Override
				public boolean canAcceptMoreProposals() {
					return proposals.size() < proposalsLimit;
				}
			};
			proposalProvider.createProposals(contexts, acceptor);
			List<Pair<Integer, ContentAssistEntry>> sorted = IterableExtensions.sortWith(proposals,
					(Pair<Integer, ContentAssistEntry> p1, Pair<Integer, ContentAssistEntry> p2) -> {
						int prioResult = p2.getKey().compareTo(p1.getKey());
						if (prioResult != 0) {
							return prioResult;
						}
						String s1 = p1.getValue().getLabel();
						if (s1 == null) {
							s1 = p1.getValue().getProposal();
						}
						String s2 = p2.getValue().getLabel();
						if (s2 == null) {
							s2 = p2.getValue().getProposal();
						}
						return s1.compareTo(s2);
					});
			result.getEntries()
					.addAll(Lists.transform(sorted, (Pair<Integer, ContentAssistEntry> it) -> it.getValue()));
		}
		return result;
	}

	public IdeContentProposalProvider getProposalProvider() {
		return proposalProvider;
	}
}
