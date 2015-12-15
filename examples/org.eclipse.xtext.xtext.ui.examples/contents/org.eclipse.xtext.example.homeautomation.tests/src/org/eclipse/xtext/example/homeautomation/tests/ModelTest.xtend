package org.eclipse.xtext.example.homeautomation.tests

import com.google.inject.Inject
import org.eclipse.xtext.example.homeautomation.tests.RuleEngineInjectorProvider
import org.eclipse.xtext.example.homeautomation.ruleEngine.Device
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model
import org.eclipse.xtext.example.homeautomation.ruleEngine.Rule
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(RuleEngineInjectorProvider)
class ModelTest {

	@Inject extension ParseHelper<Model>

	@Test
	def void testParsing() {
		val model = '''
			Device Window can be open, closed
			Device Heater can be on, off
			Rule "Save energy" when Window.open then
				fire(Heater.off)
				println('Another penny to the piggy bank!')
		'''.parse

		val device = model.declarations.get(0) as Device
		Assert::assertEquals("Window", device.name)

		val rule = model.declarations.get(2) as Rule
		Assert::assertEquals("Save energy", rule.description)
		Assert::assertEquals("open", rule.deviceState.name);
	}
}