/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.example.statemachine.ide;

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

import com.google.inject.Inject;

public class StatemachineSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
	@Inject
	private OperationCanceledManager operationCanceledManager;

	@Override
	protected boolean highlightElement(EObject o, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (o instanceof Signal) {
			highlightSignal(o, (Signal) o, StatemachinePackage.Literals.SIGNAL__NAME, acceptor, cancelIndicator);
		} else if (o instanceof Command) {
			highlightSignal(o, ((Command) o).getSignal(), StatemachinePackage.Literals.COMMAND__SIGNAL, acceptor,
					cancelIndicator);
		} else if (o instanceof Event) {
			highlightSignal(o, ((Event) o).getSignal(), StatemachinePackage.Literals.EVENT__SIGNAL, acceptor,
					cancelIndicator);
		}
		return false;
	}

	protected void highlightSignal(EObject owner, Signal signal, EStructuralFeature feature,
			IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		operationCanceledManager.checkCanceled(cancelIndicator);
		for (INode n : NodeModelUtils.findNodesForFeature(owner, feature)) {
			acceptor.addPosition(n.getOffset(), n.getLength(), signal.eClass().getName());
		}
	}
}
