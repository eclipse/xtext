package org.eclipse.xtext.testlanguages.backtracking.idea;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class BeeLangTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return BeeLangTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
