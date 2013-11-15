/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation

import javax.inject.Inject
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

/**
 * Checks whether a given XExpression is a a constant expression.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
class ConstantExpressionValidator {
	
	@Inject extension TypeReferences
	@Inject extension Primitives
	@Inject extension XExpressionHelper
	
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
			JvmField : {
				// assume that static final fields are constants for now.
				return feature.static && feature.final
			}
			JvmEnumerationLiteral : {
				return true
			}
			JvmOperation : {
				val annotationReference = expression.findInlineAnnotation
				if (annotationReference == null) {
					return false
				}
				if (annotationReference.values.filter(JvmBooleanAnnotationValue).exists [
					valueName=='constantExpression' && values.head.booleanValue
				]) {
					val receiverConstant =if (expression.actualReceiver == null) {
						true
					} else {
						expression.actualReceiver.isConstant
					}
					return receiverConstant && expression.actualArguments.forall[isConstant]
				}
			}
		}
		return false;
	}
}