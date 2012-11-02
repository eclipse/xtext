package org.eclipse.xtend.core.tests.formatting

import org.junit.Test

import org.eclipse.xtend.core.formatting.XtendFormatterConfig
import static org.junit.Assert.*
import org.eclipse.xtend.core.formatting.IntegerEntry
import org.eclipse.xtend.core.formatting.AbstractConfiguration
import org.eclipse.xtend.core.formatting.StringEntry
import java.util.Map

class XtendFormatterConfigurationTest {

	@Test def testEquals() {
		val cfg = new XtendFormatterConfig()
		val map = cfg.asMap
		val cfg2 = new XtendFormatterConfig(map)
		assertEquals(cfg, cfg2)
	}
	
	@Test def testAsMap() {
		val actual = new TestConfig1().asMap.entrySet.join("\n", [ '''«key» = «value»'''])
		assertEquals('''
			intval = 42
			strval = foo
			child1.nested1 = foo
			child1.child2.nested2 = foo
		'''.toString.trim, actual)
	}
	
	@Test def testLoad() {
		val cfg = new TestConfig1()
		val map = cfg.asMap
		val cfg2 = new TestConfig1(map)
		assertEquals(cfg, cfg2)
	}
}

class TestConfig1 extends AbstractConfiguration {
	@Property val intval = new IntegerEntry("intval", 42)
	@Property val strval = new StringEntry("strval", "foo")
	@Property val child1 = new TestNestedConfig1("child1")
	
	new() {
		super(null as String)
	}
	
	new(Map<String,String> values) {
		super(values)
	}
}

class TestNestedConfig1 extends AbstractConfiguration {
	@Property val strval = new StringEntry("nested1", "foo")
	@Property val child2 = new TestNestedConfig2("child2")
	
	new(String key) {
		super(key)
	}
}

class TestNestedConfig2 extends AbstractConfiguration {
	@Property val strval = new StringEntry("nested2", "foo")
	
	new(String key) {
		super(key)
	}
}
