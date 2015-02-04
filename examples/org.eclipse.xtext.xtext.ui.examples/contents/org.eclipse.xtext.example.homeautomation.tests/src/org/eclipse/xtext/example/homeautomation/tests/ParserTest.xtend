package org.eclipse.xtext.example.homeautomation.tests

import com.google.inject.Inject
import org.eclipse.xtext.example.homeautomation.RuleEngineInjectorProvider
import org.eclipse.xtext.example.homeautomation.ruleEngine.Device
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model
import org.eclipse.xtext.example.homeautomation.ruleEngine.Rule
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(RuleEngineInjectorProvider)
class ParserTest {
	
	@Inject extension ParseHelper<Model>
	@Inject extension ValidationTestHelper

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
	
	@Test
	def void testParsingAndLinking1() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			Rule "Save energy" when Window.open then
				for (v : Heater.values)
					val output = 'Heater state ' + v.name
					println(output)
				fire(Heater.off)
		'''.parse.assertNoErrors
	}
	
	@Test
	def void testParsingAndLinking2() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off, error
			Rule "Start heating" when Window.closed then
				val t0 = Double.parseDouble(System.getProperty('temperature'))
				fire(Heater.on)
				Thread.sleep(10000)
				val t1 = Double.parseDouble(System.getProperty('temperature'))
				if (t1 - t0 < 4.0)
					executeReport_error
			Rule "Report error" when Heater.error then
				println('Something went wrong.')
		'''.parse.assertNoErrors
	}
	
}