/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.arithmetics.ui.tests.quickfix;

import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider;
import org.eclipse.xtext.example.arithmetics.validation.ArithmeticsValidator;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(ArithmeticsUiInjectorProvider.class)
public class QuickfixTest extends AbstractQuickfixTest {
	@Test
	public void normalize_expression() {
		String model = 
				"module test\n" +
				"def fun : 1+2;";
		String expectation = 
				"module test\n" +
				"def fun : 3;";
		testQuickfixesOn(model, ArithmeticsValidator.NORMALIZABLE,
				new Quickfix("Replace with 3", "Replace expression with '3'", expectation));
	}
}
