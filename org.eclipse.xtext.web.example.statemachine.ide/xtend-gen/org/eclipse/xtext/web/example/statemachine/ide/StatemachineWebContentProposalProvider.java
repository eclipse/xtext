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
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineTemplateProposalProvider;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;
import org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
      boolean _startsWith = "true".startsWith(context.getPrefix());
      if (_startsWith) {
        final ContentAssistEntry trueEntry = this.getProposalCreator().createProposal("true", context);
        acceptor.accept(trueEntry, this.getProposalPriorities().getDefaultPriority(trueEntry));
      }
      boolean _startsWith_1 = "false".startsWith(context.getPrefix());
      if (_startsWith_1) {
        final ContentAssistEntry falseEntry = this.getProposalCreator().createProposal("false", context);
        acceptor.accept(falseEntry, this.getProposalPriorities().getDefaultPriority(falseEntry));
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
    Assignment _signalAssignment_0 = this._statemachineGrammarAccess.getEventAccess().getSignalAssignment_0();
    if (Objects.equal(assignment, _signalAssignment_0)) {
      _matched=true;
      final IScope scope = this.getScopeProvider().getScope(context.getCurrentModel(), StatemachinePackage.Literals.EVENT__SIGNAL);
      final Function1<IEObjectDescription, Boolean> _function = (IEObjectDescription it) -> {
        EClass _eClass = it.getEClass();
        return Boolean.valueOf(Objects.equal(_eClass, StatemachinePackage.Literals.INPUT_SIGNAL));
      };
      Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(scope.getAllElements(), _function);
      for (final IEObjectDescription description : _filter) {
        {
          final Procedure1<ContentAssistEntry> _function_1 = (ContentAssistEntry it) -> {
            it.setSource(description);
            it.setDescription("input signal");
          };
          final ContentAssistEntry entry = this.getProposalCreator().createProposal(description.getName().toString(), context, _function_1);
          acceptor.accept(entry, this.getProposalPriorities().getCrossRefPriority(description, entry));
        }
      }
    }
    if (!_matched) {
      Assignment _signalAssignment_1 = this._statemachineGrammarAccess.getCommandAccess().getSignalAssignment_1();
      if (Objects.equal(assignment, _signalAssignment_1)) {
        _matched=true;
        final IScope scope_1 = this.getScopeProvider().getScope(context.getCurrentModel(), StatemachinePackage.Literals.COMMAND__SIGNAL);
        final Function1<IEObjectDescription, Boolean> _function_1 = (IEObjectDescription it) -> {
          EClass _eClass = it.getEClass();
          return Boolean.valueOf(Objects.equal(_eClass, StatemachinePackage.Literals.OUTPUT_SIGNAL));
        };
        Iterable<IEObjectDescription> _filter_1 = IterableExtensions.<IEObjectDescription>filter(scope_1.getAllElements(), _function_1);
        for (final IEObjectDescription description_1 : _filter_1) {
          {
            final Procedure1<ContentAssistEntry> _function_2 = (ContentAssistEntry it) -> {
              it.setSource(description_1);
              it.setDescription("output signal");
            };
            final ContentAssistEntry entry = this.getProposalCreator().createProposal(description_1.getName().toString(), context, _function_2);
            acceptor.accept(entry, this.getProposalPriorities().getCrossRefPriority(description_1, entry));
          }
        }
      }
    }
    if (!_matched) {
      Assignment _valueAssignment_2 = this._statemachineGrammarAccess.getEventAccess().getValueAssignment_2();
      if (Objects.equal(assignment, _valueAssignment_2)) {
        _matched=true;
      }
      if (!_matched) {
        Assignment _newValueAssignment_3 = this._statemachineGrammarAccess.getCommandAccess().getNewValueAssignment_3();
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
    Keyword _stateKeyword_0 = this._statemachineGrammarAccess.getStateAccess().getStateKeyword_0();
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
