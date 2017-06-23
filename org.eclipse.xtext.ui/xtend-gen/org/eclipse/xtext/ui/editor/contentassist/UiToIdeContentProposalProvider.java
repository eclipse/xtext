/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.contentassist;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collections;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.AbstractContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Titouan Vervack - Initial contribution and API
 * 
 * @since 2.12
 */
@SuppressWarnings("all")
public abstract class UiToIdeContentProposalProvider extends AbstractContentProposalProvider {
  @Inject
  private IdeContentProposalProvider ideProvider;
  
  @Inject
  private Provider<ContentAssistContext.Builder> builderProvider;
  
  @Inject
  private Provider<IdeContentProposalAcceptor> acceptorProvider;
  
  @Override
  public void createProposals(final org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final IdeContentProposalAcceptor ideAcceptor = this.acceptorProvider.get();
    ContentAssistContext _ideContext = this.getIdeContext(context);
    this.ideProvider.createProposals(Collections.<ContentAssistContext>unmodifiableList(CollectionLiterals.<ContentAssistContext>newArrayList(_ideContext)), ideAcceptor);
    final AbstractContentProposalProvider.NullSafeCompletionProposalAcceptor uiAcceptor = new AbstractContentProposalProvider.NullSafeCompletionProposalAcceptor(acceptor);
    final Iterable<ContentAssistEntry> entries = ideAcceptor.getEntries();
    final Procedure2<ContentAssistEntry, Integer> _function = (ContentAssistEntry entry, Integer idx) -> {
      final int priority = this.computePriority(entries, (idx).intValue());
      String _elvis = null;
      String _label = entry.getLabel();
      if (_label != null) {
        _elvis = _label;
      } else {
        String _proposal = entry.getProposal();
        _elvis = _proposal;
      }
      StyledString _styledString = new StyledString(_elvis);
      final ICompletionProposal proposal = this.createCompletionProposal(entry.getProposal(), _styledString, 
        this.getImage(entry), priority, entry.getPrefix(), context);
      uiAcceptor.accept(proposal);
    };
    IterableExtensions.<ContentAssistEntry>forEach(entries, _function);
  }
  
  protected int computePriority(final Iterable<ContentAssistEntry> entries, final int index) {
    int _size = IterableExtensions.size(entries);
    return (_size - index);
  }
  
  private ContentAssistContext getIdeContext(final org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext c) {
    final ContentAssistContext.Builder builder = this.builderProvider.get();
    final Region replaceRegion = c.getReplaceRegion();
    ContentAssistContext.Builder _setOffset = builder.setPrefix(c.getPrefix()).setSelectedText(c.getSelectedText()).setRootModel(c.getRootModel()).setRootNode(c.getRootNode()).setCurrentModel(c.getCurrentModel()).setPreviousModel(c.getPreviousModel()).setCurrentNode(c.getCurrentNode()).setLastCompleteNode(c.getLastCompleteNode()).setOffset(c.getOffset());
    int _offset = replaceRegion.getOffset();
    int _length = replaceRegion.getLength();
    TextRegion _textRegion = new TextRegion(_offset, _length);
    _setOffset.setReplaceRegion(_textRegion).setResource(c.getResource());
    ImmutableList<AbstractElement> _firstSetGrammarElements = c.getFirstSetGrammarElements();
    for (final AbstractElement grammarElement : _firstSetGrammarElements) {
      builder.accept(grammarElement);
    }
    return builder.toContext();
  }
  
  protected abstract Image getImage(final ContentAssistEntry entry);
}
