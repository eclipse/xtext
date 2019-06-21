package org.eclipse.xtend.core.tests.smoke

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature

class Case_6 {
	
	def dispatch Object transform(EPackage packageDecl) {
		packageDecl.eContents.map(e | transform(e as EStructuralFeature))
	}
	
	def dispatch Object transform(EStructuralFeature entity) {
		val inferredType = null
		newArrayList(inferredType as EObject) 	 
	}
	
	def dispatch Object transform(EClass model) {
		model.ETypeParameters.map(e| transform(e))
	}

}