/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class TypeConformanceValidatorTest extends AbstractXbaseTestCase {

	@Inject 
	protected ValidationTestHelper helper;
	
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
		assertNoConformanceError("'foo' as Object");
		assertConformanceError("'foo' as Boolean", XbasePackage.Literals.XSTRING_LITERAL, "java.lang.Boolean",
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
		assertConformanceError("try 'foo' catch (java.lang.String foo) 'bar'",
				TypesPackage.Literals.JVM_FORMAL_PARAMETER, "java.lang.Throwable", "java.lang.String");
	}

	public void testThrowsExpression() throws Exception {
		assertNoConformanceError("throw new java.lang.Exception()");
		assertNoConformanceError("throw new java.lang.IllegalArgumentException()");
		assertConformanceError("throw 42", XbasePackage.Literals.XINT_LITERAL, "java.lang.Integer",
				"java.lang.Throwable");
	}

	public void testForLoop() throws Exception {
		assertNoConformanceError("for(String foo : new java.util.ArrayList<String>()) 'bar'");
		assertConformanceError("for(Integer foo : true) 'bar'", XbasePackage.Literals.XBOOLEAN_LITERAL,
				"java.lang.Boolean", "java.lang.Integer");
		assertConformanceError("for(Integer foo : new java.util.ArrayList<String>()) 'bar'",
				XbasePackage.Literals.XCONSTRUCTOR_CALL, "java.lang.Iterable<? extends java.lang.Integer>",
				"java.util.ArrayList<java.lang.String>");
	}

	protected void assertConformanceError(String expression, EClass objectType, String... messageParts)
			throws Exception {
		final XExpression xExpression = expression(expression, true);
		helper.assertError(xExpression, objectType, XbaseJavaValidator.INCOMPATIBLE_TYPES, messageParts);
	}

	protected void assertNoConformanceError(String expression) throws Exception {
		final XExpression xExpression = expression(expression, true);
		helper.assertNoError(xExpression, XbaseJavaValidator.INCOMPATIBLE_TYPES);
	}
	
}
