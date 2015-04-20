package org.eclipse.xtext.linking.lazy.idea;

import org.eclipse.xtext.linking.lazy.idea.lang.Bug311337TestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class Bug311337TestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return Bug311337TestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
