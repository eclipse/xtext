/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.contentassist;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Service class for content assist proposals.
 */
@Singleton
@SuppressWarnings("all")
public class ContentAssistService {
  public final static int DEFAULT_PROPOSALS_LIMIT = 1000;
  
  @Inject
  private Provider<ContentAssistContextFactory> contextFactoryProvider;
  
  @Inject
  private ExecutorService executorService;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private IdeContentProposalProvider proposalProvider;
  
  /**
   * Create content assist proposals at the given caret offset. This document read operation
   * is scheduled with higher priority, so currently running operations may be canceled.
   * The document processing is rescheduled as background work afterwards.
   */
  public ContentAssistResult createProposals(final XtextWebDocumentAccess document, final ITextRegion selection, final int caretOffset, final int proposalsLimit) throws InvalidRequestException {
    final String[] stateIdWrapper = new String[1];
    final CancelableUnitOfWork<ContentAssistContext[], IXtextWebDocument> _function = new CancelableUnitOfWork<ContentAssistContext[], IXtextWebDocument>() {
      @Override
      public ContentAssistContext[] exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        ContentAssistContext[] _xblockexpression = null;
        {
          String _stateId = it.getStateId();
          stateIdWrapper[0] = _stateId;
          _xblockexpression = ContentAssistService.this.getContexts(it, selection, caretOffset);
        }
        return _xblockexpression;
      }
    };
    final ContentAssistContext[] contexts = document.<ContentAssistContext[]>priorityReadOnly(_function);
    String _get = stateIdWrapper[0];
    return this.createProposals(((List<ContentAssistContext>)Conversions.doWrapArray(contexts)), _get, proposalsLimit);
  }
  
  /**
   * Apply a text update and then create content assist proposals. This document read operation
   * is scheduled with higher priority, so currently running operations may be canceled.
   * The document processing is rescheduled as background work afterwards.
   */
  public ContentAssistResult createProposalsWithUpdate(final XtextWebDocumentAccess document, final String deltaText, final int deltaOffset, final int deltaReplaceLength, final ITextRegion selection, final int caretOffset, final int proposalsLimit) throws InvalidRequestException {
    final String[] stateIdWrapper = new String[1];
    final CancelableUnitOfWork<ContentAssistContext[], IXtextWebDocument> _function = new CancelableUnitOfWork<ContentAssistContext[], IXtextWebDocument>() {
      @Override
      public ContentAssistContext[] exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        ContentAssistContext[] _xblockexpression = null;
        {
          it.setDirty(true);
          it.createNewStateId();
          String _stateId = it.getStateId();
          stateIdWrapper[0] = _stateId;
          it.updateText(deltaText, deltaOffset, deltaReplaceLength);
          _xblockexpression = ContentAssistService.this.getContexts(it, selection, caretOffset);
        }
        return _xblockexpression;
      }
    };
    final ContentAssistContext[] contexts = document.<ContentAssistContext[]>modify(_function);
    String _get = stateIdWrapper[0];
    return this.createProposals(((List<ContentAssistContext>)Conversions.doWrapArray(contexts)), _get, proposalsLimit);
  }
  
  public ContentAssistContext[] getContexts(final IXtextWebDocument document, final ITextRegion selection, final int caretOffset) {
    ContentAssistContext[] _xblockexpression = null;
    {
      ContentAssistContextFactory _get = this.contextFactoryProvider.get();
      final Procedure1<ContentAssistContextFactory> _function = new Procedure1<ContentAssistContextFactory>() {
        @Override
        public void apply(final ContentAssistContextFactory it) {
          it.setPool(ContentAssistService.this.executorService);
        }
      };
      final ContentAssistContextFactory contextFactory = ObjectExtensions.<ContentAssistContextFactory>operator_doubleArrow(_get, _function);
      String _text = document.getText();
      XtextResource _resource = document.getResource();
      _xblockexpression = contextFactory.create(_text, selection, caretOffset, _resource);
    }
    return _xblockexpression;
  }
  
  /**
   * Invoke the proposal provider and put the results into a {@link ContentAssistResult} object.
   */
  protected ContentAssistResult createProposals(final List<ContentAssistContext> contexts, final String stateId, final int proposalsLimit) {
    final ContentAssistResult result = new ContentAssistResult(stateId);
    boolean _isEmpty = contexts.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final HashSet<Pair<Integer, ContentAssistEntry>> proposals = new HashSet<Pair<Integer, ContentAssistEntry>>();
      final IIdeContentProposalAcceptor acceptor = new IIdeContentProposalAcceptor() {
        @Override
        public void accept(final ContentAssistEntry entry, final int priority) {
          Pair<Integer, ContentAssistEntry> _mappedTo = Pair.<Integer, ContentAssistEntry>of(Integer.valueOf(priority), entry);
          proposals.add(_mappedTo);
        }
        
        @Override
        public boolean canAcceptMoreProposals() {
          int _size = proposals.size();
          return (_size < proposalsLimit);
        }
      };
      this.proposalProvider.createProposals(contexts, acceptor);
      List<ContentAssistEntry> _entries = result.getEntries();
      final Comparator<Pair<Integer, ContentAssistEntry>> _function = new Comparator<Pair<Integer, ContentAssistEntry>>() {
        @Override
        public int compare(final Pair<Integer, ContentAssistEntry> p1, final Pair<Integer, ContentAssistEntry> p2) {
          Integer _key = p2.getKey();
          Integer _key_1 = p1.getKey();
          final int prioResult = _key.compareTo(_key_1);
          if ((prioResult != 0)) {
            return prioResult;
          }
          final ContentAssistEntry v1 = p1.getValue();
          final ContentAssistEntry v2 = p2.getValue();
          boolean _and = false;
          String _label = v1.getLabel();
          boolean _tripleNotEquals = (_label != null);
          if (!_tripleNotEquals) {
            _and = false;
          } else {
            String _label_1 = v2.getLabel();
            boolean _tripleNotEquals_1 = (_label_1 != null);
            _and = _tripleNotEquals_1;
          }
          if (_and) {
            String _label_2 = v1.getLabel();
            String _label_3 = v2.getLabel();
            return _label_2.compareTo(_label_3);
          } else {
            String _label_4 = v1.getLabel();
            boolean _tripleNotEquals_2 = (_label_4 != null);
            if (_tripleNotEquals_2) {
              String _label_5 = v1.getLabel();
              String _proposal = v2.getProposal();
              return _label_5.compareTo(_proposal);
            } else {
              String _label_6 = v2.getLabel();
              boolean _tripleNotEquals_3 = (_label_6 != null);
              if (_tripleNotEquals_3) {
                String _proposal_1 = v1.getProposal();
                String _label_7 = v2.getLabel();
                return _proposal_1.compareTo(_label_7);
              } else {
                String _proposal_2 = v1.getProposal();
                String _proposal_3 = v2.getProposal();
                return _proposal_2.compareTo(_proposal_3);
              }
            }
          }
        }
      };
      List<Pair<Integer, ContentAssistEntry>> _sortWith = IterableExtensions.<Pair<Integer, ContentAssistEntry>>sortWith(proposals, _function);
      final Function1<Pair<Integer, ContentAssistEntry>, ContentAssistEntry> _function_1 = new Function1<Pair<Integer, ContentAssistEntry>, ContentAssistEntry>() {
        @Override
        public ContentAssistEntry apply(final Pair<Integer, ContentAssistEntry> it) {
          return it.getValue();
        }
      };
      List<ContentAssistEntry> _map = ListExtensions.<Pair<Integer, ContentAssistEntry>, ContentAssistEntry>map(_sortWith, _function_1);
      _entries.addAll(_map);
    }
    return result;
  }
  
  @Pure
  public IdeContentProposalProvider getProposalProvider() {
    return this.proposalProvider;
  }
}
