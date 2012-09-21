/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.macro.lang.processing

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.macro.ProcessingContext
import org.eclipse.xtend.macro.lang.jvmmodel.FunctionAdapter
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.JavaReflectAccess
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.impl.FeatureCallToJavaMapping
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext
import org.eclipse.xtext.xbase.interpreter.impl.EvaluationException
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter
import org.eclipse.xtext.xbase.XMemberFeatureCall

/**
 * Specialization of the standard Xbase interpreter.
 * Handles some special APIs (e.g. ProcessorContext#type() ) as well as calling dynamic features.
 * 
 * @author Sven Efftinge
 */
class MacroInterpreter extends XbaseInterpreter {
	
	@Inject JavaReflectAccess javaReflectAccess
	@Inject FeatureCallToJavaMapping featureCallToJavaMapping
	
	override protected internalEvaluate(XExpression expression, IEvaluationContext context, CancelIndicator indicator) throws EvaluationException {
		try {
			super.internalEvaluate(expression, context, indicator)
		} catch (EvaluationException e) {
			if (e.cause instanceof MacroEvaluationException) {
				throw e
			} else {
				throw new EvaluationException(new MacroEvaluationException(expression, e.cause)) 
			}
		}
	}
	
	/**
	 * handles special 'magic' methods from ProcessingContext
	 */
	override dispatch invokeFeature(JvmOperation it, XAbstractFeatureCall featureCall, Object receiver, IEvaluationContext context, CancelIndicator indicator) {
		if (declaringType.qualifiedName == typeof(ProcessingContext).name) {
			if (simpleName == 'type') {
				
				// Special handling for "JvmTypeReference type(Class<?> clazz, JvmTypeReference ... ref)"
				// because the typeLiteral might point to some type not on the compiler's classpath
				if (parameters.head?.name == 'clazz') {
					val arguments = featureCallToJavaMapping.getActualArguments(featureCall)
					switch clazz : arguments.head {
						XTypeLiteral : {
							val typerefs = arguments.drop(1).map[internalEvaluate(context, indicator)]
							return (receiver as ProcessingContext).type(clazz.type, typerefs as JvmTypeReference[])
						}
					}
				}
				
				// Special handling for "<T> JvmTypeReference type()"
				// returns the type argument as a cloned and resolved JvmTypeReference 
				if (parameters.empty && featureCall.typeArguments.size == 1) {
					val typeArg = featureCall.typeArguments.head
					EcoreUtil::resolveAll(typeArg)
					return EcoreUtil2::clone(typeArg)
				}
			}
		}
		super._invokeFeature(it, featureCall, receiver, context, indicator)
	}
	
	/**
	 * If it's a generic type it is 'this'
	 */
	def dispatch Object invokeFeature(JvmGenericType identifiable, XFeatureCall featureCall, Object receiver,
			IEvaluationContext context, CancelIndicator indicator) {
		context.getValue(QualifiedName::create('this'))
	}
	
	
	/**
	 * handles operations with an attached FunctionAdapter
	 */
	override protected invokeOperation(JvmOperation operation, Object receiver, List<Object> argumentValues) {
		if (javaReflectAccess.getMethod(operation) == null) {
			val adapter = EcoreUtil::getAdapter(operation.eAdapters, typeof(FunctionAdapter))
			switch adapter {
				FunctionAdapter : {
					return adapter.function.apply(argumentValues)
				}
			}
		}
		super.invokeOperation(operation, receiver, argumentValues)
	}
	
}

class MacroEvaluationException extends RuntimeException {
	public XExpression causer
	new(XExpression causer, Throwable cause) {
		super(cause)
		this.causer = causer
	}
}
