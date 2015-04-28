package org.eclipse.xtext.parser.terminalrules.idea;

import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class HiddenTerminalsTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return HiddenTerminalsTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
