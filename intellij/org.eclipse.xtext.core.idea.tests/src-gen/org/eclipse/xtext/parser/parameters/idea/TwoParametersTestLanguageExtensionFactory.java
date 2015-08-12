package org.eclipse.xtext.parser.parameters.idea;

import org.eclipse.xtext.parser.parameters.idea.lang.TwoParametersTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class TwoParametersTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return TwoParametersTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
