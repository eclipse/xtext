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
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.log4j.Logger;
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
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.contentassist.CrossrefProposalCreator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.CurrentTypeFinder;

@SuppressWarnings("all")
public class WebContentProposalProvider {
  private final static Logger LOG = Logger.getLogger(WebContentProposalProvider.class);
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Inject
  private IScopeProvider scopeProvider;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Inject
  @Extension
  private CurrentTypeFinder _currentTypeFinder;
  
  public void createProposals(final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    ImmutableList<AbstractElement> _firstSetGrammarElements = context.getFirstSetGrammarElements();
    for (final AbstractElement element : _firstSetGrammarElements) {
      this.createProposals(element, context, acceptor);
    }
  }
  
  protected void _createProposals(final AbstractElement element, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
  }
  
  protected void _createProposals(final Assignment assignment, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    AbstractElement _terminal = assignment.getTerminal();
    if ((_terminal instanceof CrossReference)) {
      AbstractElement _terminal_1 = assignment.getTerminal();
      this.createProposals(_terminal_1, context, acceptor);
    }
  }
  
  protected void _createProposals(final Keyword keyword, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    final String value = keyword.getValue();
    String _prefix = context.getPrefix();
    boolean _startsWith = value.startsWith(_prefix);
    if (_startsWith) {
      String _prefix_1 = context.getPrefix();
      ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(ContentAssistResult.KEYWORD, _prefix_1);
      final Procedure1<ContentAssistResult.Entry> _function = new Procedure1<ContentAssistResult.Entry>() {
        @Override
        public void apply(final ContentAssistResult.Entry it) {
          String _value = keyword.getValue();
          it.setProposal(_value);
        }
      };
      ContentAssistResult.Entry _doubleArrow = ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function);
      acceptor.accept(_doubleArrow);
    }
  }
  
  protected void _createProposals(final RuleCall ruleCall, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
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
      ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(ContentAssistResult.TERMINAL, _prefix_1);
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
      acceptor.accept(_doubleArrow);
    }
  }
  
  protected void _createProposals(final CrossReference reference, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    final EClassifier type = this._currentTypeFinder.findCurrentTypeAfter(reference);
    if ((type instanceof EClass)) {
      final EReference ereference = GrammarUtil.getReference(reference, ((EClass)type));
      if ((ereference != null)) {
        EObject _currentModel = context.getCurrentModel();
        final IScope scope = this.scopeProvider.getScope(_currentModel, ereference);
        try {
          final CrossrefProposalCreator proposalCreator = new CrossrefProposalCreator(context, this.qualifiedNameConverter);
          Iterable<IEObjectDescription> _allElements = scope.getAllElements();
          for (final IEObjectDescription description : _allElements) {
            {
              QualifiedName _name = description.getName();
              final String elementName = _name.toString();
              String _prefix = context.getPrefix();
              boolean _startsWith = elementName.startsWith(_prefix);
              if (_startsWith) {
                ContentAssistResult.Entry _apply = proposalCreator.apply(description);
                acceptor.accept(_apply);
              }
            }
          }
        } catch (final Throwable _t) {
          if (_t instanceof UnsupportedOperationException) {
            final UnsupportedOperationException uoe = (UnsupportedOperationException)_t;
            WebContentProposalProvider.LOG.error("Failed to create content assist proposals for cross-reference.", uoe);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
  }
  
  protected void createProposals(final AbstractElement assignment, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
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
}
