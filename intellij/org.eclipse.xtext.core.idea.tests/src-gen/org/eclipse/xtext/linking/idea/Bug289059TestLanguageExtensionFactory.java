package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.linking.idea.lang.Bug289059TestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class Bug289059TestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return Bug289059TestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
