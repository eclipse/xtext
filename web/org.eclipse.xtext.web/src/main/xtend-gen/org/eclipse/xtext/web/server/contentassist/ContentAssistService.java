/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.contentassist;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
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
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

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
    return this.createProposals(contexts, _get_1);
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
    return this.createProposals(contexts, _get_1);
  }
  
  protected ContentAssistResult createProposals(final ContentAssistContext[] contexts, final String stateId) {
    final ContentAssistResult result = new ContentAssistResult();
    result.setStateId(stateId);
    boolean _isEmpty = ((List<ContentAssistContext>)Conversions.doWrapArray(contexts)).isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final HashSet<ContentAssistResult.Entry> proposals = new HashSet<ContentAssistResult.Entry>();
      final IAcceptor<ContentAssistResult.Entry> _function = new IAcceptor<ContentAssistResult.Entry>() {
        @Override
        public void accept(final ContentAssistResult.Entry it) {
          proposals.add(it);
        }
      };
      final IAcceptor<ContentAssistResult.Entry> acceptor = _function;
      final Function1<ContentAssistContext, String> _function_1 = new Function1<ContentAssistContext, String>() {
        @Override
        public String apply(final ContentAssistContext it) {
          return it.getPrefix();
        }
      };
      List<String> _map = ListExtensions.<ContentAssistContext, String>map(((List<ContentAssistContext>)Conversions.doWrapArray(contexts)), _function_1);
      final Function1<String, Integer> _function_2 = new Function1<String, Integer>() {
        @Override
        public Integer apply(final String it) {
          return Integer.valueOf(it.length());
        }
      };
      final String longestPrefix = IterableExtensions.<String, Integer>maxBy(_map, _function_2);
      for (final ContentAssistContext context : contexts) {
        String _prefix = context.getPrefix();
        boolean _equals = Objects.equal(_prefix, longestPrefix);
        if (_equals) {
          this.proposalProvider.createProposals(context, acceptor);
        }
      }
      ArrayList<ContentAssistResult.Entry> _entries = result.getEntries();
      Iterable<ContentAssistResult.Entry> _filter = this.filter(proposals);
      Iterables.<ContentAssistResult.Entry>addAll(_entries, _filter);
      ArrayList<ContentAssistResult.Entry> _entries_1 = result.getEntries();
      this.sort(_entries_1);
    }
    return result;
  }
  
  protected Iterable<ContentAssistResult.Entry> filter(final Collection<ContentAssistResult.Entry> proposals) {
    final Function1<ContentAssistResult.Entry, Boolean> _function = new Function1<ContentAssistResult.Entry, Boolean>() {
      @Override
      public Boolean apply(final ContentAssistResult.Entry it) {
        boolean _xblockexpression = false;
        {
          boolean _or = false;
          String _proposal = it.getProposal();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_proposal);
          if (_isNullOrEmpty) {
            _or = true;
          } else {
            boolean _matchesPrefix = ContentAssistService.this.matchesPrefix(it);
            boolean _not = (!_matchesPrefix);
            _or = _not;
          }
          if (_or) {
            return Boolean.valueOf(false);
          }
          boolean _switchResult = false;
          String _type = it.getType();
          boolean _matched = false;
          if (!_matched) {
            if (Objects.equal(_type, ContentAssistResult.KEYWORD)) {
              _matched=true;
              boolean _or_1 = false;
              int _size = proposals.size();
              boolean _equals = (_size == 1);
              if (_equals) {
                _or_1 = true;
              } else {
                String _proposal_1 = it.getProposal();
                char _charAt = _proposal_1.charAt(0);
                boolean _isLetter = Character.isLetter(_charAt);
                _or_1 = _isLetter;
              }
              _switchResult = _or_1;
            }
          }
          if (!_matched) {
            _switchResult = true;
          }
          _xblockexpression = _switchResult;
        }
        return Boolean.valueOf(_xblockexpression);
      }
    };
    return IterableExtensions.<ContentAssistResult.Entry>filter(proposals, _function);
  }
  
  protected boolean matchesPrefix(final ContentAssistResult.Entry entry) {
    boolean _or = false;
    boolean _or_1 = false;
    String _proposal = entry.getProposal();
    String _prefix = entry.getPrefix();
    boolean _startsWith = _proposal.startsWith(_prefix);
    if (_startsWith) {
      _or_1 = true;
    } else {
      String _proposal_1 = entry.getProposal();
      char _charAt = _proposal_1.charAt(0);
      boolean _isDelimiter = this.isDelimiter(_charAt);
      _or_1 = _isDelimiter;
    }
    if (_or_1) {
      _or = true;
    } else {
      String _prefix_1 = entry.getPrefix();
      String _prefix_2 = entry.getPrefix();
      int _length = _prefix_2.length();
      int _minus = (_length - 1);
      char _charAt_1 = _prefix_1.charAt(_minus);
      boolean _isDelimiter_1 = this.isDelimiter(_charAt_1);
      _or = _isDelimiter_1;
    }
    return _or;
  }
  
  protected boolean isDelimiter(final char c) {
    boolean _isJavaIdentifierPart = Character.isJavaIdentifierPart(c);
    return (!_isJavaIdentifierPart);
  }
  
  protected void sort(final List<ContentAssistResult.Entry> proposals) {
    final Comparator<ContentAssistResult.Entry> _function = new Comparator<ContentAssistResult.Entry>() {
      @Override
      public int compare(final ContentAssistResult.Entry a, final ContentAssistResult.Entry b) {
        int _xifexpression = (int) 0;
        String _type = a.getType();
        String _type_1 = b.getType();
        boolean _equals = Objects.equal(_type, _type_1);
        if (_equals) {
          String _proposal = a.getProposal();
          String _proposal_1 = b.getProposal();
          _xifexpression = _proposal.compareTo(_proposal_1);
        } else {
          String _type_2 = a.getType();
          String _type_3 = b.getType();
          _xifexpression = _type_2.compareTo(_type_3);
        }
        return _xifexpression;
      }
    };
    Collections.<ContentAssistResult.Entry>sort(proposals, _function);
  }
}
