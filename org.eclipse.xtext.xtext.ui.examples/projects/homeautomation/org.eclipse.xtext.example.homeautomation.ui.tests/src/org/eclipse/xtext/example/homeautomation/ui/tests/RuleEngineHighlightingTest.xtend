package org.eclipse.xtext.example.homeautomation.ui.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.testing.AbstractHighlightingTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(RuleEngineUiInjectorProvider)
class RuleEngineHighlightingTest extends AbstractHighlightingTest {

	@Inject extension DefaultHighlightingConfiguration

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
}
