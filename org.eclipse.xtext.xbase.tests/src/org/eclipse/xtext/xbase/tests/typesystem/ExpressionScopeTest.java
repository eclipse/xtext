/**
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.Objects;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProviderWithScopeTracking;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(XbaseInjectorProviderWithScopeTracking.class)
@RunWith(XtextRunner.class)
public class ExpressionScopeTest extends AbstractXbaseTestCase {
	@Inject
	private IBatchTypeResolver batchTypeResolver;

	protected void contains(IExpressionScope scope, String name) {
		assertContains(scope.getFeatureScope(), QualifiedName.create(name));
	}

	protected void assertContains(IScope scope, QualifiedName name) {
		Iterable<IEObjectDescription> elements = scope.getAllElements();
		String toString = elements.toString();
		assertNotNull(toString, scope.getSingleElement(name));
		assertFalse(toString, Iterables.isEmpty(scope.getElements(name)));
		assertTrue(toString, IterableExtensions.exists(elements, it -> Objects.equals(it.getName(), name)));
	}

	protected void containsNot(IExpressionScope scope, String name) {
		assertContainsNot(scope.getFeatureScope(), QualifiedName.create(name));
	}

	protected void assertContainsNot(IScope scope, QualifiedName name) {
		Iterable<IEObjectDescription> elements = scope.getAllElements();
		String toString = elements.toString();
		assertNull(toString, scope.getSingleElement(name));
		assertTrue(toString, Iterables.isEmpty(scope.getElements(name)));
		assertFalse(toString, IterableExtensions.exists(elements, it -> Objects.equals(it.getName(), name)));
	}

	@Test
	public void testGetExpressionScope_01() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var x = 1 }", false);
		IExpressionScope expressionScope = batchTypeResolver.resolveTypes(block).getExpressionScope(block, IExpressionScope.Anchor.AFTER);
		containsNot(expressionScope, "x");
	}

	@Test
	public void testGetExpressionScope_02() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var x = 1 }", false);
		IExpressionScope expressionScope = batchTypeResolver.resolveTypes(block).getExpressionScope(block, IExpressionScope.Anchor.BEFORE);
		containsNot(expressionScope, "x");
	}

	@Test
	public void testGetExpressionScope_03() throws Exception {
		XExpression varDecl = Iterables.getFirst(((XBlockExpression) expression("{ var x = 1 }", false)).getExpressions(), null);
		IExpressionScope expressionScope = batchTypeResolver.resolveTypes(varDecl).getExpressionScope(varDecl,
				IExpressionScope.Anchor.AFTER);
		contains(expressionScope, "x");
	}

	@Test
	public void testGetExpressionScope_04() throws Exception {
		XExpression varDecl = Iterables.getFirst(((XBlockExpression) expression("{ var x = 1 }", false)).getExpressions(), null);
		IExpressionScope expressionScope = batchTypeResolver.resolveTypes(varDecl).getExpressionScope(varDecl,
				IExpressionScope.Anchor.BEFORE);
		containsNot(expressionScope, "x");
	}

	@Test
	public void testMemberOnIt_01() throws Exception {
		XExpression varDecl = Iterables.getFirst(((XBlockExpression) expression("{ var it = \"\" }", false)).getExpressions(), null);
		IExpressionScope expressionScope = batchTypeResolver.resolveTypes(varDecl).getExpressionScope(varDecl,
				IExpressionScope.Anchor.AFTER);
		contains(expressionScope, "charAt");
		contains(expressionScope, "it");
		contains(expressionScope, "operator_lessThan");
	}

	@Test
	public void testMemberOnIt_02() throws Exception {
		XExpression varDecl = Iterables.getFirst(((XBlockExpression) expression("{ var it = \"\" }", false)).getExpressions(), null);
		IExpressionScope expressionScope = batchTypeResolver.resolveTypes(varDecl).getExpressionScope(varDecl,
				IExpressionScope.Anchor.BEFORE);
		containsNot(expressionScope, "charAt");
		containsNot(expressionScope, "it");
		containsNot(expressionScope, "operator_lessThan");
	}

	@Test
	public void testMemberOnIt_03() throws Exception {
		XVariableDeclaration first = (XVariableDeclaration) Iterables
				.getFirst(((XBlockExpression) expression("{ var (int)=>int it = [] }", false)).getExpressions(), null);
		Assert.assertNotNull(first);
		XExpression varInit = first.getRight();
		IExpressionScope expressionScope = batchTypeResolver.resolveTypes(varInit).getExpressionScope(varInit,
				IExpressionScope.Anchor.BEFORE);
		contains(expressionScope, "it");
	}

	@Test
	public void testMemberOnIt_04() throws Exception {
		XVariableDeclaration first = (XVariableDeclaration) Iterables
				.getFirst(((XBlockExpression) expression("{ var it = [] }", false)).getExpressions(), null);
		Assert.assertNotNull(first);
		XExpression varInit = first.getRight();
		IExpressionScope expressionScope = batchTypeResolver.resolveTypes(varInit).getExpressionScope(varInit,
				IExpressionScope.Anchor.BEFORE);
		containsNot(expressionScope, "it");
	}

	@Test
	public void testMemberOnIt_05() throws Exception {
		XVariableDeclaration first = (XVariableDeclaration) Iterables
				.getFirst(((XBlockExpression) expression("{ var (int)=>int it = null }", false)).getExpressions(), null);
		Assert.assertNotNull(first);
		XExpression varInit = first.getRight();
		IExpressionScope expressionScope = batchTypeResolver.resolveTypes(varInit).getExpressionScope(varInit,
				IExpressionScope.Anchor.BEFORE);
		containsNot(expressionScope, "it");
	}

	@Test
	public void testDefaultStaticMethods_01() throws Exception {
		XExpression varDecl = Iterables.getFirst(((XBlockExpression) expression("{ var it = \"\" }", false)).getExpressions(), null);
		IExpressionScope expressionScope = batchTypeResolver.resolveTypes(varDecl).getExpressionScope(varDecl,
				IExpressionScope.Anchor.BEFORE);
		contains(expressionScope, "newArrayList");
	}

	@Test
	public void testReassignedType_01() throws Exception {
		XIfExpression ifExpr = (XIfExpression) IterableExtensions
				.lastOrNull(((XBlockExpression) expression("{ var it = new Object() if (it instanceof String) {} }", false)).getExpressions());
		XBlockExpression block = (XBlockExpression) ifExpr.getThen();
		IExpressionScope expressionScope = batchTypeResolver.resolveTypes(block).getExpressionScope(block, IExpressionScope.Anchor.BEFORE);
		contains(expressionScope, "charAt");
		contains(expressionScope, "it");
		contains(expressionScope, "operator_lessThan");
	}

	@Test
	public void testReassignedType_02() throws Exception {
		XIfExpression ifExpr = (XIfExpression) IterableExtensions
				.lastOrNull(((XBlockExpression) expression("{ var it = new Object() if (it instanceof String) { it = new Object() } }", false))
						.getExpressions());
		XBlockExpression block = (XBlockExpression) ifExpr.getThen();
		IExpressionScope expressionScope = batchTypeResolver.resolveTypes(block).getExpressionScope(block, IExpressionScope.Anchor.BEFORE);
		contains(expressionScope, "charAt");
		contains(expressionScope, "it");
		contains(expressionScope, "operator_lessThan");
	}

	@Test
	public void testReassignedType_03() throws Exception {
		XIfExpression ifExpr = (XIfExpression) IterableExtensions
				.lastOrNull(((XBlockExpression) expression("{ var it = new Object() if (it instanceof String) { it = new Object() } }", false))
						.getExpressions());
		XBlockExpression block = (XBlockExpression) ifExpr.getThen();
		XExpression assignment = Iterables.getFirst(block.getExpressions(), null);
		IExpressionScope expressionScope = batchTypeResolver.resolveTypes(assignment).getExpressionScope(assignment,
				IExpressionScope.Anchor.AFTER);
		containsNot(expressionScope, "charAt");
		contains(expressionScope, "it");
		containsNot(expressionScope, "operator_lessThan");
	}
}
