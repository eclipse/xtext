/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.macro.lang.processing

import java.util.Map
import java.util.Stack
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.macro.ProcessingContext
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.validation.EObjectDiagnosticImpl
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.lib.Functions$Function1
import org.eclipse.xtext.xbase.lib.Procedures$Procedure1
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations

/**
 * Basic implementation of processing context.
 * 
 * Some methods might not be implemented here, but in the MacroInterpreter.
 * 
 * @author Sven Efftinge
 */
class ProcessingContextImpl implements ProcessingContext {
	
	@Property JvmTypesBuilder typesBuilder
	@Property IXtendJvmAssociations associations
	@Property XtendFile source
	
	private Stack<JvmIdentifiableElement> currentContainer = new Stack

	override inDerivedJavaClass(XtendMember member, Procedure1<JvmGenericType> initializer) {
		with(member.declaringXtendClass.qualifiedName, initializer)
	}
	
	def private XtendClass getDeclaringXtendClass(EObject member) {
		switch member {
			XtendClass : member
			case member.eContainer == null : null 
			default : getDeclaringXtendClass(member.eContainer)
		}
	}
	
	def private getQualifiedName(XtendClass clazz) {
		val p = (clazz.eContainer as XtendFile).getPackage
		if (p == null) {
			clazz.name
		} else {
			p + '.' + clazz.name
		}
	}
	
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
	
	override setBody(CharSequence javaCode) {
		val declarator = currentContainer.peek as JvmExecutable
		typesBuilder.setBody(declarator) [
			append(trimIndentation(javaCode))
		]
	}
	
	def private trimIndentation(CharSequence seq) {
		val lines = seq.toString.split('\n')
		if (lines.size == 1) {
			return lines.head
		} else {
			val indentation = lines.fold('') [
				a, b | 
				val indent = b.indentation
				if (a.empty)
					return indent
				if (a.startsWith(indent))
					return indent
				return a
			]
			lines.map[ s |
				if (s.startsWith(indentation)) {
					println(s.substring(indentation.length, s.length))
				} else {
					s
				}].join('\n')
		}
	}
	
	def private indentation(String s) {
		val b = new StringBuilder
		for (c : s.toCharArray) {
			if (Character::isWhitespace(c)) {
				b.append(c)
			} else {
				return b.toString
			}
		}
		return b.toString
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
				target.eResource.errors += new EObjectDiagnosticImpl(Severity::ERROR, 'macro_error', message, associations?.getPrimarySourceElement(target) ?: target, null, -1, null)
			}
			default : throw new IllegalArgumentException("Only EObjects are supported atm.")
		}
	}
	
	override warning(Object target, String message) {
		switch target {
			EObject : {
				target.eResource.errors += new EObjectDiagnosticImpl(Severity::ERROR, 'macro_error', message, associations?.getPrimarySourceElement(target) ?: target, null, -1, null)
			}
			default : throw new IllegalArgumentException("Only EObjects are supported atm.")
		}
	}
	

	override annotate(JvmTypeReference reference, Map<String,Object> values) {
		if (!(reference?.type instanceof JvmAnnotationType)) {
			throw new IllegalArgumentException('Reference must point to an annotation type but was '+reference?.type?.identifier)
		}
		val annotationType = reference.type as JvmAnnotationType
		val result = TypesFactory::eINSTANCE.createJvmAnnotationReference
		result.annotation = annotationType
		if (values != null) {
			for (entry : values.entrySet) {
				val feature = annotationType.allFeatures.filter(typeof(JvmOperation)).findFirst[ simpleName == entry.key ]
				switch value : entry.value {
					String : {
						val annotationValue = TypesFactory::eINSTANCE.createJvmStringAnnotationValue
						annotationValue.values += value
						annotationValue.operation = feature
					}
					Boolean : {
						val annotationValue = TypesFactory::eINSTANCE.createJvmBooleanAnnotationValue
						annotationValue.values += value
						annotationValue.operation = feature
					}
					Integer : {
						val annotationValue = TypesFactory::eINSTANCE.createJvmIntAnnotationValue
						annotationValue.values += value
						annotationValue.operation = feature
					}
					JvmTypeReference : {
						val annotationValue = TypesFactory::eINSTANCE.createJvmTypeAnnotationValue
						annotationValue.values += value
						annotationValue.operation = feature
					}
					
					default : throw new IllegalArgumentException("Annotation value must either be a String, Boolean, Integer, or JvmTypeReference (Class). Was "+entry.key+" -> "+entry.value+".")
				}
			}
		}
		return result
	}
	
}