package org.eclipse.xtext.xtend2.tests.smoke

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EObject
import java.util.List

class Case_6 {
	
	//TODO in Version 2.2.1 remove the return types, and you'll get incorrect Java code

	def dispatch List<?> transform(EPackage packageDecl) {
		packageDecl.eContents.map(e | transform(e as EStructuralFeature))
	}
	
	
	def dispatch transform(EStructuralFeature entity) {
		val inferredType = null
		newArrayList(inferredType as EObject) 	 
	}
	
	def dispatch List<?> transform(EClass model) {
		model.ETypeParameters.map(e| transform(e))
	}

}