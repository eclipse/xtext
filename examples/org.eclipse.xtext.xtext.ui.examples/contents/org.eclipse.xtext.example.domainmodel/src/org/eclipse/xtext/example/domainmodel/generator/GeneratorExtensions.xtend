/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.generator

import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.example.domainmodel.DomainmodelExtensions
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation
import org.eclipse.xtext.xbase.compiler.ImportManager


class GeneratorExtensions extends DomainmodelExtensions {
	
	def shortName(JvmTypeReference r, ImportManager importManager) {
		val builder = new StringBuilder()
		importManager.appendTypeRef(r, builder)
		builder.toString
	}
	
	def fileName(Entity e) {
		e.packageName.folderName + "/" + e.name + '.java'
	}
	
	def folderName(String javaPackageName) {
		if(javaPackageName != null) javaPackageName.replace('.', '/') else "" 
	}
	
	def parameterList(Operation o, ImportManager importManager) {
		o.params.map(p| p.parameterType.shortName(importManager) + ' ' + p.name).join(''', 
			'''
		)
	}
	
	def isInterface(JvmTypeReference typeRef) {
		(typeRef.type as JvmGenericType).isInterface
	}
}