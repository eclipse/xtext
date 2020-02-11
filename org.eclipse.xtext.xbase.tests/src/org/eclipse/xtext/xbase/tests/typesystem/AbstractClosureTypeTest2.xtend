/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.rules.ErrorCollector

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractClosureTypeTest2 extends AbstractXbaseTestCase {
	
	@Inject
	IBatchTypeResolver typeResolver;
	
	@Rule
 	public ErrorCollector collector= new ErrorCollector();
	
	def List<Object> resolvesClosuresTo(CharSequence expression, String... types) {
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
	
	def void withEquivalents(List<Object> references, String... types) {
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
	
	static Set<String> seenExpressions
	
	@BeforeClass
	def static void createSeenExpressionsSet() {
		seenExpressions = newHashSet
	}
	
	@AfterClass
	def static void discardSeenExpressions() {
		seenExpressions = null
	}
	
	def protected findClosures(CharSequence expression) {
		val expressionAsString = expression.toString
			.replace('ClosureTypeResolutionTestData', 'org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeResolutionTestData')
			.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val xExpression = expression(expressionAsString, false)
		val Closures = EcoreUtil2::eAll(xExpression).filter(typeof(XClosure)).toList
		return Closures.sortBy [ NodeModelUtils::findActualNodeFor(it).offset ]
	}
	
	override protected expression(CharSequence expression, boolean resolve) throws Exception {
		val string = expression.toString
		if (!seenExpressions.add(string)) {
			fail("Duplicate expression under test: " + expression)
		}
		super.expression(expression, resolve)
	}
	
}
