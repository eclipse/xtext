/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.statemachine.ide;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.web.example.statemachine.statemachine.Command;
import org.eclipse.xtext.web.example.statemachine.statemachine.Event;
import org.eclipse.xtext.web.example.statemachine.statemachine.Signal;
import org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class StatemachineSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
  @Inject
  @Extension
  private OperationCanceledManager _operationCanceledManager;
  
  @Override
  protected boolean highlightElement(final EObject it, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof Signal) {
        _matched=true;
        this.highlightSignal(it, ((Signal)it), StatemachinePackage.Literals.SIGNAL__NAME, acceptor, cancelIndicator);
      }
    }
    if (!_matched) {
      if (it instanceof Command) {
        _matched=true;
        Signal _signal = ((Command)it).getSignal();
        this.highlightSignal(it, _signal, StatemachinePackage.Literals.COMMAND__SIGNAL, acceptor, cancelIndicator);
      }
    }
    if (!_matched) {
      if (it instanceof Event) {
        _matched=true;
        Signal _signal = ((Event)it).getSignal();
        this.highlightSignal(it, _signal, StatemachinePackage.Literals.EVENT__SIGNAL, acceptor, cancelIndicator);
      }
    }
    return false;
  }
  
  protected void highlightSignal(final EObject owner, final Signal signal, final EStructuralFeature feature, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    this._operationCanceledManager.checkCanceled(cancelIndicator);
    List<INode> _findNodesForFeature = NodeModelUtils.findNodesForFeature(owner, feature);
    for (final INode it : _findNodesForFeature) {
      int _offset = it.getOffset();
      int _length = it.getLength();
      EClass _eClass = signal.eClass();
      String _name = _eClass.getName();
      acceptor.addPosition(_offset, _length, _name);
    }
  }
}
