/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.homeautomation.tests;

import org.eclipse.xtext.example.homeautomation.ruleEngine.Model;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(RuleEngineInjectorProvider.class)
public class RuleEngineParsingTest {
	@Inject
	private ParseHelper<Model> parseHelper;

	@Test
	public void loadModel() throws Exception {
		String model =
				"Device Window can be open, closed\n" +
				"\n" +
				"Device Heater can be on, off, error\n" +
				"\n" +
				"Rule 'Save energy' when Window.open then\n" +
				"	fire(Heater.off)\n" +
				"	println('Another penny to the piggy bank!')\n";
		Assert.assertNotNull(parseHelper.parse(model));
	}
}
