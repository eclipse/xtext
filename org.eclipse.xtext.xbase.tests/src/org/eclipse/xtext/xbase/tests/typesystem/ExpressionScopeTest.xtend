/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.tests.XbaseInjectorProviderWithScopeTracking
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IExpressionScope
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.xbase.typesystem.IExpressionScope.Anchor.*

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(XbaseInjectorProviderWithScopeTracking)
@RunWith(XtextRunner)
class ExpressionScopeTest extends AbstractXbaseTestCase {
	@Inject
	extension IBatchTypeResolver
	
	protected def contains(IExpressionScope scope, String name) {
		scope.featureScope.assertContains(QualifiedName.create(name))
	}
	
	protected def assertContains(IScope scope, QualifiedName name) {
		val elements = scope.allElements
		val toString = elements.toString
		assertNotNull(toString, scope.getSingleElement(name))
		assertFalse(toString, scope.getElements(name).empty)
		assertTrue(toString, elements.exists[ it.name == name ])
	}
	
	protected def containsNot(IExpressionScope scope, String name) {
		scope.featureScope.assertContainsNot(QualifiedName.create(name))
	}
	
	protected def assertContainsNot(IScope scope, QualifiedName name) {
		val elements = scope.allElements
		val toString = elements.toString
		assertNull(toString, scope.getSingleElement(name))
		assertTrue(toString, scope.getElements(name).empty)
		assertFalse(toString, elements.exists[ it.name == name ])
	}
	
	@Test
	def void testGetExpressionScope_01() {
		val block = '''{ var x = 1 }'''.expression(false) as XBlockExpression
		val expressionScope = block.resolveTypes.getExpressionScope(block, ^AFTER)
		expressionScope.containsNot('x')
	}
	
	@Test
	def void testGetExpressionScope_02() {
		val block = '''{ var x = 1 }'''.expression(false) as XBlockExpression
		val expressionScope = block.resolveTypes.getExpressionScope(block, ^BEFORE)
		expressionScope.containsNot('x')
	}
	
	@Test
	def void testGetExpressionScope_03() {
		val varDecl = ('''{ var x = 1 }'''.expression(false) as XBlockExpression).expressions.head
		val expressionScope = varDecl.resolveTypes.getExpressionScope(varDecl, ^AFTER)
		expressionScope.contains('x')
	}
	
	@Test
	def void testGetExpressionScope_04() {
		val varDecl = ('''{ var x = 1 }'''.expression(false) as XBlockExpression).expressions.head
		val expressionScope = varDecl.resolveTypes.getExpressionScope(varDecl, ^BEFORE)
		expressionScope.containsNot('x')
	}
	
	@Test
	def void testMemberOnIt_01() {
		val varDecl = ('''{ var it = "" }'''.expression(false) as XBlockExpression).expressions.head
		val expressionScope = varDecl.resolveTypes.getExpressionScope(varDecl, ^AFTER)
		expressionScope.contains('charAt')
		expressionScope.contains('it')
		expressionScope.contains('operator_lessThan')
	}
	
	@Test
	def void testMemberOnIt_02() {
		val varDecl = ('''{ var it = "" }'''.expression(false) as XBlockExpression).expressions.head
		val expressionScope = varDecl.resolveTypes.getExpressionScope(varDecl, ^BEFORE)
		expressionScope.containsNot('charAt')
		expressionScope.containsNot('it')
		expressionScope.containsNot('operator_lessThan')
	}
	
	@Test
	def void testMemberOnIt_03() {
		val varInit = (('''{ var (int)=>int it = [] }'''.expression(false) as XBlockExpression).expressions.head as XVariableDeclaration).right
		val expressionScope = varInit.resolveTypes.getExpressionScope(varInit, ^BEFORE)
		expressionScope.contains('it')
	}
	
	@Test
	def void testMemberOnIt_04() {
		val varInit = (('''{ var it = [] }'''.expression(false) as XBlockExpression).expressions.head as XVariableDeclaration).right
		val expressionScope = varInit.resolveTypes.getExpressionScope(varInit, ^BEFORE)
		expressionScope.containsNot('it')
	}
	
	@Test
	def void testMemberOnIt_05() {
		val varInit = (('''{ var (int)=>int it = null }'''.expression(false) as XBlockExpression).expressions.head as XVariableDeclaration).right
		val expressionScope = varInit.resolveTypes.getExpressionScope(varInit, ^BEFORE)
		expressionScope.containsNot('it')
	}
	
	@Test
	def void testDefaultStaticMethods_01() {
		val varDecl = ('''{ var it = "" }'''.expression(false) as XBlockExpression).expressions.head
		val expressionScope = varDecl.resolveTypes.getExpressionScope(varDecl, ^BEFORE)
		expressionScope.contains('newArrayList')
	}
	
	@Test
	def void testReassignedType_01() {
		val ifExpr = ('''{ var it = new Object() if (it instanceof String) {} }'''.expression(false) as XBlockExpression).expressions.last as XIfExpression
		val block = ifExpr.then as XBlockExpression
		val expressionScope = block.resolveTypes.getExpressionScope(block, ^BEFORE)
		expressionScope.contains('charAt')
		expressionScope.contains('it')
		expressionScope.contains('operator_lessThan')
	}
	
	@Test
	def void testReassignedType_02() {
		val ifExpr = ('''{ var it = new Object() if (it instanceof String) { it = new Object() } }'''.expression(false) as XBlockExpression).expressions.last as XIfExpression
		val block = ifExpr.then as XBlockExpression
		val expressionScope = block.resolveTypes.getExpressionScope(block, ^BEFORE)
		expressionScope.contains('charAt')
		expressionScope.contains('it')
		expressionScope.contains('operator_lessThan')
	}
	
	@Test
	def void testReassignedType_03() {
		val ifExpr = ('''{ var it = new Object() if (it instanceof String) { it = new Object() } }'''.expression(false) as XBlockExpression).expressions.last as XIfExpression
		val block = ifExpr.then as XBlockExpression
		val assignment = block.expressions.head
		val expressionScope = assignment.resolveTypes.getExpressionScope(assignment, ^AFTER)
		expressionScope.containsNot('charAt')
		expressionScope.contains('it')
		expressionScope.containsNot('operator_lessThan')
	}
}

