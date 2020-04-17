/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.contentassist;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.base.Strings;
import com.google.inject.Inject;

/**
 * Factory for content assist entries. Whenever possible, you should use this creator instead of building entries
 * directly, since prefix matching and conflict handling is done here.
 * 
 * @since 2.10
 * @noreference
 */
public class IdeContentProposalCreator {
	@Inject
	private IPrefixMatcher prefixMatcher;

	@Inject
	private IProposalConflictHelper conflictHelper;

	/**
	 * Returns an entry with the given proposal and the prefix from the context, or null if the proposal is not valid.
	 */
	public ContentAssistEntry createProposal(String proposal, ContentAssistContext context) {
		return createProposal(proposal, context.getPrefix(), context, ContentAssistEntry.KIND_UNKNOWN, null);
	}

	/**
	 * Returns an entry of kind snippet with the given proposal and label and the prefix from the context, or null if
	 * the proposal is not valid.
	 * 
	 * @since 2.16
	 */
	public ContentAssistEntry createSnippet(String proposal, String label, ContentAssistContext context) {
		return createProposal(proposal, context.getPrefix(), context, ContentAssistEntry.KIND_SNIPPET,
				(it) -> it.setLabel(label));
	}

	/**
	 * Returns an entry with the given proposal and the prefix from the context, or null if the proposal is not valid.
	 * If it is valid, the initializer function is applied to it.
	 */
	public ContentAssistEntry createProposal(String proposal, ContentAssistContext context,
			Procedure1<? super ContentAssistEntry> init) {
		return createProposal(proposal, context.getPrefix(), context, ContentAssistEntry.KIND_UNKNOWN, init);
	}

	/**
	 * Returns an entry with the given proposal and the prefix from the context, or null if the proposal is not valid.
	 * If it is valid, the initializer function is applied to it.
	 */
	public ContentAssistEntry createProposal(String proposal, ContentAssistContext context, String kind,
			Procedure1<? super ContentAssistEntry> init) {
		return createProposal(proposal, context.getPrefix(), context, kind, init);
	}

	/**
	 * Returns an entry with the given proposal and prefix, or null if the proposal is not valid. If it is valid, the
	 * initializer function is applied to it.
	 */
	public ContentAssistEntry createProposal(String proposal, String prefix, ContentAssistContext context, String kind,
			Procedure1<? super ContentAssistEntry> init) {
		if (isValidProposal(proposal, prefix, context)) {
			ContentAssistEntry result = new ContentAssistEntry();
			result.setProposal(proposal);
			result.setPrefix(prefix);
			if (kind != null) {
				result.setKind(kind);
			}
			if (init != null) {
				init.apply(result);
			}
			return result;
		}
		return null;
	}

	public boolean isValidProposal(String proposal, String prefix, ContentAssistContext context) {
		return !Strings.isNullOrEmpty(proposal) && prefixMatcher.isCandidateMatchingPrefix(proposal, prefix)
				&& !conflictHelper.existsConflict(proposal, context);
	}
}
