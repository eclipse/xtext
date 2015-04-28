package org.eclipse.xtext.testlanguages.idea;

import org.eclipse.xtext.testlanguages.idea.lang.TreeTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class TreeTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return TreeTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
