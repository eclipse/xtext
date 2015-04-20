package org.eclipse.xtext.testlanguages.idea;

import org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class OptionalEmptyTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return OptionalEmptyTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
