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
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
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
  
  protected final static String TERMINAL = "terminal";
  
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
        boolean _switchResult = false;
        String _type = it.getType();
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(_type, ContentAssistService.KEYWORD)) {
            _matched=true;
            boolean _or = false;
            int _size = proposals.size();
            boolean _equals = (_size == 1);
            if (_equals) {
              _or = true;
            } else {
              String _proposal = it.getProposal();
              char _charAt = _proposal.charAt(0);
              boolean _isLetter = Character.isLetter(_charAt);
              _or = _isLetter;
            }
            _switchResult = _or;
          }
        }
        if (!_matched) {
          _switchResult = true;
        }
        return Boolean.valueOf(_switchResult);
      }
    };
    return IterableExtensions.<ContentAssistResult.Entry>filter(proposals, _function);
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
  
  protected void _createProposal(final AbstractElement element, final ContentAssistContext context, final Set<ContentAssistResult.Entry> proposals) {
  }
  
  protected void _createProposal(final Assignment assignment, final ContentAssistContext context, final Set<ContentAssistResult.Entry> proposals) {
    AbstractElement _terminal = assignment.getTerminal();
    if ((_terminal instanceof CrossReference)) {
      AbstractElement _terminal_1 = assignment.getTerminal();
      this.createProposal(_terminal_1, context, proposals);
    }
  }
  
  protected void _createProposal(final Keyword keyword, final ContentAssistContext context, final Set<ContentAssistResult.Entry> proposals) {
    final String value = keyword.getValue();
    String _prefix = context.getPrefix();
    boolean _startsWith = value.startsWith(_prefix);
    if (_startsWith) {
      String _prefix_1 = context.getPrefix();
      ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(ContentAssistService.KEYWORD, _prefix_1);
      final Procedure1<ContentAssistResult.Entry> _function = new Procedure1<ContentAssistResult.Entry>() {
        @Override
        public void apply(final ContentAssistResult.Entry it) {
          String _value = keyword.getValue();
          it.setProposal(_value);
        }
      };
      ContentAssistResult.Entry _doubleArrow = ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function);
      proposals.add(_doubleArrow);
    }
  }
  
  protected void _createProposal(final RuleCall ruleCall, final ContentAssistContext context, final Set<ContentAssistResult.Entry> proposals) {
    boolean _and = false;
    AbstractRule _rule = ruleCall.getRule();
    if (!(_rule instanceof TerminalRule)) {
      _and = false;
    } else {
      String _prefix = context.getPrefix();
      boolean _isEmpty = _prefix.isEmpty();
      _and = _isEmpty;
    }
    if (_and) {
      String _prefix_1 = context.getPrefix();
      ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(ContentAssistService.TERMINAL, _prefix_1);
      final Procedure1<ContentAssistResult.Entry> _function = new Procedure1<ContentAssistResult.Entry>() {
        @Override
        public void apply(final ContentAssistResult.Entry it) {
          AbstractRule _rule = ruleCall.getRule();
          String _name = _rule.getName();
          boolean _equals = Objects.equal(_name, "STRING");
          if (_equals) {
            final EObject container = ruleCall.eContainer();
            if ((container instanceof Assignment)) {
              String _feature = ((Assignment)container).getFeature();
              String _plus = ("\"" + _feature);
              String _plus_1 = (_plus + "\"");
              it.setProposal(_plus_1);
              AbstractRule _rule_1 = ruleCall.getRule();
              String _name_1 = _rule_1.getName();
              it.setDescription(_name_1);
            } else {
              AbstractRule _rule_2 = ruleCall.getRule();
              String _name_2 = _rule_2.getName();
              String _plus_2 = ("\"" + _name_2);
              String _plus_3 = (_plus_2 + "\"");
              it.setProposal(_plus_3);
            }
            ArrayList<ContentAssistResult.EditPosition> _editPositions = it.getEditPositions();
            int _offset = context.getOffset();
            int _plus_4 = (_offset + 1);
            String _proposal = it.getProposal();
            int _length = _proposal.length();
            int _minus = (_length - 2);
            ContentAssistResult.EditPosition _editPosition = new ContentAssistResult.EditPosition(_plus_4, _minus);
            _editPositions.add(_editPosition);
          } else {
            final EObject container_1 = ruleCall.eContainer();
            if ((container_1 instanceof Assignment)) {
              String _feature_1 = ((Assignment)container_1).getFeature();
              it.setProposal(_feature_1);
              AbstractRule _rule_3 = ruleCall.getRule();
              String _name_3 = _rule_3.getName();
              it.setDescription(_name_3);
            } else {
              AbstractRule _rule_4 = ruleCall.getRule();
              String _name_4 = _rule_4.getName();
              it.setProposal(_name_4);
            }
            ArrayList<ContentAssistResult.EditPosition> _editPositions_1 = it.getEditPositions();
            int _offset_1 = context.getOffset();
            String _proposal_1 = it.getProposal();
            int _length_1 = _proposal_1.length();
            ContentAssistResult.EditPosition _editPosition_1 = new ContentAssistResult.EditPosition(_offset_1, _length_1);
            _editPositions_1.add(_editPosition_1);
          }
        }
      };
      ContentAssistResult.Entry _doubleArrow = ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function);
      proposals.add(_doubleArrow);
    }
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
              final String elementName = _name.toString();
              String _prefix = context.getPrefix();
              boolean _startsWith = elementName.startsWith(_prefix);
              if (_startsWith) {
                String _prefix_1 = context.getPrefix();
                ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(ContentAssistService.CROSSREF, _prefix_1);
                final Procedure1<ContentAssistResult.Entry> _function = new Procedure1<ContentAssistResult.Entry>() {
                  @Override
                  public void apply(final ContentAssistResult.Entry it) {
                    it.setProposal(elementName);
                    EClass _eClass = description.getEClass();
                    String _name = _eClass.getName();
                    it.setDescription(_name);
                  }
                };
                ContentAssistResult.Entry _doubleArrow = ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function);
                proposals.add(_doubleArrow);
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
    } else if (assignment instanceof RuleCall) {
      _createProposal((RuleCall)assignment, context, proposals);
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
