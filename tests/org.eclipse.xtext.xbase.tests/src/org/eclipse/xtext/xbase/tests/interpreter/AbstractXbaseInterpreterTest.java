/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.interpreter;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractXbaseInterpreterTest extends AbstractXbaseTestCase {

	private IExpressionInterpreter interpreter;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		interpreter = get(IExpressionInterpreter.class);
	}
	
	@Override
	protected void tearDown() throws Exception {
		interpreter = null;
		super.tearDown();
	}
	
	public void assertEvaluatesTo(Object expectation, String model) {
		try {
			XExpression expression = expression(model);
			IEvaluationResult result = interpreter.evaluate(expression);
			assertNull("Expected no exception. Model was: " + model, result.getException());
			assertEquals("Model was: " + model, expectation, result.getResult());
		} catch(Exception e) {
			if (e instanceof RuntimeException)
				throw (RuntimeException)e;
			throw new RuntimeException(e);
		}
	}
}
