/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.arithmetics.ui.tests.hyperlinking;

import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractHyperlinkingTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(ArithmeticsUiInjectorProvider.class)
public class HyperlinkingTest extends AbstractHyperlinkingTest {
	@Test
	public void hyperlink_on_function_call() {
		String model =
				"module arithmetics\n" +
				"\n" +
				"def pi: 3.14;\n" +
				"<|>pi<|> * 4;\n";
		hasHyperlinkTo(model, "arithmetics.pi");
	}

	@Test
	public void hyperlink_on_parameter() {
		String model =
				"module m1\n" +
				"\n" +
				"def multiply(a, b) : a * <|>b<|>;\n" +
				"multiply(2,3);\n";
		hasHyperlinkTo(model, "m1.multiply.b");
	}
}
