/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist

import com.google.inject.Inject

/**
 * Factory for content assist entries. Whenever possible, you should use this creator instead of building entries
 * directly, since prefix matching and conflict handling is done here.
 * 
 * @since 2.10
 * @noreference
 */
class IdeContentProposalCreator {
	
	@Inject IPrefixMatcher prefixMatcher
	
	@Inject IProposalConflictHelper conflictHelper
	
	/**
	 * Returns an entry with the given proposal and the prefix from the context, or null if the proposal is not valid.
	 */
	def ContentAssistEntry createProposal(String proposal, ContentAssistContext context) {
		createProposal(proposal, context.prefix, context, ContentAssistEntry.KIND_UNKNOWN, null)
	}
	
	/**
	 * Returns an entry of kind snippet with the given proposal and label and the prefix from the context, or null if the proposal is not valid.
	 * @since 2.16
	 */
	def ContentAssistEntry createSnippet(String proposal, String label, ContentAssistContext context) {
		createProposal(proposal, context.prefix, context, ContentAssistEntry.KIND_SNIPPET) [
			it.label = label
		]
	}
	
	/**
	 * Returns an entry with the given proposal and the prefix from the context, or null if the proposal is not valid.
	 * If it is valid, the initializer function is applied to it.
	 */
	def ContentAssistEntry createProposal(String proposal, ContentAssistContext context, (ContentAssistEntry)=>void init) {
		createProposal(proposal, context.prefix, context, ContentAssistEntry.KIND_UNKNOWN, init)
	}
	
	/**
	 * Returns an entry with the given proposal and the prefix from the context, or null if the proposal is not valid.
	 * If it is valid, the initializer function is applied to it.
	 */
	def ContentAssistEntry createProposal(String proposal, ContentAssistContext context, String kind, (ContentAssistEntry)=>void init) {
		createProposal(proposal, context.prefix, context, kind, init)
	}
	
	/**
	 * Returns an entry with the given proposal and prefix, or null if the proposal is not valid.
	 * If it is valid, the initializer function is applied to it.
	 */
	def ContentAssistEntry createProposal(String proposal, String prefix, ContentAssistContext context, String kind,
			(ContentAssistEntry)=>void init) {
		if (isValidProposal(proposal, prefix, context)) {
			val result = new ContentAssistEntry
			result.proposal = proposal
			result.prefix = prefix
			if (kind !== null)
				result.kind = kind
			if (init !== null)
				init.apply(result)
			return result
		}
	}
	
	def boolean isValidProposal(String proposal, String prefix, ContentAssistContext context) {
		!proposal.nullOrEmpty && prefixMatcher.isCandidateMatchingPrefix(proposal, prefix)
			&& !conflictHelper.existsConflict(proposal, context)
	}
	
}