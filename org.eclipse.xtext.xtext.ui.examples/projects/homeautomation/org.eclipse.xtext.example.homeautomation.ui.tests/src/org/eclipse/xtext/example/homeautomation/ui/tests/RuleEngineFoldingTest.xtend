/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractFoldingTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(RuleEngineUiInjectorProvider)
class RuleEngineFoldingTest extends AbstractFoldingTest {

	@Test def rule() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			[>Rule 'rule1' when Window.open then
			[>	fire(Heater.off)<]<]
		'''.testFoldingRegions
	}

	@Test def rules() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			[>Rule 'rule1' when Window.open then
			[>	fire(Heater.off)
				<]<]
			[>Rule 'rule2' when Heater.on then
			[>	fire(Window.closed)
				<]<]
			[>Rule 'rule3' when Window.closed then
			[>	fire(Heater.on)
				<]<]
			[>Rule 'rule4' when Window.closed then
			[>	fire(Window.closed)<]<]
		'''.testFoldingRegions
	}
}
