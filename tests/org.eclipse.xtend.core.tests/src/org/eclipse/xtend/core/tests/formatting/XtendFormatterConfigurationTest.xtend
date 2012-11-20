package org.eclipse.xtend.core.tests.formatting

import org.eclipse.xtend.core.formatting.XtendFormatterConfigKeys
import org.eclipse.xtext.xbase.configuration.AbstractConfigurationKeys
import org.eclipse.xtext.xbase.configuration.BooleanKey
import org.eclipse.xtext.xbase.configuration.IntegerKey
import org.eclipse.xtext.xbase.configuration.MapBasedConfigurationValues
import org.eclipse.xtext.xbase.configuration.StringKey
import org.eclipse.xtext.xbase.configuration.TransientKey
import org.junit.Test

import static org.junit.Assert.*

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
		'''.toString.trim, actual)
	}

	@Test def testLoad() {
		val data = '''
			intval = 420
			strval = baz
			boolval = false
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
}
