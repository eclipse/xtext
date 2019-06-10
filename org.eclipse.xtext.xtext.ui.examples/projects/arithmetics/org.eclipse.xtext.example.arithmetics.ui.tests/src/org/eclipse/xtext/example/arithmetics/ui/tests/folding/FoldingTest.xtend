/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.tests.folding

import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractFoldingTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(ArithmeticsUiInjectorProvider)
class FoldingTest extends AbstractFoldingTest {

	@Test def function001() {
		'''
			module arithmetics
			
			def add(a, b) :	a + b;
		'''.testFoldingRegions
	}

	@Test def function002() {
		'''
			module arithmetics
			
			[>def add(a, b) :
				a + b;<]
		'''.testFoldingRegions
	}

	@Test def function003() {
		'''
			module arithmetics
			
			[>def add(a, b) :
				a + b;<]
			
			[>def multiply(a, b) :
				a * b;<]
		'''.testFoldingRegions
	}
}
