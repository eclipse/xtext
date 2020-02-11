/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.junit.typesystem

import com.google.common.annotations.Beta
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.CompoundReentrantTypeResolver
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.TypeData
import org.junit.Assert
import org.junit.ComparisonFailure

/**
 * Utility to check a given expression for exceptions and integrity
 * after it was processed by the {@link IBatchTypeResolver}
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
@Singleton
class Oven extends Assert {
	
	@Inject
	IBatchTypeResolver typeResolver
	
	@Inject extension ReflectExtensions
	
	@Inject extension ParseHelper<EObject>
	
	def void fireproof(CharSequence input) throws Exception {
		input.toString.fireproof
	}
	
	def void fireproof(String input) throws Exception {
		try {
			val file = input.parse
			val resolvedTypes = typeResolver.resolveTypes(file)
			assertNotNull(resolvedTypes)
			if (file !== null) {
				for(content: file.eAllContents.toIterable) {
					switch(content) {
						XAbstractFeatureCall: {
							assertExpressionTypeIsResolved(content, resolvedTypes)
							if (content.implicitReceiver !== null) {
								assertExpressionTypeIsResolved(content.implicitReceiver, resolvedTypes)
							}
							if (content.implicitFirstArgument !== null) {
								assertExpressionTypeIsResolved(content.implicitFirstArgument, resolvedTypes)
							}
						}
						XClosure: {
							assertExpressionTypeIsResolved(content, resolvedTypes)
							content.implicitFormalParameters.forEach [
								assertIdentifiableTypeIsResolved(resolvedTypes)
							]
						}
						XExpression: {
							assertExpressionTypeIsResolved(content, resolvedTypes)
						}
						JvmIdentifiableElement: {
							assertIdentifiableTypeIsResolved(content, resolvedTypes)
						}
					}
				}
			}
		} catch(Throwable e) {
			val error = new ComparisonFailure(e.getMessage(), input, '');
			error.stackTrace = e.stackTrace
			throw error
		}
		
	}
	
	def void assertExpressionTypeIsResolved(XExpression expression, IResolvedTypes types) {
		val internalTypes = types.invoke('delegate')
		val type = switch(internalTypes) {
			CompoundReentrantTypeResolver: {
				val method = CompoundReentrantTypeResolver.getDeclaredMethod('getDelegate', XExpression)
				method.accessible = true
				val delegate = method.invoke(internalTypes, expression)
				if (delegate instanceof RootResolvedTypes)
					delegate.invoke("getTypeData", expression, Boolean.FALSE) as TypeData
			} 
			default: internalTypes.invoke("getTypeData", expression, Boolean.FALSE) as TypeData
		}
		assertTrue("Type is not resolved. Expression: " + expression.toString, if (expression instanceof XAbstractFeatureCall) expression.packageFragment || type !== null else type !== null)
	}
	
	def void assertIdentifiableTypeIsResolved(JvmIdentifiableElement identifiable, IResolvedTypes types) {
		if (identifiable.simpleName === null)
			return;
		val type = types.getActualType(identifiable)
		assertNotNull(identifiable.toString, type)
		assertNotNull(identifiable.toString + " / " + type, type.identifier)	
	}
}
