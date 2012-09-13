package org.eclipse.xtend.core.tests.formatting

import org.junit.Test
import org.eclipse.xtend.core.formatting.RendererConfiguration
import org.junit.Assert

class XtendFormatterConfigurationTest {
	
	@Test def test() {
		val cfg = new RendererConfiguration()
		val map = cfg.asMap
		val cfg2 = new RendererConfiguration(map)
		Assert::assertNotNull(cfg2) 
	} 
}