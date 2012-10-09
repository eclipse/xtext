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
class BatchIdentifiableTypeTest extends AbstractIdentifiableTypeTest {
	
	@Inject
	IBatchTypeResolver batchTypeResolver
	
	def getTypeResolver() {
		batchTypeResolver
	}
	
	override resolvesIdentifiablesTo(String expression, String... types) {
		val expressionWithQualifiedNames = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val identifiables = expressionWithQualifiedNames.findIdentifiables
		assertFalse(identifiables.empty)
		assertEquals(types.size, identifiables.size)
		val resolvedTypes = typeResolver.resolveTypes(identifiables.head)
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
class RecomputingBatchIdentifiableTypeTest extends BatchIdentifiableTypeTest {
	
	@Inject
	RecomputingBatchTypeResolver recomputingResolver;
	
	override getTypeResolver() {
		recomputingResolver
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class OldAPIIdentifiableTypeTest extends AbstractIdentifiableTypeTest {
	
	@Inject
	ITypeProvider typeProvider
	
	override resolvesIdentifiablesTo(String expression, String... types) {
		val expressionWithQualifiedNames = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val identifiables = expressionWithQualifiedNames.findIdentifiables
		identifiables.forEach[ identifiable, index |
			val type = typeProvider.getTypeForIdentifiable(identifiable)
			assertEquals('''failed for identifiable at «index»''', types.get(index), type.simpleName); 
		]		
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_03() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_04() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_13() throws Exception {
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
	@Ignore("fails in old implementation") @Test override testClosure_21() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_22() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_26() throws Exception {
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
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_32() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_35() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_002() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_012() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_016() throws Exception {
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
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_040() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_042() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_061() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_062() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_102() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_106() throws Exception {
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
	
	@Ignore("takes too long") @Test override testFeatureCall_15_b() throws Exception {
		fail("takes too long")
	}
	@Ignore("takes too long") @Test override testFeatureCall_15_f() throws Exception {
		fail("takes too long")
	}
}

