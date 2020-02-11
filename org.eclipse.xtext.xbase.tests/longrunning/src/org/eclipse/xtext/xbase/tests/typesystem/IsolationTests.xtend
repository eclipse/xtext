/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.junit.runner.RunWith
import org.junit.Test

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
@InjectWith(typeof(XbaseShufflingInjectorProvider))
class ShuffledTypeResolverTest extends AbstractBatchTypeResolverTest {
	
	@Inject
	IBatchTypeResolver typeResolver;
	
	override getTypeResolver() {
		typeResolver
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
class RecomputingBatchTypeArgumentTest extends BatchTypeArgumentTest {
	
	@Inject
	RecomputingBatchTypeResolver recomputingResolver;
	
	override getTypeResolver() {
		recomputingResolver
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
class PermutingBatchReturnTypeResolverTest extends BatchReturnTypeResolverTest {
	
	override resolvesTo(String expression, String type) {
		val replacedExpressionText = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val xExpression = expression(replacedExpressionText, false /* true */);
		assertTrue(xExpression.eResource.errors.toString, xExpression.eResource.errors.isEmpty)
		assertTrue(xExpression.eResource.warnings.toString, xExpression.eResource.warnings.isEmpty)
		if (!xExpression.hasReturnExpression) {
			doResolvesTo('''return («replacedExpressionText»)''', type);
			doResolvesTo('''{ { return («replacedExpressionText») } }''', type);
			doResolvesTo('''return {«replacedExpressionText»}''', type);
			doResolvesTo('''{ { return { ( if (true) «replacedExpressionText» ) {«replacedExpressionText»} }''', type);
		} else {
			doResolvesTo('''{ «replacedExpressionText» }''', type);
			doResolvesTo('''{ ( if (true) «replacedExpressionText» ) {«replacedExpressionText»} }''', type);
		}
		val resolvedTypes = getTypeResolver.resolveTypes(xExpression)
		val resolvedType = resolvedTypes.getReturnType(xExpression)
		assertEquals(replacedExpressionText, type, resolvedType.simpleName);
		assertTrue(xExpression.eResource.linkingAndSyntaxErrors.toString, xExpression.eResource.linkingAndSyntaxErrors.isEmpty)
		assertTrue(xExpression.eResource.warnings.toString, xExpression.eResource.warnings.isEmpty)
		return resolvedType
	}
	
	@Test override void testIfExpression_27() throws Exception {
		// a permutation of this one is 'return (if (true) while ..))' which indicates that the result should not be void
		// "if (true) while(false) ('foo'+'bar').length".resolvesTo("null")
		"return if (true) while(false) ('a'+'b').length".resolvesTo("null")
	}
	
	@Test override void testSwitchExpression_11() throws Exception {
		// a permutation of this one is 'return switch ..' which indicates that the switch result should not be void
//		"switch null {
//		  Object : return 
//		}".resolvesTo("void")
		"return switch null {
		  Object : return 
		}".resolvesTo("void")
	}
	
}