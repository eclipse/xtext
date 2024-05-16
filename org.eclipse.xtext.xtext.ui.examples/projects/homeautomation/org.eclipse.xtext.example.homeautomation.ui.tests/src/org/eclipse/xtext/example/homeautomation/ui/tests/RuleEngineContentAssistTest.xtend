/*******************************************************************************
 * Copyright (c) 2018, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(RuleEngineUiInjectorProvider)
class RuleEngineContentAssistTest extends AbstractContentAssistTest {

	@Test def empty() throws Exception {
		'''
			«c»
		'''.assertContentAssistant(#[
			'Device',
			'Rule'
		], 'Device', '''
			Device
		''')
	}

	@Test def rule_device_state() throws Exception {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when «c»
		'''.assertContentAssistant(#[
			'Window.open',
			'Window.closed',
			'Heater.on',
			'Heater.off',
			'Heater.error'
		], 'Window.open', '''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when Window.open
		''')
	}

	@Test def rule_device_state_with_prefix() throws Exception {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when Win«c»
		'''.assertContentAssistant(#[
			'Window.open',
			'Window.closed'
		], 'Window.open', '''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when Window.open
		''')
	}

	@Test def rule_then_part() throws Exception {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when Window.open then
				«c»
		'''.assertContentAssistant(#[
			'do',
			'false',
			'for',
			'if',
			'new',
			'null',
			'return',
			'switch',
			'synchronized',
			'throw',
			'true',
			'try',
			'typeof',
			'val',
			'var',
			'while'
		], 'switch', '''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when Window.open then
				switch
		''')
	}

	@Test def rule_then_part_with_prefix() throws Exception {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when Window.open then
				fire(Heater.o«c»)
		'''.assertContentAssistant(#[
			'on',
			'off'
		], 'off', '''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when Window.open then
				fire(Heater.off)
		''')
	}
}
