/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class PrimitivesExtensionsTest extends AbstractXbaseTestCase {
	@Inject
	private IExpressionInterpreter interpreter;

	@Test
	public void testOperator_tripleEquals() throws Exception {

		assertEquals(Boolean.TRUE, evaluateOperation("===", "1000200030004L", "1000200030004L"));
		assertEquals(Boolean.FALSE, evaluateOperation("===", "1000200030004L", "2000200030004L"));

	}

	@Test
	public void testOperator_tripleNotEquals() throws Exception {

		assertEquals(Boolean.FALSE, evaluateOperation("!==", "1000200030004L", "1000200030004L"));
		assertEquals(Boolean.TRUE, evaluateOperation("!==", "1000200030004L", "2000200030004L"));

	}

	private Object evaluateOperation(String primitiveOp, String a, String b) throws Exception {
		String expr = "{val  a = " + a + "; val  b = " + b + "; a" + primitiveOp + "b}";
		XExpression expression = expression(expr, true);
		return interpreter.evaluate(expression).getResult();
	}
}
