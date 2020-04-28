/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(RuleEngineInjectorProvider)
abstract class AbstractTest {

	def protected abstract void test(CharSequence document) throws Exception

	@Test def void test1() throws Exception {
		'''
			Device Window can be open, closed
			Device Heater can be on, off
			Rule "Save energy" when Window.open then
				fire(Heater.off)
				println('Another penny to the piggy bank!')
		'''.test
	}

	@Test def void test2() throws Exception {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			Rule "Save energy" when Window.open then
				for (v : Heater.values)
					val output = 'Heater state ' + v.name
					println(output)
				fire(Heater.off)
		'''.test
	}

	@Test def void test3() throws Exception {
		'''
			Device Window can be open, closed
			Device Heater can be on, off
			Rule "Save energy" when Window.open then
				switch new java.util.Random().nextInt()
					case 1,
					case 2:
						fire(Heater.off)
						println('Another penny to the piggy bank!')
					default:
						fire(Heater.on)
						println('I do support global warming!')
		'''.test
	}
}