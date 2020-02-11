/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.linking

import com.google.inject.Inject
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes
import org.junit.Before
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class BatchLinkingTest extends AbstractXbaseLinkingTest {
	
	@Inject
	IBatchTypeResolver typeResolver;
	
	boolean failOnUnresolvedProxy = true
	
	@Before
	def void init() {
		failOnUnresolvedProxy = true
	}
	
	override expression(CharSequence string, boolean resolve) throws Exception {
		failOnUnresolvedProxy = resolve
		val result = super.expression(string, false);
		val resolvedTypes = typeResolver.resolveTypes(result);
		for(content: result.eAllContents.toIterable) {
			switch(content) {
				XAbstractFeatureCall: {
					assertExpressionTypeIsResolved(content, resolvedTypes)
					if (content.implicitReceiver !== null) {
						assertExpressionTypeIsResolved(content.implicitReceiver, resolvedTypes)
					}
				}
				XExpression: {
					assertExpressionTypeIsResolved(content, resolvedTypes)
				}
				JvmIdentifiableElement: {
					assertIdentifiableTypeIsResolved(content, resolvedTypes)
				}
			}
		}
		if (failOnUnresolvedProxy)
			for(content: result.eAllContents.toIterable) {
				switch(content) {
					XConstructorCall: {
						val constructor = content.eGet(XbasePackage.Literals::XCONSTRUCTOR_CALL__CONSTRUCTOR, false) as InternalEObject
						assertNotNull(content.toString, constructor)
						assertFalse(content.toString, constructor.eIsProxy())
					}
					XAbstractFeatureCall: {
						val feature = content.eGet(XbasePackage.Literals::XABSTRACT_FEATURE_CALL__FEATURE, false) as InternalEObject
						assertNotNull(content.toString, feature)
						assertFalse(content.toString, feature.eIsProxy())
					}
				}
			}
		return result;
	}
	
	def void assertExpressionTypeIsResolved(XExpression expression, IResolvedTypes types) {
		val type = types.getActualType(expression)
		assertNotNull(expression.toString, type)
		assertNotNull(expression.toString + " / " + type, type.identifier)	
	}
	
	def void assertIdentifiableTypeIsResolved(JvmIdentifiableElement identifiable, IResolvedTypes types) {
		val type = types.getActualType(identifiable)
		assertNotNull(identifiable.toString, type)
		assertNotNull(identifiable.toString + " / " + type, type.identifier)	
	}
	
	@Test
	override testMemberCallOnMultiTypeWithUnresolvableArgument_01() throws Exception {
		try {
			failOnUnresolvedProxy = false;
			super.testMemberCallOnMultiTypeWithUnresolvableArgument_01
		} finally {
			failOnUnresolvedProxy = true
		}
	}
	
}
