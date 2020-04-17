/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.contentassist;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalCreator;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities;
import org.eclipse.xtext.ide.editor.contentassist.IdeCrossrefProposalProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Extension;
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
  private IdeContentProposalCreator proposalCreator;
  
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
    return contexts;
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
          String _xifexpression = null;
          String _name = rule.getName();
          boolean _equals = Objects.equal(_name, "STRING");
          if (_equals) {
            String _feature = assignment.getFeature();
            String _plus = ("\"" + _feature);
            _xifexpression = (_plus + "\"");
          } else {
            _xifexpression = assignment.getFeature();
          }
          final String proposal = _xifexpression;
          final Procedure1<ContentAssistEntry> _function = (ContentAssistEntry it) -> {
            String _name_1 = rule.getName();
            boolean _equals_1 = Objects.equal(_name_1, "STRING");
            if (_equals_1) {
              List<TextRegion> _editPositions = it.getEditPositions();
              int _offset = context.getOffset();
              int _plus_1 = (_offset + 1);
              int _length = proposal.length();
              int _minus = (_length - 2);
              TextRegion _textRegion = new TextRegion(_plus_1, _minus);
              _editPositions.add(_textRegion);
              it.setKind(ContentAssistEntry.KIND_TEXT);
            } else {
              List<TextRegion> _editPositions_1 = it.getEditPositions();
              int _offset_1 = context.getOffset();
              int _length_1 = proposal.length();
              TextRegion _textRegion_1 = new TextRegion(_offset_1, _length_1);
              _editPositions_1.add(_textRegion_1);
              it.setKind(ContentAssistEntry.KIND_VALUE);
            }
            it.setDescription(rule.getName());
          };
          final ContentAssistEntry entry = this.proposalCreator.createProposal(proposal, context, _function);
          acceptor.accept(entry, this.proposalPriorities.getDefaultPriority(entry));
        }
      }
    }
  }
  
  protected void _createProposals(final Keyword keyword, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    boolean _filterKeyword = this.filterKeyword(keyword, context);
    if (_filterKeyword) {
      final ContentAssistEntry entry = this.proposalCreator.createProposal(keyword.getValue(), context, ContentAssistEntry.KIND_KEYWORD, null);
      if ((entry != null)) {
        acceptor.accept(entry, this.proposalPriorities.getKeywordPriority(keyword.getValue(), entry));
      }
    }
  }
  
  protected boolean filterKeyword(final Keyword keyword, final ContentAssistContext context) {
    return true;
  }
  
  protected void _createProposals(final RuleCall ruleCall, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
  }
  
  protected void _createProposals(final CrossReference reference, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    final EClassifier type = this._currentTypeFinder.findCurrentTypeAfter(reference);
    if ((type instanceof EClass)) {
      final EReference ereference = GrammarUtil.getReference(reference, ((EClass)type));
      final EObject currentModel = context.getCurrentModel();
      if (((ereference != null) && (currentModel != null))) {
        final IScope scope = this.scopeProvider.getScope(currentModel, ereference);
        this.crossrefProposalProvider.lookupCrossReference(scope, reference, context, acceptor, 
          this.getCrossrefFilter(reference, context));
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
  protected IdeContentProposalCreator getProposalCreator() {
    return this.proposalCreator;
  }
  
  @Pure
  protected IdeContentProposalPriorities getProposalPriorities() {
    return this.proposalPriorities;
  }
}
