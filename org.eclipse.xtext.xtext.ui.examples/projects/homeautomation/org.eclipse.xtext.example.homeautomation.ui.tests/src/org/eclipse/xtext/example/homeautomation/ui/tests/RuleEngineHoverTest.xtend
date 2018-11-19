/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.ui.tests

import org.eclipse.jface.text.Region
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractHoverTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.createJavaProject

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(RuleEngineUiInjectorProvider)
class RuleEngineHoverTest extends AbstractHoverTest {

	@Before def void setup() {
		/*
		 * Xbase-based languages require java project
		 */
		projectName.createJavaProject
	}

	@Test def hover_over_device_name() {
		'''
			Device Window can be open, closed
		'''.hasHoverOver("Window", '''Device Window''')
	}

	@Test def hover_over_device_state() {
		'''
			Device Window can be open, closed
		'''.hasHoverOver("open", '''State open''')
	}

	@Test def hover_over_fire_expression() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when Window.open then
				fire(Heater.off)
		'''.hasHoverOver("fire", '''void Hover.fire(Object event)''')
	}

	@Test def hover_over_link_in_javadoc1() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			/*
			 * If the {@link Window} is open, the {@link Heater} should be turned off.
			 */
			Rule 'rule1' when Window.open then
				fire(Heater.off)
		'''.hasHoverInJavadoc("Window", '''Device Window''')
	}

	@Test def hover_over_link_in_javadoc2() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			/*
			 * If the {@link Window} is open, the {@link Heater} should be turned off.
			 */
			Rule 'rule1' when Window.open then
				fire(Heater.off)
		'''.hasHoverInJavadoc("Heater", '''Device Heater''')
	}

	@Test def hover_over_link_in_javadoc3() {
		'''
			/*
			 * {@link java.util.List}
			 */
			Device Window can be open, closed
		'''.hasHoverInJavadoc("java.util.List", '''An ordered collection (also known as a <i>sequence</i>''')
	}

	private def hasHoverInJavadoc(CharSequence it, String hoverText, String hoverContent){
		val startOfJavadoc = toString.indexOf("/**")
		val hoverRegion = new Region(toString.indexOf(hoverText, startOfJavadoc), hoverText.length)
		hasHoverOver(hoverRegion, hoverContent)
	}
}