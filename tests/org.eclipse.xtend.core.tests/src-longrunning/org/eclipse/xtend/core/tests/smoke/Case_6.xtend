package org.eclipse.xtend.core.tests.smoke

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature

class Case_6 {
	
	def dispatch transform(EPackage packageDecl) {
		packageDecl.eContents.map(e | transform(e as EStructuralFeature))
	}
	
	def dispatch transform(EStructuralFeature entity) {
		val inferredType = null
		newArrayList(inferredType as EObject) 	 
	}
	
	def dispatch transform(EClass model) {
		model.ETypeParameters.map(e| transform(e))
	}

}