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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.contentassist.IWebContentProposalAcceptor;
import org.eclipse.xtext.web.server.contentassist.WebContentProposalProvider;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.UpdateDocumentService;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Singleton
@SuppressWarnings("all")
public class ContentAssistService {
  @Inject
  private Provider<ContentAssistContextFactory> contextFactoryProvider;
  
  @Inject
  private WebContentProposalProvider proposalProvider;
  
  @Inject
  private ExecutorService executorService;
  
  @Inject
  @Extension
  private UpdateDocumentService _updateDocumentService;
  
  public ContentAssistResult createProposals(final XtextWebDocumentAccess document, final ITextRegion selection, final int offset) throws InvalidRequestException {
    ContentAssistContextFactory _get = this.contextFactoryProvider.get();
    final Procedure1<ContentAssistContextFactory> _function = new Procedure1<ContentAssistContextFactory>() {
      @Override
      public void apply(final ContentAssistContextFactory it) {
        it.setPool(ContentAssistService.this.executorService);
      }
    };
    final ContentAssistContextFactory contextFactory = ObjectExtensions.<ContentAssistContextFactory>operator_doubleArrow(_get, _function);
    final String[] stateIdWrapper = new String[1];
    final CancelableUnitOfWork<ContentAssistContext[], IXtextWebDocument> _function_1 = new CancelableUnitOfWork<ContentAssistContext[], IXtextWebDocument>() {
      @Override
      public ContentAssistContext[] exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        ContentAssistContext[] _xblockexpression = null;
        {
          String _stateId = it.getStateId();
          stateIdWrapper[0] = _stateId;
          String _text = it.getText();
          XtextResource _resource = it.getResource();
          _xblockexpression = contextFactory.create(_text, selection, offset, _resource);
        }
        return _xblockexpression;
      }
    };
    final CancelableUnitOfWork<ContentAssistContext[], IXtextWebDocument> _function_2 = new CancelableUnitOfWork<ContentAssistContext[], IXtextWebDocument>() {
      @Override
      public ContentAssistContext[] exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        ContentAssistService.this._updateDocumentService.processUpdatedDocument(it, cancelIndicator);
        return null;
      }
    };
    final ContentAssistContext[] contexts = document.<ContentAssistContext[]>priorityReadOnly(_function_1, _function_2);
    String _get_1 = stateIdWrapper[0];
    return this.createProposals(((List<ContentAssistContext>)Conversions.doWrapArray(contexts)), _get_1);
  }
  
  public ContentAssistResult createProposalsWithUpdate(final XtextWebDocumentAccess document, final String deltaText, final int deltaOffset, final int deltaReplaceLength, final ITextRegion textSelection, final int caretOffset) {
    ContentAssistContextFactory _get = this.contextFactoryProvider.get();
    final Procedure1<ContentAssistContextFactory> _function = new Procedure1<ContentAssistContextFactory>() {
      @Override
      public void apply(final ContentAssistContextFactory it) {
        it.setPool(ContentAssistService.this.executorService);
      }
    };
    final ContentAssistContextFactory contextFactory = ObjectExtensions.<ContentAssistContextFactory>operator_doubleArrow(_get, _function);
    final String[] stateIdWrapper = new String[1];
    final CancelableUnitOfWork<ContentAssistContext[], IXtextWebDocument> _function_1 = new CancelableUnitOfWork<ContentAssistContext[], IXtextWebDocument>() {
      @Override
      public ContentAssistContext[] exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        ContentAssistContext[] _xblockexpression = null;
        {
          it.setDirty(true);
          it.setProcessingCompleted(false);
          it.createNewStateId();
          String _stateId = it.getStateId();
          stateIdWrapper[0] = _stateId;
          it.updateText(deltaText, deltaOffset, deltaReplaceLength);
          String _text = it.getText();
          XtextResource _resource = it.getResource();
          _xblockexpression = contextFactory.create(_text, textSelection, caretOffset, _resource);
        }
        return _xblockexpression;
      }
    };
    final CancelableUnitOfWork<Object, IXtextWebDocument> _function_2 = new CancelableUnitOfWork<Object, IXtextWebDocument>() {
      @Override
      public Object exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        ContentAssistService.this._updateDocumentService.processUpdatedDocument(it, cancelIndicator);
        return null;
      }
    };
    final ContentAssistContext[] contexts = document.<ContentAssistContext[]>modify(_function_1, _function_2);
    String _get_1 = stateIdWrapper[0];
    return this.createProposals(((List<ContentAssistContext>)Conversions.doWrapArray(contexts)), _get_1);
  }
  
  protected ContentAssistResult createProposals(final List<ContentAssistContext> contexts, final String stateId) {
    final ContentAssistResult result = new ContentAssistResult();
    result.setStateId(stateId);
    boolean _isEmpty = contexts.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final HashSet<Pair<Integer, ContentAssistResult.Entry>> proposals = new HashSet<Pair<Integer, ContentAssistResult.Entry>>();
      final IWebContentProposalAcceptor _function = new IWebContentProposalAcceptor() {
        @Override
        public void accept(final ContentAssistResult.Entry entry, final int priority) {
          Pair<Integer, ContentAssistResult.Entry> _mappedTo = Pair.<Integer, ContentAssistResult.Entry>of(Integer.valueOf(priority), entry);
          proposals.add(_mappedTo);
        }
      };
      final IWebContentProposalAcceptor acceptor = _function;
      this.proposalProvider.createProposals(contexts, acceptor);
      ArrayList<ContentAssistResult.Entry> _entries = result.getEntries();
      final Comparator<Pair<Integer, ContentAssistResult.Entry>> _function_1 = new Comparator<Pair<Integer, ContentAssistResult.Entry>>() {
        @Override
        public int compare(final Pair<Integer, ContentAssistResult.Entry> p1, final Pair<Integer, ContentAssistResult.Entry> p2) {
          Integer _key = p2.getKey();
          Integer _key_1 = p1.getKey();
          final int prioResult = _key.compareTo(_key_1);
          if ((prioResult != 0)) {
            return prioResult;
          }
          final ContentAssistResult.Entry v1 = p1.getValue();
          final ContentAssistResult.Entry v2 = p2.getValue();
          boolean _and = false;
          String _name = v1.getName();
          boolean _tripleNotEquals = (_name != null);
          if (!_tripleNotEquals) {
            _and = false;
          } else {
            String _name_1 = v2.getName();
            boolean _tripleNotEquals_1 = (_name_1 != null);
            _and = _tripleNotEquals_1;
          }
          if (_and) {
            String _name_2 = v1.getName();
            String _name_3 = v2.getName();
            return _name_2.compareTo(_name_3);
          } else {
            String _name_4 = v1.getName();
            boolean _tripleNotEquals_2 = (_name_4 != null);
            if (_tripleNotEquals_2) {
              String _name_5 = v1.getName();
              String _proposal = v2.getProposal();
              return _name_5.compareTo(_proposal);
            } else {
              String _name_6 = v2.getName();
              boolean _tripleNotEquals_3 = (_name_6 != null);
              if (_tripleNotEquals_3) {
                String _proposal_1 = v1.getProposal();
                String _name_7 = v2.getName();
                return _proposal_1.compareTo(_name_7);
              } else {
                String _proposal_2 = v1.getProposal();
                String _proposal_3 = v2.getProposal();
                return _proposal_2.compareTo(_proposal_3);
              }
            }
          }
        }
      };
      List<Pair<Integer, ContentAssistResult.Entry>> _sortWith = IterableExtensions.<Pair<Integer, ContentAssistResult.Entry>>sortWith(proposals, _function_1);
      final Function1<Pair<Integer, ContentAssistResult.Entry>, ContentAssistResult.Entry> _function_2 = new Function1<Pair<Integer, ContentAssistResult.Entry>, ContentAssistResult.Entry>() {
        @Override
        public ContentAssistResult.Entry apply(final Pair<Integer, ContentAssistResult.Entry> it) {
          return it.getValue();
        }
      };
      List<ContentAssistResult.Entry> _map = ListExtensions.<Pair<Integer, ContentAssistResult.Entry>, ContentAssistResult.Entry>map(_sortWith, _function_2);
      _entries.addAll(_map);
    }
    return result;
  }
}
