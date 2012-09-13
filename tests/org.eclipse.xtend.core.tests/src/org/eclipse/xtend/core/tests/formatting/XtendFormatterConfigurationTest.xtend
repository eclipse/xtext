package org.eclipse.xtend.core.tests.formatting

import org.junit.Test
import org.eclipse.xtend.core.formatting.XtendFormatterConfig
import org.junit.Assert

class XtendFormatterConfigurationTest {
	
	@Test def test() {
		val cfg = new XtendFormatterConfig()
		val map = cfg.asMap
		val cfg2 = new XtendFormatterConfig(map)
		Assert::assertNotNull(cfg2) 
	} 
}