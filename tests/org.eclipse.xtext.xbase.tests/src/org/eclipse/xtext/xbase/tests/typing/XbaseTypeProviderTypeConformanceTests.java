/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import static org.eclipse.xtext.typing.ITypeConformanceComputer.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.typing.ITypeProvider;
import org.eclipse.xtext.typing.ITypeProvider.Context;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class XbaseTypeProviderTypeConformanceTests extends AbstractXbaseValidatonTest {

	@Inject
	protected ITypeProvider<JvmTypeReference> typeProvider;

	public void testIfPredicate() throws Exception {
		assertNoConformanceError("if (true) 'foo'");
		assertConformanceError("if (27) 'foo'", XbasePackage.Literals.XINT_LITERAL, "java.lang.Integer",
				"java.lang.Boolean");
	}

	public void testWhilePredicate() throws Exception {
		assertNoConformanceError("while (true) 'foo'");
		assertConformanceError("while (27) 'foo'", XbasePackage.Literals.XINT_LITERAL, "java.lang.Integer",
				"java.lang.Boolean");
		assertNoConformanceError("do 'foo' while (true)");
		assertConformanceError("do 'foo' while ('bar')", XbasePackage.Literals.XSTRING_LITERAL, "java.lang.String",
				"java.lang.Boolean");
	}

	public void testCast() throws Exception {
		assertNoConformanceError("(java.lang.Object) 'foo'");
		assertConformanceError("(java.lang.Boolean) 'foo'", XbasePackage.Literals.XSTRING_LITERAL, "java.lang.Boolean",
				"java.lang.String");
	}

	public void testVariableDeclaration() throws Exception {
		assertNoConformanceError("{ var s = 'foo' }");
		assertNoConformanceError("{ var java.lang.String s = 'foo' }");
		assertConformanceError("{ var java.lang.Boolean s = 'foo' }", XbasePackage.Literals.XSTRING_LITERAL,
				"java.lang.Boolean", "java.lang.String");
	}

	public void testCatchClause() throws Exception {
		assertNoConformanceError("try 'foo' catch (java.lang.Exception foo) 'bar'");
		assertNoConformanceError("try 'foo' catch (java.lang.IllegalArgumentException foo) 'bar'");
		assertConformanceError("try 'foo' catch (java.lang.String foo) 'bar'", TypesPackage.Literals.JVM_FORMAL_PARAMETER, "java.lang.Throwable", "java.lang.String");
	}
	
	public void testThrowsExpression() throws Exception {
		assertNoConformanceError("throw new java.lang.Exception()");
		assertNoConformanceError("throw new java.lang.IllegalArgumentException()");
		assertConformanceError("throw 42", XbasePackage.Literals.XINT_LITERAL, "java.lang.Integer", "java.lang.Throwable");
	}
	
	public void testForExpression() throws Exception {
		
	}
	
	protected void assertConformanceError(String expression, EClass objectType, String... messageParts)
			throws Exception {
		resetErrors();
		XExpression xExpression = expression(expression, true);
		typeProvider.getType(xExpression, Context.<JvmTypeReference> newCtx(this));
		super.assertError(objectType, ISSUE_NON_CONFORMANT_TYPES, messageParts);
	}

	protected void assertNoConformanceError(String expression) throws Exception {
		resetErrors();
		XExpression xExpression = expression(expression, true);
		typeProvider.getType(xExpression, Context.<JvmTypeReference> newCtx(this));
		super.assertNoError(ISSUE_NON_CONFORMANT_TYPES);
	}

}
