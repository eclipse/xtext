package org.eclipse.xtext.testlanguages.backtracking.idea;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class SimpleBeeLangTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return SimpleBeeLangTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
