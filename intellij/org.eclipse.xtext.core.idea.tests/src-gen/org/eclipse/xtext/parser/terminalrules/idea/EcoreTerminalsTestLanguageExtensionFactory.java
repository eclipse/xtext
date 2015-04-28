package org.eclipse.xtext.parser.terminalrules.idea;

import org.eclipse.xtext.parser.terminalrules.idea.lang.EcoreTerminalsTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class EcoreTerminalsTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return EcoreTerminalsTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
