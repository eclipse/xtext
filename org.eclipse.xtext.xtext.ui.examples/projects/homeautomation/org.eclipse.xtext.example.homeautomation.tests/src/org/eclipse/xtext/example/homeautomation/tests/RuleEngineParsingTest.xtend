/*******************************************************************************
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.tests

import com.google.inject.Inject
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.assertNotNull

@RunWith(XtextRunner)
@InjectWith(RuleEngineInjectorProvider)
class RuleEngineParsingTest{

	@Inject extension ParseHelper<Model>

	@Test def void loadModel() {
		'''
			Device Window can be open, closed
			
			Device Heater can be on, off, error
			
			Rule 'Save energy' when Window.open then
				fire(Heater.off)
				println('Another penny to the piggy bank!')
		'''.parse.assertNotNull
	}

}
