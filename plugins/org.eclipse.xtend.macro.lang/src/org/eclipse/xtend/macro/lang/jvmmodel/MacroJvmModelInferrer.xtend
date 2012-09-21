/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.macro.lang.jvmmodel

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtend.lib.Property
import org.eclipse.xtend.macro.ProcessingContext
import org.eclipse.xtend.macro.RegistrationContext
import org.eclipse.xtend.macro.lang.MacroAnnotationExtensions
import org.eclipse.xtend.macro.lang.macro.MacroAnnotation
import org.eclipse.xtend.macro.lang.macro.TargetType
import org.eclipse.xtend.macro.lang.processing.MacroInterpreter
import org.eclipse.xtend.macro.lang.processing.XAnnotationExtensions
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.util.TypeConformanceComputer
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

import static extension org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter.*
import org.eclipse.xtend.core.xtend.XtendFile


/**
 * Translates the macro language ASTs to Java constructs.
 * 
 * A macro annotation is translated to
 *  1) a JvmAnnotationType, to be referenced from Xtend
 *  2) a "Registrator" class which is the context for the register-expression
 *  3) a "Processor" class which is the context for the process-expression
 *   
 * @author Sven Efftinge
 */
class MacroJvmModelInferrer extends AbstractModelInferrer {
	
	@Inject extension JvmTypesBuilder
	@Inject extension MacroAnnotationExtensions
	@Inject extension XAnnotationExtensions
	@Inject MacroInterpreter interpreter

	def dispatch void infer(MacroAnnotation annotation, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		
		acceptor.accept(annotation.toClass(annotation.registratorClassName)).initializeLater [

			disableCodeGeneration
			visibility = JvmVisibility::PRIVATE
			superTypes += annotation.newTypeRef(typeof(RegistrationContext))
			addAnnotationValueAccessors(annotation)
			
			annotation.registrator => [ r |
				if (r == null)
					return;
				members +=
					r.toMethod('register', annotation.newTypeRef(Void::TYPE))[
						visibility = JvmVisibility::PUBLIC
						parameters +=
							r.toParameter("elements", r.newTypeRef(typeof(List), getAnnotatedElementsType(annotation)))
						parameters +=
							r.toParameter("source", r.newTypeRef(typeof(XtendFile)))
						body = r.expression
					]
			]
		]
		
		acceptor.accept(annotation.toClass(annotation.processorClassName)).initializeLater [
			
			disableCodeGeneration
			visibility = JvmVisibility::PRIVATE
			superTypes += annotation.newTypeRef(typeof(ProcessingContext))
			addAnnotationValueAccessors(annotation)
			
			annotation.processor => [ p |
				if (p == null)
					return;
				members +=
					p.toMethod('process', annotation.newTypeRef(Void::TYPE))[
						visibility = JvmVisibility::PUBLIC
						parameters +=
							p.toParameter("elements", p.newTypeRef(typeof(List), getAnnotatedElementsType(annotation)))
						parameters +=
							p.toParameter("source", p.newTypeRef(typeof(XtendFile)))
						body = p.expression
					]
			]
		]
		
		acceptor.accept(annotation.toAnnotationType(annotation.qualifiedName)).initializeLater [
			disableCodeGeneration
			// translate fields
			annotation.fields.forEach [ field |
				members +=
					field.toMethod(field.name, field.type)[
						if (field.initialValue != null)
							defaultValue = field.initialValue.toJvmAnnotationValue
					]
			]
		]
	}

	@Inject TypeConformanceComputer typeConformanceComputer;

	def JvmTypeReference getAnnotatedElementsType(MacroAnnotation annotation2) {
		val result = <JvmTypeReference>newArrayList()
		for (targetType : annotation2.targetType) {
			switch targetType {
				case TargetType::CLASS: {
					result += annotation2.newTypeRef(typeof(XtendClass))
				}
				case TargetType::FIELD: {
					result += annotation2.newTypeRef(typeof(XtendField))
				}
				case TargetType::METHOD: {
					result += annotation2.newTypeRef(typeof(XtendFunction))
				}
				case TargetType::CONSTRUCTOR: {
					result += annotation2.newTypeRef(typeof(XtendConstructor))
				}
				case TargetType::PARAMETER: {
					result += annotation2.newTypeRef(typeof(XtendParameter))
				}
			}
		}
		if (result.empty) {
			return annotation2.newTypeRef(typeof(XtendAnnotationTarget))
		}
		return typeConformanceComputer.getCommonSuperType(result)
	}
	
	def addAnnotationValueAccessors(JvmGenericType it, MacroAnnotation annotation) {
		for (field : annotation.fields) {
			val type = if (field.isStatic) {
					field.type
				} else {
					field.newTypeRef(typeof(XExpression))
				}
			members += field.toMethod(field.name, type) [
					parameters += field.toParameter('annotatedElement', getAnnotatedElementsType(annotation))
					visibility = JvmVisibility::PRIVATE
					eAdapters +=
						new FunctionAdapter => [
							function = [ arguments |
								val annotationTarget = arguments.head as XtendAnnotationTarget
								val expression = annotationTarget.getAnnotationValueExpression(field, annotation)
								if (field.isStatic) {
									return evaluate(expression)
								} else {
									return expression
								}
							]
						]
				]
		}
	}

	def getAnnotationValueExpression(XtendAnnotationTarget annotated, XtendField field, MacroAnnotation macroAnnotation) {
		val a = annotated.annotations.findFirst[ annotationType.macroAnnotation == macroAnnotation]
		if (field.name == 'value' && a.value != null)
			return a.value
		for (valuePair : a.elementValuePairs) {
			if (valuePair.element.simpleName == field.name)
				return valuePair.value
		}
		return field.initialValue
	}

	def evaluate(XExpression expression) {
		val result = interpreter.evaluate(expression)
		return result.result
	}
}

class FunctionAdapter extends AdapterImpl {
	@Property var (List<Object>)=>Object function

	override isAdapterForType(Object type) {
		type == typeof(FunctionAdapter)
	}
}
