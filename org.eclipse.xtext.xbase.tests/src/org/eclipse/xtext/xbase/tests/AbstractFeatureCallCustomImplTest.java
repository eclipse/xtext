/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests;

import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AbstractFeatureCallCustomImplTest extends AbstractXbaseTestCase {
	
	@SuppressWarnings("deprecation")
	@Test public void testFeatureCall() throws Exception {
		assertEquals(0, ((XFeatureCall) expression("foo")).getExplicitArguments().size());
		assertEquals(1, ((XFeatureCall) expression("foo(2)")).getExplicitArguments().size());
		assertEquals(2, ((XFeatureCall) expression("foo(3,4)")).getExplicitArguments().size());
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testMemberFeatureCall() throws Exception {
		assertEquals(1, ((XMemberFeatureCall) expression("foo.bar")).getExplicitArguments().size());
		assertEquals(2, ((XMemberFeatureCall) expression("foo.bar(2)")).getExplicitArguments().size());
		assertEquals(3, ((XMemberFeatureCall) expression("foo.bar(3,4)")).getExplicitArguments().size());
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testBinaryOperation() throws Exception {
		assertEquals(2, ((XBinaryOperation) expression("foo + bar")).getExplicitArguments().size());
		assertEquals(2, ((XBinaryOperation) expression("foo - bar + baz")).getExplicitArguments().size());
		assertEquals(2, ((XBinaryOperation) expression("a + b * c + d")).getExplicitArguments().size());
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testUnaryOperation() throws Exception {
		assertEquals(1, ((XUnaryOperation) expression("- bar")).getExplicitArguments().size());
	}
	
	@Override
	protected XExpression expression(CharSequence string) throws Exception {
		return super.expression(string, false);
	}
}
