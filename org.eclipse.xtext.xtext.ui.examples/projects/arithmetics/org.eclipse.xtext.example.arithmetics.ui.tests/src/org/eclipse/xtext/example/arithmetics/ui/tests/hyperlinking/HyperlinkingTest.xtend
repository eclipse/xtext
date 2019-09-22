/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.tests.hyperlinking

import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractHyperlinkingTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(ArithmeticsUiInjectorProvider)
class HyperlinkingTest extends AbstractHyperlinkingTest {

	@Test def hyperlink_on_function_call() {
		'''
			module arithmetics
			
			def pi: 3.14;
			«c»pi«c» * 4;
		'''.hasHyperlinkTo("arithmetics.pi")
	}

	@Test def hyperlink_on_parameter() {
		'''
			module m1
			
			def multiply(a, b) : a * «c»b«c»;
			multiply(2,3);
		'''.hasHyperlinkTo("m1.multiply.b")
	}
}