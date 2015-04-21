package org.eclipse.xtext.parser.terminalrules.idea;

import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class Bug317840TestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return Bug317840TestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
