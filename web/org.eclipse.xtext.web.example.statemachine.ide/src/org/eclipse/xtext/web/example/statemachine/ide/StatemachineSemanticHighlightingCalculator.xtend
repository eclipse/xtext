package org.eclipse.xtext.web.example.statemachine.ide

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.web.example.statemachine.statemachine.Command
import org.eclipse.xtext.web.example.statemachine.statemachine.Event
import org.eclipse.xtext.web.example.statemachine.statemachine.Signal

import static org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage.Literals.*

import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

class StatemachineSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
	
	override protected highlightElement(EObject it, IHighlightedPositionAcceptor acceptor) {
		switch it {
				Signal:
					highlightSignal(it, SIGNAL__NAME, acceptor)
				Command:
					highlightSignal(signal, COMMAND__SIGNAL, acceptor)
				Event:
					highlightSignal(signal, EVENT__SIGNAL, acceptor)
			}
		return false
	}
	
	protected def highlightSignal(EObject owner, Signal signal, EStructuralFeature feature, IHighlightedPositionAcceptor acceptor) {
		owner.findNodesForFeature(feature).forEach[
			acceptor.addPosition(offset, length, signal.eClass.name)
		]
	}
}