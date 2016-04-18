/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.statemachine.ide;

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
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineTemplateProposalProvider;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;
import org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class StatemachineWebContentProposalProvider extends IdeContentProposalProvider {
  @Inject
  @Extension
  private StatemachineGrammarAccess _statemachineGrammarAccess;
  
  @Inject
  private StatemachineTemplateProposalProvider templateProvider;
  
  @Override
  protected void _createProposals(final RuleCall ruleCall, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    AbstractRule _rule = ruleCall.getRule();
    boolean _matched = false;
    TerminalRule _bOOLEANRule = this._statemachineGrammarAccess.getBOOLEANRule();
    if (Objects.equal(_rule, _bOOLEANRule)) {
      _matched=true;
      String _prefix = context.getPrefix();
      boolean _startsWith = "true".startsWith(_prefix);
      if (_startsWith) {
        ContentAssistEntry _contentAssistEntry = new ContentAssistEntry();
        final Procedure1<ContentAssistEntry> _function = new Procedure1<ContentAssistEntry>() {
          @Override
          public void apply(final ContentAssistEntry it) {
            String _prefix = context.getPrefix();
            it.setPrefix(_prefix);
            it.setProposal("true");
          }
        };
        final ContentAssistEntry trueEntry = ObjectExtensions.<ContentAssistEntry>operator_doubleArrow(_contentAssistEntry, _function);
        IdeContentProposalPriorities _proposalPriorities = this.getProposalPriorities();
        int _defaultPriority = _proposalPriorities.getDefaultPriority(trueEntry);
        acceptor.accept(trueEntry, _defaultPriority);
      }
      String _prefix_1 = context.getPrefix();
      boolean _startsWith_1 = "false".startsWith(_prefix_1);
      if (_startsWith_1) {
        ContentAssistEntry _contentAssistEntry_1 = new ContentAssistEntry();
        final Procedure1<ContentAssistEntry> _function_1 = new Procedure1<ContentAssistEntry>() {
          @Override
          public void apply(final ContentAssistEntry it) {
            String _prefix = context.getPrefix();
            it.setPrefix(_prefix);
            it.setProposal("false");
          }
        };
        final ContentAssistEntry falseEntry = ObjectExtensions.<ContentAssistEntry>operator_doubleArrow(_contentAssistEntry_1, _function_1);
        IdeContentProposalPriorities _proposalPriorities_1 = this.getProposalPriorities();
        int _defaultPriority_1 = _proposalPriorities_1.getDefaultPriority(falseEntry);
        acceptor.accept(falseEntry, _defaultPriority_1);
      }
    }
    if (!_matched) {
      ParserRule _stateRule = this._statemachineGrammarAccess.getStateRule();
      if (Objects.equal(_rule, _stateRule)) {
        _matched=true;
        this.templateProvider.createStateProposal(context, acceptor);
      }
    }
    if (!_matched) {
      super._createProposals(ruleCall, context, acceptor);
    }
  }
  
  @Override
  protected void _createProposals(final Assignment assignment, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    boolean _matched = false;
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
          ContentAssistEntry _contentAssistEntry = new ContentAssistEntry();
          final Procedure1<ContentAssistEntry> _function_1 = new Procedure1<ContentAssistEntry>() {
            @Override
            public void apply(final ContentAssistEntry it) {
              it.setSource(description);
              String _prefix = context.getPrefix();
              it.setPrefix(_prefix);
              QualifiedName _name = description.getName();
              String _string = _name.toString();
              it.setProposal(_string);
              it.setDescription("input signal");
            }
          };
          final ContentAssistEntry entry = ObjectExtensions.<ContentAssistEntry>operator_doubleArrow(_contentAssistEntry, _function_1);
          IdeContentProposalPriorities _proposalPriorities = this.getProposalPriorities();
          int _crossRefPriority = _proposalPriorities.getCrossRefPriority(description, entry);
          acceptor.accept(entry, _crossRefPriority);
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
            ContentAssistEntry _contentAssistEntry = new ContentAssistEntry();
            final Procedure1<ContentAssistEntry> _function_2 = new Procedure1<ContentAssistEntry>() {
              @Override
              public void apply(final ContentAssistEntry it) {
                it.setSource(description_1);
                String _prefix = context.getPrefix();
                it.setPrefix(_prefix);
                QualifiedName _name = description_1.getName();
                String _string = _name.toString();
                it.setProposal(_string);
                it.setDescription("output signal");
              }
            };
            final ContentAssistEntry entry = ObjectExtensions.<ContentAssistEntry>operator_doubleArrow(_contentAssistEntry, _function_2);
            IdeContentProposalPriorities _proposalPriorities = this.getProposalPriorities();
            int _crossRefPriority = _proposalPriorities.getCrossRefPriority(description_1, entry);
            acceptor.accept(entry, _crossRefPriority);
          }
        }
      }
    }
    if (!_matched) {
      StatemachineGrammarAccess.EventElements _eventAccess_1 = this._statemachineGrammarAccess.getEventAccess();
      Assignment _valueAssignment_2 = _eventAccess_1.getValueAssignment_2();
      if (Objects.equal(assignment, _valueAssignment_2)) {
        _matched=true;
      }
      if (!_matched) {
        StatemachineGrammarAccess.CommandElements _commandAccess_1 = this._statemachineGrammarAccess.getCommandAccess();
        Assignment _newValueAssignment_3 = _commandAccess_1.getNewValueAssignment_3();
        if (Objects.equal(assignment, _newValueAssignment_3)) {
          _matched=true;
        }
      }
      if (_matched) {
      }
    }
    if (!_matched) {
      super._createProposals(assignment, context, acceptor);
    }
  }
  
  @Override
  protected boolean filterKeyword(final Keyword keyword, final ContentAssistContext context) {
    boolean _switchResult = false;
    boolean _matched = false;
    StatemachineGrammarAccess.StateElements _stateAccess = this._statemachineGrammarAccess.getStateAccess();
    Keyword _stateKeyword_0 = _stateAccess.getStateKeyword_0();
    if (Objects.equal(keyword, _stateKeyword_0)) {
      _matched=true;
      _switchResult = false;
    }
    if (!_matched) {
      _switchResult = super.filterKeyword(keyword, context);
    }
    return _switchResult;
  }
  
  public void createProposals(final AbstractElement assignment, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
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
