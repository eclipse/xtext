/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.common.util.URI
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
import org.junit.After
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ErrorCollector
import org.eclipse.emf.ecore.EObject

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

/**
 * @author Sebastian Zarnekow
 */
class BatchTypeResolverTest extends AbstractBatchTypeResolverTest {
	
	@Inject
	IBatchTypeResolver typeResolver;
	
	override getTypeResolver() {
		typeResolver
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class BatchConstructorCallTypeTest extends AbstractConstructorCallTypeTest {
	
	@Inject
	IBatchTypeResolver batchTypeResolver;
	
	def getTypeResolver() {
		batchTypeResolver
	}
	
	override resolvesConstructorCallsTo(String expression, String... types) {
		val expressionWithQualifiedNames = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val featureCalls = expressionWithQualifiedNames.findConstructorCalls
		assertFalse(featureCalls.empty)
		assertEquals(types.size, featureCalls.size)
		val resolvedTypes = typeResolver.resolveTypes(featureCalls.head)
		featureCalls.forEach [ featureCall, index |
			val type = resolvedTypes.getActualType(featureCall)
			assertEquals('''failed for constructor call at «index»''', types.get(index), type.simpleName); 
		]
	}
		
}

/**
 * @author Sebastian Zarnekow
 */
class BatchClosureTypeTest extends AbstractClosureTypeTest {
	
	@Inject
	IBatchTypeResolver batchTypeResolver;
	
	def getTypeResolver() {
		batchTypeResolver
	}
	
	@Rule
	public ErrorCollector collector= new ErrorCollector();
	
	override List<Object> resolvesClosuresTo(String expression, String... types) {
		val closures = expression.findClosures
		assertFalse(closures.empty)
		assertEquals(types.size, closures.size)
		val resolvedTypes = typeResolver.resolveTypes(closures.head)
		val result = <Object>newArrayList
		closures.forEach [ closure, index |
			val closureType = resolvedTypes.getActualType(closure)
			collector.checkSucceeds[| 
				assertTrue('''failed for closure at «index»: «closureType»''', closureType instanceof FunctionTypeReference) 
				return null
			]
			collector.checkSucceeds[| 
				assertEquals('''failed for closure at «index»''', types.get(index), closureType.simpleName) 
				return null
			] 
			result += closureType
		]
		
		return result
	}
	
	override void withEquivalents(List<Object> references, String... types) {
		references.forEach [ reference, index |
			collector.checkSucceeds[| 
				assertTrue(reference instanceof FunctionTypeReference)
				return null
			]
			collector.checkSucceeds[| 
				assertEquals(types.get(index), (reference as FunctionTypeReference).equivalent)
				return null	
			]
		]
	}
	
	def String getEquivalent(ParameterizedTypeReference type) {
		if (type.typeArguments.empty)
			return type.type.simpleName
		return '''«type.type.simpleName»<«type.typeArguments.join(', ') [simpleName]»>'''
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class BatchFeatureCallTypeTest extends AbstractFeatureCallTypeTest {
	
	@Inject
	IBatchTypeResolver batchTypeResolver;
	
	def getTypeResolver() {
		batchTypeResolver
	}
	
	override resolvesFeatureCallsTo(String expression, String... types) {
		val expressionWithQualifiedNames = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val featureCalls = expressionWithQualifiedNames.findFeatureCalls
		val resolvedTypes = typeResolver.resolveTypes(featureCalls.head)
		val actualFeatureCalls = featureCalls.filterTypeLiteralsAndPackageFragments
		assertFalse(actualFeatureCalls.empty)
		assertEquals("" + actualFeatureCalls, types.size, actualFeatureCalls.size)
		actualFeatureCalls.forEach [ featureCall, index |
			val type = resolvedTypes.getActualType(featureCall)
			assertEquals('''failed for feature call at «index»''', types.get(index), type.simpleName); 
		]
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testRawType_01() throws Exception {
		super.testRawType_01()
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testRawType_02() throws Exception {
		super.testRawType_02()
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testRawType_05() throws Exception {
		super.testRawType_05()
	}
	
	@Test
	@Ignore("TODO This should work")
	override testBug_391758() throws Exception {
		super.testBug_391758()
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testArray_09() throws Exception {
		super.testArray_09()
	}
		
}

/**
 * @author Sebastian Zarnekow
 */
class BatchIdentifiableTypeTest extends AbstractIdentifiableTypeTest {
	
	@Inject
	IBatchTypeResolver batchTypeResolver
	
	def getTypeResolver() {
		batchTypeResolver
	}
	
	override resolvesIdentifiablesTo(String expression, String... types) {
		val expressionWithQualifiedNames = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val xExpression = expression(expressionWithQualifiedNames, false)
		val resolvedTypes = typeResolver.resolveTypes(xExpression)
		val identifiables = xExpression.findIdentifiables
		assertFalse(identifiables.empty)
		assertEquals(types.size, identifiables.size)
		identifiables.forEach [ identifiable, index |
			val type = resolvedTypes.getActualType(identifiable)
			assertNotNull(type)
			assertEquals('''failed for identifiable at «index»''', types.get(index), type.simpleName); 
		]
	}
		
}

/**
 * @author Sebastian Zarnekow
 */
class BatchTypeArgumentTest extends AbstractTypeArgumentTest {
	
	@Inject
	IBatchTypeResolver batchTypeResolver;
	
	def getTypeResolver() {
		batchTypeResolver
	}
	
	IResolvedTypes resolvedTypes
	
	override protected resolveTypes(XExpression expression) {
		resolvedTypes = typeResolver.resolveTypes(expression)
	}
	
	@After
	def void discardResolvedTypes() {
		resolvedTypes = null
	}
	
	override protected hasTypeArguments(XExpression expression, String... typeArguments) {
		val actualTypeArguments = resolvedTypes.getActualTypeArguments(expression)
		assertEquals(typeArguments.size, actualTypeArguments.size)
		typeArguments.forEach [ typeArgument, i |
			assertEquals('''«typeArguments.join(', ')» vs «actualTypeArguments.map[simpleName].join(', ')»''', typeArgument, actualTypeArguments.get(i).simpleName)
		]
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testRawType_01() throws Exception {
		super.testRawType_01()
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testRawType_02() throws Exception {
		super.testRawType_02()
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testRawType_05() throws Exception {
		super.testRawType_05()
	}
	
}

