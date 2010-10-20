/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.scoping;

import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseScopeProviderTest extends AbstractXbaseTestCase {
	
	public void testAssignment_1() throws Exception {
		XAssignment assignment = (XAssignment) expression("new java.util.ArrayList<String>() += 'foo'");
		assertEquals("java.util.ArrayList.add(E)",assignment.getFeature().getCanonicalName());
	}
	
	public void testLocalVarAssignment_1() throws Exception {
		XBlockExpression block = (XBlockExpression) expression("{ var x = ''; x = '' }");
		XAssignment assignment = (XAssignment) block.getExpressions().get(1);
		assertTrue(String.valueOf(assignment.getAssignable()), assignment.getAssignable() instanceof XFeatureCall);
		assertTrue(String.valueOf(((XAbstractFeatureCall) assignment.getAssignable()).getFeature()), assignment.getAssignable() instanceof XFeatureCall);
		assertTrue(String.valueOf(assignment.getFeature()), assignment.getFeature() instanceof XVariableDeclaration);
		assertSame(assignment.getFeature(), ((XAbstractFeatureCall) assignment.getAssignable()).getFeature());
	}
	
	public void testImplicitThis_1() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{ " +
				"	val this = new java.util.ArrayList<String>(); " +
				"	size;" +
				"}");
//		TODO: fix expectation
//		assertEquals("java.util.ArrayList.size()",((XFeatureCall)bop.getExpressions().get(1)).getFeature().getCanonicalName());
		assertEquals("java.util.ArrayList.size",((XFeatureCall)bop.getExpressions().get(1)).getFeature().getCanonicalName());
	}
	
	public void testImplicitThis_2() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{ " +
				"	val this = new java.util.ArrayList<String>(); " +
				"	size();" +
				"}");
//		TODO: fix expectation
//		assertEquals("java.util.ArrayList.size()",((XFeatureCall)bop.getExpressions().get(1)).getFeature().getCanonicalName());
		assertEquals("java.util.ArrayList.size",((XFeatureCall)bop.getExpressions().get(1)).getFeature().getCanonicalName());
	}
	
	public void testShadowing_1() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{ " +
				"	val this = new java.util.List<String>(); " +
				"	val size = 23;" +
				"	size;" +
				"}");
		assertTrue(((XFeatureCall)bop.getExpressions().get(2)).getFeature() instanceof XVariableDeclaration);
	}
	
	public void testShadowing_2() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{ " +
				"	val size = 23;" +
				"	val this = new java.util.ArrayList<String>(); " +
				"	size;" +
				"}");
		assertTrue(((XFeatureCall)bop.getExpressions().get(2)).getFeature() instanceof XVariableDeclaration);
	}
	
	public void testShadowing_3() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{" +
				"	val size = 23;" +
				"	{" +
				"		val this = new java.util.ArrayList<String>(); " +
				"		size;" +
				"	};" +
				"}");
		XBlockExpression innerBlock = (XBlockExpression)bop.getExpressions().get(1);
//		TODO: fix expectation
//		assertEquals("java.util.ArrayList.size()",((XFeatureCall)innerBlock.getExpressions().get(1)).getFeature().getCanonicalName());
		assertEquals("java.util.ArrayList.size",((XFeatureCall)innerBlock.getExpressions().get(1)).getFeature().getCanonicalName());
	}
	
	public void testShadowing_4() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{" +
				"	val size = 23;" +
				"	{" +
				"		val this = new java.util.ArrayList<String>(); " +
				"		size();" +
				"	};" +
				"}");
		XBlockExpression innerBlock = (XBlockExpression)bop.getExpressions().get(1);
//		TODO: fix expectation
//		assertEquals("java.util.ArrayList.size()",((XFeatureCall)innerBlock.getExpressions().get(1)).getFeature().getCanonicalName());
		assertEquals("java.util.ArrayList.size",((XFeatureCall)innerBlock.getExpressions().get(1)).getFeature().getCanonicalName());
	}
	
	public void testShadowing_5() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{" +
				"	val size = 23;" +
				"	String size|size;" +
				"}");
		XClosure closure = (XClosure)bop.getExpressions().get(1);
		assertSame(closure.getFormalParameters().get(0), ((XFeatureCall)closure.getExpression()).getFeature());
	}
	
	public void testShadowing_6() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{" +
				"	val size = 23;" +
				"	String x|size;" +
				"}");
		XClosure closure = (XClosure)bop.getExpressions().get(1);
		assertSame(bop.getExpressions().get(0), ((XFeatureCall)closure.getExpression()).getFeature());
	}
	
	public void testShadowing_7() throws Exception {
		XBlockExpression bop = (XBlockExpression) expression(
				"{" +
				"	val size = 23;" +
				"	String size| String x|size;" +
		"}");
		XClosure closure = (XClosure)bop.getExpressions().get(1);
		assertSame(closure.getFormalParameters().get(0), ((XFeatureCall)((XClosure)closure.getExpression()).getExpression()).getFeature());
	}
}
