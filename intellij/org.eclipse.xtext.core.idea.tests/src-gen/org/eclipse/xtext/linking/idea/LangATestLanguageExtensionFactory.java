package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.linking.idea.lang.LangATestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class LangATestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return LangATestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
