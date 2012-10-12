/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typing.ITypeProvider
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith

/**
 * @author Sebastian Zarnekow
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseNewTypeSystemInjectorProvider))
class BatchFeatureCallTypeTest extends AbstractFeatureCallTypeTest {
	
	@Inject
	IBatchTypeResolver batchTypeResolver;
	
	def getTypeResolver() {
		batchTypeResolver
	}
	
	override resolvesFeatureCallsTo(String expression, String... types) {
		val expressionWithQualifiedNames = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val featureCalls = expressionWithQualifiedNames.findFeatureCalls
		assertFalse(featureCalls.empty)
		assertEquals(types.size, featureCalls.size)
		val resolvedTypes = typeResolver.resolveTypes(featureCalls.head)
		featureCalls.forEach [ featureCall, index |
			val type = resolvedTypes.getActualType(featureCall)
			assertEquals('''failed for feature call at «index»''', types.get(index), type.simpleName); 
		]
	}
		
}

/**
 * @author Sebastian Zarnekow
 */
class RecomputingBatchFeatureCallTypeTest extends BatchFeatureCallTypeTest {
	
	@Inject
	RecomputingBatchTypeResolver recomputingResolver;
	
	override getTypeResolver() {
		recomputingResolver
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class OldAPIFeatureCallTypeTest extends AbstractFeatureCallTypeTest {
	
	@Inject
	ITypeProvider typeProvider
	
	override resolvesFeatureCallsTo(String expression, String... types) {
		val expressionWithQualifiedNames = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val featureCalls = expressionWithQualifiedNames.findFeatureCalls
		featureCalls.forEach[ featureCall, index |
			val type = typeProvider.getType(featureCall)
			assertEquals('''failed for feature call at «index»''', types.get(index), type.simpleName); 
		]		
	}
	
	@Ignore("fails in old implementation") @Test override testNumberLiteralInClosure_01() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testArray_04() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testArray_07() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testArray_08() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_03() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_13() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_15() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_27() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_30() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_31() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testSwitchExpression_4() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testSwitchExpression_5() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testSwitchExpression_6() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testTypeGuardedCase_1() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorTypeInference_04() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_33() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_35() throws Exception {
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
	
	@Ignore("fails in old implementation") @Test override testPropertyAccess_05() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testPropertyAccess_06() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testBug_389512() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testTypeByTransitiveExpectation_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_08() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_10() throws Exception {
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
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_010() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_011() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_014() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_015() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_017() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_041() throws Exception {
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
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_107() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_110() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_114() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_116() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_117() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_119() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_123() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_134() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_138() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_158() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_05() throws Exception {
		fail("fails in old implementation")
	}
	
}

