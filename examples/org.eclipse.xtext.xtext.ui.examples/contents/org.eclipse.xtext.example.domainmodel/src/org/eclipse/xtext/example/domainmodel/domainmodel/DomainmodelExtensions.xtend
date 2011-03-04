package org.eclipse.xtext.example.domainmodel.domainmodel

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType

class DomainmodelExtensions {
	String packageName(Object o) {
		switch(o) {
			PackageDeclaration : concatPath(packageName(o.eContainer), o.name)
			EObject : packageName(o.eContainer)
			JvmDeclaredType : o.packageName
			default: null
		}
	}
	
	concatPath(String prefix, String suffix) {
		if(prefix == null || prefix == "") suffix else prefix + "." + suffix
	}
}