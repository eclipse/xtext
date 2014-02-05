/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class SwitchConstantExpressionsInterpreter extends AbstractConstantExpressionsInterpreter {

	@Inject extension ILogicalContainerProvider

	@Inject extension NumberLiterals numberLiterals

	def Object evaluate(XExpression it) {
		internalEvaluate(null)
	}

	def dispatch Object internalEvaluate(XNumberLiteral it, Context ctx) {
		numberValue(javaType)
	}

	def dispatch Object internalEvaluate(XAbstractFeatureCall it, Context ctx) {
		switch feature : feature {
			JvmType: {
				return toTypeReference(feature, 0)
			}
			JvmEnumerationLiteral: {
				return feature
			}
			JvmField: {
				if (feature.setConstant) {
					if (feature.constant) {
						return feature.constantValue
					}
				} else if (feature.final) {
					val associatedExpression = feature.associatedExpression
					if (associatedExpression != null) {
						return associatedExpression.evaluateAssociatedExpression(ctx)
					}
				}
			}
			XVariableDeclaration case !feature.writeable && feature.right != null: {
				return feature.right.evaluateAssociatedExpression(ctx)
			}
			XSwitchExpression case feature.^switch != null: {
				return feature.^switch.internalEvaluate(ctx)
			}
		}
		throw new UnresolvableFeatureException("Couldn't resolve feature "+ feature.simpleName, it)
	}
	
	def Object evaluateAssociatedExpression(XExpression it, Context ctx) {
		switch it {
			XAbstractFeatureCall case feature instanceof JvmEnumerationLiteral: {
				throw notConstantExpression
			}
			default: internalEvaluate(ctx)
		}
	}

}
