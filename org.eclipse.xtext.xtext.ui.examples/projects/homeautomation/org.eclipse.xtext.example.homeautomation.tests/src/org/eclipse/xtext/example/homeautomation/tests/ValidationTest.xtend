/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.tests

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.example.homeautomation.ruleEngine.RuleEnginePackage.Literals.*
import static org.eclipse.xtext.xbase.XbasePackage.Literals.*

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(RuleEngineInjectorProvider)
class ValidationTest {

	@Inject extension ParseHelper<Model>

	extension ValidationTestHelper = new ValidationTestHelper(ValidationTestHelper.Mode.EXACT)

	@Test def testDeviceWithNoStates() {
		'''
		Device Window can be
		
		'''.assertError(DEVICE, 'The device "Window" must have at least one state.')
	}

	@Test def testStatesWithSameName() {
		'''
		Device Window can be open, open
		
		'''.assertError(STATE, 'State names must be unique.')
	}

	@Test def testTwoDevicesWithSameName() {
		'''
		Device Window can be open
		Device Window can be open, closed
		
		'''.assertError(DEVICE, "Device names must be unique.")
	}

	@Test def testTwoRulesWithSameDescription() {
		'''
		Device Window can be open, closed
		
		Rule "ruleDescription" when Window.open then
			fire(Window.closed)
			
		Rule "ruleDescription" when Window.closed then
			fire(Window.open)
		'''.assertError(RULE, "Rule descriptions must be unique.")
	}

	@Test def testRuleWithEmptyDescription() {
		'''
		Device Window can be open, closed
		
		Rule "" when Window.open then
			fire(Window.closed)
		'''.assertError(RULE, "A rule description must not be empty.")
	}

	@Test def testRecursiveRule() {
		'''
		Device Window can be open
		
		Rule "Recursive rule" when Window.open then
			fire(Window.open)
		'''.assertWarning(XFEATURE_CALL,
			'Firing the same device state that triggers the rule "Recursive rule" may lead to endless recursion.')
	}

	private def assertWarning(CharSequence text, EClass objectType, String message) {
		text.parse.assertWarning(objectType, null, message)
	}

	private def assertError(CharSequence text, EClass objectType, String message) {
		text.parse.assertError(objectType, null, message)
	}
}