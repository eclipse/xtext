package org.eclipse.xtend.core.formatting

import com.google.common.base.Function
import org.apache.log4j.Logger
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.util.Pair

class NewLineConfig extends AbstractConfigurationKey<NewLineConfigValue> implements IConfigurationKeyWithStorage<NewLineConfigValue> {
	
	static val Logger log = Logger::getLogger(typeof(NewLineConfig))
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
			if(value != null)
				return Integer::parseInt(value)
		} catch(NumberFormatException e) {
			log.error('''Error parsing Integer: «value»''',e)
		}
		defaultValue
	}
	
	override load(Function<String,String> storage) {
		val minimum = parseInt(storage.apply(_minName), defaultValue.minNewLines)
		val maximum = parseInt(storage.apply(_maxName), defaultValue.maxNewLines)
		new NewLineConfigValue(minimum, maximum)
	}
	
	override store(NewLineConfigValue value, IAcceptor<Pair<String,String>> storage) {
		storage.accept(Tuples::create(_minName, String::valueOf(value.minNewLines)))
		storage.accept(Tuples::create(_maxName, String::valueOf(value.maxNewLines)))
	}
	
}


@Data class NewLineConfigValue {
	int minNewLines
	int maxNewLines
}
