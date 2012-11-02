package org.eclipse.xtend.core.formatting

import java.util.Map
import java.util.List
import org.eclipse.xtext.xbase.lib.util.ToStringHelper

class AbstractConfiguration extends AbstractEntry {

	new(String key) {
		super(key)
	}

	new(Map<String, String> values) {
		super(null)
		load(null, values)
	}

	def List<AbstractEntry> getEntries() {
		getClass.declaredFields.map[
			if (typeof(AbstractEntry).isAssignableFrom(it.type))
				try {
					it.accessible = true
					it.get(this) as AbstractEntry
				} catch (Exception e) {
				}
		].filterNull.toList
	}

	def Map<String, String> asMap() {
		<String, String>newLinkedHashMap() => [store(null, it)]
	}

	override load(String prefix, Map<String,String> values) {
		entries.forEach[load(prefix.fullPrefix, values)]
	}

	override store(String prefix, Map<String,String> values) {
		entries.forEach[store(prefix.fullPrefix, values)]
	}
	
	override equals(Object obj) {
		obj != null && obj.^class == ^class && (obj as AbstractConfiguration).asMap == asMap
	}
	
}

abstract class AbstractEntry {
	@Property val String key

	new(String key) { this._key = key }

	def protected String fullPrefix(String prefix) {
		if(prefix == null) key else prefix + "." + key
	}

	def void load(String prefix, Map<String, String> values)

	def void store(String prefix, Map<String, String> values)
	
	override toString() {
		new ToStringHelper().toString(this)
	}
}


class StringEntry extends AbstractEntry {
	@Property String value

	new(String key) {
		super(key)
	}
	
	new(String key, String value) {
		super(key)
		this._value = value
	}

	override load(String prefix, Map<String,String> values) {
		_value = values.get(prefix.fullPrefix)
	}

	override store(String prefix, Map<String,String> values) {
		values.put(prefix.fullPrefix, _value)
	}
}

class IntegerEntry extends AbstractEntry {
	@Property int value

	new(String key) {
		super(key)
	}
	
	new(String key, Integer value) {
		super(key)
		this._value = value
	}

	override load(String prefix, Map<String,String> values) {
		try {
			_value = Integer::parseInt(values.get(prefix.fullPrefix))
		} catch (NumberFormatException e) {
		}
	}

	override store(String prefix, Map<String,String> values) {
		values.put(prefix.fullPrefix, String::valueOf(_value))
	}
}
