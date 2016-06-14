package org.eclipse.xtext.xbase.formatting

import org.eclipse.xtext.preferences.PreferenceKey

/**
 * @deprecated use {@link org.eclipse.xtext.preferences.StringKey}
 */
@Deprecated class StringKey extends PreferenceKey {
	new(String id, String defaultValue) {
		super(id, defaultValue)
	}
}

/**
 * @deprecated use {@link org.eclipse.xtext.preferences.IntegerKey}
 */
@Deprecated class IntegerKey extends PreferenceKey {
	new(String name, Integer defaultValue) {
		super(name, defaultValue.toString)
	}
}

/**
 * @deprecated use {@link org.eclipse.xtext.preferences.BooleanKey}
 */
@Deprecated class BooleanKey extends PreferenceKey {
	new(String name, boolean defaultValue) {
		super(name, defaultValue.toString)
	}
}

/**
 * @deprecated use {@link org.eclipse.xtext.xbase.formatting2.BlankLineKey}
 */
@Deprecated 
class BlankLineKey extends IntegerKey {
	new(String name, Integer defaultValue) {
		super(name, defaultValue)
	}
}

/**
 * @deprecated use {@link org.eclipse.xtext.xbase.formatting2.NewLineOrPreserveKey}
 */
@Deprecated class NewLineOrPreserveKey extends BooleanKey {
	new(String name, Boolean defaultValue) {
		super(name, defaultValue)
	}
}

/**
 * @deprecated use {@link org.eclipse.xtext.xbase.formatting2.NewLineKey}
 */
@Deprecated class NewLineKey extends BooleanKey {
	new(String name, Boolean defaultValue) {
		super(name, defaultValue)
	}
}

/**
 * @deprecated use {@link org.eclipse.xtext.xbase.formatting2.WhitespaceKey}
 */
@Deprecated class WhitespaceKey extends BooleanKey {
	new(String name, Boolean defaultValue) {
		super(name, defaultValue)
	}
}
