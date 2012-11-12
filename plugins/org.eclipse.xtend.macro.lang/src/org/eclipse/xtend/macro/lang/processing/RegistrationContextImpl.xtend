/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.macro.lang.processing

import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.macro.RegistrationContext
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

/**
 * Basic implementation of Registration context.
 * 
 * @author Sven Efftinge
 */
class RegistrationContextImpl implements RegistrationContext {
	
	@Property IJvmDeclaredTypeAcceptor acceptor
	@Property extension JvmTypesBuilder typesBuilder
	@Property XtendFile source
	@Property IJvmModelAssociator associator

	//TODO improve tracing
	override registerAnnotation(String name) {
		val annoType = source.toAnnotationType(name) []
		acceptor.accept(annoType)
	}
	
	override registerClass(String name) {
		val annoType = source.toClass(name)
		acceptor.accept(annoType)
	}
	
	override registerEnum(String name) {
		val annoType = source.toEnumerationType(name)[]
		acceptor.accept(annoType)
	}
	
	override registerInterface(String name) {
		val annoType = source.toInterface(name)[]
		acceptor.accept(annoType)
	}
	
}