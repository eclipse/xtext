package org.eclipse.xtext.example.arithmetics.ui.editor.hierarchy

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.xtext.example.arithmetics.arithmetics.AbstractDefinition
import org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsPackage
import org.eclipse.xtext.ide.editor.hierarchy.DefaultCallHierarchyBuilder
import org.eclipse.xtext.resource.IReferenceDescription

import static extension org.eclipse.xtext.EcoreUtil2.*

class ArithmeticsCallHierarchyBuilder extends DefaultCallHierarchyBuilder {

	@Inject
	ArithmeticsCallHierarchyNodeLocationProvider arithmeticsCallHierarchyNodeLocationProvider

	override protected getHierarchyNodeLocationProvider() {
		arithmeticsCallHierarchyNodeLocationProvider
	}

	override protected findDeclaration(URI objectURI) {
		val description = objectURI.description
		if (description?.EClass.definition)
			return description

		return readOnly(objectURI) [ object |
			object.getContainerOfType(AbstractDefinition).description
		]
	}

	override protected filterReference(IReferenceDescription reference) {
		reference !== null && reference.EReference.EType.definition
	}

	protected def boolean isDefinition(EClassifier type) {
		ArithmeticsPackage.Literals.ABSTRACT_DEFINITION.isAssignable(type)
	}

}
