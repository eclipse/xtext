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
      Iterable<ContentAssistResult.Entry> _filter = this.proposalProvider.filter(proposals);
      Iterables.<ContentAssistResult.Entry>addAll(_entries, _filter);
      ArrayList<ContentAssistResult.Entry> _entries_1 = result.getEntries();
      this.proposalProvider.sort(_entries_1);
    }
    return result;
  }
}
