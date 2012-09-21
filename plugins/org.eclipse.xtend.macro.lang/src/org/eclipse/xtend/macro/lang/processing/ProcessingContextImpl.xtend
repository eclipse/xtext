/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.macro.lang.processing

import java.util.List
import java.util.Stack
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.lib.Property
import org.eclipse.xtend.macro.ProcessingContext
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.validation.EObjectDiagnosticImpl
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.lib.Functions$Function1
import org.eclipse.xtext.xbase.lib.Procedures$Procedure1

/**
 * Basic implementation of processing context.
 * 
 * Some methods might not be implemented here, but in the MacroInterpreter.
 * 
 * @author Sven Efftinge
 */
class ProcessingContextImpl implements ProcessingContext {
	
	@Property JvmTypesBuilder typesBuilder
	@Property XtendFile source
	@Property List<XtendAnnotationTarget> elements
	
	private Stack<JvmIdentifiableElement> currentContainer = new Stack

	/**
	 * 
	 */
	override with(String name, Procedure1<JvmGenericType> initializer) {
		val type = source.eResource.contents.filter(typeof(JvmGenericType))
			.findFirst[ qualifiedName == name ]
		try {
			currentContainer.push(type)
			initializer.apply(type)
		} finally {
			currentContainer.pop
		}
		return type
	}

	override field(String name, JvmTypeReference type) {
		val declararator = currentContainer.peek as JvmGenericType
		val result = typesBuilder.toField(source, name, type, null)
		declararator.members += result
		return result
	}

	override method(String name, JvmTypeReference returnType, Procedure1<JvmOperation> initializer) {
		val declararator = currentContainer.peek as JvmGenericType
		val result = typesBuilder.toMethod(source, name, returnType, null)
		declararator.members += result
		try {
			currentContainer.push(result)
			initializer.apply(result)
		} finally {
			currentContainer.pop
		}
		return result
	}
	
	override constructor(Procedure1<JvmConstructor> initializer) {
		val declararator = currentContainer.peek as JvmGenericType
		val result = typesBuilder.toConstructor(source, null)
		declararator.members += result
		try {
			currentContainer.push(result)
			initializer.apply(result)
		} finally {
			currentContainer.pop
		}
		return result
	}
	
	override param(String name, JvmTypeReference type) {
		val declarator = currentContainer.peek as JvmExecutable
		val result = typesBuilder.toParameter(source, name, type)
		declarator.parameters += result
		return result
	}

	override <T, RETURN_TYPE> reify(Function1<T,RETURN_TYPE> expression) {
		throw new UnsupportedOperationException("implemented in interpreter")
	}

	override <T> result(XExpression expression) {
		throw new UnsupportedOperationException("implemented in interpreter")
	}

	override <T> type() {
		throw new UnsupportedOperationException("implemented in interpreter")
	}

	override type(JvmType typeDeclaration, JvmTypeReference ... typeRef) {
		typesBuilder.newTypeRef(typeDeclaration, typeRef)
	}

	override type(Class<? extends Object> clazz, JvmTypeReference ... typeRef) {
		typesBuilder.newTypeRef(source, clazz, typeRef)
	}

	override type(String name, JvmTypeReference... typeRef) {
		val local = source.eResource.contents.filter(typeof(JvmDeclaredType)).findFirst[type |
			name == type.identifier
		]
		if (local != null)
			return typesBuilder.newTypeRef(local, typeRef)
		return typesBuilder.newTypeRef(source, name, typeRef)
	}


	override error(Object target, String message) {
		switch target {
			EObject : {
				target.eResource.errors += new EObjectDiagnosticImpl(Severity::ERROR, 'macro_error', message, target, null, -1, null)
			}
			default : throw new IllegalArgumentException("Only EObjects are supported atm.")
		}
	}
	
	override warning(Object target, String message) {
		switch target {
			EObject : {
				target.eResource.errors += new EObjectDiagnosticImpl(Severity::ERROR, 'macro_error', message, target, null, -1, null)
			}
			default : throw new IllegalArgumentException("Only EObjects are supported atm.")
		}
	}
	
}