/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.linking

import com.google.inject.Inject
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XCasePart
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes
import org.eclipse.emf.ecore.InternalEObject
import org.junit.Test
import org.junit.Ignore
import org.junit.Before

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
				XSwitchExpression: {
					assertExpressionTypeIsResolved(content, resolvedTypes)
					if (content.localVarName != null) {
						assertIdentifiableTypeIsResolved(content, resolvedTypes)
					}
				}
				XAbstractFeatureCall: {
					assertExpressionTypeIsResolved(content, resolvedTypes)
					if (content.implicitReceiver != null) {
						assertExpressionTypeIsResolved(content.implicitReceiver, resolvedTypes)
					}
				}
				XExpression: {
					assertExpressionTypeIsResolved(content, resolvedTypes)
				}
				XCasePart : { /* skip */}
				JvmIdentifiableElement: {
					assertIdentifiableTypeIsResolved(content, resolvedTypes)
				}
			}
		}
		if (failOnUnresolvedProxy)
			for(content: result.eAllContents.toIterable) {
				switch(content) {
					XConstructorCall: {
						val constructor = content.eGet(XbasePackage$Literals::XCONSTRUCTOR_CALL__CONSTRUCTOR, false) as InternalEObject
						assertNotNull(content.toString, constructor)
						assertFalse(content.toString, constructor.eIsProxy())
					}
					XAbstractFeatureCall: {
						val feature = content.eGet(XbasePackage$Literals::XABSTRACT_FEATURE_CALL__FEATURE, false) as InternalEObject
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
	@Ignore("Implement me")
	override testMemberCallOnNull_02() throws Exception {
		fail("Should be unresolved proxy for now - or ambiguous feature later on")
	}
	
	@Test
	@Ignore("Implement me")
	override testMemberCallOnNull_06() throws Exception {
		fail("Should be unresolved proxy for now - or ambiguous feature later on")
	}
	
	@Test
	@Ignore("Implement me")
	override testMemberCallOnNull_07() throws Exception {
		fail("Should be unresolved proxy for now - or ambiguous feature later on")
	}
	
	@Test
	@Ignore("Implement me")
	override testMemberCallOnNull_11() throws Exception {
		fail("Should be unresolved proxy for now - or ambiguous feature later on")
	}
	
	@Test
	@Ignore("Implement me")
	override testMemberCallOnNull_12() throws Exception {
		fail("Should be unresolved proxy for now - or ambiguous feature later on")
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