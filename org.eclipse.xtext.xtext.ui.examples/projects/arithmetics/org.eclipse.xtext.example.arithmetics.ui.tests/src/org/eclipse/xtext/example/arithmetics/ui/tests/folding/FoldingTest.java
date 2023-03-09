/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.arithmetics.ui.tests.folding;

import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractFoldingTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(ArithmeticsUiInjectorProvider.class)
public class FoldingTest extends AbstractFoldingTest {
	@Test
	public void function001() {
		String model =
				"module arithmetics\n" +
				"def add(a, b) :	a + b;\n";
		testFoldingRegions(model);
	}

	@Test
	public void function002() {
		String model =
				"module arithmetics\n" +
				"[>def add(a, b) :\n" +
				"	a + b;<]\n";
		testFoldingRegions(model);
	}

	@Test
	public void function003() {
		String model =
				"module arithmetics\n" +
				"\n" +
				"[>def add(a, b) :\n" +
				"	a + b;<]" +
				"\n" +
				"[>def multiply(a, b) :\n" +
				"	a * b;<]\n";
		testFoldingRegions(model);
	}
}
