package org.eclipse.xtext.example.homeautomation.tests

import org.eclipse.xtext.example.homeautomation.tests.RuleEngineInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(RuleEngineInjectorProvider)
abstract class AbstractTest {

	def protected abstract void test(CharSequence document)

	@Test def void test1() {
		'''
			Device Window can be open, closed
			Device Heater can be on, off
			Rule "Save energy" when Window.open then
				fire(Heater.off)
				println('Another penny to the piggy bank!')
		'''.test
	}

	@Test def void test2() {
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

	@Test def void test3() {
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
		'''.test
	}
	
	@Test def void test4() {
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