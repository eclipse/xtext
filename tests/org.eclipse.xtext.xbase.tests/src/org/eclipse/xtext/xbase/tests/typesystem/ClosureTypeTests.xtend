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

/**
 * @author Sebastian Zarnekow
 */
class BatchClosureTypeTest extends AbstractClosureTypeTest {
	
	@Inject
	IBatchTypeResolver typeResolver;
	
	override List<Object> resolvesClosuresTo(String expression, String... types) {
		val expressionWithQualifiedNames = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val closures = expressionWithQualifiedNames.findClosures
		assertFalse(closures.empty)
		assertEquals(types.size, closures.size)
		val resolvedTypes = typeResolver.resolveTypes(closures.head)
		val result = <Object>newArrayList
		closures.forEach [ closure, index |
			val closureType = resolvedTypes.getActualType(closure)
			assertTrue('''failed for closure at «index»: «closureType»''', closureType instanceof FunctionTypeReference)
			assertEquals('''failed for closure at «index»''', types.get(index), closureType.simpleName); 
			result += closureType
		]
		
		return result
	}
	
	override void withEquivalents(List<Object> references, String... types) {
		references.forEach [ reference, index |
			assertTrue(reference instanceof FunctionTypeReference)
			assertEquals(types.get(index), (reference as FunctionTypeReference).equivalent)
		]
	}
	
	def String getEquivalent(ParameterizedTypeReference type) {
		'''«type.type.simpleName»<«type.typeArguments.join(', ') [simpleName]»>'''
	}
		
}

/**
 * @author Sebastian Zarnekow
 */
class OldAPIClosureTypeTest extends AbstractClosureTypeTest {
	
	@Inject
	ITypeProvider typeProvider
	
	override List<Object> resolvesClosuresTo(String expression, String... types) {
		val expressionWithQualifiedNames = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val closures = expressionWithQualifiedNames.findClosures
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
}

