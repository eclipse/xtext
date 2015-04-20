package org.eclipse.xtext.serializer.idea;

import org.eclipse.xtext.serializer.idea.lang.ContextFinderTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class ContextFinderTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return ContextFinderTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
