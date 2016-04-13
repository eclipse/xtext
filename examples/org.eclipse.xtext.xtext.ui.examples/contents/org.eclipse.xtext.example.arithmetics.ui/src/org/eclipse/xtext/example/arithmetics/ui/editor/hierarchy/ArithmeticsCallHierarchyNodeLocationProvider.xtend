package org.eclipse.xtext.example.arithmetics.ui.editor.hierarchy

import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.example.arithmetics.arithmetics.FunctionCall
import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyNodeLocationProvider

@Singleton
class ArithmeticsCallHierarchyNodeLocationProvider extends DefaultHierarchyNodeLocationProvider {

	override getTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		if (owner instanceof FunctionCall) {
			val textRegion = locationInFileProvider.getFullTextRegion(owner)
			return owner.toTextRegionWithLineInformation(textRegion)
		}

		return super.getTextRegion(owner, feature, indexInList)
	}

}
