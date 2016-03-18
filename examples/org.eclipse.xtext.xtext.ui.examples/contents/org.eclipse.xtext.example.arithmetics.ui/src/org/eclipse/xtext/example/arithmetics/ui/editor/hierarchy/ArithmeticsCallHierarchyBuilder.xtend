package org.eclipse.xtext.example.arithmetics.ui.editor.hierarchy

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsPackage
import org.eclipse.xtext.ide.editor.hierarchy.DefaultCallHierarchyBuilder
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IReferenceDescription

import static extension org.eclipse.xtext.EcoreUtil2.*

class ArithmeticsCallHierarchyBuilder extends DefaultCallHierarchyBuilder {

	@Inject
	ArithmeticsCallHierarchyNodeLocationProvider arithmeticsCallHierarchyNodeLocationProvider

	override protected getHierarchyNodeLocationProvider() {
		arithmeticsCallHierarchyNodeLocationProvider
	}

	override protected getRootDeclaration(IEObjectDescription declaration) {
		if (declaration?.EClass.definition)
			return declaration
	}

	override protected getDeclaration(IReferenceDescription reference) {
		switch type : reference?.EReference?.EType {
			EClass case type.definition:
				return super.getDeclaration(reference)
		}
	}

	protected def boolean isDefinition(EClass type) {
		return ArithmeticsPackage.Literals.ABSTRACT_DEFINITION.isAssignableFrom(type)
	}

}
