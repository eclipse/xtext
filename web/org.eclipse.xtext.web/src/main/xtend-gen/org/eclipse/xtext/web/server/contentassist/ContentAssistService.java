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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.UpdateDocumentService;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.CurrentTypeFinder;

@Singleton
@SuppressWarnings("all")
public class ContentAssistService {
  protected final static String KEYWORD = "keyword";
  
  protected final static String CROSSREF = "crossref";
  
  @Inject
  private Provider<ContentAssistContextFactory> contextFactoryProvider;
  
  @Inject
  private IScopeProvider scopeProvider;
  
  @Inject
  private ExecutorService executorService;
  
  @Inject
  @Extension
  private UpdateDocumentService _updateDocumentService;
  
  @Inject
  @Extension
  private CurrentTypeFinder _currentTypeFinder;
  
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
      final Function1<ContentAssistContext, String> _function = new Function1<ContentAssistContext, String>() {
        @Override
        public String apply(final ContentAssistContext it) {
          return it.getPrefix();
        }
      };
      List<String> _map = ListExtensions.<ContentAssistContext, String>map(((List<ContentAssistContext>)Conversions.doWrapArray(contexts)), _function);
      final Function1<String, Integer> _function_1 = new Function1<String, Integer>() {
        @Override
        public Integer apply(final String it) {
          return Integer.valueOf(it.length());
        }
      };
      final String longestPrefix = IterableExtensions.<String, Integer>maxBy(_map, _function_1);
      for (final ContentAssistContext context : contexts) {
        String _prefix = context.getPrefix();
        boolean _equals = Objects.equal(_prefix, longestPrefix);
        if (_equals) {
          ImmutableList<AbstractElement> _firstSetGrammarElements = context.getFirstSetGrammarElements();
          for (final AbstractElement element : _firstSetGrammarElements) {
            this.createProposal(element, context, proposals);
          }
        }
      }
      ArrayList<ContentAssistResult.Entry> _entries = result.getEntries();
      _entries.addAll(proposals);
      ArrayList<ContentAssistResult.Entry> _entries_1 = result.getEntries();
      Comparator<? super ContentAssistResult.Entry> _proposalComparator = this.getProposalComparator();
      Collections.<ContentAssistResult.Entry>sort(_entries_1, _proposalComparator);
    }
    return result;
  }
  
  protected Comparator<? super ContentAssistResult.Entry> getProposalComparator() {
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
    return _function;
  }
  
  protected void _createProposal(final AbstractElement element, final ContentAssistContext context, final Set<ContentAssistResult.Entry> proposals) {
  }
  
  protected void _createProposal(final Keyword keyword, final ContentAssistContext context, final Set<ContentAssistResult.Entry> proposals) {
    final String value = keyword.getValue();
    boolean _and = false;
    boolean _and_1 = false;
    String _prefix = context.getPrefix();
    boolean _startsWith = value.startsWith(_prefix);
    if (!_startsWith) {
      _and_1 = false;
    } else {
      int _length = value.length();
      boolean _greaterThan = (_length > 1);
      _and_1 = _greaterThan;
    }
    if (!_and_1) {
      _and = false;
    } else {
      char _charAt = value.charAt(0);
      boolean _isLetter = Character.isLetter(_charAt);
      _and = _isLetter;
    }
    if (_and) {
      String _prefix_1 = context.getPrefix();
      String _value = keyword.getValue();
      final ContentAssistResult.Entry entry = new ContentAssistResult.Entry(_prefix_1, _value, null, null, null);
      entry.setType(ContentAssistService.KEYWORD);
      proposals.add(entry);
    }
  }
  
  protected void _createProposal(final Assignment assignment, final ContentAssistContext context, final Set<ContentAssistResult.Entry> proposals) {
    AbstractElement _terminal = assignment.getTerminal();
    this.createProposal(_terminal, context, proposals);
  }
  
  protected void _createProposal(final CrossReference reference, final ContentAssistContext context, final Set<ContentAssistResult.Entry> proposals) {
    final EClassifier type = this._currentTypeFinder.findCurrentTypeAfter(reference);
    if ((type instanceof EClass)) {
      final EReference ereference = GrammarUtil.getReference(reference, ((EClass)type));
      if ((ereference != null)) {
        EObject _currentModel = context.getCurrentModel();
        final IScope scope = this.scopeProvider.getScope(_currentModel, ereference);
        try {
          Iterable<IEObjectDescription> _allElements = scope.getAllElements();
          for (final IEObjectDescription description : _allElements) {
            {
              QualifiedName _name = description.getName();
              String name = _name.toString();
              String _prefix = context.getPrefix();
              boolean _startsWith = name.startsWith(_prefix);
              boolean _not = (!_startsWith);
              if (_not) {
                QualifiedName _qualifiedName = description.getQualifiedName();
                String _string = _qualifiedName.toString();
                name = _string;
              }
              String _prefix_1 = context.getPrefix();
              boolean _startsWith_1 = name.startsWith(_prefix_1);
              if (_startsWith_1) {
                String _prefix_2 = context.getPrefix();
                EClass _eClass = description.getEClass();
                String _name_1 = _eClass.getName();
                final ContentAssistResult.Entry entry = new ContentAssistResult.Entry(_prefix_2, name, null, _name_1, null);
                entry.setType(ContentAssistService.CROSSREF);
                proposals.add(entry);
              }
            }
          }
        } catch (final Throwable _t) {
          if (_t instanceof UnsupportedOperationException) {
            final UnsupportedOperationException uoe = (UnsupportedOperationException)_t;
            uoe.printStackTrace();
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
  }
  
  protected void createProposal(final AbstractElement assignment, final ContentAssistContext context, final Set<ContentAssistResult.Entry> proposals) {
    if (assignment instanceof Assignment) {
      _createProposal((Assignment)assignment, context, proposals);
      return;
    } else if (assignment instanceof CrossReference) {
      _createProposal((CrossReference)assignment, context, proposals);
      return;
    } else if (assignment instanceof Keyword) {
      _createProposal((Keyword)assignment, context, proposals);
      return;
    } else if (assignment != null) {
      _createProposal(assignment, context, proposals);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(assignment, context, proposals).toString());
    }
  }
}
