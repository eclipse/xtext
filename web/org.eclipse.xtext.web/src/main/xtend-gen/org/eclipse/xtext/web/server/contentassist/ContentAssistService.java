/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.contentassist;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Singleton
@SuppressWarnings("all")
public class ContentAssistService {
  @Inject
  private Provider<ContentAssistContextFactory> contextFactoryProvider;
  
  private final ExecutorService pool = Executors.newFixedThreadPool(3);
  
  public ContentAssistResult createProposals(final XtextWebDocumentAccess document, final ITextRegion selection, final int offset) throws InvalidRequestException {
    ContentAssistContextFactory _get = this.contextFactoryProvider.get();
    final Procedure1<ContentAssistContextFactory> _function = new Procedure1<ContentAssistContextFactory>() {
      @Override
      public void apply(final ContentAssistContextFactory it) {
        it.setPool(ContentAssistService.this.pool);
      }
    };
    final ContentAssistContextFactory contextFactory = ObjectExtensions.<ContentAssistContextFactory>operator_doubleArrow(_get, _function);
    final CancelableUnitOfWork<ContentAssistContext[], IXtextWebDocument> _function_1 = new CancelableUnitOfWork<ContentAssistContext[], IXtextWebDocument>() {
      @Override
      public ContentAssistContext[] exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        String _text = it.getText();
        XtextResource _resource = it.getResource();
        return contextFactory.create(_text, selection, offset, _resource);
      }
    };
    final ContentAssistContext[] contexts = document.<ContentAssistContext[]>readOnly(_function_1);
    final ContentAssistResult result = new ContentAssistResult();
    for (final ContentAssistContext context : contexts) {
      ImmutableList<AbstractElement> _firstSetGrammarElements = context.getFirstSetGrammarElements();
      for (final AbstractElement element : _firstSetGrammarElements) {
        this.createProposal(element, context, result);
      }
    }
    ArrayList<ContentAssistResult.Entry> _entries = result.getEntries();
    final Comparator<ContentAssistResult.Entry> _function_2 = new Comparator<ContentAssistResult.Entry>() {
      @Override
      public int compare(final ContentAssistResult.Entry a, final ContentAssistResult.Entry b) {
        String _proposal = a.getProposal();
        String _proposal_1 = b.getProposal();
        return _proposal.compareTo(_proposal_1);
      }
    };
    Collections.<ContentAssistResult.Entry>sort(_entries, _function_2);
    return result;
  }
  
  protected Boolean _createProposal(final AbstractElement element, final ContentAssistContext context, final ContentAssistResult result) {
    return null;
  }
  
  protected Boolean _createProposal(final Keyword keyword, final ContentAssistContext context, final ContentAssistResult result) {
    boolean _xblockexpression = false;
    {
      final String value = keyword.getValue();
      boolean _xifexpression = false;
      boolean _and = false;
      boolean _and_1 = false;
      int _length = value.length();
      boolean _greaterThan = (_length > 1);
      if (!_greaterThan) {
        _and_1 = false;
      } else {
        char _charAt = value.charAt(0);
        boolean _isLetter = Character.isLetter(_charAt);
        _and_1 = _isLetter;
      }
      if (!_and_1) {
        _and = false;
      } else {
        ArrayList<ContentAssistResult.Entry> _entries = result.getEntries();
        final Function1<ContentAssistResult.Entry, Boolean> _function = new Function1<ContentAssistResult.Entry, Boolean>() {
          @Override
          public Boolean apply(final ContentAssistResult.Entry it) {
            String _proposal = it.getProposal();
            return Boolean.valueOf(Objects.equal(_proposal, value));
          }
        };
        boolean _exists = IterableExtensions.<ContentAssistResult.Entry>exists(_entries, _function);
        boolean _not = (!_exists);
        _and = _not;
      }
      if (_and) {
        ArrayList<ContentAssistResult.Entry> _entries_1 = result.getEntries();
        String _value = keyword.getValue();
        ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(_value, null, null, null);
        _xifexpression = _entries_1.add(_entry);
      }
      _xblockexpression = _xifexpression;
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  protected Boolean createProposal(final AbstractElement keyword, final ContentAssistContext context, final ContentAssistResult result) {
    if (keyword instanceof Keyword) {
      return _createProposal((Keyword)keyword, context, result);
    } else if (keyword != null) {
      return _createProposal(keyword, context, result);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(keyword, context, result).toString());
    }
  }
}
