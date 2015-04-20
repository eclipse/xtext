package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.linking.idea.lang.Bug287988TestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class Bug287988TestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return Bug287988TestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
