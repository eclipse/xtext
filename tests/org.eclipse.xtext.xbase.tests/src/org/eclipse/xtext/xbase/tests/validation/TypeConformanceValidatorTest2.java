/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseNewTypeSystemInjectorProvider.class)
public class TypeConformanceValidatorTest2 extends TypeConformanceValidatorTest {
	
	@Override
	@Test public void testWhilePredicate() throws Exception {
		assertNoConformanceError("while (true) 'foo'");
		assertConformanceError("while (27) 'foo'", XbasePackage.Literals.XNUMBER_LITERAL, "int",
				"boolean");
		assertNoConformanceError("do 'foo' while (true)");
		assertConformanceError("do 'foo' while ('bar')", XbasePackage.Literals.XSTRING_LITERAL, "String",
				"boolean");
		
		assertConformanceError("while (null) 'foo'", XbasePackage.Literals.XNULL_LITERAL, "null", "boolean");
		assertConformanceError("while ({}) 'foo'", XbasePackage.Literals.XBLOCK_EXPRESSION, "null", "boolean");
		assertNoConformanceError("while ({'foo'=='bar'}) 'foo'");
		
		assertConformanceError("do 'foo' while (null)", XbasePackage.Literals.XNULL_LITERAL, "null", "boolean");
		assertConformanceError("do 'foo' while ({})", XbasePackage.Literals.XBLOCK_EXPRESSION, "null", "boolean");
		assertNoConformanceError("do 'foo' while ({'foo'=='bar'})");
	}
	
	@Override
	@Test
	public void testVariableDeclaration() throws Exception {
		assertNoConformanceError("{ var s = 'foo' }");
		assertNoConformanceError("{ var java.lang.String s = 'foo' }");
		assertConformanceError("{ var java.lang.Boolean s = 'foo' }", XbasePackage.Literals.XSTRING_LITERAL,
				"Boolean", "String");
	}
	
	@Override
	@Test
	public void testCatchClause() throws Exception {
		assertNoConformanceError("try 'foo' catch (java.lang.Exception foo) 'bar'");
		assertNoConformanceError("try 'foo' catch (java.lang.IllegalArgumentException foo) 'bar'");
		assertConformanceError("try 'foo' catch (java.lang.String foo) 'bar'",
				TypesPackage.Literals.JVM_FORMAL_PARAMETER, "Throwable", "String");
	}
	
	@Override
	@Test
	public void testThrowsExpression() throws Exception {
		assertNoConformanceError("throw new java.lang.Exception()");
		assertNoConformanceError("throw new java.lang.IllegalArgumentException()");
		assertConformanceError("throw 42", XbasePackage.Literals.XNUMBER_LITERAL, "int",
				"Throwable");
	}
	
	@Override
	@Test
	public void testForLoop() throws Exception {
		assertNoConformanceError("for(String foo : new java.util.ArrayList<String>()) 'bar'");
		assertConformanceError("for(Integer foo : true) 'bar'", XbasePackage.Literals.XBOOLEAN_LITERAL,
				"boolean", "Integer");
		assertConformanceError("for(Integer foo : new java.util.ArrayList<String>()) 'bar'",
				XbasePackage.Literals.XCONSTRUCTOR_CALL, "Iterable<? extends Integer>",
				"ArrayList<String>");
	}
	
	@Override
	@Test
	public void testForLoop_05() throws Exception {
		assertConformanceError("{ val java.util.Set<Object> set = newHashSet() for(String s : set) s }", 
				XbasePackage.Literals.XFEATURE_CALL, 
				"Iterable<? extends String>", "String[]", "Set<Object>");
	}
	
	@Override
	@Test
	public void testForLoop_06() throws Exception {
		assertConformanceError("{ val java.util.Set set = newHashSet() for(String s : set) s }", 
				XbasePackage.Literals.XFEATURE_CALL, 
				"Iterable<? extends String>", "String[]", "Set");
	}
	
	@Override
	@Test
	public void testForLoop_07() throws Exception {
		assertConformanceError("{ val java.util.Set set = <String>newHashSet() for(String s : set) s }", 
				XbasePackage.Literals.XFEATURE_CALL, 
				"Iterable<? extends String>", "String[]", "Set");
	}
	
	
}
