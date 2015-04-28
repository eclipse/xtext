package org.eclipse.xtext.parser.assignments.idea;

import org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class Bug287184TestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return Bug287184TestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
