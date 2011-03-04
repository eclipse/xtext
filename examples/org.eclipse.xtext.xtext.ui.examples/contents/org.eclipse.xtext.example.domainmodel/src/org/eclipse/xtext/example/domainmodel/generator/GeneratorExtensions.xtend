package org.eclipse.xtext.example.domainmodel.generator

import org.eclipse.xtext.example.domainmodel.domainmodel.*
import org.eclipse.emf.ecore.*
import org.eclipse.xtext.common.types.*
import java.util.Set
import org.eclipse.xtext.xbase.compiler.*


class GeneratorExtensions extends DomainmodelExtensions {
	
	shortName(JvmTypeReference r, ImportManager importManager) {
		val builder = new StringBuilder()
		importManager.appendTypeRef(r, builder)
		builder.toString
	}
	
	fileName(Entity e) {
		e.packageName.replace('.', '/') + "/" + e.name + '.java'
	}
	
	parameterList(Operation o, ImportManager importManager) {
		o.params.map(p| p.parameterType.shortName(importManager) + ' ' + p.name).elementsToString(''', 
			'''
		)
	}
}