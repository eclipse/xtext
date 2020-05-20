/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XbaseFactory
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference
import org.junit.Test

/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractBatchTypeResolverTest extends AbstractTypeResolverTest<LightweightTypeReference> {
	
	override LightweightTypeReference resolvesTo(String expression, String type) {
		val xExpression = expression(expression, false /* true */);
		assertTrue(xExpression.eResource.errors.toString, xExpression.eResource.errors.isEmpty)
		assertTrue(xExpression.eResource.warnings.toString, xExpression.eResource.warnings.isEmpty)
		val resolvedTypes = getTypeResolver.resolveTypes(xExpression)
		val resolvedType = resolvedTypes.getActualType(xExpression)
		assertEquals(type, resolvedType.simpleName);
		for(content: xExpression.eAllContents.toIterable) {
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
		for(content: xExpression.eAllContents.toIterable) {
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
					if (content.implicitReceiver !== null) {
						val implicitFeature = content.implicitReceiver.eGet(XbasePackage.Literals::XABSTRACT_FEATURE_CALL__FEATURE, false) as InternalEObject
						assertNotNull(implicitFeature.toString, feature)
						assertFalse(implicitFeature.toString, feature.eIsProxy())
					}
				}
			}
		}
		assertTrue(xExpression.eResource.linkingAndSyntaxErrors.toString, xExpression.eResource.linkingAndSyntaxErrors.isEmpty)
		assertTrue(xExpression.eResource.warnings.toString, xExpression.eResource.warnings.isEmpty)
		return resolvedType
	}
	
	override void isFunctionAndEquivalentTo(LightweightTypeReference reference, String type) {
		assertTrue(reference instanceof FunctionTypeReference)
		assertEquals(type, (reference as FunctionTypeReference).equivalent)
	}
	
	def String getEquivalent(ParameterizedTypeReference type) {
		'''«type.type.simpleName»«type.typeArguments.join('<', ', ', '>') [simpleName]»'''
	}
		
	def void assertExpressionTypeIsResolved(XExpression expression, IResolvedTypes types) {
		val type = types.getActualType(expression)
		assertNotNull("Type is not resolved. Expression: " + expression.toString, type)
		assertNotNull(expression.toString + " / " + type, type.identifier)
		val expectedType = types.getExpectedType(expression)
        assertNotNull(expression.toString, String::valueOf(expectedType))	
	}
	
	def void assertIdentifiableTypeIsResolved(JvmIdentifiableElement identifiable, IResolvedTypes types) {
		val type = types.getActualType(identifiable)
		assertNotNull(identifiable.toString, type)
		assertNotNull(identifiable.toString + " / " + type, type.identifier)	
	}
	
	def IBatchTypeResolver getTypeResolver()
	
	@Test 
	def void testNull() throws Exception {
		val typeResolution = typeResolver.resolveTypes(null as EObject)
		assertNotNull(typeResolution);
		assertEquals(IResolvedTypes::NULL, typeResolution)
	}

	@Test 
	def void testProxy() throws Exception {
		val proxy = XbaseFactory::eINSTANCE.createXFeatureCall();
		(proxy as InternalEObject).eSetProxyURI(URI::createURI("path#fragment"));
		val typeResolution = typeResolver.resolveTypes(proxy)
		assertNotNull(typeResolution);
		assertEquals(IResolvedTypes::NULL, typeResolution)
	}
	
}

