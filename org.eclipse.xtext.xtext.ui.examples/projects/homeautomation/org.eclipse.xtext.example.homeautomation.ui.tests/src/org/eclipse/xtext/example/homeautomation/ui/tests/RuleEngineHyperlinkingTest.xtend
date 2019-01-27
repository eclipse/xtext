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
import org.eclipse.xtext.ui.testing.AbstractHyperlinkingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.createJavaProject

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(RuleEngineUiInjectorProvider)
class RuleEngineHyperlinkingTest extends AbstractHyperlinkingTest {

	@Before def void setup() {
		/*
		 * Xbase-based languages require java project
		 */
		projectName.createJavaProject
	}

	@Test def hyperlink_on_rule_when_part() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when «c»Window.open«c» then
				fire(Heater.off)
		'''.hasHyperlinkTo("Window.open")
	}

	@Test def hyperlink_on_device_name_in_rule_then_part() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when Window.open then
				fire(«c»Heater«c».off)
		'''.hasHyperlinkTo("Heater")
	}

	@Test def hyperlink_on_device_state_in_rule_then_part() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when Window.open then
				fire(Heater.«c»off«c»)
		'''.hasHyperlinkTo("Heater.off")
	}

	@Test def hyperlink_on_link_in_javadoc1() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			/**
			 * If the {@link «c»Window«c»} is open, the {@link Heater} should be turned off.
			 */
			Rule 'rule1' when Window.open then
				fire(Heater.off)
		'''.hasHyperlinkTo("Window")
	}

	@Test def hyperlink_on_link_in_javadoc2() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			/**
			 * If the {@link Window} is open, the {@link «c»Heater«c»} should be turned off.
			 */
			Rule 'rule1' when Window.open then
				fire(Heater.off)
		'''.hasHyperlinkTo("Heater")
	}

	@Test def hyperlink_on_link_in_javadoc3() {
		'''
			/**
			 * {@link «c»java.util.List«c»}
			 */
			Device Window can be open, closed
		'''.hasHyperlinkTo("java.util.List")
	}
}