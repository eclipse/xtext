package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.linking.idea.lang.IgnoreCaseImportsTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class IgnoreCaseImportsTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return IgnoreCaseImportsTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
