/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test.languages.contentassist;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;
import org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.contentassist.IWebContentProposaAcceptor;
import org.eclipse.xtext.web.server.contentassist.WebContentProposalPriorities;
import org.eclipse.xtext.web.server.contentassist.WebContentProposalProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class StatemachineWebContentProposalProvider extends WebContentProposalProvider {
  @Inject
  @Extension
  private StatemachineGrammarAccess _statemachineGrammarAccess;
  
  @Override
  protected void _createProposals(final RuleCall ruleCall, final ContentAssistContext context, final IWebContentProposaAcceptor acceptor) {
    AbstractRule _rule = ruleCall.getRule();
    boolean _matched = false;
    if (!_matched) {
      TerminalRule _bOOLEANRule = this._statemachineGrammarAccess.getBOOLEANRule();
      if (Objects.equal(_rule, _bOOLEANRule)) {
        _matched=true;
        String _prefix = context.getPrefix();
        ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(_prefix);
        final Procedure1<ContentAssistResult.Entry> _function = new Procedure1<ContentAssistResult.Entry>() {
          @Override
          public void apply(final ContentAssistResult.Entry it) {
            it.setProposal("true");
          }
        };
        final ContentAssistResult.Entry trueEntry = ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function);
        WebContentProposalPriorities _proposalPriorities = this.getProposalPriorities();
        int _defaultPriority = _proposalPriorities.getDefaultPriority(trueEntry);
        acceptor.accept(trueEntry, _defaultPriority);
        String _prefix_1 = context.getPrefix();
        ContentAssistResult.Entry _entry_1 = new ContentAssistResult.Entry(_prefix_1);
        final Procedure1<ContentAssistResult.Entry> _function_1 = new Procedure1<ContentAssistResult.Entry>() {
          @Override
          public void apply(final ContentAssistResult.Entry it) {
            it.setProposal("false");
          }
        };
        final ContentAssistResult.Entry falseEntry = ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry_1, _function_1);
        WebContentProposalPriorities _proposalPriorities_1 = this.getProposalPriorities();
        int _defaultPriority_1 = _proposalPriorities_1.getDefaultPriority(falseEntry);
        acceptor.accept(falseEntry, _defaultPriority_1);
      }
    }
    if (!_matched) {
      super._createProposals(ruleCall, context, acceptor);
    }
  }
  
  @Override
  protected void _createProposals(final Assignment assignment, final ContentAssistContext context, final IWebContentProposaAcceptor acceptor) {
    boolean _matched = false;
    if (!_matched) {
      StatemachineGrammarAccess.EventElements _eventAccess = this._statemachineGrammarAccess.getEventAccess();
      Assignment _signalAssignment_0 = _eventAccess.getSignalAssignment_0();
      if (Objects.equal(assignment, _signalAssignment_0)) {
        _matched=true;
        IScopeProvider _scopeProvider = this.getScopeProvider();
        EObject _currentModel = context.getCurrentModel();
        final IScope scope = _scopeProvider.getScope(_currentModel, StatemachinePackage.Literals.EVENT__SIGNAL);
        Iterable<IEObjectDescription> _allElements = scope.getAllElements();
        final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
          @Override
          public Boolean apply(final IEObjectDescription it) {
            EClass _eClass = it.getEClass();
            return Boolean.valueOf(Objects.equal(_eClass, StatemachinePackage.Literals.INPUT_SIGNAL));
          }
        };
        Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(_allElements, _function);
        for (final IEObjectDescription description : _filter) {
          {
            String _prefix = context.getPrefix();
            ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(_prefix);
            final Procedure1<ContentAssistResult.Entry> _function_1 = new Procedure1<ContentAssistResult.Entry>() {
              @Override
              public void apply(final ContentAssistResult.Entry it) {
                QualifiedName _name = description.getName();
                String _string = _name.toString();
                it.setProposal(_string);
                it.setDescription("input signal");
              }
            };
            final ContentAssistResult.Entry entry = ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function_1);
            WebContentProposalPriorities _proposalPriorities = this.getProposalPriorities();
            int _crossRefPriority = _proposalPriorities.getCrossRefPriority(description, entry);
            acceptor.accept(entry, _crossRefPriority);
          }
        }
      }
    }
    if (!_matched) {
      StatemachineGrammarAccess.CommandElements _commandAccess = this._statemachineGrammarAccess.getCommandAccess();
      Assignment _signalAssignment_1 = _commandAccess.getSignalAssignment_1();
      if (Objects.equal(assignment, _signalAssignment_1)) {
        _matched=true;
        IScopeProvider _scopeProvider_1 = this.getScopeProvider();
        EObject _currentModel_1 = context.getCurrentModel();
        final IScope scope_1 = _scopeProvider_1.getScope(_currentModel_1, StatemachinePackage.Literals.COMMAND__SIGNAL);
        Iterable<IEObjectDescription> _allElements_1 = scope_1.getAllElements();
        final Function1<IEObjectDescription, Boolean> _function_1 = new Function1<IEObjectDescription, Boolean>() {
          @Override
          public Boolean apply(final IEObjectDescription it) {
            EClass _eClass = it.getEClass();
            return Boolean.valueOf(Objects.equal(_eClass, StatemachinePackage.Literals.OUTPUT_SIGNAL));
          }
        };
        Iterable<IEObjectDescription> _filter_1 = IterableExtensions.<IEObjectDescription>filter(_allElements_1, _function_1);
        for (final IEObjectDescription description_1 : _filter_1) {
          {
            String _prefix = context.getPrefix();
            ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(_prefix);
            final Procedure1<ContentAssistResult.Entry> _function_2 = new Procedure1<ContentAssistResult.Entry>() {
              @Override
              public void apply(final ContentAssistResult.Entry it) {
                QualifiedName _name = description_1.getName();
                String _string = _name.toString();
                it.setProposal(_string);
                it.setDescription("output signal");
              }
            };
            final ContentAssistResult.Entry entry = ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function_2);
            WebContentProposalPriorities _proposalPriorities = this.getProposalPriorities();
            int _crossRefPriority = _proposalPriorities.getCrossRefPriority(description_1, entry);
            acceptor.accept(entry, _crossRefPriority);
          }
        }
      }
    }
    if (!_matched) {
      super._createProposals(assignment, context, acceptor);
    }
  }
  
  public void createProposals(final AbstractElement assignment, final ContentAssistContext context, final IWebContentProposaAcceptor acceptor) {
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
}
