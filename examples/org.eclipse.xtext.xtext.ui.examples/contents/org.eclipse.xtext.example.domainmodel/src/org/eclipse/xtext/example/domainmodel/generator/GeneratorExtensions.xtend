package org.eclipse.xtext.example.domainmodel.generator

import org.eclipse.xtext.example.domainmodel.domainmodel.*
import org.eclipse.emf.ecore.*
import org.eclipse.xtext.common.types.*
import java.util.Set
import org.eclipse.xtext.xbase.compiler.*


class GeneratorExtensions {
	String packageName(Object o) {
		switch(o) {
			PackageDeclaration : concatPath(packageName(o.eContainer()), o.name)
			EObject : packageName(o.eContainer())
			JvmDeclaredType : o.packageName
			default: null
		}
	}
	
	concatPath(String prefix, String suffix) {
		if(prefix == null || prefix == "") suffix else prefix + "." + suffix
	}
	
	shortName(JvmTypeReference r, ImportManager importManager) {
		val builder = new StringBuilder()
		importManager.appendTypeRef(r, builder)
		builder.toString
	}
	
	fileName(Entity e) {
		e.packageName().replace('.', '/') + "/" + e.name + '.java'
	}
	
	parameterList(Operation o, ImportManager importManager) {
		o.params.map(p| p.parameterType.shortName(importManager) + ' ' + p.name).elementsToString(", ")
	}
}