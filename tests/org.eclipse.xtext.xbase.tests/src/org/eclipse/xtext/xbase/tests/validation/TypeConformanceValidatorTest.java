/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class TypeConformanceValidatorTest extends AbstractXbaseTestCase {

	@Inject
	protected ValidationTestHelper helper;

	@Test public void testIfPredicate() throws Exception {
		assertNoConformanceError("if (true) 'foo'");
		assertConformanceError("if (27) 'foo'", XbasePackage.Literals.XNUMBER_LITERAL, "int",
				"boolean");
		assertConformanceError("if (null) 'foo'", XbasePackage.Literals.XNULL_LITERAL, "null", "boolean");
		assertConformanceError("if ({}) 'foo'", XbasePackage.Literals.XBLOCK_EXPRESSION, "null", "boolean");
		assertNoConformanceError("if ({'foo'=='bar'}) 'foo'");
	}
	
	@Test public void testWhilePredicate() throws Exception {
		assertNoConformanceError("while (true) 'foo'");
		assertConformanceError("while (27) 'foo'", XbasePackage.Literals.XNUMBER_LITERAL, "int",
				"boolean");
		assertNoConformanceError("do 'foo' while (true)");
		assertConformanceError("do 'foo' while ('bar')", XbasePackage.Literals.XSTRING_LITERAL, "java.lang.String",
				"boolean");
		
		assertConformanceError("while (null) 'foo'", XbasePackage.Literals.XNULL_LITERAL, "null", "boolean");
		assertConformanceError("while ({}) 'foo'", XbasePackage.Literals.XBLOCK_EXPRESSION, "null", "boolean");
		assertNoConformanceError("while ({'foo'=='bar'}) 'foo'");
		
		assertConformanceError("do 'foo' while (null)", XbasePackage.Literals.XNULL_LITERAL, "null", "boolean");
		assertConformanceError("do 'foo' while ({})", XbasePackage.Literals.XBLOCK_EXPRESSION, "null", "boolean");
		assertNoConformanceError("do 'foo' while ({'foo'=='bar'})");
	}

	@Test public void testCast_00() throws Exception {
		assertNoConformanceError("'foo' as Object");
	}

	@Test public void testCast_01() throws Exception {
		assertCastError("'foo' as Boolean", TypesPackage.Literals.JVM_TYPE_REFERENCE, "Cannot", "Boolean");
	}

	@Test public void testCast_02() throws Exception {
		assertCastError("new NullPointerException() as StringBuilder", TypesPackage.Literals.JVM_TYPE_REFERENCE,
				"cannot", "StringBuilder");
	}

	@Test public void testCast_03() throws Exception {
		assertNoConformanceError("new NullPointerException() as CharSequence");
	}

	@Test public void testCast_04() throws Exception {
		// class MyNPE extends NullPointerException implements CharSequence {}
		// TODO: should we check the actual type in case the a casted expression
		// is an upcast?
		assertNoConformanceError("('foo' as CharSequence) as NullPointerException");
	}

	@Test public void testCast_05() throws Exception {
		assertCastError("('foo' as CharSequence) as Integer", TypesPackage.Literals.JVM_TYPE_REFERENCE, "cannot",
				"CharSequence", "Integer");
	}
	
	@Test
	@Ignore("TODO fix me")
	public void testCast_06() throws Exception {
		assertCastError("newArrayList(new Object()) as java.util.List<String>", TypesPackage.Literals.JVM_TYPE_REFERENCE, "cannot",
				"ArrayList<Object>", "List<String>");
	}

	@Test
	public void testCast_07() throws Exception {
		assertNoConformanceError("42 as byte");
	}
	
	@Test public void testSwitch_TypeGuard_01() throws Exception {
		String expression = "switch ('foo') { Integer : null }";
		final XExpression xExpression = expression(expression, false);
		helper.assertError(xExpression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_CAST);
	}
	
	@Test public void testSwitch_TypeGuard_02() throws Exception {
		String expression = "switch (new java.util.ArrayList()) { java.util.HashSet : null }";
		final XExpression xExpression = expression(expression, false);
		helper.assertError(xExpression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_CAST);
	}

	@Test public void testVariableDeclaration() throws Exception {
		assertNoConformanceError("{ var s = 'foo' }");
		assertNoConformanceError("{ var java.lang.String s = 'foo' }");
		assertConformanceError("{ var java.lang.Boolean s = 'foo' }", XbasePackage.Literals.XSTRING_LITERAL,
				"java.lang.Boolean", "java.lang.String");
	}

	@Test public void testCatchClause() throws Exception {
		assertNoConformanceError("try 'foo' catch (java.lang.Exception foo) 'bar'");
		assertNoConformanceError("try 'foo' catch (java.lang.IllegalArgumentException foo) 'bar'");
		assertConformanceError("try 'foo' catch (java.lang.String foo) 'bar'",
				TypesPackage.Literals.JVM_FORMAL_PARAMETER, "Throwable", "java.lang.String");
	}

	@Test public void testThrowsExpression() throws Exception {
		assertNoConformanceError("throw new java.lang.Exception()");
		assertNoConformanceError("throw new java.lang.IllegalArgumentException()");
		assertConformanceError("throw 42", XbasePackage.Literals.XNUMBER_LITERAL, "int",
				"java.lang.Throwable");
	}

	@Test public void testForLoop() throws Exception {
		assertNoConformanceError("for(String foo : new java.util.ArrayList<String>()) 'bar'");
		assertConformanceError("for(Integer foo : true) 'bar'", XbasePackage.Literals.XBOOLEAN_LITERAL,
				"boolean", "java.lang.Integer");
		assertConformanceError("for(Integer foo : new java.util.ArrayList<String>()) 'bar'",
				XbasePackage.Literals.XCONSTRUCTOR_CALL, "java.lang.Iterable<? extends java.lang.Integer>",
				"java.util.ArrayList<java.lang.String>");
	}
	
	@Test public void testForLoop_02() throws Exception {
		assertNoConformanceError("for(String s : newHashSet('s')) s");
	}
	
	@Test public void testForLoop_03() throws Exception {
		assertNoConformanceError("{ val java.util.Set set = newHashSet() for(Object o : set) o }");
	}
	
	@Test public void testForLoop_04() throws Exception {
		assertNoConformanceError("{ val java.util.Set<String> set = newHashSet() for(String s : set) s }");
	}
	
	@Test public void testForLoop_05() throws Exception {
		assertConformanceError("{ val java.util.Set<Object> set = newHashSet() for(String s : set) s }", 
				XbasePackage.Literals.XFEATURE_CALL, 
				"java.lang.Iterable<? extends java.lang.String>", "java.lang.String[]", "java.util.Set<java.lang.Object>");
	}
	
	@Test public void testForLoop_06() throws Exception {
		assertConformanceError("{ val java.util.Set set = newHashSet() for(String s : set) s }", 
				XbasePackage.Literals.XFEATURE_CALL, 
				"java.lang.Iterable<? extends java.lang.String>", "java.lang.String[]", "java.util.Set");
	}
	
	@Test public void testForLoop_07() throws Exception {
		assertConformanceError("{ val java.util.Set set = <String>newHashSet() for(String s : set) s }", 
				XbasePackage.Literals.XFEATURE_CALL, 
				"java.lang.Iterable<? extends java.lang.String>", "java.lang.String[]", "java.util.Set");
	}
	
	@Test public void testForLoop_08() throws Exception {
		assertNoConformanceError("{ val java.util.Set set = newHashSet() for(Object o : set) o }");
	}

	protected void assertConformanceError(String expression, EClass objectType, String... messageParts)
			throws Exception {
		final XExpression xExpression = expression(expression, false);
		helper.assertError(xExpression, objectType, INCOMPATIBLE_TYPES, messageParts);
	}

	protected void assertCastError(String expression, EClass objectType, String... messageParts) throws Exception {
		final XExpression xExpression = expression(expression, false);
		helper.assertError(xExpression, objectType, INVALID_CAST, messageParts);
	}

	protected void assertNoConformanceError(String expression) throws Exception {
		final XExpression xExpression = expression(expression, false);
		helper.assertNoError(xExpression, INCOMPATIBLE_TYPES);
	}

}
