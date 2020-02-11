/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.interpreter;

import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.impl.NullEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class InterpreterTest extends AbstractXbaseTestCase {
	
	@Inject XbaseInterpreter interpreter;
	
	@Test public void testCancelIndication() throws Exception {
		XExpression expression = expression("'string'", true);
		assertNull(interpreter.evaluate(expression, new NullEvaluationContext(), new CancelIndicator() {
			@Override
			public boolean isCanceled() {
				return true;
			}
		}));
		assertEquals("string", interpreter.evaluate(expression, new NullEvaluationContext(), null).getResult());
		assertEquals("string", interpreter.evaluate(expression, new NullEvaluationContext(), new CancelIndicator() {
			@Override
			public boolean isCanceled() {
				return false;
			}
		}).getResult());
	}
	
	@Test public void testInfiniteLoopInJava() throws Exception {
		XExpression expression = expression(
				"try " +
				"  new testdata.ClosureClient().infiniteApply(|{null})" +
				"catch(Exception e)" +
				"  'literal' ", true);
		assertNull(interpreter.evaluate(expression, new DefaultEvaluationContext(), new CancelIndicator() {
			private int i = 0;
			@Override
			public boolean isCanceled() {
				if (i == 500)
					return true;
				i++;
				return false;
			}
		}));
	}
}
