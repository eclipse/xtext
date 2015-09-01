/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typing

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.AnonymousClass
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.junit.Test

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class AnonymousClassTypeTest extends AbstractXtendTestCase {
	
	@Inject extension IBatchTypeResolver
	
	@Inject extension IXtendJvmAssociations
	
	@Test
	def void testPlainAnonymous() {
		val operation = function('''
			def foo() {
				new Runnable() {
					override run() {}
				}
			}
		''').directlyInferredOperation
		val resolvedTypes = operation.eResource.resolveTypes
		assertEquals('Runnable', resolvedTypes.getActualType(operation).toString)	
	}
	
	@Test
	def void testAnonymousWithAdditionalMember() {
		val function = function('''
			def foo() {
				val foo = new Runnable() {
					int bar
					override run() {}
				}
				foo
			}
		''')
		val operation = function.directlyInferredOperation
		val resolvedTypes = operation.eResource.resolveTypes
		assertEquals('Runnable', resolvedTypes.getActualType(operation).toString)	
		val variable = (function.expression as XBlockExpression).expressions.last
		val variableType = resolvedTypes.getActualType(variable)
		assertEquals('__Foo_1', variableType.toString)
		assertTrue(variableType.isSubtypeOf(Runnable))
	}
	
	@Test
	def void testOverriddenMethodTypeArgumentInference() {
		val function = function('''
			def foo() {
				new Iterable<String>() {
					override iterator() {}
				}
			}
		''')
		val operation = function.directlyInferredOperation
		val resolvedTypes = operation.eResource.resolveTypes
		assertEquals('Iterable<String>', resolvedTypes.getActualType(operation).toString)
		val anonymousClass = (function.expression as XBlockExpression).expressions.head as AnonymousClass
		val overriding = (anonymousClass.members.last as XtendFunction).directlyInferredOperation
		assertEquals('Iterator<String>', resolvedTypes.getActualType(overriding).toString)
	}
	
	@Test
	def void testOverriddenMethodTypeArgumentInference_2() {
		val function = function('''
			def <T> foo() {
				new Iterable<T>() {
					override iterator() {}
				}
			}
		''')
		val operation = function.directlyInferredOperation
		val resolvedTypes = operation.eResource.resolveTypes
		assertEquals('Iterable<T>', resolvedTypes.getActualType(operation).toString)
		val anonymousClass = (function.expression as XBlockExpression).expressions.head as AnonymousClass
		val overriding = (anonymousClass.members.last as XtendFunction).directlyInferredOperation
		assertEquals('Iterator<T>', resolvedTypes.getActualType(overriding).toString)
	}
}
