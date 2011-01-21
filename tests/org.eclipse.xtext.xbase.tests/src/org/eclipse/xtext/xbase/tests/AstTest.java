/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests;

import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XUnaryOperation;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AstTest extends AbstractXbaseTestCase {
	
	public void testFeatureCall() throws Exception {
		assertEquals(0, ((XFeatureCall) expression("foo")).getAllArguments().size());
		assertEquals(1, ((XFeatureCall) expression("foo(2)")).getAllArguments().size());
		assertEquals(2, ((XFeatureCall) expression("foo(3,4)")).getAllArguments().size());
	}
	
	public void testMemberFeatureCall() throws Exception {
		assertEquals(1, ((XMemberFeatureCall) expression("foo.bar")).getAllArguments().size());
		assertEquals(2, ((XMemberFeatureCall) expression("foo.bar(2)")).getAllArguments().size());
		assertEquals(3, ((XMemberFeatureCall) expression("foo.bar(3,4)")).getAllArguments().size());
	}
	
	public void testBinaryOperation() throws Exception {
//		assertEquals(2, ((XBinaryOperation) expression("foo + bar")).getArguments().size());
		assertEquals(2, ((XBinaryOperation) expression("foo - bar + baz")).getAllArguments().size());
		assertEquals(2, ((XBinaryOperation) expression("a + b * c + d")).getAllArguments().size());
	}
	
	public void testUnaryOperation() throws Exception {
		assertEquals(1, ((XUnaryOperation) expression("- bar")).getAllArguments().size());
	}
	
	@Override
	protected XExpression expression(String string) throws Exception {
		return super.expression(string, false);
	}
}
