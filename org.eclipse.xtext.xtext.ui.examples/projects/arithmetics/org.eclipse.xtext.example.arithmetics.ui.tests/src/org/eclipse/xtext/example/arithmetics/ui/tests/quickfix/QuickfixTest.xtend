/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.tests.quickfix

import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.example.arithmetics.validation.ArithmeticsValidator.NORMALIZABLE

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(ArithmeticsUiInjectorProvider)
class QuickfixTest extends AbstractQuickfixTest {

	@Test def normalize_expression() {
		'''
			module test
			def fun : 1+2;
		'''.testQuickfixesOn(NORMALIZABLE, new Quickfix("Replace with 3", "Replace expression with '3'", '''
			module test
			def fun : 3;
		'''))
	}

}