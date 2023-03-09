/*******************************************************************************
 * Copyright (c) 2014, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals
import org.eclipse.xtext.common.types.access.impl.ClassFinder
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmTypeReference
import java.util.Map
import java.util.Set

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class SwitchConstantExpressionsInterpreter extends AbstractConstantExpressionsInterpreter {

	@Inject extension ILogicalContainerProvider

	@Inject extension NumberLiterals numberLiterals

	def Object evaluate(XExpression it) {
		evaluate(new Context(null, null, null, newHashSet))
	}

	def Object evaluate(XExpression it, boolean validationMode) {
		val ctx = new SwitchContext(null, null, null, newHashSet)
		ctx.validationMode = validationMode
		evaluate(ctx)
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
				} else if (feature.final
						// Java requires fields referenced in switch cases to be static, but we still want to be able
						// to evaluate non-static final fields when checking for duplicate cases.
						&& (feature.static || ctx instanceof SwitchContext && (ctx as SwitchContext).validationMode)) {
					val associatedExpression = feature.associatedExpression
					if (associatedExpression !== null) {
						return associatedExpression.evaluateAssociatedExpression(ctx)
					}
				}
			}
			XVariableDeclaration case !feature.writeable && feature.right !== null: {
				return feature.right.evaluateAssociatedExpression(ctx)
			}
			JvmFormalParameter: {
				switch container : feature.eContainer {
					XSwitchExpression case container.^switch !== null: {
						return container.^switch.evaluate(ctx)
					}
				}
			}
		}
		throw new UnresolvableFeatureException("Couldn't resolve feature "+ feature.simpleName, it)
	}
	
	def Object evaluateAssociatedExpression(XExpression it, Context ctx) {
		switch it {
			XAbstractFeatureCall case feature instanceof JvmEnumerationLiteral: {
				throw notConstantExpression
			}
			default: evaluate(ctx)
		}
	}
	
	private static class SwitchContext extends Context {
		boolean validationMode

		new(JvmTypeReference expectedType, ClassFinder classFinder, Map<String, JvmIdentifiableElement> visibleFeatures,
			Set<XExpression> alreadyEvaluating) {
			super(expectedType, classFinder, visibleFeatures, alreadyEvaluating)
		}
	}

}
