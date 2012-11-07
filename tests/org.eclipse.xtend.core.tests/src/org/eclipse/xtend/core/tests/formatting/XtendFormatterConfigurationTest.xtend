package org.eclipse.xtend.core.tests.formatting

import org.eclipse.xtend.core.formatting.AbstractConfigurationKeys
import org.eclipse.xtend.core.formatting.BooleanKey
import org.eclipse.xtend.core.formatting.IntegerKey
import org.eclipse.xtend.core.formatting.MapBasedConfigurationValues
import org.eclipse.xtend.core.formatting.NewLineConfig
import org.eclipse.xtend.core.formatting.StringKey
import org.eclipse.xtend.core.formatting.TransientKey
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.xtend.core.formatting.XtendFormatterConfigKeys

class XtendFormatterConfigurationTest {

	@Test def testXtendDefaultValues() {
		val keys = new XtendFormatterConfigKeys()
		val actual = new MapBasedConfigurationValues(keys)
		assertEquals(120, actual.get(keys.maxLineWidth))
	}
	
	@Test def testDefaultValues() {
		val actual = new MapBasedConfigurationValues(new TestConfig1()).store.entrySet.join("\n", [ '''«key» = «value»'''])
		assertEquals('''
			intval = 42
			strval = foo
			boolval = true
			newLineConfig.minNewLines = 2
			newLineConfig.maxNewLines = 3
		'''.toString.trim, actual)
	}

	@Test def testLoad() {
		val data = '''
			intval = 420
			strval = baz
			boolval = false
			newLineConfig.minNewLines = 20
			newLineConfig.maxNewLines = 30
		'''.toString.trim
		val map = <String, String>newLinkedHashMap
		data.split("\\\n").forEach[ val x = it.split("="); map.put(x.get(0).trim, x.get(1).trim) ]
		val cfg = new MapBasedConfigurationValues(new TestConfig1())
		cfg.load(map)
		val actual = cfg.store.entrySet.join("\n", [ '''«key» = «value»'''])
		assertEquals(data, actual)
	}
}

class TestConfig1 extends AbstractConfigurationKeys {
	public val intval = new IntegerKey("intval", 42)
	public val strval = new StringKey("strval", "foo")
	public val boolval = new BooleanKey("boolval", true)
	public val transientval = new TransientKey("transientval", "foo")
	public val child1 = new NewLineConfig("newLineConfig", 2, 3)
}
