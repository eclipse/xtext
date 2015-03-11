package org.eclipse.xtext.xbase.formatting

import org.eclipse.xtext.preferences.PreferenceKey

class StringKey extends PreferenceKey {
	new(String id, String defaultValue) {
		super(id, defaultValue)
	}
}

class IntegerKey extends PreferenceKey {
	new(String name, Integer defaultValue) {
		super(name, defaultValue.toString)
	}
}

class BooleanKey extends PreferenceKey {
	new(String name, boolean defaultValue) {
		super(name, defaultValue.toString)
	}
}

class BlankLineKey extends IntegerKey {
	new(String name, Integer defaultValue) {
		super(name, defaultValue)
	}
}

class NewLineOrPreserveKey extends BooleanKey {
	new(String name, Boolean defaultValue) {
		super(name, defaultValue)
	}
}

class NewLineKey extends BooleanKey {
	new(String name, Boolean defaultValue) {
		super(name, defaultValue)
	}
}

class WhitespaceKey extends BooleanKey {
	new(String name, Boolean defaultValue) {
		super(name, defaultValue)
	}
}
