package org.eclipse.xtext.web.example.statemachine.ide

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.web.example.statemachine.statemachine.Command
import org.eclipse.xtext.web.example.statemachine.statemachine.Event
import org.eclipse.xtext.web.example.statemachine.statemachine.Signal

import static org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage.Literals.*

import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

class StatemachineSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {
	
	override provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		resource?.allContents?.forEach [ 
			switch it {
				Signal:
					highlightSignal(it, SIGNAL__NAME, acceptor)
				Command:
					highlightSignal(signal, COMMAND__SIGNAL, acceptor)
				Event:
					highlightSignal(signal, EVENT__SIGNAL, acceptor)
			}
		]
	}
	
	protected def highlightSignal(EObject owner, Signal signal, EStructuralFeature feature, IHighlightedPositionAcceptor acceptor) {
		owner.findNodesForFeature(feature).forEach[
			acceptor.addPosition(offset, length, signal.eClass.name)
		]
	}
}