package org.eclipse.xtext.xbase.tests.configuration

import com.google.common.base.Function
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.util.Pair
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.xbase.configuration.AbstractConfigurationKey
import org.eclipse.xtext.xbase.configuration.AbstractConfigurationKeys
import org.eclipse.xtext.xbase.configuration.BooleanKey
import org.eclipse.xtext.xbase.configuration.IConfigurationKeyWithStorage
import org.eclipse.xtext.xbase.configuration.IntegerKey
import org.eclipse.xtext.xbase.configuration.MapBasedConfigurationValues
import org.eclipse.xtext.xbase.configuration.StringKey
import org.eclipse.xtext.xbase.configuration.TransientKey
import org.junit.Test

import static org.junit.Assert.*

class ConfigurationTest {

	@Test def testDefaultValues() {
		val actual = new MapBasedConfigurationValues(new TestConfig1()).store.entrySet.join("\n", ['''«key» = «value»'''])
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
		data.split("\\\n").forEach[val x = it.split("="); map.put(x.get(0).trim, x.get(1).trim)]
		val cfg = new MapBasedConfigurationValues(new TestConfig1())
		cfg.load(map)
		val actual = cfg.store.entrySet.join("\n", ['''«key» = «value»'''])
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

class NewLineConfig extends AbstractConfigurationKey<NewLineConfigValue> implements IConfigurationKeyWithStorage<NewLineConfigValue> {

	@Property val String minName
	@Property val String maxName

	new(String name, int minNewLines, int maxNewLines) {
		super(name, new NewLineConfigValue(minNewLines, maxNewLines))
		_minName = '''«name».minNewLines'''
		_maxName = '''«name».maxNewLines'''
	}

	override getStorageNames() {
		newArrayList(_minName, _maxName)
	}

	def protected Integer parseInt(String value, Integer defaultValue) {
		try {
			if (value != null)
				return Integer::parseInt(value)
		} catch (NumberFormatException e) {
			throw e
		}
		defaultValue
	}

	override load(Function<String, String> storage) {
		val minimum = parseInt(storage.apply(_minName), defaultValue.minNewLines)
		val maximum = parseInt(storage.apply(_maxName), defaultValue.maxNewLines)
		new NewLineConfigValue(minimum, maximum)
	}

	override store(NewLineConfigValue value, IAcceptor<Pair<String, String>> storage) {
		storage.accept(Tuples::create(_minName, String::valueOf(value.minNewLines)))
		storage.accept(Tuples::create(_maxName, String::valueOf(value.maxNewLines)))
	}

}

@Data class NewLineConfigValue {
	int minNewLines
	int maxNewLines
}
