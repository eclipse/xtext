/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference
import org.eclipse.xtext.xbase.typing.ITypeProvider
import org.eclipse.xtext.xtype.XFunctionTypeRef
import org.junit.Ignore
import org.junit.Test
import org.junit.rules.ErrorCollector
import org.junit.Rule
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.InjectWith

/**
 * @author Sebastian Zarnekow
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseNewTypeSystemInjectorProvider))
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
class RecomputingBatchClosureTypeTest extends BatchClosureTypeTest {
	
	@Inject
	RecomputingBatchTypeResolver recomputingResolver;
	
	override getTypeResolver() {
		recomputingResolver
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class OldAPIClosureTypeTest extends AbstractClosureTypeTest {
	
	@Inject
	ITypeProvider typeProvider
	
	override List<Object> resolvesClosuresTo(String expression, String... types) {
		val closures = expression.findClosures
		val result = <Object>newArrayList
		closures.forEach[ closure, index |
			val closureType = typeProvider.getType(closure)
			assertTrue('''failed for closure at «index»: «closureType»''', closureType instanceof XFunctionTypeRef)
			assertEquals('''failed for closure at «index»''', types.get(index), closureType.simpleName); 
			result += closureType
		]		
		return result
	}
	
	override void withEquivalents(List<Object> references, String... types) {
		references.forEach [ reference, index |
			assertTrue(reference instanceof XFunctionTypeRef)
			assertEquals(types.get(index), (reference as XFunctionTypeRef).equivalent.simpleName)
		]
	}
	
	@Ignore("fails in old impl")
	@Test 
	override testOverloadedOperators_03() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_04() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_12() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_13() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_14() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_16() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_17() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_19() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_20() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_02() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_03() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_04() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_05() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_06() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_08() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_09() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_10() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_11() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_12() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_13() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_14() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_15() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_16() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_17() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_18() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_19() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_20() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_21() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_22() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_23() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_24() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_26() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_27() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testMemberFeatureCall_01() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testNumberLiteralInClosure() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_16() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_19() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_65() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testIfExpression_05() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testIfExpression_07() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testIfExpression_09() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testIfExpression_12() throws Exception {
		fail("fails in old impl")
	}

	@Ignore("fails in old impl")
	@Test
	override testDeferredTypeArgumentResolution_15() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testDeferredTypeArgumentResolution_16() throws Exception {
		fail("fails in old impl")
	}

	@Ignore("fails in old impl")
	@Test
	override testIncompatibleExpression_01() throws Exception {
		fail("fails in old impl")	
	}
	
}

