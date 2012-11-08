/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XCasePart
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XbaseFactory
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer
import org.eclipse.xtext.xbase.typesystem.internal.AbstractPendingLinkingCandidate
import org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference
import org.eclipse.xtext.xbase.typing.ITypeProvider
import org.eclipse.xtext.xtype.XFunctionTypeRef
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.rules.Timeout
import org.junit.runner.RunWith

/**
 * @author Sebastian Zarnekow
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseNewTypeSystemInjectorProvider))
abstract class AbstractBatchTypeResolverTest extends AbstractTypeResolverTest<LightweightTypeReference> {
	
	override LightweightTypeReference resolvesTo(String expression, String type) {
		val xExpression = expression(expression.replace('$$', 'org::eclipse::xtext::xbase::lib::'), false /* true */);
		assertTrue(xExpression.eResource.errors.toString, xExpression.eResource.errors.isEmpty)
		assertTrue(xExpression.eResource.warnings.toString, xExpression.eResource.warnings.isEmpty)
		val resolvedTypes = getTypeResolver.resolveTypes(xExpression)
		val resolvedType = resolvedTypes.getActualType(xExpression)
		assertEquals(type, resolvedType.simpleName);
		for(content: xExpression.eAllContents.toIterable) {
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
		for(content: xExpression.eAllContents.toIterable) {
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
					if (content.implicitReceiver != null) {
						val implicitFeature = content.implicitReceiver.eGet(XbasePackage$Literals::XABSTRACT_FEATURE_CALL__FEATURE, false) as InternalEObject
						assertNotNull(implicitFeature.toString, feature)
						assertFalse(implicitFeature.toString, feature.eIsProxy())
					}
				}
			}
		}
		assertTrue(xExpression.eResource.errors.toString, xExpression.eResource.errors.isEmpty)
		assertTrue(xExpression.eResource.warnings.toString, xExpression.eResource.warnings.isEmpty)
		return resolvedType
	}
	
	override void isFunctionAndEquivalentTo(LightweightTypeReference reference, String type) {
		assertTrue(reference instanceof FunctionTypeReference)
		assertEquals(type, (reference as FunctionTypeReference).equivalent)
	}
	
	def String getEquivalent(ParameterizedTypeReference type) {
		'''«type.type.simpleName»<«type.typeArguments.join(', ') [simpleName]»>'''
	}
		
	def void assertExpressionTypeIsResolved(XExpression expression, IResolvedTypes types) {
		val type = types.getActualType(expression)
		assertNotNull("Type is not resolved. Expression: " + expression.toString, type)
		assertNotNull(expression.toString + " / " + type, type.identifier)	
	}
	
	def void assertIdentifiableTypeIsResolved(JvmIdentifiableElement identifiable, IResolvedTypes types) {
		val type = types.getActualType(identifiable)
		assertNotNull(identifiable.toString, type)
		assertNotNull(identifiable.toString + " / " + type, type.identifier)	
	}
	
	def IBatchTypeResolver getTypeResolver()
	
	@Test 
	def void testNull() throws Exception {
		val typeResolution = typeResolver.resolveTypes(null)
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
	
	@Ignore("TODO discuss the preference - list or array?") @Test override testIfExpression_10() throws Exception {
		super.testIfExpression_10()
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class OldAPITypeResolverTest extends AbstractTypeResolverTest<JvmTypeReference> {
	
	@Inject
	ITypeProvider typeProvider
	
	override JvmTypeReference resolvesTo(String expression, String type) {
		val xExpression = expression(expression, false /* true */);
		assertTrue(xExpression.eResource.errors.isEmpty)
		assertTrue(xExpression.eResource.warnings.isEmpty)
		val resolvedType = typeProvider.getType(xExpression)
		assertEquals(type, resolvedType?.simpleName);
		for(content: xExpression.eAllContents.toIterable) {
			switch(content) {
				XSwitchExpression: {
					assertExpressionTypeIsResolved(content)
					if (content.localVarName != null) {
						assertIdentifiableTypeIsResolved(content)
					}
				}
				XExpression: {
					assertExpressionTypeIsResolved(content)
				}
				XCasePart : { /* skip */}
				JvmIdentifiableElement: {
					assertIdentifiableTypeIsResolved(content)
				}
			}
		}
		assertTrue(xExpression.eResource.errors.isEmpty)
		assertTrue(xExpression.eResource.warnings.isEmpty)
		return resolvedType
	}
	
	override void isFunctionAndEquivalentTo(JvmTypeReference reference, String type) {
		assertTrue(reference instanceof XFunctionTypeRef)
		assertEquals(type, (reference as XFunctionTypeRef).equivalent.simpleName)
	}
	
	def void assertExpressionTypeIsResolved(XExpression expression) {
		val type = typeProvider.getType(expression)
		assertNotNull(expression.toString, type)
		assertNotNull(expression.toString + " / " + type, type.identifier)	
	}
	
	def void assertIdentifiableTypeIsResolved(JvmIdentifiableElement identifiable) {
		val type = typeProvider.getTypeForIdentifiable(identifiable)
		assertNotNull(identifiable.toString, type)
		assertNotNull(identifiable.toString + " / " + type, type.identifier)	
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testBlockExpression_03() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_b() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_c() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_d() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_d_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_e_2() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_f() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_f_2() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_g() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_g_2() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_h() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_h_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_i() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_i_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_i_3() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_i_4() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_j() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_j_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_k() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_k_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_l() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_l_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_m() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_n() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_n_1() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_n_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_25_d() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_03_b() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_10() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_13() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_24_a() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_24_b() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_32() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_33() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testOverloadedVarArgs_03() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testOverloadedOperators_20() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testImplicitImportPrintln_01() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testImplicitImportEmptyList() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testMethodTypeParamInference_03() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testMethodTypeParamInference_04() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testMethodTypeParamInference_05() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_06() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_08() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_10() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_13() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_13a() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_13b() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_15() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_16() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_17() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_18() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_19() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_20() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_21() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_22() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_23() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_24() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_25() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_26() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_27() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_28() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_29() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_30() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_31() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testIfExpression_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_06() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_07() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_08() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_09() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_11() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_12() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testSwitchExpression_4() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testSwitchExpression_7() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testSwitchExpression_8() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testTypeLiteral_2() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testTypeLiteral_3() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testTypeGuardedCase_2() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorCall_01() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorCall_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorCall_03() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_06_00() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_27() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testFeatureCall_28() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testToList_04() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testToList_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testToList_07() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testBounds_24() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testBounds_26() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testPropertyAccess_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testPropertyAccess_06() throws Exception {
		fail("fails in old implementation")
	}
	
    @Ignore("fails in old implementation") @Test override testBug_381466_01() throws Exception {
        fail("fails in old implementation")
    }
    @Ignore("fails in old implementation") @Test override testBug_381466_02() throws Exception {
        fail("fails in old implementation")
    }
    @Ignore("fails in old implementation") @Test override testBug_381466_03() throws Exception {
        fail("fails in old implementation")
    }
    @Ignore("fails in old implementation") @Test override testBug_381466_04() throws Exception {
        fail("fails in old implementation")
    }
	
	@Ignore("fails in old implementation") @Test override testTypeByTransitiveExpectation_01() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testTypeByTransitiveExpectation_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_002() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_003() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_004() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_005() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_006() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_007() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_008() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_009() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_010() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_011() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_012() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_013() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_014() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_015() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_016() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_017() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_018() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_019() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_020() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_021() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_022() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_023() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_024() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_025() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_026() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_027() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_028() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_029() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_030() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_031() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_032() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_033() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_034() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_035() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_036() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_037() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_038() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_039() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_040() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_041() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_042() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_043() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_044() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_045() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_046() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_048() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_049() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_050() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_051() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_052() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_053() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_054() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_055() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_056() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_057() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_058() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_059() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_060() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_061() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_062() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_063() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_064() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_065() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_066() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_067() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_068() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_069() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_070() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_071() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_072() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_073() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_074() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_075() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_076() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_077() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_078() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_079() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_080() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_081() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_082() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_083() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_084() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_085() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_086() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_087() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_088() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_089() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_090() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_091() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_092() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_093() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_094() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_095() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_096() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_097() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_098() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_099() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_100() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_101() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_102() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_103() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_104() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_105() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_106() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_107() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_108() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_109() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_110() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_111() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_112() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_113() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_114() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_115() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_116() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_117() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_118() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_119() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_120() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_121() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_122() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_123() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_124() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_125() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_126() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_127() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_128() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_129() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_130() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_131() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_132() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_133() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_134() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_135() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_136() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_137() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_138() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_139() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_140() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_141() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_142() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_143() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_144() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_145() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_146() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_147() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_148() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_149() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_150() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_151() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_152() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_153() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_154() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_155() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_156() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_157() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_158() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_159() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_160() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_04() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_06() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_07() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_08() throws Exception {
		fail("fails in old implementation")
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
class RecomputingTypeResolverTest extends AbstractBatchTypeResolverTest {
	
	@Inject
	RecomputingBatchTypeResolver typeResolver;
	
	override getTypeResolver() {
		typeResolver
	}
	
}

/**
 * A test that triggers the computation of argument types in reverse order.
 * Furthermore it will shuffle the order of branches in if and switch expressions.
 * @author Sebastian Zarnekow
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseShufflingNewTypeSystemInjectorProvider))
class ShuffledTypeResolverTest extends AbstractBatchTypeResolverTest {
	
	@Inject
	IBatchTypeResolver typeResolver;
	
	override getTypeResolver() {
		typeResolver
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testOverloadedOperators_08() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testOverloadedOperators_09() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testOverloadedOperators_10() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testOverloadedOperators_15() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testClosure_03() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testClosure_30() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testClosure_31() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testEMap_01() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testEMap_02() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testEMap_05() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testEMap_06() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testEMap_09() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testEMap_10() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testMemberFeatureCall_02() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_07() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_07_01() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_07_02() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_07_03() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_09() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_13_6() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_17_a() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_17_b() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_18_a() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_18_b() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_19_a() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_19_b() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_20_a() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_20_b() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_21_a() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_21_b() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_22_a() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_22_b() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_23_a() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_23_b() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_24_a() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_24_b() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_25_a() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_25_b() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_25_c() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_25_d() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_26() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_26a() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_26b() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_27() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_28() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_30() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_31() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_37() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testFeatureCall_38() throws Exception {
		fail("TODO deferred closure typing")
	}
	
	@Test
	@Ignore("TODO deferred closure typing")
	override testBug_389512() throws Exception {
		fail("TODO deferred closure typing")
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
abstract class TypeResolverPerformanceTest extends BatchTypeResolverTest {
	
	@Rule
	public val timeout = new Timeout(400) // TODO improve - aim at something like 100
	
	override LightweightTypeReference resolvesTo(String expression, String type) {
		val xExpression = expression(expression.replace('$$', 'org::eclipse::xtext::xbase::lib::'), false /* true */);
		val resolvedTypes = getTypeResolver.resolveTypes(xExpression)
		val lightweight = resolvedTypes.getActualType(xExpression)
		assertEquals(type, lightweight.simpleName);
		return lightweight
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class InvariantCheckingBatchTypeResolverTest extends AbstractBatchTypeResolverTest {
	
	@Inject
	InvariantCheckingBatchTypeResolver typeResolver;
	
	override getTypeResolver() {
		typeResolver
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class InvariantCheckingBatchTypeResolver extends DefaultBatchTypeResolver {

	@Inject
	Provider<ValidatingReentrantTypeResolver> resolverProvider

	override protected createResolver() {
		resolverProvider.get
	}
			
}

/**
 * This tests ensures that the type calculation does not depend on some lazy evaluation.
 * Therefore all argument types for all overloaded variants are computed eagerly.
 * @author Sebastian Zarnekow
 */
class IsolationTest extends AbstractBatchTypeResolverTest {

	@Inject
	EagerBatchTypeResolver typeResolver
	
	override getTypeResolver() {
		typeResolver
	}
	
}

/**
 * This tests ensures that the type calculation does not depend on some lazy evaluation.
 * Therefore all argument types for all overloaded variants are computed eagerly.
 * @author Sebastian Zarnekow
 */
class InvariantCheckingIsolationTest extends AbstractBatchTypeResolverTest {

	@Inject
	InvariantCheckingEagerBatchTypeResolver typeResolver
	
	override getTypeResolver() {
		typeResolver
	}

}

/**
 * @author Sebastian Zarnekow
 */
class EagerBatchTypeResolver extends DefaultBatchTypeResolver {

	@Inject
	Provider<EagerReentrantTypeResolver> resolverProvider

	override protected createResolver() {
		resolverProvider.get
	}
			
}

/**
 * @author Sebastian Zarnekow
 */
class InvariantCheckingEagerBatchTypeResolver extends DefaultBatchTypeResolver {

	@Inject
	Provider<EagerReentrantTypeResolver> resolverProvider

	override protected createResolver() {
		resolverProvider.get
	}
			
}

/**
 * @author Sebastian Zarnekow
 */
class EagerReentrantTypeResolver extends DefaultReentrantTypeResolver {
	
	@Inject
	EagerArgumentTypeComputer typeComputer
	
	override protected getTypeComputer() {
		typeComputer
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class InvariantCheckingEagerReentrantTypeResolver extends EagerReentrantTypeResolver {
	
	override protected createResolvedTypes() {
		return new ValidatingRootResolvedTypes(this)
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
@Singleton
class EagerArgumentTypeComputer extends XbaseTypeComputer {
	
	override protected <Candidate extends ILinkingCandidate> getBestCandidate(List<? extends Candidate> candidates) {
		candidates.forEach[
			if (it instanceof AbstractPendingLinkingCandidate)
				(it as AbstractPendingLinkingCandidate).computeArgumentTypes()
		]
		super.<Candidate> getBestCandidate(candidates)
	}
	
}
