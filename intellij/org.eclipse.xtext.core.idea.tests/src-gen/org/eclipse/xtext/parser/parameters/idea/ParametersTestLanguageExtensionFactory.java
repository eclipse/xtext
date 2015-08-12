package org.eclipse.xtext.parser.parameters.idea;

import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class ParametersTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return ParametersTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
