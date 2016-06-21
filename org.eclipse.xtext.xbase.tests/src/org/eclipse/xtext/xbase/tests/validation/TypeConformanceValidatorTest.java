/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
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
		assertConformanceError("do 'foo' while ('bar')", XbasePackage.Literals.XSTRING_LITERAL, "String",
				"boolean");
		
		assertConformanceError("while (null) 'foo'", XbasePackage.Literals.XNULL_LITERAL, "null", "boolean");
		assertConformanceError("while ({}) 'foo'", XbasePackage.Literals.XBLOCK_EXPRESSION, "null", "boolean");
		assertNoConformanceError("while ({'foo'=='bar'}) 'foo'");
		
		assertConformanceError("do 'foo' while (null)", XbasePackage.Literals.XNULL_LITERAL, "null", "boolean");
		assertConformanceError("do 'foo' while ({})", XbasePackage.Literals.XBLOCK_EXPRESSION, "null", "boolean");
		assertNoConformanceError("do 'foo' while ({'foo'=='bar'})");
	}

	@Test public void testCast_00() throws Exception {
		assertNoCastError("'foo' as Object");
	}

	@Test public void testCast_01() throws Exception {
		assertCastError("'foo' as Boolean", TypesPackage.Literals.JVM_TYPE_REFERENCE, "Cannot", "Boolean");
	}

	@Test public void testCast_02() throws Exception {
		assertCastError("new NullPointerException() as StringBuilder", TypesPackage.Literals.JVM_TYPE_REFERENCE,
				"cannot", "StringBuilder");
	}

	@Test public void testCast_03() throws Exception {
		assertNoCastError("new NullPointerException() as CharSequence");
	}

	@Test public void testCast_04() throws Exception {
		// class MyNPE extends NullPointerException implements CharSequence {}
		// TODO: should we check the actual type in case the a casted expression
		// is an upcast? (see comment in XbaseTypeComputer
		assertNoCastError("('foo' as CharSequence) as NullPointerException");
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
		assertNoCastError("42 as byte");
	}
	
	@Test
	public void testCast_07a() throws Exception {
		assertNoCastError("42 as long");
	}
	
	@Test 
	public void testCast_08() throws Exception {
		assertCastError("true as Integer", TypesPackage.Literals.JVM_TYPE_REFERENCE, "Cannot", "boolean", "Integer");
	}
	
	@Test 
	public void testCast_09() throws Exception {
		assertNoCastError("true as Boolean");
	}
	
	@Test 
	public void testCast_10() throws Exception {
		assertNoCastError("(null as Integer) as int");
	}
	
	@Test 
	public void testCast_11() throws Exception {
		assertCastError("(null as Integer) as boolean", TypesPackage.Literals.JVM_TYPE_REFERENCE, "Cannot", "boolean", "Integer");
	}
	
	@Test 
	public void testCast_11a() throws Exception {
		assertCastError("(null as Integer) as short", TypesPackage.Literals.JVM_TYPE_REFERENCE, "Cannot", "Integer", "short");
	}

	@Test 
	public void testCast_11b() throws Exception {
		assertNoCastError("(null as Integer) as long");
	}

	@Test 
	public void testCast_12() throws Exception {
		assertCastError("true as int", TypesPackage.Literals.JVM_TYPE_REFERENCE, "Cannot", "boolean", "int");
	}
	
	@Test 
	public void testCast_13() throws Exception {
		final XExpression xExpression = expression("true as boolean", false);
		helper.assertWarning(xExpression, TypesPackage.Literals.JVM_TYPE_REFERENCE, OBSOLETE_CAST, "boolean");
	}
	
	@Test 
	public void testCast_14() throws Exception {
		assertCastError("new Object as int", TypesPackage.Literals.JVM_TYPE_REFERENCE, "Cannot", "Object", "int");
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

	@Test
	public void testVariableDeclaration() throws Exception {
		assertNoConformanceError("{ var s = 'foo' }");
		assertNoConformanceError("{ var java.lang.String s = 'foo' }");
		assertConformanceError("{ var java.lang.Boolean s = 'foo' }", XbasePackage.Literals.XSTRING_LITERAL,
				"Boolean", "String");
	}
	
	@Test
	public void testVariableDeclarationWithIf() throws Exception {
		assertConformanceError("{ var boolean b = if (true) 'foo' else true }", XbasePackage.Literals.XSTRING_LITERAL,
				"boolean", "String");
	}
	
	@Test
	public void testNullToPrimitive() throws Exception {
		assertConformanceError("{ var boolean b = null }", XbasePackage.Literals.XNULL_LITERAL, "boolean", "null");
	}
	
	@Test
	public void testNullToPrimitiveInIf() throws Exception {
		String expressionAsString = "{ var boolean b = if (Boolean.TRUE) null b.toString }";
		XExpression xExpression = expression(expressionAsString, false);
		List<Issue> issues = helper.validate(xExpression);
		assertEquals(issues.toString(), 1, issues.size());
	}
	
	@Test
	public void testNullToPrimitiveInIfWithBlock() throws Exception {
		String expressionAsString = "{ var boolean b = if (Boolean.TRUE) { null } b.toString }";
		XExpression xExpression = expression(expressionAsString, false);
		List<Issue> issues = helper.validate(xExpression);
		assertEquals(issues.toString(), 1, issues.size());
	}
	
	@Test
	public void testNullToPrimitiveInNestedIf() throws Exception {
		String expressionAsString = "{ var boolean b = if (Boolean.TRUE) if (Boolean.TRUE) null else '' b.toString }";
		XExpression xExpression = expression(expressionAsString, false);
		List<Issue> issues = helper.validate(xExpression);
		assertEquals(issues.toString(), 2, issues.size());
	}
	
	@Test
	public void testNullToPrimitiveInSwitch() throws Exception {
		String expressionAsString = "{ var boolean b = switch new Object { String : true default: null } b.toString }";
		XExpression xExpression = expression(expressionAsString, false);
		List<Issue> issues = helper.validate(xExpression);
		assertEquals(issues.toString(), 1, issues.size());
		Issue singleIssue = issues.get(0);
		assertEquals(expressionAsString.indexOf("null"), singleIssue.getOffset().intValue());
		assertEquals("null".length(), singleIssue.getLength().intValue());
	}
	
	@Test public void testIncompatibleSwitchCase_01() throws Exception {
		String expressionAsString = "{ var boolean b = switch o: new Object { String: o } b.toString }";
		XExpression xExpression = expression(expressionAsString, false);
		List<Issue> issues = helper.validate(xExpression);
		assertEquals(issues.toString(), 1, issues.size());
		Issue singleIssue = issues.get(0);
		assertEquals(expressionAsString.indexOf(": o") + 2, singleIssue.getOffset().intValue());
		assertEquals("o".length(), singleIssue.getLength().intValue());
	}
	
	@Test public void testIncompatibleSwitchCase_02() throws Exception {
		String expressionAsString = "{ var boolean b = switch o: new Object { String: { o } } b.toString }";
		XExpression xExpression = expression(expressionAsString, false);
		List<Issue> issues = helper.validate(xExpression);
		assertEquals(issues.toString(), 1, issues.size());
		Issue singleIssue = issues.get(0);
		assertEquals(expressionAsString.indexOf("{ o") + 2, singleIssue.getOffset().intValue());
		assertEquals("o".length(), singleIssue.getLength().intValue());
	}

	@Test
	public void testCatchClause() throws Exception {
		assertNoConformanceError("try 'foo' catch (java.lang.Exception foo) 'bar'");
		assertNoConformanceError("try 'foo' catch (java.lang.IllegalArgumentException foo) 'bar'");
		assertConformanceError("try 'foo' catch (java.lang.String foo) 'bar'",
				TypesPackage.Literals.JVM_FORMAL_PARAMETER, "Throwable", "String");
	}

	@Test
	public void testThrowsExpression() throws Exception {
		assertNoConformanceError("throw new java.lang.Exception()");
		assertNoConformanceError("throw new java.lang.IllegalArgumentException()");
		assertConformanceError("throw 42", XbasePackage.Literals.XNUMBER_LITERAL, "int",
				"Throwable");
	}

	@Test
	public void testForLoop() throws Exception {
		assertNoConformanceError("for(String foo : new java.util.ArrayList<String>()) 'bar'");
		assertConformanceError("for(Integer foo : true) 'bar'", XbasePackage.Literals.XBOOLEAN_LITERAL,
				"boolean", "Integer");
		assertConformanceError("for(Integer foo : new java.util.ArrayList<String>()) 'bar'",
				XbasePackage.Literals.XCONSTRUCTOR_CALL, "Iterable<? extends Integer>",
				"ArrayList<String>");
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
	
	@Test
	public void testForLoop_05() throws Exception {
		assertConformanceError("{ val java.util.Set<Object> set = newHashSet() for(String s : set) s }", 
				XbasePackage.Literals.XFEATURE_CALL, 
				"Iterable<? extends String>", "String[]", "Set<Object>");
	}
	
	@Test
	public void testForLoop_06() throws Exception {
		assertConformanceError("{ val java.util.Set set = newHashSet() for(String s : set) s.toString }", 
				XbasePackage.Literals.XFOR_LOOP_EXPRESSION, 
				"Type mismatch: cannot convert from element type Object to String");
	}
	
	@Test
	public void testForLoop_07() throws Exception {
		assertConformanceError("{ val java.util.Set set = <String>newHashSet() for(String s : set) s.toString }", 
				XbasePackage.Literals.XFOR_LOOP_EXPRESSION,  
				"Type mismatch: cannot convert from element type Object to String");
	}
	
	@Test 
	public void testForLoop_08() throws Exception {
		assertNoConformanceError("{ val java.util.Set set = newHashSet() for(Object o : set) o }");
	}
	
	@Test 
	@Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=404706")
	public void testEntrySetAddAll_01() throws Exception {
		assertConformanceError("{ val java.util.Map<? extends String, ? extends String> it = null entrySet.addAll(entrySet) }",
				XbasePackage.Literals.XFEATURE_CALL, "TODO");
	}
	
	@Test 
	public void testEntrySetAddAll_02() throws Exception {
		assertConformanceError(
				"{" +
				"  val java.util.Map<? extends String, ? extends String> it = null" +
				"  val java.util.Set<java.util.Map$Entry<? extends String, ? extends String>> set = entrySet" +
				"}",
				XbasePackage.Literals.XFEATURE_CALL, 
				"Type mismatch: cannot convert from Set<? extends Entry<? extends String, ? extends String>> to Set<Entry<? extends String, ? extends String>>");
	}
	
	@Test
	@Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=404706")
	public void testEntrySetAddAll_03() throws Exception {
		assertConformanceError(
				"{" +
				"  val java.util.Map<? extends String, ? extends String> it = null" +
				"  val set = entrySet" +
				"  set.addAll(set)" +
				"}",
				XbasePackage.Literals.XFEATURE_CALL, 
				"TODO");
	}
	
	@Test 
	@Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=404706")
	public void testEntrySetAddAll_04() throws Exception {
		assertConformanceError(
				"{" +
				"  val java.util.Set<? extends java.util.Map$Entry<? extends String, ? extends String>> set = null" +
				"  set.addAll(set)" +
				"}",
				XbasePackage.Literals.XFEATURE_CALL, 
				"Type mismatch: cannot convert from Set<? extends Entry<? extends String, ? extends String>> to Set<Entry<? extends String, ? extends String>>");
	}

	@Test 
	public void testEntrySetAddAll_05() throws Exception {
		assertConformanceError(
				"{" +
				"  val java.util.Map<? extends String, ? extends String> it = null" +
				"  val java.util.Set<java.util.Map.Entry<? extends String, ? extends String>> set = entrySet" +
				"}",
				XbasePackage.Literals.XFEATURE_CALL, 
				"Type mismatch: cannot convert from Set<? extends Entry<? extends String, ? extends String>> to Set<Entry<? extends String, ? extends String>>");
	}
	
	@Test 
	public void testEntrySetAdd_01() throws Exception {
		assertConformanceError(
				"{" +
				"  val java.util.Set<? extends java.util.Map$Entry<? extends String, ? extends String>> set = null" +
				"  set.add(set.head)" +
				"}",
				XbasePackage.Literals.XMEMBER_FEATURE_CALL, 
				"Type mismatch: type Entry<? extends String, ? extends String> is not applicable at this location");
	}
	
	@Test 
	public void testEntrySetAdd_02() throws Exception {
		assertConformanceError(
				"{" +
						"  val java.util.Set<? extends java.util.Map.Entry<? extends String, ? extends String>> set = null" +
						"  set.add(set.head)" +
						"}",
						XbasePackage.Literals.XMEMBER_FEATURE_CALL, 
				"Type mismatch: type Entry<? extends String, ? extends String> is not applicable at this location");
	}
	
	@Test public void testReturn_01() throws Exception {
		assertNoConformanceError("return");
		assertNoConformanceError("return null");
		assertNoConformanceError("return 1");
		assertNoConformanceError("return ''");
	}
	
	@Test public void testReturn_02() throws Exception {
		assertNoConformanceError("println(return)");
	}
	
	@Test public void testReturn_03() throws Exception {
		final XExpression xExpression = expression("println(return)", false);
		helper.assertError(xExpression, XbasePackage.Literals.XFEATURE_CALL, UNREACHABLE_CODE, "Unreachable code.");
	}

	@Test public void testByteCannotBeAssignedToBoolean() throws Exception {
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=457779
		assertConformanceError("boolean", "byte");
	}

	@Test public void testShortCannotBeAssignedToBoolean() throws Exception {
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=457779
		assertConformanceError("boolean", "char");
	}

	@Test public void testCharCannotBeAssignedToBoolean() throws Exception {
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=457779
		assertConformanceError("boolean", "char");
	}

	protected void assertConformanceError(String leftType, String rightType)
			throws Exception {
		final XExpression xExpression = expression(
				"{var " + leftType + " left; var " + rightType + " right; left = right;}", false);
		helper.assertError(xExpression, XbasePackage.Literals.XFEATURE_CALL, INCOMPATIBLE_TYPES, "Cannot", rightType, leftType);
	}

	protected void assertConformanceError(String expression, EClass objectType, String... messageParts)
			throws Exception {
		final XExpression xExpression = expression(expression, false);
		helper.assertError(xExpression, objectType, INCOMPATIBLE_TYPES, messageParts);
	}
	
	protected void assertNoConformanceError(String expression) throws Exception {
		final XExpression xExpression = expression(expression, false);
		helper.assertNoError(xExpression, INCOMPATIBLE_TYPES);
	}

	protected void assertCastError(String expression, EClass objectType, String... messageParts) throws Exception {
		final XExpression xExpression = expression(expression, false);
		helper.assertError(xExpression, objectType, INVALID_CAST, messageParts);
	}
	
	protected void assertNoCastError(String expression) throws Exception {
		final XExpression xExpression = expression(expression, false);
		helper.assertNoError(xExpression, INVALID_CAST);
	}

}
