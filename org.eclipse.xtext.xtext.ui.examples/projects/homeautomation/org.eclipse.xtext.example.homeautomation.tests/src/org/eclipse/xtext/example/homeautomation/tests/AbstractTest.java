/**
 * Copyright (c) 2015, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.homeautomation.tests;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.Strings;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuleEngineInjectorProvider.class)
public abstract class AbstractTest {
	protected abstract void test(final CharSequence document) throws Exception;

	@Test
	public void test1() throws Exception {
		String model =
				"Device Window can be open, closed\n" +
				"Device Heater can be on, off\n" +
				"Rule \"Save energy\" when Window.open then\n" +
				"	fire(Heater.off)\n" +
				"	println('Another penny to the piggy bank!')\n";
		test(Strings.toPlatformLineSeparator(model));
	}

	@Test
	public void test2() throws Exception {
		String model =
				"Device Window can be open, closed\n" +
				"Device Heater can be on, off, error\n" +
				"Rule \"Save energy\" when Window.open then\n" +
				"	for (v : Heater.values)\n" +
				"		val output = 'Heater state ' + v.name\n" +
				"		println(output)\n" +
				"	fire(Heater.off)\n";
		test(Strings.toPlatformLineSeparator(model));
	}

	@Test
	public void test3() throws Exception {
		String model =
				"Device Window can be open, closed\n" +
				"Device Heater can be on, off\n" +
				"Rule \"Save energy\" when Window.open then\n" +
				"	switch new java.util.Random().nextInt()\n" +
				"		case 1,\n" +
				"		case 2:\n" +
				"			fire(Heater.off)\n" +
				"			println('Another penny to the piggy bank!')\n" +
				"		default:\n" +
				"			fire(Heater.on)\n" +
				"			println('I do support global warming!')\n";
		test(Strings.toPlatformLineSeparator(model));
	}
}
