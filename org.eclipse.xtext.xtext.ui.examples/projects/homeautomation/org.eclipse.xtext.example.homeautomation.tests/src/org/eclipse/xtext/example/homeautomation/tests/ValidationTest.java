/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.homeautomation.tests;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model;
import org.eclipse.xtext.example.homeautomation.ruleEngine.RuleEnginePackage;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RuleEngineInjectorProvider.class)
public class ValidationTest {
	@Inject
	private ParseHelper<Model> parseHelper;

	private ValidationTestHelper validationTestHelper = new ValidationTestHelper(ValidationTestHelper.Mode.EXACT);

	@Test
	public void testDeviceWithNoStates() throws Exception {
		String model = "Device Window can be";
		assertError(model, RuleEnginePackage.Literals.DEVICE, "The device \"Window\" must have at least one state.");
	}

	@Test
	public void testStatesWithSameName() throws Exception {
		String model = "Device Window can be open, open";
		assertError(model, RuleEnginePackage.Literals.STATE, "State names must be unique.");
	}

	@Test
	public void testTwoDevicesWithSameName() throws Exception {
		String model =
				"Device Window can be open\n" +
				"Device Window can be open, closed\n";
		assertError(model, RuleEnginePackage.Literals.DEVICE, "Device names must be unique.");
	}

	@Test
	public void testTwoRulesWithSameDescription() throws Exception {
		String model =
				"Device Window can be open, closed\n" +
				"\n" +
				"Rule 'ruleDescription' when Window.open then\n" +
				"	fire(Window.closed)\n" +
				"	\n" +
				"Rule 'ruleDescription' when Window.closed then\n" +
				"	fire(Window.open)\n";
		assertError(model, RuleEnginePackage.Literals.RULE, "Rule descriptions must be unique.");
	}

	@Test
	public void testRuleWithEmptyDescription() throws Exception {
		String model =
				"Device Window can be open, closed\n" +
				"\n" +
				"Rule '' when Window.open then\n" +
				"	fire(Window.closed)\n";
		assertError(model, RuleEnginePackage.Literals.RULE, "A rule description must not be empty.");
	}

	@Test
	public void testRecursiveRule() throws Exception {
		String model =
				"Device Window can be open\n" +
				"\n" +
				"Rule 'Recursive rule' when Window.open then\n" +
				"	fire(Window.open)\n";
		assertWarning(model, XbasePackage.Literals.XFEATURE_CALL,
				"Firing the same device state that triggers the rule \"Recursive rule\" may lead to endless recursion.");
	}

	private void assertWarning(CharSequence text, EClass objectType, String message) throws Exception {
		validationTestHelper.assertWarning(parseHelper.parse(text), objectType, null, message);
	}

	private void assertError(CharSequence text, EClass objectType, String message) throws Exception {
		validationTestHelper.assertError(parseHelper.parse(text), objectType, null, message);
	}
}
