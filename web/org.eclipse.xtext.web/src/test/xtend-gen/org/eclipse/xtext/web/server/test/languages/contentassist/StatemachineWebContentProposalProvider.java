/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test.languages.contentassist;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage;
import org.eclipse.xtext.web.server.contentassist.AbstractDeclarativeWebContentProposalProvider;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.contentassist.Proposals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class StatemachineWebContentProposalProvider extends AbstractDeclarativeWebContentProposalProvider {
  @Proposals(rule = "BOOLEAN")
  public void completeBoolean(final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    String _prefix = context.getPrefix();
    ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(ContentAssistResult.TERMINAL, _prefix);
    final Procedure1<ContentAssistResult.Entry> _function = new Procedure1<ContentAssistResult.Entry>() {
      @Override
      public void apply(final ContentAssistResult.Entry it) {
        it.setProposal("true");
      }
    };
    ContentAssistResult.Entry _doubleArrow = ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function);
    acceptor.accept(_doubleArrow);
    String _prefix_1 = context.getPrefix();
    ContentAssistResult.Entry _entry_1 = new ContentAssistResult.Entry(ContentAssistResult.TERMINAL, _prefix_1);
    final Procedure1<ContentAssistResult.Entry> _function_1 = new Procedure1<ContentAssistResult.Entry>() {
      @Override
      public void apply(final ContentAssistResult.Entry it) {
        it.setProposal("false");
      }
    };
    ContentAssistResult.Entry _doubleArrow_1 = ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry_1, _function_1);
    acceptor.accept(_doubleArrow_1);
  }
  
  @Proposals(rule = "Event", feature = "signal")
  public void completeEventSignal(final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
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
      String _prefix = context.getPrefix();
      ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(ContentAssistResult.CROSSREF, _prefix);
      final Procedure1<ContentAssistResult.Entry> _function_1 = new Procedure1<ContentAssistResult.Entry>() {
        @Override
        public void apply(final ContentAssistResult.Entry it) {
          QualifiedName _name = description.getName();
          String _string = _name.toString();
          it.setProposal(_string);
          it.setDescription("input signal");
        }
      };
      ContentAssistResult.Entry _doubleArrow = ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function_1);
      acceptor.accept(_doubleArrow);
    }
  }
  
  @Proposals(rule = "Command", feature = "signal")
  public void completeCommandSignal(final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    IScopeProvider _scopeProvider = this.getScopeProvider();
    EObject _currentModel = context.getCurrentModel();
    final IScope scope = _scopeProvider.getScope(_currentModel, StatemachinePackage.Literals.COMMAND__SIGNAL);
    Iterable<IEObjectDescription> _allElements = scope.getAllElements();
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      @Override
      public Boolean apply(final IEObjectDescription it) {
        EClass _eClass = it.getEClass();
        return Boolean.valueOf(Objects.equal(_eClass, StatemachinePackage.Literals.OUTPUT_SIGNAL));
      }
    };
    Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(_allElements, _function);
    for (final IEObjectDescription description : _filter) {
      String _prefix = context.getPrefix();
      ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(ContentAssistResult.CROSSREF, _prefix);
      final Procedure1<ContentAssistResult.Entry> _function_1 = new Procedure1<ContentAssistResult.Entry>() {
        @Override
        public void apply(final ContentAssistResult.Entry it) {
          QualifiedName _name = description.getName();
          String _string = _name.toString();
          it.setProposal(_string);
          it.setDescription("output signal");
        }
      };
      ContentAssistResult.Entry _doubleArrow = ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function_1);
      acceptor.accept(_doubleArrow);
    }
  }
}
