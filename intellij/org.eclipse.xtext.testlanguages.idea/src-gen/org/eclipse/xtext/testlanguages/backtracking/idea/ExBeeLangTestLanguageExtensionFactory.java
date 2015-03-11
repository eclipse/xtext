package org.eclipse.xtext.testlanguages.backtracking.idea;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.ExBeeLangTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class ExBeeLangTestLanguageExtensionFactory implements ExtensionFactory {

	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return ExBeeLangTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
