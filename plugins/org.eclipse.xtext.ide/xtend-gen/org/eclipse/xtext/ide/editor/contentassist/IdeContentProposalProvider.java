/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.contentassist;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities;
import org.eclipse.xtext.ide.editor.contentassist.IdeCrossrefProposalProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.CurrentTypeFinder;

/**
 * Generic content proposal provider for use in different IDE contexts. This provider is
 * <em>not</em> used by the Eclipse integration, which has its own abstraction for
 * content assist proposals.
 * @noreference
 */
@SuppressWarnings("all")
public class IdeContentProposalProvider {
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Inject
  private IScopeProvider scopeProvider;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Inject
  private IdeCrossrefProposalProvider crossrefProposalProvider;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Inject
  private IdeContentProposalPriorities proposalPriorities;
  
  @Inject
  @Extension
  private CurrentTypeFinder _currentTypeFinder;
  
  /**
   * Create content assist proposals and pass them to the given acceptor.
   */
  public void createProposals(final Collection<ContentAssistContext> contexts, final IIdeContentProposalAcceptor acceptor) {
    Iterable<ContentAssistContext> _filteredContexts = this.getFilteredContexts(contexts);
    for (final ContentAssistContext context : _filteredContexts) {
      ImmutableList<AbstractElement> _firstSetGrammarElements = context.getFirstSetGrammarElements();
      for (final AbstractElement element : _firstSetGrammarElements) {
        {
          boolean _canAcceptMoreProposals = acceptor.canAcceptMoreProposals();
          boolean _not = (!_canAcceptMoreProposals);
          if (_not) {
            return;
          }
          this.createProposals(element, context, acceptor);
        }
      }
    }
  }
  
  protected Iterable<ContentAssistContext> getFilteredContexts(final Collection<ContentAssistContext> contexts) {
    ContentAssistContext selectedContext = null;
    for (final ContentAssistContext context : contexts) {
      if (((selectedContext == null) || (this.isAcceptable(context) && ((context.getPrefix().length() > selectedContext.getPrefix().length()) || (!this.isAcceptable(selectedContext)))))) {
        selectedContext = context;
      }
    }
    final ContentAssistContext finalSelectedContext = selectedContext;
    final Function1<ContentAssistContext, Boolean> _function = new Function1<ContentAssistContext, Boolean>() {
      @Override
      public Boolean apply(final ContentAssistContext context) {
        return Boolean.valueOf(((context == finalSelectedContext) || (Objects.equal(context.getPrefix(), finalSelectedContext.getPrefix()) && IdeContentProposalProvider.this.isAcceptable(context))));
      }
    };
    return IterableExtensions.<ContentAssistContext>filter(contexts, _function);
  }
  
  protected boolean isAcceptable(final ContentAssistContext context) {
    final String prefix = context.getPrefix();
    return (prefix.isEmpty() || Character.isJavaIdentifierPart(prefix.charAt((prefix.length() - 1))));
  }
  
  protected void _createProposals(final AbstractElement element, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
  }
  
  protected void _createProposals(final Assignment assignment, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    final AbstractElement terminal = assignment.getTerminal();
    if ((terminal instanceof CrossReference)) {
      this.createProposals(terminal, context, acceptor);
    } else {
      if ((terminal instanceof RuleCall)) {
        final AbstractRule rule = ((RuleCall)terminal).getRule();
        if (((rule instanceof TerminalRule) && context.getPrefix().isEmpty())) {
          ContentAssistEntry _contentAssistEntry = new ContentAssistEntry();
          final Procedure1<ContentAssistEntry> _function = new Procedure1<ContentAssistEntry>() {
            @Override
            public void apply(final ContentAssistEntry it) {
              String _prefix = context.getPrefix();
              it.setPrefix(_prefix);
              String _name = rule.getName();
              boolean _equals = Objects.equal(_name, "STRING");
              if (_equals) {
                String _feature = assignment.getFeature();
                String _plus = ("\"" + _feature);
                String _plus_1 = (_plus + "\"");
                it.setProposal(_plus_1);
                ArrayList<TextRegion> _editPositions = it.getEditPositions();
                int _offset = context.getOffset();
                int _plus_2 = (_offset + 1);
                String _proposal = it.getProposal();
                int _length = _proposal.length();
                int _minus = (_length - 2);
                TextRegion _textRegion = new TextRegion(_plus_2, _minus);
                _editPositions.add(_textRegion);
              } else {
                String _feature_1 = assignment.getFeature();
                it.setProposal(_feature_1);
                ArrayList<TextRegion> _editPositions_1 = it.getEditPositions();
                int _offset_1 = context.getOffset();
                String _proposal_1 = it.getProposal();
                int _length_1 = _proposal_1.length();
                TextRegion _textRegion_1 = new TextRegion(_offset_1, _length_1);
                _editPositions_1.add(_textRegion_1);
              }
              String _name_1 = rule.getName();
              it.setDescription(_name_1);
            }
          };
          final ContentAssistEntry entry = ObjectExtensions.<ContentAssistEntry>operator_doubleArrow(_contentAssistEntry, _function);
          int _defaultPriority = this.proposalPriorities.getDefaultPriority(entry);
          acceptor.accept(entry, _defaultPriority);
        }
      }
    }
  }
  
  protected void _createProposals(final Keyword keyword, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    boolean _filterKeyword = this.filterKeyword(keyword, context);
    if (_filterKeyword) {
      ContentAssistEntry _contentAssistEntry = new ContentAssistEntry();
      final Procedure1<ContentAssistEntry> _function = new Procedure1<ContentAssistEntry>() {
        @Override
        public void apply(final ContentAssistEntry it) {
          String _prefix = context.getPrefix();
          it.setPrefix(_prefix);
          String _value = keyword.getValue();
          it.setProposal(_value);
        }
      };
      final ContentAssistEntry entry = ObjectExtensions.<ContentAssistEntry>operator_doubleArrow(_contentAssistEntry, _function);
      String _value = keyword.getValue();
      int _keywordPriority = this.proposalPriorities.getKeywordPriority(_value, entry);
      acceptor.accept(entry, _keywordPriority);
    }
  }
  
  protected boolean filterKeyword(final Keyword keyword, final ContentAssistContext context) {
    return (keyword.getValue().regionMatches(true, 0, context.getPrefix(), 0, context.getPrefix().length()) && (keyword.getValue().length() > context.getPrefix().length()));
  }
  
  protected void _createProposals(final RuleCall ruleCall, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
  }
  
  protected void _createProposals(final CrossReference reference, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    final EClassifier type = this._currentTypeFinder.findCurrentTypeAfter(reference);
    if ((type instanceof EClass)) {
      final EReference ereference = GrammarUtil.getReference(reference, ((EClass)type));
      if ((ereference != null)) {
        EObject _currentModel = context.getCurrentModel();
        final IScope scope = this.scopeProvider.getScope(_currentModel, ereference);
        Predicate<IEObjectDescription> _crossrefFilter = this.getCrossrefFilter(reference, context);
        this.crossrefProposalProvider.lookupCrossReference(scope, reference, context, acceptor, _crossrefFilter);
      }
    }
  }
  
  protected Predicate<IEObjectDescription> getCrossrefFilter(final CrossReference reference, final ContentAssistContext context) {
    return Predicates.<IEObjectDescription>alwaysTrue();
  }
  
  protected void createProposals(final AbstractElement assignment, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    if (assignment instanceof Assignment) {
      _createProposals((Assignment)assignment, context, acceptor);
      return;
    } else if (assignment instanceof CrossReference) {
      _createProposals((CrossReference)assignment, context, acceptor);
      return;
    } else if (assignment instanceof Keyword) {
      _createProposals((Keyword)assignment, context, acceptor);
      return;
    } else if (assignment instanceof RuleCall) {
      _createProposals((RuleCall)assignment, context, acceptor);
      return;
    } else if (assignment != null) {
      _createProposals(assignment, context, acceptor);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(assignment, context, acceptor).toString());
    }
  }
  
  @Pure
  protected IScopeProvider getScopeProvider() {
    return this.scopeProvider;
  }
  
  @Pure
  protected IQualifiedNameConverter getQualifiedNameConverter() {
    return this.qualifiedNameConverter;
  }
  
  @Pure
  protected IdeCrossrefProposalProvider getCrossrefProposalProvider() {
    return this.crossrefProposalProvider;
  }
  
  @Pure
  protected IdeContentProposalPriorities getProposalPriorities() {
    return this.proposalPriorities;
  }
}
