/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.contentassist;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class ContentAssistService {
  public final static int DEFAULT_PROPOSALS_LIMIT = 1000;
  
  @Inject
  private Provider<ContentAssistContextFactory> contextFactoryProvider;
  
  @Inject
  private ExecutorService executorService;
  
  @Inject
  private IdeContentProposalProvider proposalProvider;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  public Iterable<ContentAssistEntry> createProposals(final String document, final int caretOffset, final XtextResource resource, final CancelIndicator cancelIndicator) {
    final TextRegion selection = new TextRegion(caretOffset, 0);
    return this.createProposals(document, selection, caretOffset, resource, cancelIndicator);
  }
  
  public Iterable<ContentAssistEntry> createProposals(final String document, final TextRegion selection, final int caretOffset, final XtextResource resource, final CancelIndicator cancelIndicator) {
    return this.createProposals(document, selection, caretOffset, resource, ContentAssistService.DEFAULT_PROPOSALS_LIMIT, cancelIndicator);
  }
  
  public Iterable<ContentAssistEntry> createProposals(final String document, final TextRegion selection, final int caretOffset, final XtextResource resource, final int proposalsLimit, final CancelIndicator cancelIndicator) {
    final Comparator<Pair<Integer, ContentAssistEntry>> _function = (Pair<Integer, ContentAssistEntry> p1, Pair<Integer, ContentAssistEntry> p2) -> {
      Integer _key = p2.getKey();
      Integer _key_1 = p1.getKey();
      final int prioResult = _key.compareTo(_key_1);
      if ((prioResult != 0)) {
        return prioResult;
      }
      String _elvis = null;
      ContentAssistEntry _value = p1.getValue();
      String _label = _value.getLabel();
      if (_label != null) {
        _elvis = _label;
      } else {
        ContentAssistEntry _value_1 = p1.getValue();
        String _proposal = _value_1.getProposal();
        _elvis = _proposal;
      }
      final String s1 = _elvis;
      String _elvis_1 = null;
      ContentAssistEntry _value_2 = p2.getValue();
      String _label_1 = _value_2.getLabel();
      if (_label_1 != null) {
        _elvis_1 = _label_1;
      } else {
        ContentAssistEntry _value_3 = p2.getValue();
        String _proposal_1 = _value_3.getProposal();
        _elvis_1 = _proposal_1;
      }
      final String s2 = _elvis_1;
      final int ignoreCase = s1.compareToIgnoreCase(s2);
      if ((ignoreCase == 0)) {
        return s1.compareTo(s2);
      }
      return ignoreCase;
    };
    final TreeSet<Pair<Integer, ContentAssistEntry>> entries = new TreeSet<Pair<Integer, ContentAssistEntry>>(_function);
    final IIdeContentProposalAcceptor acceptor = new IIdeContentProposalAcceptor() {
      @Override
      public void accept(final ContentAssistEntry entry, final int priority) {
        if ((entry != null)) {
          String _proposal = entry.getProposal();
          boolean _tripleEquals = (_proposal == null);
          if (_tripleEquals) {
            throw new IllegalArgumentException("proposal must not be null.");
          }
          Pair<Integer, ContentAssistEntry> _mappedTo = Pair.<Integer, ContentAssistEntry>of(Integer.valueOf(priority), entry);
          entries.add(_mappedTo);
        }
        ContentAssistService.this.operationCanceledManager.checkCanceled(cancelIndicator);
      }
      
      @Override
      public boolean canAcceptMoreProposals() {
        int _size = entries.size();
        return (_size < proposalsLimit);
      }
    };
    this.createProposals(document, selection, caretOffset, resource, acceptor);
    final Function1<Pair<Integer, ContentAssistEntry>, ContentAssistEntry> _function_1 = (Pair<Integer, ContentAssistEntry> it) -> {
      return it.getValue();
    };
    return IterableExtensions.<Pair<Integer, ContentAssistEntry>, ContentAssistEntry>map(entries, _function_1);
  }
  
  public void createProposals(final String document, final TextRegion selection, final int caretOffset, final XtextResource resource, final IIdeContentProposalAcceptor acceptor) {
    int _length = document.length();
    boolean _greaterThan = (caretOffset > _length);
    if (_greaterThan) {
      return;
    }
    final ContentAssistContextFactory contextFactory = this.contextFactoryProvider.get();
    contextFactory.setPool(this.executorService);
    final ContentAssistContext[] contexts = contextFactory.create(document, selection, caretOffset, resource);
    this.proposalProvider.createProposals(((Collection<ContentAssistContext>)Conversions.doWrapArray(contexts)), acceptor);
  }
}
