/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.ide

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.web.example.statemachine.statemachine.Command
import org.eclipse.xtext.web.example.statemachine.statemachine.Event
import org.eclipse.xtext.web.example.statemachine.statemachine.Signal

import static org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage.Literals.*

import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

class StatemachineSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
	
	@Inject extension OperationCanceledManager
	
	override protected highlightElement(EObject it, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		switch it {
			Signal:
				highlightSignal(it, SIGNAL__NAME, acceptor, cancelIndicator)
			Command:
				highlightSignal(signal, COMMAND__SIGNAL, acceptor, cancelIndicator)
			Event:
				highlightSignal(signal, EVENT__SIGNAL, acceptor, cancelIndicator)
		}
		return false
	}
	
	protected def highlightSignal(EObject owner, Signal signal, EStructuralFeature feature,
			IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		cancelIndicator.checkCanceled
		owner.findNodesForFeature(feature).forEach[
			acceptor.addPosition(offset, length, signal.eClass.name)
		]
	}
}