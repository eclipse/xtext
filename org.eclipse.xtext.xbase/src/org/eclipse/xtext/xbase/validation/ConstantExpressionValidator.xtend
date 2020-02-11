/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.util.Primitives
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XCastedExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.util.XExpressionHelper
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.eclipse.xtext.common.types.access.TypeResource
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.emf.ecore.EObject

/**
 * Checks whether a given XExpression is a a constant expression.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
class ConstantExpressionValidator {
	
	@Inject extension TypeReferences
	@Inject extension Primitives
	@Inject extension XExpressionHelper
	@Inject extension ILogicalContainerProvider
	
	def dispatch boolean isConstant(XExpression expression) {
		return false
	}
	
	def dispatch boolean isConstant(XStringLiteral expression) { true }
	def dispatch boolean isConstant(XTypeLiteral expression) { true }
	def dispatch boolean isConstant(XNumberLiteral expression) { true }
	def dispatch boolean isConstant(XBooleanLiteral expression) { true }
	
	def dispatch boolean isConstant(XCastedExpression expression) {
		expression.type.primitive || expression.type.is(String)
	}
	
	def dispatch boolean isConstant(XAbstractFeatureCall expression) {
		switch feature : expression.feature {
			JvmEnumerationLiteral : {
				return true
			}
			JvmField : {
				if (feature.setConstant) {
					return feature.constant
				}
				val potentiallyConstant = feature.static && feature.final
				if (potentiallyConstant) {
					if (feature.eResource instanceof TypeResource) {
						return true
					} else {
						return feature.associatedExpression.constantExpression
					}
				}
				return false
			}
			JvmOperation : {
				val annotationReference = expression.findInlineAnnotation
				if (annotationReference === null) {
					return false
				}
				if (annotationReference.values.filter(JvmBooleanAnnotationValue).exists [
					valueName=='constantExpression' && values.head.booleanValue
				]) {
					val receiverConstant = if (expression.actualReceiver === null) {
						true
					} else {
						expression.actualReceiver.isConstant
					}
					return receiverConstant && expression.actualArguments.forall[isConstant]
				}
			}
			XVariableDeclaration: {
				return !feature.writeable && feature.right.constantExpression
			}
			XSwitchExpression: {
				return feature.^switch.constantExpression;
			}
			EObject case feature.eIsProxy: {
				throw new NotResolvedFeatureException
			}
		}
		return false
	}
	
	def dispatch boolean isConstantExpression(Void it) {
		false
	}
	
	def dispatch boolean isConstantExpression(XExpression it) {
		constant
	}
	
	def dispatch boolean isConstantExpression(XAbstractFeatureCall it) {
		switch feature {
			JvmEnumerationLiteral : false
			default: constant
		}
	}
}

class NotResolvedFeatureException extends RuntimeException {
}	
