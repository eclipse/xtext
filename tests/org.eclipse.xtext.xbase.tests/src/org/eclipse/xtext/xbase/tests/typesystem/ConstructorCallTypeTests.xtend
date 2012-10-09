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
class RecomputingBatchConstructorCallTypeTest extends BatchConstructorCallTypeTest {
	
	@Inject
	RecomputingBatchTypeResolver recomputingResolver;
	
	override getTypeResolver() {
		recomputingResolver
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class OldAPIConstructorCallTypeTest extends AbstractConstructorCallTypeTest {
	
	@Inject
	ITypeProvider typeProvider
	
	override resolvesConstructorCallsTo(String expression, String... types) {
		val expressionWithQualifiedNames = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val featureCalls = expressionWithQualifiedNames.findConstructorCalls
		featureCalls.forEach[ featureCall, index |
			val type = typeProvider.getType(featureCall)
			assertEquals('''failed for constructor call at «index»''', types.get(index), type.simpleName); 
		]		
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorTypeParameters_01() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testConstructorTypeParameters_02() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testConstructorTypeParameters_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testConstructorTypeParameters_04() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorTypeInference_04() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testConstructorTypeInference_06() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testConstructorTypeInference_07() throws Exception {
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
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_134() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_136() throws Exception {
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
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_155() throws Exception {
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

