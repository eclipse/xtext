/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.arithmetics.tests;

import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(ArithmeticsInjectorProvider.class)
public class ArithmeticsParsingTest {
	@Inject
	private ParseHelper<Module> parseHelper;

	@Inject
	private ValidationTestHelper validationTestHelper;

	@Test
	public void loadModel() throws Exception {
		String model =
				"module test\n" +
				"def fun(a,b) : a * b;\n" +
				"fun(2, fun(3,4));\n";
		validationTestHelper.assertNoErrors(parseHelper.parse(model));
	}
}
