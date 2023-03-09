/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.homeautomation.tests;

import org.eclipse.xtext.example.homeautomation.ruleEngine.Device;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Rule;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(RuleEngineInjectorProvider.class)
public class ModelTest {
	@Inject
	private ParseHelper<Model> parseHelper;

	@Test
	public void testParsing() throws Exception {
		String text =
				"Device Window can be open, closed\n" +
				"Device Heater can be on, off\n" +
				"Rule 'Save energy' when Window.open then\n" +
				"	fire(Heater.off)\n" +
				"	println('Another penny to the piggy bank!')\n";
		Model model = parseHelper.parse(text);
		Device device = (Device) model.getDeclarations().get(0);
		Assert.assertEquals("Window", device.getName());
		Rule rule = (Rule) model.getDeclarations().get(2);
		Assert.assertEquals("Save energy", rule.getDescription());
		Assert.assertEquals("open", rule.getDeviceState().getName());
	}
}
