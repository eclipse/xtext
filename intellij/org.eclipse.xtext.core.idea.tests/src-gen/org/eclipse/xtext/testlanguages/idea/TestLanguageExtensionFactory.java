package org.eclipse.xtext.testlanguages.idea;

import org.eclipse.xtext.testlanguages.idea.lang.TestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class TestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return TestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
