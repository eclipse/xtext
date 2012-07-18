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
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xbase.XCasePart
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer
import org.eclipse.xtext.xbase.typesystem.internal.AbstractLinkingCandidate
import org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver
import org.eclipse.xtext.xbase.typing.ITypeProvider

import static org.junit.Assert.*
import org.eclipse.xtext.xbase.XbaseFactory
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.common.util.URI
import org.junit.Test
import org.junit.Ignore

/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractBatchTypeResolverTest extends AbstractTypeResolverTest {
	
	override void resolvesTo(String expression, String type) {
		val xExpression = expression(expression.replace('$$', 'org::eclipse::xtext::xbase::lib::'), false /* true */);
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
				XExpression: {
					assertExpressionTypeIsResolved(content, resolvedTypes)
				}
				XCasePart : { /* skip */}
				JvmIdentifiableElement: {
					assertIdentifiableTypeIsResolved(content, resolvedTypes)
				}
			}
		}
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
}

/**
 * @author Sebastian Zarnekow
 */
class OldAPITypeResolverTest extends AbstractTypeResolverTest {
	
	@Inject
	ITypeProvider typeProvider
	
	override void resolvesTo(String expression, String type) {
		val xExpression = expression(expression, false /* true */);
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
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_d_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_h_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_i_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_j_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_k_2() throws Exception {
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
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_24_b() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testOverloadedVarArgs_03() throws Exception {
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
	
	@Ignore("fails in old implementation") @Test override testIfExpression_03() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testSwitchExpression_4() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorCall() throws Exception {
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
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_05b() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_05c() throws Exception {
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
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_131() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_132() throws Exception {
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
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_146() throws Exception {
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
	
	@Ignore("error candidates")
	@Test
	override testEMap_01() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testEMap_02() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_07_02() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_07_03() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_17_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_18_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_19_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_20_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_21_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_22_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_23_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_24_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_26a() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_31() throws Exception {
		fail
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

	@Ignore("error candidates")
	@Test
	override testEMap_01() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testEMap_02() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_07_02() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_07_03() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_17_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_18_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_19_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_20_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_21_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_22_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_23_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_24_b() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_26a() throws Exception {
		fail
	}
	
	@Ignore("error candidates")
	@Test
	override testFeatureCall_31() throws Exception {
		fail
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
	
	override protected <Candidate extends ILinkingCandidate<Candidate>> getBestCandidate(List<Candidate> candidates) {
		candidates.forEach[
			(it as AbstractLinkingCandidate).computeArgumentTypes(feature)
		]
		super.<Candidate> getBestCandidate(candidates)
	}
	
}
