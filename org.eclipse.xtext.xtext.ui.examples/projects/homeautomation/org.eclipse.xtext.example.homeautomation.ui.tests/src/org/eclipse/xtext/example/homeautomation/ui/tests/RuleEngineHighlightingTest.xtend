/*******************************************************************************
 * Copyright (c) 2018, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.ui.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractHighlightingTest
import org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingConfiguration
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.createJavaProject

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(RuleEngineUiInjectorProvider)
class RuleEngineHighlightingTest extends AbstractHighlightingTest {

	@Inject extension XbaseHighlightingConfiguration

	@Before def void setup() {
		/*
		 * Xbase-based languages require java project
		 */
		projectName.createJavaProject
	}

	@Test def device_keyword() {
		'''
			Device Window can be open, closed
		'''.testHighlighting("Device", keywordTextStyle)
	}

	@Test def can_keyword() {
		'''
			Device Window can be open, closed
		'''.testHighlighting("can", keywordTextStyle)
	}

	@Test def be_keyword() {
		'''
			Device Window can be open, closed
		'''.testHighlighting("be", keywordTextStyle)
	}

	@Test def rule_keyword() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when Window.open then
				fire(Heater.off)
		'''.testHighlighting("Rule", keywordTextStyle)
	}

	@Test def when_keyword() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when Window.open then
				fire(Heater.off)
		'''.testHighlighting("when", keywordTextStyle)
	}

	@Test def then_keyword() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when Window.open then
				fire(Heater.off)
		'''.testHighlighting("then", keywordTextStyle)
	}

	@Test def switch_keyword() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off
			
			Rule "Save energy" when Window.open then
				switch new java.util.Random().nextInt
					case 1,
					case 2:
						fire(Heater.off)
					default:
						fire(Heater.on)
		'''.testHighlighting("switch", keywordTextStyle)
	}

	@Test def case_keyword() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off
			
			Rule "Save energy" when Window.open then
				switch new java.util.Random().nextInt
					case 1,
					case 2:
						fire(Heater.off)
					default:
						fire(Heater.on)
		'''.testHighlighting("case", keywordTextStyle)
	}

	@Test def default_keyword() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off
			
			Rule "Save energy" when Window.open then
				switch new java.util.Random().nextInt
					case 1,
					case 2:
						fire(Heater.off)
					default:
						fire(Heater.on)
		'''.testHighlighting("default", keywordTextStyle)
	}

	@Test def number() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off
			
			Rule "Save energy" when Window.open then
				switch new java.util.Random().nextInt
					case 1,
					case 2:
						fire(Heater.off)
					default:
						fire(Heater.on)
		'''.testHighlighting("1", numberTextStyle)
	}

	@Test def punctuation() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when Window.open then
				fire(Heater.off)
		'''.testHighlighting(".", punctuationTextStyle)
	}

	@Test def single_quoted_rule_description() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule 'rule1' when Window.open then
				fire(Heater.off)
		'''.testHighlighting("rule1", stringTextStyle)
	}

	@Test def double_quoted_rule_description() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule "rule1" when Window.open then
				fire(Heater.off)
		'''.testHighlighting("rule1", stringTextStyle)
	}

	@Test def fire_method_invocation() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule "rule1" when Window.open then
				fire(Heater.off)
		'''.testHighlighting("fire", staticMethodInvocation)
	}

	@Test def device_state_access() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule "rule1" when Window.open then
				fire(Heater.off)
		'''.testHighlighting("off", staticField)
	}

	@Test def single_line_comment() {
		'''
			// A language for home automation systems.
			
			Device Window can be open, closed
			Device Heater can be on, off, error
			
			Rule "rule1" when Window.open then
				fire(Heater.off)
		'''.testHighlighting("A language for home automation systems", commentTextStyle)
	}

	@Test def multi_line_comment() {
		'''
			/*
			 * A language for home automation systems
			 * supporting indentation-based code blocks
			 * similar to Python.
			 */
			
			Device Window can be open, closed
			Device Heater can be on, off, error
		'''.testHighlighting('''
			/*
			 * A language for home automation systems
			 * supporting indentation-based code blocks
			 * similar to Python.
			 */
		''', commentTextStyle)
	}

	@Test def fixme_task_in_comment() {
		'''
			/**
			 * FIXME
			 */
			Device Window can be open, closed
		'''.testHighlighting('FIXME', taskTextStyle)
	}

	@Test def todo_task_in_comment() {
		'''
			/**
			 * TODO
			 */
			Device Window can be open, closed
		'''.testHighlighting('TODO', taskTextStyle)
	}

	@Test def xxx_task_in_comment() {
		'''
			/**
			 * XXX
			 */
			Device Window can be open, closed
		'''.testHighlighting('XXX', taskTextStyle)
	}

	protected override int getStartPosition(String content, String text) {
		content.lastIndexOf(text)
	}
}
