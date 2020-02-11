/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.contentassist;

import com.google.inject.Inject;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IPrefixMatcher;
import org.eclipse.xtext.ide.editor.contentassist.IProposalConflictHelper;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Factory for content assist entries. Whenever possible, you should use this creator instead of building entries
 * directly, since prefix matching and conflict handling is done here.
 * 
 * @since 2.10
 * @noreference
 */
@SuppressWarnings("all")
public class IdeContentProposalCreator {
  @Inject
  private IPrefixMatcher prefixMatcher;
  
  @Inject
  private IProposalConflictHelper conflictHelper;
  
  /**
   * Returns an entry with the given proposal and the prefix from the context, or null if the proposal is not valid.
   */
  public ContentAssistEntry createProposal(final String proposal, final ContentAssistContext context) {
    return this.createProposal(proposal, context.getPrefix(), context, ContentAssistEntry.KIND_UNKNOWN, null);
  }
  
  /**
   * Returns an entry of kind snippet with the given proposal and label and the prefix from the context, or null if the proposal is not valid.
   * @since 2.16
   */
  public ContentAssistEntry createSnippet(final String proposal, final String label, final ContentAssistContext context) {
    final Procedure1<ContentAssistEntry> _function = (ContentAssistEntry it) -> {
      it.setLabel(label);
    };
    return this.createProposal(proposal, context.getPrefix(), context, ContentAssistEntry.KIND_SNIPPET, _function);
  }
  
  /**
   * Returns an entry with the given proposal and the prefix from the context, or null if the proposal is not valid.
   * If it is valid, the initializer function is applied to it.
   */
  public ContentAssistEntry createProposal(final String proposal, final ContentAssistContext context, final Procedure1<? super ContentAssistEntry> init) {
    return this.createProposal(proposal, context.getPrefix(), context, ContentAssistEntry.KIND_UNKNOWN, init);
  }
  
  /**
   * Returns an entry with the given proposal and the prefix from the context, or null if the proposal is not valid.
   * If it is valid, the initializer function is applied to it.
   */
  public ContentAssistEntry createProposal(final String proposal, final ContentAssistContext context, final String kind, final Procedure1<? super ContentAssistEntry> init) {
    return this.createProposal(proposal, context.getPrefix(), context, kind, init);
  }
  
  /**
   * Returns an entry with the given proposal and prefix, or null if the proposal is not valid.
   * If it is valid, the initializer function is applied to it.
   */
  public ContentAssistEntry createProposal(final String proposal, final String prefix, final ContentAssistContext context, final String kind, final Procedure1<? super ContentAssistEntry> init) {
    boolean _isValidProposal = this.isValidProposal(proposal, prefix, context);
    if (_isValidProposal) {
      final ContentAssistEntry result = new ContentAssistEntry();
      result.setProposal(proposal);
      result.setPrefix(prefix);
      if ((kind != null)) {
        result.setKind(kind);
      }
      if ((init != null)) {
        init.apply(result);
      }
      return result;
    }
    return null;
  }
  
  public boolean isValidProposal(final String proposal, final String prefix, final ContentAssistContext context) {
    return (((!StringExtensions.isNullOrEmpty(proposal)) && this.prefixMatcher.isCandidateMatchingPrefix(proposal, prefix)) && (!this.conflictHelper.existsConflict(proposal, context)));
  }
}
